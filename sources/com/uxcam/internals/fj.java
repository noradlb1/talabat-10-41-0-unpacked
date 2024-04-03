package com.uxcam.internals;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Locale;

@TargetApi(11)
public class fj {

    /* renamed from: g  reason: collision with root package name */
    public static ArrayList f13339g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public static ArrayList f13340h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public static boolean f13341i = false;

    /* renamed from: j  reason: collision with root package name */
    public static HandlerThread f13342j = new HandlerThread("screenActionLooper");

    /* renamed from: k  reason: collision with root package name */
    public static Handler f13343k = null;

    /* renamed from: a  reason: collision with root package name */
    public int f13344a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f13345b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f13346c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f13347d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f13348e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f13349f = 0;

    public class aa extends Handler {
        public aa(Looper looper) {
            super(looper);
        }
    }

    public class ab implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f13350a;

        public ab(ViewGroup viewGroup) {
            this.f13350a = viewGroup;
        }

        public void run() {
            fj.f13341i = true;
            try {
                Thread.sleep(800);
                for (int i11 = 0; i11 < fj.f13340h.size(); i11++) {
                    WeakReference weakReference = (WeakReference) fj.f13340h.get(i11);
                    if (weakReference == null || weakReference.get() == null) {
                        fj.f13340h.remove(i11);
                    }
                }
                new fj().a(this.f13350a);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
            fj.f13341i = false;
        }
    }

    public static void a() {
        if (!f13341i) {
            if (!f13342j.isAlive()) {
                f13342j.start();
                f13343k = new aa(f13342j.getLooper());
            }
            if (gm.B) {
                f13343k.post(new ab((ViewGroup) ((Activity) ia.c()).findViewById(16908290).getRootView()));
            }
        }
    }

    public final void a(ViewGroup viewGroup) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt != null) {
                if (childAt instanceof ViewGroup) {
                    int i12 = this.f13348e + 1;
                    this.f13348e = i12;
                    a(childAt, i12);
                    a((ViewGroup) childAt);
                } else if (childAt instanceof CompoundButton) {
                    int i13 = this.f13346c + 1;
                    this.f13346c = i13;
                    a(childAt, i13);
                } else if ((childAt instanceof Button) || (childAt instanceof ImageButton) || childAt.getClass().getName().contains("ActionMenuItemView")) {
                    int i14 = this.f13344a + 1;
                    this.f13344a = i14;
                    a(childAt, i14);
                } else if (childAt instanceof EditText) {
                    int i15 = this.f13345b + 1;
                    this.f13345b = i15;
                    a(childAt, i15);
                } else if (childAt instanceof SeekBar) {
                    int i16 = this.f13347d + 1;
                    this.f13347d = i16;
                    a(childAt, i16);
                } else {
                    int i17 = this.f13349f + 1;
                    this.f13349f = i17;
                    a(childAt, i17);
                }
            }
        }
    }

    public final void a(View view, int i11) {
        View.OnTouchListener onTouchListener;
        try {
            String str = hm.f13566i;
            if ((str == null || !str.toLowerCase(Locale.ROOT).equals("xamarin")) && view.isShown() && view.getVisibility() == 0) {
                int i12 = 0;
                int i13 = 0;
                while (i13 < f13340h.size()) {
                    WeakReference weakReference = (WeakReference) f13340h.get(i13);
                    if (weakReference == null || weakReference.get() != view) {
                        i13++;
                    } else {
                        return;
                    }
                }
                Class cls = view.getClass();
                while (cls != View.class) {
                    cls = cls.getSuperclass();
                }
                Field[] declaredFields = cls.getDeclaredFields();
                int length = declaredFields.length;
                while (true) {
                    if (i12 >= length) {
                        onTouchListener = null;
                        break;
                    }
                    Field field = declaredFields[i12];
                    if ("mListenerInfo".equals(field.getName())) {
                        field.setAccessible(true);
                        onTouchListener = (View.OnTouchListener) ex.a("mOnTouchListener", field.get(view));
                        break;
                    }
                    i12++;
                }
                if (!(onTouchListener instanceof hv)) {
                    view.setOnTouchListener(new hv(onTouchListener, i11));
                    f13340h.add(new WeakReference(view));
                    return;
                }
                ((hv) onTouchListener).f13608b = i11;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
