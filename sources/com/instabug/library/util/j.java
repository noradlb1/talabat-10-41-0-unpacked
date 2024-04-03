package com.instabug.library.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.view.ViewUtils;
import com.instabug.library.visualusersteps.y;
import java.lang.ref.WeakReference;

public class j implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f52067a = new h(this);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference f52068b;

    /* renamed from: c  reason: collision with root package name */
    private final i f52069c;

    public j(@NonNull Activity activity, @NonNull i iVar) {
        WeakReference weakReference = new WeakReference(activity);
        this.f52068b = weakReference;
        this.f52069c = iVar;
        d((Activity) weakReference.get());
        c((Activity) weakReference.get());
    }

    /* access modifiers changed from: private */
    public void a(boolean z11) {
        this.f52069c.a(z11);
    }

    private void c(@Nullable Activity activity) {
        View a11 = a(activity);
        if (a11 != null) {
            a11.getViewTreeObserver().addOnGlobalFocusChangeListener(this);
        }
    }

    private void d(@Nullable Activity activity) {
        View a11 = a(activity);
        if (a11 != null) {
            a11.getViewTreeObserver().addOnGlobalLayoutListener(this.f52067a);
        }
    }

    public void onGlobalFocusChanged(View view, View view2) {
        if (view2 != null) {
            if (!(view2 instanceof EditText)) {
                y.d().f52201a = null;
                y.d().b(false);
            } else if (view == null || view != view2) {
                y.d().f52201a = new WeakReference(view2);
                y.d().a(view, view2);
            }
        }
    }

    public final void a() {
        View a11;
        WeakReference weakReference = this.f52068b;
        if (weakReference != null && (a11 = a((Activity) weakReference.get())) != null) {
            a11.getViewTreeObserver().removeOnGlobalLayoutListener(this.f52067a);
            a11.getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        }
    }

    public final boolean b(@Nullable Activity activity) {
        View a11;
        if (activity == null || (a11 = a(activity)) == null) {
            return false;
        }
        Rect rect = new Rect();
        a11.getWindowVisibleDisplayFrame(rect);
        if (activity.getWindow().getDecorView().getRootView().getHeight() - rect.height() > ViewUtils.convertDpToPx(activity, 100.0f)) {
            return true;
        }
        return false;
    }

    @Nullable
    public View a(@Nullable Activity activity) {
        if (activity != null) {
            return activity.getWindow().getDecorView().getRootView();
        }
        return null;
    }
}
