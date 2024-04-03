package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dq {
    public static String lmn(String str) {
        if (!str.contains("|")) {
            return ar.ikl.contains(str) ? str : "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : str.split("\\|")) {
            if (!TextUtils.isEmpty(str2) && ar.ikl.contains(str2)) {
                sb2.append(str2);
                sb2.append("|");
            }
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public static List<String> lmn(Context context) {
        String klm = dv.klm(context, "global_v2", "dis_pros", "");
        if (TextUtils.isEmpty(klm)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (klm.contains("|")) {
            return Arrays.asList(klm.split("\\|"));
        }
        arrayList.add(klm);
        return arrayList;
    }

    public static void lmn(Context context, String str) {
        dv.lmn(context, "global_v2", "dis_pros", str);
    }
}
