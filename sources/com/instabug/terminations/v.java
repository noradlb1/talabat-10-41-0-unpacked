package com.instabug.terminations;

import android.content.Context;
import com.instabug.commons.caching.SessionCacheDirectory;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import com.instabug.library.tracking.FirstFGTimeProvider;
import com.instabug.terminations.cache.a;
import com.instabug.terminations.cache.b;
import com.instabug.terminations.cache.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class v implements a0 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Context f52663a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SessionCacheDirectory f52664b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final j0 f52665c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final FirstFGTimeProvider f52666d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final c f52667e;

    /* renamed from: f  reason: collision with root package name */
    private List f52668f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Long f52669g;

    public v(@Nullable Context context, @NotNull SessionCacheDirectory sessionCacheDirectory, @NotNull j0 j0Var, @NotNull FirstFGTimeProvider firstFGTimeProvider, @NotNull c cVar) {
        Intrinsics.checkNotNullParameter(sessionCacheDirectory, "crashesCacheDir");
        Intrinsics.checkNotNullParameter(j0Var, "validator");
        Intrinsics.checkNotNullParameter(firstFGTimeProvider, "firstFGProvider");
        Intrinsics.checkNotNullParameter(cVar, "cachingManager");
        this.f52663a = context;
        this.f52664b = sessionCacheDirectory;
        this.f52665c = j0Var;
        this.f52666d = firstFGTimeProvider;
        this.f52667e = cVar;
    }

    private final File c(File file) {
        StateSnapshotCaptor.Companion companion = StateSnapshotCaptor.Companion;
        File snapshotFile = companion.getSnapshotFile(file);
        if (!snapshotFile.exists()) {
            snapshotFile = null;
        }
        if (snapshotFile != null) {
            return snapshotFile;
        }
        File oldSnapshotFile = companion.getOldSnapshotFile(file);
        if (oldSnapshotFile.exists()) {
            return oldSnapshotFile;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.instabug.terminations.x d(java.io.File r4) {
        /*
            r3 = this;
            java.io.File r4 = r3.e(r4)
            r0 = 0
            if (r4 != 0) goto L_0x0008
            goto L_0x0043
        L_0x0008:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x002e }
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ all -> 0x002e }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x002e }
            r2.<init>(r4)     // Catch:{ all -> 0x002e }
            r1.<init>(r2)     // Catch:{ all -> 0x002e }
            java.lang.Object r4 = r1.readObject()     // Catch:{ all -> 0x0027 }
            boolean r2 = r4 instanceof com.instabug.terminations.x     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x001d
            r4 = r0
        L_0x001d:
            com.instabug.terminations.x r4 = (com.instabug.terminations.x) r4     // Catch:{ all -> 0x0027 }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ all -> 0x002e }
            java.lang.Object r4 = kotlin.Result.m6329constructorimpl(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0039
        L_0x0027:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x002e }
            throw r2     // Catch:{ all -> 0x002e }
        L_0x002e:
            r4 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m6329constructorimpl(r4)
        L_0x0039:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r4)
            if (r1 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r0 = r4
        L_0x0041:
            com.instabug.terminations.x r0 = (com.instabug.terminations.x) r0
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.v.d(java.io.File):com.instabug.terminations.x");
    }

    private final File e(File file) {
        a aVar = b.f52598b;
        File g11 = aVar.g(file);
        if (!g11.exists()) {
            g11 = null;
        }
        if (g11 == null) {
            return null;
        }
        File f11 = aVar.f(g11);
        if (!f11.exists()) {
            f11 = null;
        }
        if (f11 != null) {
            return f11;
        }
        File e11 = aVar.e(g11);
        if (e11.exists()) {
            return e11;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.instabug.terminations.model.b f(java.io.File r12) {
        /*
            r11 = this;
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x007b }
            com.instabug.terminations.cache.a r1 = com.instabug.terminations.cache.b.f52598b     // Catch:{ all -> 0x007b }
            java.io.File r1 = r1.h(r12)     // Catch:{ all -> 0x007b }
            if (r1 != 0) goto L_0x000d
            r1 = r0
            goto L_0x0045
        L_0x000d:
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0031 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0031 }
            r3.<init>(r1)     // Catch:{ all -> 0x0031 }
            r2.<init>(r3)     // Catch:{ all -> 0x0031 }
            java.lang.Object r1 = r2.readObject()     // Catch:{ all -> 0x002a }
            boolean r3 = r1 instanceof com.instabug.terminations.x     // Catch:{ all -> 0x002a }
            if (r3 != 0) goto L_0x0020
            r1 = r0
        L_0x0020:
            com.instabug.terminations.x r1 = (com.instabug.terminations.x) r1     // Catch:{ all -> 0x002a }
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x0031 }
            java.lang.Object r1 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x0031 }
            goto L_0x003c
        L_0x002a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002c }
        L_0x002c:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ all -> 0x0031 }
            throw r3     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x007b }
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)     // Catch:{ all -> 0x007b }
            java.lang.Object r1 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x007b }
        L_0x003c:
            boolean r2 = kotlin.Result.m6335isFailureimpl(r1)     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x0043
            r1 = r0
        L_0x0043:
            com.instabug.terminations.x r1 = (com.instabug.terminations.x) r1     // Catch:{ all -> 0x007b }
        L_0x0045:
            if (r1 != 0) goto L_0x0048
            return r0
        L_0x0048:
            long r4 = r1.c()     // Catch:{ all -> 0x007b }
            com.instabug.library.model.State r7 = r11.b(r12)     // Catch:{ all -> 0x007b }
            com.instabug.terminations.model.a r2 = com.instabug.terminations.model.a.f52632a     // Catch:{ all -> 0x007b }
            android.content.Context r3 = r11.f52663a     // Catch:{ all -> 0x007b }
            java.lang.String r6 = r12.getName()     // Catch:{ all -> 0x007b }
            java.lang.String r1 = "sessionDirectory.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch:{ all -> 0x007b }
            r8 = 0
            r9 = 16
            r10 = 0
            com.instabug.terminations.model.b r1 = com.instabug.terminations.model.a.a(r2, r3, r4, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x007b }
            android.content.Context r2 = r11.f52663a     // Catch:{ all -> 0x007b }
            if (r2 != 0) goto L_0x006a
            goto L_0x006f
        L_0x006a:
            com.instabug.terminations.cache.c r3 = r11.f52667e     // Catch:{ all -> 0x007b }
            r3.b(r2, r1)     // Catch:{ all -> 0x007b }
        L_0x006f:
            com.instabug.terminations.cache.a r2 = com.instabug.terminations.cache.b.f52598b     // Catch:{ all -> 0x007b }
            java.lang.String r3 = "-mig"
            r2.c(r12, r3)     // Catch:{ all -> 0x007b }
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x007b }
            goto L_0x0086
        L_0x007b:
            r12 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r12)
        L_0x0086:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r12)
            if (r1 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r0 = r12
        L_0x008e:
            com.instabug.terminations.model.b r0 = (com.instabug.terminations.model.b) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.v.f(java.io.File):com.instabug.terminations.model.b");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A[Catch:{ all -> 0x010c }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0104 A[Catch:{ all -> 0x010c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.io.File r10) {
        /*
            r9 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x010c }
            com.instabug.terminations.x r0 = r9.d(r10)     // Catch:{ all -> 0x010c }
            r1 = 0
            if (r0 != 0) goto L_0x000b
            goto L_0x00d9
        L_0x000b:
            java.util.List r2 = r9.a((java.io.File) r10)     // Catch:{ all -> 0x010c }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x010c }
            r3 = 1
            r2 = r2 ^ r3
            r4 = 0
            if (r2 != 0) goto L_0x0021
            boolean r2 = r0.b()     // Catch:{ all -> 0x010c }
            if (r2 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r2 = r4
            goto L_0x0022
        L_0x0021:
            r2 = r3
        L_0x0022:
            java.util.List r5 = r0.a()     // Catch:{ all -> 0x010c }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x010c }
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x010c }
            if (r6 == 0) goto L_0x0104
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x010c }
        L_0x0034:
            boolean r7 = r5.hasNext()     // Catch:{ all -> 0x010c }
            if (r7 == 0) goto L_0x0057
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x010c }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x010c }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x010c }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x010c }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x010c }
            if (r6 != 0) goto L_0x0051
            if (r7 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r6 = r4
            goto L_0x0052
        L_0x0051:
            r6 = r3
        L_0x0052:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x010c }
            goto L_0x0034
        L_0x0057:
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x010c }
            boolean r5 = r6.booleanValue()     // Catch:{ all -> 0x010c }
            boolean r6 = r0.d()     // Catch:{ all -> 0x010c }
            if (r6 != 0) goto L_0x0066
            if (r5 != 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r3 = r4
        L_0x0067:
            java.lang.String r4 = " for session "
            java.lang.String r5 = "Trm Migrator-> Snapshot "
            java.lang.String r6 = "-mig"
            if (r2 != 0) goto L_0x00dd
            if (r3 == 0) goto L_0x0072
            goto L_0x00dd
        L_0x0072:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010c }
            r2.<init>()     // Catch:{ all -> 0x010c }
            r2.append(r5)     // Catch:{ all -> 0x010c }
            r2.append(r0)     // Catch:{ all -> 0x010c }
            r2.append(r4)     // Catch:{ all -> 0x010c }
            java.lang.String r3 = r10.getName()     // Catch:{ all -> 0x010c }
            r2.append(r3)     // Catch:{ all -> 0x010c }
            java.lang.String r3 = " is eligible for validation"
            r2.append(r3)     // Catch:{ all -> 0x010c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x010c }
            com.instabug.commons.logging.a.b(r2)     // Catch:{ all -> 0x010c }
            java.lang.Long r2 = r9.f52669g     // Catch:{ all -> 0x010c }
            if (r2 != 0) goto L_0x0098
            goto L_0x00d0
        L_0x0098:
            long r2 = r2.longValue()     // Catch:{ all -> 0x010c }
            com.instabug.terminations.j0 r4 = r9.f52665c     // Catch:{ all -> 0x010c }
            long r7 = r0.c()     // Catch:{ all -> 0x010c }
            boolean r0 = r4.a(r2, r7)     // Catch:{ all -> 0x010c }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x010c }
            boolean r2 = r0.booleanValue()     // Catch:{ all -> 0x010c }
            if (r2 == 0) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r0 = r1
        L_0x00b2:
            if (r0 != 0) goto L_0x00b5
            goto L_0x00d0
        L_0x00b5:
            r0.booleanValue()     // Catch:{ all -> 0x010c }
            com.instabug.terminations.cache.a r0 = com.instabug.terminations.cache.b.f52598b     // Catch:{ all -> 0x010c }
            java.lang.String r1 = "-vld"
            r0.c(r10, r1)     // Catch:{ all -> 0x010c }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x010c }
            java.lang.String r0 = "Trm Migrator-> Validated session "
            java.lang.String r1 = r10.getName()     // Catch:{ all -> 0x010c }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)     // Catch:{ all -> 0x010c }
            com.instabug.commons.logging.a.b(r0)     // Catch:{ all -> 0x010c }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x010c }
        L_0x00d0:
            if (r1 != 0) goto L_0x00d7
            com.instabug.terminations.cache.a r0 = com.instabug.terminations.cache.b.f52598b     // Catch:{ all -> 0x010c }
            r0.c(r10, r6)     // Catch:{ all -> 0x010c }
        L_0x00d7:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x010c }
        L_0x00d9:
            kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x010c }
            goto L_0x0116
        L_0x00dd:
            com.instabug.terminations.cache.a r1 = com.instabug.terminations.cache.b.f52598b     // Catch:{ all -> 0x010c }
            r1.c(r10, r6)     // Catch:{ all -> 0x010c }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x010c }
            r1.<init>()     // Catch:{ all -> 0x010c }
            r1.append(r5)     // Catch:{ all -> 0x010c }
            r1.append(r0)     // Catch:{ all -> 0x010c }
            r1.append(r4)     // Catch:{ all -> 0x010c }
            java.lang.String r10 = r10.getName()     // Catch:{ all -> 0x010c }
            r1.append(r10)     // Catch:{ all -> 0x010c }
            java.lang.String r10 = " is not eligible for validation"
            r1.append(r10)     // Catch:{ all -> 0x010c }
            java.lang.String r10 = r1.toString()     // Catch:{ all -> 0x010c }
            com.instabug.commons.logging.a.b(r10)     // Catch:{ all -> 0x010c }
            return
        L_0x0104:
            java.lang.UnsupportedOperationException r10 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x010c }
            java.lang.String r0 = "Empty collection can't be reduced."
            r10.<init>(r0)     // Catch:{ all -> 0x010c }
            throw r10     // Catch:{ all -> 0x010c }
        L_0x010c:
            r10 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            kotlin.Result.m6329constructorimpl(r10)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.v.g(java.io.File):void");
    }

    @NotNull
    public m invoke() {
        this.f52668f = this.f52664b.getOldSessionsDirectories();
        this.f52669g = this.f52666d.getFirstFGTime();
        List list = this.f52668f;
        l lVar = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldSessionsDirectories");
            list = null;
        }
        l a11 = a(SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.mapNotNull(SequencesKt___SequencesKt.onEach(CollectionsKt___CollectionsKt.asSequence(list), new t(this)), new u(this))));
        Long l11 = this.f52669g;
        if (l11 != null) {
            l11.longValue();
            lVar = a11;
        }
        if (lVar == null) {
            return k.f52629a;
        }
        return lVar;
    }

    private final List a(File file) {
        String[] list;
        File file2 = new File(file.getAbsolutePath() + File.separator + "ndk");
        List list2 = null;
        if (!file2.exists()) {
            file2 = null;
        }
        if (!(file2 == null || (list = file2.list()) == null)) {
            list2 = ArraysKt___ArraysKt.toList((T[]) list);
        }
        return list2 == null ? CollectionsKt__CollectionsKt.emptyList() : list2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.instabug.library.model.State b(java.io.File r4) {
        /*
            r3 = this;
            java.io.File r4 = r3.c(r4)
            r0 = 0
            if (r4 != 0) goto L_0x0008
            goto L_0x0043
        L_0x0008:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x002e }
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ all -> 0x002e }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x002e }
            r2.<init>(r4)     // Catch:{ all -> 0x002e }
            r1.<init>(r2)     // Catch:{ all -> 0x002e }
            java.lang.Object r4 = r1.readObject()     // Catch:{ all -> 0x0027 }
            boolean r2 = r4 instanceof com.instabug.library.model.State     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x001d
            r4 = r0
        L_0x001d:
            com.instabug.library.model.State r4 = (com.instabug.library.model.State) r4     // Catch:{ all -> 0x0027 }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ all -> 0x002e }
            java.lang.Object r4 = kotlin.Result.m6329constructorimpl(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0039
        L_0x0027:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x002e }
            throw r2     // Catch:{ all -> 0x002e }
        L_0x002e:
            r4 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m6329constructorimpl(r4)
        L_0x0039:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r4)
            if (r1 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r0 = r4
        L_0x0041:
            com.instabug.library.model.State r0 = (com.instabug.library.model.State) r0
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.v.b(java.io.File):com.instabug.library.model.State");
    }

    private final l a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String d11 = ((com.instabug.terminations.model.b) it.next()).d();
            if (d11 != null) {
                arrayList.add(d11);
            }
        }
        List<File> list2 = this.f52668f;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldSessionsDirectories");
            list2 = null;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        for (File name2 : list2) {
            arrayList2.add(name2.getName());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object next : arrayList2) {
            if (!arrayList.contains((String) next)) {
                arrayList3.add(next);
            }
        }
        return new l(list, arrayList3);
    }
}
