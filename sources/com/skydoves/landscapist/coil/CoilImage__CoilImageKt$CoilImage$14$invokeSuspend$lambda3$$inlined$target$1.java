package com.skydoves.landscapist.coil;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.core.graphics.drawable.DrawableKt;
import coil.request.ImageRequest;
import coil.target.Target;
import com.skydoves.landscapist.ImageLoadState;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n¸\u0006\u0000"}, d2 = {"coil/request/ImageRequest$Builder$target$4", "Lcoil/target/Target;", "onError", "", "error", "Landroid/graphics/drawable/Drawable;", "onStart", "placeholder", "onSuccess", "result", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: com.skydoves.landscapist.coil.CoilImage__CoilImageKt$CoilImage$14$invokeSuspend$lambda-3$$inlined$target$1  reason: invalid class name */
public final class CoilImage__CoilImageKt$CoilImage$14$invokeSuspend$lambda3$$inlined$target$1 implements Target {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableStateFlow f52990b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MutableStateFlow f52991c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MutableStateFlow f52992d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f52993e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f52994f;

    public CoilImage__CoilImageKt$CoilImage$14$invokeSuspend$lambda3$$inlined$target$1(MutableStateFlow mutableStateFlow, MutableStateFlow mutableStateFlow2, MutableStateFlow mutableStateFlow3, BitmapPalette bitmapPalette, ImageRequest imageRequest) {
        this.f52990b = mutableStateFlow;
        this.f52991c = mutableStateFlow2;
        this.f52992d = mutableStateFlow3;
        this.f52993e = bitmapPalette;
        this.f52994f = imageRequest;
    }

    public void onError(@Nullable Drawable drawable) {
        Bitmap bitmap$default;
        MutableStateFlow mutableStateFlow = this.f52991c;
        ImageBitmap imageBitmap = null;
        if (!(drawable == null || (bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, (Bitmap.Config) null, 7, (Object) null)) == null)) {
            imageBitmap = AndroidImageBitmap_androidKt.asImageBitmap(bitmap$default);
        }
        mutableStateFlow.setValue(new ImageLoadState.Failure(imageBitmap));
    }

    public void onStart(@Nullable Drawable drawable) {
        this.f52990b.setValue(new ImageLoadState.Loading(0.0f));
    }

    public void onSuccess(@NotNull Drawable drawable) {
        BitmapPalette applyImageModel;
        Intrinsics.checkNotNullParameter(drawable, "result");
        this.f52992d.setValue(new ImageLoadState.Success(drawable));
        BitmapPalette bitmapPalette = this.f52993e;
        if (bitmapPalette != null && (applyImageModel = bitmapPalette.applyImageModel(this.f52994f.getData())) != null) {
            applyImageModel.generate(DrawableKt.toBitmap$default(drawable, 0, 0, (Bitmap.Config) null, 7, (Object) null).copy(Bitmap.Config.ARGB_8888, true));
        }
    }
}
