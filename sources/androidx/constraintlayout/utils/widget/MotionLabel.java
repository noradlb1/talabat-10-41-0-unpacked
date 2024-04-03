package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.view.GravityCompat;
import com.google.android.material.badge.BadgeDrawable;

public class MotionLabel extends View implements FloatLayout {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;

    /* renamed from: b  reason: collision with root package name */
    public TextPaint f11069b = new TextPaint();

    /* renamed from: c  reason: collision with root package name */
    public Path f11070c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public ViewOutlineProvider f11071d;

    /* renamed from: e  reason: collision with root package name */
    public RectF f11072e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11073f = true;

    /* renamed from: g  reason: collision with root package name */
    public Matrix f11074g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f11075h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    public Rect f11076i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f11077j;

    /* renamed from: k  reason: collision with root package name */
    public float f11078k;

    /* renamed from: l  reason: collision with root package name */
    public float f11079l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f11080m = Float.NaN;
    private boolean mAutoSize = false;
    private int mAutoSizeTextType = 0;
    private float mBaseTextSize = Float.NaN;
    private float mDeltaLeft;
    private float mFloatHeight;
    private float mFloatWidth;
    private String mFontFamily;
    private int mGravity = BadgeDrawable.TOP_START;
    private Layout mLayout;
    private int mPaddingBottom = 1;
    private int mPaddingLeft = 1;
    private int mPaddingRight = 1;
    private int mPaddingTop = 1;
    /* access modifiers changed from: private */
    public float mRound = Float.NaN;
    /* access modifiers changed from: private */
    public float mRoundPercent = 0.0f;
    private int mStyleIndex;
    private String mText = "Hello World";
    private Drawable mTextBackground;
    private Bitmap mTextBackgroundBitmap;
    private Rect mTextBounds = new Rect();
    private int mTextFillColor = 65535;
    private int mTextOutlineColor = 65535;
    private float mTextOutlineThickness = 0.0f;
    private float mTextPanX = 0.0f;
    private float mTextPanY = 0.0f;
    private BitmapShader mTextShader;
    private Matrix mTextShaderMatrix;
    private float mTextSize = 48.0f;
    private int mTextureEffect = 0;
    private float mTextureHeight = Float.NaN;
    private float mTextureWidth = Float.NaN;
    private CharSequence mTransformed;
    private int mTypefaceIndex;
    private boolean mUseOutline = false;

    /* renamed from: n  reason: collision with root package name */
    public float f11081n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f11082o = Float.NaN;

    public MotionLabel(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void adjustTexture(float f11, float f12, float f13, float f14) {
        if (this.mTextShaderMatrix != null) {
            this.mFloatWidth = f13 - f11;
            this.mFloatHeight = f14 - f12;
            updateShaderMatrix();
        }
    }

    private float getHorizontalOffset() {
        float f11;
        float f12;
        if (Float.isNaN(this.mBaseTextSize)) {
            f11 = 1.0f;
        } else {
            f11 = this.mTextSize / this.mBaseTextSize;
        }
        TextPaint textPaint = this.f11069b;
        String str = this.mText;
        float measureText = f11 * textPaint.measureText(str, 0, str.length());
        if (Float.isNaN(this.mFloatWidth)) {
            f12 = (float) getMeasuredWidth();
        } else {
            f12 = this.mFloatWidth;
        }
        return ((((f12 - ((float) getPaddingLeft())) - ((float) getPaddingRight())) - measureText) * (this.mTextPanX + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f11;
        float f12;
        if (Float.isNaN(this.mBaseTextSize)) {
            f11 = 1.0f;
        } else {
            f11 = this.mTextSize / this.mBaseTextSize;
        }
        Paint.FontMetrics fontMetrics = this.f11069b.getFontMetrics();
        if (Float.isNaN(this.mFloatHeight)) {
            f12 = (float) getMeasuredHeight();
        } else {
            f12 = this.mFloatHeight;
        }
        float paddingTop = (f12 - ((float) getPaddingTop())) - ((float) getPaddingBottom());
        float f13 = fontMetrics.descent;
        float f14 = fontMetrics.ascent;
        return (((paddingTop - ((f13 - f14) * f11)) * (1.0f - this.mTextPanY)) / 2.0f) - (f11 * f14);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setUpTheme(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLabel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.mFontFamily = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.mBaseTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mBaseTextSize);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.mTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.mTextSize);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.mStyleIndex = obtainStyledAttributes.getInt(index, this.mStyleIndex);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.mTypefaceIndex = obtainStyledAttributes.getInt(index, this.mTypefaceIndex);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.mTextFillColor = obtainStyledAttributes.getColor(index, this.mTextFillColor);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.mRound);
                    this.mRound = dimension;
                    setRound(dimension);
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f11 = obtainStyledAttributes.getFloat(index, this.mRoundPercent);
                    this.mRoundPercent = f11;
                    setRoundPercent(f11);
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.mAutoSizeTextType = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.mTextOutlineColor = obtainStyledAttributes.getInt(index, this.mTextOutlineColor);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.mTextOutlineThickness = obtainStyledAttributes.getDimension(index, this.mTextOutlineThickness);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.mTextBackground = obtainStyledAttributes.getDrawable(index);
                    this.mUseOutline = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.f11079l = obtainStyledAttributes.getFloat(index, this.f11079l);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.f11080m = obtainStyledAttributes.getFloat(index, this.f11080m);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.mTextPanX = obtainStyledAttributes.getFloat(index, this.mTextPanX);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.mTextPanY = obtainStyledAttributes.getFloat(index, this.mTextPanY);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.f11082o = obtainStyledAttributes.getFloat(index, this.f11082o);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.f11081n = obtainStyledAttributes.getFloat(index, this.f11081n);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.mTextureHeight = obtainStyledAttributes.getDimension(index, this.mTextureHeight);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.mTextureWidth = obtainStyledAttributes.getDimension(index, this.mTextureWidth);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.mTextureEffect = obtainStyledAttributes.getInt(index, this.mTextureEffect);
                }
            }
            obtainStyledAttributes.recycle();
        }
        setupTexture();
        e();
    }

    private void setTypefaceFromAttrs(String str, int i11, int i12) {
        Typeface typeface;
        Typeface typeface2;
        int i13;
        if (str != null) {
            typeface = Typeface.create(str, i12);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        boolean z11 = true;
        if (i11 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i11 == 2) {
            typeface = Typeface.SERIF;
        } else if (i11 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f11 = 0.0f;
        if (i12 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i12);
            } else {
                typeface2 = Typeface.create(typeface, i12);
            }
            setTypeface(typeface2);
            if (typeface2 != null) {
                i13 = typeface2.getStyle();
            } else {
                i13 = 0;
            }
            int i14 = (~i13) & i12;
            TextPaint textPaint = this.f11069b;
            if ((i14 & 1) == 0) {
                z11 = false;
            }
            textPaint.setFakeBoldText(z11);
            TextPaint textPaint2 = this.f11069b;
            if ((i14 & 2) != 0) {
                f11 = -0.25f;
            }
            textPaint2.setTextSkewX(f11);
            return;
        }
        this.f11069b.setFakeBoldText(false);
        this.f11069b.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    private void setUpTheme(Context context, @Nullable AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f11069b;
        int i11 = typedValue.data;
        this.mTextFillColor = i11;
        textPaint.setColor(i11);
    }

    private void setupTexture() {
        if (this.mTextBackground != null) {
            this.mTextShaderMatrix = new Matrix();
            int intrinsicWidth = this.mTextBackground.getIntrinsicWidth();
            int intrinsicHeight = this.mTextBackground.getIntrinsicHeight();
            int i11 = 128;
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                if (Float.isNaN(this.mTextureWidth)) {
                    intrinsicWidth = 128;
                } else {
                    intrinsicWidth = (int) this.mTextureWidth;
                }
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (!Float.isNaN(this.mTextureHeight)) {
                    i11 = (int) this.mTextureHeight;
                }
                intrinsicHeight = i11;
            }
            if (this.mTextureEffect != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.mTextBackgroundBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.mTextBackgroundBitmap);
            this.mTextBackground.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.mTextBackground.setFilterBitmap(true);
            this.mTextBackground.draw(canvas);
            if (this.mTextureEffect != 0) {
                this.mTextBackgroundBitmap = c(this.mTextBackgroundBitmap, 4);
            }
            Bitmap bitmap = this.mTextBackgroundBitmap;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.mTextShader = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void updateShaderMatrix() {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17 = 0.0f;
        if (Float.isNaN(this.f11079l)) {
            f11 = 0.0f;
        } else {
            f11 = this.f11079l;
        }
        if (Float.isNaN(this.f11080m)) {
            f12 = 0.0f;
        } else {
            f12 = this.f11080m;
        }
        if (Float.isNaN(this.f11081n)) {
            f13 = 1.0f;
        } else {
            f13 = this.f11081n;
        }
        if (!Float.isNaN(this.f11082o)) {
            f17 = this.f11082o;
        }
        this.mTextShaderMatrix.reset();
        float width = (float) this.mTextBackgroundBitmap.getWidth();
        float height = (float) this.mTextBackgroundBitmap.getHeight();
        if (Float.isNaN(this.mTextureWidth)) {
            f14 = this.mFloatWidth;
        } else {
            f14 = this.mTextureWidth;
        }
        if (Float.isNaN(this.mTextureHeight)) {
            f15 = this.mFloatHeight;
        } else {
            f15 = this.mTextureHeight;
        }
        if (width * f15 < height * f14) {
            f16 = f14 / width;
        } else {
            f16 = f15 / height;
        }
        float f18 = f13 * f16;
        this.mTextShaderMatrix.postScale(f18, f18);
        float f19 = width * f18;
        float f21 = f14 - f19;
        float f22 = f18 * height;
        float f23 = f15 - f22;
        if (!Float.isNaN(this.mTextureHeight)) {
            f23 = this.mTextureHeight / 2.0f;
        }
        if (!Float.isNaN(this.mTextureWidth)) {
            f21 = this.mTextureWidth / 2.0f;
        }
        this.mTextShaderMatrix.postTranslate((((f11 * f21) + f14) - f19) * 0.5f, (((f12 * f23) + f15) - f22) * 0.5f);
        this.mTextShaderMatrix.postRotate(f17, f14 / 2.0f, f15 / 2.0f);
        this.mTextShader.setLocalMatrix(this.mTextShaderMatrix);
    }

    public Bitmap c(Bitmap bitmap, int i11) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i12 = 0; i12 < i11 && width >= 32 && height >= 32; i12++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    public void d(float f11) {
        if (this.mUseOutline || f11 != 1.0f) {
            this.f11070c.reset();
            String str = this.mText;
            int length = str.length();
            this.f11069b.getTextBounds(str, 0, length, this.mTextBounds);
            this.f11069b.getTextPath(str, 0, length, 0.0f, 0.0f, this.f11070c);
            if (f11 != 1.0f) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Debug.getLoc());
                sb2.append(" scale ");
                sb2.append(f11);
                Matrix matrix = new Matrix();
                matrix.postScale(f11, f11);
                this.f11070c.transform(matrix);
            }
            Rect rect = this.mTextBounds;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = (float) getHeight();
            rectF.right = (float) getWidth();
            this.f11073f = false;
        }
    }

    public void e() {
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        setTypefaceFromAttrs(this.mFontFamily, this.mTypefaceIndex, this.mStyleIndex);
        this.f11069b.setColor(this.mTextFillColor);
        this.f11069b.setStrokeWidth(this.mTextOutlineThickness);
        this.f11069b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f11069b.setFlags(128);
        setTextSize(this.mTextSize);
        this.f11069b.setAntiAlias(true);
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getScaleFromTextSize() {
        return this.mBaseTextSize;
    }

    public float getTextBackgroundPanX() {
        return this.f11079l;
    }

    public float getTextBackgroundPanY() {
        return this.f11080m;
    }

    public float getTextBackgroundRotate() {
        return this.f11082o;
    }

    public float getTextBackgroundZoom() {
        return this.f11081n;
    }

    public int getTextOutlineColor() {
        return this.mTextOutlineColor;
    }

    public float getTextPanX() {
        return this.mTextPanX;
    }

    public float getTextPanY() {
        return this.mTextPanY;
    }

    public float getTextureHeight() {
        return this.mTextureHeight;
    }

    public float getTextureWidth() {
        return this.mTextureWidth;
    }

    public Typeface getTypeface() {
        return this.f11069b.getTypeface();
    }

    public void layout(int i11, int i12, int i13, int i14) {
        float f11;
        super.layout(i11, i12, i13, i14);
        boolean isNaN = Float.isNaN(this.mBaseTextSize);
        if (isNaN) {
            f11 = 1.0f;
        } else {
            f11 = this.mTextSize / this.mBaseTextSize;
        }
        this.mFloatWidth = (float) (i13 - i11);
        this.mFloatHeight = (float) (i14 - i12);
        if (this.mAutoSize) {
            if (this.f11076i == null) {
                this.f11077j = new Paint();
                this.f11076i = new Rect();
                this.f11077j.set(this.f11069b);
                this.f11078k = this.f11077j.getTextSize();
            }
            Paint paint = this.f11077j;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.f11076i);
            int width = this.f11076i.width();
            int height = (int) (((float) this.f11076i.height()) * 1.3f);
            float f12 = (this.mFloatWidth - ((float) this.mPaddingRight)) - ((float) this.mPaddingLeft);
            float f13 = (this.mFloatHeight - ((float) this.mPaddingBottom)) - ((float) this.mPaddingTop);
            if (isNaN) {
                float f14 = (float) width;
                float f15 = (float) height;
                if (f14 * f13 > f15 * f12) {
                    this.f11069b.setTextSize((this.f11078k * f12) / f14);
                } else {
                    this.f11069b.setTextSize((this.f11078k * f13) / f15);
                }
            } else {
                float f16 = (float) width;
                float f17 = (float) height;
                f11 = f16 * f13 > f17 * f12 ? f12 / f16 : f13 / f17;
            }
        }
        if (this.mUseOutline || !isNaN) {
            adjustTexture((float) i11, (float) i12, (float) i13, (float) i14);
            d(f11);
        }
    }

    public void onDraw(Canvas canvas) {
        float f11;
        if (Float.isNaN(this.mBaseTextSize)) {
            f11 = 1.0f;
        } else {
            f11 = this.mTextSize / this.mBaseTextSize;
        }
        super.onDraw(canvas);
        if (this.mUseOutline || f11 != 1.0f) {
            if (this.f11073f) {
                d(f11);
            }
            if (this.f11074g == null) {
                this.f11074g = new Matrix();
            }
            if (this.mUseOutline) {
                this.f11075h.set(this.f11069b);
                this.f11074g.reset();
                float horizontalOffset = ((float) this.mPaddingLeft) + getHorizontalOffset();
                float verticalOffset = ((float) this.mPaddingTop) + getVerticalOffset();
                this.f11074g.postTranslate(horizontalOffset, verticalOffset);
                this.f11074g.preScale(f11, f11);
                this.f11070c.transform(this.f11074g);
                if (this.mTextShader != null) {
                    this.f11069b.setFilterBitmap(true);
                    this.f11069b.setShader(this.mTextShader);
                } else {
                    this.f11069b.setColor(this.mTextFillColor);
                }
                this.f11069b.setStyle(Paint.Style.FILL);
                this.f11069b.setStrokeWidth(this.mTextOutlineThickness);
                canvas.drawPath(this.f11070c, this.f11069b);
                if (this.mTextShader != null) {
                    this.f11069b.setShader((Shader) null);
                }
                this.f11069b.setColor(this.mTextOutlineColor);
                this.f11069b.setStyle(Paint.Style.STROKE);
                this.f11069b.setStrokeWidth(this.mTextOutlineThickness);
                canvas.drawPath(this.f11070c, this.f11069b);
                this.f11074g.reset();
                this.f11074g.postTranslate(-horizontalOffset, -verticalOffset);
                this.f11070c.transform(this.f11074g);
                this.f11069b.set(this.f11075h);
                return;
            }
            float horizontalOffset2 = ((float) this.mPaddingLeft) + getHorizontalOffset();
            float verticalOffset2 = ((float) this.mPaddingTop) + getVerticalOffset();
            this.f11074g.reset();
            this.f11074g.preTranslate(horizontalOffset2, verticalOffset2);
            this.f11070c.transform(this.f11074g);
            this.f11069b.setColor(this.mTextFillColor);
            this.f11069b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f11069b.setStrokeWidth(this.mTextOutlineThickness);
            canvas.drawPath(this.f11070c, this.f11069b);
            this.f11074g.reset();
            this.f11074g.preTranslate(-horizontalOffset2, -verticalOffset2);
            this.f11070c.transform(this.f11074g);
            return;
        }
        canvas.drawText(this.mText, this.mDeltaLeft + ((float) this.mPaddingLeft) + getHorizontalOffset(), ((float) this.mPaddingTop) + getVerticalOffset(), this.f11069b);
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        this.mAutoSize = false;
        this.mPaddingLeft = getPaddingLeft();
        this.mPaddingRight = getPaddingRight();
        this.mPaddingTop = getPaddingTop();
        this.mPaddingBottom = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f11069b;
            String str = this.mText;
            textPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
            if (mode != 1073741824) {
                size = (int) (((float) this.mTextBounds.width()) + 0.99999f);
            }
            size += this.mPaddingLeft + this.mPaddingRight;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (((float) this.f11069b.getFontMetricsInt((Paint.FontMetricsInt) null)) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.mPaddingTop + this.mPaddingBottom + fontMetricsInt;
            }
        } else if (this.mAutoSizeTextType != 0) {
            this.mAutoSize = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i11) {
        if ((i11 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 0) {
            i11 |= GravityCompat.START;
        }
        if ((i11 & 112) == 0) {
            i11 |= 48;
        }
        if (i11 != this.mGravity) {
            invalidate();
        }
        this.mGravity = i11;
        int i12 = i11 & 112;
        if (i12 == 48) {
            this.mTextPanY = -1.0f;
        } else if (i12 != 80) {
            this.mTextPanY = 0.0f;
        } else {
            this.mTextPanY = 1.0f;
        }
        int i13 = i11 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i13 != 3) {
            if (i13 != 5) {
                if (i13 != 8388611) {
                    if (i13 != 8388613) {
                        this.mTextPanX = 0.0f;
                        return;
                    }
                }
            }
            this.mTextPanX = 1.0f;
            return;
        }
        this.mTextPanX = -1.0f;
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
            if (this.f11070c == null) {
                this.f11070c = new Path();
            }
            if (this.f11072e == null) {
                this.f11072e = new RectF();
            }
            if (this.f11071d == null) {
                AnonymousClass2 r52 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.mRound);
                    }
                };
                this.f11071d = r52;
                setOutlineProvider(r52);
            }
            setClipToOutline(true);
            this.f11072e.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f11070c.reset();
            Path path = this.f11070c;
            RectF rectF = this.f11072e;
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
            if (this.f11070c == null) {
                this.f11070c = new Path();
            }
            if (this.f11072e == null) {
                this.f11072e = new RectF();
            }
            if (this.f11071d == null) {
                AnonymousClass1 r62 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = MotionLabel.this.getWidth();
                        int height = MotionLabel.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionLabel.this.mRoundPercent) / 2.0f);
                    }
                };
                this.f11071d = r62;
                setOutlineProvider(r62);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.mRoundPercent) / 2.0f;
            this.f11072e.set(0.0f, 0.0f, (float) width, (float) height);
            this.f11070c.reset();
            this.f11070c.addRoundRect(this.f11072e, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f11) {
        this.mBaseTextSize = f11;
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f11) {
        this.f11079l = f11;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundPanY(float f11) {
        this.f11080m = f11;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundRotate(float f11) {
        this.f11082o = f11;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextBackgroundZoom(float f11) {
        this.f11081n = f11;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextFillColor(int i11) {
        this.mTextFillColor = i11;
        invalidate();
    }

    public void setTextOutlineColor(int i11) {
        this.mTextOutlineColor = i11;
        this.mUseOutline = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f11) {
        this.mTextOutlineThickness = f11;
        this.mUseOutline = true;
        if (Float.isNaN(f11)) {
            this.mTextOutlineThickness = 1.0f;
            this.mUseOutline = false;
        }
        invalidate();
    }

    public void setTextPanX(float f11) {
        this.mTextPanX = f11;
        invalidate();
    }

    public void setTextPanY(float f11) {
        this.mTextPanY = f11;
        invalidate();
    }

    public void setTextSize(float f11) {
        float f12;
        this.mTextSize = f11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Debug.getLoc());
        sb2.append("  ");
        sb2.append(f11);
        sb2.append(" / ");
        sb2.append(this.mBaseTextSize);
        TextPaint textPaint = this.f11069b;
        if (!Float.isNaN(this.mBaseTextSize)) {
            f11 = this.mBaseTextSize;
        }
        textPaint.setTextSize(f11);
        if (Float.isNaN(this.mBaseTextSize)) {
            f12 = 1.0f;
        } else {
            f12 = this.mTextSize / this.mBaseTextSize;
        }
        d(f12);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f11) {
        this.mTextureHeight = f11;
        updateShaderMatrix();
        invalidate();
    }

    public void setTextureWidth(float f11) {
        this.mTextureWidth = f11;
        updateShaderMatrix();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.f11069b.getTypeface() != typeface) {
            this.f11069b.setTypeface(typeface);
            if (this.mLayout != null) {
                this.mLayout = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public void layout(float f11, float f12, float f13, float f14) {
        int i11 = (int) (f11 + 0.5f);
        this.mDeltaLeft = f11 - ((float) i11);
        int i12 = (int) (f13 + 0.5f);
        int i13 = i12 - i11;
        int i14 = (int) (f14 + 0.5f);
        int i15 = (int) (0.5f + f12);
        int i16 = i14 - i15;
        float f15 = f13 - f11;
        this.mFloatWidth = f15;
        float f16 = f14 - f12;
        this.mFloatHeight = f16;
        adjustTexture(f11, f12, f13, f14);
        if (getMeasuredHeight() == i16 && getMeasuredWidth() == i13) {
            super.layout(i11, i15, i12, i14);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
            super.layout(i11, i15, i12, i14);
        }
        if (this.mAutoSize) {
            if (this.f11076i == null) {
                this.f11077j = new Paint();
                this.f11076i = new Rect();
                this.f11077j.set(this.f11069b);
                this.f11078k = this.f11077j.getTextSize();
            }
            this.mFloatWidth = f15;
            this.mFloatHeight = f16;
            Paint paint = this.f11077j;
            String str = this.mText;
            paint.getTextBounds(str, 0, str.length(), this.f11076i);
            int width = this.f11076i.width();
            float height = ((float) this.f11076i.height()) * 1.3f;
            float f17 = (f15 - ((float) this.mPaddingRight)) - ((float) this.mPaddingLeft);
            float f18 = (f16 - ((float) this.mPaddingBottom)) - ((float) this.mPaddingTop);
            float f19 = (float) width;
            if (f19 * f18 > height * f17) {
                this.f11069b.setTextSize((this.f11078k * f17) / f19);
            } else {
                this.f11069b.setTextSize((this.f11078k * f18) / height);
            }
            if (this.mUseOutline || !Float.isNaN(this.mBaseTextSize)) {
                d(Float.isNaN(this.mBaseTextSize) ? 1.0f : this.mTextSize / this.mBaseTextSize);
            }
        }
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
