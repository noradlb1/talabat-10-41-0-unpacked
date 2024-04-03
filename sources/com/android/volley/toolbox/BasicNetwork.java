package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BasicNetwork implements Network {
    private static final int DEFAULT_POOL_SIZE = 4096;
    private final BaseHttpStack mBaseHttpStack;
    @Deprecated
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    @Deprecated
    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(4096));
    }

    @Deprecated
    public static Map<String, String> convertHeaders(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i11 = 0; i11 < headerArr.length; i11++) {
            treeMap.put(headerArr[i11].getName(), headerArr[i11].getValue());
        }
        return treeMap;
    }

    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        byte[] bArr;
        HttpResponse httpResponse;
        IOException iOException;
        HttpResponse executeRequest;
        int statusCode;
        List<Header> headers;
        byte[] bArr2;
        Request<?> request2 = request;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                executeRequest = this.mBaseHttpStack.executeRequest(request2, HttpHeaderParser.getCacheHeaders(request.getCacheEntry()));
                try {
                    statusCode = executeRequest.getStatusCode();
                    headers = executeRequest.getHeaders();
                    break;
                } catch (IOException e11) {
                    bArr = null;
                    httpResponse = executeRequest;
                    iOException = e11;
                }
            } catch (IOException e12) {
                iOException = e12;
                httpResponse = null;
                bArr = null;
            }
            NetworkUtility.attemptRetryOnException(request2, NetworkUtility.shouldRetryException(request, iOException, elapsedRealtime, httpResponse, bArr));
        }
        if (statusCode == 304) {
            return NetworkUtility.getNotModifiedNetworkResponse(request2, SystemClock.elapsedRealtime() - elapsedRealtime, headers);
        }
        InputStream content = executeRequest.getContent();
        if (content != null) {
            bArr2 = NetworkUtility.inputStreamToBytes(content, executeRequest.getContentLength(), this.mPool);
        } else {
            bArr2 = new byte[0];
        }
        NetworkUtility.logSlowRequests(SystemClock.elapsedRealtime() - elapsedRealtime, request2, bArr2, statusCode);
        if (statusCode < 200 || statusCode > 299) {
            throw new IOException();
        }
        return new NetworkResponse(statusCode, bArr2, false, SystemClock.elapsedRealtime() - elapsedRealtime, headers);
    }

    @Deprecated
    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mBaseHttpStack = new AdaptedHttpStack(httpStack);
        this.mPool = byteArrayPool;
    }

    public BasicNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    public BasicNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.mBaseHttpStack = baseHttpStack;
        this.mHttpStack = baseHttpStack;
        this.mPool = byteArrayPool;
    }
}
