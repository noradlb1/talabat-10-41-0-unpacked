package org.mockito.kotlin;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.mockito.ArgumentCaptor;
import org.mockito.kotlin.internal.CreateInstanceKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0016"}, d2 = {"Lorg/mockito/kotlin/KArgumentCaptor;", "T", "", "captor", "Lorg/mockito/ArgumentCaptor;", "tClass", "Lkotlin/reflect/KClass;", "(Lorg/mockito/ArgumentCaptor;Lkotlin/reflect/KClass;)V", "allValues", "", "getAllValues", "()Ljava/util/List;", "firstValue", "getFirstValue", "()Ljava/lang/Object;", "lastValue", "getLastValue", "secondValue", "getSecondValue", "thirdValue", "getThirdValue", "capture", "mockito-kotlin"}, k = 1, mv = {1, 1, 15})
public final class KArgumentCaptor<T> {
    private final ArgumentCaptor<T> captor;
    private final KClass<?> tClass;

    public KArgumentCaptor(@NotNull ArgumentCaptor<T> argumentCaptor, @NotNull KClass<?> kClass) {
        Intrinsics.checkParameterIsNotNull(argumentCaptor, "captor");
        Intrinsics.checkParameterIsNotNull(kClass, "tClass");
        this.captor = argumentCaptor;
        this.tClass = kClass;
    }

    public final T capture() {
        T capture = this.captor.capture();
        return capture != null ? capture : CreateInstanceKt.createInstance(this.tClass);
    }

    @NotNull
    public final List<T> getAllValues() {
        List<T> allValues = this.captor.getAllValues();
        Intrinsics.checkExpressionValueIsNotNull(allValues, "captor.allValues");
        return allValues;
    }

    public final T getFirstValue() {
        return ArgumentCaptorKt.getFirstValue(this.captor);
    }

    public final T getLastValue() {
        return ArgumentCaptorKt.getLastValue(this.captor);
    }

    public final T getSecondValue() {
        return ArgumentCaptorKt.getSecondValue(this.captor);
    }

    public final T getThirdValue() {
        return ArgumentCaptorKt.getThirdValue(this.captor);
    }
}
