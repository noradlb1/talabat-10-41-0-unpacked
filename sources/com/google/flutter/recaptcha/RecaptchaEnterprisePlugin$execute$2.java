package com.google.flutter.recaptcha;

import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaClient;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Result;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.google.flutter.recaptcha.RecaptchaEnterprisePlugin$execute$2", f = "RecaptchaEnterprisePlugin.kt", i = {}, l = {94, 94}, m = "invokeSuspend", n = {}, s = {})
public final class RecaptchaEnterprisePlugin$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecaptchaAction $action;
    final /* synthetic */ MethodChannel.Result $result;
    final /* synthetic */ Double $timeout;
    int label;
    final /* synthetic */ RecaptchaEnterprisePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecaptchaEnterprisePlugin$execute$2(RecaptchaEnterprisePlugin recaptchaEnterprisePlugin, Double d11, RecaptchaAction recaptchaAction, MethodChannel.Result result, Continuation<? super RecaptchaEnterprisePlugin$execute$2> continuation) {
        super(2, continuation);
        this.this$0 = recaptchaEnterprisePlugin;
        this.$timeout = d11;
        this.$action = recaptchaAction;
        this.$result = result;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecaptchaEnterprisePlugin$execute$2(this.this$0, this.$timeout, this.$action, this.$result, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecaptchaEnterprisePlugin$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            RecaptchaClient access$getRecaptchaClient$p = this.this$0.recaptchaClient;
            if (access$getRecaptchaClient$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recaptchaClient");
                access$getRecaptchaClient$p = null;
            }
            Double d11 = this.$timeout;
            RecaptchaAction recaptchaAction = this.$action;
            if (d11 != null) {
                this.label = 1;
                obj2 = access$getRecaptchaClient$p.m9340execute0E7RQCE(recaptchaAction, (long) d11.doubleValue(), this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 2;
                obj2 = access$getRecaptchaClient$p.m9341executegIAlus(recaptchaAction, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            ResultKt.throwOnFailure(obj);
            obj2 = ((Result) obj).m6338unboximpl();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        MethodChannel.Result result = this.$result;
        if (Result.m6336isSuccessimpl(obj2)) {
            result.success((String) obj2);
        }
        MethodChannel.Result result2 = this.$result;
        Throwable r92 = Result.m6332exceptionOrNullimpl(obj2);
        if (r92 != null) {
            result2.error("FL_EXECUTE_FAILED", r92.toString(), (Object) null);
        }
        return Unit.INSTANCE;
    }
}
