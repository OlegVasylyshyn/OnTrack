// 3. Given a list Seq(1, 2, 3)

/*
which represents the number 123, write a function to increment it by one (without converting to an INT and adding 1).
Your function should produce the expected result for the following test cases:

Nil => Nil
Seq(0) => Seq(1)
Seq(1, 2, 3) => Seq(1, 2, 4)
Seq(9, 9, 9) => Seq(1, 0, 0, 0)

*/

def increment(ints: Seq[Int]): Seq[Int] =

  def incrementLastElement: Seq[Int] =
    if ints.isEmpty then ints
    else
      ints.updated(ints.size - 1, ints.last + 1)

  val (left, incremented) = incrementLastElement.foldRight((0, List.empty[Int])) {
    case (current, (left, acc)) =>
      val sum = left + current
      if sum > 9 then
        val newLeft = sum - 9
        val newCurrent = sum % 10
        (newLeft, newCurrent :: acc)
      else
        (0, sum :: acc)
  }
  if left > 0 then left :: incremented
  else incremented

println(increment(Nil))
println(increment(Seq(0)))
println(increment(Seq(1, 2, 3)))
println(increment(Seq(9, 9, 9)))
