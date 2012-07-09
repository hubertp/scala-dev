/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2006-2011, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */



package scala.util.parsing
package combinator
package lexical

import token._
import input.CharArrayReader.EofCh
import debugging.ParserLocation

/** This component complements the `Scanners` component with
 *  common operations for lexical parsers.
 *
 *  Refer to [[scala.util.parsing.combinator.lexical.StdLexical]]
 *  for a concrete implementation for a simple, Scala-like language.
 *
 * @author Martin Odersky, Adriaan Moors
 */
abstract class Lexical extends Scanners with Tokens {

  /** A character-parser that matches a letter (and returns it).*/
  def letter(implicit loc: ParserLocation) = elem("letter", _.isLetter)

  /** A character-parser that matches a digit (and returns it).*/
  def digit(implicit loc: ParserLocation) = elem("digit", _.isDigit)

  /** A character-parser that matches any character except the ones given in `cs` (and returns it).*/
  def chrExcept(cs: Char*)(implicit loc: ParserLocation) = elem("", ch => (cs forall (ch != _)))

  /** A character-parser that matches a white-space character (and returns it).*/
  def whitespaceChar(implicit loc: ParserLocation) = elem("space char", ch => ch <= ' ' && ch != EofCh)
}
