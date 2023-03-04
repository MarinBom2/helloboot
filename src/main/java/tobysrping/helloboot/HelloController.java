package tobysrping.helloboot;

import java.util.Objects;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//dispathcher servlet 이 class 레벨에서 먼저 찾고
//method 레벨에서 그다음으로 찾는다.
//@RestController // dispathcherservlet 은 restcontroller 가 붙으면 모두 responseBody 로 return 한다.

@RestController
public class HelloController {

  private final HelloService helloService;
  private final ApplicationContext applicationContext;

  public HelloController(HelloService helloService, ApplicationContext applicationContext) {
    this.helloService = helloService;
    this.applicationContext = applicationContext;
    System.out.println(applicationContext);
  }

  @GetMapping("/hello")
  public String hello(String name){
    //가장처음에 디스패처 서블릿 404 에러
    //view 를 return 해줘라 . dispathcher servlet
    //그대로 웹 응답 body 에 넣어서 동작하게 하려면 ?
    return helloService.sayHello(Objects.requireNonNull(name));
  }

}
