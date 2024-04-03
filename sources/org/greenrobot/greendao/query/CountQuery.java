package org.greenrobot.greendao.query;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.database.Database;

@Instrumented
public class CountQuery<T> extends AbstractQuery<T> {
    private final QueryData<T> queryData;

    public static final class QueryData<T2> extends AbstractQueryData<T2, CountQuery<T2>> {
        /* renamed from: e */
        public CountQuery<T2> a() {
            return new CountQuery(this, this.f27886b, this.f27885a, (String[]) this.f27887c.clone());
        }

        private QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
            super(abstractDao, str, strArr);
        }
    }

    public static <T2> CountQuery<T2> c(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return (CountQuery) new QueryData(abstractDao, str, AbstractQuery.b(objArr)).b();
    }

    public long count() {
        Cursor cursor;
        a();
        Database database = this.f27880a.getDatabase();
        String str = this.f27882c;
        String[] strArr = this.f27883d;
        if (!(database instanceof SQLiteDatabase)) {
            cursor = database.rawQuery(str, strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase) database, str, strArr);
        }
        try {
            if (!cursor.moveToNext()) {
                throw new DaoException("No result for count");
            } else if (!cursor.isLast()) {
                throw new DaoException("Unexpected row count: " + cursor.getCount());
            } else if (cursor.getColumnCount() == 1) {
                return cursor.getLong(0);
            } else {
                throw new DaoException("Unexpected column count: " + cursor.getColumnCount());
            }
        } finally {
            cursor.close();
        }
    }

    public CountQuery<T> forCurrentThread() {
        return (CountQuery) this.queryData.c(this);
    }

    private CountQuery(QueryData<T> queryData2, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.queryData = queryData2;
    }

    public CountQuery<T> setParameter(int i11, Object obj) {
        return (CountQuery) super.setParameter(i11, obj);
    }

    public CountQuery<T> setParameter(int i11, Date date) {
        return (CountQuery) super.setParameter(i11, date);
    }

    public CountQuery<T> setParameter(int i11, Boolean bool) {
        return (CountQuery) super.setParameter(i11, bool);
    }
}
