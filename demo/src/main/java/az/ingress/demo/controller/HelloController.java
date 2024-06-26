package az.ingress.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name,
                        @RequestHeader(value = "Accept-Language", required = false) String lang){
        return switch(lang){
            case "az" -> "Salam " + name;
            case "ru" -> "Privet " + name;
            case "en" -> "Hello " + name;
            default -> "Hello";
        };
    }

    @PostMapping("/create")
    public void create(@RequestBody Student student){
        System.out.println("Student created " + student);
    }

    @PutMapping("/update")
    public void update(){
        System.out.println("Student updated.");
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Integer id){
        System.out.println("Student with id " + id + " deleted.");
    }
}
