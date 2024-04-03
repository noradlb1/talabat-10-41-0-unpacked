package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.hms.dtm.core.Kd;
import com.huawei.hms.dtm.core.Md;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.c;
import com.huawei.hms.dtm.core.util.f;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class Jd {
    private static int a(Md md2, View view, int i11) {
        if (md2.a() > 0) {
            return md2.a();
        }
        if (f.i((ViewGroup) view.getParent())) {
            return i11;
        }
        return 0;
    }

    public static Kd a(Activity activity) {
        Logger.debug("DTM-AutoTrace", "getViewTree in Thread:" + Thread.currentThread().getName());
        Window window = activity.getWindow();
        C0427r rVar = null;
        if (window == null) {
            return null;
        }
        View decorView = window.getDecorView();
        float f11 = 1.0f / Resources.getSystem().getDisplayMetrics().density;
        View findViewById = activity.findViewById(16908290);
        if (!(findViewById instanceof ViewGroup)) {
            return null;
        }
        ViewParent parent = findViewById.getParent();
        int left = findViewById.getLeft();
        int top = findViewById.getTop();
        while (parent != null && parent != decorView) {
            if (parent instanceof View) {
                View view = (View) parent;
                top += view.getTop();
                left += view.getLeft();
            }
            parent = parent.getParent();
        }
        Md md2 = new Md();
        md2.a(f.a(findViewById));
        md2.a(new Md.a(f11).c((float) left).d((float) top).b((float) findViewById.getWidth()).a((float) findViewById.getHeight()));
        ViewParent parent2 = findViewById.getParent();
        if (parent2 instanceof ViewGroup) {
            rVar = C0432s.a((ViewGroup) parent2, new C0427r(), findViewById, 0);
        }
        ViewGroup viewGroup = (ViewGroup) findViewById;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            a(a(viewGroup.getChildAt(i11), i11, viewGroup, rVar), md2, 0, 0, f11, 1);
        }
        return new Kd().a(new Kd.a(f11).b((float) decorView.getWidth()).a((float) decorView.getHeight())).b(activity.getClass().getName()).a(md2);
    }

    private static Ld a(View view, int i11, ViewGroup viewGroup, C0427r rVar) {
        Ld ld2 = new Ld();
        ld2.a(view);
        ld2.a(i11);
        ld2.a(viewGroup);
        ld2.a(rVar);
        return ld2;
    }

    private static JSONObject a(WebView webView) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String[] strArr = {null};
        Activity b11 = c.a().b();
        if (b11 == null) {
            return null;
        }
        b11.runOnUiThread(new Id(webView, new Hd(countDownLatch, strArr)));
        try {
            if (!countDownLatch.await(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                Logger.debug("DTM-AutoTrace", "getXpathFromJS#CountDownLatch.await timeout: 2000");
            }
            if (!TextUtils.isEmpty(strArr[0])) {
                return new JSONObject(strArr[0]);
            }
            Logger.debug("DTM-AutoTrace", "jsonResult jsonStr null");
            return null;
        } catch (InterruptedException | JSONException unused) {
        }
    }

    private static void a(WebView webView, Md md2, int i11, int i12) {
        a(md2, a(webView), i11, i12, 1.0f);
    }

    private static void a(Ld ld2, Md md2, int i11, int i12, float f11, int i13) {
        if (a(ld2) && !Cd.a().a(ld2.a())) {
            View a11 = ld2.a();
            C0427r a12 = C0432s.a(ld2.c(), ld2.d(), a11, ld2.b());
            Md md3 = new Md();
            md3.a(f.a(a11));
            md3.a(new Md.a(f11).c(a11.getX() - ((float) i11)).d(a11.getY() - ((float) i12)).b((float) a11.getWidth()).a((float) a11.getHeight()));
            md3.b(a12.a());
            md3.d(a12.b());
            md3.b(a(md2, a11, i13));
            md3.b(a(a11));
            md3.a(b(a11));
            md3.a(a12.c());
            md3.c(c(a11));
            md2.a(md3);
            if (a11 instanceof WebView) {
                a((WebView) a11, md3, i11, i12);
            } else if (a11 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) a11;
                int childCount = viewGroup.getChildCount();
                for (int i14 = 0; i14 < childCount; i14++) {
                    a(a(viewGroup.getChildAt(i14), i14, viewGroup, a12), md3, viewGroup.getScrollX(), viewGroup.getScrollY(), f11, i13 + 1);
                }
            }
        }
    }

    private static void a(Md md2, JSONObject jSONObject, int i11, int i12, float f11) {
        Md md3 = md2;
        JSONObject jSONObject2 = jSONObject;
        int i13 = i11;
        int i14 = i12;
        float f12 = f11;
        if (jSONObject2 != null) {
            boolean z11 = true;
            try {
                md3.d(true);
                if (!jSONObject2.isNull("url")) {
                    md3.f(jSONObject2.getString("url"));
                }
                Md md4 = new Md();
                md4.d(true);
                if (!jSONObject2.isNull("id")) {
                    md4.b(jSONObject2.getString("id"));
                }
                if (!jSONObject2.isNull("idList")) {
                    md4.d(jSONObject2.getString("idList"));
                }
                if (!jSONObject2.isNull("idRange")) {
                    md4.c(jSONObject2.getString("idRange"));
                }
                if (!jSONObject2.isNull("tagName")) {
                    md4.e(jSONObject2.getString("tagName"));
                }
                md4.a(false);
                md4.b(0);
                if (!jSONObject2.isNull("content")) {
                    md4.a(jSONObject2.getString("content"));
                }
                md4.b(!jSONObject2.isNull("isEdit") ? jSONObject2.getBoolean("isEdit") : true);
                if (!jSONObject2.isNull("isParam")) {
                    z11 = jSONObject2.getBoolean("isParam");
                }
                md4.c(z11);
                if (!jSONObject2.isNull(TypedValues.AttributesType.S_FRAME)) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(TypedValues.AttributesType.S_FRAME);
                    md4.a(new Md.a(f12).c((float) (jSONObject3.getInt(Param.X) - i13)).d((float) (jSONObject3.getInt(Param.Y) - i14)).b((float) jSONObject3.getInt("w")).a((float) jSONObject3.getInt("h")));
                }
                if (!jSONObject2.isNull("child")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("child");
                    int length = jSONArray.length();
                    for (int i15 = 0; i15 < length; i15++) {
                        a(md4, (JSONObject) jSONArray.get(i15), i13, i14, f12);
                    }
                }
                md3.a(md4);
            } catch (JSONException e11) {
                Logger.info("DTM-AutoTrace", "failed to get viewTree of WebView#" + e11.getMessage());
            }
        }
    }

    private static boolean a(View view) {
        if (view == null || (view instanceof WebView)) {
            return false;
        }
        return view.hasOnClickListeners();
    }

    private static boolean a(Ld ld2) {
        return (ld2 == null || ld2.a() == null || ld2.b() < 0 || ld2.c() == null || ld2.d() == null) ? false : true;
    }

    private static String b(View view) {
        if (!(view instanceof TextView) || f.j(view)) {
            return "";
        }
        String charSequence = ((TextView) view).getText().toString();
        return !TextUtils.isEmpty(charSequence) ? charSequence : "";
    }

    private static boolean c(View view) {
        return ((view instanceof TextView) && !f.j(view) && !(view instanceof RadioButton)) || (view instanceof RadioGroup) || (view instanceof Switch);
    }
}
