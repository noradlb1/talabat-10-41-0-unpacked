package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.NotNull;

public interface DeserializationConfiguration {

    public static final class Default implements DeserializationConfiguration {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        public boolean getAllowUnstableDependencies() {
            return DefaultImpls.getAllowUnstableDependencies(this);
        }

        public boolean getPreserveDeclarationsOrdering() {
            return DefaultImpls.getPreserveDeclarationsOrdering(this);
        }

        public boolean getReportErrorsOnPreReleaseDependencies() {
            return DefaultImpls.getReportErrorsOnPreReleaseDependencies(this);
        }

        public boolean getSkipMetadataVersionCheck() {
            return DefaultImpls.getSkipMetadataVersionCheck(this);
        }

        public boolean getSkipPrereleaseCheck() {
            return DefaultImpls.getSkipPrereleaseCheck(this);
        }

        public boolean getTypeAliasesAllowed() {
            return DefaultImpls.getTypeAliasesAllowed(this);
        }
    }

    public static final class DefaultImpls {
        public static boolean getAllowUnstableDependencies(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getPreserveDeclarationsOrdering(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getReportErrorsOnPreReleaseDependencies(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getSkipMetadataVersionCheck(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getSkipPrereleaseCheck(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return false;
        }

        public static boolean getTypeAliasesAllowed(@NotNull DeserializationConfiguration deserializationConfiguration) {
            return true;
        }
    }

    boolean getAllowUnstableDependencies();

    boolean getPreserveDeclarationsOrdering();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();
}
