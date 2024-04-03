package com.instabug.anr.model;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.commons.threading.c;
import com.instabug.commons.threading.e;
import com.instabug.crash.CrashReporting;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributesDbHelper;
import com.instabug.library.internal.storage.operation.WriteStateToFileDiskOperation;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ReportHelper;
import com.instabug.library.util.memory.MemoryUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class a {
    @Nullable
    public b a(String str, String str2, @NonNull IncidentMetadata incidentMetadata) throws JSONException, IOException {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            InstabugSDKLogger.e("IBG-CR", "Couldn't create a new instance of ANR due to a null context.");
            return null;
        }
        com.instabug.commons.threading.a aVar = new com.instabug.commons.threading.a(e.f46356a, new c("ANRError: Application Not Responding for at least 5000 ms.", str));
        JSONObject a11 = aVar.a();
        String jSONObject = !(a11 instanceof JSONObject) ? a11.toString() : JSONObjectInstrumentation.toString(a11);
        JSONArray b11 = aVar.b();
        b bVar = new b(applicationContext, jSONObject, !(b11 instanceof JSONArray) ? b11.toString() : JSONArrayInstrumentation.toString(b11), str2, incidentMetadata);
        if (bVar.g() != null) {
            a(bVar);
            bVar.g().setUri(DiskUtils.with(applicationContext).writeOperation(new WriteStateToFileDiskOperation(DiskUtils.createStateTextFile(applicationContext, CrashReporting.ANR_STATE), bVar.g().toJson())).execute());
            ReportHelper.update(bVar.g(), ReportHelper.getReport(InstabugCore.getOnReportCreatedListener()));
        }
        if (InstabugCore.getExtraAttachmentFiles() != null && InstabugCore.getExtraAttachmentFiles().size() >= 1) {
            for (Map.Entry next : InstabugCore.getExtraAttachmentFiles().entrySet()) {
                Uri newFileAttachmentUri = AttachmentsUtility.getNewFileAttachmentUri(applicationContext, (Uri) next.getKey(), (String) next.getValue());
                if (newFileAttachmentUri != null) {
                    bVar.a(newFileAttachmentUri);
                }
            }
        }
        return bVar;
    }

    private void a(b bVar) {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null && !MemoryUtils.isLowMemory(applicationContext) && InstabugCore.getFeatureState(Feature.USER_EVENTS) == Feature.State.ENABLED) {
            try {
                bVar.g().updateUserEvents();
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-CR", "Got error while parsing user events logs", e11);
            }
        }
        if (SettingsManager.getInstance().getOnReportCreatedListener() == null) {
            bVar.g().setTags(InstabugCore.getTagsAsString());
            bVar.g().updateConsoleLog();
            Feature.State featureState = InstabugCore.getFeatureState(Feature.USER_DATA);
            Feature.State state = Feature.State.ENABLED;
            if (featureState == state) {
                bVar.g().setUserData(InstabugCore.getUserData());
            }
            if (InstabugCore.getFeatureState(Feature.INSTABUG_LOGS) == state) {
                bVar.g().setInstabugLog(InstabugLog.getLogs());
            }
        }
        if (!InstabugCore.isFeatureAvailable(Feature.REPORT_PHONE_NUMBER) || bVar.g().getCustomUserAttribute() == null) {
            bVar.g().setUserAttributes(UserAttributesDbHelper.getSDKUserAttributes());
        } else {
            bVar.g().setUserAttributes(UserAttributesDbHelper.getSDKUserAttributesAndAppendToIt("IBG_phone_number", bVar.g().getCustomUserAttribute()));
        }
        bVar.g().updateVisualUserSteps();
    }
}
