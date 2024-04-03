package com.instabug.survey.ui.survey.welcomepage;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.instabug.library.core.InstabugCore;
import com.instabug.survey.R;
import com.instabug.survey.ui.SurveyActivity;
import com.instabug.survey.ui.gestures.d;
import com.instabug.survey.ui.gestures.e;

public class b extends a implements View.OnTouchListener, d {
    public void b() {
    }

    public void e() {
        if (getActivity() != null && this.G != null) {
            ((SurveyActivity) getActivity()).b(this.G);
        }
    }

    public void i() {
        e();
    }

    public void j0(View view, @Nullable Bundle bundle) {
        super.j0(view, bundle);
        ImageView imageView = (ImageView) i(R.id.survey_partial_close_btn);
        LinearLayout linearLayout = (LinearLayout) i(R.id.instabug_dialog_survey_container);
        if (linearLayout != null) {
            linearLayout.setOnTouchListener(this);
        }
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    public int k0() {
        return InstabugCore.getPrimaryColor();
    }

    public void onClick(View view) {
        super.onClick(view);
        if (view.getId() == R.id.survey_partial_close_btn) {
            i();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        e.a(view, motionEvent, true, true, this);
        return true;
    }
}
