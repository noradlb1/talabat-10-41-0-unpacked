package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltIns$customizer$2 extends Lambda implements Function0<JvmBuiltInsCustomizer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JvmBuiltIns f24466g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ StorageManager f24467h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns$customizer$2(JvmBuiltIns jvmBuiltIns, StorageManager storageManager) {
        super(0);
        this.f24466g = jvmBuiltIns;
        this.f24467h = storageManager;
    }

    @NotNull
    public final JvmBuiltInsCustomizer invoke() {
        ModuleDescriptorImpl builtInsModule = this.f24466g.getBuiltInsModule();
        Intrinsics.checkNotNullExpressionValue(builtInsModule, "builtInsModule");
        StorageManager storageManager = this.f24467h;
        final JvmBuiltIns jvmBuiltIns = this.f24466g;
        return new JvmBuiltInsCustomizer(builtInsModule, storageManager, new Function0<JvmBuiltIns.Settings>() {
            @NotNull
            public final JvmBuiltIns.Settings invoke() {
                Function0 access$getSettingsComputation$p = jvmBuiltIns.settingsComputation;
                if (access$getSettingsComputation$p != null) {
                    JvmBuiltIns.Settings settings = (JvmBuiltIns.Settings) access$getSettingsComputation$p.invoke();
                    jvmBuiltIns.settingsComputation = null;
                    return settings;
                }
                throw new AssertionError("JvmBuiltins instance has not been initialized properly");
            }
        });
    }
}
