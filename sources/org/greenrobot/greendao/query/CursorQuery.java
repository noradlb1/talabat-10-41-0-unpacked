package org.greenrobot.greendao.query;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

@Instrumented
public class CursorQuery<T> extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;

    public static final class QueryData<T2> extends AbstractQueryData<T2, CursorQuery<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        public QueryData(AbstractDao abstractDao, String str, String[] strArr, int i11, int i12) {
            super(abstractDao, str, strArr);
            this.limitPosition = i11;
            this.offsetPosition = i12;
        }

        /* renamed from: e */
        public CursorQuery<T2> a() {
            return new CursorQuery(this, this.f27886b, this.f27885a, (String[]) this.f27887c.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> CursorQuery<T2> c(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i11, int i12) {
        return (CursorQuery) new QueryData(abstractDao, str, AbstractQuery.b(objArr), i11, i12).b();
    }

    public static <T2> CursorQuery<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return c(abstractDao, str, objArr, -1, -1);
    }

    public CursorQuery forCurrentThread() {
        return (CursorQuery) this.queryData.c(this);
    }

    public Cursor query() {
        a();
        Database database = this.f27880a.getDatabase();
        String str = this.f27882c;
        String[] strArr = this.f27883d;
        if (!(database instanceof SQLiteDatabase)) {
            return database.rawQuery(str, strArr);
        }
        return SQLiteInstrumentation.rawQuery((SQLiteDatabase) database, str, strArr);
    }

    public /* bridge */ /* synthetic */ void setLimit(int i11) {
        super.setLimit(i11);
    }

    public /* bridge */ /* synthetic */ void setOffset(int i11) {
        super.setOffset(i11);
    }

    private CursorQuery(QueryData<T> queryData2, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i11, int i12) {
        super(abstractDao, str, strArr, i11, i12);
        this.queryData = queryData2;
    }

    public CursorQuery<T> setParameter(int i11, Object obj) {
        return (CursorQuery) super.setParameter(i11, obj);
    }

    public CursorQuery<T> setParameter(int i11, Date date) {
        return (CursorQuery) super.setParameter(i11, date);
    }

    public CursorQuery<T> setParameter(int i11, Boolean bool) {
        return (CursorQuery) super.setParameter(i11, bool);
    }
}
