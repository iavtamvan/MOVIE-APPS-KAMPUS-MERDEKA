package com.iavariav.moviedb.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.iavariav.moviedb.R;
import com.iavariav.moviedb.teknik.model.ChildsItem;
import com.iavariav.moviedb.teknik.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class TeknikAdapter extends RecyclerView.Adapter<TeknikAdapter.MovieViewHolder> {

    private Context context;
    private List<DataItem> dataItems = new ArrayList<>();
    private List<ChildsItem> childsItems = new ArrayList<>();

    private List<String> arrayTeknik = new ArrayList<>();

    public TeknikAdapter(Context context, List<DataItem> dataItems) {
        this.context = context;
        this.dataItems = dataItems;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_list_teknik, viewGroup, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder teknikViewHolder, int i) {
        teknikViewHolder.tvJudul.setText(dataItems.get(i).getNamaKat());

        childsItems = dataItems.get(i).getChilds();
        Log.d("debug", "onBindViewHolder: " + childsItems);

        for (int j = 0; j < childsItems.size(); j++) {
//            teknikViewHolder.tvSub.setText(childsItems.get(0).getNamaKat());
            arrayTeknik.add(childsItems.get(j).getNamaKat());
            Log.d("debug", "array Child: " + childsItems.get(j).getNamaKat());
        }

        String replaceSubTeknikKotakPertama = arrayTeknik.toString().replace("[", "");
        String replaceSubTeknikKotakKedua = replaceSubTeknikKotakPertama.replace("]", "");
        String replaceKoma = replaceSubTeknikKotakKedua.replace(",", "\n");

        teknikViewHolder.tvSub.setText(replaceKoma);
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private CardView cvKlik;
        private TextView tvJudul;
        private TextView tvSub;

        public MovieViewHolder(View itemView) {
            super(itemView);
            cvKlik = itemView.findViewById(R.id.cv_klik);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvSub = itemView.findViewById(R.id.tv_sub);
        }
    }
}