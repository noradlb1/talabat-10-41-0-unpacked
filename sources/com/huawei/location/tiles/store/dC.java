package com.huawei.location.tiles.store;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.tiles.utils.d2;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Instrumented
public class dC {
    private static double E5 = 0.0d;
    private static final String FB;
    private static final String LW;
    private static final String Vw;

    /* renamed from: d2  reason: collision with root package name */
    private static double f50248d2 = 0.0d;
    private static String dC;

    /* renamed from: yn  reason: collision with root package name */
    public static final String f50249yn;
    private Vw Ot;

    /* renamed from: oc  reason: collision with root package name */
    private yn f50250oc;

    /* renamed from: ut  reason: collision with root package name */
    private int f50251ut = 30;

    /* renamed from: zp  reason: collision with root package name */
    private int f50252zp = 25;

    public class FB extends TypeToken<Vw> {
        public FB(dC dCVar) {
        }
    }

    public class LW implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50253b;

        public LW(String str) {
            this.f50253b = str;
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("SDM-TileStoreManager-" + hashCode());
            dC.c(dC.this, this.f50253b);
        }
    }

    public class Vw implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f50255b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f50256c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f50257d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50258e;

        public Vw(dC dCVar, String str, String str2, String str3, String str4) {
            this.f50255b = str;
            this.f50256c = str2;
            this.f50257d = str3;
            this.f50258e = str4;
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("SDM-TileStoreManager-" + hashCode());
            if (!com.huawei.location.activity.model.Vw.yn(this.f50255b, this.f50256c, this.f50257d, this.f50258e)) {
                com.huawei.location.tiles.utils.FB.FB();
            }
        }
    }

    public class yn implements Runnable {
        public yn() {
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("SDM-TileStoreManager-" + hashCode());
            dC.b(dC.this);
            dC.a(dC.this);
        }
    }

    static {
        String str;
        try {
            str = ContextUtil.getContext().getCacheDir().getCanonicalPath() + File.separator;
        } catch (IOException unused) {
            LogConsole.e("FileUtils", "Failed to obtain the store dir path.");
            str = null;
        }
        f50249yn = str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("CityAdmin");
        String str2 = File.separator;
        sb2.append(str2);
        Vw = sb2.toString();
        FB = str + "CityInfo" + str2;
        LW = str + "TileList" + str2;
    }

    public dC(int i11, int i12) {
        Vw(i11);
        yn(i12);
    }

    private void Vw(int i11) {
        if (i11 > 0) {
            this.f50252zp = i11;
        } else {
            LogConsole.i("TileStoreManager", "tileDailyMaxNum is Invalid.");
        }
    }

    private synchronized void Vw(String str) {
        LogConsole.i("TileStoreManager", "get cityInfo form cloud");
        ExecutorUtil.getInstance().execute(new LW(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Vw() {
        /*
            r10 = this;
            com.huawei.location.tiles.store.yn r0 = r10.f50250oc
            r1 = 604800000(0x240c8400, double:2.988109026E-315)
            java.lang.String r3 = "CityAdminJson"
            r4 = 0
            java.lang.String r5 = "TileStoreManager"
            if (r0 != 0) goto L_0x0076
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = f50249yn
            r0.append(r6)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r0)
            boolean r6 = r3.exists()
            if (r6 != 0) goto L_0x0029
            goto L_0x0049
        L_0x0029:
            long r6 = java.lang.System.currentTimeMillis()
            long r8 = r3.lastModified()
            long r6 = r6 - r8
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x003f
            boolean r0 = r3.delete()
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = "Failed to delete old adminJson file."
            goto L_0x0063
        L_0x003f:
            java.lang.String r0 = com.huawei.location.tiles.utils.yn.Vw(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x004b
        L_0x0049:
            r0 = r4
            goto L_0x0067
        L_0x004b:
            com.google.gson.Gson r1 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch:{ JsonSyntaxException -> 0x0061 }
            java.lang.Class<com.huawei.location.tiles.store.yn> r2 = com.huawei.location.tiles.store.yn.class
            boolean r3 = r1 instanceof com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x0061 }
            if (r3 != 0) goto L_0x005a
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r2)     // Catch:{ JsonSyntaxException -> 0x0061 }
            goto L_0x005e
        L_0x005a:
            java.lang.Object r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r1, (java.lang.String) r0, r2)     // Catch:{ JsonSyntaxException -> 0x0061 }
        L_0x005e:
            com.huawei.location.tiles.store.yn r0 = (com.huawei.location.tiles.store.yn) r0     // Catch:{ JsonSyntaxException -> 0x0061 }
            goto L_0x0067
        L_0x0061:
            java.lang.String r0 = "json syntax error"
        L_0x0063:
            com.huawei.location.lite.common.log.LogConsole.e(r5, r0)
            goto L_0x0049
        L_0x0067:
            r10.f50250oc = r0
            if (r0 == 0) goto L_0x006d
            r0 = 1
            goto L_0x006e
        L_0x006d:
            r0 = 0
        L_0x006e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "hasAdminJson is: "
            goto L_0x0092
        L_0x0076:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = f50249yn
            r0.append(r6)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.huawei.location.tiles.utils.yn.yn((java.lang.String) r0, (long) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adminJson is exist, checking local files are expired: "
        L_0x0092:
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r5, r1)
            if (r0 != 0) goto L_0x00b4
            java.lang.String r1 = "set adminJson is null"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r1)
            r10.f50250oc = r4
            com.huawei.location.lite.common.util.ExecutorUtil r1 = com.huawei.location.lite.common.util.ExecutorUtil.getInstance()
            com.huawei.location.tiles.store.dC$yn r2 = new com.huawei.location.tiles.store.dC$yn
            r2.<init>()
            r1.execute(r2)
        L_0x00b4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.store.dC.Vw():boolean");
    }

    public static void a(dC dCVar) {
        String str;
        String str2;
        synchronized (dCVar) {
            yn ynVar = dCVar.f50250oc;
            if (ynVar != null) {
                String yn2 = ynVar.yn();
                String FB2 = dCVar.f50250oc.FB();
                String Vw2 = dCVar.f50250oc.Vw();
                String str3 = Vw;
                String yn3 = com.huawei.location.tiles.utils.yn.yn(str3, yn2);
                if (!TextUtils.isEmpty(yn3)) {
                    if (!TextUtils.isEmpty(Vw2)) {
                        File file = new File(yn3);
                        if (file.exists()) {
                            String yn4 = com.huawei.location.tiles.utils.LW.yn(yn3, FB2);
                            if (!TextUtils.isEmpty(yn4) && yn4.equals(Vw2)) {
                                str = "TileStoreManager";
                                str2 = "The file is the latest version.";
                                LogConsole.d(str, str2);
                            } else if (file.getParentFile().delete()) {
                                LogConsole.e("TileStoreManager", "Failed to delete the file.");
                            }
                        }
                        if (com.huawei.location.activity.model.Vw.yn(yn3, yn2, FB2, Vw2) && !com.huawei.location.tiles.utils.yn.yn(yn3, str3, file.getName().replace(".zip", ""))) {
                            LogConsole.e("TileStoreManager", "Failed to unzip the adminJson file.");
                        }
                    }
                }
                str = "TileStoreManager";
                str2 = "The adminJson file data is abnormal.";
                LogConsole.d(str, str2);
            }
        }
    }

    public static void b(dC dCVar) {
        Object obj;
        String str;
        String str2;
        String str3;
        synchronized (dCVar) {
            if (dCVar.f50250oc == null) {
                String Vw2 = com.huawei.location.activity.model.Vw.Vw("CITYADMIN-WKT");
                if (TextUtils.isEmpty(Vw2)) {
                    LogConsole.d("TileStoreManager", "get adminJson from cloud is fail");
                } else {
                    try {
                        Type type = new d2(dCVar).getType();
                        Gson instance = GsonUtil.getInstance();
                        if (!(instance instanceof Gson)) {
                            obj = instance.fromJson(Vw2, type);
                        } else {
                            obj = GsonInstrumentation.fromJson(instance, Vw2, type);
                        }
                        List list = (List) obj;
                        if (list != null) {
                            if (list.size() != 0) {
                                yn ynVar = (yn) list.get(0);
                                if (ynVar == null) {
                                    str = "TileStoreManager";
                                    str2 = "tempAdminJson is null";
                                    LogConsole.d(str, str2);
                                } else {
                                    dCVar.f50250oc = ynVar;
                                    Gson instance2 = GsonUtil.getInstance();
                                    yn ynVar2 = dCVar.f50250oc;
                                    if (!(instance2 instanceof Gson)) {
                                        str3 = instance2.toJson((Object) ynVar2);
                                    } else {
                                        str3 = GsonInstrumentation.toJson(instance2, (Object) ynVar2);
                                    }
                                    com.huawei.location.tiles.utils.yn.yn(str3, new File(f50249yn + "CityAdminJson"));
                                }
                            }
                        }
                        str = "TileStoreManager";
                        str2 = "adminJsonList is null";
                        LogConsole.d(str, str2);
                    } catch (JsonSyntaxException unused) {
                        LogConsole.e("TileStoreManager", "json syntax error");
                    }
                }
            }
        }
        return;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056 A[LOOP:0: B:1:0x000d->B:18:0x0056, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059 A[EDGE_INSN: B:40:0x0059->B:19:0x0059 ?: BREAK  
    EDGE_INSN: B:41:0x0059->B:19:0x0059 ?: BREAK  ] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(com.huawei.location.tiles.store.dC r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "json syntax error"
            java.lang.String r1 = "TileStoreManager"
            r8.getClass()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 1
        L_0x000d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            java.lang.String r5 = "_"
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = com.huawei.location.activity.model.Vw.Vw((java.lang.String) r4)
            com.huawei.location.tiles.store.zp r5 = new com.huawei.location.tiles.store.zp     // Catch:{ JsonSyntaxException -> 0x0047 }
            r5.<init>(r8)     // Catch:{ JsonSyntaxException -> 0x0047 }
            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ JsonSyntaxException -> 0x0047 }
            com.google.gson.Gson r6 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch:{ JsonSyntaxException -> 0x0047 }
            boolean r7 = r6 instanceof com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x0047 }
            if (r7 != 0) goto L_0x003b
            java.lang.Object r4 = r6.fromJson((java.lang.String) r4, (java.lang.reflect.Type) r5)     // Catch:{ JsonSyntaxException -> 0x0047 }
            goto L_0x003f
        L_0x003b:
            java.lang.Object r4 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r6, (java.lang.String) r4, (java.lang.reflect.Type) r5)     // Catch:{ JsonSyntaxException -> 0x0047 }
        L_0x003f:
            java.util.List r4 = (java.util.List) r4     // Catch:{ JsonSyntaxException -> 0x0047 }
            if (r4 == 0) goto L_0x004b
            r2.addAll(r4)     // Catch:{ JsonSyntaxException -> 0x0048 }
            goto L_0x004b
        L_0x0047:
            r4 = 0
        L_0x0048:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
        L_0x004b:
            if (r4 == 0) goto L_0x0059
            int r4 = r4.size()
            r5 = 59
            if (r4 >= r5) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0059:
            java.lang.String r3 = com.huawei.location.activity.model.Vw.Vw((java.lang.String) r9)
            com.huawei.location.tiles.store.ut r4 = new com.huawei.location.tiles.store.ut     // Catch:{ JsonSyntaxException -> 0x007f }
            r4.<init>(r8)     // Catch:{ JsonSyntaxException -> 0x007f }
            java.lang.reflect.Type r4 = r4.getType()     // Catch:{ JsonSyntaxException -> 0x007f }
            com.google.gson.Gson r5 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch:{ JsonSyntaxException -> 0x007f }
            boolean r6 = r5 instanceof com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x007f }
            if (r6 != 0) goto L_0x0073
            java.lang.Object r3 = r5.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r4)     // Catch:{ JsonSyntaxException -> 0x007f }
            goto L_0x0077
        L_0x0073:
            java.lang.Object r3 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r5, (java.lang.String) r3, (java.lang.reflect.Type) r4)     // Catch:{ JsonSyntaxException -> 0x007f }
        L_0x0077:
            java.util.List r3 = (java.util.List) r3     // Catch:{ JsonSyntaxException -> 0x007f }
            if (r3 == 0) goto L_0x0082
            r2.addAll(r3)     // Catch:{ JsonSyntaxException -> 0x007f }
            goto L_0x0082
        L_0x007f:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
        L_0x0082:
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x00cc
            com.huawei.location.tiles.store.Vw r0 = new com.huawei.location.tiles.store.Vw
            r0.<init>(r9, r2)
            r8.Ot = r0
            com.google.gson.Gson r0 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            com.huawei.location.tiles.store.Vw r8 = r8.Ot
            boolean r1 = r0 instanceof com.google.gson.Gson
            if (r1 != 0) goto L_0x009e
            java.lang.String r8 = r0.toJson((java.lang.Object) r8)
            goto L_0x00a2
        L_0x009e:
            java.lang.String r8 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r0, (java.lang.Object) r8)
        L_0x00a2:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = FB
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            java.io.File r9 = r0.getParentFile()
            boolean r9 = r9.exists()
            if (r9 != 0) goto L_0x00c9
            java.io.File r9 = r0.getParentFile()
            r9.mkdirs()
        L_0x00c9:
            com.huawei.location.tiles.utils.yn.yn((java.lang.String) r8, (java.io.File) r0)
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.store.dC.c(com.huawei.location.tiles.store.dC, java.lang.String):void");
    }

    private FB yn(String str, List<FB> list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            for (FB next : list) {
                if (next != null) {
                    String yn2 = next.yn();
                    if (!TextUtils.isEmpty(yn2)) {
                        if (yn2.endsWith(str + ".zip")) {
                            return next;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    private Vw yn(String str) {
        String str2;
        File file = new File(FB + str);
        if (!file.exists() || System.currentTimeMillis() - file.lastModified() >= 604800000) {
            return null;
        }
        try {
            String Vw2 = com.huawei.location.tiles.utils.yn.Vw(file.getCanonicalPath());
            Type type = new FB(this).getType();
            Gson instance = GsonUtil.getInstance();
            return (Vw) (!(instance instanceof Gson) ? instance.fromJson(Vw2, type) : GsonInstrumentation.fromJson(instance, Vw2, type));
        } catch (IOException unused) {
            str2 = "Invalid file path";
            LogConsole.e("TileStoreManager", str2);
            return null;
        } catch (JsonSyntaxException unused2) {
            str2 = "json syntax error";
            LogConsole.e("TileStoreManager", str2);
            return null;
        }
    }

    private void yn(int i11) {
        if (i11 > 0) {
            this.f50251ut = i11;
        } else {
            LogConsole.i("TileStoreManager", "storeFileMaxNum is Invalid.");
        }
    }

    private void yn(String str, String str2, String str3, String str4) {
        if (com.huawei.location.tiles.utils.FB.Vw() >= this.f50252zp) {
            LogConsole.i("TileStoreManager", "The maximum number of downloads per day is exceeded.");
            return;
        }
        com.huawei.location.tiles.utils.FB.yn();
        com.huawei.location.tiles.utils.yn.yn(LW, this.f50251ut);
        ExecutorUtil.getInstance().execute(new Vw(this, str, str2, str3, str4));
    }

    public LW FB(String str) {
        if (TextUtils.isEmpty(f50249yn)) {
            LogConsole.i("TileStoreManager", "store dir is empty");
            return new LW(3, (String) null);
        } else if (TextUtils.isEmpty(dC)) {
            LogConsole.i("TileStoreManager", "Failed to get tile,currCityCode is empty");
            return new LW(3, (String) null);
        } else {
            if (this.Ot == null) {
                this.Ot = yn(dC);
            }
            Vw vw2 = this.Ot;
            if (vw2 == null) {
                LogConsole.i("TileStoreManager", "Failed to get tile,cityInfo cache is null");
                Vw(dC);
                return new LW(2, (String) null);
            }
            FB yn2 = yn(str, vw2.Vw());
            if (yn2 == null) {
                LogConsole.d("TileStoreManager", "current location does not have tile info");
                return new LW(3, (String) null);
            }
            String yn3 = yn2.yn();
            String yn4 = com.huawei.location.tiles.utils.yn.yn(LW, yn3);
            String FB2 = yn2.FB();
            String Vw2 = yn2.Vw();
            if (TextUtils.isEmpty(yn4)) {
                LogConsole.d("TileStoreManager", "get filePath from downloadUrl error");
                return new LW(3, (String) null);
            }
            File file = new File(yn4);
            if (!file.exists()) {
                LogConsole.i("TileStoreManager", "tile zip file does not exist");
                yn(yn4, yn3, FB2, Vw2);
                return new LW(2, (String) null);
            }
            String yn5 = com.huawei.location.tiles.utils.LW.yn(yn4, FB2);
            if (TextUtils.isEmpty(yn5) || !yn5.equals(Vw2)) {
                LogConsole.i("TileStoreManager", "The signature information is incorrect.");
                if (file.delete()) {
                    LogConsole.e("TileStoreManager", "Failed to delete the file.");
                }
                yn(yn4, yn3, FB2, Vw2);
                return new LW(2, (String) null);
            }
            LogConsole.i("TileStoreManager", "get tilePath success from the tileStore.");
            return new LW(1, yn4);
        }
    }

    public d2 yn() {
        return new d2(f50248d2, E5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0137, code lost:
        if (com.huawei.location.tiles.utils.yn.yn(FB + r0, 604800000) == false) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0140, code lost:
        if (r4 == null) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x015a, code lost:
        if (yn(java.lang.String.valueOf(com.huawei.location.activity.model.Vw.yn(r12, r14, 15)), r11.Ot.Vw()) == null) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x015c, code lost:
        r2 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean yn(double r12, double r14) {
        /*
            r11 = this;
            E5 = r12
            f50248d2 = r14
            java.lang.String r0 = f50249yn
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r1 = "TileStoreManager"
            r2 = 0
            if (r0 == 0) goto L_0x0015
            java.lang.String r12 = "store dir is empty"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r12)
            return r2
        L_0x0015:
            boolean r0 = r11.Vw()
            if (r0 == 0) goto L_0x0172
            com.huawei.location.tiles.store.yn r0 = r11.f50250oc
            r3 = 1
            java.lang.String r4 = ""
            java.lang.String r5 = ".zip"
            if (r0 != 0) goto L_0x0027
        L_0x0024:
            r0 = r2
            goto L_0x00a8
        L_0x0027:
            java.lang.String r0 = r0.yn()
            java.lang.String r6 = Vw
            java.lang.String r0 = com.huawei.location.tiles.utils.yn.yn((java.lang.String) r6, (java.lang.String) r0)
            com.huawei.location.tiles.store.yn r7 = r11.f50250oc
            java.lang.String r7 = r7.FB()
            com.huawei.location.tiles.store.yn r8 = r11.f50250oc
            java.lang.String r8 = r8.Vw()
            boolean r9 = android.text.TextUtils.isEmpty(r0)
            if (r9 == 0) goto L_0x0049
            java.lang.String r0 = "The local compressed file path does not exist."
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            goto L_0x0024
        L_0x0049:
            java.io.File r9 = new java.io.File
            r9.<init>(r0)
            java.lang.String r7 = com.huawei.location.tiles.utils.LW.yn(r0, r7)
            boolean r10 = r9.exists()
            if (r10 == 0) goto L_0x009a
            boolean r10 = android.text.TextUtils.isEmpty(r7)
            if (r10 != 0) goto L_0x009a
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0065
            goto L_0x009a
        L_0x0065:
            java.lang.String r7 = r9.getName()
            java.lang.String r7 = r7.replace(r5, r4)
            java.io.File r8 = new java.io.File
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            boolean r8 = r8.exists()
            if (r8 != 0) goto L_0x0093
            boolean r0 = com.huawei.location.tiles.utils.yn.yn((java.lang.String) r0, (java.lang.String) r6, (java.lang.String) r7)
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = "Failed to unzip the file."
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
            goto L_0x0024
        L_0x0093:
            java.lang.String r0 = "The local cityAdmin file exists."
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            r0 = r3
            goto L_0x00a8
        L_0x009a:
            com.huawei.location.lite.common.util.ExecutorUtil r0 = com.huawei.location.lite.common.util.ExecutorUtil.getInstance()
            com.huawei.location.tiles.store.E5 r6 = new com.huawei.location.tiles.store.E5
            r6.<init>(r11)
            r0.execute(r6)
            goto L_0x0024
        L_0x00a8:
            if (r0 != 0) goto L_0x00ac
            goto L_0x0172
        L_0x00ac:
            com.huawei.location.tiles.store.yn r0 = r11.f50250oc
            if (r0 != 0) goto L_0x00b6
            java.lang.String r12 = "adminJson is null"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r12)
            return r2
        L_0x00b6:
            java.lang.String r0 = r0.yn()
            java.lang.String r6 = Vw
            java.lang.String r0 = com.huawei.location.tiles.utils.yn.yn((java.lang.String) r6, (java.lang.String) r0)
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 == 0) goto L_0x00cc
            java.lang.String r12 = "Invalid zip file path."
            com.huawei.location.lite.common.log.LogConsole.i(r1, r12)
            return r2
        L_0x00cc:
            java.io.File r7 = new java.io.File
            r7.<init>(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = r7.getName()
            java.lang.String r4 = r6.replace(r5, r4)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.huawei.location.tiles.utils.yn.yn((java.lang.String) r0, (double) r12, (double) r14)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L_0x00f8
            java.lang.String r12 = "The cityCode is not found."
            com.huawei.location.lite.common.log.LogConsole.i(r1, r12)
            return r2
        L_0x00f8:
            java.lang.String r4 = "[a-zA-Z0-9\\.\\-\\_]+"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)
            java.util.regex.Matcher r4 = r4.matcher(r0)
            boolean r4 = r4.matches()
            if (r4 != 0) goto L_0x010e
            java.lang.String r12 = "The cityCode contains invalid characters."
            com.huawei.location.lite.common.log.LogConsole.i(r1, r12)
            return r2
        L_0x010e:
            dC = r0
            com.huawei.location.tiles.store.Vw r4 = r11.Ot
            if (r4 == 0) goto L_0x013a
            java.lang.String r4 = r4.yn()
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x011f
            goto L_0x013a
        L_0x011f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = FB
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r5 = 604800000(0x240c8400, double:2.988109026E-315)
            boolean r4 = com.huawei.location.tiles.utils.yn.yn((java.lang.String) r4, (long) r5)
            if (r4 != 0) goto L_0x0146
            goto L_0x0142
        L_0x013a:
            com.huawei.location.tiles.store.Vw r4 = r11.yn((java.lang.String) r0)
            r11.Ot = r4
            if (r4 != 0) goto L_0x0146
        L_0x0142:
            r11.Vw((java.lang.String) r0)
            goto L_0x015d
        L_0x0146:
            com.huawei.location.tiles.store.Vw r0 = r11.Ot
            java.util.List r0 = r0.Vw()
            r4 = 15
            long r12 = com.huawei.location.activity.model.Vw.yn((double) r12, (double) r14, (int) r4)
            java.lang.String r12 = java.lang.String.valueOf(r12)
            com.huawei.location.tiles.store.FB r12 = r11.yn((java.lang.String) r12, (java.util.List<com.huawei.location.tiles.store.FB>) r0)
            if (r12 == 0) goto L_0x015d
            r2 = r3
        L_0x015d:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "check city Support is："
            r12.append(r13)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r1, r12)
            return r2
        L_0x0172:
            java.lang.String r12 = "do not have adminJson or adminFile"
            com.huawei.location.lite.common.log.LogConsole.d(r1, r12)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.tiles.store.dC.yn(double, double):boolean");
    }
}
