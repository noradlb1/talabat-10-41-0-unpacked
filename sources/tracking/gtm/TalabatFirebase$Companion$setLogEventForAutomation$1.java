package tracking.gtm;

import android.os.Bundle;
import com.talabat.talabatcore.logger.LogManager;
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
@DebugMetadata(c = "tracking.gtm.TalabatFirebase$Companion$setLogEventForAutomation$1", f = "TalabatFirebase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TalabatFirebase$Companion$setLogEventForAutomation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f63541h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f63542i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Bundle f63543j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatFirebase$Companion$setLogEventForAutomation$1(String str, Bundle bundle, Continuation<? super TalabatFirebase$Companion$setLogEventForAutomation$1> continuation) {
        super(2, continuation);
        this.f63542i = str;
        this.f63543j = bundle;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TalabatFirebase$Companion$setLogEventForAutomation$1(this.f63542i, this.f63543j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TalabatFirebase$Companion$setLogEventForAutomation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f63541h == 0) {
            ResultKt.throwOnFailure(obj);
            DynamicJsonManager.INSTANCE.updateDynamicJson(this.f63542i, this.f63543j);
            String str = this.f63542i;
            LogManager.debug("TRACKING_EVENTS_LOG::: " + str + ", write completed to file");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
