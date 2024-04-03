package com.talabat.observability.localTracer;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import kotlin.Metadata;
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
import org.json.JSONArray;

@Instrumented
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.observability.localTracer.PointOfInterestReporter$endTraceLog$1$1", f = "PointOfInterestReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PointOfInterestReporter$endTraceLog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61094h;

    public PointOfInterestReporter$endTraceLog$1$1(Continuation<? super PointOfInterestReporter$endTraceLog$1$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PointOfInterestReporter$endTraceLog$1$1(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PointOfInterestReporter$endTraceLog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61094h == 0) {
            ResultKt.throwOnFailure(obj);
            JSONArray access$toJsonArray = PointOfInterestReporterKt.toJsonArray(PointOfInterestReporter.tracesList);
            if (!(access$toJsonArray instanceof JSONArray)) {
                str = access$toJsonArray.toString();
            } else {
                str = JSONArrayInstrumentation.toString(access$toJsonArray);
            }
            Intrinsics.checkNotNullExpressionValue(str, "tracesList.toJsonArray().toString()");
            FileOperator.Companion.saveToFile(str);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
