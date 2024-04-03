package com.android.volley.toolbox;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.android.volley.AsyncNetwork;
import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestTask;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.AsyncHttpStack;
import com.android.volley.toolbox.NetworkUtility;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class BasicAsyncNetwork extends AsyncNetwork {
    private final AsyncHttpStack mAsyncStack;
    /* access modifiers changed from: private */
    public final ByteArrayPool mPool;

    public static class Builder {
        private static final int DEFAULT_POOL_SIZE = 4096;
        @NonNull
        private AsyncHttpStack mAsyncStack;
        private ByteArrayPool mPool = null;

        public Builder(@NonNull AsyncHttpStack asyncHttpStack) {
            this.mAsyncStack = asyncHttpStack;
        }

        public BasicAsyncNetwork build() {
            if (this.mPool == null) {
                this.mPool = new ByteArrayPool(4096);
            }
            return new BasicAsyncNetwork(this.mAsyncStack, this.mPool);
        }

        public Builder setPool(ByteArrayPool byteArrayPool) {
            this.mPool = byteArrayPool;
            return this;
        }
    }

    public class InvokeRetryPolicyTask<T> extends RequestTask<T> {
        final AsyncNetwork.OnRequestComplete callback;
        final Request<T> request;
        final NetworkUtility.RetryInfo retryInfo;

        public InvokeRetryPolicyTask(Request<T> request2, NetworkUtility.RetryInfo retryInfo2, AsyncNetwork.OnRequestComplete onRequestComplete) {
            super(request2);
            this.request = request2;
            this.retryInfo = retryInfo2;
            this.callback = onRequestComplete;
        }

        public void run() {
            try {
                NetworkUtility.attemptRetryOnException(this.request, this.retryInfo);
                BasicAsyncNetwork.this.performRequest(this.request, this.callback);
            } catch (VolleyError e11) {
                this.callback.onError(e11);
            }
        }
    }

    public class ResponseParsingTask<T> extends RequestTask<T> {
        AsyncNetwork.OnRequestComplete callback;
        HttpResponse httpResponse;
        InputStream inputStream;
        Request<T> request;
        long requestStartMs;
        List<Header> responseHeaders;
        int statusCode;

        public ResponseParsingTask(InputStream inputStream2, HttpResponse httpResponse2, Request<T> request2, AsyncNetwork.OnRequestComplete onRequestComplete, long j11, List<Header> list, int i11) {
            super(request2);
            this.inputStream = inputStream2;
            this.httpResponse = httpResponse2;
            this.request = request2;
            this.callback = onRequestComplete;
            this.requestStartMs = j11;
            this.responseHeaders = list;
            this.statusCode = i11;
        }

        public void run() {
            try {
                BasicAsyncNetwork.this.onResponseRead(this.requestStartMs, this.statusCode, this.httpResponse, this.request, this.callback, this.responseHeaders, NetworkUtility.inputStreamToBytes(this.inputStream, this.httpResponse.getContentLength(), BasicAsyncNetwork.this.mPool));
            } catch (IOException e11) {
                BasicAsyncNetwork.this.onRequestFailed(this.request, this.callback, e11, this.requestStartMs, this.httpResponse, (byte[]) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onRequestFailed(Request<?> request, AsyncNetwork.OnRequestComplete onRequestComplete, IOException iOException, long j11, @Nullable HttpResponse httpResponse, @Nullable byte[] bArr) {
        try {
            getBlockingExecutor().execute(new InvokeRetryPolicyTask(request, NetworkUtility.shouldRetryException(request, iOException, j11, httpResponse, bArr), onRequestComplete));
        } catch (VolleyError e11) {
            onRequestComplete.onError(e11);
        }
    }

    /* access modifiers changed from: private */
    public void onRequestSucceeded(Request<?> request, long j11, HttpResponse httpResponse, AsyncNetwork.OnRequestComplete onRequestComplete) {
        int statusCode = httpResponse.getStatusCode();
        List<Header> headers = httpResponse.getHeaders();
        if (statusCode == 304) {
            Request<?> request2 = request;
            onRequestComplete.onSuccess(NetworkUtility.getNotModifiedNetworkResponse(request, SystemClock.elapsedRealtime() - j11, headers));
            return;
        }
        Request<?> request3 = request;
        AsyncNetwork.OnRequestComplete onRequestComplete2 = onRequestComplete;
        byte[] contentBytes = httpResponse.getContentBytes();
        if (contentBytes == null && httpResponse.getContent() == null) {
            contentBytes = new byte[0];
        }
        byte[] bArr = contentBytes;
        if (bArr != null) {
            onResponseRead(j11, statusCode, httpResponse, request, onRequestComplete, headers, bArr);
            return;
        }
        getBlockingExecutor().execute(new ResponseParsingTask(httpResponse.getContent(), httpResponse, request, onRequestComplete, j11, headers, statusCode));
    }

    /* access modifiers changed from: private */
    public void onResponseRead(long j11, int i11, HttpResponse httpResponse, Request<?> request, AsyncNetwork.OnRequestComplete onRequestComplete, List<Header> list, byte[] bArr) {
        int i12 = i11;
        Request<?> request2 = request;
        NetworkUtility.logSlowRequests(SystemClock.elapsedRealtime() - j11, request, bArr, i11);
        if (i12 < 200 || i12 > 299) {
            AsyncNetwork.OnRequestComplete onRequestComplete2 = onRequestComplete;
            onRequestFailed(request, onRequestComplete, new IOException(), j11, httpResponse, bArr);
            return;
        }
        NetworkResponse networkResponse = new NetworkResponse(i11, bArr, false, SystemClock.elapsedRealtime() - j11, list);
        AsyncNetwork.OnRequestComplete onRequestComplete3 = onRequestComplete;
        onRequestComplete.onSuccess(networkResponse);
    }

    public void performRequest(Request<?> request, AsyncNetwork.OnRequestComplete onRequestComplete) {
        if (getBlockingExecutor() != null) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            final Request<?> request2 = request;
            final AsyncNetwork.OnRequestComplete onRequestComplete2 = onRequestComplete;
            this.mAsyncStack.executeRequest(request, HttpHeaderParser.getCacheHeaders(request.getCacheEntry()), new AsyncHttpStack.OnRequestComplete() {
                public void onAuthError(AuthFailureError authFailureError) {
                    onRequestComplete2.onError(authFailureError);
                }

                public void onError(IOException iOException) {
                    BasicAsyncNetwork.this.onRequestFailed(request2, onRequestComplete2, iOException, elapsedRealtime, (HttpResponse) null, (byte[]) null);
                }

                public void onSuccess(HttpResponse httpResponse) {
                    BasicAsyncNetwork.this.onRequestSucceeded(request2, elapsedRealtime, httpResponse, onRequestComplete2);
                }
            });
            return;
        }
        throw new IllegalStateException("mBlockingExecuter must be set before making a request");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setBlockingExecutor(ExecutorService executorService) {
        super.setBlockingExecutor(executorService);
        this.mAsyncStack.setBlockingExecutor(executorService);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setNonBlockingExecutor(ExecutorService executorService) {
        super.setNonBlockingExecutor(executorService);
        this.mAsyncStack.setNonBlockingExecutor(executorService);
    }

    private BasicAsyncNetwork(AsyncHttpStack asyncHttpStack, ByteArrayPool byteArrayPool) {
        this.mAsyncStack = asyncHttpStack;
        this.mPool = byteArrayPool;
    }
}
