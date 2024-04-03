package kotlin.reflect.jvm.internal.impl.descriptors.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaVisibilities {
    @NotNull
    public static final JavaVisibilities INSTANCE = new JavaVisibilities();

    public static final class PackageVisibility extends Visibility {
        @NotNull
        public static final PackageVisibility INSTANCE = new PackageVisibility();

        private PackageVisibility() {
            super("package", false);
        }

        @Nullable
        public Integer compareTo(@NotNull Visibility visibility) {
            Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (this == visibility) {
                return 0;
            }
            if (Visibilities.INSTANCE.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        @NotNull
        public String getInternalDisplayName() {
            return "public/*package*/";
        }

        @NotNull
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    public static final class ProtectedAndPackage extends Visibility {
        @NotNull
        public static final ProtectedAndPackage INSTANCE = new ProtectedAndPackage();

        private ProtectedAndPackage() {
            super("protected_and_package", true);
        }

        @Nullable
        public Integer compareTo(@NotNull Visibility visibility) {
            int i11;
            Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (Intrinsics.areEqual((Object) this, (Object) visibility)) {
                return 0;
            }
            if (visibility == Visibilities.Internal.INSTANCE) {
                return null;
            }
            if (Visibilities.INSTANCE.isPrivate(visibility)) {
                i11 = 1;
            } else {
                i11 = -1;
            }
            return Integer.valueOf(i11);
        }

        @NotNull
        public String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }

        @NotNull
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    public static final class ProtectedStaticVisibility extends Visibility {
        @NotNull
        public static final ProtectedStaticVisibility INSTANCE = new ProtectedStaticVisibility();

        private ProtectedStaticVisibility() {
            super("protected_static", true);
        }

        @NotNull
        public String getInternalDisplayName() {
            return "protected/*protected static*/";
        }

        @NotNull
        public Visibility normalize() {
            return Visibilities.Protected.INSTANCE;
        }
    }

    private JavaVisibilities() {
    }
}
