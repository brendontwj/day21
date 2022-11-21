package vttp2022.day21.day21.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.day21.day21.models.Book;
import vttp2022.day21.day21.models.Query;
import vttp2022.day21.day21.repositories.BookRepository;

@Controller
@RequestMapping(path = "database")
public class BookController {
    
    @Autowired
    BookRepository bookRepo;

    @GetMapping
    public String showQueryPage(Model model) {
        model.addAttribute("query", new Query());
        return "index";
    }

    @PostMapping("queryInput")
    public String showResultsPage(@ModelAttribute Query query, Model model) {
        String name = query.getName();
        int limit = query.getLimit();
        name = '%' + name + '%';

        List<Book> books = bookRepo.getBooksByNameAndLimit(name,limit);

        model.addAttribute("bookList", books);

        return "results";
    }
}
