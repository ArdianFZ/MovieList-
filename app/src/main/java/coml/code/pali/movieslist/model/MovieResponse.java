package coml.code.pali.movieslist.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    private List<Movies> results;

    @SerializedName("page")
    private int page;

    public MovieResponse() {
    }

    public List<Movies> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }
}