// Generated by JFlex 1.9.1 http://jflex.de/  (tweaked for IntelliJ platform)
// source: Corn.flex

package dev.jstanger.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.lexer.FlexLexer;
import java.util.Deque;
import java.util.ArrayDeque;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static dev.jstanger.language.psi.CornTypes.*;


public class CornLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int ASSIGN_BLOCK_STATE = 2;
  public static final int OBJECT_STATE = 4;
  public static final int VALUE_STATE = 6;
  public static final int ARRAY_STATE = 8;
  public static final int STRING_STATE = 10;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5, 5
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\25\u0100\1\u0200\11\u0100\1\u0300\17\u0100\1\u0400\247\u0100"+
    "\10\u0500\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\4\2\22\0\1\1\1\0\1\3\1\0"+
    "\1\4\6\0\1\5\1\0\1\6\1\7\1\10\1\11"+
    "\11\12\3\0\1\13\3\0\6\14\24\15\1\16\1\17"+
    "\1\20\1\0\1\21\1\0\1\22\3\14\1\23\1\24"+
    "\2\15\1\25\2\15\1\26\1\15\1\27\3\15\1\30"+
    "\1\31\1\32\1\33\2\15\1\34\2\15\1\35\1\0"+
    "\1\36\7\0\1\37\32\0\1\40\u01df\0\1\40\177\0"+
    "\13\40\35\0\2\37\5\0\1\40\57\0\1\40\240\0"+
    "\1\40\377\0\u0100\41";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1536];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\6\0\1\1\1\2\2\1\1\3\1\1\1\4\1\1"+
    "\1\5\1\6\1\7\1\10\1\7\1\11\1\12\2\1"+
    "\2\13\1\14\1\15\3\1\1\16\1\17\2\1\2\20"+
    "\1\21\3\1\1\22\1\23\2\24\1\25\1\0\1\26"+
    "\1\27\1\30\1\7\1\31\15\0\1\32\1\33\2\13"+
    "\3\0\1\34\2\20\5\0\1\35\1\36\2\0\1\37"+
    "\1\40\1\0\1\41\1\0\1\42\1\33\1\34";

  private static int [] zzUnpackAction() {
    int [] result = new int[91];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\42\0\104\0\146\0\210\0\252\0\314\0\356"+
    "\0\u0110\0\u0132\0\314\0\u0154\0\314\0\u0176\0\314\0\314"+
    "\0\u0198\0\u01ba\0\u01dc\0\314\0\314\0\u01fe\0\u0220\0\u0242"+
    "\0\u0264\0\314\0\314\0\u0286\0\u02a8\0\u02ca\0\314\0\314"+
    "\0\u02ec\0\u01ba\0\u030e\0\u0330\0\314\0\u0352\0\u0374\0\u0396"+
    "\0\u03b8\0\314\0\u0154\0\u03da\0\u03fc\0\u041e\0\u0440\0\314"+
    "\0\314\0\u0462\0\u0484\0\u04a6\0\u04c8\0\u04ea\0\u050c\0\u052e"+
    "\0\u0550\0\u0572\0\u0594\0\u05b6\0\u05d8\0\u05fa\0\u061c\0\u03da"+
    "\0\314\0\u063e\0\u0660\0\u04ea\0\u0682\0\u06a4\0\u06c6\0\u06e8"+
    "\0\u070a\0\u05b6\0\u072c\0\u074e\0\u0770\0\u0792\0\u07b4\0\314"+
    "\0\314\0\u07d6\0\u07f8\0\314\0\314\0\u081a\0\314\0\u083c"+
    "\0\314\0\u081a\0\u083c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[91];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\7\2\10\5\7\1\11\15\7\1\12\6\7\1\13"+
    "\5\7\2\10\1\7\1\14\3\7\1\11\2\7\1\15"+
    "\11\7\1\16\7\7\1\17\1\20\3\7\1\21\2\10"+
    "\1\7\1\14\1\21\1\7\1\22\1\23\2\21\1\15"+
    "\2\21\1\7\1\21\1\7\14\21\1\7\1\24\2\7"+
    "\1\21\1\7\2\10\1\25\1\26\1\7\1\27\1\7"+
    "\1\11\1\30\1\31\3\7\1\32\1\7\1\33\3\7"+
    "\1\34\2\7\1\35\2\7\1\36\2\7\1\37\5\7"+
    "\2\10\1\40\1\14\1\7\1\41\1\42\1\11\1\43"+
    "\1\44\3\7\1\45\1\7\1\33\3\7\1\46\2\7"+
    "\1\47\2\7\1\50\2\7\1\13\4\7\3\51\1\52"+
    "\1\53\12\51\1\54\22\51\43\0\2\10\47\0\1\55"+
    "\54\0\1\56\32\0\2\57\3\0\14\57\34\0\1\60"+
    "\12\0\1\21\2\0\4\21\1\0\3\21\1\0\23\21"+
    "\2\0\1\21\7\0\1\61\32\0\1\21\2\0\4\21"+
    "\1\0\1\62\2\21\1\0\23\21\2\0\1\21\14\0"+
    "\2\63\3\0\14\63\16\0\2\31\36\0\1\64\1\0"+
    "\2\31\6\0\1\65\12\0\1\66\14\0\1\64\1\0"+
    "\2\31\6\0\1\65\42\0\1\67\52\0\1\70\36\0"+
    "\1\71\22\0\2\44\36\0\1\72\1\0\2\44\6\0"+
    "\1\73\12\0\1\74\14\0\1\72\1\0\2\44\6\0"+
    "\1\73\42\0\1\75\52\0\1\76\36\0\1\77\11\0"+
    "\3\51\2\0\12\51\1\100\24\51\1\0\34\51\1\0"+
    "\1\51\1\0\2\55\1\0\34\55\1\0\1\55\33\0"+
    "\1\101\20\0\2\57\1\0\2\57\3\0\14\57\5\0"+
    "\1\62\1\55\1\0\4\62\1\55\3\62\1\55\23\62"+
    "\1\0\1\55\1\21\11\0\2\63\1\0\2\63\3\0"+
    "\14\63\16\0\2\102\40\0\2\103\40\0\2\104\1\0"+
    "\1\104\5\0\3\104\43\0\1\105\41\0\1\106\46\0"+
    "\1\107\17\0\2\110\40\0\2\111\40\0\2\112\1\0"+
    "\1\112\5\0\3\112\43\0\1\113\41\0\1\114\46\0"+
    "\1\115\17\0\2\102\10\0\1\116\27\0\2\103\6\0"+
    "\1\65\51\0\1\117\36\0\1\120\36\0\1\121\27\0"+
    "\2\110\10\0\1\122\27\0\2\111\6\0\1\73\51\0"+
    "\1\123\36\0\1\124\36\0\1\125\23\0\2\126\56\0"+
    "\1\127\23\0\2\130\56\0\1\131\27\0\2\132\40\0"+
    "\2\133\27\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[2142];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\6\0\1\11\3\1\1\11\1\1\1\11\1\1\2\11"+
    "\3\1\2\11\4\1\2\11\3\1\2\11\4\1\1\11"+
    "\4\1\1\11\3\1\1\0\1\1\2\11\2\1\15\0"+
    "\1\11\3\1\3\0\3\1\5\0\2\11\2\0\2\11"+
    "\1\0\1\11\1\0\1\11\2\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[91];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  protected int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /* user code: */
  public CornLexer() {
    this((java.io.Reader)null);
  }
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public CornLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return BAD_CHARACTER;
            }
          // fall through
          case 35: break;
          case 2:
            { return WHITE_SPACE;
            }
          // fall through
          case 36: break;
          case 3:
            { pushState(OBJECT_STATE); return LEFT_BRACE;
            }
          // fall through
          case 37: break;
          case 4:
            { pushState(VALUE_STATE); return OP_EQ;
            }
          // fall through
          case 38: break;
          case 5:
            { return LEFT_BRACE;
            }
          // fall through
          case 39: break;
          case 6:
            { return RIGHT_BRACE;
            }
          // fall through
          case 40: break;
          case 7:
            { return PATH_SEG;
            }
          // fall through
          case 41: break;
          case 8:
            { return DOT;
            }
          // fall through
          case 42: break;
          case 9:
            { popState(); return RIGHT_BRACE;
            }
          // fall through
          case 43: break;
          case 10:
            { replaceState(STRING_STATE); return DOUBLE_QUOTE;
            }
          // fall through
          case 44: break;
          case 11:
            { popState(); return INTEGER;
            }
          // fall through
          case 45: break;
          case 12:
            { replaceState(ARRAY_STATE); return LEFT_BRACKET;
            }
          // fall through
          case 46: break;
          case 13:
            { popState(); return RIGHT_BRACKET;
            }
          // fall through
          case 47: break;
          case 14:
            { replaceState(OBJECT_STATE); return LEFT_BRACE;
            }
          // fall through
          case 48: break;
          case 15:
            { pushState(STRING_STATE); return DOUBLE_QUOTE;
            }
          // fall through
          case 49: break;
          case 16:
            { return INTEGER;
            }
          // fall through
          case 50: break;
          case 17:
            { pushState(ARRAY_STATE); return LEFT_BRACKET;
            }
          // fall through
          case 51: break;
          case 18:
            { return CHAR_SEQ;
            }
          // fall through
          case 52: break;
          case 19:
            { popState(); return DOUBLE_QUOTE;
            }
          // fall through
          case 53: break;
          case 20:
            { popState(); return BAD_CHARACTER;
            }
          // fall through
          case 54: break;
          case 21:
            { return COMMENT;
            }
          // fall through
          case 55: break;
          case 22:
            { return INPUT_TOKEN;
            }
          // fall through
          case 56: break;
          case 23:
            { popState(); return IN;
            }
          // fall through
          case 57: break;
          case 24:
            { return DOTDOT;
            }
          // fall through
          case 58: break;
          case 25:
            { popState(); return INPUT_TOKEN;
            }
          // fall through
          case 59: break;
          case 26:
            { pushState(ASSIGN_BLOCK_STATE); return LET;
            }
          // fall through
          case 60: break;
          case 27:
            { popState(); return FLOAT;
            }
          // fall through
          case 61: break;
          case 28:
            { return FLOAT;
            }
          // fall through
          case 62: break;
          case 29:
            { popState(); return NULL;
            }
          // fall through
          case 63: break;
          case 30:
            { popState(); return TRUE;
            }
          // fall through
          case 64: break;
          case 31:
            { return NULL;
            }
          // fall through
          case 65: break;
          case 32:
            { return TRUE;
            }
          // fall through
          case 66: break;
          case 33:
            { popState(); return FALSE;
            }
          // fall through
          case 67: break;
          case 34:
            { return FALSE;
            }
          // fall through
          case 68: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
