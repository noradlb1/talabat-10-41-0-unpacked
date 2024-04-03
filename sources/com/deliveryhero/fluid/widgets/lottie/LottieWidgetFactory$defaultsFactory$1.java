package com.deliveryhero.fluid.widgets.lottie;

import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.widgets.lottie.RepeatCount;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/lottie/LottieModel;", "widget", "Lcom/deliveryhero/fluid/widgets/lottie/LottieWidget;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LottieWidgetFactory$defaultsFactory$1 extends Lambda implements Function1<LottieWidget, LottieModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieWidgetFactory f30278g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieWidgetFactory$defaultsFactory$1(LottieWidgetFactory lottieWidgetFactory) {
        super(1);
        this.f30278g = lottieWidgetFactory;
    }

    @NotNull
    public final LottieModel invoke(@NotNull LottieWidget lottieWidget) {
        Intrinsics.checkNotNullParameter(lottieWidget, "widget");
        return new LottieModel(new Literal(null), new Literal(new RepeatCount.Finite(0)), this.f30278g.a(lottieWidget));
    }
}
