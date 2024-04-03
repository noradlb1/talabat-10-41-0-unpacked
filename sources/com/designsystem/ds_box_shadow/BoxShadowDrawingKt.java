package com.designsystem.ds_box_shadow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.DensityKt;
import com.designsystem.transformation.BlurTransformation;
import f0.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0002\u001a2\u0010\u000b\u001a\u00020\t*\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u001a*\u0010\u000b\u001a\u00020\t*\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a1\u0010\u0015\u001a\u00020\t*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a6\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001aF\u0010!\u001a\u0004\u0018\u00010\"*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"PixelsOverBoundaries", "", "blurred", "Landroid/graphics/Bitmap;", "blurTransformation", "Lcom/designsystem/transformation/BlurTransformation;", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "drawBoxShadow", "shadows", "", "Lcom/designsystem/ds_box_shadow/Shadow;", "shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "context", "Landroid/content/Context;", "density", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "setShadowShape", "Landroid/graphics/drawable/GradientDrawable;", "size", "Landroidx/compose/ui/geometry/Size;", "setShadowShape-Ug5Nnss", "(Landroid/graphics/drawable/GradientDrawable;Landroidx/compose/foundation/shape/RoundedCornerShape;FJ)V", "toBlurredBitmap", "Landroid/graphics/drawable/Drawable;", "width", "height", "xOffset", "yOffset", "toShadowBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BoxShadowDrawingKt {
    private static final float PixelsOverBoundaries = 25.0f;

    private static final Bitmap blurred(Bitmap bitmap, BlurTransformation blurTransformation, Function1<? super Canvas, Unit> function1) {
        function1.invoke(new Canvas(bitmap));
        Unit unit = Unit.INSTANCE;
        return blurTransformation.transform(bitmap);
    }

    public static final void drawBoxShadow(@NotNull ContentDrawScope contentDrawScope, @NotNull List<Shadow> list, @NotNull RoundedCornerShape roundedCornerShape, @NotNull Context context) {
        List<Shadow> list2 = list;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        Intrinsics.checkNotNullParameter(list2, "shadows");
        Intrinsics.checkNotNullParameter(roundedCornerShape, "shape");
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Shadow shadow = (Shadow) it.next();
            Iterator it2 = it;
            ImageBitmap shadowBitmap = toShadowBitmap(shadow, Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc()), Size.m2742getHeightimpl(contentDrawScope.m3425getSizeNHjbRc()), roundedCornerShape, contentDrawScope.getDensity(), shadow.getOffset().m8279getXD9Ej5fM() * contentDrawScope.getDensity(), shadow.getOffset().m8280getYD9Ej5fM() * contentDrawScope.getDensity(), new BlurTransformation(context, RangesKt___RangesKt.coerceAtMost(shadow.m8273getBlurRadiusD9Ej5fM() * contentDrawScope.getDensity(), (float) PixelsOverBoundaries), 0.0f, 4, (DefaultConstructorMarker) null));
            if (shadowBitmap != null) {
                contentDrawScope.getDrawContext().getTransform().inset(-25.0f, -25.0f, -25.0f, -25.0f);
                b.A(contentDrawScope, shadowBitmap, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 62, (Object) null);
                contentDrawScope.getDrawContext().getTransform().inset(PixelsOverBoundaries, PixelsOverBoundaries, PixelsOverBoundaries, PixelsOverBoundaries);
            }
            it = it2;
        }
    }

    /* renamed from: setShadowShape-Ug5Nnss  reason: not valid java name */
    private static final void m8267setShadowShapeUg5Nnss(GradientDrawable gradientDrawable, RoundedCornerShape roundedCornerShape, float f11, long j11) {
        if (Intrinsics.areEqual((Object) roundedCornerShape, (Object) RoundedCornerShapeKt.getCircleShape())) {
            gradientDrawable.setShape(1);
            return;
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{roundedCornerShape.getTopStart().m805toPxTmRCtEA(j11, DensityKt.Density$default(f11, 0.0f, 2, (Object) null)), roundedCornerShape.getTopStart().m805toPxTmRCtEA(j11, DensityKt.Density$default(f11, 0.0f, 2, (Object) null)), roundedCornerShape.getTopEnd().m805toPxTmRCtEA(j11, DensityKt.Density$default(f11, 0.0f, 2, (Object) null)), roundedCornerShape.getTopEnd().m805toPxTmRCtEA(j11, DensityKt.Density$default(f11, 0.0f, 2, (Object) null)), roundedCornerShape.getBottomEnd().m805toPxTmRCtEA(j11, DensityKt.Density$default(f11, 0.0f, 2, (Object) null)), roundedCornerShape.getBottomEnd().m805toPxTmRCtEA(j11, DensityKt.Density$default(f11, 0.0f, 2, (Object) null)), roundedCornerShape.getBottomStart().m805toPxTmRCtEA(j11, DensityKt.Density$default(f11, 0.0f, 2, (Object) null)), roundedCornerShape.getBottomStart().m805toPxTmRCtEA(j11, DensityKt.Density$default(f11, 0.0f, 2, (Object) null))});
    }

    private static final Bitmap toBlurredBitmap(Drawable drawable, float f11, float f12, float f13, float f14, BlurTransformation blurTransformation) {
        Bitmap createBitmap = Bitmap.createBitmap((int) ((float) Math.ceil((double) (f11 + f13 + 50.0f))), (int) ((float) Math.ceil((double) (f12 + f14 + 50.0f))), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(realWidth, … Bitmap.Config.ARGB_8888)");
        return blurred(createBitmap, blurTransformation, new BoxShadowDrawingKt$toBlurredBitmap$1(f13, f14, drawable));
    }

    private static final ImageBitmap toShadowBitmap(Shadow shadow, float f11, float f12, RoundedCornerShape roundedCornerShape, float f13, float f14, float f15, BlurTransformation blurTransformation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ColorKt.m2974toArgb8_81llA(shadow.m8274getColor0d7_KjU()));
        int i11 = (int) f11;
        int i12 = (int) f12;
        gradientDrawable.setSize(i11, i12);
        gradientDrawable.setBounds(0, 0, i11, i12);
        m8267setShadowShapeUg5Nnss(gradientDrawable, roundedCornerShape, f13, SizeKt.Size(f11, f12));
        Bitmap blurredBitmap = toBlurredBitmap(gradientDrawable, f11, f12, f14, f15, blurTransformation);
        if (blurredBitmap == null) {
            return null;
        }
        return AndroidImageBitmap_androidKt.asImageBitmap(blurredBitmap);
    }

    public static final void drawBoxShadow(@NotNull Canvas canvas, @NotNull List<Shadow> list, @NotNull RoundedCornerShape roundedCornerShape, @NotNull Context context, float f11) {
        Canvas canvas2 = canvas;
        List<Shadow> list2 = list;
        Intrinsics.checkNotNullParameter(canvas2, "<this>");
        Intrinsics.checkNotNullParameter(list2, "shadows");
        Intrinsics.checkNotNullParameter(roundedCornerShape, "shape");
        Intrinsics.checkNotNullParameter(context, "context");
        for (Shadow shadow : list2) {
            ImageBitmap shadowBitmap = toShadowBitmap(shadow, (float) canvas.getWidth(), (float) canvas.getHeight(), roundedCornerShape, f11, shadow.getOffset().m8279getXD9Ej5fM() * f11, shadow.getOffset().m8280getYD9Ej5fM() * f11, new BlurTransformation(context, RangesKt___RangesKt.coerceAtMost(shadow.m8273getBlurRadiusD9Ej5fM() * f11, (float) PixelsOverBoundaries), 0.0f, 4, (DefaultConstructorMarker) null));
            if (shadowBitmap != null) {
                int save = canvas.save();
                canvas2.translate(-25.0f, -25.0f);
                try {
                    canvas2.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(shadowBitmap), 0.0f, 0.0f, (Paint) null);
                } finally {
                    canvas2.restoreToCount(save);
                }
            }
        }
    }
}
