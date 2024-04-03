package com.facebook.appevents.codeless;

import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.TimerTask;
import kotlin.Metadata;

@Instrumented
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/facebook/appevents/codeless/ViewIndexer$schedule$indexingTask$1", "Ljava/util/TimerTask;", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewIndexer$schedule$indexingTask$1 extends TimerTask {
    final /* synthetic */ ViewIndexer this$0;

    public ViewIndexer$schedule$indexingTask$1(ViewIndexer viewIndexer) {
        this.this$0 = viewIndexer;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x007b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            com.facebook.appevents.codeless.ViewIndexer r0 = r7.this$0     // Catch:{ Exception -> 0x0094 }
            java.lang.ref.WeakReference r0 = r0.activityReference     // Catch:{ Exception -> 0x0094 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0094 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x0094 }
            android.view.View r1 = com.facebook.appevents.internal.AppEventUtility.getRootView(r0)     // Catch:{ Exception -> 0x0094 }
            if (r0 == 0) goto L_0x0093
            if (r1 != 0) goto L_0x0016
            goto L_0x0093
        L_0x0016:
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0094 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x0094 }
            boolean r2 = com.facebook.appevents.codeless.CodelessManager.getIsAppIndexingEnabled$facebook_core_release()     // Catch:{ Exception -> 0x0094 }
            if (r2 != 0) goto L_0x0025
            return
        L_0x0025:
            boolean r2 = com.facebook.internal.InternalSettings.isUnityApp()     // Catch:{ Exception -> 0x0094 }
            if (r2 == 0) goto L_0x002f
            com.facebook.appevents.codeless.internal.UnityReflection.captureViewHierarchy()     // Catch:{ Exception -> 0x0094 }
            return
        L_0x002f:
            java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x0094 }
            com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker r3 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker     // Catch:{ Exception -> 0x0094 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0094 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0094 }
            com.facebook.appevents.codeless.ViewIndexer r3 = r7.this$0     // Catch:{ Exception -> 0x0094 }
            android.os.Handler r3 = r3.uiThreadHandler     // Catch:{ Exception -> 0x0094 }
            r3.post(r2)     // Catch:{ Exception -> 0x0094 }
            java.lang.String r3 = ""
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0050 }
            r5 = 1
            java.lang.Object r2 = r2.get(r5, r4)     // Catch:{ Exception -> 0x0050 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0050 }
            r3 = r2
            goto L_0x005a
        L_0x0050:
            r2 = move-exception
            java.lang.String r4 = com.facebook.appevents.codeless.ViewIndexer.TAG     // Catch:{ Exception -> 0x0094 }
            java.lang.String r5 = "Failed to take screenshot."
            android.util.Log.e(r4, r5, r2)     // Catch:{ Exception -> 0x0094 }
        L_0x005a:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0094 }
            r2.<init>()     // Catch:{ Exception -> 0x0094 }
            java.lang.String r4 = "screenname"
            r2.put((java.lang.String) r4, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x007b }
            java.lang.String r0 = "screenshot"
            r2.put((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x007b }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x007b }
            r0.<init>()     // Catch:{ JSONException -> 0x007b }
            org.json.JSONObject r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r1)     // Catch:{ JSONException -> 0x007b }
            r0.put((java.lang.Object) r1)     // Catch:{ JSONException -> 0x007b }
            java.lang.String r1 = "view"
            r2.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x007b }
            goto L_0x0084
        L_0x007b:
            java.lang.String r0 = com.facebook.appevents.codeless.ViewIndexer.TAG     // Catch:{ Exception -> 0x0094 }
            java.lang.String r1 = "Failed to create JSONObject"
            android.util.Log.e(r0, r1)     // Catch:{ Exception -> 0x0094 }
        L_0x0084:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r2)     // Catch:{ Exception -> 0x0094 }
            java.lang.String r1 = "viewTree.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x0094 }
            com.facebook.appevents.codeless.ViewIndexer r1 = r7.this$0     // Catch:{ Exception -> 0x0094 }
            r1.sendToServer(r0)     // Catch:{ Exception -> 0x0094 }
            goto L_0x009e
        L_0x0093:
            return
        L_0x0094:
            r0 = move-exception
            java.lang.String r1 = com.facebook.appevents.codeless.ViewIndexer.TAG
            java.lang.String r2 = "UI Component tree indexing failure!"
            android.util.Log.e(r1, r2, r0)
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1.run():void");
    }
}
