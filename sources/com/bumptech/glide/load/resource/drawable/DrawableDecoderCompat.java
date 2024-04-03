package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i11) {
        return getDrawable(context, context2, i11, (Resources.Theme) null);
    }

    private static Drawable loadDrawableV4(Context context, @DrawableRes int i11, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i11, theme);
    }

    private static Drawable loadDrawableV7(Context context, @DrawableRes int i11, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i11);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i11, @Nullable Resources.Theme theme) {
        return getDrawable(context, context, i11, theme);
    }

    private static Drawable getDrawable(Context context, Context context2, @DrawableRes int i11, @Nullable Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i11, theme);
            }
        } catch (NoClassDefFoundError unused) {
            shouldCallAppCompatResources = false;
        } catch (IllegalStateException e11) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i11);
            }
            throw e11;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i11, theme);
    }
}
