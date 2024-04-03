package com.deliveryhero.fluid.widgets.lottie;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.widgets.WidgetModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/fluid/widgets/lottie/LottieModel;", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "animationResource", "Lcom/deliveryhero/fluid/expression/Expression;", "", "animationRepeatCount", "Lcom/deliveryhero/fluid/widgets/lottie/RepeatCount;", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getAnimationRepeatCount", "()Lcom/deliveryhero/fluid/expression/Expression;", "getAnimationResource", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LottieModel implements WidgetModel {
    @NotNull
    private final Expression<RepeatCount> animationRepeatCount;
    @NotNull
    private final Expression<String> animationResource;
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;

    public LottieModel(@NotNull Expression<String> expression, @NotNull Expression<RepeatCount> expression2, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, "animationResource");
        Intrinsics.checkNotNullParameter(expression2, "animationRepeatCount");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.animationResource = expression;
        this.animationRepeatCount = expression2;
        this.baseProperties = baseProperties2;
    }

    @NotNull
    public final Expression<RepeatCount> getAnimationRepeatCount() {
        return this.animationRepeatCount;
    }

    @NotNull
    public final Expression<String> getAnimationResource() {
        return this.animationResource;
    }

    @NotNull
    public WidgetModel.BaseProperties getBaseProperties() {
        return this.baseProperties;
    }
}
