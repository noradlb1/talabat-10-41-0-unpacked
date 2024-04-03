package timber.log;

import android.os.Build;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Timber {
    private static final List<Tree> FOREST = new ArrayList();
    private static final Tree[] TREE_ARRAY_EMPTY;
    private static final Tree TREE_OF_SOULS = new Tree() {
        public void d(String str, Object... objArr) {
            for (Tree d11 : Timber.f63507a) {
                d11.d(str, objArr);
            }
        }

        public void e(String str, Object... objArr) {
            for (Tree e11 : Timber.f63507a) {
                e11.e(str, objArr);
            }
        }

        public void g(int i11, String str, @NotNull String str2, Throwable th2) {
            throw new AssertionError("Missing override for log method.");
        }

        public void i(String str, Object... objArr) {
            for (Tree i11 : Timber.f63507a) {
                i11.i(str, objArr);
            }
        }

        public void log(int i11, String str, Object... objArr) {
            for (Tree log : Timber.f63507a) {
                log.log(i11, str, objArr);
            }
        }

        public void v(String str, Object... objArr) {
            for (Tree v11 : Timber.f63507a) {
                v11.v(str, objArr);
            }
        }

        public void w(String str, Object... objArr) {
            for (Tree w11 : Timber.f63507a) {
                w11.w(str, objArr);
            }
        }

        public void wtf(String str, Object... objArr) {
            for (Tree wtf : Timber.f63507a) {
                wtf.wtf(str, objArr);
            }
        }

        public void d(Throwable th2, String str, Object... objArr) {
            for (Tree d11 : Timber.f63507a) {
                d11.d(th2, str, objArr);
            }
        }

        public void e(Throwable th2, String str, Object... objArr) {
            for (Tree e11 : Timber.f63507a) {
                e11.e(th2, str, objArr);
            }
        }

        public void i(Throwable th2, String str, Object... objArr) {
            for (Tree i11 : Timber.f63507a) {
                i11.i(th2, str, objArr);
            }
        }

        public void log(int i11, Throwable th2, String str, Object... objArr) {
            for (Tree log : Timber.f63507a) {
                log.log(i11, th2, str, objArr);
            }
        }

        public void v(Throwable th2, String str, Object... objArr) {
            for (Tree v11 : Timber.f63507a) {
                v11.v(th2, str, objArr);
            }
        }

        public void w(Throwable th2, String str, Object... objArr) {
            for (Tree w11 : Timber.f63507a) {
                w11.w(th2, str, objArr);
            }
        }

        public void wtf(Throwable th2, String str, Object... objArr) {
            for (Tree wtf : Timber.f63507a) {
                wtf.wtf(th2, str, objArr);
            }
        }

        public void d(Throwable th2) {
            for (Tree d11 : Timber.f63507a) {
                d11.d(th2);
            }
        }

        public void e(Throwable th2) {
            for (Tree e11 : Timber.f63507a) {
                e11.e(th2);
            }
        }

        public void i(Throwable th2) {
            for (Tree i11 : Timber.f63507a) {
                i11.i(th2);
            }
        }

        public void log(int i11, Throwable th2) {
            for (Tree log : Timber.f63507a) {
                log.log(i11, th2);
            }
        }

        public void v(Throwable th2) {
            for (Tree v11 : Timber.f63507a) {
                v11.v(th2);
            }
        }

        public void w(Throwable th2) {
            for (Tree w11 : Timber.f63507a) {
                w11.w(th2);
            }
        }

        public void wtf(Throwable th2) {
            for (Tree wtf : Timber.f63507a) {
                wtf.wtf(th2);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static volatile Tree[] f63507a;

    public static class DebugTree extends Tree {
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
        private static final int CALL_STACK_INDEX = 5;
        private static final int MAX_LOG_LENGTH = 4000;
        private static final int MAX_TAG_LENGTH = 23;

        public final String b() {
            String b11 = super.b();
            if (b11 != null) {
                return b11;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 5) {
                return h(stackTrace[5]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        public void g(int i11, String str, @NotNull String str2, Throwable th2) {
            int min;
            if (str2.length() >= MAX_LOG_LENGTH) {
                int length = str2.length();
                int i12 = 0;
                while (i12 < length) {
                    int indexOf = str2.indexOf(10, i12);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i12 + MAX_LOG_LENGTH);
                        String substring = str2.substring(i12, min);
                        if (i11 == 7) {
                            Log.wtf(str, substring);
                        } else {
                            Log.println(i11, str, substring);
                        }
                        if (min >= indexOf) {
                            break;
                        }
                        i12 = min;
                    }
                    i12 = min + 1;
                }
            } else if (i11 == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i11, str, str2);
            }
        }

        @Nullable
        public String h(@NotNull StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String substring = className.substring(className.lastIndexOf(46) + 1);
            if (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) {
                return substring;
            }
            return substring.substring(0, 23);
        }
    }

    public static abstract class Tree {

        /* renamed from: a  reason: collision with root package name */
        public final ThreadLocal<String> f63508a = new ThreadLocal<>();

        private String getStackTraceString(Throwable th2) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th2.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void prepareLog(int i11, Throwable th2, String str, Object... objArr) {
            String b11 = b();
            if (f(b11, i11)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = a(str, objArr);
                    }
                    if (th2 != null) {
                        str = str + StringUtils.LF + getStackTraceString(th2);
                    }
                } else if (th2 != null) {
                    str = getStackTraceString(th2);
                } else {
                    return;
                }
                g(i11, b11, str, th2);
            }
        }

        public String a(@NotNull String str, @NotNull Object[] objArr) {
            return String.format(str, objArr);
        }

        @Nullable
        public String b() {
            String str = this.f63508a.get();
            if (str != null) {
                this.f63508a.remove();
            }
            return str;
        }

        @Deprecated
        public boolean c(int i11) {
            return true;
        }

        public void d(String str, Object... objArr) {
            prepareLog(3, (Throwable) null, str, objArr);
        }

        public void e(String str, Object... objArr) {
            prepareLog(6, (Throwable) null, str, objArr);
        }

        public boolean f(@Nullable String str, int i11) {
            return c(i11);
        }

        public abstract void g(int i11, @Nullable String str, @NotNull String str2, @Nullable Throwable th2);

        public void i(String str, Object... objArr) {
            prepareLog(4, (Throwable) null, str, objArr);
        }

        public void log(int i11, String str, Object... objArr) {
            prepareLog(i11, (Throwable) null, str, objArr);
        }

        public void v(String str, Object... objArr) {
            prepareLog(2, (Throwable) null, str, objArr);
        }

        public void w(String str, Object... objArr) {
            prepareLog(5, (Throwable) null, str, objArr);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, (Throwable) null, str, objArr);
        }

        public void d(Throwable th2, String str, Object... objArr) {
            prepareLog(3, th2, str, objArr);
        }

        public void e(Throwable th2, String str, Object... objArr) {
            prepareLog(6, th2, str, objArr);
        }

        public void i(Throwable th2, String str, Object... objArr) {
            prepareLog(4, th2, str, objArr);
        }

        public void log(int i11, Throwable th2, String str, Object... objArr) {
            prepareLog(i11, th2, str, objArr);
        }

        public void v(Throwable th2, String str, Object... objArr) {
            prepareLog(2, th2, str, objArr);
        }

        public void w(Throwable th2, String str, Object... objArr) {
            prepareLog(5, th2, str, objArr);
        }

        public void wtf(Throwable th2, String str, Object... objArr) {
            prepareLog(7, th2, str, objArr);
        }

        public void d(Throwable th2) {
            prepareLog(3, th2, (String) null, new Object[0]);
        }

        public void e(Throwable th2) {
            prepareLog(6, th2, (String) null, new Object[0]);
        }

        public void i(Throwable th2) {
            prepareLog(4, th2, (String) null, new Object[0]);
        }

        public void log(int i11, Throwable th2) {
            prepareLog(i11, th2, (String) null, new Object[0]);
        }

        public void v(Throwable th2) {
            prepareLog(2, th2, (String) null, new Object[0]);
        }

        public void w(Throwable th2) {
            prepareLog(5, th2, (String) null, new Object[0]);
        }

        public void wtf(Throwable th2) {
            prepareLog(7, th2, (String) null, new Object[0]);
        }
    }

    static {
        Tree[] treeArr = new Tree[0];
        TREE_ARRAY_EMPTY = treeArr;
        f63507a = treeArr;
    }

    private Timber() {
        throw new AssertionError("No instances.");
    }

    @NotNull
    public static Tree asTree() {
        return TREE_OF_SOULS;
    }

    public static void d(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.d(str, objArr);
    }

    public static void e(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.e(str, objArr);
    }

    @NotNull
    public static List<Tree> forest() {
        List<Tree> unmodifiableList;
        List<Tree> list = FOREST;
        synchronized (list) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return unmodifiableList;
    }

    public static void i(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.i(str, objArr);
    }

    public static void log(int i11, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.log(i11, str, objArr);
    }

    public static void plant(@NotNull Tree tree) {
        if (tree == null) {
            throw new NullPointerException("tree == null");
        } else if (tree != TREE_OF_SOULS) {
            List<Tree> list = FOREST;
            synchronized (list) {
                list.add(tree);
                f63507a = (Tree[]) list.toArray(new Tree[list.size()]);
            }
        } else {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
    }

    @NotNull
    public static Tree tag(String str) {
        for (Tree tree : f63507a) {
            tree.f63508a.set(str);
        }
        return TREE_OF_SOULS;
    }

    public static int treeCount() {
        int size;
        List<Tree> list = FOREST;
        synchronized (list) {
            size = list.size();
        }
        return size;
    }

    public static void uproot(@NotNull Tree tree) {
        List<Tree> list = FOREST;
        synchronized (list) {
            if (list.remove(tree)) {
                f63507a = (Tree[]) list.toArray(new Tree[list.size()]);
            } else {
                throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + tree);
            }
        }
    }

    public static void uprootAll() {
        List<Tree> list = FOREST;
        synchronized (list) {
            list.clear();
            f63507a = TREE_ARRAY_EMPTY;
        }
    }

    public static void v(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.v(str, objArr);
    }

    public static void w(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.w(str, objArr);
    }

    public static void wtf(@NonNls String str, Object... objArr) {
        TREE_OF_SOULS.wtf(str, objArr);
    }

    public static void d(Throwable th2, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.d(th2, str, objArr);
    }

    public static void e(Throwable th2, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.e(th2, str, objArr);
    }

    public static void i(Throwable th2, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.i(th2, str, objArr);
    }

    public static void log(int i11, Throwable th2, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.log(i11, th2, str, objArr);
    }

    public static void v(Throwable th2, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.v(th2, str, objArr);
    }

    public static void w(Throwable th2, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.w(th2, str, objArr);
    }

    public static void wtf(Throwable th2, @NonNls String str, Object... objArr) {
        TREE_OF_SOULS.wtf(th2, str, objArr);
    }

    public static void d(Throwable th2) {
        TREE_OF_SOULS.d(th2);
    }

    public static void e(Throwable th2) {
        TREE_OF_SOULS.e(th2);
    }

    public static void i(Throwable th2) {
        TREE_OF_SOULS.i(th2);
    }

    public static void log(int i11, Throwable th2) {
        TREE_OF_SOULS.log(i11, th2);
    }

    public static void v(Throwable th2) {
        TREE_OF_SOULS.v(th2);
    }

    public static void w(Throwable th2) {
        TREE_OF_SOULS.w(th2);
    }

    public static void wtf(Throwable th2) {
        TREE_OF_SOULS.wtf(th2);
    }

    public static void plant(@NotNull Tree... treeArr) {
        if (treeArr != null) {
            int length = treeArr.length;
            int i11 = 0;
            while (i11 < length) {
                Tree tree = treeArr[i11];
                if (tree == null) {
                    throw new NullPointerException("trees contains null");
                } else if (tree != TREE_OF_SOULS) {
                    i11++;
                } else {
                    throw new IllegalArgumentException("Cannot plant Timber into itself.");
                }
            }
            List<Tree> list = FOREST;
            synchronized (list) {
                Collections.addAll(list, treeArr);
                f63507a = (Tree[]) list.toArray(new Tree[list.size()]);
            }
            return;
        }
        throw new NullPointerException("trees == null");
    }
}
