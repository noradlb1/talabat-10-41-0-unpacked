package com.google.firebase.database.connection;

import java.util.ArrayList;
import java.util.List;

public class ConnectionUtils {
    public static void hardAssert(boolean z11) {
        hardAssert(z11, "", new Object[0]);
    }

    public static Long longFromObject(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static String pathToString(List<String> list) {
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        for (String next : list) {
            if (!z11) {
                sb2.append("/");
            }
            sb2.append(next);
            z11 = false;
        }
        return sb2.toString();
    }

    public static List<String> stringToPath(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("/", -1);
        for (int i11 = 0; i11 < split.length; i11++) {
            if (!split[i11].isEmpty()) {
                arrayList.add(split[i11]);
            }
        }
        return arrayList;
    }

    public static void hardAssert(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new AssertionError("hardAssert failed: " + String.format(str, objArr));
        }
    }
}
