//package com.manasvi.Journal.App.controller;
//
//import com.manasvi.Journal.App.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/journal")
//public class journalEntryController {
//
//    private Map<Long , JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myentry){
//        journalEntries.put(myentry.getId(), myentry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getById(@PathVariable Long myId){
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public JournalEntry delById(@PathVariable Long myId){
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("id/{myId}")
//    public JournalEntry updateById(@PathVariable Long myId , @RequestBody JournalEntry myentry){
//        return journalEntries.put(myId , myentry);
//    }
//}
