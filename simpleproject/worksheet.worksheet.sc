// class Person(var firstName: String, val lastName: String) {
//     println("begin of constructor")
//     println(firstName)
//     val age = 0
//     override def toString(): String = s"$firstName"
//     println("end of constructure")
// }

// val kan = new Person("Kan", "Ouivirach")
// print(kan.firstName)
// kan.toString

class ScalaClass(value: String) {
  def oneParameter(x: String) = x
  def >>(some: String) = s">> $some"
  def ->:(none: String) = s"-> $none"
}

val sc = new ScalaClass("Something")
sc.oneParameter("Skooldio")
sc oneParameter "Skooldio"

sc.>>("Skooldio")
sc >> "Skooldio"

sc.->:("Skooldio")
"Skooldio" ->: sc

object Logger {
  def printSomething(message: String) = println(s"Message: $message")
}

class Project(name: String, dateToFinish: Int) {}

class Test {
  import Logger._
  val project1 = new Project("a", 5)
  val project2 = new Project("b", 3)
  printSomething("2 projects created")
}

val test = new Test

// class Person {
//     var name: String = ""
//     var age: Int = 0
//     def accessPrivateInformation() = println(Person.privateFilename)
// }

// object Person {
//     def apply(name: String, age: Int) = {
//         var p = new Person
//         p.name = name
//         p.age = age
//         p
//     }

//     def apply(name: String) = {
//         var p = new Person
//         p.name = name
//         p
//     }

//     private val privateFilename = "/usr/save/private"
// }

// val person = new Person
// person.accessPrivateInformation()

// val p1 = Person("kan", 38)
// val p2 = Person("skooldio")
// p1.name
// p1.age
// p2.name
// p2.age

// val p3 = Person("skooldio")

// p2 == p3

case class Person(name: String, age: Int) {}

val p1 = Person("kan", 38)
val p2 = Person("kan", 38)
p1 == p2
p1.toString

// class Task(var id: Int, var title: String, var state: Int = 1) {
//   def next() = { if (state == 3) 3 else state += 1 }
// }

// val buyBanana = new Task(id = 0, title = "Buy Banana", state = 1)
// buyBanana.next()
// buyBanana.state
// buyBanana.next()
// buyBanana.state
// buyBanana.next()
// buyBanana.state

// class Task {
//   var id: Int = 0
//   var title: String = ""
//   var state: Int = 1
//   def next() = { if (state == 3) 3 else state += 1 }
// }

// object Task {
//   def apply(id: Int, title: String, state: Int) = {
//     var t = new Task
//     t.id = id
//     t.title = title
//     t.state = state
//     t
//   }

//   def apply(id: Int, title: String) = {
//     var t = new Task
//     t.id = id
//     t.title = title
//     t
//   }
// }

// val buyBanana = Task(id = 0, title = "Buy Banana", state = 1)

object States extends scala.Enumeration {
  type State = Value
  var Todo, Doing, Done = Value
}

case class Task(id: Int, title: String, var state: States.State) {
  import States._
  def next(): Task = {
    if (state == Todo) copy(state = Doing)
    else if (state == Doing) copy(state = Done)
    else this
  }
}

val buyBanana = Task(id = 0, title = "Buy Banana", state = States.Todo)
buyBanana.next()
buyBanana.state
buyBanana.next()
buyBanana.state
buyBanana.next()
buyBanana.state

val buyingBanana = buyBanana.next()
buyingBanana
val doneBanana = buyingBanana.next()
doneBanana
