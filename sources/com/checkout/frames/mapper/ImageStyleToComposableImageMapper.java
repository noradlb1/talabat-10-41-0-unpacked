package com.checkout.frames.mapper;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.style.component.base.ImageStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u00050\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/checkout/frames/mapper/ImageStyleToComposableImageMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/base/ImageStyle;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "()V", "LabelImage", "style", "(Lcom/checkout/frames/style/component/base/ImageStyle;Landroidx/compose/runtime/Composer;I)Lkotlin/Unit;", "map", "from", "(Lcom/checkout/frames/style/component/base/ImageStyle;)Lkotlin/jvm/functions/Function2;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageStyleToComposableImageMapper implements Mapper<ImageStyle, Function2<? super Composer, ? super Integer, ? extends Unit>> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: androidx.compose.ui.graphics.ColorFilter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: kotlin.Unit} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: kotlin.Unit} */
    /* JADX WARNING: type inference failed for: r0v5, types: [androidx.compose.ui.graphics.ColorFilter] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Unit LabelImage(com.checkout.frames.style.component.base.ImageStyle r13, androidx.compose.runtime.Composer r14, int r15) {
        /*
            r12 = this;
            r15 = 816926779(0x30b1503b, float:1.2901248E-9)
            r14.startReplaceableGroup(r15)
            java.lang.Integer r15 = r13.getImage()
            r0 = 0
            if (r15 != 0) goto L_0x000f
            goto L_0x00a3
        L_0x000f:
            int r15 = r15.intValue()
            r1 = 0
            androidx.compose.ui.graphics.painter.Painter r2 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r15, r14, r1)
            androidx.compose.ui.Modifier$Companion r15 = androidx.compose.ui.Modifier.Companion
            r3 = 3
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r15, r0, r1, r3, r0)
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.wrapContentWidth$default(r15, r0, r1, r3, r0)
            com.checkout.frames.model.Padding r3 = r13.getPadding()
            if (r3 == 0) goto L_0x0051
            int r4 = r3.getStart()
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r4)
            int r5 = r3.getTop()
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r5)
            int r6 = r3.getEnd()
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r6)
            int r3 = r3.getBottom()
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.PaddingKt.m489paddingqDBjuR0(r15, r4, r5, r6, r3)
        L_0x0051:
            java.lang.Integer r3 = r13.getHeight()
            if (r3 == 0) goto L_0x0064
            int r3 = r3.intValue()
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r15, r3)
        L_0x0064:
            java.lang.Integer r3 = r13.getWidth()
            if (r3 == 0) goto L_0x0077
            int r3 = r3.intValue()
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r15, r3)
        L_0x0077:
            r4 = r15
            int r15 = com.checkout.frames.R.string.cko_content_description_image
            java.lang.String r3 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r15, r14, r1)
            java.lang.Long r13 = r13.getTinColor()
            if (r13 == 0) goto L_0x0095
            long r0 = r13.longValue()
            androidx.compose.ui.graphics.ColorFilter$Companion r5 = androidx.compose.ui.graphics.ColorFilter.Companion
            long r6 = androidx.compose.ui.graphics.ColorKt.Color((long) r0)
            r8 = 0
            r9 = 2
            r10 = 0
            androidx.compose.ui.graphics.ColorFilter r0 = androidx.compose.ui.graphics.ColorFilter.Companion.m2960tintxETnrds$default(r5, r6, r8, r9, r10)
        L_0x0095:
            r8 = r0
            r5 = 0
            r6 = 0
            r7 = 0
            r10 = 8
            r11 = 56
            r9 = r14
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r2, (java.lang.String) r3, (androidx.compose.ui.Modifier) r4, (androidx.compose.ui.Alignment) r5, (androidx.compose.ui.layout.ContentScale) r6, (float) r7, (androidx.compose.ui.graphics.ColorFilter) r8, (androidx.compose.runtime.Composer) r9, (int) r10, (int) r11)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00a3:
            r14.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.mapper.ImageStyleToComposableImageMapper.LabelImage(com.checkout.frames.style.component.base.ImageStyle, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    @Nullable
    public Function2<Composer, Integer, Unit> map(@Nullable ImageStyle imageStyle) {
        if (imageStyle != null) {
            return ComposableLambdaKt.composableLambdaInstance(-729381658, true, new ImageStyleToComposableImageMapper$map$1$1(this, imageStyle));
        }
        return null;
    }
}
