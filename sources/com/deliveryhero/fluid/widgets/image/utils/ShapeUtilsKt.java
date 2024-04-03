package com.deliveryhero.fluid.widgets.image.utils;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\n\u0010\b\u001a\u00060\u0001j\u0002`\t2\n\u0010\n\u001a\u00060\u0001j\u0002`\t2\n\u0010\u000b\u001a\u00060\u0001j\u0002`\t2\n\u0010\f\u001a\u00060\u0001j\u0002`\tH\u0000\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\r"}, d2 = {"absoluteValue", "", "Lcom/google/android/material/shape/CornerSize;", "getAbsoluteValue", "(Lcom/google/android/material/shape/CornerSize;)F", "updateCornerRadii", "", "Lcom/google/android/material/imageview/ShapeableImageView;", "topLeft", "Lcom/deliveryhero/fluid/values/Pixel;", "topRight", "bottomRight", "bottomLeft", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ShapeUtilsKt {
    private static final float getAbsoluteValue(CornerSize cornerSize) {
        return ((AbsoluteCornerSize) cornerSize).getCornerSize();
    }

    public static final void updateCornerRadii(@NotNull ShapeableImageView shapeableImageView, float f11, float f12, float f13, float f14) {
        boolean z11;
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(shapeableImageView, "<this>");
        CornerSize topLeftCornerSize = shapeableImageView.getShapeAppearanceModel().getTopLeftCornerSize();
        Intrinsics.checkNotNullExpressionValue(topLeftCornerSize, "shapeAppearanceModel.topLeftCornerSize");
        boolean z14 = true;
        if (((AbsoluteCornerSize) topLeftCornerSize).getCornerSize() == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            CornerSize topRightCornerSize = shapeableImageView.getShapeAppearanceModel().getTopRightCornerSize();
            Intrinsics.checkNotNullExpressionValue(topRightCornerSize, "shapeAppearanceModel.topRightCornerSize");
            if (((AbsoluteCornerSize) topRightCornerSize).getCornerSize() == f12) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                CornerSize bottomRightCornerSize = shapeableImageView.getShapeAppearanceModel().getBottomRightCornerSize();
                Intrinsics.checkNotNullExpressionValue(bottomRightCornerSize, "shapeAppearanceModel.bottomRightCornerSize");
                if (((AbsoluteCornerSize) bottomRightCornerSize).getCornerSize() == f13) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    CornerSize bottomLeftCornerSize = shapeableImageView.getShapeAppearanceModel().getBottomLeftCornerSize();
                    Intrinsics.checkNotNullExpressionValue(bottomLeftCornerSize, "shapeAppearanceModel.bottomLeftCornerSize");
                    if (((AbsoluteCornerSize) bottomLeftCornerSize).getCornerSize() != f14) {
                        z14 = false;
                    }
                    if (z14) {
                        return;
                    }
                }
            }
        }
        shapeableImageView.setShapeAppearanceModel(shapeableImageView.getShapeAppearanceModel().toBuilder().setTopLeftCornerSize(f11).setTopRightCornerSize(f12).setBottomRightCornerSize(f13).setBottomLeftCornerSize(f14).build());
    }
}
