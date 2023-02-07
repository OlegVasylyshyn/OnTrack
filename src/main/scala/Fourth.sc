// 4. Explain what the following code means:
// Mention some advantages of the above code.

// BTW in Scala 3 the syntax of wildcard arguments in types has changed from _ to ? ref: https://docs.scala-lang.org/scala3/reference/changed-features/wildcards.html

trait MyAlg[F[_]] {
  def insertItSomewhere(someInt: Int): F[Unit]
  def doSomething(someInt: Int): F[Int]
}

// wildcard _ brings flexibility for returned type constructor of F. So that we can return F[Unit] or F[Int].
