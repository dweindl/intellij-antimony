// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.dweindl.intellijAntimony.psi.AntimonyTypes.*;
import static com.github.dweindl.intellijAntimony.parser.AntimonyParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AntimonyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    parseLight(root_, builder_);
    return builder_.getTreeBuilt();
  }

  public void parseLight(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, EXTENDS_SETS_);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType root_, PsiBuilder builder_) {
    return parse_root_(root_, builder_, 0);
  }

  static boolean parse_root_(IElementType root_, PsiBuilder builder_, int level_) {
    return antimonyFile(builder_, level_ + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(AND_EXPR, ARITHMETIC_EXPR, COMPARISON_EXPR, EXPR,
      LITERAL_EXPR, LOGICAL_EXPR, MUL_EXPR, NOT_EXPR,
      OR_EXPR, PAREN_EXPR, PLUS_EXPR, POWER_EXPR,
      RATE_EXPR, REF_EXPR, SPECIES_EXPR),
  };

  /* ********************************************************** */
  // AND not_expr
  public static boolean and_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "and_expr")) return false;
    if (!nextTokenIs(builder_, "<expression>", AND)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _LEFT_, AND_EXPR, "<expression>");
    result_ = consumeToken(builder_, AND);
    result_ = result_ && not_expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // identifier annotation_keywords (string | MULTILINE_STRING) ("," EOL? string)* (SEMI | EOL)
  public static boolean annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ANNOTATION, null);
    result_ = identifier(builder_, level_ + 1);
    result_ = result_ && annotation_keywords(builder_, level_ + 1);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, annotation_2(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, annotation_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && annotation_4(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // string | MULTILINE_STRING
  private static boolean annotation_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_2")) return false;
    boolean result_;
    result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, MULTILINE_STRING);
    return result_;
  }

  // ("," EOL? string)*
  private static boolean annotation_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!annotation_3_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "annotation_3", pos_)) break;
    }
    return true;
  }

  // "," EOL? string
  private static boolean annotation_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && annotation_3_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, STRING);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // EOL?
  private static boolean annotation_3_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_3_0_1")) return false;
    consumeToken(builder_, EOL);
    return true;
  }

  // SEMI | EOL
  private static boolean annotation_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_4")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // "notes"
  //     | "is"
  //     | "identity"
  //     | "part"
  //     | "hasPart"
  //     | "biological_entity_is"
  //     | "isPartOf"
  //     | "parthood"
  //     | "isVersionOf"
  //     | "hypernym"
  //     | "hasVersion"
  //     | "version"
  //     | "isHomologTo"
  //     | "homolog"
  //     | "isDescribedBy"
  //     | "description"
  //     | "isEncodedBy"
  //     | "encoder"
  //     | "encodes"
  //     | "encodement"
  //     | "occursIn"
  //     | "container"
  //     | "hasProperty"
  //     | "property"
  //     | "isPropertyOf"
  //     | "propertyBearer"
  //     | "hasTaxon"
  //     | "taxon"
  //     | "created"  // TODO: date
  //     | "modified" // TODO: date
  //     | "creator.name"
  //     | "creator.givenName"
  //     | "creator.familyName"
  //     | "creator.organization"
  //     | "creator.email"
  public static boolean annotation_keywords(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_keywords")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ANNOTATION_KEYWORDS, "<annotation keywords>");
    result_ = consumeToken(builder_, NOTES);
    if (!result_) result_ = consumeToken(builder_, IS);
    if (!result_) result_ = consumeToken(builder_, IDENTITY);
    if (!result_) result_ = consumeToken(builder_, PART);
    if (!result_) result_ = consumeToken(builder_, "hasPart");
    if (!result_) result_ = consumeToken(builder_, "biological_entity_is");
    if (!result_) result_ = consumeToken(builder_, "isPartOf");
    if (!result_) result_ = consumeToken(builder_, "parthood");
    if (!result_) result_ = consumeToken(builder_, "isVersionOf");
    if (!result_) result_ = consumeToken(builder_, "hypernym");
    if (!result_) result_ = consumeToken(builder_, "hasVersion");
    if (!result_) result_ = consumeToken(builder_, "version");
    if (!result_) result_ = consumeToken(builder_, "isHomologTo");
    if (!result_) result_ = consumeToken(builder_, "homolog");
    if (!result_) result_ = consumeToken(builder_, "isDescribedBy");
    if (!result_) result_ = consumeToken(builder_, "description");
    if (!result_) result_ = consumeToken(builder_, "isEncodedBy");
    if (!result_) result_ = consumeToken(builder_, "encoder");
    if (!result_) result_ = consumeToken(builder_, "encodes");
    if (!result_) result_ = consumeToken(builder_, "encodement");
    if (!result_) result_ = consumeToken(builder_, "occursIn");
    if (!result_) result_ = consumeToken(builder_, "container");
    if (!result_) result_ = consumeToken(builder_, "hasProperty");
    if (!result_) result_ = consumeToken(builder_, "property");
    if (!result_) result_ = consumeToken(builder_, "isPropertyOf");
    if (!result_) result_ = consumeToken(builder_, "propertyBearer");
    if (!result_) result_ = consumeToken(builder_, "hasTaxon");
    if (!result_) result_ = consumeToken(builder_, "taxon");
    if (!result_) result_ = consumeToken(builder_, "created");
    if (!result_) result_ = consumeToken(builder_, "modified");
    if (!result_) result_ = consumeToken(builder_, "creator.name");
    if (!result_) result_ = consumeToken(builder_, "creator.givenName");
    if (!result_) result_ = consumeToken(builder_, "creator.familyName");
    if (!result_) result_ = consumeToken(builder_, "creator.organization");
    if (!result_) result_ = consumeToken(builder_, "creator.email");
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // identifier "." identifier
  public static boolean annotation_type(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "annotation_type")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, DOT);
    result_ = result_ && identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, ANNOTATION_TYPE, result_);
    return result_;
  }

  /* ********************************************************** */
  // root_item * <<eof>>
  static boolean antimonyFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "antimonyFile")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = antimonyFile_0(builder_, level_ + 1);
    result_ = result_ && eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // root_item *
  private static boolean antimonyFile_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "antimonyFile_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!root_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "antimonyFile_0", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (BACKSLASH EOL)* factor plus_expr *
  public static boolean arithmetic_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arithmetic_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, ARITHMETIC_EXPR, "<expression>");
    result_ = arithmetic_expr_0(builder_, level_ + 1);
    result_ = result_ && factor(builder_, level_ + 1);
    result_ = result_ && arithmetic_expr_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (BACKSLASH EOL)*
  private static boolean arithmetic_expr_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arithmetic_expr_0")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!arithmetic_expr_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "arithmetic_expr_0", pos_)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean arithmetic_expr_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arithmetic_expr_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, BACKSLASH, EOL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // plus_expr *
  private static boolean arithmetic_expr_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arithmetic_expr_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!plus_expr(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "arithmetic_expr_2", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "$"? identifier ("in" compartment_id)? "=" expr
  public static boolean assignment(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignment")) return false;
    if (!nextTokenIs(builder_, "<assignment>", DOLLAR, ID)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ASSIGNMENT, "<assignment>");
    result_ = assignment_0(builder_, level_ + 1);
    result_ = result_ && identifier(builder_, level_ + 1);
    result_ = result_ && assignment_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EQ);
    pinned_ = result_; // pin = 4
    result_ = result_ && expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // "$"?
  private static boolean assignment_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignment_0")) return false;
    consumeToken(builder_, DOLLAR);
    return true;
  }

  // ("in" compartment_id)?
  private static boolean assignment_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignment_2")) return false;
    assignment_2_0(builder_, level_ + 1);
    return true;
  }

  // "in" compartment_id
  private static boolean assignment_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignment_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IN);
    result_ = result_ && compartment_id(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // "$"? identifier ("in" compartment_id)? ":=" expr
  public static boolean assignment_rule(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignment_rule")) return false;
    if (!nextTokenIs(builder_, "<assignment rule>", DOLLAR, ID)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, ASSIGNMENT_RULE, "<assignment rule>");
    result_ = assignment_rule_0(builder_, level_ + 1);
    result_ = result_ && identifier(builder_, level_ + 1);
    result_ = result_ && assignment_rule_2(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ASSIGN_EQ);
    pinned_ = result_; // pin = 4
    result_ = result_ && expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // "$"?
  private static boolean assignment_rule_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignment_rule_0")) return false;
    consumeToken(builder_, DOLLAR);
    return true;
  }

  // ("in" compartment_id)?
  private static boolean assignment_rule_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignment_rule_2")) return false;
    assignment_rule_2_0(builder_, level_ + 1);
    return true;
  }

  // "in" compartment_id
  private static boolean assignment_rule_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "assignment_rule_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IN);
    result_ = result_ && compartment_id(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // arithmetic_expr comparison_op? arithmetic_expr
  public static boolean comparison_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "comparison_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, COMPARISON_EXPR, "<expression>");
    result_ = arithmetic_expr(builder_, level_ + 1);
    result_ = result_ && comparison_expr_1(builder_, level_ + 1);
    result_ = result_ && arithmetic_expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // comparison_op?
  private static boolean comparison_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "comparison_expr_1")) return false;
    comparison_op(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // EQEQ | NEQ | LT | LTE | GT | GTE
  public static boolean comparison_op(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "comparison_op")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, COMPARISON_OP, "<comparison op>");
    result_ = consumeToken(builder_, EQEQ);
    if (!result_) result_ = consumeToken(builder_, NEQ);
    if (!result_) result_ = consumeToken(builder_, LT);
    if (!result_) result_ = consumeToken(builder_, LTE);
    if (!result_) result_ = consumeToken(builder_, GT);
    if (!result_) result_ = consumeToken(builder_, GTE);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ("var" | "const")? "compartment"
  public static boolean compartment_declaration_prefix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "compartment_declaration_prefix")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, COMPARTMENT_DECLARATION_PREFIX, "<compartment declaration prefix>");
    result_ = compartment_declaration_prefix_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COMPARTMENT);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ("var" | "const")?
  private static boolean compartment_declaration_prefix_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "compartment_declaration_prefix_0")) return false;
    compartment_declaration_prefix_0_0(builder_, level_ + 1);
    return true;
  }

  // "var" | "const"
  private static boolean compartment_declaration_prefix_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "compartment_declaration_prefix_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, VAR);
    if (!result_) result_ = consumeToken(builder_, CONST);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean compartment_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "compartment_id")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, COMPARTMENT_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // MODEL annotation_type string (SEMI | EOL)
  public static boolean current_model_annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "current_model_annotation")) return false;
    if (!nextTokenIs(builder_, MODEL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, MODEL);
    result_ = result_ && annotation_type(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, STRING);
    result_ = result_ && current_model_annotation_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, CURRENT_MODEL_ANNOTATION, result_);
    return result_;
  }

  // SEMI | EOL
  private static boolean current_model_annotation_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "current_model_annotation_3")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // declaration_prefix? rule_or_assignment ("," rule_or_assignment)* (SEMI | EOL | LINE_COMMENT)
  public static boolean declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "declaration")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, DECLARATION, "<declaration>");
    result_ = declaration_0(builder_, level_ + 1);
    result_ = result_ && rule_or_assignment(builder_, level_ + 1);
    result_ = result_ && declaration_2(builder_, level_ + 1);
    result_ = result_ && declaration_3(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // declaration_prefix?
  private static boolean declaration_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "declaration_0")) return false;
    declaration_prefix(builder_, level_ + 1);
    return true;
  }

  // ("," rule_or_assignment)*
  private static boolean declaration_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "declaration_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!declaration_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "declaration_2", pos_)) break;
    }
    return true;
  }

  // "," rule_or_assignment
  private static boolean declaration_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "declaration_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && rule_or_assignment(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // SEMI | EOL | LINE_COMMENT
  private static boolean declaration_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "declaration_3")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = consumeToken(builder_, LINE_COMMENT);
    return result_;
  }

  /* ********************************************************** */
  // species_declaration_prefix | compartment_declaration_prefix | other_declaration_prefix
  static boolean declaration_prefix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "declaration_prefix")) return false;
    boolean result_;
    result_ = species_declaration_prefix(builder_, level_ + 1);
    if (!result_) result_ = compartment_declaration_prefix(builder_, level_ + 1);
    if (!result_) result_ = other_declaration_prefix(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // identifier EQ expr
  public static boolean event_assignment(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_assignment")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, EQ);
    result_ = result_ && expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, EVENT_ASSIGNMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // event_assignment ("," (BACKSLASH EOL)* event_assignment)*
  public static boolean event_assignments(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_assignments")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = event_assignment(builder_, level_ + 1);
    result_ = result_ && event_assignments_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, EVENT_ASSIGNMENTS, result_);
    return result_;
  }

  // ("," (BACKSLASH EOL)* event_assignment)*
  private static boolean event_assignments_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_assignments_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!event_assignments_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "event_assignments_1", pos_)) break;
    }
    return true;
  }

  // "," (BACKSLASH EOL)* event_assignment
  private static boolean event_assignments_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_assignments_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && event_assignments_1_0_1(builder_, level_ + 1);
    result_ = result_ && event_assignment(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (BACKSLASH EOL)*
  private static boolean event_assignments_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_assignments_1_0_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!event_assignments_1_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "event_assignments_1_0_1", pos_)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean event_assignments_1_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_assignments_1_0_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, BACKSLASH, EOL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (event_id ":")? event_trigger ":" (BACKSLASH EOL)* event_assignments (SEMI | EOL)
  public static boolean event_definition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_definition")) return false;
    if (!nextTokenIs(builder_, "<event definition>", AT, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EVENT_DEFINITION, "<event definition>");
    result_ = event_definition_0(builder_, level_ + 1);
    result_ = result_ && event_trigger(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && event_definition_3(builder_, level_ + 1);
    result_ = result_ && event_assignments(builder_, level_ + 1);
    result_ = result_ && event_definition_5(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (event_id ":")?
  private static boolean event_definition_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_definition_0")) return false;
    event_definition_0_0(builder_, level_ + 1);
    return true;
  }

  // event_id ":"
  private static boolean event_definition_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_definition_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = event_id(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (BACKSLASH EOL)*
  private static boolean event_definition_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_definition_3")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!event_definition_3_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "event_definition_3", pos_)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean event_definition_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_definition_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, BACKSLASH, EOL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // SEMI | EOL
  private static boolean event_definition_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_definition_5")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean event_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_id")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, EVENT_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // "at" expr
  public static boolean event_trigger(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "event_trigger")) return false;
    if (!nextTokenIs(builder_, AT)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, EVENT_TRIGGER, null);
    result_ = consumeToken(builder_, AT);
    pinned_ = result_; // pin = 1
    result_ = result_ && expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // logical_expr | arithmetic_expr
  public static boolean expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, EXPR, "<expression>");
    result_ = logical_expr(builder_, level_ + 1);
    if (!result_) result_ = arithmetic_expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // primary mul_expr * (BACKSLASH EOL)*
  static boolean factor(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "factor")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = primary(builder_, level_ + 1);
    result_ = result_ && factor_1(builder_, level_ + 1);
    result_ = result_ && factor_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // mul_expr *
  private static boolean factor_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "factor_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!mul_expr(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "factor_1", pos_)) break;
    }
    return true;
  }

  // (BACKSLASH EOL)*
  private static boolean factor_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "factor_2")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!factor_2_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "factor_2", pos_)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean factor_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "factor_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, BACKSLASH, EOL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // "import" filename (SEMI | EOL)
  public static boolean file_import(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file_import")) return false;
    if (!nextTokenIs(builder_, IMPORT)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IMPORT);
    result_ = result_ && filename(builder_, level_ + 1);
    result_ = result_ && file_import_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, FILE_IMPORT, result_);
    return result_;
  }

  // SEMI | EOL
  private static boolean file_import_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "file_import_2")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // string
  public static boolean filename(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "filename")) return false;
    if (!nextTokenIs(builder_, STRING)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, STRING);
    exit_section_(builder_, marker_, FILENAME, result_);
    return result_;
  }

  /* ********************************************************** */
  // expr (',' expr)*
  public static boolean function_arguments(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_arguments")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_ARGUMENTS, "<function arguments>");
    result_ = expr(builder_, level_ + 1);
    result_ = result_ && function_arguments_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (',' expr)*
  private static boolean function_arguments_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_arguments_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!function_arguments_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "function_arguments_1", pos_)) break;
    }
    return true;
  }

  // ',' expr
  private static boolean function_arguments_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_arguments_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // function_id '(' function_arguments? ')'
  public static boolean function_call(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_call")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_CALL, null);
    result_ = function_id(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LPAREN);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, function_call_2(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RPAREN) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // function_arguments?
  private static boolean function_call_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_call_2")) return false;
    function_arguments(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // "function" function_id "(" function_signature_arguments? ")" (SEMI | EOL) expr (SEMI | EOL) "end"
  public static boolean function_definition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_definition")) return false;
    if (!nextTokenIs(builder_, FUNCTION)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, FUNCTION_DEFINITION, null);
    result_ = consumeToken(builder_, FUNCTION);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, function_id(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, LPAREN)) && result_;
    result_ = pinned_ && report_error_(builder_, function_definition_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, RPAREN)) && result_;
    result_ = pinned_ && report_error_(builder_, function_definition_5(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, expr(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, function_definition_7(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, END) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // function_signature_arguments?
  private static boolean function_definition_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_definition_3")) return false;
    function_signature_arguments(builder_, level_ + 1);
    return true;
  }

  // SEMI | EOL
  private static boolean function_definition_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_definition_5")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  // SEMI | EOL
  private static boolean function_definition_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_definition_7")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean function_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_id")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, FUNCTION_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean function_signature_argument(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_signature_argument")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, FUNCTION_SIGNATURE_ARGUMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // function_signature_argument ("," function_signature_argument)*
  public static boolean function_signature_arguments(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_signature_arguments")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = function_signature_argument(builder_, level_ + 1);
    result_ = result_ && function_signature_arguments_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, FUNCTION_SIGNATURE_ARGUMENTS, result_);
    return result_;
  }

  // ("," function_signature_argument)*
  private static boolean function_signature_arguments_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_signature_arguments_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!function_signature_arguments_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "function_signature_arguments_1", pos_)) break;
    }
    return true;
  }

  // "," function_signature_argument
  private static boolean function_signature_arguments_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "function_signature_arguments_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && function_signature_argument(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ID
  public static boolean identifier(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "identifier")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ID);
    exit_section_(builder_, marker_, IDENTIFIER, result_);
    return result_;
  }

  /* ********************************************************** */
  // "$"? identifier ("in" compartment_id)?
  public static boolean just_declaration(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "just_declaration")) return false;
    if (!nextTokenIs(builder_, "<just declaration>", DOLLAR, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, JUST_DECLARATION, "<just declaration>");
    result_ = just_declaration_0(builder_, level_ + 1);
    result_ = result_ && identifier(builder_, level_ + 1);
    result_ = result_ && just_declaration_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // "$"?
  private static boolean just_declaration_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "just_declaration_0")) return false;
    consumeToken(builder_, DOLLAR);
    return true;
  }

  // ("in" compartment_id)?
  private static boolean just_declaration_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "just_declaration_2")) return false;
    just_declaration_2_0(builder_, level_ + 1);
    return true;
  }

  // "in" compartment_id
  private static boolean just_declaration_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "just_declaration_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, IN);
    result_ = result_ && compartment_id(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // species_expr (PLUS species_expr)*
  static boolean list_of_reactants(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "list_of_reactants")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = species_expr(builder_, level_ + 1);
    result_ = result_ && list_of_reactants_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (PLUS species_expr)*
  private static boolean list_of_reactants_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "list_of_reactants_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!list_of_reactants_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "list_of_reactants_1", pos_)) break;
    }
    return true;
  }

  // PLUS species_expr
  private static boolean list_of_reactants_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "list_of_reactants_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, PLUS);
    result_ = result_ && species_expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // number_literal unit_id ?
  public static boolean literal_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "literal_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LITERAL_EXPR, "<expression>");
    result_ = number_literal(builder_, level_ + 1);
    result_ = result_ && literal_expr_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // unit_id ?
  private static boolean literal_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "literal_expr_1")) return false;
    unit_id(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // logical_term or_expr *
  public static boolean logical_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logical_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, LOGICAL_EXPR, "<expression>");
    result_ = logical_term(builder_, level_ + 1);
    result_ = result_ && logical_expr_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // or_expr *
  private static boolean logical_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logical_expr_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!or_expr(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "logical_expr_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // not_expr and_expr *
  public static boolean logical_term(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logical_term")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, LOGICAL_TERM, "<logical term>");
    result_ = not_expr(builder_, level_ + 1);
    result_ = result_ && logical_term_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // and_expr *
  private static boolean logical_term_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "logical_term_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!and_expr(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "logical_term_1", pos_)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // model_id annotation_type string (SEMI | EOL)
  public static boolean model_annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_annotation")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = model_id(builder_, level_ + 1);
    result_ = result_ && annotation_type(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, STRING);
    result_ = result_ && model_annotation_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, MODEL_ANNOTATION, result_);
    return result_;
  }

  // SEMI | EOL
  private static boolean model_annotation_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_annotation_3")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean model_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_id")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, MODEL_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // (model_id ":")? model_id ("(" function_signature_arguments? ")")? ("," "timeconv" "=" expr)? ("," "extentconv" "=" expr)? (SEMI | EOL)
  public static boolean model_import(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = model_import_0(builder_, level_ + 1);
    result_ = result_ && model_id(builder_, level_ + 1);
    result_ = result_ && model_import_2(builder_, level_ + 1);
    result_ = result_ && model_import_3(builder_, level_ + 1);
    result_ = result_ && model_import_4(builder_, level_ + 1);
    result_ = result_ && model_import_5(builder_, level_ + 1);
    exit_section_(builder_, marker_, MODEL_IMPORT, result_);
    return result_;
  }

  // (model_id ":")?
  private static boolean model_import_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_0")) return false;
    model_import_0_0(builder_, level_ + 1);
    return true;
  }

  // model_id ":"
  private static boolean model_import_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = model_id(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ("(" function_signature_arguments? ")")?
  private static boolean model_import_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_2")) return false;
    model_import_2_0(builder_, level_ + 1);
    return true;
  }

  // "(" function_signature_arguments? ")"
  private static boolean model_import_2_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_2_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && model_import_2_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // function_signature_arguments?
  private static boolean model_import_2_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_2_0_1")) return false;
    function_signature_arguments(builder_, level_ + 1);
    return true;
  }

  // ("," "timeconv" "=" expr)?
  private static boolean model_import_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_3")) return false;
    model_import_3_0(builder_, level_ + 1);
    return true;
  }

  // "," "timeconv" "=" expr
  private static boolean model_import_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COMMA, TIMECONV, EQ);
    result_ = result_ && expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ("," "extentconv" "=" expr)?
  private static boolean model_import_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_4")) return false;
    model_import_4_0(builder_, level_ + 1);
    return true;
  }

  // "," "extentconv" "=" expr
  private static boolean model_import_4_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_4_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COMMA, EXTENTCONV, EQ);
    result_ = result_ && expr(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // SEMI | EOL
  private static boolean model_import_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "model_import_5")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // (modifier_id ":")? species_id ("-|" | "-o" | "-(") reaction_id (SEMI | EOL)
  public static boolean modifier_annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "modifier_annotation")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = modifier_annotation_0(builder_, level_ + 1);
    result_ = result_ && species_id(builder_, level_ + 1);
    result_ = result_ && modifier_annotation_2(builder_, level_ + 1);
    result_ = result_ && reaction_id(builder_, level_ + 1);
    result_ = result_ && modifier_annotation_4(builder_, level_ + 1);
    exit_section_(builder_, marker_, MODIFIER_ANNOTATION, result_);
    return result_;
  }

  // (modifier_id ":")?
  private static boolean modifier_annotation_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "modifier_annotation_0")) return false;
    modifier_annotation_0_0(builder_, level_ + 1);
    return true;
  }

  // modifier_id ":"
  private static boolean modifier_annotation_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "modifier_annotation_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = modifier_id(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // "-|" | "-o" | "-("
  private static boolean modifier_annotation_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "modifier_annotation_2")) return false;
    boolean result_;
    result_ = consumeToken(builder_, "-|");
    if (!result_) result_ = consumeToken(builder_, "-o");
    if (!result_) result_ = consumeToken(builder_, "-(");
    return result_;
  }

  // SEMI | EOL
  private static boolean modifier_annotation_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "modifier_annotation_4")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean modifier_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "modifier_id")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, MODIFIER_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // MODEL "*"? model_id ("(" function_signature_arguments? ")")? module_body? END
  public static boolean module_$(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_$")) return false;
    if (!nextTokenIs(builder_, MODEL)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MODULE, null);
    result_ = consumeToken(builder_, MODEL);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, module_1(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, model_id(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, module_3(builder_, level_ + 1)) && result_;
    result_ = pinned_ && report_error_(builder_, module_4(builder_, level_ + 1)) && result_;
    result_ = pinned_ && consumeToken(builder_, END) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // "*"?
  private static boolean module_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_1")) return false;
    consumeToken(builder_, MUL);
    return true;
  }

  // ("(" function_signature_arguments? ")")?
  private static boolean module_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_3")) return false;
    module_3_0(builder_, level_ + 1);
    return true;
  }

  // "(" function_signature_arguments? ")"
  private static boolean module_3_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_3_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, LPAREN);
    result_ = result_ && module_3_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RPAREN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // function_signature_arguments?
  private static boolean module_3_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_3_0_1")) return false;
    function_signature_arguments(builder_, level_ + 1);
    return true;
  }

  // module_body?
  private static boolean module_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_4")) return false;
    module_body(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // module_body_item +
  public static boolean module_body(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_body")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, MODULE_BODY, "<module body>");
    result_ = module_body_item(builder_, level_ + 1);
    while (result_) {
      int pos_ = current_position_(builder_);
      if (!module_body_item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "module_body", pos_)) break;
    }
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
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
  //     | model_import
  //     | file_import
  //     | current_model_annotation
  static boolean module_body_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_body_item")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = annotation(builder_, level_ + 1);
    if (!result_) result_ = reaction(builder_, level_ + 1);
    if (!result_) result_ = unit_annotation(builder_, level_ + 1);
    if (!result_) result_ = declaration(builder_, level_ + 1);
    if (!result_) result_ = unit_definition(builder_, level_ + 1);
    if (!result_) result_ = modifier_annotation(builder_, level_ + 1);
    if (!result_) result_ = event_definition(builder_, level_ + 1);
    if (!result_) result_ = function_definition(builder_, level_ + 1);
    if (!result_) result_ = model_import(builder_, level_ + 1);
    if (!result_) result_ = file_import(builder_, level_ + 1);
    if (!result_) result_ = current_model_annotation(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // mul_op primary
  public static boolean mul_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mul_expr")) return false;
    if (!nextTokenIs(builder_, "<expression>", DIV, MUL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _LEFT_, MUL_EXPR, "<expression>");
    result_ = mul_op(builder_, level_ + 1);
    result_ = result_ && primary(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ('*'|'/') (BACKSLASH EOL)*
  static boolean mul_op(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mul_op")) return false;
    if (!nextTokenIs(builder_, "", DIV, MUL)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = mul_op_0(builder_, level_ + 1);
    result_ = result_ && mul_op_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '*'|'/'
  private static boolean mul_op_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mul_op_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, MUL);
    if (!result_) result_ = consumeToken(builder_, DIV);
    return result_;
  }

  // (BACKSLASH EOL)*
  private static boolean mul_op_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mul_op_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!mul_op_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "mul_op_1", pos_)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean mul_op_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "mul_op_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, BACKSLASH, EOL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // NOT? comparison_expr
  public static boolean not_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "not_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, NOT_EXPR, "<expression>");
    result_ = not_expr_0(builder_, level_ + 1);
    result_ = result_ && comparison_expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // NOT?
  private static boolean not_expr_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "not_expr_0")) return false;
    consumeToken(builder_, NOT);
    return true;
  }

  /* ********************************************************** */
  // ('+'|'-') ? (INT | FLOAT | SCIENTIFIC)
  public static boolean number_literal(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "number_literal")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, NUMBER_LITERAL, "<number literal>");
    result_ = number_literal_0(builder_, level_ + 1);
    result_ = result_ && number_literal_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // ('+'|'-') ?
  private static boolean number_literal_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "number_literal_0")) return false;
    number_literal_0_0(builder_, level_ + 1);
    return true;
  }

  // '+'|'-'
  private static boolean number_literal_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "number_literal_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    return result_;
  }

  // INT | FLOAT | SCIENTIFIC
  private static boolean number_literal_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "number_literal_1")) return false;
    boolean result_;
    result_ = consumeToken(builder_, INT);
    if (!result_) result_ = consumeToken(builder_, FLOAT);
    if (!result_) result_ = consumeToken(builder_, SCIENTIFIC);
    return result_;
  }

  /* ********************************************************** */
  // OR logical_term
  public static boolean or_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "or_expr")) return false;
    if (!nextTokenIs(builder_, "<expression>", OR)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _LEFT_, OR_EXPR, "<expression>");
    result_ = consumeToken(builder_, OR);
    result_ = result_ && logical_term(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ("var" | "const")?
  public static boolean other_declaration_prefix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "other_declaration_prefix")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, OTHER_DECLARATION_PREFIX, "<other declaration prefix>");
    other_declaration_prefix_0(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, true, false, null);
    return true;
  }

  // "var" | "const"
  private static boolean other_declaration_prefix_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "other_declaration_prefix_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, VAR);
    if (!result_) result_ = consumeToken(builder_, CONST);
    return result_;
  }

  /* ********************************************************** */
  // ('-(' | '(') expr ')'
  public static boolean paren_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "paren_expr")) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, PAREN_EXPR, "<expression>");
    result_ = paren_expr_0(builder_, level_ + 1);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, expr(builder_, level_ + 1));
    result_ = pinned_ && consumeToken(builder_, RPAREN) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // '-(' | '('
  private static boolean paren_expr_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "paren_expr_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, "-(");
    if (!result_) result_ = consumeToken(builder_, LPAREN);
    return result_;
  }

  /* ********************************************************** */
  // plus_op factor
  public static boolean plus_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "plus_expr")) return false;
    if (!nextTokenIs(builder_, "<expression>", MINUS, PLUS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _LEFT_, PLUS_EXPR, "<expression>");
    result_ = plus_op(builder_, level_ + 1);
    result_ = result_ && factor(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ('+'|'-') (BACKSLASH EOL)*
  static boolean plus_op(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "plus_op")) return false;
    if (!nextTokenIs(builder_, "", MINUS, PLUS)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = plus_op_0(builder_, level_ + 1);
    result_ = result_ && plus_op_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // '+'|'-'
  private static boolean plus_op_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "plus_op_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    return result_;
  }

  // (BACKSLASH EOL)*
  private static boolean plus_op_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "plus_op_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!plus_op_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "plus_op_1", pos_)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean plus_op_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "plus_op_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, BACKSLASH, EOL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // '^' primary
  public static boolean power_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "power_expr")) return false;
    if (!nextTokenIs(builder_, "<expression>", POW)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _LEFT_, POWER_EXPR, "<expression>");
    result_ = consumeToken(builder_, POW);
    result_ = result_ && primary(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // primary_inner (BACKSLASH EOL)*  power_expr?
  static boolean primary(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = primary_inner(builder_, level_ + 1);
    result_ = result_ && primary_1(builder_, level_ + 1);
    result_ = result_ && primary_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (BACKSLASH EOL)*
  private static boolean primary_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_1")) return false;
    while (true) {
      int pos_ = current_position_(builder_);
      if (!primary_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "primary_1", pos_)) break;
    }
    return true;
  }

  // BACKSLASH EOL
  private static boolean primary_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_1_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, BACKSLASH, EOL);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // power_expr?
  private static boolean primary_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_2")) return false;
    power_expr(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // ('+'|'-') ? (literal_expr | function_call | ref_expr | paren_expr)
  static boolean primary_inner(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_inner")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = primary_inner_0(builder_, level_ + 1);
    result_ = result_ && primary_inner_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ('+'|'-') ?
  private static boolean primary_inner_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_inner_0")) return false;
    primary_inner_0_0(builder_, level_ + 1);
    return true;
  }

  // '+'|'-'
  private static boolean primary_inner_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_inner_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, PLUS);
    if (!result_) result_ = consumeToken(builder_, MINUS);
    return result_;
  }

  // literal_expr | function_call | ref_expr | paren_expr
  private static boolean primary_inner_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "primary_inner_1")) return false;
    boolean result_;
    result_ = literal_expr(builder_, level_ + 1);
    if (!result_) result_ = function_call(builder_, level_ + 1);
    if (!result_) result_ = ref_expr(builder_, level_ + 1);
    if (!result_) result_ = paren_expr(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // list_of_reactants
  public static boolean products(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "products")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, PRODUCTS, "<products>");
    result_ = list_of_reactants(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // expr
  public static boolean rate_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rate_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _COLLAPSE_, RATE_EXPR, "<expression>");
    result_ = expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // identifier "'" EQ expr
  public static boolean rate_rule(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rate_rule")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RATE_RULE, null);
    result_ = identifier(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 1, PRIME, EQ);
    pinned_ = result_; // pin = 2
    result_ = result_ && expr(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  /* ********************************************************** */
  // list_of_reactants
  public static boolean reactants(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reactants")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REACTANTS, "<reactants>");
    result_ = list_of_reactants(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (reaction_id ":")? reactants? ("->"|"=>") products? SEMI rate_expr (SEMI | EOL | <<eof>>)
  public static boolean reaction(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reaction")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REACTION, "<reaction>");
    result_ = reaction_0(builder_, level_ + 1);
    result_ = result_ && reaction_1(builder_, level_ + 1);
    result_ = result_ && reaction_2(builder_, level_ + 1);
    result_ = result_ && reaction_3(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMI);
    result_ = result_ && rate_expr(builder_, level_ + 1);
    result_ = result_ && reaction_6(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // (reaction_id ":")?
  private static boolean reaction_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reaction_0")) return false;
    reaction_0_0(builder_, level_ + 1);
    return true;
  }

  // reaction_id ":"
  private static boolean reaction_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reaction_0_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = reaction_id(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // reactants?
  private static boolean reaction_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reaction_1")) return false;
    reactants(builder_, level_ + 1);
    return true;
  }

  // "->"|"=>"
  private static boolean reaction_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reaction_2")) return false;
    boolean result_;
    result_ = consumeToken(builder_, "->");
    if (!result_) result_ = consumeToken(builder_, "=>");
    return result_;
  }

  // products?
  private static boolean reaction_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reaction_3")) return false;
    products(builder_, level_ + 1);
    return true;
  }

  // SEMI | EOL | <<eof>>
  private static boolean reaction_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reaction_6")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean reaction_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "reaction_id")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, REACTION_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean ref_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ref_expr")) return false;
    if (!nextTokenIs(builder_, "<expression>", ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, REF_EXPR, "<expression>");
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // EOL | module | module_body | model_annotation
  static boolean root_item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "root_item")) return false;
    boolean result_;
    result_ = consumeToken(builder_, EOL);
    if (!result_) result_ = module_$(builder_, level_ + 1);
    if (!result_) result_ = module_body(builder_, level_ + 1);
    if (!result_) result_ = model_annotation(builder_, level_ + 1);
    return result_;
  }

  /* ********************************************************** */
  // rate_rule | assignment | assignment_rule | just_declaration
  public static boolean rule_or_assignment(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "rule_or_assignment")) return false;
    if (!nextTokenIs(builder_, "<rule or assignment>", DOLLAR, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, RULE_OR_ASSIGNMENT, "<rule or assignment>");
    result_ = rate_rule(builder_, level_ + 1);
    if (!result_) result_ = assignment(builder_, level_ + 1);
    if (!result_) result_ = assignment_rule(builder_, level_ + 1);
    if (!result_) result_ = just_declaration(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ("substanceOnly" "species") | (("var" | "const")? "species")
  public static boolean species_declaration_prefix(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "species_declaration_prefix")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SPECIES_DECLARATION_PREFIX, "<species declaration prefix>");
    result_ = species_declaration_prefix_0(builder_, level_ + 1);
    if (!result_) result_ = species_declaration_prefix_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // "substanceOnly" "species"
  private static boolean species_declaration_prefix_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "species_declaration_prefix_0")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, SUBSTANCE_ONLY, SPECIES);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ("var" | "const")? "species"
  private static boolean species_declaration_prefix_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "species_declaration_prefix_1")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = species_declaration_prefix_1_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SPECIES);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ("var" | "const")?
  private static boolean species_declaration_prefix_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "species_declaration_prefix_1_0")) return false;
    species_declaration_prefix_1_0_0(builder_, level_ + 1);
    return true;
  }

  // "var" | "const"
  private static boolean species_declaration_prefix_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "species_declaration_prefix_1_0_0")) return false;
    boolean result_;
    result_ = consumeToken(builder_, VAR);
    if (!result_) result_ = consumeToken(builder_, CONST);
    return result_;
  }

  /* ********************************************************** */
  // stoichiometry? "$"? species_id
  public static boolean species_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "species_expr")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, SPECIES_EXPR, "<expression>");
    result_ = species_expr_0(builder_, level_ + 1);
    result_ = result_ && species_expr_1(builder_, level_ + 1);
    result_ = result_ && species_id(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  // stoichiometry?
  private static boolean species_expr_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "species_expr_0")) return false;
    stoichiometry(builder_, level_ + 1);
    return true;
  }

  // "$"?
  private static boolean species_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "species_expr_1")) return false;
    consumeToken(builder_, DOLLAR);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean species_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "species_id")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, SPECIES_ID, result_);
    return result_;
  }

  /* ********************************************************** */
  // number_literal
  public static boolean stoichiometry(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "stoichiometry")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, STOICHIOMETRY, "<stoichiometry>");
    result_ = number_literal(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // identifier "has" unit_id (SEMI | EOL)
  public static boolean unit_annotation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unit_annotation")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, UNIT_ANNOTATION, null);
    result_ = identifier(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, HAS);
    pinned_ = result_; // pin = 2
    result_ = result_ && report_error_(builder_, unit_id(builder_, level_ + 1));
    result_ = pinned_ && unit_annotation_3(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // SEMI | EOL
  private static boolean unit_annotation_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unit_annotation_3")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // "unit" unit_id EQ expr (SEMI | EOL)
  public static boolean unit_definition(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unit_definition")) return false;
    if (!nextTokenIs(builder_, UNIT_KEYWORD)) return false;
    boolean result_, pinned_;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, UNIT_DEFINITION, null);
    result_ = consumeToken(builder_, UNIT_KEYWORD);
    pinned_ = result_; // pin = 1
    result_ = result_ && report_error_(builder_, unit_id(builder_, level_ + 1));
    result_ = pinned_ && report_error_(builder_, consumeToken(builder_, EQ)) && result_;
    result_ = pinned_ && report_error_(builder_, expr(builder_, level_ + 1)) && result_;
    result_ = pinned_ && unit_definition_4(builder_, level_ + 1) && result_;
    exit_section_(builder_, level_, marker_, result_, pinned_, null);
    return result_ || pinned_;
  }

  // SEMI | EOL
  private static boolean unit_definition_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unit_definition_4")) return false;
    boolean result_;
    result_ = consumeToken(builder_, SEMI);
    if (!result_) result_ = consumeToken(builder_, EOL);
    return result_;
  }

  /* ********************************************************** */
  // identifier
  public static boolean unit_id(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "unit_id")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = identifier(builder_, level_ + 1);
    exit_section_(builder_, marker_, UNIT_ID, result_);
    return result_;
  }

}
