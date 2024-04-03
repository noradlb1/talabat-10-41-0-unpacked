package com.google.android.recaptcha.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Instrumented
public final class zzad extends SQLiteOpenHelper {
    @NotNull
    public static final zzab zza;
    private static final int zzb;
    /* access modifiers changed from: private */
    @Nullable
    public static zzad zzc;

    static {
        zzab zzab = new zzab((DefaultConstructorMarker) null);
        zza = zzab;
        zzb = zzab.zzb("18.2.1");
    }

    public /* synthetic */ zzad(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        super(context, "cesdb", (SQLiteDatabase.CursorFactory) null, zzb);
    }

    public final void onCreate(@NotNull SQLiteDatabase sQLiteDatabase) {
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
        }
    }

    public final void onDowngrade(@NotNull SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS ce");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
        }
    }

    public final void onUpgrade(@NotNull SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "DROP TABLE IF EXISTS ce");
        }
        if (!z11) {
            sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
        }
    }

    public final int zza(@NotNull List list) {
        if (list.isEmpty()) {
            return 0;
        }
        String valueOf = String.valueOf(CollectionsKt___CollectionsKt.joinToString$default(list, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "(", ")", 0, (CharSequence) null, zzac.zza, 24, (Object) null));
        SQLiteDatabase writableDatabase = getWritableDatabase();
        String concat = "id IN ".concat(valueOf);
        if (!(writableDatabase instanceof SQLiteDatabase)) {
            return writableDatabase.delete("ce", concat, (String[]) null);
        }
        return SQLiteInstrumentation.delete(writableDatabase, "ce", concat, (String[]) null);
    }

    public final int zzb() {
        Cursor cursor;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (!(readableDatabase instanceof SQLiteDatabase)) {
            cursor = readableDatabase.rawQuery("SELECT COUNT(*) FROM ce", (String[]) null);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(readableDatabase, "SELECT COUNT(*) FROM ce", (String[]) null);
        }
        try {
            if (cursor.moveToNext()) {
                return cursor.getInt(0);
            }
            cursor.close();
            return -1;
        } catch (Exception unused) {
            return -1;
        } finally {
            cursor.close();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005e, code lost:
        return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005f, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0062, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0057 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzd() {
        /*
            r9 = this;
            android.database.sqlite.SQLiteDatabase r0 = r9.getReadableDatabase()
            java.lang.String r1 = "ce"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "ts ASC"
            boolean r8 = r0 instanceof android.database.sqlite.SQLiteDatabase
            if (r8 != 0) goto L_0x0016
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x001f
        L_0x0016:
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r0, r1, r2, r3, r4, r5, r6, r7)
        L_0x001f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0024:
            boolean r2 = r0.moveToNext()     // Catch:{ Exception -> 0x0057 }
            if (r2 == 0) goto L_0x0051
            java.lang.String r2 = "id"
            int r2 = r0.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x0057 }
            int r2 = r0.getInt(r2)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r3 = "ss"
            int r3 = r0.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0057 }
            java.lang.String r4 = "ts"
            int r4 = r0.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0057 }
            long r4 = r0.getLong(r4)     // Catch:{ Exception -> 0x0057 }
            com.google.android.recaptcha.internal.zzae r6 = new com.google.android.recaptcha.internal.zzae     // Catch:{ Exception -> 0x0057 }
            r6.<init>(r3, r4, r2)     // Catch:{ Exception -> 0x0057 }
            r1.add(r6)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0024
        L_0x0051:
            r0.close()
            return r1
        L_0x0055:
            r1 = move-exception
            goto L_0x005f
        L_0x0057:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()     // Catch:{ all -> 0x0055 }
            r0.close()
            return r1
        L_0x005f:
            r0.close()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzad.zzd():java.util.List");
    }

    public final boolean zzf(@NotNull zzae zzae) {
        return zza(CollectionsKt__CollectionsJVMKt.listOf(zzae)) == 1;
    }
}
