package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {
    protected final T drawable;

    public DrawableResource(T t11) {
        this.drawable = (Drawable) Preconditions.checkNotNull(t11);
    }

    public void initialize() {
        T t11 = this.drawable;
        if (t11 instanceof BitmapDrawable) {
            ((BitmapDrawable) t11).getBitmap().prepareToDraw();
        } else if (t11 instanceof GifDrawable) {
            ((GifDrawable) t11).getFirstFrame().prepareToDraw();
        }
    }

    @NonNull
    public final T get() {
        Drawable.ConstantState constantState = this.drawable.getConstantState();
        if (constantState == null) {
            return this.drawable;
        }
        return constantState.newDrawable();
    }
}
