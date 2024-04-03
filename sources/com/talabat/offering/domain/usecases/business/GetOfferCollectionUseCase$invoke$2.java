package com.talabat.offering.domain.usecases.business;

import JsonModels.PolygonEvents;
import com.talabat.offering.domain.entities.Background;
import com.talabat.offering.domain.entities.CallToAction;
import com.talabat.offering.domain.entities.Header;
import com.talabat.offering.domain.entities.HeaderText;
import com.talabat.offering.domain.entities.OfferCollection;
import com.talabat.offering.domain.repo.OfferCollectionRepo;
import datamodels.QuickFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/offering/domain/entities/OfferCollection;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.offering.domain.usecases.business.GetOfferCollectionUseCase$invoke$2", f = "GetOfferCollectionUseCase.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
public final class GetOfferCollectionUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OfferCollection>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61118h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GetOfferCollectionUseCase f61119i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f61120j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ double f61121k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ double f61122l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetOfferCollectionUseCase$invoke$2(GetOfferCollectionUseCase getOfferCollectionUseCase, int i11, double d11, double d12, Continuation<? super GetOfferCollectionUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f61119i = getOfferCollectionUseCase;
        this.f61120j = i11;
        this.f61121k = d11;
        this.f61122l = d12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetOfferCollectionUseCase$invoke$2 getOfferCollectionUseCase$invoke$2 = new GetOfferCollectionUseCase$invoke$2(this.f61119i, this.f61120j, this.f61121k, this.f61122l, continuation);
        getOfferCollectionUseCase$invoke$2.L$0 = obj;
        return getOfferCollectionUseCase$invoke$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super OfferCollection> continuation) {
        return ((GetOfferCollectionUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61118h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            GetOfferCollectionUseCase getOfferCollectionUseCase = this.f61119i;
            int i12 = this.f61120j;
            double d11 = this.f61121k;
            double d12 = this.f61122l;
            Result.Companion companion = Result.Companion;
            OfferCollectionRepo access$getOfferCollectionRepo$p = getOfferCollectionUseCase.offerCollectionRepo;
            this.f61118h = 1;
            obj = access$getOfferCollectionRepo$p.getOfferCollection(i12, d11, d12, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((OfferCollection) obj);
        if (Result.m6332exceptionOrNullimpl(obj2) == null) {
            return obj2;
        }
        return new OfferCollection((HeaderText) null, (CallToAction) null, (Header) null, (String) null, (List) null, (Background) null, (PolygonEvents) null, (QuickFilter) null, 255, (DefaultConstructorMarker) null);
    }
}
