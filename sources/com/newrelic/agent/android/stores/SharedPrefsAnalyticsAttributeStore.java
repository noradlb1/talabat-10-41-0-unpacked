package com.newrelic.agent.android.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsAttributeStore;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharedPrefsAnalyticsAttributeStore extends SharedPrefsStore implements AnalyticsAttributeStore {
    private static final String STORE_FILE = "NRAnalyticsAttributeStore";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    /* renamed from: com.newrelic.agent.android.stores.SharedPrefsAnalyticsAttributeStore$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType[] r0 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType = r0
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.stores.SharedPrefsAnalyticsAttributeStore.AnonymousClass1.<clinit>():void");
        }
    }

    public SharedPrefsAnalyticsAttributeStore(Context context) {
        super(context, STORE_FILE);
    }

    public List<AnalyticsAttribute> fetchAll() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.sharedPrefs.getAll().entrySet()) {
            AgentLog agentLog = log;
            agentLog.audit("SharedPrefsAnalyticsAttributeStore contains attribute [" + next.getKey() + "=" + next.getValue() + "]");
            if (next.getValue() instanceof String) {
                arrayList.add(new AnalyticsAttribute(next.getKey().toString(), next.getValue().toString(), true));
            } else if (next.getValue() instanceof Float) {
                arrayList.add(new AnalyticsAttribute(next.getKey().toString(), Double.valueOf(next.getValue().toString()).doubleValue(), true));
            } else if (next.getValue() instanceof Long) {
                arrayList.add(new AnalyticsAttribute(next.getKey().toString(), Double.longBitsToDouble(Long.valueOf(next.getValue().toString()).longValue()), true));
            } else if (next.getValue() instanceof Boolean) {
                arrayList.add(new AnalyticsAttribute(next.getKey().toString(), Boolean.valueOf(next.getValue().toString()).booleanValue(), true));
            } else {
                agentLog.error("SharedPrefsAnalyticsAttributeStore.fetchAll(): unsupported attribute [" + next.getKey() + "=" + next.getValue() + "]");
            }
        }
        return arrayList;
    }

    public SharedPrefsAnalyticsAttributeStore(Context context, String str) {
        super(context, str);
    }

    public void delete(AnalyticsAttribute analyticsAttribute) {
        synchronized (this) {
            AgentLog agentLog = log;
            agentLog.audit("SharedPrefsAnalyticsAttributeStore.delete(" + analyticsAttribute.getName() + ")");
            super.delete(analyticsAttribute.getName());
        }
    }

    public boolean store(AnalyticsAttribute analyticsAttribute) {
        synchronized (this) {
            if (!analyticsAttribute.isPersistent()) {
                return false;
            }
            SharedPreferences.Editor edit = this.sharedPrefs.edit();
            int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType[analyticsAttribute.getAttributeDataType().ordinal()];
            if (i11 == 1) {
                AgentLog agentLog = log;
                agentLog.audit("SharedPrefsAnalyticsAttributeStore.store(" + analyticsAttribute + ")");
                edit.putString(analyticsAttribute.getName(), analyticsAttribute.getStringValue());
            } else if (i11 == 2) {
                AgentLog agentLog2 = log;
                agentLog2.audit("SharedPrefsAnalyticsAttributeStore.store(" + analyticsAttribute + ")");
                edit.putLong(analyticsAttribute.getName(), Double.doubleToLongBits(analyticsAttribute.getDoubleValue()));
            } else if (i11 != 3) {
                AgentLog agentLog3 = log;
                agentLog3.error("SharedPrefsAnalyticsAttributeStore.store - unsupported analytic attribute data type" + analyticsAttribute.getName());
                return false;
            } else {
                AgentLog agentLog4 = log;
                agentLog4.audit("SharedPrefsAnalyticsAttributeStore.store(" + analyticsAttribute + ")");
                edit.putBoolean(analyticsAttribute.getName(), analyticsAttribute.getBooleanValue());
            }
            boolean applyOrCommitEditor = applyOrCommitEditor(edit);
            return applyOrCommitEditor;
        }
    }
}
