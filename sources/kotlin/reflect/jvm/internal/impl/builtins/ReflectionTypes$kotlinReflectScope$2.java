package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public final class ReflectionTypes$kotlinReflectScope$2 extends Lambda implements Function0<MemberScope> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ModuleDescriptor f24460g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectionTypes$kotlinReflectScope$2(ModuleDescriptor moduleDescriptor) {
        super(0);
        this.f24460g = moduleDescriptor;
    }

    @NotNull
    public final MemberScope invoke() {
        return this.f24460g.getPackage(StandardNames.KOTLIN_REFLECT_FQ_NAME).getMemberScope();
    }
}
