package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {
    private static final String TAG = "RequestTracker";
    private boolean isPaused;
    private final List<Request> pendingRequests = new ArrayList();
    private final Set<Request> requests = Collections.newSetFromMap(new WeakHashMap());

    @VisibleForTesting
    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public boolean clearAndRemove(@Nullable Request request) {
        boolean z11 = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.requests.remove(request);
        if (!this.pendingRequests.remove(request) && !remove) {
            z11 = false;
        }
        if (z11) {
            request.clear();
        }
        return z11;
    }

    public void clearRequests() {
        for (T clearAndRemove : Util.getSnapshot(this.requests)) {
            clearAndRemove(clearAndRemove);
        }
        this.pendingRequests.clear();
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void pauseAllRequests() {
        this.isPaused = true;
        for (T t11 : Util.getSnapshot(this.requests)) {
            if (t11.isRunning() || t11.isComplete()) {
                t11.clear();
                this.pendingRequests.add(t11);
            }
        }
    }

    public void pauseRequests() {
        this.isPaused = true;
        for (T t11 : Util.getSnapshot(this.requests)) {
            if (t11.isRunning()) {
                t11.pause();
                this.pendingRequests.add(t11);
            }
        }
    }

    public void restartRequests() {
        for (T t11 : Util.getSnapshot(this.requests)) {
            if (!t11.isComplete() && !t11.isCleared()) {
                t11.clear();
                if (!this.isPaused) {
                    t11.begin();
                } else {
                    this.pendingRequests.add(t11);
                }
            }
        }
    }

    public void resumeRequests() {
        this.isPaused = false;
        for (T t11 : Util.getSnapshot(this.requests)) {
            if (!t11.isComplete() && !t11.isRunning()) {
                t11.begin();
            }
        }
        this.pendingRequests.clear();
    }

    public void runRequest(@NonNull Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
            return;
        }
        request.clear();
        Log.isLoggable(TAG, 2);
        this.pendingRequests.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.requests.size() + ", isPaused=" + this.isPaused + "}";
    }
}
