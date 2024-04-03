package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1 extends Lambda implements Function1<DescriptorRendererOptions, Unit> {
    public static final DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1 INSTANCE = new DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1();

    public DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DescriptorRendererOptions) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, "$this$withOptions");
        descriptorRendererOptions.setWithDefinedIn(false);
        descriptorRendererOptions.setModifiers(SetsKt__SetsKt.emptySet());
        descriptorRendererOptions.setWithoutSuperTypes(true);
    }
}
