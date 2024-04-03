package com.newrelic.agent.android.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.crash.Crash;
import com.newrelic.agent.android.crash.CrashStore;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class SharedPrefsCrashStore extends SharedPrefsStore implements CrashStore {
    private static final String STORE_FILE = "NRCrashStore";

    public SharedPrefsCrashStore(Context context) {
        this(context, STORE_FILE);
    }

    public List<Crash> fetchAll() {
        ArrayList arrayList = new ArrayList();
        for (Object next : super.fetchAll()) {
            if (next instanceof String) {
                try {
                    arrayList.add(Crash.crashFromJsonString((String) next));
                } catch (Exception e11) {
                    SharedPrefsStore.log.error("Exception encountered while deserializing crash", e11);
                }
            }
        }
        return arrayList;
    }

    public SharedPrefsCrashStore(Context context, String str) {
        super(context, str);
    }

    public void delete(Crash crash) {
        try {
            synchronized (this) {
                this.sharedPrefs.edit().remove(crash.getUuid().toString()).commit();
            }
        } catch (Exception e11) {
            SharedPrefsStore.log.error("SharedPrefsCrashStore.delete(): ", e11);
        }
    }

    public boolean store(Crash crash) {
        boolean commit;
        synchronized (this) {
            try {
                JsonObject asJsonObject = crash.asJsonObject();
                asJsonObject.add("uploadCount", SafeJsonPrimitive.factory((Number) Integer.valueOf(crash.getUploadCount())));
                String jsonElement = asJsonObject.toString();
                SharedPreferences.Editor edit = this.sharedPrefs.edit();
                edit.putString(crash.getUuid().toString(), jsonElement);
                StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_SIZE_UNCOMPRESSED, (long) jsonElement.length());
                commit = edit.commit();
            } catch (Exception e11) {
                SharedPrefsStore.log.error("SharedPrefsStore.store(String, String): ", e11);
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return commit;
    }
}
