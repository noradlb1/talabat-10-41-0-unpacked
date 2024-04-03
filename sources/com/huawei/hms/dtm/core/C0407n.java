package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.f;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hms.dtm.core.n  reason: case insensitive filesystem */
public class C0407n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private View.OnClickListener f48522a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Activity> f48523b;

    public C0407n(Activity activity, View.OnClickListener onClickListener) {
        this.f48522a = onClickListener;
        this.f48523b = new WeakReference<>(activity);
    }

    private static boolean a(View view) {
        if (view == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i11 = R.id.dtm_onclick_timestamp_id;
        String str = (String) view.getTag(i11);
        if (!TextUtils.isEmpty(str) && currentTimeMillis - Long.parseLong(str) < 500) {
            return true;
        }
        view.setTag(i11, String.valueOf(currentTimeMillis));
        return false;
    }

    private void b(View view) {
        String str;
        String str2;
        Activity activity = this.f48523b.get();
        if (activity != null) {
            if (a(view)) {
                Logger.warn("DTM-AutoTrace", "Click too fast");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("$DTM_AT_TARGET", activity.getClass().getName());
            int id2 = view.getId();
            if (-1 != id2) {
                try {
                    bundle.putString("$DTM_AT_ID_NAME", activity.getResources().getResourceName(id2));
                } catch (Resources.NotFoundException e11) {
                    Logger.warn("DTM-AutoTrace", "resource not found:" + e11.getMessage());
                }
            }
            long nanoTime = System.nanoTime();
            C0427r a11 = C0432s.a(activity, view);
            Logger.debug("DTM-AutoTrace", "getViewXPathInfo time cost#" + (((float) (System.nanoTime() - nanoTime)) / 1000000.0f));
            if (a11 != null) {
                str = a11.a();
                str2 = a11.b();
            } else {
                str = null;
                str2 = null;
            }
            Logger.debug("DTM-AutoTrace", "getViewXPathInfo viewTreeId:" + str);
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("$DTM_AT_XPATH", str);
            }
            Logger.debug("DTM-AutoTrace", "getViewXPathInfo viewTreeListId:" + str2);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("$DTM_AT_XPATH_LIST", str2);
            }
            bundle.putString("$DTM_AT_CONTENT", (!(view instanceof TextView) || f.j(view)) ? "" : ((TextView) view).getText().toString());
            bundle.putLong("$DTM_AT_TIME", System.currentTimeMillis());
            bundle.putString("$DTM_AT_TYPE", "$DTM_AT_CLICK");
            C0417p.a(this.f48523b, bundle, view);
        }
    }

    public void onClick(View view) {
        long nanoTime = System.nanoTime();
        b(view);
        Logger.debug("DTM-AutoTrace", "trackView time cost#" + (((float) (System.nanoTime() - nanoTime)) / 1000000.0f));
        View.OnClickListener onClickListener = this.f48522a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
