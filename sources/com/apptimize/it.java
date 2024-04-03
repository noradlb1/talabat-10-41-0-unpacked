package com.apptimize;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class it extends io {

    /* renamed from: a  reason: collision with root package name */
    private static final String f43072a = "it";

    /* renamed from: b  reason: collision with root package name */
    private static Method f43073b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f43074c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f43075d;

    /* renamed from: e  reason: collision with root package name */
    private StateListDrawable f43076e;

    /* renamed from: f  reason: collision with root package name */
    private List<int[]> f43077f;

    public static class a extends RuntimeException {
        public a() {
        }

        public a(Throwable th2) {
            super(th2);
        }
    }

    public static class b extends a {
    }

    static {
        Class<StateListDrawable> cls = StateListDrawable.class;
        try {
            f43073b = cls.getMethod("getStateCount", new Class[0]);
            Class cls2 = Integer.TYPE;
            f43074c = cls.getMethod("getStateSet", new Class[]{cls2});
            f43075d = cls.getMethod("getStateDrawable", new Class[]{cls2});
        } catch (NoSuchMethodException unused) {
        }
    }

    public it(iq iqVar, StateListDrawable stateListDrawable, List<int[]> list) {
        super(iqVar);
        this.f43076e = stateListDrawable;
        this.f43077f = Collections.unmodifiableList(new ArrayList(list));
    }

    private static boolean d() {
        return (f43073b == null || f43074c == null || f43075d == null) ? false : true;
    }

    private StateListDrawable e() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        for (int i11 = 0; i11 < c(); i11++) {
            stateListDrawable.addState(b(i11), a(i11));
        }
        return stateListDrawable;
    }

    public List<Drawable> a() throws a {
        if (d()) {
            ArrayList arrayList = new ArrayList();
            int c11 = c();
            for (int i11 = 0; i11 < c11; i11++) {
                arrayList.add(a(i11));
            }
            return arrayList;
        }
        throw new b();
    }

    public String b() {
        return "stateful";
    }

    public int[] b(int i11) throws a {
        if (d()) {
            try {
                return (int[]) f43074c.invoke(this.f43076e, new Object[]{Integer.valueOf(i11)});
            } catch (IllegalAccessException e11) {
                throw new a(e11);
            } catch (InvocationTargetException e12) {
                throw new a(e12);
            }
        } else {
            throw new b();
        }
    }

    public int c() throws a {
        if (d()) {
            try {
                return ((Integer) f43073b.invoke(this.f43076e, new Object[0])).intValue();
            } catch (IllegalAccessException e11) {
                throw new a(e11);
            } catch (InvocationTargetException e12) {
                throw new a(e12);
            }
        } else {
            throw new b();
        }
    }

    public Drawable a(int i11) throws a {
        if (d()) {
            try {
                return (Drawable) f43075d.invoke(this.f43076e, new Object[]{Integer.valueOf(i11)});
            } catch (IllegalAccessException e11) {
                throw new a(e11);
            } catch (InvocationTargetException e12) {
                throw new a(e12);
            }
        } else {
            throw new b();
        }
    }

    public void a(ih ihVar) throws hk {
        try {
            for (Drawable a11 : a()) {
                ip.a(a11).a(ihVar);
            }
        } catch (a unused) {
            bo.g(f43072a, "Could not access images in StateListDrawable. Some images may be removed.");
        }
    }

    public Drawable a(io ioVar) throws hk {
        if (this.f43077f.isEmpty()) {
            return this.f43076e;
        }
        if (ioVar instanceof it) {
            it itVar = (it) ioVar;
            StateListDrawable e11 = e();
            for (int[] next : this.f43077f) {
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    if (i11 >= itVar.c()) {
                        break;
                    } else if (Arrays.equals(itVar.b(i11), next)) {
                        e11.addState(next, itVar.a(i11));
                        z11 = true;
                        continue;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (!z11) {
                    throw new hk("Expected state list in original StateListDrawable, but not found: " + Arrays.toString(next));
                }
            }
            return e11;
        }
        throw new hk("Expecting original image to be a StateListDrawable; found " + ioVar);
    }
}
