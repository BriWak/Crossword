import org.scalatest._
import _root_.exceptions.NoSuitableSiteException
import models.GridInterpreter

class CrosswordSpec extends WordSpec with MustMatchers{

  "Matcher" must {
  val m = new Matcher
    "place a 2 letter word in a location that is suitable" in {
      m.parse(List("it","the"),"..") mustEqual List("it")
    }

    "place a 3 letter word in a location that is suitable" in {
      m.parse(List("it","the"),"...") mustEqual List("the")
    }

    "throw an error when given a 4 letter word that is unsuitable" in {
      val error = intercept[NoSuitableSiteException](m.parse(List("then","the"),".."))
      error.getMessage mustEqual "Unable to find a word for a 2 character site"
    }

    "return all 3 letter words when given a site that is 3 long" in {
      m.parse(List("and", "end", "dot", "kevin"),"...") mustEqual List("and", "end", "dot")
    }
  }
  "GridInterpreter" must {
    val g = new GridInterpreter
    "return 1 sites when given a  grid with 1 sites in" in {
      g.find("  \n..") mustEqual List("..")
    }

    "return 2 sites when given a grid with 2 sites in" in {
      g.find(" .\n..") mustEqual List("..","..")
    }

  }
}
