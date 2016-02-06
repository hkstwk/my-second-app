package models

case class Duplicates(lsIn: List[Any])

object Duplicates {

 def distinct[A](ls: List[A]): List[A] = ls.distinct

 def duplicates[A](ls: List[A]) : List[A] = ls match {
  case Nil => Nil
  case head :: tail => head :: duplicates(tail dropWhile { x => x == head } )
 }

}