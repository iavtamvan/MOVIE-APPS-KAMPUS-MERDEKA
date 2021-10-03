package com.iavariav.moviedb.teknik;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.iavariav.moviedb.Config;
import com.iavariav.moviedb.R;
import com.iavariav.moviedb.adapter.TeknikAdapter;
import com.iavariav.moviedb.api.ApiConfig;
import com.iavariav.moviedb.api.ApiService;
import com.iavariav.moviedb.teknik.model.DataItem;
import com.iavariav.moviedb.teknik.model.TeknikRootModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeknikActivity extends AppCompatActivity {
    private final String TAG = "debug";

    private String namaLengkap;
    private String username;

    private List<DataItem> dataItems = new ArrayList<>();
//    private List<ChildsItem> childsItems = new ArrayList<>();

    private TeknikAdapter teknikAdapter;

    private RecyclerView rv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teknik);
        initView();

        // inisialisasi shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, MODE_PRIVATE);

        // untuk create shared pref
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Config.SHARED_PREF_NAMA_LENGKAP, "Merdeka John");
        editor.putString(Config.SHARED_PREF_USERNAME, "bill_john");
//        editor.commit();
        editor.apply();

//        untuk menghapus
        editor.putString(Config.SHARED_PREF_NAMA_LENGKAP, "");
        editor.putString(Config.SHARED_PREF_USERNAME, "");
        editor.apply();

        // untuk membaca shared pref
        namaLengkap = sharedPreferences.getString(Config.SHARED_PREF_NAMA_LENGKAP, "");
        username = sharedPreferences.getString(Config.SHARED_PREF_USERNAME, "");



        tv.setText("Nama lengkap = " + namaLengkap + "\n" + "Username = " + username);
        getDataTeknik();

    }

    private void getDataTeknik() {
        ApiService apiService = ApiConfig.getApiService(Config.BASE_URL_WEBHOST_APP);
        apiService.ambilDataTeknik()
                .enqueue(new Callback<TeknikRootModel>() {
                    @Override
                    public void onResponse(Call<TeknikRootModel> call, Response<TeknikRootModel> response) {
                        if (response.isSuccessful()) {
                            dataItems = response.body().getData();
                            Log.d(TAG, "onResponse: " + dataItems.size());

                            teknikAdapter = new TeknikAdapter(TeknikActivity.this, dataItems);
                            rv.setAdapter(teknikAdapter);
                            rv.setLayoutManager(new LinearLayoutManager(TeknikActivity.this));
                            teknikAdapter.notifyDataSetChanged();


//                            for (int i = 0; i < dataItems.size(); i++) {
//                                childsItems = dataItems.get(i).getChilds();
//                                for (int j = 0; j < childsItems.size(); j++) {
//                                    Log.d(TAG, "onResponse: " + childsItems.size());
//                                    Log.d(TAG, "onResponse: " + childsItems.get(j).getNamaKat());
//                                }
//                            }
                        } else {
                            Log.d(TAG, "onResponse Failed: " + response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<TeknikRootModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    private void initView() {
        rv = findViewById(R.id.rv);
        tv = findViewById(R.id.tv);
    }
}