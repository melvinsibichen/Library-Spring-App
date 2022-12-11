package com.example.com.nest.LibraryApp.controller;

import com.example.com.nest.LibraryApp.dao.BookDao;
//import com.nest.LibraryApp.dao.IssueDao;
import com.example.com.nest.LibraryApp.dao.UserDao;
import com.example.com.nest.LibraryApp.model.BooksModel;
//import com.nest.LibraryApp.model.IssueModel;
import com.example.com.nest.LibraryApp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    private UserDao udao;
    @Autowired
    private BookDao bdao;
    //@Autowired
    //private IssueDao idao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public String AdminLogin(@RequestBody UserModel um){
        return "Welcome to Library App";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userLogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody UserModel um){
        List<UserModel> result = (List<UserModel>) udao.GetLoginCreds(um.getUsername(),um.getPassword());
        HashMap<String, String> st = new HashMap<>();
        if(result.size()==0){
            st.put("status","failed");
            st.put("message","User Credential Error");

        }else{
            st.put("status","success");
            st.put("message","user login success");
            st.put("userId",String.valueOf(result.get(0).getId()));
            st.put("email",String.valueOf(result.get(0).getEmail()));
            st.put("name",String.valueOf(result.get(0).getName()));
        }
        return st;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userRegistration", consumes = "application/json", produces = "application/json")
    public  HashMap<String, String> UserRegistration(@RequestBody UserModel um){
        List<UserModel> result = (List<UserModel>) udao.FindUserLogin(um.getUsername());
        udao.save(um);
        HashMap<String, String> hm = new HashMap<>();
        if(result.size()!=0){
            hm.put("status","success");
            hm.put("message","user already exists");
        }else{
            udao.save(um);
            hm.put("status","success");
            hm.put("message","user added successfully");
        }
        return hm;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addBook", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> AddBook(@RequestBody BooksModel bm){
        bdao.save(bm);
        HashMap<String, String> st = new HashMap<>();
        st.put("status","success");
        st.put("message","Book added successfully");
        return st;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/editBook", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> EditBook(@RequestBody BooksModel bm){
        bdao.EditBook(bm.getId(),bm.getTitle(),bm.getDescription(),bm.getImage(),bm.getPrice(), bm.getReleasedyear(),bm.getAuthor());
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/getBookById", consumes = "application/json", produces = "application/json")
    public List<BooksModel> GetBookById(@RequestBody BooksModel bm){
        return (List<BooksModel>) bdao.GetBookById(bm.getId());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteBook", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> DeleteBook(@RequestBody BooksModel bm){
        String id = String.valueOf(bm.getId());
        bdao.DeleteBook(bm.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/issueBook", consumes = "application/json", produces = "application/json")
//    public HashMap<String, String> IssueBook(@RequestBody IssueModel im){
//        idao.save(im);
//        HashMap<String, String> map = new HashMap<>();
//        map.put("status","success");
//        return map;
//    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchBook", consumes = "application/json", produces = "application/json")
    public List<BooksModel> SearchBook(@RequestBody BooksModel bm){
        return (List<BooksModel>) bdao.SearchBook(bm.getTitle());
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/viewBook")
    public List<BooksModel> ViewBook(){
        List<BooksModel> result = (List<BooksModel>) bdao.findAll();
        return result;
    }

//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/getUserIssue", consumes = "application/json", produces = "application/json")
//    public List<IssueModel> GetUserIssues(@RequestBody IssueModel im){
//        List<IssueModel> result = (List<IssueModel>) idao.GetUserIssues(im.getUserId());
//
//        return result;
//    }

//    @CrossOrigin(origins = "*")
//    @GetMapping("/getBookIssue")
//    public List<IssueModel> GetBookIssues(){
//        List<IssueModel> result = (List<IssueModel>) idao.findAll();
//        return result;
//    }


}