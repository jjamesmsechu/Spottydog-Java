package com.vodaintern.timestamp.Entry;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    @Autowired
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }


    public List<Entry> getEntry() {
       return entryRepository.findAll();

    }
    public Optional<Entry> get1Entry(Long id){
            return entryRepository.findById(id);
    }

    public void createEntry(Entry entry) {
        entryRepository.save(entry);
    }

    public void deleteEntry(Long userId) {
        boolean exists = entryRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("No Entry With Given ID Found");
        }
        entryRepository.deleteById(userId);
    }

    @Transactional
    public void updateEntry(Long userId, LocalTime startime, LocalTime endtime, Date date) {
        Entry entry = entryRepository.findById(userId).
                orElseThrow(() ->
                new IllegalStateException("Entry Does Not Exist")
        );

        if (!(startime == null) &&
                !Objects.equals(startime,entry.getStartime())){
            entry.setStartime(startime);
        }
        if (!(endtime == null) &&
                !Objects.equals(endtime,entry.getEndtime())){
            entry.setEndtime(endtime);
        }
        if (!(date == null) &&
                !Objects.equals(date,entry.getDate())){
            entry.setDate(date);
        }


    }
}
