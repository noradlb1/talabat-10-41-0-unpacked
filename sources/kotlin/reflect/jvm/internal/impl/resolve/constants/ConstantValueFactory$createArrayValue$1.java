package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class ConstantValueFactory$createArrayValue$1 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KotlinType f24804g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstantValueFactory$createArrayValue$1(KotlinType kotlinType) {
        super(1);
        this.f24804g = kotlinType;
    }

    @NotNull
    public final KotlinType invoke(@NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "it");
        return this.f24804g;
    }
}
