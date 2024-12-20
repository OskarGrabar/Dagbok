package com.example.dagbok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public String saveEntry(@ModelAttribute DiaryEntry diaryEntry) {
        diaryEntryRepository.save(diaryEntry);
        return "redirect:/";
    }

    @GetMapping("/edit-entry")
    public String editEntryForm(@RequestParam int id, Model model) {
        DiaryEntry entry = diaryEntryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid entry ID:" + id));
        model.addAttribute("entry", entry);
        return "edit-entry";
    }

    @PostMapping("/update-entry")
    public String updateEntry(@ModelAttribute DiaryEntry diaryEntry) {
        diaryEntryRepository.save(diaryEntry);
        return "redirect:/";
    }

    @GetMapping("/delete-entry")
    public String deleteEntry(@RequestParam int id) {
        diaryEntryRepository.deleteById(id);
        return "redirect:/";
    }
}
