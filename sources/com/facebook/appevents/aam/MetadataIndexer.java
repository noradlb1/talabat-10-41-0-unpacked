package com.facebook.appevents.aam;

import android.app.Activity;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import m6.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\tH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/aam/MetadataIndexer;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "enabled", "", "enable", "", "onActivityResumed", "activity", "Landroid/app/Activity;", "updateRules", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class MetadataIndexer {
    @NotNull
    public static final MetadataIndexer INSTANCE = new MetadataIndexer();
    private static final String TAG = MetadataIndexer.class.getCanonicalName();
    private static boolean enabled;

    private MetadataIndexer() {
    }

    @JvmStatic
    public static final void enable() {
        try {
            FacebookSdk.getExecutor().execute(new a());
        } catch (Exception e11) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, e11);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m8899enable$lambda0() {
        if (!AttributionIdentifiers.Companion.isTrackingLimited(FacebookSdk.getApplicationContext())) {
            INSTANCE.updateRules();
            enabled = true;
        }
    }

    @JvmStatic
    @UiThread
    public static final void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            if (!enabled) {
                return;
            }
            if (!MetadataRule.Companion.getRules().isEmpty()) {
                MetadataViewObserver.Companion.startTrackingActivity(activity);
            }
        } catch (Exception unused) {
        }
    }

    private final void updateRules() {
        String rawAamRules;
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (queryAppSettings != null && (rawAamRules = queryAppSettings.getRawAamRules()) != null) {
            MetadataRule.Companion.updateRules(rawAamRules);
        }
    }
}
