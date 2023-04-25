package com.neuq.campus.Controller;

import com.neuq.campus.Model.Degree;
import com.neuq.campus.Model.School;
import com.neuq.campus.Model.User;
import com.neuq.campus.Repository.DegreeRepository;
import com.neuq.campus.Repository.SchoolRepository;
import com.neuq.campus.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    DegreeRepository degreeRepository;

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @PostMapping("/login")
    @ResponseBody
    public User userLogin(@RequestBody User user)
    {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @PostMapping("/update")
    @ResponseBody
    public User userUpdate(@RequestBody User user)
    {
        System.out.println(user.get_id().toHexString());
        user.set_id(new ObjectId(user.get_id().toHexString()));
        return userRepository.save(user);
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public User registerUser(@RequestBody User user)
    {
        if(userRepository.countByUsername(user.getUsername()) == 0)
        {
            user.setUid(user.getUsername().hashCode());
            user.setFirst(true);
            user.setTimestamp(System.currentTimeMillis());
            return userRepository.save(user);
        }
        else return user;
    }

    @GetMapping("/getSnameBySid")
    @ResponseBody
    public School getSnameBySid(@RequestParam int sid)
    {
        return schoolRepository.getBySid(sid);
    }

    @GetMapping("/getDnameByDid")
    @ResponseBody
    public Degree getDnameByDid(@RequestParam int did)
    {
        return degreeRepository.getByDid(did);
    }

    @GetMapping("getUserByUid")
    public User getUserByUid(@PathParam("uid") int uid)
    {
        return userRepository.findUserByUid(uid);
    }
}
