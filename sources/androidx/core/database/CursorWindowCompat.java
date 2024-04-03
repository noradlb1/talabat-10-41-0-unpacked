package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class CursorWindowCompat {

    @RequiresApi(15)
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static CursorWindow a(String str) {
            return new CursorWindow(str);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static CursorWindow a(String str, long j11) {
            return new CursorWindow(str, j11);
        }
    }

    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(str, j11);
        }
        return Api15Impl.a(str);
    }
}
