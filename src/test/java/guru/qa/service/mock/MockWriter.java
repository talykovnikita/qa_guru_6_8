package guru.qa.service.mock;

import guru.qa.service.Writer;

import java.io.*;

public class MockWriter implements Writer {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Override
    public void handleString(String output){
        try {
            outputStream.write(output.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromOutputStream(){
        return outputStream.toString();
    }
}
