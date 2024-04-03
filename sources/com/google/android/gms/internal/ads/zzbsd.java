package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

@VisibleForTesting
public final class zzbsd {
    public static final Intent zza(Uri uri, Context context, zzalt zzalt, View view) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    public static final Intent zzb(Intent intent, ResolveInfo resolveInfo, Context context, zzalt zzalt, View view) {
        Intent intent2 = new Intent(intent);
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent2.setClassName(activityInfo.packageName, activityInfo.name);
        return intent2;
    }

    @VisibleForTesting
    public static final ResolveInfo zzc(Intent intent, Context context, zzalt zzalt, View view) {
        return zzd(intent, new ArrayList(), context, zzalt, view);
    }

    @VisibleForTesting
    public static final ResolveInfo zzd(Intent intent, ArrayList<ResolveInfo> arrayList, Context context, zzalt zzalt, View view) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i11 = 0;
                while (true) {
                    if (i11 >= queryIntentActivities.size()) {
                        break;
                    } else if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i11).activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        } catch (Throwable th2) {
            zzt.zzo().zzs(th2, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
        }
    }
}
