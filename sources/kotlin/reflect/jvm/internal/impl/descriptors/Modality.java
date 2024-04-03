package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    @NotNull
    public static final Companion Companion = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Modality convertFromFlags(boolean z11, boolean z12, boolean z13) {
            if (z11) {
                return Modality.SEALED;
            }
            if (z12) {
                return Modality.ABSTRACT;
            }
            if (z13) {
                return Modality.OPEN;
            }
            return Modality.FINAL;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }
}
