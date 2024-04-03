package androidx.test.internal.util;

import android.os.Looper;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.ThreadChecker;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class Checks {
    private static final ThreadChecker THREAD_CHECKER;

    static {
        Class<ThreadChecker> cls = ThreadChecker.class;
        List<ThreadChecker> loadService = ServiceLoaderWrapper.loadService(cls);
        if (loadService.isEmpty()) {
            THREAD_CHECKER = new ThreadChecker() {
                public void checkMainThread() {
                    Checks.checkState(Thread.currentThread().equals(Looper.getMainLooper().getThread()), "Method cannot be called off the main application thread (on: %s)", Thread.currentThread().getName());
                }

                public void checkNotMainThread() {
                    Checks.checkState(!Thread.currentThread().equals(Looper.getMainLooper().getThread()), "Method cannot be called on the main application thread (on: %s)", Thread.currentThread().getName());
                }
            };
        } else if (loadService.size() == 1) {
            THREAD_CHECKER = loadService.get(0);
        } else {
            throw new IllegalStateException(String.format("Found more than one %s implementations.", new Object[]{cls.getName()}));
        }
    }

    private Checks() {
    }

    public static void checkArgument(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkMainThread() {
        THREAD_CHECKER.checkMainThread();
    }

    public static void checkNotMainThread() {
        THREAD_CHECKER.checkNotMainThread();
    }

    public static <T> T checkNotNull(T t11) {
        t11.getClass();
        return t11;
    }

    public static void checkState(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    private static String format(String str, Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i11 = 0;
        int i12 = 0;
        while (i11 < objArr.length && (indexOf = valueOf.indexOf(LogWriteConstants.LOCATION_MSG_FORMAT, i12)) != -1) {
            sb2.append(valueOf.substring(i12, indexOf));
            sb2.append(objArr[i11]);
            i12 = indexOf + 2;
            i11++;
        }
        sb2.append(valueOf.substring(i12));
        if (i11 < objArr.length) {
            sb2.append(" [");
            sb2.append(objArr[i11]);
            for (int i13 = i11 + 1; i13 < objArr.length; i13++) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb2.append(objArr[i13]);
            }
            sb2.append(AbstractJsonLexerKt.END_LIST);
        }
        return sb2.toString();
    }

    public static void checkArgument(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> T checkNotNull(T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t11, String str, Object... objArr) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(format(str, objArr));
    }

    public static void checkState(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalStateException(format(str, objArr));
        }
    }
}
