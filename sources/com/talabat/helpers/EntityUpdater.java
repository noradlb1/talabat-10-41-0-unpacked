package com.talabat.helpers;

import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function3;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import zr.a;
import zr.b;

public class EntityUpdater<T> implements BiFunction<T, T, T> {
    private final Callable<T> createNewEntity;
    private final BiPredicate<T, T> isSameEntity;
    private final Function3<Field, Object, Object, Object> merger = new b();

    public EntityUpdater(Callable<T> callable, BiPredicate<T, T> biPredicate) {
        this.createNewEntity = callable;
        this.isSameEntity = biPredicate;
    }

    /* access modifiers changed from: private */
    public static Object defaultMerger(Field field, Object obj, Object obj2) throws Exception {
        Object obj3 = field.get(obj);
        Object obj4 = field.get(obj2);
        if (obj4 == null) {
            return obj3;
        }
        return obj4;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$apply$0(Object obj, Object obj2, Object obj3, Field field) throws Exception {
        field.setAccessible(true);
        field.set(obj, this.merger.apply(field, obj2, obj3));
    }

    @Nullable
    public T apply(@Nullable T t11, @Nullable T t12) throws Exception {
        if (t11 == null || t12 == null || !this.isSameEntity.test(t11, t12)) {
            return t12;
        }
        T call = this.createNewEntity.call();
        Observable.fromArray(call.getClass().getDeclaredFields()).blockingForEach(new a(this, call, t11, t12));
        return call;
    }
}
