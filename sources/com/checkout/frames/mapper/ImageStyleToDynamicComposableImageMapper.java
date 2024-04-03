package com.checkout.frames.mapper;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.request.ImageStyleToDynamicImageRequest;
import com.checkout.frames.style.component.base.ImageStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u00050\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010\tJ \u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/checkout/frames/mapper/ImageStyleToDynamicComposableImageMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/model/request/ImageStyleToDynamicImageRequest;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "()V", "Image", "request", "(Lcom/checkout/frames/model/request/ImageStyleToDynamicImageRequest;Landroidx/compose/runtime/Composer;I)Lkotlin/Unit;", "map", "from", "(Lcom/checkout/frames/model/request/ImageStyleToDynamicImageRequest;)Lkotlin/jvm/functions/Function2;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageStyleToDynamicComposableImageMapper implements Mapper<ImageStyleToDynamicImageRequest, Function2<? super Composer, ? super Integer, ? extends Unit>> {
    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final Unit Image(ImageStyleToDynamicImageRequest imageStyleToDynamicImageRequest, Composer composer, int i11) {
        Integer width;
        Integer height;
        Padding padding;
        composer.startReplaceableGroup(-1943977707);
        Integer num = (Integer) SnapshotStateKt.collectAsState(imageStyleToDynamicImageRequest.getDynamicImageId(), null, (CoroutineContext) null, composer, 56, 2).getValue();
        Unit unit = null;
        if (num != null) {
            Painter painterResource = PainterResources_androidKt.painterResource(num.intValue(), composer, 0);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = SizeKt.wrapContentWidth$default(SizeKt.wrapContentHeight$default(Modifier.Companion, (Alignment.Vertical) null, false, 3, (Object) null), (Alignment.Horizontal) null, false, 3, (Object) null);
            ImageStyle style = imageStyleToDynamicImageRequest.getStyle();
            if (!(style == null || (padding = style.getPadding()) == null)) {
                objectRef.element = PaddingKt.m489paddingqDBjuR0((Modifier) objectRef.element, Dp.m5478constructorimpl((float) padding.getStart()), Dp.m5478constructorimpl((float) padding.getTop()), Dp.m5478constructorimpl((float) padding.getEnd()), Dp.m5478constructorimpl((float) padding.getBottom()));
            }
            ImageStyle style2 = imageStyleToDynamicImageRequest.getStyle();
            if (!(style2 == null || (height = style2.getHeight()) == null)) {
                objectRef.element = SizeKt.m544height3ABfNKs((Modifier) objectRef.element, Dp.m5478constructorimpl((float) height.intValue()));
            }
            ImageStyle style3 = imageStyleToDynamicImageRequest.getStyle();
            if (!(style3 == null || (width = style3.getWidth()) == null)) {
                objectRef.element = SizeKt.m563width3ABfNKs((Modifier) objectRef.element, Dp.m5478constructorimpl((float) width.intValue()));
            }
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -887556482, true, new ImageStyleToDynamicComposableImageMapper$Image$1$1$4(objectRef, imageStyleToDynamicImageRequest, painterResource));
            Function0 function0 = (Function0) SnapshotStateKt.collectAsState(imageStyleToDynamicImageRequest.getOnImageClick(), null, (CoroutineContext) null, composer, 56, 2).getValue();
            composer.startReplaceableGroup(-366940115);
            if (function0 != null) {
                IconButtonKt.IconButton(function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, ComposableLambdaKt.composableLambda(composer, -840289594, true, new ImageStyleToDynamicComposableImageMapper$Image$1$1$5$1(composableLambda)), composer, 196608, 30);
                unit = Unit.INSTANCE;
            }
            composer.endReplaceableGroup();
            if (unit == null) {
                composableLambda.invoke(composer, 0);
            }
            unit = Unit.INSTANCE;
        }
        composer.endReplaceableGroup();
        return unit;
    }

    @NotNull
    public Function2<Composer, Integer, Unit> map(@NotNull ImageStyleToDynamicImageRequest imageStyleToDynamicImageRequest) {
        Intrinsics.checkNotNullParameter(imageStyleToDynamicImageRequest, "from");
        return ComposableLambdaKt.composableLambdaInstance(665823777, true, new ImageStyleToDynamicComposableImageMapper$map$1(this, imageStyleToDynamicImageRequest));
    }
}
