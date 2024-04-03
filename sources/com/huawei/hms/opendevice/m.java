package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import com.deliveryhero.customerchat.eventTracking.constants.UserPropertyKeys;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class m {

    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f49656a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f49657b;

        public a(Context context, String str) {
            this.f49656a = context;
            this.f49657b = str;
        }

        public void run() {
            if (!d.b()) {
                HMSLog.d("ReportAaidToken", "Not HW Phone.");
            } else if (!m.b(this.f49656a)) {
                String a11 = b.a(this.f49656a);
                if (TextUtils.isEmpty(a11)) {
                    HMSLog.w("ReportAaidToken", "AAID is empty.");
                } else if (!m.d(this.f49656a, a11, this.f49657b)) {
                    HMSLog.d("ReportAaidToken", "This time need not report.");
                } else {
                    String string = AGConnectServicesConfig.fromContext(this.f49656a).getString("region");
                    if (TextUtils.isEmpty(string)) {
                        HMSLog.i("ReportAaidToken", "The data storage region is empty.");
                        return;
                    }
                    String a12 = k.a(this.f49656a, "com.huawei.hms.opendevicesdk", "ROOT", (String) null, string);
                    if (!TextUtils.isEmpty(a12)) {
                        String b11 = m.c(this.f49656a, a11, this.f49657b);
                        Context context = this.f49656a;
                        m.b(this.f49656a, g.a(context, a12 + "/rest/appdata/v1/aaid/report", b11, (Map<String, String>) null), a11, this.f49657b);
                    }
                }
            }
        }
    }

    public enum b {
        MOBILE("1"),
        PC(ExifInterface.GPS_MEASUREMENT_2D),
        TABLET(ExifInterface.GPS_MEASUREMENT_3D),
        TV(OnlineLocationService.SRC_DEFAULT),
        SOUNDBOX("5"),
        GLASS("6"),
        WATCH("7"),
        VEHICLE("8"),
        OFFICE_DEVICE("9"),
        IOT_DEVICES("10"),
        HEALTHY("11"),
        ENTERTAINMENT("12"),
        TRANSPORT_DEVICES("13");
        

        /* renamed from: a  reason: collision with root package name */
        private String f49672a;

        private b(String str) {
            this.f49672a = str;
        }

        public String a() {
            return this.f49672a;
        }
    }

    public enum c {
        IOS("ios"),
        ANDROID("android"),
        HARMONY("harmony"),
        WINDOWS("windows"),
        EMBED("embed"),
        OTHERS("others");
        

        /* renamed from: a  reason: collision with root package name */
        private String f49680a;

        private c(String str) {
            this.f49680a = str;
        }

        public String a() {
            return this.f49680a;
        }
    }

    /* access modifiers changed from: private */
    public static String c(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timezone", (Object) TimeZone.getDefault().getID());
            jSONObject2.put("country", (Object) SystemUtils.getLocalCountry());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("agent_version", (Object) new PackageManagerHelper(context).getPackageVersionName("com.huawei.android.pushagent"));
            jSONObject3.put("hms_version", (Object) String.valueOf(Util.getHmsVersion(context)));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("dev_type", (Object) b.MOBILE.a());
            jSONObject4.put("dev_sub_type", (Object) "phone");
            jSONObject4.put("os_type", (Object) c.ANDROID.a());
            jSONObject4.put(UserPropertyKeys.OS_VERSION, (Object) String.valueOf(HwBuildEx.VERSION.EMUI_SDK_INT));
            jSONObject.put("id", (Object) UUID.randomUUID().toString());
            jSONObject.put("global", (Object) jSONObject2);
            jSONObject.put("push_agent", (Object) jSONObject3);
            jSONObject.put("hardware", (Object) jSONObject4);
            jSONObject.put("aaid", (Object) str);
            jSONObject.put(LegacyTokenLocalDataSourceImpl.KEY, (Object) str2);
            jSONObject.put("app_id", (Object) AGConnectServicesConfig.fromContext(context).getString("client/app_id"));
            jSONObject.put("region", (Object) AGConnectServicesConfig.fromContext(context).getString("region"));
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException unused) {
            HMSLog.e("ReportAaidToken", "Catch JSONException.");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static boolean d(Context context, String str, String str2) {
        i a11 = i.a(context);
        if (!a11.containsKey("reportAaidAndToken")) {
            HMSLog.d("ReportAaidToken", "It hasn't been reported, this time needs report.");
            return true;
        }
        String string = a11.getString("reportAaidAndToken");
        if (TextUtils.isEmpty(string)) {
            HMSLog.e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
            return true;
        }
        return !string.equals(n.a(str2 + str, Constants.SHA256));
    }

    /* access modifiers changed from: private */
    public static boolean b(Context context) {
        int packageVersionCode = new PackageManagerHelper(context).getPackageVersionCode("com.huawei.android.pushagent");
        HMSLog.d("ReportAaidToken", "NC version code: " + packageVersionCode);
        return (90101400 <= packageVersionCode && packageVersionCode < 100000000) || packageVersionCode >= 100001301;
    }

    public static void a(Context context, String str) {
        new a(context, str).start();
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("ReportAaidToken", "Https response is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("ret", 256);
            if (optInt == 0) {
                boolean saveString = i.a(context).saveString("reportAaidAndToken", n.a(str3 + str2, Constants.SHA256));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Report success ");
                sb2.append(saveString ? "and save success." : "but save failure.");
                HMSLog.d("ReportAaidToken", sb2.toString());
                return;
            }
            HMSLog.e("ReportAaidToken", "Https response body's ret code: " + optInt + ", error message: " + jSONObject.optString("msg"));
        } catch (JSONException unused) {
            HMSLog.e("ReportAaidToken", "Has JSONException.");
        } catch (Exception unused2) {
            HMSLog.e("ReportAaidToken", "Exception occur.");
        }
    }
}
