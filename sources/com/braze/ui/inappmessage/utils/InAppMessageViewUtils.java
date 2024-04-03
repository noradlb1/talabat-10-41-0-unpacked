package com.braze.ui.inappmessage.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.GravityCompat;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0002J\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u0012J2\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0007H\u0007J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0007J\u001a\u0010%\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\f\u001a\u00020\rH\u0007¨\u0006&"}, d2 = {"Lcom/braze/ui/inappmessage/utils/InAppMessageViewUtils;", "", "()V", "closeInAppMessageOnKeycodeBack", "", "resetMessageMarginsIfNecessary", "messageView", "Landroid/widget/TextView;", "headerView", "setDrawableColor", "drawable", "Landroid/graphics/drawable/Drawable;", "color", "", "setDrawableColorFilter", "setFrameColor", "view", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/Integer;)V", "setIcon", "context", "Landroid/content/Context;", "icon", "", "iconColor", "iconBackgroundColor", "textView", "setImage", "bitmap", "Landroid/graphics/Bitmap;", "imageView", "Landroid/widget/ImageView;", "setTextAlignment", "textAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "setTextViewColor", "setViewBackgroundColor", "setViewBackgroundColorFilter", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InAppMessageViewUtils {
    @NotNull
    public static final InAppMessageViewUtils INSTANCE = new InAppMessageViewUtils();

    private InAppMessageViewUtils() {
    }

    @JvmStatic
    public static final void closeInAppMessageOnKeycodeBack() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageViewUtils$closeInAppMessageOnKeycodeBack$1.INSTANCE, 7, (Object) null);
        BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
    }

    @JvmStatic
    public static final void resetMessageMarginsIfNecessary(@Nullable TextView textView, @Nullable TextView textView2) {
        if (textView2 == null && textView != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(textView.getLayoutParams().width, textView.getLayoutParams().height);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
        }
    }

    @JvmStatic
    public static final void setDrawableColor(@NotNull Drawable drawable, @ColorInt int i11) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            if (layerDrawable.getNumberOfLayers() <= 0 || !(layerDrawable.getDrawable(0) instanceof GradientDrawable)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageViewUtils$setDrawableColor$1.INSTANCE, 7, (Object) null);
            } else {
                Drawable drawable2 = layerDrawable.getDrawable(0);
                Intrinsics.checkNotNullExpressionValue(drawable2, "drawable.getDrawable(0)");
                setDrawableColor(drawable2, i11);
            }
        }
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(i11);
        } else {
            INSTANCE.setDrawableColorFilter(drawable, i11);
        }
    }

    private final void setDrawableColorFilter(Drawable drawable, @ColorInt int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            drawable.setColorFilter(new BlendModeColorFilter(i11, BlendMode.SRC_ATOP));
        } else {
            drawable.setColorFilter(i11, PorterDuff.Mode.SRC_ATOP);
        }
    }

    @JvmStatic
    public static final void setFrameColor(@NotNull View view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (num != null) {
            view.setBackgroundColor(num.intValue());
        }
    }

    @JvmStatic
    public static final void setIcon(@NotNull Context context, @Nullable String str, int i11, int i12, @NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textView, "textView");
        if (str != null) {
            try {
                textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf"));
                textView.setText(str);
                setTextViewColor(textView, i11);
                if (textView.getBackground() != null) {
                    Drawable background = textView.getBackground();
                    Intrinsics.checkNotNullExpressionValue(background, "textView.background");
                    setDrawableColor(background, i12);
                    return;
                }
                setViewBackgroundColor(textView, i12);
            } catch (Exception e11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) InAppMessageViewUtils$setIcon$1.INSTANCE, 4, (Object) null);
            }
        }
    }

    @JvmStatic
    public static final void setImage(@Nullable Bitmap bitmap, @NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    @JvmStatic
    public static final void setTextAlignment(@NotNull TextView textView, @NotNull TextAlign textAlign) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(textAlign, TtmlNode.ATTR_TTS_TEXT_ALIGN);
        if (textAlign == TextAlign.START) {
            textView.setGravity(GravityCompat.START);
        } else if (textAlign == TextAlign.END) {
            textView.setGravity(GravityCompat.END);
        } else if (textAlign == TextAlign.CENTER) {
            textView.setGravity(17);
        }
    }

    @JvmStatic
    public static final void setTextViewColor(@NotNull TextView textView, int i11) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        textView.setTextColor(i11);
    }

    @JvmStatic
    public static final void setViewBackgroundColor(@NotNull View view, int i11) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackgroundColor(i11);
    }

    @JvmStatic
    public static final void setViewBackgroundColorFilter(@NotNull View view, @ColorInt int i11) {
        Intrinsics.checkNotNullParameter(view, "view");
        InAppMessageViewUtils inAppMessageViewUtils = INSTANCE;
        Drawable background = view.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "view.background");
        inAppMessageViewUtils.setDrawableColorFilter(background, i11);
        view.getBackground().setAlpha(Color.alpha(i11));
    }
}
