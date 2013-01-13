package com.grumpycats.mmmtg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CardListActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.card_list, menu);
        return true;
    }
}
