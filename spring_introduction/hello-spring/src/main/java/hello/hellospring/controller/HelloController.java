package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

        @GetMapping("hello")
        public String hello(Model model) {

            model.addAttribute("data", "hello!!");
            return "hello";

        }

        @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam("name") String name, Model model) {
            model.addAttribute("name", name);
            return "hello-template";
        }


        @GetMapping("hello-string")
        @ResponseBody
        public String helloString(@RequestParam("name") String name) {
            return "hello " + name; //"hello spring"


        }


        @GetMapping("hello-api")
        @ResponseBody
        public Hello helloApi(@RequestParam("name") String name) {
            Hello hello = new Hello();
            hello.setName(name);
            return hello;

        }
        static class Hello {
            private String name;
            
            //getter, setter > Java bean 규약 
            //라이브러리같은데서 쓰거나 메소드로 접근
            //>> 프로퍼티 접근 방식이라고 함.
            
            
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    
        //05.28
        //http://localhost:9090/hello-api?name=Spring!!!!!!
        //json 방식
        //HTML과 달리 열고 닫고를 하지 않아도 됨. 심플 >> 최근에는 json 방식으로 통일됨.
        //스프링도 기본이 객체를 반환하고 Responsebody로 반환하는데 > json으로 반환하는게
        //기본으로 설정됨.
        //>> json 방식으로 사용하는게 요즘 트렌드
}
