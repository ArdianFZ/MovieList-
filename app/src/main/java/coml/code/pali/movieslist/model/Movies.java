package coml.code.pali.movieslist.model;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jazz on 30/11/2017.
 */

public class Movies {
    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("title")
    private String title;

    @SerializedName("vote_average")
    private double voteAverage;


//    public Movies(String overview, String posterPath, String releaseDate, String title, double voteAverage) {
//        this.overview = overview;
//        this.posterPath = posterPath;
//        this.releaseDate = releaseDate;
//        this.title = title;
//        this.voteAverage = voteAverage;
//    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getTitles() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }
}
