package com.instabug.library.internal.view.floatingactionbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.view.IconView;

public abstract class d extends IconView {
    public boolean A;
    @DrawableRes

    /* renamed from: e  reason: collision with root package name */
    private int f51251e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Drawable f51252f;

    /* renamed from: g  reason: collision with root package name */
    private int f51253g;

    /* renamed from: h  reason: collision with root package name */
    private float f51254h;

    /* renamed from: i  reason: collision with root package name */
    private float f51255i;

    /* renamed from: j  reason: collision with root package name */
    private float f51256j;

    /* renamed from: k  reason: collision with root package name */
    private int f51257k;

    /* renamed from: w  reason: collision with root package name */
    public int f51258w;

    /* renamed from: x  reason: collision with root package name */
    public int f51259x;

    /* renamed from: y  reason: collision with root package name */
    public int f51260y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public String f51261z;

    public d(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private StateListDrawable a(float f11) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, b(this.f51260y, f11));
        stateListDrawable.addState(new int[]{16842919}, b(this.f51259x, f11));
        stateListDrawable.addState(new int[0], b(this.f51258w, f11));
        return stateListDrawable;
    }

    private void b() {
        this.f51254h = j(this.f51253g == 0 ? R.dimen.instabug_fab_size_normal : R.dimen.instabug_fab_size_mini);
    }

    private int c(float f11) {
        return (int) (f11 * 255.0f);
    }

    private void c() {
        this.f51257k = (int) (this.f51254h + (this.f51255i * 2.0f));
    }

    private int d(int i11) {
        return Color.argb(Color.alpha(i11) / 2, Color.red(i11), Color.green(i11), Color.blue(i11));
    }

    private int e(int i11) {
        return a(i11, 1.1f);
    }

    private int f(int i11) {
        return Color.rgb(Color.red(i11), Color.green(i11), Color.blue(i11));
    }

    private void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void g() {
        int i11;
        int i12;
        float j11 = j(R.dimen.instabug_fab_stroke_width);
        float f11 = j11 / 2.0f;
        Drawable[] drawableArr = new Drawable[4];
        Resources resources = getResources();
        if (this.f51253g == 0) {
            i11 = R.drawable.ibg_core_fab_bg_normal;
        } else {
            i11 = R.drawable.ibg_core_fab_bg_mini;
        }
        drawableArr[0] = resources.getDrawable(i11);
        drawableArr[1] = a(j11);
        drawableArr[2] = b(j11);
        drawableArr[3] = getIconDrawable();
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        if (this.f51253g == 0) {
            i12 = ((int) (this.f51254h - j(R.dimen.instabug_fab_icon_size_normal))) / 2;
        } else {
            i12 = ((int) (this.f51254h - j(R.dimen.instabug_fab_icon_size_mini))) / 2;
        }
        float f12 = this.f51255i;
        int i13 = (int) f12;
        float f13 = this.f51256j;
        int i14 = (int) (f12 - f13);
        int i15 = (int) (f12 + f13);
        layerDrawable.setLayerInset(1, i13, i14, i13, i15);
        int i16 = (int) (((float) i13) - f11);
        LayerDrawable layerDrawable2 = layerDrawable;
        layerDrawable2.setLayerInset(2, i16, (int) (((float) i14) - f11), i16, (int) (((float) i15) - f11));
        int i17 = i13 + i12;
        layerDrawable2.setLayerInset(3, i17, i14 + i12, i17, i15 + i12);
        setBackgroundCompat(layerDrawable);
    }

    @StringRes
    public int getButtonContentDescription() {
        return R.string.ibg_scren_recording_duration_btn_content_description;
    }

    public int getColorDisabled() {
        return this.f51260y;
    }

    public int getColorNormal() {
        return this.f51258w;
    }

    public int getColorPressed() {
        return this.f51259x;
    }

    public abstract Drawable getIconDrawable();

    public TextView getLabelView() {
        return (TextView) getTag(R.id.instabug_fab_label);
    }

    public int getSize() {
        return this.f51253g;
    }

    @Nullable
    public String getTitle() {
        return this.f51261z;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void h(Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, 0, 0);
        this.f51258w = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_instabug_fab_colorNormal, -1);
        this.f51259x = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_instabug_fab_colorPressed, -3355444);
        this.f51260y = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_instabug_fab_colorDisabled, Color.parseColor("#EFEFF4"));
        this.f51253g = obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_instabug_fab_size, 0);
        this.f51251e = obtainStyledAttributes.getResourceId(R.styleable.FloatingActionButton_instabug_fab_icon, 0);
        this.f51261z = obtainStyledAttributes.getString(R.styleable.FloatingActionButton_instabug_fab_title);
        this.A = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_instabug_fab_stroke_visible, true);
        obtainStyledAttributes.recycle();
        b();
        this.f51255i = j(R.dimen.instabug_fab_shadow_radius);
        this.f51256j = j(R.dimen.instabug_fab_shadow_offset);
        c();
        g();
        setContentDescription(LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), getButtonContentDescription(), getContext()));
        ViewCompat.setAccessibilityDelegate(this, new a(this));
    }

    public int i(@ColorRes int i11) {
        return getResources().getColor(i11);
    }

    public float j(@DimenRes int i11) {
        return getResources().getDimension(i11);
    }

    public void onMeasure(int i11, int i12) {
        int i13 = this.f51257k;
        setMeasuredDimension(i13, i13);
    }

    public void setColorDisabled(int i11) {
        if (this.f51260y != i11) {
            this.f51260y = i11;
            g();
        }
    }

    public void setColorDisabledResId(@ColorRes int i11) {
        setColorDisabled(i(i11));
    }

    public void setColorNormal(int i11) {
        if (this.f51258w != i11) {
            this.f51258w = i11;
            g();
        }
    }

    public void setColorNormalResId(@ColorRes int i11) {
        setColorNormal(i(i11));
    }

    public void setColorPressed(int i11) {
        if (this.f51259x != i11) {
            this.f51259x = i11;
            g();
        }
    }

    public void setColorPressedResId(@ColorRes int i11) {
        setColorPressed(i(i11));
    }

    public void setIcon(@DrawableRes int i11) {
        if (this.f51251e != i11) {
            this.f51251e = i11;
            this.f51252f = null;
            g();
        }
    }

    public void setIconDrawable(@NonNull Drawable drawable) {
        if (this.f51252f != drawable) {
            this.f51251e = 0;
            this.f51252f = drawable;
            g();
        }
    }

    public void setSize(int i11) {
        if (i11 != 1 && i11 != 0) {
            throw new IllegalArgumentException("Use @FAB_SIZE constants only!");
        } else if (this.f51253g != i11) {
            this.f51253g = i11;
            b();
            c();
            g();
        }
    }

    public void setStrokeVisible(boolean z11) {
        if (this.A != z11) {
            this.A = z11;
            g();
        }
    }

    public void setTitle(String str) {
        this.f51261z = str;
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    public void setVisibility(int i11) {
        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i11);
        }
        super.setVisibility(i11);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public d(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        h(context, attributeSet);
    }

    private Drawable c(int i11, float f11) {
        if (!this.A) {
            return new ColorDrawable(0);
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        int a11 = a(i11);
        int d11 = d(a11);
        int e11 = e(i11);
        int d12 = d(e11);
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f11);
        paint.setStyle(Paint.Style.STROKE);
        shapeDrawable.setShaderFactory(new b(this, e11, d12, i11, d11, a11));
        return shapeDrawable;
    }

    private Drawable b(int i11, float f11) {
        LayerDrawable layerDrawable;
        int alpha = Color.alpha(i11);
        int f12 = f(i11);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setColor(f12);
        Drawable[] drawableArr = {shapeDrawable, c(f12, f11)};
        if (alpha == 255 || !this.A) {
            layerDrawable = new LayerDrawable(drawableArr);
        } else {
            layerDrawable = new c(alpha, drawableArr);
        }
        int i12 = (int) (f11 / 2.0f);
        layerDrawable.setLayerInset(1, i12, i12, i12, i12);
        return layerDrawable;
    }

    private int a(int i11) {
        return a(i11, 0.9f);
    }

    private int a(int i11, float f11) {
        float[] fArr = new float[3];
        Color.colorToHSV(i11, fArr);
        fArr[2] = Math.min(fArr[2] * f11, 1.0f);
        return Color.HSVToColor(Color.alpha(i11), fArr);
    }

    private Drawable b(float f11) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f11);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setAlpha(c(0.02f));
        return shapeDrawable;
    }
}
