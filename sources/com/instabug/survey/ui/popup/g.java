package com.instabug.survey.ui.popup;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.instabug.library.Feature;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.survey.R;

public abstract class g {
    private static void a(Activity activity, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.survey_partial_close_btn);
        if (imageView != null) {
            if (AccessibilityUtils.isAccessibilityServiceEnabled()) {
                imageView.setAccessibilityTraversalAfter(imageView.getRootView().getId());
            }
            imageView.setOnClickListener(new d(activity));
        }
    }

    private static void a(@Nullable View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    private static void a(@Nullable Button button, @Nullable Button button2, @Nullable ImageView imageView, AlertDialog alertDialog, @Nullable f fVar) {
        a((View) button, (View.OnClickListener) new a(alertDialog, fVar));
        a((View) button2, (View.OnClickListener) new b(alertDialog, fVar));
        a((View) imageView, (View.OnClickListener) new c(fVar));
    }

    private static void a(Button button, Button button2, AppCompatImageView appCompatImageView) {
        int i11;
        if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
            button.setTextColor(-1);
            button2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            button.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            button2.setBackgroundResource(R.drawable.ib_survey_bg_apprating_negative);
            if (appCompatImageView != null) {
                i11 = R.drawable.ib_ic_survey_apprating_light;
            } else {
                return;
            }
        } else {
            button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            button2.setTextColor(-1);
            button.setBackgroundColor(-1);
            button2.setBackgroundResource(R.drawable.ib_survey_bg_apprating_negative_dark);
            if (appCompatImageView != null) {
                i11 = R.drawable.ib_ic_survey_apprating_dark;
            } else {
                return;
            }
        }
        appCompatImageView.setImageResource(i11);
    }

    private static void a(@Nullable TextView textView, @Nullable String str, @Nullable Button button, @Nullable String str2, @Nullable Button button2, @Nullable String str3) {
        if (!(textView == null || str == null)) {
            textView.setText(str);
        }
        if (!(button == null || str2 == null)) {
            button.setText(str2);
        }
        if (button2 != null && str3 != null) {
            button2.setText(str3);
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public static void b(@NonNull Activity activity, @LayoutRes int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable f fVar) {
        if (!activity.isFinishing()) {
            AlertDialog create = new AlertDialog.Builder(activity, 16973840).create();
            View inflate = activity.getLayoutInflater().inflate(i11, (ViewGroup) null);
            create.setView(inflate);
            create.setCancelable(false);
            TextView textView = (TextView) inflate.findViewById(R.id.instabug_text_view_question);
            Button button = (Button) inflate.findViewById(R.id.ib_survey_btn_yes);
            Button button2 = (Button) inflate.findViewById(R.id.ib_survey_btn_no);
            AppCompatImageView appCompatImageView = (AppCompatImageView) inflate.findViewById(R.id.ib_survey_custom_dialog_illustration);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.survey_partial_close_btn);
            if (!(button == null || button2 == null || appCompatImageView == null)) {
                a(button, button2, appCompatImageView);
            }
            a(textView, str, button, str2, button2, str3);
            a(activity, inflate);
            a(button, button2, imageView, create, fVar);
            InstabugCore.handlePbiFooter(inflate);
            if (InstabugCore.getFeatureState(Feature.WHITE_LABELING) == Feature.State.ENABLED) {
                InstabugCore.handlePbiFooterThemeColor(inflate, R.color.pbi_footer_color_dark, R.color.pbi_footer_color_light);
            }
            create.show();
        }
    }
}
