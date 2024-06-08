package com.manasvi.Journal.App.service;

import com.manasvi.Journal.App.entity.JournalEntry;
import com.manasvi.Journal.App.entity.Users;
import com.manasvi.Journal.App.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JornalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry myentry, String userName) {
        Users user1 = userService.findByusername(userName);
        JournalEntry saved = journalEntryRepository.save(myentry);
        user1.getJournalEntries().add(saved);
        userService.saveEntry(user1);
    }

    @Transactional
    public void saveEntry(JournalEntry myentry) {
        journalEntryRepository.save(myentry);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getByID(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deletebyId(ObjectId id, String userName) {
        try {
            Users user1 = userService.findByusername(userName);
            Optional<JournalEntry> journalEntry = journalEntryRepository.findById(id);
            if (journalEntry.isPresent() && user1.getJournalEntries().contains(journalEntry.get())) {
                user1.getJournalEntries().remove(journalEntry.get());
                userService.saveEntry(user1);
                journalEntryRepository.deleteById(id);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry.", e);
        }
        return false;
    }
}
