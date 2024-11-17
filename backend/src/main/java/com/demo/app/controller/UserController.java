package com.demo.app.controller;

import com.demo.app.model.Document;
import com.demo.app.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private DocService docService;


    @RequestMapping(value = {"/docs"}, method = RequestMethod.GET)
    public List<Document> welcome() {
        return docService.findAllDocs(1L);
    }
}
