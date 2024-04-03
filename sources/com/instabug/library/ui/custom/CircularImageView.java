package com.instabug.library.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.instabug.library.R;

public class CircularImageView extends AppCompatImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 2;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final boolean DEFAULT_BORDER_OVERLAY = false;
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_FILL_COLOR = 0;
    private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    @Nullable
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private final Paint mBitmapPaint;
    @Nullable
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBorderColor;
    private boolean mBorderOverlay;
    private final Paint mBorderPaint;
    private float mBorderRadius;
    private final RectF mBorderRect;
    private int mBorderWidth;
    @Nullable
    private ColorFilter mColorFilter;
    private float mDrawableRadius;
    private final RectF mDrawableRect;
    private int mFillColor;
    private final Paint mFillPaint;
    private boolean mReady;
    private boolean mSetupPending;
    private final Matrix mShaderMatrix;

    public CircularImageView(Context context) {
        super(context);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mFillPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mFillColor = 0;
        init();
    }

    @Nullable
    private Bitmap getBitmapFromDrawable(@Nullable Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(2, 2, BITMAP_CONFIG);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private void init() {
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    private void setup() {
        if (!this.mReady) {
            this.mSetupPending = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.mBitmap == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.mBitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.mBitmapPaint.setAntiAlias(true);
            this.mBitmapPaint.setShader(this.mBitmapShader);
            this.mBorderPaint.setStyle(Paint.Style.STROKE);
            this.mBorderPaint.setAntiAlias(true);
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStrokeWidth((float) this.mBorderWidth);
            this.mFillPaint.setStyle(Paint.Style.FILL);
            this.mFillPaint.setAntiAlias(true);
            this.mFillPaint.setColor(this.mFillColor);
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            this.mBorderRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mBorderRadius = Math.min((this.mBorderRect.height() - ((float) this.mBorderWidth)) / 2.0f, (this.mBorderRect.width() - ((float) this.mBorderWidth)) / 2.0f);
            this.mDrawableRect.set(this.mBorderRect);
            if (!this.mBorderOverlay) {
                RectF rectF = this.mDrawableRect;
                float f11 = (float) this.mBorderWidth;
                rectF.inset(f11, f11);
            }
            this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
            updateShaderMatrix();
            invalidate();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void updateShaderMatrix() {
        float f11;
        float f12;
        this.mShaderMatrix.set((Matrix) null);
        float f13 = 0.0f;
        if (((float) this.mBitmapWidth) * this.mDrawableRect.height() > this.mDrawableRect.width() * ((float) this.mBitmapHeight)) {
            f12 = this.mDrawableRect.height() / ((float) this.mBitmapHeight);
            f11 = (this.mDrawableRect.width() - (((float) this.mBitmapWidth) * f12)) * 0.5f;
        } else {
            f12 = this.mDrawableRect.width() / ((float) this.mBitmapWidth);
            f11 = 0.0f;
            f13 = (this.mDrawableRect.height() - (((float) this.mBitmapHeight) * f12)) * 0.5f;
        }
        this.mShaderMatrix.setScale(f12, f12);
        Matrix matrix = this.mShaderMatrix;
        RectF rectF = this.mDrawableRect;
        matrix.postTranslate(((float) ((int) (f11 + 0.5f))) + rectF.left, ((float) ((int) (f13 + 0.5f))) + rectF.top);
        BitmapShader bitmapShader = this.mBitmapShader;
        if (bitmapShader != null) {
            bitmapShader.setLocalMatrix(this.mShaderMatrix);
        }
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public ImageView.ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public boolean isBorderOverlay() {
        return this.mBorderOverlay;
    }

    public void onDraw(Canvas canvas) {
        if (this.mBitmap != null) {
            if (this.mFillColor != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.mDrawableRadius, this.mFillPaint);
            }
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.mDrawableRadius, this.mBitmapPaint);
            if (this.mBorderWidth != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.mBorderRadius, this.mBorderPaint);
            }
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        setup();
    }

    public void setAdjustViewBounds(boolean z11) {
        if (z11) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int i11) {
        if (i11 != this.mBorderColor) {
            this.mBorderColor = i11;
            this.mBorderPaint.setColor(i11);
            invalidate();
        }
    }

    public void setBorderColorResource(@ColorRes int i11) {
        setBorderColor(getContext().getResources().getColor(i11));
    }

    public void setBorderOverlay(boolean z11) {
        if (z11 != this.mBorderOverlay) {
            this.mBorderOverlay = z11;
            setup();
        }
    }

    public void setBorderWidth(int i11) {
        if (i11 != this.mBorderWidth) {
            this.mBorderWidth = i11;
            setup();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.mColorFilter) {
            this.mColorFilter = colorFilter;
            this.mBitmapPaint.setColorFilter(colorFilter);
            invalidate();
        }
    }

    public void setFillColor(@ColorInt int i11) {
        if (i11 != this.mFillColor) {
            this.mFillColor = i11;
            this.mFillPaint.setColor(i11);
            invalidate();
        }
    }

    public void setFillColorResource(@ColorRes int i11) {
        setFillColor(getContext().getResources().getColor(i11));
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = getBitmapFromDrawable(drawable);
        setup();
    }

    public void setImageResource(@DrawableRes int i11) {
        super.setImageResource(i11);
        this.mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    public void setImageURI(@Nullable Uri uri) {
        Bitmap bitmap;
        super.setImageURI(uri);
        if (uri != null) {
            bitmap = getBitmapFromDrawable(getDrawable());
        } else {
            bitmap = null;
        }
        this.mBitmap = bitmap;
        setup();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != SCALE_TYPE) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mFillPaint = new Paint();
        this.mBorderColor = -16777216;
        this.mBorderWidth = 0;
        this.mFillColor = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i11, 0);
        this.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_ibg_civ_border_width, 0);
        this.mBorderColor = obtainStyledAttributes.getColor(R.styleable.CircleImageView_ibg_civ_border_color, -16777216);
        this.mBorderOverlay = obtainStyledAttributes.getBoolean(R.styleable.CircleImageView_ibg_civ_border_overlay, false);
        this.mFillColor = obtainStyledAttributes.getColor(R.styleable.CircleImageView_ibg_civ_fill_color, 0);
        obtainStyledAttributes.recycle();
        init();
    }
}
