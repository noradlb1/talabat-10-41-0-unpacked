package com.pichillilorenzo.flutter_inappwebview;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RequestPermissionHandler implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static Map<Integer, List<Runnable>> actionDictionary = new HashMap();

    public static void checkAndRun(Activity activity, String str, int i11, Runnable runnable) {
        if (ContextCompat.checkSelfPermission(activity.getApplicationContext(), str) != 0) {
            if (actionDictionary.containsKey(Integer.valueOf(i11))) {
                actionDictionary.get(Integer.valueOf(i11)).add(runnable);
            } else {
                actionDictionary.put(Integer.valueOf(i11), Arrays.asList(new Runnable[]{runnable}));
            }
            ActivityCompat.requestPermissions(activity, new String[]{str}, i11);
            return;
        }
        runnable.run();
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        if (iArr.length > 0 && iArr[0] == 0) {
            List<Runnable> list = actionDictionary.get(Integer.valueOf(i11));
            for (Runnable runnable : list) {
                runnable.run();
                list.remove(runnable);
            }
        }
    }
}
