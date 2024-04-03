package com.huawei.hms.flutter.analytics.viewmodel;

import android.content.Context;
import android.os.Bundle;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;
import com.huawei.hms.analytics.type.ReportPolicy;
import com.huawei.hms.flutter.analytics.presenter.HMSAnalyticsContract;
import java.util.Map;
import java.util.Set;
import xa.a;

public class HMSAnalyticsViewModel implements HMSAnalyticsContract.Presenter {
    private final HiAnalyticsInstance analyticsInstance;

    public HMSAnalyticsViewModel(Context context, HiAnalyticsInstance hiAnalyticsInstance) {
        if (AGConnectInstance.getInstance() == null) {
            AGConnectInstance.initialize(context);
        }
        this.analyticsInstance = hiAnalyticsInstance;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getAAID$0(HMSAnalyticsContract.ResultListener resultListener, Task task) {
        if (task.isSuccessful()) {
            resultListener.onSuccess((String) task.getResult());
        } else {
            resultListener.onFail(task.getException());
        }
    }

    public void addDefaultEventParams(Bundle bundle) {
        this.analyticsInstance.addDefaultEventParams(bundle);
    }

    public void clearCachedData() {
        this.analyticsInstance.clearCachedData();
    }

    public void enableLog() {
        HiAnalyticsTools.enableLog();
    }

    public void enableLogWithLevel(int i11) {
        HiAnalyticsTools.enableLog(i11);
    }

    public void getAAID(HMSAnalyticsContract.ResultListener<String> resultListener) {
        this.analyticsInstance.getAAID().addOnCompleteListener(new a(resultListener));
    }

    public void getDataUploadSiteInfo(HMSAnalyticsContract.ResultListener<String> resultListener) {
        resultListener.onSuccess(this.analyticsInstance.getDataUploadSiteInfo());
    }

    public void getReportPolicyThreshold(HMSAnalyticsContract.ResultListener<Long> resultListener, ReportPolicy reportPolicy) {
        resultListener.onSuccess(Long.valueOf(reportPolicy.getThreshold()));
    }

    public void getUserProfiles(HMSAnalyticsContract.ResultListener<Map<String, String>> resultListener, boolean z11) {
        resultListener.onSuccess(this.analyticsInstance.getUserProfiles(z11));
    }

    public void isRestrictionEnabled(HMSAnalyticsContract.ResultListener<Boolean> resultListener) {
        resultListener.onSuccess(Boolean.valueOf(this.analyticsInstance.isRestrictionEnabled()));
    }

    public void onEvent(String str, Bundle bundle) {
        this.analyticsInstance.onEvent(str, bundle);
    }

    public void pageEnd(String str) {
        this.analyticsInstance.pageEnd(str);
    }

    public void pageStart(String str, String str2) {
        this.analyticsInstance.pageStart(str, str2);
    }

    public void setAnalyticsEnabled(boolean z11) {
        this.analyticsInstance.setAnalyticsEnabled(z11);
    }

    public void setChannel(String str) {
        this.analyticsInstance.setChannel(str);
    }

    public void setCollectAdsIdEnabled(boolean z11) {
        this.analyticsInstance.setAnalyticsEnabled(z11);
    }

    public void setCustomReferrer(String str) {
        this.analyticsInstance.setCustomReferrer(str);
    }

    public void setMinActivitySessions(long j11) {
        this.analyticsInstance.setMinActivitySessions(j11);
    }

    public void setPropertyCollection(String str, boolean z11) {
        this.analyticsInstance.setPropertyCollection(str, z11);
    }

    public void setPushToken(String str) {
        this.analyticsInstance.setPushToken(str);
    }

    public void setReportPolicies(Set<ReportPolicy> set) {
        this.analyticsInstance.setReportPolicies(set);
    }

    public void setRestrictionEnabled(boolean z11) {
        this.analyticsInstance.setRestrictionEnabled(z11);
    }

    public void setSessionDuration(long j11) {
        this.analyticsInstance.setSessionDuration(j11);
    }

    public void setUserId(String str) {
        this.analyticsInstance.setUserId(str);
    }

    public void setUserProfile(String str, String str2) {
        this.analyticsInstance.setUserProfile(str, str2);
    }
}
