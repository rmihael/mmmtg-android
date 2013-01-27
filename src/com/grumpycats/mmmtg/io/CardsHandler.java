package com.grumpycats.mmmtg.io;

import com.grumpycats.mmmtg.io.model.Card;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ilariyabelova
 * Date: 1/27/13
 * Time: 2:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class CardsHandler {
    private static final String TAG = CardsHandler.class.getSimpleName() ;

    public List<Card> parse (JSONObject json) throws JSONException {
        JSONArray cardsJSON = !json.isNull("cards") ? json.getJSONArray("cards") : null;
        if(cardsJSON == null) {
            throw new JSONException("Missing card in json");
        }
        List<Card> cards = new ArrayList<Card>();

        for(int i = 0; i < cardsJSON.length(); i++)  {
            cards.add(parseCard((JSONObject)cardsJSON.get(i))) ;
        }
        return cards;
    }

    private static Card parseCard(JSONObject card) throws JSONException {
        final String name = !card.isNull("name") ? card.getString("name") : null;
        final long serverId = !card.isNull("id") ? card.getLong("id") : -1;
        if(name == null || serverId < 0) {
            throw new JSONException("Missing required json fields: 'name' or 'server id'");
        }
        final String block = !card.isNull("block") ? card.getString("block") : null;
        JSONObject pricesJSON = !card.isNull("prices") ? card.getJSONObject("prices") : null;
        final Map<Timestamp, Double> prices = new HashMap<Timestamp, Double>();
        if(pricesJSON != null){
            Iterator it = pricesJSON.keys();
            while(it.hasNext()){
                String key = (String) it.next();
                prices.put(new Timestamp(Long.valueOf(key)), pricesJSON.getDouble(key));
            }
        }
        return Card.create(name, block, prices, -1, serverId);
    }
}
