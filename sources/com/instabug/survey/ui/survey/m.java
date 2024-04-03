package com.instabug.survey.ui.survey;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.ui.custom.MaterialMenuDrawable;
import com.instabug.library.util.LocaleHelper;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;

public class m extends l {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ImageView f52565k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ProgressBar f52566l;

    public static m b(Survey survey, boolean z11) {
        Bundle k02 = l.k0(survey, z11);
        m mVar = new m();
        mVar.setArguments(k02);
        return mVar;
    }

    private void j(int i11) {
        ImageView imageView = this.f52565k;
        if (imageView != null) {
            if (i11 != 0 || imageView.getVisibility() == 0) {
                com.instabug.survey.ui.m.b(this.f52565k);
            } else {
                com.instabug.survey.ui.m.a(this.f52565k);
            }
        }
    }

    private void v() {
        ImageView imageView = (ImageView) i(R.id.instabug_ic_survey_close);
        this.f52565k = imageView;
        if (imageView != null && getActivity() != null) {
            MaterialMenuDrawable materialMenuDrawable = new MaterialMenuDrawable(getActivity(), ContextCompat.getColor(getActivity(), 17170443), MaterialMenuDrawable.Stroke.THIN);
            imageView.setImageDrawable(materialMenuDrawable.getCurrent());
            imageView.setOnClickListener(this);
            imageView.setVisibility(4);
            imageView.setContentDescription(getString(R.string.feature_request_go_back));
            if (LocaleHelper.isRTL((Context) getActivity())) {
                materialMenuDrawable.setRTLEnabled(true);
            }
            materialMenuDrawable.setIconState(MaterialMenuDrawable.IconState.ARROW);
        }
    }

    private void w() {
        int i11;
        Resources resources;
        ProgressBar progressBar = (ProgressBar) i(R.id.survey_step_progressbar);
        this.f52566l = progressBar;
        if (progressBar != null) {
            LayerDrawable layerDrawable = (LayerDrawable) progressBar.getProgressDrawable();
            if (InstabugCore.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                resources = getResources();
                i11 = R.drawable.ibg_survey_progressbar_background_light;
            } else {
                resources = getResources();
                i11 = R.drawable.ibg_survey_progressbar_background_dark;
            }
            layerDrawable.setDrawableByLayerId(16908288, resources.getDrawable(i11));
            layerDrawable.getDrawable(1).setColorFilter(InstabugCore.getPrimaryColor(), PorterDuff.Mode.SRC_IN);
            progressBar.setProgressDrawable(layerDrawable);
        }
    }

    public void a(int i11, Survey survey) {
        super.a(i11, survey);
        ImageView imageView = this.f52565k;
        if (imageView != null) {
            if (!survey.isNPSSurvey()) {
                if (!t0()) {
                    u0();
                    imageView.setVisibility(0);
                    return;
                }
            } else if (!survey.isNPSSurvey()) {
                return;
            } else {
                if (!u0()) {
                    if (t0()) {
                        imageView.setVisibility(4);
                        return;
                    } else {
                        j(0);
                        return;
                    }
                }
            }
            j(4);
        }
    }

    public void j() {
        j(4);
    }

    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        v();
        w();
    }

    @VisibleForTesting
    public void m0(int i11, int i12) {
        ProgressBar progressBar = this.f52566l;
        if (progressBar != null) {
            progressBar.setMax(i12 * 100);
            ProgressBar progressBar2 = this.f52566l;
            ObjectAnimator ofInt = ObjectAnimator.ofInt(progressBar2, "progress", new int[]{progressBar2.getProgress(), (i11 + 1) * 100});
            ofInt.setDuration(200);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.start();
        }
    }

    public int q0() {
        return InstabugCore.getPrimaryColor();
    }

    public void s0(int i11) {
        ProgressBar progressBar = this.f52566l;
        if (progressBar != null) {
            progressBar.setVisibility(i11);
        }
    }

    public void u() {
        ImageView imageView = this.f52565k;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public boolean v0() {
        return true;
    }
}
