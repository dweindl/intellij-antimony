// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.dweindl.intellijantimony.psi.AntimonyTypes.*;
import static com.github.dweindl.intellijantimony.parser.AntimonyParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AntimonyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return antimonyFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(AND_EXPR, ARITHMETIC_EXPR, COMPARISON_EXPR, EXPR,
      LITERAL_EXPR, LOGICAL_EXPR, MUL_EXPR, NOT_EXPR,
      OR_EXPR, PAREN_EXPR, PLUS_EXPR, POWER_EXPR,
      RATE_EXPR, REF_EXPR, SPECIES_EXPR),
  };

  /* ********************************************************** */
  // AND not_expr
  public static boolean and_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expr")) return false;
    if (!nextTokenIs(b, "<expression>", AND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, AND_EXPR, "<expression>");
    r = consumeToken(b, AND);
    r = r && not_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier ("notes" | "is" | "identity" | "part") string ("," EOL? string)* (SEMI | EOL)
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ANNOTATION, null);
    r = identifier(b, l + 1);
    r = r && annotation_1(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, STRING));
    r = p && report_error_(b, annotation_3(b, l + 1)) && r;
    r = p && annotation_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // "notes" | "is" | "identity" | "part"
  private static boolean annotation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_1")) return false;
    boolean r;
    r = consumeToken(b, NOTES);
    if (!r) r = consumeToken(b, IS);
    if (!r) r = consumeToken(b, IDENTITY);
    if (!r) r = consumeToken(b, PART);
    return r;
  }

  // ("," EOL? string)*
  private static boolean annotation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!annotation_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "annotation_3", c)) break;
    }
    return true;
  }

  // "," EOL? string
  private static boolean annotation_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && annotation_3_0_1(b, l + 1);
    r = r && consumeToken(b, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // EOL?
  private static boolean annotation_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_3_0_1")) return false;
    consumeToken(b, EOL);
    return true;
  }

  // SEMI | EOL
  private static boolean annotation_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_4")) return false;
    boolean r;
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // identifier "." identifier
  public static boolean annotation_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_type")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && identifier(b, l + 1);
    exit_section_(b, m, ANNOTATION_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // root_item * <<eof>>
  static boolean antimonyFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antimonyFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = antimonyFile_0(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // root_item *
  private static boolean antimonyFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antimonyFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "antimonyFile_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (BACKSLASH EOL)* factor plus_expr *
  public static boolean arithmetic_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arithmetic_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, ARITHMETIC_EXPR, "<expression>");
    r = arithmetic_expr_0(b, l + 1);
    r = r && factor(b, l + 1);
    r = r && arithmetic_expr_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BACKSLASH EOL)*
  private static boolean arithmetic_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arithmetic_expr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arithmetic_expr_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arithmetic_expr_0", c)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean arithmetic_expr_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arithmetic_expr_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BACKSLASH, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // plus_expr *
  private static boolean arithmetic_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arithmetic_expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!plus_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arithmetic_expr_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // identifier ("in" compartment_id)? "=" expr
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, null);
    r = identifier(b, l + 1);
    r = r && assignment_1(b, l + 1);
    r = r && consumeToken(b, EQ);
    p = r; // pin = 3
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ("in" compartment_id)?
  private static boolean assignment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1")) return false;
    assignment_1_0(b, l + 1);
    return true;
  }

  // "in" compartment_id
  private static boolean assignment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    r = r && compartment_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier ("in" compartment_id)? ":=" expr
  public static boolean assignment_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_rule")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_RULE, null);
    r = identifier(b, l + 1);
    r = r && assignment_rule_1(b, l + 1);
    r = r && consumeToken(b, ASSIGN_EQ);
    p = r; // pin = 3
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ("in" compartment_id)?
  private static boolean assignment_rule_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_rule_1")) return false;
    assignment_rule_1_0(b, l + 1);
    return true;
  }

  // "in" compartment_id
  private static boolean assignment_rule_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_rule_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    r = r && compartment_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // arithmetic_expr comparison_op? arithmetic_expr
  public static boolean comparison_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, COMPARISON_EXPR, "<expression>");
    r = arithmetic_expr(b, l + 1);
    r = r && comparison_expr_1(b, l + 1);
    r = r && arithmetic_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // comparison_op?
  private static boolean comparison_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_expr_1")) return false;
    comparison_op(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // EQEQ | NEQ | LT | LTE | GT | GTE
  public static boolean comparison_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comparison_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARISON_OP, "<comparison op>");
    r = consumeToken(b, EQEQ);
    if (!r) r = consumeToken(b, NEQ);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, LTE);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, GTE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ("var" | "const")? "compartment"
  public static boolean compartment_declaration_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compartment_declaration_prefix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARTMENT_DECLARATION_PREFIX, "<compartment declaration prefix>");
    r = compartment_declaration_prefix_0(b, l + 1);
    r = r && consumeToken(b, COMPARTMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("var" | "const")?
  private static boolean compartment_declaration_prefix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compartment_declaration_prefix_0")) return false;
    compartment_declaration_prefix_0_0(b, l + 1);
    return true;
  }

  // "var" | "const"
  private static boolean compartment_declaration_prefix_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compartment_declaration_prefix_0_0")) return false;
    boolean r;
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, CONST);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean compartment_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compartment_id")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, COMPARTMENT_ID, r);
    return r;
  }

  /* ********************************************************** */
  // declaration_prefix? rule_or_assignment ("," rule_or_assignment)* (SEMI | EOL | LINE_COMMENT)
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = declaration_0(b, l + 1);
    r = r && rule_or_assignment(b, l + 1);
    r = r && declaration_2(b, l + 1);
    r = r && declaration_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // declaration_prefix?
  private static boolean declaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_0")) return false;
    declaration_prefix(b, l + 1);
    return true;
  }

  // ("," rule_or_assignment)*
  private static boolean declaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!declaration_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "declaration_2", c)) break;
    }
    return true;
  }

  // "," rule_or_assignment
  private static boolean declaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && rule_or_assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMI | EOL | LINE_COMMENT
  private static boolean declaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_3")) return false;
    boolean r;
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = consumeToken(b, LINE_COMMENT);
    return r;
  }

  /* ********************************************************** */
  // species_declaration_prefix | compartment_declaration_prefix | other_declaration_prefix
  static boolean declaration_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration_prefix")) return false;
    boolean r;
    r = species_declaration_prefix(b, l + 1);
    if (!r) r = compartment_declaration_prefix(b, l + 1);
    if (!r) r = other_declaration_prefix(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifier EQ expr
  public static boolean event_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_assignment")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && expr(b, l + 1);
    exit_section_(b, m, EVENT_ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // event_assignment ("," (BACKSLASH EOL)* event_assignment)*
  public static boolean event_assignments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_assignments")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = event_assignment(b, l + 1);
    r = r && event_assignments_1(b, l + 1);
    exit_section_(b, m, EVENT_ASSIGNMENTS, r);
    return r;
  }

  // ("," (BACKSLASH EOL)* event_assignment)*
  private static boolean event_assignments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_assignments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!event_assignments_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "event_assignments_1", c)) break;
    }
    return true;
  }

  // "," (BACKSLASH EOL)* event_assignment
  private static boolean event_assignments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_assignments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && event_assignments_1_0_1(b, l + 1);
    r = r && event_assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BACKSLASH EOL)*
  private static boolean event_assignments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_assignments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!event_assignments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "event_assignments_1_0_1", c)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean event_assignments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_assignments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BACKSLASH, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // event_trigger ":" (BACKSLASH EOL)* event_assignments (SEMI | EOL)
  public static boolean event_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_definition")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = event_trigger(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && event_definition_2(b, l + 1);
    r = r && event_assignments(b, l + 1);
    r = r && event_definition_4(b, l + 1);
    exit_section_(b, m, EVENT_DEFINITION, r);
    return r;
  }

  // (BACKSLASH EOL)*
  private static boolean event_definition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_definition_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!event_definition_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "event_definition_2", c)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean event_definition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_definition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BACKSLASH, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // SEMI | EOL
  private static boolean event_definition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_definition_4")) return false;
    boolean r;
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // "at" expr
  public static boolean event_trigger(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "event_trigger")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AT);
    r = r && expr(b, l + 1);
    exit_section_(b, m, EVENT_TRIGGER, r);
    return r;
  }

  /* ********************************************************** */
  // logical_expr | arithmetic_expr
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPR, "<expression>");
    r = logical_expr(b, l + 1);
    if (!r) r = arithmetic_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primary mul_expr * (BACKSLASH EOL)*
  static boolean factor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary(b, l + 1);
    r = r && factor_1(b, l + 1);
    r = r && factor_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // mul_expr *
  private static boolean factor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mul_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "factor_1", c)) break;
    }
    return true;
  }

  // (BACKSLASH EOL)*
  private static boolean factor_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!factor_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "factor_2", c)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean factor_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BACKSLASH, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr (',' expr)*
  public static boolean function_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_arguments")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_ARGUMENTS, "<function arguments>");
    r = expr(b, l + 1);
    r = r && function_arguments_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' expr)*
  private static boolean function_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_arguments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_arguments_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_arguments_1", c)) break;
    }
    return true;
  }

  // ',' expr
  private static boolean function_arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // function_id '(' function_arguments? ')'
  public static boolean function_call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, null);
    r = function_id(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    p = r; // pin = 2
    r = r && report_error_(b, function_call_2(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // function_arguments?
  private static boolean function_call_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_2")) return false;
    function_arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // "function" function_id "(" function_signature_arguments? ")" (SEMI | EOL) expr (SEMI | EOL) "end"
  public static boolean function_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEFINITION, null);
    r = consumeToken(b, FUNCTION);
    p = r; // pin = 1
    r = r && report_error_(b, function_id(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LPAREN)) && r;
    r = p && report_error_(b, function_definition_3(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RPAREN)) && r;
    r = p && report_error_(b, function_definition_5(b, l + 1)) && r;
    r = p && report_error_(b, expr(b, l + 1)) && r;
    r = p && report_error_(b, function_definition_7(b, l + 1)) && r;
    r = p && consumeToken(b, END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // function_signature_arguments?
  private static boolean function_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_3")) return false;
    function_signature_arguments(b, l + 1);
    return true;
  }

  // SEMI | EOL
  private static boolean function_definition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_5")) return false;
    boolean r;
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  // SEMI | EOL
  private static boolean function_definition_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_definition_7")) return false;
    boolean r;
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean function_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_id")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, FUNCTION_ID, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean function_signature_argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature_argument")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, FUNCTION_SIGNATURE_ARGUMENT, r);
    return r;
  }

  /* ********************************************************** */
  // function_signature_argument ("," function_signature_argument)*
  public static boolean function_signature_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature_arguments")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_signature_argument(b, l + 1);
    r = r && function_signature_arguments_1(b, l + 1);
    exit_section_(b, m, FUNCTION_SIGNATURE_ARGUMENTS, r);
    return r;
  }

  // ("," function_signature_argument)*
  private static boolean function_signature_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature_arguments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_signature_arguments_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_signature_arguments_1", c)) break;
    }
    return true;
  }

  // "," function_signature_argument
  private static boolean function_signature_arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_signature_arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && function_signature_argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // identifier ("in" compartment_id)?
  public static boolean just_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "just_declaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    r = r && just_declaration_1(b, l + 1);
    exit_section_(b, m, JUST_DECLARATION, r);
    return r;
  }

  // ("in" compartment_id)?
  private static boolean just_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "just_declaration_1")) return false;
    just_declaration_1_0(b, l + 1);
    return true;
  }

  // "in" compartment_id
  private static boolean just_declaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "just_declaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    r = r && compartment_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // species_expr (PLUS species_expr)*
  static boolean list_of_reactants(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_of_reactants")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = species_expr(b, l + 1);
    r = r && list_of_reactants_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PLUS species_expr)*
  private static boolean list_of_reactants_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_of_reactants_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_of_reactants_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_of_reactants_1", c)) break;
    }
    return true;
  }

  // PLUS species_expr
  private static boolean list_of_reactants_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_of_reactants_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    r = r && species_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // number_literal unit ?
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<expression>");
    r = number_literal(b, l + 1);
    r = r && literal_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unit ?
  private static boolean literal_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr_1")) return false;
    unit(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // logical_term or_expr *
  public static boolean logical_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, LOGICAL_EXPR, "<expression>");
    r = logical_term(b, l + 1);
    r = r && logical_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // or_expr *
  private static boolean logical_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!or_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_expr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // not_expr and_expr *
  public static boolean logical_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_TERM, "<logical term>");
    r = not_expr(b, l + 1);
    r = r && logical_term_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // and_expr *
  private static boolean logical_term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logical_term_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!and_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logical_term_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // model_id annotation_type string (SEMI | EOL)
  public static boolean model_annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_annotation")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = model_id(b, l + 1);
    r = r && annotation_type(b, l + 1);
    r = r && consumeToken(b, STRING);
    r = r && model_annotation_3(b, l + 1);
    exit_section_(b, m, MODEL_ANNOTATION, r);
    return r;
  }

  // SEMI | EOL
  private static boolean model_annotation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_annotation_3")) return false;
    boolean r;
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean model_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "model_id")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, MODEL_ID, r);
    return r;
  }

  /* ********************************************************** */
  // (modifier_id ":")? species_id ("-|" | "-o" | "-(") reaction_id (SEMI | EOL)
  public static boolean modifier_annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_annotation")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifier_annotation_0(b, l + 1);
    r = r && species_id(b, l + 1);
    r = r && modifier_annotation_2(b, l + 1);
    r = r && reaction_id(b, l + 1);
    r = r && modifier_annotation_4(b, l + 1);
    exit_section_(b, m, MODIFIER_ANNOTATION, r);
    return r;
  }

  // (modifier_id ":")?
  private static boolean modifier_annotation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_annotation_0")) return false;
    modifier_annotation_0_0(b, l + 1);
    return true;
  }

  // modifier_id ":"
  private static boolean modifier_annotation_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_annotation_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifier_id(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // "-|" | "-o" | "-("
  private static boolean modifier_annotation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_annotation_2")) return false;
    boolean r;
    r = consumeToken(b, "-|");
    if (!r) r = consumeToken(b, "-o");
    if (!r) r = consumeToken(b, "-(");
    return r;
  }

  // SEMI | EOL
  private static boolean modifier_annotation_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_annotation_4")) return false;
    boolean r;
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean modifier_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_id")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, MODIFIER_ID, r);
    return r;
  }

  /* ********************************************************** */
  // MODEL model_id "(" ")" module_body? END
  public static boolean module(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module")) return false;
    if (!nextTokenIs(b, MODEL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE, null);
    r = consumeToken(b, MODEL);
    p = r; // pin = 1
    r = r && report_error_(b, model_id(b, l + 1));
    r = p && report_error_(b, consumeTokens(b, -1, LPAREN, RPAREN)) && r;
    r = p && report_error_(b, module_4(b, l + 1)) && r;
    r = p && consumeToken(b, END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // module_body?
  private static boolean module_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_4")) return false;
    module_body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // module_body_item +
  public static boolean module_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODULE_BODY, "<module body>");
    r = module_body_item(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!module_body_item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_body", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EOL
  //     | annotation
  //     | reaction
  //     | unit_annotation
  //     | declaration
  //     | unit_definition
  //     | modifier_annotation
  //     | event_definition
  //     | function_definition
  static boolean module_body_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_body_item")) return false;
    boolean r;
    r = consumeToken(b, EOL);
    if (!r) r = annotation(b, l + 1);
    if (!r) r = reaction(b, l + 1);
    if (!r) r = unit_annotation(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    if (!r) r = unit_definition(b, l + 1);
    if (!r) r = modifier_annotation(b, l + 1);
    if (!r) r = event_definition(b, l + 1);
    if (!r) r = function_definition(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // mul_op primary
  public static boolean mul_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_expr")) return false;
    if (!nextTokenIs(b, "<expression>", DIV, MUL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, MUL_EXPR, "<expression>");
    r = mul_op(b, l + 1);
    r = r && primary(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('*'|'/') (BACKSLASH EOL)*
  static boolean mul_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_op")) return false;
    if (!nextTokenIs(b, "", DIV, MUL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mul_op_0(b, l + 1);
    r = r && mul_op_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '*'|'/'
  private static boolean mul_op_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_op_0")) return false;
    boolean r;
    r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    return r;
  }

  // (BACKSLASH EOL)*
  private static boolean mul_op_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_op_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mul_op_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mul_op_1", c)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean mul_op_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_op_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BACKSLASH, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NOT? comparison_expr
  public static boolean not_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, NOT_EXPR, "<expression>");
    r = not_expr_0(b, l + 1);
    r = r && comparison_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NOT?
  private static boolean not_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_expr_0")) return false;
    consumeToken(b, NOT);
    return true;
  }

  /* ********************************************************** */
  // ('+'|'-') ? (INT | FLOAT | SCIENTIFIC)
  public static boolean number_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
    r = number_literal_0(b, l + 1);
    r = r && number_literal_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('+'|'-') ?
  private static boolean number_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal_0")) return false;
    number_literal_0_0(b, l + 1);
    return true;
  }

  // '+'|'-'
  private static boolean number_literal_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  // INT | FLOAT | SCIENTIFIC
  private static boolean number_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal_1")) return false;
    boolean r;
    r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, SCIENTIFIC);
    return r;
  }

  /* ********************************************************** */
  // OR logical_term
  public static boolean or_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or_expr")) return false;
    if (!nextTokenIs(b, "<expression>", OR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, OR_EXPR, "<expression>");
    r = consumeToken(b, OR);
    r = r && logical_term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ("var" | "const")?
  public static boolean other_declaration_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "other_declaration_prefix")) return false;
    Marker m = enter_section_(b, l, _NONE_, OTHER_DECLARATION_PREFIX, "<other declaration prefix>");
    other_declaration_prefix_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // "var" | "const"
  private static boolean other_declaration_prefix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "other_declaration_prefix_0")) return false;
    boolean r;
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, CONST);
    return r;
  }

  /* ********************************************************** */
  // ('-(' | '(') expr ')'
  public static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, PAREN_EXPR, "<expression>");
    r = paren_expr_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // '-(' | '('
  private static boolean paren_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr_0")) return false;
    boolean r;
    r = consumeToken(b, "-(");
    if (!r) r = consumeToken(b, LPAREN);
    return r;
  }

  /* ********************************************************** */
  // plus_op factor
  public static boolean plus_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_expr")) return false;
    if (!nextTokenIs(b, "<expression>", MINUS, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, PLUS_EXPR, "<expression>");
    r = plus_op(b, l + 1);
    r = r && factor(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('+'|'-') (BACKSLASH EOL)*
  static boolean plus_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_op")) return false;
    if (!nextTokenIs(b, "", MINUS, PLUS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = plus_op_0(b, l + 1);
    r = r && plus_op_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+'|'-'
  private static boolean plus_op_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_op_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  // (BACKSLASH EOL)*
  private static boolean plus_op_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_op_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!plus_op_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "plus_op_1", c)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean plus_op_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_op_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BACKSLASH, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '^' primary
  public static boolean power_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "power_expr")) return false;
    if (!nextTokenIs(b, "<expression>", POW)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, POWER_EXPR, "<expression>");
    r = consumeToken(b, POW);
    r = r && primary(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primary_inner (BACKSLASH EOL)*  power_expr?
  static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary_inner(b, l + 1);
    r = r && primary_1(b, l + 1);
    r = r && primary_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BACKSLASH EOL)*
  private static boolean primary_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!primary_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primary_1", c)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean primary_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BACKSLASH, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // power_expr?
  private static boolean primary_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_2")) return false;
    power_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ('+'|'-') ? (literal_expr | function_call | ref_expr | paren_expr)
  static boolean primary_inner(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_inner")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary_inner_0(b, l + 1);
    r = r && primary_inner_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('+'|'-') ?
  private static boolean primary_inner_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_inner_0")) return false;
    primary_inner_0_0(b, l + 1);
    return true;
  }

  // '+'|'-'
  private static boolean primary_inner_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_inner_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  // literal_expr | function_call | ref_expr | paren_expr
  private static boolean primary_inner_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_inner_1")) return false;
    boolean r;
    r = literal_expr(b, l + 1);
    if (!r) r = function_call(b, l + 1);
    if (!r) r = ref_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // list_of_reactants
  public static boolean products(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "products")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRODUCTS, "<products>");
    r = list_of_reactants(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expr
  public static boolean rate_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rate_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, RATE_EXPR, "<expression>");
    r = expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier "'" EQ expr
  public static boolean rate_rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rate_rule")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RATE_RULE, null);
    r = identifier(b, l + 1);
    r = r && consumeTokens(b, 1, PRIME, EQ);
    p = r; // pin = 2
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // list_of_reactants
  public static boolean reactants(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reactants")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REACTANTS, "<reactants>");
    r = list_of_reactants(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (reaction_id ":")? reactants? ("->"|"=>") products? SEMI rate_expr (SEMI | EOL | <<eof>>)
  public static boolean reaction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reaction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REACTION, "<reaction>");
    r = reaction_0(b, l + 1);
    r = r && reaction_1(b, l + 1);
    r = r && reaction_2(b, l + 1);
    r = r && reaction_3(b, l + 1);
    r = r && consumeToken(b, SEMI);
    r = r && rate_expr(b, l + 1);
    r = r && reaction_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (reaction_id ":")?
  private static boolean reaction_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reaction_0")) return false;
    reaction_0_0(b, l + 1);
    return true;
  }

  // reaction_id ":"
  private static boolean reaction_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reaction_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = reaction_id(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // reactants?
  private static boolean reaction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reaction_1")) return false;
    reactants(b, l + 1);
    return true;
  }

  // "->"|"=>"
  private static boolean reaction_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reaction_2")) return false;
    boolean r;
    r = consumeToken(b, "->");
    if (!r) r = consumeToken(b, "=>");
    return r;
  }

  // products?
  private static boolean reaction_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reaction_3")) return false;
    products(b, l + 1);
    return true;
  }

  // SEMI | EOL | <<eof>>
  private static boolean reaction_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reaction_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean reaction_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reaction_id")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, REACTION_ID, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean ref_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ref_expr")) return false;
    if (!nextTokenIs(b, "<expression>", ID)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REF_EXPR, "<expression>");
    r = identifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EOL | module | module_body | model_annotation
  static boolean root_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_item")) return false;
    boolean r;
    r = consumeToken(b, EOL);
    if (!r) r = module(b, l + 1);
    if (!r) r = module_body(b, l + 1);
    if (!r) r = model_annotation(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // rate_rule | assignment | assignment_rule | just_declaration
  public static boolean rule_or_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_or_assignment")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rate_rule(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    if (!r) r = assignment_rule(b, l + 1);
    if (!r) r = just_declaration(b, l + 1);
    exit_section_(b, m, RULE_OR_ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ("substanceOnly" "species") | (("var" | "const")? "species")
  public static boolean species_declaration_prefix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "species_declaration_prefix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIES_DECLARATION_PREFIX, "<species declaration prefix>");
    r = species_declaration_prefix_0(b, l + 1);
    if (!r) r = species_declaration_prefix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "substanceOnly" "species"
  private static boolean species_declaration_prefix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "species_declaration_prefix_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SUBSTANCE_ONLY, SPECIES);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("var" | "const")? "species"
  private static boolean species_declaration_prefix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "species_declaration_prefix_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = species_declaration_prefix_1_0(b, l + 1);
    r = r && consumeToken(b, SPECIES);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("var" | "const")?
  private static boolean species_declaration_prefix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "species_declaration_prefix_1_0")) return false;
    species_declaration_prefix_1_0_0(b, l + 1);
    return true;
  }

  // "var" | "const"
  private static boolean species_declaration_prefix_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "species_declaration_prefix_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, CONST);
    return r;
  }

  /* ********************************************************** */
  // stoichiometry? "$"? species_id
  public static boolean species_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "species_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIES_EXPR, "<expression>");
    r = species_expr_0(b, l + 1);
    r = r && species_expr_1(b, l + 1);
    r = r && species_id(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // stoichiometry?
  private static boolean species_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "species_expr_0")) return false;
    stoichiometry(b, l + 1);
    return true;
  }

  // "$"?
  private static boolean species_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "species_expr_1")) return false;
    consumeToken(b, DOLLAR);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean species_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "species_id")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, SPECIES_ID, r);
    return r;
  }

  /* ********************************************************** */
  // number_literal
  public static boolean stoichiometry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stoichiometry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STOICHIOMETRY, "<stoichiometry>");
    r = number_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean unit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, UNIT, r);
    return r;
  }

  /* ********************************************************** */
  // identifier "has" unit (SEMI | EOL)
  public static boolean unit_annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_annotation")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNIT_ANNOTATION, null);
    r = identifier(b, l + 1);
    r = r && consumeToken(b, HAS);
    p = r; // pin = 2
    r = r && report_error_(b, unit(b, l + 1));
    r = p && unit_annotation_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SEMI | EOL
  private static boolean unit_annotation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_annotation_3")) return false;
    boolean r;
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // "unit" identifier EQ expr (SEMI | EOL)
  public static boolean unit_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_definition")) return false;
    if (!nextTokenIs(b, UNIT_KEYWORD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNIT_DEFINITION, null);
    r = consumeToken(b, UNIT_KEYWORD);
    p = r; // pin = 1
    r = r && report_error_(b, identifier(b, l + 1));
    r = p && report_error_(b, consumeToken(b, EQ)) && r;
    r = p && report_error_(b, expr(b, l + 1)) && r;
    r = p && unit_definition_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // SEMI | EOL
  private static boolean unit_definition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unit_definition_4")) return false;
    boolean r;
    r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

}
