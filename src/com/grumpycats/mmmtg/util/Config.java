package com.grumpycats.mmmtg.util;

/**
 * Created with IntelliJ IDEA.
 * User: ilariyabelova
 * Date: 1/28/13
 * Time: 2:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Config {
    public static final String APP_NAME = "mmmtg";

    private static final String BASE_URL = "http://192.168.1.107:9000";
    public static final String GET_CARDS      = BASE_URL + "/cards";
    public static final int HTTP_REQUEST_TIMEOUT_MS = 30 * 1000;
}
