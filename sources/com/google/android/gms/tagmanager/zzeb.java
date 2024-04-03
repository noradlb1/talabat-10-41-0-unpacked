package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.description.type.TypeDescription;

@Instrumented
@VisibleForTesting
final class zzeb implements zzcb {
    /* access modifiers changed from: private */
    public static final String zzxj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", new Object[]{"gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time"});
    private final zzed zzaie;
    private volatile zzbe zzaif;
    private final zzcc zzaig;
    /* access modifiers changed from: private */
    public final String zzaih;
    private long zzaii;
    private final int zzaij;
    /* access modifiers changed from: private */
    public final Context zzrm;
    /* access modifiers changed from: private */
    public Clock zzsd;

    public zzeb(zzcc zzcc, Context context) {
        this(zzcc, context, "gtm_urls.db", 2000);
    }

    private final void zza(String[] strArr) {
        SQLiteDatabase zzau;
        if (strArr != null && strArr.length != 0 && (zzau = zzau("Error opening database for deleteHits.")) != null) {
            boolean z11 = true;
            try {
                SQLiteInstrumentation.delete(zzau, "gtm_hits", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, TypeDescription.Generic.OfWildcardType.SYMBOL))}), strArr);
                zzcc zzcc = this.zzaig;
                if (zziv() != 0) {
                    z11 = false;
                }
                zzcc.zze(z11);
            } catch (SQLiteException unused) {
                zzdi.zzac("Error deleting hits");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0138, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0139, code lost:
        r14 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x013c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f6 A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fb A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010f A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0138 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0155 A[Catch:{ all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015a A[Catch:{ all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x016b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.google.android.gms.tagmanager.zzbw> zzaa(int r19) {
        /*
            r18 = this;
            java.lang.String r0 = "%s ASC"
            java.lang.String r1 = "hit_id"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r3 = "Error opening database for peekHits"
            r4 = r18
            android.database.sqlite.SQLiteDatabase r3 = r4.zzau(r3)
            if (r3 != 0) goto L_0x0014
            return r2
        L_0x0014:
            java.lang.String r6 = "gtm_hits"
            java.lang.String r5 = "hit_time"
            java.lang.String r7 = "hit_first_send_time"
            java.lang.String[] r7 = new java.lang.String[]{r1, r5, r7}     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r15 = 1
            java.lang.Object[] r5 = new java.lang.Object[r15]     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            r13 = 0
            r5[r13] = r1     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            java.lang.String r12 = java.lang.String.format(r0, r5)     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            r16 = 40
            java.lang.String r17 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            r5 = r3
            r14 = r13
            r13 = r17
            android.database.Cursor r13 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteException -> 0x0143, all -> 0x0140 }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x013c, all -> 0x0138 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x013c, all -> 0x0138 }
            boolean r2 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x0135, all -> 0x0138 }
            if (r2 == 0) goto L_0x006b
        L_0x0045:
            com.google.android.gms.tagmanager.zzbw r2 = new com.google.android.gms.tagmanager.zzbw     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            long r6 = r13.getLong(r14)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            long r8 = r13.getLong(r15)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            r5 = 2
            long r10 = r13.getLong(r5)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            r5 = r2
            r5.<init>(r6, r8, r10)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            r12.add(r2)     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            boolean r2 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x0066, all -> 0x0062 }
            if (r2 != 0) goto L_0x0045
            goto L_0x006b
        L_0x0062:
            r0 = move-exception
            r14 = r13
            goto L_0x0169
        L_0x0066:
            r0 = move-exception
            r2 = r12
            r14 = r13
            goto L_0x0145
        L_0x006b:
            r13.close()
            java.lang.String r6 = "gtm_hits"
            java.lang.String r2 = "hit_url"
            java.lang.String[] r7 = new java.lang.String[]{r1, r2}     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.Object[] r2 = new java.lang.Object[r15]     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            r2[r14] = r1     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            java.lang.String r1 = java.lang.Integer.toString(r16)     // Catch:{ SQLiteException -> 0x00e3, all -> 0x00e0 }
            r5 = r3
            r2 = r12
            r12 = r0
            r3 = r13
            r13 = r1
            android.database.Cursor r13 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteException -> 0x00dd, all -> 0x00da }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x00d8 }
            if (r0 == 0) goto L_0x00d4
            r0 = r14
        L_0x0096:
            r1 = r13
            android.database.sqlite.SQLiteCursor r1 = (android.database.sqlite.SQLiteCursor) r1     // Catch:{ SQLiteException -> 0x00d8 }
            android.database.CursorWindow r1 = r1.getWindow()     // Catch:{ SQLiteException -> 0x00d8 }
            int r1 = r1.getNumRows()     // Catch:{ SQLiteException -> 0x00d8 }
            if (r1 <= 0) goto L_0x00b1
            java.lang.Object r1 = r2.get(r0)     // Catch:{ SQLiteException -> 0x00d8 }
            com.google.android.gms.tagmanager.zzbw r1 = (com.google.android.gms.tagmanager.zzbw) r1     // Catch:{ SQLiteException -> 0x00d8 }
            java.lang.String r3 = r13.getString(r15)     // Catch:{ SQLiteException -> 0x00d8 }
            r1.zzbc(r3)     // Catch:{ SQLiteException -> 0x00d8 }
            goto L_0x00cc
        L_0x00b1:
            java.lang.String r1 = "HitString for hitId %d too large.  Hit will be deleted."
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ SQLiteException -> 0x00d8 }
            java.lang.Object r5 = r2.get(r0)     // Catch:{ SQLiteException -> 0x00d8 }
            com.google.android.gms.tagmanager.zzbw r5 = (com.google.android.gms.tagmanager.zzbw) r5     // Catch:{ SQLiteException -> 0x00d8 }
            long r5 = r5.zzih()     // Catch:{ SQLiteException -> 0x00d8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ SQLiteException -> 0x00d8 }
            r3[r14] = r5     // Catch:{ SQLiteException -> 0x00d8 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ SQLiteException -> 0x00d8 }
            com.google.android.gms.tagmanager.zzdi.zzac(r1)     // Catch:{ SQLiteException -> 0x00d8 }
        L_0x00cc:
            int r0 = r0 + 1
            boolean r1 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x00d8 }
            if (r1 != 0) goto L_0x0096
        L_0x00d4:
            r13.close()
            return r2
        L_0x00d8:
            r0 = move-exception
            goto L_0x00e6
        L_0x00da:
            r0 = move-exception
            r13 = r3
            goto L_0x012f
        L_0x00dd:
            r0 = move-exception
            r13 = r3
            goto L_0x00e6
        L_0x00e0:
            r0 = move-exception
            r3 = r13
            goto L_0x012f
        L_0x00e3:
            r0 = move-exception
            r2 = r12
            r3 = r13
        L_0x00e6:
            java.lang.String r1 = "Error in peekHits fetching hit url: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x012e }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x012e }
            int r3 = r0.length()     // Catch:{ all -> 0x012e }
            if (r3 == 0) goto L_0x00fb
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x012e }
            goto L_0x0100
        L_0x00fb:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x012e }
            r0.<init>(r1)     // Catch:{ all -> 0x012e }
        L_0x0100:
            com.google.android.gms.tagmanager.zzdi.zzac(r0)     // Catch:{ all -> 0x012e }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x012e }
            r0.<init>()     // Catch:{ all -> 0x012e }
            int r1 = r2.size()     // Catch:{ all -> 0x012e }
            r3 = r14
        L_0x010d:
            if (r14 >= r1) goto L_0x0128
            java.lang.Object r5 = r2.get(r14)     // Catch:{ all -> 0x012e }
            int r14 = r14 + 1
            com.google.android.gms.tagmanager.zzbw r5 = (com.google.android.gms.tagmanager.zzbw) r5     // Catch:{ all -> 0x012e }
            java.lang.String r6 = r5.zzij()     // Catch:{ all -> 0x012e }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x012e }
            if (r6 == 0) goto L_0x0124
            if (r3 != 0) goto L_0x0128
            r3 = r15
        L_0x0124:
            r0.add(r5)     // Catch:{ all -> 0x012e }
            goto L_0x010d
        L_0x0128:
            if (r13 == 0) goto L_0x012d
            r13.close()
        L_0x012d:
            return r0
        L_0x012e:
            r0 = move-exception
        L_0x012f:
            if (r13 == 0) goto L_0x0134
            r13.close()
        L_0x0134:
            throw r0
        L_0x0135:
            r0 = move-exception
            r2 = r12
            goto L_0x013d
        L_0x0138:
            r0 = move-exception
            r3 = r13
            r14 = r3
            goto L_0x0169
        L_0x013c:
            r0 = move-exception
        L_0x013d:
            r3 = r13
            r14 = r3
            goto L_0x0145
        L_0x0140:
            r0 = move-exception
            r14 = 0
            goto L_0x0169
        L_0x0143:
            r0 = move-exception
            r14 = 0
        L_0x0145:
            java.lang.String r1 = "Error in peekHits fetching hitIds: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0168 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0168 }
            int r3 = r0.length()     // Catch:{ all -> 0x0168 }
            if (r3 == 0) goto L_0x015a
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x0168 }
            goto L_0x015f
        L_0x015a:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0168 }
            r0.<init>(r1)     // Catch:{ all -> 0x0168 }
        L_0x015f:
            com.google.android.gms.tagmanager.zzdi.zzac(r0)     // Catch:{ all -> 0x0168 }
            if (r14 == 0) goto L_0x0167
            r14.close()
        L_0x0167:
            return r2
        L_0x0168:
            r0 = move-exception
        L_0x0169:
            if (r14 == 0) goto L_0x016e
            r14.close()
        L_0x016e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.zzaa(int):java.util.List");
    }

    private final SQLiteDatabase zzau(String str) {
        try {
            return this.zzaie.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzac(str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void zze(long j11) {
        zza(new String[]{String.valueOf(j11)});
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    private final int zziv() {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        int i11 = 0;
        if (zzau == null) {
            return 0;
        }
        ? r22 = 0;
        try {
            Cursor rawQuery = SQLiteInstrumentation.rawQuery(zzau, "SELECT COUNT(*) from gtm_hits", r22);
            if (rawQuery.moveToFirst()) {
                i11 = (int) rawQuery.getLong(0);
            }
            rawQuery.close();
        } catch (SQLiteException unused) {
            zzdi.zzac("Error getting numStoredHits");
            if (r22 != 0) {
                r22.close();
            }
        } catch (Throwable th2) {
            if (r22 != 0) {
                r22.close();
            }
            throw th2;
        }
        return i11;
    }

    private final int zziw() {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        int i11 = 0;
        if (zzau == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            Cursor query = SQLiteInstrumentation.query(zzau, "gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", (String[]) null, (String) null, (String) null, (String) null);
            i11 = query.getCount();
            query.close();
        } catch (SQLiteException unused) {
            zzdi.zzac("Error getting num untried hits");
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
        return i11;
    }

    private final List<String> zzz(int i11) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (i11 <= 0) {
            zzdi.zzac("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase zzau = zzau("Error opening database for peekHitIds.");
        if (zzau == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            Cursor query = SQLiteInstrumentation.query(zzau, "gtm_hits", new String[]{"hit_id"}, (String) null, (String[]) null, (String) null, (String) null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i11));
            if (query.moveToFirst()) {
                do {
                    arrayList.add(String.valueOf(query.getLong(0)));
                } while (query.moveToNext());
            }
            query.close();
        } catch (SQLiteException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Error in peekHits fetching hitIds: ".concat(valueOf);
            } else {
                str = new String("Error in peekHits fetching hitIds: ");
            }
            zzdi.zzac(str);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
        return arrayList;
    }

    public final void dispatch() {
        zzdi.zzab("GTM Dispatch running...");
        if (this.zzaif.zzhy()) {
            List<zzbw> zzaa = zzaa(40);
            if (zzaa.isEmpty()) {
                zzdi.zzab("...nothing to dispatch");
                this.zzaig.zze(true);
                return;
            }
            this.zzaif.zzd(zzaa);
            if (zziw() > 0) {
                zzfn.zzjq().dispatch();
            }
        }
    }

    public final void zzb(long j11, String str) {
        long currentTimeMillis = this.zzsd.currentTimeMillis();
        if (currentTimeMillis > this.zzaii + 86400000) {
            this.zzaii = currentTimeMillis;
            SQLiteDatabase zzau = zzau("Error opening database for deleteStaleHits.");
            if (zzau != null) {
                SQLiteInstrumentation.delete(zzau, "gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzsd.currentTimeMillis() - 2592000000L)});
                this.zzaig.zze(zziv() == 0);
            }
        }
        int zziv = (zziv() - this.zzaij) + 1;
        if (zziv > 0) {
            List<String> zzz = zzz(zziv);
            int size = zzz.size();
            StringBuilder sb2 = new StringBuilder(51);
            sb2.append("Store full, deleting ");
            sb2.append(size);
            sb2.append(" hits to make room.");
            zzdi.zzab(sb2.toString());
            zza((String[]) zzz.toArray(new String[0]));
        }
        SQLiteDatabase zzau2 = zzau("Error opening database for putHit");
        if (zzau2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j11));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", 0);
            try {
                SQLiteInstrumentation.insert(zzau2, "gtm_hits", (String) null, contentValues);
                this.zzaig.zze(false);
            } catch (SQLiteException unused) {
                zzdi.zzac("Error storing hit");
            }
        }
    }

    @VisibleForTesting
    private zzeb(zzcc zzcc, Context context, String str, int i11) {
        Context applicationContext = context.getApplicationContext();
        this.zzrm = applicationContext;
        this.zzaih = str;
        this.zzaig = zzcc;
        this.zzsd = DefaultClock.getInstance();
        this.zzaie = new zzed(this, applicationContext, str);
        this.zzaif = new zzfu(applicationContext, new zzec(this));
        this.zzaii = 0;
        this.zzaij = 2000;
    }

    /* access modifiers changed from: private */
    public final void zzb(long j11, long j12) {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredHits.");
        if (zzau != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_first_send_time", Long.valueOf(j12));
            try {
                SQLiteInstrumentation.update(zzau, "gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j11)});
            } catch (SQLiteException unused) {
                StringBuilder sb2 = new StringBuilder(69);
                sb2.append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ");
                sb2.append(j11);
                zzdi.zzac(sb2.toString());
                zze(j11);
            }
        }
    }
}
