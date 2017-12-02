package coml.code.pali.movieslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import coml.code.pali.movieslist.Adapter.MoviesAdapter;
import coml.code.pali.movieslist.api.Constant;
import coml.code.pali.movieslist.controller.MovieController;
import coml.code.pali.movieslist.event.MovieEvent;
import coml.code.pali.movieslist.model.Movies;


public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.rv_main_movies)
    RecyclerView mMainMovies;
private Movies movies;
    private EventBus  eventBus = App.getInstance().getEventBus();
    private MoviesAdapter adapter;
    private MovieController controller;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        eventBus.register(this);

        controller = new MovieController();

        initView();

        //errorLayout.setVisibility(View.GONE);
       // loadingBar.setVisibility(View.VISIBLE);

        page = 1;
       // setPopularMovies(page);
        controller.getPopularMovies(1);

    }

    private void initView() {
        ButterKnife.bind(this);

        int columns = Constant.Function.getColumnsCount(this);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, columns);
        mMainMovies.setLayoutManager(layoutManager);
        mMainMovies.setHasFixedSize(true);

        adapter = new MoviesAdapter();
        mMainMovies.setAdapter(adapter);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMovieList(MovieEvent event) {
//        loadingBar.setVisibility(View.GONE);
        adapter.setData(event.getBody().getResults());
        mMainMovies.scrollToPosition(0);


    }

    @Override
    protected void onDestroy() {
        eventBus.unregister(this);

        super.onDestroy();
    }
}


