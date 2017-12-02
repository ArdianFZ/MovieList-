package coml.code.pali.movieslist.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import coml.code.pali.movieslist.App;
import coml.code.pali.movieslist.Rinci_MoviesActivity;
import coml.code.pali.movieslist.R;
import coml.code.pali.movieslist.api.ApiInterface;
import coml.code.pali.movieslist.api.Constant;
import coml.code.pali.movieslist.model.Movies;

/**
 * Created by Jazz on 30/11/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>{

    private Context context;

    ArrayList<Movies> MoviesL;
    public MoviesAdapter() {
        MoviesL = new ArrayList<>();
    }

    public void setData(List<Movies> movies) {
        this.MoviesL.clear();
        this.MoviesL.addAll(movies);
        notifyDataSetChanged();
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewC = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_movies,parent,false);
       MoviesViewHolder moviesViewHolder = new MoviesViewHolder(viewC);
        return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {

        holder.textViewTitel.setText( MoviesL.get(position).getTitles());

        Constant.Function.setImageResource(holder.itemView.getContext(),
                ApiInterface.IMAGE_URL + MoviesL.get(position).getPosterPath(), holder.movie_poster);

//        //holder.movie_poster.setImageResource(MoviesL.get(p));
//       final Movies movies = MoviesL.get(position);
//        String imagePoster = Movies.IMAGE_URL + movies.getPosterPath();
//        final ImageView imageView = (((MoviesViewHolder)holder).movie_poster);
////
//        Picasso
//                .with(context)
//                .load(imagePoster)
//                .placeholder(R.mipmap.ic_launcher)
//                .fit()
//                .centerCrop();
//                //.into(((MoviesViewHolder) holder).movie_poster);
//


    }

    @Override
    public int getItemCount() {
        return MoviesL.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.adapter_movies_poster)
        ImageView movie_poster;

        @BindView(R.id.T_textView)
        TextView textViewTitel;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            movie_poster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), Rinci_MoviesActivity.class);
                    String movieJson = App.getInstance().getGson().toJson(MoviesL.get(getAdapterPosition()));
                    intent.putExtra("movie",movieJson);
                    view.getContext().startActivity(intent);



                }
            });
        }
    }
}
