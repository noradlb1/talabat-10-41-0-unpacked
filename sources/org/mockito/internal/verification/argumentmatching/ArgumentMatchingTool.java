package org.mockito.internal.verification.argumentmatching;

import a40.a;
import a40.b;
import a40.c;
import a40.d;
import j$.util.Collection;
import j$.util.Map;
import j$.util.stream.Collectors;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.ContainsExtraTypeInfo;

public class ArgumentMatchingTool {
    private ArgumentMatchingTool() {
    }

    public static Set<String> getNotMatchingArgsWithSameName(List<ArgumentMatcher> list, Object[] objArr) {
        Object wanted;
        HashMap hashMap = new HashMap();
        for (ArgumentMatcher next : list) {
            if ((next instanceof ContainsExtraTypeInfo) && (wanted = ((ContainsExtraTypeInfo) next).getWanted()) != null) {
                Class<?> cls = wanted.getClass();
                ((Set) Map.EL.computeIfAbsent(hashMap, cls.getSimpleName(), new a())).add(cls.getCanonicalName());
            }
        }
        for (Object obj : objArr) {
            if (obj != null) {
                Class<?> cls2 = obj.getClass();
                ((Set) Map.EL.computeIfAbsent(hashMap, cls2.getSimpleName(), new b())).add(cls2.getCanonicalName());
            }
        }
        return (Set) Collection.EL.stream(hashMap.entrySet()).filter(new c()).map(new d()).collect(Collectors.toSet());
    }

    public static Integer[] getSuspiciouslyNotMatchingArgsIndexes(List<ArgumentMatcher> list, Object[] objArr) {
        if (list.size() != objArr.length) {
            return new Integer[0];
        }
        LinkedList linkedList = new LinkedList();
        int i11 = 0;
        for (ArgumentMatcher next : list) {
            if ((next instanceof ContainsExtraTypeInfo) && !safelyMatches(next, objArr[i11]) && toStringEquals(next, objArr[i11]) && !((ContainsExtraTypeInfo) next).typeMatches(objArr[i11])) {
                linkedList.add(Integer.valueOf(i11));
            }
            i11++;
        }
        return (Integer[]) linkedList.toArray(new Integer[0]);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Set lambda$getNotMatchingArgsWithSameName$0(String str) {
        return new HashSet();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Set lambda$getNotMatchingArgsWithSameName$1(String str) {
        return new HashSet();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getNotMatchingArgsWithSameName$2(Map.Entry entry) {
        return ((Set) entry.getValue()).size() > 1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$getNotMatchingArgsWithSameName$3(Map.Entry entry) {
        return (String) entry.getKey();
    }

    private static boolean safelyMatches(ArgumentMatcher argumentMatcher, Object obj) {
        try {
            return argumentMatcher.matches(obj);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean toStringEquals(ArgumentMatcher argumentMatcher, Object obj) {
        return argumentMatcher.toString().equals(String.valueOf(obj));
    }
}
