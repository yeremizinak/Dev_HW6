package org.example;

import java.io.*;

public class ReadFile {
    public static String readFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder content = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        br.close();
        isr.close();
        fis.close();

        return content.toString();
    }
}
