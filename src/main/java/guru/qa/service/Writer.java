package guru.qa.service;

public interface Writer {
    void write(String output);

    String readFromOutputStream();
}
