package com.deliveryhero.fluid.widgets.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.deliveryhero.fluid.widgets.image.utils.ContentModeUtilsKt;
import com.google.android.material.imageview.ShapeableImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/image/ImageWidget;", "Lcom/google/android/material/imageview/ShapeableImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Lcom/deliveryhero/fluid/widgets/image/ImageContentMode;", "contentMode", "getContentMode", "()Lcom/deliveryhero/fluid/widgets/image/ImageContentMode;", "setContentMode", "(Lcom/deliveryhero/fluid/widgets/image/ImageContentMode;)V", "onSizeChanged", "", "width", "", "height", "oldWidth", "oldHeight", "setImageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setImageResource", "resId", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ImageWidget extends ShapeableImageView {
    @NotNull
    private ImageContentMode contentMode = ImageContentMode.SCALE_ASPECT_FIT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageWidget(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public final ImageContentMode getContentMode() {
        return this.contentMode;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        ContentModeUtilsKt.updateContentMode(this, this.contentMode);
    }

    public final void setContentMode(@NotNull ImageContentMode imageContentMode) {
        Intrinsics.checkNotNullParameter(imageContentMode, "value");
        if (this.contentMode != imageContentMode) {
            ContentModeUtilsKt.updateContentMode(this, imageContentMode);
            this.contentMode = imageContentMode;
        }
    }

    public void setImageBitmap(@Nullable Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        ContentModeUtilsKt.updateContentMode(this, this.contentMode);
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        ContentModeUtilsKt.updateContentMode(this, this.contentMode);
    }

    public void setImageResource(int i11) {
        super.setImageResource(i11);
        ContentModeUtilsKt.updateContentMode(this, this.contentMode);
    }
}
