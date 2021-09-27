package tv.codely.finderKata.algorithm

import tv.codely.finderKata.algorithm.FinderByAgeType.FindByAge

class Finder(private val personList: List[Person]) {

  def Find(findByAgeType: FindByAge): PersonPair = {

    val sortedList = personList.sortWith(_.birthDate.getMillis < _.birthDate.getMillis)
    sortedList.size match {
      case 0 | 1 => new PersonPair()
      case _ => {
        findByAgeType match {
          case FinderByAgeType.Furthest => new PersonPair(sortedList.head, sortedList.last)
          case FinderByAgeType.Closest => {
            val oldest = sortedList.head;
            val secondOldest = sortedList.tail.head;
            val currentLeastDifferencePair = new PersonPair(oldest, secondOldest)
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
        val newCurrentDifferencePair = new PersonPair(older, nextOlder)
        if (newCurrentDifferencePair.AgeDifference < currentLeastDifferencePair.AgeDifference) {
          findClosestPair(newCurrentDifferencePair, remainingList.tail)
        } else {
          findClosestPair(currentLeastDifferencePair, remainingList.tail)
        }
      }
    }
  }
}


