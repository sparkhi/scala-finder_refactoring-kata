package tv.codely.finderKata.algorithm

class PersonPair (val Old: Person, val Young: Person, val AgeDifference: Long ) {

  def this() = this(null, null, 0)
  def this (old: Person, young: Person) = this (old, young, young.birthDate.getMillis - old.birthDate.getMillis)
}
