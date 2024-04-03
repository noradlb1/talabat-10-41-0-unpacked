package com.instabug.survey.utils;

import android.app.Activity;
import android.content.Context;
import ce.a;
import ce.c;
import ce.d;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.b;
import java.util.Objects;

public abstract class e {
    public static void a(Activity activity, ReviewInfo reviewInfo, b bVar) {
        try {
            Task<Void> launchReviewFlow = ReviewManagerFactory.create(activity).launchReviewFlow(activity, reviewInfo);
            Objects.requireNonNull(bVar);
            launchReviewFlow.addOnCompleteListener(new a(bVar));
            launchReviewFlow.addOnFailureListener(new ce.b(bVar));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", "GooglePlay in-app review request failed due to error: " + e11.getMessage());
        }
    }

    public static void a(Activity activity, com.instabug.survey.a aVar) {
        try {
            ReviewManagerFactory.create(activity).requestReviewFlow().addOnCompleteListener(new c(aVar)).addOnFailureListener(new d(aVar));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", "GooglePlay in-app review request failed due to error: " + e11.getMessage());
        }
    }

    public static void a(Context context) {
        if (com.instabug.survey.settings.c.m() == null) {
            new NetworkManager().doRequest(IBGNetworkWorker.SURVEYS, 1, new Request.Builder().method("GET").url("https://play.google.com/store/apps/details?id=" + InstabugDeviceProperties.getPackageName(context)).disableDefaultParameters(true).build(), (Request.Callbacks<RequestResponse, Throwable>) new d());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(com.instabug.survey.a aVar, Task task) {
        try {
            if (task.isSuccessful()) {
                aVar.a((ReviewInfo) task.getResult());
                return;
            }
            aVar.onFailure(new Exception("GooglePlay in-app review task did not succeed, result: " + task.getResult()));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", "Couldn't get GooglePlay in-app review request result" + e11.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "market://details?id="
            r0.append(r1)
            java.lang.String r1 = com.instabug.library.internal.device.InstabugDeviceProperties.getPackageName(r5)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "android.intent.action.VIEW"
            r1.<init>(r2, r0)
            r0 = 1208483840(0x48080000, float:139264.0)
            r1.addFlags(r0)
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r0)
            r5.startActivity(r1)     // Catch:{ ActivityNotFoundException -> 0x002e }
            goto L_0x0073
        L_0x002e:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x0053 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r3.<init>()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = "https://play.google.com/store/apps/details?id="
            r3.append(r4)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = com.instabug.library.internal.device.InstabugDeviceProperties.getPackageName(r5)     // Catch:{ Exception -> 0x0053 }
            r3.append(r4)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0053 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0053 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0053 }
            r1.addFlags(r0)     // Catch:{ Exception -> 0x0053 }
            r5.startActivity(r1)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0073
        L_0x0053:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error: "
            r0.append(r1)
            java.lang.String r5 = r5.getMessage()
            r0.append(r5)
            java.lang.String r5 = " while rating app"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "IBG-Surveys"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r5)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.utils.e.b(android.content.Context):void");
    }
}
