package com.grumpycats.mmmtg.sync;

import android.util.Log;
import com.grumpycats.mmmtg.io.HandlerException;
import com.grumpycats.mmmtg.io.JSONHandler;
import com.grumpycats.mmmtg.util.Config;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ilariyabelova
 * Date: 1/28/13
 * Time: 2:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class RestHelper {

    private static final String TAG = Config.APP_NAME + ": " + RestHelper.class.getSimpleName() ;

    public static HttpClient getHttpClient() {
        HttpClient httpClient = new DefaultHttpClient();
        final HttpParams params = httpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(params, Config.HTTP_REQUEST_TIMEOUT_MS);
        HttpConnectionParams.setSoTimeout(params, Config.HTTP_REQUEST_TIMEOUT_MS);
        return httpClient;
    }

    public void syncCards(){


    }

    private static JSONObject executeGet(String urlString) throws IOException, JSONException{
        Log.v(TAG, "Requesting URL: " + urlString);

        HttpGet get = new HttpGet(urlString);
        HttpResponse response = getHttpClient().execute(get);

        Log.v(TAG, "HTTP response: " + response);

        StatusLine status = response.getStatusLine();
        throwStatusExceptions(status, urlString);

        String data = EntityUtils.toString(response.getEntity());

        return new JSONObject(data);
    }

    private static void throwStatusExceptions(StatusLine status, String urlString) throws IOException {
        if (status.getStatusCode() != HttpStatus.SC_OK) {
            String exceptionMessage = "Error response " + " "
                    + status.getProtocolVersion().toString()
                    + status.getStatusCode() + " "
                    + status.getReasonPhrase() + " for"
                    + urlString;
            Log.e(TAG, "Server error: " + exceptionMessage);
            throw new HandlerException(exceptionMessage);
        }
    }


}
