package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.Arrays;
import org.json.JSONArray;

@Instrumented
public class ie {

    /* renamed from: c  reason: collision with root package name */
    public static ie f13624c;

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f13625a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f13626b;

    public ie(SharedPreferences sharedPreferences) {
        this.f13625a = sharedPreferences;
        String[] strArr = new String[3];
        this.f13626b = strArr;
        Arrays.fill(strArr, "");
        String string = sharedPreferences.getString("last_session_id", (String) null);
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    this.f13626b[i11] = jSONArray.getString(i11);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                e11.getMessage();
            }
        }
    }

    public static ie a(Context context) {
        if (f13624c == null) {
            f13624c = new ie(context.getSharedPreferences("UXCamPreferences", 0));
        }
        return f13624c;
    }

    public void b(String str) {
        a(str);
        if (str != null && !str.isEmpty()) {
            for (String equals : this.f13626b) {
                if (str.equals(equals)) {
                    a();
                    return;
                }
            }
            String[] strArr = this.f13626b;
            int length = strArr.length - 1;
            if (length >= 0) {
                System.arraycopy(strArr, 1, strArr, 0, length);
            }
            String[] strArr2 = this.f13626b;
            strArr2[length] = "";
            strArr2[strArr2.length - 1] = str;
            a();
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < this.f13626b.length; i11++) {
            sb2.append("index:");
            sb2.append(i11);
            sb2.append(" => ");
            sb2.append(this.f13626b[i11]);
            sb2.append(" ; ");
        }
        StringBuilder a11 = hl.a("SManager{ ");
        a11.append(sb2.toString());
        a11.append(" }");
        return a11.toString();
    }

    public String a(String str) {
        String[] strArr;
        String[] strArr2 = this.f13626b;
        int length = strArr2.length - 1;
        if (str == null) {
            return strArr2[length];
        }
        int i11 = 0;
        int i12 = length;
        boolean z11 = false;
        while (true) {
            strArr = this.f13626b;
            if (i11 >= strArr.length) {
                break;
            }
            if (strArr[i11].equals(str)) {
                i12 = i11;
                z11 = true;
            }
            i11++;
        }
        return z11 ? strArr[i12 - 1] : strArr[i12];
    }

    @SuppressLint({"ApplySharedPref"})
    public final String a() {
        JSONArray jSONArray = new JSONArray();
        for (String put : this.f13626b) {
            jSONArray.put((Object) put);
        }
        this.f13625a.edit().putString("last_session_id", JSONArrayInstrumentation.toString(jSONArray)).commit();
        return JSONArrayInstrumentation.toString(jSONArray);
    }
}
