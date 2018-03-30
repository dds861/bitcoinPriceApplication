package com.dd.bitcoincurrentprice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView mText1;
    private TextView mText2;
    private TextView mText3;
    private TextView mText4;
    private TextView mText5;
    private TextView mText6;
    private TextView mText7;
    private TextView mText8;
    private TextView mText9;

    private ArrayList<String> stringArrayListCountries = new ArrayList<>();
    private ArrayList<String> stringArrayListCurrencies = new ArrayList<>();
    private TextView mText10;
    private TextView mText11;

    private static final String TAG = "MainActivity";

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Log.i("autolog", "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        setTitle("Bitcoin Price");

        initView();


        loadJSON1();

    }

    private void initView() {
//        Log.i("autolog", "initView();");
        mText1 = findViewById(R.id.text1);
        mText2 = findViewById(R.id.text2);
        mText3 = findViewById(R.id.text3);
        mText4 = findViewById(R.id.text4);
        mText5 = findViewById(R.id.text5);
        mText6 = findViewById(R.id.text6);
        mText7 = findViewById(R.id.text7);
        mText8 = findViewById(R.id.text8);
        mText9 = findViewById(R.id.text9);
        mText10 = findViewById(R.id.text10);
        mText11 = findViewById(R.id.text11);
    }


    private void loadJSON1() {
        Log.i("autolog", "loadJSON: ");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.coindesk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
//        Log.i("autolog", "service: " + service);


        Call<User> call = service.getUserData();
//        Log.i("autolog", "call: " + call);


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i("autolog", "call1: onResponse: ");

                User user = response.body();
                mText1.setText(user.getBpi().getUSD().getCode());
                mText2.setText("$ " + user.getBpi().getUSD().getRate());
                mText3.setText(user.getBpi().getUSD().getDescription());
                mText4.setText(user.getBpi().getEUR().getCode());
                mText5.setText("€ " + user.getBpi().getEUR().getRate());
                mText6.setText(user.getBpi().getEUR().getDescription());
                mText7.setText(user.getBpi().getGBP().getCode());
                mText8.setText("£ " + user.getBpi().getGBP().getRate());
                mText9.setText(user.getBpi().getGBP().getDescription());
//                mText10.setText("Last Update: " + user.getTime().getUpdated());
                mText11.setText(user.getDisclaimer());

                String dateStr = user.getTime().getUpdated();
                SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH);
                df.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date = null;
                try {
                    date = df.parse(dateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                df.setTimeZone(TimeZone.getDefault());
                String formattedDate = df.format(date);
                mText10.setText("Last Update: " + formattedDate);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
//                Log.d("Error", t.getMessage());
            }
        });


    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            // do something here
            loadJSON1();
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadJSON2() throws IOException {
        Log.i("autolog", "loadJSON2: ");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.coindesk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
//        Log.i("autolog", "service: " + service);

        Call<List<UserCurrencies>> call2 = service.getUserData2();
//        Log.i("autolog", "call2: " + call2);

        List<UserCurrencies> userCurrencies = call2.execute().body();
        for (UserCurrencies currencies : userCurrencies) {
            stringArrayListCountries.add(currencies.getCountry());
            Log.i("autolog", "currencies.getCountry(): " + currencies.getCountry());
            stringArrayListCurrencies.add(currencies.getCurrency());
            Log.i("autolog", "currencies.getCurrency(): " + currencies.getCurrency());


        }

//        call2.enqueue(new Callback<List<UserCurrencies>>() {
//            @Override
//            public void onResponse(Call<List<UserCurrencies>> call, Response<List<UserCurrencies>> response) {
//                Log.i("autolog", "call2: onResponse: ");
//
//                List<UserCurrencies> userCurrencies = response.body();
////                stringArrayListCountries = new ArrayList<>(Arrays.asList(userCurrencies.getCountry()));
//
//                for (UserCurrencies currencies : userCurrencies) {
//                    stringArrayListCountries.add(currencies.getCountry());
////                    Log.i("autolog", "currencies.getCountry(): " + currencies.getCountry());
//                    stringArrayListCurrencies.add(currencies.getCurrency());
////                    Log.i("autolog", "currencies.getCurrency(): " + currencies.getCurrency());
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<UserCurrencies>> call, Throwable t) {
////                Log.d("autolog", t.getMessage());
//            }
//        });
    }
}
