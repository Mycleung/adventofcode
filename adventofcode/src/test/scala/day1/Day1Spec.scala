package day1

import org.scalatest._

class Day1Spec extends WordSpec with Matchers {
  "Day1 Inverse Captcha" should {
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
}
