package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.R;

class CircleImageView extends ImageView {
    private static final int DEFAULT_BACKGROUND_COLOR = -328966;
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private int mBackgroundColor;
    private Animation.AnimationListener mListener;
    private int mShadowRadius;

    public static class OvalShadow extends OvalShape {
        private CircleImageView mCircleImageView;
        private Paint mShadowPaint = new Paint();
        private int mShadowRadius;

        public OvalShadow(CircleImageView circleImageView, int i11) {
            this.mCircleImageView = circleImageView;
            this.mShadowRadius = i11;
            updateRadialGradient((int) rect().width());
        }

        private void updateRadialGradient(int i11) {
            float f11 = (float) (i11 / 2);
            this.mShadowPaint.setShader(new RadialGradient(f11, f11, (float) this.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP));
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.mCircleImageView.getWidth() / 2;
            float f11 = (float) width;
            float height = (float) (this.mCircleImageView.getHeight() / 2);
            canvas.drawCircle(f11, height, f11, this.mShadowPaint);
            canvas.drawCircle(f11, height, (float) (width - this.mShadowRadius), paint);
        }

        public void onResize(float f11, float f12) {
            super.onResize(f11, f12);
            updateRadialGradient((int) f11);
        }
    }

    public CircleImageView(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f11 = getContext().getResources().getDisplayMetrics().density;
        int i11 = (int) (Y_OFFSET * f11);
        int i12 = (int) (0.0f * f11);
        this.mShadowRadius = (int) (SHADOW_RADIUS * f11);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.SwipeRefreshLayout);
        this.mBackgroundColor = obtainStyledAttributes.getColor(R.styleable.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, DEFAULT_BACKGROUND_COLOR);
        obtainStyledAttributes.recycle();
        if (elevationSupported()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f11 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShadow(this, this.mShadowRadius));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.mShadowRadius, (float) i12, (float) i11, KEY_SHADOW_COLOR);
            int i13 = this.mShadowRadius;
            setPadding(i13, i13, i13, i13);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(this.mBackgroundColor);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    private boolean elevationSupported() {
        return true;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        if (!elevationSupported()) {
            setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i11) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i11);
            this.mBackgroundColor = i11;
        }
    }
}
