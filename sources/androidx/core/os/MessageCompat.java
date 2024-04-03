package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    @RequiresApi(22)
    public static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        public static boolean a(Message message) {
            return message.isAsynchronous();
        }

        @DoNotInline
        public static void b(Message message, boolean z11) {
            message.setAsynchronous(z11);
        }
    }

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message message) {
        return Api22Impl.a(message);
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message message, boolean z11) {
        Api22Impl.b(message, z11);
    }
}
