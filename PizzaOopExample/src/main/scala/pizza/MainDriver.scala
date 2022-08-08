package pizza

import scala.collection.mutable.ArrayBuffer

object MainDriver extends App {

    val p1 = new Pizza (
        MediumCrustSize,
        ThinCrustType,
        List(Cheese)
    )

    // val p2 = new Pizza (
    //     LargeCrustSize,
    //     ThinCrustType,
    //     ArrayBuffer(Cheese, Pepperoni, Sausage)
    // )

    val address = Address (
        "123 Main Street",
        "Apt. 1",
        "Talkeetna",
        "Alaska",
        "99676"
    )

    val customer = Customer (
        "Alvin Alexander",
        "907-555-1212",
        address
    )

    val o = new Order(
        // ArrayBuffer(p1, p2),
        ArrayBuffer(p1),
        customer
    )

    // o.addPizza(
    //     new Pizza (
    //         SmallCrustSize,
    //         ThinCrustType,
    //         ArrayBuffer(Cheese, Mushrooms)
    //     )
    // )

    // print the order
    o.printOrder

}



