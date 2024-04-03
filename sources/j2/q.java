package j2;

import androidx.arch.core.util.Function;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class q implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f44352a;

    public /* synthetic */ q(RoomDatabase roomDatabase) {
        this.f44352a = roomDatabase;
    }

    public final Object apply(Object obj) {
        return this.f44352a.lambda$endTransaction$1((SupportSQLiteDatabase) obj);
    }
}
