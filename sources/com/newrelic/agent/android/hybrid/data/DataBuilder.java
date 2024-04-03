package com.newrelic.agent.android.hybrid.data;

import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.mobile.fbs.ApplicationInfo;
import com.newrelic.mobile.fbs.BoolSessionAttribute;
import com.newrelic.mobile.fbs.DoubleSessionAttribute;
import com.newrelic.mobile.fbs.HexAgentData;
import com.newrelic.mobile.fbs.HexAgentDataBundle;
import com.newrelic.mobile.fbs.LongSessionAttribute;
import com.newrelic.mobile.fbs.StringSessionAttribute;
import com.newrelic.mobile.fbs.jserror.Frame;
import com.newrelic.mobile.fbs.jserror.JsError;
import com.newrelic.mobile.fbs.jserror.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataBuilder {
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
        for (int i15 = 0; i15 < hexAgentData.jsErrorsLength(); i15++) {
            JsError jsErrors = hexAgentData.jsErrors(i15);
            hashMap.put("name", jsErrors.name());
            hashMap.put("message", jsErrors.message());
            hashMap.put("fatal", Boolean.valueOf(jsErrors.fatal()));
            hashMap.put(HexAttribute.HEX_ATTR_JSERROR_BUILDID, jsErrors.buildId());
            hashMap.put(HexAttribute.HEX_ATTR_JSERROR_BUNDLEID, jsErrors.bundleId());
            Thread currentThread = Thread.currentThread();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i16 = 0; i16 < jsErrors.thread().framesLength(); i16++) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("fileName", jsErrors.thread().frames(i16).fileName());
                linkedHashMap2.put("lineNumber", Integer.valueOf(jsErrors.thread().frames(i16).lineNumber()));
                linkedHashMap2.put("method", jsErrors.thread().frames(i16).method());
                linkedHashMap2.put(HexAttribute.HEX_ATTR_JSERROR_COLUMN, Integer.valueOf(jsErrors.thread().frames(i16).column()));
                linkedHashMap.put("frame " + i16, linkedHashMap2);
            }
            linkedHashMap.put("crashed", Boolean.FALSE);
            linkedHashMap.put("state", currentThread.getState().toString());
            linkedHashMap.put("threadNumber", Long.valueOf(currentThread.getId()));
            linkedHashMap.put("threadId", currentThread.getName());
            linkedHashMap.put("priority", Integer.valueOf(currentThread.getPriority()));
            hashMap.put("thread 0", linkedHashMap);
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
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        HashMap hashMap = new HashMap();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            computeIfAbsent((String) next.getKey(), hashMap, flatBufferBuilder);
            if (value instanceof String) {
                computeIfAbsent((String) value, hashMap, flatBufferBuilder);
            }
        }
        Iterator<Map<String, Object>> it = set.iterator();
        List<Map> list = null;
        while (true) {
            str = "message";
            if (!it.hasNext()) {
                break;
            }
            Map next2 = it.next();
            computeIfAbsent((String) next2.get("name"), hashMap, flatBufferBuilder);
            computeIfAbsent((String) next2.get(str), hashMap, flatBufferBuilder);
            list = (List) next2.get("thread");
        }
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        if (list != null) {
            for (Map map2 : list) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("fileName", Integer.valueOf(flatBufferBuilder.createString((CharSequence) "")));
                for (Map.Entry entry : map2.entrySet()) {
                    String str2 = (String) entry.getKey();
                    Object value2 = entry.getValue();
                    if (value2 instanceof String) {
                        hashMap2.put(str2, Integer.valueOf(flatBufferBuilder.createString((CharSequence) (String) value2)));
                    }
                }
                Frame.startFrame(flatBufferBuilder);
                if (hashMap2.get("method") != null) {
                    Frame.addMethod(flatBufferBuilder, ((Integer) hashMap2.get("method")).intValue());
                }
                if (hashMap2.get("fileName") != null) {
                    Frame.addFileName(flatBufferBuilder, ((Integer) hashMap2.get("fileName")).intValue());
                }
                if (map2.get("lineNumber") != null) {
                    Frame.addLineNumber(flatBufferBuilder, ((Integer) map2.get("lineNumber")).intValue());
                }
                if (map2.get(HexAttribute.HEX_ATTR_JSERROR_COLUMN) != null) {
                    Frame.addColumn(flatBufferBuilder, ((Integer) map2.get(HexAttribute.HEX_ATTR_JSERROR_COLUMN)).intValue());
                }
                arrayList.add(Integer.valueOf(Frame.endFrame(flatBufferBuilder)));
            }
        }
        int createThread = Thread.createThread(flatBufferBuilder, Thread.createFramesVector(flatBufferBuilder, toArray(arrayList)));
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
            for (Map next4 : set) {
                int stringIndexMapOffset = stringIndexMapOffset(hashMap, next4.get("name"));
                int stringIndexMapOffset2 = stringIndexMapOffset(hashMap, next4.get(str));
                boolean booleanValue = ((Boolean) next4.get("fatal")).booleanValue();
                int stringIndexMapOffset3 = stringIndexMapOffset(hashMap, next4.get(HexAttribute.HEX_ATTR_JSERROR_BUILDID));
                String str3 = str;
                int stringIndexMapOffset4 = stringIndexMapOffset(hashMap, next4.get(HexAttribute.HEX_ATTR_JSERROR_BUNDLEID));
                JsError.startJsError(flatBufferBuilder);
                JsError.addFatal(flatBufferBuilder, booleanValue);
                if (-1 != stringIndexMapOffset) {
                    JsError.addName(flatBufferBuilder, stringIndexMapOffset);
                }
                if (-1 != stringIndexMapOffset2) {
                    JsError.addMessage(flatBufferBuilder, stringIndexMapOffset2);
                }
                if (-1 != stringIndexMapOffset3) {
                    JsError.addBuildId(flatBufferBuilder, stringIndexMapOffset3);
                }
                if (-1 != stringIndexMapOffset4) {
                    JsError.addBundleId(flatBufferBuilder, stringIndexMapOffset4);
                }
                JsError.addThread(flatBufferBuilder, createThread);
                hashSet5.add(Integer.valueOf(JsError.endJsError(flatBufferBuilder)));
                str = str3;
            }
        }
        if (!hashSet5.isEmpty()) {
            i15 = HexAgentData.createJsErrorsVector(flatBufferBuilder, toArray(hashSet5));
        } else {
            i15 = -1;
        }
        ApplicationInfo.startApplicationInfo(flatBufferBuilder);
        ApplicationInfo.addPlatform(flatBufferBuilder, 0);
        ApplicationInfo.addFramework(flatBufferBuilder, 1);
        int endApplicationInfo = ApplicationInfo.endApplicationInfo(flatBufferBuilder);
        HexAgentData.startHexAgentData(flatBufferBuilder);
        if (i11 != -1) {
            HexAgentData.addStringAttributes(flatBufferBuilder, i11);
        }
        if (i12 != -1) {
            HexAgentData.addDoubleAttributes(flatBufferBuilder, i12);
        }
        if (i13 != -1) {
            HexAgentData.addLongAttributes(flatBufferBuilder, i13);
        }
        if (i14 != -1) {
            HexAgentData.addBoolAttributes(flatBufferBuilder, i14);
        }
        if (i15 != -1) {
            HexAgentData.addJsErrors(flatBufferBuilder, i15);
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
