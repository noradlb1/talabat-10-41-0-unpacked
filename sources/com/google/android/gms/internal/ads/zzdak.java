package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.zzt;
import com.huawei.hms.flutter.map.constants.Param;
import org.json.JSONObject;

public final class zzdak extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzdak(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzdak zza(Context context, View view, zzfdn zzfdn) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzdak zzdak = new zzdak(context);
        if (!(zzfdn.zzv.isEmpty() || (resources = zzdak.zza.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzfdo zzfdo = zzfdn.zzv.get(0);
            float f11 = displayMetrics.density;
            zzdak.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzfdo.zza) * f11), (int) (((float) zzfdo.zzb) * f11)));
        }
        zzdak.zzb = view;
        zzdak.addView(view);
        zzt.zzx();
        zzcjz.zzb(zzdak, zzdak);
        zzt.zzx();
        zzcjz.zza(zzdak, zzdak);
        JSONObject jSONObject = zzfdn.zzaf;
        RelativeLayout relativeLayout = new RelativeLayout(zzdak.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            zzdak.zzc(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzdak.zzc(optJSONObject2, relativeLayout, 12);
        }
        zzdak.addView(relativeLayout);
        return zzdak;
    }

    private final int zzb(double d11) {
        zzbgo.zzb();
        return zzcis.zzs(this.zza, (int) d11);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i11) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb2 = zzb(jSONObject.optDouble(Param.PADDING, 0.0d));
        textView.setPadding(0, zzb2, 0, zzb2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i11);
        relativeLayout.addView(textView, layoutParams);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }
}
