package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.h.c;
import com.huawei.hms.framework.network.grs.local.model.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, b> f48868b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f48869c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private a f48870a;

    public b(Context context, boolean z11) {
        a(context, z11);
        f48868b.put(context.getPackageName(), this);
    }

    public static b a(String str) {
        return f48868b.get(str);
    }

    private void a(Context context, boolean z11) {
        long j11;
        StringBuilder sb2;
        String[] strArr;
        long currentTimeMillis = System.currentTimeMillis();
        String a11 = c.a("grs_route_config_files_list.txt", context);
        Logger.i("LocalManagerProxy", "Io.getConfigContent timeCost:" + (System.currentTimeMillis() - currentTimeMillis));
        Logger.i("LocalManagerProxy", "initLocalManager configFileListContent:" + a11);
        if (TextUtils.isEmpty(a11)) {
            Logger.i("LocalManagerProxy", "Get config files list by AssetsManager");
            j11 = System.currentTimeMillis();
            strArr = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
            sb2 = new StringBuilder();
        } else {
            j11 = System.currentTimeMillis();
            Logger.i("LocalManagerProxy", "Get config files list use configFileListContent: " + a11);
            strArr = a11.split("#");
            sb2 = new StringBuilder();
        }
        sb2.append("list timeCost:");
        sb2.append(System.currentTimeMillis() - j11);
        Logger.i("LocalManagerProxy", sb2.toString());
        List arrayList = strArr == null ? new ArrayList() : Arrays.asList(strArr);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        Logger.i("LocalManagerProxy", "contains APP_20_CONFIG_FILE_NAME: " + arrayList.contains("grs_app_global_route_config.json"));
        boolean z12 = false;
        this.f48870a = new d(false, z11);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f48870a = new d(context, appConfigName, z11);
        }
        if (!this.f48870a.c() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f48870a = new c(context, z11);
        }
        this.f48870a.a(context, (List<String>) arrayList);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("on initLocalManager finish, check appGrs: ");
        if (this.f48870a.f48863a == null) {
            z12 = true;
        }
        sb3.append(z12);
        Logger.i("LocalManagerProxy", sb3.toString());
    }

    public a a() {
        return this.f48870a.a();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z11) {
        String a11;
        synchronized (f48869c) {
            a11 = this.f48870a.a(context, aVar, grsBaseInfo, str, str2, z11);
        }
        return a11;
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z11) {
        Map<String, String> a11;
        synchronized (f48869c) {
            a11 = this.f48870a.a(context, aVar, grsBaseInfo, str, z11);
        }
        return a11;
    }

    public Set<String> b() {
        return this.f48870a.b();
    }
}
