package controller.search;

import model.database.Database;

import java.util.List;

public interface Searcher {
    List performSearch(String query, Database db);
}
