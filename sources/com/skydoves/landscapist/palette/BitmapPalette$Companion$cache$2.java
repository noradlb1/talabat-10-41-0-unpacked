package com.skydoves.landscapist.palette;

import android.util.LruCache;
import androidx.palette.graphics.Palette;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, d2 = {"Landroid/util/LruCache;", "", "Landroidx/palette/graphics/Palette;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BitmapPalette$Companion$cache$2 extends Lambda implements Function0<LruCache<Object, Palette>> {
    public static final BitmapPalette$Companion$cache$2 INSTANCE = new BitmapPalette$Companion$cache$2();

    public BitmapPalette$Companion$cache$2() {
        super(0);
    }

    @NotNull
    public final LruCache<Object, Palette> invoke() {
        return new LruCache<>(20);
    }
}
