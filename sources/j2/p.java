package j2;

import androidx.arch.core.util.Function;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class p implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f44351a;

    public /* synthetic */ p(RoomDatabase roomDatabase) {
        this.f44351a = roomDatabase;
    }

    public final Object apply(Object obj) {
        return this.f44351a.lambda$beginTransaction$0((SupportSQLiteDatabase) obj);
    }
}
