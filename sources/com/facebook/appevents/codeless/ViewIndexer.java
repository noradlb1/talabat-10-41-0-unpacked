package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o6.e;
import o6.f;
import o6.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0006\u0010\u0015\u001a\u00020\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityReference", "Ljava/lang/ref/WeakReference;", "indexingTimer", "Ljava/util/Timer;", "previousDigest", "", "uiThreadHandler", "Landroid/os/Handler;", "processRequest", "", "request", "Lcom/facebook/GraphRequest;", "currentDigest", "schedule", "sendToServer", "tree", "unschedule", "Companion", "ScreenshotTaker", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class ViewIndexer {
    @NotNull
    private static final String APP_VERSION_PARAM = "app_version";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PLATFORM_PARAM = "platform";
    @NotNull
    private static final String REQUEST_TYPE = "request_type";
    @NotNull
    private static final String SUCCESS = "success";
    /* access modifiers changed from: private */
    @NotNull
    public static final String TAG;
    @NotNull
    private static final String TREE_PARAM = "tree";
    /* access modifiers changed from: private */
    @Nullable
    public static ViewIndexer instance;
    /* access modifiers changed from: private */
    @NotNull
    public final WeakReference<Activity> activityReference;
    @Nullable
    private Timer indexingTimer;
    @Nullable
    private String previousDigest = null;
    /* access modifiers changed from: private */
    @NotNull
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$Companion;", "", "()V", "APP_VERSION_PARAM", "", "PLATFORM_PARAM", "REQUEST_TYPE", "SUCCESS", "TAG", "TREE_PARAM", "instance", "Lcom/facebook/appevents/codeless/ViewIndexer;", "buildAppIndexingRequest", "Lcom/facebook/GraphRequest;", "appIndex", "accessToken", "Lcom/facebook/AccessToken;", "appId", "requestType", "sendToServerUnityInstance", "", "tree", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: buildAppIndexingRequest$lambda-0  reason: not valid java name */
        public static final void m8910buildAppIndexingRequest$lambda0(GraphResponse graphResponse) {
            Intrinsics.checkNotNullParameter(graphResponse, "it");
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, ViewIndexer.TAG, "App index sent to FB!");
        }

        @JvmStatic
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final GraphRequest buildAppIndexingRequest(@Nullable String str, @Nullable AccessToken accessToken, @Nullable String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str3, "requestType");
            if (str == null) {
                return null;
            }
            GraphRequest.Companion companion = GraphRequest.Companion;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.US, "%s/app_indexing", Arrays.copyOf(new Object[]{str2}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            GraphRequest newPostRequest = companion.newPostRequest(accessToken, format, (JSONObject) null, (GraphRequest.Callback) null);
            Bundle parameters = newPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString(ViewIndexer.TREE_PARAM, str);
            parameters.putString("app_version", AppEventUtility.getAppVersion());
            parameters.putString("platform", "android");
            parameters.putString("request_type", str3);
            if (Intrinsics.areEqual((Object) str3, (Object) Constants.APP_INDEXING)) {
                parameters.putString(Constants.DEVICE_SESSION_ID, CodelessManager.getCurrentDeviceSessionID$facebook_core_release());
            }
            newPostRequest.setParameters(parameters);
            newPostRequest.setCallback(new g());
            return newPostRequest;
        }

        @JvmStatic
        public final void sendToServerUnityInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, ViewIndexer.TREE_PARAM);
            ViewIndexer access$getInstance$cp = ViewIndexer.instance;
            if (access$getInstance$cp != null) {
                access$getInstance$cp.sendToServer(str);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/codeless/ViewIndexer$ScreenshotTaker;", "Ljava/util/concurrent/Callable;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "Ljava/lang/ref/WeakReference;", "call", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ScreenshotTaker implements Callable<String> {
        @NotNull
        private final WeakReference<View> rootView;

        public ScreenshotTaker(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "rootView");
            this.rootView = new WeakReference<>(view);
        }

        @NotNull
        public String call() {
            View view = this.rootView.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)");
            return encodeToString;
        }
    }

    static {
        String canonicalName = ViewIndexer.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "";
        }
        TAG = canonicalName;
    }

    public ViewIndexer(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityReference = new WeakReference<>(activity);
        instance = this;
    }

    @JvmStatic
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final GraphRequest buildAppIndexingRequest(@Nullable String str, @Nullable AccessToken accessToken, @Nullable String str2, @NotNull String str3) {
        return Companion.buildAppIndexingRequest(str, accessToken, str2, str3);
    }

    /* access modifiers changed from: private */
    /* renamed from: schedule$lambda-0  reason: not valid java name */
    public static final void m8908schedule$lambda0(ViewIndexer viewIndexer, TimerTask timerTask) {
        Intrinsics.checkNotNullParameter(viewIndexer, "this$0");
        Intrinsics.checkNotNullParameter(timerTask, "$indexingTask");
        try {
            Timer timer = viewIndexer.indexingTimer;
            if (timer != null) {
                timer.cancel();
            }
            viewIndexer.previousDigest = null;
            Timer timer2 = new Timer();
            timer2.scheduleAtFixedRate(timerTask, 0, 1000);
            viewIndexer.indexingTimer = timer2;
        } catch (Exception e11) {
            Log.e(TAG, "Error scheduling indexing job", e11);
        }
    }

    /* access modifiers changed from: private */
    public final void sendToServer(String str) {
        FacebookSdk.getExecutor().execute(new f(str, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: sendToServer$lambda-1  reason: not valid java name */
    public static final void m8909sendToServer$lambda1(String str, ViewIndexer viewIndexer) {
        Intrinsics.checkNotNullParameter(str, "$tree");
        Intrinsics.checkNotNullParameter(viewIndexer, "this$0");
        String md5hash = Utility.md5hash(str);
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (md5hash == null || !Intrinsics.areEqual((Object) md5hash, (Object) viewIndexer.previousDigest)) {
            viewIndexer.processRequest(Companion.buildAppIndexingRequest(str, currentAccessToken, FacebookSdk.getApplicationId(), Constants.APP_INDEXING), md5hash);
        }
    }

    @JvmStatic
    public static final void sendToServerUnityInstance(@NotNull String str) {
        Companion.sendToServerUnityInstance(str);
    }

    public final void processRequest(@Nullable GraphRequest graphRequest, @Nullable String str) {
        if (graphRequest != null) {
            GraphResponse executeAndWait = graphRequest.executeAndWait();
            try {
                JSONObject jSONObject = executeAndWait.getJSONObject();
                if (jSONObject != null) {
                    if (Intrinsics.areEqual((Object) "true", (Object) jSONObject.optString("success"))) {
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Successfully send UI component tree to server");
                        this.previousDigest = str;
                    }
                    if (jSONObject.has(Constants.APP_INDEXING_ENABLED)) {
                        CodelessManager.updateAppIndexing$facebook_core_release(jSONObject.getBoolean(Constants.APP_INDEXING_ENABLED));
                        return;
                    }
                    return;
                }
                Log.e(TAG, Intrinsics.stringPlus("Error sending UI component tree to Facebook: ", executeAndWait.getError()));
            } catch (JSONException e11) {
                Log.e(TAG, "Error decoding server response.", e11);
            }
        }
    }

    public final void schedule() {
        try {
            FacebookSdk.getExecutor().execute(new e(this, new ViewIndexer$schedule$indexingTask$1(this)));
        } catch (RejectedExecutionException e11) {
            Log.e(TAG, "Error scheduling indexing job", e11);
        }
    }

    public final void unschedule() {
        if (this.activityReference.get() != null) {
            try {
                Timer timer = this.indexingTimer;
                if (timer != null) {
                    timer.cancel();
                }
                this.indexingTimer = null;
            } catch (Exception e11) {
                Log.e(TAG, "Error unscheduling indexing job", e11);
            }
        }
    }
}
