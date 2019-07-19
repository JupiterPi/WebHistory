package main.java.kaye.webhistory;

import java.util.Date;

public class Entry {
    private String name;
    private Date timestamp;

    public Entry(String string, boolean fromLine) {
        if (fromLine) {
            String[] fields = string.split(";");
            name = fields[0];

            String[] subfields = fields[1].split(":");
            int[] d = new int[subfields.length];
            for (int i = 0; i < subfields.length; i++) {
                d[i] = Integer.parseInt(subfields[i]);
            }
            timestamp = new Date(d[0], d[1], d[2], d[3], d[4]);
        } else {
            name = string;
            timestamp = new Date();
        }
    }

    public String toString() {
        return name + " at " + timestamp.toString();
    }

    public String toStringForFile() {
        return name + ";" + timestamp.getYear() + ":" + timestamp.getMonth() + ":" + timestamp.getDay() + ":" + timestamp.getHours() + ":" + timestamp.getMinutes();
    }
}