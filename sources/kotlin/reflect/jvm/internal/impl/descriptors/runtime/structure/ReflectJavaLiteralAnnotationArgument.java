package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaLiteralAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaLiteralAnnotationArgument {
    @NotNull
    private final Object value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaLiteralAnnotationArgument(@Nullable Name name2, @NotNull Object obj) {
        super(name2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(obj, "value");
        this.value = obj;
    }

    @NotNull
    public Object getValue() {
        return this.value;
    }
}
