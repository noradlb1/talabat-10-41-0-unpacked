package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;

public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }

        public static boolean postDelayed(Handler handler, Runnable runnable, Object obj, long j11) {
            return handler.postDelayed(runnable, obj, j11);
        }

        public static Handler createAsync(Looper looper, Handler.Callback callback) {
            return Handler.createAsync(looper, callback);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean hasCallbacks(Handler handler, Runnable runnable) {
            return handler.hasCallbacks(runnable);
        }
    }

    private HandlerCompat() {
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(looper);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e11) {
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e11);
            return new Handler(looper);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        }
    }

    @RequiresApi(16)
    public static boolean hasCallbacks(@NonNull Handler handler, @NonNull Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.hasCallbacks(handler, runnable);
        }
        try {
            return ((Boolean) Handler.class.getMethod("hasCallbacks", new Class[]{Runnable.class}).invoke(handler, new Object[]{runnable})).booleanValue();
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        } catch (IllegalAccessException | NoSuchMethodException | NullPointerException e12) {
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e12);
        }
    }

    public static boolean postDelayed(@NonNull Handler handler, @NonNull Runnable runnable, @Nullable Object obj, long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.postDelayed(handler, runnable, obj, j11);
        }
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = obj;
        return handler.sendMessageDelayed(obtain, j11);
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(looper, callback);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, callback, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e11) {
            Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e11);
            return new Handler(looper, callback);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException(cause);
            }
        }
    }
}
