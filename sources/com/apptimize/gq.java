package com.apptimize;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import com.apptimize.jn;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.net.URI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class gq {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42708a = "gq";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final jn f42709b;

    /* renamed from: c  reason: collision with root package name */
    private final gr f42710c;

    /* renamed from: d  reason: collision with root package name */
    private final ge f42711d;

    /* renamed from: e  reason: collision with root package name */
    private final gp f42712e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final fo f42713f;

    /* renamed from: g  reason: collision with root package name */
    private final fo f42714g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f42715h = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f42716i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f42717j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f42718k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f42719l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f42720m = true;

    public static class a {
        @SuppressLint({"NewApi"})
        public static Bitmap a(DisplayMetrics displayMetrics, int i11, int i12, Bitmap.Config config) {
            return Bitmap.createBitmap(displayMetrics, i11, i12, config);
        }
    }

    public class b extends Exception {
        private b() {
        }
    }

    public gq(gr grVar, ge geVar, fv fvVar, final gp gpVar) {
        this.f42710c = grVar;
        this.f42711d = geVar;
        this.f42712e = gpVar;
        this.f42709b = new jn();
        this.f42713f = fvVar.a((fi) new fi() {
            public void run() {
                gpVar.a((fj) new fj() {
                    public void a(Activity activity) {
                        gq.this.e(activity);
                    }
                });
            }
        });
        this.f42714g = fvVar.a((fi) new fi() {
            public void run() {
                gpVar.a((fj) new fj() {
                    public void a(Activity activity) {
                        gq.this.c(activity);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void e(Activity activity) {
        this.f42712e.b();
        if (d()) {
            try {
                final Bitmap a11 = a(activity);
                final JSONArray a12 = this.f42710c.a(activity);
                if (a12.length() == 0) {
                    b("Apptimize is not explicitly enabled for this Activity.");
                }
                this.f42716i = false;
                this.f42712e.d((fi) new fi() {
                    public void run() {
                        try {
                            int b11 = gq.this.f42717j + 1;
                            gq gqVar = gq.this;
                            JSONObject a11 = gqVar.a(a11, gqVar.f42709b, b11, a12);
                            if (a11 != null) {
                                gq.this.c(a11);
                                int unused = gq.this.f42717j = b11;
                            }
                        } catch (b unused2) {
                            gq.this.f42713f.b(200);
                        }
                    }
                });
            } catch (JSONException e11) {
                bo.c(f42708a, "Error getting info to send WYSIWYG information. Retrying", e11);
                this.f42713f.b(200);
            }
        }
    }

    private void g() {
        if (this.f42719l && this.f42716i && d() && this.f42718k == this.f42717j && this.f42720m) {
            this.f42713f.a(250);
        }
    }

    /* access modifiers changed from: private */
    public void c(final Activity activity) {
        this.f42712e.b();
        if (d()) {
            try {
                final JSONArray a11 = this.f42710c.a(activity);
                if (a11.length() == 0) {
                    b("Apptimize is not explicitly enabled for this Activity.");
                }
                this.f42716i = false;
                if (this.f42720m) {
                    final Bitmap a12 = a(activity);
                    if (this.f42717j == 0) {
                        this.f42712e.d((fi) new fi() {
                            public void run() {
                                gq.this.a(activity, a12, (JSONArray) null, true);
                            }
                        });
                        this.f42712e.d((fi) new fi() {
                            public void run() {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("type", (Object) "ViewHierarchy");
                                    jSONObject.put("rootArray", (Object) a11);
                                    jSONObject.put("updateSequenceData", (Object) gq.this.f42715h);
                                    gq.this.c(jSONObject);
                                } catch (JSONException unused) {
                                    bo.e(gq.f42708a, "Error on early sending of view hierarchy");
                                }
                                gq.this.a(activity, a12, a11, false);
                            }
                        });
                    }
                    this.f42712e.d((fi) new fi() {
                        public void run() {
                            gq.this.a(activity, a12, a11, false);
                        }
                    });
                    return;
                }
                this.f42712e.d((fi) new fi() {
                    public void run() {
                        gq.this.b(activity);
                    }
                });
            } catch (JSONException e11) {
                bo.c(f42708a, "Error getting info to send WYSIWYG information. Retrying", e11);
                this.f42714g.a(200);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(Activity activity) {
        try {
            JSONArray a11 = this.f42710c.a(activity);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rootArray", (Object) a11);
            br.a("v", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void b() {
        this.f42712e.a((fj) new fj() {
            public void a(Activity activity) {
                gq.this.d(activity);
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(Activity activity) {
        try {
            c(c.a((Context) activity, false));
        } catch (JSONException e11) {
            bo.c(f42708a, "Unexpected exception getting device information. Retrying. ", e11);
            this.f42713f.b(200);
        }
    }

    private void a(Canvas canvas, Object obj) {
        View a11 = js.a(obj);
        if (a11 != null && !js.b(a11)) {
            Point a12 = js.a(a11);
            Point point = new Point(a11.getWidth(), a11.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(point.x, point.y, Bitmap.Config.ARGB_8888);
            try {
                a11.draw(new Canvas(createBitmap));
                canvas.drawBitmap(createBitmap, (float) a12.x, (float) a12.y, new Paint());
            } catch (Exception e11) {
                bo.g(f42708a, "Unable to take screen shot:", e11);
            }
        }
    }

    public void b(JSONObject jSONObject) {
        try {
            this.f42718k = jSONObject.getInt("snapshotSequenceNumber");
            g();
        } catch (JSONException e11) {
            bo.d(f42708a, "Error reading snapshotSuccessfullySent message", e11);
        }
    }

    public boolean d() {
        ge geVar = this.f42711d;
        return geVar != null && geVar.h();
    }

    private void b(String str) {
        if (d()) {
            try {
                this.f42711d.a(str);
            } catch (Exception e11) {
                bo.f(f42708a, "Error sending message", e11);
            }
        }
    }

    public void e() {
        this.f42717j = 0;
        this.f42718k = -1;
        this.f42719l = false;
        this.f42720m = true;
    }

    private Bitmap a(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(new DisplayMetrics());
        Point point = new Point();
        defaultDisplay.getSize(point);
        Bitmap a11 = a.a(displayMetrics, point.x, point.y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(a11);
        try {
            js.a(activity).draw(canvas);
            for (Object a12 : this.f42710c.a()) {
                a(canvas, a12);
            }
            return a11;
        } catch (Exception e11) {
            bo.g(f42708a, "Unable to take screen shot:", e11);
            return a11;
        }
    }

    public void c() {
        this.f42716i = true;
        g();
    }

    /* access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        if (d()) {
            try {
                this.f42711d.a(jSONObject);
            } catch (Exception e11) {
                bo.f(f42708a, "Error sending message", e11);
            }
        }
    }

    private JSONObject a(jn.a aVar, int i11, JSONArray jSONArray) throws b {
        JSONObject jSONObject = new JSONObject();
        try {
            String a11 = ew.a(aVar.f43121a.toByteArray(), 0);
            jSONObject.put("type", (Object) "SnapShot");
            jSONObject.put("snapshotSequenceNumber", i11);
            jSONObject.put("updateSequenceData", (Object) this.f42715h);
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rootArray", (Object) jSONArray);
                jSONObject.put("viewHierarchy", (Object) jSONObject2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("screenShot", (Object) a11);
            jSONObject3.put("left", aVar.f43122b.left);
            jSONObject3.put(TtmlNode.RIGHT, aVar.f43122b.right);
            jSONObject3.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, aVar.f43122b.top);
            jSONObject3.put("bottom", aVar.f43122b.bottom);
            jSONObject3.put("fullScreen", aVar.f43123c);
            jSONObject3.put("scale", aVar.f43124d);
            jSONObject3.put("imageType", (Object) MimeTypes.IMAGE_JPEG);
            jSONObject.put("screenShot", (Object) jSONObject3);
            return jSONObject;
        } catch (JSONException e11) {
            bo.g(f42708a, "Unable to take screen shot:", e11);
            throw new b();
        } catch (IOException e12) {
            bo.g(f42708a, "Unable to take screen shot:", e12);
            throw new b();
        }
    }

    private JSONObject a(Bitmap bitmap, boolean z11, jn jnVar, int i11, JSONArray jSONArray) throws b {
        return a(jnVar.a(bitmap, z11), i11, jSONArray);
    }

    /* access modifiers changed from: private */
    public JSONObject a(Bitmap bitmap, jn jnVar, int i11, JSONArray jSONArray) throws b {
        jn.a a11 = jnVar.a(bitmap);
        if (a11 == null) {
            return null;
        }
        return a(a11, i11, jSONArray);
    }

    public void a(JSONObject jSONObject) {
        if (d()) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("settings");
                if (jSONObject2.has("sendScreenshots")) {
                    this.f42720m = jSONObject2.getBoolean("sendScreenshots");
                }
            } catch (Exception e11) {
                String str = f42708a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No settings sent with message to wysiwygSettings! Message: ");
                sb2.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                bo.d(str, sb2.toString(), e11);
            }
        }
    }

    public void a() {
        this.f42712e.a((fj) new fj() {
            public void a(Activity activity) {
                gq.this.c(activity);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, Bitmap bitmap, JSONArray jSONArray, boolean z11) {
        try {
            int i11 = this.f42717j + 1;
            c(a(bitmap, z11, this.f42709b, i11, jSONArray));
            b(activity);
            this.f42717j = i11;
            this.f42719l = true;
        } catch (b unused) {
            this.f42713f.b(200);
        }
    }

    public void a(final URI uri) {
        this.f42712e.d((fi) new fi() {
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", (Object) "ImageRequest");
                    jSONObject.put("uri", (Object) uri.toString());
                    gq.this.c(jSONObject);
                } catch (JSONException e11) {
                    bo.d(gq.f42708a, "Unexpected error when creating request-image message: ", e11);
                }
            }
        });
    }

    public void a(String str) {
        this.f42712e.b();
        this.f42715h = str;
    }
}
