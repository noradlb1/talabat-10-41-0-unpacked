package com.talabat.dialogs;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.adapters.MenuOffersAdapter;
import com.talabat.helpers.Blur;
import com.talabat.helpers.GlobalDataModel;
import datamodels.OffersItem;
import java.util.ArrayList;

@Instrumented
public class SpecialOffersDialog extends DialogFragment implements TraceFieldInterface {
    public GestureDetector C = new GestureDetector(getActivity(), new GestureListener());
    public FrameLayout F;
    public View G;
    public Trace _nr_trace;
    private ArrayList<OffersItem> mListOffers;
    private RecyclerView mRecyclerViewOffers;

    public class GestureListener implements GestureDetector.OnGestureListener {
        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        public class AnimationListener implements Animation.AnimationListener {
            private AnimationListener() {
            }

            public void onAnimationEnd(Animation animation) {
                SpecialOffersDialog.this.G.clearAnimation();
                SpecialOffersDialog.this.getDialog().dismiss();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        }

        public GestureListener() {
        }

        private void animate(int i11, int i12, int i13, int i14) {
            TranslateAnimation translateAnimation = new TranslateAnimation((float) i11, (float) i12, (float) i13, (float) i14);
            translateAnimation.setAnimationListener(new AnimationListener());
            translateAnimation.setDuration(500);
            SpecialOffersDialog.this.G.startAnimation(translateAnimation);
        }

        private void animateBottom() {
            animate(0, 0, 0, Resources.getSystem().getDisplayMetrics().heightPixels);
        }

        private void animateLeft() {
            animate(0, Resources.getSystem().getDisplayMetrics().widthPixels * -1, 0, 0);
        }

        private void animateRight() {
            animate(0, Resources.getSystem().getDisplayMetrics().widthPixels, 0, 0);
        }

        private void animateTop() {
            animate(0, 0, 0, Resources.getSystem().getDisplayMetrics().heightPixels * -1);
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            if (motionEvent.getX() - motionEvent2.getX() > 120.0f && Math.abs(f12) > 200.0f) {
                animateLeft();
                return false;
            } else if (motionEvent2.getX() - motionEvent.getX() > 120.0f && Math.abs(f12) > 200.0f) {
                animateRight();
                return false;
            } else if (motionEvent.getY() - motionEvent2.getY() > 120.0f && Math.abs(f12) > 200.0f) {
                animateTop();
                return false;
            } else if (motionEvent2.getY() - motionEvent.getY() <= 120.0f || Math.abs(f12) <= 200.0f) {
                return false;
            } else {
                animateBottom();
                return false;
            }
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            return false;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "SpecialOffersDialog#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SpecialOffersDialog#onCreateView", (ArrayList<String>) null);
        }
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.special_offers_dialog_fragment, viewGroup, false);
        ((ImageView) inflate.findViewById(R.id.iv_background)).setImageDrawable(new BitmapDrawable(getResources(), Blur.fastBlur(Blur.takeScreenShot(getActivity()), 25, getActivity())));
        this.mListOffers = GlobalDataModel.OFFERS.offersList;
        Log.i("offcount", this.mListOffers.size() + "");
        this.mRecyclerViewOffers = (RecyclerView) inflate.findViewById(R.id.rcv_offers);
        this.mRecyclerViewOffers.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.mRecyclerViewOffers.setNestedScrollingEnabled(false);
        MenuOffersAdapter menuOffersAdapter = new MenuOffersAdapter(getActivity());
        menuOffersAdapter.setOffers(this.mListOffers);
        this.mRecyclerViewOffers.setAdapter(menuOffersAdapter);
        ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SpecialOffersDialog.this.getDialog().dismiss();
            }
        });
        this.F = (FrameLayout) inflate.findViewById(R.id.fl_image);
        this.G = inflate.findViewById(R.id.ll_container);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getActivity(), R.color.special_offers_background)));
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getDialog().getWindow().setAttributes(attributes);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
