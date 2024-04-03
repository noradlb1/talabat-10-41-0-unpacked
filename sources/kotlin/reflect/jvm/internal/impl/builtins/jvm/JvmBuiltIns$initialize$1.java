package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltIns$initialize$1 extends Lambda implements Function0<JvmBuiltIns.Settings> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ModuleDescriptor f24469g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f24470h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JvmBuiltIns$initialize$1(ModuleDescriptor moduleDescriptor, boolean z11) {
        super(0);
        this.f24469g = moduleDescriptor;
        this.f24470h = z11;
    }

    @NotNull
    public final JvmBuiltIns.Settings invoke() {
        return new JvmBuiltIns.Settings(this.f24469g, this.f24470h);
    }
}
