package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class b implements Function {
    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$pokeOpen$0((SupportSQLiteDatabase) obj);
    }
}
