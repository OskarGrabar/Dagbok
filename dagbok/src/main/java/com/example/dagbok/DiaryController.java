package com.example.dagbok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiaryController {

    @Autowired
    private DiaryEntryRepository diaryEntryRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("entries", diaryEntryRepository.findVisibleEntries());
        return "index";
    }
    @GetMapping("/new-entry")
public String newEntryForm(Model model) {
    model.addAttribute("entry", new DiaryEntry());
    return "new-entry";
}

@PostMapping("/save-entry")
public String saveEntry(DiaryEntry diaryEntry) {
    diaryEntryRepository.save(diaryEntry);
    return "redirect:/";
}
}
