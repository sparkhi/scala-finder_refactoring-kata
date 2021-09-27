package tv.codely.finderKata.algorithm

import com.github.nscala_time.time.Imports._
import org.scalatest._
import org.scalatest.Matchers._

final class FinderTest extends WordSpec with BeforeAndAfterEach {

  "Finder" should {
    "Return empty results when given empty list" in {
      val finder = new Finder(List.empty)

      val result = finder.Find(FinderByAgeType.Closest)

      result.Old shouldBe null
      result.Young shouldBe null
    }

    "Return empty results when given one person" in {
      val sue: Person = new Person("Sue", DateTime.parse("1950-01-01"))
      val list = List(sue)

      val finder = new Finder(list)

      val result = finder.Find(FinderByAgeType.Closest)

      result.Old shouldBe null
      result.Young shouldBe null
    }

    "Return closest two for two people" in {
      val sue: Person = new Person("Sue", DateTime.parse("1950-01-01"))
      val greg: Person = new Person("Greg", DateTime.parse("1952-05-01"))
      val list = List(sue, greg)

      val finder = new Finder(list)

      val result = finder.Find(FinderByAgeType.Closest)

      result.Old shouldBe sue
      result.Young shouldBe greg
    }

    "Return furthest two for two people" in {
      val greg: Person = new Person("Greg", DateTime.parse("1952-05-01"))
      val mike: Person = new Person("Mike", DateTime.parse("1979-01-01"))
      val list = List(mike, greg)

      val finder = new Finder(list)

      val result = finder.Find(FinderByAgeType.Furthest)

      result.Old shouldBe greg
      result.Young shouldBe mike
    }

    "Return furthest two for four people" in {
      val sue: Person = new Person("Sue", DateTime.parse("1950-01-01"))
      val greg: Person = new Person("Greg", DateTime.parse("1952-05-01"))
      val sarah: Person = new Person("Sarah", DateTime.parse("1982-01-01"))
      val mike: Person = new Person("Mike", DateTime.parse("1979-01-01"))
      val list = List(sue, sarah, mike, greg)

      val finder = new Finder(list)

      val result = finder.Find(FinderByAgeType.Furthest)

      result.Old shouldBe sue
      result.Young shouldBe sarah
    }

    "Return closest two for four people" in {
      val sue: Person = new Person("Sue", DateTime.parse("1950-01-01"))
      val greg: Person = new Person("Greg", DateTime.parse("1952-05-01"))
      val sarah: Person = new Person("Sarah", DateTime.parse("1982-01-01"))
      val mike: Person = new Person("Mike", DateTime.parse("1979-01-01"))
      val list = List(sue, sarah, mike, greg)

      val finder = new Finder(list)

      val result = finder.Find(FinderByAgeType.Closest)


      result.Old shouldBe sue
      result.Young shouldBe greg
    }
  }
}

