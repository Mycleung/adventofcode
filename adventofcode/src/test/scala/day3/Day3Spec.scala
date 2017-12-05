package day3

import org.scalatest.{Matchers, WordSpec}
import math.{sqrt, pow}

class Day3Spec extends WordSpec with Matchers {

  "Day 3 part 1" should {
    "get a distance of 0 for square 1" in {
      Day3.steps1(1) shouldBe 0
    }

    "get a distance of 3 for square 12" in {
      Day3.steps1(12) shouldBe 3
    }

    "get a distance of 2 for square 23" in {
      Day3.steps1(23) shouldBe 2
    }

    "get a distance of 31 for square 1024" in {
      Day3.steps1(1024) shouldBe 31
    }
  }
}
