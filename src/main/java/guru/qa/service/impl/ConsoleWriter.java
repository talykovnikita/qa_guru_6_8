package guru.qa.service.impl;

import guru.qa.service.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public Object handleString(String output) {
        System.out.println(output);
        return null;
    }
}
