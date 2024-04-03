package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.uxcam.OnVerificationListener;
import com.uxcam.datamodel.UXCamBlur;
import com.uxcam.datamodel.UXCamOccludeAllTextFields;
import com.uxcam.datamodel.UXCamOcclusion;
import com.uxcam.datamodel.UXCamOverlay;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mz.a0;
import mz.b0;
import mz.v;
import mz.w;
import mz.x;
import mz.y;
import mz.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gn {

    /* renamed from: c  reason: collision with root package name */
    public static final double[][] f13478c = {new double[]{0.5d, 320.0d}, new double[]{0.5d, 384.0d}, new double[]{1.0d, 432.0d}, new double[]{1.0d, 432.0d}, new double[]{0.5d, 128.0d}};

    /* renamed from: d  reason: collision with root package name */
    public static final double[][] f13479d = {new double[]{0.5d, 160.0d}, new double[]{0.5d, 240.0d}, new double[]{1.0d, 320.0d}, new double[]{1.0d, 432.0d}, new double[]{0.5d, 128.0d}};

    /* renamed from: e  reason: collision with root package name */
    public static final double[][] f13480e = {new double[]{0.5d, 160.0d}, new double[]{0.5d, 320.0d}, new double[]{0.5d, 320.0d}, new double[]{0.5d, 384.0d}, new double[]{0.5d, 128.0d}};

    /* renamed from: f  reason: collision with root package name */
    public static final double[][] f13481f = {new double[]{0.5d, 160.0d}, new double[]{0.5d, 240.0d}, new double[]{0.5d, 272.0d}, new double[]{0.5d, 320.0d}, new double[]{0.5d, 128.0d}};

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f13482a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f13483b;

    public class aa implements ab {
        public aa(gn gnVar) {
        }

        public void a(String str) {
            gm.D.add(str);
        }
    }

    public interface ab {
        void a(String str);
    }

    public gn(JSONObject jSONObject, Context context) {
        gm.f13455d = jSONObject.optString("appId");
        this.f13482a = jSONObject.optJSONObject("data");
        this.f13483b = context;
    }

    public void a(double d11, int i11, int i12, boolean z11) {
        if (ia.f13617c.getResources().getDisplayMetrics().widthPixels >= i11 || i12 == 1) {
            gm.f13467p = i11;
            int i13 = (int) (1000.0d / d11);
            gm.f13458g = i13;
            int i14 = 1000 / i13;
            gs.f13488k = i14;
            if (i14 < 1) {
                gs.f13488k = 1;
            }
            cm.f13132l = gs.f13488k;
            gu.a("SettingsHandler").getClass();
            return;
        }
        a(i12 - 1, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("name");
            JSONArray optJSONArray = jSONObject.optJSONArray("algs");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                a(optJSONArray, (ab) new v(this, optString));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a() {
        JSONObject optJSONObject = this.f13482a.optJSONObject("settings");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        eq eqVar = new eq(this.f13483b);
        boolean z11 = !eqVar.a("opt_out_of_video_recording");
        boolean optBoolean = this.f13482a.optBoolean("videoRecording", true);
        if (optBoolean && !z11) {
            bj.f13072i = true;
        }
        gm.f13457f = z11 && optBoolean;
        gm.f13473v = optJSONObject.optBoolean("subscriptionSessionLimitReached", false);
        gm.B = optJSONObject.optBoolean("screenAction", true);
        gm.C = optJSONObject.optBoolean("encrypt", true);
        if (this.f13482a.optBoolean("stopRecording")) {
            String str = hm.e().f12942b;
            SharedPreferences sharedPreferences = eqVar.f13291a;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("killed_app_key", str).apply();
            }
            ia.c(new File(by.a()));
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("rage");
        if (optJSONArray != null) {
            gm.f13474w = new int[]{optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2)};
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("eventLimit");
        if (optJSONArray2 != null) {
            gm.f13476y = new int[]{optJSONArray2.optInt(0), optJSONArray2.optInt(1), optJSONArray2.optInt(2)};
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("anr");
        if (optJSONArray3 != null) {
            gm.f13475x = new int[]{optJSONArray3.optInt(0), optJSONArray3.optInt(1)};
        }
        this.f13482a.optString("domain");
        gm.f13462k = this.f13482a.optString("deviceUrl");
        gm.f13463l = this.f13482a.optString("sessionUrl");
        gm.f13464m = this.f13482a.optString("misc");
        gm.f13456e = !this.f13482a.optBoolean("appIcon", false);
        JSONObject optJSONObject2 = this.f13482a.optJSONObject("s3");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        gm.f13461j = optJSONObject2;
        gm.f13471t = optJSONObject.optJSONArray("filtersDataSession");
        gm.f13472u = optJSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        optJSONObject.optString("url");
        a(optJSONObject.optInt("videoQuality", 2), fn.g());
        if (optJSONObject.optInt("uploadNetwork", 1) == 2) {
            gm.f13459h = optJSONObject.optInt("mobileDataLimit", 0);
        } else {
            gm.f13459h = 0;
        }
        gm.f13460i = optJSONObject.optBoolean("mobileDataDataOnly", false);
        a(optJSONObject.optJSONArray("activitiesToIgnore"), (ab) new aa(this));
        a(optJSONObject);
        optJSONObject.optBoolean("upload_crashed_session", true);
        gm.L = this.f13482a.optString("sessionId");
        gm.M = optJSONObject.optBoolean("recordAppLog");
        Context context = this.f13483b;
        if (ie.f13624c == null) {
            ie.f13624c = new ie(context.getSharedPreferences("UXCamPreferences", 0));
        }
        ie.f13624c.b(gm.L);
        hb.c().a();
        bi.f13068c.clear();
        bi.f13066a = true;
        gk.a().d();
        for (OnVerificationListener onVerificationSuccess : hm.f().f13576a) {
            String str2 = ia.f13615a;
            onVerificationSuccess.onVerificationSuccess();
        }
        if (this.f13482a.has("appIcon") && !gm.f13456e) {
            Context context2 = this.f13483b;
            dd ddVar = new dd(context2);
            Drawable applicationIcon = context2.getPackageManager().getApplicationIcon(context2.getApplicationInfo());
            File file = new File(by.c(), "icon.png");
            try {
                int intrinsicWidth = applicationIcon.getIntrinsicWidth();
                int intrinsicHeight = applicationIcon.getIntrinsicHeight();
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                applicationIcon.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                applicationIcon.draw(canvas);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException unused) {
                gu.a("IconSender").getClass();
            }
            new ae().b(ddVar.f13189a, file);
        }
    }

    public static /* synthetic */ void b(List list, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("name");
            JSONObject optJSONObject = jSONObject.optJSONObject(DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            if (optString.equals("gaussianBlur")) {
                int optInt = optJSONObject != null ? optJSONObject.optInt(Param.RADIUS, gm.E) : -1;
                UXCamBlur.Builder excludeMentionedScreens = new UXCamBlur.Builder().screens(list).excludeMentionedScreens(true);
                if (optInt != -1) {
                    excludeMentionedScreens.blurRadius(optInt);
                }
                ee.a((UXCamOcclusion) excludeMentionedScreens.build());
            } else if (optString.equals("totalObfuscation")) {
                ee.a((UXCamOcclusion) new UXCamOverlay.Builder().screens(list).excludeMentionedScreens(true).build());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("occlusion");
            if (optJSONObject == null) {
                if (jSONObject.optBoolean("occludeAllTextFields", false)) {
                    ee.a((UXCamOcclusion) new UXCamOccludeAllTextFields.Builder().build());
                }
                boolean optBoolean = jSONObject.optBoolean("recordGestureForOccludedScreen", false);
                a(jSONObject.optJSONArray("screensNotToOcclude"), (ab) new y(optBoolean));
                a(jSONObject.optJSONArray("screensToOcclude"), (ab) new z(optBoolean));
                return;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray(RemoteConfigComponent.DEFAULTS_FILE_NAME);
            if (optJSONArray != null) {
                a(optJSONArray, (ab) new a0());
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("screens");
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("screensNotToOccludeDefaults");
            if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    a(optJSONArray2, (ab) new b0(this));
                }
            } else if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                a(optJSONArray3, optJSONArray2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static /* synthetic */ void a(String str) {
        try {
            if (new JSONObject(str).optString("name").equals("hideTextFields")) {
                ee.a((UXCamOcclusion) new UXCamOccludeAllTextFields.Builder().build());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            a(str, jSONObject.optString("name"), jSONObject.optJSONObject(DarkstoresMainActivity.CONFIG_EXTRA_KEY));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(String str, String str2, JSONObject jSONObject) {
        try {
            if (str2.equals("gaussianBlur")) {
                int optInt = jSONObject != null ? jSONObject.optInt(Param.RADIUS, gm.E) : -1;
                UXCamBlur.Builder screens = new UXCamBlur.Builder().screens(Collections.singletonList(str));
                if (optInt != -1) {
                    screens.blurRadius(optInt);
                }
                ee.a((UXCamOcclusion) screens.build());
            } else if (str2.equals("totalObfuscation")) {
                ee.a((UXCamOcclusion) new UXCamOverlay.Builder().screens(Collections.singletonList(str)).build());
            } else if (str2.equals("hideTextFields")) {
                ee.a((UXCamOcclusion) new UXCamOccludeAllTextFields.Builder().screens(Collections.singletonList(str)).build());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(JSONArray jSONArray, JSONArray jSONArray2) {
        ArrayList arrayList = new ArrayList();
        a(jSONArray2, (ab) new w(arrayList));
        a(jSONArray, (ab) new x(arrayList));
    }

    public static /* synthetic */ void a(List list, String str) {
        try {
            list.add(new JSONObject(str).optString("name"));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(JSONArray jSONArray, ab abVar) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                try {
                    abVar.a(jSONArray.get(i11).toString());
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public final void a(int i11, boolean z11) {
        if (i11 > 5 || i11 < 1) {
            gu.a("SettingsHandler").getClass();
            i11 = 2;
        }
        int i12 = i11;
        boolean f11 = bm.f(this.f13483b);
        gu.a("SettingsHandler").getClass();
        if (z11 && f11) {
            double[] dArr = f13478c[i12 - 1];
            a(dArr[0], (int) dArr[1], i12, true);
        } else if (z11) {
            double[] dArr2 = f13479d[i12 - 1];
            a(dArr2[0], (int) dArr2[1], i12, true);
        } else if (f11) {
            double[] dArr3 = f13480e[i12 - 1];
            a(dArr3[0], (int) dArr3[1], i12, true);
        } else {
            double[] dArr4 = f13481f[i12 - 1];
            a(dArr4[0], (int) dArr4[1], i12, true);
        }
    }
}
