package CheckEmailID

import org.scalatest.funsuite.AnyFunSuite

class CheckEmailTest extends AnyFunSuite{

  val email = new CheckEmail
  test("Check Recipient's Name that it does not contain special characters"){

    val expectedValue = true
    val result = email.recipientName("aayush@gmail.com")
    assert(result == expectedValue)
  }

  test("Recipient's Name with Special Characters throw Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      email.recipientName("aayush??@gmail.com")
    }
  }


  test("Check '@' Symbol is present in the Email ID"){

    val expectedValue= true
    val result = email.checkAtTheRate("aayush@gmail.com")
    assert(result == expectedValue)
  }


  test("Email ID without '@' throws Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      email.checkAtTheRate("aayushgmail.com")
    }
  }


  test("Check that Domain Name does not contain special characters"){

    val expectedValue= true
    val result = email.domainName("aayush@gmail.com")
    assert(result == expectedValue)
  }


  test("Domain Name with Special Characters throws Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      email.domainName("aayush@gmail#23.com")
    }
  }


  test("Check Top Level Domains are .com/.net/.org"){

    val expectedValue= true
    val result = email.topLevelDomain("aayush@gmail.com")
    assert(result == expectedValue)
  }

  test("If Top Level Domain is not .net/.org/.com it throws Illegal Argument Exception"){

    intercept[IllegalArgumentException]{
      email.topLevelDomain("aayush@gmail.co.in")
    }
  }
}
