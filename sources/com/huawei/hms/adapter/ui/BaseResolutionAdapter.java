package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.RegionUtils;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Activity> f47812a;

    /* renamed from: b  reason: collision with root package name */
    private String f47813b = "";

    /* renamed from: c  reason: collision with root package name */
    private long f47814c = 0;

    private void a(long j11) {
        if (!RegionUtils.isChinaROM(c())) {
            HMSLog.i("BaseResolutionAdapter", "not ChinaROM");
            return;
        }
        Activity c11 = c();
        if (c11 != null && !c11.isFinishing()) {
            HashMap hashMap = new HashMap();
            hashMap.put("package", c11.getPackageName());
            hashMap.put(CommonCode.MapKey.RESOLUTION_FLAG, this.f47814c + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + j11);
            HiAnalyticsUtils.getInstance().onEvent(c11, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, hashMap);
            HMSLog.e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.f47813b + ", carriedTimeStamp: " + this.f47814c + ", savedTimeStamp: " + j11);
        }
    }

    private void b() {
        Activity c11 = c();
        if (c11 != null && !c11.isFinishing()) {
            c11.finish();
        }
    }

    private Activity c() {
        WeakReference<Activity> weakReference = this.f47812a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void d() {
        SystemManager.getInstance().notifyResolutionResult((Intent) null, this.f47813b);
        b();
    }

    public int getRequestCode() {
        return 1001;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBridgeActivityCreate(android.app.Activity r10) {
        /*
            r9 = this;
            java.lang.String r0 = "BaseResolutionAdapter"
            if (r10 != 0) goto L_0x000d
            java.lang.String r10 = "activity is null"
            com.huawei.hms.support.log.HMSLog.e(r0, r10)
            r9.d()
            return
        L_0x000d:
            boolean r1 = r10.isFinishing()
            if (r1 == 0) goto L_0x0019
            java.lang.String r10 = "activity is finishing"
            com.huawei.hms.support.log.HMSLog.e(r0, r10)
            return
        L_0x0019:
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r10)
            r9.f47812a = r1
            android.content.Intent r1 = r10.getIntent()
            if (r1 != 0) goto L_0x002a
            r9.d()
            return
        L_0x002a:
            android.os.Bundle r2 = r1.getExtras()     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "transaction_id"
            java.lang.String r3 = r1.getStringExtra(r3)     // Catch:{ all -> 0x0041 }
            r9.f47813b = r3     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "resolution_flag"
            r4 = 0
            long r3 = r1.getLongExtra(r3, r4)     // Catch:{ all -> 0x0041 }
            r9.f47814c = r3     // Catch:{ all -> 0x0041 }
            goto L_0x0061
        L_0x0041:
            r1 = move-exception
            goto L_0x0045
        L_0x0043:
            r1 = move-exception
            r2 = 0
        L_0x0045:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "get transaction_id or resolution_flag exception:"
            r3.append(r4)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r1)
        L_0x0061:
            boolean r1 = r9.a()
            if (r1 != 0) goto L_0x006b
            r9.d()
            return
        L_0x006b:
            java.lang.String r1 = r9.f47813b
            if (r1 == 0) goto L_0x0083
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r1 < r3) goto L_0x0083
            java.lang.String r1 = "remove apk resolution failed task."
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager r1 = com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager.getInstance()
            java.lang.String r3 = r9.f47813b
            r1.removeTask(r3)
        L_0x0083:
            if (r2 != 0) goto L_0x0089
            r9.d()
            return
        L_0x0089:
            java.lang.String r1 = "resolution"
            android.os.Parcelable r1 = r2.getParcelable(r1)
            if (r1 != 0) goto L_0x0095
            r9.d()
            return
        L_0x0095:
            boolean r2 = r1 instanceof android.content.Intent
            if (r2 == 0) goto L_0x00ae
            android.content.Intent r1 = (android.content.Intent) r1     // Catch:{ all -> 0x00a5 }
            android.content.Intent r1 = com.huawei.hms.utils.IntentUtil.modifyIntentBehaviorsSafe(r1)     // Catch:{ all -> 0x00a5 }
            r2 = 1001(0x3e9, float:1.403E-42)
            r10.startActivityForResult(r1, r2)     // Catch:{ all -> 0x00a5 }
            goto L_0x00cb
        L_0x00a5:
            r9.d()
            java.lang.String r10 = "ActivityNotFoundException:exception"
            com.huawei.hms.support.log.HMSLog.e(r0, r10)
            goto L_0x00cb
        L_0x00ae:
            boolean r2 = r1 instanceof android.app.PendingIntent
            if (r2 == 0) goto L_0x00cb
            android.app.PendingIntent r1 = (android.app.PendingIntent) r1     // Catch:{ SendIntentException -> 0x00c3 }
            android.content.IntentSender r3 = r1.getIntentSender()     // Catch:{ SendIntentException -> 0x00c3 }
            r4 = 1001(0x3e9, float:1.403E-42)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r10
            r2.startIntentSenderForResult(r3, r4, r5, r6, r7, r8)     // Catch:{ SendIntentException -> 0x00c3 }
            goto L_0x00cb
        L_0x00c3:
            r9.d()
            java.lang.String r10 = "SendIntentException:exception"
            com.huawei.hms.support.log.HMSLog.e(r0, r10)
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.ui.BaseResolutionAdapter.onBridgeActivityCreate(android.app.Activity):void");
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f47812a = null;
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        if (i11 != getRequestCode()) {
            return false;
        }
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i12);
        if (i12 == 1001 || i12 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i12);
        }
        if (i12 == -1 || intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) || intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(intent, this.f47813b);
        } else {
            SystemManager.getInstance().notifyResolutionResult((Intent) null, this.f47813b);
        }
        b();
        return true;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    private boolean a() {
        long resolutionFlag = ResolutionFlagUtil.getInstance().getResolutionFlag(this.f47813b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.f47813b);
        if (resolutionFlag != 0 && resolutionFlag == this.f47814c) {
            return true;
        }
        a(resolutionFlag);
        return false;
    }
}
