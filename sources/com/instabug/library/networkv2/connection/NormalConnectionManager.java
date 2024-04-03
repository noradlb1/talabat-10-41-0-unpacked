package com.instabug.library.networkv2.connection;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.util.Constants;
import com.talabat.helpers.TalabatVolley;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;

public class NormalConnectionManager extends InstabugBaseConnectionManagerImpl {
    private void writeRequestBody(OutputStream outputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes(Charset.forName("UTF8")));
        gZIPOutputStream.close();
        outputStream.write(byteArrayOutputStream.toByteArray());
        try {
            outputStream.flush();
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Failed to flush o/s ", e11);
        } catch (Throwable th2) {
            byteArrayOutputStream.close();
            outputStream.close();
            throw th2;
        }
        byteArrayOutputStream.close();
        outputStream.close();
    }

    public int getConnectTimeOut() {
        return TalabatVolley.DEFAULT_TIMEOUT_MS;
    }

    public String getContentType() {
        return "application/json";
    }

    public int getReadTimeOut() {
        return 10000;
    }

    public RequestResponse handleResponse(HttpURLConnection httpURLConnection, Request request) throws IOException {
        RequestResponse requestResponse = new RequestResponse();
        if (httpURLConnection != null) {
            requestResponse.setResponseCode(httpURLConnection.getResponseCode());
            requestResponse.setHeaders(getHeaderFields(httpURLConnection));
            requestResponse.setResponseBody(convertStreamToString(httpURLConnection.getInputStream()));
            httpURLConnection.disconnect();
        }
        return requestResponse;
    }

    public HttpURLConnection setupConnection(HttpURLConnection httpURLConnection, Request request) throws Exception {
        InstabugSDKLogger.d("IBG-Core", "Connect to: " + request.getRequestUrlForLogging() + " with normal type");
        httpURLConnection.setRequestProperty("Content-Encoding", Constants.Network.ContentType.GZIP);
        httpURLConnection.setReadTimeout(getReadTimeOut());
        httpURLConnection.setConnectTimeout(getConnectTimeOut());
        if (httpURLConnection.getRequestMethod().equals("POST") || httpURLConnection.getRequestMethod().equals("PUT")) {
            httpURLConnection.setDoOutput(true);
            writeRequestBody(httpURLConnection.getOutputStream(), request.getRequestBody());
        }
        return httpURLConnection;
    }
}
