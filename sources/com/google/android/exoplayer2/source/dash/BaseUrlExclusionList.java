package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import d8.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class BaseUrlExclusionList {
    private final Map<Integer, Long> excludedPriorities;
    private final Map<String, Long> excludedServiceLocations;
    private final Random random;
    private final Map<List<Pair<String, Integer>>, BaseUrl> selectionsTaken;

    public BaseUrlExclusionList() {
        this(new Random());
    }

    private static <T> void addExclusion(T t11, long j11, Map<T, Long> map) {
        if (map.containsKey(t11)) {
            j11 = Math.max(j11, ((Long) Util.castNonNull(map.get(t11))).longValue());
        }
        map.put(t11, Long.valueOf(j11));
    }

    private List<BaseUrl> applyExclusions(List<BaseUrl> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        removeExpiredExclusions(elapsedRealtime, this.excludedServiceLocations);
        removeExpiredExclusions(elapsedRealtime, this.excludedPriorities);
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            BaseUrl baseUrl = list.get(i11);
            if (!this.excludedServiceLocations.containsKey(baseUrl.serviceLocation) && !this.excludedPriorities.containsKey(Integer.valueOf(baseUrl.priority))) {
                arrayList.add(baseUrl);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static int compareBaseUrl(BaseUrl baseUrl, BaseUrl baseUrl2) {
        int compare = Integer.compare(baseUrl.priority, baseUrl2.priority);
        if (compare != 0) {
            return compare;
        }
        return baseUrl.serviceLocation.compareTo(baseUrl2.serviceLocation);
    }

    public static int getPriorityCount(List<BaseUrl> list) {
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < list.size(); i11++) {
            hashSet.add(Integer.valueOf(list.get(i11).priority));
        }
        return hashSet.size();
    }

    private static <T> void removeExpiredExclusions(long j11, Map<T, Long> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            if (((Long) next.getValue()).longValue() <= j11) {
                arrayList.add(next.getKey());
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            map.remove(arrayList.get(i11));
        }
    }

    private BaseUrl selectWeighted(List<BaseUrl> list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            i11 += list.get(i12).weight;
        }
        int nextInt = this.random.nextInt(i11);
        int i13 = 0;
        for (int i14 = 0; i14 < list.size(); i14++) {
            BaseUrl baseUrl = list.get(i14);
            i13 += baseUrl.weight;
            if (nextInt < i13) {
                return baseUrl;
            }
        }
        return (BaseUrl) Iterables.getLast(list);
    }

    public void exclude(BaseUrl baseUrl, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j11;
        addExclusion(baseUrl.serviceLocation, elapsedRealtime, this.excludedServiceLocations);
        int i11 = baseUrl.priority;
        if (i11 != Integer.MIN_VALUE) {
            addExclusion(Integer.valueOf(i11), elapsedRealtime, this.excludedPriorities);
        }
    }

    public int getPriorityCountAfterExclusion(List<BaseUrl> list) {
        HashSet hashSet = new HashSet();
        List<BaseUrl> applyExclusions = applyExclusions(list);
        for (int i11 = 0; i11 < applyExclusions.size(); i11++) {
            hashSet.add(Integer.valueOf(applyExclusions.get(i11).priority));
        }
        return hashSet.size();
    }

    public void reset() {
        this.excludedServiceLocations.clear();
        this.excludedPriorities.clear();
        this.selectionsTaken.clear();
    }

    @Nullable
    public BaseUrl selectBaseUrl(List<BaseUrl> list) {
        List<BaseUrl> applyExclusions = applyExclusions(list);
        if (applyExclusions.size() < 2) {
            return (BaseUrl) Iterables.getFirst(applyExclusions, null);
        }
        Collections.sort(applyExclusions, new a());
        ArrayList arrayList = new ArrayList();
        int i11 = applyExclusions.get(0).priority;
        int i12 = 0;
        while (true) {
            if (i12 >= applyExclusions.size()) {
                break;
            }
            BaseUrl baseUrl = applyExclusions.get(i12);
            if (i11 == baseUrl.priority) {
                arrayList.add(new Pair(baseUrl.serviceLocation, Integer.valueOf(baseUrl.weight)));
                i12++;
            } else if (arrayList.size() == 1) {
                return applyExclusions.get(0);
            }
        }
        BaseUrl baseUrl2 = this.selectionsTaken.get(arrayList);
        if (baseUrl2 != null) {
            return baseUrl2;
        }
        BaseUrl selectWeighted = selectWeighted(applyExclusions.subList(0, arrayList.size()));
        this.selectionsTaken.put(arrayList, selectWeighted);
        return selectWeighted;
    }

    @VisibleForTesting
    public BaseUrlExclusionList(Random random2) {
        this.selectionsTaken = new HashMap();
        this.random = random2;
        this.excludedServiceLocations = new HashMap();
        this.excludedPriorities = new HashMap();
    }
}
