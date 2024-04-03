package com.deliveryhero.fluid.widgets.image.utils;

import android.graphics.Matrix;
import android.widget.ImageView;
import com.deliveryhero.fluid.widgets.image.ImageContentMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\r\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0000¨\u0006\u000f"}, d2 = {"getXTranslation", "", "mode", "Lcom/deliveryhero/fluid/widgets/image/ImageContentMode;", "viewWidth", "", "drawableWidth", "getYTranslation", "viewHeight", "drawableHeight", "setCropContentMode", "", "Landroid/widget/ImageView;", "updateContentMode", "value", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ContentModeUtilsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageContentMode.values().length];
            iArr[ImageContentMode.SCALE_ASPECT_FILL.ordinal()] = 1;
            iArr[ImageContentMode.SCALE_ASPECT_FIT.ordinal()] = 2;
            iArr[ImageContentMode.SCALE_TO_FILL.ordinal()] = 3;
            iArr[ImageContentMode.BOTTOM.ordinal()] = 4;
            iArr[ImageContentMode.BOTTOM_LEFT.ordinal()] = 5;
            iArr[ImageContentMode.BOTTOM_RIGHT.ordinal()] = 6;
            iArr[ImageContentMode.LEFT.ordinal()] = 7;
            iArr[ImageContentMode.RIGHT.ordinal()] = 8;
            iArr[ImageContentMode.CENTER.ordinal()] = 9;
            iArr[ImageContentMode.TOP_RIGHT.ordinal()] = 10;
            iArr[ImageContentMode.TOP.ordinal()] = 11;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final float getXTranslation(ImageContentMode imageContentMode, int i11, int i12) {
        int i13 = WhenMappings.$EnumSwitchMapping$0[imageContentMode.ordinal()];
        if (i13 != 4) {
            if (i13 != 6) {
                switch (i13) {
                    case 8:
                    case 10:
                        break;
                    case 9:
                    case 11:
                        break;
                    default:
                        return 0.0f;
                }
            }
            return (float) (i11 - i12);
        }
        return ((float) (i11 - i12)) / 2.0f;
    }

    private static final float getYTranslation(ImageContentMode imageContentMode, int i11, int i12) {
        switch (WhenMappings.$EnumSwitchMapping$0[imageContentMode.ordinal()]) {
            case 4:
            case 5:
            case 6:
                return (float) (i11 - i12);
            case 7:
            case 8:
            case 9:
                return ((float) (i11 - i12)) / 2.0f;
            default:
                return 0.0f;
        }
    }

    private static final boolean setCropContentMode(ImageView imageView, ImageContentMode imageContentMode) {
        if (imageView.getDrawable() == null) {
            return false;
        }
        int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        if (height <= 0 || width <= 0) {
            return false;
        }
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix(imageView.getImageMatrix());
        matrix.setTranslate(getXTranslation(imageContentMode, width, imageView.getDrawable().getIntrinsicWidth()), getYTranslation(imageContentMode, height, imageView.getDrawable().getIntrinsicHeight()));
        imageView.setImageMatrix(matrix);
        return true;
    }

    public static final boolean updateContentMode(@NotNull ImageView imageView, @NotNull ImageContentMode imageContentMode) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageContentMode, "value");
        int i11 = WhenMappings.$EnumSwitchMapping$0[imageContentMode.ordinal()];
        if (i11 == 1) {
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return true;
        } else if (i11 == 2) {
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return true;
        } else if (i11 != 3) {
            return setCropContentMode(imageView, imageContentMode);
        } else {
            imageView.setAdjustViewBounds(false);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
    }
}
