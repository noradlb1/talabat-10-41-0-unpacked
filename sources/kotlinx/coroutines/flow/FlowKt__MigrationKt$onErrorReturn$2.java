package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "e", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__MigrationKt$onErrorReturn$2 extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f25750h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25751i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Throwable, Boolean> f25752j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ T f25753k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$onErrorReturn$2(Function1<? super Throwable, Boolean> function1, T t11, Continuation<? super FlowKt__MigrationKt$onErrorReturn$2> continuation) {
        super(3, continuation);
        this.f25752j = function1;
        this.f25753k = t11;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th2, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__MigrationKt$onErrorReturn$2 flowKt__MigrationKt$onErrorReturn$2 = new FlowKt__MigrationKt$onErrorReturn$2(this.f25752j, this.f25753k, continuation);
        flowKt__MigrationKt$onErrorReturn$2.L$0 = flowCollector;
        flowKt__MigrationKt$onErrorReturn$2.f25751i = th2;
        return flowKt__MigrationKt$onErrorReturn$2.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25750h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th2 = (Throwable) this.f25751i;
            if (this.f25752j.invoke(th2).booleanValue()) {
                T t11 = this.f25753k;
                this.L$0 = null;
                this.f25750h = 1;
                if (flowCollector.emit(t11, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th2;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
