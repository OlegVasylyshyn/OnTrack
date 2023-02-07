// 2. Given two functions f1 and f2, implement f3 by composing f1 and f2

val f1: (Int, Int) => Int = (a, b) => a + b
val f2: Int => String = _.toString
val f3: (Int, Int) => String = (a, b) => f2(f1(a, b))

val result: String = f3(5, 10)
println(result)
