package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeAttributes {
    @Nullable
    private final SimpleType defaultType;
    @NotNull
    private final JavaTypeFlexibility flexibility;
    @NotNull
    private final TypeUsage howThisTypeIsUsed;
    private final boolean isForAnnotationParameter;
    @Nullable
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    public JavaTypeAttributes(@NotNull TypeUsage typeUsage, @NotNull JavaTypeFlexibility javaTypeFlexibility, boolean z11, @Nullable Set<? extends TypeParameterDescriptor> set, @Nullable SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        this.howThisTypeIsUsed = typeUsage;
        this.flexibility = javaTypeFlexibility;
        this.isForAnnotationParameter = z11;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes javaTypeAttributes, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z11, Set<TypeParameterDescriptor> set, SimpleType simpleType, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            typeUsage = javaTypeAttributes.howThisTypeIsUsed;
        }
        if ((i11 & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.flexibility;
        }
        JavaTypeFlexibility javaTypeFlexibility2 = javaTypeFlexibility;
        if ((i11 & 4) != 0) {
            z11 = javaTypeAttributes.isForAnnotationParameter;
        }
        boolean z12 = z11;
        if ((i11 & 8) != 0) {
            set = javaTypeAttributes.visitedTypeParameters;
        }
        Set<TypeParameterDescriptor> set2 = set;
        if ((i11 & 16) != 0) {
            simpleType = javaTypeAttributes.defaultType;
        }
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility2, z12, set2, simpleType);
    }

    @NotNull
    public final JavaTypeAttributes copy(@NotNull TypeUsage typeUsage, @NotNull JavaTypeFlexibility javaTypeFlexibility, boolean z11, @Nullable Set<? extends TypeParameterDescriptor> set, @Nullable SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return new JavaTypeAttributes(typeUsage, javaTypeFlexibility, z11, set, simpleType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaTypeAttributes)) {
            return false;
        }
        JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) obj;
        return this.howThisTypeIsUsed == javaTypeAttributes.howThisTypeIsUsed && this.flexibility == javaTypeAttributes.flexibility && this.isForAnnotationParameter == javaTypeAttributes.isForAnnotationParameter && Intrinsics.areEqual((Object) this.visitedTypeParameters, (Object) javaTypeAttributes.visitedTypeParameters) && Intrinsics.areEqual((Object) this.defaultType, (Object) javaTypeAttributes.defaultType);
    }

    @Nullable
    public final SimpleType getDefaultType() {
        return this.defaultType;
    }

    @NotNull
    public final JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    @NotNull
    public final TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    @Nullable
    public final Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public int hashCode() {
        int hashCode = ((this.howThisTypeIsUsed.hashCode() * 31) + this.flexibility.hashCode()) * 31;
        boolean z11 = this.isForAnnotationParameter;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        Set<TypeParameterDescriptor> set = this.visitedTypeParameters;
        int i12 = 0;
        int hashCode2 = (i11 + (set == null ? 0 : set.hashCode())) * 31;
        SimpleType simpleType = this.defaultType;
        if (simpleType != null) {
            i12 = simpleType.hashCode();
        }
        return hashCode2 + i12;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    @NotNull
    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.howThisTypeIsUsed + ", flexibility=" + this.flexibility + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + this.visitedTypeParameters + ", defaultType=" + this.defaultType + ')';
    }

    @NotNull
    public final JavaTypeAttributes withDefaultType(@Nullable SimpleType simpleType) {
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, (Set) null, simpleType, 15, (Object) null);
    }

    @NotNull
    public final JavaTypeAttributes withFlexibility(@NotNull JavaTypeFlexibility javaTypeFlexibility) {
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return copy$default(this, (TypeUsage) null, javaTypeFlexibility, false, (Set) null, (SimpleType) null, 29, (Object) null);
    }

    @NotNull
    public final JavaTypeAttributes withNewVisitedTypeParameter(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        Set set;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Set<TypeParameterDescriptor> set2 = this.visitedTypeParameters;
        if (set2 != null) {
            set = SetsKt___SetsKt.plus(set2, typeParameterDescriptor);
        } else {
            set = SetsKt__SetsJVMKt.setOf(typeParameterDescriptor);
        }
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, set, (SimpleType) null, 23, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z11, Set set, SimpleType simpleType, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i11 & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? null : set, (i11 & 16) != 0 ? null : simpleType);
    }
}
