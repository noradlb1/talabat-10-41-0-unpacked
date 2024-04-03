package com.deliveryhero.fluid.widgets.image;

import com.deliveryhero.fluid.expression.Expression;
import com.deliveryhero.fluid.values.LogicalPixel;
import com.deliveryhero.fluid.widgets.WidgetModel;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B}\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\u0001\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006/"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageModel;", "Lcom/deliveryhero/fluid/widgets/WidgetModel;", "image", "Lcom/deliveryhero/fluid/expression/Expression;", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator;", "loadingPlaceholder", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "errorPlaceholder", "contentMode", "Lcom/deliveryhero/fluid/widgets/image/ImageContentMode;", "cornerRadiusTopLeft", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "cornerRadiusTopRight", "cornerRadiusBottomRight", "cornerRadiusBottomLeft", "baseProperties", "Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "(Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/expression/Expression;Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;)V", "getBaseProperties", "()Lcom/deliveryhero/fluid/widgets/WidgetModel$BaseProperties;", "getContentMode", "()Lcom/deliveryhero/fluid/expression/Expression;", "getCornerRadiusBottomLeft", "getCornerRadiusBottomRight", "getCornerRadiusTopLeft", "getCornerRadiusTopRight", "getErrorPlaceholder", "getImage", "getLoadingPlaceholder", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageModel implements WidgetModel {
    @NotNull
    private final WidgetModel.BaseProperties baseProperties;
    @NotNull
    private final Expression<ImageContentMode> contentMode;
    @NotNull
    private final Expression<LogicalPixel> cornerRadiusBottomLeft;
    @NotNull
    private final Expression<LogicalPixel> cornerRadiusBottomRight;
    @NotNull
    private final Expression<LogicalPixel> cornerRadiusTopLeft;
    @NotNull
    private final Expression<LogicalPixel> cornerRadiusTopRight;
    @NotNull
    private final Expression<ImageLocator.Local> errorPlaceholder;
    @NotNull
    private final Expression<ImageLocator> image;
    @NotNull
    private final Expression<ImageLocator.Local> loadingPlaceholder;

    public ImageModel(@NotNull Expression<ImageLocator> expression, @NotNull Expression<ImageLocator.Local> expression2, @NotNull Expression<ImageLocator.Local> expression3, @NotNull Expression<ImageContentMode> expression4, @NotNull Expression<LogicalPixel> expression5, @NotNull Expression<LogicalPixel> expression6, @NotNull Expression<LogicalPixel> expression7, @NotNull Expression<LogicalPixel> expression8, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, "image");
        Intrinsics.checkNotNullParameter(expression2, "loadingPlaceholder");
        Intrinsics.checkNotNullParameter(expression3, "errorPlaceholder");
        Intrinsics.checkNotNullParameter(expression4, "contentMode");
        Intrinsics.checkNotNullParameter(expression5, "cornerRadiusTopLeft");
        Intrinsics.checkNotNullParameter(expression6, "cornerRadiusTopRight");
        Intrinsics.checkNotNullParameter(expression7, "cornerRadiusBottomRight");
        Intrinsics.checkNotNullParameter(expression8, "cornerRadiusBottomLeft");
        Intrinsics.checkNotNullParameter(baseProperties2, "baseProperties");
        this.image = expression;
        this.loadingPlaceholder = expression2;
        this.errorPlaceholder = expression3;
        this.contentMode = expression4;
        this.cornerRadiusTopLeft = expression5;
        this.cornerRadiusTopRight = expression6;
        this.cornerRadiusBottomRight = expression7;
        this.cornerRadiusBottomLeft = expression8;
        this.baseProperties = baseProperties2;
    }

    public static /* synthetic */ ImageModel copy$default(ImageModel imageModel, Expression expression, Expression expression2, Expression expression3, Expression expression4, Expression expression5, Expression expression6, Expression expression7, Expression expression8, WidgetModel.BaseProperties baseProperties2, int i11, Object obj) {
        ImageModel imageModel2 = imageModel;
        int i12 = i11;
        return imageModel.copy((i12 & 1) != 0 ? imageModel2.image : expression, (i12 & 2) != 0 ? imageModel2.loadingPlaceholder : expression2, (i12 & 4) != 0 ? imageModel2.errorPlaceholder : expression3, (i12 & 8) != 0 ? imageModel2.contentMode : expression4, (i12 & 16) != 0 ? imageModel2.cornerRadiusTopLeft : expression5, (i12 & 32) != 0 ? imageModel2.cornerRadiusTopRight : expression6, (i12 & 64) != 0 ? imageModel2.cornerRadiusBottomRight : expression7, (i12 & 128) != 0 ? imageModel2.cornerRadiusBottomLeft : expression8, (i12 & 256) != 0 ? imageModel.getBaseProperties() : baseProperties2);
    }

    @NotNull
    public final Expression<ImageLocator> component1() {
        return this.image;
    }

    @NotNull
    public final Expression<ImageLocator.Local> component2() {
        return this.loadingPlaceholder;
    }

    @NotNull
    public final Expression<ImageLocator.Local> component3() {
        return this.errorPlaceholder;
    }

    @NotNull
    public final Expression<ImageContentMode> component4() {
        return this.contentMode;
    }

    @NotNull
    public final Expression<LogicalPixel> component5() {
        return this.cornerRadiusTopLeft;
    }

    @NotNull
    public final Expression<LogicalPixel> component6() {
        return this.cornerRadiusTopRight;
    }

    @NotNull
    public final Expression<LogicalPixel> component7() {
        return this.cornerRadiusBottomRight;
    }

    @NotNull
    public final Expression<LogicalPixel> component8() {
        return this.cornerRadiusBottomLeft;
    }

    @NotNull
    public final WidgetModel.BaseProperties component9() {
        return getBaseProperties();
    }

    @NotNull
    public final ImageModel copy(@NotNull Expression<ImageLocator> expression, @NotNull Expression<ImageLocator.Local> expression2, @NotNull Expression<ImageLocator.Local> expression3, @NotNull Expression<ImageContentMode> expression4, @NotNull Expression<LogicalPixel> expression5, @NotNull Expression<LogicalPixel> expression6, @NotNull Expression<LogicalPixel> expression7, @NotNull Expression<LogicalPixel> expression8, @NotNull WidgetModel.BaseProperties baseProperties2) {
        Intrinsics.checkNotNullParameter(expression, "image");
        Intrinsics.checkNotNullParameter(expression2, "loadingPlaceholder");
        Intrinsics.checkNotNullParameter(expression3, "errorPlaceholder");
        Intrinsics.checkNotNullParameter(expression4, "contentMode");
        Expression<LogicalPixel> expression9 = expression5;
        Intrinsics.checkNotNullParameter(expression9, "cornerRadiusTopLeft");
        Expression<LogicalPixel> expression10 = expression6;
        Intrinsics.checkNotNullParameter(expression10, "cornerRadiusTopRight");
        Expression<LogicalPixel> expression11 = expression7;
        Intrinsics.checkNotNullParameter(expression11, "cornerRadiusBottomRight");
        Expression<LogicalPixel> expression12 = expression8;
        Intrinsics.checkNotNullParameter(expression12, "cornerRadiusBottomLeft");
        WidgetModel.BaseProperties baseProperties3 = baseProperties2;
        Intrinsics.checkNotNullParameter(baseProperties3, "baseProperties");
        return new ImageModel(expression, expression2, expression3, expression4, expression9, expression10, expression11, expression12, baseProperties3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageModel)) {
            return false;
        }
        ImageModel imageModel = (ImageModel) obj;
        return Intrinsics.areEqual((Object) this.image, (Object) imageModel.image) && Intrinsics.areEqual((Object) this.loadingPlaceholder, (Object) imageModel.loadingPlaceholder) && Intrinsics.areEqual((Object) this.errorPlaceholder, (Object) imageModel.errorPlaceholder) && Intrinsics.areEqual((Object) this.contentMode, (Object) imageModel.contentMode) && Intrinsics.areEqual((Object) this.cornerRadiusTopLeft, (Object) imageModel.cornerRadiusTopLeft) && Intrinsics.areEqual((Object) this.cornerRadiusTopRight, (Object) imageModel.cornerRadiusTopRight) && Intrinsics.areEqual((Object) this.cornerRadiusBottomRight, (Object) imageModel.cornerRadiusBottomRight) && Intrinsics.areEqual((Object) this.cornerRadiusBottomLeft, (Object) imageModel.cornerRadiusBottomLeft) && Intrinsics.areEqual((Object) getBaseProperties(), (Object) imageModel.getBaseProperties());
    }

    @NotNull
    public WidgetModel.BaseProperties getBaseProperties() {
        return this.baseProperties;
    }

    @NotNull
    public final Expression<ImageContentMode> getContentMode() {
        return this.contentMode;
    }

    @NotNull
    public final Expression<LogicalPixel> getCornerRadiusBottomLeft() {
        return this.cornerRadiusBottomLeft;
    }

    @NotNull
    public final Expression<LogicalPixel> getCornerRadiusBottomRight() {
        return this.cornerRadiusBottomRight;
    }

    @NotNull
    public final Expression<LogicalPixel> getCornerRadiusTopLeft() {
        return this.cornerRadiusTopLeft;
    }

    @NotNull
    public final Expression<LogicalPixel> getCornerRadiusTopRight() {
        return this.cornerRadiusTopRight;
    }

    @NotNull
    public final Expression<ImageLocator.Local> getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    @NotNull
    public final Expression<ImageLocator> getImage() {
        return this.image;
    }

    @NotNull
    public final Expression<ImageLocator.Local> getLoadingPlaceholder() {
        return this.loadingPlaceholder;
    }

    public int hashCode() {
        return (((((((((((((((this.image.hashCode() * 31) + this.loadingPlaceholder.hashCode()) * 31) + this.errorPlaceholder.hashCode()) * 31) + this.contentMode.hashCode()) * 31) + this.cornerRadiusTopLeft.hashCode()) * 31) + this.cornerRadiusTopRight.hashCode()) * 31) + this.cornerRadiusBottomRight.hashCode()) * 31) + this.cornerRadiusBottomLeft.hashCode()) * 31) + getBaseProperties().hashCode();
    }

    @NotNull
    public String toString() {
        return "ImageModel(image=" + this.image + ", loadingPlaceholder=" + this.loadingPlaceholder + ", errorPlaceholder=" + this.errorPlaceholder + ", contentMode=" + this.contentMode + ", cornerRadiusTopLeft=" + this.cornerRadiusTopLeft + ", cornerRadiusTopRight=" + this.cornerRadiusTopRight + ", cornerRadiusBottomRight=" + this.cornerRadiusBottomRight + ", cornerRadiusBottomLeft=" + this.cornerRadiusBottomLeft + ", baseProperties=" + getBaseProperties() + ')';
    }
}
