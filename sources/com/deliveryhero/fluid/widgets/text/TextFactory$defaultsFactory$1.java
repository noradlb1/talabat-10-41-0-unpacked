package com.deliveryhero.fluid.widgets.text;

import android.content.Context;
import android.widget.TextView;
import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.values.Color;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.values.ScalableLogicalPixel;
import com.deliveryhero.fluid.widgets.text.utils.TextAppearanceUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/text/TextModel;", "widget", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFactory$defaultsFactory$1 extends Lambda implements Function1<TextView, TextModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f30284g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextFactory f30285h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFactory$defaultsFactory$1(Context context, TextFactory textFactory) {
        super(1);
        this.f30284g = context;
        this.f30285h = textFactory;
    }

    @NotNull
    public final TextModel invoke(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "widget");
        return new TextModel(new Literal(null), new Literal(null), new Literal(new ResourceTextStyle(TextAppearanceUtilsKt.getDefaultTextAppearanceId(this.f30284g))), new Literal(new Color(textView.getTextColors().getDefaultColor())), new Literal(new ScalableLogicalPixel(14.0f)), new Literal(TextAlignment.TOP_LEADING), new Literal(new LogicalPixel(textView.getLineSpacingExtra() / this.f30284g.getResources().getDisplayMetrics().density)), new Literal(Float.valueOf(textView.getLineSpacingMultiplier())), new Literal(Integer.valueOf(textView.getMaxLines())), new Literal(Integer.valueOf(textView.getMinLines())), new Literal(LineBreakMode.CLIP), this.f30285h.a(textView));
    }
}
