package views.formdata

import play.api.data._
import play.api.data.Forms._

case class InputFormData(list: String)

object InputFormData{
  val inputForm : Form[InputFormData] = Form(
    mapping(
      "sometext" -> text)
    (InputFormData.apply)(InputFormData.unapply)
  )
}