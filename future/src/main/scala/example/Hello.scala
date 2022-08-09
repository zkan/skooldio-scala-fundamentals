package example

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

// object Hello extends Greeting with App {
//   println(greeting)
// }

// trait Greeting {
//   lazy val greeting: String = "hello"
// }

object MainFuture extends App {
  val startTime = currentTime

  def currentTime = System.currentTimeMillis()
  def deltaTime(t0: Long) = currentTime - t0

  def bakePizza(): Future[String] = Future {
    Thread.sleep(3000)
    "Pizza"
  }

  def makePasta(): Future[String] = Future {
    Thread.sleep(2000)
    "Pasta"
  }
  
  def makeDrink(): Future[String] = Future {
    Thread.sleep(1000)
    "Drink"
  }

  // val pizza = bakePizza()
  // val pasta = makePasta()
  // val drink = makeDrink()

  // bakePizza().onComplete {
  //   case Success(value)     => println(s"Pizza is ready")
  //   case Failure(exception) => println(s"Pizza is not ready")
  // }
  // makePasta().onComplete {
  //   case Success(value)     => println(s"Pasta is ready")
  //   case Failure(exception) => println(s"Pasta is not ready")
  // }

  val mainCourse = for {
    pizza <- bakePizza()
    pasta <- makePasta()
  } yield (pizza, pasta)

  mainCourse.onComplete {
    case Success(value)     => println(s"Main course is ready $value")
    case Failure(exception) => println(s"Main course is not ready")
  }

  makeDrink().onComplete {
    case Success(value)     => println(s"Drink is ready")
    case Failure(exception) => println(s"Drink is not ready")
  }

  // Tell main thread to wait
  // Thread.sleep(3200)
  // println(s"$pizza $pasta $drink")

  val totalTime = deltaTime(startTime)
  println(s"Total time is $totalTime")
}