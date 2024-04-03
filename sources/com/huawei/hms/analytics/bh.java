package com.huawei.hms.analytics;

import android.content.Context;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteFullException;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.database.EventDao;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

public final class bh implements IStorageHandler {
    private static IStorageHandler lmn;
    private bg klm;

    private bh(Context context) {
        this.klm = bg.lmn(context);
    }

    private static synchronized void klm(Context context) {
        synchronized (bh.class) {
            if (lmn == null) {
                lmn = new bh(context);
            }
        }
    }

    public static IStorageHandler lmn(Context context) {
        if (lmn == null) {
            klm(context);
        }
        return lmn;
    }

    public final long count(String str) {
        return this.klm.lmn.getEventDao().queryBuilder().where(EventDao.Properties.ghi.eq(str), new WhereCondition[0]).count();
    }

    public final void deleteAll() {
        this.klm.lmn();
    }

    public final void deleteByTag(String str) {
        this.klm.lmn(str);
    }

    public final void deleteByTagType(String str, String str2) {
        this.klm.lmn(str, str2);
    }

    public final void deleteEvents(List<Event> list) {
        this.klm.lmn.getEventDao().deleteInTx(list);
    }

    public final long insert(Event event) {
        try {
            return this.klm.lmn.getEventDao().insert(event);
        } catch (SQLiteFullException e11) {
            HiLog.w("StorageHandler", "SQLite full exception");
            this.klm.lmn();
            dr.lmn(e11);
            return 0;
        }
    }

    public final void insertEx(List<Event> list) {
        try {
            this.klm.lmn(list);
        } catch (SQLiteFullException e11) {
            HiLog.w("StorageHandler", "SQLite full exception");
            this.klm.lmn();
            dr.lmn(e11);
        }
    }

    public final List<Event> readBySql(String str) {
        return this.klm.lmn.getEventDao().queryBuilder().where(new WhereCondition.StringCondition(str), new WhereCondition[0]).build().forCurrentThread().list();
    }

    public final List<Event> readEvents(String str) {
        try {
            return this.klm.klm(str);
        } catch (SQLiteBlobTooBigException e11) {
            HiLog.w("StorageHandler", "SQLite blob too big exception");
            this.klm.lmn(str);
            dr.lmn(e11);
            return new ArrayList();
        }
    }

    public final List<Event> readEvents(String str, String str2) {
        try {
            return this.klm.lmn.getEventDao().queryBuilder().where(EventDao.Properties.ghi.eq(str), new WhereCondition[0]).where(EventDao.Properties.ikl.eq(str2), new WhereCondition[0]).build().forCurrentThread().list();
        } catch (SQLiteBlobTooBigException e11) {
            HiLog.w("StorageHandler", "SQLite blob too big exception");
            this.klm.lmn(str, str2);
            dr.lmn(e11);
            return new ArrayList();
        }
    }

    public final List<Event> readEvents(String str, String str2, int i11) {
        try {
            return this.klm.lmn.getEventDao().queryBuilder().where(EventDao.Properties.ghi.eq(str), new WhereCondition[0]).where(EventDao.Properties.ikl.eq(str2), new WhereCondition[0]).limit(i11).build().forCurrentThread().list();
        } catch (SQLiteBlobTooBigException e11) {
            HiLog.w("StorageHandler", "SQLite blob too big exception");
            this.klm.lmn(str, str2);
            dr.lmn(e11);
            return new ArrayList();
        }
    }

    public final List<Event> readEvents(List<String> list) {
        try {
            QueryBuilder queryBuilder = this.klm.lmn.getEventDao().queryBuilder();
            int size = list.size();
            WhereCondition[] whereConditionArr = new WhereCondition[size];
            for (int i11 = 0; i11 < list.size(); i11++) {
                whereConditionArr[i11] = EventDao.Properties.ghi.eq(list.get(i11));
            }
            if (size == 1) {
                return queryBuilder.where(whereConditionArr[0], new WhereCondition[0]).build().list();
            }
            int i12 = size - 2;
            WhereCondition[] whereConditionArr2 = new WhereCondition[i12];
            System.arraycopy(whereConditionArr, 2, whereConditionArr2, 0, i12);
            queryBuilder.whereOr(whereConditionArr[0], whereConditionArr[1], whereConditionArr2);
            return queryBuilder.build().list();
        } catch (SQLiteBlobTooBigException e11) {
            HiLog.w("StorageHandler", "SQLite blob too big exception");
            QueryBuilder queryBuilder2 = this.klm.lmn.getEventDao().queryBuilder();
            for (String eq2 : list) {
                queryBuilder2.where(EventDao.Properties.ghi.eq(eq2), new WhereCondition[0]);
            }
            queryBuilder2.buildDelete().executeDeleteWithoutDetachingEntities();
            dr.lmn(e11);
            return new ArrayList();
        }
    }
}
