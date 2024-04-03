package com.instabug.library.util;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public class DrawableUtils {

    public class a extends LayerDrawable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f52045b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Drawable f52046c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Drawable[] drawableArr, float f11, Drawable drawable) {
            super(drawableArr);
            this.f52045b = f11;
            this.f52046c = drawable;
        }

        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.f52045b, ((float) this.f52046c.getBounds().width()) / 2.0f, ((float) this.f52046c.getBounds().height()) / 2.0f);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public static Drawable getRotateDrawable(Drawable drawable, float f11) {
        return new a(new Drawable[]{drawable}, f11, drawable);
    }

    public static void setColor(View view, int i11) {
        Drawable background = view.getBackground();
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(i11);
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i11);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background).setColor(i11);
        }
    }

    public static void setDrawableTintColor(@Nullable ImageView imageView, int i11) {
        if (imageView != null) {
            imageView.setColorFilter(i11, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
