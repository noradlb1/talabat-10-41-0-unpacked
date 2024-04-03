package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.braze.models.inappmessage.InAppMessageBase;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzfdn;
import com.google.android.gms.internal.ads.zzfps;
import com.google.android.gms.internal.ads.zzfqp;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import net.bytebuddy.pool.TypePool;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcb {
    public static Point zza(MotionEvent motionEvent, @Nullable View view) {
        int[] zzj = zzj(view);
        float rawX = motionEvent.getRawX();
        return new Point(((int) rawX) - zzj[0], ((int) motionEvent.getRawY()) - zzj[1]);
    }

    public static WindowManager.LayoutParams zzb() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzbgq.zzc().zzb(zzblj.zzfP)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = BadgeDrawable.TOP_START;
        return layoutParams;
    }

    public static JSONObject zzc(@Nullable String str, Context context, Point point, Point point2) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(Param.X, zzbgo.zzb().zzb(context, point2.x));
                    jSONObject3.put(Param.Y, zzbgo.zzb().zzb(context, point2.y));
                    jSONObject3.put("start_x", zzbgo.zzb().zzb(context, point.x));
                    jSONObject3.put("start_y", zzbgo.zzb().zzb(context, point.y));
                    jSONObject = jSONObject3;
                } catch (JSONException e11) {
                    zzciz.zzh("Error occurred while putting signals into JSON object.", e11);
                }
                jSONObject2.put("click_point", (Object) jSONObject);
                jSONObject2.put(InstabugDbContract.AnnouncementAssetsEntry.COLUMN_ID, (Object) str);
                return jSONObject2;
            } catch (Exception e12) {
                e = e12;
                jSONObject = jSONObject2;
                zzciz.zzh("Error occurred while grabbing click signals.", e);
                return jSONObject;
            }
        } catch (Exception e13) {
            e = e13;
            zzciz.zzh("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
    }

    public static JSONObject zzd(Context context, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, @Nullable View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Map.Entry entry;
        boolean z11;
        Context context2 = context;
        Map<String, WeakReference<View>> map3 = map2;
        JSONObject jSONObject3 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject3;
        }
        int[] zzj = zzj(view);
        Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            View view2 = (View) ((WeakReference) next.getValue()).get();
            if (view2 != null) {
                int[] zzj2 = zzj(view2);
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                Iterator<Map.Entry<String, WeakReference<View>>> it2 = it;
                try {
                    JSONObject jSONObject6 = jSONObject3;
                    try {
                        jSONObject5.put("width", zzbgo.zzb().zzb(context2, view2.getMeasuredWidth()));
                        jSONObject5.put("height", zzbgo.zzb().zzb(context2, view2.getMeasuredHeight()));
                        jSONObject5.put(Param.X, zzbgo.zzb().zzb(context2, zzj2[0] - zzj[0]));
                        jSONObject5.put(Param.Y, zzbgo.zzb().zzb(context2, zzj2[1] - zzj[1]));
                        jSONObject5.put("relative_to", (Object) "ad_view");
                        jSONObject4.put(TypedValues.AttributesType.S_FRAME, (Object) jSONObject5);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject2 = zzk(context2, rect);
                        } else {
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("width", 0);
                            jSONObject2.put("height", 0);
                            jSONObject2.put(Param.X, zzbgo.zzb().zzb(context2, zzj2[0] - zzj[0]));
                            jSONObject2.put(Param.Y, zzbgo.zzb().zzb(context2, zzj2[1] - zzj[1]));
                            jSONObject2.put("relative_to", (Object) "ad_view");
                        }
                        jSONObject4.put("visible_bounds", (Object) jSONObject2);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject4.put(InAppMessageBase.MESSAGE_TEXT_COLOR, textView.getCurrentTextColor());
                            entry = next;
                            jSONObject4.put(ViewHierarchyConstants.TEXT_SIZE, (double) textView.getTextSize());
                            jSONObject4.put("text", (Object) textView.getText());
                        } else {
                            entry = next;
                        }
                        if (map3 == null || !map3.containsKey(entry.getKey()) || !view2.isClickable()) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        jSONObject4.put("is_clickable", z11);
                        jSONObject = jSONObject6;
                        try {
                            jSONObject.put((String) entry.getKey(), (Object) jSONObject4);
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        jSONObject = jSONObject6;
                        zzciz.zzj("Unable to get asset views information");
                        jSONObject3 = jSONObject;
                        it = it2;
                    }
                } catch (JSONException unused3) {
                    jSONObject = jSONObject3;
                    zzciz.zzj("Unable to get asset views information");
                    jSONObject3 = jSONObject;
                    it = it2;
                }
                jSONObject3 = jSONObject;
                it = it2;
            }
        }
        return jSONObject3;
    }

    public static JSONObject zze(Context context, @Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzt.zzp();
            jSONObject.put("can_show_on_lock_screen", zzt.zzt(view));
            zzt.zzp();
            jSONObject.put("is_keyguard_locked", zzt.zzH(context));
        } catch (JSONException unused) {
            zzciz.zzj("Unable to get lock screen information");
        }
        return jSONObject;
    }

    public static JSONObject zzf(@Nullable View view) {
        int i11;
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            boolean z11 = false;
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfM)).booleanValue()) {
                zzt.zzp();
                ViewParent parent = view.getParent();
                while (parent != null && !(parent instanceof ScrollView)) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    z11 = true;
                }
                jSONObject.put("contained_in_scroll_view", z11);
            } else {
                zzt.zzp();
                ViewParent parent2 = view.getParent();
                while (parent2 != null && !(parent2 instanceof AdapterView)) {
                    parent2 = parent2.getParent();
                }
                if (parent2 == null) {
                    i11 = -1;
                } else {
                    i11 = ((AdapterView) parent2).getPositionForView(view);
                }
                if (i11 != -1) {
                    z11 = true;
                }
                jSONObject.put("contained_in_scroll_view", z11);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016f A[Catch:{ JSONException -> 0x0174 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject zzg(android.content.Context r16, @androidx.annotation.Nullable android.view.View r17) {
        /*
            r0 = r16
            r1 = r17
            java.lang.String r2 = "window"
            java.lang.String r3 = "relative_to"
            java.lang.String r4 = "y"
            java.lang.String r5 = "x"
            java.lang.String r6 = "height"
            java.lang.String r7 = "width"
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            if (r1 != 0) goto L_0x0018
            return r8
        L_0x0018:
            r9 = 2
            r10 = 1
            r11 = 0
            int[] r12 = zzj(r17)     // Catch:{ Exception -> 0x00fd }
            int[] r13 = new int[r9]     // Catch:{ Exception -> 0x00fd }
            int r14 = r17.getMeasuredWidth()     // Catch:{ Exception -> 0x00fd }
            r13[r11] = r14     // Catch:{ Exception -> 0x00fd }
            int r14 = r17.getMeasuredHeight()     // Catch:{ Exception -> 0x00fd }
            r13[r10] = r14     // Catch:{ Exception -> 0x00fd }
            android.view.ViewParent r14 = r17.getParent()     // Catch:{ Exception -> 0x00fd }
        L_0x0031:
            boolean r15 = r14 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x00fd }
            if (r15 == 0) goto L_0x0058
            r15 = r14
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ Exception -> 0x00fd }
            int r9 = r15.getMeasuredWidth()     // Catch:{ Exception -> 0x00fd }
            r10 = r13[r11]     // Catch:{ Exception -> 0x00fd }
            int r9 = java.lang.Math.min(r9, r10)     // Catch:{ Exception -> 0x00fd }
            r13[r11] = r9     // Catch:{ Exception -> 0x00fd }
            int r9 = r15.getMeasuredHeight()     // Catch:{ Exception -> 0x00fd }
            r10 = 1
            r15 = r13[r10]     // Catch:{ Exception -> 0x00fd }
            int r9 = java.lang.Math.min(r9, r15)     // Catch:{ Exception -> 0x00fd }
            r13[r10] = r9     // Catch:{ Exception -> 0x00fd }
            android.view.ViewParent r14 = r14.getParent()     // Catch:{ Exception -> 0x00fd }
            r9 = 2
            r10 = 1
            goto L_0x0031
        L_0x0058:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fd }
            r9.<init>()     // Catch:{ Exception -> 0x00fd }
            int r10 = r17.getMeasuredWidth()     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzcis r14 = com.google.android.gms.internal.ads.zzbgo.zzb()     // Catch:{ Exception -> 0x00fd }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r7, (int) r10)     // Catch:{ Exception -> 0x00fd }
            int r10 = r17.getMeasuredHeight()     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzcis r14 = com.google.android.gms.internal.ads.zzbgo.zzb()     // Catch:{ Exception -> 0x00fd }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r6, (int) r10)     // Catch:{ Exception -> 0x00fd }
            r10 = r12[r11]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzcis r14 = com.google.android.gms.internal.ads.zzbgo.zzb()     // Catch:{ Exception -> 0x00fd }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r5, (int) r10)     // Catch:{ Exception -> 0x00fd }
            r10 = 1
            r14 = r12[r10]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzcis r10 = com.google.android.gms.internal.ads.zzbgo.zzb()     // Catch:{ Exception -> 0x00fd }
            int r10 = r10.zzb(r0, r14)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r4, (int) r10)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "maximum_visible_width"
            r14 = r13[r11]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzcis r15 = com.google.android.gms.internal.ads.zzbgo.zzb()     // Catch:{ Exception -> 0x00fd }
            int r14 = r15.zzb(r0, r14)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r10, (int) r14)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "maximum_visible_height"
            r14 = 1
            r13 = r13[r14]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzcis r14 = com.google.android.gms.internal.ads.zzbgo.zzb()     // Catch:{ Exception -> 0x00fd }
            int r13 = r14.zzb(r0, r13)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r10, (int) r13)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r10 = "frame"
            r8.put((java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ Exception -> 0x00fd }
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ Exception -> 0x00fd }
            r9.<init>()     // Catch:{ Exception -> 0x00fd }
            boolean r10 = r1.getGlobalVisibleRect(r9)     // Catch:{ Exception -> 0x00fd }
            if (r10 == 0) goto L_0x00cd
            org.json.JSONObject r0 = zzk(r0, r9)     // Catch:{ Exception -> 0x00fd }
            goto L_0x00f7
        L_0x00cd:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fd }
            r9.<init>()     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r7, (int) r11)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r6, (int) r11)     // Catch:{ Exception -> 0x00fd }
            r6 = r12[r11]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzcis r7 = com.google.android.gms.internal.ads.zzbgo.zzb()     // Catch:{ Exception -> 0x00fd }
            int r6 = r7.zzb(r0, r6)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r5, (int) r6)     // Catch:{ Exception -> 0x00fd }
            r5 = 1
            r6 = r12[r5]     // Catch:{ Exception -> 0x00fd }
            com.google.android.gms.internal.ads.zzcis r5 = com.google.android.gms.internal.ads.zzbgo.zzb()     // Catch:{ Exception -> 0x00fd }
            int r0 = r5.zzb(r0, r6)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r4, (int) r0)     // Catch:{ Exception -> 0x00fd }
            r9.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ Exception -> 0x00fd }
            r0 = r9
        L_0x00f7:
            java.lang.String r2 = "visible_bounds"
            r8.put((java.lang.String) r2, (java.lang.Object) r0)     // Catch:{ Exception -> 0x00fd }
            goto L_0x0102
        L_0x00fd:
            java.lang.String r0 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.ads.zzciz.zzj(r0)
        L_0x0102:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzeG
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r2.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x017a
            android.view.ViewParent r0 = r17.getParent()
            if (r0 == 0) goto L_0x0139
            java.lang.Class r1 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.String r2 = "getTemplateTypeName"
            java.lang.Class[] r3 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.Object r0 = r1.invoke(r0, r2)     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NoSuchMethodException -> 0x0139, SecurityException -> 0x0133, IllegalAccessException -> 0x0131, InvocationTargetException -> 0x012f }
            goto L_0x013b
        L_0x012f:
            r0 = move-exception
            goto L_0x0134
        L_0x0131:
            r0 = move-exception
            goto L_0x0134
        L_0x0133:
            r0 = move-exception
        L_0x0134:
            java.lang.String r1 = "Cannot access method getTemplateTypeName: "
            com.google.android.gms.internal.ads.zzciz.zzh(r1, r0)
        L_0x0139:
            java.lang.String r0 = ""
        L_0x013b:
            int r1 = r0.hashCode()     // Catch:{ JSONException -> 0x0174 }
            r2 = -2066603854(0xffffffff84d220b2, float:-4.940079E-36)
            if (r1 == r2) goto L_0x0154
            r2 = 2019754500(0x78630204, float:1.8417067E34)
            if (r1 == r2) goto L_0x014a
            goto L_0x015e
        L_0x014a:
            java.lang.String r1 = "medium_template"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x015e
            r0 = 1
            goto L_0x015f
        L_0x0154:
            java.lang.String r1 = "small_template"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x015e
            r0 = r11
            goto L_0x015f
        L_0x015e:
            r0 = -1
        L_0x015f:
            java.lang.String r1 = "native_template_type"
            if (r0 == 0) goto L_0x016f
            r2 = 1
            if (r0 == r2) goto L_0x016a
            r8.put((java.lang.String) r1, (int) r11)     // Catch:{ JSONException -> 0x0174 }
            goto L_0x017a
        L_0x016a:
            r2 = 2
            r8.put((java.lang.String) r1, (int) r2)     // Catch:{ JSONException -> 0x0174 }
            goto L_0x017a
        L_0x016f:
            r2 = 1
            r8.put((java.lang.String) r1, (int) r2)     // Catch:{ JSONException -> 0x0174 }
            goto L_0x017a
        L_0x0174:
            r0 = move-exception
            java.lang.String r1 = "Could not log native template signal to JSON"
            com.google.android.gms.internal.ads.zzciz.zzh(r1, r0)
        L_0x017a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzcb.zzg(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static boolean zzh(Context context, zzfdn zzfdn) {
        if (!zzfdn.zzK) {
            return false;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfN)).booleanValue()) {
            return ((Boolean) zzbgq.zzc().zzb(zzblj.zzfQ)).booleanValue();
        }
        String str = (String) zzbgq.zzc().zzb(zzblj.zzfO);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            for (String equals : zzfqp.zzc(zzfps.zzb(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER)).zzd(str)) {
                if (equals.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean zzi(int i11) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzcf)).booleanValue()) {
            return true;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcg)).booleanValue() || i11 <= 15299999) {
            return true;
        }
        return false;
    }

    public static int[] zzj(@Nullable View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private static JSONObject zzk(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzbgo.zzb().zzb(context, rect.right - rect.left));
        jSONObject.put("height", zzbgo.zzb().zzb(context, rect.bottom - rect.top));
        jSONObject.put(Param.X, zzbgo.zzb().zzb(context, rect.left));
        jSONObject.put(Param.Y, zzbgo.zzb().zzb(context, rect.top));
        jSONObject.put("relative_to", (Object) "self");
        return jSONObject;
    }
}
