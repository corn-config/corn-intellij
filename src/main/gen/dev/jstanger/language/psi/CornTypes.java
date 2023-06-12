// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import dev.jstanger.language.psi.impl.*;

public interface CornTypes {

  IElementType ARRAY = new CornElementType("ARRAY");
  IElementType ARRAY_VALUE = new CornElementType("ARRAY_VALUE");
  IElementType ASSIGNMENT = new CornElementType("ASSIGNMENT");
  IElementType ASSIGN_BLOCK = new CornElementType("ASSIGN_BLOCK");
  IElementType BOOLEAN = new CornElementType("BOOLEAN");
  IElementType INPUT = new CornElementType("INPUT");
  IElementType OBJECT = new CornElementType("OBJECT");
  IElementType OBJECT_VALUE = new CornElementType("OBJECT_VALUE");
  IElementType PAIR = new CornElementType("PAIR");
  IElementType PATH = new CornElementType("PATH");
  IElementType SPREAD = new CornElementType("SPREAD");
  IElementType VALUE = new CornElementType("VALUE");

  IElementType COMMENT = new CornTokenType("comment");
  IElementType DOT = new CornTokenType(".");
  IElementType DOTDOT = new CornTokenType("..");
  IElementType DOUBLE_QUOTE = new CornTokenType("\"");
  IElementType FALSE = new CornTokenType("false");
  IElementType FLOAT = new CornTokenType("float");
  IElementType IN = new CornTokenType("in");
  IElementType INPUT_TOKEN = new CornTokenType("input_token");
  IElementType INTEGER = new CornTokenType("integer");
  IElementType LEFT_BRACE = new CornTokenType("{");
  IElementType LEFT_BRACKET = new CornTokenType("[");
  IElementType LET = new CornTokenType("let");
  IElementType NULL = new CornTokenType("null");
  IElementType OP_EQ = new CornTokenType("=");
  IElementType PATH_SEG = new CornTokenType("path_seg");
  IElementType RIGHT_BRACE = new CornTokenType("}");
  IElementType RIGHT_BRACKET = new CornTokenType("]");
  IElementType STRING = new CornTokenType("string");
  IElementType TRUE = new CornTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY) {
        return new CornArrayImpl(node);
      }
      else if (type == ARRAY_VALUE) {
        return new CornArrayValueImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new CornAssignmentImpl(node);
      }
      else if (type == ASSIGN_BLOCK) {
        return new CornAssignBlockImpl(node);
      }
      else if (type == BOOLEAN) {
        return new CornBooleanImpl(node);
      }
      else if (type == INPUT) {
        return new CornInputImpl(node);
      }
      else if (type == OBJECT) {
        return new CornObjectImpl(node);
      }
      else if (type == OBJECT_VALUE) {
        return new CornObjectValueImpl(node);
      }
      else if (type == PAIR) {
        return new CornPairImpl(node);
      }
      else if (type == PATH) {
        return new CornPathImpl(node);
      }
      else if (type == SPREAD) {
        return new CornSpreadImpl(node);
      }
      else if (type == VALUE) {
        return new CornValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
