package dev.jstanger.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.lexer.FlexLexer;
import java.util.Deque;
import java.util.ArrayDeque;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static dev.jstanger.language.psi.CornTypes.*;

%%

%{
  public CornLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class CornLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

SPACE=[ \t\n\x0B\f\r]+
COMMENT="//".*
PATH_SEG=[^.\-\"${}\[\]=\s][^.=\s]*
INPUT_TOKEN=\$[a-zA-Z_][a-zA-Z0-9_]*
FLOAT=-?[0-9]+\.[0-9]+(e[+\-][0-9]+)?
HEX_INTEGER=0x[0-9a-fA-F]+
INTEGER=-?[0-9]+(_?[0-9]+)*
CHAR=[^\"\\]|\\.

%{
    Deque<Integer> stateStack = new ArrayDeque<>();

    private void pushState(int state) {
        stateStack.push(state);
        yybegin(state);
    }

    private void popState() {
        if(!stateStack.isEmpty()) stateStack.pop();

        var newState = stateStack.peekFirst();
        if(newState == null) newState = YYINITIAL;

        yybegin(newState);
    }

    private void replaceState(int newState) {
        popState();
        pushState(newState);
    }
%}

%state ASSIGN_BLOCK_STATE
%state OBJECT_STATE
%state VALUE_STATE
%state ARRAY_STATE
%state STRING_STATE

%%

<YYINITIAL> {
    "let"              { pushState(ASSIGN_BLOCK_STATE); return LET; }
    "{"                { pushState(OBJECT_STATE); return LEFT_BRACE; }

    {COMMENT}          { return COMMENT; }
    {SPACE}            { return WHITE_SPACE; }
}

<ASSIGN_BLOCK_STATE> {
    {COMMENT}          { return COMMENT; }
    {SPACE}            { return WHITE_SPACE; }

    "in"               { popState(); return IN; }
    "{"                { return LEFT_BRACE; }
    "}"                { return RIGHT_BRACE; }

    {INPUT_TOKEN}      { return INPUT_TOKEN; }
    "="                { pushState(VALUE_STATE); return OP_EQ; }
}

<OBJECT_STATE> {
    "}"                { popState(); return RIGHT_BRACE; }

    {PATH_SEG}         { return PATH_SEG; }
    "="                { pushState(VALUE_STATE); return OP_EQ; }
    ".."               { return DOTDOT; }
    "."                { return DOT; }
    {INPUT_TOKEN}      { return INPUT_TOKEN; }

    {COMMENT}          { return COMMENT; }
    {SPACE}            { return WHITE_SPACE; }
}

<VALUE_STATE> {
    "{"                { replaceState(OBJECT_STATE); return LEFT_BRACE; }
    "["                { replaceState(ARRAY_STATE); return LEFT_BRACKET; }

    "true"             { popState(); return TRUE; }
    "false"            { popState(); return FALSE; }
    "null"             { popState(); return NULL; }

    "\""               { replaceState(STRING_STATE); return DOUBLE_QUOTE; }

    {INPUT_TOKEN}      { popState(); return INPUT_TOKEN; }
    {FLOAT}            { popState(); return FLOAT; }
    {HEX_INTEGER}      { popState(); return INTEGER; }
    {INTEGER}          { popState(); return INTEGER; }


    {COMMENT}          { return COMMENT; }
    {SPACE}            { return WHITE_SPACE; }

    "]"                { popState(); return RIGHT_BRACKET; }

    // [^]                { popState(); }
}

<ARRAY_STATE> {
    "]"                { popState(); return RIGHT_BRACKET; }

    "{"                { pushState(OBJECT_STATE); return LEFT_BRACE; }
    "["                { pushState(ARRAY_STATE); return LEFT_BRACKET; }

    ".."               { return DOTDOT; }

    "true"             { return TRUE; }
    "false"            { return FALSE; }
    "null"             { return NULL; }

    "\""               { pushState(STRING_STATE); return DOUBLE_QUOTE; }

    {INPUT_TOKEN}      { return INPUT_TOKEN; }
    {FLOAT}            { return FLOAT; }
    {HEX_INTEGER}      { return INTEGER; }
    {INTEGER}          { return INTEGER; }


    {COMMENT}          { return COMMENT; }
    {SPACE}            { return WHITE_SPACE; }
}

<STRING_STATE> {
    "\""               { popState(); return DOUBLE_QUOTE; }

    {INPUT_TOKEN}      { return INPUT_TOKEN; }
    {CHAR}             { return CHAR; }

    [^]                { popState(); return BAD_CHARACTER; }
}

[^] { return BAD_CHARACTER; }
