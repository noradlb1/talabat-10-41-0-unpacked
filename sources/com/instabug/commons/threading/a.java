package com.instabug.commons.threading;

import com.instabug.crash.utils.f;
import java.lang.Thread;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f46346a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final JSONArray f46347b;

    /* renamed from: com.instabug.commons.threading.a$a  reason: collision with other inner class name */
    public static abstract class C0054a {

        /* renamed from: com.instabug.commons.threading.a$a$a  reason: collision with other inner class name */
        public static final class C0055a extends C0054a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f46348a;
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            private final String f46349b;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            @JvmOverloads
            public C0055a(@NotNull Throwable th2) {
                this(th2, (String) null, 2, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(th2, "throwable");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ C0055a(Throwable th2, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
                this(th2, (i11 & 2) != 0 ? null : str);
            }

            @NotNull
            public JSONObject a() {
                JSONObject a11 = f.a(this.f46348a, this.f46349b);
                Intrinsics.checkNotNullExpressionValue(a11, "createExceptionJson(throwable, identifier)");
                return a11;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            @JvmOverloads
            public C0055a(@NotNull Throwable th2, @Nullable String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(th2, "throwable");
                this.f46348a = th2;
                this.f46349b = str;
            }
        }

        /* renamed from: com.instabug.commons.threading.a$a$b */
        public static final class b extends C0054a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final b f46350a = new b();

            private b() {
                super((DefaultConstructorMarker) null);
            }
        }

        private C0054a() {
        }

        public /* synthetic */ C0054a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public JSONObject a() {
            return null;
        }
    }

    public static abstract class b {

        /* renamed from: com.instabug.commons.threading.a$b$a  reason: collision with other inner class name */
        public static final class C0056a extends b {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final C0056a f46351a = new C0056a();

            private C0056a() {
                super((DefaultConstructorMarker) null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public JSONObject a() {
            return null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public a(@NotNull b bVar, @NotNull C0054a aVar) {
        this(bVar, aVar, (Thread) null, (Set) null, 0, 0, 60, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bVar, "threadParsingStrategy");
        Intrinsics.checkNotNullParameter(aVar, "errorParsingStrategy");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public a(@NotNull b bVar, @NotNull C0054a aVar, @Nullable Thread thread) {
        this(bVar, aVar, thread, (Set) null, 0, 0, 56, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bVar, "threadParsingStrategy");
        Intrinsics.checkNotNullParameter(aVar, "errorParsingStrategy");
    }

    @JvmOverloads
    public a(@NotNull b bVar, @NotNull C0054a aVar, @Nullable Thread thread, @NotNull Set set, int i11, int i12) {
        int i13;
        Object obj;
        Intrinsics.checkNotNullParameter(bVar, "threadParsingStrategy");
        Intrinsics.checkNotNullParameter(aVar, "errorParsingStrategy");
        Intrinsics.checkNotNullParameter(set, "threads");
        boolean z11 = true;
        int i14 = 0;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator it = set.iterator();
            i13 = 0;
            while (it.hasNext()) {
                if ((((Thread) it.next()).getState() == Thread.State.TERMINATED) && (i13 = i13 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            i13 = 0;
        }
        Set a11 = a(set, thread);
        Set a12 = a(set, thread, a11, i11 - a11.size());
        Integer valueOf = Integer.valueOf((set.size() - i13) - a12.size());
        valueOf = valueOf.intValue() >= 0 ? false : z11 ? null : valueOf;
        i14 = valueOf != null ? valueOf.intValue() : i14;
        com.instabug.commons.logging.a.b("Original threads' count = " + set.size() + ", Terminated threads' count = " + i13 + ", Dropped threads' count = " + i14);
        com.instabug.commons.logging.a.b(Intrinsics.stringPlus("First original thread ", CollectionsKt___CollectionsKt.firstOrNull(set)));
        com.instabug.commons.logging.a.b(Intrinsics.stringPlus("Last original thread ", CollectionsKt___CollectionsKt.lastOrNull(set)));
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = new JSONObject();
            JSONObject a13 = bVar.a();
            if (a13 != null) {
                jSONObject.put("thread", (Object) a13);
            }
            JSONObject a14 = aVar.a();
            if (a14 != null) {
                jSONObject.put("error", (Object) a14);
            }
            jSONObject.put("droppedThreads", i14);
            jSONObject.put("terminatedThreads", i13);
            obj = Result.m6329constructorimpl(jSONObject);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        this.f46346a = (JSONObject) com.instabug.commons.logging.a.a(obj, new JSONObject(), "Failed parsing crash details", false, 4, (Object) null);
        this.f46347b = o.a(a12, thread, i12);
    }

    @NotNull
    public final JSONObject a() {
        return this.f46346a;
    }

    @NotNull
    public final JSONArray b() {
        return this.f46347b;
    }

    private final Set a(Set set, Thread thread) {
        return SequencesKt___SequencesKt.toSet(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(set), new f(thread)));
    }

    private final Set a(Set set, Thread thread, Set set2, int i11) {
        Set mutableSet = SequencesKt___SequencesKt.toMutableSet(SequencesKt___SequencesKt.take(SequencesKt___SequencesKt.sortedWith(SequencesKt___SequencesKt.filterNot(SequencesKt___SequencesKt.filterNot(SequencesKt___SequencesKt.filterNot(CollectionsKt___CollectionsKt.asSequence(set), i.f46358a), new j(thread)), k.f46360a), new h()), i11));
        mutableSet.addAll(set2);
        return CollectionsKt___CollectionsKt.toSet(CollectionsKt___CollectionsKt.sortedWith(mutableSet, new g()));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(b bVar, C0054a aVar, Thread thread, Set<Thread> set, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, aVar, (i13 & 4) != 0 ? null : thread, (i13 & 8) != 0 ? Thread.getAllStackTraces().keySet() : set, (i13 & 16) != 0 ? 200 : i11, (i13 & 32) != 0 ? 100 : i12);
    }
}
