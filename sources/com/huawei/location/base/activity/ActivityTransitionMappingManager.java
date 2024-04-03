package com.huawei.location.base.activity;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionEvent;
import com.huawei.hms.location.entity.activity.ActivityTransitionResult;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.entity.MovementEvent;
import com.huawei.location.lite.common.log.LogConsole;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ActivityTransitionMappingManager {
    private static final String TAG = "ActivityTransitionMappingManager";
    private List<ActivityTransitionMappingInfo> infos = new CopyOnWriteArrayList();
    private Map<String, Integer> returnEventsCache = new ConcurrentHashMap();

    private void callBackWithReport(ActivityTransitionMappingInfo activityTransitionMappingInfo, List<ActivityTransitionEvent> list) {
        try {
            activityTransitionMappingInfo.getCallback().onActivityTransition(new ActivityTransitionResult(list));
        } catch (Exception unused) {
            LogConsole.e(TAG, "Failed to get activity transition callback", true);
        }
    }

    private List<ActivityTransitionEvent> getActivityTransitionEvents(List<ActivityTransition> list, Iterable<MovementEvent> iterable) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.isEmpty() || iterable == null)) {
            for (ActivityTransition next : list) {
                for (MovementEvent next2 : iterable) {
                    String movement = next2.getMovement();
                    int eventType = next2.getEventType();
                    int intValue = ActivityRecognitionConstantsMapping.getActivityTypeOpposite(movement).intValue();
                    int intValue2 = ActivityRecognitionConstantsMapping.getTransitionTypeOpposite(Integer.valueOf(eventType)).intValue();
                    if (next.getActivityType() == intValue && next.getTransitionType() == intValue2) {
                        arrayList.add(new ActivityTransitionEvent(intValue, intValue2, SystemClock.elapsedRealtimeNanos()));
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean isUpdate(ActivityTransitionMappingInfo activityTransitionMappingInfo) {
        for (int i11 = 0; i11 < this.infos.size(); i11++) {
            if (this.infos.get(i11).equals(activityTransitionMappingInfo)) {
                ActivityTransitionMappingInfo activityTransitionMappingInfo2 = this.infos.get(i11);
                LogConsole.i(TAG, "need update atMappingInfo:atRequestSize:" + activityTransitionMappingInfo2.getActivityTransitions().size() + "->" + activityTransitionMappingInfo.getActivityTransitions().size());
                activityTransitionMappingInfo2.setActivityTransitions(activityTransitionMappingInfo.getActivityTransitions());
                activityTransitionMappingInfo2.setClientInfo(activityTransitionMappingInfo.getClientInfo());
                return true;
            }
        }
        return false;
    }

    public void addActivityTransitionMappingInfo(List<ActivityTransition> list, ATCallback aTCallback, ClientInfo clientInfo) {
        String str;
        LogConsole.i(TAG, "addActivityTransitionMappingInfo callback:");
        if (list == null || list.isEmpty() || aTCallback == null) {
            str = "null == transitions || transitions.size() < 1 || null == pendingIntent";
        } else {
            ActivityTransitionMappingInfo activityTransitionMappingInfo = new ActivityTransitionMappingInfo();
            activityTransitionMappingInfo.setActivityTransitions(list);
            activityTransitionMappingInfo.setCallback(aTCallback);
            activityTransitionMappingInfo.setClientInfo(clientInfo);
            if (this.infos.isEmpty() || !isUpdate(activityTransitionMappingInfo)) {
                this.infos.add(activityTransitionMappingInfo);
            }
            str = "addActivityTransitionMappingInfo end size is " + this.infos.size();
        }
        LogConsole.i(TAG, str);
    }

    public Iterable<MovementEvent> compareReturnEventCache(Iterable<MovementEvent> iterable) {
        LogConsole.i(TAG, "compareReturnEventCache");
        ArrayList arrayList = new ArrayList();
        for (MovementEvent add : iterable) {
            arrayList.add(add);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MovementEvent movementEvent = (MovementEvent) it.next();
            String movement = movementEvent.getMovement();
            int eventType = movementEvent.getEventType();
            LogConsole.i(TAG, "movement " + movement + "eventType " + eventType);
            if (this.returnEventsCache.isEmpty()) {
                this.returnEventsCache.put(movement, Integer.valueOf(eventType));
            } else {
                Integer num = this.returnEventsCache.get(movement);
                this.returnEventsCache.put(movement, Integer.valueOf(eventType));
                if (num != null && num.intValue() == eventType) {
                    LogConsole.i(TAG, "already report , remove it");
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public List<ActivityTransitionMappingInfo> getInfos() {
        return this.infos;
    }

    public boolean isEmptyRequest() {
        List<ActivityTransitionMappingInfo> list = this.infos;
        return list == null || list.isEmpty();
    }

    public List<ActivityTransition> removeActivityTransitionMappingInfo(ATCallback aTCallback) {
        LogConsole.i(TAG, "removeActivityTransitionMappingInfo callback: " + aTCallback + " ,size is " + this.infos.size(), true);
        HashMap hashMap = new HashMap(this.infos.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ActivityTransitionMappingInfo next : this.infos) {
            List<ActivityTransition> activityTransitions = next.getActivityTransitions();
            if (next.getCallback().equals(aTCallback)) {
                arrayList2.add(next);
                arrayList.addAll(activityTransitions);
            } else if (activityTransitions != null && activityTransitions.size() > 0) {
                for (ActivityTransition next2 : activityTransitions) {
                    hashMap.put(next2.getActivityType() + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + next2.getTransitionType(), Boolean.TRUE);
                }
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ActivityTransition activityTransition = (ActivityTransition) it.next();
                if (!hashMap.isEmpty()) {
                    if (hashMap.containsKey(activityTransition.getActivityType() + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + activityTransition.getTransitionType())) {
                        it.remove();
                        LogConsole.i(TAG, "other request contain:" + activityTransition.getActivityType() + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + activityTransition.getTransitionType() + ", not disable");
                    }
                }
            }
        }
        this.infos.removeAll(arrayList2);
        LogConsole.i(TAG, "removeActivityTransitionMappingInfo end size is " + this.infos.size());
        return arrayList;
    }

    public List<ActivityTransitionMappingInfo> removeActivityTransitionMappingInfoByPackageName(String str) {
        LogConsole.i(TAG, "removeActivityTransitionMappingInfoByPackageName:enter:" + str);
        ArrayList arrayList = new ArrayList();
        for (ActivityTransitionMappingInfo next : this.infos) {
            if (next.getClientInfo().getPackageName().equals(str)) {
                arrayList.add(next);
            }
        }
        this.infos.removeAll(arrayList);
        LogConsole.i(TAG, "removeActivityTransitionMappingInfoByPackageName:exit:" + str);
        return arrayList;
    }

    public void sendActivityTransitionMappingInfo(Iterable<MovementEvent> iterable, Context context) {
        LogConsole.i(TAG, "sendActivityTransitionMappingInfo:requestList size:" + this.infos.size(), true);
        for (ActivityTransitionMappingInfo next : this.infos) {
            List<ActivityTransitionEvent> activityTransitionEvents = getActivityTransitionEvents(next.getActivityTransitions(), iterable);
            LogConsole.i(TAG, "sendActivityTransitionMappingInfo,events size is " + activityTransitionEvents.size());
            if (activityTransitionEvents.size() > 0) {
                callBackWithReport(next, activityTransitionEvents);
            }
        }
    }
}
