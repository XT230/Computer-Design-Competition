package com.neuq.campus.Controller;

import com.neuq.campus.Model.School;
import com.neuq.campus.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController
{
    @Autowired
    SchoolRepository schoolRepository;

    @GetMapping("/getSnameBySid")
    @ResponseBody
    public School getSnameBySid(@RequestParam int sid)
    {
        return schoolRepository.getBySid(sid);
    }

    @GetMapping("/getAllSchools")
    @ResponseBody
    public List<School> getAllSchools()
    {
        return schoolRepository.findAll();
    }

}
