package com.example.demo.Controller;
import com.example.demo.Entity.Jtable;
import com.example.demo.Repo.HelloRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private final HelloRepository helloRepository;

    public HelloController(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @GetMapping("/hello")
    @CrossOrigin(origins = "*")
    public String sayHello() {
        // Just return the first entity’s message, or fallback
//        return helloRepository.findById(1L)
//                .map(HelloEntity::getMessage)
//                .orElse("Hello");
        return "Hello";
    }
    @GetMapping("/all")
    public List<Jtable> getAllMessages() {
        return helloRepository.findAll();
    }
    @PostMapping("/add")
    public Jtable addData(@RequestBody Jtable jtable){
//        console.log(req.body);
        return helloRepository.save(jtable);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteData(@PathVariable Long id){
        if(helloRepository.existsById(id)){
            helloRepository.deleteById(id);
            return "Deleted";
        }else{
            return "Data with given id dont exist";
        }
    }

    @PutMapping("/update/{id}")
    public Jtable updateEntry(@PathVariable Long id, @RequestBody Jtable updated) {
        return helloRepository.findById(id)
                .map(existing -> {
                    existing.setSname(updated.getSname());
                    existing.setLocation(updated.getLocation());
                    return helloRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Entry not found with id " + id));
    }
}
