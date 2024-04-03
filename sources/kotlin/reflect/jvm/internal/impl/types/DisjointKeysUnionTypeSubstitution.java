package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final TypeSubstitution first;
    @NotNull
    private final TypeSubstitution second;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull TypeSubstitution typeSubstitution, @NotNull TypeSubstitution typeSubstitution2) {
            Intrinsics.checkNotNullParameter(typeSubstitution, "first");
            Intrinsics.checkNotNullParameter(typeSubstitution2, "second");
            if (typeSubstitution.isEmpty()) {
                return typeSubstitution2;
            }
            if (typeSubstitution2.isEmpty()) {
                return typeSubstitution;
            }
            return new DisjointKeysUnionTypeSubstitution(typeSubstitution, typeSubstitution2, (DefaultConstructorMarker) null);
        }
    }

    private DisjointKeysUnionTypeSubstitution(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2) {
        this.first = typeSubstitution;
        this.second = typeSubstitution2;
    }

    public /* synthetic */ DisjointKeysUnionTypeSubstitution(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeSubstitution, typeSubstitution2);
    }

    @JvmStatic
    @NotNull
    public static final TypeSubstitution create(@NotNull TypeSubstitution typeSubstitution, @NotNull TypeSubstitution typeSubstitution2) {
        return Companion.create(typeSubstitution, typeSubstitution2);
    }

    public boolean approximateCapturedTypes() {
        return this.first.approximateCapturedTypes() || this.second.approximateCapturedTypes();
    }

    public boolean approximateContravariantCapturedTypes() {
        return this.first.approximateContravariantCapturedTypes() || this.second.approximateContravariantCapturedTypes();
    }

    @NotNull
    public Annotations filterAnnotations(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return this.second.filterAnnotations(this.first.filterAnnotations(annotations));
    }

    @Nullable
    public TypeProjection get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        TypeProjection typeProjection = this.first.get(kotlinType);
        if (typeProjection == null) {
            return this.second.get(kotlinType);
        }
        return typeProjection;
    }

    public boolean isEmpty() {
        return false;
    }

    @NotNull
    public KotlinType prepareTopLevelType(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        Intrinsics.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics.checkNotNullParameter(variance, "position");
        return this.second.prepareTopLevelType(this.first.prepareTopLevelType(kotlinType, variance), variance);
    }
}
