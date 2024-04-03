package com.skydoves.landscapist.coil;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import coil.ImageLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalCoilImageLoader", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcoil/ImageLoader;", "getLocalCoilImageLoader", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "coil_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LocalCoilProviderKt {
    @NotNull
    private static final ProvidableCompositionLocal<ImageLoader> LocalCoilImageLoader = CompositionLocalKt.staticCompositionLocalOf(LocalCoilProviderKt$LocalCoilImageLoader$1.INSTANCE);

    @NotNull
    public static final ProvidableCompositionLocal<ImageLoader> getLocalCoilImageLoader() {
        return LocalCoilImageLoader;
    }
}
