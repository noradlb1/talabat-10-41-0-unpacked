package com.uxcam.internals;

import android.content.Context;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;
import com.braze.models.FeatureFlag;
import com.facebook.internal.NativeProtocol;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.uxcam.internals.gu;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hb {

    /* renamed from: g  reason: collision with root package name */
    public static final String f13524g = gk.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    public static float f13525h;

    /* renamed from: i  reason: collision with root package name */
    public static int f13526i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static String f13527j;

    /* renamed from: k  reason: collision with root package name */
    public static String f13528k = "";

    /* renamed from: l  reason: collision with root package name */
    public static volatile hb f13529l = null;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f13530a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ib f13531b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f13532c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f13533d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f13534e = new JSONArray();

    /* renamed from: f  reason: collision with root package name */
    public JSONArray f13535f = new JSONArray();

    public static hb c() {
        if (f13529l == null) {
            synchronized (gk.class) {
                if (f13529l == null) {
                    f13529l = new hb();
                }
            }
        }
        return f13529l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        if (r8.isEmpty() != false) goto L_0x0008;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r7, java.lang.String r8, boolean r9) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0008
            boolean r0 = r8.isEmpty()     // Catch:{ Exception -> 0x012a }
            if (r0 == 0) goto L_0x0016
        L_0x0008:
            android.content.Context r8 = com.uxcam.internals.ia.c()     // Catch:{ Exception -> 0x012a }
            android.app.Activity r8 = (android.app.Activity) r8     // Catch:{ Exception -> 0x012a }
            java.lang.Class r8 = r8.getClass()     // Catch:{ Exception -> 0x012a }
            java.lang.String r8 = r8.getSimpleName()     // Catch:{ Exception -> 0x012a }
        L_0x0016:
            r0 = 0
            r1 = 1
            if (r9 != 0) goto L_0x0038
            java.util.Set r9 = com.uxcam.internals.gm.D     // Catch:{ Exception -> 0x012a }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x012a }
        L_0x0020:
            boolean r2 = r9.hasNext()     // Catch:{ Exception -> 0x012a }
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r9.next()     // Catch:{ Exception -> 0x012a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x012a }
            boolean r2 = r2.equals(r8)     // Catch:{ Exception -> 0x012a }
            if (r2 == 0) goto L_0x0020
            r9 = r1
            goto L_0x0035
        L_0x0034:
            r9 = r0
        L_0x0035:
            if (r9 == 0) goto L_0x0038
            return
        L_0x0038:
            com.uxcam.internals.hb r9 = c()     // Catch:{ Exception -> 0x012a }
            java.util.ArrayList r9 = r9.f13530a     // Catch:{ Exception -> 0x012a }
            int r9 = r9.size()     // Catch:{ Exception -> 0x012a }
            if (r9 != 0) goto L_0x0061
            java.util.ArrayList r9 = r6.f13532c     // Catch:{ Exception -> 0x012a }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x012a }
        L_0x004a:
            boolean r2 = r9.hasNext()     // Catch:{ Exception -> 0x012a }
            if (r2 == 0) goto L_0x0061
            java.lang.Object r2 = r9.next()     // Catch:{ Exception -> 0x012a }
            com.uxcam.internals.bv r2 = (com.uxcam.internals.bv) r2     // Catch:{ Exception -> 0x012a }
            java.lang.String r3 = r2.f13095d     // Catch:{ Exception -> 0x012a }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x012a }
            if (r3 == 0) goto L_0x004a
            r2.f13095d = r8     // Catch:{ Exception -> 0x012a }
            goto L_0x004a
        L_0x0061:
            f13528k = r8     // Catch:{ Exception -> 0x012a }
            boolean r9 = com.uxcam.internals.ee.c((java.lang.String) r8)     // Catch:{ Exception -> 0x012a }
            com.uxcam.internals.ib r2 = new com.uxcam.internals.ib     // Catch:{ Exception -> 0x012a }
            r2.<init>()     // Catch:{ Exception -> 0x012a }
            java.util.concurrent.CountDownLatch r3 = new java.util.concurrent.CountDownLatch     // Catch:{ InterruptedException -> 0x0086 }
            r3.<init>(r1)     // Catch:{ InterruptedException -> 0x0086 }
            android.os.Handler r4 = new android.os.Handler     // Catch:{ InterruptedException -> 0x0086 }
            android.os.Looper r5 = android.os.Looper.getMainLooper()     // Catch:{ InterruptedException -> 0x0086 }
            r4.<init>(r5)     // Catch:{ InterruptedException -> 0x0086 }
            mz.d0 r5 = new mz.d0     // Catch:{ InterruptedException -> 0x0086 }
            r5.<init>(r6, r2, r7, r3)     // Catch:{ InterruptedException -> 0x0086 }
            r4.post(r5)     // Catch:{ InterruptedException -> 0x0086 }
            r3.await()     // Catch:{ InterruptedException -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ Exception -> 0x012a }
        L_0x008a:
            r6.f13531b = r2     // Catch:{ Exception -> 0x012a }
            java.util.ArrayList r7 = r6.f13530a     // Catch:{ Exception -> 0x012a }
            r2.f13622b = r8     // Catch:{ Exception -> 0x012a }
            r2 = 0
            if (r7 == 0) goto L_0x00b8
            boolean r3 = r7.isEmpty()     // Catch:{ Exception -> 0x012a }
            if (r3 != 0) goto L_0x00b8
            int r3 = r7.size()     // Catch:{ Exception -> 0x012a }
            int r3 = r3 - r1
            java.lang.Object r3 = r7.get(r3)     // Catch:{ Exception -> 0x012a }
            com.uxcam.internals.gz r3 = (com.uxcam.internals.gz) r3     // Catch:{ Exception -> 0x012a }
            java.lang.String r3 = r3.f13516a     // Catch:{ Exception -> 0x012a }
            boolean r3 = r8.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x012a }
            if (r3 == 0) goto L_0x00b8
            int r8 = r7.size()     // Catch:{ Exception -> 0x012a }
            int r8 = r8 - r1
            java.lang.Object r7 = r7.get(r8)     // Catch:{ Exception -> 0x012a }
            com.uxcam.internals.gz r7 = (com.uxcam.internals.gz) r7     // Catch:{ Exception -> 0x012a }
            goto L_0x0101
        L_0x00b8:
            com.uxcam.internals.gz r3 = new com.uxcam.internals.gz     // Catch:{ Exception -> 0x012a }
            r3.<init>()     // Catch:{ Exception -> 0x012a }
            r3.f13516a = r8     // Catch:{ Exception -> 0x012a }
            com.uxcam.datamodel.UXCamOcclusion r8 = com.uxcam.internals.ee.b((java.lang.String) r8)     // Catch:{ Exception -> 0x012a }
            if (r8 == 0) goto L_0x00d0
            if (r9 == 0) goto L_0x00ce
            boolean r8 = r8.isWithoutGesture()     // Catch:{ Exception -> 0x012a }
            if (r8 == 0) goto L_0x00ce
            r0 = r1
        L_0x00ce:
            r3.f13520e = r0     // Catch:{ Exception -> 0x012a }
        L_0x00d0:
            float r8 = com.uxcam.internals.ia.d()     // Catch:{ Exception -> 0x012a }
            if (r7 == 0) goto L_0x00dd
            boolean r9 = r7.isEmpty()     // Catch:{ Exception -> 0x012a }
            if (r9 == 0) goto L_0x00dd
            r8 = r2
        L_0x00dd:
            r3.f13517b = r8     // Catch:{ Exception -> 0x012a }
            if (r7 == 0) goto L_0x00fc
            boolean r9 = r7.isEmpty()     // Catch:{ Exception -> 0x00f8 }
            if (r9 != 0) goto L_0x00fc
            int r9 = r7.size()     // Catch:{ Exception -> 0x00f8 }
            int r9 = r9 - r1
            java.lang.Object r9 = r7.get(r9)     // Catch:{ Exception -> 0x00f8 }
            com.uxcam.internals.gz r9 = (com.uxcam.internals.gz) r9     // Catch:{ Exception -> 0x00f8 }
            float r0 = r9.f13517b     // Catch:{ Exception -> 0x00f8 }
            float r8 = r8 - r0
            r9.f13519d = r8     // Catch:{ Exception -> 0x00f8 }
            goto L_0x00fc
        L_0x00f8:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ Exception -> 0x012a }
        L_0x00fc:
            if (r7 == 0) goto L_0x0101
            r7.add(r3)     // Catch:{ Exception -> 0x012a }
        L_0x0101:
            android.content.Context r7 = com.uxcam.internals.ia.c()     // Catch:{ Exception -> 0x012a }
            android.app.Activity r7 = (android.app.Activity) r7     // Catch:{ Exception -> 0x012a }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x012a }
            android.content.res.Configuration r7 = r7.getConfiguration()     // Catch:{ Exception -> 0x012a }
            int r7 = r7.orientation     // Catch:{ Exception -> 0x012a }
            int r8 = com.uxcam.internals.fm.f13364c     // Catch:{ Exception -> 0x012a }
            if (r8 == r7) goto L_0x0126
            boolean r8 = com.uxcam.internals.fm.f13365d     // Catch:{ Exception -> 0x012a }
            if (r8 != 0) goto L_0x0126
            com.uxcam.internals.fm.f13364c = r7     // Catch:{ Exception -> 0x012a }
            com.uxcam.internals.hb r7 = c()     // Catch:{ Exception -> 0x012a }
            com.uxcam.internals.ib r7 = r7.f13531b     // Catch:{ Exception -> 0x012a }
            r8 = 10
            r7.a(r8, r2, r2)     // Catch:{ Exception -> 0x012a }
        L_0x0126:
            com.uxcam.internals.fj.a()     // Catch:{ Exception -> 0x012a }
            goto L_0x012e
        L_0x012a:
            r7 = move-exception
            r7.printStackTrace()
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.hb.a(android.content.Context, java.lang.String, boolean):void");
    }

    public Set b() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f13530a.iterator();
        while (it.hasNext()) {
            hashSet.add(new ac(((gz) it.next()).f13516a));
        }
        return hashSet;
    }

    public String d() {
        ArrayList arrayList = this.f13530a;
        if (arrayList == null || arrayList.isEmpty()) {
            return "";
        }
        ArrayList arrayList2 = this.f13530a;
        return ((gz) arrayList2.get(arrayList2.size() - 1)).f13516a;
    }

    public int e() {
        Iterator it = this.f13530a.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Iterator it2 = ((gz) it.next()).f13518c.iterator();
            while (it2.hasNext()) {
                int i12 = ((cq) it2.next()).f13153b;
                if (!(i12 == 10 || i12 == 3 || i12 == 4 || i12 == 5 || i12 == 2)) {
                    i11++;
                }
            }
        }
        return i11;
    }

    public JSONArray f() {
        JSONArray jSONArray = new JSONArray();
        a(this.f13532c, jSONArray);
        a(this.f13533d, jSONArray);
        return jSONArray;
    }

    public final JSONArray g() {
        float f11;
        Iterator it = this.f13530a.iterator();
        JSONArray jSONArray = new JSONArray();
        int i11 = 1;
        boolean z11 = true;
        while (true) {
            float f12 = 0.0f;
            try {
                if (!it.hasNext()) {
                    break;
                }
                gz gzVar = (gz) it.next();
                JSONArray jSONArray2 = new JSONArray();
                if (z11 && gzVar.f13519d - f13525h < 0.0f) {
                    f13525h = 0.0f;
                }
                JSONObject jSONObject = new JSONObject();
                Locale locale = Locale.ENGLISH;
                Object[] objArr = new Object[i11];
                objArr[0] = Float.valueOf(gzVar.f13517b);
                jSONObject.put("va", (Object) Float.valueOf(String.format(locale, "%.3f", objArr)));
                jSONArray2.put((Object) jSONObject);
                JSONArray jSONArray3 = new JSONArray();
                Iterator it2 = gzVar.f13518c.iterator();
                while (it2.hasNext()) {
                    cq cqVar = (cq) it2.next();
                    JSONArray jSONArray4 = new JSONArray();
                    jSONArray4.put(cqVar.f13155d);
                    jSONArray4.put(cqVar.f13156e);
                    jSONArray4.put(cqVar.f13159h);
                    jSONArray4.put(cqVar.f13153b);
                    jSONArray4.put(cqVar.f13160i.booleanValue() ? 1 : 0);
                    float f13 = f13525h;
                    if (f13 < f12) {
                        f13 = f12;
                    }
                    cqVar.a(cqVar.f13154c - f13);
                    Iterator it3 = cqVar.f13164m.iterator();
                    while (it3.hasNext()) {
                        cq cqVar2 = (cq) it3.next();
                        cqVar2.a(cqVar2.f13154c - f13);
                    }
                    Locale locale2 = Locale.ENGLISH;
                    Object[] objArr2 = new Object[i11];
                    float f14 = cqVar.f13154c;
                    if (f14 < f12) {
                        f14 = f12;
                    }
                    objArr2[0] = Float.valueOf(f14);
                    jSONArray4.put((Object) Float.valueOf(String.format(locale2, "%.3f", objArr2)));
                    JSONArray jSONArray5 = new JSONArray();
                    Iterator it4 = cqVar.f13164m.iterator();
                    while (it4.hasNext()) {
                        cq cqVar3 = (cq) it4.next();
                        JSONArray jSONArray6 = new JSONArray();
                        jSONArray6.put(cqVar3.f13153b);
                        Locale locale3 = Locale.ENGLISH;
                        Object[] objArr3 = new Object[i11];
                        objArr3[0] = Float.valueOf(cqVar3.f13154c);
                        jSONArray6.put((Object) Float.valueOf(String.format(locale3, "%.3f", objArr3)));
                        jSONArray6.put(cqVar3.f13155d);
                        jSONArray6.put(cqVar3.f13156e);
                        jSONArray5.put((Object) jSONArray6);
                        i11 = 1;
                    }
                    if (cqVar.f13154c > 0.0f || cqVar.f13153b == 10) {
                        jSONArray4.put((Object) jSONArray5);
                        jSONArray3.put((Object) jSONArray4);
                    }
                    jSONArray4.put(cqVar.f13162k ? 1 : 0);
                    fi fiVar = cqVar.f13163l;
                    if (fiVar != null) {
                        jSONArray4.put((Object) fiVar.a());
                    } else {
                        jSONArray4.put((Object) new JSONObject());
                    }
                    i11 = 1;
                    f12 = 0.0f;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("cor", (Object) jSONArray3);
                float f15 = gzVar.f13517b - f13525h;
                Locale locale4 = Locale.ENGLISH;
                Object[] objArr4 = new Object[1];
                if (f15 < 0.0f) {
                    f15 = 0.0f;
                }
                objArr4[0] = Float.valueOf(f15);
                jSONObject2.put("at", (Object) Float.valueOf(String.format(locale4, "%.3f", objArr4)));
                float f16 = gzVar.f13519d;
                if (z11) {
                    f16 -= f13525h;
                }
                if (!it.hasNext()) {
                    f16 += f13525h;
                }
                if (z11) {
                    z11 = false;
                }
                jSONObject2.put("vt", (Object) Float.valueOf(String.format(locale4, "%.3f", new Object[]{Float.valueOf(f16)})));
                jSONObject2.put("an", (Object) gzVar.f13516a);
                jSONArray.put((Object) jSONObject2);
                i11 = 1;
            } catch (JSONException e11) {
                gu.ab a11 = gu.a(f13524g);
                e11.getMessage();
                a11.getClass();
                f11 = 0.0f;
            }
        }
        f11 = 0.0f;
        f13525h = f11;
        return jSONArray;
    }

    public JSONArray h() {
        if (this.f13530a.isEmpty()) {
            gz gzVar = new gz();
            gzVar.f13516a = "unknown";
            gzVar.f13517b = 0.0f;
            this.f13530a.add(gzVar);
        }
        JSONArray g11 = g();
        a();
        return g11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ib ibVar, Context context, CountDownLatch countDownLatch) {
        try {
            this.f13531b = ibVar;
            new GestureDetector(context, ibVar).setOnDoubleTapListener(ibVar);
            new ScaleGestureDetector(context, ibVar);
        } catch (Exception e11) {
            e11.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    public void a() {
        ArrayList arrayList = this.f13532c;
        if (arrayList == null) {
            arrayList = null;
        }
        f13529l = new hb();
        f13529l.f13532c = arrayList;
        this.f13530a = null;
    }

    public void a(String str, float f11, Map map) {
        String str2;
        gu.ab a11 = gu.a("rageClickDetector");
        Objects.toString(map);
        a11.getClass();
        if (this.f13533d == null) {
            this.f13533d = new ArrayList();
        }
        if ("rageTap".equals(str)) {
            str2 = (String) map.get("activity");
        } else {
            str2 = c().d();
        }
        bv bvVar = new bv(str, f11, str2, map);
        bvVar.f13096e = true;
        this.f13533d.add(bvVar);
    }

    public void a(String str, JSONObject jSONObject, Map map) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            int[] iArr = gm.f13476y;
            int i11 = 0;
            int i12 = iArr[0];
            int i13 = iArr[1];
            int i14 = iArr[2];
            if (this.f13532c.size() < i12) {
                if (a(str) <= 255) {
                    if (map != null && map.size() <= i13) {
                        for (Map.Entry entry : map.entrySet()) {
                            if (i11 >= i13) {
                                Objects.toString(entry.getKey());
                                Objects.toString(entry.getValue());
                            } else if (a(entry.getKey().toString()) > i14) {
                                Objects.toString(entry.getKey());
                                Objects.toString(entry.getValue());
                            } else if (a(entry.getValue().toString()) > i14) {
                                Objects.toString(entry.getKey());
                                Objects.toString(entry.getValue());
                            } else {
                                jSONObject2.put(entry.getKey().toString(), (Object) entry.getValue().toString());
                            }
                            i11++;
                        }
                    } else if (map != null) {
                        String str2 = "Too many properties in this event: " + map.size() + ". Limit is " + i13 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER;
                        jSONObject2.put("_UXCam_Overload", (Object) str2);
                        gu.a("UXCam").b(str2, new Object[0]);
                    }
                }
            }
            if (!str.isEmpty()) {
                jSONObject.put("name", (Object) str);
            }
            jSONObject.put(FeatureFlag.PROPERTIES, (Object) jSONObject2);
            jSONObject.put("screen", (Object) c().d());
            jSONObject.put("timeStamp", System.currentTimeMillis());
            jSONObject.put("timeline", (double) ia.d());
            this.f13535f.put((Object) jSONObject);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public final int a(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    @NonNull
    public final JSONArray a(ArrayList arrayList, JSONArray jSONArray) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                JSONObject jSONObject = new JSONObject();
                bv bvVar = (bv) it.next();
                jSONObject.put("name", (Object) bvVar.f13093b);
                jSONObject.put("time", (Object) Float.valueOf(String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(bvVar.f13094c)})));
                jSONObject.put("screen", (Object) bvVar.f13095d);
                if (bvVar.f13096e) {
                    jSONObject.put("internal", true);
                }
                if (bvVar.f13092a != null) {
                    jSONObject.put(NativeProtocol.WEB_DIALOG_PARAMS, (Object) new JSONObject((Map<?, ?>) bvVar.f13092a));
                }
                jSONArray.put((Object) jSONObject);
            } catch (JSONException e11) {
                e11.getMessage();
                gu.f13504c.getClass();
            }
        }
        return jSONArray;
    }
}
