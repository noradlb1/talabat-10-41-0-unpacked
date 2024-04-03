package com.talabat.sidemenu;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.sidemenu.SideMenuTLifeViewPresenter$setView$1", f = "SideMenuTLifeViewPresenter.kt", i = {}, l = {41, 51}, m = "invokeSuspend", n = {}, s = {})
public final class SideMenuTLifeViewPresenter$setView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61381h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SideMenuTLifeViewPresenter f61382i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f61383j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SideMenuTLifeViewHolder f61384k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideMenuTLifeViewPresenter$setView$1(SideMenuTLifeViewPresenter sideMenuTLifeViewPresenter, boolean z11, SideMenuTLifeViewHolder sideMenuTLifeViewHolder, Continuation<? super SideMenuTLifeViewPresenter$setView$1> continuation) {
        super(2, continuation);
        this.f61382i = sideMenuTLifeViewPresenter;
        this.f61383j = z11;
        this.f61384k = sideMenuTLifeViewHolder;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SideMenuTLifeViewPresenter$setView$1(this.f61382i, this.f61383j, this.f61384k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SideMenuTLifeViewPresenter$setView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61381h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SideMenuTLifeViewPresenter sideMenuTLifeViewPresenter = this.f61382i;
            boolean z12 = this.f61383j;
            SideMenuTLifeViewHolder sideMenuTLifeViewHolder = this.f61384k;
            Result.Companion companion = Result.Companion;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            if (z12) {
                z11 = true;
            } else {
                z11 = false;
            }
            SideMenuTLifeViewPresenter$setView$1$1$1 sideMenuTLifeViewPresenter$setView$1$1$1 = new SideMenuTLifeViewPresenter$setView$1$1$1(sideMenuTLifeViewPresenter, z11, sideMenuTLifeViewHolder, (Continuation<? super SideMenuTLifeViewPresenter$setView$1$1$1>) null);
            this.f61381h = 1;
            if (BuildersKt.withContext(main, sideMenuTLifeViewPresenter$setView$1$1$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else if (i11 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
        SideMenuTLifeViewPresenter sideMenuTLifeViewPresenter2 = this.f61382i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            MainCoroutineDispatcher main2 = Dispatchers.getMain();
            SideMenuTLifeViewPresenter$setView$1$2$1 sideMenuTLifeViewPresenter$setView$1$2$1 = new SideMenuTLifeViewPresenter$setView$1$2$1(sideMenuTLifeViewPresenter2, (Continuation<? super SideMenuTLifeViewPresenter$setView$1$2$1>) null);
            this.f61381h = 2;
            if (BuildersKt.withContext(main2, sideMenuTLifeViewPresenter$setView$1$2$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
