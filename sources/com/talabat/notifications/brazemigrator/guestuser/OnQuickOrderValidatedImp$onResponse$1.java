package com.talabat.notifications.brazemigrator.guestuser;

import JsonModels.Response.AddAddressRM;
import com.talabat.localization.R;
import com.talabat.notifications.brazemigrator.BrazeUserMigrator;
import com.talabat.notifications.brazemigrator.guestuser.model.GuestUserRequestBody;
import datamodels.QuickOrderUserInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import library.talabat.mvp.quickorder.QuickOrderListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.notifications.brazemigrator.guestuser.OnQuickOrderValidatedImp$onResponse$1", f = "OnQuickOrderValidatedImp.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class OnQuickOrderValidatedImp$onResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61077h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OnQuickOrderValidatedImp f61078i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ QuickOrderUserInfo f61079j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ QuickOrderListener f61080k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ AddAddressRM f61081l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnQuickOrderValidatedImp$onResponse$1(OnQuickOrderValidatedImp onQuickOrderValidatedImp, QuickOrderUserInfo quickOrderUserInfo, QuickOrderListener quickOrderListener, AddAddressRM addAddressRM, Continuation<? super OnQuickOrderValidatedImp$onResponse$1> continuation) {
        super(2, continuation);
        this.f61078i = onQuickOrderValidatedImp;
        this.f61079j = quickOrderUserInfo;
        this.f61080k = quickOrderListener;
        this.f61081l = addAddressRM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OnQuickOrderValidatedImp$onResponse$1(this.f61078i, this.f61079j, this.f61080k, this.f61081l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OnQuickOrderValidatedImp$onResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61077h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            BrazeUserMigrator access$getBrazeUserMigrator$p = this.f61078i.brazeUserMigrator;
            String str = this.f61079j.firstName;
            Intrinsics.checkNotNullExpressionValue(str, "quickOrderUserInfo.firstName");
            String str2 = this.f61079j.lastName;
            Intrinsics.checkNotNullExpressionValue(str2, "quickOrderUserInfo.lastName");
            String str3 = this.f61079j.mobileNumber;
            Intrinsics.checkNotNullExpressionValue(str3, "quickOrderUserInfo.mobileNumber");
            GuestUserRequestBody guestUserRequestBody = new GuestUserRequestBody(str, str2, str3);
            final QuickOrderListener quickOrderListener = this.f61080k;
            final AddAddressRM addAddressRM = this.f61081l;
            AnonymousClass1 r32 = new Function0<Unit>() {
                public final void invoke() {
                    quickOrderListener.onAddressValidationSuccess(addAddressRM.result.address);
                }
            };
            final QuickOrderListener quickOrderListener2 = this.f61080k;
            final OnQuickOrderValidatedImp onQuickOrderValidatedImp = this.f61078i;
            AnonymousClass2 r42 = new Function0<Unit>() {
                public final void invoke() {
                    quickOrderListener2.onAddressValidationFailed(500, onQuickOrderValidatedImp.applicationContext.getString(R.string.address_error_message));
                }
            };
            this.f61077h = 1;
            if (access$getBrazeUserMigrator$p.migrateGuestUser(guestUserRequestBody, r32, r42, this) == coroutine_suspended) {
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
