package org.junit.jupiter.api;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.DesugarArrays;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.opentest4j.MultipleFailuresError;
import x20.b;
import x20.c;

class AssertAll {
    private AssertAll() {
    }

    public static void b(String str, Collection<Executable> collection) {
        Preconditions.notNull(collection, "executables collection must not be null");
        Preconditions.containsNoNullElements(collection, "individual executables must not be null");
        c(str, Collection.EL.stream(collection));
    }

    public static void c(String str, Stream<Executable> stream) {
        Preconditions.notNull(stream, "executables stream must not be null");
        List list = (List) stream.map(new a()).filter(new b()).collect(Collectors.toList());
        if (!list.isEmpty()) {
            MultipleFailuresError multipleFailuresError = new MultipleFailuresError(str, list);
            Iterable.EL.forEach(list, new c(multipleFailuresError));
            throw multipleFailuresError;
        }
    }

    public static void d(String str, Executable... executableArr) {
        Preconditions.notEmpty((T[]) executableArr, "executables array must not be null or empty");
        Preconditions.containsNoNullElements((T[]) executableArr, "individual executables must not be null");
        c(str, DesugarArrays.stream((T[]) executableArr));
    }

    public static void e(java.util.Collection<Executable> collection) {
        b((String) null, collection);
    }

    public static void f(Stream<Executable> stream) {
        c((String) null, stream);
    }

    public static void g(Executable... executableArr) {
        d((String) null, executableArr);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Throwable lambda$assertAll$0(Executable executable) {
        Preconditions.notNull(executable, "individual executables must not be null");
        try {
            executable.execute();
            return null;
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            return th2;
        }
    }
}
