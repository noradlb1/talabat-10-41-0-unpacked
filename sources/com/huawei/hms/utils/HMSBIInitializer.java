package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

@Instrumented
public class HMSBIInitializer {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f49925d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static HMSBIInitializer f49926e;

    /* renamed from: f  reason: collision with root package name */
    private static HiAnalyticsInstance f49927f;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f49928a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f49929b = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f49930c;

    public class a implements IQueryUrlCallBack {
        public a() {
        }

        public void onCallBackFail(int i11) {
            HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + i11);
            HMSBIInitializer.this.f49929b.set(false);
            com.huawei.hms.stats.a.c().a();
        }

        public void onCallBackSuccess(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (!HMSBIInitializer.this.f49930c) {
                    HmsHiAnalyticsUtils.init(HMSBIInitializer.this.f49928a, false, false, false, str, "com.huawei.hwid");
                } else {
                    HMSBIInitializer.this.a(str);
                }
                HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
            }
            HMSBIInitializer.this.f49929b.set(false);
            com.huawei.hms.stats.a.c().b();
        }
    }

    @Instrumented
    public class b extends AsyncTask implements TraceFieldInterface {
        public Trace _nr_trace;

        private b() {
        }

        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        public Void a(String... strArr) {
            HMSBIInitializer.this.b(strArr[0]);
            return null;
        }

        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "HMSBIInitializer$b#doInBackground", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "HMSBIInitializer$b#doInBackground", (ArrayList<String>) null);
            }
            Void a11 = a((String[]) objArr);
            TraceMachine.exitMethod();
            return a11;
        }

        public /* synthetic */ b(HMSBIInitializer hMSBIInitializer, a aVar) {
            this();
        }
    }

    private HMSBIInitializer(Context context) {
        this.f49928a = context;
        this.f49930c = HianalyticsExist.isHianalyticsExist();
    }

    public static HMSBIInitializer getInstance(Context context) {
        synchronized (f49925d) {
            if (f49926e == null && context != null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    f49926e = new HMSBIInitializer(applicationContext);
                } else {
                    f49926e = new HMSBIInitializer(context);
                }
            }
        }
        return f49926e;
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f49927f;
    }

    public void initBI() {
        boolean z11;
        if (!this.f49930c) {
            z11 = HmsHiAnalyticsUtils.getInitFlag();
        } else {
            z11 = HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        }
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + z11);
        if (!z11 && !AnalyticsSwitchHolder.isAnalyticsDisabled(this.f49928a)) {
            HMSLog.i("HMSBIInitializer", "Builder->biInitFlag : start initHaSDK");
            initHaSDK();
        }
    }

    public void initHaSDK() {
        if (this.f49929b.compareAndSet(false, true)) {
            String issueCountryCode = GrsApp.getInstance().getIssueCountryCode(this.f49928a);
            if (!TextUtils.isEmpty(issueCountryCode)) {
                issueCountryCode = issueCountryCode.toUpperCase(Locale.ENGLISH);
            }
            if ("UNKNOWN".equalsIgnoreCase(issueCountryCode) || TextUtils.isEmpty(issueCountryCode)) {
                HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
                this.f49929b.set(false);
                return;
            }
            AsyncTaskInstrumentation.execute(new b(this, (a) null), issueCountryCode);
        }
    }

    public boolean isInit() {
        if (!this.f49930c) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        HiAnalyticsInstance instanceByTag = HiAnalyticsManager.getInstanceByTag(HiAnalyticsConstant.HA_SERVICE_TAG);
        f49927f = instanceByTag;
        if (instanceByTag != null) {
            instanceByTag.setAppid("com.huawei.hwid");
            return;
        }
        HiAnalyticsConfig build = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build();
        HiAnalyticsInstance create = new HiAnalyticsInstance.Builder(this.f49928a).setOperConf(build).setMaintConf(new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(str).build()).create(HiAnalyticsConstant.HA_SERVICE_TAG);
        f49927f = create;
        if (create != null) {
            create.setAppid("com.huawei.hwid");
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
        grsBaseInfo.setIssueCountry(str);
        new GrsClient(this.f49928a, grsBaseInfo).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new a());
    }
}
