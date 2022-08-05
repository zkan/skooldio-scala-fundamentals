class Person(var firstName: String, val lastName: String) {
    println("begin of constructor")
    println(firstName)
    val age = 0
    override def toString(): String = s"$firstName"
    println("end of constructure")
}

val kan = new Person("Kan", "Ouivirach")
print(kan.firstName) 
kan.toString

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