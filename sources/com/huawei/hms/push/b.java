package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;

public class b {
    public static byte[] a(Bundle bundle, String str) {
        try {
            byte[] byteArray = bundle.getByteArray(str);
            if (byteArray == null) {
                return new byte[0];
            }
            return byteArray;
        } catch (Exception e11) {
            HMSLog.i("BundleUtil", "getByteArray exception" + e11.getMessage());
            return new byte[0];
        }
    }

    public static String b(Bundle bundle, String str) {
        try {
            return bundle.getString(str);
        } catch (Exception e11) {
            HMSLog.i("BundleUtil", "getString exception" + e11.getMessage());
            return null;
        }
    }

    public static String c(Bundle bundle, String str) {
        try {
            String string = bundle.getString(str);
            if (string == null) {
                return "";
            }
            return string;
        } catch (Exception e11) {
            HMSLog.i("BundleUtil", "getString exception" + e11.getMessage());
            return "";
        }
    }
}
