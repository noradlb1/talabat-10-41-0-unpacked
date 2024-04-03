package com.deliveryhero.customerchat.analytics.repository;

import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.analytics.service.AnalyticsService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lretrofit2/Response;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.deliveryhero.customerchat.analytics.repository.AnalyticsRepositoryImpl$track$2", f = "AnalyticsRepositoryImpl.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
public final class AnalyticsRepositoryImpl$track$2 extends SuspendLambda implements Function1<Continuation<? super Response<Object>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f29808h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AnalyticsRepositoryImpl f29809i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EventCreationRequest f29810j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f29811k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f29812l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnalyticsRepositoryImpl$track$2(AnalyticsRepositoryImpl analyticsRepositoryImpl, EventCreationRequest eventCreationRequest, String str, String str2, Continuation<? super AnalyticsRepositoryImpl$track$2> continuation) {
        super(1, continuation);
        this.f29809i = analyticsRepositoryImpl;
        this.f29810j = eventCreationRequest;
        this.f29811k = str;
        this.f29812l = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AnalyticsRepositoryImpl$track$2(this.f29809i, this.f29810j, this.f29811k, this.f29812l, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Response<Object>> continuation) {
        return ((AnalyticsRepositoryImpl$track$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f29808h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.f29812l;
            this.f29808h = 1;
            obj = AnalyticsService.DefaultImpls.sendEvent$default(this.f29809i.analyticsService, this.f29809i.getSendEventsUrl(), this.f29810j, "Bearer " + this.f29811k, str, (String) null, this, 16, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
