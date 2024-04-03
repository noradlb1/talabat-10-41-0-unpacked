package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        @DoNotInline
        public static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i11) {
            return drawableContainerState.getChild(i11);
        }

        @DoNotInline
        public static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        @DoNotInline
        public static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        @DoNotInline
        public static void e(Drawable drawable, boolean z11) {
            drawable.setAutoMirrored(z11);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        @DoNotInline
        public static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        @DoNotInline
        public static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        @DoNotInline
        public static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        @DoNotInline
        public static void e(Drawable drawable, float f11, float f12) {
            drawable.setHotspot(f11, f12);
        }

        @DoNotInline
        public static void f(Drawable drawable, int i11, int i12, int i13, int i14) {
            drawable.setHotspotBounds(i11, i12, i13, i14);
        }

        @DoNotInline
        public static void g(Drawable drawable, int i11) {
            drawable.setTint(i11);
        }

        @DoNotInline
        public static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        @DoNotInline
        public static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        @DoNotInline
        public static boolean b(Drawable drawable, int i11) {
            return drawable.setLayoutDirection(i11);
        }
    }

    private DrawableCompat() {
    }

    public static void applyTheme(@NonNull Drawable drawable, @NonNull Resources.Theme theme) {
        Api21Impl.a(drawable, theme);
    }

    public static boolean canApplyTheme(@NonNull Drawable drawable) {
        return Api21Impl.b(drawable);
    }

    public static void clearColorFilter(@NonNull Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int getAlpha(@NonNull Drawable drawable) {
        return Api19Impl.a(drawable);
    }

    @Nullable
    public static ColorFilter getColorFilter(@NonNull Drawable drawable) {
        return Api21Impl.c(drawable);
    }

    public static int getLayoutDirection(@NonNull Drawable drawable) {
        return Api23Impl.a(drawable);
    }

    public static void inflate(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Api21Impl.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean isAutoMirrored(@NonNull Drawable drawable) {
        return Api19Impl.d(drawable);
    }

    @Deprecated
    public static void jumpToCurrentState(@NonNull Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void setAutoMirrored(@NonNull Drawable drawable, boolean z11) {
        Api19Impl.e(drawable, z11);
    }

    public static void setHotspot(@NonNull Drawable drawable, float f11, float f12) {
        Api21Impl.e(drawable, f11, f12);
    }

    public static void setHotspotBounds(@NonNull Drawable drawable, int i11, int i12, int i13, int i14) {
        Api21Impl.f(drawable, i11, i12, i13, i14);
    }

    public static boolean setLayoutDirection(@NonNull Drawable drawable, int i11) {
        return Api23Impl.b(drawable, i11);
    }

    public static void setTint(@NonNull Drawable drawable, @ColorInt int i11) {
        Api21Impl.g(drawable, i11);
    }

    public static void setTintList(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        Api21Impl.h(drawable, colorStateList);
    }

    public static void setTintMode(@NonNull Drawable drawable, @Nullable PorterDuff.Mode mode) {
        Api21Impl.i(drawable, mode);
    }

    public static <T extends Drawable> T unwrap(@NonNull Drawable drawable) {
        if (drawable instanceof WrappedDrawable) {
            return ((WrappedDrawable) drawable).getWrappedDrawable();
        }
        return drawable;
    }

    @NonNull
    public static Drawable wrap(@NonNull Drawable drawable) {
        return drawable;
    }
}
