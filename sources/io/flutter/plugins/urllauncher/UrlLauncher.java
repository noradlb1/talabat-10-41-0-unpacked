package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;

class UrlLauncher {
    @Nullable
    private Activity activity;
    private final Context applicationContext;

    public enum LaunchStatus {
        OK,
        NO_ACTIVITY,
        ACTIVITY_NOT_FOUND
    }

    public UrlLauncher(Context context, @Nullable Activity activity2) {
        this.applicationContext = context;
        this.activity = activity2;
    }

    public boolean a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        ComponentName resolveActivity = intent.resolveActivity(this.applicationContext.getPackageManager());
        if (resolveActivity == null || "{com.android.fallback/com.android.fallback.Fallback}".equals(resolveActivity.toShortString())) {
            return false;
        }
        return true;
    }

    public void b() {
        this.applicationContext.sendBroadcast(new Intent(WebViewActivity.ACTION_CLOSE));
    }

    public LaunchStatus c(String str, Bundle bundle, boolean z11, boolean z12, boolean z13) {
        Intent intent;
        Activity activity2 = this.activity;
        if (activity2 == null) {
            return LaunchStatus.NO_ACTIVITY;
        }
        if (z11) {
            intent = WebViewActivity.createIntent(activity2, str, z12, z13, bundle);
        } else {
            intent = new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", bundle);
        }
        try {
            this.activity.startActivity(intent);
            return LaunchStatus.OK;
        } catch (ActivityNotFoundException unused) {
            return LaunchStatus.ACTIVITY_NOT_FOUND;
        }
    }

    public void d(@Nullable Activity activity2) {
        this.activity = activity2;
    }
}
