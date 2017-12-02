package day1

import org.scalatest._

class Day1Spec extends WordSpec with Matchers {
  "Day1 Inverse Captcha 1" should {
    "get 3 for 1122" in {
      Day1.inverseCaptchaNext("1122") shouldBe 3
    }

    "get 4 for 1111" in {
      Day1.inverseCaptchaNext("1111") shouldBe 4
    }

    "get 0 for 1234" in {
      Day1.inverseCaptchaNext("1234") shouldBe 0
    }

    "get 9 for 91212129" in {
      Day1.inverseCaptchaNext("91212129") shouldBe 9
    }

    "get 0 for 5" in {
      Day1.inverseCaptchaNext("5") shouldBe 0
    }
  }

  "Day1 Inverse Captcha 2" should {
    "get 6 for 1212" in {
      Day1.inverseCaptchaHalf("1212") shouldBe 6
    }

    "get 0 for 1221" in {
      Day1.inverseCaptchaHalf("1221") shouldBe 0
    }

    "get 4 for 123425" in {
      Day1.inverseCaptchaHalf("123425") shouldBe 4
    }

    "get 12 for 123123" in {
      Day1.inverseCaptchaHalf("123123") shouldBe 12
    }

    "get 4 for 12131415" in {
      Day1.inverseCaptchaHalf("12131415") shouldBe 4
    }
  }
}
