package com.huawei.hms.analytics;

import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.analytics.bg;
import com.huawei.hms.analytics.database.LogConfig;
import com.huawei.hms.analytics.database.LogEvent;
import com.huawei.hms.analytics.database.LogEventDaoManager;
import java.util.List;

public final class bi {
    private static bi klm;
    public final bj lmn;

    private bi() {
        try {
            this.lmn = new LogEventDaoManager(new LogEventDaoManager.lmn(av.lmn().lmn.ghi, "ha_levt.db", (SQLiteDatabase.CursorFactory) null).getWritableDatabase()).newSession();
        } catch (Exception e11) {
            throw new bg.lmn(e11.getMessage());
        }
    }

    private static synchronized void hij() {
        synchronized (bi.class) {
            klm = new bi();
        }
    }

    public static bi lmn() {
        if (klm == null) {
            hij();
        }
        return klm;
    }

    public final void ijk() {
        this.lmn.lmn.deleteAll();
        this.lmn.lmn();
    }

    public final void ikl() {
        this.lmn.klm.deleteAll();
        this.lmn.lmn.deleteAll();
        this.lmn.lmn();
    }

    public final long klm() {
        return this.lmn.klm.count();
    }

    public final void klm(LogConfig logConfig) {
        this.lmn.lmn.update(logConfig);
    }

    public final long lmn(LogConfig logConfig) {
        return this.lmn.lmn.insert(logConfig);
    }

    public final void lmn(LogEvent logEvent) {
        this.lmn.klm.insert(logEvent);
    }

    public final void lmn(List<Long> list) {
        this.lmn.klm.deleteByKeyInTx(list);
    }
}
