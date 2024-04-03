package com.huawei.hms.locationSdk;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.locationSdk.g;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.interfaces.IRouterCallback;
import java.util.ArrayList;
import java.util.List;

class g1<TResult, TClient extends AnyClient, TOption extends Api.ApiOptions> implements IRouterCallback {

    /* renamed from: a  reason: collision with root package name */
    private TaskApiCall<TClient, TResult> f49182a;

    /* renamed from: b  reason: collision with root package name */
    private TaskCompletionSource<TResult> f49183b;

    /* renamed from: c  reason: collision with root package name */
    private AbstractClientBuilder<TClient, TOption> f49184c;

    /* renamed from: d  reason: collision with root package name */
    private String f49185d;

    public class a implements BaseHmsClient.OnConnectionFailedListener {
        public a(g1 g1Var) {
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
        }
    }

    public class b implements BaseHmsClient.ConnectionCallbacks {
        public b(g1 g1Var) {
        }

        public void onConnected() {
        }

        public void onConnectionSuspended(int i11) {
        }
    }

    public g1(TaskApiCall<TClient, TResult> taskApiCall, TaskCompletionSource<TResult> taskCompletionSource, AbstractClientBuilder<TClient, TOption> abstractClientBuilder) {
        this.f49182a = taskApiCall;
        this.f49183b = taskCompletionSource;
        this.f49184c = abstractClientBuilder;
    }

    private ClientSettings a() {
        Context context = ContextUtil.getContext();
        ClientSettings clientSettings = new ClientSettings(context.getPackageName(), context.getClass().getName(), new ArrayList(), Util.getAppId(ContextUtil.getContext()), (List<String>) null);
        clientSettings.setCpID(Util.getCpId(context));
        if (TextUtils.isEmpty(this.f49185d)) {
            this.f49185d = HMSPackageManager.getInstance(context).getHMSPackageName();
            HMSLog.i("LiteApiListener", "inner hms is empty,hms pkg name is " + this.f49185d);
        }
        clientSettings.setInnerHmsPkg(this.f49185d);
        return clientSettings;
    }

    private void a(RouterResponse routerResponse) {
        if (routerResponse != null && this.f49182a != null) {
            this.f49182a.onResponse(b(), new k1(routerResponse.getStatusInfo(), routerResponse.getTransactionId()), routerResponse.getBody(), this.f49183b);
            HMSLog.d("LiteApiListener", "doTaskExecute onResponse success");
        }
    }

    private TClient b() {
        return this.f49184c.buildClient(ContextUtil.getContext(), a(), new a(this), new g.a(ContextUtil.getContext(), new b(this)));
    }

    public void doExecute(RouterResponse routerResponse) {
        a(routerResponse);
    }

    public void onComplete(RouterResponse routerResponse) {
        a(routerResponse);
    }
}
