package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t11);

    public final int handle(T t11) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t11);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        SupportSQLiteStatement acquire = acquire();
        try {
            int i11 = 0;
            for (Object bind : iterable) {
                bind(acquire, bind);
                i11 += acquire.executeUpdateDelete();
            }
            return i11;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            int i11 = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                i11 += acquire.executeUpdateDelete();
            }
            return i11;
        } finally {
            release(acquire);
        }
    }
}
