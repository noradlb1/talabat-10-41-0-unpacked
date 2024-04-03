package com.talabat.darkstores.feature.main;

import com.designsystem.ds_toast.DSToast;
import com.designsystem.ds_toast.DSToastModel;
import com.talabat.darkstores.R;
import com.talabat.darkstores.model.ToastModel;
import com.talabat.wrapper.EventWrapper;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.darkstores.feature.main.DarkstoresMainActivity$observeVoucherGenerationLiveData$1$1", f = "DarkstoresMainActivity.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
public final class DarkstoresMainActivity$observeVoucherGenerationLiveData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f56452h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ EventWrapper<ToastModel> f56453i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56454j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresMainActivity$observeVoucherGenerationLiveData$1$1(EventWrapper<ToastModel> eventWrapper, DarkstoresMainActivity darkstoresMainActivity, Continuation<? super DarkstoresMainActivity$observeVoucherGenerationLiveData$1$1> continuation) {
        super(2, continuation);
        this.f56453i = eventWrapper;
        this.f56454j = darkstoresMainActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DarkstoresMainActivity$observeVoucherGenerationLiveData$1$1(this.f56453i, this.f56454j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DarkstoresMainActivity$observeVoucherGenerationLiveData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f56452h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ToastModel contentIfNotHandled = this.f56453i.getContentIfNotHandled();
            if (contentIfNotHandled != null) {
                String string = this.f56454j.getString(contentIfNotHandled.getLabelResId());
                Intrinsics.checkNotNullExpressionValue(string, "getString(toastModel.labelResId)");
                DSToastModel dSToastModel = new DSToastModel(string, contentIfNotHandled.getLeadingIconResId());
                this.f56452h = 1;
                if (((DSToast) this.f56454j._$_findCachedViewById(R.id.toast)).showDSToast(dSToastModel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
