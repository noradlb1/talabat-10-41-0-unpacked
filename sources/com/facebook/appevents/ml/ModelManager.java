package com.facebook.appevents.ml;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r6.a;
import r6.b;
import r6.c;
import r6.d;
import r6.e;

@RestrictTo({RestrictTo.Scope.LIBRARY})
@Instrumented
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u000278B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0007J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bH\u0002J9\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0006\u0010!\u001a\u00020\"2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020'0-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040-H\u0007¢\u0006\u0002\u00100J%\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'H\u0002¢\u0006\u0002\u00105J%\u00106\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'H\u0002¢\u0006\u0002\u00105R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u001c\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager;", "", "()V", "ASSET_URI_KEY", "", "CACHE_KEY_MODELS", "CACHE_KEY_REQUEST_TIMESTAMP", "MODEL_ASSERT_STORE", "MODEL_REQUEST_INTERVAL_MILLISECONDS", "", "MTML_INTEGRITY_DETECT_PREDICTION", "", "MTML_SUGGESTED_EVENTS_PREDICTION", "MTML_USE_CASE", "RULES_URI_KEY", "THRESHOLD_KEY", "USE_CASE_KEY", "VERSION_ID_KEY", "isLocaleEnglish", "", "()Z", "taskHandlers", "", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "addModels", "", "models", "Lorg/json/JSONObject;", "enable", "enableMTML", "fetchModels", "getRuleFile", "Ljava/io/File;", "task", "Lcom/facebook/appevents/ml/ModelManager$Task;", "isValidTimestamp", "timestamp", "", "parseJsonArray", "", "jsonArray", "Lorg/json/JSONArray;", "parseRawJsonObject", "jsonObject", "predict", "", "denses", "texts", "(Lcom/facebook/appevents/ml/ModelManager$Task;[[F[Ljava/lang/String;)[Ljava/lang/String;", "processIntegrityDetectionResult", "res", "Lcom/facebook/appevents/ml/MTensor;", "thresholds", "(Lcom/facebook/appevents/ml/MTensor;[F)[Ljava/lang/String;", "processSuggestedEventResult", "Task", "TaskHandler", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class ModelManager {
    @NotNull
    private static final String ASSET_URI_KEY = "asset_uri";
    @NotNull
    private static final String CACHE_KEY_MODELS = "models";
    @NotNull
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";
    @NotNull
    public static final ModelManager INSTANCE = new ModelManager();
    @NotNull
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    public static final int MODEL_REQUEST_INTERVAL_MILLISECONDS = 259200000;
    @NotNull
    private static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = CollectionsKt__CollectionsKt.listOf("none", "address", IntegrityManager.INTEGRITY_TYPE_HEALTH);
    @NotNull
    private static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = CollectionsKt__CollectionsKt.listOf("other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);
    @NotNull
    private static final String MTML_USE_CASE = "MTML";
    @NotNull
    private static final String RULES_URI_KEY = "rules_uri";
    @NotNull
    private static final String THRESHOLD_KEY = "thresholds";
    @NotNull
    private static final String USE_CASE_KEY = "use_case";
    @NotNull
    private static final String VERSION_ID_KEY = "version_id";
    @NotNull
    private static final Map<String, TaskHandler> taskHandlers = new ConcurrentHashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$Task;", "", "(Ljava/lang/String;I)V", "toKey", "", "toUseCase", "MTML_INTEGRITY_DETECT", "MTML_APP_EVENT_PREDICTION", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Task.values().length];
                iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 1;
                iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @NotNull
        public final String toKey() {
            int i11 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i11 == 1) {
                return "integrity_detect";
            }
            if (i11 == 2) {
                return "app_event_pred";
            }
            throw new NoWhenBranchMatchedException();
        }

        @NotNull
        public final String toUseCase() {
            int i11 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i11 == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i11 == 2) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u00020\u0001:\u0001*B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010)\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "", "useCase", "", "assetUri", "ruleUri", "versionId", "", "thresholds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[F)V", "getAssetUri", "()Ljava/lang/String;", "setAssetUri", "(Ljava/lang/String;)V", "model", "Lcom/facebook/appevents/ml/Model;", "getModel", "()Lcom/facebook/appevents/ml/Model;", "setModel", "(Lcom/facebook/appevents/ml/Model;)V", "onPostExecute", "Ljava/lang/Runnable;", "ruleFile", "Ljava/io/File;", "getRuleFile", "()Ljava/io/File;", "setRuleFile", "(Ljava/io/File;)V", "getRuleUri", "setRuleUri", "getThresholds", "()[F", "setThresholds", "([F)V", "getUseCase", "setUseCase", "getVersionId", "()I", "setVersionId", "(I)V", "setOnPostExecute", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TaskHandler {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        private String assetUri;
        @Nullable
        private Model model;
        /* access modifiers changed from: private */
        @Nullable
        public Runnable onPostExecute;
        @Nullable
        private File ruleFile;
        @Nullable
        private String ruleUri;
        @Nullable
        private float[] thresholds;
        @NotNull
        private String useCase;
        private int versionId;

        @Instrumented
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004J\u001c\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler$Companion;", "", "()V", "build", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "json", "Lorg/json/JSONObject;", "deleteOldFiles", "", "useCase", "", "versionId", "", "download", "uri", "name", "onComplete", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "execute", "handler", "master", "slaves", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final void deleteOldFiles(String str, int i11) {
                File[] listFiles;
                boolean z11;
                File mlDir = Utils.getMlDir();
                if (mlDir != null && (listFiles = mlDir.listFiles()) != null) {
                    if (listFiles.length == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        String str2 = str + '_' + i11;
                        int length = listFiles.length;
                        int i12 = 0;
                        while (i12 < length) {
                            File file = listFiles[i12];
                            i12++;
                            String name2 = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "name");
                            if (StringsKt__StringsJVMKt.startsWith$default(name2, str, false, 2, (Object) null) && !StringsKt__StringsJVMKt.startsWith$default(name2, str2, false, 2, (Object) null)) {
                                file.delete();
                            }
                        }
                    }
                }
            }

            private final void download(String str, String str2, FileDownloadTask.Callback callback) {
                File file = new File(Utils.getMlDir(), str2);
                if (str == null || file.exists()) {
                    callback.onComplete(file);
                } else {
                    AsyncTaskInstrumentation.execute(new FileDownloadTask(str, file, callback), new String[0]);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: execute$lambda-1  reason: not valid java name */
            public static final void m8924execute$lambda1(List list, File file) {
                Intrinsics.checkNotNullParameter(list, "$slaves");
                Intrinsics.checkNotNullParameter(file, "file");
                Model build = Model.Companion.build(file);
                if (build != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        TaskHandler taskHandler = (TaskHandler) it.next();
                        TaskHandler.Companion.download(taskHandler.getRuleUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId() + "_rule", new e(taskHandler, build));
                    }
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: execute$lambda-1$lambda-0  reason: not valid java name */
            public static final void m8925execute$lambda1$lambda0(TaskHandler taskHandler, Model model, File file) {
                Intrinsics.checkNotNullParameter(taskHandler, "$slave");
                Intrinsics.checkNotNullParameter(file, "file");
                taskHandler.setModel(model);
                taskHandler.setRuleFile(file);
                Runnable access$getOnPostExecute$p = taskHandler.onPostExecute;
                if (access$getOnPostExecute$p != null) {
                    access$getOnPostExecute$p.run();
                }
            }

            @Nullable
            public final TaskHandler build(@Nullable JSONObject jSONObject) {
                if (jSONObject == null) {
                    return null;
                }
                try {
                    String string = jSONObject.getString(ModelManager.USE_CASE_KEY);
                    String string2 = jSONObject.getString(ModelManager.ASSET_URI_KEY);
                    String optString = jSONObject.optString(ModelManager.RULES_URI_KEY, (String) null);
                    int i11 = jSONObject.getInt(ModelManager.VERSION_ID_KEY);
                    float[] access$parseJsonArray = ModelManager.INSTANCE.parseJsonArray(jSONObject.getJSONArray(ModelManager.THRESHOLD_KEY));
                    Intrinsics.checkNotNullExpressionValue(string, "useCase");
                    Intrinsics.checkNotNullExpressionValue(string2, "assetUri");
                    return new TaskHandler(string, string2, optString, i11, access$parseJsonArray);
                } catch (Exception unused) {
                    return null;
                }
            }

            public final void execute(@NotNull TaskHandler taskHandler) {
                Intrinsics.checkNotNullParameter(taskHandler, "handler");
                execute(taskHandler, CollectionsKt__CollectionsJVMKt.listOf(taskHandler));
            }

            public final void execute(@NotNull TaskHandler taskHandler, @NotNull List<TaskHandler> list) {
                Intrinsics.checkNotNullParameter(taskHandler, "master");
                Intrinsics.checkNotNullParameter(list, "slaves");
                deleteOldFiles(taskHandler.getUseCase(), taskHandler.getVersionId());
                download(taskHandler.getAssetUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId(), new d(list));
            }
        }

        public TaskHandler(@NotNull String str, @NotNull String str2, @Nullable String str3, int i11, @Nullable float[] fArr) {
            Intrinsics.checkNotNullParameter(str, "useCase");
            Intrinsics.checkNotNullParameter(str2, "assetUri");
            this.useCase = str;
            this.assetUri = str2;
            this.ruleUri = str3;
            this.versionId = i11;
            this.thresholds = fArr;
        }

        @NotNull
        public final String getAssetUri() {
            return this.assetUri;
        }

        @Nullable
        public final Model getModel() {
            return this.model;
        }

        @Nullable
        public final File getRuleFile() {
            return this.ruleFile;
        }

        @Nullable
        public final String getRuleUri() {
            return this.ruleUri;
        }

        @Nullable
        public final float[] getThresholds() {
            return this.thresholds;
        }

        @NotNull
        public final String getUseCase() {
            return this.useCase;
        }

        public final int getVersionId() {
            return this.versionId;
        }

        public final void setAssetUri(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.assetUri = str;
        }

        public final void setModel(@Nullable Model model2) {
            this.model = model2;
        }

        @NotNull
        public final TaskHandler setOnPostExecute(@Nullable Runnable runnable) {
            this.onPostExecute = runnable;
            return this;
        }

        public final void setRuleFile(@Nullable File file) {
            this.ruleFile = file;
        }

        public final void setRuleUri(@Nullable String str) {
            this.ruleUri = str;
        }

        public final void setThresholds(@Nullable float[] fArr) {
            this.thresholds = fArr;
        }

        public final void setUseCase(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.useCase = str;
        }

        public final void setVersionId(int i11) {
            this.versionId = i11;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Task.values().length];
            iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 1;
            iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ModelManager() {
    }

    private final void addModels(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                TaskHandler build = TaskHandler.Companion.build(jSONObject.getJSONObject(keys.next()));
                if (build != null) {
                    taskHandlers.put(build.getUseCase(), build);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    @JvmStatic
    public static final void enable() {
        Utility utility = Utility.INSTANCE;
        Utility.runOnNonUiThread(new a());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[Catch:{ Exception -> 0x0071 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[Catch:{ Exception -> 0x0071 }] */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8921enable$lambda0() {
        /*
            java.lang.String r0 = "model_request_timestamp"
            java.lang.String r1 = "models"
            android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r3 = "com.facebook.internal.MODEL_STORE"
            r4 = 0
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r3, r4)     // Catch:{ Exception -> 0x0071 }
            r3 = 0
            java.lang.String r3 = r2.getString(r1, r3)     // Catch:{ Exception -> 0x0071 }
            if (r3 == 0) goto L_0x0026
            int r5 = r3.length()     // Catch:{ Exception -> 0x0071 }
            if (r5 != 0) goto L_0x001d
            r4 = 1
        L_0x001d:
            if (r4 == 0) goto L_0x0020
            goto L_0x0026
        L_0x0020:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0071 }
            r4.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x0071 }
            goto L_0x002b
        L_0x0026:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0071 }
            r4.<init>()     // Catch:{ Exception -> 0x0071 }
        L_0x002b:
            r5 = 0
            long r5 = r2.getLong(r0, r5)     // Catch:{ Exception -> 0x0071 }
            com.facebook.internal.FeatureManager r3 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ Exception -> 0x0071 }
            com.facebook.internal.FeatureManager$Feature r3 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch:{ Exception -> 0x0071 }
            boolean r3 = com.facebook.internal.FeatureManager.isEnabled(r3)     // Catch:{ Exception -> 0x0071 }
            if (r3 == 0) goto L_0x0049
            int r3 = r4.length()     // Catch:{ Exception -> 0x0071 }
            if (r3 == 0) goto L_0x0049
            com.facebook.appevents.ml.ModelManager r3 = INSTANCE     // Catch:{ Exception -> 0x0071 }
            boolean r3 = r3.isValidTimestamp(r5)     // Catch:{ Exception -> 0x0071 }
            if (r3 != 0) goto L_0x0069
        L_0x0049:
            com.facebook.appevents.ml.ModelManager r3 = INSTANCE     // Catch:{ Exception -> 0x0071 }
            org.json.JSONObject r4 = r3.fetchModels()     // Catch:{ Exception -> 0x0071 }
            if (r4 != 0) goto L_0x0052
            return
        L_0x0052:
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r3 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r4)     // Catch:{ Exception -> 0x0071 }
            android.content.SharedPreferences$Editor r1 = r2.putString(r1, r3)     // Catch:{ Exception -> 0x0071 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0071 }
            android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r2)     // Catch:{ Exception -> 0x0071 }
            r0.apply()     // Catch:{ Exception -> 0x0071 }
        L_0x0069:
            com.facebook.appevents.ml.ModelManager r0 = INSTANCE     // Catch:{ Exception -> 0x0071 }
            r0.addModels(r4)     // Catch:{ Exception -> 0x0071 }
            r0.enableMTML()     // Catch:{ Exception -> 0x0071 }
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.m8921enable$lambda0():void");
    }

    private final void enableMTML() {
        ArrayList arrayList = new ArrayList();
        String str = null;
        int i11 = 0;
        for (Map.Entry next : taskHandlers.entrySet()) {
            String str2 = (String) next.getKey();
            TaskHandler taskHandler = (TaskHandler) next.getValue();
            if (Intrinsics.areEqual((Object) str2, (Object) Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                String assetUri = taskHandler.getAssetUri();
                int max = Math.max(i11, taskHandler.getVersionId());
                FeatureManager featureManager = FeatureManager.INSTANCE;
                if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                    arrayList.add(taskHandler.setOnPostExecute(new b()));
                }
                str = assetUri;
                i11 = max;
            }
            if (Intrinsics.areEqual((Object) str2, (Object) Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                str = taskHandler.getAssetUri();
                i11 = Math.max(i11, taskHandler.getVersionId());
                FeatureManager featureManager2 = FeatureManager.INSTANCE;
                if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                    arrayList.add(taskHandler.setOnPostExecute(new c()));
                }
            }
        }
        if (str != null && i11 > 0 && !arrayList.isEmpty()) {
            TaskHandler.Companion.execute(new TaskHandler(MTML_USE_CASE, str, (String) null, i11, (float[]) null), arrayList);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-1  reason: not valid java name */
    public static final void m8922enableMTML$lambda1() {
        SuggestedEventsManager.enable();
    }

    /* access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-2  reason: not valid java name */
    public static final void m8923enableMTML$lambda2() {
        IntegrityManager.enable();
    }

    private final JSONObject fetchModels() {
        String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", strArr));
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "app/model_asset", (GraphRequest.Callback) null);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
        if (jSONObject == null) {
            return null;
        }
        return parseRawJsonObject(jSONObject);
    }

    @JvmStatic
    @Nullable
    public static final File getRuleFile(@NotNull Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
        if (taskHandler == null) {
            return null;
        }
        return taskHandler.getRuleFile();
    }

    private final boolean isLocaleEnglish() {
        Locale resourceLocale = Utility.getResourceLocale();
        if (resourceLocale != null) {
            String language = resourceLocale.getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "locale.language");
            if (StringsKt__StringsKt.contains$default((CharSequence) language, (CharSequence) "en", false, 2, (Object) null)) {
                return true;
            }
            return false;
        }
        return true;
    }

    private final boolean isValidTimestamp(long j11) {
        return j11 != 0 && System.currentTimeMillis() - j11 < 259200000;
    }

    /* access modifiers changed from: private */
    public final float[] parseJsonArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        float[] fArr = new float[jSONArray.length()];
        int length = jSONArray.length();
        if (length > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                try {
                    String string = jSONArray.getString(i11);
                    Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                    fArr[i11] = Float.parseFloat(string);
                } catch (JSONException unused) {
                }
                if (i12 >= length) {
                    break;
                }
                i11 = i12;
            }
        }
        return fArr;
    }

    private final JSONObject parseRawJsonObject(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("data");
            int length = jSONArray.length();
            if (length <= 0) {
                return jSONObject2;
            }
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                JSONObject jSONObject3 = jSONArray.getJSONObject(i11);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(VERSION_ID_KEY, (Object) jSONObject3.getString(VERSION_ID_KEY));
                jSONObject4.put(USE_CASE_KEY, (Object) jSONObject3.getString(USE_CASE_KEY));
                jSONObject4.put(THRESHOLD_KEY, (Object) jSONObject3.getJSONArray(THRESHOLD_KEY));
                jSONObject4.put(ASSET_URI_KEY, (Object) jSONObject3.getString(ASSET_URI_KEY));
                if (jSONObject3.has(RULES_URI_KEY)) {
                    jSONObject4.put(RULES_URI_KEY, (Object) jSONObject3.getString(RULES_URI_KEY));
                }
                jSONObject2.put(jSONObject3.getString(USE_CASE_KEY), (Object) jSONObject4);
                if (i12 >= length) {
                    return jSONObject2;
                }
                i11 = i12;
            }
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    @JvmStatic
    @Nullable
    public static final String[] predict(@NotNull Task task, @NotNull float[][] fArr, @NotNull String[] strArr) {
        Model model;
        boolean z11;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(fArr, "denses");
        Intrinsics.checkNotNullParameter(strArr, "texts");
        TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
        if (taskHandler == null) {
            model = null;
        } else {
            model = taskHandler.getModel();
        }
        if (model == null) {
            return null;
        }
        float[] thresholds = taskHandler.getThresholds();
        int length = strArr.length;
        boolean z12 = false;
        int length2 = fArr[0].length;
        MTensor mTensor = new MTensor(new int[]{length, length2});
        if (length > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                System.arraycopy(fArr[i11], 0, mTensor.getData(), i11 * length2, length2);
                if (i12 >= length) {
                    break;
                }
                i11 = i12;
            }
        }
        MTensor predictOnMTML = model.predictOnMTML(mTensor, strArr, task.toKey());
        if (predictOnMTML == null || thresholds == null) {
            return null;
        }
        if (predictOnMTML.getData().length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        if (thresholds.length == 0) {
            z12 = true;
        }
        if (z12) {
            return null;
        }
        int i13 = WhenMappings.$EnumSwitchMapping$0[task.ordinal()];
        if (i13 == 1) {
            return INSTANCE.processSuggestedEventResult(predictOnMTML, thresholds);
        }
        if (i13 == 2) {
            return INSTANCE.processIntegrityDetectionResult(predictOnMTML, thresholds);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        float[] data = mTensor.getData();
        if (shape2 != fArr.length) {
            return null;
        }
        IntRange until = RangesKt___RangesKt.until(0, shape);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            int length = fArr.length;
            String str = "none";
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                int i13 = i12 + 1;
                if (data[(nextInt * shape2) + i12] >= fArr[i11]) {
                    str = MTML_INTEGRITY_DETECT_PREDICTION.get(i12);
                }
                i11++;
                i12 = i13;
            }
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
        int shape = mTensor.getShape(0);
        int shape2 = mTensor.getShape(1);
        float[] data = mTensor.getData();
        if (shape2 != fArr.length) {
            return null;
        }
        IntRange until = RangesKt___RangesKt.until(0, shape);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            int length = fArr.length;
            String str = "other";
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                int i13 = i12 + 1;
                if (data[(nextInt * shape2) + i12] >= fArr[i11]) {
                    str = MTML_SUGGESTED_EVENTS_PREDICTION.get(i12);
                }
                i11++;
                i12 = i13;
            }
            arrayList.add(str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
