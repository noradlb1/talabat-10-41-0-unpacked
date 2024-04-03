package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NullabilityQualifierWithMigrationStatus {
    private final boolean isForWarningOnly;
    @NotNull
    private final NullabilityQualifier qualifier;

    public NullabilityQualifierWithMigrationStatus(@NotNull NullabilityQualifier nullabilityQualifier, boolean z11) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "qualifier");
        this.qualifier = nullabilityQualifier;
        this.isForWarningOnly = z11;
    }

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifier nullabilityQualifier, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            nullabilityQualifier = nullabilityQualifierWithMigrationStatus.qualifier;
        }
        if ((i11 & 2) != 0) {
            z11 = nullabilityQualifierWithMigrationStatus.isForWarningOnly;
        }
        return nullabilityQualifierWithMigrationStatus.copy(nullabilityQualifier, z11);
    }

    @NotNull
    public final NullabilityQualifierWithMigrationStatus copy(@NotNull NullabilityQualifier nullabilityQualifier, boolean z11) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) obj;
        return this.qualifier == nullabilityQualifierWithMigrationStatus.qualifier && this.isForWarningOnly == nullabilityQualifierWithMigrationStatus.isForWarningOnly;
    }

    @NotNull
    public final NullabilityQualifier getQualifier() {
        return this.qualifier;
    }

    public int hashCode() {
        int hashCode = this.qualifier.hashCode() * 31;
        boolean z11 = this.isForWarningOnly;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isForWarningOnly() {
        return this.isForWarningOnly;
    }

    @NotNull
    public String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.qualifier + ", isForWarningOnly=" + this.isForWarningOnly + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, (i11 & 2) != 0 ? false : z11);
    }
}
