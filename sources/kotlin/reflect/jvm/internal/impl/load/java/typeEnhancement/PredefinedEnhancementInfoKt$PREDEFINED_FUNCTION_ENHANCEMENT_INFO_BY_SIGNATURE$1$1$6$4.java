package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import org.jetbrains.annotations.NotNull;

public final class PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$4 extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f24698g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$4(String str) {
        super(1);
        this.f24698g = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
        Intrinsics.checkNotNullParameter(functionEnhancementBuilder, "$this$function");
        functionEnhancementBuilder.returns(this.f24698g, PredefinedEnhancementInfoKt.NOT_NULLABLE);
    }
}
