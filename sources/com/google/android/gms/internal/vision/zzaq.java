package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzaq implements zzau {
    @GuardedBy("ConfigurationContentLoader.class")
    private static final Map<Uri, zzaq> zzfj = new ArrayMap();
    private static final String[] zzfp = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzfk;
    private final ContentObserver zzfl;
    private final Object zzfm = new Object();
    private volatile Map<String, String> zzfn;
    @GuardedBy("this")
    private final List<zzar> zzfo = new ArrayList();

    private zzaq(ContentResolver contentResolver, Uri uri2) {
        zzas zzas = new zzas(this, (Handler) null);
        this.zzfl = zzas;
        this.zzfk = contentResolver;
        this.uri = uri2;
        contentResolver.registerContentObserver(uri2, false, zzas);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(5:5|6|7|8|9)|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.vision.zzaq zza(android.content.ContentResolver r4, android.net.Uri r5) {
        /*
            java.lang.Class<com.google.android.gms.internal.vision.zzaq> r0 = com.google.android.gms.internal.vision.zzaq.class
            monitor-enter(r0)
            java.util.Map<android.net.Uri, com.google.android.gms.internal.vision.zzaq> r1 = zzfj     // Catch:{ all -> 0x0018 }
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.vision.zzaq r2 = (com.google.android.gms.internal.vision.zzaq) r2     // Catch:{ all -> 0x0018 }
            if (r2 != 0) goto L_0x0016
            com.google.android.gms.internal.vision.zzaq r3 = new com.google.android.gms.internal.vision.zzaq     // Catch:{ SecurityException -> 0x0016 }
            r3.<init>(r4, r5)     // Catch:{ SecurityException -> 0x0016 }
            r1.put(r5, r3)     // Catch:{ SecurityException -> 0x0015 }
        L_0x0015:
            r2 = r3
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return r2
        L_0x0018:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzaq.zza(android.content.ContentResolver, android.net.Uri):com.google.android.gms.internal.vision.zzaq");
    }

    private final Map<String, String> zzu() {
        Map<String, String> map = this.zzfn;
        if (map == null) {
            synchronized (this.zzfm) {
                map = this.zzfn;
                if (map == null) {
                    map = zzw();
                    this.zzfn = map;
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    /* JADX INFO: finally extract failed */
    private final Map<String, String> zzw() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Map<String, String> map = (Map) zzat.zza(new zzap(this));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return map;
        } catch (SQLiteException | IllegalStateException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return null;
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
    }

    public static synchronized void zzx() {
        synchronized (zzaq.class) {
            for (zzaq next : zzfj.values()) {
                next.zzfk.unregisterContentObserver(next.zzfl);
            }
            zzfj.clear();
        }
    }

    public final /* synthetic */ Object zzb(String str) {
        return zzu().get(str);
    }

    public final void zzv() {
        synchronized (this.zzfm) {
            this.zzfn = null;
            zzbe.zzab();
        }
        synchronized (this) {
            for (zzar zzz : this.zzfo) {
                zzz.zzz();
            }
        }
    }

    public final /* synthetic */ Map zzy() {
        Map map;
        Cursor query = this.zzfk.query(this.uri, zzfp, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                map.put(query.getString(0), query.getString(1));
            }
            query.close();
            return map;
        } finally {
            query.close();
        }
    }
}
