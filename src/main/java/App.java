import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("allContacts", Contact.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contacts", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String firstName = request.queryParams("firstName");
      String lastName = request.queryParams("lastName");
      String birthMonth = request.queryParams("birthMonth");
      Contact newContact = new Contact(firstName, lastName, birthMonth);

      model.put("contacts", newContact);
      model.put("allContacts", Contact.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/contacts/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));

      model.put("allPhones", contact.getPhone());
      model.put("contact", contact);
      model.put("template", "templates/info.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contacts/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      Phone phone = Phone.find(Integer.parseInt(request.params(":id")));
      ArrayList<Phone> phoneList = contact.getPhone();

      if (phoneList == null) {
        phoneList = new ArrayList<Phone>();
        request.session().attribute("phoneList", phoneList);
      }

      String number = request.queryParams("phoneNumber");
      String type = request.queryParams("phoneType");
      Phone newPhone = new Phone(number, type);

      phoneList.add(newPhone);

      model.put("allPhones", phoneList);
      model.put("contact", contact);
      model.put("template", "templates/info.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
