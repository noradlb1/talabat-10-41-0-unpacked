package coil.memory;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import coil.memory.MemoryCache;
import coil.memory.RealMemoryCache;
import coil.util.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 (2\u00020\u0001:\u0003()*B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J(\u0010#\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0011H\u0016RX\u0010\u0005\u001a>\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u0006j\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n`\u000b8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcoil/memory/RealWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "logger", "Lcoil/util/Logger;", "(Lcoil/util/Logger;)V", "cache", "Ljava/util/HashMap;", "Lcoil/memory/MemoryCache$Key;", "Ljava/util/ArrayList;", "Lcoil/memory/RealWeakMemoryCache$WeakValue;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "getCache$coil_base_release$annotations", "()V", "getCache$coil_base_release", "()Ljava/util/HashMap;", "operationsSinceCleanUp", "", "getOperationsSinceCleanUp$coil_base_release$annotations", "getOperationsSinceCleanUp$coil_base_release", "()I", "setOperationsSinceCleanUp$coil_base_release", "(I)V", "cleanUp", "", "cleanUp$coil_base_release", "cleanUpIfNecessary", "clearMemory", "get", "Lcoil/memory/RealMemoryCache$Value;", "key", "remove", "", "bitmap", "Landroid/graphics/Bitmap;", "set", "isSampled", "size", "trimMemory", "level", "Companion", "StrongValue", "WeakValue", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private static final int CLEAN_UP_INTERVAL = 10;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "RealWeakMemoryCache";
    @NotNull
    private final HashMap<MemoryCache.Key, ArrayList<WeakValue>> cache = new HashMap<>();
    @Nullable
    private final Logger logger;
    private int operationsSinceCleanUp;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcoil/memory/RealWeakMemoryCache$Companion;", "", "()V", "CLEAN_UP_INTERVAL", "", "TAG", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"Lcoil/memory/RealWeakMemoryCache$StrongValue;", "Lcoil/memory/RealMemoryCache$Value;", "bitmap", "Landroid/graphics/Bitmap;", "isSampled", "", "(Landroid/graphics/Bitmap;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "()Z", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class StrongValue implements RealMemoryCache.Value {
        @NotNull
        private final Bitmap bitmap;
        private final boolean isSampled;

        public StrongValue(@NotNull Bitmap bitmap2, boolean z11) {
            Intrinsics.checkNotNullParameter(bitmap2, "bitmap");
            this.bitmap = bitmap2;
            this.isSampled = z11;
        }

        @NotNull
        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public boolean isSampled() {
            return this.isSampled;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcoil/memory/RealWeakMemoryCache$WeakValue;", "", "identityHashCode", "", "bitmap", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "isSampled", "", "size", "(ILjava/lang/ref/WeakReference;ZI)V", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getIdentityHashCode", "()I", "()Z", "getSize", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @VisibleForTesting
    public static final class WeakValue {
        @NotNull
        private final WeakReference<Bitmap> bitmap;
        private final int identityHashCode;
        private final boolean isSampled;
        private final int size;

        public WeakValue(int i11, @NotNull WeakReference<Bitmap> weakReference, boolean z11, int i12) {
            Intrinsics.checkNotNullParameter(weakReference, "bitmap");
            this.identityHashCode = i11;
            this.bitmap = weakReference;
            this.isSampled = z11;
            this.size = i12;
        }

        @NotNull
        public final WeakReference<Bitmap> getBitmap() {
            return this.bitmap;
        }

        public final int getIdentityHashCode() {
            return this.identityHashCode;
        }

        public final int getSize() {
            return this.size;
        }

        public final boolean isSampled() {
            return this.isSampled;
        }
    }

    public RealWeakMemoryCache(@Nullable Logger logger2) {
        this.logger = logger2;
    }

    private final void cleanUpIfNecessary() {
        int i11 = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i11 + 1;
        if (i11 >= 10) {
            cleanUp$coil_base_release();
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getCache$coil_base_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getOperationsSinceCleanUp$coil_base_release$annotations() {
    }

    @VisibleForTesting
    public final void cleanUp$coil_base_release() {
        boolean z11;
        Bitmap bitmap;
        this.operationsSinceCleanUp = 0;
        Iterator<ArrayList<WeakValue>> it = this.cache.values().iterator();
        while (it.hasNext()) {
            ArrayList<WeakValue> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            ArrayList arrayList = next;
            if (arrayList.size() <= 1) {
                WeakValue weakValue = (WeakValue) CollectionsKt___CollectionsKt.firstOrNull(arrayList);
                if (weakValue == null) {
                    bitmap = null;
                } else {
                    bitmap = weakValue.getBitmap().get();
                }
                if (bitmap == null) {
                    it.remove();
                }
            } else {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        int i13 = i11 + 1;
                        int i14 = i11 - i12;
                        if (((WeakValue) arrayList.get(i14)).getBitmap().get() == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            arrayList.remove(i14);
                            i12++;
                        }
                        if (i13 > size) {
                            break;
                        }
                        i11 = i13;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    public synchronized void clearMemory() {
        Logger logger2 = this.logger;
        if (logger2 != null) {
            if (logger2.getLevel() <= 2) {
                logger2.log(TAG, 2, "clearMemory", (Throwable) null);
            }
        }
        this.operationsSinceCleanUp = 0;
        this.cache.clear();
    }

    @Nullable
    public synchronized RealMemoryCache.Value get(@NotNull MemoryCache.Key key) {
        StrongValue strongValue;
        Intrinsics.checkNotNullParameter(key, "key");
        ArrayList arrayList = this.cache.get(key);
        StrongValue strongValue2 = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size() - 1;
        if (size >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                WeakValue weakValue = (WeakValue) arrayList.get(i11);
                Bitmap bitmap = weakValue.getBitmap().get();
                if (bitmap == null) {
                    strongValue = null;
                } else {
                    strongValue = new StrongValue(bitmap, weakValue.isSampled());
                }
                if (strongValue != null) {
                    strongValue2 = strongValue;
                    break;
                } else if (i12 > size) {
                    break;
                } else {
                    i11 = i12;
                }
            }
        }
        cleanUpIfNecessary();
        return strongValue2;
    }

    @NotNull
    public final HashMap<MemoryCache.Key, ArrayList<WeakValue>> getCache$coil_base_release() {
        return this.cache;
    }

    public final int getOperationsSinceCleanUp$coil_base_release() {
        return this.operationsSinceCleanUp;
    }

    public synchronized boolean remove(@NotNull MemoryCache.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.cache.remove(key) != null;
    }

    public synchronized void set(@NotNull MemoryCache.Key key, @NotNull Bitmap bitmap, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        HashMap<MemoryCache.Key, ArrayList<WeakValue>> hashMap = this.cache;
        ArrayList<WeakValue> arrayList = hashMap.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            hashMap.put(key, arrayList);
        }
        ArrayList arrayList2 = arrayList;
        int identityHashCode = System.identityHashCode(bitmap);
        WeakValue weakValue = new WeakValue(identityHashCode, new WeakReference(bitmap), z11, i11);
        int size = arrayList2.size() - 1;
        if (size >= 0) {
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                Object obj = arrayList2.get(i12);
                Intrinsics.checkNotNullExpressionValue(obj, "values[index]");
                WeakValue weakValue2 = (WeakValue) obj;
                if (i11 >= weakValue2.getSize()) {
                    if (weakValue2.getIdentityHashCode() == identityHashCode && weakValue2.getBitmap().get() == bitmap) {
                        arrayList2.set(i12, weakValue);
                    } else {
                        arrayList2.add(i12, weakValue);
                    }
                } else if (i13 > size) {
                    break;
                } else {
                    i12 = i13;
                }
            }
            cleanUpIfNecessary();
        }
        arrayList2.add(weakValue);
        cleanUpIfNecessary();
    }

    public final void setOperationsSinceCleanUp$coil_base_release(int i11) {
        this.operationsSinceCleanUp = i11;
    }

    public synchronized void trimMemory(int i11) {
        Logger logger2 = this.logger;
        if (logger2 != null) {
            if (logger2.getLevel() <= 2) {
                logger2.log(TAG, 2, Intrinsics.stringPlus("trimMemory, level=", Integer.valueOf(i11)), (Throwable) null);
            }
        }
        if (i11 >= 10 && i11 != 20) {
            cleanUp$coil_base_release();
        }
    }

    public synchronized boolean remove(@NotNull Bitmap bitmap) {
        boolean z11;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int identityHashCode = System.identityHashCode(bitmap);
        Collection<ArrayList<WeakValue>> values = getCache$coil_base_release().values();
        Intrinsics.checkNotNullExpressionValue(values, "cache.values");
        Iterator it = values.iterator();
        loop0:
        while (true) {
            z11 = false;
            if (!it.hasNext()) {
                break;
            }
            ArrayList arrayList = (ArrayList) it.next();
            int size = arrayList.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i11 = (z11 ? 1 : 0) + true;
                    if (((WeakValue) arrayList.get(z11)).getIdentityHashCode() == identityHashCode) {
                        arrayList.remove(z11);
                        z11 = true;
                        break loop0;
                    } else if (i11 > size) {
                        break;
                    } else {
                        z11 = i11;
                    }
                }
            }
        }
        cleanUpIfNecessary();
        return z11;
    }
}
