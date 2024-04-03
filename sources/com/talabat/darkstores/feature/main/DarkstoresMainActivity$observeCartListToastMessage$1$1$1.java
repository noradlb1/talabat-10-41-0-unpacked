package com.talabat.darkstores.feature.main;

import com.designsystem.ds_toast.DSToast;
import com.designsystem.ds_toast.DSToastModel;
import com.talabat.darkstores.R;
import com.talabat.feature.darkstorescartlist.domain.model.CartListToast;
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
@DebugMetadata(c = "com.talabat.darkstores.feature.main.DarkstoresMainActivity$observeCartListToastMessage$1$1$1", f = "DarkstoresMainActivity.kt", i = {}, l = {395}, m = "invokeSuspend", n = {}, s = {})
public final class DarkstoresMainActivity$observeCartListToastMessage$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f56449h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56450i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CartListToast f56451j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresMainActivity$observeCartListToastMessage$1$1$1(DarkstoresMainActivity darkstoresMainActivity, CartListToast cartListToast, Continuation<? super DarkstoresMainActivity$observeCartListToastMessage$1$1$1> continuation) {
        super(2, continuation);
        this.f56450i = darkstoresMainActivity;
        this.f56451j = cartListToast;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DarkstoresMainActivity$observeCartListToastMessage$1$1$1(this.f56450i, this.f56451j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DarkstoresMainActivity$observeCartListToastMessage$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f56449h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            DSToastModel access$getToastModel = this.f56450i.getToastModel(this.f56451j);
            this.f56449h = 1;
            if (((DSToast) this.f56450i._$_findCachedViewById(R.id.toast)).showDSToast(access$getToastModel, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
