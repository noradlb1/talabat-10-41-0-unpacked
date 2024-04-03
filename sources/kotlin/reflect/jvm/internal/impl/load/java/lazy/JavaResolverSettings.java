package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import org.jetbrains.annotations.NotNull;

public interface JavaResolverSettings {
    @NotNull
    public static final Companion Companion = Companion.f24586a;

    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f24586a = new Companion();

        private Companion() {
        }
    }

    public static final class Default implements JavaResolverSettings {
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        public boolean getCorrectNullabilityForNotNullTypeParameter() {
            return false;
        }

        public boolean getIgnoreNullabilityForErasedValueParameters() {
            return false;
        }

        public boolean getTypeEnhancementImprovementsInStrictMode() {
            return false;
        }
    }

    boolean getCorrectNullabilityForNotNullTypeParameter();

    boolean getIgnoreNullabilityForErasedValueParameters();

    boolean getTypeEnhancementImprovementsInStrictMode();
}
