package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRendererImpl$appendTypeProjections$1 extends Lambda implements Function1<TypeProjection, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DescriptorRendererImpl f24782g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$appendTypeProjections$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.f24782g = descriptorRendererImpl;
    }

    @NotNull
    public final CharSequence invoke(@NotNull TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "it");
        if (typeProjection.isStarProjection()) {
            return "*";
        }
        DescriptorRendererImpl descriptorRendererImpl = this.f24782g;
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "it.type");
        String renderType = descriptorRendererImpl.renderType(type);
        if (typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return renderType;
        }
        return typeProjection.getProjectionKind() + ' ' + renderType;
    }
}
