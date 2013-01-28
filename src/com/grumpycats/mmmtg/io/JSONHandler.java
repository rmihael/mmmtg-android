package com.grumpycats.mmmtg.io;

import com.grumpycats.mmmtg.io.model.Card;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ilariyabelova
 * Date: 1/28/13
 * Time: 3:22 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class JSONHandler {

    public abstract List<Card> parse (JSONObject json) throws JSONException;

}