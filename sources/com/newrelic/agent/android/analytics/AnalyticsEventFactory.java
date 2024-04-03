package com.newrelic.agent.android.analytics;

import java.util.Set;

class AnalyticsEventFactory {

    /* renamed from: com.newrelic.agent.android.analytics.AnalyticsEventFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.newrelic.agent.android.analytics.AnalyticsEventCategory[] r0 = com.newrelic.agent.android.analytics.AnalyticsEventCategory.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory = r0
                com.newrelic.agent.android.analytics.AnalyticsEventCategory r1 = com.newrelic.agent.android.analytics.AnalyticsEventCategory.Session     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.analytics.AnalyticsEventCategory r1 = com.newrelic.agent.android.analytics.AnalyticsEventCategory.RequestError     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.newrelic.agent.android.analytics.AnalyticsEventCategory r1 = com.newrelic.agent.android.analytics.AnalyticsEventCategory.Interaction     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.newrelic.agent.android.analytics.AnalyticsEventCategory r1 = com.newrelic.agent.android.analytics.AnalyticsEventCategory.Crash     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory     // Catch:{ NoSuchFieldError -> 0x003e }
                com.newrelic.agent.android.analytics.AnalyticsEventCategory r1 = com.newrelic.agent.android.analytics.AnalyticsEventCategory.Custom     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.newrelic.agent.android.analytics.AnalyticsEventCategory r1 = com.newrelic.agent.android.analytics.AnalyticsEventCategory.Breadcrumb     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.newrelic.agent.android.analytics.AnalyticsEventCategory r1 = com.newrelic.agent.android.analytics.AnalyticsEventCategory.NetworkRequest     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.newrelic.agent.android.analytics.AnalyticsEventCategory r1 = com.newrelic.agent.android.analytics.AnalyticsEventCategory.UserAction     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.analytics.AnalyticsEventFactory.AnonymousClass1.<clinit>():void");
        }
    }

    private AnalyticsEventFactory() {
    }

    public static AnalyticsEvent createEvent(String str, AnalyticsEventCategory analyticsEventCategory, String str2, Set<AnalyticsAttribute> set) {
        switch (AnonymousClass1.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory[analyticsEventCategory.ordinal()]) {
            case 1:
                return new SessionEvent(set);
            case 2:
                return new NetworkRequestErrorEvent(set);
            case 3:
                return new InteractionEvent(str, set);
            case 4:
                return new CrashEvent(str, set);
            case 5:
                return new CustomEvent(str, str2, set);
            case 6:
                return new BreadcrumbEvent(str, set);
            case 7:
                return new NetworkRequestEvent(set);
            case 8:
                return new UserActionEvent(str, set);
            default:
                return null;
        }
    }
}
