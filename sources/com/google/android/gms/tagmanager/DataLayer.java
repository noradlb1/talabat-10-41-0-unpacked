package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@VisibleForTesting
public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();
    private static final String[] zzafn = "gtm.lifetime".split("\\.");
    private static final Pattern zzafo = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<zzb, Integer> zzafp;
    private final Map<String, Object> zzafq;
    private final ReentrantLock zzafr;
    private final LinkedList<Map<String, Object>> zzafs;
    private final zzc zzaft;
    /* access modifiers changed from: private */
    public final CountDownLatch zzafu;

    public static final class zza {
        public final String mKey;
        public final Object mValue;

        public zza(String str, Object obj) {
            this.mKey = str;
            this.mValue = obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (!this.mKey.equals(zza.mKey) || !this.mValue.equals(zza.mValue)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.mKey.hashCode()), Integer.valueOf(this.mValue.hashCode())});
        }

        public final String toString() {
            String str = this.mKey;
            String obj = this.mValue.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(obj).length());
            sb2.append("Key: ");
            sb2.append(str);
            sb2.append(" value: ");
            sb2.append(obj);
            return sb2.toString();
        }
    }

    public interface zzb {
        void zzc(Map<String, Object> map);
    }

    public interface zzc {
        void zza(zzaq zzaq);

        void zza(List<zza> list, long j11);

        void zzas(String str);
    }

    @VisibleForTesting
    public DataLayer() {
        this(new zzao());
    }

    @VisibleForTesting
    public static List<Object> listOf(Object... objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object add : objArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    @VisibleForTesting
    public static Map<String, Object> mapOf(Object... objArr) {
        if (objArr.length % 2 == 0) {
            HashMap hashMap = new HashMap();
            int i11 = 0;
            while (i11 < objArr.length) {
                String str = objArr[i11];
                if (str instanceof String) {
                    hashMap.put(str, objArr[i11 + 1]);
                    i11 += 2;
                } else {
                    String valueOf = String.valueOf(objArr[i11]);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 21);
                    sb2.append("key is not a string: ");
                    sb2.append(valueOf);
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
            return hashMap;
        }
        throw new IllegalArgumentException("expected even number of key-value pairs");
    }

    private final void zza(Map<String, Object> map, String str, Collection<zza> collection) {
        for (Map.Entry next : map.entrySet()) {
            String str2 = str.length() == 0 ? "" : RealDiscoveryConfigurationRepository.VERSION_DELIMETER;
            String str3 = (String) next.getKey();
            StringBuilder sb2 = new StringBuilder(str.length() + str2.length() + String.valueOf(str3).length());
            sb2.append(str);
            sb2.append(str2);
            sb2.append(str3);
            String sb3 = sb2.toString();
            if (next.getValue() instanceof Map) {
                zza((Map) next.getValue(), sb3, collection);
            } else if (!sb3.equals("gtm.lifetime")) {
                collection.add(new zza(sb3, next.getValue()));
            }
        }
    }

    @VisibleForTesting
    private static Long zzar(String str) {
        long j11;
        String str2;
        String str3;
        String str4;
        String str5;
        Matcher matcher = zzafo.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str5 = "unknown _lifetime: ".concat(valueOf);
            } else {
                str5 = new String("unknown _lifetime: ");
            }
            zzdi.zzaw(str5);
            return null;
        }
        try {
            j11 = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                str4 = "illegal number in _lifetime value: ".concat(valueOf2);
            } else {
                str4 = new String("illegal number in _lifetime value: ");
            }
            zzdi.zzac(str4);
            j11 = 0;
        }
        if (j11 <= 0) {
            String valueOf3 = String.valueOf(str);
            if (valueOf3.length() != 0) {
                str3 = "non-positive _lifetime: ".concat(valueOf3);
            } else {
                str3 = new String("non-positive _lifetime: ");
            }
            zzdi.zzaw(str3);
            return null;
        }
        String group = matcher.group(2);
        if (group.length() == 0) {
            return Long.valueOf(j11);
        }
        char charAt = group.charAt(0);
        if (charAt == 'd') {
            return Long.valueOf(j11 * 1000 * 60 * 60 * 24);
        }
        if (charAt == 'h') {
            return Long.valueOf(j11 * 1000 * 60 * 60);
        }
        if (charAt == 'm') {
            return Long.valueOf(j11 * 1000 * 60);
        }
        if (charAt == 's') {
            return Long.valueOf(j11 * 1000);
        }
        String valueOf4 = String.valueOf(str);
        if (valueOf4.length() != 0) {
            str2 = "unknown units in _lifetime: ".concat(valueOf4);
        } else {
            str2 = new String("unknown units in _lifetime: ");
        }
        zzdi.zzac(str2);
        return null;
    }

    @VisibleForTesting
    private final void zzb(Map<String, Object> map, Map<String, Object> map2) {
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof List) {
                if (!(map2.get(next) instanceof List)) {
                    map2.put(next, new ArrayList());
                }
                zza((List<Object>) (List) obj, (List<Object>) (List) map2.get(next));
            } else if (obj instanceof Map) {
                if (!(map2.get(next) instanceof Map)) {
                    map2.put(next, new HashMap());
                }
                zzb((Map) obj, (Map) map2.get(next));
            } else {
                map2.put(next, obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zze(Map<String, Object> map) {
        Long l11;
        this.zzafr.lock();
        try {
            this.zzafs.offer(map);
            int i11 = 0;
            if (this.zzafr.getHoldCount() == 1) {
                int i12 = 0;
                while (true) {
                    Map poll = this.zzafs.poll();
                    if (poll == null) {
                        break;
                    }
                    synchronized (this.zzafq) {
                        for (String str : poll.keySet()) {
                            zzb(zzg(str, poll.get(str)), this.zzafq);
                        }
                    }
                    for (zzb zzc2 : this.zzafp.keySet()) {
                        zzc2.zzc(poll);
                    }
                    i12++;
                    if (i12 > 500) {
                        this.zzafs.clear();
                        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                    }
                }
            }
            String[] strArr = zzafn;
            int length = strArr.length;
            Object obj = map;
            while (true) {
                l11 = null;
                if (i11 >= length) {
                    break;
                }
                String str2 = strArr[i11];
                if (!(obj instanceof Map)) {
                    obj = null;
                    break;
                } else {
                    obj = ((Map) obj).get(str2);
                    i11++;
                }
            }
            if (obj != null) {
                l11 = zzar(obj.toString());
            }
            if (l11 != null) {
                ArrayList arrayList = new ArrayList();
                zza(map, "", arrayList);
                this.zzaft.zza(arrayList, l11.longValue());
            }
            this.zzafr.unlock();
        } catch (Throwable th2) {
            this.zzafr.unlock();
            throw th2;
        }
    }

    public static Map<String, Object> zzg(String str, Object obj) {
        HashMap hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i11 = 0;
        HashMap hashMap2 = hashMap;
        while (i11 < split.length - 1) {
            HashMap hashMap3 = new HashMap();
            hashMap2.put(split[i11], hashMap3);
            i11++;
            hashMap2 = hashMap3;
        }
        hashMap2.put(split[split.length - 1], obj);
        return hashMap;
    }

    public Object get(String str) {
        synchronized (this.zzafq) {
            Object obj = this.zzafq;
            for (String str2 : str.split("\\.")) {
                if (!(obj instanceof Map)) {
                    return null;
                }
                obj = ((Map) obj).get(str2);
                if (obj == null) {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String str, Object obj) {
        push(zzg(str, obj));
    }

    public void pushEvent(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("event", str);
        push(hashMap);
    }

    public String toString() {
        String sb2;
        synchronized (this.zzafq) {
            StringBuilder sb3 = new StringBuilder();
            for (Map.Entry next : this.zzafq.entrySet()) {
                sb3.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{next.getKey(), next.getValue()}));
            }
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public final void zzaq(String str) {
        push(str, (Object) null);
        this.zzaft.zzas(str);
    }

    public DataLayer(zzc zzc2) {
        this.zzaft = zzc2;
        this.zzafp = new ConcurrentHashMap<>();
        this.zzafq = new HashMap();
        this.zzafr = new ReentrantLock();
        this.zzafs = new LinkedList<>();
        this.zzafu = new CountDownLatch(1);
        zzc2.zza(new zzap(this));
    }

    public void push(Map<String, Object> map) {
        try {
            this.zzafu.await();
        } catch (InterruptedException unused) {
            zzdi.zzac("DataLayer.push: unexpected InterruptedException");
        }
        zze(map);
    }

    public final void zza(zzb zzb2) {
        this.zzafp.put(zzb2, 0);
    }

    @VisibleForTesting
    private final void zza(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add((Object) null);
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            Object obj = list.get(i11);
            if (obj instanceof List) {
                if (!(list2.get(i11) instanceof List)) {
                    list2.set(i11, new ArrayList());
                }
                zza((List<Object>) (List) obj, (List<Object>) (List) list2.get(i11));
            } else if (obj instanceof Map) {
                if (!(list2.get(i11) instanceof Map)) {
                    list2.set(i11, new HashMap());
                }
                zzb((Map) obj, (Map) list2.get(i11));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i11, obj);
            }
        }
    }
}
