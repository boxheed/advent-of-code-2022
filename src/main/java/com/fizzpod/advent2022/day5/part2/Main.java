package com.fizzpod.advent2022.day5.part2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        try (InputStream stream = Main.class.getResourceAsStream("data.txt")) {
            List<String> lines = IOUtils.readLines(stream, Charset.forName("UTF-8"));
            process(lines);
        }

    }

    private static void process(List<String> lines) {

        List<LinkedList<String>> columns = new LinkedList<>();
        for (String line : lines) {
            if (!line.startsWith("move") && line.length() > 0) {
                String[] entries = line.split("");
                for (int i = 0; i < entries.length; i++) {

                    if (columns.size() >= i) {
                        columns.add(new LinkedList<String>());
                    }
                    LinkedList<String> column = columns.get(i);
                    String value = entries[i];
                    if (value.matches("[a-zA-Z]")) {
                        column.add(value);
                    }
                }
            } else if ("".equals(line)) {
                // tidy up columns
                LinkedList<LinkedList<String>> tidyColumns = new LinkedList<>();
                for (LinkedList<String> column : columns) {
                    if (!column.isEmpty()) {
                        tidyColumns.add(column);
                    }
                }
                columns = tidyColumns;
            } else {
                Pattern pattern = Pattern.compile("move ([0-9]*) from ([0-9]*) to ([0-9]*)");
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    int number = Integer.valueOf(matcher.group(1));
                    int from = Integer.valueOf(matcher.group(2));
                    int to = Integer.valueOf(matcher.group(3));
                    LinkedList<String> fromColumn = columns.get(from - 1);
                    LinkedList<String> toColumn = columns.get(to - 1);
                    LinkedList<String> tempColumn = new LinkedList<>();
                    for (int i = 0; i < number; i++) {
                        String item = fromColumn.remove();
                        tempColumn.addFirst(item);
                    }
                    for (String val : tempColumn) {
                        toColumn.addFirst(val);
                    }
                }
            }
        }
        String columnTops = "";
        for (LinkedList<String> column : columns) {
            columnTops += column.peek();
        }
        System.out.println(columnTops);
    }

}
