package com.huawei.location.base.activity;

import com.huawei.location.base.activity.constant.MovementConstants;
import java.util.HashMap;
import java.util.Map;

public class ActivityRecognitionConstantsMapping {
    private static final int UN_VALID_VAL = -1;
    private static Map<Integer, String> activityTypeMap = new HashMap(10);
    private static Map<String, Integer> activityTypeOppositeMap = new HashMap(10);
    private static Map<Integer, Integer> transitionTypeMap = new HashMap(2);
    private static Map<Integer, Integer> transitionTypeOppositeMap = new HashMap(2);

    static {
        transitionTypeMap.put(0, 1);
        transitionTypeMap.put(1, 2);
        transitionTypeOppositeMap.put(1, 0);
        transitionTypeOppositeMap.put(2, 1);
        activityTypeMap.put(0, MovementConstants.MSDP_MOVEMENT_IN_VEHICLE);
        activityTypeMap.put(1, MovementConstants.MSDP_MOVEMENT_ON_BICYCLE);
        activityTypeMap.put(2, MovementConstants.MSDP_MOVEMENT_ON_FOOT);
        activityTypeMap.put(3, MovementConstants.MSDP_MOVEMENT_STILL);
        activityTypeMap.put(4, "android.activity_recognition.unknown");
        activityTypeMap.put(7, MovementConstants.MSDP_MOVEMENT_WALKING);
        activityTypeMap.put(8, MovementConstants.MSDP_MOVEMENT_RUNNING);
        activityTypeMap.put(10, MovementConstants.MSDP_MOVEMENT_ELEVATOR);
        Map<Integer, String> map = activityTypeMap;
        Object obj = MovementConstants.MSDP_MOVEMENT_ELEVATOR;
        map.put(9, MovementConstants.MSDP_MOVEMENT_FAST_WALKING);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_IN_VEHICLE, 0);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_ON_BICYCLE, 1);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_ON_FOOT, 2);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_STILL, 3);
        activityTypeOppositeMap.put("android.activity_recognition.unknown", 4);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_WALKING, 7);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_RUNNING, 8);
        activityTypeOppositeMap.put(obj, 10);
        activityTypeOppositeMap.put(MovementConstants.MSDP_MOVEMENT_FAST_WALKING, 9);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r2 = activityTypeMap.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getActivityType(java.lang.Integer r2) {
        /*
            java.lang.String r0 = ""
            if (r2 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.util.Map<java.lang.Integer, java.lang.String> r1 = activityTypeMap
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0010
            return r0
        L_0x0010:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.base.activity.ActivityRecognitionConstantsMapping.getActivityType(java.lang.Integer):java.lang.String");
    }

    public static Map<Integer, String> getActivityTypeMap() {
        return activityTypeMap;
    }

    public static Integer getActivityTypeOpposite(String str) {
        Integer num;
        if (str == null || "".equals(str) || (num = activityTypeOppositeMap.get(str)) == null) {
            return -1;
        }
        return num;
    }

    public static Map<String, Integer> getActivityTypeOppositeMap() {
        return activityTypeOppositeMap;
    }

    public static Integer getTransitionType(Integer num) {
        Integer num2;
        if (num == null || (num2 = transitionTypeMap.get(num)) == null) {
            return -1;
        }
        return num2;
    }

    public static Map<Integer, Integer> getTransitionTypeMap() {
        return transitionTypeMap;
    }

    public static Integer getTransitionTypeOpposite(Integer num) {
        Integer num2;
        if (num == null || (num2 = transitionTypeOppositeMap.get(num)) == null) {
            return -1;
        }
        return num2;
    }

    public static Map<Integer, Integer> getTransitionTypeOppositeMap() {
        return transitionTypeOppositeMap;
    }

    public static void setActivityTypeOppositeMap(Map<String, Integer> map) {
        activityTypeOppositeMap = map;
    }

    public static void setTransitionTypeOppositeMap(Map<Integer, Integer> map) {
        transitionTypeOppositeMap = map;
    }
}
