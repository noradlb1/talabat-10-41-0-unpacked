package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class SQLiteCursorCompat {

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static void a(SQLiteCursor sQLiteCursor, boolean z11) {
            sQLiteCursor.setFillWindowForwardOnly(z11);
        }
    }

    private SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(@NonNull SQLiteCursor sQLiteCursor, boolean z11) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.a(sQLiteCursor, z11);
        }
    }
}
