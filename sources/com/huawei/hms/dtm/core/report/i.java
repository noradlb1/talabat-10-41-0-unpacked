package com.huawei.hms.dtm.core.report;

import com.google.android.exoplayer2.C;
import com.google.firebase.perf.FirebasePerformance;
import com.huawei.hms.dtm.core.C0391jd;
import com.huawei.hms.dtm.core.DynamicTagManager;
import com.huawei.hms.dtm.core.Fc;
import com.huawei.hms.dtm.core.Gc;
import com.huawei.hms.dtm.core.Hc;
import com.huawei.hms.dtm.core.J;
import com.huawei.hms.dtm.core.M;
import com.huawei.hms.dtm.core.Q;
import com.huawei.hms.dtm.core.V;
import com.huawei.hms.dtm.core.util.Logger;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f48579a = Arrays.asList(new String[]{"GET", "POST", "PUT", FirebasePerformance.HttpMethod.HEAD});

    /* renamed from: b  reason: collision with root package name */
    private final a f48580b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f48581c = new ArrayList();

    public i(a aVar) {
        this.f48580b = aVar;
    }

    private int a(List<Q> list) {
        M b11 = M.b();
        int i11 = -1;
        for (Q next : list) {
            if (next != null) {
                String a11 = a(next.h());
                if (!this.f48581c.contains(a11)) {
                    i11 = next.e();
                    Gc a12 = a(b11, next);
                    if (a12 != null) {
                        Logger.test("send request: " + MessageFormat.format("method:{0} url:{1} header:{2} body:{3}", new Object[]{next.f(), next.h(), next.d(), next.a()}));
                        try {
                            long nanoTime = System.nanoTime();
                            Hc a13 = Fc.a(a12);
                            if (a13.c() <= 0 && !this.f48581c.contains(a11)) {
                                this.f48581c.add(a11);
                            }
                            if (a13.c() > 0) {
                                this.f48581c.remove(a11);
                            }
                            long round = a13.c() == 0 ? -1 : Math.round(((double) (System.nanoTime() - nanoTime)) / 1000000.0d);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Send event the response is ");
                            sb2.append(a13.c());
                            sb2.append(" delay=");
                            sb2.append(round);
                            Logger.info("DTM-Report", sb2.toString());
                            a(next, a13, round);
                            a(b11, next, a13);
                        } catch (V unused) {
                            Logger.error("DTM-Report", "Wrong format url cause http exception, delete it");
                            b11.a(next.e());
                        }
                    }
                }
            }
        }
        return i11;
    }

    private Gc a(M m11, Q q11) {
        String str;
        Gc gc2 = new Gc();
        String d11 = q11.d();
        HashMap hashMap = new HashMap();
        if (d11 != null) {
            try {
                JSONObject jSONObject = new JSONObject(d11);
                JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i11 = 0; i11 < names.length(); i11++) {
                        String string = names.getString(i11);
                        hashMap.put(string, String.valueOf(jSONObject.get(string)));
                    }
                }
            } catch (JSONException unused) {
                str = "Illegal http headers, delete this event.";
            }
        }
        gc2.a((Map<String, String>) hashMap);
        try {
            gc2.a(new URL(q11.h()));
            gc2.a(q11.a());
            String f11 = q11.f();
            if (f11 == null || !f48579a.contains(f11)) {
                str = "Unsupported http method in this event, delete it.";
                Logger.error("DTM-Report", str);
                m11.b(q11.e());
                return null;
            }
            gc2.b(q11.f());
            return gc2;
        } catch (MalformedURLException unused2) {
            str = "MalformedURLException,means ";
        }
    }

    private String a(String str) {
        try {
            return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
        } catch (IOException unused) {
            Logger.error("DTM-Report", "IOException in getVendorHost");
            return "UNKNOWN";
        }
    }

    private void a() {
        M b11 = M.b();
        List<Q> c11 = b11.c(20);
        if (c11.isEmpty()) {
            Logger.debug("DTM-Report", "Empty reportList, stop report.");
            this.f48580b.a(true);
            return;
        }
        do {
            int a11 = a(c11);
            if (a11 != -1) {
                c11 = b11.a(a11, 20);
            } else {
                return;
            }
        } while (!c11.isEmpty());
        Logger.debug("DTM-Report", "All event has been reported once.");
    }

    private void a(M m11, Q q11, Hc hc2) {
        if (hc2.c() > 0) {
            m11.a(q11.e());
        } else {
            m11.b(q11);
        }
    }

    private void a(Q q11, Hc hc2, long j11) {
        String str;
        if (J.a() != null && hc2 != null) {
            int c11 = hc2.c();
            if (c11 < 200 || c11 >= 300) {
                str = hc2.b();
            } else if (q11.c() == 0) {
                str = "";
            } else {
                return;
            }
            C0391jd.a().a(DynamicTagManager.getInstance().getConfigurationID()).e(a(q11.h())).c(String.valueOf(c11)).d(String.valueOf(j11)).b(str).b();
        }
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        M b11 = M.b();
        b11.a(currentTimeMillis - 2592000000L);
        long a11 = b11.a() - C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        if (a11 > 0) {
            Logger.info("DTM-Report", "To much event, need to delete the early data");
            if (b11.b(a11)) {
                Logger.info("DTM-Report", "Delete from table event success, num=" + a11);
            }
        }
    }

    public void run() {
        Logger.info("DTM-Report", "report task begin.");
        b();
        a();
        this.f48581c.clear();
        a();
        Logger.info("DTM-Report", "report task end.");
    }
}
