package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

public class ImageFilterView extends AppCompatImageView {
    public ViewOutlineProvider F;
    public RectF H;
    public Drawable[] I = new Drawable[2];
    public LayerDrawable J;
    public float K = Float.NaN;
    public float L = Float.NaN;
    public float M = Float.NaN;
    public float N = Float.NaN;
    private Drawable mAltDrawable = null;
    private float mCrossfade = 0.0f;
    private Drawable mDrawable = null;
    private ImageMatrix mImageMatrix = new ImageMatrix();
    private boolean mOverlay = true;
    private Path mPath;
    /* access modifiers changed from: private */
    public float mRound = Float.NaN;
    /* access modifiers changed from: private */
    public float mRoundPercent = 0.0f;

    public static class ImageMatrix {

        /* renamed from: a  reason: collision with root package name */
        public float[] f11057a = new float[20];

        /* renamed from: b  reason: collision with root package name */
        public ColorMatrix f11058b = new ColorMatrix();

        /* renamed from: c  reason: collision with root package name */
        public ColorMatrix f11059c = new ColorMatrix();

        /* renamed from: d  reason: collision with root package name */
        public float f11060d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f11061e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f11062f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f11063g = 1.0f;

        private void brightness(float f11) {
            float[] fArr = this.f11057a;
            fArr[0] = f11;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f11;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f11;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void saturation(float f11) {
            float f12 = 1.0f - f11;
            float f13 = 0.2999f * f12;
            float f14 = 0.587f * f12;
            float f15 = f12 * 0.114f;
            float[] fArr = this.f11057a;
            fArr[0] = f13 + f11;
            fArr[1] = f14;
            fArr[2] = f15;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f13;
            fArr[6] = f14 + f11;
            fArr[7] = f15;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f13;
            fArr[11] = f14;
            fArr[12] = f15 + f11;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void warmth(float f11) {
            float f12;
            float f13;
            float f14;
            if (f11 <= 0.0f) {
                f11 = 0.01f;
            }
            float f15 = (5000.0f / f11) / 100.0f;
            if (f15 > 66.0f) {
                double d11 = (double) (f15 - 60.0f);
                f13 = ((float) Math.pow(d11, -0.13320475816726685d)) * 329.69873f;
                f12 = ((float) Math.pow(d11, 0.07551484555006027d)) * 288.12216f;
            } else {
                f12 = (((float) Math.log((double) f15)) * 99.4708f) - 161.11957f;
                f13 = 255.0f;
            }
            if (f15 >= 66.0f) {
                f14 = 255.0f;
            } else if (f15 > 19.0f) {
                f14 = (((float) Math.log((double) (f15 - 10.0f))) * 138.51773f) - 305.0448f;
            } else {
                f14 = 0.0f;
            }
            float min = Math.min(255.0f, Math.max(f13, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f12, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f14, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log((double) 50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log((double) 40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f11057a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        public void a(ImageView imageView) {
            boolean z11;
            this.f11058b.reset();
            float f11 = this.f11061e;
            boolean z12 = true;
            if (f11 != 1.0f) {
                saturation(f11);
                this.f11058b.set(this.f11057a);
                z11 = true;
            } else {
                z11 = false;
            }
            float f12 = this.f11062f;
            if (f12 != 1.0f) {
                this.f11059c.setScale(f12, f12, f12, 1.0f);
                this.f11058b.postConcat(this.f11059c);
                z11 = true;
            }
            float f13 = this.f11063g;
            if (f13 != 1.0f) {
                warmth(f13);
                this.f11059c.set(this.f11057a);
                this.f11058b.postConcat(this.f11059c);
                z11 = true;
            }
            float f14 = this.f11060d;
            if (f14 != 1.0f) {
                brightness(f14);
                this.f11059c.set(this.f11057a);
                this.f11058b.postConcat(this.f11059c);
            } else {
                z12 = z11;
            }
            if (z12) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f11058b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.mAltDrawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.K));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.L));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.N));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.M));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.mDrawable = drawable;
            if (this.mAltDrawable == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.mDrawable = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.I;
                    Drawable mutate = drawable2.mutate();
                    this.mDrawable = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.I;
            Drawable mutate2 = getDrawable().mutate();
            this.mDrawable = mutate2;
            drawableArr2[0] = mutate2;
            this.I[1] = this.mAltDrawable.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.I);
            this.J = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            if (!this.mOverlay) {
                this.J.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            super.setImageDrawable(this.J);
        }
    }

    private void setMatrix() {
        float f11;
        float f12;
        float f13;
        float f14;
        if (!Float.isNaN(this.K) || !Float.isNaN(this.L) || !Float.isNaN(this.M) || !Float.isNaN(this.N)) {
            float f15 = 0.0f;
            if (Float.isNaN(this.K)) {
                f11 = 0.0f;
            } else {
                f11 = this.K;
            }
            if (Float.isNaN(this.L)) {
                f12 = 0.0f;
            } else {
                f12 = this.L;
            }
            if (Float.isNaN(this.M)) {
                f13 = 1.0f;
            } else {
                f13 = this.M;
            }
            if (!Float.isNaN(this.N)) {
                f15 = this.N;
            }
            Matrix matrix = new Matrix();
            matrix.reset();
            float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
            float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
            float width = (float) getWidth();
            float height = (float) getHeight();
            if (intrinsicWidth * height < intrinsicHeight * width) {
                f14 = width / intrinsicWidth;
            } else {
                f14 = height / intrinsicHeight;
            }
            float f16 = f13 * f14;
            matrix.postScale(f16, f16);
            float f17 = intrinsicWidth * f16;
            float f18 = f16 * intrinsicHeight;
            matrix.postTranslate((((f11 * (width - f17)) + width) - f17) * 0.5f, (((f12 * (height - f18)) + height) - f18) * 0.5f);
            matrix.postRotate(f15, width / 2.0f, height / 2.0f);
            setImageMatrix(matrix);
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private void setOverlay(boolean z11) {
        this.mOverlay = z11;
    }

    private void updateViewMatrix() {
        if (!Float.isNaN(this.K) || !Float.isNaN(this.L) || !Float.isNaN(this.M) || !Float.isNaN(this.N)) {
            setMatrix();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.mImageMatrix.f11060d;
    }

    public float getContrast() {
        return this.mImageMatrix.f11062f;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getImagePanX() {
        return this.K;
    }

    public float getImagePanY() {
        return this.L;
    }

    public float getImageRotate() {
        return this.N;
    }

    public float getImageZoom() {
        return this.M;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.f11061e;
    }

    public float getWarmth() {
        return this.mImageMatrix.f11063g;
    }

    public void layout(int i11, int i12, int i13, int i14) {
        super.layout(i11, i12, i13, i14);
        setMatrix();
    }

    public void setAltImageResource(int i11) {
        Drawable mutate = AppCompatResources.getDrawable(getContext(), i11).mutate();
        this.mAltDrawable = mutate;
        Drawable[] drawableArr = this.I;
        drawableArr[0] = this.mDrawable;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.I);
        this.J = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.mCrossfade);
    }

    public void setBrightness(float f11) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.f11060d = f11;
        imageMatrix.a(this);
    }

    public void setContrast(float f11) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.f11062f = f11;
        imageMatrix.a(this);
    }

    public void setCrossfade(float f11) {
        this.mCrossfade = f11;
        if (this.I != null) {
            if (!this.mOverlay) {
                this.J.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.J.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.J);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mAltDrawable == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.mDrawable = mutate;
        Drawable[] drawableArr = this.I;
        drawableArr[0] = mutate;
        drawableArr[1] = this.mAltDrawable;
        LayerDrawable layerDrawable = new LayerDrawable(this.I);
        this.J = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.mCrossfade);
    }

    public void setImagePanX(float f11) {
        this.K = f11;
        updateViewMatrix();
    }

    public void setImagePanY(float f11) {
        this.L = f11;
        updateViewMatrix();
    }

    public void setImageResource(int i11) {
        if (this.mAltDrawable != null) {
            Drawable mutate = AppCompatResources.getDrawable(getContext(), i11).mutate();
            this.mDrawable = mutate;
            Drawable[] drawableArr = this.I;
            drawableArr[0] = mutate;
            drawableArr[1] = this.mAltDrawable;
            LayerDrawable layerDrawable = new LayerDrawable(this.I);
            this.J = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.mCrossfade);
            return;
        }
        super.setImageResource(i11);
    }

    public void setImageRotate(float f11) {
        this.N = f11;
        updateViewMatrix();
    }

    public void setImageZoom(float f11) {
        this.M = f11;
        updateViewMatrix();
    }

    @RequiresApi(21)
    public void setRound(float f11) {
        boolean z11;
        if (Float.isNaN(f11)) {
            this.mRound = f11;
            float f12 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f12);
            return;
        }
        if (this.mRound != f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mRound = f11;
        if (f11 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.H == null) {
                this.H = new RectF();
            }
            if (this.F == null) {
                AnonymousClass2 r52 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.mRound);
                    }
                };
                this.F = r52;
                setOutlineProvider(r52);
            }
            setClipToOutline(true);
            this.H.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.H;
            float f13 = this.mRound;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f11) {
        boolean z11;
        if (this.mRoundPercent != f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mRoundPercent = f11;
        if (f11 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.H == null) {
                this.H = new RectF();
            }
            if (this.F == null) {
                AnonymousClass1 r62 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = ImageFilterView.this.getWidth();
                        int height = ImageFilterView.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterView.this.mRoundPercent) / 2.0f);
                    }
                };
                this.F = r62;
                setOutlineProvider(r62);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.mRoundPercent) / 2.0f;
            this.H.set(0.0f, 0.0f, (float) width, (float) height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.H, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f11) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.f11061e = f11;
        imageMatrix.a(this);
    }

    public void setWarmth(float f11) {
        ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.f11063g = f11;
        imageMatrix.a(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
