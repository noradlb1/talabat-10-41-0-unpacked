package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.webkit.WebView;
import com.huawei.hms.dtm.core.util.f;
import java.util.ArrayList;
import java.util.List;

public class Cd {

    /* renamed from: a  reason: collision with root package name */
    private List<View> f48271a = new ArrayList();

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final Cd f48272a = new Cd();
    }

    private int a(Rect rect, Rect rect2) {
        int i11 = rect.left;
        int i12 = rect2.left;
        if (i11 - i12 <= 0) {
            i11 = i12;
        }
        int i13 = rect.top;
        int i14 = rect2.top;
        if (i13 - i14 <= 0) {
            i13 = i14;
        }
        int i15 = rect.right;
        int i16 = rect2.right;
        if (i15 - i16 >= 0) {
            i15 = i16;
        }
        int i17 = rect.bottom;
        int i18 = rect2.bottom;
        if (i17 - i18 >= 0) {
            i17 = i18;
        }
        if (i11 >= i15 || i13 >= i17) {
            return 0;
        }
        return (i15 - i11) * (i17 - i13);
    }

    public static Cd a() {
        return a.f48272a;
    }

    private List<View> a(View view, List<View> list) {
        int indexOf;
        if (list == null || list.isEmpty() || (indexOf = list.indexOf(view)) < 0 || indexOf >= list.size() - 1) {
            return null;
        }
        return list.subList(indexOf + 1, list.size());
    }

    private List<View> b(View view) {
        List<View> e11 = f.e(view);
        if (e11 != null && !e11.isEmpty()) {
            view = e11.get(e11.size() - 1);
        }
        return a(view, this.f48271a);
    }

    private boolean c(View view) {
        List<View> e11;
        if (!(view == null || (e11 = f.e(view)) == null || e11.isEmpty())) {
            for (View next : e11) {
                if (next != null && (next.hasOnClickListeners() || (next instanceof WebView))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(Activity activity) {
        View findViewById;
        if (activity != null && !activity.isFinishing() && (findViewById = activity.findViewById(16908290)) != null) {
            this.f48271a = f.e(findViewById);
        }
    }

    public boolean a(View view) {
        int a11;
        Rect f11 = f.f(view);
        if (f11 == null) {
            return true;
        }
        List<View> b11 = b(view);
        if (b11 == null || b11.isEmpty()) {
            return false;
        }
        int width = f11.width() * f11.height();
        boolean z11 = false;
        for (View next : b11) {
            Rect f12 = f.f(next);
            if (f12 != null && (a11 = a(f11, f12)) > 0) {
                z11 = ((float) a11) / (((float) width) * 1.0f) >= 0.75f && f.a(next) > 185 && c(next);
                if (z11) {
                    break;
                }
            }
        }
        return z11;
    }

    public void b() {
        List<View> list = this.f48271a;
        if (list != null) {
            list.clear();
        }
    }
}
