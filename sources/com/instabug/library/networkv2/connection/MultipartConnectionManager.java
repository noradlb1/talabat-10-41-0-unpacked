package com.instabug.library.networkv2.connection;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.google.common.net.HttpHeaders;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.e;
import com.instabug.library.networkv2.request.FileToUpload;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.jetbrains.annotations.NotNull;

public class MultipartConnectionManager extends InstabugBaseConnectionManagerImpl {
    @NotNull
    @SuppressLint({"RESOURCE_LEAK"})
    private e buildMultipartRequest(Request request, HttpURLConnection httpURLConnection, @NonNull FileToUpload fileToUpload) throws IOException {
        e eVar = new e(httpURLConnection);
        for (RequestParameter next : request.getRequestBodyParameters()) {
            eVar.a(next.getKey(), next.getValue().toString());
        }
        eVar.a(fileToUpload.getFilePartName(), fileToUpload.getFilePath(), fileToUpload.getFileName(), fileToUpload.getFileType());
        return eVar;
    }

    public int getConnectTimeOut() {
        return 0;
    }

    public String getContentType() {
        return "application/json";
    }

    public int getReadTimeOut() {
        return 0;
    }

    public RequestResponse handleResponse(HttpURLConnection httpURLConnection, Request request) throws IOException {
        RequestResponse requestResponse = new RequestResponse();
        requestResponse.setResponseCode(httpURLConnection.getResponseCode());
        requestResponse.setHeaders(getHeaderFields(httpURLConnection));
        requestResponse.setResponseBody(convertStreamToString(httpURLConnection.getInputStream()));
        httpURLConnection.disconnect();
        return requestResponse;
    }

    @SuppressLint({"RESOURCE_LEAK"})
    public HttpURLConnection setupConnection(HttpURLConnection httpURLConnection, Request request) throws Exception {
        InstabugSDKLogger.d("IBG-Core", "Connect to: " + request.getRequestUrlForLogging() + " with multiPart type");
        httpURLConnection.setRequestProperty("Connection", HttpHeaders.KEEP_ALIVE);
        httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
        httpURLConnection.setRequestProperty("Content-Encoding", "");
        FileToUpload fileToUpload = request.getFileToUpload();
        if (fileToUpload != null) {
            buildMultipartRequest(request, httpURLConnection, fileToUpload).a();
        }
        return httpURLConnection;
    }
}
