package tv.codely.finderKata.algorithm

class PersonPair (val Old: Option[Person], val Young: Option[Person], val AgeDifference: Long ) {

  def this() = this(Option.empty, Option.empty, 0)
  def this (old: Option[Person], young: Option[Person]) =
    this (old, young, young.get.birthDate.getMillis - old.get.birthDate.getMillis)
}
