package com.deliveryhero.fluid.widgets.image;

import com.deliveryhero.fluid.expression.literal.Literal;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/image/ImageModel;", "widget", "Lcom/deliveryhero/fluid/widgets/image/ImageWidget;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ImageFactory$defaultsFactory$1 extends Lambda implements Function1<ImageWidget, ImageModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageFactory f30273g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageFactory$defaultsFactory$1(ImageFactory imageFactory) {
        super(1);
        this.f30273g = imageFactory;
    }

    @NotNull
    public final ImageModel invoke(@NotNull ImageWidget imageWidget) {
        Intrinsics.checkNotNullParameter(imageWidget, "widget");
        ImageLocator.Companion companion = ImageLocator.Companion;
        Literal literal = new Literal(companion.getNULL());
        Literal literal2 = new Literal(companion.getNULL());
        Literal literal3 = new Literal(companion.getNULL());
        Literal literal4 = new Literal(ImageContentMode.SCALE_TO_FILL);
        LogicalPixel.Companion companion2 = LogicalPixel.Companion;
        return new ImageModel(literal, literal2, literal3, literal4, new Literal(companion2.getZERO()), new Literal(companion2.getZERO()), new Literal(companion2.getZERO()), new Literal(companion2.getZERO()), this.f30273g.a(imageWidget));
    }
}
