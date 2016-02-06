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
    Ok(views.html.foo(Duplicates.distinct(List(1,2,2,3,3,3,4,4,4,4,5,5,5,5,5)))("Hello foo with bootstrap")(inputFormData))
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
    Ok(views.html.foo(Duplicates.distinct(list))("Hello foo with bootstrap")(inputFormData))
    //Ok(views.html.foo(Duplicates.distinct(List('a,'a,'b,'b','c,'c)))("Hello foo with bootstrap")(inputFormData))
  }

}
