package com.braze.ui.inappmessage.utils;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.braze.ui.inappmessage.utils.BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2", f = "BackgroundInAppMessagePreparer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f44148h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BackgroundInAppMessagePreparer f44149i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ IInAppMessage f44150j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2(BackgroundInAppMessagePreparer backgroundInAppMessagePreparer, IInAppMessage iInAppMessage, Continuation<? super BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2> continuation) {
        super(2, continuation);
        this.f44149i = backgroundInAppMessagePreparer;
        this.f44150j = iInAppMessage;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2(this.f44149i, this.f44150j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BackgroundInAppMessagePreparer$displayPreparedInAppMessage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f44148h == 0) {
            ResultKt.throwOnFailure(obj);
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f44149i, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) AnonymousClass1.INSTANCE, 7, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().displayInAppMessage(this.f44150j, false);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
