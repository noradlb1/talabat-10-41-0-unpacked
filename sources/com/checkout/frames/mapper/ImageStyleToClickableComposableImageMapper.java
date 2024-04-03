package com.checkout.frames.mapper;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.model.request.ImageStyleToClickableImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u00050\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/checkout/frames/mapper/ImageStyleToClickableComposableImageMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/model/request/ImageStyleToClickableImageRequest;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "()V", "LabelImage", "request", "(Lcom/checkout/frames/model/request/ImageStyleToClickableImageRequest;Landroidx/compose/runtime/Composer;I)Lkotlin/Unit;", "map", "from", "(Lcom/checkout/frames/model/request/ImageStyleToClickableImageRequest;)Lkotlin/jvm/functions/Function2;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageStyleToClickableComposableImageMapper implements Mapper<ImageStyleToClickableImageRequest, Function2<? super Composer, ? super Integer, ? extends Unit>> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Unit LabelImage(com.checkout.frames.model.request.ImageStyleToClickableImageRequest r13, androidx.compose.runtime.Composer r14, int r15) {
        /*
            r12 = this;
            r15 = 2015077408(0x781ba420, float:1.2627107E34)
            r14.startReplaceableGroup(r15)
            com.checkout.frames.style.component.base.ImageStyle r15 = r13.getStyle()
            r0 = 0
            if (r15 == 0) goto L_0x0012
            java.lang.Integer r15 = r15.getImage()
            goto L_0x0013
        L_0x0012:
            r15 = r0
        L_0x0013:
            if (r15 != 0) goto L_0x0017
            goto L_0x00e9
        L_0x0017:
            int r15 = r15.intValue()
            r1 = 0
            androidx.compose.ui.graphics.painter.Painter r15 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r15, r14, r1)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r4 = 3
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r3, r0, r1, r4, r0)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentWidth$default(r3, r0, r1, r4, r0)
            r2.element = r0
            com.checkout.frames.style.component.base.ImageStyle r0 = r13.getStyle()
            com.checkout.frames.model.Padding r1 = r0.getPadding()
            if (r1 == 0) goto L_0x006a
            T r3 = r2.element
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            int r4 = r1.getStart()
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r4)
            int r5 = r1.getTop()
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r5)
            int r6 = r1.getEnd()
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r6)
            int r1 = r1.getBottom()
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m489paddingqDBjuR0(r3, r4, r5, r6, r1)
            r2.element = r1
        L_0x006a:
            java.lang.Integer r1 = r0.getHeight()
            if (r1 == 0) goto L_0x0083
            int r1 = r1.intValue()
            T r3 = r2.element
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r3, r1)
            r2.element = r1
        L_0x0083:
            java.lang.Integer r0 = r0.getWidth()
            if (r0 == 0) goto L_0x009c
            int r0 = r0.intValue()
            T r1 = r2.element
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r0 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r1, r0)
            r2.element = r0
        L_0x009c:
            com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper$LabelImage$1$2 r0 = new com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper$LabelImage$1$2
            r0.<init>(r2, r13, r15)
            r15 = -2108599329(0xffffffff825153df, float:-1.5378965E-37)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r15 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r15, r1, r0)
            r0 = 1157296644(0x44faf204, float:2007.563)
            r14.startReplaceableGroup(r0)
            boolean r0 = r14.changed((java.lang.Object) r13)
            java.lang.Object r2 = r14.rememberedValue()
            if (r0 != 0) goto L_0x00c1
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x00c9
        L_0x00c1:
            com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper$LabelImage$1$3$1 r2 = new com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper$LabelImage$1$3$1
            r2.<init>(r13)
            r14.updateRememberedValue(r2)
        L_0x00c9:
            r14.endReplaceableGroup()
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper$LabelImage$1$4 r13 = new com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper$LabelImage$1$4
            r13.<init>(r15)
            r15 = 1675040601(0x63d71759, float:7.9354647E21)
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r15, r1, r13)
            r10 = 196608(0x30000, float:2.75506E-40)
            r11 = 30
            r9 = r14
            androidx.compose.material3.IconButtonKt.IconButton(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x00e9:
            r14.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.mapper.ImageStyleToClickableComposableImageMapper.LabelImage(com.checkout.frames.model.request.ImageStyleToClickableImageRequest, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    @Nullable
    public Function2<Composer, Integer, Unit> map(@Nullable ImageStyleToClickableImageRequest imageStyleToClickableImageRequest) {
        if (imageStyleToClickableImageRequest != null) {
            return ComposableLambdaKt.composableLambdaInstance(1384250234, true, new ImageStyleToClickableComposableImageMapper$map$1$1(this, imageStyleToClickableImageRequest));
        }
        return null;
    }
}
