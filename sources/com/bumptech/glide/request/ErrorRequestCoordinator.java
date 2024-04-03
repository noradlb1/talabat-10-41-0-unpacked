package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

public final class ErrorRequestCoordinator implements RequestCoordinator, Request {
    private volatile Request error;
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState errorState;
    @Nullable
    private final RequestCoordinator parent;
    private volatile Request primary;
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState primaryState;
    private final Object requestLock;

    public ErrorRequestCoordinator(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.primaryState = requestState;
        this.errorState = requestState;
        this.requestLock = obj;
        this.parent = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean isValidRequest(Request request) {
        if (request.equals(this.primary) || (this.primaryState == RequestCoordinator.RequestState.FAILED && request.equals(this.error))) {
            return true;
        }
        return false;
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyCleared() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    @GuardedBy("requestLock")
    private boolean parentCanNotifyStatusChanged() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    @GuardedBy("requestLock")
    private boolean parentCanSetImage() {
        RequestCoordinator requestCoordinator = this.parent;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    public void begin() {
        synchronized (this.requestLock) {
            RequestCoordinator.RequestState requestState = this.primaryState;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.primaryState = requestState2;
                this.primary.begin();
            }
        }
    }

    public boolean canNotifyCleared(Request request) {
        boolean z11;
        synchronized (this.requestLock) {
            if (!parentCanNotifyCleared() || !isValidRequest(request)) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        return z11;
    }

    public boolean canNotifyStatusChanged(Request request) {
        boolean z11;
        synchronized (this.requestLock) {
            if (!parentCanNotifyStatusChanged() || !isValidRequest(request)) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        return z11;
    }

    public boolean canSetImage(Request request) {
        boolean z11;
        synchronized (this.requestLock) {
            if (!parentCanSetImage() || !isValidRequest(request)) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        return z11;
    }

    public void clear() {
        synchronized (this.requestLock) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.primaryState = requestState;
            this.primary.clear();
            if (this.errorState != requestState) {
                this.errorState = requestState;
                this.error.clear();
            }
        }
    }

    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.requestLock) {
            RequestCoordinator requestCoordinator2 = this.parent;
            if (requestCoordinator2 != null) {
                requestCoordinator = requestCoordinator2.getRoot();
            } else {
                requestCoordinator = this;
            }
        }
        return requestCoordinator;
    }

    public boolean isAnyResourceSet() {
        boolean z11;
        synchronized (this.requestLock) {
            if (!this.primary.isAnyResourceSet()) {
                if (!this.error.isAnyResourceSet()) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    public boolean isCleared() {
        boolean z11;
        synchronized (this.requestLock) {
            RequestCoordinator.RequestState requestState = this.primaryState;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            if (requestState == requestState2 && this.errorState == requestState2) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    public boolean isComplete() {
        boolean z11;
        synchronized (this.requestLock) {
            RequestCoordinator.RequestState requestState = this.primaryState;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (requestState != requestState2) {
                if (this.errorState != requestState2) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    public boolean isEquivalentTo(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.primary.isEquivalentTo(errorRequestCoordinator.primary) || !this.error.isEquivalentTo(errorRequestCoordinator.error)) {
            return false;
        }
        return true;
    }

    public boolean isRunning() {
        boolean z11;
        synchronized (this.requestLock) {
            RequestCoordinator.RequestState requestState = this.primaryState;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                if (this.errorState != requestState2) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestFailed(com.bumptech.glide.request.Request r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.requestLock
            monitor-enter(r0)
            com.bumptech.glide.request.Request r1 = r2.error     // Catch:{ all -> 0x002b }
            boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x001e
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.primaryState = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = r2.errorState     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator$RequestState r1 = com.bumptech.glide.request.RequestCoordinator.RequestState.RUNNING     // Catch:{ all -> 0x002b }
            if (r3 == r1) goto L_0x001c
            r2.errorState = r1     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.Request r3 = r2.error     // Catch:{ all -> 0x002b }
            r3.begin()     // Catch:{ all -> 0x002b }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x001e:
            com.bumptech.glide.request.RequestCoordinator$RequestState r3 = com.bumptech.glide.request.RequestCoordinator.RequestState.FAILED     // Catch:{ all -> 0x002b }
            r2.errorState = r3     // Catch:{ all -> 0x002b }
            com.bumptech.glide.request.RequestCoordinator r3 = r2.parent     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0029
            r3.onRequestFailed(r2)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.ErrorRequestCoordinator.onRequestFailed(com.bumptech.glide.request.Request):void");
    }

    public void onRequestSuccess(Request request) {
        synchronized (this.requestLock) {
            if (request.equals(this.primary)) {
                this.primaryState = RequestCoordinator.RequestState.SUCCESS;
            } else if (request.equals(this.error)) {
                this.errorState = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.parent;
            if (requestCoordinator != null) {
                requestCoordinator.onRequestSuccess(this);
            }
        }
    }

    public void pause() {
        synchronized (this.requestLock) {
            RequestCoordinator.RequestState requestState = this.primaryState;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.primaryState = RequestCoordinator.RequestState.PAUSED;
                this.primary.pause();
            }
            if (this.errorState == requestState2) {
                this.errorState = RequestCoordinator.RequestState.PAUSED;
                this.error.pause();
            }
        }
    }

    public void setRequests(Request request, Request request2) {
        this.primary = request;
        this.error = request2;
    }
}
