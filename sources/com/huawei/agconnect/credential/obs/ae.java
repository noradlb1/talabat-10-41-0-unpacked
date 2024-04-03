package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.common.api.Logger;
import com.huawei.agconnect.core.service.EndpointService;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import okhttp3.Dns;

public class ae implements EndpointService {

    /* renamed from: a  reason: collision with root package name */
    private r f47558a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f47559b = false;

    public static class a implements Callable<String> {

        /* renamed from: a  reason: collision with root package name */
        String f47560a;

        /* renamed from: b  reason: collision with root package name */
        String f47561b;

        public static a a(String str, String str2) {
            a aVar = new a();
            aVar.f47560a = str;
            aVar.f47561b = str2;
            return aVar;
        }

        private boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                int indexOf = str.indexOf(CertificateUtil.DELIMITER);
                Dns.SYSTEM.lookup(indexOf != -1 ? str.substring(0, indexOf) : str);
                return true;
            } catch (UnknownHostException unused) {
                Logger.e("EndpointServiceImpl", "checkUrl#UnknownHostException:" + str);
                return false;
            }
        }

        /* renamed from: a */
        public String call() {
            if (a(this.f47560a)) {
                return this.f47560a;
            }
            if (a(this.f47561b)) {
                return this.f47561b;
            }
            throw new IOException("main/backup url both are invalid");
        }
    }

    public ae(Context context, AGConnectInstance aGConnectInstance) {
        this.f47558a = new r(aGConnectInstance.getOptions().getString("agcgw/url"), aGConnectInstance.getOptions().getString("agcgw/backurl"));
        if (n.a().b().containsKey(this.f47558a)) {
            this.f47558a = n.a().b().get(this.f47558a).a();
            this.f47559b = n.a().b().get(this.f47558a).b().booleanValue();
        }
    }

    public Task<String> getEndpointDomain(boolean z11) {
        if (z11 || !this.f47559b) {
            return Tasks.callInBackground(a.a(this.f47558a.a(), this.f47558a.b()));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(this.f47558a.c());
        return taskCompletionSource.getTask();
    }
}
