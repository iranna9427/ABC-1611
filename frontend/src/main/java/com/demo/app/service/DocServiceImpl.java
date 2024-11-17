package com.demo.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.app.model.Document;
import org.springframework.web.client.RestTemplate;

@Service
public class DocServiceImpl implements DocService {


    @Value("${api.host.baseurl}")
    private String apiHost;

    @Override
    public List<Document> findAllDocs(Long id) {

        RestTemplate template = new RestTemplate();
        List<Document> docs = new ArrayList<>();
        try {
            ResponseEntity<List> ret = template.getForEntity(apiHost+"/docs", List.class, id);
            boolean success = ret.getStatusCode().value() == 200;
            if(success){
                docs.addAll(ret.getBody());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        return docs;
    }


}
