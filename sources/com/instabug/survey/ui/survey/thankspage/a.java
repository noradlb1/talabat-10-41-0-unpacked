package com.instabug.survey.ui.survey.thankspage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import be.b;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.LocaleUtils;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.n;

public abstract class a extends InstabugBaseFragment implements c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private ImageView f52586a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private TextView f52587b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private TextView f52588c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f52589d;

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        SurveyActivity surveyActivity = (SurveyActivity) getActivity();
        if (surveyActivity != null) {
            surveyActivity.c(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Animation animation, Animation animation2, Animation animation3) {
        ImageView imageView;
        if (this.f52587b != null && (imageView = this.f52586a) != null && this.f52588c != null) {
            imageView.startAnimation(animation);
            this.f52587b.startAnimation(animation2);
            this.f52588c.startAnimation(animation3);
        }
    }

    private void b() {
        if (getActivity() != null && ((SurveyActivity) getActivity()).f() != null && this.f52586a != null && ((SurveyActivity) getActivity()).f() == n.PRIMARY) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f52586a.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 16);
            this.f52586a.setLayoutParams(layoutParams);
        }
    }

    @Nullable
    private Survey f() {
        if (getArguments() != null) {
            return (Survey) getArguments().getSerializable("key_survey");
        }
        return null;
    }

    public static a h(@Nullable Survey survey) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_survey", survey);
        b bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    private void h() {
        TextView textView;
        d dVar = (d) this.C;
        if (dVar == null || f() == null) {
            TextView textView2 = this.f52588c;
            if (textView2 != null) {
                textView2.setText(R.string.instabug_custom_survey_thanks_subtitle);
                return;
            }
            return;
        }
        String a11 = dVar.a(f());
        if (a11 != null && (textView = this.f52588c) != null) {
            textView.setText(a11);
        }
    }

    private void i() {
        TextView textView;
        d dVar = (d) this.C;
        if (dVar == null || f() == null) {
            TextView textView2 = this.f52587b;
            if (textView2 != null) {
                textView2.setText(R.string.instabug_custom_survey_thanks_title);
                return;
            }
            return;
        }
        String b11 = dVar.b(f());
        if (b11 != null && (textView = this.f52587b) != null) {
            textView.setText(b11);
        }
    }

    private void j() {
        if (getContext() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ib_srv_anim_fade_in_scale);
            Context context = getContext();
            int i11 = R.anim.ib_srv_anim_fly_in;
            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i11);
            Animation loadAnimation3 = AnimationUtils.loadAnimation(getContext(), i11);
            loadAnimation2.setStartOffset(300);
            loadAnimation3.setStartOffset(400);
            TextView textView = this.f52587b;
            if (textView != null) {
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new b(this, loadAnimation, loadAnimation2, loadAnimation3));
            }
        }
    }

    public void a() {
        LinearLayout linearLayout;
        if (getContext() != null && (linearLayout = this.f52589d) != null) {
            InstabugCore.handlePbiFooter(linearLayout);
            InstabugCore.handlePbiFooterThemeColor(this.f52589d, R.color.pbi_footer_color_dark, R.color.pbi_footer_color_light);
        }
    }

    public String getLocalizedString(@StringRes int i11) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), i11, getContext());
    }

    public int i0() {
        return R.layout.instabug_survey_fragment_thanks_dialog;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0098, code lost:
        if (r0 != null) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00af, code lost:
        if (r0 != null) goto L_0x00b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j0(android.view.View r4, @androidx.annotation.Nullable android.os.Bundle r5) {
        /*
            r3 = this;
            int r5 = com.instabug.survey.R.id.instabug_img_thanks
            android.view.View r5 = r3.i(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.f52586a = r5
            int r0 = com.instabug.survey.R.id.txt_thanks_title
            android.view.View r0 = r3.i(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3.f52587b = r0
            int r1 = com.instabug.survey.R.id.txtSubTitle
            android.view.View r1 = r3.i(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r3.f52588c = r1
            if (r0 == 0) goto L_0x0152
            if (r5 == 0) goto L_0x0152
            if (r1 != 0) goto L_0x0026
            goto L_0x0152
        L_0x0026:
            int r1 = com.instabug.survey.R.id.survey_partial_close_btn
            android.view.View r1 = r3.i(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0057
            boolean r2 = com.instabug.library.util.AccessibilityUtils.isAccessibilityServiceEnabled()
            if (r2 == 0) goto L_0x0052
            r2 = 0
            r1.setVisibility(r2)
            android.view.View r2 = r1.getRootView()
            int r2 = r2.getId()
            r1.setAccessibilityTraversalAfter(r2)
            r2 = 1
            androidx.core.view.ViewCompat.setImportantForAccessibility(r1, r2)
            be.a r2 = new be.a
            r2.<init>(r3)
            r1.setOnClickListener(r2)
            goto L_0x0057
        L_0x0052:
            r2 = 8
            r1.setVisibility(r2)
        L_0x0057:
            r3.i()
            int r1 = com.instabug.survey.R.id.instabug_pbi_container
            android.view.View r1 = r3.i(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r3.f52589d = r1
            boolean r1 = com.instabug.survey.settings.c.n()
            if (r1 == 0) goto L_0x00c2
            com.instabug.survey.models.Survey r1 = r3.f()
            if (r1 == 0) goto L_0x00c2
            com.instabug.survey.models.Survey r1 = r3.f()
            int r1 = r1.getType()
            r2 = 2
            if (r1 != r2) goto L_0x00c2
            com.instabug.library.InstabugColorTheme r1 = com.instabug.library.core.InstabugCore.getTheme()
            com.instabug.library.InstabugColorTheme r2 = com.instabug.library.InstabugColorTheme.InstabugColorThemeLight
            if (r1 != r2) goto L_0x009b
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setTextColor(r1)
            android.content.Context r0 = r3.getContext()
            if (r0 == 0) goto L_0x00b8
            android.content.Context r0 = r3.getContext()
            int r2 = com.instabug.survey.R.drawable.ic_suvey_vz_custom_thanks_background
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r0, r2)
            if (r0 == 0) goto L_0x00b8
            goto L_0x00b1
        L_0x009b:
            r1 = -1
            r0.setTextColor(r1)
            android.content.Context r0 = r3.getContext()
            if (r0 == 0) goto L_0x00b8
            android.content.Context r0 = r3.getContext()
            int r2 = com.instabug.survey.R.drawable.ic_suvey_vz_custom_thanks_background
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r0, r2)
            if (r0 == 0) goto L_0x00b8
        L_0x00b1:
            android.graphics.drawable.Drawable r0 = com.instabug.library.util.Colorizer.getTintedDrawable(r1, r0)
            r5.setBackgroundDrawable(r0)
        L_0x00b8:
            java.lang.String r0 = "#f5bf56"
            int r0 = android.graphics.Color.parseColor(r0)
            r5.setColorFilter(r0)
            goto L_0x0100
        L_0x00c2:
            r3.h()
            com.instabug.library.InstabugColorTheme r1 = com.instabug.library.core.InstabugCore.getTheme()
            com.instabug.library.InstabugColorTheme r2 = com.instabug.library.InstabugColorTheme.InstabugColorThemeLight
            if (r1 != r2) goto L_0x00d2
            int r1 = r3.o0()
            goto L_0x00dd
        L_0x00d2:
            android.content.Context r1 = r3.requireContext()
            r2 = 17170443(0x106000b, float:2.4611944E-38)
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r2)
        L_0x00dd:
            r0.setTextColor(r1)
            int r0 = r3.n0()
            r5.setColorFilter(r0)
            android.content.Context r0 = r3.getContext()
            if (r0 == 0) goto L_0x0100
            android.content.Context r0 = r3.getContext()
            int r1 = com.instabug.survey.R.drawable.ibg_survey_ic_thanks_background
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.getDrawable(r0, r1)
            if (r0 == 0) goto L_0x0100
            android.graphics.drawable.Drawable r0 = r3.m0(r0)
            r5.setBackgroundDrawable(r0)
        L_0x0100:
            com.instabug.library.core.ui.BaseContract$Presenter r5 = r3.C
            if (r5 == 0) goto L_0x0109
            com.instabug.survey.ui.survey.thankspage.d r5 = (com.instabug.survey.ui.survey.thankspage.d) r5
            r5.a()
        L_0x0109:
            r3.j()
            r3.b()
            boolean r5 = com.instabug.library.util.AccessibilityUtils.isAccessibilityServiceEnabled()
            if (r5 == 0) goto L_0x0152
            android.widget.TextView r5 = r3.f52587b
            if (r5 == 0) goto L_0x0152
            android.widget.TextView r5 = r3.f52588c
            if (r5 == 0) goto L_0x0152
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            android.widget.TextView r0 = r3.f52587b
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x0138
            android.widget.TextView r0 = r3.f52587b
            java.lang.CharSequence r0 = r0.getText()
            r5.append(r0)
            java.lang.String r0 = "\n"
            r5.append(r0)
        L_0x0138:
            android.widget.TextView r0 = r3.f52588c
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x0149
            android.widget.TextView r0 = r3.f52588c
            java.lang.CharSequence r0 = r0.getText()
            r5.append(r0)
        L_0x0149:
            int r0 = r5.length()
            if (r0 <= 0) goto L_0x0152
            r4.setContentDescription(r5)
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.ui.survey.thankspage.a.j0(android.view.View, android.os.Bundle):void");
    }

    public Drawable m0(Drawable drawable) {
        return Colorizer.getPrimaryColorTintedDrawable(drawable);
    }

    public int n0() {
        return InstabugCore.getPrimaryColor();
    }

    public int o0() {
        return InstabugCore.getPrimaryColor();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.C = new d(this);
    }
}
