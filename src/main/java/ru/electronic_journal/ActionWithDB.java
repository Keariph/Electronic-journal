package ru.electronic_journal;

import java.util.List;

public interface ActionWithDB<T> {
public void create();
public void update();
public void delete();
public List<T> read(String query);
}
