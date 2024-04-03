package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b9\u0010:J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0017\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0017\u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\rJ1\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00012\b\u0010\u0015\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0018\u0010\rJ\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0019\u0010\bJ\u0006\u0010\u001a\u001a\u00020\nJ\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0006J\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 J\b\u0010#\u001a\u00020\"H\u0016J'\u0010)\u001a\u00028\u0002\"\u0004\b\u0002\u0010$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00020%H\bø\u0001\u0000¢\u0006\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`.8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R$\u00103\u001a\u0012\u0012\u0004\u0012\u00028\u000001j\b\u0012\u0004\u0012\u00028\u0000`28\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R$\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00068G@BX\u000e¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b6\u00108R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u00107R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u00107R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u00107R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u00107R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u00107R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u00107\u0002\u0007\n\u0005\b20\u0001¨\u0006;"}, d2 = {"Landroidx/compose/ui/text/caches/LruCache;", "K", "V", "", "key", "value", "", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "maxSize", "", "resize", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "trimToSize", "remove", "", "evicted", "oldValue", "newValue", "b", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "a", "c", "evictAll", "hitCount", "missCount", "createCount", "putCount", "evictionCount", "", "snapshot", "", "toString", "R", "Lkotlin/Function0;", "block", "synchronizedValue$ui_text_release", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "synchronizedValue", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "monitor", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "Ljava/util/HashMap;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "keySet", "Ljava/util/LinkedHashSet;", "<set-?>", "size", "I", "()I", "<init>", "(I)V", "ui-text_release"}, k = 1, mv = {1, 7, 1})
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    @NotNull
    private final LinkedHashSet<K> keySet;
    @NotNull
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;
    /* access modifiers changed from: private */
    @NotNull
    public final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    public LruCache(int i11) {
        boolean z11;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.maxSize = i11;
            this.map = new HashMap<>(0, 0.75f);
            this.keySet = new LinkedHashSet<>();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    private final int safeSizeOf(K k11, V v11) {
        boolean z11;
        int c11 = c(k11, v11);
        if (c11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return c11;
        }
        throw new IllegalStateException(("Negative size: " + k11 + SignatureVisitor.INSTANCEOF + v11).toString());
    }

    @Nullable
    public V a(K k11) {
        return null;
    }

    public void b(boolean z11, K k11, V v11, @Nullable V v12) {
    }

    public int c(K k11, V v11) {
        return 1;
    }

    public final int createCount() {
        int i11;
        synchronized (this.monitor) {
            i11 = this.createCount;
        }
        return i11;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i11;
        synchronized (this.monitor) {
            i11 = this.evictionCount;
        }
        return i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0 = a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r2 = r5.monitor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r5.createCount++;
        r3 = r5.map.put(r6, r0);
        r5.keySet.remove(r6);
        r5.keySet.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r3 == null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        r5.map.put(r6, r3);
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r5.size = size() + safeSizeOf(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        r3 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r1 == null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        b(false, r6, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        trimToSize(r5.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
        return r0;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r6) {
        /*
            r5 = this;
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r5.monitor
            monitor-enter(r0)
            java.util.HashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x006c }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x001d
            java.util.LinkedHashSet<K> r2 = r5.keySet     // Catch:{ all -> 0x006c }
            r2.remove(r6)     // Catch:{ all -> 0x006c }
            java.util.LinkedHashSet<K> r2 = r5.keySet     // Catch:{ all -> 0x006c }
            r2.add(r6)     // Catch:{ all -> 0x006c }
            int r6 = r5.hitCount     // Catch:{ all -> 0x006c }
            int r6 = r6 + 1
            r5.hitCount = r6     // Catch:{ all -> 0x006c }
            monitor-exit(r0)
            return r1
        L_0x001d:
            int r2 = r5.missCount     // Catch:{ all -> 0x006c }
            int r2 = r2 + 1
            r5.missCount = r2     // Catch:{ all -> 0x006c }
            monitor-exit(r0)
            java.lang.Object r0 = r5.a(r6)
            if (r0 != 0) goto L_0x002c
            r6 = 0
            return r6
        L_0x002c:
            androidx.compose.ui.text.platform.SynchronizedObject r2 = r5.monitor
            monitor-enter(r2)
            int r3 = r5.createCount     // Catch:{ all -> 0x0069 }
            int r3 = r3 + 1
            r5.createCount = r3     // Catch:{ all -> 0x0069 }
            java.util.HashMap<K, V> r3 = r5.map     // Catch:{ all -> 0x0069 }
            java.lang.Object r3 = r3.put(r6, r0)     // Catch:{ all -> 0x0069 }
            java.util.LinkedHashSet<K> r4 = r5.keySet     // Catch:{ all -> 0x0069 }
            r4.remove(r6)     // Catch:{ all -> 0x0069 }
            java.util.LinkedHashSet<K> r4 = r5.keySet     // Catch:{ all -> 0x0069 }
            r4.add(r6)     // Catch:{ all -> 0x0069 }
            if (r3 == 0) goto L_0x004e
            java.util.HashMap<K, V> r1 = r5.map     // Catch:{ all -> 0x0069 }
            r1.put(r6, r3)     // Catch:{ all -> 0x0069 }
            r1 = r3
            goto L_0x0059
        L_0x004e:
            int r3 = r5.size()     // Catch:{ all -> 0x0069 }
            int r4 = r5.safeSizeOf(r6, r0)     // Catch:{ all -> 0x0069 }
            int r3 = r3 + r4
            r5.size = r3     // Catch:{ all -> 0x0069 }
        L_0x0059:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0069 }
            monitor-exit(r2)
            if (r1 == 0) goto L_0x0063
            r2 = 0
            r5.b(r2, r6, r0, r1)
            return r1
        L_0x0063:
            int r6 = r5.maxSize
            r5.trimToSize(r6)
            return r0
        L_0x0069:
            r6 = move-exception
            monitor-exit(r2)
            throw r6
        L_0x006c:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.caches.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final int hitCount() {
        int i11;
        synchronized (this.monitor) {
            i11 = this.hitCount;
        }
        return i11;
    }

    public final int maxSize() {
        int i11;
        synchronized (this.monitor) {
            i11 = this.maxSize;
        }
        return i11;
    }

    public final int missCount() {
        int i11;
        synchronized (this.monitor) {
            i11 = this.missCount;
        }
        return i11;
    }

    @Nullable
    public final V put(K k11, V v11) {
        V put;
        if (k11 == null || v11 == null) {
            throw null;
        }
        synchronized (this.monitor) {
            this.putCount++;
            this.size = size() + safeSizeOf(k11, v11);
            put = this.map.put(k11, v11);
            if (put != null) {
                this.size = size() - safeSizeOf(k11, put);
            }
            if (this.keySet.contains(k11)) {
                this.keySet.remove(k11);
            }
            this.keySet.add(k11);
        }
        if (put != null) {
            b(false, k11, put, v11);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final int putCount() {
        int i11;
        synchronized (this.monitor) {
            i11 = this.putCount;
        }
        return i11;
    }

    @Nullable
    public final V remove(K k11) {
        V remove;
        k11.getClass();
        synchronized (this.monitor) {
            remove = this.map.remove(k11);
            this.keySet.remove(k11);
            if (remove != null) {
                this.size = size() - safeSizeOf(k11, remove);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (remove != null) {
            b(false, k11, remove, (V) null);
        }
        return remove;
    }

    public void resize(int i11) {
        boolean z11;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            synchronized (this.monitor) {
                this.maxSize = i11;
                Unit unit = Unit.INSTANCE;
            }
            trimToSize(i11);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    @JvmName(name = "size")
    public final int size() {
        int i11;
        synchronized (this.monitor) {
            i11 = this.size;
        }
        return i11;
    }

    @NotNull
    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this.monitor) {
            linkedHashMap = new LinkedHashMap();
            Iterator<K> it = this.keySet.iterator();
            while (it.hasNext()) {
                K next = it.next();
                V v11 = this.map.get(next);
                Intrinsics.checkNotNull(v11);
                linkedHashMap.put(next, v11);
            }
        }
        return linkedHashMap;
    }

    public final <R> R synchronizedValue$ui_text_release(@NotNull Function0<? extends R> function0) {
        R invoke;
        Intrinsics.checkNotNullParameter(function0, "block");
        synchronized (this.monitor) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    @NotNull
    public String toString() {
        int i11;
        String str;
        synchronized (this.monitor) {
            int i12 = this.hitCount;
            int i13 = this.missCount + i12;
            if (i13 != 0) {
                i11 = (i12 * 100) / i13;
            } else {
                i11 = 0;
            }
            str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + i11 + "%]";
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0090, code lost:
        throw new java.lang.IllegalStateException("map/keySet size inconsistency");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r8) {
        /*
            r7 = this;
        L_0x0000:
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r7.monitor
            monitor-enter(r0)
            int r1 = r7.size()     // Catch:{ all -> 0x0091 }
            if (r1 < 0) goto L_0x0089
            java.util.HashMap<K, V> r1 = r7.map     // Catch:{ all -> 0x0091 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x0017
            int r1 = r7.size()     // Catch:{ all -> 0x0091 }
            if (r1 != 0) goto L_0x0089
        L_0x0017:
            java.util.HashMap<K, V> r1 = r7.map     // Catch:{ all -> 0x0091 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0091 }
            java.util.LinkedHashSet<K> r2 = r7.keySet     // Catch:{ all -> 0x0091 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0091 }
            if (r1 != r2) goto L_0x0089
            int r1 = r7.size()     // Catch:{ all -> 0x0091 }
            r2 = 1
            r3 = 0
            if (r1 <= r8) goto L_0x0074
            java.util.HashMap<K, V> r1 = r7.map     // Catch:{ all -> 0x0091 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0091 }
            if (r1 != 0) goto L_0x0074
            java.util.LinkedHashSet<K> r1 = r7.keySet     // Catch:{ all -> 0x0091 }
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.first(r1)     // Catch:{ all -> 0x0091 }
            java.util.HashMap<K, V> r4 = r7.map     // Catch:{ all -> 0x0091 }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x0091 }
            if (r4 == 0) goto L_0x006c
            java.util.HashMap<K, V> r5 = r7.map     // Catch:{ all -> 0x0091 }
            java.util.Map r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r5)     // Catch:{ all -> 0x0091 }
            r5.remove(r1)     // Catch:{ all -> 0x0091 }
            java.util.LinkedHashSet<K> r5 = r7.keySet     // Catch:{ all -> 0x0091 }
            java.util.Collection r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(r5)     // Catch:{ all -> 0x0091 }
            r5.remove(r1)     // Catch:{ all -> 0x0091 }
            int r5 = r7.size()     // Catch:{ all -> 0x0091 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x0091 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0091 }
            int r6 = r7.safeSizeOf(r1, r4)     // Catch:{ all -> 0x0091 }
            int r5 = r5 - r6
            r7.size = r5     // Catch:{ all -> 0x0091 }
            int r5 = r7.evictionCount     // Catch:{ all -> 0x0091 }
            int r5 = r5 + r2
            r7.evictionCount = r5     // Catch:{ all -> 0x0091 }
            goto L_0x0076
        L_0x006c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = "inconsistent state"
            r8.<init>(r1)     // Catch:{ all -> 0x0091 }
            throw r8     // Catch:{ all -> 0x0091 }
        L_0x0074:
            r1 = r3
            r4 = r1
        L_0x0076:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0091 }
            monitor-exit(r0)
            if (r1 != 0) goto L_0x007e
            if (r4 != 0) goto L_0x007e
            return
        L_0x007e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            r7.b(r2, r1, r4, r3)
            goto L_0x0000
        L_0x0089:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = "map/keySet size inconsistency"
            r8.<init>(r1)     // Catch:{ all -> 0x0091 }
            throw r8     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.caches.LruCache.trimToSize(int):void");
    }
}
