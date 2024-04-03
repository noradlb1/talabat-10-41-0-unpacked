package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeSubstitution$replaceWithNonApproximating$1 extends TypeSubstitution {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TypeSubstitution f24960a;

    public TypeSubstitution$replaceWithNonApproximating$1(TypeSubstitution typeSubstitution) {
        this.f24960a = typeSubstitution;
    }

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    @NotNull
    public Annotations filterAnnotations(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return this.f24960a.filterAnnotations(annotations);
    }

    @Nullable
    public TypeProjection get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        return this.f24960a.get(kotlinType);
    }

    public boolean isEmpty() {
        return this.f24960a.isEmpty();
    }

    @NotNull
    public KotlinType prepareTopLevelType(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        Intrinsics.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics.checkNotNullParameter(variance, "position");
        return this.f24960a.prepareTopLevelType(kotlinType, variance);
    }
}
