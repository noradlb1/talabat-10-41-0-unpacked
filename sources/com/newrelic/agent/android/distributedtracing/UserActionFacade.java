package com.newrelic.agent.android.distributedtracing;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.AnalyticsEventCategory;
import i.b;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public class UserActionFacade {
    private static final AtomicReference<UserActionFacade> instance = new AtomicReference<>((Object) null);
    private static TraceFacade traceFacade = DistributedTracing.getInstance();

    public static UserActionFacade getInstance() {
        AtomicReference<UserActionFacade> atomicReference = instance;
        b.a(atomicReference, (Object) null, new UserActionFacade());
        return atomicReference.get();
    }

    public static void setTraceFacade(TraceFacade traceFacade2) {
        traceFacade = traceFacade2;
    }

    public void recordUserAction(UserActionType userActionType) {
        recordUserAction(userActionType, (Map<String, Object>) null);
    }

    public void recordUserAction(UserActionType userActionType, Map<String, Object> map) {
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("actionType", userActionType.toString());
            if (map != null) {
                treeMap.putAll(map);
            }
            AnalyticsControllerImpl.getInstance().internalRecordEvent(AnalyticsEvent.EVENT_NAME_IS_TYPE, AnalyticsEventCategory.UserAction, AnalyticsEvent.EVENT_TYPE_MOBILE_USER_ACTION, treeMap);
        }
    }
}
