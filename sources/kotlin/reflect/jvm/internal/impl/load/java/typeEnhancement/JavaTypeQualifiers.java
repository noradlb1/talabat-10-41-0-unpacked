package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeQualifiers {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final JavaTypeQualifiers NONE = new JavaTypeQualifiers((NullabilityQualifier) null, (MutabilityQualifier) null, false, false, 8, (DefaultConstructorMarker) null);
    private final boolean definitelyNotNull;
    private final boolean isNullabilityQualifierForWarning;
    @Nullable
    private final MutabilityQualifier mutability;
    @Nullable
    private final NullabilityQualifier nullability;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.NONE;
        }
    }

    public JavaTypeQualifiers(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z11, boolean z12) {
        this.nullability = nullabilityQualifier;
        this.mutability = mutabilityQualifier;
        this.definitelyNotNull = z11;
        this.isNullabilityQualifierForWarning = z12;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    @Nullable
    public final MutabilityQualifier getMutability() {
        return this.mutability;
    }

    @Nullable
    public final NullabilityQualifier getNullability() {
        return this.nullability;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.isNullabilityQualifierForWarning;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, mutabilityQualifier, z11, (i11 & 8) != 0 ? false : z12);
    }
}
