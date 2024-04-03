package com.talabat;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import buisnessmodels.GEMEngine;
import buisnessmodels.TalabatFormatter;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.geminterfaces.OnGemFooterCallBacks;
import com.talabat.helpers.GlobalDataModel;
import datamodels.Gem;
import java.util.ArrayList;
import ue.f6;

@Instrumented
public class GemFooterMenuLevelView extends Fragment implements View.OnClickListener, TraceFieldInterface {
    private static final StrikethroughSpan STRIKE_THROUGH_SPAN = new StrikethroughSpan();
    private static final int[] colorArray = {R.color.gem_card_1, R.color.gem_card_2, R.color.gem_card_3, R.color.gem_text_purple};
    public Handler C;
    public Runnable F;
    public boolean G;
    public Trace _nr_trace;
    private TextView adMoreitemText;
    private LinearLayout backgroundLayout;
    private ArrayList<Gem> gemOfferArray;
    private OnGemFooterCallBacks mCallback;
    private TextView mTimerText;
    private TextView newPrice;
    private TextView oldPrice;
    /* access modifiers changed from: private */
    public ImageView sandTimer;
    private Button viewCart;

    private void handleGemView(float f11) {
        if (GEMEngine.getInstance() != null) {
            Gem closestGem = GEMEngine.getInstance().closestGem(f11, false);
            if (!(closestGem == null || closestGem.getConditionAmount() == 0.0f)) {
                GEMEngine.getInstance().setEligibleOfferAmount(closestGem.getFlooringGem().getDiscount());
                this.adMoreitemText.setVisibility(0);
                TextView textView = this.adMoreitemText;
                String string = getResources().getString(R.string.add_save_text);
                String replace = string.replace(RichContentLoadTimeRecorder.DELIMETER, "" + TalabatFormatter.getInstance().getFormattedCurrency(closestGem.getConditionAmount() - f11));
                textView.setText(replace.replace("**", "" + TalabatFormatter.getInstance().getFormattedCurrency(closestGem.getDiscount())));
                if (f11 >= GEMEngine.getInstance().getLowestGem().getConditionAmount()) {
                    this.newPrice.setVisibility(0);
                    this.newPrice.setText(TalabatFormatter.getInstance().getFormattedCurrency(f11 - closestGem.getFlooringGem().getDiscount()));
                    TextView textView2 = this.oldPrice;
                    strikeThroughText(10, textView2, textView2.getText().toString());
                    GlobalDataModel.GEMCONSTANTS.isGemRedeemed = false;
                    updateTextColor();
                } else {
                    this.newPrice.setVisibility(8);
                }
            }
            if (closestGem != null && closestGem.isLastOffer()) {
                GEMEngine.getInstance().setEligibleOfferAmount(closestGem.getFlooringGem().getDiscount());
                GlobalDataModel.GEMCONSTANTS.isGemRedeemed = false;
                this.adMoreitemText.setVisibility(8);
                this.newPrice.setVisibility(0);
                this.newPrice.setText(TalabatFormatter.getInstance().getFormattedCurrency(f11 - GEMEngine.getInstance().getLargestGem().getDiscount()));
                TextView textView3 = this.oldPrice;
                strikeThroughText(10, textView3, textView3.getText().toString());
                updateTextColor();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0(View view) {
        OnGemFooterCallBacks onGemFooterCallBacks = this.mCallback;
        if (onGemFooterCallBacks != null) {
            onGemFooterCallBacks.onFragmentHeightObtained(view.getMeasuredHeight());
        }
    }

    private void strikeThroughText(int i11, TextView textView, String str) {
        textView.setText(str, TextView.BufferType.SPANNABLE);
        ((Spannable) textView.getText()).setSpan(STRIKE_THROUGH_SPAN, i11, str.length(), 33);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r1 == 3) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateTextColor() {
        /*
            r4 = this;
            buisnessmodels.GEMEngine r0 = buisnessmodels.GEMEngine.getInstance()
            int r0 = r0.getCurrentGemIndex()
            buisnessmodels.GEMEngine r1 = buisnessmodels.GEMEngine.getInstance()
            int r1 = r1.getGemCount()
            r2 = 2
            if (r0 == r2) goto L_0x0020
            r3 = 3
            if (r0 == r3) goto L_0x001d
            r1 = 4
            if (r0 == r1) goto L_0x001b
            r2 = 0
            goto L_0x0021
        L_0x001b:
            r2 = r3
            goto L_0x0021
        L_0x001d:
            if (r1 != r3) goto L_0x0021
            goto L_0x001b
        L_0x0020:
            r2 = 1
        L_0x0021:
            android.widget.TextView r0 = r4.newPrice
            android.content.res.Resources r1 = r4.getResources()
            int[] r3 = colorArray
            r2 = r3[r2]
            int r1 = r1.getColor(r2)
            r0.setTextColor(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.GemFooterMenuLevelView.updateTextColor():void");
    }

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
        try {
            this.mCallback = (OnGemFooterCallBacks) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnGemFooterCallBacks");
        }
    }

    public void onClick(View view) {
        this.mCallback.onViewCartClicked();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GemFooterMenuLevelView#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GemFooterMenuLevelView#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.gem_menu_level_footer, (ViewGroup) null);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroy() {
        stopTimer();
        super.onDestroy();
    }

    public void onDetach() {
        this.mCallback = null;
        super.onDetach();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mTimerText = (TextView) view.findViewById(R.id.timer_text_gem);
        this.sandTimer = (ImageView) view.findViewById(R.id.sand_timer);
        this.oldPrice = (TextView) view.findViewById(R.id.old_price_gem);
        this.newPrice = (TextView) view.findViewById(R.id.new_price_gem);
        this.adMoreitemText = (TextView) view.findViewById(R.id.addmore_item_gem);
        this.viewCart = (Button) view.findViewById(R.id.go_to_view_cart);
        this.backgroundLayout = (LinearLayout) view.findViewById(R.id.offer_bg);
        this.viewCart.setOnClickListener(this);
        startTimer();
        this.mCallback.onFragmentLoaded(getArguments().getBoolean("isMinOrderPassed"), getArguments().getString("balance"));
        view.post(new f6(this, view));
    }

    public void setGemOfferArray() {
        this.gemOfferArray = new ArrayList<>();
        if (GEMEngine.getInstance() != null) {
            this.gemOfferArray = GEMEngine.getInstance().getGems();
        }
    }

    public void setMinimumOrderPassedView(float f11) {
        this.oldPrice.setText(getResources().getString(R.string.subtotal_mony_currency).replace(RichContentLoadTimeRecorder.DELIMETER, TalabatFormatter.getInstance().getFormattedCurrency(f11)));
        this.viewCart.setText(getResources().getString(R.string.view_cart).toUpperCase());
        handleGemView(f11);
        this.viewCart.setCompoundDrawablePadding((int) getResources().getDimension(R.dimen.view_cart_button_bounds));
    }

    public void setTimerText(String str) {
        this.mTimerText.setText(str);
    }

    public void setUnderMinimumOrder(float f11, String str) {
        this.oldPrice.setText(getResources().getString(R.string.subtotal_mony_currency).replace(RichContentLoadTimeRecorder.DELIMETER, TalabatFormatter.getInstance().getFormattedCurrency(f11)));
        this.viewCart.setText(getResources().getString(R.string.view_cart).toUpperCase());
        handleGemView(f11);
        this.viewCart.setCompoundDrawablePadding((int) getResources().getDimension(R.dimen.view_cart_button_bounds));
    }

    public void startTimer() {
        initialiseTimer();
        this.G = false;
        this.C = new Handler();
        AnonymousClass1 r02 = new Runnable() {
            public void run() {
                if (GemFooterMenuLevelView.this.sandTimer != null) {
                    GemFooterMenuLevelView gemFooterMenuLevelView = GemFooterMenuLevelView.this;
                    if (!gemFooterMenuLevelView.G) {
                        gemFooterMenuLevelView.createRotateAnimator(gemFooterMenuLevelView.sandTimer, 0.0f, 180.0f).start();
                        GemFooterMenuLevelView.this.G = true;
                    } else {
                        gemFooterMenuLevelView.createRotateAnimator(gemFooterMenuLevelView.sandTimer, 180.0f, 360.0f).start();
                        GemFooterMenuLevelView.this.G = false;
                    }
                }
                GemFooterMenuLevelView.this.C.postDelayed(this, 1000);
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
        try {
            this.mCallback = (OnGemFooterCallBacks) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnGemFooterCallBacks");
        }
    }
}
