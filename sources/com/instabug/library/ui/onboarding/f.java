package com.instabug.library.ui.onboarding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.view.ViewUtils;

public class f extends InstabugBaseFragment {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f51984a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f51985b;
    @DrawableRes

    /* renamed from: c  reason: collision with root package name */
    private int f51986c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f51987d = false;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static f a(@DrawableRes int i11, @Nullable String str, @Nullable String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("img", i11);
        bundle.putString("title", str);
        bundle.putString("subtitle", str2);
        f fVar = new f();
        fVar.setArguments(bundle);
        return fVar;
    }

    public int i0() {
        return R.layout.ib_core_lyt_onboarding_pager_fragment;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void j0(View view, @Nullable Bundle bundle) {
        TextView textView = (TextView) i(R.id.ib_core_tv_title);
        TextView textView2 = (TextView) i(R.id.ib_core_tv_subtitle);
        ImageView imageView = (ImageView) i(R.id.ib_core_img_onboarding);
        RelativeLayout relativeLayout = (RelativeLayout) i(R.id.ib_core_lyt_onboarding_pager_fragment);
        Context context = getContext();
        if (!(relativeLayout == null || context == null)) {
            if (LocaleUtils.isRTL(InstabugCore.getLocale(context))) {
                relativeLayout.setRotation(180.0f);
            }
            if (this.f51987d) {
                relativeLayout.setPadding(ViewUtils.convertDpToPx(context, 16.0f), ViewUtils.convertDpToPx(context, 24.0f), ViewUtils.convertDpToPx(context, 16.0f), ViewUtils.convertDpToPx(context, 16.0f));
            }
        }
        if (textView != null) {
            textView.setText(this.f51984a);
        }
        if (textView2 != null) {
            textView2.setText(this.f51985b);
        }
        if (imageView != null) {
            try {
                imageView.setImageResource(this.f51986c);
                imageView.setBackgroundColor(SettingsManager.getInstance().getPrimaryColor());
                int i11 = -ViewUtils.convertDpToPx(context, 1.0f);
                imageView.setPadding(i11, i11, i11, i11);
            } catch (Exception unused) {
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f51984a = getArguments().getString("title");
            this.f51985b = getArguments().getString("subtitle");
            this.f51986c = getArguments().getInt("img");
            this.f51987d = getArguments().getBoolean("setLivePadding");
        }
    }

    public static f a(int i11, @Nullable String str, @Nullable String str2, boolean z11) {
        f a11 = a(i11, str, str2);
        if (a11.getArguments() != null) {
            a11.getArguments().putBoolean("setLivePadding", z11);
        }
        return a11;
    }
}
