package com.newrelic.agent.android.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class PersistentUUID {
    private static File UUID_FILE = new File(Environment.getDataDirectory(), UUID_FILENAME);
    private static final String UUID_FILENAME = "nr_installation";
    private static final String UUID_KEY = "nr_uuid";
    private static AgentLog log = AgentLogManager.getAgentLog();

    public PersistentUUID(Context context) {
        UUID_FILE = new File(context.getFilesDir(), UUID_FILENAME);
    }

    @SuppressLint({"MissingPermission"})
    private String generateUniqueID(Context context) {
        String str = Build.SERIAL;
        String str2 = Build.ID;
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string)) {
                return UUID.randomUUID().toString();
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getDeviceId();
                }
            } catch (Exception unused) {
                str = "badf00d";
            }
            if (TextUtils.isEmpty(str)) {
                str = Build.HARDWARE + Build.DEVICE + Build.BOARD + Build.BRAND;
            }
            intToHexString(string.hashCode(), 8);
            intToHexString(str.hashCode(), 4);
            intToHexString(Build.VERSION.SDK_INT, 4);
            intToHexString(Build.VERSION.RELEASE.hashCode(), 12);
            throw new RuntimeException("Not supported (TODO)");
        } catch (Exception unused2) {
            return UUID.randomUUID().toString();
        }
    }

    private String intToHexString(int i11, int i12) {
        String hexString = Integer.toHexString(i11);
        char[] cArr = new char[(i12 - hexString.length())];
        Arrays.fill(cArr, '0');
        String str = new String(cArr) + hexString;
        String str2 = "";
        int i13 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i13++;
            str2 = str.substring(length, length + 1) + str2;
            if (i13 % i12 == 0) {
                str2 = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str2;
            }
        }
        if (str2.startsWith(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)) {
            return str2.substring(1, str2.length());
        }
        return str2;
    }

    public String getDeviceId(Context context) {
        String generateUniqueID = generateUniqueID(context);
        if (TextUtils.isEmpty(generateUniqueID)) {
            return UUID.randomUUID().toString();
        }
        return generateUniqueID;
    }

    public String getPersistentUUID() {
        String uUIDFromFileStore = getUUIDFromFileStore();
        if (!TextUtils.isEmpty(uUIDFromFileStore)) {
            StatsEngine.get().inc(MetricNames.METRIC_UUID_RECOVERED);
            return uUIDFromFileStore;
        }
        String uuid = UUID.randomUUID().toString();
        AgentLog agentLog = log;
        agentLog.info("Created random UUID: " + uuid);
        StatsEngine.get().inc(MetricNames.MOBILE_APP_INSTALL);
        AnalyticsControllerImpl.getInstance().addAttributeUnchecked(new AnalyticsAttribute(AnalyticsAttribute.APP_INSTALL_ATTRIBUTE, true), false);
        setPersistedUUID(uuid);
        return uuid;
    }

    public String getUUIDFromFileStore() {
        if (UUID_FILE.exists()) {
            try {
                return new JSONObject(new BufferedReader(new FileReader(UUID_FILE)).readLine()).getString(UUID_KEY);
            } catch (FileNotFoundException e11) {
                log.error(e11.getMessage());
            } catch (IOException e12) {
                log.error(e12.getMessage());
            } catch (JSONException e13) {
                log.error(e13.getMessage());
            } catch (NullPointerException e14) {
                log.error(e14.getMessage());
            }
        }
        return null;
    }

    public void noticeUUIDMetric(String str) {
        StatsEngine statsEngine = StatsEngine.get();
        if (statsEngine != null) {
            statsEngine.inc(MetricNames.METRIC_MOBILE + str);
            return;
        }
        AgentLog agentLog = log;
        agentLog.error("StatsEngine is null. " + str + "  not recorded.");
    }

    public void putUUIDToFileStore(String str) {
        BufferedWriter bufferedWriter;
        JSONObject jSONObject = new JSONObject();
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(UUID_FILE));
            jSONObject.put(UUID_KEY, (Object) str);
            bufferedWriter.write(jSONObject.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            return;
        } catch (Exception e11) {
            log.error(e11.getMessage());
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public void setPersistedUUID(String str) {
        putUUIDToFileStore(str);
    }
}
