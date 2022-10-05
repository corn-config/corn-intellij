package dev.jstanger.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static dev.jstanger.language.psi.CornTypes.*;

%%

%{
  public _CornLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class CornLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
COMMENT="//".*
PATH_SEG=[^=\s.\-\"$0-9][^=\s.]*
STRING=\"([^\"\\]|\\.)*\"
INPUT_TOKEN=\$[A-z_][A-z0-9_]*
FLOAT=-?[0-9]+(\.[0-9]*)?
INTEGER=-?[0-9]+

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "let"              { return LET; }
  "in"               { return IN; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  "null"             { return NULL; }
  "="                { return OP_EQ; }
  "{"                { return LEFT_BRACE; }
  "}"                { return RIGHT_BRACE; }
  "["                { return LEFT_BRACKET; }
  "]"                { return RIGHT_BRACKET; }
  "\""               { return DOUBLE_QUOTE; }
  "_"                { return UNDERSCORE; }
  "$"                { return DOLLAR; }
  "."                { return DOT; }

  {SPACE}            { return SPACE; }
  {COMMENT}          { return COMMENT; }
  {PATH_SEG}         { return PATH_SEG; }
  {STRING}           { return STRING; }
  {INPUT_TOKEN}      { return INPUT_TOKEN; }
  {FLOAT}            { return FLOAT; }
  {INTEGER}          { return INTEGER; }

}

[^] { return BAD_CHARACTER; }
