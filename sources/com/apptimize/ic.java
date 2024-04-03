package com.apptimize;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class ic {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f43010a = "ic";

    public static void a(hl hlVar, Resources resources, ii iiVar) {
        hl hlVar2 = hlVar;
        Class<View> cls = View.class;
        hlVar.b(hj.a("visibility", ho.a((JSONObject) new JSONObject() {
            {
                try {
                    put("Visible", 0);
                    put("Invisible", 4);
                    put("Gone", 8);
                } catch (JSONException e11) {
                    bo.g(ic.f43010a, "Error initializing options: ", e11);
                }
            }
        }), cls));
        hm<Number> hmVar = hm.f42954c;
        Class<Number> cls2 = Number.class;
        hj a11 = hlVar.a((hj<?, ?, ?>) hj.a("paddingLeft", hmVar, jk.a(resources), new iu<Number, View>(cls, cls2, "paddingLeft") {

            /* renamed from: a  reason: collision with root package name */
            private final Method f43011a;

            {
                Class cls = Integer.TYPE;
                this.f43011a = fn.a((Class<?>) View.class, "setPadding", (Class<?>[]) new Class[]{cls, cls, cls, cls});
            }

            public Method a() throws NoSuchMethodException {
                return this.f43011a;
            }

            public void a(View view, Number number) {
                view.setPadding(number.intValue(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
            }
        }));
        Class cls3 = Integer.TYPE;
        a11.a(hlVar, "internalSetPadding", (Class<?>[]) new Class[]{cls3, cls3, cls3, cls3}).a(hlVar, "resetPaddingToInitialValues", (Class<?>[]) new Class[0]);
        hlVar.a((hj<?, ?, ?>) hj.a("paddingTop", hmVar, jk.a(resources), new iu<Number, View>(cls, cls2, "paddingTop") {
            public Method a() throws NoSuchMethodException {
                Class cls = Integer.TYPE;
                return View.class.getMethod("setPadding", new Class[]{cls, cls, cls, cls});
            }

            public void a(View view, Number number) {
                view.setPadding(view.getPaddingLeft(), number.intValue(), view.getPaddingRight(), view.getPaddingBottom());
            }
        })).a(hlVar, "internalSetPadding", (Class<?>[]) new Class[]{cls3, cls3, cls3, cls3}).a(hlVar, "resetPaddingToInitialValues", (Class<?>[]) new Class[0]);
        hlVar.a((hj<?, ?, ?>) hj.a("paddingRight", hmVar, jk.a(resources), new iu<Number, View>(cls, cls2, "paddingRight") {
            public Method a() throws NoSuchMethodException {
                Class cls = Integer.TYPE;
                return View.class.getMethod("setPadding", new Class[]{cls, cls, cls, cls});
            }

            public void a(View view, Number number) {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), number.intValue(), view.getPaddingBottom());
            }
        })).a(hlVar, "internalSetPadding", (Class<?>[]) new Class[]{cls3, cls3, cls3, cls3}).a(hlVar, "resetPaddingToInitialValues", (Class<?>[]) new Class[0]);
        hlVar.a((hj<?, ?, ?>) hj.a("paddingBottom", hmVar, jk.a(resources), new iu<Number, View>(cls, cls2, "paddingBottom") {
            public Method a() throws NoSuchMethodException {
                Class cls = Integer.TYPE;
                return View.class.getMethod("setPadding", new Class[]{cls, cls, cls, cls});
            }

            public void a(View view, Number number) {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), number.intValue());
            }
        })).a(hlVar, "internalSetPadding", (Class<?>[]) new Class[]{cls3, cls3, cls3, cls3}).a(hlVar, "resetPaddingToInitialValues", (Class<?>[]) new Class[0]);
        hm<Number> hmVar2 = hm.f42953b;
        jf jfVar = new jf();
        Class cls4 = Float.TYPE;
        hlVar.b(hj.a("alpha", hmVar2, jfVar, iu.a(cls, cls4, "alpha"))).a(hlVar, "setAlphaNoInvalidation", (Class<?>[]) new Class[]{cls4});
        hlVar.b(hj.a("background", Cif.f43020b, Cif.a(iiVar.f()), new ie(iiVar.f(), iu.a(cls, Drawable.class, "background"))));
        hlVar.b(hj.a("scrollbarFadingEnabled", hm.f42957f, ji.a(Boolean.class), iu.a(cls, Boolean.TYPE, "scrollbarFadingEnabled")));
        hlVar.b(hj.a("textAlignment", ho.a((JSONObject) new JSONObject() {
            {
                try {
                    put("Center", 4);
                    put("Gravity", 1);
                    put("Inherit", 0);
                    put("Text end", 3);
                    put("Text start", 2);
                    put("View end", 6);
                    put("View start", 5);
                } catch (JSONException e11) {
                    bo.g(ic.f43010a, "Error initializing options: ", e11);
                }
            }
        }), cls));
    }
}
