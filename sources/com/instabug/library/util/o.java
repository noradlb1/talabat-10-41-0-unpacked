package com.instabug.library.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.settings.SettingsManager;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class o {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final o f52079a = new o();

    private o() {
    }

    @JvmStatic
    @JvmName(name = "handlePbiFooter")
    public static final void a(@Nullable View view) {
        if (!f52079a.b() || SettingsManager.getInstance().isCustomBrandingEnabled()) {
            if (view != null) {
                c(view);
            }
        } else if (view != null) {
            b(view);
        }
    }

    @JvmStatic
    private static final void b(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.instabug_pbi_container);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @JvmStatic
    private static final void c(View view) {
        ImageView imageView;
        TextView textView;
        Context context;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.instabug_pbi_container);
        if (linearLayout != null && (imageView = (ImageView) view.findViewById(R.id.image_instabug_logo)) != null && (textView = (TextView) view.findViewById(R.id.text_view_pb)) != null && (context = view.getContext()) != null) {
            linearLayout.setVisibility(0);
            o oVar = f52079a;
            if (!oVar.b()) {
                imageView.setImageResource(R.drawable.ibg_core_ic_instabug_logo);
                textView.setText(LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(context), R.string.instabug_str_powered_by_instabug, context));
            } else if (SettingsManager.getInstance().isCustomBrandingEnabled()) {
                imageView.setImageBitmap(oVar.a());
                textView.setVisibility(8);
            }
        }
    }

    private final boolean b() {
        return InstabugCore.getFeatureState(Feature.WHITE_LABELING) == Feature.State.ENABLED;
    }

    @JvmStatic
    @JvmName(name = "handleThemeColor")
    public static final void a(@Nullable View view, @Nullable @ColorRes Integer num, @Nullable @ColorRes Integer num2) {
        Context context;
        int i11;
        if (!f52079a.b()) {
            if (view == null) {
                context = null;
            } else {
                context = view.getContext();
            }
            if (context != null) {
                if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight && num != null) {
                    i11 = num.intValue();
                } else if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeDark && num2 != null) {
                    i11 = num2.intValue();
                } else {
                    return;
                }
                a(view, ContextCompat.getColor(context, i11));
            }
        }
    }

    @JvmStatic
    @JvmName(name = "setThemeColor")
    public static final void a(@Nullable View view, @ColorInt int i11) {
        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;
        if (!f52079a.b()) {
            if (view == null) {
                linearLayout = null;
            } else {
                linearLayout = (LinearLayout) view.findViewById(R.id.instabug_pbi_container);
            }
            if (linearLayout != null && linearLayout.getVisibility() != 8 && linearLayout.getVisibility() != 4 && (imageView = (ImageView) view.findViewById(R.id.image_instabug_logo)) != null && (textView = (TextView) view.findViewById(R.id.text_view_pb)) != null) {
                imageView.setColorFilter(i11, PorterDuff.Mode.SRC_ATOP);
                textView.setTextColor(i11);
            }
        }
    }

    private final Bitmap a() {
        if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            return SettingsManager.getInstance().getLightCustomBrandingLogo();
        }
        if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeDark) {
            return SettingsManager.getInstance().getDarkCustomBrandingLogo();
        }
        return null;
    }
}
