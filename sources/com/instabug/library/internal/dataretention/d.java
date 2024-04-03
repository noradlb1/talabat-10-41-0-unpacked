package com.instabug.library.internal.dataretention;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.util.threading.PoolProvider;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Iterator;
import java.util.List;

@Instrumented
@Deprecated
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List f50967a;

    public d(@NonNull List list) {
        this.f50967a = list;
    }

    public void a() {
        for (f b11 : this.f50967a) {
            b(b11);
        }
    }

    public void b() {
        PoolProvider.postIOTask(new c(this));
    }

    @VisibleForTesting
    public void c(n nVar, long j11, List list) {
        e(nVar.b(), nVar.a(), j11, list);
    }

    @VisibleForTesting
    public void d(String str, h hVar) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String str2 = hVar.a().a() + " = ? AND " + hVar.b().a() + " = ?";
        String[] strArr = {(String) hVar.a().b(), ((Long) hVar.b().b()).toString()};
        try {
            openDatabase.beginTransaction();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(str, str2, strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, str, str2, strArr);
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    @VisibleForTesting
    public void e(String str, List list, long j11, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (f(hVar, j11) && !g(hVar, list2)) {
                d(str, hVar);
            }
        }
    }

    @VisibleForTesting
    public boolean f(h hVar, long j11) {
        if (((Long) hVar.b().b()).longValue() != 0 && System.currentTimeMillis() - ((Long) hVar.b().b()).longValue() > j11) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public boolean g(h hVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((k) it.next()).a(hVar)) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    public void b(f fVar) {
        c(fVar.c(), fVar.b().b(), fVar.a());
    }
}
