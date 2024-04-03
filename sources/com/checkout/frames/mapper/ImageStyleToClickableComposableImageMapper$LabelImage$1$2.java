package com.checkout.frames.mapper;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.StringResources_androidKt;
import com.checkout.frames.R;
import com.checkout.frames.model.request.ImageStyleToClickableImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ImageStyleToClickableComposableImageMapper$LabelImage$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Painter $image;
    final /* synthetic */ Ref.ObjectRef<Modifier> $modifier;
    final /* synthetic */ ImageStyleToClickableImageRequest $request;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageStyleToClickableComposableImageMapper$LabelImage$1$2(Ref.ObjectRef<Modifier> objectRef, ImageStyleToClickableImageRequest imageStyleToClickableImageRequest, Painter painter) {
        super(2);
        this.$modifier = objectRef;
        this.$request = imageStyleToClickableImageRequest;
        this.$image = painter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        ColorFilter colorFilter;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Modifier modifier = (Modifier) this.$modifier.element;
            String stringResource = StringResources_androidKt.stringResource(R.string.cko_content_description_image, composer, 0);
            Long tinColor = this.$request.getStyle().getTinColor();
            if (tinColor != null) {
                colorFilter = ColorFilter.Companion.m2960tintxETnrds$default(ColorFilter.Companion, ColorKt.Color(tinColor.longValue()), 0, 2, (Object) null);
            } else {
                colorFilter = null;
            }
            ImageKt.Image(this.$image, stringResource, modifier, (Alignment) null, (ContentScale) null, 0.0f, colorFilter, composer, 8, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
