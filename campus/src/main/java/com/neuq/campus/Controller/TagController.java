package com.neuq.campus.Controller;

import com.neuq.campus.Model.Tag;
import com.neuq.campus.Repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController
{
    @Autowired
    TagRepository tagRepository;

    @GetMapping("/getAllTags")
    public List<Tag> getAllTags()
    {
        return tagRepository.findAll();
    }
}
