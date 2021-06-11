package guru.qa.service;

public interface Writer {
    void handleString(String output);

    String readFromOutputStream();
}
