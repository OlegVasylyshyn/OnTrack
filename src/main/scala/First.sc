import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

// 1. Given these functions:
 def f1: Future[Unit] = Future { println(1) }
 def f2: Future[Unit] = Future { println(2) }
 def f3: Future[Unit] = Future { println(3) }
 def f4: Future[Unit] = Future { println(4) }

// Write code to execute them when:

// there are no dependencies between the functions

f1 // so that we can just call these functions in different order and don't wait for results.
f2
f3
f4

// f4 depends on f3 which depends on f2 which depends on f1

for {
  result1 <- f1
  result2 <- f2 // wait for f1 use here result1
  result3 <- f3 // wait for f2 use here result2
  result4 <- f4 // wait for f3 use here result3
} yield {
  // do something with result4 .. or any other result
}

// f4 depends on f3 and f2, and f3 and f2 both depend on f1

for {
  result1 <- f1
  (r2, r3) <- {
    // run f2 and f3 in parallel
    val result2 = f2 // use result1
    val result3 = f3 // use result1
    for {
      r1 <- result2
      r2 <- result3
    } yield {
      (r1, r2)
    }
  }
  r4 <- f4
} yield {
  // do something with r4 .. or any other rX
}

