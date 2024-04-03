package com.uxcam.internals;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import java.lang.ref.WeakReference;

public class hr {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f13589a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference f13590b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13591c;

    /* renamed from: d  reason: collision with root package name */
    public int f13592d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13593e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13594f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13595g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13596h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13597i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13598j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f13599k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f13600l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f13601m;

    public hr() {
        this.f13589a = new Rect();
        this.f13593e = false;
        this.f13594f = false;
        this.f13599k = false;
        this.f13600l = false;
        this.f13601m = false;
    }

    public boolean a() {
        return this.f13595g || this.f13596h || this.f13597i || this.f13598j;
    }

    public hr(View view) {
        Rect rect = new Rect();
        this.f13589a = rect;
        this.f13593e = false;
        this.f13594f = false;
        this.f13599k = false;
        this.f13600l = false;
        this.f13601m = false;
        view.getGlobalVisibleRect(rect);
        this.f13594f = view.isEnabled();
        this.f13593e = view.isClickable();
        this.f13595g = view.canScrollVertically(1);
        this.f13596h = view.canScrollVertically(-1);
        this.f13597i = view.canScrollHorizontally(-1);
        this.f13598j = view.canScrollHorizontally(1);
        this.f13599k = view instanceof ViewGroup;
        if (view instanceof CompoundButton) {
            if (ex.a("mOnCheckedChangeListener", (Object) view) != null) {
                this.f13601m = true;
            }
        } else if (!(view instanceof SeekBar)) {
            this.f13601m = view.hasOnClickListeners();
        } else if (ex.a("mOnSeekBarChangeListener", (Object) view) != null) {
            this.f13601m = true;
        }
        this.f13600l = view.isScrollContainer();
        this.f13590b = new WeakReference(view);
    }
}
