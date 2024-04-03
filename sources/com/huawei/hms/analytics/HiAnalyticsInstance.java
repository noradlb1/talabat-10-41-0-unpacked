package com.huawei.hms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.SyncManager;
import com.huawei.hms.analytics.type.HALogConfig;
import com.huawei.hms.analytics.type.ReportPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HiAnalyticsInstance {
    /* access modifiers changed from: package-private */
    public bm lmn = null;

    public void addDefaultEventParams(Bundle bundle) {
        if (this.lmn != null) {
            final Bundle lmn2 = dm.lmn(bundle);
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.lmn(lmn2);
                    }
                }
            });
        }
    }

    public void clearCachedData() {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.ghi();
                    }
                }
            });
        }
    }

    public Task<String> getAAID() {
        if (this.lmn == null) {
            return null;
        }
        if (be.lmn()) {
            return this.lmn.fgh();
        }
        try {
            SyncManager.getInstance().await(SyncManager.TaskNames.INIT_TASK_OPENNESS, 150);
            return this.lmn.fgh();
        } catch (InterruptedException unused) {
            HiLog.w("opennessInstance", "getAAID Interrupted Exception");
            return null;
        }
    }

    public String getDataUploadSiteInfo() {
        if (this.lmn == null) {
            return "";
        }
        if (be.lmn()) {
            return this.lmn.efg();
        }
        try {
            SyncManager.getInstance().await(SyncManager.TaskNames.INIT_TASK_OPENNESS, 150);
            return this.lmn.efg();
        } catch (InterruptedException unused) {
            HiLog.w("opennessInstance", "getAAID Interrupted Exception");
            return "";
        }
    }

    public Map<String, String> getUserProfiles(boolean z11) {
        if (this.lmn != null) {
            if (be.lmn()) {
                return this.lmn.lmn(z11);
            }
            try {
                SyncManager.getInstance().await(SyncManager.TaskNames.INIT_TASK_OPENNESS, 150);
                return this.lmn.lmn(z11);
            } catch (InterruptedException unused) {
                HiLog.w("opennessInstance", "getAAID Interrupted Exception");
            }
        }
        return new HashMap();
    }

    public boolean isRestrictionEnabled() {
        if (this.lmn != null) {
            return be.lmn() ? this.lmn.ijk() : be.ghi();
        }
        return false;
    }

    public boolean isRestrictionShared() {
        if (this.lmn == null) {
            return true;
        }
        if (be.lmn()) {
            return this.lmn.hij();
        }
        try {
            SyncManager.getInstance().await(SyncManager.TaskNames.INIT_TASK_OPENNESS, 150);
            return this.lmn.hij();
        } catch (InterruptedException unused) {
            HiLog.w("opennessInstance", "isRestrictionShared Interrupted Exception");
            return true;
        }
    }

    public void onEvent(final String str, Bundle bundle) {
        if (this.lmn != null) {
            final Bundle lmn2 = dm.lmn(bundle);
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.lmn(str, lmn2);
                    }
                }
            });
        }
    }

    public void onNewIntent(final Intent intent) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.lmn(intent);
                    }
                }
            });
        }
    }

    public void pageEnd(final String str) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.ijk(str);
                    }
                }
            });
        }
    }

    public void pageStart(final String str, final String str2) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.klm(str, str2);
                    }
                }
            });
        }
    }

    @Deprecated
    public void regHmsSvcEvent() {
    }

    public void setAnalyticsEnabled(final boolean z11) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.ghi(z11);
                    }
                }
            });
        }
    }

    @Deprecated
    public void setAutoCollectionEnabled(boolean z11) {
    }

    public void setChannel(final String str) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.fgh(str);
                    }
                }
            });
        }
    }

    public void setCollectAdsIdEnabled(final boolean z11) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.ikl(z11);
                    }
                }
            });
        }
    }

    @Deprecated
    public void setCurrentActivity(final Activity activity, final String str, final String str2) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.lmn(activity, str, str2);
                    }
                }
            });
        }
    }

    public void setCustomReferrer(final String str) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.efg(str);
                    }
                }
            });
        }
    }

    public void setMinActivitySessions(final long j11) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.ikl(j11);
                    }
                }
            });
        }
    }

    public void setPropertyCollection(final String str, final boolean z11) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.lmn(str, z11);
                    }
                }
            });
        }
    }

    public void setPushToken(final String str) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.ghi(str);
                    }
                }
            });
        }
    }

    public void setPushTokenCollectionEnabled(final boolean z11) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.fgh(z11);
                    }
                }
            });
        }
    }

    public void setReportPolicies(Set<ReportPolicy> set) {
        if (this.lmn != null) {
            final HashSet hashSet = new HashSet(set);
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.lmn((Set<ReportPolicy>) hashSet);
                    }
                }
            });
        }
    }

    public void setRestrictionEnabled(final boolean z11) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.hij(z11);
                    }
                }
            });
        }
    }

    public void setRestrictionShared(final boolean z11) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.ijk(z11);
                    }
                }
            });
        }
    }

    public void setSessionDuration(final long j11) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.ijk(j11);
                    }
                }
            });
        }
    }

    public void setUserId(final String str) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.hij(str);
                    }
                }
            });
        }
    }

    public void setUserProfile(final String str, final String str2) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.lmn(str, str2);
                    }
                }
            });
        }
    }

    public void setWXAppId(final String str) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.ikl(str);
                    }
                }
            });
        }
    }

    public void setWXOpenId(final String str) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.klm(str);
                    }
                }
            });
        }
    }

    public void setWXUnionId(final String str) {
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.lmn(str);
                    }
                }
            });
        }
    }

    @Deprecated
    public void unRegHmsSvcEvent() {
    }

    public void writeLog(HALogConfig hALogConfig, final String str) {
        if (hALogConfig == null) {
            HiLog.w("opennessInstance", "log config is null");
            return;
        }
        final HALogConfig hALogConfig2 = new HALogConfig(hALogConfig);
        if (this.lmn != null) {
            dg.lmn().lmn(new Runnable() {
                public final void run() {
                    if (be.lmn()) {
                        HiAnalyticsInstance.this.lmn.lmn(hALogConfig2, str);
                    }
                }
            });
        }
    }
}
