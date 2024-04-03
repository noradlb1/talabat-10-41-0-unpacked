package com.apptimize;

import android.app.Activity;
import android.content.Context;
import com.apptimize.z;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;

public class fb {

    /* renamed from: a  reason: collision with root package name */
    public static final String f42395a = "fb";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f42396b = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f42397c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<Future<?>> f42398d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<String> f42399e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<ge> f42400f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final aw f42401g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Context f42402h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final String f42403i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final String f42404j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final String f42405k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f42406l;

    public class a implements z.a {
        private a() {
        }

        public void a() {
        }

        public void a(Activity activity) {
            fb.this.f();
        }

        public void b(Activity activity) {
        }
    }

    public fb(Context context, au auVar, String str, String str2, String str3, aw awVar, ApptimizeOptions apptimizeOptions, Properties properties) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f42397c = atomicBoolean;
        this.f42398d = new AtomicReference<>((Object) null);
        this.f42399e = new AtomicReference<>((Object) null);
        this.f42400f = new AtomicReference<>((Object) null);
        this.f42401g = awVar;
        this.f42403i = str3;
        this.f42402h = context;
        this.f42404j = str2;
        this.f42405k = str;
        Boolean l11 = as.l(properties);
        boolean booleanValue = l11 != null ? l11.booleanValue() : apptimizeOptions.isDevicePairingEnabled();
        this.f42406l = booleanValue;
        if (!booleanValue) {
            return;
        }
        if (c.d(context, auVar) && apptimizeOptions.isDeveloperModeDisabled()) {
            return;
        }
        if (as.n(properties) || c.d(context, auVar) || i.a().a(context, "forceDebug", false) || i.a().a(context, "devicePairingAuthorized", false)) {
            atomicBoolean.set(true);
        } else {
            d();
        }
    }

    private void d() {
        this.f42399e.set(c(this.f42402h));
        Future future = this.f42398d.get();
        if (!this.f42397c.get() && this.f42399e.get() != null && this.f42403i != null) {
            if (future == null || future.isDone()) {
                this.f42398d.set(fg.f42429d.submit(new fi() {
                    public void run() {
                        fe.a(fb.f42395a, (fi) new fi() {
                            public void run() {
                                String str = fb.f42395a;
                                bo.a(str, "Checking pairing-token authorization list " + fb.this.f42403i);
                                fb.this.f42401g.a(fb.this.f42405k, fb.this.f42403i, fb.this.f42404j, new ax<JSONArray>() {
                                    public void b() {
                                        bo.a(fb.f42395a, "Not checking pairing-token authorization list because Apptimize is offline.");
                                    }

                                    public void a(JSONArray jSONArray, HttpURLConnection httpURLConnection) {
                                        try {
                                            String replaceAll = ((String) fb.this.f42399e.get()).replaceAll("[^0-9a-fA-F]+", "");
                                            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                                if (replaceAll.equalsIgnoreCase(jSONArray.getString(i11).replaceAll("[^0-9a-fA-F]+", ""))) {
                                                    i.a().b(fb.this.f42402h, "pairingTokenExpiryDate", new Date(Long.MAX_VALUE));
                                                    i.a().b(fb.this.f42402h, "devicePairingAuthorized", true);
                                                    fb.this.f42396b.set(true);
                                                    fb.this.f42397c.set(true);
                                                    fb.this.e();
                                                    bo.f(fb.f42395a, "Pairing-token authorized - performing developer mode pairing");
                                                    return;
                                                }
                                            }
                                            bo.e(fb.f42395a, "Pairing-token not authorized");
                                        } catch (JSONException e11) {
                                            bo.b(fb.f42395a, "Received unexpected response to pairing-token authorization list request", e11);
                                        }
                                    }

                                    public void a(HttpURLConnection httpURLConnection) {
                                        bo.b(fb.f42395a, "Failed request for pairing-token authorization list.");
                                    }

                                    public void a() {
                                        bo.b(fb.f42395a, "pairing-token authorization list request 304ed");
                                    }
                                });
                            }
                        }, "Exception while checking pairing-token authorization.");
                    }
                }));
            }
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.f42400f.get() != null) {
            this.f42400f.get().c(this.f42397c.get() && this.f42406l);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        d();
    }

    public boolean a() {
        return this.f42397c.get() || this.f42399e.get() != null;
    }

    public boolean b() {
        Future future = this.f42398d.get();
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException e11) {
                bo.b(f42395a, "Pairing-token authorization error", e11);
            } catch (ExecutionException e12) {
                bo.b(f42395a, "Pairing-token authorization error", e12);
            }
            this.f42398d.set((Object) null);
            if (this.f42396b.get()) {
                this.f42397c.set(true);
                a(this.f42402h);
            } else {
                String str = f42395a;
                bo.b(str, "Pairing-token authorization rejected for " + this.f42399e.get());
            }
        }
        return this.f42397c.get();
    }

    public boolean c() {
        return this.f42406l;
    }

    public static void a(Context context) {
        i.a().b(context, "forceDebug", true);
        bo.a(f42395a, "Pairing-token set FORCE_DEBUG_KEY");
    }

    public static String c(Context context) {
        String a11 = i.a().a(context, "pairingToken", (String) null);
        Date a12 = i.a().a(context, "pairingTokenExpiryDate", (Date) null);
        if (a11 == null || a12 == null || a12.before(new Date())) {
            return null;
        }
        return a11;
    }

    public void a(z zVar) {
        if (zVar != null && this.f42406l && !this.f42397c.get()) {
            new fc(this.f42402h).a(zVar);
            zVar.a(new a());
        }
    }

    public static String d(Context context) {
        String c11 = c(context);
        if (c11 == null) {
            return null;
        }
        i.a().b(context, "pairingTokenExpiryDate", new Date(new Date().getTime() + DateUtils.MILLIS_PER_HOUR));
        return c11;
    }

    public void a(ge geVar) {
        this.f42400f.set(geVar);
    }

    public static String b(Context context) {
        Date date = new Date(new Date().getTime() + DateUtils.MILLIS_PER_HOUR);
        SecureRandom secureRandom = new SecureRandom();
        String format = String.format("%04x-%04x", new Object[]{Integer.valueOf(secureRandom.nextInt(65535)), Integer.valueOf(secureRandom.nextInt(65535))});
        i.a().b(context, "pairingToken", format);
        i.a().b(context, "pairingTokenExpiryDate", date);
        i.a().b(context, "devicePairingAuthorized", false);
        return format;
    }

    public fb(Context context, au auVar, String str, String str2, String str3, aw awVar, boolean z11, boolean z12) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.f42397c = atomicBoolean;
        this.f42398d = new AtomicReference<>((Object) null);
        this.f42399e = new AtomicReference<>((Object) null);
        this.f42400f = new AtomicReference<>((Object) null);
        this.f42401g = awVar;
        this.f42403i = str3;
        this.f42402h = context;
        this.f42404j = str2;
        this.f42405k = str;
        atomicBoolean.set(z11);
        this.f42406l = z12;
    }
}
