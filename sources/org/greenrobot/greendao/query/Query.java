package org.greenrobot.greendao.query;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.apihint.Internal;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.rx.RxQuery;
import rx.schedulers.Schedulers;

@Instrumented
public class Query<T> extends AbstractQueryWithLimit<T> {
    private final QueryData<T> queryData;
    private volatile RxQuery rxTxIo;
    private volatile RxQuery rxTxPlain;

    public static final class QueryData<T2> extends AbstractQueryData<T2, Query<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        public QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr, int i11, int i12) {
            super(abstractDao, str, strArr);
            this.limitPosition = i11;
            this.offsetPosition = i12;
        }

        /* renamed from: e */
        public Query<T2> a() {
            return new Query(this, this.f27886b, this.f27885a, (String[]) this.f27887c.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> Query<T2> c(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i11, int i12) {
        return (Query) new QueryData(abstractDao, str, AbstractQuery.b(objArr), i11, i12).b();
    }

    public static <T2> Query<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return c(abstractDao, str, objArr, -1, -1);
    }

    @Internal
    public RxQuery __InternalRx() {
        if (this.rxTxIo == null) {
            this.rxTxIo = new RxQuery(this, Schedulers.io());
        }
        return this.rxTxIo;
    }

    @Internal
    public RxQuery __internalRxPlain() {
        if (this.rxTxPlain == null) {
            this.rxTxPlain = new RxQuery(this);
        }
        return this.rxTxPlain;
    }

    public Query<T> forCurrentThread() {
        return (Query) this.queryData.c(this);
    }

    public List<T> list() {
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
        return this.f27881b.loadAllAndCloseCursor(cursor);
    }

    public CloseableListIterator<T> listIterator() {
        return listLazyUncached().listIteratorAutoClose();
    }

    public LazyList<T> listLazy() {
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
        return new LazyList<>(this.f27881b, cursor, true);
    }

    public LazyList<T> listLazyUncached() {
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
        return new LazyList<>(this.f27881b, cursor, false);
    }

    public /* bridge */ /* synthetic */ void setLimit(int i11) {
        super.setLimit(i11);
    }

    public /* bridge */ /* synthetic */ void setOffset(int i11) {
        super.setOffset(i11);
    }

    public T unique() {
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
        return this.f27881b.loadUniqueAndCloseCursor(cursor);
    }

    public T uniqueOrThrow() {
        T unique = unique();
        if (unique != null) {
            return unique;
        }
        throw new DaoException("No entity found for query");
    }

    private Query(QueryData<T> queryData2, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i11, int i12) {
        super(abstractDao, str, strArr, i11, i12);
        this.queryData = queryData2;
    }

    public Query<T> setParameter(int i11, Object obj) {
        return (Query) super.setParameter(i11, obj);
    }

    public Query<T> setParameter(int i11, Date date) {
        return (Query) super.setParameter(i11, date);
    }

    public Query<T> setParameter(int i11, Boolean bool) {
        return (Query) super.setParameter(i11, bool);
    }
}
