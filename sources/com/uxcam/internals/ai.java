package com.uxcam.internals;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ai {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f12988a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f12989b;

    public ai(int[] iArr) {
        if (iArr.length != 0) {
            this.f12988a = iArr;
            int[] iArr2 = new int[(iArr.length + 1)];
            this.f12989b = iArr2;
            Arrays.fill(iArr2, 0);
            return;
        }
        throw new IllegalArgumentException("binBreakPoints[] cannot be empty.");
    }

    public void a(long j11) {
        int i11 = 0;
        while (true) {
            int[] iArr = this.f12988a;
            if (i11 >= iArr.length || j11 < ((long) iArr[i11])) {
                int[] iArr2 = this.f12989b;
                iArr2[i11] = iArr2[i11] + 1;
            } else {
                i11++;
            }
        }
        int[] iArr22 = this.f12989b;
        iArr22[i11] = iArr22[i11] + 1;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        int i11 = 0;
        for (int put : this.f12988a) {
            jSONArray.put(put);
        }
        JSONArray jSONArray2 = new JSONArray();
        while (true) {
            int[] iArr = this.f12989b;
            if (i11 >= iArr.length) {
                break;
            }
            jSONArray2.put(iArr[i11]);
            i11++;
        }
        try {
            jSONObject.put("bin", (Object) jSONArray);
            jSONObject.put("data", (Object) jSONArray2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }
}
