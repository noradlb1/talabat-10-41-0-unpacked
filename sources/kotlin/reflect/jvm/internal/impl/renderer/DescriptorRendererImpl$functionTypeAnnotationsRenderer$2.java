package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRendererImpl$functionTypeAnnotationsRenderer$2 extends Lambda implements Function0<DescriptorRendererImpl> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DescriptorRendererImpl f24783g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(DescriptorRendererImpl descriptorRendererImpl) {
        super(0);
        this.f24783g = descriptorRendererImpl;
    }

    @NotNull
    public final DescriptorRendererImpl invoke() {
        DescriptorRenderer withOptions = this.f24783g.withOptions(AnonymousClass1.INSTANCE);
        Intrinsics.checkNotNull(withOptions, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        return (DescriptorRendererImpl) withOptions;
    }
}
