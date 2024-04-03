package com.apptimize;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f43085a = "j";

    /* renamed from: b  reason: collision with root package name */
    private static b f43086b = b.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private static final Map<c, String> f43087c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<c, String> f43088d;

    /* renamed from: e  reason: collision with root package name */
    private static final Map<c, String> f43089e;

    /* renamed from: f  reason: collision with root package name */
    private static final Map<c, String> f43090f;

    /* renamed from: com.apptimize.j$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f43091a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f43092b;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        static {
            /*
                com.apptimize.j$a[] r0 = com.apptimize.j.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f43092b = r0
                r1 = 1
                com.apptimize.j$a r2 = com.apptimize.j.a.PROD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f43092b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.apptimize.j$a r3 = com.apptimize.j.a.STAGING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.apptimize.j$b[] r2 = com.apptimize.j.b.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f43091a = r2
                com.apptimize.j$b r3 = com.apptimize.j.b.DEFAULT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f43091a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.apptimize.j$b r2 = com.apptimize.j.b.EUCS     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f43091a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.apptimize.j$b r1 = com.apptimize.j.b.GCP     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apptimize.j.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        PROD,
        STAGING
    }

    public enum b {
        DEFAULT,
        EUCS,
        GCP
    }

    public enum c {
        WEB_SOCKET,
        PAIRING_TOKEN,
        PILOT_GROUPS,
        LOW_LATENCY_METADATA,
        LOW_LATENCY_BACKGROUND_METADATA,
        HIGH_LATENCY_METADATA,
        DEVELOPER_METADATA
    }

    static {
        HashMap hashMap = new HashMap();
        f43087c = hashMap;
        c cVar = c.WEB_SOCKET;
        hashMap.put(cVar, "wss://plank.apptimize.com/websocket");
        c cVar2 = c.PAIRING_TOKEN;
        hashMap.put(cVar2, "https://tycho.apptimize.com/api/pairing/v2/%s?rid=%s&guid=%s");
        c cVar3 = c.PILOT_GROUPS;
        hashMap.put(cVar3, "https://mapi.apptimize.com/api/pilot-groups?appKey={lapp_key}&pilotTargetingId={lpilot_targeting_id}");
        c cVar4 = c.LOW_LATENCY_METADATA;
        hashMap.put(cVar4, "https://md-a-c.apptimize.com/api/metadata/v4/");
        c cVar5 = c.LOW_LATENCY_BACKGROUND_METADATA;
        hashMap.put(cVar5, "https://md-a-c.apptimize.com/api/metadata/v4/");
        c cVar6 = c.HIGH_LATENCY_METADATA;
        hashMap.put(cVar6, "https://md-a-s.apptimize.com/api/metadata/v4/");
        c cVar7 = c.DEVELOPER_METADATA;
        hashMap.put(cVar7, "https://md-a-d.apptimize.com/api/metadata/v4/");
        HashMap hashMap2 = new HashMap();
        f43088d = hashMap2;
        hashMap2.put(cVar, "wss://staging-plank.apptimize.co/websocket");
        hashMap2.put(cVar2, "https://staging-tycho.apptimize.co/api/pairing/v2/%s?rid=%s&guid=%s");
        hashMap2.put(cVar3, "https://staging-mapi.apptimize.co/api/pilot-groups?appKey={lapp_key}&pilotTargetingId={lpilot_targeting_id}");
        hashMap2.put(cVar4, "https://staging-md.apptimize.co/api/metadata/v4/");
        hashMap2.put(cVar5, "https://staging-md.apptimize.co/api/metadata/v4/");
        hashMap2.put(cVar6, "https://staging-md.apptimize.co/api/metadata/v4/");
        hashMap2.put(cVar7, "https://staging-md.apptimize.co/api/metadata/v4/");
        HashMap hashMap3 = new HashMap();
        f43089e = hashMap3;
        hashMap3.put(cVar, "wss://plank.apptimize.eu/websocket");
        hashMap3.put(cVar2, "https://tycho.apptimize.eu/api/pairing/v2/%s?rid=%s&guid=%s");
        hashMap3.put(cVar3, "https://mapi.apptimize.eu/api/pilot-groups?appKey={lapp_key}&pilotTargetingId={lpilot_targeting_id}");
        hashMap3.put(cVar4, "https://md-a-c.apptimize.eu/api/metadata/v4/");
        hashMap3.put(cVar5, "https://md-a-c.apptimize.eu/api/metadata/v4/");
        hashMap3.put(cVar6, "https://md-a-s.apptimize.eu/api/metadata/v4/");
        hashMap3.put(cVar7, "https://md-a-d.apptimize.eu/api/metadata/v4/");
        HashMap hashMap4 = new HashMap();
        f43090f = hashMap4;
        hashMap4.put(cVar, "wss://gcp-stag-plank.apptimize.co/websocket");
        hashMap4.put(cVar2, "https://gcp-stag-tycho.apptimize.co/api/pairing/v2/%s?rid=%s&guid=%s");
        hashMap4.put(cVar3, "https://gcp-stag-mapi.apptimize.co/api/pilot-groups?appKey={lapp_key}&pilotTargetingId={lpilot_targeting_id}");
        hashMap4.put(cVar4, "https://gcp-stag-md.apptimize.co/api/metadata/v4/");
        hashMap4.put(cVar5, "https://gcp-stag-md.apptimize.co/api/metadata/v4/");
        hashMap4.put(cVar6, "https://gcp-stag-md.apptimize.co/api/metadata/v4/");
        hashMap4.put(cVar7, "https://gcp-stag-md.apptimize.co/api/metadata/v4/");
    }

    public static String a() {
        return a(c.WEB_SOCKET, a.PROD);
    }

    public static String b() {
        return a(c.PAIRING_TOKEN, a.PROD);
    }

    private static String c(c cVar, a aVar) {
        if (AnonymousClass1.f43092b[aVar.ordinal()] == 1) {
            return f43089e.get(cVar);
        }
        Log.e(f43085a, "Unknown ServerEnvironment specified for eucs, falling back to default");
        return b(cVar, aVar);
    }

    private static String d(c cVar, a aVar) {
        if (AnonymousClass1.f43092b[aVar.ordinal()] == 2) {
            return f43090f.get(cVar);
        }
        Log.e(f43085a, "Unknown ServerEnvironment specified for gcp, falling back to default");
        return b(cVar, aVar);
    }

    public static void a(b bVar) {
        f43086b = bVar;
    }

    private static String b(c cVar, a aVar) {
        int i11 = AnonymousClass1.f43092b[aVar.ordinal()];
        if (i11 == 1) {
            return f43087c.get(cVar);
        }
        if (i11 == 2) {
            return f43088d.get(cVar);
        }
        Log.e(f43085a, "Unknown ServerEnvironment specified for default, falling back to prod");
        return b(cVar, a.PROD);
    }

    public static String a(c cVar, a aVar, b bVar) {
        int i11 = AnonymousClass1.f43091a[bVar.ordinal()];
        if (i11 == 1) {
            return b(cVar, aVar);
        }
        if (i11 == 2) {
            return c(cVar, aVar);
        }
        if (i11 != 3) {
            return null;
        }
        return d(cVar, aVar);
    }

    public static String a(c cVar, a aVar) {
        return a(cVar, aVar, f43086b);
    }
}
