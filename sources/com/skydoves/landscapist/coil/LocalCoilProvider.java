package com.skydoves.landscapist.coil;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.Coil;
import coil.ImageLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/skydoves/landscapist/coil/LocalCoilProvider;", "", "()V", "getCoilImageLoader", "Lcoil/ImageLoader;", "(Landroidx/compose/runtime/Composer;I)Lcoil/ImageLoader;", "coil_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LocalCoilProvider {
    @NotNull
    public static final LocalCoilProvider INSTANCE = new LocalCoilProvider();

    private LocalCoilProvider() {
    }

    @NotNull
    @Composable
    public final ImageLoader getCoilImageLoader(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(360463424);
        ImageLoader imageLoader = (ImageLoader) composer.consume(LocalCoilProviderKt.getLocalCoilImageLoader());
        if (imageLoader == null) {
            composer.startReplaceableGroup(360463528);
            imageLoader = Coil.imageLoader((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
        } else {
            composer.startReplaceableGroup(360463475);
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return imageLoader;
    }
}
