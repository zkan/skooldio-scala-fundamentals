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