package com.talabat.core.tracking.data.common;

import com.talabat.core.tracking.data.logger.LogManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.automation.DynamicJsonManager;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.core.tracking.data.common.DefaultTestingUtils$setLogEventForAutomation$1", f = "DefaultTestingUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultTestingUtils$setLogEventForAutomation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f56002h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f56003i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f56004j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTestingUtils$setLogEventForAutomation$1(String str, Map<String, ? extends Object> map, Continuation<? super DefaultTestingUtils$setLogEventForAutomation$1> continuation) {
        super(2, continuation);
        this.f56003i = str;
        this.f56004j = map;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultTestingUtils$setLogEventForAutomation$1(this.f56003i, this.f56004j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultTestingUtils$setLogEventForAutomation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f56002h == 0) {
            ResultKt.throwOnFailure(obj);
            DynamicJsonManager.INSTANCE.updateDynamicJson(this.f56003i, (Map<String, ? extends Object>) this.f56004j);
            String str = this.f56003i;
            LogManager.debug("TRACKING_EVENTS_LOG::: " + str + ", write completed to file");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
