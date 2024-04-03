package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;
import k6.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0011R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/RequestProgress;", "", "callbackHandler", "Landroid/os/Handler;", "request", "Lcom/facebook/GraphRequest;", "(Landroid/os/Handler;Lcom/facebook/GraphRequest;)V", "lastReportedProgress", "", "<set-?>", "maxProgress", "getMaxProgress", "()J", "progress", "getProgress", "threshold", "addProgress", "", "size", "addToMax", "reportProgress", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RequestProgress {
    @Nullable
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    @NotNull
    private final GraphRequest request;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    public RequestProgress(@Nullable Handler handler, @NotNull GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        this.callbackHandler = handler;
        this.request = graphRequest;
    }

    /* access modifiers changed from: private */
    /* renamed from: reportProgress$lambda-0  reason: not valid java name */
    public static final void m8875reportProgress$lambda0(GraphRequest.Callback callback, long j11, long j12) {
        ((GraphRequest.OnProgressCallback) callback).onProgress(j11, j12);
    }

    public final void addProgress(long j11) {
        long j12 = this.progress + j11;
        this.progress = j12;
        if (j12 >= this.lastReportedProgress + this.threshold || j12 >= this.maxProgress) {
            reportProgress();
        }
    }

    public final void addToMax(long j11) {
        this.maxProgress += j11;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final void reportProgress() {
        Boolean bool;
        if (this.progress > this.lastReportedProgress) {
            GraphRequest.Callback callback = this.request.getCallback();
            long j11 = this.maxProgress;
            if (j11 > 0 && (callback instanceof GraphRequest.OnProgressCallback)) {
                long j12 = this.progress;
                Handler handler = this.callbackHandler;
                if (handler == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(handler.post(new s(callback, j12, j11)));
                }
                if (bool == null) {
                    ((GraphRequest.OnProgressCallback) callback).onProgress(j12, j11);
                }
                this.lastReportedProgress = this.progress;
            }
        }
    }
}
