package com.grumpycats.mmmtg;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CardListActivity extends Activity {

    private static final String TAG = "com.grumpycats.mmmtg.CardListActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_list);
        Map<Timestamp, Double> d = new HashMap<Timestamp, Double>();
        d.put(new Timestamp(1), 21.2);
        System.out.println(d);
        Card c = Card.create("hello", "world", d, 3, 4);
        System.out.println(c);
        try{
            c = Card.valueOf(new JSONObject("{id:1,name:'Force of Will',block:Revised,prices:{}}"));
            System.out.println(c);
        } catch (JSONException e){
            Log.e(TAG, "JSON exception", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.card_list, menu);
        return true;
    }
}
