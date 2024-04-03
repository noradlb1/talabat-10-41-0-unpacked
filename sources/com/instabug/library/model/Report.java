package com.instabug.library.model;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Report {
    private static final int FILES_LIST_LIMIT = 3;
    private static final int ITEMS_LIST_LIMIT = 10;
    private ArrayList<a> consoleLogs = new ArrayList<>();
    private HashMap<Uri, String> fileAttachments = new HashMap<>();
    private ArrayList<String> tags = new ArrayList<>();
    private HashMap<String, String> userAttributes = new HashMap<>();
    @Nullable
    private String userData;

    public interface OnReportCreatedListener {
        void onReportCreated(Report report);
    }

    public void addConsoleLogs(ArrayList<a> arrayList) {
        if (arrayList != null) {
            int i11 = 0;
            while (this.consoleLogs.size() <= 10 && i11 < arrayList.size()) {
                this.consoleLogs.add(arrayList.get(i11));
                i11++;
            }
            if (i11 < arrayList.size()) {
                InstabugSDKLogger.w("IBG-Core", "Some console logs were ignored. Maximum allowed logs count reached. Please note that you can add up to 10 log messages.");
            }
        }
    }

    public void addFileAttachment(@NonNull Uri uri, @NonNull String str) {
        if (this.fileAttachments.size() < 3) {
            this.fileAttachments.put(uri, str);
        } else {
            InstabugSDKLogger.w("IBG-Core", "File was ignored. Maximum allowed files count reached. Please note that you can add up to 10 files.");
        }
    }

    public void addTag(String... strArr) {
        if (strArr != null) {
            int i11 = 0;
            while (this.tags.size() < 10 && i11 < strArr.length) {
                this.tags.add(strArr[i11]);
                i11++;
            }
            if (i11 < strArr.length) {
                InstabugSDKLogger.w("IBG-Core", "Some tags were ignored. Maximum allowed tags count reached. Please note that you can add up to 10 tags.");
            }
        }
    }

    public void addUserAttributes(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
            while (this.userAttributes.size() < 10 && it.hasNext()) {
                Map.Entry next = it.next();
                if (next != null) {
                    this.userAttributes.put((String) next.getKey(), (String) next.getValue());
                }
            }
            if (it.hasNext()) {
                InstabugSDKLogger.w("IBG-Core", "Some attributes were ignored. Maximum allowed attributes count reached. Please note that you can add up to 10 user attributes.");
            }
        }
    }

    public void appendToConsoleLogs(String str) {
        if (this.consoleLogs.size() >= 10) {
            InstabugSDKLogger.w("IBG-Core", "Console log was ignored. Maximum allowed logs count reached. Please note that you can add up to 10 log messages.");
            return;
        }
        a aVar = new a();
        aVar.c(str);
        aVar.a(System.currentTimeMillis());
        this.consoleLogs.add(aVar);
    }

    public ArrayList<a> getConsoleLog() {
        return this.consoleLogs;
    }

    public HashMap<Uri, String> getFileAttachments() {
        return this.fileAttachments;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public HashMap<String, String> getUserAttributes() {
        return this.userAttributes;
    }

    @Nullable
    public String getUserData() {
        return this.userData;
    }

    public void logDebug(String str) {
        if (InstabugCore.getFeatureState(Feature.INSTABUG_LOGS) == Feature.State.ENABLED) {
            InstabugLog.d(str);
        }
    }

    public void logError(String str) {
        if (InstabugCore.getFeatureState(Feature.INSTABUG_LOGS) == Feature.State.ENABLED) {
            InstabugLog.e(str);
        }
    }

    public void logInfo(String str) {
        if (InstabugCore.getFeatureState(Feature.INSTABUG_LOGS) == Feature.State.ENABLED) {
            InstabugLog.i(str);
        }
    }

    public void logVerbose(String str) {
        if (InstabugCore.getFeatureState(Feature.INSTABUG_LOGS) == Feature.State.ENABLED) {
            InstabugLog.v(str);
        }
    }

    public void logWarn(String str) {
        if (InstabugCore.getFeatureState(Feature.INSTABUG_LOGS) == Feature.State.ENABLED) {
            InstabugLog.w(str);
        }
    }

    public void setUserAttribute(@NonNull String str, String str2) {
        if (this.userAttributes.size() >= 10) {
            InstabugSDKLogger.w("IBG-Core", "User attribute was ignored. Maximum allowed attributes count reached. Please note that you can add up to 10 user attributes.");
        } else {
            this.userAttributes.put(str, str2);
        }
    }

    public void setUserData(@NonNull String str) {
        this.userData = StringUtility.trimString(str, 1000);
    }

    public void addFileAttachment(@NonNull byte[] bArr, @NonNull String str) {
        Uri uriFromBytes;
        if (this.fileAttachments.size() >= 3) {
            InstabugSDKLogger.w("IBG-Core", "File was ignored. Maximum allowed files count reached. Please note that you can add up to 10 files.");
            return;
        }
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null && AttachmentsUtility.isValidSize((double) bArr.length, 5.0d) && (uriFromBytes = AttachmentsUtility.getUriFromBytes(applicationContext, bArr, str)) != null) {
            this.fileAttachments.put(uriFromBytes, str);
        }
    }

    public void addTag(ArrayList<String> arrayList) {
        if (arrayList != null) {
            int i11 = 0;
            while (this.tags.size() < 10 && i11 < arrayList.size()) {
                this.tags.add(arrayList.get(i11));
                i11++;
            }
            if (i11 < arrayList.size()) {
                InstabugSDKLogger.w("IBG-Core", "Some tags were ignored. Maximum allowed tags count reached. Please note that you can add up to 10 tags.");
            }
        }
    }
}
