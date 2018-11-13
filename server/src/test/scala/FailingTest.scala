import org.scalatest.{Matchers, WordSpec}

class FailingTest extends WordSpec with Matchers {
  "this test" should {
    "fail" in {
      fail()
    }
  }
}
