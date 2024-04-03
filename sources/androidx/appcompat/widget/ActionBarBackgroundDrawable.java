package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final ActionBarContainer f747a;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void getOutline(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f747a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f747a;
        if (actionBarContainer.f751e) {
            Drawable drawable = actionBarContainer.f750d;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f748b;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f747a;
        Drawable drawable3 = actionBarContainer2.f749c;
        if (drawable3 != null && actionBarContainer2.f752f) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        ActionBarContainer actionBarContainer = this.f747a;
        if (!actionBarContainer.f751e) {
            Drawable drawable = actionBarContainer.f748b;
            if (drawable != null) {
                Api21Impl.getOutline(drawable, outline);
            }
        } else if (actionBarContainer.f750d != null) {
            Api21Impl.getOutline(actionBarContainer.f748b, outline);
        }
    }

    public void setAlpha(int i11) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
