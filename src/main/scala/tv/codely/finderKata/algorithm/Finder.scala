package tv.codely.finderKata.algorithm

class Finder(private val personList: List[Person]) {

  def Find(findByAgeType: FinderByAgeType): PersonPair = {

    val sortedList = personList.sortWith(_.birthDate.getMillis < _.birthDate.getMillis)
    sortedList.size match {
      case 0 | 1 => new PersonPair()
      case _ => {
        findByAgeType match {
          case FURTHEST => new PersonPair(Some(sortedList.head), Some(sortedList.last))
          case CLOSEST => {
            val currentLeastDifferencePair = new PersonPair(Some(sortedList.head), Some(sortedList.tail.head))
            findClosestPair(currentLeastDifferencePair, sortedList.tail)
          }
        }
      }
    }
  }

  def findClosestPair(currentLeastDifferencePair: PersonPair, remainingList: List[Person]): PersonPair = {
    remainingList.size match {
      case 1 => currentLeastDifferencePair
      case _ => {
        val older = remainingList.head;
        val nextOlder = remainingList.tail.head;
        val newCurrentDifferencePair = new PersonPair(Some(older), Some(nextOlder))
        if (newCurrentDifferencePair.AgeDifference < currentLeastDifferencePair.AgeDifference) {
          findClosestPair(newCurrentDifferencePair, remainingList.tail)
        } else {
          findClosestPair(currentLeastDifferencePair, remainingList.tail)
        }
      }
    }
  }
}


