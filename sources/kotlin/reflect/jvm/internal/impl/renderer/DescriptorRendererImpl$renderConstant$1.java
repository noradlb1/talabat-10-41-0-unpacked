package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRendererImpl$renderConstant$1 extends Lambda implements Function1<ConstantValue<?>, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DescriptorRendererImpl f24784g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$renderConstant$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.f24784g = descriptorRendererImpl;
    }

    @NotNull
    public final CharSequence invoke(@NotNull ConstantValue<?> constantValue) {
        Intrinsics.checkNotNullParameter(constantValue, "it");
        return this.f24784g.renderConstant(constantValue);
    }
}
