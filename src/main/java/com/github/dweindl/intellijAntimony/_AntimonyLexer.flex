package com.github.dweindl.intellijAntimony;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.dweindl.intellijAntimony.psi.AntimonyTypes.*;

%%

%{
  public _AntimonyLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _AntimonyLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

MODEL=(model|module)
EOL=[ \t\n\x0B\f\r]*(\n|\r\n)[ \t\n\x0B\f\r]*
WHITE_SPACE=[ \t\x0B\f\r]+
LINE_COMMENT=("//"|#).*
BLOCK_COMMENT="/"\*([^*]|\*+[^*/])*(\*+"/")
ID=[a-zA-Z_][a-zA-Z_0-9]*
INT=[0-9]+
FLOAT=[0-9]+\.[0-9]*|\.[0-9]+
SCIENTIFIC=([0-9]+(\.[0-9]*)?|\.[0-9]+)[eE][-+]?[0-9]+
STRING=(\"([^\"\\]|\\.)*\")
MULTILINE_STRING=(```([^`]|`[^`]|``[^`])*```)

%%
<YYINITIAL> {
  {WHITE_SPACE}            { return WHITE_SPACE; }

  ";"                      { return SEMI; }
  ":"                      { return COLON; }
  "'"                      { return PRIME; }
  ","                      { return COMMA; }
  "end"                    { return END; }
  "var"                    { return VAR; }
  "const"                  { return CONST; }
  "species"                { return SPECIES; }
  "compartment"            { return COMPARTMENT; }
  "substanceOnly"          { return SUBSTANCE_ONLY; }
  "function"               { return FUNCTION; }
  "identity"               { return IDENTITY; }
  "part"                   { return PART; }
  "is"                     { return IS; }
  "in"                     { return IN; }
  "at"                     { return AT; }
  "notes"                  { return NOTES; }
  "has"                    { return HAS; }
  "unit"                   { return UNIT_KEYWORD; }
  "import"                 { return IMPORT; }
  "timeconv"               { return TIMECONV; }
  "extentconv"             { return EXTENTCONV; }
  "+"                      { return PLUS; }
  "-"                      { return MINUS; }
  "*"                      { return MUL; }
  "/"                      { return DIV; }
  "^"                      { return POW; }
  "("                      { return LPAREN; }
  ")"                      { return RPAREN; }
  "="                      { return EQ; }
  ":="                     { return ASSIGN_EQ; }
  "\\"                     { return BACKSLASH; }
  "."                      { return DOT; }
  "$"                      { return DOLLAR; }
  "&&"                     { return AND; }
  "||"                     { return OR; }
  "!"                      { return NOT; }
  "=="                     { return EQEQ; }
  "!="                     { return NEQ; }
  "<"                      { return LT; }
  "<="                     { return LTE; }
  ">"                      { return GT; }
  ">="                     { return GTE; }

  {MODEL}                  { return MODEL; }
  {EOL}                    { return EOL; }
  {WHITE_SPACE}            { return WHITE_SPACE; }
  {LINE_COMMENT}           { return LINE_COMMENT; }
  {BLOCK_COMMENT}          { return BLOCK_COMMENT; }
  {ID}                     { return ID; }
  {INT}                    { return INT; }
  {FLOAT}                  { return FLOAT; }
  {SCIENTIFIC}             { return SCIENTIFIC; }
  {STRING}                 { return STRING; }
  {MULTILINE_STRING}       { return MULTILINE_STRING; }

}

[^] { return BAD_CHARACTER; }
