package com.newrelic.agent.android.agentdata.builder;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.mobile.fbs.ApplicationInfo;
import com.newrelic.mobile.fbs.BoolSessionAttribute;
import com.newrelic.mobile.fbs.DoubleSessionAttribute;
import com.newrelic.mobile.fbs.HexAgentData;
import com.newrelic.mobile.fbs.HexAgentDataBundle;
import com.newrelic.mobile.fbs.LongSessionAttribute;
import com.newrelic.mobile.fbs.StringSessionAttribute;
import com.newrelic.mobile.fbs.hex.Frame;
import com.newrelic.mobile.fbs.hex.HandledException;
import com.newrelic.mobile.fbs.hex.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AgentDataBuilder {
    public static Map<String, Object> attributesMapFromAgentData(HexAgentData hexAgentData) {
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < hexAgentData.stringAttributesLength(); i11++) {
            StringSessionAttribute stringAttributes = hexAgentData.stringAttributes(i11);
            hashMap.put(stringAttributes.name(), stringAttributes.value());
        }
        for (int i12 = 0; i12 < hexAgentData.longAttributesLength(); i12++) {
            LongSessionAttribute longAttributes = hexAgentData.longAttributes(i12);
            hashMap.put(longAttributes.name(), Long.valueOf(longAttributes.value()));
        }
        for (int i13 = 0; i13 < hexAgentData.doubleAttributesLength(); i13++) {
            DoubleSessionAttribute doubleAttributes = hexAgentData.doubleAttributes(i13);
            hashMap.put(doubleAttributes.name(), Double.valueOf(doubleAttributes.value()));
        }
        for (int i14 = 0; i14 < hexAgentData.boolAttributesLength(); i14++) {
            BoolSessionAttribute boolAttributes = hexAgentData.boolAttributes(i14);
            hashMap.put(boolAttributes.name(), Boolean.valueOf(boolAttributes.value()));
        }
        for (int i15 = 0; i15 < hexAgentData.handledExceptionsLength(); i15++) {
            HandledException handledExceptions = hexAgentData.handledExceptions(i15);
            hashMap.put(HexAttribute.HEX_ATTR_TIMESTAMP_MS, Long.valueOf(handledExceptions.timestampMs()));
            hashMap.put(HexAttribute.HEX_ATTR_APP_UUID_HI, Long.valueOf(handledExceptions.appUuidHigh()));
            hashMap.put(HexAttribute.HEX_ATTR_APP_UUID_LO, Long.valueOf(handledExceptions.appUuidLow()));
            hashMap.put("name", handledExceptions.name());
            hashMap.put(HexAttribute.HEX_ATTR_CAUSE, handledExceptions.cause());
            hashMap.put("message", handledExceptions.message());
            for (int i16 = 0; i16 < handledExceptions.threadsLength(); i16++) {
                Thread currentThread = Thread.currentThread();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (int i17 = 0; i17 < handledExceptions.threads(i16).framesLength(); i17++) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("fileName", handledExceptions.threads(i16).frames(i17).fileName());
                    linkedHashMap2.put("lineNumber", Long.valueOf(handledExceptions.threads(i16).frames(i17).lineNumber()));
                    linkedHashMap2.put(HexAttribute.HEX_ATTR_CLASS_NAME, handledExceptions.threads(i16).frames(i17).className());
                    linkedHashMap2.put(HexAttribute.HEX_ATTR_METHOD_NAME, handledExceptions.threads(i16).frames(i17).methodName());
                    linkedHashMap.put("frame " + i17, linkedHashMap2);
                }
                linkedHashMap.put("crashed", Boolean.FALSE);
                linkedHashMap.put("state", currentThread.getState().toString());
                linkedHashMap.put("threadNumber", Long.valueOf(currentThread.getId()));
                linkedHashMap.put("threadId", currentThread.getName());
                linkedHashMap.put("priority", Integer.valueOf(currentThread.getPriority()));
                hashMap.put("thread " + i16, linkedHashMap);
            }
        }
        return hashMap;
    }

    public static void computeIfAbsent(String str, Map<String, Integer> map, FlatBufferBuilder flatBufferBuilder) {
        if (str != null && !map.containsValue(str)) {
            map.put(str, Integer.valueOf(flatBufferBuilder.createString((CharSequence) str)));
        }
    }

    public static FlatBufferBuilder startAndFinishAgentData(Map<String, Object> map, Set<Map<String, Object>> set) {
        String str;
        String str2;
        String str3;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Object obj;
        Iterator<Map<String, Object>> it;
        int i16;
        long j11;
        long j12;
        String str4;
        HashMap hashMap = new HashMap();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            computeIfAbsent((String) next.getKey(), hashMap, flatBufferBuilder);
            if (value instanceof String) {
                computeIfAbsent((String) value, hashMap, flatBufferBuilder);
            }
        }
        Iterator<Map<String, Object>> it2 = set.iterator();
        List<Map> list = null;
        while (true) {
            boolean hasNext = it2.hasNext();
            str = HexAttribute.HEX_ATTR_CAUSE;
            str2 = "message";
            str3 = "name";
            if (!hasNext) {
                break;
            }
            Map next2 = it2.next();
            computeIfAbsent((String) next2.get(str3), hashMap, flatBufferBuilder);
            computeIfAbsent((String) next2.get(str2), hashMap, flatBufferBuilder);
            computeIfAbsent((String) next2.get(str), hashMap, flatBufferBuilder);
            list = (List) next2.get("thread");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            for (Map map2 : list) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("fileName", Integer.valueOf(flatBufferBuilder.createString((CharSequence) "")));
                for (Map.Entry entry : map2.entrySet()) {
                    String str5 = (String) entry.getKey();
                    Object value2 = entry.getValue();
                    if (value2 instanceof String) {
                        hashMap2.put(str5, Integer.valueOf(flatBufferBuilder.createString((CharSequence) (String) value2)));
                    }
                }
                Frame.startFrame(flatBufferBuilder);
                if (hashMap2.get(HexAttribute.HEX_ATTR_CLASS_NAME) != null) {
                    Frame.addClassName(flatBufferBuilder, ((Integer) hashMap2.get(HexAttribute.HEX_ATTR_CLASS_NAME)).intValue());
                }
                if (hashMap2.get(HexAttribute.HEX_ATTR_METHOD_NAME) != null) {
                    Frame.addMethodName(flatBufferBuilder, ((Integer) hashMap2.get(HexAttribute.HEX_ATTR_METHOD_NAME)).intValue());
                }
                if (hashMap2.get("fileName") != null) {
                    Frame.addFileName(flatBufferBuilder, ((Integer) hashMap2.get("fileName")).intValue());
                }
                if (map2.get("lineNumber") != null) {
                    Frame.addLineNumber(flatBufferBuilder, (long) ((Integer) map2.get("lineNumber")).intValue());
                }
                arrayList.add(Integer.valueOf(Frame.endFrame(flatBufferBuilder)));
            }
        }
        arrayList2.add(Integer.valueOf(Thread.createThread(flatBufferBuilder, Thread.createFramesVector(flatBufferBuilder, toArray(arrayList)))));
        int createThreadsVector = HandledException.createThreadsVector(flatBufferBuilder, toArray(arrayList2));
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (Map.Entry next3 : map.entrySet()) {
            int intValue = ((Integer) hashMap.get((String) next3.getKey())).intValue();
            Object value3 = next3.getValue();
            if (value3 instanceof String) {
                hashSet.add(Integer.valueOf(StringSessionAttribute.createStringSessionAttribute(flatBufferBuilder, intValue, ((Integer) hashMap.get(value3)).intValue())));
            } else if ((value3 instanceof Double) || (value3 instanceof Float)) {
                hashSet2.add(Integer.valueOf(DoubleSessionAttribute.createDoubleSessionAttribute(flatBufferBuilder, intValue, ((Number) value3).doubleValue())));
            } else if (value3 instanceof Number) {
                hashSet3.add(Integer.valueOf(LongSessionAttribute.createLongSessionAttribute(flatBufferBuilder, intValue, ((Number) value3).longValue())));
            } else if (value3 instanceof Boolean) {
                hashSet4.add(Integer.valueOf(BoolSessionAttribute.createBoolSessionAttribute(flatBufferBuilder, intValue, ((Boolean) value3).booleanValue())));
            }
        }
        if (!hashSet.isEmpty()) {
            i11 = HexAgentData.createStringAttributesVector(flatBufferBuilder, toArray(hashSet));
        } else {
            i11 = -1;
        }
        if (!hashSet2.isEmpty()) {
            i12 = HexAgentData.createDoubleAttributesVector(flatBufferBuilder, toArray(hashSet2));
        } else {
            i12 = -1;
        }
        if (!hashSet3.isEmpty()) {
            i13 = HexAgentData.createLongAttributesVector(flatBufferBuilder, toArray(hashSet3));
        } else {
            i13 = -1;
        }
        if (!hashSet4.isEmpty()) {
            i14 = HexAgentData.createBoolAttributesVector(flatBufferBuilder, toArray(hashSet4));
        } else {
            i14 = -1;
        }
        HashSet hashSet5 = new HashSet();
        if (!set.isEmpty()) {
            Iterator<Map<String, Object>> it3 = set.iterator();
            while (it3.hasNext()) {
                Map next4 = it3.next();
                int stringIndexMapOffset = stringIndexMapOffset(hashMap, next4.get(str3));
                int stringIndexMapOffset2 = stringIndexMapOffset(hashMap, next4.get(str2));
                int stringIndexMapOffset3 = stringIndexMapOffset(hashMap, next4.get(str));
                HashMap hashMap3 = hashMap;
                if (next4.containsKey(HexAttribute.HEX_ATTR_TIMESTAMP_MS)) {
                    obj = next4.get(HexAttribute.HEX_ATTR_TIMESTAMP_MS);
                } else {
                    obj = Long.valueOf(System.currentTimeMillis());
                }
                String str6 = str;
                String str7 = str2;
                long longValue = ((Long) obj).longValue();
                try {
                    str4 = str3;
                    it = it3;
                    j11 = ((Long) next4.get(HexAttribute.HEX_ATTR_APP_UUID_HI)).longValue();
                    i16 = i13;
                    j12 = ((Long) next4.get(HexAttribute.HEX_ATTR_APP_UUID_LO)).longValue();
                } catch (ClassCastException unused) {
                    str4 = str3;
                    it = it3;
                    j11 = 0;
                    i16 = i13;
                    j12 = 0;
                }
                HandledException.startHandledException(flatBufferBuilder);
                HandledException.addAppUuidHigh(flatBufferBuilder, j11);
                HandledException.addAppUuidLow(flatBufferBuilder, j12);
                if (-1 != longValue) {
                    HandledException.addTimestampMs(flatBufferBuilder, longValue);
                }
                if (-1 != stringIndexMapOffset) {
                    HandledException.addName(flatBufferBuilder, stringIndexMapOffset);
                }
                if (-1 != stringIndexMapOffset2) {
                    HandledException.addMessage(flatBufferBuilder, stringIndexMapOffset2);
                }
                if (-1 != stringIndexMapOffset3) {
                    HandledException.addCause(flatBufferBuilder, stringIndexMapOffset3);
                }
                HandledException.addThreads(flatBufferBuilder, createThreadsVector);
                hashSet5.add(Integer.valueOf(HandledException.endHandledException(flatBufferBuilder)));
                it3 = it;
                str3 = str4;
                hashMap = hashMap3;
                str2 = str7;
                str = str6;
                i13 = i16;
            }
        }
        int i17 = i13;
        if (!hashSet5.isEmpty()) {
            i15 = HexAgentData.createHandledExceptionsVector(flatBufferBuilder, toArray(hashSet5));
        } else {
            i15 = -1;
        }
        ApplicationInfo.startApplicationInfo(flatBufferBuilder);
        ApplicationInfo.addPlatform(flatBufferBuilder, 0);
        int endApplicationInfo = ApplicationInfo.endApplicationInfo(flatBufferBuilder);
        HexAgentData.startHexAgentData(flatBufferBuilder);
        if (i11 != -1) {
            HexAgentData.addStringAttributes(flatBufferBuilder, i11);
        }
        if (i12 != -1) {
            HexAgentData.addDoubleAttributes(flatBufferBuilder, i12);
        }
        int i18 = i17;
        if (i18 != -1) {
            HexAgentData.addLongAttributes(flatBufferBuilder, i18);
        }
        if (i14 != -1) {
            HexAgentData.addBoolAttributes(flatBufferBuilder, i14);
        }
        if (i15 != -1) {
            HexAgentData.addHandledExceptions(flatBufferBuilder, i15);
        }
        HexAgentData.addApplicationInfo(flatBufferBuilder, endApplicationInfo);
        HashSet hashSet6 = new HashSet();
        hashSet6.add(Integer.valueOf(HexAgentData.endHexAgentData(flatBufferBuilder)));
        int createHexAgentDataVector = HexAgentDataBundle.createHexAgentDataVector(flatBufferBuilder, toArray(hashSet6));
        HexAgentDataBundle.startHexAgentDataBundle(flatBufferBuilder);
        HexAgentDataBundle.addHexAgentData(flatBufferBuilder, createHexAgentDataVector);
        flatBufferBuilder.finish(HexAgentDataBundle.endHexAgentDataBundle(flatBufferBuilder));
        return flatBufferBuilder;
    }

    private static int stringIndexMapOffset(Map<String, Integer> map, Object obj) {
        Integer num;
        Integer num2 = -1;
        if (!(obj == null || (num = map.get(obj)) == null)) {
            num2 = num;
        }
        return num2.intValue();
    }

    private static int[] toArray(Collection<Integer> collection) {
        int[] iArr = new int[collection.size()];
        int i11 = 0;
        for (Integer intValue : collection) {
            iArr[i11] = intValue.intValue();
            i11++;
        }
        return iArr;
    }

    public static String toJsonString(HexAgentDataBundle hexAgentDataBundle, int i11) {
        return new GsonBuilder().enableComplexMapKeySerialization().serializeNulls().setPrettyPrinting().create().toJson((Object) attributesMapFromAgentData(hexAgentDataBundle.hexAgentData(i11)));
    }
}
