package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class o implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement f37533a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function f37534b;

    public /* synthetic */ o(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, Function function) {
        this.f37533a = autoClosingSupportSqliteStatement;
        this.f37534b = function;
    }

    public final Object apply(Object obj) {
        return this.f37533a.lambda$executeSqliteStatementWithRefCount$0(this.f37534b, (SupportSQLiteDatabase) obj);
    }
}
