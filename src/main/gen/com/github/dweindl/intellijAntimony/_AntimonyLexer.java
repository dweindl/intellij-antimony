// Generated by JFlex 1.9.1 http://jflex.de/  (tweaked for IntelliJ platform)
// source: _AntimonyLexer.flex

package com.github.dweindl.intellijAntimony;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.dweindl.intellijAntimony.psi.AntimonyTypes.*;


public class _AntimonyLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

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
    "\11\0\1\1\1\2\3\3\22\0\1\1\1\4\1\5"+
    "\1\6\1\7\1\0\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\12\22\1\23\1\24"+
    "\1\25\1\26\1\27\2\0\4\30\1\31\11\30\1\32"+
    "\13\30\1\0\1\33\1\0\1\34\1\30\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\30\1\44\1\45"+
    "\2\30\1\46\1\47\1\50\1\51\1\52\1\30\1\53"+
    "\1\54\1\55\1\56\1\57\1\30\1\60\1\61\1\30"+
    "\1\0\1\62\10\0\1\63\u01a2\0\2\63\326\0\u0100\63";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
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
    "\1\0\1\1\1\2\1\3\1\4\1\1\1\5\1\6"+
    "\1\1\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\1\15\26\1\1\1\31\1\0"+
    "\1\32\1\0\1\33\1\34\2\0\1\35\1\36\1\37"+
    "\1\40\1\0\1\41\7\26\1\42\1\43\10\26\1\44"+
    "\2\0\1\45\1\0\2\26\1\46\2\26\1\47\11\26"+
    "\1\50\1\51\1\0\11\26\1\52\3\26\1\53\1\0"+
    "\1\26\1\54\4\26\1\55\1\26\1\56\3\26\1\57"+
    "\4\26\1\60\7\26\1\61\4\26\1\62\1\63\1\26"+
    "\1\64\4\26\1\65\1\26\1\66\2\26\1\67";

  private static int [] zzUnpackAction() {
    int [] result = new int[155];
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
    "\0\0\0\64\0\150\0\234\0\320\0\u0104\0\u0138\0\64"+
    "\0\u016c\0\64\0\64\0\64\0\64\0\64\0\64\0\64"+
    "\0\u01a0\0\u01d4\0\u0208\0\u023c\0\64\0\u0270\0\u02a4\0\u02d8"+
    "\0\u030c\0\64\0\64\0\u0340\0\u0374\0\u03a8\0\u03dc\0\u0410"+
    "\0\u0444\0\u0478\0\u04ac\0\u04e0\0\u0514\0\u0548\0\u057c\0\u05b0"+
    "\0\u05e4\0\u0618\0\64\0\u0104\0\64\0\u064c\0\64\0\u0680"+
    "\0\u06b4\0\u06e8\0\64\0\64\0\64\0\64\0\u071c\0\u030c"+
    "\0\u0750\0\u0784\0\u07b8\0\u07ec\0\u0820\0\u0854\0\u0888\0\u030c"+
    "\0\u030c\0\u08bc\0\u08f0\0\u0924\0\u0958\0\u098c\0\u09c0\0\u09f4"+
    "\0\u0a28\0\64\0\u0a5c\0\u0a90\0\u0a90\0\u0ac4\0\u0af8\0\u0b2c"+
    "\0\u030c\0\u0b60\0\u0b94\0\u030c\0\u0bc8\0\u0bfc\0\u0c30\0\u0c64"+
    "\0\u0c98\0\u0ccc\0\u0d00\0\u0d34\0\u0d68\0\u030c\0\64\0\u0d9c"+
    "\0\u0dd0\0\u0e04\0\u0e38\0\u0e6c\0\u0ea0\0\u0ed4\0\u0f08\0\u0f3c"+
    "\0\u0f70\0\u030c\0\u0fa4\0\u0fd8\0\u100c\0\u030c\0\u1040\0\u1074"+
    "\0\u030c\0\u10a8\0\u10dc\0\u1110\0\u1144\0\u030c\0\u1178\0\u030c"+
    "\0\u11ac\0\u11e0\0\u1214\0\64\0\u1248\0\u127c\0\u12b0\0\u12e4"+
    "\0\u030c\0\u1318\0\u134c\0\u1380\0\u13b4\0\u13e8\0\u141c\0\u1450"+
    "\0\u030c\0\u1484\0\u14b8\0\u14ec\0\u1520\0\u030c\0\u030c\0\u1554"+
    "\0\u030c\0\u1588\0\u15bc\0\u15f0\0\u1624\0\u030c\0\u1658\0\u030c"+
    "\0\u168c\0\u16c0\0\u030c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[155];
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
    "\1\2\1\3\1\4\1\3\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\3\31\1\32\1\33\1\34\1\35\1\31\1\36\1\31"+
    "\1\37\1\40\1\41\1\42\1\31\1\43\1\44\1\31"+
    "\1\45\1\31\1\46\1\47\1\50\1\51\2\31\1\52"+
    "\1\2\65\0\1\3\1\4\1\3\61\0\3\4\106\0"+
    "\1\53\35\0\5\54\1\55\25\54\1\56\30\54\2\7"+
    "\2\0\57\7\11\0\1\57\75\0\1\60\55\0\1\61"+
    "\4\0\1\7\62\0\1\60\1\0\1\23\6\0\1\62"+
    "\10\0\1\62\47\0\1\63\63\0\1\64\63\0\1\65"+
    "\63\0\1\66\57\0\1\31\5\0\3\31\3\0\24\31"+
    "\37\0\1\67\50\0\1\31\5\0\3\31\3\0\17\31"+
    "\1\70\4\31\24\0\1\31\5\0\3\31\3\0\13\31"+
    "\1\71\10\31\24\0\1\31\5\0\3\31\3\0\12\31"+
    "\1\72\7\31\1\73\1\31\24\0\1\31\5\0\3\31"+
    "\3\0\20\31\1\74\3\31\24\0\1\31\5\0\3\31"+
    "\3\0\1\75\23\31\24\0\1\31\5\0\3\31\3\0"+
    "\3\31\1\76\5\31\1\77\1\100\3\31\1\101\5\31"+
    "\24\0\1\31\5\0\3\31\3\0\13\31\1\102\10\31"+
    "\24\0\1\31\5\0\3\31\3\0\13\31\1\103\10\31"+
    "\24\0\1\31\5\0\3\31\3\0\1\104\23\31\24\0"+
    "\1\31\5\0\3\31\3\0\14\31\1\105\3\31\1\106"+
    "\3\31\24\0\1\31\5\0\3\31\3\0\7\31\1\107"+
    "\14\31\24\0\1\31\5\0\3\31\3\0\12\31\1\110"+
    "\11\31\24\0\1\31\5\0\3\31\3\0\1\111\23\31"+
    "\64\0\1\112\1\0\2\54\2\0\57\54\23\0\1\60"+
    "\6\0\1\62\10\0\1\62\21\0\14\61\1\113\47\61"+
    "\15\0\1\114\1\0\1\114\2\0\1\115\76\0\1\116"+
    "\50\0\1\31\5\0\3\31\3\0\11\31\1\117\1\120"+
    "\11\31\24\0\1\31\5\0\3\31\3\0\3\31\1\121"+
    "\20\31\24\0\1\31\5\0\3\31\3\0\17\31\1\122"+
    "\4\31\24\0\1\31\5\0\3\31\3\0\12\31\1\123"+
    "\11\31\24\0\1\31\5\0\3\31\3\0\16\31\1\124"+
    "\5\31\24\0\1\31\5\0\3\31\3\0\4\31\1\125"+
    "\17\31\24\0\1\31\5\0\3\31\3\0\14\31\1\126"+
    "\7\31\24\0\1\31\5\0\3\31\3\0\3\31\1\127"+
    "\20\31\24\0\1\31\5\0\3\31\3\0\17\31\1\130"+
    "\4\31\24\0\1\31\5\0\3\31\3\0\15\31\1\131"+
    "\6\31\24\0\1\31\5\0\3\31\3\0\4\31\1\132"+
    "\17\31\24\0\1\31\5\0\3\31\3\0\1\31\1\133"+
    "\22\31\24\0\1\31\5\0\3\31\3\0\11\31\1\134"+
    "\12\31\24\0\1\31\5\0\3\31\3\0\7\31\1\135"+
    "\14\31\24\0\1\31\5\0\3\31\3\0\15\31\1\136"+
    "\6\31\2\0\14\61\1\113\4\61\1\137\42\61\22\0"+
    "\1\115\41\0\35\116\1\140\26\116\22\0\1\31\5\0"+
    "\3\31\3\0\14\31\1\141\7\31\24\0\1\31\5\0"+
    "\3\31\3\0\16\31\1\142\5\31\24\0\1\31\5\0"+
    "\3\31\3\0\4\31\1\143\17\31\24\0\1\31\5\0"+
    "\3\31\3\0\2\31\1\144\21\31\24\0\1\31\5\0"+
    "\3\31\3\0\12\31\1\145\11\31\24\0\1\31\5\0"+
    "\3\31\3\0\13\31\1\146\10\31\24\0\1\31\5\0"+
    "\3\31\3\0\4\31\1\147\13\31\1\150\3\31\24\0"+
    "\1\31\5\0\3\31\3\0\4\31\1\151\17\31\24\0"+
    "\1\31\5\0\3\31\3\0\17\31\1\152\4\31\24\0"+
    "\1\31\5\0\3\31\3\0\2\31\1\153\21\31\24\0"+
    "\1\31\5\0\3\31\3\0\16\31\1\154\5\31\24\0"+
    "\1\31\5\0\3\31\3\0\4\31\1\155\17\31\24\0"+
    "\1\31\5\0\3\31\3\0\17\31\1\156\4\31\2\0"+
    "\35\116\1\157\26\116\22\0\1\31\5\0\3\31\3\0"+
    "\1\160\23\31\24\0\1\31\5\0\3\31\3\0\17\31"+
    "\1\161\4\31\24\0\1\31\5\0\3\31\3\0\12\31"+
    "\1\162\11\31\24\0\1\31\5\0\3\31\3\0\17\31"+
    "\1\163\4\31\24\0\1\31\5\0\3\31\3\0\17\31"+
    "\1\164\4\31\24\0\1\31\5\0\3\31\3\0\15\31"+
    "\1\165\6\31\24\0\1\31\5\0\3\31\3\0\10\31"+
    "\1\166\13\31\24\0\1\31\5\0\3\31\3\0\10\31"+
    "\1\167\13\31\24\0\1\31\5\0\3\31\3\0\16\31"+
    "\1\170\5\31\24\0\1\31\5\0\3\31\3\0\7\31"+
    "\1\171\14\31\24\0\1\31\5\0\3\31\3\0\17\31"+
    "\1\172\4\31\24\0\1\31\5\0\3\31\3\0\2\31"+
    "\1\173\21\31\2\0\35\116\1\174\26\116\22\0\1\31"+
    "\5\0\3\31\3\0\15\31\1\175\6\31\24\0\1\31"+
    "\5\0\3\31\3\0\17\31\1\176\4\31\24\0\1\31"+
    "\5\0\3\31\3\0\7\31\1\177\14\31\24\0\1\31"+
    "\5\0\3\31\3\0\7\31\1\200\14\31\24\0\1\31"+
    "\5\0\3\31\3\0\17\31\1\201\4\31\24\0\1\31"+
    "\5\0\3\31\3\0\4\31\1\166\17\31\24\0\1\31"+
    "\5\0\3\31\3\0\4\31\1\202\17\31\24\0\1\31"+
    "\5\0\3\31\3\0\1\203\23\31\24\0\1\31\5\0"+
    "\3\31\3\0\13\31\1\204\10\31\24\0\1\31\5\0"+
    "\3\31\3\0\17\31\1\205\4\31\24\0\1\31\5\0"+
    "\3\31\3\0\2\31\1\206\21\31\24\0\1\31\5\0"+
    "\3\31\3\0\13\31\1\207\10\31\24\0\1\31\5\0"+
    "\3\31\3\0\17\31\1\210\4\31\24\0\1\31\5\0"+
    "\3\31\3\0\16\31\1\211\5\31\24\0\1\31\5\0"+
    "\3\31\3\0\12\31\1\212\11\31\24\0\1\31\5\0"+
    "\3\31\3\0\12\31\1\213\11\31\24\0\1\31\5\0"+
    "\3\31\3\0\11\31\1\214\12\31\24\0\1\31\5\0"+
    "\3\31\3\0\13\31\1\215\10\31\24\0\1\31\5\0"+
    "\3\31\3\0\12\31\1\216\11\31\24\0\1\31\5\0"+
    "\3\31\3\0\23\31\1\217\24\0\1\31\5\0\3\31"+
    "\3\0\2\31\1\220\21\31\24\0\1\31\5\0\3\31"+
    "\3\0\21\31\1\221\2\31\24\0\1\31\5\0\3\31"+
    "\3\0\4\31\1\222\17\31\24\0\1\31\5\0\3\31"+
    "\3\0\12\31\1\223\11\31\24\0\1\31\5\0\3\31"+
    "\3\0\4\31\1\224\17\31\24\0\1\31\5\0\3\31"+
    "\3\0\12\31\1\225\11\31\24\0\1\31\5\0\3\31"+
    "\3\0\21\31\1\226\2\31\24\0\1\31\5\0\2\31"+
    "\1\227\3\0\24\31\24\0\1\31\5\0\3\31\3\0"+
    "\17\31\1\230\4\31\24\0\1\31\5\0\3\31\3\0"+
    "\12\31\1\231\11\31\24\0\1\31\5\0\3\31\3\0"+
    "\10\31\1\232\13\31\24\0\1\31\5\0\3\31\3\0"+
    "\23\31\1\233\2\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[5876];
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
    "\1\0\1\11\5\1\1\11\1\1\7\11\4\1\1\11"+
    "\4\1\2\11\17\1\1\11\1\0\1\11\1\0\1\11"+
    "\1\1\2\0\4\11\1\0\22\1\1\11\2\0\1\1"+
    "\1\0\20\1\1\11\1\0\16\1\1\0\14\1\1\11"+
    "\37\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[155];
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

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  protected int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
  public _AntimonyLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _AntimonyLexer(java.io.Reader in) {
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
          case 56: break;
          case 2:
            { return WHITE_SPACE;
            }
          // fall through
          case 57: break;
          case 3:
            { return EOL;
            }
          // fall through
          case 58: break;
          case 4:
            { return NOT;
            }
          // fall through
          case 59: break;
          case 5:
            { return LINE_COMMENT;
            }
          // fall through
          case 60: break;
          case 6:
            { return DOLLAR;
            }
          // fall through
          case 61: break;
          case 7:
            { return PRIME;
            }
          // fall through
          case 62: break;
          case 8:
            { return LPAREN;
            }
          // fall through
          case 63: break;
          case 9:
            { return RPAREN;
            }
          // fall through
          case 64: break;
          case 10:
            { return MUL;
            }
          // fall through
          case 65: break;
          case 11:
            { return PLUS;
            }
          // fall through
          case 66: break;
          case 12:
            { return COMMA;
            }
          // fall through
          case 67: break;
          case 13:
            { return MINUS;
            }
          // fall through
          case 68: break;
          case 14:
            { return DOT;
            }
          // fall through
          case 69: break;
          case 15:
            { return DIV;
            }
          // fall through
          case 70: break;
          case 16:
            { return INT;
            }
          // fall through
          case 71: break;
          case 17:
            { return COLON;
            }
          // fall through
          case 72: break;
          case 18:
            { return SEMI;
            }
          // fall through
          case 73: break;
          case 19:
            { return LT;
            }
          // fall through
          case 74: break;
          case 20:
            { return EQ;
            }
          // fall through
          case 75: break;
          case 21:
            { return GT;
            }
          // fall through
          case 76: break;
          case 22:
            { return ID;
            }
          // fall through
          case 77: break;
          case 23:
            { return BACKSLASH;
            }
          // fall through
          case 78: break;
          case 24:
            { return POW;
            }
          // fall through
          case 79: break;
          case 25:
            { return NEQ;
            }
          // fall through
          case 80: break;
          case 26:
            { return STRING;
            }
          // fall through
          case 81: break;
          case 27:
            { return AND;
            }
          // fall through
          case 82: break;
          case 28:
            { return FLOAT;
            }
          // fall through
          case 83: break;
          case 29:
            { return ASSIGN_EQ;
            }
          // fall through
          case 84: break;
          case 30:
            { return LTE;
            }
          // fall through
          case 85: break;
          case 31:
            { return EQEQ;
            }
          // fall through
          case 86: break;
          case 32:
            { return GTE;
            }
          // fall through
          case 87: break;
          case 33:
            { return AT;
            }
          // fall through
          case 88: break;
          case 34:
            { return IN;
            }
          // fall through
          case 89: break;
          case 35:
            { return IS;
            }
          // fall through
          case 90: break;
          case 36:
            { return OR;
            }
          // fall through
          case 91: break;
          case 37:
            { return SCIENTIFIC;
            }
          // fall through
          case 92: break;
          case 38:
            { return END;
            }
          // fall through
          case 93: break;
          case 39:
            { return HAS;
            }
          // fall through
          case 94: break;
          case 40:
            { return VAR;
            }
          // fall through
          case 95: break;
          case 41:
            { return BLOCK_COMMENT;
            }
          // fall through
          case 96: break;
          case 42:
            { return PART;
            }
          // fall through
          case 97: break;
          case 43:
            { return UNIT_KEYWORD;
            }
          // fall through
          case 98: break;
          case 44:
            { return CONST;
            }
          // fall through
          case 99: break;
          case 45:
            { return MODEL;
            }
          // fall through
          case 100: break;
          case 46:
            { return NOTES;
            }
          // fall through
          case 101: break;
          case 47:
            { return MULTILINE_STRING;
            }
          // fall through
          case 102: break;
          case 48:
            { return IMPORT;
            }
          // fall through
          case 103: break;
          case 49:
            { return SPECIES;
            }
          // fall through
          case 104: break;
          case 50:
            { return FUNCTION;
            }
          // fall through
          case 105: break;
          case 51:
            { return IDENTITY;
            }
          // fall through
          case 106: break;
          case 52:
            { return TIMECONV;
            }
          // fall through
          case 107: break;
          case 53:
            { return EXTENTCONV;
            }
          // fall through
          case 108: break;
          case 54:
            { return COMPARTMENT;
            }
          // fall through
          case 109: break;
          case 55:
            { return SUBSTANCE_ONLY;
            }
          // fall through
          case 110: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}