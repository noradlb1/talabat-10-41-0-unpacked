package com.apptimize;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class ib {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f43008a = "ib";

    public static void a(hl hlVar, Resources resources) {
        hm<String> hmVar = hm.f42956e;
        Class<TextView> cls = TextView.class;
        Class<CharSequence> cls2 = CharSequence.class;
        hj a11 = hlVar.a((hj<?, ?, ?>) hj.a("text", hmVar, new iy(), iu.a(cls, cls2, "text")));
        Class cls3 = Boolean.TYPE;
        Class cls4 = Integer.TYPE;
        a11.a(hlVar, "setText", (Class<?>[]) new Class[]{cls2, TextView.BufferType.class, cls3, cls4});
        hlVar.b(hj.a("textColor", hm.f42952a, new ja(), iu.a(cls, ColorStateList.class, "textColor", "getTextColors", "setTextColor"))).a(hlVar, "setTextColor", (Class<?>[]) new Class[]{cls4});
        hlVar.a((hj<?, ?, ?>) hj.a("textSize", hm.f42953b, jc.a(new jf(), jk.b(resources)), new iu<Float, TextView>(cls, Float.class, "textSize") {

            /* renamed from: a  reason: collision with root package name */
            private final Method f43009a = fn.a((Class<?>) TextView.class, "setTextSize", (Class<?>[]) new Class[]{Integer.TYPE, Float.TYPE});

            public Method a() throws NoSuchMethodException {
                return this.f43009a;
            }

            public void a(TextView textView, Float f11) {
                textView.setTextSize(0, f11.floatValue());
            }
        })).a(hlVar, "setRawTextSize", (Class<?>[]) new Class[]{Float.TYPE});
        hlVar.b(hj.a("textStyle", ho.a((JSONObject) new JSONObject() {
            {
                try {
                    put("Normal", 0);
                    put("Bold", 1);
                    put("Bold italic", 3);
                    put("Italic", 2);
                } catch (JSONException e11) {
                    bo.g(ib.f43008a, "Error initializing options: ", e11);
                }
            }
        }), new ix()));
        hlVar.b(hj.a(ViewHierarchyConstants.HINT_KEY, hmVar, new je(), iu.a(cls, cls2, ViewHierarchyConstants.HINT_KEY)));
        hlVar.b(hj.a("gravityHorizontal", ho.a((JSONObject) new JSONObject() {
            {
                try {
                    put("None", 0);
                    put("Center", 1);
                    put("Left", 3);
                    put("Right", 5);
                } catch (JSONException e11) {
                    bo.g(ib.f43008a, "Error initializing options: ", e11);
                }
            }
        }), iv.f43083a));
        hlVar.b(hj.a("gravityVertical", ho.a((JSONObject) new JSONObject() {
            {
                try {
                    put("None", 0);
                    put("Center", 16);
                    put("Top", 48);
                    put("Bottom", 80);
                } catch (JSONException e11) {
                    bo.g(ib.f43008a, "Error initializing options: ", e11);
                }
            }
        }), iv.f43084b));
        hm<Number> hmVar2 = hm.f42954c;
        hlVar.b(hj.a("width", hmVar2, jc.a(new jg(), jk.a(resources)), new iu(cls, cls4, "width")));
        hlVar.b(hj.a("height", hmVar2, jc.a(new jg(), jk.a(resources)), new iu(cls, cls4, "height")));
        Class<TextUtils.TruncateAt> cls5 = TextUtils.TruncateAt.class;
        hlVar.b(hj.a("ellipsize", ho.a((JSONObject) new JSONObject() {
            {
                try {
                    put("None", Integer.MAX_VALUE);
                    put("Start", TextUtils.TruncateAt.START.ordinal());
                    put("Middle", TextUtils.TruncateAt.MIDDLE.ordinal());
                    put("End", TextUtils.TruncateAt.END.ordinal());
                    put("Marquee", TextUtils.TruncateAt.MARQUEE.ordinal());
                } catch (JSONException e11) {
                    bo.g(ib.f43008a, "Error initializing options: ", e11);
                }
            }
        }), new jd(cls5), iu.a(cls, cls5, "ellipsize")));
        hlVar.b(hj.a("maxLines", hmVar2, new jg(), iu.a(cls, cls4, "maxLines")));
        hlVar.b(hj.a("textSelectable", hm.f42957f, ji.a(Boolean.class), iu.a(cls, cls3, "textSelectable", "isTextSelectable", "setTextIsSelectable")));
    }
}
