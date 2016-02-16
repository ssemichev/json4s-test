import org.json4s.DefaultFormats
import org.json4s.JsonDSL._


object Json4sTest extends App {

  implicit val formats = DefaultFormats

  val json = ("field1" -> "field1") ~ ("field2" -> "field2")

  val dto = json.extract[TestDto]

  assert(dto.field1 == "field1")
  assert(dto.field2 == "field2")
  assert(dto.field3 == "")
  assert(dto.field4 == null)

}

class TestDto(
    val field1: String,
    val field2: String,
    val field3: String = "",
    val field4: String = null)