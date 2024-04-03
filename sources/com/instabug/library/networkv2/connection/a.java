package com.instabug.library.networkv2.connection;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import java.io.IOException;
import java.net.HttpURLConnection;

public interface a {
    HttpURLConnection create(Request request) throws Exception;

    RequestResponse handleResponse(HttpURLConnection httpURLConnection, Request request) throws IOException;

    Throwable handleServerError(HttpURLConnection httpURLConnection) throws Exception;
}
