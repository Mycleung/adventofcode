package day3

import scala.math.{pow, sqrt, abs}

object Day3 extends App {
  // Find the largest square number that's lower than the target
  def highestSquare(target: Int): Int = sqrt(target.toDouble).floor.toInt

  def cornerCoords(square: Int): (Int, Int) = {
    if (isEven(square)) (1 - (square / 2), square / 2)
    else (square / 2, - (square / 2))
  }

  def pointCoord(num: Int): (Int, Int) = {
    val square = highestSquare(num)
    println(s"Highest square : $square")
    val (cornerX, cornerY) = cornerCoords(square)
    println(s"Corners: ($cornerX, $cornerY)")
    val walk: Int = num - pow(square.toDouble, 2.0).toInt
    if (isEven(square)) {
      walk match {
        case 0 => (cornerX, cornerY)
        case 1 => (cornerX - 1, cornerY)
        case a if a <= square + 1 => (cornerX -1, cornerY - a + 1)
        case b => (cornerX + (b - square - 2), cornerY - square)
      }
    } else {
      walk match {
        case 0 => (cornerX, cornerY)
        case 1 => (cornerX + 1, cornerY)
        case a if a <= square + 1 => (cornerX + 1, cornerY + a - 1)
        case b => (cornerX - (b - square - 2), cornerY + square)
      }
    }

  }

  def isEven(num: Int): Boolean = {
    num % 2 == 0
  }

  def steps1(num: Int): Int = {
    val (x, y) = pointCoord(num)
    abs(x) + abs(y)
  }

  println(s"Solution for part 1 is: ${steps1(289326)}")
}
