package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.braze.models.FeatureFlag;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.HttpUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.description.type.TypeDescription;

@Instrumented
final class zzay extends zzan implements Closeable {
    /* access modifiers changed from: private */
    public static final String zzxj = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    private static final String zzxk = String.format("SELECT MAX(%s) FROM %s WHERE 1;", new Object[]{"hit_time", "hits2"});
    private final zzaz zzxl;
    private final zzcv zzxm = new zzcv(zzcn());
    /* access modifiers changed from: private */
    public final zzcv zzxn = new zzcv(zzcn());

    public zzay(zzap zzap) {
        super(zzap);
        this.zzxl = new zzaz(this, zzap.getContext(), "google_analytics_v4.db");
    }

    private final long zzdl() {
        zzk.zzav();
        zzdb();
        return zza("SELECT COUNT(*) FROM hits2", (String[]) null);
    }

    /* access modifiers changed from: private */
    public static String zzdt() {
        return "google_analytics_v4.db";
    }

    @VisibleForTesting
    private final Map<String, String> zzv(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith(TypeDescription.Generic.OfWildcardType.SYMBOL)) {
                if (str.length() != 0) {
                    str = TypeDescription.Generic.OfWildcardType.SYMBOL.concat(str);
                } else {
                    str = new String(TypeDescription.Generic.OfWildcardType.SYMBOL);
                }
            }
            return HttpUtils.parse(new URI(str), "UTF-8");
        } catch (URISyntaxException e11) {
            zze("Error parsing hit parameters", e11);
            return new HashMap(0);
        }
    }

    @VisibleForTesting
    private final Map<String, String> zzw(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = TypeDescription.Generic.OfWildcardType.SYMBOL.concat(valueOf);
            } else {
                str2 = new String(TypeDescription.Generic.OfWildcardType.SYMBOL);
            }
            return HttpUtils.parse(new URI(str2), "UTF-8");
        } catch (URISyntaxException e11) {
            zze("Error parsing property parameters", e11);
            return new HashMap(0);
        }
    }

    public final void beginTransaction() {
        zzdb();
        getWritableDatabase().beginTransaction();
    }

    public final void close() {
        try {
            this.zzxl.close();
        } catch (SQLiteException e11) {
            zze("Sql error closing database", e11);
        } catch (IllegalStateException e12) {
            zze("Error closing database", e12);
        }
    }

    public final void endTransaction() {
        zzdb();
        getWritableDatabase().endTransaction();
    }

    @VisibleForTesting
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzxl.getWritableDatabase();
        } catch (SQLiteException e11) {
            zzd("Error opening database", e11);
            throw e11;
        }
    }

    public final boolean isEmpty() {
        return zzdl() == 0;
    }

    public final void setTransactionSuccessful() {
        zzdb();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final void zza(List<Long> list) {
        Preconditions.checkNotNull(list);
        zzk.zzav();
        zzdb();
        if (!list.isEmpty()) {
            StringBuilder sb2 = new StringBuilder("hit_id");
            sb2.append(" in (");
            for (int i11 = 0; i11 < list.size(); i11++) {
                Long l11 = list.get(i11);
                if (l11 == null || l11.longValue() == 0) {
                    throw new SQLiteException("Invalid hit id");
                }
                if (i11 > 0) {
                    sb2.append(",");
                }
                sb2.append(l11);
            }
            sb2.append(")");
            String sb3 = sb2.toString();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
                int delete = !(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.delete("hits2", sb3, (String[]) null) : SQLiteInstrumentation.delete(writableDatabase, "hits2", sb3, (String[]) null);
                if (delete != list.size()) {
                    zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb3);
                }
            } catch (SQLiteException e11) {
                zze("Error deleting hits", e11);
                throw e11;
            }
        }
    }

    public final void zzaw() {
    }

    public final void zzc(zzcd zzcd) {
        String str;
        Preconditions.checkNotNull(zzcd);
        zzk.zzav();
        zzdb();
        Preconditions.checkNotNull(zzcd);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry next : zzcd.zzdm().entrySet()) {
            String str2 = (String) next.getKey();
            if (!"ht".equals(str2) && !"qt".equals(str2) && !"AppUID".equals(str2)) {
                builder.appendQueryParameter(str2, (String) next.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        if (encodedQuery.length() > 8192) {
            zzco().zza(zzcd, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = zzby.zzze.get().intValue();
        long zzdl = zzdl();
        if (zzdl > ((long) (intValue - 1))) {
            List<Long> zzc = zzc((zzdl - ((long) intValue)) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(zzc.size()));
            zza(zzc);
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", encodedQuery);
        contentValues.put("hit_time", Long.valueOf(zzcd.zzfh()));
        contentValues.put("hit_app_id", Integer.valueOf(zzcd.zzff()));
        if (zzcd.zzfj()) {
            str = zzbq.zzet();
        } else {
            str = zzbq.zzeu();
        }
        contentValues.put("hit_url", str);
        try {
            long insert = !(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.insert("hits2", (String) null, contentValues) : SQLiteInstrumentation.insert(writableDatabase, "hits2", (String) null, contentValues);
            if (insert == -1) {
                zzu("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzcd);
            }
        } catch (SQLiteException e11) {
            zze("Error storing a hit", e11);
        }
    }

    public final List<zzcd> zzd(long j11) {
        boolean z11;
        Cursor cursor;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        zzk.zzav();
        zzdb();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursor2 = null;
        try {
            String[] strArr = {"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"};
            String format = String.format("%s ASC", new Object[]{"hit_id"});
            String l11 = Long.toString(j11);
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                cursor = writableDatabase.query("hits2", strArr, (String) null, (String[]) null, (String) null, (String) null, format, l11);
            } else {
                cursor = SQLiteInstrumentation.query(writableDatabase, "hits2", strArr, (String) null, (String[]) null, (String) null, (String) null, format, l11);
            }
            Cursor cursor3 = cursor;
            ArrayList arrayList = new ArrayList();
            if (cursor3.moveToFirst()) {
                do {
                    long j12 = cursor3.getLong(0);
                    arrayList.add(new zzcd(this, zzv(cursor3.getString(2)), cursor3.getLong(1), zzcz.zzaj(cursor3.getString(3)), j12, cursor3.getInt(4)));
                } while (cursor3.moveToNext());
            }
            cursor3.close();
            return arrayList;
        } catch (SQLiteException e11) {
            zze("Error loading hits from the database", e11);
            throw e11;
        } catch (Throwable th2) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th2;
        }
    }

    public final int zzdr() {
        int i11;
        zzk.zzav();
        zzdb();
        if (!this.zzxm.zzj(86400000)) {
            return 0;
        }
        this.zzxm.start();
        zzq("Deleting stale hits (if any)");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String[] strArr = {Long.toString(zzcn().currentTimeMillis() - 2592000000L)};
        if (!(writableDatabase instanceof SQLiteDatabase)) {
            i11 = writableDatabase.delete("hits2", "hit_time < ?", strArr);
        } else {
            i11 = SQLiteInstrumentation.delete(writableDatabase, "hits2", "hit_time < ?", strArr);
        }
        zza("Deleted stale hits, count", Integer.valueOf(i11));
        return i11;
    }

    public final long zzds() {
        zzk.zzav();
        zzdb();
        return zza(zzxk, (String[]) null, 0);
    }

    public final void zze(long j11) {
        zzk.zzav();
        zzdb();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j11));
        zza("Deleting hit, id", Long.valueOf(j11));
        zza((List<Long>) arrayList);
    }

    public final List<zzas> zzf(long j11) {
        Cursor cursor;
        boolean z11;
        zzdb();
        zzk.zzav();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursor2 = null;
        try {
            String[] strArr = {"cid", "tid", "adid", "hits_count", NativeProtocol.WEB_DIALOG_PARAMS};
            int intValue = zzby.zzzg.get().intValue();
            String valueOf = String.valueOf(intValue);
            String[] strArr2 = {"0"};
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                cursor = writableDatabase.query(FeatureFlag.PROPERTIES, strArr, "app_uid=?", strArr2, (String) null, (String) null, (String) null, valueOf);
            } else {
                cursor = SQLiteInstrumentation.query(writableDatabase, FeatureFlag.PROPERTIES, strArr, "app_uid=?", strArr2, (String) null, (String) null, (String) null, valueOf);
            }
            ArrayList arrayList = new ArrayList();
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (cursor.getInt(2) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    long j12 = (long) cursor.getInt(3);
                    Map<String, String> zzw = zzw(cursor.getString(4));
                    if (!TextUtils.isEmpty(string)) {
                        if (!TextUtils.isEmpty(string2)) {
                            arrayList.add(new zzas(0, string, string2, z11, j12, zzw));
                        }
                    }
                    zzc("Read property with empty client id or tracker id", string, string2);
                } while (cursor.moveToNext());
            }
            if (arrayList.size() >= intValue) {
                zzt("Sending hits to too many properties. Campaign report might be incorrect");
            }
            cursor.close();
            return arrayList;
        } catch (SQLiteException e11) {
            zze("Error loading hits from the database", e11);
            throw e11;
        } catch (Throwable th2) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th2;
        }
    }

    public final long zza(long j11, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzdb();
        zzk.zzav();
        return zza("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j11), str, str2}, 0);
    }

    private final long zza(String str, String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursor = null;
        try {
            cursor = !(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.rawQuery(str, (String[]) null) : SQLiteInstrumentation.rawQuery(writableDatabase, str, (String[]) null);
            if (cursor.moveToFirst()) {
                long j11 = cursor.getLong(0);
                cursor.close();
                return j11;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e11) {
            zzd("Database error", str, e11);
            throw e11;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    private final List<Long> zzc(long j11) {
        zzk.zzav();
        zzdb();
        if (j11 <= 0) {
            return Collections.emptyList();
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            String[] strArr = {"hit_id"};
            String format = String.format("%s ASC", new Object[]{"hit_id"});
            String l11 = Long.toString(j11);
            Cursor query = !(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.query("hits2", strArr, (String) null, (String[]) null, (String) null, (String) null, format, l11) : SQLiteInstrumentation.query(writableDatabase, "hits2", strArr, (String) null, (String[]) null, (String) null, (String) null, format, l11);
            if (query.moveToFirst()) {
                do {
                    arrayList.add(Long.valueOf(query.getLong(0)));
                } while (query.moveToNext());
            }
            query.close();
        } catch (SQLiteException e11) {
            zzd("Error selecting hit ids", e11);
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

    private final long zza(String str, String[] strArr, long j11) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursor = null;
        try {
            Cursor rawQuery = !(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.rawQuery(str, strArr) : SQLiteInstrumentation.rawQuery(writableDatabase, str, strArr);
            if (rawQuery.moveToFirst()) {
                long j12 = rawQuery.getLong(0);
                rawQuery.close();
                return j12;
            }
            rawQuery.close();
            return 0;
        } catch (SQLiteException e11) {
            zzd("Database error", str, e11);
            throw e11;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }
}
