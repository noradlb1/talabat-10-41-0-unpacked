package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;

public final class DefaultBuiltIns extends KotlinBuiltIns {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final DefaultBuiltIns Instance = new DefaultBuiltIns(false, 1, (DefaultConstructorMarker) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.Instance;
        }
    }

    public DefaultBuiltIns() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public DefaultBuiltIns(boolean z11) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z11) {
            d(false);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultBuiltIns(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11);
    }
}
