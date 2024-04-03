package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: b  reason: collision with root package name */
    public ViewOutlineProvider f11049b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f11050c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable[] f11051d = new Drawable[2];

    /* renamed from: e  reason: collision with root package name */
    public LayerDrawable f11052e;
    private Drawable mAltDrawable = null;
    private float mCrossfade = 0.0f;
    private Drawable mDrawable = null;
    private ImageFilterView.ImageMatrix mImageMatrix = new ImageFilterView.ImageMatrix();
    private boolean mOverlay = true;
    private float mPanX = Float.NaN;
    private float mPanY = Float.NaN;
    private Path mPath;
    private float mRotate = Float.NaN;
    /* access modifiers changed from: private */
    public float mRound = Float.NaN;
    /* access modifiers changed from: private */
    public float mRoundPercent = 0.0f;
    private float mZoom = Float.NaN;

    public ImageFilterButton(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
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
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.mPanX));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.mPanY));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.mRotate));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.mZoom));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.mDrawable = drawable;
            if (this.mAltDrawable == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.mDrawable = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f11051d;
                    Drawable mutate = drawable2.mutate();
                    this.mDrawable = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f11051d;
            Drawable mutate2 = getDrawable().mutate();
            this.mDrawable = mutate2;
            drawableArr2[0] = mutate2;
            this.f11051d[1] = this.mAltDrawable.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f11051d);
            this.f11052e = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            if (!this.mOverlay) {
                this.f11052e.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            super.setImageDrawable(this.f11052e);
        }
    }

    private void setMatrix() {
        float f11;
        float f12;
        float f13;
        float f14;
        if (!Float.isNaN(this.mPanX) || !Float.isNaN(this.mPanY) || !Float.isNaN(this.mZoom) || !Float.isNaN(this.mRotate)) {
            float f15 = 0.0f;
            if (Float.isNaN(this.mPanX)) {
                f11 = 0.0f;
            } else {
                f11 = this.mPanX;
            }
            if (Float.isNaN(this.mPanY)) {
                f12 = 0.0f;
            } else {
                f12 = this.mPanY;
            }
            if (Float.isNaN(this.mZoom)) {
                f13 = 1.0f;
            } else {
                f13 = this.mZoom;
            }
            if (!Float.isNaN(this.mRotate)) {
                f15 = this.mRotate;
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
        if (!Float.isNaN(this.mPanX) || !Float.isNaN(this.mPanY) || !Float.isNaN(this.mZoom) || !Float.isNaN(this.mRotate)) {
            setMatrix();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.mImageMatrix.f11062f;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public float getImageZoom() {
        return this.mZoom;
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
        Drawable[] drawableArr = this.f11051d;
        drawableArr[0] = this.mDrawable;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f11051d);
        this.f11052e = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.mCrossfade);
    }

    public void setBrightness(float f11) {
        ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.f11060d = f11;
        imageMatrix.a(this);
    }

    public void setContrast(float f11) {
        ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.f11062f = f11;
        imageMatrix.a(this);
    }

    public void setCrossfade(float f11) {
        this.mCrossfade = f11;
        if (this.f11051d != null) {
            if (!this.mOverlay) {
                this.f11052e.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.f11052e.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.f11052e);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mAltDrawable == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.mDrawable = mutate;
        Drawable[] drawableArr = this.f11051d;
        drawableArr[0] = mutate;
        drawableArr[1] = this.mAltDrawable;
        LayerDrawable layerDrawable = new LayerDrawable(this.f11051d);
        this.f11052e = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.mCrossfade);
    }

    public void setImagePanX(float f11) {
        this.mPanX = f11;
        updateViewMatrix();
    }

    public void setImagePanY(float f11) {
        this.mPanY = f11;
        updateViewMatrix();
    }

    public void setImageResource(int i11) {
        if (this.mAltDrawable != null) {
            Drawable mutate = AppCompatResources.getDrawable(getContext(), i11).mutate();
            this.mDrawable = mutate;
            Drawable[] drawableArr = this.f11051d;
            drawableArr[0] = mutate;
            drawableArr[1] = this.mAltDrawable;
            LayerDrawable layerDrawable = new LayerDrawable(this.f11051d);
            this.f11052e = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.mCrossfade);
            return;
        }
        super.setImageResource(i11);
    }

    public void setImageRotate(float f11) {
        this.mRotate = f11;
        updateViewMatrix();
    }

    public void setImageZoom(float f11) {
        this.mZoom = f11;
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
            if (this.f11050c == null) {
                this.f11050c = new RectF();
            }
            if (this.f11049b == null) {
                AnonymousClass2 r52 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.mRound);
                    }
                };
                this.f11049b = r52;
                setOutlineProvider(r52);
            }
            setClipToOutline(true);
            this.f11050c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.f11050c;
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
            if (this.f11050c == null) {
                this.f11050c = new RectF();
            }
            if (this.f11049b == null) {
                AnonymousClass1 r62 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = ImageFilterButton.this.getWidth();
                        int height = ImageFilterButton.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.mRoundPercent) / 2.0f);
                    }
                };
                this.f11049b = r62;
                setOutlineProvider(r62);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.mRoundPercent) / 2.0f;
            this.f11050c.set(0.0f, 0.0f, (float) width, (float) height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.f11050c, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f11) {
        ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.f11061e = f11;
        imageMatrix.a(this);
    }

    public void setWarmth(float f11) {
        ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
        imageMatrix.f11063g = f11;
        imageMatrix.a(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
