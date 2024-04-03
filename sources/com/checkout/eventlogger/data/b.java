package com.checkout.eventlogger.data;

import com.checkout.eventlogger.domain.model.MonitoringLevel;
import com.checkout.eventlogger.network.b.a;
import com.checkout.eventlogger.network.b.b;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@DebugMetadata(c = "com.checkout.eventlogger.data.CheckoutEventLoggingService$sendCloudEvents$1", f = "CheckoutEventLoggingService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f44211a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f44212b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(a aVar, List list, Continuation continuation) {
        super(2, continuation);
        this.f44211a = aVar;
        this.f44212b = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new b(this.f44211a, this.f44212b, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((b) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Gson gson = (Gson) this.f44211a.f44206b.getValue();
        List list = this.f44212b;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) list);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) list);
        }
        a aVar = this.f44211a.f44207c;
        Intrinsics.checkNotNullExpressionValue(str, "payload");
        com.checkout.eventlogger.network.b.b<Unit> a11 = aVar.a(str);
        if (!(a11 instanceof b.c)) {
            if (a11 instanceof b.C0046b) {
                MonitoringLevel monitoringLevel = MonitoringLevel.DEBUG;
                Intrinsics.checkNotNullParameter("Failed to send logging data: " + ((b.C0046b) a11).f44262a, "message");
                Intrinsics.checkNotNullParameter("Cko-Logger", "tag");
                Intrinsics.checkNotNullParameter(monitoringLevel, "monitoringLevel");
            } else if (a11 instanceof b.a) {
                Throwable th2 = ((b.a) a11).f44261a;
                Intrinsics.checkNotNullParameter("Error sending logging data", "message");
                Intrinsics.checkNotNullParameter("Cko-Logger", "tag");
            }
        }
        return Unit.INSTANCE;
    }
}
