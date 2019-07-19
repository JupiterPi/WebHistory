package main.java.kaye.webhistory;

import main.java.kaye.webhistory.filetool.CreatedNewFileException;
import main.java.kaye.webhistory.filetool.EmptyFileException;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@RequestMapping(path="")
@RestController
public class Controller {
    @Autowired HistoryService service;

    @PostMapping("/register/{name}")
    public void registerEntry(@PathVariable String name) throws IOException {
        service.addEntry(name);
    }

    @GetMapping("/get")
    public String get() throws IOException {
        service.readEntries();
        return service.toString();
    }

    @GetMapping("/getforbrowser")
    public String getForBrowser() throws IOException {
        service.readEntries();
        return service.toStringForBrowser();
    }
}
