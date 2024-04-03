package com.talabat.newrelic;

import com.newrelic.agent.android.NewRelic;
import java.util.LinkedHashMap;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.newrelic.NewRelic$recordCustomEvent$1", f = "NewRelic.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NewRelic$recordCustomEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61073h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f61074i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f61075j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f61076k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewRelic$recordCustomEvent$1(Map<String, String> map, String str, String str2, Continuation<? super NewRelic$recordCustomEvent$1> continuation) {
        super(2, continuation);
        this.f61074i = map;
        this.f61075j = str;
        this.f61076k = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NewRelic$recordCustomEvent$1(this.f61074i, this.f61075j, this.f61076k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NewRelic$recordCustomEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f61073h == 0) {
            ResultKt.throwOnFailure(obj);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(this.f61074i);
            String str = this.f61075j;
            if (str != null) {
                linkedHashMap.put("name", str);
            }
            NewRelic.recordCustomEvent(this.f61076k, linkedHashMap);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
