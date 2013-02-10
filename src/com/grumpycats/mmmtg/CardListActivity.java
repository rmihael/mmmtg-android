package com.grumpycats.mmmtg;

import android.os.Bundle;
import android.app.Activity;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import com.grumpycats.mmmtg.io.model.Card;
import com.grumpycats.mmmtg.sync.RestHelper;
import com.grumpycats.mmmtg.util.Config;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CardListActivity extends Activity {

    private static final String TAG = Config.APP_NAME + ": " + CardListActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.stock_list);
        Map<Timestamp, Double> d = new HashMap<Timestamp, Double>();
        d.put(new Timestamp(1), 21.2);
        Log.d(TAG, d.toString());
        Card c = Card.create("hello", "world", d, 3, 4);
        Log.d(TAG, c.toString());
        RestHelper.getCards();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.card_list, menu);
        return true;
    }
}
