package guru.qa.service.impl;

import guru.qa.service.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String output) {
        System.out.println(output);
    }

    @Override
    public String readFromOutputStream() {
        throw new UnsupportedOperationException();
    }
}
