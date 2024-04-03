package com.facebook.appevents.cloudbridge;

import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.huawei.wisesecurity.ucs.credential.Credential;
import com.instabug.library.networkv2.RequestResponse;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import n6.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001@B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010 \u001a\u00020!2\u001a\u0010\"\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b\u0018\u00010#H\u0000¢\u0006\u0002\b$J \u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0007J\n\u0010)\u001a\u0004\u0018\u00010\fH\u0007J=\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u00052\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b0#2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0000¢\u0006\u0004\b.\u0010/J\u0001\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u00010\f2\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001b2\b\b\u0002\u00105\u001a\u00020\u00052<\u00106\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020!\u0018\u000107H\u0000¢\u0006\u0002\b;J$\u0010<\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b\u0018\u00010#2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020!2\u0006\u0010=\u001a\u00020>H\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R,\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u001b0\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006A"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests;", "", "()V", "ACCEPTABLE_HTTP_RESPONSE", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "MAX_CACHED_TRANSFORMED_EVENTS", "MAX_PROCESSED_TRANSFORMED_EVENTS", "MAX_RETRY_COUNT", "RETRY_EVENTS_HTTP_RESPONSE", "TAG", "", "TIMEOUT_INTERVAL", "credentials", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "getCredentials$facebook_core_release", "()Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "setCredentials$facebook_core_release", "(Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;)V", "currentRetryCount", "getCurrentRetryCount$facebook_core_release", "()I", "setCurrentRetryCount$facebook_core_release", "(I)V", "transformedEvents", "", "", "getTransformedEvents$facebook_core_release", "()Ljava/util/List;", "setTransformedEvents$facebook_core_release", "(Ljava/util/List;)V", "appendEvents", "", "events", "", "appendEvents$facebook_core_release", "configure", "datasetID", "url", "accessKey", "getCredentials", "handleError", "responseCode", "processedEvents", "maxRetryCount", "handleError$facebook_core_release", "(Ljava/lang/Integer;Ljava/util/List;I)V", "makeHttpRequest", "urlStr", "requestMethod", "jsonBodyStr", "requestProperties", "timeOutInterval", "requestCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "requestResult", "makeHttpRequest$facebook_core_release", "transformAppEventRequestForCAPIG", "request", "Lcom/facebook/GraphRequest;", "transformGraphRequestAndSendToCAPIGEndPoint", "CloudBridgeCredentials", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventsConversionsAPITransformerWebRequests {
    /* access modifiers changed from: private */
    @NotNull
    public static final HashSet<Integer> ACCEPTABLE_HTTP_RESPONSE = SetsKt__SetsKt.hashSetOf(200, 202);
    @NotNull
    public static final AppEventsConversionsAPITransformerWebRequests INSTANCE = new AppEventsConversionsAPITransformerWebRequests();
    public static final int MAX_CACHED_TRANSFORMED_EVENTS = 1000;
    private static final int MAX_PROCESSED_TRANSFORMED_EVENTS = 10;
    public static final int MAX_RETRY_COUNT = 5;
    @NotNull
    private static final HashSet<Integer> RETRY_EVENTS_HTTP_RESPONSE = SetsKt__SetsKt.hashSetOf(503, 504, Integer.valueOf(RequestResponse.HttpStatusCode._4xx.RATE_LIMIT_REACHED));
    @NotNull
    private static final String TAG = "CAPITransformerWebRequests";
    private static final int TIMEOUT_INTERVAL = 60000;
    public static CloudBridgeCredentials credentials;
    private static int currentRetryCount;
    public static List<Map<String, Object>> transformedEvents;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "", "datasetID", "", "cloudBridgeURL", "accessKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getCloudBridgeURL", "getDatasetID", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CloudBridgeCredentials {
        @NotNull
        private final String accessKey;
        @NotNull
        private final String cloudBridgeURL;
        @NotNull
        private final String datasetID;

        public CloudBridgeCredentials(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "datasetID");
            Intrinsics.checkNotNullParameter(str2, "cloudBridgeURL");
            Intrinsics.checkNotNullParameter(str3, Credential.AK);
            this.datasetID = str;
            this.cloudBridgeURL = str2;
            this.accessKey = str3;
        }

        public static /* synthetic */ CloudBridgeCredentials copy$default(CloudBridgeCredentials cloudBridgeCredentials, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cloudBridgeCredentials.datasetID;
            }
            if ((i11 & 2) != 0) {
                str2 = cloudBridgeCredentials.cloudBridgeURL;
            }
            if ((i11 & 4) != 0) {
                str3 = cloudBridgeCredentials.accessKey;
            }
            return cloudBridgeCredentials.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.datasetID;
        }

        @NotNull
        public final String component2() {
            return this.cloudBridgeURL;
        }

        @NotNull
        public final String component3() {
            return this.accessKey;
        }

        @NotNull
        public final CloudBridgeCredentials copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "datasetID");
            Intrinsics.checkNotNullParameter(str2, "cloudBridgeURL");
            Intrinsics.checkNotNullParameter(str3, Credential.AK);
            return new CloudBridgeCredentials(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CloudBridgeCredentials)) {
                return false;
            }
            CloudBridgeCredentials cloudBridgeCredentials = (CloudBridgeCredentials) obj;
            return Intrinsics.areEqual((Object) this.datasetID, (Object) cloudBridgeCredentials.datasetID) && Intrinsics.areEqual((Object) this.cloudBridgeURL, (Object) cloudBridgeCredentials.cloudBridgeURL) && Intrinsics.areEqual((Object) this.accessKey, (Object) cloudBridgeCredentials.accessKey);
        }

        @NotNull
        public final String getAccessKey() {
            return this.accessKey;
        }

        @NotNull
        public final String getCloudBridgeURL() {
            return this.cloudBridgeURL;
        }

        @NotNull
        public final String getDatasetID() {
            return this.datasetID;
        }

        public int hashCode() {
            return (((this.datasetID.hashCode() * 31) + this.cloudBridgeURL.hashCode()) * 31) + this.accessKey.hashCode();
        }

        @NotNull
        public String toString() {
            return "CloudBridgeCredentials(datasetID=" + this.datasetID + ", cloudBridgeURL=" + this.cloudBridgeURL + ", accessKey=" + this.accessKey + ')';
        }
    }

    private AppEventsConversionsAPITransformerWebRequests() {
    }

    @JvmStatic
    public static final void configure(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "datasetID");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intrinsics.checkNotNullParameter(str3, Credential.AK);
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", str, str2, str3);
        AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
        appEventsConversionsAPITransformerWebRequests.setCredentials$facebook_core_release(new CloudBridgeCredentials(str, str2, str3));
        appEventsConversionsAPITransformerWebRequests.setTransformedEvents$facebook_core_release(new ArrayList());
    }

    @JvmStatic
    @Nullable
    public static final String getCredentials() {
        try {
            CloudBridgeCredentials credentials$facebook_core_release = INSTANCE.getCredentials$facebook_core_release();
            if (credentials$facebook_core_release == null) {
                return null;
            }
            return credentials$facebook_core_release.toString();
        } catch (UninitializedPropertyAccessException unused) {
            return null;
        }
    }

    public static /* synthetic */ void handleError$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, Integer num, List list, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 5;
        }
        appEventsConversionsAPITransformerWebRequests.handleError$facebook_core_release(num, list, i11);
    }

    public static /* synthetic */ void makeHttpRequest$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests, String str, String str2, String str3, Map map, int i11, Function2 function2, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            i11 = 60000;
        }
        appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, str2, str3, map, i11, function2);
    }

    private final List<Map<String, Object>> transformAppEventRequestForCAPIG(GraphRequest graphRequest) {
        JSONObject graphObject = graphRequest.getGraphObject();
        if (graphObject == null) {
            return null;
        }
        Map mutableMap = MapsKt__MapsKt.toMutableMap(Utility.convertJSONObjectToHashMap(graphObject));
        Object tag = graphRequest.getTag();
        if (tag != null) {
            mutableMap.put("custom_events", tag);
            StringBuilder sb2 = new StringBuilder();
            for (String str : mutableMap.keySet()) {
                sb2.append(str);
                sb2.append(" : ");
                sb2.append(mutableMap.get(str));
                sb2.append(System.getProperty("line.separator"));
            }
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "\nGraph Request data: \n\n%s \n\n", sb2);
            return AppEventsConversionsAPITransformer.INSTANCE.conversionsAPICompatibleEvent$facebook_core_release(mutableMap);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    @JvmStatic
    public static final void transformGraphRequestAndSendToCAPIGEndPoint(@NotNull GraphRequest graphRequest) {
        Intrinsics.checkNotNullParameter(graphRequest, "request");
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new b(graphRequest));
    }

    /* access modifiers changed from: private */
    /* renamed from: transformGraphRequestAndSendToCAPIGEndPoint$lambda-0  reason: not valid java name */
    public static final void m8902transformGraphRequestAndSendToCAPIGEndPoint$lambda0(GraphRequest graphRequest) {
        List list;
        Intrinsics.checkNotNullParameter(graphRequest, "$request");
        String graphPath = graphRequest.getGraphPath();
        if (graphPath == null) {
            list = null;
        } else {
            list = StringsKt__StringsKt.split$default((CharSequence) graphPath, new String[]{"/"}, false, 0, 6, (Object) null);
        }
        if (list == null || list.size() != 2) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n GraphPathComponents Error when logging: \n%s", graphRequest);
            return;
        }
        try {
            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = INSTANCE;
            String str = appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getCloudBridgeURL() + "/capi/" + appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getDatasetID() + "/events";
            List<Map<String, Object>> transformAppEventRequestForCAPIG = appEventsConversionsAPITransformerWebRequests.transformAppEventRequestForCAPIG(graphRequest);
            if (transformAppEventRequestForCAPIG != null) {
                appEventsConversionsAPITransformerWebRequests.appendEvents$facebook_core_release(transformAppEventRequestForCAPIG);
                int min = Math.min(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().size(), 10);
                List slice = CollectionsKt___CollectionsKt.slice(appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release(), new IntRange(0, min - 1));
                appEventsConversionsAPITransformerWebRequests.getTransformedEvents$facebook_core_release().subList(0, min).clear();
                JSONArray jSONArray = new JSONArray((Collection<?>) slice);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("data", jSONArray);
                linkedHashMap.put(Credential.AK, appEventsConversionsAPITransformerWebRequests.getCredentials$facebook_core_release().getAccessKey());
                JSONObject jSONObject = new JSONObject((Map<?, ?>) linkedHashMap);
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject, 2);
                Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "jsonBodyStr.toString(2)");
                companion.log(loggingBehavior, TAG, "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", str, graphRequest, jSONObjectInstrumentation);
                appEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(str, "POST", JSONObjectInstrumentation.toString(jSONObject), MapsKt__MapsJVMKt.mapOf(TuplesKt.to("Content-Type", "application/json")), 60000, new AppEventsConversionsAPITransformerWebRequests$transformGraphRequestAndSendToCAPIGEndPoint$1$1(slice));
            }
        } catch (UninitializedPropertyAccessException e11) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "\n Credentials not initialized Error when logging: \n%s", e11);
        }
    }

    public final void appendEvents$facebook_core_release(@Nullable List<? extends Map<String, ? extends Object>> list) {
        if (list != null) {
            getTransformedEvents$facebook_core_release().addAll(list);
        }
        int max = Math.max(0, getTransformedEvents$facebook_core_release().size() - 1000);
        if (max > 0) {
            setTransformedEvents$facebook_core_release(TypeIntrinsics.asMutableList(CollectionsKt___CollectionsKt.drop(getTransformedEvents$facebook_core_release(), max)));
        }
    }

    @NotNull
    public final CloudBridgeCredentials getCredentials$facebook_core_release() {
        CloudBridgeCredentials cloudBridgeCredentials = credentials;
        if (cloudBridgeCredentials != null) {
            return cloudBridgeCredentials;
        }
        Intrinsics.throwUninitializedPropertyAccessException("credentials");
        throw null;
    }

    public final int getCurrentRetryCount$facebook_core_release() {
        return currentRetryCount;
    }

    @NotNull
    public final List<Map<String, Object>> getTransformedEvents$facebook_core_release() {
        List<Map<String, Object>> list = transformedEvents;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("transformedEvents");
        throw null;
    }

    public final void handleError$facebook_core_release(@Nullable Integer num, @NotNull List<? extends Map<String, ? extends Object>> list, int i11) {
        Intrinsics.checkNotNullParameter(list, "processedEvents");
        if (!CollectionsKt___CollectionsKt.contains(RETRY_EVENTS_HTTP_RESPONSE, num)) {
            return;
        }
        if (currentRetryCount >= i11) {
            getTransformedEvents$facebook_core_release().clear();
            currentRetryCount = 0;
            return;
        }
        getTransformedEvents$facebook_core_release().addAll(0, list);
        currentRetryCount++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bd, code lost:
        r11 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c5, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c9, code lost:
        throw r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a5 A[Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ed A[Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void makeHttpRequest$facebook_core_release(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> r11, int r12, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> r13) {
        /*
            r7 = this;
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "CAPITransformerWebRequests"
            java.lang.String r2 = "urlStr"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            java.lang.String r2 = "requestMethod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            r2 = 0
            r3 = 0
            r4 = 1
            java.net.URL r5 = new java.net.URL     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r5.<init>(r8)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.net.URLConnection r8 = r5.openConnection()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.net.URLConnection r8 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r8)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.Object r8 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r8)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.net.URLConnection r8 = (java.net.URLConnection) r8     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            if (r8 == 0) goto L_0x00f9
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r8.setRequestMethod(r9)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            if (r11 != 0) goto L_0x002e
            goto L_0x004f
        L_0x002e:
            java.util.Set r9 = r11.keySet()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            if (r9 != 0) goto L_0x0035
            goto L_0x004f
        L_0x0035:
            java.util.Iterator r9 = r9.iterator()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
        L_0x0039:
            boolean r5 = r9.hasNext()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            if (r5 == 0) goto L_0x004f
            java.lang.Object r5 = r9.next()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.Object r6 = r11.get(r5)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r8.setRequestProperty(r5, r6)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            goto L_0x0039
        L_0x004f:
            java.lang.String r9 = r8.getRequestMethod()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.String r11 = "POST"
            boolean r9 = r9.equals(r11)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            if (r9 != 0) goto L_0x006a
            java.lang.String r9 = r8.getRequestMethod()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.String r11 = "PUT"
            boolean r9 = r9.equals(r11)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            if (r9 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r9 = r3
            goto L_0x006b
        L_0x006a:
            r9 = r4
        L_0x006b:
            r8.setDoOutput(r9)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r8.setConnectTimeout(r12)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.io.OutputStream r11 = r8.getOutputStream()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r9.<init>(r11)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.io.BufferedWriter r11 = new java.io.BufferedWriter     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.io.OutputStreamWriter r12 = new java.io.OutputStreamWriter     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r12.<init>(r9, r0)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r11.<init>(r12)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r11.write(r10)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r11.flush()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r11.close()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r9.close()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r9.<init>()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.util.HashSet<java.lang.Integer> r10 = ACCEPTABLE_HTTP_RESPONSE     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            int r11 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            boolean r10 = r10.contains(r11)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            if (r10 == 0) goto L_0x00ca
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.io.InputStreamReader r11 = new java.io.InputStreamReader     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.io.InputStream r12 = r8.getInputStream()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r11.<init>(r12, r0)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r10.<init>(r11)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
        L_0x00b3:
            java.lang.String r11 = r10.readLine()     // Catch:{ all -> 0x00c3 }
            if (r11 == 0) goto L_0x00bd
            r9.append(r11)     // Catch:{ all -> 0x00c3 }
            goto L_0x00b3
        L_0x00bd:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c3 }
            kotlin.io.CloseableKt.closeFinally(r10, r2)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            goto L_0x00ca
        L_0x00c3:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r8)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            throw r9     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
        L_0x00ca:
            java.lang.String r9 = r9.toString()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.String r10 = "connResponseSB.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            com.facebook.internal.Logger$Companion r10 = com.facebook.internal.Logger.Companion     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            com.facebook.LoggingBehavior r11 = com.facebook.LoggingBehavior.APP_EVENTS     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.String r12 = "\nResponse Received: \n%s\n%s"
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r0[r3] = r9     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            int r5 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r0[r4] = r5     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r10.log((com.facebook.LoggingBehavior) r11, (java.lang.String) r1, (java.lang.String) r12, (java.lang.Object[]) r0)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            if (r13 == 0) goto L_0x0131
            int r8 = r8.getResponseCode()     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            r13.invoke(r9, r8)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            goto L_0x0131
        L_0x00f9:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            java.lang.String r9 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r8.<init>(r9)     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
            throw r8     // Catch:{ UnknownHostException -> 0x0114, IOException -> 0x0101 }
        L_0x0101:
            r8 = move-exception
            com.facebook.internal.Logger$Companion r9 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r10 = com.facebook.LoggingBehavior.DEVELOPER_ERRORS
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r8 = r8.toString()
            r11[r3] = r8
            java.lang.String r8 = "Send to server failed: \n%s"
            r9.log((com.facebook.LoggingBehavior) r10, (java.lang.String) r1, (java.lang.String) r8, (java.lang.Object[]) r11)
            goto L_0x0131
        L_0x0114:
            r8 = move-exception
            com.facebook.internal.Logger$Companion r9 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r10 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r11 = new java.lang.Object[r4]
            java.lang.String r8 = r8.toString()
            r11[r3] = r8
            java.lang.String r8 = "Connection failed, retrying: \n%s"
            r9.log((com.facebook.LoggingBehavior) r10, (java.lang.String) r1, (java.lang.String) r8, (java.lang.Object[]) r11)
            if (r13 == 0) goto L_0x0131
            r8 = 503(0x1f7, float:7.05E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r13.invoke(r2, r8)
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.makeHttpRequest$facebook_core_release(java.lang.String, java.lang.String, java.lang.String, java.util.Map, int, kotlin.jvm.functions.Function2):void");
    }

    public final void setCredentials$facebook_core_release(@NotNull CloudBridgeCredentials cloudBridgeCredentials) {
        Intrinsics.checkNotNullParameter(cloudBridgeCredentials, "<set-?>");
        credentials = cloudBridgeCredentials;
    }

    public final void setCurrentRetryCount$facebook_core_release(int i11) {
        currentRetryCount = i11;
    }

    public final void setTransformedEvents$facebook_core_release(@NotNull List<Map<String, Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        transformedEvents = list;
    }
}
