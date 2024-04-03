package com.skydoves.landscapist.palette;

import android.graphics.Bitmap;
import android.util.LruCache;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.palette.graphics.Palette;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import te.a;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/skydoves/landscapist/palette/BitmapPalette;", "", "imageModel", "useCache", "", "interceptor", "Lcom/skydoves/landscapist/palette/PaletteBuilderInterceptor;", "paletteLoadedListener", "Lcom/skydoves/landscapist/palette/PaletteLoadedListener;", "(Ljava/lang/Object;ZLcom/skydoves/landscapist/palette/PaletteBuilderInterceptor;Lcom/skydoves/landscapist/palette/PaletteLoadedListener;)V", "applyImageModel", "generate", "", "bitmap", "Landroid/graphics/Bitmap;", "Companion", "landscapist_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BitmapPalette {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<LruCache<Object, Palette>> cache$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, BitmapPalette$Companion$cache$2.INSTANCE);
    @Nullable
    private Object imageModel;
    @Nullable
    private final PaletteBuilderInterceptor interceptor;
    @Nullable
    private final PaletteLoadedListener paletteLoadedListener;
    private final boolean useCache;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R)\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048@X\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/skydoves/landscapist/palette/BitmapPalette$Companion;", "", "()V", "cache", "Landroid/util/LruCache;", "Landroidx/palette/graphics/Palette;", "getCache$landscapist_release", "()Landroid/util/LruCache;", "cache$delegate", "Lkotlin/Lazy;", "landscapist_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LruCache<Object, Palette> getCache$landscapist_release() {
            return (LruCache) BitmapPalette.cache$delegate.getValue();
        }
    }

    public BitmapPalette() {
        this((Object) null, false, (PaletteBuilderInterceptor) null, (PaletteLoadedListener) null, 15, (DefaultConstructorMarker) null);
    }

    public BitmapPalette(@Nullable Object obj, boolean z11, @Nullable PaletteBuilderInterceptor paletteBuilderInterceptor, @Nullable PaletteLoadedListener paletteLoadedListener2) {
        this.imageModel = obj;
        this.useCache = z11;
        this.interceptor = paletteBuilderInterceptor;
        this.paletteLoadedListener = paletteLoadedListener2;
    }

    /* access modifiers changed from: private */
    /* renamed from: generate$lambda-1  reason: not valid java name */
    public static final void m9407generate$lambda1(BitmapPalette bitmapPalette, Object obj, Palette palette) {
        Intrinsics.checkNotNullParameter(bitmapPalette, "this$0");
        Intrinsics.checkNotNullParameter(obj, "$model");
        if (palette != null) {
            if (bitmapPalette.useCache) {
                Companion.getCache$landscapist_release().put(obj, palette);
            }
            PaletteLoadedListener paletteLoadedListener2 = bitmapPalette.paletteLoadedListener;
            if (paletteLoadedListener2 != null) {
                paletteLoadedListener2.onPaletteLoaded(palette);
            }
        }
    }

    @NotNull
    public final BitmapPalette applyImageModel(@Nullable Object obj) {
        this.imageModel = obj;
        return this;
    }

    public final void generate(@Nullable Bitmap bitmap) {
        Object obj;
        Palette.Builder builder;
        Palette palette;
        if (bitmap != null && (obj = this.imageModel) != null) {
            if (!this.useCache || (palette = Companion.getCache$landscapist_release().get(obj)) == null) {
                PaletteBuilderInterceptor paletteBuilderInterceptor = this.interceptor;
                if (paletteBuilderInterceptor == null) {
                    builder = null;
                } else {
                    builder = paletteBuilderInterceptor.intercept(new Palette.Builder(bitmap));
                }
                if (builder == null) {
                    builder = new Palette.Builder(bitmap);
                }
                builder.generate(new a(this, obj));
                return;
            }
            PaletteLoadedListener paletteLoadedListener2 = this.paletteLoadedListener;
            if (paletteLoadedListener2 != null) {
                paletteLoadedListener2.onPaletteLoaded(palette);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BitmapPalette(Object obj, boolean z11, PaletteBuilderInterceptor paletteBuilderInterceptor, PaletteLoadedListener paletteLoadedListener2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : obj, (i11 & 2) != 0 ? true : z11, (i11 & 4) != 0 ? null : paletteBuilderInterceptor, (i11 & 8) != 0 ? null : paletteLoadedListener2);
    }
}
