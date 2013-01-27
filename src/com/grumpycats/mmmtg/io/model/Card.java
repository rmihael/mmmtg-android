package com.grumpycats.mmmtg.io.model;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ilariyabelova
 * Date: 1/26/13
 * Time: 1:19 AM
 * To change this template use File | Settings | File Templates.
 */
final public class Card {


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

    @Override
    public String toString(){
        return  "[" + serverId + ", " + name + ", " + block + ", " + prices + "]";
    }

}
