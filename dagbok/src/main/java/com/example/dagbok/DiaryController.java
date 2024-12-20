package com.example.dagbok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DiaryController {

    @Autowired
    private DiaryEntryRepository diaryEntryRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("entries", diaryEntryRepository.findVisibleEntries());
        return "index";
    }
}
