package com.bahadirmemis.mobileactionbootcamp.springcore;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserDao userDao;




    @GetMapping
    public ResponseEntity<List<User>> getAllProducts(){


        List<User> userList = userDao.findAll();

        return ResponseEntity.ok(userList);
    }



    @PostMapping
    public ResponseEntity<User> savePorducts(@RequestBody User user){

        user = userDao.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getProductById(@PathVariable Long id){

        User myUser = userDao.findById(id).orElseThrow();
        return ResponseEntity.ok(myUser);
    }
    @PutMapping
    public ResponseEntity<User> updateProduct(@RequestBody User user){
        if(user.getId() == null){
            throw new RuntimeException("User id cannot be empty");
        }

        boolean isExist = userDao.existsById((user.getId()));
        if(!isExist){
            throw new RuntimeException("User does not exists");
        }

        user = userDao.save(user);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/passive/{id}")
    public ResponseEntity makePassive(@PathVariable Long id){
        User user = userDao.findById(id).orElseThrow();
        user.setIsActive(Boolean.FALSE);

        user = userDao.save(user);

        return ResponseEntity.ok(user);
    }
}
