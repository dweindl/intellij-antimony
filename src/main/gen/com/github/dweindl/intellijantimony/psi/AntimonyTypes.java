// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.dweindl.intellijantimony.psi.impl.*;

public interface AntimonyTypes {

  IElementType AND_EXPR = new AntimonyElementType("AND_EXPR");
  IElementType ANNOTATION = new AntimonyElementType("ANNOTATION");
  IElementType ANNOTATION_IS = new AntimonyElementType("ANNOTATION_IS");
  IElementType ANNOTATION_TYPE = new AntimonyElementType("ANNOTATION_TYPE");
  IElementType ARITHMETIC_EXPR = new AntimonyElementType("ARITHMETIC_EXPR");
  IElementType ASSIGNMENT = new AntimonyElementType("ASSIGNMENT");
  IElementType ASSIGNMENT_RULE = new AntimonyElementType("ASSIGNMENT_RULE");
  IElementType COMPARISON_EXPR = new AntimonyElementType("COMPARISON_EXPR");
  IElementType COMPARISON_OP = new AntimonyElementType("COMPARISON_OP");
  IElementType COMPARTMENT_ID = new AntimonyElementType("COMPARTMENT_ID");
  IElementType DECLARATION = new AntimonyElementType("DECLARATION");
  IElementType DECLARATION_BODY = new AntimonyElementType("DECLARATION_BODY");
  IElementType EVENT_ASSIGNMENT = new AntimonyElementType("EVENT_ASSIGNMENT");
  IElementType EVENT_ASSIGNMENTS = new AntimonyElementType("EVENT_ASSIGNMENTS");
  IElementType EVENT_DEFINITION = new AntimonyElementType("EVENT_DEFINITION");
  IElementType EVENT_TRIGGER = new AntimonyElementType("EVENT_TRIGGER");
  IElementType EXPR = new AntimonyElementType("EXPR");
  IElementType FUNCTION_ARGUMENTS = new AntimonyElementType("FUNCTION_ARGUMENTS");
  IElementType FUNCTION_CALL = new AntimonyElementType("FUNCTION_CALL");
  IElementType FUNCTION_NAME = new AntimonyElementType("FUNCTION_NAME");
  IElementType IDENTIFIER = new AntimonyElementType("IDENTIFIER");
  IElementType LITERAL_EXPR = new AntimonyElementType("LITERAL_EXPR");
  IElementType LOGICAL_EXPR = new AntimonyElementType("LOGICAL_EXPR");
  IElementType LOGICAL_TERM = new AntimonyElementType("LOGICAL_TERM");
  IElementType MODEL_ANNOTATION = new AntimonyElementType("MODEL_ANNOTATION");
  IElementType MODEL_ID = new AntimonyElementType("MODEL_ID");
  IElementType MODIFIER_ANNOTATION = new AntimonyElementType("MODIFIER_ANNOTATION");
  IElementType MODIFIER_ID = new AntimonyElementType("MODIFIER_ID");
  IElementType MODULE = new AntimonyElementType("MODULE");
  IElementType MODULE_BODY = new AntimonyElementType("MODULE_BODY");
  IElementType MUL_EXPR = new AntimonyElementType("MUL_EXPR");
  IElementType NOT_EXPR = new AntimonyElementType("NOT_EXPR");
  IElementType NUMBER_LITERAL = new AntimonyElementType("NUMBER_LITERAL");
  IElementType OR_EXPR = new AntimonyElementType("OR_EXPR");
  IElementType PAREN_EXPR = new AntimonyElementType("PAREN_EXPR");
  IElementType PLUS_EXPR = new AntimonyElementType("PLUS_EXPR");
  IElementType POWER_EXPR = new AntimonyElementType("POWER_EXPR");
  IElementType PRODUCTS = new AntimonyElementType("PRODUCTS");
  IElementType RATE_EXPR = new AntimonyElementType("RATE_EXPR");
  IElementType RATE_RULE = new AntimonyElementType("RATE_RULE");
  IElementType REACTANTS = new AntimonyElementType("REACTANTS");
  IElementType REACTION = new AntimonyElementType("REACTION");
  IElementType REACTION_ID = new AntimonyElementType("REACTION_ID");
  IElementType REF_EXPR = new AntimonyElementType("REF_EXPR");
  IElementType SPECIES_EXPR = new AntimonyElementType("SPECIES_EXPR");
  IElementType SPECIES_ID = new AntimonyElementType("SPECIES_ID");
  IElementType STOICHIOMETRY = new AntimonyElementType("STOICHIOMETRY");
  IElementType UNIT = new AntimonyElementType("UNIT");
  IElementType UNIT_ANNOTATION = new AntimonyElementType("UNIT_ANNOTATION");
  IElementType UNIT_DEFINITION = new AntimonyElementType("UNIT_DEFINITION");

  IElementType AND = new AntimonyTokenType("&&");
  IElementType ASSIGN_EQ = new AntimonyTokenType(":=");
  IElementType AT = new AntimonyTokenType("at");
  IElementType BACKSLASH = new AntimonyTokenType("\\");
  IElementType BLOCK_COMMENT = new AntimonyTokenType("BLOCK_COMMENT");
  IElementType COLON = new AntimonyTokenType(":");
  IElementType COMMA = new AntimonyTokenType(",");
  IElementType COMPARTMENT = new AntimonyTokenType("compartment");
  IElementType CONST = new AntimonyTokenType("const");
  IElementType DIV = new AntimonyTokenType("/");
  IElementType DOT = new AntimonyTokenType(".");
  IElementType END = new AntimonyTokenType("end");
  IElementType EOL = new AntimonyTokenType("EOL");
  IElementType EQ = new AntimonyTokenType("=");
  IElementType EQEQ = new AntimonyTokenType("==");
  IElementType FLOAT = new AntimonyTokenType("FLOAT");
  IElementType GT = new AntimonyTokenType(">");
  IElementType GTE = new AntimonyTokenType(">=");
  IElementType HAS = new AntimonyTokenType("has");
  IElementType ID = new AntimonyTokenType("ID");
  IElementType IN = new AntimonyTokenType("in");
  IElementType INT = new AntimonyTokenType("INT");
  IElementType IS = new AntimonyTokenType("is");
  IElementType LINE_COMMENT = new AntimonyTokenType("LINE_COMMENT");
  IElementType LPAREN = new AntimonyTokenType("(");
  IElementType LT = new AntimonyTokenType("<");
  IElementType LTE = new AntimonyTokenType("<=");
  IElementType MINUS = new AntimonyTokenType("-");
  IElementType MODEL = new AntimonyTokenType("MODEL");
  IElementType MUL = new AntimonyTokenType("*");
  IElementType NEQ = new AntimonyTokenType("!=");
  IElementType NOT = new AntimonyTokenType("!");
  IElementType NOTES = new AntimonyTokenType("notes");
  IElementType OR = new AntimonyTokenType("||");
  IElementType PLUS = new AntimonyTokenType("+");
  IElementType POW = new AntimonyTokenType("^");
  IElementType PRIME = new AntimonyTokenType("'");
  IElementType RPAREN = new AntimonyTokenType(")");
  IElementType SCIENTIFIC = new AntimonyTokenType("SCIENTIFIC");
  IElementType SEMI = new AntimonyTokenType(";");
  IElementType SPECIES = new AntimonyTokenType("species");
  IElementType STRING = new AntimonyTokenType("string");
  IElementType UNIT_KEYWORD = new AntimonyTokenType("unit");
  IElementType VAR = new AntimonyTokenType("var");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AND_EXPR) {
        return new AntimonyAndExprImpl(node);
      }
      else if (type == ANNOTATION) {
        return new AntimonyAnnotationImpl(node);
      }
      else if (type == ANNOTATION_IS) {
        return new AntimonyAnnotationIsImpl(node);
      }
      else if (type == ANNOTATION_TYPE) {
        return new AntimonyAnnotationTypeImpl(node);
      }
      else if (type == ARITHMETIC_EXPR) {
        return new AntimonyArithmeticExprImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new AntimonyAssignmentImpl(node);
      }
      else if (type == ASSIGNMENT_RULE) {
        return new AntimonyAssignmentRuleImpl(node);
      }
      else if (type == COMPARISON_EXPR) {
        return new AntimonyComparisonExprImpl(node);
      }
      else if (type == COMPARISON_OP) {
        return new AntimonyComparisonOpImpl(node);
      }
      else if (type == COMPARTMENT_ID) {
        return new AntimonyCompartmentIdImpl(node);
      }
      else if (type == DECLARATION) {
        return new AntimonyDeclarationImpl(node);
      }
      else if (type == DECLARATION_BODY) {
        return new AntimonyDeclarationBodyImpl(node);
      }
      else if (type == EVENT_ASSIGNMENT) {
        return new AntimonyEventAssignmentImpl(node);
      }
      else if (type == EVENT_ASSIGNMENTS) {
        return new AntimonyEventAssignmentsImpl(node);
      }
      else if (type == EVENT_DEFINITION) {
        return new AntimonyEventDefinitionImpl(node);
      }
      else if (type == EVENT_TRIGGER) {
        return new AntimonyEventTriggerImpl(node);
      }
      else if (type == FUNCTION_ARGUMENTS) {
        return new AntimonyFunctionArgumentsImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new AntimonyFunctionCallImpl(node);
      }
      else if (type == FUNCTION_NAME) {
        return new AntimonyFunctionNameImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new AntimonyIdentifierImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new AntimonyLiteralExprImpl(node);
      }
      else if (type == LOGICAL_EXPR) {
        return new AntimonyLogicalExprImpl(node);
      }
      else if (type == LOGICAL_TERM) {
        return new AntimonyLogicalTermImpl(node);
      }
      else if (type == MODEL_ANNOTATION) {
        return new AntimonyModelAnnotationImpl(node);
      }
      else if (type == MODEL_ID) {
        return new AntimonyModelIdImpl(node);
      }
      else if (type == MODIFIER_ANNOTATION) {
        return new AntimonyModifierAnnotationImpl(node);
      }
      else if (type == MODIFIER_ID) {
        return new AntimonyModifierIdImpl(node);
      }
      else if (type == MODULE) {
        return new AntimonyModuleImpl(node);
      }
      else if (type == MODULE_BODY) {
        return new AntimonyModuleBodyImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new AntimonyMulExprImpl(node);
      }
      else if (type == NOT_EXPR) {
        return new AntimonyNotExprImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new AntimonyNumberLiteralImpl(node);
      }
      else if (type == OR_EXPR) {
        return new AntimonyOrExprImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new AntimonyParenExprImpl(node);
      }
      else if (type == PLUS_EXPR) {
        return new AntimonyPlusExprImpl(node);
      }
      else if (type == POWER_EXPR) {
        return new AntimonyPowerExprImpl(node);
      }
      else if (type == PRODUCTS) {
        return new AntimonyProductsImpl(node);
      }
      else if (type == RATE_RULE) {
        return new AntimonyRateRuleImpl(node);
      }
      else if (type == REACTANTS) {
        return new AntimonyReactantsImpl(node);
      }
      else if (type == REACTION) {
        return new AntimonyReactionImpl(node);
      }
      else if (type == REACTION_ID) {
        return new AntimonyReactionIdImpl(node);
      }
      else if (type == REF_EXPR) {
        return new AntimonyRefExprImpl(node);
      }
      else if (type == SPECIES_EXPR) {
        return new AntimonySpeciesExprImpl(node);
      }
      else if (type == SPECIES_ID) {
        return new AntimonySpeciesIdImpl(node);
      }
      else if (type == STOICHIOMETRY) {
        return new AntimonyStoichiometryImpl(node);
      }
      else if (type == UNIT) {
        return new AntimonyUnitImpl(node);
      }
      else if (type == UNIT_ANNOTATION) {
        return new AntimonyUnitAnnotationImpl(node);
      }
      else if (type == UNIT_DEFINITION) {
        return new AntimonyUnitDefinitionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
