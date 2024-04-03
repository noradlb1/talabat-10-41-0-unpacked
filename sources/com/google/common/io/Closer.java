package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class Closer implements Closeable {
    private static final Suppressor SUPPRESSOR;
    private final Deque<Closeable> stack = new ArrayDeque(4);
    @VisibleForTesting
    final Suppressor suppressor;
    @CheckForNull
    private Throwable thrown;

    @VisibleForTesting
    public static final class LoggingSuppressor implements Suppressor {
        static final LoggingSuppressor INSTANCE = new LoggingSuppressor();

        public void suppress(Closeable closeable, Throwable th2, Throwable th3) {
            Logger logger = Closeables.logger;
            Level level = Level.WARNING;
            logger.log(level, "Suppressing exception thrown when closing " + closeable, th3);
        }
    }

    @VisibleForTesting
    public static final class SuppressingSuppressor implements Suppressor {
        private final Method addSuppressed;

        private SuppressingSuppressor(Method method) {
            this.addSuppressed = method;
        }

        @CheckForNull
        public static SuppressingSuppressor tryCreate() {
            Class<Throwable> cls = Throwable.class;
            try {
                return new SuppressingSuppressor(cls.getMethod("addSuppressed", new Class[]{cls}));
            } catch (Throwable unused) {
                return null;
            }
        }

        public void suppress(Closeable closeable, Throwable th2, Throwable th3) {
            if (th2 != th3) {
                try {
                    this.addSuppressed.invoke(th2, new Object[]{th3});
                } catch (Throwable unused) {
                    LoggingSuppressor.INSTANCE.suppress(closeable, th2, th3);
                }
            }
        }
    }

    @VisibleForTesting
    public interface Suppressor {
        void suppress(Closeable closeable, Throwable th2, Throwable th3);
    }

    static {
        Suppressor tryCreate = SuppressingSuppressor.tryCreate();
        if (tryCreate == null) {
            tryCreate = LoggingSuppressor.INSTANCE;
        }
        SUPPRESSOR = tryCreate;
    }

    @VisibleForTesting
    public Closer(Suppressor suppressor2) {
        this.suppressor = (Suppressor) Preconditions.checkNotNull(suppressor2);
    }

    public static Closer create() {
        return new Closer(SUPPRESSOR);
    }

    public void close() throws IOException {
        Throwable th2 = this.thrown;
        while (!this.stack.isEmpty()) {
            Closeable removeFirst = this.stack.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th3) {
                if (th2 == null) {
                    th2 = th3;
                } else {
                    this.suppressor.suppress(removeFirst, th2, th3);
                }
            }
        }
        if (this.thrown == null && th2 != null) {
            Throwables.propagateIfPossible(th2, IOException.class);
            throw new AssertionError(th2);
        }
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public <C extends Closeable> C register(@ParametricNullness C c11) {
        if (c11 != null) {
            this.stack.addFirst(c11);
        }
        return c11;
    }

    public RuntimeException rethrow(Throwable th2) throws IOException {
        Preconditions.checkNotNull(th2);
        this.thrown = th2;
        Throwables.propagateIfPossible(th2, IOException.class);
        throw new RuntimeException(th2);
    }

    public <X extends Exception> RuntimeException rethrow(Throwable th2, Class<X> cls) throws IOException, Exception {
        Preconditions.checkNotNull(th2);
        this.thrown = th2;
        Throwables.propagateIfPossible(th2, IOException.class);
        Throwables.propagateIfPossible(th2, cls);
        throw new RuntimeException(th2);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable th2, Class<X1> cls, Class<X2> cls2) throws IOException, Exception, Exception {
        Preconditions.checkNotNull(th2);
        this.thrown = th2;
        Throwables.propagateIfPossible(th2, IOException.class);
        Throwables.propagateIfPossible(th2, cls, cls2);
        throw new RuntimeException(th2);
    }
}
