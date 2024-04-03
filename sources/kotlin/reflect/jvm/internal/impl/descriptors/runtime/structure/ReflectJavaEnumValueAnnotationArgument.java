package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaEnumValueAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaEnumValueAnnotationArgument {
    @NotNull
    private final Enum<?> value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaEnumValueAnnotationArgument(@Nullable Name name2, @NotNull Enum<?> enumR) {
        super(name2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(enumR, "value");
        this.value = enumR;
    }

    @Nullable
    public Name getEntryName() {
        return Name.identifier(this.value.name());
    }

    @Nullable
    public ClassId getEnumClassId() {
        Class<?> cls = this.value.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        Intrinsics.checkNotNullExpressionValue(cls, "enumClass");
        return ReflectClassUtilKt.getClassId(cls);
    }
}
