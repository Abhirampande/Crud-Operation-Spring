package com.exam.den.Controller;

import com.exam.den.Model.Model;
import com.exam.den.Repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Repo repo;
    //localhost:8060
    @GetMapping(value = "get")
    public List<Model> getAllModel(){
        return repo.findAll();
    }
    @GetMapping(value = "/model/{Id}")
    public Model getModel(@PathVariable Long Id){
        Model model = repo.findById(Id).get();
        return model;
    }

    //GET http://localhost:8080/users/older-than?age=18
    @GetMapping(value = "/model/older-than")
    public List<Model> getModelOlderThan(@RequestParam int age){
        return repo.findByAgeGreaterThan(age);
    }

    @PostMapping(value = "save")
    public String saveModel(@RequestBody Model model){
        repo.save(model);
        return "saved";

    }
    @PutMapping(value = "update/{Id}")
    public String updateModel(@RequestBody Model model, @PathVariable Long Id){
        Model updateModel = repo.findById(Id).get();
        updateModel.setName(model.getName());
        updateModel.setAge(model.getAge());
        repo.save(model);
        return "updated";

    }

    @DeleteMapping(value = "del/{Id}")
    public String deleteModel(@PathVariable Long Id){
        Model deleteModel= repo.findById(Id).get();
        repo.delete(deleteModel);
        return "deleted";
    }
}
