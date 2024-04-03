package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRendererImpl$renderSuperTypes$1 extends Lambda implements Function1<KotlinType, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DescriptorRendererImpl f24785g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$renderSuperTypes$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.f24785g = descriptorRendererImpl;
    }

    @NotNull
    public final CharSequence invoke(KotlinType kotlinType) {
        DescriptorRendererImpl descriptorRendererImpl = this.f24785g;
        Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
        return descriptorRendererImpl.renderType(kotlinType);
    }
}
