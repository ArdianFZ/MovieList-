package coml.code.pali.movieslist.controller;

import org.greenrobot.eventbus.EventBus;


import coml.code.pali.movieslist.App;
import coml.code.pali.movieslist.api.ApiInterface;
import coml.code.pali.movieslist.api.Constant;
import coml.code.pali.movieslist.event.MovieErrorEvent;
import coml.code.pali.movieslist.event.MovieEvent;
import coml.code.pali.movieslist.model.MovieResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieController {

    private EventBus eventBus = App.getInstance().getEventBus();

    private void getMovies(int type, int page) {
        Call<MovieResponse> movieResponseCall = App.getInstance()
                .getApiService()
                .getMovies(Constant
                        .Data
                        .MOVIE_LIST_TYPE[type], ApiInterface.API_KEY, ApiInterface.LANG_SOURCE, page, ApiInterface.MOVIES_REGION);
        movieResponseCall.enqueue(new Callback<MovieResponse>() {

            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                if (response.code() == 200) {
                    eventBus.post(new MovieEvent(response.message(), response.body()));
                } else {
                    eventBus.post(new MovieErrorEvent(response.message()));
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                eventBus.post(new MovieErrorEvent(t.getMessage()));
            }
        });
    }

    public void getPopularMovies(int page) {
        getMovies(0, page);
    }

    public void getTopRatedMovies(int page) {
        getMovies(1, page);
    }
}