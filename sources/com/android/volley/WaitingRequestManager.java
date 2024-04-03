package com.android.volley;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.volley.Cache;
import com.android.volley.Request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

class WaitingRequestManager implements Request.NetworkRequestCompleteListener {
    @Nullable
    private final CacheDispatcher mCacheDispatcher;
    @Nullable
    private final BlockingQueue<Request<?>> mNetworkQueue;
    @Nullable
    private final RequestQueue mRequestQueue;
    private final ResponseDelivery mResponseDelivery;
    private final Map<String, List<Request<?>>> mWaitingRequests;

    public WaitingRequestManager(@NonNull RequestQueue requestQueue) {
        this.mWaitingRequests = new HashMap();
        this.mRequestQueue = requestQueue;
        this.mResponseDelivery = requestQueue.getResponseDelivery();
        this.mCacheDispatcher = null;
        this.mNetworkQueue = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean maybeAddToWaitingRequests(com.android.volley.Request<?> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = r6.getCacheKey()     // Catch:{ all -> 0x0053 }
            java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r1 = r5.mWaitingRequests     // Catch:{ all -> 0x0053 }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x0053 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003b
            java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r1 = r5.mWaitingRequests     // Catch:{ all -> 0x0053 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0053 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x001e
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0053 }
            r1.<init>()     // Catch:{ all -> 0x0053 }
        L_0x001e:
            java.lang.String r4 = "waiting-for-response"
            r6.addMarker(r4)     // Catch:{ all -> 0x0053 }
            r1.add(r6)     // Catch:{ all -> 0x0053 }
            java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r6 = r5.mWaitingRequests     // Catch:{ all -> 0x0053 }
            r6.put(r0, r1)     // Catch:{ all -> 0x0053 }
            boolean r6 = com.android.volley.VolleyLog.DEBUG     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x0039
            java.lang.String r6 = "Request for cacheKey=%s is in flight, putting on hold."
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0053 }
            r1[r3] = r0     // Catch:{ all -> 0x0053 }
            com.android.volley.VolleyLog.d(r6, r1)     // Catch:{ all -> 0x0053 }
        L_0x0039:
            monitor-exit(r5)
            return r2
        L_0x003b:
            java.util.Map<java.lang.String, java.util.List<com.android.volley.Request<?>>> r1 = r5.mWaitingRequests     // Catch:{ all -> 0x0053 }
            r4 = 0
            r1.put(r0, r4)     // Catch:{ all -> 0x0053 }
            r6.setNetworkRequestCompleteListener(r5)     // Catch:{ all -> 0x0053 }
            boolean r6 = com.android.volley.VolleyLog.DEBUG     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x0051
            java.lang.String r6 = "new request, sending to network %s"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0053 }
            r1[r3] = r0     // Catch:{ all -> 0x0053 }
            com.android.volley.VolleyLog.d(r6, r1)     // Catch:{ all -> 0x0053 }
        L_0x0051:
            monitor-exit(r5)
            return r3
        L_0x0053:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.WaitingRequestManager.maybeAddToWaitingRequests(com.android.volley.Request):boolean");
    }

    public synchronized void onNoUsableResponseReceived(Request<?> request) {
        BlockingQueue<Request<?>> blockingQueue;
        String cacheKey = request.getCacheKey();
        List remove = this.mWaitingRequests.remove(cacheKey);
        if (remove != null && !remove.isEmpty()) {
            if (VolleyLog.DEBUG) {
                VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
            }
            Request request2 = (Request) remove.remove(0);
            this.mWaitingRequests.put(cacheKey, remove);
            request2.setNetworkRequestCompleteListener(this);
            RequestQueue requestQueue = this.mRequestQueue;
            if (requestQueue != null) {
                requestQueue.sendRequestOverNetwork(request2);
            } else if (!(this.mCacheDispatcher == null || (blockingQueue = this.mNetworkQueue) == null)) {
                try {
                    blockingQueue.put(request2);
                } catch (InterruptedException e11) {
                    VolleyLog.e("Couldn't add request to queue. %s", e11.toString());
                    Thread.currentThread().interrupt();
                    this.mCacheDispatcher.quit();
                }
            }
        }
        return;
    }

    public void onResponseReceived(Request<?> request, Response<?> response) {
        List<Request> remove;
        Cache.Entry entry = response.cacheEntry;
        if (entry == null || entry.isExpired()) {
            onNoUsableResponseReceived(request);
            return;
        }
        String cacheKey = request.getCacheKey();
        synchronized (this) {
            remove = this.mWaitingRequests.remove(cacheKey);
        }
        if (remove != null) {
            if (VolleyLog.DEBUG) {
                VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
            }
            for (Request postResponse : remove) {
                this.mResponseDelivery.postResponse(postResponse, response);
            }
        }
    }

    public WaitingRequestManager(@NonNull CacheDispatcher cacheDispatcher, @NonNull BlockingQueue<Request<?>> blockingQueue, ResponseDelivery responseDelivery) {
        this.mWaitingRequests = new HashMap();
        this.mRequestQueue = null;
        this.mResponseDelivery = responseDelivery;
        this.mCacheDispatcher = cacheDispatcher;
        this.mNetworkQueue = blockingQueue;
    }
}
