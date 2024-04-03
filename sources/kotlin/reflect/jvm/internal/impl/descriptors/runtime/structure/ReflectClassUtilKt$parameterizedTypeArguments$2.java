package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class ReflectClassUtilKt$parameterizedTypeArguments$2 extends Lambda implements Function1<ParameterizedType, Sequence<? extends Type>> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$2 INSTANCE = new ReflectClassUtilKt$parameterizedTypeArguments$2();

    public ReflectClassUtilKt$parameterizedTypeArguments$2() {
        super(1);
    }

    @NotNull
    public final Sequence<Type> invoke(@NotNull ParameterizedType parameterizedType) {
        Intrinsics.checkNotNullParameter(parameterizedType, "it");
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "it.actualTypeArguments");
        return ArraysKt___ArraysKt.asSequence((T[]) actualTypeArguments);
    }
}
