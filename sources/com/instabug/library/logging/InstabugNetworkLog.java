package com.instabug.library.logging;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.model.NetworkLog;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class InstabugNetworkLog {
    /* access modifiers changed from: private */
    public NetworkLog networkLog = new NetworkLog();

    public class a implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f51423a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51424b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f51425c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f51426d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51427e;

        public a(int i11, String str, String str2, String str3, String str4) {
            this.f51423a = i11;
            this.f51424b = str;
            this.f51425c = str2;
            this.f51426d = str3;
            this.f51427e = str4;
        }

        public void run() throws Exception {
            if (InstabugNetworkLog.this.networkLog == null) {
                NetworkLog unused = InstabugNetworkLog.this.networkLog = new NetworkLog();
            }
            InstabugNetworkLog.this.networkLog.setResponseCode(this.f51423a);
            NetworkLog a11 = InstabugNetworkLog.this.networkLog;
            a11.setDate(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds() + "");
            InstabugNetworkLog.this.networkLog.setMethod(this.f51424b);
            InstabugNetworkLog.this.networkLog.setUrl(this.f51425c);
            try {
                InstabugNetworkLog.this.networkLog.setRequest(this.f51426d);
                InstabugNetworkLog.this.networkLog.setResponse(this.f51427e);
                InstabugNetworkLog.this.insert();
            } catch (IllegalArgumentException unused2) {
                InstabugSDKLogger.e("IBG-Core", "Content-type is not allowed to be logged");
                NetworkLog unused3 = InstabugNetworkLog.this.networkLog = null;
            }
        }
    }

    public class b implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HttpURLConnection f51429a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51430b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f51431c;

        public b(HttpURLConnection httpURLConnection, String str, String str2) {
            this.f51429a = httpURLConnection;
            this.f51430b = str;
            this.f51431c = str2;
        }

        public void run() throws Exception {
            if (InstabugNetworkLog.this.networkLog == null) {
                NetworkLog unused = InstabugNetworkLog.this.networkLog = new NetworkLog();
            }
            InstabugNetworkLog.this.networkLog.setResponseCode(this.f51429a.getResponseCode());
            NetworkLog a11 = InstabugNetworkLog.this.networkLog;
            a11.setDate(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds() + "");
            InstabugNetworkLog.this.networkLog.setMethod(this.f51429a.getRequestMethod());
            InstabugNetworkLog.this.networkLog.setUrl(this.f51429a.getURL().toString());
            try {
                InstabugNetworkLog.this.d(this.f51429a);
                InstabugNetworkLog.this.networkLog.setRequest(this.f51430b);
                InstabugNetworkLog.this.networkLog.setResponse(this.f51431c);
            } catch (JSONException e11) {
                e11.printStackTrace();
            } catch (IllegalArgumentException unused2) {
                InstabugSDKLogger.e("IBG-Core", "Content-type is not allowed to be logged");
                return;
            }
            InstabugNetworkLog.this.insert();
        }
    }

    public class c implements VoidRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f51433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f51435c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f51436d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51437e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f51438f;

        public c(int i11, String str, String str2, long j11, String str3, String str4) {
            this.f51433a = i11;
            this.f51434b = str;
            this.f51435c = str2;
            this.f51436d = j11;
            this.f51437e = str3;
            this.f51438f = str4;
        }

        public void run() {
            if (InstabugNetworkLog.this.networkLog == null) {
                NetworkLog unused = InstabugNetworkLog.this.networkLog = new NetworkLog();
            }
            InstabugNetworkLog.this.networkLog.setResponseCode(this.f51433a);
            NetworkLog a11 = InstabugNetworkLog.this.networkLog;
            a11.setDate(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds() + "");
            InstabugNetworkLog.this.networkLog.setMethod(this.f51434b);
            InstabugNetworkLog.this.networkLog.setUrl(this.f51435c);
            InstabugNetworkLog.this.networkLog.setTotalDuration(this.f51436d);
            try {
                InstabugNetworkLog.this.networkLog.setRequest(this.f51437e);
                InstabugNetworkLog.this.networkLog.setResponse(this.f51438f);
                InstabugNetworkLog.this.insert();
            } catch (IllegalArgumentException unused2) {
                InstabugSDKLogger.e("IBG-Core", "Content-type is not allowed to be logged");
                NetworkLog unused3 = InstabugNetworkLog.this.networkLog = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void insert() {
        NetworkLog networkLog2 = this.networkLog;
        if (networkLog2 != null) {
            networkLog2.insert();
        }
    }

    @VisibleForTesting
    public void d(HttpURLConnection httpURLConnection) throws JSONException, IllegalArgumentException {
        List<String> list;
        JSONObject jSONObject = new JSONObject();
        for (String next : httpURLConnection.getHeaderFields().keySet()) {
            if (!(next == null || (list = httpURLConnection.getHeaderFields().get(next)) == null || list.isEmpty())) {
                for (String str : list) {
                    if (!next.equalsIgnoreCase(NetworkLog.CONTENT_TYPE) || str.contains("application/json") || str.contains(NetworkLog.XML_1) || str.contains(NetworkLog.XML_2) || str.contains(NetworkLog.PROTOBUF) || str.contains(NetworkLog.HTML) || str.contains("text/plain")) {
                        jSONObject.put(next, (Object) str);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                continue;
            }
        }
        if (this.networkLog == null) {
            this.networkLog = new NetworkLog();
        }
        this.networkLog.setRequestHeaders(JSONObjectInstrumentation.toString(jSONObject));
    }

    @Deprecated
    public void log(String str, String str2, @Nullable String str3, @Nullable String str4, int i11) throws IOException {
        APIChecker.checkAndRunInExecutor("NetworkLog.log", new a(i11, str2, str, str3, str4));
    }

    public void log(HttpURLConnection httpURLConnection, @Nullable String str, @Nullable String str2) throws IOException {
        APIChecker.checkAndRunInExecutor("NetworkLog.log", new b(httpURLConnection, str, str2));
    }

    public void log(String str, String str2, @Nullable String str3, @Nullable String str4, int i11, long j11) {
        APIChecker.checkAndRunInExecutor("NetworkLog.log", new c(i11, str2, str, j11, str3, str4));
    }
}
