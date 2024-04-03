package com.checkout.threedsecure.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0003¨\u0006\t"}, d2 = {"Lcom/checkout/threedsecure/webview/ThreeDSWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cleanup", "", "destroy", "setup", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ViewConstructor"})
public final class ThreeDSWebView extends WebView {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThreeDSWebView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setup();
    }

    private final void cleanup() {
        clearHistory();
        onPause();
        removeAllViews();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void setup() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void destroy() {
        cleanup();
        super.destroy();
    }
}
