package com.instabug.terminations;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.instabug.commons.caching.SessionCacheDirectory;
import com.instabug.commons.d;
import com.instabug.commons.e;
import com.instabug.commons.f;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import com.instabug.library.model.State;
import com.instabug.library.tracking.FirstFGTimeProvider;
import com.instabug.terminations.cache.a;
import com.instabug.terminations.cache.b;
import com.instabug.terminations.cache.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(30)
public final class p implements a0 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Context f52641a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SessionCacheDirectory f52642b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final j0 f52643c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final FirstFGTimeProvider f52644d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final c f52645e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private File f52646f;

    /* renamed from: g  reason: collision with root package name */
    private List f52647g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Long f52648h;

    public p(@Nullable Context context, @NotNull SessionCacheDirectory sessionCacheDirectory, @NotNull j0 j0Var, @NotNull FirstFGTimeProvider firstFGTimeProvider, @NotNull c cVar) {
        Intrinsics.checkNotNullParameter(sessionCacheDirectory, "crashesCacheDir");
        Intrinsics.checkNotNullParameter(j0Var, "validator");
        Intrinsics.checkNotNullParameter(firstFGTimeProvider, "firstFGProvider");
        Intrinsics.checkNotNullParameter(cVar, "cachingManager");
        this.f52641a = context;
        this.f52642b = sessionCacheDirectory;
        this.f52643c = j0Var;
        this.f52644d = firstFGTimeProvider;
        this.f52645e = cVar;
    }

    private final File d(File file) {
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

    private final boolean e(File file) {
        List a11;
        boolean z11;
        r c11 = c(file);
        if (c11 == null || (a11 = c11.a()) == null) {
            return true;
        }
        Iterator it = a11.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                boolean booleanValue = ((Boolean) it.next()).booleanValue();
                if (((Boolean) next).booleanValue() || booleanValue) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                next = Boolean.valueOf(z11);
            }
            Boolean bool = (Boolean) next;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    /* access modifiers changed from: private */
    public final com.instabug.terminations.model.b f(File file) {
        Object obj;
        com.instabug.terminations.model.b bVar = null;
        try {
            Result.Companion companion = Result.Companion;
            a aVar = b.f52598b;
            File h11 = aVar.h(file);
            if (h11 == null) {
                File a11 = aVar.a(file);
                if (a11 != null) {
                    aVar.b(a11, "-bl");
                }
                return null;
            }
            String name2 = h11.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "validatedDetectionFile.name");
            long parseLong = Long.parseLong(StringsKt__StringsKt.removeSuffix(name2, (CharSequence) "-vld"));
            State a12 = a(file);
            com.instabug.commons.logging.a.b(Intrinsics.stringPlus("Trm Migrator-> Migrating ", h11.getAbsolutePath()));
            com.instabug.terminations.model.a aVar2 = com.instabug.terminations.model.a.f52632a;
            Context context = this.f52641a;
            String name3 = file.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "sessionDir.name");
            com.instabug.terminations.model.b a13 = com.instabug.terminations.model.a.a(aVar2, context, parseLong, name3, a12, (IncidentMetadata) null, 16, (Object) null);
            Context context2 = this.f52641a;
            if (context2 != null) {
                this.f52645e.b(context2, a13);
            }
            aVar.b(h11, "-vld");
            aVar.c(file, "-mig");
            obj = Result.m6329constructorimpl(a13);
            if (!Result.m6335isFailureimpl(obj)) {
                bVar = obj;
            }
            return bVar;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009f A[Catch:{ all -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0 A[Catch:{ all -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a3 A[Catch:{ all -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4 A[Catch:{ all -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cd A[Catch:{ all -> 0x00f8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Result g(java.io.File r14) {
        /*
            r13 = this;
            java.lang.String r0 = "-osd"
            java.lang.String r1 = "-fg"
            java.lang.String r2 = "name"
            java.lang.Long r3 = r13.f52648h
            r4 = 0
            if (r3 != 0) goto L_0x000d
            goto L_0x0107
        L_0x000d:
            long r5 = r3.longValue()
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x00f8 }
            com.instabug.terminations.cache.a r3 = com.instabug.terminations.cache.b.f52598b     // Catch:{ all -> 0x00f8 }
            java.io.File r7 = r3.c(r14)     // Catch:{ all -> 0x00f8 }
            if (r7 != 0) goto L_0x001d
            goto L_0x00f3
        L_0x001d:
            java.lang.String r8 = r7.getName()     // Catch:{ all -> 0x00f8 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)     // Catch:{ all -> 0x00f8 }
            r9 = 2
            r10 = 0
            boolean r8 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r1, (boolean) r10, (int) r9, (java.lang.Object) r4)     // Catch:{ all -> 0x00f8 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x00f8 }
            boolean r9 = r8.booleanValue()     // Catch:{ all -> 0x00f8 }
            if (r9 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r8 = r4
        L_0x0036:
            if (r8 != 0) goto L_0x003a
            r1 = r4
            goto L_0x0043
        L_0x003a:
            r8.booleanValue()     // Catch:{ all -> 0x00f8 }
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00f8 }
            kotlin.Pair r1 = kotlin.TuplesKt.to(r8, r1)     // Catch:{ all -> 0x00f8 }
        L_0x0043:
            if (r1 != 0) goto L_0x004d
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00f8 }
            java.lang.String r8 = "-bg"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r8)     // Catch:{ all -> 0x00f8 }
        L_0x004d:
            java.lang.Object r8 = r1.component1()     // Catch:{ all -> 0x00f8 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x00f8 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x00f8 }
            java.lang.Object r1 = r1.component2()     // Catch:{ all -> 0x00f8 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00f8 }
            java.lang.String r9 = r7.getName()     // Catch:{ all -> 0x00f8 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = kotlin.text.StringsKt__StringsKt.removeSuffix((java.lang.String) r9, (java.lang.CharSequence) r2)     // Catch:{ all -> 0x00f8 }
            long r11 = java.lang.Long.parseLong(r2)     // Catch:{ all -> 0x00f8 }
            boolean r14 = r13.e(r14)     // Catch:{ all -> 0x00f8 }
            r2 = 1
            if (r14 != 0) goto L_0x0089
            java.lang.String r14 = "Trm Migrator-> detection on foreground "
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x00f8 }
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r14, r9)     // Catch:{ all -> 0x00f8 }
            com.instabug.commons.logging.a.b(r14)     // Catch:{ all -> 0x00f8 }
            if (r8 == 0) goto L_0x0087
            goto L_0x0089
        L_0x0087:
            r14 = r10
            goto L_0x008a
        L_0x0089:
            r14 = r2
        L_0x008a:
            com.instabug.terminations.j0 r8 = r13.f52643c     // Catch:{ all -> 0x00f8 }
            boolean r5 = r8.a(r5, r11)     // Catch:{ all -> 0x00f8 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x00f8 }
            boolean r6 = r5.booleanValue()     // Catch:{ all -> 0x00f8 }
            if (r6 == 0) goto L_0x009d
            if (r14 == 0) goto L_0x009d
            r10 = r2
        L_0x009d:
            if (r10 == 0) goto L_0x00a0
            goto L_0x00a1
        L_0x00a0:
            r5 = r4
        L_0x00a1:
            if (r5 != 0) goto L_0x00a4
            goto L_0x00cb
        L_0x00a4:
            r5.booleanValue()     // Catch:{ all -> 0x00f8 }
            r3.a((java.io.File) r7, (java.lang.String) r1)     // Catch:{ all -> 0x00f8 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r14.<init>()     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = "Trm Migrator-> Marked "
            r14.append(r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = r7.getAbsolutePath()     // Catch:{ all -> 0x00f8 }
            r14.append(r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = " as valid"
            r14.append(r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x00f8 }
            com.instabug.commons.logging.a.b(r14)     // Catch:{ all -> 0x00f8 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f8 }
        L_0x00cb:
            if (r4 != 0) goto L_0x00f1
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r14.<init>()     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = "Trm Migrator-> Detection "
            r14.append(r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = r7.getAbsolutePath()     // Catch:{ all -> 0x00f8 }
            r14.append(r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r2 = " is not valid"
            r14.append(r2)     // Catch:{ all -> 0x00f8 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x00f8 }
            com.instabug.commons.logging.a.b(r14)     // Catch:{ all -> 0x00f8 }
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)     // Catch:{ all -> 0x00f8 }
            r3.b(r7, r14)     // Catch:{ all -> 0x00f8 }
        L_0x00f1:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f8 }
        L_0x00f3:
            java.lang.Object r14 = kotlin.Result.m6329constructorimpl(r4)     // Catch:{ all -> 0x00f8 }
            goto L_0x0103
        L_0x00f8:
            r14 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r14 = kotlin.ResultKt.createFailure(r14)
            java.lang.Object r14 = kotlin.Result.m6329constructorimpl(r14)
        L_0x0103:
            kotlin.Result r4 = kotlin.Result.m6328boximpl(r14)
        L_0x0107:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.p.g(java.io.File):kotlin.Result");
    }

    @NotNull
    public m invoke() {
        if (this.f52641a == null) {
            com.instabug.commons.logging.a.a("Couldn't start terminations migration (lack of Context)");
            return k.f52629a;
        }
        this.f52646f = this.f52642b.getCurrentSessionDirectory();
        this.f52647g = this.f52642b.getOldSessionsDirectories();
        this.f52648h = this.f52644d.getFirstFGTime();
        e a11 = new f(h.f52622a.a()).a(this.f52641a);
        a(a11);
        b(a11);
        List list = this.f52647g;
        l lVar = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldSessionsDirectories");
            list = null;
        }
        l a12 = a(SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.mapNotNull(SequencesKt___SequencesKt.onEach(CollectionsKt___CollectionsKt.asSequence(list), new n(this)), new o(this))));
        Long l11 = this.f52648h;
        if (l11 != null) {
            l11.longValue();
            lVar = a12;
        }
        if (lVar == null) {
            return k.f52629a;
        }
        return lVar;
    }

    private final void a(e eVar) {
        try {
            Result.Companion companion = Result.Companion;
            File file = this.f52646f;
            File file2 = null;
            if (file == null) {
                file = null;
            } else {
                a aVar = b.f52598b;
                File g11 = aVar.g(file);
                if ((g11.exists() ? g11 : null) == null) {
                    g11.mkdirs();
                    Unit unit = Unit.INSTANCE;
                }
                if (aVar.a(file) == null) {
                    File a11 = aVar.a(file, eVar.a());
                    if (a11.exists()) {
                        file2 = a11;
                    }
                    if (file2 == null) {
                        a11.createNewFile();
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                com.instabug.commons.logging.a.b("Trm Migrator-> Marked current session with Baseline");
            }
            Result.m6329constructorimpl(file);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    private final void b(e eVar) {
        String str;
        Object obj;
        String str2;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            Iterator it = eVar.b().iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (a((d) obj)) {
                    break;
                }
            }
            d dVar = (d) obj;
            if (dVar == null) {
                com.instabug.commons.logging.a.b("Trm Migrator-> no valid exit info found, skipping ..");
                return;
            }
            Integer valueOf = Integer.valueOf(dVar.a());
            if (!(valueOf.intValue() == 100)) {
                valueOf = null;
            }
            if (valueOf == null) {
                str2 = "-bg";
            } else {
                valueOf.intValue();
                str2 = "-fg";
            }
            List<File> list = this.f52647g;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oldSessionsDirectories");
                list = null;
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (File a11 : list) {
                arrayList.add(b.f52598b.a(a11, eVar.c()));
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (((File) obj2).exists()) {
                    break;
                }
            }
            File file = (File) obj2;
            if (file != null) {
                b.f52598b.a(file, str2, dVar.c());
                str = Intrinsics.stringPlus("Trm Migrator-> Marked detection for bl ", file.getAbsolutePath());
            }
            Result.m6329constructorimpl(str);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
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
    private final com.instabug.terminations.r c(java.io.File r4) {
        /*
            r3 = this;
            java.io.File r4 = r3.d(r4)
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
            boolean r2 = r4 instanceof com.instabug.terminations.r     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x001d
            r4 = r0
        L_0x001d:
            com.instabug.terminations.r r4 = (com.instabug.terminations.r) r4     // Catch:{ all -> 0x0027 }
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
            com.instabug.terminations.r r0 = (com.instabug.terminations.r) r0
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.p.c(java.io.File):com.instabug.terminations.r");
    }

    private final boolean a(d dVar) {
        return dVar.b() == 10 || dVar.b() == 6;
    }

    private final l a(List list) {
        List<File> list2 = this.f52647g;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldSessionsDirectories");
            list2 = null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
        for (File name2 : list2) {
            arrayList.add(name2.getName());
        }
        return new l(list, arrayList);
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
    private final com.instabug.library.model.State a(java.io.File r4) {
        /*
            r3 = this;
            java.io.File r4 = r3.b((java.io.File) r4)
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
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.p.a(java.io.File):com.instabug.library.model.State");
    }

    private final File b(File file) {
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
}
