package org.junit.platform.commons.util;

import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.DesugarArrays;
import j$.util.Spliterators;
import j$.util.function.Supplier;
import j$.util.stream.Collector;
import j$.util.stream.Collectors;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import l30.f0;
import l30.g0;
import l30.h0;
import org.apiguardian.api.API;
import org.junit.platform.commons.PreconditionViolationException;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> T getOnlyElement(Collection<T> collection) {
        Preconditions.notNull(collection, "collection must not be null");
        boolean z11 = true;
        if (collection.size() != 1) {
            z11 = false;
        }
        Preconditions.condition(z11, (Supplier<String>) new f0(collection));
        return collection.iterator().next();
    }

    @API(since = "1.9.1", status = API.Status.INTERNAL)
    public static boolean isConvertibleToStream(Class<?> cls) {
        if (cls == null || cls == Void.TYPE) {
            return false;
        }
        if (Stream.class.isAssignableFrom(cls) || DoubleStream.class.isAssignableFrom(cls) || IntStream.class.isAssignableFrom(cls) || LongStream.class.isAssignableFrom(cls) || Iterable.class.isAssignableFrom(cls) || Iterator.class.isAssignableFrom(cls) || Object[].class.isAssignableFrom(cls) || (cls.isArray() && cls.getComponentType().isPrimitive())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$getOnlyElement$0(Collection collection) {
        return "collection must contain exactly one element: " + collection;
    }

    @API(since = "1.6", status = API.Status.INTERNAL)
    public static <T> Set<T> toSet(T[] tArr) {
        Preconditions.notNull(tArr, "values array must not be null");
        if (tArr.length == 0) {
            return Collections.emptySet();
        }
        if (tArr.length == 1) {
            return Collections.singleton(tArr[0]);
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, tArr);
        return hashSet;
    }

    public static Stream<?> toStream(Object obj) {
        Preconditions.notNull(obj, "Object must not be null");
        if (obj instanceof Stream) {
            return (Stream) obj;
        }
        if (obj instanceof DoubleStream) {
            return ((DoubleStream) obj).boxed();
        }
        if (obj instanceof IntStream) {
            return ((IntStream) obj).boxed();
        }
        if (obj instanceof LongStream) {
            return ((LongStream) obj).boxed();
        }
        if (obj instanceof Collection) {
            return Collection.EL.stream((java.util.Collection) obj);
        }
        if (obj instanceof Iterable) {
            return StreamSupport.stream(Iterable.EL.spliterator((Iterable) obj), false);
        }
        if (obj instanceof Iterator) {
            return StreamSupport.stream(Spliterators.spliteratorUnknownSize((Iterator) obj, 16), false);
        }
        if (obj instanceof Object[]) {
            return DesugarArrays.stream((T[]) (Object[]) obj);
        }
        if (obj instanceof double[]) {
            return DoubleStream.CC.of((double[]) obj).boxed();
        }
        if (obj instanceof int[]) {
            return IntStream.CC.of((int[]) obj).boxed();
        }
        if (obj instanceof long[]) {
            return LongStream.CC.of((long[]) obj).boxed();
        }
        if (obj.getClass().isArray() && obj.getClass().getComponentType().isPrimitive()) {
            return IntStream.CC.range(0, Array.getLength(obj)).mapToObj(new h0(obj));
        }
        throw new PreconditionViolationException("Cannot convert instance of " + obj.getClass().getName() + " into a Stream: " + obj);
    }

    public static <T> Collector<T, ?, List<T>> toUnmodifiableList() {
        return Collectors.collectingAndThen(Collectors.toList(), new g0());
    }
}
