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
import com.google.android.gms.internal.gtm.zzdf;
import com.google.android.gms.internal.gtm.zzdi;
import com.google.android.gms.tagmanager.DataLayer;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import net.bytebuddy.description.type.TypeDescription;

@Instrumented
final class zzat implements DataLayer.zzc {
    /* access modifiers changed from: private */
    public static final String zzafx = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private final Executor zzafy;
    private zzax zzafz;
    private int zzaga;
    /* access modifiers changed from: private */
    public final Context zzrm;
    private Clock zzsd;

    public zzat(Context context) {
        this(context, DefaultClock.getInstance(), "google_tagmanager.db", 2000, zzdf.zzgp().zzr(zzdi.zzadg));
    }

    /* access modifiers changed from: private */
    public final void zzat(String str) {
        SQLiteDatabase zzau = zzau("Error opening database for clearKeysWithPrefix.");
        if (zzau != null) {
            try {
                int delete = SQLiteInstrumentation.delete(zzau, "datalayer", "key = ? OR key LIKE ?", new String[]{str, String.valueOf(str).concat(".%")});
                StringBuilder sb2 = new StringBuilder(25);
                sb2.append("Cleared ");
                sb2.append(delete);
                sb2.append(" items");
                zzdi.zzab(sb2.toString());
            } catch (SQLiteException e11) {
                String valueOf = String.valueOf(e11);
                StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 44 + valueOf.length());
                sb3.append("Error deleting entries with key prefix: ");
                sb3.append(str);
                sb3.append(" (");
                sb3.append(valueOf);
                sb3.append(").");
                zzdi.zzac(sb3.toString());
            } finally {
                zzhw();
            }
        }
    }

    private final SQLiteDatabase zzau(String str) {
        try {
            return this.zzafz.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzac(str);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzb(List<zzay> list, long j11) {
        long currentTimeMillis;
        String[] strArr;
        try {
            currentTimeMillis = this.zzsd.currentTimeMillis();
            zzl(currentTimeMillis);
            int zzhv = (zzhv() - this.zzaga) + list.size();
            if (zzhv > 0) {
                List<String> zzu = zzu(zzhv);
                int size = zzu.size();
                StringBuilder sb2 = new StringBuilder(64);
                sb2.append("DataLayer store full, deleting ");
                sb2.append(size);
                sb2.append(" entries to make room.");
                zzdi.zzaw(sb2.toString());
                strArr = (String[]) zzu.toArray(new String[0]);
                if (strArr != null) {
                    if (strArr.length != 0) {
                        SQLiteDatabase zzau = zzau("Error opening database for deleteEntries.");
                        if (zzau != null) {
                            SQLiteInstrumentation.delete(zzau, "datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, TypeDescription.Generic.OfWildcardType.SYMBOL))}), strArr);
                        }
                    }
                }
            }
        } catch (SQLiteException unused) {
            String valueOf = String.valueOf(Arrays.toString(strArr));
            zzdi.zzac(valueOf.length() != 0 ? "Error deleting entries ".concat(valueOf) : new String("Error deleting entries "));
        } catch (Throwable th2) {
            zzhw();
            throw th2;
        }
        long j12 = currentTimeMillis + j11;
        SQLiteDatabase zzau2 = zzau("Error opening database for writeEntryToDatabase.");
        if (zzau2 != null) {
            for (zzay next : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j12));
                contentValues.put("key", next.zzagg);
                contentValues.put("value", next.zzagh);
                SQLiteInstrumentation.insert(zzau2, "datalayer", (String) null, contentValues);
            }
        }
        zzhw();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f A[SYNTHETIC, Splitter:B:13:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0029 A[SYNTHETIC, Splitter:B:22:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] zzf(java.lang.Object r3) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0026, all -> 0x001c }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0026, all -> 0x001c }
            r2.writeObject(r3)     // Catch:{ IOException -> 0x0027, all -> 0x0019 }
            byte[] r3 = r0.toByteArray()     // Catch:{ IOException -> 0x0027, all -> 0x0019 }
            r2.close()     // Catch:{ IOException -> 0x0018 }
            r0.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            return r3
        L_0x0019:
            r3 = move-exception
            r1 = r2
            goto L_0x001d
        L_0x001c:
            r3 = move-exception
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r1.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0022:
            r0.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            throw r3
        L_0x0026:
            r2 = r1
        L_0x0027:
            if (r2 == 0) goto L_0x002c
            r2.close()     // Catch:{ IOException -> 0x002f }
        L_0x002c:
            r0.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zzf(java.lang.Object):byte[]");
    }

    /* access modifiers changed from: private */
    public final List<DataLayer.zza> zzht() {
        try {
            zzl(this.zzsd.currentTimeMillis());
            List<zzay> zzhu = zzhu();
            ArrayList arrayList = new ArrayList();
            for (zzay next : zzhu) {
                arrayList.add(new DataLayer.zza(next.zzagg, zza(next.zzagh)));
            }
            return arrayList;
        } finally {
            zzhw();
        }
    }

    private final List<zzay> zzhu() {
        SQLiteDatabase zzau = zzau("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (zzau == null) {
            return arrayList;
        }
        Cursor query = SQLiteInstrumentation.query(zzau, "datalayer", new String[]{"key", "value"}, (String) null, (String[]) null, (String) null, (String) null, "ID", (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzay(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    private final int zzhv() {
        SQLiteDatabase zzau = zzau("Error opening database for getNumStoredEntries.");
        int i11 = 0;
        if (zzau == null) {
            return 0;
        }
        ? r22 = 0;
        try {
            Cursor rawQuery = SQLiteInstrumentation.rawQuery(zzau, "SELECT COUNT(*) from datalayer", r22);
            if (rawQuery.moveToFirst()) {
                i11 = (int) rawQuery.getLong(0);
            }
            rawQuery.close();
        } catch (SQLiteException unused) {
            zzdi.zzac("Error getting numStoredEntries");
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

    private final void zzhw() {
        try {
            this.zzafz.close();
        } catch (SQLiteException unused) {
        }
    }

    private final void zzl(long j11) {
        SQLiteDatabase zzau = zzau("Error opening database for deleteOlderThan.");
        if (zzau != null) {
            try {
                int delete = SQLiteInstrumentation.delete(zzau, "datalayer", "expires <= ?", new String[]{Long.toString(j11)});
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Deleted ");
                sb2.append(delete);
                sb2.append(" expired items");
                zzdi.zzab(sb2.toString());
            } catch (SQLiteException unused) {
                zzdi.zzac("Error deleting old entries.");
            }
        }
    }

    private final List<String> zzu(int i11) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (i11 <= 0) {
            zzdi.zzac("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase zzau = zzau("Error opening database for peekEntryIds.");
        if (zzau == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            Cursor query = SQLiteInstrumentation.query(zzau, "datalayer", new String[]{"ID"}, (String) null, (String[]) null, (String) null, (String) null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i11));
            if (query.moveToFirst()) {
                do {
                    arrayList.add(String.valueOf(query.getLong(0)));
                } while (query.moveToNext());
            }
            query.close();
        } catch (SQLiteException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "Error in peekEntries fetching entryIds: ".concat(valueOf);
            } else {
                str = new String("Error in peekEntries fetching entryIds: ");
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

    public final void zza(List<DataLayer.zza> list, long j11) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.zza next : list) {
            arrayList.add(new zzay(next.mKey, zzf(next.mValue)));
        }
        this.zzafy.execute(new zzau(this, arrayList, j11));
    }

    public final void zzas(String str) {
        this.zzafy.execute(new zzaw(this, str));
    }

    @VisibleForTesting
    private zzat(Context context, Clock clock, String str, int i11, Executor executor) {
        this.zzrm = context;
        this.zzsd = clock;
        this.zzaga = 2000;
        this.zzafy = executor;
        this.zzafz = new zzax(this, context, str);
    }

    public final void zza(zzaq zzaq) {
        this.zzafy.execute(new zzav(this, zzaq));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e A[SYNTHETIC, Splitter:B:13:0x001e] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0028 A[SYNTHETIC, Splitter:B:22:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0032 A[SYNTHETIC, Splitter:B:31:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object zza(byte[] r3) {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r3)
            r3 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x0018 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x0025, all -> 0x0018 }
            java.lang.Object r3 = r1.readObject()     // Catch:{ IOException -> 0x0030, ClassNotFoundException -> 0x0026, all -> 0x0016 }
            r1.close()     // Catch:{ IOException -> 0x0015 }
            r0.close()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            return r3
        L_0x0016:
            r3 = move-exception
            goto L_0x001c
        L_0x0018:
            r1 = move-exception
            r2 = r1
            r1 = r3
            r3 = r2
        L_0x001c:
            if (r1 == 0) goto L_0x0021
            r1.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0021:
            r0.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0024:
            throw r3
        L_0x0025:
            r1 = r3
        L_0x0026:
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ IOException -> 0x002e }
        L_0x002b:
            r0.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            return r3
        L_0x002f:
            r1 = r3
        L_0x0030:
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0035:
            r0.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzat.zza(byte[]):java.lang.Object");
    }
}
