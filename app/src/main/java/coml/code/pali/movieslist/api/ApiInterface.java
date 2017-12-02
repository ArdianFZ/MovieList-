package coml.code.pali.movieslist.api;

import coml.code.pali.movieslist.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ray on 14/06/2017.
 */

public interface ApiInterface {
    String BASE_URL = "https://api.themoviedb.org/3/";
    String BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w185";
    String API_KEY = "68160e0faab1bec4b598a885f659e440";
    String LANG_SOURCE = "en-US";
    String MOVIES_REGION = "US";
    String IMAGE_URL = "http://image.tmdb.org/t/p/w500/";



    @GET("movie/{typ" + "e}")
    Call<MovieResponse> getMovies(@Path("type") String type,
                                  @Query("api_key") String apiKey,
                                  @Query("language") String language,
                                  @Query("page") int page,
                                  @Query("region") String region);
}
