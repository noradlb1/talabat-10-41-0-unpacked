package com.instabug.commons.caching;

import androidx.annotation.WorkerThread;
import com.instabug.commons.logging.a;
import com.instabug.library.util.threading.PoolProvider;
import dc.b;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class h implements SessionCacheDirectory {
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final a f46290f = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Function0 f46291a;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final Function1 f46292b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f46293c = LazyKt__LazyJVMKt.lazy(new b(this));
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f46294d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Map f46295e = new LinkedHashMap();

    @JvmOverloads
    public h(@NotNull Function0 function0, @NotNull Function1 function1) {
        Intrinsics.checkNotNullParameter(function0, "ctxGetter");
        Intrinsics.checkNotNullParameter(function1, "attachmentsDirGetter");
        this.f46291a = function0;
        this.f46292b = function1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List c() {
        /*
            r3 = this;
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0034 }
            java.io.File r1 = r3.getFileDirectory()     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x000a
            goto L_0x0029
        L_0x000a:
            boolean r2 = r1.exists()     // Catch:{ all -> 0x0034 }
            r2 = r2 ^ 1
            if (r2 != 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r1 != 0) goto L_0x0017
            goto L_0x0029
        L_0x0017:
            dc.d r2 = new dc.d     // Catch:{ all -> 0x0034 }
            r2.<init>(r3)     // Catch:{ all -> 0x0034 }
            java.io.File[] r1 = r1.listFiles(r2)     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x0023
            goto L_0x0029
        L_0x0023:
            java.util.List r1 = kotlin.collections.ArraysKt___ArraysKt.toList((T[]) r1)     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x002b
        L_0x0029:
            r1 = r0
            goto L_0x002f
        L_0x002b:
            java.util.List r1 = r3.a((java.util.List) r1)     // Catch:{ all -> 0x0034 }
        L_0x002f:
            java.lang.Object r1 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x0034 }
            goto L_0x003f
        L_0x0034:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m6329constructorimpl(r1)
        L_0x003f:
            boolean r2 = kotlin.Result.m6335isFailureimpl(r1)
            if (r2 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r0 = r1
        L_0x0047:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.commons.caching.h.c():java.util.List");
    }

    public void addWatcher(int i11) {
        synchronized (this) {
            if (!this.f46295e.containsKey(Integer.valueOf(i11))) {
                this.f46295e.put(Integer.valueOf(i11), Boolean.FALSE);
                a.b("Watcher " + i11 + " added to crashes dir");
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @WorkerThread
    public void consentOnCleansing(int i11) {
        synchronized (this) {
            this.f46295e.put(Integer.valueOf(i11), Boolean.TRUE);
            a.b(Intrinsics.stringPlus("Considered consent of id -> ", Integer.valueOf(i11)));
            a();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public File getCurrentSessionDirectory() {
        File file;
        synchronized (this) {
            String str = this.f46294d;
            if (str != null) {
                File b11 = b();
                if (b11 != null) {
                    file = f46290f.a(b11, str);
                }
            }
            file = null;
        }
        return file;
    }

    @Nullable
    public File getFileDirectory() {
        File b11 = b();
        if (b11 == null) {
            return null;
        }
        return f46290f.a(b11);
    }

    @NotNull
    @WorkerThread
    public List getOldSessionsDirectories() {
        List c11;
        synchronized (this) {
            c11 = c();
            if (c11 == null) {
                c11 = CollectionsKt__CollectionsKt.emptyList();
            }
        }
        return c11;
    }

    @Nullable
    public Boolean queryWatcherConsent(int i11) {
        return (Boolean) this.f46295e.get(Integer.valueOf(i11));
    }

    @WorkerThread
    public void removeWatcher(int i11) {
        synchronized (this) {
            this.f46295e.remove(Integer.valueOf(i11));
            a.b("Watcher " + i11 + " removed from crashes dir");
            a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void setCurrentSessionId(@Nullable String str) {
        synchronized (this) {
            this.f46294d = str;
            if (str != null) {
                PoolProvider.postIOTask(new b(this, str));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void a(h hVar, String str) {
        Intrinsics.checkNotNullParameter(hVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$it");
        hVar.a(str);
    }

    private final File b() {
        return (File) this.f46293c.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[Catch:{ all -> 0x008d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[Catch:{ all -> 0x008d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r5 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x008d }
            java.util.Map r0 = r5.f46295e     // Catch:{ all -> 0x008d }
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x008d }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            goto L_0x002f
        L_0x000c:
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x008d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x008d }
        L_0x0014:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x002f
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x008d }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x008d }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x008d }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x008d }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x008d }
            r3 = 1
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x0014
            goto L_0x0030
        L_0x002f:
            r3 = r2
        L_0x0030:
            if (r3 == 0) goto L_0x0033
            return
        L_0x0033:
            java.lang.String r0 = "Cleansing crashes directory excluding "
            java.lang.String r1 = r5.f46294d     // Catch:{ all -> 0x008d }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)     // Catch:{ all -> 0x008d }
            com.instabug.commons.logging.a.b(r0)     // Catch:{ all -> 0x008d }
            java.io.File r0 = r5.getFileDirectory()     // Catch:{ all -> 0x008d }
            if (r0 != 0) goto L_0x0045
            goto L_0x0061
        L_0x0045:
            dc.c r1 = new dc.c     // Catch:{ all -> 0x008d }
            r1.<init>(r5)     // Catch:{ all -> 0x008d }
            java.io.File[] r0 = r0.listFiles(r1)     // Catch:{ all -> 0x008d }
            if (r0 != 0) goto L_0x0051
            goto L_0x0061
        L_0x0051:
            int r1 = r0.length     // Catch:{ all -> 0x008d }
        L_0x0052:
            if (r2 >= r1) goto L_0x0061
            r3 = r0[r2]     // Catch:{ all -> 0x008d }
            int r2 = r2 + 1
            java.lang.String r4 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x008d }
            boolean unused = kotlin.io.FilesKt__UtilsKt.deleteRecursively(r3)     // Catch:{ all -> 0x008d }
            goto L_0x0052
        L_0x0061:
            java.util.Map r0 = r5.f46295e     // Catch:{ all -> 0x008d }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x008d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x008d }
        L_0x006b:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0087
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x008d }
            java.lang.Number r1 = (java.lang.Number) r1     // Catch:{ all -> 0x008d }
            int r1 = r1.intValue()     // Catch:{ all -> 0x008d }
            java.util.Map r2 = r5.f46295e     // Catch:{ all -> 0x008d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x008d }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x008d }
            r2.put(r1, r3)     // Catch:{ all -> 0x008d }
            goto L_0x006b
        L_0x0087:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x008d }
            kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x008d }
            goto L_0x0097
        L_0x008d:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m6329constructorimpl(r0)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.commons.caching.h.a():void");
    }

    /* access modifiers changed from: private */
    public static final boolean b(h hVar, File file) {
        Intrinsics.checkNotNullParameter(hVar, "$this_runCatching");
        return !Intrinsics.areEqual((Object) file.getName(), (Object) hVar.f46294d);
    }

    /* access modifiers changed from: private */
    public static final boolean a(h hVar, File file) {
        Intrinsics.checkNotNullParameter(hVar, "$this_runCatching");
        return !Intrinsics.areEqual((Object) file.getName(), (Object) hVar.f46294d);
    }

    private final List a(List list) {
        List mutableList = SequencesKt___SequencesKt.toMutableList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.sortedWith(SequencesKt___SequencesKt.dropWhile(SequencesKt___SequencesKt.onEach(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(list), d.f46286a), e.f46287a), f.f46288a), new c()), g.f46289a));
        if (mutableList.size() <= 100) {
            return list;
        }
        int size = mutableList.size() - 100;
        int i11 = 0;
        while (i11 < size) {
            i11++;
            File file = (File) CollectionsKt__MutableCollectionsKt.removeLastOrNull(mutableList);
            if (file != null) {
                boolean unused = FilesKt__UtilsKt.deleteRecursively(file);
            }
        }
        return mutableList;
    }

    private final void a(String str) {
        a aVar;
        File a11;
        File b11 = b();
        if (b11 != null && (a11 = aVar.a(b11, str)) != null) {
            if ((a11.exists() ? a11 : null) == null) {
                a11.mkdirs();
                Unit unit = Unit.INSTANCE;
            }
            File a12 = (aVar = f46290f).a(a11, System.currentTimeMillis());
            if (a12 != null) {
                a12.createNewFile();
            }
        }
    }
}
