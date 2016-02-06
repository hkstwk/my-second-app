package controllers

import models.Duplicates
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import views.formdata.InputFormData
import views.formdata.InputFormData.inputForm

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def foo = Action { implicit request =>
    val inputFormData : Form[InputFormData] = InputFormData.inputForm
    Ok(views.html.foo(Duplicates.distinct(List()))("Play for scala")(inputFormData))
  }

  val listForm : Form[InputFormData] = Form {
    mapping(
      "sometext" -> text
    )(InputFormData.apply)(InputFormData.unapply)
  }

  def postInput = Action { implicit request =>
    val inputFormData = InputFormData.inputForm.bindFromRequest()
    val inputForm = inputFormData.get
    val list = inputForm.list.toList
    Ok(views.html.foo(Duplicates.duplicates(list))("Play for scala")(inputFormData))
  }

}
