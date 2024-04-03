package org.greenrobot.greendao.query;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Date;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

@Instrumented
public class DeleteQuery<T> extends AbstractQuery<T> {
    private final QueryData<T> queryData;

    public static final class QueryData<T2> extends AbstractQueryData<T2, DeleteQuery<T2>> {
        /* renamed from: e */
        public DeleteQuery<T2> a() {
            return new DeleteQuery(this, this.f27886b, this.f27885a, (String[]) this.f27887c.clone());
        }

        private QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
            super(abstractDao, str, strArr);
        }
    }

    public static <T2> DeleteQuery<T2> c(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return (DeleteQuery) new QueryData(abstractDao, str, AbstractQuery.b(objArr)).b();
    }

    public void executeDeleteWithoutDetachingEntities() {
        a();
        Database database = this.f27880a.getDatabase();
        if (database.isDbLockedByCurrentThread()) {
            Database database2 = this.f27880a.getDatabase();
            String str = this.f27882c;
            String[] strArr = this.f27883d;
            if (!(database2 instanceof SQLiteDatabase)) {
                database2.execSQL(str, strArr);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) database2, str, strArr);
            }
        } else {
            database.beginTransaction();
            try {
                Database database3 = this.f27880a.getDatabase();
                String str2 = this.f27882c;
                String[] strArr2 = this.f27883d;
                if (!(database3 instanceof SQLiteDatabase)) {
                    database3.execSQL(str2, strArr2);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) database3, str2, strArr2);
                }
                database.setTransactionSuccessful();
            } finally {
                database.endTransaction();
            }
        }
    }

    public DeleteQuery<T> forCurrentThread() {
        return (DeleteQuery) this.queryData.c(this);
    }

    private DeleteQuery(QueryData<T> queryData2, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.queryData = queryData2;
    }

    public DeleteQuery<T> setParameter(int i11, Object obj) {
        return (DeleteQuery) super.setParameter(i11, obj);
    }

    public DeleteQuery<T> setParameter(int i11, Date date) {
        return (DeleteQuery) super.setParameter(i11, date);
    }

    public DeleteQuery<T> setParameter(int i11, Boolean bool) {
        return (DeleteQuery) super.setParameter(i11, bool);
    }
}
