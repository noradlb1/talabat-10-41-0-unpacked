package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import org.jetbrains.annotations.NotNull;

public final class PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$14$1 extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f24674g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$14$1(String str) {
        super(1);
        this.f24674g = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "$this$function");
        functionEnhancementBuilder.returns(this.f24674g, PredefinedEnhancementInfoKt.NOT_PLATFORM);
    }
}
