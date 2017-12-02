package coml.code.pali.movieslist;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import coml.code.pali.movieslist.api.ApiInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**Sumber by alodokter-it on 16/06/17 .*/
/**
 * Created by Jazz on 30/11/2017.
 */


public class App extends Application {
    private static App instance;
    private Retrofit retrofit;
    private EventBus eventBus;
    private Gson gson;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        createEventBus();
        createRetrofitClient();
        createGson();
    }

    private void createGson() {
        gson = new GsonBuilder().create();
    }

    private void createEventBus() {
        eventBus = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .build();
    }

    private void createRetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public Retrofit getRetrofitClient() {
        return retrofit;
    }

    public Gson getGson() {
        return gson;
    }

    public ApiInterface getApiService() {
        return getRetrofitClient().create( ApiInterface.class);
    }
}