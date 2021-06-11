package guru.qa.service.impl;

import guru.qa.service.Writer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ConsoleWriter implements Writer {

    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    @Override
    public void write(String output) {
        try {
            writer.write(output);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readFromOutputStream() {
        throw new NotImplementedException();
    }
}
