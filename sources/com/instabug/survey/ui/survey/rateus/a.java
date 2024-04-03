package com.instabug.survey.ui.survey.rateus;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.Colorizer;
import com.instabug.survey.R;
import com.instabug.survey.models.Survey;
import com.instabug.survey.models.b;
import com.instabug.survey.ui.survey.c;
import com.instabug.survey.ui.survey.n;
import org.jetbrains.annotations.NotNull;

public abstract class a extends c {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private TextView f52581i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ImageView f52582j;

    public static b a(Survey survey, n nVar) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("question", survey.getQuestions().get(0));
        bVar.setArguments(bundle);
        bVar.a(nVar);
        return bVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Animation animation, Animation animation2, Animation animation3) {
        ImageView imageView = this.f52582j;
        if (imageView != null) {
            imageView.startAnimation(animation);
        }
        TextView textView = this.f52581i;
        if (textView != null) {
            textView.startAnimation(animation2);
        }
        TextView textView2 = this.I;
        if (textView2 != null) {
            textView2.startAnimation(animation3);
        }
    }

    private void l() {
        if (getContext() != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ib_srv_anim_fade_in_scale);
            Context context = getContext();
            int i11 = R.anim.ib_srv_anim_fly_in;
            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i11);
            Animation loadAnimation3 = AnimationUtils.loadAnimation(getContext(), i11);
            loadAnimation2.setStartOffset(300);
            loadAnimation3.setStartOffset(400);
            TextView textView = this.f52581i;
            if (textView != null) {
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new ae.a(this, loadAnimation, loadAnimation2, loadAnimation3));
            }
        }
    }

    @Nullable
    public String f() {
        b bVar = this.G;
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    public int i0() {
        return R.layout.survey_rate_us_fragment;
    }

    @CallSuper
    public void j0(View view, @Nullable Bundle bundle) {
        Drawable drawable;
        super.j0(view, bundle);
        this.f52581i = (TextView) view.findViewById(R.id.txt_rate_us_title);
        this.I = (TextView) view.findViewById(R.id.txt_rate_us_question);
        ImageView imageView = (ImageView) view.findViewById(R.id.instabug_img_thanks);
        this.f52582j = imageView;
        if (imageView != null) {
            imageView.setColorFilter(o0());
            if (!(getContext() == null || (drawable = ContextCompat.getDrawable(getContext(), R.drawable.ibg_survey_ic_thanks_background)) == null)) {
                imageView.setBackgroundDrawable(n0(drawable));
            }
        }
        TextView textView = this.f52581i;
        if (textView != null) {
            textView.setTextColor(p0());
        }
        l();
    }

    public void k() {
        TextView textView;
        String e11;
        Survey survey = this.L;
        if (survey != null && this.I != null && this.G != null) {
            if (survey.getThankYouTitle() != null) {
                TextView textView2 = this.f52581i;
                if (textView2 != null) {
                    textView2.setText(this.L.getThankYouTitle());
                }
            } else {
                TextView textView3 = this.f52581i;
                if (textView3 != null) {
                    textView3.setText(R.string.instabug_custom_survey_thanks_title);
                }
            }
            if (this.L.getThankYouMessage() != null) {
                textView = this.I;
                e11 = this.L.getThankYouMessage();
            } else if (this.G.e() != null) {
                textView = this.I;
                e11 = this.G.e();
            } else {
                return;
            }
            textView.setText(e11);
        }
    }

    public Drawable n0(Drawable drawable) {
        return Colorizer.getPrimaryColorTintedDrawable(drawable);
    }

    public int o0() {
        return InstabugCore.getPrimaryColor();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (getArguments() != null) {
            this.G = (b) getArguments().getSerializable("question");
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        View i11;
        super.onViewCreated(view, bundle);
        if (AccessibilityUtils.isAccessibilityServiceEnabled() && (i11 = i(R.id.thanks_container_layout)) != null) {
            i11.requestFocus();
        }
    }

    public int p0() {
        return InstabugCore.getPrimaryColor();
    }
}
