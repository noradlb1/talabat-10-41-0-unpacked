package io.reactivex.internal.util;

import i.b;
import io.reactivex.exceptions.CompositeException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {
    public static final Throwable TERMINATED = new Termination();

    public static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Termination() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    private ExceptionHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable th2) {
        Throwable th3;
        Throwable th4;
        do {
            th3 = atomicReference.get();
            if (th3 == TERMINATED) {
                return false;
            }
            if (th3 == null) {
                th4 = th2;
            } else {
                th4 = new CompositeException(th3, th2);
            }
        } while (!b.a(atomicReference, th3, th4));
        return true;
    }

    public static List<Throwable> flatten(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(th2);
        while (!arrayDeque.isEmpty()) {
            Throwable th3 = (Throwable) arrayDeque.removeFirst();
            if (th3 instanceof CompositeException) {
                List<Throwable> exceptions = ((CompositeException) th3).getExceptions();
                for (int size = exceptions.size() - 1; size >= 0; size--) {
                    arrayDeque.offerFirst(exceptions.get(size));
                }
            } else {
                arrayList.add(th3);
            }
        }
        return arrayList;
    }

    public static <T> Throwable terminate(AtomicReference<Throwable> atomicReference) {
        Throwable th2 = atomicReference.get();
        Throwable th3 = TERMINATED;
        if (th2 != th3) {
            return atomicReference.getAndSet(th3);
        }
        return th2;
    }

    public static <E extends Throwable> Exception throwIfThrowable(Throwable th2) throws Throwable {
        if (th2 instanceof Exception) {
            return (Exception) th2;
        }
        throw th2;
    }

    public static String timeoutMessage(long j11, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j11 + " " + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException wrapOrThrow(Throwable th2) {
        if (th2 instanceof Error) {
            throw ((Error) th2);
        } else if (th2 instanceof RuntimeException) {
            return (RuntimeException) th2;
        } else {
            return new RuntimeException(th2);
        }
    }
}
