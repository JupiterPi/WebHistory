package main.java.kaye.webhistory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import main.java.kaye.webhistory.filetool.*;

@Service
public class HistoryService {
    private List<Entry> entries = new ArrayList<>();
    private String entriesFileName = "entriesFile.txt";

    public void addEntry(String name) throws IOException {
        entries.add(new Entry(name, false));
        writeEntries();
    }

    public String getEntriesForFile() {
        String returning = "";
        for (Entry entry : entries) {
            returning = returning + entry.toStringForFile() + "\n";
        }
        return returning;
    }

    public String toString() {
        String returning = "";
        for (Entry entry : entries) {
            returning = returning + entry.toString() + "\n";
        }
        return returning;
    }

    public String toStringForBrowser() {
        String returning = "";
        for (Entry entry : entries) {
            returning = returning + entry.toString() + "<br>";
        }
        return returning;
    }

    public void readEntries() throws IOException {
        entries = new ArrayList<>();
        FileTool entriesFile = new FileTool(entriesFileName);
        for (String line : entriesFile.getFile()) {
            entries.add(new Entry (line, true));
        }
    }

    public void writeEntries() throws IOException {
        FileTool entriesFile = new FileTool(entriesFileName);
        List<String> file = new ArrayList<>();
        for (Entry entry : entries) {
            file.add(entry.toStringForFile());
        }
        entriesFile.setFile(file);
        entriesFile.saveFile();
    }
}
