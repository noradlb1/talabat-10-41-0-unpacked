package com.talabat.dialogs;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.ObjectKey;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.ItemDetailsActivity;
import com.talabat.R;
import com.talabat.RestaurantMenuScreenR;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.helpers.Blur;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.helpers.GlideApp;
import datamodels.MenuItem;
import java.util.ArrayList;

@Instrumented
public class MenuImageDialog extends DialogFragment implements TraceFieldInterface {
    public static final String ARG_MENU_ITEM = "ARG_MENU_ITEM";
    public String C;
    public GestureDetector F = new GestureDetector(getActivity(), new GestureListener());
    public FrameLayout G;
    public ImageView H;
    public View I;
    public ProgressBar J;
    public Trace _nr_trace;

    public class GestureListener implements GestureDetector.OnGestureListener {
        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        public class AnimationListener implements Animation.AnimationListener {
            private AnimationListener() {
            }

            public void onAnimationEnd(Animation animation) {
                MenuImageDialog.this.I.clearAnimation();
                MenuImageDialog.this.getDialog().dismiss();
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
            MenuImageDialog.this.I.startAnimation(translateAnimation);
        }

        private void animateBottom() {
            animate(0, 0, 0, Resources.getSystem().getDisplayMetrics().heightPixels);
        }

        private void animateLeft() {
            Log.i(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "1");
            animate(0, Resources.getSystem().getDisplayMetrics().widthPixels * -1, 0, 0);
        }

        private void animateRight() {
            Log.i(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.GPS_MEASUREMENT_2D);
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

    private void setBackGround(View view) {
        ((ImageView) view.findViewById(R.id.iv_background)).setImageDrawable(new BitmapDrawable(getResources(), Blur.fastBlur(Blur.takeScreenShot(getActivity()), 25, getActivity())));
    }

    private void showImage(String str) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(getActivity())) {
            GlideApp.with(getActivity()).clear((View) this.H);
            GlideApp.with(getActivity()).load(str).signature((Key) new ObjectKey(Long.valueOf(System.currentTimeMillis() / 86400000))).centerInside().encodeFormat(Bitmap.CompressFormat.PNG).diskCacheStrategy(DiskCacheStrategy.RESOURCE).skipMemoryCache(false).format(DecodeFormat.PREFER_ARGB_8888).override(displayMetrics.widthPixels, displayMetrics.heightPixels).fitCenter().listener((RequestListener) new RequestListener<Drawable>() {
                public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                    MenuImageDialog.this.H.setImageResource(R.drawable.placeholder);
                    MenuImageDialog.this.J.setVisibility(8);
                    MenuImageDialog.this.H.setVisibility(0);
                    return false;
                }

                public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                    MenuImageDialog.this.J.setVisibility(8);
                    MenuImageDialog.this.H.setVisibility(0);
                    return false;
                }
            }).into(this.H);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "MenuImageDialog#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "MenuImageDialog#onCreateView", (ArrayList<String>) null);
        }
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialogue_maximized_menu_image, viewGroup, false);
        MenuItem menuItem = GlobalDataModel.MENU.menuItem;
        this.J = (ProgressBar) inflate.findViewById(R.id.progress);
        ((TextView) inflate.findViewById(R.id.tv_item_name)).setText(menuItem.f13862name);
        this.C = menuItem.getThumbnail();
        setBackGround(inflate);
        ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuImageDialog.this.getDialog().dismiss();
            }
        });
        this.H = (ImageView) inflate.findViewById(R.id.iv_item_image);
        showImage(this.C);
        this.G = (FrameLayout) inflate.findViewById(R.id.fl_image);
        inflate.findViewById(R.id.ll_touchable).setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                GestureDetector gestureDetector = MenuImageDialog.this.F;
                if (gestureDetector != null) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
        this.H.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                GestureDetector gestureDetector = MenuImageDialog.this.F;
                if (gestureDetector != null) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        });
        this.I = inflate.findViewById(R.id.ll_container);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (getActivity() instanceof ItemDetailsActivity) {
            ((ItemDetailsActivity) getActivity()).onDialogDismiss();
        } else {
            boolean z11 = getActivity() instanceof RestaurantMenuScreenR;
        }
    }

    public void onResume() {
        super.onResume();
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getActivity(), R.color.menu_image_background)));
        }
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
