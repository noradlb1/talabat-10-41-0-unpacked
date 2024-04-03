package com.checkout.eventlogger.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

public final class a {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final C0044a f44204e = new C0044a();

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f44205a = LazyKt__LazyJVMKt.lazy(c.f44210a);

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f44206b = LazyKt__LazyJVMKt.lazy(b.f44209a);

    /* renamed from: c  reason: collision with root package name */
    public final com.checkout.eventlogger.network.b.a f44207c;

    /* renamed from: d  reason: collision with root package name */
    public final d f44208d;

    /* renamed from: com.checkout.eventlogger.data.a$a  reason: collision with other inner class name */
    public static final class C0044a {
    }

    public static final class b extends Lambda implements Function0<Gson> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f44209a = new b();

        public b() {
            super(0);
        }

        public Object invoke() {
            Gson create = new GsonBuilder().create();
            Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder()\n            .create()");
            return create;
        }
    }

    public static final class c extends Lambda implements Function0<CoroutineScope> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f44210a = new c();

        public c() {
            super(0);
        }

        public Object invoke() {
            return CoroutineScopeKt.CoroutineScope(new CoroutineName("CheckoutLoggingService").plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(Dispatchers.getIO()).plus(NonCancellable.INSTANCE));
        }
    }

    public a(@NotNull com.checkout.eventlogger.network.b.a aVar, @NotNull d dVar) {
        Intrinsics.checkNotNullParameter(aVar, "networkApi");
        Intrinsics.checkNotNullParameter(dVar, "logEventMapper");
        this.f44207c = aVar;
        this.f44208d = dVar;
    }
}
