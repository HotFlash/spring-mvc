package ru.gb.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.gb.model.Student;

import java.util.List;

@Controller
public class GreetingsController {

  // [GET, POST, PUT, DELETE], PATCH, HEAD, ...

  @GetMapping("/hello")
//  @RequestMapping(value = "/1", method = RequestMethod.GET)
  @ResponseBody
  public String helloWorld(@RequestParam String name) {
    return "Hello, " + name + "!";
  }

  @GetMapping("/home")
  public String home(@RequestParam(required = false) String name, Model model) {
    if (name != null) {
      model.addAttribute("name", name);
    } else{
      model.addAttribute("name", "Java");
    }

    return "home";
  }

  // GET http://localhost:8180/app/hello?name=Igor
  // [GET, POST, PUT, ... ] -> DispatcherServlet -> Ищет нужный контроллер -> Отдает ответ клиенту



}
