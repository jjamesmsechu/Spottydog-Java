package com.vodaintern.timestamp.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(path = "api/entry")
public class EntryController {


    private final EntryService entryService;

    @Autowired
    public EntryController(EntryService entryService){
        this.entryService = entryService;
    }


    @GetMapping
    public ResponseEntity<List<Entry>> getEntry(){
        return ResponseEntity.ok().body(entryService.getEntry());
    };
    @PostMapping
    public void createEntry(@RequestBody Entry entry){
        entryService.createEntry(entry);

    }

    @DeleteMapping(path = "{userId}")
    public void deleteEntry(@PathVariable("userId") Long userId){
        entryService.deleteEntry(userId);
    }

    @PutMapping(path = "{userId}")
    public void putEntry(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) LocalTime startime,
            @RequestParam(required = false) LocalTime endtime,
            @RequestParam(required = false) Date date
    ){
        entryService.updateEntry(userId,startime,endtime,date);
    }
}
