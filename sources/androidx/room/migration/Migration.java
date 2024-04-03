package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int i11, int i12) {
        this.startVersion = i11;
        this.endVersion = i12;
    }

    public abstract void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);
}
