package com.huawei.hms.flutter.analytics.presenter;

import android.os.Bundle;
import com.huawei.hms.analytics.type.ReportPolicy;
import java.util.Map;
import java.util.Set;

public interface HMSAnalyticsContract {

    public interface Presenter {
        void addDefaultEventParams(Bundle bundle);

        void clearCachedData();

        void enableLog();

        void enableLogWithLevel(int i11);

        void getAAID(ResultListener<String> resultListener);

        void getDataUploadSiteInfo(ResultListener<String> resultListener);

        void getReportPolicyThreshold(ResultListener<Long> resultListener, ReportPolicy reportPolicy);

        void getUserProfiles(ResultListener<Map<String, String>> resultListener, boolean z11);

        void isRestrictionEnabled(ResultListener<Boolean> resultListener);

        void onEvent(String str, Bundle bundle);

        void pageEnd(String str);

        void pageStart(String str, String str2);

        void setAnalyticsEnabled(boolean z11);

        void setChannel(String str);

        void setCollectAdsIdEnabled(boolean z11);

        void setCustomReferrer(String str);

        void setMinActivitySessions(long j11);

        void setPropertyCollection(String str, boolean z11);

        void setPushToken(String str);

        void setReportPolicies(Set<ReportPolicy> set);

        void setRestrictionEnabled(boolean z11);

        void setSessionDuration(long j11);

        void setUserId(String str);

        void setUserProfile(String str, String str2);
    }

    public interface ResultListener<T> {
        void onFail(Exception exc);

        void onSuccess(T t11);
    }
}
