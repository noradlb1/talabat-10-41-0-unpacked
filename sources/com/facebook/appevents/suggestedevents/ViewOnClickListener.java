package com.facebook.appevents.suggestedevents;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import t6.c;
import t6.d;

@RestrictTo({RestrictTo.Scope.LIBRARY})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J \u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener;", "Landroid/view/View$OnClickListener;", "hostView", "Landroid/view/View;", "rootView", "activityName", "", "(Landroid/view/View;Landroid/view/View;Ljava/lang/String;)V", "baseListener", "hostViewWeakReference", "Ljava/lang/ref/WeakReference;", "rootViewWeakReference", "onClick", "", "view", "predictAndProcess", "pathID", "buttonText", "viewData", "Lorg/json/JSONObject;", "process", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class ViewOnClickListener implements View.OnClickListener {
    @NotNull
    private static final String API_ENDPOINT = "%s/suggested_events";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String OTHER_EVENT = "other";
    /* access modifiers changed from: private */
    @NotNull
    public static final Set<Integer> viewsAttachedListener = new HashSet();
    @NotNull
    private final String activityName;
    @Nullable
    private final View.OnClickListener baseListener;
    @NotNull
    private final WeakReference<View> hostViewWeakReference;
    @NotNull
    private final WeakReference<View> rootViewWeakReference;

    @Instrumented
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u000fJ \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener$Companion;", "", "()V", "API_ENDPOINT", "", "OTHER_EVENT", "viewsAttachedListener", "", "", "attachListener", "", "hostView", "Landroid/view/View;", "rootView", "activityName", "attachListener$facebook_core_release", "processPredictedResult", "predictedEvent", "buttonText", "dense", "", "queryHistoryAndProcess", "", "pathID", "sendPredictedResult", "eventToPost", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void processPredictedResult(String str, String str2, float[] fArr) {
            if (SuggestedEventsManager.isProductionEvents$facebook_core_release(str)) {
                new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(str, str2);
            } else if (SuggestedEventsManager.isEligibleEvents$facebook_core_release(str)) {
                sendPredictedResult(str, str2, fArr);
            }
        }

        /* access modifiers changed from: private */
        public final boolean queryHistoryAndProcess(String str, String str2) {
            String queryEvent = PredictionHistoryManager.queryEvent(str);
            if (queryEvent == null) {
                return false;
            }
            if (Intrinsics.areEqual((Object) queryEvent, (Object) "other")) {
                return true;
            }
            Utility utility = Utility.INSTANCE;
            Utility.runOnNonUiThread(new d(queryEvent, str2));
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: queryHistoryAndProcess$lambda-0  reason: not valid java name */
        public static final void m8931queryHistoryAndProcess$lambda0(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "$queriedEvent");
            Intrinsics.checkNotNullParameter(str2, "$buttonText");
            ViewOnClickListener.Companion.processPredictedResult(str, str2, new float[0]);
        }

        private final void sendPredictedResult(String str, String str2, float[] fArr) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString(InstabugDbContract.APMFragmentEventsEntry.COLUMN_NAME, str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb2 = new StringBuilder();
                int length = fArr.length;
                int i11 = 0;
                while (i11 < length) {
                    float f11 = fArr[i11];
                    i11++;
                    sb2.append(f11);
                    sb2.append(",");
                }
                jSONObject.put("dense", (Object) sb2.toString());
                jSONObject.put("button_text", (Object) str2);
                bundle.putString(TtmlNode.TAG_METADATA, JSONObjectInstrumentation.toString(jSONObject));
                GraphRequest.Companion companion = GraphRequest.Companion;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.US, ViewOnClickListener.API_ENDPOINT, Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                GraphRequest newPostRequest = companion.newPostRequest((AccessToken) null, format, (JSONObject) null, (GraphRequest.Callback) null);
                newPostRequest.setParameters(bundle);
                newPostRequest.executeAndWait();
            } catch (JSONException unused) {
            }
        }

        @JvmStatic
        public final void attachListener$facebook_core_release(@NotNull View view, @NotNull View view2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(view, "hostView");
            Intrinsics.checkNotNullParameter(view2, "rootView");
            Intrinsics.checkNotNullParameter(str, "activityName");
            int hashCode = view.hashCode();
            if (!ViewOnClickListener.viewsAttachedListener.contains(Integer.valueOf(hashCode))) {
                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                ViewHierarchy.setOnClickListener(view, new ViewOnClickListener(view, view2, str, (DefaultConstructorMarker) null));
                ViewOnClickListener.viewsAttachedListener.add(Integer.valueOf(hashCode));
            }
        }
    }

    private ViewOnClickListener(View view, View view2, String str) {
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.rootViewWeakReference = new WeakReference<>(view2);
        this.hostViewWeakReference = new WeakReference<>(view);
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            this.activityName = StringsKt__StringsJVMKt.replace$default(lowerCase, "activity", "", false, 4, (Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public /* synthetic */ ViewOnClickListener(View view, View view2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2, str);
    }

    @JvmStatic
    public static final void attachListener$facebook_core_release(@NotNull View view, @NotNull View view2, @NotNull String str) {
        Companion.attachListener$facebook_core_release(view, view2, str);
    }

    private final void predictAndProcess(String str, String str2, JSONObject jSONObject) {
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new c(jSONObject, str2, this, str));
    }

    /* access modifiers changed from: private */
    /* renamed from: predictAndProcess$lambda-0  reason: not valid java name */
    public static final void m8930predictAndProcess$lambda0(JSONObject jSONObject, String str, ViewOnClickListener viewOnClickListener, String str2) {
        Intrinsics.checkNotNullParameter(jSONObject, "$viewData");
        Intrinsics.checkNotNullParameter(str, "$buttonText");
        Intrinsics.checkNotNullParameter(viewOnClickListener, "this$0");
        Intrinsics.checkNotNullParameter(str2, "$pathID");
        try {
            Utility utility = Utility.INSTANCE;
            String appName = Utility.getAppName(FacebookSdk.getApplicationContext());
            if (appName != null) {
                String lowerCase = appName.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                float[] denseFeatures = FeatureExtractor.getDenseFeatures(jSONObject, lowerCase);
                String textFeature = FeatureExtractor.getTextFeature(str, viewOnClickListener.activityName, lowerCase);
                if (denseFeatures != null) {
                    ModelManager modelManager = ModelManager.INSTANCE;
                    String[] predict = ModelManager.predict(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{denseFeatures}, new String[]{textFeature});
                    if (predict != null) {
                        String str3 = predict[0];
                        PredictionHistoryManager.addPrediction(str2, str3);
                        if (!Intrinsics.areEqual((Object) str3, (Object) "other")) {
                            Companion.processPredictedResult(str3, str, denseFeatures);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
        }
    }

    private final void process() {
        View view = this.rootViewWeakReference.get();
        View view2 = this.hostViewWeakReference.get();
        if (view != null && view2 != null) {
            try {
                String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view2);
                String pathID = PredictionHistoryManager.getPathID(view2, textOfViewRecursively);
                if (pathID != null && !Companion.queryHistoryAndProcess(pathID, textOfViewRecursively)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("view", (Object) SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                    jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, (Object) this.activityName);
                    predictAndProcess(pathID, textOfViewRecursively, jSONObject);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View.OnClickListener onClickListener = this.baseListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        process();
    }
}
