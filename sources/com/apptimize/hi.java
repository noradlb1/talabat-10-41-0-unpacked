package com.apptimize;

import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class hi extends gu {

    /* renamed from: b  reason: collision with root package name */
    private static final String f42939b = "hi";

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f42940c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f42941d = Boolean.TRUE;

    /* renamed from: e  reason: collision with root package name */
    private hg f42942e;

    public hi(View view, he heVar, Integer num, hg hgVar) {
        super(view, heVar, num, hgVar);
        this.f42942e = hgVar;
    }

    private boolean m() {
        Boolean bool = f42940c;
        return bool != null && !bool.booleanValue();
    }

    public List<hf> a() {
        int i11;
        ArrayList arrayList = new ArrayList();
        View view = i().get();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            a(viewGroup);
            if (!m()) {
                return arrayList;
            }
            int childCount = viewGroup.getChildCount();
            ViewGroup.LayoutParams layoutParams = null;
            for (int i12 = 0; i12 < childCount; i12++) {
                try {
                    View childAt = viewGroup.getChildAt(i12);
                    if (this.f42942e.a(childAt)) {
                        if (f42941d.booleanValue()) {
                            layoutParams = childAt.getLayoutParams();
                            Field declaredField = layoutParams.getClass().getDeclaredField("position");
                            declaredField.setAccessible(true);
                            i11 = declaredField.getInt(layoutParams);
                        } else {
                            i11 = i12;
                        }
                        arrayList.add(this.f42942e.a(childAt, (he) this, Integer.valueOf(i11)));
                    }
                } catch (Exception e11) {
                    String str = f42939b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unexpected error when accessing child position ");
                    sb2.append(i12);
                    sb2.append(" of ");
                    sb2.append(childCount);
                    sb2.append(" ");
                    sb2.append(layoutParams == null ? "null" : layoutParams.getClass().getName());
                    bo.d(str, sb2.toString(), e11);
                }
            }
        }
        return arrayList;
    }

    private void a(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() > 0) {
            try {
                viewGroup.getChildAt(0).getLayoutParams().getClass().getDeclaredField("gravity");
                f42940c = Boolean.FALSE;
            } catch (Exception unused) {
                f42940c = Boolean.TRUE;
                bo.j(f42939b, "Apptimize was unable to properly process a ViewPager's children.The most likely cause is ProGuard. Consult the Apptimize docs  for information on how to adjust your ProGuard configuration.");
            }
            try {
                viewGroup.getChildAt(0).getLayoutParams().getClass().getDeclaredField("position");
                f42941d = Boolean.TRUE;
            } catch (Exception unused2) {
                f42941d = Boolean.FALSE;
            }
        }
    }
}
