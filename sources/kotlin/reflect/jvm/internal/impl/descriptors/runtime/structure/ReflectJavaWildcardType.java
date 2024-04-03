package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    @NotNull
    private final Collection<JavaAnnotation> annotations = CollectionsKt__CollectionsKt.emptyList();
    private final boolean isDeprecatedInJavaDoc;
    @NotNull
    private final WildcardType reflectType;

    public ReflectJavaWildcardType(@NotNull WildcardType wildcardType) {
        Intrinsics.checkNotNullParameter(wildcardType, "reflectType");
        this.reflectType = wildcardType;
    }

    @NotNull
    /* renamed from: a */
    public WildcardType getReflectType() {
        return this.reflectType;
    }

    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    public boolean isExtends() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "reflectType.upperBounds");
        return !Intrinsics.areEqual(ArraysKt___ArraysKt.firstOrNull((T[]) upperBounds), (Object) Object.class);
    }

    @Nullable
    public ReflectJavaType getBound() {
        Type[] upperBounds = getReflectType().getUpperBounds();
        Type[] lowerBounds = getReflectType().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + getReflectType());
        } else if (lowerBounds.length == 1) {
            ReflectJavaType.Factory factory = ReflectJavaType.Factory;
            Intrinsics.checkNotNullExpressionValue(lowerBounds, "lowerBounds");
            Object single = ArraysKt___ArraysKt.single((T[]) lowerBounds);
            Intrinsics.checkNotNullExpressionValue(single, "lowerBounds.single()");
            return factory.create((Type) single);
        } else {
            if (upperBounds.length == 1) {
                Intrinsics.checkNotNullExpressionValue(upperBounds, "upperBounds");
                Type type = (Type) ArraysKt___ArraysKt.single((T[]) upperBounds);
                if (!Intrinsics.areEqual((Object) type, (Object) Object.class)) {
                    ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
                    Intrinsics.checkNotNullExpressionValue(type, "ub");
                    return factory2.create(type);
                }
            }
            return null;
        }
    }
}
