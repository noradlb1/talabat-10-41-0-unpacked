package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class JvmMetadataVersion extends BinaryVersion {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final JvmMetadataVersion INSTANCE = new JvmMetadataVersion(1, 7, 1);
    @NotNull
    @JvmField
    public static final JvmMetadataVersion INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    private final boolean isStrictSemantics;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(@NotNull int[] iArr, boolean z11) {
        super(Arrays.copyOf(iArr, iArr.length));
        Intrinsics.checkNotNullParameter(iArr, "versionArray");
        this.isStrictSemantics = z11;
    }

    public boolean isCompatible() {
        boolean z11;
        if (getMajor() == 1 && getMinor() == 0) {
            return false;
        }
        if (this.isStrictSemantics) {
            z11 = a(INSTANCE);
        } else {
            int major = getMajor();
            JvmMetadataVersion jvmMetadataVersion = INSTANCE;
            if (major != jvmMetadataVersion.getMajor() || getMinor() > jvmMetadataVersion.getMinor() + 1) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        if (z11) {
            return true;
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JvmMetadataVersion(@NotNull int... iArr) {
        this(iArr, false);
        Intrinsics.checkNotNullParameter(iArr, "numbers");
    }
}
