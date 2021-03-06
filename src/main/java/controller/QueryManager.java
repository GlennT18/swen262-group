package controller;

import controller.search.Searcher;
import controller.sort.Sorter;
import model.database.Database;

import java.util.List;

public class QueryManager {
    private Searcher searcher;
    private Sorter sorter;
    private String argument;
    private Database database;

    private static QueryManager instance = new QueryManager();

    private QueryManager(){}

    //Get the only object available
    public static QueryManager getInstance(){
        return instance;
    }

    public void setSearcher(Searcher searcher) {
        this.searcher = searcher;
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public List executeQuery() {
        List results = searcher.performSearch(argument, database);
        sorter.sortData(results);
        return results;
    }
}
