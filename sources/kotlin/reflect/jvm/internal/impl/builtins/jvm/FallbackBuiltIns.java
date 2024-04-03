package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import org.jetbrains.annotations.NotNull;

final class FallbackBuiltIns extends KotlinBuiltIns {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final KotlinBuiltIns Instance = new FallbackBuiltIns();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KotlinBuiltIns getInstance() {
            return FallbackBuiltIns.Instance;
        }
    }

    private FallbackBuiltIns() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        d(true);
    }

    @NotNull
    /* renamed from: g */
    public PlatformDependentDeclarationFilter.All getPlatformDependentDeclarationFilter() {
        return PlatformDependentDeclarationFilter.All.INSTANCE;
    }
}
