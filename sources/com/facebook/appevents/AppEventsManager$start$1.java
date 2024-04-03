package com.facebook.appevents;

import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.integrity.MACARuleMatchingManager;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import kotlin.Metadata;
import l6.k;
import l6.l;
import l6.m;
import l6.n;
import l6.o;
import l6.p;
import l6.q;
import l6.r;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/appevents/AppEventsManager$start$1", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventsManager$start$1 implements FetchedAppSettingsManager.FetchedAppSettingsCallback {
    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m8888onSuccess$lambda0(boolean z11) {
        if (z11) {
            MetadataIndexer.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-1  reason: not valid java name */
    public static final void m8889onSuccess$lambda1(boolean z11) {
        if (z11) {
            RestrictiveDataManager.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-2  reason: not valid java name */
    public static final void m8890onSuccess$lambda2(boolean z11) {
        if (z11) {
            ModelManager.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-3  reason: not valid java name */
    public static final void m8891onSuccess$lambda3(boolean z11) {
        if (z11) {
            EventDeactivationManager.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-4  reason: not valid java name */
    public static final void m8892onSuccess$lambda4(boolean z11) {
        if (z11) {
            InAppPurchaseManager.enableAutoLogging();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-5  reason: not valid java name */
    public static final void m8893onSuccess$lambda5(boolean z11) {
        if (z11) {
            ProtectedModeManager.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-6  reason: not valid java name */
    public static final void m8894onSuccess$lambda6(boolean z11) {
        if (z11) {
            MACARuleMatchingManager.enable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-7  reason: not valid java name */
    public static final void m8895onSuccess$lambda7(boolean z11) {
        if (z11) {
            AppEventsCAPIManager.enable();
        }
    }

    public void onError() {
    }

    public void onSuccess(@Nullable FetchedAppSettings fetchedAppSettings) {
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.AAM, new k());
        FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new l());
        FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new m());
        FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new n());
        FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new o());
        FeatureManager.checkFeature(FeatureManager.Feature.ProtectedMode, new p());
        FeatureManager.checkFeature(FeatureManager.Feature.MACARuleMatching, new q());
        FeatureManager.checkFeature(FeatureManager.Feature.CloudBridge, new r());
    }
}
