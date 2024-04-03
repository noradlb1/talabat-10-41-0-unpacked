package com.instabug.bug.cache;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.instabug.bug.cache.migrationpolicy.b;
import com.instabug.bug.di.a;
import com.instabug.bug.model.d;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.List;
import org.json.JSONException;

@Instrumented
public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f45623a = a.a();

    /* renamed from: b  reason: collision with root package name */
    private a f45624b = a.c();

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A[Catch:{ all -> 0x0025, all -> 0x002a, Exception -> 0x0036 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a() {
        /*
            r5 = this;
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r0 = r0.openDatabase()
            r1 = 0
            java.lang.String r2 = "SELECT name FROM sqlite_master WHERE type='table' AND name = 'bugs_table'"
            boolean r3 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0036 }
            r4 = 0
            if (r3 != 0) goto L_0x0015
            android.database.Cursor r0 = r0.rawQuery(r2, r4)     // Catch:{ Exception -> 0x0036 }
            goto L_0x001b
        L_0x0015:
            android.database.sqlite.SQLiteDatabase r0 = (android.database.sqlite.SQLiteDatabase) r0     // Catch:{ Exception -> 0x0036 }
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r0, r2, r4)     // Catch:{ Exception -> 0x0036 }
        L_0x001b:
            if (r0 == 0) goto L_0x002f
            boolean r2 = r0.moveToFirst()     // Catch:{ all -> 0x0025 }
            if (r2 == 0) goto L_0x002f
            r2 = 1
            goto L_0x0030
        L_0x0025:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch:{ Exception -> 0x0036 }
        L_0x002e:
            throw r2     // Catch:{ Exception -> 0x0036 }
        L_0x002f:
            r2 = r1
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0035:
            return r2
        L_0x0036:
            r0 = move-exception
            java.lang.String r2 = "IBG-BR"
            java.lang.String r3 = "can't check if plain Bugs Table exists"
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "can't check if plain Bugs Table exists due to: "
            r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.cache.c.a():boolean");
    }

    public void a(Context context) {
        try {
            if (!a()) {
                this.f45624b.b();
                return;
            }
            List<d> a11 = this.f45624b.a(context);
            if (!a11.isEmpty()) {
                InstabugSDKLogger.d("IBG-BR", "Migrating " + a11.size() + " bugs to encrypted table");
                for (d dVar : a11) {
                    String id2 = dVar.getId();
                    if (id2 != null) {
                        try {
                            this.f45623a.a(dVar);
                        } catch (JSONException e11) {
                            IBGDiagnostics.reportNonFatal(e11, String.format("Failed to migrate bug with id %s to encrypted DB, dropping it.", new Object[]{id2}));
                        }
                        this.f45624b.a(id2);
                    }
                }
            }
            this.f45624b.b();
        } catch (Exception e12) {
            b(new com.instabug.bug.cache.migrationpolicy.a(e12));
        } catch (Throwable th2) {
            this.f45624b.b();
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038 A[Catch:{ Exception -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041 A[Catch:{ Exception -> 0x004f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r6, @androidx.annotation.Nullable java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "IBG-BR"
            if (r7 != 0) goto L_0x000a
            java.lang.String r6 = "Encryption migration required with null migration type value"
            com.instabug.library.util.InstabugSDKLogger.d(r0, r6)
            return
        L_0x000a:
            com.instabug.bug.settings.b r1 = com.instabug.bug.settings.b.f()     // Catch:{ Exception -> 0x004f }
            r2 = 0
            r1.b((boolean) r2)     // Catch:{ Exception -> 0x004f }
            int r1 = r7.hashCode()     // Catch:{ Exception -> 0x004f }
            r3 = -1512642408(0xffffffffa5d6e898, float:-3.7280694E-16)
            r4 = 1
            if (r1 == r3) goto L_0x002c
            r2 = 2066059376(0x7b259070, float:8.596585E35)
            if (r1 == r2) goto L_0x0022
            goto L_0x0035
        L_0x0022:
            java.lang.String r1 = "decrypt_db"
            boolean r7 = r7.equals(r1)     // Catch:{ Exception -> 0x004f }
            if (r7 == 0) goto L_0x0035
            r2 = r4
            goto L_0x0036
        L_0x002c:
            java.lang.String r1 = "encrypt_db"
            boolean r7 = r7.equals(r1)     // Catch:{ Exception -> 0x004f }
            if (r7 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r2 = -1
        L_0x0036:
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x003b
            goto L_0x0047
        L_0x003b:
            java.lang.String r7 = "Backward migration from encrypted to plain bugs"
        L_0x003d:
            com.instabug.library.util.InstabugSDKLogger.d(r0, r7)     // Catch:{ Exception -> 0x004f }
            goto L_0x0044
        L_0x0041:
            java.lang.String r7 = "Forward migration from plain to encrypted bugs"
            goto L_0x003d
        L_0x0044:
            r5.c(r6)     // Catch:{ Exception -> 0x004f }
        L_0x0047:
            com.instabug.bug.settings.b r6 = com.instabug.bug.settings.b.f()     // Catch:{ Exception -> 0x004f }
            r6.b((boolean) r4)     // Catch:{ Exception -> 0x004f }
            goto L_0x0058
        L_0x004f:
            r6 = move-exception
            com.instabug.bug.cache.migrationpolicy.c r7 = new com.instabug.bug.cache.migrationpolicy.c
            r7.<init>(r6)
            r5.b(r7)
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.cache.c.a(android.content.Context, java.lang.String):void");
    }

    @VisibleForTesting
    public void b(b bVar) {
        bVar.a();
    }

    @VisibleForTesting
    public void c(Context context) {
        List<d> a11 = this.f45623a.a(context);
        if (!a11.isEmpty()) {
            for (d a12 : a11) {
                this.f45623a.a(a12);
            }
        }
    }
}
