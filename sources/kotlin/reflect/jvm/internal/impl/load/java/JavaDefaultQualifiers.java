package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaDefaultQualifiers {
    private final boolean definitelyNotNull;
    @NotNull
    private final NullabilityQualifierWithMigrationStatus nullabilityQualifier;
    @NotNull
    private final Collection<AnnotationQualifierApplicabilityType> qualifierApplicabilityTypes;

    public JavaDefaultQualifiers(@NotNull NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z11) {
        Intrinsics.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        this.nullabilityQualifier = nullabilityQualifierWithMigrationStatus;
        this.qualifierApplicabilityTypes = collection;
        this.definitelyNotNull = z11;
    }

    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<AnnotationQualifierApplicabilityType> collection, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            nullabilityQualifierWithMigrationStatus = javaDefaultQualifiers.nullabilityQualifier;
        }
        if ((i11 & 2) != 0) {
            collection = javaDefaultQualifiers.qualifierApplicabilityTypes;
        }
        if ((i11 & 4) != 0) {
            z11 = javaDefaultQualifiers.definitelyNotNull;
        }
        return javaDefaultQualifiers.copy(nullabilityQualifierWithMigrationStatus, collection, z11);
    }

    @NotNull
    public final JavaDefaultQualifiers copy(@NotNull NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z11) {
        Intrinsics.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(nullabilityQualifierWithMigrationStatus, collection, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaDefaultQualifiers)) {
            return false;
        }
        JavaDefaultQualifiers javaDefaultQualifiers = (JavaDefaultQualifiers) obj;
        return Intrinsics.areEqual((Object) this.nullabilityQualifier, (Object) javaDefaultQualifiers.nullabilityQualifier) && Intrinsics.areEqual((Object) this.qualifierApplicabilityTypes, (Object) javaDefaultQualifiers.qualifierApplicabilityTypes) && this.definitelyNotNull == javaDefaultQualifiers.definitelyNotNull;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    @NotNull
    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.nullabilityQualifier;
    }

    @NotNull
    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.qualifierApplicabilityTypes;
    }

    public int hashCode() {
        int hashCode = ((this.nullabilityQualifier.hashCode() * 31) + this.qualifierApplicabilityTypes.hashCode()) * 31;
        boolean z11 = this.definitelyNotNull;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "JavaDefaultQualifiers(nullabilityQualifier=" + this.nullabilityQualifier + ", qualifierApplicabilityTypes=" + this.qualifierApplicabilityTypes + ", definitelyNotNull=" + this.definitelyNotNull + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifierWithMigrationStatus, collection, (i11 & 4) != 0 ? nullabilityQualifierWithMigrationStatus.getQualifier() == NullabilityQualifier.NOT_NULL : z11);
    }
}
