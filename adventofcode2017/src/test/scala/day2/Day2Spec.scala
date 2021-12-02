package day2

import org.scalatest.{Matchers, WordSpec}

class Day2Spec extends WordSpec with Matchers {

  "day2 part 1" should {
    "calculate a checksum" in {
      val test = """5	1	9	5
                   |7	5	3
                   |2c4	6	8""".stripMargin
      Day2.solve1(test) shouldBe 18
    }
  }

  "day2 part 2" should {
    "calculate a checksum" in {
      val test = """5	9	2	8
                   |9	4	7	3
                   |3	8	6	5""".stripMargin
      Day2.solve2(test) shouldBe 9
    }
  }

}
