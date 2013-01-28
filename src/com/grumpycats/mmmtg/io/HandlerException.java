package com.grumpycats.mmmtg.io;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ilariyabelova
 * Date: 1/28/13
 * Time: 3:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class HandlerException extends IOException {

    public HandlerException() {
        super();
    }

    public HandlerException(String message) {
        super(message);
    }

    public HandlerException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }

    @Override
    public String toString() {
        if (getCause() != null) {
            return getLocalizedMessage() + ": " + getCause();
        } else {
            return getLocalizedMessage();
        }
    }
}
