package com.adjust.sdk;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.perf.util.Constants;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class AdjustInstance {
    private IActivityHandler activityHandler;
    private String basePath;
    private String gdprPath;
    private PreLaunchActions preLaunchActions = new PreLaunchActions();
    private String pushToken;
    private Boolean startEnabled = null;
    private boolean startOffline = false;
    private String subscriptionPath;

    public static class PreLaunchActions {
        public Boolean lastMeasurementConsentTracked = null;
        public List<IRunActivityHandler> preLaunchActionsArray = new ArrayList();
        public List<AdjustThirdPartySharing> preLaunchAdjustThirdPartySharingArray = new ArrayList();
    }

    public class a implements IRunActivityHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f39906a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f39907b;

        public a(String str, String str2) {
            this.f39906a = str;
            this.f39907b = str2;
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.addSessionCallbackParameterI(this.f39906a, this.f39907b);
        }
    }

    public class b implements IRunActivityHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f39908a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f39909b;

        public b(String str, String str2) {
            this.f39908a = str;
            this.f39909b = str2;
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.addSessionPartnerParameterI(this.f39908a, this.f39909b);
        }
    }

    public class c implements IRunActivityHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f39910a;

        public c(String str) {
            this.f39910a = str;
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.removeSessionCallbackParameterI(this.f39910a);
        }
    }

    public class d implements IRunActivityHandler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f39911a;

        public d(String str) {
            this.f39911a = str;
        }

        public final void run(ActivityHandler activityHandler) {
            activityHandler.removeSessionPartnerParameterI(this.f39911a);
        }
    }

    public class e implements IRunActivityHandler {
        public final void run(ActivityHandler activityHandler) {
            activityHandler.resetSessionCallbackParametersI();
        }
    }

    public class f implements IRunActivityHandler {
        public final void run(ActivityHandler activityHandler) {
            activityHandler.resetSessionPartnerParametersI();
        }
    }

    private boolean checkActivityHandler(String str) {
        return checkActivityHandler(str, false);
    }

    private boolean checkActivityHandler(String str, boolean z11) {
        if (this.activityHandler != null) {
            return true;
        }
        if (str == null) {
            AdjustFactory.getLogger().error("Adjust not initialized correctly", new Object[0]);
            return false;
        }
        if (z11) {
            AdjustFactory.getLogger().warn("Adjust not initialized, but %s saved for launch", str);
        } else {
            AdjustFactory.getLogger().warn("Adjust not initialized, can't perform %s", str);
        }
        return false;
    }

    private boolean checkActivityHandler(boolean z11, String str, String str2) {
        return z11 ? checkActivityHandler(str, true) : checkActivityHandler(str2, true);
    }

    private boolean isInstanceEnabled() {
        Boolean bool = this.startEnabled;
        return bool == null || bool.booleanValue();
    }

    private void saveDeeplink(Uri uri, long j11, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).saveDeeplink(uri, j11);
    }

    private void saveDisableThirdPartySharing(Context context) {
        SharedPreferencesManager.getDefaultInstance(context).setDisableThirdPartySharing();
    }

    private void saveGdprForgetMe(Context context) {
        SharedPreferencesManager.getDefaultInstance(context).setGdprForgetMe();
    }

    private void savePreinstallReferrer(String str, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).savePreinstallReferrer(str);
    }

    private void savePushToken(String str, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).savePushToken(str);
    }

    private void saveRawReferrer(String str, long j11, Context context) {
        SharedPreferencesManager.getDefaultInstance(context).saveRawReferrer(str, j11);
    }

    private void setSendingReferrersAsNotSent(Context context) {
        SharedPreferencesManager.getDefaultInstance(context).setSendingReferrersAsNotSent();
    }

    public void addSessionCallbackParameter(String str, String str2) {
        if (checkActivityHandler("adding session callback parameter", true)) {
            this.activityHandler.addSessionCallbackParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new a(str, str2));
        }
    }

    public void addSessionPartnerParameter(String str, String str2) {
        if (checkActivityHandler("adding session partner parameter", true)) {
            this.activityHandler.addSessionPartnerParameter(str, str2);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new b(str, str2));
        }
    }

    public void appWillOpenUrl(Uri uri) {
        if (checkActivityHandler("appWillOpenUrl")) {
            this.activityHandler.readOpenUrl(uri, System.currentTimeMillis());
        }
    }

    public void appWillOpenUrl(Uri uri, Context context) {
        if (uri == null || uri.toString().length() == 0) {
            AdjustFactory.getLogger().warn("Skipping deep link processing (null or empty)", new Object[0]);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!checkActivityHandler("appWillOpenUrl", true)) {
            saveDeeplink(uri, currentTimeMillis, context);
        } else {
            this.activityHandler.readOpenUrl(uri, currentTimeMillis);
        }
    }

    public void disableThirdPartySharing(Context context) {
        if (!checkActivityHandler("disable third party sharing", true)) {
            saveDisableThirdPartySharing(context);
        } else {
            this.activityHandler.disableThirdPartySharing();
        }
    }

    public void gdprForgetMe(Context context) {
        saveGdprForgetMe(context);
        if (checkActivityHandler("gdpr", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.gdprForgetMe();
        }
    }

    public String getAdid() {
        if (!checkActivityHandler("getAdid")) {
            return null;
        }
        return this.activityHandler.getAdid();
    }

    public AdjustAttribution getAttribution() {
        if (!checkActivityHandler("getAttribution")) {
            return null;
        }
        return this.activityHandler.getAttribution();
    }

    public String getSdkVersion() {
        return Util.getSdkVersion();
    }

    public boolean isEnabled() {
        return !checkActivityHandler(Constants.ENABLE_DISABLE) ? isInstanceEnabled() : this.activityHandler.isEnabled();
    }

    public void onCreate(AdjustConfig adjustConfig) {
        if (adjustConfig == null) {
            AdjustFactory.getLogger().error("AdjustConfig missing", new Object[0]);
        } else if (!adjustConfig.isValid()) {
            AdjustFactory.getLogger().error("AdjustConfig not initialized correctly", new Object[0]);
        } else if (this.activityHandler != null) {
            AdjustFactory.getLogger().error("Adjust already initialized", new Object[0]);
        } else {
            adjustConfig.preLaunchActions = this.preLaunchActions;
            adjustConfig.pushToken = this.pushToken;
            adjustConfig.startEnabled = this.startEnabled;
            adjustConfig.startOffline = this.startOffline;
            adjustConfig.basePath = this.basePath;
            adjustConfig.gdprPath = this.gdprPath;
            adjustConfig.subscriptionPath = this.subscriptionPath;
            this.activityHandler = AdjustFactory.getActivityHandler(adjustConfig);
            setSendingReferrersAsNotSent(adjustConfig.context);
        }
    }

    public void onPause() {
        if (checkActivityHandler("onPause")) {
            this.activityHandler.onPause();
        }
    }

    public void onResume() {
        if (checkActivityHandler("onResume")) {
            this.activityHandler.onResume();
        }
    }

    public void removeSessionCallbackParameter(String str) {
        if (checkActivityHandler("removing session callback parameter", true)) {
            this.activityHandler.removeSessionCallbackParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new c(str));
        }
    }

    public void removeSessionPartnerParameter(String str) {
        if (checkActivityHandler("removing session partner parameter", true)) {
            this.activityHandler.removeSessionPartnerParameter(str);
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new d(str));
        }
    }

    public void resetSessionCallbackParameters() {
        if (checkActivityHandler("resetting session callback parameters", true)) {
            this.activityHandler.resetSessionCallbackParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new e());
        }
    }

    public void resetSessionPartnerParameters() {
        if (checkActivityHandler("resetting session partner parameters", true)) {
            this.activityHandler.resetSessionPartnerParameters();
        } else {
            this.preLaunchActions.preLaunchActionsArray.add(new f());
        }
    }

    public void sendFirstPackages() {
        if (checkActivityHandler("sendFirstPackages")) {
            this.activityHandler.sendFirstPackages();
        }
    }

    public void sendPreinstallReferrer(String str, Context context) {
        if (str == null || str.length() == 0) {
            AdjustFactory.getLogger().warn("Skipping SYSTEM_INSTALLER_REFERRER preinstall referrer processing (null or empty)", new Object[0]);
            return;
        }
        savePreinstallReferrer(str, context);
        if (checkActivityHandler("preinstall referrer", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.sendPreinstallReferrer();
        }
    }

    public void sendReferrer(String str, Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            AdjustFactory.getLogger().warn("Skipping INSTALL_REFERRER intent referrer processing (null or empty)", new Object[0]);
            return;
        }
        saveRawReferrer(str, currentTimeMillis, context);
        if (checkActivityHandler(Constants.REFERRER, true) && this.activityHandler.isEnabled()) {
            this.activityHandler.sendReftagReferrer();
        }
    }

    public void setEnabled(boolean z11) {
        this.startEnabled = Boolean.valueOf(z11);
        if (checkActivityHandler(z11, "enabled mode", "disabled mode")) {
            this.activityHandler.setEnabled(z11);
        }
    }

    public void setOfflineMode(boolean z11) {
        if (!checkActivityHandler(z11, "offline mode", "online mode")) {
            this.startOffline = z11;
        } else {
            this.activityHandler.setOfflineMode(z11);
        }
    }

    public void setPushToken(String str) {
        if (!checkActivityHandler("push token", true)) {
            this.pushToken = str;
        } else {
            this.activityHandler.setPushToken(str, false);
        }
    }

    public void setPushToken(String str, Context context) {
        savePushToken(str, context);
        if (checkActivityHandler("push token", true) && this.activityHandler.isEnabled()) {
            this.activityHandler.setPushToken(str, true);
        }
    }

    public void setTestOptions(AdjustTestOptions adjustTestOptions) {
        String str = adjustTestOptions.basePath;
        if (str != null) {
            this.basePath = str;
        }
        String str2 = adjustTestOptions.gdprPath;
        if (str2 != null) {
            this.gdprPath = str2;
        }
        String str3 = adjustTestOptions.subscriptionPath;
        if (str3 != null) {
            this.subscriptionPath = str3;
        }
        String str4 = adjustTestOptions.baseUrl;
        if (str4 != null) {
            AdjustFactory.setBaseUrl(str4);
        }
        String str5 = adjustTestOptions.gdprUrl;
        if (str5 != null) {
            AdjustFactory.setGdprUrl(str5);
        }
        String str6 = adjustTestOptions.subscriptionUrl;
        if (str6 != null) {
            AdjustFactory.setSubscriptionUrl(str6);
        }
        Long l11 = adjustTestOptions.timerIntervalInMilliseconds;
        if (l11 != null) {
            AdjustFactory.setTimerInterval(l11.longValue());
        }
        if (adjustTestOptions.timerStartInMilliseconds != null) {
            AdjustFactory.setTimerStart(adjustTestOptions.timerIntervalInMilliseconds.longValue());
        }
        Long l12 = adjustTestOptions.sessionIntervalInMilliseconds;
        if (l12 != null) {
            AdjustFactory.setSessionInterval(l12.longValue());
        }
        Long l13 = adjustTestOptions.subsessionIntervalInMilliseconds;
        if (l13 != null) {
            AdjustFactory.setSubsessionInterval(l13.longValue());
        }
        Boolean bool = adjustTestOptions.tryInstallReferrer;
        if (bool != null) {
            AdjustFactory.setTryInstallReferrer(bool.booleanValue());
        }
        if (adjustTestOptions.noBackoffWait != null) {
            BackoffStrategy backoffStrategy = BackoffStrategy.NO_WAIT;
            AdjustFactory.setPackageHandlerBackoffStrategy(backoffStrategy);
            AdjustFactory.setSdkClickBackoffStrategy(backoffStrategy);
        }
        Boolean bool2 = adjustTestOptions.enableSigning;
        if (bool2 != null && bool2.booleanValue()) {
            AdjustFactory.enableSigning();
        }
        Boolean bool3 = adjustTestOptions.disableSigning;
        if (bool3 != null && bool3.booleanValue()) {
            AdjustFactory.disableSigning();
        }
    }

    public void teardown() {
        if (checkActivityHandler("teardown")) {
            this.activityHandler.teardown();
            this.activityHandler = null;
        }
    }

    public void trackAdRevenue(AdjustAdRevenue adjustAdRevenue) {
        if (checkActivityHandler("trackAdRevenue")) {
            this.activityHandler.trackAdRevenue(adjustAdRevenue);
        }
    }

    public void trackAdRevenue(String str, JSONObject jSONObject) {
        if (checkActivityHandler("trackAdRevenue")) {
            this.activityHandler.trackAdRevenue(str, jSONObject);
        }
    }

    public void trackEvent(AdjustEvent adjustEvent) {
        if (checkActivityHandler(AnalyticsMethodChannel.TRACK_METHOD_CALL_FLUTTER_EVENT)) {
            this.activityHandler.trackEvent(adjustEvent);
        }
    }

    public void trackMeasurementConsent(boolean z11) {
        if (!checkActivityHandler("measurement consent", true)) {
            this.preLaunchActions.lastMeasurementConsentTracked = Boolean.valueOf(z11);
            return;
        }
        this.activityHandler.trackMeasurementConsent(z11);
    }

    public void trackPlayStoreSubscription(AdjustPlayStoreSubscription adjustPlayStoreSubscription) {
        if (checkActivityHandler("trackPlayStoreSubscription")) {
            this.activityHandler.trackPlayStoreSubscription(adjustPlayStoreSubscription);
        }
    }

    public void trackThirdPartySharing(AdjustThirdPartySharing adjustThirdPartySharing) {
        if (!checkActivityHandler("third party sharing", true)) {
            this.preLaunchActions.preLaunchAdjustThirdPartySharingArray.add(adjustThirdPartySharing);
        } else {
            this.activityHandler.trackThirdPartySharing(adjustThirdPartySharing);
        }
    }
}
