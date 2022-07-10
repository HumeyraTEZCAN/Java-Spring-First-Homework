package com.bahadirmemis.mobileactionbootcamp.springcore;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usersComments")
@RequiredArgsConstructor
public class UserCommentController {
    private final UserCommentDao userCommentDao;


    @GetMapping
    public ResponseEntity<List<UserComment>> getAllComments() {

        List<UserComment> commentList = userCommentDao.findAll();

        return ResponseEntity.ok(commentList);
    }


    @PostMapping
    public ResponseEntity<UserComment> saveComments(@RequestBody UserComment userComment) {

        userComment = userCommentDao.save(userComment);

        return new ResponseEntity<>(userComment, HttpStatus.CREATED);
    }



    @PatchMapping
    public ResponseEntity<UserComment> updateProduct(@RequestBody UserComment userComment , String newcomment) {
        if (userComment.getId() == null) {
            throw new RuntimeException("User Comment id cannot be empty");
        }

        boolean isExist = userCommentDao.existsById((userComment.getId()));
        if (!isExist) {
            throw new RuntimeException("User Comment does not exists");
        }

        userComment = userCommentDao.findById(userComment.getId()).orElseThrow();

        userComment.setComment(newcomment);

        userComment = userCommentDao.save(userComment);
        return ResponseEntity.ok(userComment);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userCommentDao.deleteById(id);

    }
}