package com.talabat;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import buisnessmodels.GEMEngine;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class GemFooterCartView extends Fragment implements TraceFieldInterface {
    public Handler C;
    public Runnable F;
    public Trace _nr_trace;
    private TextView mTimerText;
    /* access modifiers changed from: private */
    public ImageView sandTimer;

    public ObjectAnimator createRotateAnimator(View view, float f11, float f12) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", new float[]{f11, f12});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new LinearInterpolator());
        return ofFloat;
    }

    public void initialiseTimer() {
        Handler handler;
        Runnable runnable = this.F;
        if (!(runnable == null || (handler = this.C) == null)) {
            handler.removeCallbacks(runnable);
        }
        this.C = null;
        this.F = null;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GemFooterCartView#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GemFooterCartView#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.gem_cart_footer, (ViewGroup) null);
        this.mTimerText = (TextView) inflate.findViewById(R.id.timer_text_gem);
        this.sandTimer = (ImageView) inflate.findViewById(R.id.sand_timer);
        startTimer();
        if (GEMEngine.getInstance() != null) {
            setTimerText(GEMEngine.getInstance().getTime());
        }
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroy() {
        stopTimer();
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        if (GEMEngine.getInstance() != null) {
            setTimerText(GEMEngine.getInstance().getTime());
        }
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void setTimerText(String str) {
        this.mTimerText.setText(str);
    }

    public void startTimer() {
        initialiseTimer();
        this.C = new Handler();
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                if (GemFooterCartView.this.sandTimer != null) {
                    GemFooterCartView gemFooterCartView = GemFooterCartView.this;
                    gemFooterCartView.createRotateAnimator(gemFooterCartView.sandTimer, 0.0f, 180.0f).start();
                }
                GemFooterCartView.this.C.postDelayed(this, 1000);
            }
        };
        this.F = r02;
        r02.run();
    }

    public void stopTimer() {
        Handler handler;
        Runnable runnable = this.F;
        if (runnable != null && (handler = this.C) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
}
