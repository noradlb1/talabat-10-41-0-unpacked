package com.instabug.survey.ui.survey.rateus;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.survey.models.Survey;
import com.instabug.survey.settings.c;
import com.instabug.survey.ui.SurveyActivity;

public class b extends a {
    private void a(@NonNull ImageView imageView) {
        int i11;
        if (!AccessibilityUtils.isAccessibilityServiceEnabled()) {
            imageView.setOnClickListener((View.OnClickListener) null);
            i11 = 8;
        } else {
            imageView.setOnClickListener(new ae.b(this));
            i11 = 0;
        }
        imageView.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        SurveyActivity surveyActivity = (SurveyActivity) getActivity();
        if (surveyActivity != null) {
            surveyActivity.b(true);
        }
    }

    public void j0(View view, @Nullable Bundle bundle) {
        Survey survey;
        super.j0(view, bundle);
        ImageView imageView = this.M;
        if (imageView != null) {
            a(imageView);
            RelativeLayout relativeLayout = this.K;
            if (relativeLayout != null && (survey = this.L) != null && !survey.isDismissible()) {
                relativeLayout.setOnTouchListener(this);
                relativeLayout.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.L != null && c.l() && this.L.isAppStoreRatingEnabled()) {
            return super.onTouch(view, motionEvent);
        }
        return true;
    }
}
