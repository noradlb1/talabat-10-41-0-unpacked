package org.junit.jupiter.api;

import j$.util.Spliterators;
import j$.util.function.Function;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.net.URI;
import java.util.Iterator;
import org.apiguardian.api.API;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.junit.platform.commons.util.Preconditions;
import x20.a0;
import x20.c0;

@API(since = "5.3", status = API.Status.MAINTAINED)
public class DynamicTest extends DynamicNode {
    private final Executable executable;

    private DynamicTest(String str, URI uri, Executable executable2) {
        super(str, uri);
        this.executable = (Executable) Preconditions.notNull(executable2, "executable must not be null");
    }

    public static DynamicTest dynamicTest(String str, Executable executable2) {
        return new DynamicTest(str, (URI) null, executable2);
    }

    public static <T> Stream<DynamicTest> stream(Iterator<T> it, Function<? super T, String> function, ThrowingConsumer<? super T> throwingConsumer) {
        Preconditions.notNull(it, "inputGenerator must not be null");
        return stream(StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 16), false), function, throwingConsumer);
    }

    public Executable getExecutable() {
        return this.executable;
    }

    public static DynamicTest dynamicTest(String str, URI uri, Executable executable2) {
        return new DynamicTest(str, uri, executable2);
    }

    @API(since = "5.7", status = API.Status.MAINTAINED)
    public static <T> Stream<DynamicTest> stream(Stream<T> stream, Function<? super T, String> function, ThrowingConsumer<? super T> throwingConsumer) {
        Preconditions.notNull(stream, "inputStream must not be null");
        Preconditions.notNull(function, "displayNameGenerator must not be null");
        Preconditions.notNull(throwingConsumer, "testExecutor must not be null");
        return stream.map(new a0(function, throwingConsumer));
    }

    @API(since = "5.8", status = API.Status.MAINTAINED)
    public static <T> Stream<DynamicTest> stream(Iterator<? extends Named<T>> it, ThrowingConsumer<? super T> throwingConsumer) {
        Preconditions.notNull(it, "inputGenerator must not be null");
        return stream(StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, 16), false), throwingConsumer);
    }

    @API(since = "5.8", status = API.Status.MAINTAINED)
    public static <T> Stream<DynamicTest> stream(Stream<? extends Named<T>> stream, ThrowingConsumer<? super T> throwingConsumer) {
        Preconditions.notNull(stream, "inputStream must not be null");
        Preconditions.notNull(throwingConsumer, "testExecutor must not be null");
        return stream.map(new c0(throwingConsumer));
    }
}
