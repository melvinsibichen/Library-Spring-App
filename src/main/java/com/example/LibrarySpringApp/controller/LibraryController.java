package com.nest.LibraryApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @PostMapping("/")
    public String AdminLogin(){
        return "Welcome to admin Login";
    }

    @PostMapping("/userLogin")
    public String UserLogin(){
        return "Welcome to User Login";
    }

    @PostMapping("/userRegistration")
    public String UserRegistration(){
        return "Welcome to User Registration";
    }

    @PostMapping("/addBook")
    public String AddBook(){
        return "Welcome to Add Book";
    }

    @PostMapping("/editBook")
    public String EditBook(){
        return "Welcome to Edit Book";
    }

    @PostMapping("/deleteBook")
    public String DeleteBook(){
        return "Welcome to Delete Book";
    }

    @PostMapping("/issueBook")
    public String IssueBook(){
        return "Welcome to Issue Book";
    }

    @PostMapping("/searchBook")
    public String SearchBook(){
        return "Welcome to Search Book";
    }

    @GetMapping("/viewBook")
    public String ViewBook(){
        return "Welcome to View Book";
    }

}