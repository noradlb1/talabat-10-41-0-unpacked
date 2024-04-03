package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class _d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final float f48444a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Vd> f48445b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Wd> f48446c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final _d f48447a = new _d((Zd) null);
    }

    private _d() {
        this.f48445b = null;
        this.f48446c = null;
        this.f48444a = J.a().getResources().getDisplayMetrics().density;
    }

    public /* synthetic */ _d(Zd zd2) {
        this();
    }

    private void a(Activity activity, WebView webView) {
        activity.runOnUiThread(new Zd(this, webView));
    }

    public static _d b() {
        return a.f48447a;
    }

    public float a() {
        return this.f48444a;
    }

    public float a(WebView webView) {
        Vd vd2;
        if (this.f48445b == null || webView == null || (vd2 = this.f48445b.get(String.valueOf(webView.hashCode()))) == null) {
            return 1.0f;
        }
        return vd2.a();
    }

    public void a(View view, Activity activity) {
        this.f48445b = new HashMap();
        this.f48446c = new HashMap();
        if (view instanceof WebView) {
            a(activity, (WebView) view);
        } else if (view instanceof ViewGroup) {
            LinkedList linkedList = new LinkedList();
            linkedList.offer((ViewGroup) view);
            while (!linkedList.isEmpty()) {
                ViewGroup viewGroup = (ViewGroup) linkedList.poll();
                if (viewGroup != null) {
                    for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (childAt instanceof WebView) {
                            a(activity, (WebView) childAt);
                        } else if (childAt instanceof ViewGroup) {
                            linkedList.offer((ViewGroup) childAt);
                        }
                    }
                }
            }
        }
    }

    public void b(WebView webView) {
        String url;
        if (webView != null && (url = webView.getUrl()) != null) {
            Logger.debug("DTM-AutoTrace", "JsManager.logWebViewLeave: " + url);
            Wd wd2 = this.f48446c.get(String.valueOf(webView.hashCode()));
            if (wd2 != null) {
                wd2.a(url);
            }
        }
    }

    public void c() {
        Map<String, Vd> map = this.f48445b;
        if (map != null) {
            map.clear();
            this.f48445b = null;
        }
        Map<String, Wd> map2 = this.f48446c;
        if (map2 != null) {
            map2.clear();
            this.f48446c = null;
        }
    }
}
