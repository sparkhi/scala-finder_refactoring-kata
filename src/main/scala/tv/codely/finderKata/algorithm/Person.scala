package tv.codely.finderKata.algorithm

import com.github.nscala_time.time.Imports._

class Person (val name: String, val birthDate: DateTime) {
  def getName(): String = name
  def getBirthDate(): DateTime = birthDate
}
