package com.huawei.hms.dtm;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class D {
    public static boolean a(Context context, Intent intent) {
        return a(context, intent, (Bundle) null);
    }

    @TargetApi(16)
    public static boolean a(Context context, Intent intent, Bundle bundle) {
        String str;
        try {
            context.startActivity(intent, bundle);
            return true;
        } catch (ActivityNotFoundException unused) {
            str = "safeStartActivity: ActivityNotFoundException";
            B.b("IntentUtils", str);
            return false;
        } catch (Exception unused2) {
            str = "safeStartActivityForResult: Exception";
            B.b("IntentUtils", str);
            return false;
        }
    }
}
