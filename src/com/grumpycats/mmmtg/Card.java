package com.grumpycats.mmmtg;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ilariyabelova
 * Date: 1/26/13
 * Time: 1:19 AM
 * To change this template use File | Settings | File Templates.
 */
final public class Card {

    private static final String TAG = "com.grumpycats.mmmtg.Card" ;

    private final String name;

    private final String block;

    private final Map<Timestamp, Double> prices;

    private long rawId;

    private long serverId;

    private Card(String name, String block, final Map<Timestamp, Double> prices, long rawId, long serverId){
        this.name = name;
        this.block = block;
        this.prices = prices;
        this.rawId = rawId;
        this.serverId = serverId;
    }

    public static Card create(String name, String block, Map<Timestamp, Double> prices, long rawId, long serverId) {
        return new Card(name, block, prices, rawId, serverId);
    }

    public static Card valueOf(JSONObject card) throws JSONException{
            final String name = !card.isNull("name") ? card.getString("name") : null;
            final long serverId = !card.isNull("id") ? card.getLong("id") : -1;
            if(name == null || serverId < 0) {
                throw new JSONException("Missing required json fields: 'name' or 'server id'");
            }
            final String block = !card.isNull("block") ? card.getString("block") : null;
            JSONObject pricesJSON = !card.isNull("prices") ? card.getJSONObject("prices") : null;
            final Map<Timestamp, Double> prices = new HashMap<Timestamp, Double>();
            if(pricesJSON != null){
                Iterator<String> it = pricesJSON.keys();
                while(it.hasNext()){
                    String key = it.next();
                    prices.put(new Timestamp(Long.valueOf(key)), pricesJSON.getDouble(key));
                }
            }
        return Card.create(name, block, prices, -1, serverId);
    }

    @Override
    public String toString(){
        return  "[" + serverId + ", " + name + ", " + block + ", " + prices + "]";
    }

}
