package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.common.api.BaseResponse;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.agconnect.exception.AGCNetworkException;
import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.agconnect.https.Adapter;
import com.huawei.agconnect.https.HttpsException;
import com.huawei.agconnect.https.HttpsKit;
import com.huawei.agconnect.https.HttpsResult;
import com.huawei.agconnect.https.Method;
import com.huawei.agconnect.https.adapter.JsonAdapterFactory;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.Interceptor;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final n f47594a = new n();

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f47595b = v.a();

    /* renamed from: c  reason: collision with root package name */
    private final Map<r, t> f47596c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Adapter.Factory f47597d = new JsonAdapterFactory();

    private n() {
    }

    public static n a() {
        return f47594a;
    }

    private HttpsKit a(Context context, List<Interceptor> list, Authenticator authenticator, long j11, TimeUnit timeUnit) {
        if (j11 == 0) {
            timeUnit = TimeUnit.MILLISECONDS;
            j11 = 5000;
        }
        return new HttpsKit.Builder().client(new p(context, Collections.unmodifiableList(list), true).a(authenticator).a(j11, timeUnit)).executor(f47595b).build();
    }

    private <Req> Method a(Req req, int i11, Adapter.Factory factory) {
        return i11 == 1 ? new Method.Post(req, factory) : i11 == 2 ? new Method.Put(req, factory) : new Method.Get(req);
    }

    public <Req, Rsp> Task<Rsp> a(Req req, int i11, Class<Rsp> cls, AGConnectOptions aGConnectOptions) {
        return a(req, i11, cls, this.f47597d, 5000, TimeUnit.MILLISECONDS, (List<Interceptor>) null, (Authenticator) null, aGConnectOptions);
    }

    public <Req, Rsp> Task<Rsp> a(Req req, int i11, final Class<Rsp> cls, Adapter.Factory factory, long j11, TimeUnit timeUnit, List<Interceptor> list, Authenticator authenticator, AGConnectOptions aGConnectOptions) {
        List<Interceptor> list2 = list;
        AGConnectOptions aGConnectOptions2 = aGConnectOptions;
        final Adapter.Factory factory2 = factory != null ? factory : this.f47597d;
        String string = aGConnectOptions2.getString("agcgw/url");
        String string2 = aGConnectOptions2.getString("agcgw/backurl");
        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
            Context b11 = w.a().b();
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            ArrayList arrayList = new ArrayList();
            if (list2 != null) {
                arrayList.addAll(list2);
            } else {
                arrayList.add(new u(string, string2));
            }
            HttpsKit a11 = a(b11, arrayList, authenticator, j11, timeUnit);
            Req req2 = req;
            int i12 = i11;
            Class<Rsp> cls2 = cls;
            a11.create(b11).execute(a(req, i11, factory2)).addOnSuccessListener(TaskExecutors.immediate(), new OnSuccessListener<HttpsResult>() {
                /* renamed from: a */
                public void onSuccess(HttpsResult httpsResult) {
                    Object obj;
                    if (httpsResult.isSuccess()) {
                        if (String.class.equals(cls)) {
                            obj = httpsResult.getResponse();
                        } else {
                            try {
                                obj = httpsResult.getResponse(cls, factory2);
                            } catch (RuntimeException e11) {
                                taskCompletionSource.setException(e11);
                                return;
                            }
                        }
                        taskCompletionSource.setResult(obj);
                        return;
                    }
                    if (httpsResult.code() == 401) {
                        try {
                            BaseResponse baseResponse = (BaseResponse) httpsResult.getResponse(BaseResponse.class, factory2);
                            if (!(baseResponse == null || baseResponse.getRet() == null)) {
                                taskCompletionSource.setException(new AGCServerException(httpsResult.getErrorMsg(), httpsResult.code(), baseResponse.getRet().getCode()));
                                return;
                            }
                        } catch (RuntimeException unused) {
                            Logger.e("BackendImpl", "get base response error");
                        }
                    }
                    taskCompletionSource.setException(new AGCServerException(httpsResult.getErrorMsg(), httpsResult.code()));
                }
            }).addOnFailureListener(TaskExecutors.immediate(), (OnFailureListener) new OnFailureListener() {
                public void onFailure(Exception exc) {
                    taskCompletionSource.setException(exc instanceof HttpsException ? !((HttpsException) exc).hasRequest() ? new AGCNetworkException(exc.getMessage(), 0) : new AGCNetworkException(exc.getMessage(), 1) : new AGCServerException(exc.getMessage(), 2));
                }
            });
            return taskCompletionSource.getTask();
        }
        throw new InvalidParameterException("url is null");
    }

    public Map<r, t> b() {
        return this.f47596c;
    }
}
