package stringliteraltypes213

case class Money[Currency <: String](value: BigDecimal)

trait Monoid[T] {

  val id: T
  def combine(a: T, b: T): T
}

object Monoid {

  implicit def moneyMonoid[A <: String]: Monoid[Money[A]] = new Monoid[Money[A]] {
    override val id: Money[A] = Money[A](0)
    override def combine(a:  Money[A], b:  Money[A]): Money[A] =
      Money[A](a.value + b.value)
  }
}

object Main {
  def sum[T: Monoid](a: T, b: T): T = implicitly[Monoid[T]].combine(a, b)

  val m1 = Money["GBP"](100)
  val m2 = Money["USD"](200)
  val m3 = Money["GBP"](300)

  sum(m1, m3)
  // sum(m1, m2) // wont compile
}