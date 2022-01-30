// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static dev.jstanger.language.psi.CornTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CornParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return config(b, l + 1);
  }

  /* ********************************************************** */
  // LEFT_BRACKET value* RIGHT_BRACKET
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && array_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // value*
  private static boolean array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LET LEFT_BRACE { assignment } * RIGHT_BRACE IN
  public static boolean assign_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_block")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LET, LEFT_BRACE);
    r = r && assign_block_2(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_BRACE, IN);
    exit_section_(b, m, ASSIGN_BLOCK, r);
    return r;
  }

  // { assignment } *
  private static boolean assign_block_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_block_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!assign_block_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assign_block_2", c)) break;
    }
    return true;
  }

  // { assignment }
  private static boolean assign_block_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_block_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // input OP_EQ value
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, INPUT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = input(b, l + 1);
    r = r && consumeToken(b, OP_EQ);
    r = r && value(b, l + 1);
    exit_section_(b, m, ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // TRUE | FALSE
  public static boolean boolean_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_$")) return false;
    if (!nextTokenIs(b, "<boolean $>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN, "<boolean $>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // assign_block? object
  static boolean config(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config")) return false;
    if (!nextTokenIs(b, "", LEFT_BRACE, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = config_0(b, l + 1);
    r = r && object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // assign_block?
  private static boolean config_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "config_0")) return false;
    assign_block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // input_token
  public static boolean input(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "input")) return false;
    if (!nextTokenIs(b, INPUT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INPUT_TOKEN);
    exit_section_(b, m, INPUT, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACE { pair }* RIGHT_BRACE
  public static boolean object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object")) return false;
    if (!nextTokenIs(b, LEFT_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACE);
    r = r && object_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACE);
    exit_section_(b, m, OBJECT, r);
    return r;
  }

  // { pair }*
  private static boolean object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!object_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "object_1", c)) break;
    }
    return true;
  }

  // { pair }
  private static boolean object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pair(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // path OP_EQ value
  public static boolean pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pair")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PAIR, "<pair>");
    r = path(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, OP_EQ));
    r = p && value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, CornParser::pair_recover);
    return r || p;
  }

  /* ********************************************************** */
  // !(path | RIGHT_BRACE )
  static boolean pair_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pair_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !pair_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // path | RIGHT_BRACE
  private static boolean pair_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pair_recover_0")) return false;
    boolean r;
    r = path(b, l + 1);
    if (!r) r = consumeToken(b, RIGHT_BRACE);
    return r;
  }

  /* ********************************************************** */
  // path_seg + (DOT path_seg )*
  public static boolean path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path")) return false;
    if (!nextTokenIs(b, PATH_SEG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = path_0(b, l + 1);
    r = r && path_1(b, l + 1);
    exit_section_(b, m, PATH, r);
    return r;
  }

  // path_seg +
  private static boolean path_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PATH_SEG);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, PATH_SEG)) break;
      if (!empty_element_parsed_guard_(b, "path_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT path_seg )*
  private static boolean path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "path_1", c)) break;
    }
    return true;
  }

  // DOT path_seg
  private static boolean path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, PATH_SEG);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // object | array | input | string | float | integer | boolean | NULL
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = object(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = input(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = boolean_$(b, l + 1);
    if (!r) r = consumeToken(b, NULL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
