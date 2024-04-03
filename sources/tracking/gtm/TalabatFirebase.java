package tracking.gtm;

import android.content.Context;
import android.os.Bundle;
import buisnessmodels.Customer;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.core.tracking.domain.AnalyticsType;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.core.tracking.domain.perseus.PerseusEventTools;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.lib.Integration;
import com.talabat.talabatcore.application.BaseApplication;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CustomerInfo;
import i40.a;
import i40.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.deeplink.DeepLinkParser;
import tracking.deeplink.DeepLinkResult;
import tracking.gtm.TalabatGTM;
import tracking.gtm.automation.utils.AutomationTestingIntegrator;
import tracking.gtm.datalayerLogger.DatalayerModel;
import tracking.perseus.TalabatPerseus;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Ltracking/gtm/TalabatFirebase;", "Ltracking/gtm/ITalabatFirebase;", "()V", "dispatchEvent", "", "context", "Landroid/content/Context;", "eventName", "", "params", "Landroid/os/Bundle;", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatFirebase implements ITalabatFirebase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\"\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006J6\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b¨\u0006\u0019"}, d2 = {"Ltracking/gtm/TalabatFirebase$Companion;", "", "()V", "addCommonProperties", "", "params", "Landroid/os/Bundle;", "dispatchEvent", "context", "Landroid/content/Context;", "eventName", "", "handleEventWithPerseus", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "trackingCoreLibApi", "Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "sendToFirebase", "bundle", "setLogEventForAutomation", "shouldBeSent", "", "attribute", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void dispatchEvent$default(Companion companion, Context context, String str, Bundle bundle, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                context = BaseApplication.Companion.getInstance();
            }
            if ((i11 & 4) != 0) {
                bundle = new Bundle();
            }
            companion.dispatchEvent(context, str, bundle);
        }

        private final void handleEventWithPerseus(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, Bundle bundle, String str) {
            Integer num;
            if (trackingCoreLibApi != null && configurationLocalCoreLibApi != null) {
                TalabatPerseus.Companion companion = TalabatPerseus.Companion;
                CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
                if (customerInfo != null) {
                    num = Integer.valueOf(customerInfo.f13850id);
                } else {
                    num = null;
                }
                companion.setUserId(String.valueOf(num));
                String adid = Adjust.getAdid();
                String str2 = "";
                if (adid == null) {
                    adid = str2;
                }
                companion.setAdjustId(adid);
                companion.setCountry(configurationLocalCoreLibApi.getRepository().selectedCountry());
                String str3 = GlobalDataModel.googleAdId;
                if (str3 != null) {
                    str2 = str3;
                }
                companion.setAdvertisingId(str2);
                PerseusEventTools perseusEventTools = trackingCoreLibApi.getPerseusEventTools();
                companion.sendEvent(perseusEventTools.adaptEventName(str, bundle), perseusEventTools.addPerseusParams(str, bundle));
            }
        }

        private final void sendToFirebase(String str, Bundle bundle) {
            String str2;
            FirebaseDatabase instance = FirebaseDatabase.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
            DatabaseReference reference = instance.getReference(DatalayerModel.INSTANCE.getLoggingKey());
            Intrinsics.checkNotNullExpressionValue(reference, "firebaseDatabase.getRefe…atalayerModel.loggingKey)");
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                HashMap hashMap2 = new HashMap();
                Intrinsics.checkNotNullExpressionValue(next, "key");
                if (obj != null) {
                    str2 = obj.toString();
                } else {
                    str2 = null;
                }
                hashMap2.put(next, str2);
                arrayList.add(hashMap2);
            }
            hashMap.put(str, arrayList);
            reference.push().setValue(hashMap).addOnFailureListener(new a()).addOnCompleteListener(new b());
        }

        /* access modifiers changed from: private */
        /* renamed from: sendToFirebase$lambda-1  reason: not valid java name */
        public static final void m10950sendToFirebase$lambda1(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            LogManager.logException(exc);
        }

        /* access modifiers changed from: private */
        /* renamed from: sendToFirebase$lambda-2  reason: not valid java name */
        public static final void m10951sendToFirebase$lambda2(Task task) {
            Intrinsics.checkNotNullParameter(task, "it");
            task.isSuccessful();
        }

        public final void addCommonProperties(@NotNull Bundle bundle) {
            String str;
            boolean z11;
            DeepLinkResult deepLinkResult;
            Intrinsics.checkNotNullParameter(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
            TalabatPerseus.Companion companion = TalabatPerseus.Companion;
            bundle.putString("perseusHitMatchId", companion.getHitMatchId());
            bundle.putString("perseusSessionId", companion.getMySessionId());
            bundle.putString("perseusClientId", TalabatPerseus.Companion.getMyClientId$default(companion, (Context) null, 1, (Object) null));
            CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
            if (customerInfo == null || (str = Integer.valueOf(customerInfo.f13850id).toString()) == null) {
                str = "N/A";
            }
            bundle.putString("customerCode", str);
            AdjustAttribution attribution = Adjust.getAttribution();
            if (attribution != null) {
                if (shouldBeSent(attribution.network)) {
                    bundle.putString(ConstantsKt.ADJUST_NETWORK, attribution.network);
                }
                if (shouldBeSent(attribution.adgroup)) {
                    bundle.putString(ConstantsKt.ADJUST_AD_GROUP, attribution.adgroup);
                }
                if (shouldBeSent(attribution.campaign)) {
                    bundle.putString(ConstantsKt.ADJUST_CAMPAIGN, attribution.campaign);
                }
                if (shouldBeSent(attribution.creative)) {
                    bundle.putString(ConstantsKt.ADJUST_CREATIVE, attribution.creative);
                }
                if (shouldBeSent(attribution.trackerToken)) {
                    bundle.putString(ConstantsKt.ADJUST_TRACKER_TOKEN, attribution.trackerToken);
                }
                if (shouldBeSent(attribution.clickLabel)) {
                    bundle.putString(ConstantsKt.ADJUST_LABEL, attribution.clickLabel);
                }
                if (shouldBeSent(attribution.adid)) {
                    bundle.putString(ConstantsKt.ADJUST_AD_ID, attribution.adid);
                }
            }
            String deepLinksQuery = GlobalDataModel.getDeepLinksQuery();
            if (deepLinksQuery == null || deepLinksQuery.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                deepLinkResult = DeepLinkParser.parse(deepLinksQuery);
            } else {
                deepLinkResult = new DeepLinkResult();
            }
            if (shouldBeSent(deepLinkResult.source)) {
                bundle.putString(ConstantsKt.DEEPLINK_UTM_SOURCE, deepLinkResult.source);
            }
            if (shouldBeSent(deepLinkResult.campaign)) {
                bundle.putString(ConstantsKt.DEEPLINK_UTM_CAMPAIGN, deepLinkResult.campaign);
            }
            if (shouldBeSent(deepLinkResult.medium)) {
                bundle.putString(ConstantsKt.DEEPLINK_UTM_MEDIUM, deepLinkResult.medium);
            }
            if (shouldBeSent(deepLinkResult.getContent())) {
                bundle.putString(ConstantsKt.DEEPLINK_UTM_CONTENT, deepLinkResult.getContent());
            }
            if (shouldBeSent(deepLinkResult.getId())) {
                bundle.putString(ConstantsKt.DEEPLINK_UTM_ID, deepLinkResult.getId());
            }
            if (shouldBeSent(deepLinkResult.getTerm())) {
                bundle.putString(ConstantsKt.DEEPLINK_UTM_TERM, deepLinkResult.getTerm());
            }
            if (!Intrinsics.areEqual((Object) "release", (Object) "release") || !Intrinsics.areEqual((Object) TalabatEnvironment.INSTANCE.getEnvironment(), (Object) "prod")) {
                bundle.putInt(ConstantsKt.PRE_RELEASE_VERSION, 1);
            }
        }

        public final void dispatchEvent(@NotNull Context context, @NotNull String str, @NotNull Bundle bundle) {
            ApiContainer apiContainer;
            TrackingCoreLibApi trackingCoreLibApi;
            AnalyticsType analyticsType;
            boolean z11;
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
            ObservabilityCoreLibApi observabilityCoreLibApi;
            FlutterMigrationTools flutterMigrationTools;
            String str2 = str;
            Bundle bundle2 = bundle;
            Context context2 = context;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "eventName");
            Intrinsics.checkNotNullParameter(bundle2, NativeProtocol.WEB_DIALOG_PARAMS);
            try {
                apiContainer = AndroidComponentsKt.apiContainer(context);
            } catch (ClassCastException unused) {
                apiContainer = null;
            }
            if (apiContainer != null) {
                trackingCoreLibApi = (TrackingCoreLibApi) apiContainer.getFeature(TrackingCoreLibApi.class);
            } else {
                trackingCoreLibApi = null;
            }
            if (trackingCoreLibApi != null) {
                analyticsType = trackingCoreLibApi.getAnalyticsType();
            } else {
                analyticsType = null;
            }
            if (analyticsType == AnalyticsType.HUAWEI) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                HiAnalyticsInstance instance = HiAnalytics.getInstance(context);
                TalabatGTM.Companion companion = TalabatGTM.Companion;
                instance.setUserId(companion.getUserId());
                addCommonProperties(bundle2);
                if (AutomationTestingIntegrator.INSTANCE.isAutomationProcess().invoke().booleanValue()) {
                    setLogEventForAutomation(str, bundle2);
                }
                instance.onEvent(str, bundle2);
                String str3 = "Sending " + str + " with params " + bundle2 + " and userId " + companion.getUserId();
                if (Integration.getGaEventsTracker() != null) {
                    GaEventsTrackingKt.updateGaEventsTracker$default(str, bundle, str3, (List) null, 8, (Object) null);
                }
                LogManager.debug(str3);
            } else {
                FirebaseAnalytics instance2 = FirebaseAnalytics.getInstance(context);
                Intrinsics.checkNotNullExpressionValue(instance2, "getInstance(context)");
                addCommonProperties(bundle2);
                TalabatGTM.Companion companion2 = TalabatGTM.Companion;
                instance2.setUserId(companion2.getUserId());
                if (AutomationTestingIntegrator.INSTANCE.isAutomationProcess().invoke().booleanValue()) {
                    setLogEventForAutomation(str, bundle2);
                }
                if (!(trackingCoreLibApi == null || (flutterMigrationTools = trackingCoreLibApi.getFlutterMigrationTools()) == null)) {
                    flutterMigrationTools.logGaEvent(str, bundle2);
                    flutterMigrationTools.removeMigrationParameters(str, bundle2);
                }
                instance2.logEvent(str, bundle2);
                String str4 = "Sending " + str + " with params " + bundle2 + " and userId " + companion2.getUserId();
                if (Integration.getGaEventsTracker() != null) {
                    GaEventsTrackingKt.updateGaEventsTracker$default(str, bundle, str4, (List) null, 8, (Object) null);
                }
                LogManager.debug(str4);
                if (DatalayerModel.INSTANCE.isLoggingEnabled()) {
                    sendToFirebase(str, bundle2);
                }
            }
            if (apiContainer != null) {
                configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class);
            } else {
                configurationLocalCoreLibApi = null;
            }
            if (apiContainer != null) {
                observabilityCoreLibApi = (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class);
            } else {
                observabilityCoreLibApi = null;
            }
            handleEventWithPerseus(configurationLocalCoreLibApi, trackingCoreLibApi, observabilityCoreLibApi, bundle, str);
        }

        public final void setLogEventForAutomation(@NotNull String str, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            Intrinsics.checkNotNullParameter(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new TalabatFirebase$Companion$setLogEventForAutomation$1(str, bundle, (Continuation<? super TalabatFirebase$Companion$setLogEventForAutomation$1>) null), 3, (Object) null);
        }

        public final boolean shouldBeSent(@Nullable String str) {
            return !(str == null || StringsKt__StringsJVMKt.isBlank(str)) && !Intrinsics.areEqual((Object) str, (Object) "N/A");
        }
    }

    public void dispatchEvent(@NotNull Context context, @NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        Companion.dispatchEvent(context, str, bundle);
    }
}
