package tv.codely.finderKata.algorithm

sealed trait FinderByAgeType {def name: String}
case object CLOSEST extends FinderByAgeType {val name = "CLOSEST"}
case object FURTHEST extends FinderByAgeType {val name = "FURTHEST"}
