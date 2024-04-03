package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Throwables {
    @GwtIncompatible
    @J2ktIncompatible
    private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
    @GwtIncompatible
    @J2ktIncompatible
    @VisibleForTesting
    static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
    /* access modifiers changed from: private */
    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible
    public static final Method getStackTraceDepthMethod;
    /* access modifiers changed from: private */
    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible
    public static final Method getStackTraceElementMethod;
    /* access modifiers changed from: private */
    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible
    public static final Object jla;

    static {
        Method method;
        Object jla2 = getJLA();
        jla = jla2;
        Method method2 = null;
        if (jla2 == null) {
            method = null;
        } else {
            method = getGetMethod();
        }
        getStackTraceElementMethod = method;
        if (jla2 != null) {
            method2 = getSizeMethod(jla2);
        }
        getStackTraceDepthMethod = method2;
    }

    private Throwables() {
    }

    public static List<Throwable> getCausalChain(Throwable th2) {
        Preconditions.checkNotNull(th2);
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(th2);
        boolean z11 = false;
        Throwable th3 = th2;
        while (true) {
            th2 = th2.getCause();
            if (th2 == null) {
                return Collections.unmodifiableList(arrayList);
            }
            arrayList.add(th2);
            if (th2 != th3) {
                if (z11) {
                    th3 = th3.getCause();
                }
                z11 = !z11;
            } else {
                throw new IllegalArgumentException("Loop in causal chain detected.", th2);
            }
        }
    }

    @GwtIncompatible
    @CheckForNull
    @J2ktIncompatible
    public static <X extends Throwable> X getCauseAs(Throwable th2, Class<X> cls) {
        try {
            return (Throwable) cls.cast(th2.getCause());
        } catch (ClassCastException e11) {
            e11.initCause(th2);
            throw e11;
        }
    }

    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible
    private static Method getGetMethod() {
        return getJlaMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible
    private static Object getJLA() {
        try {
            return Class.forName(SHARED_SECRETS_CLASSNAME, false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    @GwtIncompatible
    @CheckForNull
    @J2ktIncompatible
    private static Method getJlaMethod(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName(JAVA_LANG_ACCESS_CLASSNAME, false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Throwable getRootCause(Throwable th2) {
        boolean z11 = false;
        Throwable th3 = th2;
        while (true) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                return th2;
            }
            if (cause != th3) {
                if (z11) {
                    th3 = th3.getCause();
                }
                z11 = !z11;
                th2 = cause;
            } else {
                throw new IllegalArgumentException("Loop in causal chain detected.", cause);
            }
        }
    }

    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible
    private static Method getSizeMethod(Object obj) {
        try {
            Method jlaMethod = getJlaMethod("getStackTraceDepth", Throwable.class);
            if (jlaMethod == null) {
                return null;
            }
            jlaMethod.invoke(obj, new Object[]{new Throwable()});
            return jlaMethod;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @GwtIncompatible
    public static String getStackTraceAsString(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    @J2ktIncompatible
    public static Object invokeAccessibleNonThrowingMethod(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw propagate(e12.getCause());
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static List<StackTraceElement> jlaStackTrace(final Throwable th2) {
        Preconditions.checkNotNull(th2);
        return new AbstractList<StackTraceElement>() {
            public int size() {
                Method access$300 = Throwables.getStackTraceDepthMethod;
                Objects.requireNonNull(access$300);
                Object access$100 = Throwables.jla;
                Objects.requireNonNull(access$100);
                return ((Integer) Throwables.invokeAccessibleNonThrowingMethod(access$300, access$100, th2)).intValue();
            }

            public StackTraceElement get(int i11) {
                Method access$000 = Throwables.getStackTraceElementMethod;
                Objects.requireNonNull(access$000);
                Object access$100 = Throwables.jla;
                Objects.requireNonNull(access$100);
                return (StackTraceElement) Throwables.invokeAccessibleNonThrowingMethod(access$000, access$100, th2, Integer.valueOf(i11));
            }
        };
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static List<StackTraceElement> lazyStackTrace(Throwable th2) {
        if (lazyStackTraceIsLazy()) {
            return jlaStackTrace(th2);
        }
        return Collections.unmodifiableList(Arrays.asList(th2.getStackTrace()));
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static boolean lazyStackTraceIsLazy() {
        return (getStackTraceElementMethod == null || getStackTraceDepthMethod == null) ? false : true;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Deprecated
    @J2ktIncompatible
    public static RuntimeException propagate(Throwable th2) {
        throwIfUnchecked(th2);
        throw new RuntimeException(th2);
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static <X extends Throwable> void propagateIfInstanceOf(@CheckForNull Throwable th2, Class<X> cls) throws Throwable {
        if (th2 != null) {
            throwIfInstanceOf(th2, cls);
        }
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static void propagateIfPossible(@CheckForNull Throwable th2) {
        if (th2 != null) {
            throwIfUnchecked(th2);
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <X extends Throwable> void throwIfInstanceOf(Throwable th2, Class<X> cls) throws Throwable {
        Preconditions.checkNotNull(th2);
        if (cls.isInstance(th2)) {
            throw ((Throwable) cls.cast(th2));
        }
    }

    public static void throwIfUnchecked(Throwable th2) {
        Preconditions.checkNotNull(th2);
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else if (th2 instanceof Error) {
            throw ((Error) th2);
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <X extends Throwable> void propagateIfPossible(@CheckForNull Throwable th2, Class<X> cls) throws Throwable {
        propagateIfInstanceOf(th2, cls);
        propagateIfPossible(th2);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@CheckForNull Throwable th2, Class<X1> cls, Class<X2> cls2) throws Throwable, Throwable {
        Preconditions.checkNotNull(cls2);
        propagateIfInstanceOf(th2, cls);
        propagateIfPossible(th2, cls2);
    }
}
