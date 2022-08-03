import scalaj.http.{Http, HttpResponse}
import scala.xml.{XML, Elem, NodeSeq}

// object MyMain {
//   def main(params: Array[String]) = {
//     println("Hello World")
//   }
// }

object MyMain extends App {
    println("Hello World")

    val response: HttpResponse[String] = Http(
        "http://feeds.bbci.co.uk/news/rss.xml"
    ).asString
    // println(response)

    val xml: Elem = XML.loadString(response.body)
    // println(xml)

    // val titles: NodeSeq = xml.\\("item").\("title")
    val titles: NodeSeq = xml \\  "item" \ "title"
    // println(titles)

    val titleTexts: Seq[String] = for { title <- titles } yield title.text
    // titleTexts.foreach(titleText => println(titleText))
    titleTexts.foreach(println)
}