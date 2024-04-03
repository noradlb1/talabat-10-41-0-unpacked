package com.instabug.fatalhangs.model;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.fatalhangs.di.c;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper;
import com.instabug.library.internal.storage.operation.WriteStateToFileDiskOperation;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.model.Report;
import com.instabug.library.model.State;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ReportHelper;
import com.instabug.library.util.memory.MemoryUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f46480a = new b();

    private b() {
    }

    private final void b(Context context, State state) {
        if (state != null) {
            if (!MemoryUtils.isLowMemory(context) && InstabugCore.getFeatureState(Feature.USER_EVENTS) == Feature.State.ENABLED) {
                try {
                    state.updateUserEvents();
                } catch (JSONException e11) {
                    InstabugSDKLogger.e("IBG-CR", "Got error while parsing user events logs", e11);
                }
            }
            if (SettingsManager.getInstance().getOnReportCreatedListener() == null) {
                state.setTags(InstabugCore.getTagsAsString());
                state.updateConsoleLog();
                Feature.State featureState = InstabugCore.getFeatureState(Feature.USER_DATA);
                Feature.State state2 = Feature.State.ENABLED;
                if (featureState == state2) {
                    state.setUserData(InstabugCore.getUserData());
                }
                if (InstabugCore.getFeatureState(Feature.INSTABUG_LOGS) == state2) {
                    state.setInstabugLog(InstabugLog.getLogs());
                }
            }
            if (!InstabugCore.isFeatureAvailable(Feature.REPORT_PHONE_NUMBER) || state.getCustomUserAttribute() == null) {
                state.setUserAttributes(UserAttributesDbHelper.getSDKUserAttributes());
            } else {
                String customUserAttribute = state.getCustomUserAttribute();
                Intrinsics.checkNotNull(customUserAttribute);
                state.setUserAttributes(UserAttributesDbHelper.getSDKUserAttributesAndAppendToIt("IBG_phone_number", customUserAttribute));
            }
            state.updateVisualUserSteps();
        }
    }

    @Nullable
    public final c a(@Nullable Context context, long j11, @NotNull JSONObject jSONObject, @NotNull String str, @NotNull IncidentMetadata incidentMetadata) {
        String str2;
        JSONObject put;
        JSONObject put2;
        Intrinsics.checkNotNullParameter(jSONObject, "mainThreadData");
        Intrinsics.checkNotNullParameter(str, "threadsData");
        Intrinsics.checkNotNullParameter(incidentMetadata, TtmlNode.TAG_METADATA);
        if (context == null) {
            InstabugSDKLogger.v("FatalHang", "Couldn't create a new instance of FatalHang due to a null context.");
            return null;
        }
        c cVar = new c(incidentMetadata);
        cVar.a(String.valueOf(System.currentTimeMillis()));
        cVar.d(StringsKt__StringsJVMKt.replace$default("The app’s main thread was unresponsive for more than xxx milliseconds", "xxx", String.valueOf(j11), false, 4, (Object) null));
        JSONObject optJSONObject = jSONObject.optJSONObject("error");
        if (!(optJSONObject == null || (put = optJSONObject.put("name", (Object) "Fatal Hang")) == null || (put2 = put.put("exception", (Object) Intrinsics.stringPlus("Fatal Hang: ", cVar.f()))) == null)) {
            put2.put("message", (Object) Intrinsics.stringPlus("Fatal Hang: ", cVar.f()));
        }
        if (optJSONObject == null) {
            str2 = null;
        } else {
            str2 = optJSONObject.optString("stackTrace");
        }
        if (str2 != null) {
            String str3 = "Fatal Hang: " + cVar.f() + str2;
            if (optJSONObject != null) {
                optJSONObject.put("stackTrace", (Object) str3);
            }
        }
        if (optJSONObject != null) {
            jSONObject.put("error", (Object) optJSONObject);
        }
        cVar.c(JSONObjectInstrumentation.toString(jSONObject));
        cVar.e(str);
        Activity currentRealActivity = c.f46466a.i().getCurrentRealActivity();
        if (currentRealActivity != null) {
            cVar.b(currentRealActivity.getClass().getName());
        }
        cVar.a(State.getState(context));
        b bVar = f46480a;
        bVar.b(context, cVar.h());
        Report report = ReportHelper.getReport(InstabugCore.getOnReportCreatedListener());
        Intrinsics.checkNotNullExpressionValue(report, "getReport(InstabugCore.g…nReportCreatedListener())");
        ReportHelper.update(cVar.h(), report);
        cVar.b(bVar.a(context, cVar.h()));
        cVar.a((State) null);
        bVar.a(context, cVar);
        return cVar;
    }

    private final void a(Context context, c cVar) {
        if (InstabugCore.getExtraAttachmentFiles() != null) {
            LinkedHashMap<Uri, String> extraAttachmentFiles = InstabugCore.getExtraAttachmentFiles();
            Intrinsics.checkNotNull(extraAttachmentFiles);
            if (extraAttachmentFiles.size() >= 1) {
                LinkedHashMap<Uri, String> extraAttachmentFiles2 = InstabugCore.getExtraAttachmentFiles();
                Intrinsics.checkNotNull(extraAttachmentFiles2);
                Intrinsics.checkNotNullExpressionValue(extraAttachmentFiles2, "getExtraAttachmentFiles()!!");
                for (Map.Entry next : extraAttachmentFiles2.entrySet()) {
                    Uri newFileAttachmentUri = AttachmentsUtility.getNewFileAttachmentUri(context, (Uri) next.getKey(), (String) next.getValue());
                    if (newFileAttachmentUri != null) {
                        cVar.a(newFileAttachmentUri);
                    }
                }
            }
        }
    }

    private final Uri a(Context context, State state) {
        String str;
        File createStateTextFile = DiskUtils.createStateTextFile(context, "fatal_hang_state");
        DiskUtils with = DiskUtils.with(context);
        if (state == null) {
            str = null;
        } else {
            str = state.toJson();
        }
        return with.writeOperation(new WriteStateToFileDiskOperation(createStateTextFile, str)).execute();
    }
}
