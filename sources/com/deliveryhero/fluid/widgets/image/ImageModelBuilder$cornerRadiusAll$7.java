package com.deliveryhero.fluid.widgets.image;

import com.deliveryhero.fluid.expression.ExpressionBuilder;
import com.deliveryhero.fluid.expression.literal.LiteralBuilder;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.Shape;
import com.deliveryhero.fluid.values.codecs.scalar.ShapeCodec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/fluid/expression/ExpressionBuilder;", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ImageModelBuilder$cornerRadiusAll$7 extends Lambda implements Function1<ExpressionBuilder<LogicalPixel>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageModelBuilder f30277g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageModelBuilder$cornerRadiusAll$7(ImageModelBuilder imageModelBuilder) {
        super(1);
        this.f30277g = imageModelBuilder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ExpressionBuilder<LogicalPixel>) (ExpressionBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ExpressionBuilder<LogicalPixel> expressionBuilder) {
        if (expressionBuilder != null) {
            this.f30277g.setShape(new LiteralBuilder(ShapeCodec.INSTANCE.encode(Shape.RECT_ROUNDED)));
        }
    }
}
