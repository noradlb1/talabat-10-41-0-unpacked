package com.instabug.library.annotation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.instabug.library.R;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.view.ViewUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorPickerPopUpView extends View {

    /* renamed from: i  reason: collision with root package name */
    private static final int f34070i = Color.argb(255, 247, 247, 247);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private RectF f34071a;

    /* renamed from: b  reason: collision with root package name */
    private d f34072b;

    /* renamed from: c  reason: collision with root package name */
    private int f34073c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private c f34074d;

    /* renamed from: e  reason: collision with root package name */
    private final b f34075e;
    @Size(7)

    /* renamed from: f  reason: collision with root package name */
    private int[] f34076f;

    /* renamed from: g  reason: collision with root package name */
    private int f34077g;

    /* renamed from: h  reason: collision with root package name */
    private List f34078h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public RectF f34079a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        public int f34080b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f34081c;

        public a(int i11) {
            this.f34080b = i11;
        }

        public RectF a() {
            RectF rectF = new RectF();
            rectF.set(this.f34079a);
            rectF.inset((-this.f34079a.width()) / 3.0f, (-this.f34079a.height()) / 3.0f);
            return rectF;
        }
    }

    public static class b extends ExploreByTouchHelper {

        /* renamed from: a  reason: collision with root package name */
        private final ColorPickerPopUpView f34082a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f34083b;

        public b(@NonNull View view) {
            super(view);
            this.f34082a = (ColorPickerPopUpView) view;
            this.f34083b = view.getContext().getResources().getStringArray(R.array.ibg_bug_annotation_colors_names_content_description);
        }

        public int getVirtualViewAt(float f11, float f12) {
            return Math.min((int) (f11 / (((float) this.f34082a.getWidth()) / ((float) this.f34082a.getCheckCircleColorList().size()))), this.f34082a.getCheckCircleColorList().size());
        }

        public void getVisibleVirtualViews(List list) {
            int size = this.f34082a.getCheckCircleColorList().size();
            for (int i11 = 0; i11 < size; i11++) {
                list.add(Integer.valueOf(i11));
            }
        }

        public boolean onPerformActionForVirtualView(int i11, int i12, @Nullable Bundle bundle) {
            return false;
        }

        public void onPopulateNodeForVirtualView(int i11, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setClassName(ColorPickerPopUpView.class.getSimpleName());
            accessibilityNodeInfoCompat.setContentDescription(this.f34083b[i11]);
            accessibilityNodeInfoCompat.setRoleDescription("Button");
            accessibilityNodeInfoCompat.addAction(16);
            RectF rectF = this.f34082a.getCheckCircleColorList().get(i11).f34079a;
            Rect rect = new Rect();
            rectF.round(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
        }
    }

    public interface c {
        void a(@ColorInt int i11, int i12);
    }

    public enum d {
        PORTRAIT,
        LANDSCAPE
    }

    public ColorPickerPopUpView(Context context) {
        this(context, (AttributeSet) null);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void a(@Nullable AttributeSet attributeSet, int i11) {
        ViewCompat.setAccessibilityDelegate(this, this.f34075e);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPickerPopUpView, i11, 0);
        d screenOrientation = getScreenOrientation();
        d dVar = d.PORTRAIT;
        if (screenOrientation != dVar) {
            dVar = d.LANDSCAPE;
        }
        this.f34072b = dVar;
        obtainStyledAttributes.recycle();
        this.f34073c = f34070i;
        this.f34078h = new ArrayList();
        for (int aVar : this.f34076f) {
            this.f34078h.add(new a(aVar));
        }
        setSelectedColor(0);
    }

    private d getScreenOrientation() {
        if (getResources().getConfiguration().orientation == 2) {
            return d.LANDSCAPE;
        }
        return d.PORTRAIT;
    }

    private void setSelectedColor(int i11) {
        boolean z11;
        this.f34077g = this.f34076f[i11];
        for (int i12 = 0; i12 < this.f34078h.size(); i12++) {
            a aVar = (a) this.f34078h.get(i12);
            if (i12 == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            aVar.f34081c = z11;
        }
        invalidate();
        c cVar = this.f34074d;
        if (cVar != null) {
            cVar.a(this.f34077g, i11);
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f34075e.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public List<a> getCheckCircleColorList() {
        return this.f34078h;
    }

    public int getSelectedColor() {
        return this.f34077g;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d screenOrientation = getScreenOrientation();
        d dVar = d.PORTRAIT;
        if (screenOrientation != dVar) {
            dVar = d.LANDSCAPE;
        }
        this.f34072b = dVar;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, (measuredWidth * 55) / 426);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f34077g = bundle.getInt("selected_color");
            parcelable = bundle.getParcelable("instabug_color_picker");
            setSelectedColor(a(this.f34076f, this.f34077g));
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instabug_color_picker", super.onSaveInstanceState());
        bundle.putInt("selected_color", this.f34077g);
        return bundle;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (this.f34072b == d.LANDSCAPE) {
            float f11 = ((float) (i11 * 55)) / 406.0f;
            if (InstabugDeviceProperties.isTablet(getContext())) {
                this.f34071a = new RectF(0.0f, (float) ViewUtils.convertDpToPx(getContext(), 110.0f), (float) i11, f11);
            } else {
                this.f34071a = new RectF(0.0f, (float) ViewUtils.convertDpToPx(getContext(), 50.0f), (float) i11, f11);
            }
        } else {
            float f12 = ((float) (i11 * 55)) / 420.0f;
            if (InstabugDeviceProperties.isTablet(getContext())) {
                this.f34071a = new RectF(0.0f, (float) ViewUtils.convertDpToPx(getContext(), 60.0f), (float) i11, f12);
            } else {
                this.f34071a = new RectF(0.0f, (float) ViewUtils.convertDpToPx(getContext(), 16.0f), (float) i11, f12);
            }
        }
        RectF rectF = this.f34071a;
        float floor = rectF.left + ((float) Math.floor((double) ((rectF.width() * 0.04429f) + 0.5f)));
        RectF rectF2 = this.f34071a;
        float floor2 = rectF2.top + ((float) Math.floor((double) ((rectF2.height() * 0.2f) + 0.5f)));
        RectF rectF3 = this.f34071a;
        float floor3 = rectF3.left + ((float) Math.floor((double) ((rectF3.width() * 0.09857f) + 0.5f)));
        RectF rectF4 = this.f34071a;
        ((a) this.f34078h.get(0)).f34079a = new RectF(floor, floor2, floor3, rectF4.top + ((float) Math.floor((double) ((rectF4.height() * 0.66504f) + 0.5f))));
        RectF rectF5 = this.f34071a;
        float floor4 = rectF5.left + ((float) Math.floor((double) ((rectF5.width() * 0.18714f) + 0.5f)));
        RectF rectF6 = this.f34071a;
        float floor5 = rectF6.top + ((float) Math.floor((double) ((rectF6.height() * 0.2f) + 0.5f)));
        RectF rectF7 = this.f34071a;
        float floor6 = rectF7.left + ((float) Math.floor((double) ((rectF7.width() * 0.24143f) + 0.5f)));
        RectF rectF8 = this.f34071a;
        ((a) this.f34078h.get(1)).f34079a = new RectF(floor4, floor5, floor6, rectF8.top + ((float) Math.floor((double) ((rectF8.height() * 0.66504f) + 0.5f))));
        RectF rectF9 = this.f34071a;
        float floor7 = rectF9.left + ((float) Math.floor((double) ((rectF9.width() * 0.33f) + 0.5f)));
        RectF rectF10 = this.f34071a;
        float floor8 = rectF10.top + ((float) Math.floor((double) ((rectF10.height() * 0.2f) + 0.5f)));
        RectF rectF11 = this.f34071a;
        float floor9 = rectF11.left + ((float) Math.floor((double) ((rectF11.width() * 0.38429f) + 0.5f)));
        RectF rectF12 = this.f34071a;
        ((a) this.f34078h.get(2)).f34079a = new RectF(floor7, floor8, floor9, rectF12.top + ((float) Math.floor((double) ((rectF12.height() * 0.66504f) + 0.5f))));
        RectF rectF13 = this.f34071a;
        float floor10 = rectF13.left + ((float) Math.floor((double) ((rectF13.width() * 0.47286f) + 0.5f)));
        RectF rectF14 = this.f34071a;
        float floor11 = rectF14.top + ((float) Math.floor((double) ((rectF14.height() * 0.2f) + 0.5f)));
        RectF rectF15 = this.f34071a;
        float floor12 = rectF15.left + ((float) Math.floor((double) ((rectF15.width() * 0.52714f) + 0.5f)));
        RectF rectF16 = this.f34071a;
        ((a) this.f34078h.get(3)).f34079a = new RectF(floor10, floor11, floor12, rectF16.top + ((float) Math.floor((double) ((rectF16.height() * 0.66504f) + 0.5f))));
        RectF rectF17 = this.f34071a;
        float floor13 = rectF17.left + ((float) Math.floor((double) ((rectF17.width() * 0.61571f) + 0.5f)));
        RectF rectF18 = this.f34071a;
        float floor14 = rectF18.top + ((float) Math.floor((double) ((rectF18.height() * 0.2f) + 0.5f)));
        RectF rectF19 = this.f34071a;
        float floor15 = rectF19.left + ((float) Math.floor((double) ((rectF19.width() * 0.67f) + 0.5f)));
        RectF rectF20 = this.f34071a;
        ((a) this.f34078h.get(4)).f34079a = new RectF(floor13, floor14, floor15, rectF20.top + ((float) Math.floor((double) ((rectF20.height() * 0.66504f) + 0.5f))));
        RectF rectF21 = this.f34071a;
        float floor16 = rectF21.left + ((float) Math.floor((double) ((rectF21.width() * 0.75857f) + 0.5f)));
        RectF rectF22 = this.f34071a;
        float floor17 = rectF22.top + ((float) Math.floor((double) ((rectF22.height() * 0.2f) + 0.5f)));
        RectF rectF23 = this.f34071a;
        float floor18 = rectF23.left + ((float) Math.floor((double) ((rectF23.width() * 0.81286f) + 0.5f)));
        RectF rectF24 = this.f34071a;
        ((a) this.f34078h.get(5)).f34079a = new RectF(floor16, floor17, floor18, rectF24.top + ((float) Math.floor((double) ((rectF24.height() * 0.66504f) + 0.5f))));
        RectF rectF25 = this.f34071a;
        float floor19 = rectF25.left + ((float) Math.floor((double) ((rectF25.width() * 0.90143f) + 0.5f)));
        RectF rectF26 = this.f34071a;
        float floor20 = rectF26.top + ((float) Math.floor((double) ((rectF26.height() * 0.2f) + 0.5f)));
        RectF rectF27 = this.f34071a;
        float floor21 = rectF27.left + ((float) Math.floor((double) ((rectF27.width() * 0.95571f) + 0.5f)));
        RectF rectF28 = this.f34071a;
        ((a) this.f34078h.get(6)).f34079a = new RectF(floor19, floor20, floor21, rectF28.top + ((float) Math.floor((double) ((rectF28.height() * 0.66504f) + 0.5f))));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (actionMasked == 1) {
            int i11 = 0;
            while (true) {
                if (i11 >= this.f34078h.size()) {
                    break;
                } else if (((a) this.f34078h.get(i11)).a().contains(x11, y11)) {
                    setSelectedColor(i11);
                    break;
                } else {
                    i11++;
                }
            }
        }
        return true;
    }

    public void setColors(@Size(7) int[] iArr) {
        this.f34076f = Arrays.copyOf(iArr, iArr.length);
    }

    public void setOnColorSelectionListener(@Nullable c cVar) {
        this.f34074d = cVar;
    }

    public void setOrientation(d dVar) {
        this.f34072b = dVar;
    }

    public void setPopUpBackgroundColor(int i11) {
        this.f34073c = i11;
        invalidate();
    }

    public ColorPickerPopUpView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public ColorPickerPopUpView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34075e = new b(this);
        this.f34076f = new int[]{-65536, -15925503, -65028, -15893761, -33280, -1024, -4737097};
        a(attributeSet, i11);
    }

    private static int a(int[] iArr, int i11) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            if (iArr[i12] == i11) {
                return i12;
            }
        }
        return 0;
    }

    private void a(Canvas canvas, a aVar) {
        RectF rectF = aVar.f34079a;
        int i11 = aVar.f34080b;
        float f11 = rectF.left;
        RectF rectF2 = new RectF(f11, rectF.top, ((float) Math.floor((double) (rectF.height() + 0.5f))) + f11, rectF.top + ((float) Math.floor((double) (rectF.height() + 0.5f))));
        Path path = new Path();
        path.addOval(rectF2, Path.Direction.CW);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i11);
        canvas.drawPath(path, paint);
        if (aVar.f34081c) {
            Path path2 = new Path();
            path2.moveTo(rectF.left + (rectF.height() * 0.20313f), rectF.top + (rectF.height() * 0.51758f));
            path2.lineTo(rectF.left + (rectF.height() * 0.39844f), rectF.top + (rectF.height() * 0.71875f));
            path2.lineTo(rectF.left + (rectF.height() * 0.79492f), rectF.top + (rectF.height() * 0.33008f));
            path2.lineTo(rectF.left + (rectF.height() * 0.74805f), rectF.top + (rectF.height() * 0.28125f));
            path2.lineTo(rectF.left + (rectF.height() * 0.39844f), rectF.top + (rectF.height() * 0.625f));
            path2.lineTo(rectF.left + (rectF.height() * 0.25f), rectF.top + (rectF.height() * 0.47266f));
            path2.lineTo(rectF.left + (rectF.height() * 0.20313f), rectF.top + (rectF.height() * 0.51758f));
            path2.close();
            Paint paint2 = new Paint(1);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setColor(-1);
            canvas.drawPath(path2, paint2);
        }
    }

    private void a(Canvas canvas) {
        Path path = new Path();
        RectF rectF = this.f34071a;
        if (rectF != null) {
            path.moveTo(rectF.left, rectF.top);
            path.lineTo(this.f34071a.width(), this.f34071a.top);
            path.lineTo(this.f34071a.width(), this.f34071a.height() + 200.0f);
            RectF rectF2 = this.f34071a;
            path.lineTo(rectF2.left, rectF2.height() + 200.0f);
            RectF rectF3 = this.f34071a;
            path.lineTo(rectF3.left, rectF3.top);
            path.close();
        }
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f34073c);
        canvas.drawPath(path, paint);
        canvas.save();
        canvas.restore();
        for (a a11 : this.f34078h) {
            a(canvas, a11);
        }
    }
}
