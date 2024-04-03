package com.talabat.riderinfo.presentation.viewmodel;

import com.talabat.chat.domain.ChatException;
import com.talabat.observability.ObservabilityManager;
import com.talabat.riderinfo.domain.entity.RiderInfo;
import com.talabat.riderinfo.domain.usecase.GetRiderInfo;
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
@DebugMetadata(c = "com.talabat.riderinfo.presentation.viewmodel.RiderChatDeepLinkViewModel$onCreate$1", f = "RiderChatDeepLinkViewModel.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
public final class RiderChatDeepLinkViewModel$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61293h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RiderChatDeepLinkViewModel f61294i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f61295j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderChatDeepLinkViewModel$onCreate$1(RiderChatDeepLinkViewModel riderChatDeepLinkViewModel, String str, Continuation<? super RiderChatDeepLinkViewModel$onCreate$1> continuation) {
        super(2, continuation);
        this.f61294i = riderChatDeepLinkViewModel;
        this.f61295j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RiderChatDeepLinkViewModel$onCreate$1(this.f61294i, this.f61295j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RiderChatDeepLinkViewModel$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61293h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f61294i.showLoading();
            GetRiderInfo access$getGetRiderInfo$p = this.f61294i.getRiderInfo;
            String str = this.f61295j;
            this.f61293h = 1;
            obj = access$getGetRiderInfo$p.invoke(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (ChatException e11) {
                String message = e11.getMessage();
                if (message == null) {
                    message = "Opening raider chat from Global Help Center failed!";
                }
                ObservabilityManager.trackUnExpectedScenario$default(message, (Map) null, 2, (Object) null);
                this.f61294i.showErrorMessage();
            } catch (Exception e12) {
                String message2 = e12.getMessage();
                if (message2 == null) {
                    message2 = "Fetching rider info failed when opening rider chat!";
                }
                ObservabilityManager.trackUnExpectedScenario$default(message2, (Map) null, 2, (Object) null);
                this.f61294i.showErrorMessage();
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f61294i.hideLoading();
        this.f61294i.startRiderChat.invoke((RiderInfo) obj);
        return Unit.INSTANCE;
    }
}
