package com.visa.checkout;

import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.visa.checkout.j;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.pool.TypePool;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
final class t {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static int f391 = 0;

    /* renamed from: ʼ  reason: contains not printable characters */
    private static long f392 = 7617519513434447065L;

    /* renamed from: ʽ  reason: contains not printable characters */
    private static char[] f393 = {46412, 27034, 3318, 9158, 50731, 58725, 38988, 48311, 21387, 30437, 5412, 21411, 36725, 59924, 50491, 8393, 918, 32432, 23043, 46458, 36870, 62410, 12028, 2439, 25780, 16495, 41756, 40509, 63941, 54446, 14220, 4965, 20042, 43323, 34043, 59347, 49853, 15759, 6500, 29740, 22279, 45822, 60876, 51372, 9327, 'f', 56489, 33747, 24331, 14963, 5461, 61616, 54255, 44776, 35382, 25881, 16505, 'C', 56502, 47580, 38637, 29453, 20559, 11643, 2511, 59057, 50126, 40975, 32033, 23052, 14179, 5047, 61657, 52727, 43532, 34608, 25707, 16518, 7588, 64200, 55051, 46200, 37215, 28261, 19092, 'k', 56508, 47563, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, 56508, 47552, 38626, 29445, 20561, 'v', 56504, 47582, 38654, 29441, 12687, 60761, 34872, 42775, 17125, 25018, 7324, 14408, 55138, 'a', 56503, 47574, 38649, 29451, 20564, 11634, 2480, 59041, 50117, 'I', 56468, 47607, 38594, 53293, 3323, 27034, 18101, 41799, 32792, 64830, 55693, 14068, 5000, 28740, 44402, 35337, 59194, 50145, 8338, 7603, 31307, 22304, 46085, 37117, 52672, 10926, 1900, 25668, 16693, 48649, 39649, 63413, 54406, 12657, 28255, 19245, 42977, 34011, Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 56497, 47581, 38629, 29441, 41888, 32616, 6659, 13570, 53450, 62351, 36515, 57395, 15589, 22916, 30379, 37721, 45062, 52512, 26391, 48095, 57012, 61877, 5245, 14136, 18964, 28372, 33247, 42169, 51065, 6723, 15675, 20496, 29916, 38836, 43668, 52602, 57414, 6190, 50406, 41357, 36492, 27460, 18433, 13613, 4590, 65254, 56195, 47184, 'a', 56489, 47554, 38595, 29451, 20558, 11618, 2489, 59053, 50131, 40969, 32058, 23107, 14187, 'a', 56489, 47554, 38597, 29445, 20560, 11635, 37054, 19574, 10525, 1538, 58334, 49296, 48570, 39257, 30328, 21264, 41807, 32649, 6904, 13779, 53262, 62304, 36420, 43648, 17812, 24810, 816, 56835, 63866, 37970, 18483, 38130, 61825, 56992, 15189, 61143, 12827, 22384, 30799, 40379, 48873, 50133, 59181, 2075, 11620, 18094, 39542, 65294, 53288, 13773, 5778, 27538, 20292, 41071, 34062, 59133, 15350, 7298, 29098, 21880, 10546, 62953, 37005, 49039, 23110, 30985, 1029, 8407, 53238, 60061, 35150, 21622, 29455, 7741, 15084, 55701};

    /* renamed from: ॱ  reason: contains not printable characters */
    private static WeakReference<Activity> f394 = null;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static int f395 = 1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Context f396;

    /* renamed from: ˋ  reason: contains not printable characters */
    private f f397;

    /* renamed from: ˎ  reason: contains not printable characters */
    private HashMap<String, s> f398;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f399;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private FingerprintManager f400 = null;

    @Instrumented
    public static class a implements Serializable {

        /* renamed from: ˏ  reason: contains not printable characters */
        private transient JSONObject f401;

        public a(JSONObject jSONObject) {
            this.f401 = jSONObject;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            try {
                this.f401 = new JSONObject(objectInputStream.readUTF());
            } catch (Exception unused) {
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            String str;
            objectOutputStream.defaultWriteObject();
            JSONObject jSONObject = this.f401;
            if (!(jSONObject instanceof JSONObject)) {
                str = jSONObject.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject);
            }
            objectOutputStream.writeUTF(str);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final JSONObject m6302() {
            return this.f401;
        }
    }

    @Instrumented
    public class b extends AsyncTask implements TraceFieldInterface {
        public Trace _nr_trace;

        private b() {
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private Void m6303(Object[] objArr) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(t.m6296(t.this).openFileOutput(objArr[1], 0));
                objectOutputStream.writeObject(objArr[0]);
                objectOutputStream.flush();
                objectOutputStream.close();
                return null;
            } catch (IOException unused) {
                return null;
            }
        }

        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "t$b#doInBackground", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "t$b#doInBackground", (ArrayList<String>) null);
            }
            Void r42 = m6303(objArr);
            TraceMachine.exitMethod();
            return r42;
        }

        public /* synthetic */ b(t tVar, byte b11) {
            this();
        }
    }

    public interface c {
        /* renamed from: ˎ  reason: contains not printable characters */
        void m6304(Object obj);
    }

    public static class d implements j.a {

        /* renamed from: ˊ  reason: contains not printable characters */
        private Object f403;

        /* renamed from: ˎ  reason: contains not printable characters */
        private c f404;

        /* renamed from: ॱ  reason: contains not printable characters */
        private WeakReference<t> f405;

        public d(WeakReference<t> weakReference, c cVar, Object obj) {
            this.f405 = weakReference;
            this.f404 = cVar;
            this.f403 = obj;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m6305() {
            try {
                if (this.f405.get() != null) {
                    this.f404.m6304(this.f403);
                }
            } catch (Exception unused) {
                this.f405.get();
                this.f404.m6304((Object) null);
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void m6306() {
            this.f404.m6304((Object) null);
        }
    }

    @Instrumented
    public static class e implements Serializable {

        /* renamed from: ॱ  reason: contains not printable characters */
        private transient JSONArray f406;

        public e(JSONArray jSONArray) {
            this.f406 = jSONArray;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            try {
                this.f406 = new JSONArray(objectInputStream.readUTF());
            } catch (Exception unused) {
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            String str;
            objectOutputStream.defaultWriteObject();
            JSONArray jSONArray = this.f406;
            if (!(jSONArray instanceof JSONArray)) {
                str = jSONArray.toString();
            } else {
                str = JSONArrayInstrumentation.toString(jSONArray);
            }
            objectOutputStream.writeUTF(str);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final JSONArray m6307() {
            return this.f406;
        }
    }

    public t(Context context, String str) throws Exception {
        this.f396 = context;
        this.f397 = new f(this.f396);
        this.f399 = str;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(context.openFileInput(str));
            this.f398 = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception unused) {
            this.f398 = new HashMap<>();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r0 != true) goto L_0x001b;
     */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m6295() {
        /*
            r6 = this;
            int r0 = f391
            int r0 = r0 + 39
            int r1 = r0 % 128
            f395 = r1
            int r0 = r0 % 2
            r1 = 11
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001b
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 119(0x77, float:1.67E-43)
            if (r0 < r4) goto L_0x0018
            r0 = r2
            goto L_0x0019
        L_0x0018:
            r0 = r3
        L_0x0019:
            if (r0 == r3) goto L_0x0044
        L_0x001b:
            int r0 = f391
            int r0 = r0 + 109
            int r4 = r0 % 128
            f395 = r4
            int r0 = r0 % 2
            if (r0 == 0) goto L_0x0094
            android.hardware.fingerprint.FingerprintManager r0 = r6.f400
            if (r0 != 0) goto L_0x0044
            android.content.Context r0 = r6.f396
            android.content.Context r0 = r0.getApplicationContext()
            r4 = 46378(0xb52a, float:6.499E-41)
            java.lang.String r4 = m6297(r1, r2, r4)
            java.lang.String r4 = r4.intern()
            java.lang.Object r0 = r0.getSystemService(r4)
            android.hardware.fingerprint.FingerprintManager r0 = (android.hardware.fingerprint.FingerprintManager) r0
            r6.f400 = r0
        L_0x0044:
            int r0 = f391
            int r0 = r0 + 103
            int r4 = r0 % 128
            f395 = r4
            int r0 = r0 % 2
            r4 = 21442(0x53c2, float:3.0047E-41)
            if (r0 != 0) goto L_0x0067
            android.content.Context r0 = r6.f396
            r1 = 12
            r5 = 115(0x73, float:1.61E-43)
            java.lang.String r1 = m6297(r1, r5, r4)
            java.lang.String r1 = r1.intern()
            int r0 = r0.checkSelfPermission(r1)
            if (r0 != 0) goto L_0x0093
            goto L_0x0079
        L_0x0067:
            android.content.Context r0 = r6.f396
            r5 = 34
            java.lang.String r1 = m6297(r5, r1, r4)
            java.lang.String r1 = r1.intern()
            int r0 = r0.checkSelfPermission(r1)
            if (r0 != 0) goto L_0x0093
        L_0x0079:
            android.hardware.fingerprint.FingerprintManager r0 = r6.f400
            boolean r0 = r0.isHardwareDetected()
            r1 = 69
            if (r0 == 0) goto L_0x0085
            r0 = r1
            goto L_0x0087
        L_0x0085:
            r0 = 67
        L_0x0087:
            if (r0 == r1) goto L_0x008a
            goto L_0x0093
        L_0x008a:
            android.hardware.fingerprint.FingerprintManager r0 = r6.f400
            boolean r0 = r0.hasEnrolledFingerprints()
            if (r0 == 0) goto L_0x0093
            return r3
        L_0x0093:
            return r2
        L_0x0094:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.t.m6295():boolean");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ Context m6296(t tVar) {
        int i11 = f391 + 87;
        int i12 = i11 % 128;
        f395 = i12;
        char c11 = i11 % 2 == 0 ? '\"' : TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
        Context context = tVar.f396;
        if (c11 != '\"') {
            int i13 = i12 + 95;
            f391 = i13 % 128;
            if (i13 % 2 == 0) {
                return context;
            }
            throw null;
        }
        throw null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m6298(Activity activity) {
        f394 = new WeakReference<>(activity);
        int i11 = f391 + 91;
        f395 = i11 % 128;
        if ((i11 % 2 == 0 ? 9 : 'P') == 9) {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (r1.equalsIgnoreCase(m6297(10, 47, 33719).intern()) != false) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02ea A[SYNTHETIC] */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m6299(java.lang.String r17, com.visa.checkout.t.c r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            int r3 = f391
            int r3 = r3 + 23
            int r4 = r3 % 128
            f395 = r4
            r4 = 2
            int r3 = r3 % r4
            r5 = 45
            if (r3 != 0) goto L_0x0017
            r3 = 71
            goto L_0x0018
        L_0x0017:
            r3 = r5
        L_0x0018:
            r6 = 19
            r7 = 33719(0x83b7, float:4.725E-41)
            r8 = 47
            r9 = 10
            r11 = 0
            if (r3 == r5) goto L_0x0037
            r3 = 90
            r12 = 18
            java.lang.String r3 = m6297(r3, r12, r7)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            boolean r3 = r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x02ee }
            if (r3 == 0) goto L_0x01fb
            goto L_0x0045
        L_0x0037:
            java.lang.String r3 = m6297(r9, r8, r7)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            boolean r3 = r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x02ee }
            if (r3 == 0) goto L_0x01fb
        L_0x0045:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x02ee }
            r1.<init>()     // Catch:{ Exception -> 0x02ee }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x02ee }
            r3.<init>()     // Catch:{ Exception -> 0x02ee }
            r5 = 85
            r7 = 3
            java.lang.String r8 = m6297(r7, r5, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r8 = r8.intern()     // Catch:{ Exception -> 0x02ee }
            r12 = 6
            r13 = 88
            java.lang.String r12 = m6297(r12, r13, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r12 = r12.intern()     // Catch:{ Exception -> 0x02ee }
            r3.put((java.lang.String) r8, (java.lang.Object) r12)     // Catch:{ Exception -> 0x02ee }
            r8 = 94
            r12 = 5
            java.lang.String r13 = m6297(r12, r8, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r13 = r13.intern()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r14 = android.os.Build.SERIAL     // Catch:{ Exception -> 0x02ee }
            r3.put((java.lang.String) r13, (java.lang.Object) r14)     // Catch:{ Exception -> 0x02ee }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x02ee }
            r13.<init>()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r14 = m6297(r7, r5, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r14 = r14.intern()     // Catch:{ Exception -> 0x02ee }
            r15 = 9
            r10 = 12782(0x31ee, float:1.7911E-41)
            r4 = 99
            java.lang.String r10 = m6297(r15, r4, r10)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x02ee }
            r13.put((java.lang.String) r14, (java.lang.Object) r10)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r10 = m6297(r12, r8, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r10 = r10.intern()     // Catch:{ Exception -> 0x02ee }
            android.content.Context r14 = r0.f396     // Catch:{ Exception -> 0x02ee }
            android.content.ContentResolver r14 = r14.getContentResolver()     // Catch:{ Exception -> 0x02ee }
            r15 = 108(0x6c, float:1.51E-43)
            java.lang.String r15 = m6297(r9, r15, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r15 = r15.intern()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r14 = android.provider.Settings.Secure.getString(r14, r15)     // Catch:{ Exception -> 0x02ee }
            r13.put((java.lang.String) r10, (java.lang.Object) r14)     // Catch:{ Exception -> 0x02ee }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x02ee }
            r10.<init>()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r5 = m6297(r7, r5, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r5 = r5.intern()     // Catch:{ Exception -> 0x02ee }
            r7 = 4
            r14 = 118(0x76, float:1.65E-43)
            java.lang.String r7 = m6297(r7, r14, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r7 = r7.intern()     // Catch:{ Exception -> 0x02ee }
            r10.put((java.lang.String) r5, (java.lang.Object) r7)     // Catch:{ Exception -> 0x02ee }
            android.content.Context r5 = r0.f396     // Catch:{ Exception -> 0x02ee }
            r7 = 122(0x7a, float:1.71E-43)
            r14 = 53324(0xd04c, float:7.4723E-41)
            r15 = 35
            java.lang.String r7 = m6297(r15, r7, r14)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r7 = r7.intern()     // Catch:{ Exception -> 0x02ee }
            int r5 = androidx.core.content.ContextCompat.checkSelfPermission(r5, r7)     // Catch:{ Exception -> 0x02ee }
            if (r5 != 0) goto L_0x0108
            android.content.Context r5 = r0.f396     // Catch:{ Exception -> 0x02ee }
            r7 = 157(0x9d, float:2.2E-43)
            java.lang.String r7 = m6297(r12, r7, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r7 = r7.intern()     // Catch:{ Exception -> 0x02ee }
            java.lang.Object r5 = r5.getSystemService(r7)     // Catch:{ Exception -> 0x02ee }
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch:{ Exception -> 0x02ee }
            java.lang.String r5 = r5.getDeviceId()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r7 = m6297(r12, r8, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r7 = r7.intern()     // Catch:{ Exception -> 0x02ee }
            r10.put((java.lang.String) r7, (java.lang.Object) r5)     // Catch:{ Exception -> 0x02ee }
        L_0x0108:
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x02ee }
            r5.<init>()     // Catch:{ Exception -> 0x02ee }
            r5.put((java.lang.Object) r3)     // Catch:{ Exception -> 0x02ee }
            r5.put((java.lang.Object) r13)     // Catch:{ Exception -> 0x02ee }
            r5.put((java.lang.Object) r10)     // Catch:{ Exception -> 0x02ee }
            r3 = 162(0xa2, float:2.27E-43)
            r7 = 41921(0xa3c1, float:5.8744E-41)
            r8 = 7
            java.lang.String r3 = m6297(r8, r3, r7)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            r7 = 169(0xa9, float:2.37E-43)
            r10 = 57426(0xe052, float:8.0471E-41)
            java.lang.String r7 = m6297(r8, r7, r10)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r7 = r7.intern()     // Catch:{ Exception -> 0x02ee }
            r1.put((java.lang.String) r3, (java.lang.Object) r7)     // Catch:{ Exception -> 0x02ee }
            r3 = 176(0xb0, float:2.47E-43)
            r7 = 26486(0x6776, float:3.7115E-41)
            java.lang.String r3 = m6297(r6, r3, r7)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x02ee }
            r1.put((java.lang.String) r3, (java.lang.Object) r6)     // Catch:{ Exception -> 0x02ee }
            r3 = 195(0xc3, float:2.73E-43)
            r6 = 6223(0x184f, float:8.72E-42)
            r7 = 11
            java.lang.String r3 = m6297(r7, r3, r6)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r6 = android.os.Build.VERSION.CODENAME     // Catch:{ Exception -> 0x02ee }
            r1.put((java.lang.String) r3, (java.lang.Object) r6)     // Catch:{ Exception -> 0x02ee }
            r3 = 206(0xce, float:2.89E-43)
            r6 = 14
            java.lang.String r3 = m6297(r6, r3, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x02ee }
            r1.put((java.lang.String) r3, (int) r7)     // Catch:{ Exception -> 0x02ee }
            r3 = 220(0xdc, float:3.08E-43)
            java.lang.String r3 = m6297(r8, r3, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            android.content.Context r7 = r0.f396     // Catch:{ Exception -> 0x02ee }
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ Exception -> 0x02ee }
            r1.put((java.lang.String) r3, (java.lang.Object) r7)     // Catch:{ Exception -> 0x02ee }
            r3 = 227(0xe3, float:3.18E-43)
            r7 = 37087(0x90df, float:5.197E-41)
            java.lang.String r3 = m6297(r9, r3, r7)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            r7 = 21
            r1.put((java.lang.String) r3, (int) r7)     // Catch:{ Exception -> 0x02ee }
            r3 = 237(0xed, float:3.32E-43)
            r7 = 41785(0xa339, float:5.8553E-41)
            java.lang.String r3 = m6297(r6, r3, r7)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            r6 = 251(0xfb, float:3.52E-43)
            r7 = 18437(0x4805, float:2.5836E-41)
            java.lang.String r6 = m6297(r12, r6, r7)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r6 = r6.intern()     // Catch:{ Exception -> 0x02ee }
            r1.put((java.lang.String) r3, (java.lang.Object) r6)     // Catch:{ Exception -> 0x02ee }
            r3 = 256(0x100, float:3.59E-43)
            r6 = 61110(0xeeb6, float:8.5633E-41)
            java.lang.String r3 = m6297(r9, r3, r6)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            r1.put((java.lang.String) r3, (java.lang.Object) r5)     // Catch:{ Exception -> 0x02ee }
            r3 = 266(0x10a, float:3.73E-43)
            r5 = 18122(0x46ca, float:2.5394E-41)
            r6 = 15
            java.lang.String r3 = m6297(r6, r3, r5)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ Exception -> 0x02ee }
            r1.put((java.lang.String) r3, (java.lang.Object) r5)     // Catch:{ Exception -> 0x02ee }
            r3 = 281(0x119, float:3.94E-43)
            r5 = 10577(0x2951, float:1.4822E-41)
            r6 = 16
            java.lang.String r3 = m6297(r6, r3, r5)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = r3.intern()     // Catch:{ Exception -> 0x02ee }
            boolean r5 = r16.m6295()     // Catch:{ Exception -> 0x02ee }
            r1.put((java.lang.String) r3, (boolean) r5)     // Catch:{ Exception -> 0x02ee }
            r2.m6304(r1)     // Catch:{ Exception -> 0x02ee }
            int r1 = f395
            int r1 = r1 + r4
            int r2 = r1 % 128
            f391 = r2
            r2 = 2
            int r1 = r1 % r2
            r2 = 1
            if (r1 == 0) goto L_0x01f6
            r11 = r2
        L_0x01f6:
            if (r11 == r2) goto L_0x01f9
            return
        L_0x01f9:
            r1 = 0
            throw r1
        L_0x01fb:
            java.util.HashMap<java.lang.String, com.visa.checkout.s> r3 = r0.f398     // Catch:{ Exception -> 0x02ee }
            java.lang.Object r1 = r3.get(r1)     // Catch:{ Exception -> 0x02ee }
            com.visa.checkout.s r1 = (com.visa.checkout.s) r1     // Catch:{ Exception -> 0x02ee }
            if (r1 != 0) goto L_0x021a
            int r1 = f395
            int r1 = r1 + r8
            int r3 = r1 % 128
            f391 = r3
            r3 = 2
            int r1 = r1 % r3
            if (r1 != 0) goto L_0x0215
            r1 = 0
            r2.m6304(r1)     // Catch:{ Exception -> 0x02ef }
            return
        L_0x0215:
            r1 = 0
            r2.m6304(r1)     // Catch:{ Exception -> 0x02ef }
            throw r1     // Catch:{ Exception -> 0x02ef }
        L_0x021a:
            java.util.EnumSet r3 = r1.m6289()     // Catch:{ Exception -> 0x02ee }
            com.visa.checkout.x r4 = com.visa.checkout.x.f417     // Catch:{ Exception -> 0x02ee }
            boolean r4 = r3.contains(r4)     // Catch:{ Exception -> 0x02ee }
            com.visa.checkout.x r7 = com.visa.checkout.x.f418     // Catch:{ Exception -> 0x02ee }
            boolean r3 = r3.contains(r7)     // Catch:{ Exception -> 0x02ee }
            if (r3 != 0) goto L_0x023d
            int r3 = f395
            int r3 = r3 + r6
            int r6 = r3 % 128
            f391 = r6
            r6 = 2
            int r3 = r3 % r6
            if (r4 == 0) goto L_0x0238
            goto L_0x023d
        L_0x0238:
            java.io.Serializable r3 = r1.m6287()     // Catch:{ Exception -> 0x02ee }
            goto L_0x0264
        L_0x023d:
            java.io.Serializable r3 = r1.m6287()     // Catch:{ Exception -> 0x02ee }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x02ee }
            java.lang.String r6 = r1.m6290()     // Catch:{ Exception -> 0x02ee }
            r7 = 2
            byte[] r3 = android.util.Base64.decode(r3, r7)     // Catch:{ Exception -> 0x02ee }
            byte[] r6 = android.util.Base64.decode(r6, r7)     // Catch:{ Exception -> 0x02ee }
            com.visa.checkout.f r7 = r0.f397     // Catch:{ Exception -> 0x02ee }
            byte[] r3 = r7.m6177(r3, r6)     // Catch:{ Exception -> 0x02ee }
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x02ee }
            r6.<init>(r3)     // Catch:{ Exception -> 0x02ee }
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x02ee }
            r3.<init>(r6)     // Catch:{ Exception -> 0x02ee }
            java.lang.Object r3 = r3.readObject()     // Catch:{ Exception -> 0x02ee }
        L_0x0264:
            if (r4 == 0) goto L_0x02cc
            int r6 = f391
            int r6 = r6 + 119
            int r7 = r6 % 128
            f395 = r7
            r7 = 2
            int r6 = r6 % r7
            boolean r6 = r16.m6295()     // Catch:{ Exception -> 0x02ee }
            if (r6 == 0) goto L_0x02cc
            java.lang.String r4 = r1.m6294()     // Catch:{ Exception -> 0x02ee }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x02ee }
            if (r4 == 0) goto L_0x028d
            r1 = 28
            r4 = 57
            java.lang.String r1 = m6297(r1, r4, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r1 = r1.intern()     // Catch:{ Exception -> 0x02ee }
            goto L_0x0291
        L_0x028d:
            java.lang.String r1 = r1.m6294()     // Catch:{ Exception -> 0x02ee }
        L_0x0291:
            com.visa.checkout.t$d r4 = new com.visa.checkout.t$d     // Catch:{ Exception -> 0x02ee }
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x02ee }
            r6.<init>(r0)     // Catch:{ Exception -> 0x02ee }
            r4.<init>(r6, r2, r3)     // Catch:{ Exception -> 0x02ee }
            java.lang.ref.WeakReference<android.app.Activity> r3 = f394     // Catch:{ Exception -> 0x02ee }
            if (r3 != 0) goto L_0x02a3
            r4.m6203()     // Catch:{ Exception -> 0x02ee }
            return
        L_0x02a3:
            com.visa.checkout.j r3 = new com.visa.checkout.j     // Catch:{ Exception -> 0x02ee }
            r3.<init>()     // Catch:{ Exception -> 0x02ee }
            android.hardware.fingerprint.FingerprintManager r6 = r0.f400     // Catch:{ Exception -> 0x02ee }
            r3.m6200((android.hardware.fingerprint.FingerprintManager) r6)     // Catch:{ Exception -> 0x02ee }
            r3.m6198((java.lang.String) r1)     // Catch:{ Exception -> 0x02ee }
            java.lang.ref.WeakReference<android.app.Activity> r1 = f394     // Catch:{ Exception -> 0x02ee }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x02ee }
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x02ee }
            android.app.FragmentManager r1 = r1.getFragmentManager()     // Catch:{ Exception -> 0x02ee }
            r6 = 2
            java.lang.String r5 = m6297(r6, r5, r11)     // Catch:{ Exception -> 0x02ee }
            java.lang.String r5 = r5.intern()     // Catch:{ Exception -> 0x02ee }
            r3.show(r1, r5)     // Catch:{ Exception -> 0x02ee }
            r3.m6196((com.visa.checkout.j.a) r4)     // Catch:{ Exception -> 0x02ee }
            return
        L_0x02cc:
            if (r4 == 0) goto L_0x02ea
            boolean r1 = r16.m6295()     // Catch:{ Exception -> 0x02ee }
            if (r1 != 0) goto L_0x02ea
            int r1 = f391
            int r1 = r1 + 67
            int r3 = r1 % 128
            f395 = r3
            r3 = 2
            int r1 = r1 % r3
            if (r1 == 0) goto L_0x02e5
            r1 = 0
            r2.m6304(r1)     // Catch:{ Exception -> 0x02ef }
            return
        L_0x02e5:
            r1 = 0
            r2.m6304(r1)     // Catch:{ Exception -> 0x02ef }
            throw r1     // Catch:{ Exception -> 0x02ef }
        L_0x02ea:
            r2.m6304(r3)     // Catch:{ Exception -> 0x02ee }
            return
        L_0x02ee:
            r1 = 0
        L_0x02ef:
            r2.m6304(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.t.m6299(java.lang.String, com.visa.checkout.t$c):void");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m6300() {
        int i11 = f391 + 65;
        int i12 = i11 % 128;
        f395 = i12;
        if ((i11 % 2 == 0 ? 7 : 'P') == 'P') {
            f394 = null;
            this.f396 = null;
            this.f400 = null;
            int i13 = i12 + 109;
            f391 = i13 % 128;
            int i14 = i13 % 2;
            return;
        }
        f394 = null;
        this.f396 = null;
        this.f400 = null;
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0055, code lost:
        if ((r9 % 2) == 0) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0057, code lost:
        r9 = 'H';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
        r9 = kotlin.text.Typography.less;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005b, code lost:
        if (r9 == 'H') goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        if (r8 == false) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0060, code lost:
        r9 = 39 / 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0063, code lost:
        if (r8 == false) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
        r8 = new java.io.ByteArrayOutputStream();
        r9 = new java.io.ObjectOutputStream(r8);
        r9.writeObject(r7);
        r9.flush();
        r7 = r8.toByteArray();
        r9.close();
        r7 = r5.f397.m6176(r7);
        r7 = android.util.Pair.create(android.util.Base64.encodeToString((byte[]) r7.first, 2), android.util.Base64.encodeToString((byte[]) r7.second, 2));
        r0.m6291((java.io.Serializable) r7.first);
        r0.m6292((java.lang.String) r7.second);
        r7 = f391 + 75;
        f395 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ad, code lost:
        r5.f398.put(r6, r0);
        com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation.execute(new com.visa.checkout.t.b(r5, (byte) 0), r5.f398, r5.f399);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c4, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0011, code lost:
        if (r7 == null) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        if (r7 == null) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r0 = new com.visa.checkout.s();
        r0.m6288(r9);
        r0.m6293(r8);
        r0.m6291(r7);
        r9 = r8.contains(com.visa.checkout.x.f417);
        r8 = r8.contains(com.visa.checkout.x.f418);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0048, code lost:
        if (r9 != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004a, code lost:
        r9 = f395 + 105;
        f391 = r9 % 128;
     */
    /* renamed from: ॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m6301(java.lang.String r6, java.io.Serializable r7, java.util.EnumSet<com.visa.checkout.x> r8, java.lang.String r9) throws java.lang.Exception {
        /*
            r5 = this;
            int r0 = f395
            int r0 = r0 + 105
            int r1 = r0 % 128
            f391 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0014
            r0 = 81
            int r0 = r0 / r3
            if (r7 != 0) goto L_0x002e
            goto L_0x0016
        L_0x0014:
            if (r7 != 0) goto L_0x002e
        L_0x0016:
            java.util.HashMap<java.lang.String, com.visa.checkout.s> r7 = r5.f398
            r7.remove(r6)
            com.visa.checkout.t$b r6 = new com.visa.checkout.t$b
            r6.<init>(r5, r3)
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.util.HashMap<java.lang.String, com.visa.checkout.s> r8 = r5.f398
            r7[r3] = r8
            java.lang.String r8 = r5.f399
            r7[r2] = r8
            com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation.execute(r6, r7)
            return
        L_0x002e:
            com.visa.checkout.s r0 = new com.visa.checkout.s
            r0.<init>()
            r0.m6288(r9)
            r0.m6293((java.util.EnumSet<com.visa.checkout.x>) r8)
            r0.m6291((java.io.Serializable) r7)
            com.visa.checkout.x r9 = com.visa.checkout.x.f417
            boolean r9 = r8.contains(r9)
            com.visa.checkout.x r4 = com.visa.checkout.x.f418
            boolean r8 = r8.contains(r4)
            if (r9 != 0) goto L_0x0065
            int r9 = f395
            int r9 = r9 + 105
            int r4 = r9 % 128
            f391 = r4
            int r9 = r9 % r1
            r4 = 72
            if (r9 == 0) goto L_0x0059
            r9 = r4
            goto L_0x005b
        L_0x0059:
            r9 = 60
        L_0x005b:
            if (r9 == r4) goto L_0x0060
            if (r8 == 0) goto L_0x00ad
            goto L_0x0065
        L_0x0060:
            r9 = 39
            int r9 = r9 / r3
            if (r8 == 0) goto L_0x00ad
        L_0x0065:
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream
            r8.<init>()
            java.io.ObjectOutputStream r9 = new java.io.ObjectOutputStream
            r9.<init>(r8)
            r9.writeObject(r7)
            r9.flush()
            byte[] r7 = r8.toByteArray()
            r9.close()
            com.visa.checkout.f r8 = r5.f397
            android.util.Pair r7 = r8.m6176((byte[]) r7)
            java.lang.Object r8 = r7.first
            byte[] r8 = (byte[]) r8
            java.lang.String r8 = android.util.Base64.encodeToString(r8, r1)
            java.lang.Object r7 = r7.second
            byte[] r7 = (byte[]) r7
            java.lang.String r7 = android.util.Base64.encodeToString(r7, r1)
            android.util.Pair r7 = android.util.Pair.create(r8, r7)
            java.lang.Object r8 = r7.first
            java.io.Serializable r8 = (java.io.Serializable) r8
            r0.m6291((java.io.Serializable) r8)
            java.lang.Object r7 = r7.second
            java.lang.String r7 = (java.lang.String) r7
            r0.m6292((java.lang.String) r7)
            int r7 = f391
            int r7 = r7 + 75
            int r8 = r7 % 128
            f395 = r8
            int r7 = r7 % r1
        L_0x00ad:
            java.util.HashMap<java.lang.String, com.visa.checkout.s> r7 = r5.f398
            r7.put(r6, r0)
            com.visa.checkout.t$b r6 = new com.visa.checkout.t$b
            r6.<init>(r5, r3)
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.util.HashMap<java.lang.String, com.visa.checkout.s> r8 = r5.f398
            r7[r3] = r8
            java.lang.String r8 = r5.f399
            r7[r2] = r8
            com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation.execute(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.t.m6301(java.lang.String, java.io.Serializable, java.util.EnumSet, java.lang.String):void");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String m6297(int i11, int i12, char c11) {
        int i13 = f395 + 67;
        f391 = i13 % 128;
        int i14 = i13 % 2;
        char[] cArr = new char[i11];
        int i15 = 0;
        while (true) {
            if ((i15 < i11 ? 'T' : 13) == 13) {
                return new String(cArr);
            }
            int i16 = f395;
            int i17 = i16 + 69;
            f391 = i17 % 128;
            if (i17 % 2 != 0) {
                cArr[i15] = (char) ((int) ((((long) f393[i12 << i15]) / (((long) i15) + f392)) / ((long) c11)));
                i15 += 0;
            } else {
                cArr[i15] = (char) ((int) ((((long) f393[i12 + i15]) ^ (((long) i15) * f392)) ^ ((long) c11)));
                i15++;
            }
            int i18 = i16 + 71;
            f391 = i18 % 128;
            int i19 = i18 % 2;
        }
    }
}
