package ru.neoflex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.practice.database.DatabaseRes;
import ru.neoflex.practice.repository.RepositoryRes;

import java.util.List;

@RestController
public class CalcController {

    @Autowired
    public RepositoryRes repositoryRes;

    @GetMapping("/plus/{a}/{b}")
    public Integer sum(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        repositoryRes.save(new DatabaseRes(a, "+", b, a + b));
        return a + b;
    }

    @GetMapping("/minus/{a}/{b}")
    public Integer min(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        repositoryRes.save(new DatabaseRes(a, "-", b, a - b));
        return a - b;
    }

    @GetMapping("/TableAll")
    public List<DatabaseRes> getAllRes() {
        return repositoryRes.findAllRes();
    }
}
