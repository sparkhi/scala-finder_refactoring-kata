package tv.codely.finderKata.algorithm

import java.util.ArrayList

import scala.collection.JavaConverters._

import tv.codely.finderKata.algorithm.FinderByAgeType.FindByAge

class Finder(private val personList: List[Person]) {

  def Find(findByAgeType: FindByAge): PersonPair = {

    val sortedList = personList.sortWith(_.birthDate.getMillis < _.birthDate.getMillis)
    val personPairList = new ArrayList[PersonPair]()

    for (i <- 0 until sortedList.size - 1; j <- i + 1 until sortedList.size) {
      val r: PersonPair = new PersonPair()

      if (sortedList(i).birthDate.getMillis < sortedList(j).birthDate.getMillis) {
        r.Young = sortedList(i)
        r.Old = sortedList(j)
      } else {
        r.Young = sortedList(j)
        r.Old = sortedList(i)
      }

      r.AgeDifference = r.Old.birthDate.getMillis - r.Young.birthDate.getMillis
      personPairList.add(r)
    }

    if (personPairList.size < 1) {
      return new PersonPair()
    }

    var answer: PersonPair = personPairList.get(0)

    for (result: PersonPair <- personPairList.asScala) findByAgeType match {
      case FinderByAgeType.Closest => if (result.AgeDifference < answer.AgeDifference) {
        answer = result
      }
      case FinderByAgeType.Furthest => if (result.AgeDifference > answer.AgeDifference) {
        answer = result
      }
    }

    answer
  }
}
