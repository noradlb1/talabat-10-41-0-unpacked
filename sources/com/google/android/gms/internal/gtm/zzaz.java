package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.braze.models.FeatureFlag;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.VisibleForTesting;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.time.DateUtils;

@Instrumented
@VisibleForTesting
final class zzaz extends SQLiteOpenHelper {
    private final /* synthetic */ zzay zzxo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaz(zzay zzay, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zzxo = zzay;
    }

    private final boolean zza(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            String[] strArr = {"name"};
            String[] strArr2 = {str};
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", strArr, "name=?", strArr2, (String) null, (String) null, (String) null);
            } else {
                cursor = SQLiteInstrumentation.query(sQLiteDatabase, "SQLITE_MASTER", strArr, "name=?", strArr2, (String) null, (String) null, (String) null);
            }
            Cursor cursor3 = cursor;
            boolean moveToFirst = cursor3.moveToFirst();
            cursor3.close();
            return moveToFirst;
        } catch (SQLiteException e11) {
            this.zzxo.zzc("Error querying for table", str, e11);
            if (cursor2 != null) {
                cursor2.close();
            }
            return false;
        } catch (Throwable th2) {
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th2;
        }
    }

    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22);
        sb2.append("SELECT * FROM ");
        sb2.append(str);
        sb2.append(" LIMIT 0");
        String sb3 = sb2.toString();
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.rawQuery(sb3, (String[]) null);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, sb3, (String[]) null);
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            for (String add : columnNames) {
                hashSet.add(add);
            }
            return hashSet;
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase getWritableDatabase() {
        if (this.zzxo.zzxn.zzj(DateUtils.MILLIS_PER_HOUR)) {
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException unused) {
                this.zzxo.zzxn.start();
                this.zzxo.zzu("Opening the database failed, dropping the table and recreating it");
                this.zzxo.getContext().getDatabasePath(zzay.zzdt()).delete();
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    this.zzxo.zzxn.clear();
                    return writableDatabase;
                } catch (SQLiteException e11) {
                    this.zzxo.zze("Failed to open freshly created database", e11);
                    throw e11;
                }
            }
        } else {
            throw new SQLiteException("Database open failed");
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        String path = sQLiteDatabase.getPath();
        if (zzbx.version() >= 9) {
            File file = new File(path);
            file.setReadable(false, false);
            file.setWritable(false, false);
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        String str;
        String str2;
        if (!zza(sQLiteDatabase, "hits2")) {
            String zzdu = zzay.zzxj;
            if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                sQLiteDatabase.execSQL(zzdu);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, zzdu);
            }
        } else {
            Set<String> zzb = zzb(sQLiteDatabase, "hits2");
            String[] strArr = {"hit_id", "hit_string", "hit_time", "hit_url"};
            for (int i11 = 0; i11 < 4; i11++) {
                String str3 = strArr[i11];
                if (!zzb.remove(str3)) {
                    String valueOf = String.valueOf(str3);
                    if (valueOf.length() != 0) {
                        str2 = "Database hits2 is missing required column: ".concat(valueOf);
                    } else {
                        str2 = new String("Database hits2 is missing required column: ");
                    }
                    throw new SQLiteException(str2);
                }
            }
            boolean z11 = !zzb.remove("hit_app_id");
            if (!zzb.isEmpty()) {
                throw new SQLiteException("Database hits2 has extra columns");
            } else if (z11) {
                if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
                    sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
                } else {
                    SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE hits2 ADD COLUMN hit_app_id INTEGER");
                }
            }
        }
        if (zza(sQLiteDatabase, FeatureFlag.PROPERTIES)) {
            Set<String> zzb2 = zzb(sQLiteDatabase, FeatureFlag.PROPERTIES);
            String[] strArr2 = {"app_uid", "cid", "tid", NativeProtocol.WEB_DIALOG_PARAMS, "adid", "hits_count"};
            for (int i12 = 0; i12 < 6; i12++) {
                String str4 = strArr2[i12];
                if (!zzb2.remove(str4)) {
                    String valueOf2 = String.valueOf(str4);
                    if (valueOf2.length() != 0) {
                        str = "Database properties is missing required column: ".concat(valueOf2);
                    } else {
                        str = new String("Database properties is missing required column: ");
                    }
                    throw new SQLiteException(str);
                }
            }
            if (!zzb2.isEmpty()) {
                throw new SQLiteException("Database properties table has extra columns");
            }
        } else if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS properties ( app_uid INTEGER NOT NULL, cid TEXT NOT NULL, tid TEXT NOT NULL, params TEXT NOT NULL, adid INTEGER NOT NULL, hits_count INTEGER NOT NULL, PRIMARY KEY (app_uid, cid, tid)) ;");
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }
}
