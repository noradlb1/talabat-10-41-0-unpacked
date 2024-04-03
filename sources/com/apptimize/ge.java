package com.apptimize;

import android.app.Activity;
import com.apptimize.ag;
import com.apptimize.ap;
import com.apptimize.bj;
import com.apptimize.dp;
import com.apptimize.dt;
import com.apptimize.gd;
import com.apptimize.gn;
import com.apptimize.gr;
import com.apptimize.z;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.tekartik.sqflite.Constant;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ge implements ao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42526a = "ge";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f42527b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f42528c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final gd f42529d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f42530e;

    /* renamed from: f  reason: collision with root package name */
    private final String f42531f;

    /* renamed from: g  reason: collision with root package name */
    private final dt f42532g;

    /* renamed from: h  reason: collision with root package name */
    private final bz f42533h;

    /* renamed from: i  reason: collision with root package name */
    private final ag f42534i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ap f42535j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final AtomicReference<Date> f42536k = new AtomicReference<>(new Date());
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public au f42537l;

    /* renamed from: m  reason: collision with root package name */
    private final fp<JSONObject> f42538m = new fp<>(10);
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public gr.d f42539n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f42540o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f42541p = true;

    /* renamed from: q  reason: collision with root package name */
    private boolean f42542q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f42543r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f42544s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f42545t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f42546u;

    public class a implements z.a {
        private a() {
        }

        private ft<Long> b() {
            return new ft<Long>() {
                /* renamed from: a */
                public Long b() {
                    return Long.valueOf(((Date) ge.this.f42536k.get()).getTime());
                }
            };
        }

        public void a() {
            ge.this.a(true);
        }

        public void a(Activity activity) {
            ge.this.a(false);
            ge.this.f42536k.set(new Date());
            ge.this.f42535j.b("onApplicationResume", b(), ge.this.f42536k.get());
        }

        public void b(Activity activity) {
            a(activity);
        }
    }

    public class c implements dt.b {
        private c() {
        }

        public void a(long j11) {
            ge.this.a(j11);
        }

        public void a(String str, dp.k kVar, Map<String, Object> map) {
            ge.this.a(str, kVar, map);
        }
    }

    public ge(String str, String str2, String str3, String str4, bj.b bVar, dt dtVar, au auVar, boolean z11, boolean z12, boolean z13) {
        this.f42527b = str;
        this.f42530e = str2;
        this.f42528c = str3;
        this.f42531f = str4;
        this.f42529d = new gd(str4, bVar, new b(), auVar);
        this.f42532g = dtVar;
        this.f42533h = auVar.f();
        this.f42537l = auVar;
        this.f42542q = z11;
        this.f42544s = z12;
        this.f42546u = z13;
        this.f42534i = r();
        this.f42535j = q();
        dtVar.a((dt.b) new c());
    }

    private synchronized boolean l() {
        return this.f42540o;
    }

    private void m() {
        this.f42529d.e();
    }

    private synchronized void n() {
        if (!this.f42543r && !this.f42542q && !this.f42541p && this.f42544s) {
            if (!this.f42545t) {
                String format = String.format("Apptimize is in developer mode; connecting to websocket server as \"%s\" to enable test preview/dry-run.", new Object[]{this.f42528c});
                String str = f42526a;
                bo.h(str, format);
                if (this.f42546u) {
                    a("Multi-process app detected: Apptimize will not run in some parts of your app.");
                }
                bo.a(str, "Connecting developer mode websocket to " + this.f42531f);
                this.f42545t = true;
            }
            this.f42529d.c();
        }
    }

    private void o() {
        Iterator<JSONObject> it = this.f42538m.b().iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    private void p() {
        this.f42532g.f();
    }

    private ap q() {
        try {
            return new ap.a(this).a("onApplicationResume", ge.class.getDeclaredMethod("a", new Class[]{Date.class})).a(this.f42537l.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f42526a, "Error binding", e11);
            return null;
        }
    }

    private ag r() {
        try {
            return new ag.a(this).a("downloadMetaDataNow", ge.class.getDeclaredMethod("g", new Class[0])).a(this.f42537l.d());
        } catch (NoSuchMethodException e11) {
            bo.e(f42526a, "Error binding", e11);
            return null;
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "PrefixedAttributeUpdate");
            JSONArray jSONArray = new JSONArray();
            for (String put : this.f42532g.a(dl.b()).keySet()) {
                jSONArray.put((Object) put);
            }
            jSONObject.put("prefixedAttributeNames", (Object) jSONArray);
            this.f42529d.a(jSONObject);
        } catch (JSONException unused) {
            bo.b(f42526a, "Error while sending SendPrefixedAttributeUpdate message.");
        }
    }

    public void j() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "DynamicVariableUpdate");
            JSONArray jSONArray = new JSONArray();
            for (List<ApptimizeVar<?>> it : ej.a().values()) {
                for (ApptimizeVar apptimizeVar : it) {
                    jSONArray.put((Object) new JSONObject(apptimizeVar, k.c(apptimizeVar), k.a(apptimizeVar)) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ ApptimizeVar f42551a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ String f42552b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ Object f42553c;

                        {
                            this.f42551a = r3;
                            this.f42552b = r4;
                            this.f42553c = r5;
                            put("name", (Object) k.b(r3));
                            put("type", (Object) r4);
                            if (k.d(r3) != null) {
                                put("nestedType", (Object) k.d(r3));
                            }
                            if (r5 == null) {
                                put("defaultValue", JSONObject.NULL);
                            } else if (DefaultCardView.CARD_LIST.equals(r4)) {
                                put("defaultValue", (Object) new JSONArray((Collection<?>) (List) r5));
                            } else if ("dictionary".equals(r4)) {
                                JSONObject jSONObject = new JSONObject();
                                for (Map.Entry entry : ((Map) r5).entrySet()) {
                                    if (entry.getValue() != null) {
                                        jSONObject.put((String) entry.getKey(), entry.getValue());
                                    } else {
                                        jSONObject.put((String) entry.getKey(), JSONObject.NULL);
                                    }
                                }
                                put("defaultValue", (Object) jSONObject);
                            } else {
                                put("defaultValue", r5);
                            }
                        }
                    });
                }
            }
            jSONObject.put("variables", (Object) jSONArray);
            this.f42529d.a(jSONObject);
        } catch (JSONException unused) {
            bo.b(f42526a, "Error while sending DynamicVariableUpdate message.");
        }
    }

    /* access modifiers changed from: private */
    public synchronized void d(boolean z11) {
        this.f42540o = z11;
    }

    public synchronized void b(boolean z11) {
        if (this.f42542q != z11) {
            this.f42542q = z11;
            if (z11) {
                m();
            } else {
                n();
            }
        }
    }

    public synchronized void c(boolean z11) {
        if (this.f42544s != z11) {
            this.f42544s = z11;
            if (z11) {
                n();
            } else {
                m();
            }
        }
    }

    public synchronized void e() {
        n();
    }

    public synchronized void f() {
        this.f42543r = true;
        m();
    }

    public void g() {
        this.f42533h.i();
    }

    public boolean h() {
        return this.f42529d.a();
    }

    public void a(z zVar) {
        zVar.a(new a());
    }

    private void d(JSONObject jSONObject) {
        throw new UnsupportedOperationException("Requested to used old verify system");
    }

    public void a(gr.d dVar) {
        this.f42539n = dVar;
    }

    public long a(Date date) {
        String str = f42526a;
        bo.k(str, "onApplicationResume our resumeDate:" + this.f42536k.get().getTime() + " date:" + date.getTime());
        if (!date.after(this.f42536k.get())) {
            return this.f42536k.get().getTime();
        }
        a(true);
        return date.getTime();
    }

    public void b(JSONObject jSONObject) {
        if (l()) {
            a(jSONObject);
        } else {
            this.f42538m.a(jSONObject);
        }
    }

    public void c(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("accessToken");
            String str = f42526a;
            bo.q(str, "In order to pair this device, go to the administration website, click on \"Devices\", and click \"Add new device\". Follow the instructions there. Your access token: " + string);
        } catch (JSONException e11) {
            bo.b(f42526a, "Error processing NewDeviceTokenResponse.", e11);
        }
    }

    public synchronized void a(boolean z11) {
        String str = f42526a;
        bo.k(str, "updateAppSleeping:" + z11);
        this.f42541p = z11;
        if (z11) {
            m();
        } else {
            n();
        }
    }

    public void a(JSONObject jSONObject, au auVar) {
        String str;
        String optString = jSONObject.optString("type");
        if (optString == null) {
            bo.b(f42526a, "Type is null");
            this.f42529d.d();
        } else if (optString.equals("WebDisconnected")) {
            this.f42532g.f();
            gr.d dVar = this.f42539n;
            if (dVar != null) {
                dVar.b();
            }
        } else if (optString.equals("NewDeviceTokenResponse")) {
            c(jSONObject);
        } else if (optString.equals("TestVariationOverride")) {
            d(jSONObject);
        } else if (optString.equals("CancelOverride")) {
            p();
        } else if (!optString.equals("ExperimentStatusUpdateRequest")) {
            if (optString.equals("DownloadMetaDataNow")) {
                bz bzVar = this.f42533h;
                if (bzVar != null) {
                    bzVar.i();
                } else {
                    this.f42534i.a("downloadMetaDataNow", new Object[0]);
                }
            } else if (optString.equals("WysiwygSettings")) {
                gr.d dVar2 = this.f42539n;
                if (dVar2 == null) {
                    bo.n(f42526a, "Wysiwyg callbacks not set and received WysiwygSettings; ignoring.");
                } else {
                    dVar2.a(jSONObject);
                }
            } else if (optString.equals("SendEverything")) {
                gr.d dVar3 = this.f42539n;
                if (dVar3 == null) {
                    bo.n(f42526a, "Wysiwyg callbacks not set and received SendEverything; ignoring.");
                } else {
                    dVar3.b(jSONObject);
                }
            } else if (optString.equals("SnapShotReceived")) {
                gr.d dVar4 = this.f42539n;
                if (dVar4 == null) {
                    bo.n(f42526a, "Wysiwyg callbacks not set and received SnapShotReceived; ignoring.");
                } else {
                    dVar4.e(jSONObject);
                }
            } else if (optString.equals("SetWysiwygData")) {
                gr.d dVar5 = this.f42539n;
                if (dVar5 == null) {
                    bo.n(f42526a, "Wysiwyg callbacks not set and received SetWysiwygData; ignoring.");
                } else {
                    dVar5.c(jSONObject);
                }
            } else if (optString.equals("LeaveWysiwygDeveloperMode")) {
                gr.d dVar6 = this.f42539n;
                if (dVar6 == null) {
                    bo.n(f42526a, "Wysiwyg callbacks not set and received LeaveWysiwygDeveloperMode; ignoring.");
                    return;
                }
                dVar6.d(jSONObject);
                this.f42539n.b();
            } else if (optString.equals("SendLogMessages")) {
                d(true);
                bp.b();
                o();
            } else if (optString.equals("ImageResponse")) {
                gr.d dVar7 = this.f42539n;
                if (dVar7 == null) {
                    bo.n(f42526a, "Wysiwyg callbacks not set and received ImageResponse; ignoring.");
                } else {
                    dVar7.f(jSONObject);
                }
            } else if (optString.equals("MetadataOverride")) {
                try {
                    cb b11 = cb.b(jSONObject.getJSONObject(TtmlNode.TAG_METADATA), auVar);
                    this.f42532g.a(b11);
                    a(b11.l(), new bb(this.f42532g.x(), this.f42532g.z(), this.f42532g.A(), this.f42532g.B(), this.f42532g.C(), b11.m(), b11.f()));
                } catch (ca e11) {
                    bo.k(f42526a, "Invalid metadata: ", e11);
                } catch (JSONException e12) {
                    bo.k(f42526a, "Unexpected error when reading metadata: ", e12);
                }
            } else if (optString.equals("SendPrefixedAttributeUpdate")) {
                i();
            } else if (!optString.equals("Error")) {
                bo.s(f42526a, "Unknown message type: " + jSONObject);
                this.f42529d.d();
            } else if (jSONObject.optInt(Constant.PARAM_ERROR_CODE) == 8) {
                f();
                if (!j.a().equals(this.f42529d.b())) {
                    str = " when connecting to server " + this.f42529d.b();
                } else {
                    str = "";
                }
                bo.p(f42526a, "The app key is invalid" + str + ". Please check that you have copied it correctly.");
            } else {
                bo.s(f42526a, "Received error message: " + jSONObject);
                this.f42529d.d();
            }
        }
    }

    @Instrumented
    public class b implements gd.b {
        private b() {
        }

        public void a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", (Object) "DeviceHello");
                jSONObject.put("version", (Object) fx.a());
                jSONObject.put("platform", (Object) "android");
                jSONObject.put(DistributedTracing.NR_GUID_ATTRIBUTE, (Object) ge.this.f42530e);
                jSONObject.put("appKey", (Object) ge.this.f42527b);
                jSONObject.put("deviceInfo", (Object) new JSONObject() {
                    {
                        put("name", (Object) ge.this.f42528c);
                    }
                });
                jSONObject.put("supportedFeatures", (Object) new JSONObject() {
                    {
                        put(TtmlNode.TAG_METADATA, 4);
                        put("visual", gn.a(gn.b.f42666d) ? 1 : 0);
                        put("visualVerify", 2);
                        put("noAnimationOnStyling", 1);
                        put("dynamicVariables", 1);
                        put("prefixedAttributes", 2);
                        put("wysiwygSettings", 1);
                    }
                });
                String k11 = ge.f42526a;
                bo.d(k11, "Sending connect message " + JSONObjectInstrumentation.toString(jSONObject));
                ge.this.f42529d.a(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("type", (Object) "NewDeviceTokenRequest");
                    ge.this.f42529d.a(jSONObject2);
                    ge.this.j();
                    ge.this.i();
                    bp.a(ge.this.f42529d);
                } catch (JSONException e11) {
                    bo.b(ge.f42526a, "Exception while requesting a new device token.", e11);
                }
            } catch (JSONException e12) {
                bo.b(ge.f42526a, "Exception while creating hello.", e12);
            }
        }

        public void b() {
            bo.o(ge.f42526a, "Websocket disconnected");
            ge.this.d(false);
            bp.a();
            if (ge.this.f42539n != null) {
                ge.this.f42539n.b();
            }
        }

        public void a(JSONObject jSONObject) {
            ge geVar = ge.this;
            geVar.a(jSONObject, geVar.f42537l);
        }
    }

    public void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", (Object) "PassThroughToWeb");
            jSONObject2.put("message", (Object) jSONObject);
            this.f42529d.a(jSONObject2);
        } catch (JSONException e11) {
            bo.b(f42526a, "Error sending pass through message.", e11);
        }
    }

    public void a(String str, dp.k kVar, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "MetricReached");
            jSONObject.put("metric", (Object) str);
            jSONObject.put("source", (Object) kVar.a());
            jSONObject.put(AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY, (Object) new JSONObject((Map<?, ?>) map));
            a(jSONObject);
        } catch (JSONException unused) {
            bo.b(f42526a, "Error while sending MetricReached message.");
        }
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "AlertMessage");
            jSONObject.put("msg", (Object) str);
            b(jSONObject);
        } catch (JSONException unused) {
            bo.b(f42526a, "Error while sending AlertMessage message.");
        }
    }

    public void a(long j11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "VerifyVariantShown");
            jSONObject.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID, j11);
            b(jSONObject);
            br.a("VerifyVariantShown");
        } catch (JSONException unused) {
            bo.b(f42526a, "Error while sending VerifyVariantShown message.");
        }
    }

    public void a(List<bu> list, bb bbVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "VerifyFilterUpdate");
            JSONArray jSONArray = new JSONArray();
            for (bu next : list) {
                Long a11 = next.a();
                if (a11 != null) {
                    jSONArray.put((Object) new JSONObject(a11, next, bbVar) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ Long f42547a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ bu f42548b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ bb f42549c;

                        {
                            this.f42547a = r4;
                            this.f42548b = r5;
                            this.f42549c = r6;
                            put(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID, r4.longValue());
                            put("matching_filters", (Object) r5.a(r6));
                            put("non_matching_filters", (Object) r5.b(r6));
                        }
                    });
                }
            }
            jSONObject.put("variants", (Object) jSONArray);
            a(jSONObject);
        } catch (JSONException unused) {
            bo.b(f42526a, "Error while sending ExperimentFilterStatusUpdate message");
        }
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                return 0L;
            }
        };
    }
}
