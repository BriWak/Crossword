import exceptions._

class Matcher {
  def parse(words: List[String],site: String): List[String] = {
    val suitableWords = words.filter(word => word.length == site.length)
    if (suitableWords == Nil) throw new NoSuitableSiteException(s"Unable to find a word for a ${site.length} character site")
    suitableWords
    //      case 2 => "it"
//      case 3 => "the"
//      case invalid => throw new NoSuitableSiteException(s"Unable to find a word for a $invalid character site")
//    }
  }
}

