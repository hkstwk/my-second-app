package models

case class Duplicates(lsIn: List[Any])

object Duplicates {

 def distinct[A](ls: List[A]): List[A] = ls.distinct

}