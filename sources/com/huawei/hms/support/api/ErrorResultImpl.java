package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public abstract class ErrorResultImpl<R extends Result> extends PendingResult<R> {

    /* renamed from: a  reason: collision with root package name */
    private R f49811a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f49812b;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ResultCallback f49813a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ErrorResultImpl f49814b;

        public a(ResultCallback resultCallback, ErrorResultImpl errorResultImpl) {
            this.f49813a = resultCallback;
            this.f49814b = errorResultImpl;
        }

        public void run() {
            ResultCallback resultCallback = this.f49813a;
            ErrorResultImpl errorResultImpl = ErrorResultImpl.this;
            resultCallback.onResult(errorResultImpl.a(errorResultImpl.f49812b, this.f49814b));
        }
    }

    public ErrorResultImpl(int i11) {
        this.f49812b = i11;
    }

    public final R await() {
        return await(0, (TimeUnit) null);
    }

    @Deprecated
    public void cancel() {
    }

    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public void postRunnable(Looper looper, ResultCallback<R> resultCallback, ErrorResultImpl errorResultImpl) {
        if (looper == null) {
            looper = Looper.myLooper();
        }
        new Handler(looper).post(new a(resultCallback, errorResultImpl));
    }

    public final void setResultCallback(ResultCallback<R> resultCallback) {
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    public R await(long j11, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return a(this.f49812b, this);
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    /* access modifiers changed from: private */
    public R a(int i11, ErrorResultImpl errorResultImpl) {
        Type genericSuperclass = errorResultImpl.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        try {
            R r11 = (Result) GenericTypeReflector.getType(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).newInstance();
            this.f49811a = r11;
            r11.setStatus(new Status(i11));
        } catch (InstantiationException unused) {
            HMSLog.e("ErrorResultImpl", "InstantiationException");
        } catch (IllegalAccessException unused2) {
            HMSLog.e("ErrorResultImpl", "IllegalAccessException");
        }
        return this.f49811a;
    }

    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j11, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        postRunnable(looper, resultCallback, this);
    }
}
