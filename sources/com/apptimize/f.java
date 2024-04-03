package com.apptimize;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.apptimize.bd;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Instrumented
public class f extends SQLiteOpenHelper implements bd {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42376a = "f";

    /* renamed from: b  reason: collision with root package name */
    private static Map<bd.b, bd.a> f42377b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final String f42378c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadPoolExecutor f42379d;

    /* renamed from: e  reason: collision with root package name */
    private Context f42380e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f42381f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private AtomicBoolean f42382g = new AtomicBoolean(false);

    public abstract class a implements bh {

        /* renamed from: a  reason: collision with root package name */
        protected SQLiteDatabase f42389a;

        public a() {
            a();
        }

        public String a(String str) {
            return f.this.c(this.f42389a, str);
        }

        public abstract void a();

        public void b() {
            this.f42389a.setTransactionSuccessful();
        }

        public void c() {
            try {
                this.f42389a.endTransaction();
            } finally {
                this.f42389a = null;
            }
        }

        public List<JSONObject> d() {
            return f.this.a(this.f42389a);
        }

        public int e() {
            return f.this.b(this.f42389a);
        }

        public JSONObject f() {
            return f.this.c(this.f42389a);
        }
    }

    public class c implements bh {
        public c() {
        }

        public String a(String str) {
            return null;
        }

        public void b() {
        }

        public void c() {
        }

        public List<JSONObject> d() {
            return new ArrayList();
        }

        public int e() {
            return 0;
        }

        public JSONObject f() {
            return null;
        }
    }

    public class d extends a {
        public d() {
            super();
        }

        public void a() {
            SQLiteDatabase b11 = f.this.h();
            this.f42389a = b11;
            b11.beginTransactionNonExclusive();
        }
    }

    public f(Context context, bd.b bVar, ThreadPoolExecutor threadPoolExecutor) {
        super(context, a(bVar), (SQLiteDatabase.CursorFactory) null, 6);
        this.f42378c = a(bVar);
        this.f42380e = context;
        this.f42379d = threadPoolExecutor;
    }

    private synchronized boolean e() {
        if (this.f42382g.get()) {
            return true;
        }
        if (this.f42381f.get()) {
            return false;
        }
        return this.f42380e.getDatabasePath(this.f42378c).exists();
    }

    private void f() {
        if (!this.f42382g.get() && this.f42381f.compareAndSet(false, true)) {
            String str = f42376a;
            bo.m(str, "createDbInBackground " + this.f42378c);
            this.f42379d.submit(new fi() {
                public void run() {
                    fe.a(f.f42376a, new fi() {
                        public void run() {
                            SQLiteDatabase unused = f.this.g();
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public SQLiteDatabase g() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        if (!this.f42382g.get()) {
            onCreate(writableDatabase);
            this.f42382g.set(true);
        }
        return writableDatabase;
    }

    /* access modifiers changed from: private */
    public SQLiteDatabase h() {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (!this.f42382g.get()) {
            onCreate(readableDatabase);
            this.f42382g.set(true);
        }
        return readableDatabase;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS keyvals (k TEXT NOT NULL PRIMARY KEY ON CONFLICT REPLACE, v TEXT NOT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS keyvals (k TEXT NOT NULL PRIMARY KEY ON CONFLICT REPLACE, v TEXT NOT NULL)");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS entry_store (id INTEGER NOT NULL PRIMARY KEY ON CONFLICT REPLACE, value TEXT NOT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS entry_store (id INTEGER NOT NULL PRIMARY KEY ON CONFLICT REPLACE, value TEXT NOT NULL)");
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS blockedExperiments");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS blockedExperiments");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS pendingResults");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS pendingResults");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS queues");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS queues");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS pending_items");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS pending_items");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS entry_store");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS entry_store");
        }
        if (i11 < 5) {
            if (!z11) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS keyvals");
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS keyvals");
            }
        }
        onCreate(sQLiteDatabase);
    }

    public class b extends a implements bi {
        public b() {
            super();
        }

        public void a() {
            SQLiteDatabase a11 = f.this.g();
            this.f42389a = a11;
            a11.beginTransaction();
        }

        public void b(String str) {
            f.this.b(this.f42389a, str);
        }

        public void a(String str, String str2) {
            f.this.a(this.f42389a, str, str2);
        }

        public void a(dp dpVar) throws JSONException {
            f.this.a(this.f42389a, dpVar);
        }

        public void a(List<dp> list) {
            f.this.a(this.f42389a, list);
        }

        public void a(List<JSONObject> list, int i11) {
            f.this.a(this.f42389a, list, i11);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0064, code lost:
        if (r1 != null) goto L_0x0066;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[Catch:{ JSONException -> 0x005b, Exception -> 0x004f, all -> 0x004d, all -> 0x006a }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject c(android.database.sqlite.SQLiteDatabase r9) {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = "SELECT id, value FROM entry_store ORDER BY id DESC LIMIT 1"
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ JSONException -> 0x005b, Exception -> 0x004f, all -> 0x004d }
            boolean r4 = r9 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ JSONException -> 0x005b, Exception -> 0x004f, all -> 0x004d }
            if (r4 != 0) goto L_0x000f
            android.database.Cursor r9 = r9.rawQuery(r1, r3)     // Catch:{ JSONException -> 0x005b, Exception -> 0x004f, all -> 0x004d }
            goto L_0x0013
        L_0x000f:
            android.database.Cursor r9 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r9, r1, r3)     // Catch:{ JSONException -> 0x005b, Exception -> 0x004f, all -> 0x004d }
        L_0x0013:
            int r1 = r9.getCount()     // Catch:{ JSONException -> 0x0048, Exception -> 0x0043, all -> 0x003e }
            if (r1 <= 0) goto L_0x003a
            r9.moveToFirst()     // Catch:{ JSONException -> 0x0048, Exception -> 0x0043, all -> 0x003e }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0048, Exception -> 0x0043, all -> 0x003e }
            r3 = 1
            java.lang.String r3 = r9.getString(r3)     // Catch:{ JSONException -> 0x0048, Exception -> 0x0043, all -> 0x003e }
            r1.<init>((java.lang.String) r3)     // Catch:{ JSONException -> 0x0048, Exception -> 0x0043, all -> 0x003e }
            long r3 = com.apptimize.dp.a((org.json.JSONObject) r1)     // Catch:{ JSONException -> 0x0048, Exception -> 0x0043, all -> 0x003e }
            long r5 = r9.getLong(r2)     // Catch:{ JSONException -> 0x0048, Exception -> 0x0043, all -> 0x003e }
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0039
            java.lang.String r2 = f42376a     // Catch:{ JSONException -> 0x0048, Exception -> 0x0043, all -> 0x003e }
            java.lang.String r3 = "The id column did not match the Entry ID found in value."
            com.apptimize.bo.g(r2, r3)     // Catch:{ JSONException -> 0x0048, Exception -> 0x0043, all -> 0x003e }
        L_0x0039:
            r0 = r1
        L_0x003a:
            r9.close()
            goto L_0x0069
        L_0x003e:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x006c
        L_0x0043:
            r1 = move-exception
            r7 = r1
            r1 = r9
            r9 = r7
            goto L_0x0051
        L_0x0048:
            r1 = move-exception
            r7 = r1
            r1 = r9
            r9 = r7
            goto L_0x005d
        L_0x004d:
            r9 = move-exception
            goto L_0x006c
        L_0x004f:
            r9 = move-exception
            r1 = r0
        L_0x0051:
            java.lang.String r2 = f42376a     // Catch:{ all -> 0x006a }
            java.lang.String r3 = "Unable to retrieve latest entry from database"
            com.apptimize.bo.e(r2, r3, r9)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0069
            goto L_0x0066
        L_0x005b:
            r9 = move-exception
            r1 = r0
        L_0x005d:
            java.lang.String r2 = f42376a     // Catch:{ all -> 0x006a }
            java.lang.String r3 = "entry_store did not hold a properly formatted JSON value"
            com.apptimize.bo.e(r2, r3, r9)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0069
        L_0x0066:
            r1.close()
        L_0x0069:
            return r0
        L_0x006a:
            r9 = move-exception
            r0 = r1
        L_0x006c:
            if (r0 == 0) goto L_0x0071
            r0.close()
        L_0x0071:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.f.c(android.database.sqlite.SQLiteDatabase):org.json.JSONObject");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r1 == null) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(android.database.sqlite.SQLiteDatabase r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = "SELECT COUNT(*) FROM entry_store"
            java.lang.String[] r3 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0028 }
            boolean r4 = r6 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0028 }
            if (r4 != 0) goto L_0x000f
            android.database.Cursor r6 = r6.rawQuery(r2, r3)     // Catch:{ Exception -> 0x0028 }
            goto L_0x0013
        L_0x000f:
            android.database.Cursor r6 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r6, r2, r3)     // Catch:{ Exception -> 0x0028 }
        L_0x0013:
            r1 = r6
            r1.moveToFirst()     // Catch:{ Exception -> 0x0028 }
            boolean r6 = r1.isAfterLast()     // Catch:{ Exception -> 0x0028 }
            if (r6 != 0) goto L_0x0022
            int r6 = r1.getInt(r0)     // Catch:{ Exception -> 0x0028 }
            r0 = r6
        L_0x0022:
            r1.close()
            goto L_0x0033
        L_0x0026:
            r6 = move-exception
            goto L_0x0034
        L_0x0028:
            r6 = move-exception
            java.lang.String r2 = f42376a     // Catch:{ all -> 0x0026 }
            java.lang.String r3 = "Unable to retrieve entry count from database"
            com.apptimize.bo.e(r2, r3, r6)     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0033
            goto L_0x0022
        L_0x0033:
            return r0
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()
        L_0x0039:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.f.b(android.database.sqlite.SQLiteDatabase):int");
    }

    public static synchronized bd.a a(final Context context, final bd.b bVar, final ThreadPoolExecutor threadPoolExecutor) {
        bd.a aVar;
        synchronized (f.class) {
            if (!f42377b.containsKey(bVar)) {
                f42377b.put(bVar, new bd.a() {

                    /* renamed from: d  reason: collision with root package name */
                    private f f42386d;

                    /* renamed from: a */
                    public synchronized f b() {
                        if (this.f42386d == null) {
                            this.f42386d = new f(context, bVar, threadPoolExecutor);
                        }
                        return this.f42386d;
                    }
                });
            }
            aVar = f42377b.get(bVar);
        }
        return aVar;
    }

    private static String a(bd.b bVar) {
        return bVar == bd.b.OnFlash ? "apptimize.db" : "apptimize_tmp.db";
    }

    /* access modifiers changed from: private */
    public void b(SQLiteDatabase sQLiteDatabase, String str) {
        str.getClass();
        Object[] objArr = {str};
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("DELETE FROM keyvals WHERE k = ?", objArr);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DELETE FROM keyvals WHERE k = ?", objArr);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c(android.database.sqlite.SQLiteDatabase r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            r2 = 0
            r0[r2] = r8     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            java.lang.String r3 = "SELECT v FROM keyvals WHERE k = ?"
            boolean r4 = r7 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            if (r4 != 0) goto L_0x0012
            android.database.Cursor r7 = r7.rawQuery(r3, r0)     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            goto L_0x0016
        L_0x0012:
            android.database.Cursor r7 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r7, r3, r0)     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
        L_0x0016:
            r7.moveToFirst()     // Catch:{ Exception -> 0x002c, all -> 0x0028 }
            boolean r0 = r7.isAfterLast()     // Catch:{ Exception -> 0x002c, all -> 0x0028 }
            if (r0 != 0) goto L_0x0024
            java.lang.String r8 = r7.getString(r2)     // Catch:{ Exception -> 0x002c, all -> 0x0028 }
            r1 = r8
        L_0x0024:
            r7.close()
            goto L_0x0050
        L_0x0028:
            r8 = move-exception
            r1 = r7
            r7 = r8
            goto L_0x0053
        L_0x002c:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L_0x0035
        L_0x0031:
            r7 = move-exception
            goto L_0x0053
        L_0x0033:
            r7 = move-exception
            r0 = r1
        L_0x0035:
            java.lang.String r2 = f42376a     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r3.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = "Unable to retrieve value from database for key "
            r3.append(r4)     // Catch:{ all -> 0x0051 }
            r3.append(r8)     // Catch:{ all -> 0x0051 }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x0051 }
            com.apptimize.bo.e(r2, r8, r7)     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0050
            r0.close()
        L_0x0050:
            return r1
        L_0x0051:
            r7 = move-exception
            r1 = r0
        L_0x0053:
            if (r1 == 0) goto L_0x0058
            r1.close()
        L_0x0058:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.f.c(android.database.sqlite.SQLiteDatabase, java.lang.String):java.lang.String");
    }

    public void a() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String str = f42376a;
        bo.e(str, "Wiping db " + this.f42378c);
        boolean z11 = writableDatabase instanceof SQLiteDatabase;
        if (!z11) {
            writableDatabase.execSQL("DROP TABLE IF EXISTS keyvals");
        } else {
            SQLiteInstrumentation.execSQL(writableDatabase, "DROP TABLE IF EXISTS keyvals");
        }
        if (!z11) {
            writableDatabase.execSQL("DROP TABLE IF EXISTS entry_store");
        } else {
            SQLiteInstrumentation.execSQL(writableDatabase, "DROP TABLE IF EXISTS entry_store");
        }
        onCreate(writableDatabase);
    }

    public synchronized bh b() {
        if (!e()) {
            f();
            return new c();
        }
        return new d();
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, dp dpVar) throws JSONException {
        dpVar.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(dpVar.f41864d));
        JSONObject a11 = dpVar.a();
        contentValues.put("value", !(a11 instanceof JSONObject) ? a11.toString() : JSONObjectInstrumentation.toString(a11));
        if ((!(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.insert("entry_store", (String) null, contentValues) : SQLiteInstrumentation.insert(sQLiteDatabase, "entry_store", (String) null, contentValues)) == -1) {
            bo.g(f42376a, "Error occurred when inserting Entry into entry_store.");
        }
    }

    public bi c() {
        return new b();
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, List<dp> list) {
        if (list == null) {
            bo.e(f42376a, "Tried to call addEntries with a null list of entries");
        } else if (list.isEmpty()) {
            bo.e(f42376a, "Tried to call addEntries with an empty list of entries");
        } else {
            for (dp a11 : list) {
                try {
                    a(sQLiteDatabase, a11);
                } catch (JSONException e11) {
                    bo.e(f42376a, "Unable to convert Entry to JSON", e11);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r1 == null) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<org.json.JSONObject> a(android.database.sqlite.SQLiteDatabase r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "SELECT value FROM entry_store ORDER BY id"
            r3 = 0
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ Exception -> 0x003d }
            boolean r5 = r7 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x003d }
            if (r5 != 0) goto L_0x0014
            android.database.Cursor r7 = r7.rawQuery(r2, r4)     // Catch:{ Exception -> 0x003d }
            goto L_0x0018
        L_0x0014:
            android.database.Cursor r7 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r7, r2, r4)     // Catch:{ Exception -> 0x003d }
        L_0x0018:
            r1 = r7
            r1.moveToFirst()     // Catch:{ Exception -> 0x003d }
        L_0x001c:
            boolean r7 = r1.isAfterLast()     // Catch:{ Exception -> 0x003d }
            if (r7 != 0) goto L_0x0047
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002f }
            java.lang.String r2 = r1.getString(r3)     // Catch:{ JSONException -> 0x002f }
            r7.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x002f }
            r0.add(r7)     // Catch:{ JSONException -> 0x002f }
            goto L_0x0037
        L_0x002f:
            r7 = move-exception
            java.lang.String r2 = f42376a     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = "entry_store did not hold a JSON value"
            com.apptimize.bo.e(r2, r4, r7)     // Catch:{ Exception -> 0x003d }
        L_0x0037:
            r1.moveToNext()     // Catch:{ Exception -> 0x003d }
            goto L_0x001c
        L_0x003b:
            r7 = move-exception
            goto L_0x004b
        L_0x003d:
            r7 = move-exception
            java.lang.String r2 = f42376a     // Catch:{ all -> 0x003b }
            java.lang.String r3 = "Unable to retrieve entries from database"
            com.apptimize.bo.e(r2, r3, r7)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x004a
        L_0x0047:
            r1.close()
        L_0x004a:
            return r0
        L_0x004b:
            if (r1 == 0) goto L_0x0050
            r1.close()
        L_0x0050:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.f.a(android.database.sqlite.SQLiteDatabase):java.util.List");
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, List<JSONObject> list, int i11) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        for (int i13 = 0; i13 != list.size(); i13++) {
            if (i13 % i11 == 0 && i13 > 0) {
                i12 += a(sQLiteDatabase, sb2.toString());
                sb2.setLength(0);
            }
            try {
                long a11 = dp.a(list.get(i13));
                if (i13 % i11 != 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(a11);
            } catch (JSONException e11) {
                bo.e(f42376a, "Entry JSON did not have Entry ID.", e11);
            }
        }
        if (sb2.length() != 0) {
            i12 += a(sQLiteDatabase, sb2.toString());
        }
        if (i12 != list.size()) {
            bo.c(f42376a, "We just posted " + list.size() + " entries, but deleted " + i12);
        }
    }

    private int a(SQLiteDatabase sQLiteDatabase, String str) {
        String str2 = "id IN (" + str + ")";
        String[] strArr = new String[0];
        return !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.delete("entry_store", str2, strArr) : SQLiteInstrumentation.delete(sQLiteDatabase, "entry_store", str2, strArr);
    }

    /* access modifiers changed from: private */
    public void a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        str.getClass();
        str2.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("k", str);
        contentValues.put("v", str2);
        if ((!(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.insert("keyvals", (String) null, contentValues) : SQLiteInstrumentation.insert(sQLiteDatabase, "keyvals", (String) null, contentValues)) == -1) {
            bo.g(f42376a, "Error occurred when inserting into keyvals.");
        }
    }
}
