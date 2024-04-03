package com.huawei.hms.dtm.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.huawei.hms.dtm.core.util.f;

/* renamed from: com.huawei.hms.dtm.core.sd  reason: case insensitive filesystem */
public abstract class C0436sd {

    /* renamed from: a  reason: collision with root package name */
    protected ImageView f48587a;

    /* renamed from: b  reason: collision with root package name */
    protected Activity f48588b;

    /* renamed from: c  reason: collision with root package name */
    protected C0426qd f48589c;

    /* renamed from: d  reason: collision with root package name */
    private int f48590d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f48591e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f48592f = 0;

    /* renamed from: com.huawei.hms.dtm.core.sd$a */
    public class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private final View f48593a;

        /* renamed from: b  reason: collision with root package name */
        private int f48594b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f48595c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f48596d = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f48597e = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f48598f;

        /* renamed from: g  reason: collision with root package name */
        private int f48599g;

        /* renamed from: h  reason: collision with root package name */
        Rect f48600h = new Rect();

        /* renamed from: i  reason: collision with root package name */
        Rect f48601i = new Rect();

        public a(View view) {
            this.f48593a = view;
        }

        private boolean a(float f11, float f12, float f13, float f14) {
            return Math.abs(f11 - f12) <= 3.0f && Math.abs(f13 - f14) <= 3.0f;
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f48594b = (int) motionEvent.getRawX();
                this.f48595c = (int) motionEvent.getRawY();
                this.f48596d = this.f48594b - view.getLeft();
                this.f48597e = this.f48595c - view.getTop();
                this.f48598f = view.getWidth();
                this.f48599g = view.getHeight();
                this.f48593a.getLocalVisibleRect(this.f48601i);
            } else if (action != 1) {
                if (action == 2) {
                    int rawX = ((int) motionEvent.getRawX()) - this.f48596d;
                    int rawY = ((int) motionEvent.getRawY()) - this.f48597e;
                    Rect rect = this.f48600h;
                    rect.left = rawX;
                    rect.top = rawY;
                    rect.right = this.f48598f + rawX;
                    rect.bottom = this.f48599g + rawY;
                    if (this.f48601i.contains(rect)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        marginLayoutParams.leftMargin = rawX;
                        marginLayoutParams.topMargin = C0436sd.this.b(rawY);
                        view.setLayoutParams(marginLayoutParams);
                    }
                }
            } else if (a((float) this.f48594b, motionEvent.getRawX(), (float) this.f48595c, motionEvent.getRawY())) {
                C0436sd.this.c();
            }
            return true;
        }
    }

    public C0436sd(Activity activity) {
        this.f48588b = activity;
        this.f48587a = new ImageView(J.b());
        ViewGroup viewGroup = (ViewGroup) f.a(activity);
        if (viewGroup != null) {
            this.f48587a.setOnTouchListener(new a(viewGroup));
        }
    }

    private void a(Activity activity) {
        if (this.f48590d <= 0) {
            Resources resources = activity.getResources();
            this.f48590d = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        }
    }

    /* access modifiers changed from: private */
    public int b(int i11) {
        int i12 = this.f48590d;
        if (i11 < i12) {
            i11 = i12;
        }
        int i13 = this.f48592f;
        int i14 = i11 + i13;
        int i15 = this.f48591e + i12;
        return i14 > i15 ? i15 - i13 : i11;
    }

    private void b(Activity activity) {
        if (activity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.f48591e = displayMetrics.heightPixels;
        }
    }

    public abstract void a();

    public abstract void a(int i11);

    public void a(Activity activity, ViewGroup viewGroup, ImageView imageView) {
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        int i11 = (int) ((activity.getResources().getDisplayMetrics().density * 78.0f) + 0.5f);
        this.f48592f = i11;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i11, i11);
        layoutParams.leftMargin = (width - i11) / 6;
        layoutParams.topMargin = b(((height - i11) * 5) / 6);
        imageView.setLayoutParams(layoutParams);
    }

    public abstract void a(ViewGroup viewGroup);

    public void b() {
        Activity activity = this.f48588b;
        if (activity != null) {
            a(activity);
            b(this.f48588b);
            ViewGroup viewGroup = (ViewGroup) f.a(this.f48588b);
            if (viewGroup != null) {
                viewGroup.post(new C0431rd(this, viewGroup));
            }
        }
    }

    public abstract void c();
}
