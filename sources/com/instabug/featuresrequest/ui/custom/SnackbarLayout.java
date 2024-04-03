package com.instabug.featuresrequest.ui.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.instabug.featuresrequest.R;

public class SnackbarLayout extends LinearLayout {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private TextView f46692a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Button f46693b;

    /* renamed from: c  reason: collision with root package name */
    public int f46694c;

    /* renamed from: d  reason: collision with root package name */
    private int f46695d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private b f46696e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private a f46697f;

    public interface a {
        void a(View view);

        void b(View view);
    }

    public interface b {
        void a(View view, int i11, int i12, int i13, int i14);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public SnackbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.f46694c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.f46695d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        int i11 = R.styleable.SnackbarLayout_elevation;
        if (obtainStyledAttributes.hasValue(i11)) {
            ViewCompat.setElevation(this, (float) obtainStyledAttributes.getDimensionPixelSize(i11, 0));
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        LayoutInflater.from(context).inflate(R.layout.ib_fr_insta_toast_include, this);
        ViewCompat.setAccessibilityLiveRegion(this, 1);
    }

    private static void a(View view, int i11, int i12) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i11, ViewCompat.getPaddingEnd(view), i12);
        } else {
            view.setPadding(view.getPaddingLeft(), i11, view.getPaddingRight(), i12);
        }
    }

    private boolean a(int i11, int i12, int i13) {
        boolean z11;
        if (i11 != getOrientation()) {
            setOrientation(i11);
            z11 = true;
        } else {
            z11 = false;
        }
        TextView textView = this.f46692a;
        if (textView == null || (textView.getPaddingTop() == i12 && this.f46692a.getPaddingBottom() == i13)) {
            return z11;
        }
        a((View) this.f46692a, i12, i13);
        return true;
    }

    public void a(int i11, int i12) {
        TextView textView = this.f46692a;
        if (textView != null) {
            ViewCompat.setAlpha(textView, 0.0f);
            ViewCompat.animate(this.f46692a).alpha(1.0f).setDuration((long) i12).setStartDelay((long) i11).start();
        }
        Button button = this.f46693b;
        if (button != null && button.getVisibility() == 0) {
            ViewCompat.setAlpha(this.f46693b, 0.0f);
            ViewCompat.animate(this.f46693b).alpha(1.0f).setDuration((long) i12).setStartDelay((long) i11).start();
        }
    }

    public void b(int i11, int i12) {
        TextView textView = this.f46692a;
        if (textView != null) {
            ViewCompat.setAlpha(textView, 1.0f);
            ViewCompat.animate(this.f46692a).alpha(0.0f).setDuration((long) i12).setStartDelay((long) i11).start();
        }
        Button button = this.f46693b;
        if (button != null && button.getVisibility() == 0) {
            ViewCompat.setAlpha(this.f46693b, 1.0f);
            ViewCompat.animate(this.f46693b).alpha(0.0f).setDuration((long) i12).setStartDelay((long) i11).start();
        }
    }

    @Nullable
    public Button getActionView() {
        return this.f46693b;
    }

    @Nullable
    public TextView getMessageView() {
        return this.f46692a;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f46697f;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f46697f;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f46692a = (TextView) findViewById(R.id.snackbar_text);
        this.f46693b = (Button) findViewById(R.id.snackbar_action);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        b bVar;
        super.onLayout(z11, i11, i12, i13, i14);
        if (z11 && (bVar = this.f46696e) != null) {
            bVar.a(this, i11, i12, i13, i14);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        if (a(1, r0, r0) != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (a(0, r0, r0) != false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f46694c
            if (r0 <= 0) goto L_0x0018
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f46694c
            if (r0 <= r1) goto L_0x0018
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L_0x0018:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.instabug.featuresrequest.R.dimen.ib_fr_toast_multi_line_padding
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.instabug.featuresrequest.R.dimen.ib_fr_toast_single_line_padding
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f46692a
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003e
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            if (r2 <= r4) goto L_0x003e
            r2 = r4
            goto L_0x003f
        L_0x003e:
            r2 = r3
        L_0x003f:
            android.widget.Button r5 = r7.f46693b
            if (r5 == 0) goto L_0x0058
            if (r2 == 0) goto L_0x0058
            int r6 = r7.f46695d
            if (r6 <= 0) goto L_0x0058
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f46695d
            if (r5 <= r6) goto L_0x0058
            boolean r0 = r7.a((int) r4, (int) r0, (int) r0)
            if (r0 == 0) goto L_0x0063
            goto L_0x0062
        L_0x0058:
            if (r2 == 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r0 = r1
        L_0x005c:
            boolean r0 = r7.a((int) r3, (int) r0, (int) r0)
            if (r0 == 0) goto L_0x0063
        L_0x0062:
            r3 = r4
        L_0x0063:
            if (r3 == 0) goto L_0x0068
            super.onMeasure(r8, r9)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.ui.custom.SnackbarLayout.onMeasure(int, int):void");
    }

    public void setOnAttachStateChangeListener(a aVar) {
        this.f46697f = aVar;
    }

    public void setOnLayoutChangeListener(b bVar) {
        this.f46696e = bVar;
    }
}
