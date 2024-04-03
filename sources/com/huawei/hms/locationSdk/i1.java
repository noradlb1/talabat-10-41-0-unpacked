package com.huawei.hms.locationSdk;

import android.content.Context;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.location.router.RouterTaskHandler;
import com.huawei.location.router.entity.RouterRequest;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class i1<TResult, TClient extends AnyClient, TOption extends Api.ApiOptions> implements InvocationHandler {

    /* renamed from: d  reason: collision with root package name */
    private static final Object[] f49190d = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    private final Object f49191a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f49192b;

    /* renamed from: c  reason: collision with root package name */
    private RouterTaskHandler f49193c;

    public class a extends CancellationToken {
        public a(i1 i1Var) {
        }

        public boolean isCancellationRequested() {
            return false;
        }

        public CancellationToken register(Runnable runnable) {
            return null;
        }
    }

    private i1(Context context, Object obj) {
        this.f49191a = obj;
        this.f49192b = new WeakReference<>(context);
    }

    private Task<TResult> a(Object[] objArr) {
        ApiException apiException;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (objArr == null || objArr.length == 0) {
            apiException = new ApiException(Status.FAILURE);
        } else {
            if (this.f49193c == null) {
                RouterTaskHandler instance = RouterTaskHandler.getInstance();
                this.f49193c = instance;
                instance.initTaskCall(this.f49192b.get());
            }
            h0 h0Var = null;
            AbstractClientBuilder abstractClientBuilder = null;
            for (h0 h0Var2 : objArr) {
                if (h0Var2 instanceof h0) {
                    h0Var = a(h0Var2);
                }
                if (h0Var2 instanceof AbstractClientBuilder) {
                    abstractClientBuilder = (AbstractClientBuilder) h0Var2;
                }
            }
            if (h0Var == null || abstractClientBuilder == null) {
                apiException = new ApiException(Status.FAILURE);
            } else {
                synchronized (f49190d) {
                    this.f49193c.enqueue(new RouterRequest(h0Var.getUri(), h0Var.getRequestJson(), h0Var.getTransactionId(), new g1(h0Var, taskCompletionSource, abstractClientBuilder), h0Var.getParcelable()));
                    HMSLog.i("LiteSDKApiProxyHandler", "handlerLiteTask success");
                }
                return taskCompletionSource.getTask();
            }
        }
        taskCompletionSource.setException(apiException);
        return taskCompletionSource.getTask();
    }

    private h0<TClient, TResult> a(h0<TClient, TResult> h0Var) {
        h0Var.setToken(new a(this));
        return h0Var;
    }

    public static Object a(Context context, Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new i1(context, obj));
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
        if (!method.isAnnotationPresent(h1.class)) {
            return method.invoke(this.f49191a, objArr);
        }
        HMSLog.i("LiteSDKApiProxyHandler", "not find HMS Core ,try use lite");
        return a(objArr);
    }
}
