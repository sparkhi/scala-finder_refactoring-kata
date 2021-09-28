package tv.codely.finderKata.algorithm

import com.github.nscala_time.time.Imports._
import org.scalatest._
import org.scalatest.Matchers._

final class FinderTest extends WordSpec with BeforeAndAfterEach {

  "Finder" should {
    "Return empty results when given empty list" in {
      val finder = new Finder(List.empty)

      val result = finder.Find(CLOSEST)

      result.Old shouldBe empty
      result.Young shouldBe empty
    }

    "Return empty results when given one person" in {
      val sue: Person = Person("Sue", DateTime.parse("1950-01-01"))
      val list = List(sue)

      val finder = new Finder(list)

      val result = finder.Find(CLOSEST)

      result.Old shouldBe empty
      result.Young shouldBe empty
    }

    "Return closest two for two people" in {
      val sue: Person = Person("Sue", DateTime.parse("1950-01-01"))
      val greg: Person = Person("Greg", DateTime.parse("1952-05-01"))
      val list = List(sue, greg)

      val finder = new Finder(list)

      val result = finder.Find(CLOSEST)

      result.Old.get shouldBe sue
      result.Young.get shouldBe greg
    }

    "Return furthest two for two people" in {
      val greg: Person = Person("Greg", DateTime.parse("1952-05-01"))
      val mike: Person = Person("Mike", DateTime.parse("1979-01-01"))
      val list = List(mike, greg)

      val finder = new Finder(list)

      val result = finder.Find(FURTHEST)

      result.Old.get shouldBe greg
      result.Young.get shouldBe mike
    }

    "Return furthest two for four people" in {
      val sue: Person = Person("Sue", DateTime.parse("1950-01-01"))
      val greg: Person = Person("Greg", DateTime.parse("1952-05-01"))
      val sarah: Person = Person("Sarah", DateTime.parse("1982-01-01"))
      val mike: Person = Person("Mike", DateTime.parse("1979-01-01"))
      val list = List(sue, sarah, mike, greg)

      val finder = new Finder(list)

      val result = finder.Find(FURTHEST)

      result.Old.get shouldBe sue
      result.Young.get shouldBe sarah
    }

    "Return closest two for four people" in {
      val sue: Person = Person("Sue", DateTime.parse("1950-01-01"))
      val greg: Person = Person("Greg", DateTime.parse("1952-05-01"))
      val sarah: Person = Person("Sarah", DateTime.parse("1982-01-01"))
      val mike: Person = Person("Mike", DateTime.parse("1979-01-01"))
      val list = List(sue, sarah, mike, greg)

      val finder = new Finder(list)

      val result = finder.Find(CLOSEST)


      result.Old.get shouldBe sue
      result.Young.get shouldBe greg
    }
  }
}

