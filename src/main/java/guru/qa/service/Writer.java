package guru.qa.service;

public interface Writer<T> {
    T handleString(String output);
}
