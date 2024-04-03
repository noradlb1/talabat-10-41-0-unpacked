package com.google.flutter.recaptcha;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.recaptcha.Recaptcha;
import com.google.android.recaptcha.RecaptchaClient;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.google.flutter.recaptcha.RecaptchaEnterprisePlugin$initClient$1", f = "RecaptchaEnterprisePlugin.kt", i = {}, l = {66, 67}, m = "invokeSuspend", n = {}, s = {})
public final class RecaptchaEnterprisePlugin$initClient$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MethodChannel.Result $result;
    final /* synthetic */ String $siteKey;
    final /* synthetic */ Double $timeout;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecaptchaEnterprisePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecaptchaEnterprisePlugin$initClient$1(Double d11, RecaptchaEnterprisePlugin recaptchaEnterprisePlugin, String str, MethodChannel.Result result, Continuation<? super RecaptchaEnterprisePlugin$initClient$1> continuation) {
        super(2, continuation);
        this.$timeout = d11;
        this.this$0 = recaptchaEnterprisePlugin;
        this.$siteKey = str;
        this.$result = result;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RecaptchaEnterprisePlugin$initClient$1 recaptchaEnterprisePlugin$initClient$1 = new RecaptchaEnterprisePlugin$initClient$1(this.$timeout, this.this$0, this.$siteKey, this.$result, continuation);
        recaptchaEnterprisePlugin$initClient$1.L$0 = obj;
        return recaptchaEnterprisePlugin$initClient$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecaptchaEnterprisePlugin$initClient$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Application application;
        Application application2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Double d11 = this.$timeout;
            RecaptchaEnterprisePlugin recaptchaEnterprisePlugin = this.this$0;
            String str = this.$siteKey;
            if (d11 != null) {
                Recaptcha recaptcha = Recaptcha.INSTANCE;
                Application access$getApplication$p = recaptchaEnterprisePlugin.application;
                if (access$getApplication$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
                    application2 = null;
                } else {
                    application2 = access$getApplication$p;
                }
                this.label = 1;
                obj2 = recaptcha.m9339getClientBWLJW6A(application2, str, (long) d11.doubleValue(), this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Recaptcha recaptcha2 = Recaptcha.INSTANCE;
                Application access$getApplication$p2 = recaptchaEnterprisePlugin.application;
                if (access$getApplication$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
                    application = null;
                } else {
                    application = access$getApplication$p2;
                }
                this.label = 2;
                obj2 = Recaptcha.m9338getClientBWLJW6A$default(recaptcha2, application, str, 0, this, 4, (Object) null);
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
        RecaptchaEnterprisePlugin recaptchaEnterprisePlugin2 = this.this$0;
        MethodChannel.Result result = this.$result;
        if (Result.m6336isSuccessimpl(obj2)) {
            recaptchaEnterprisePlugin2.recaptchaClient = (RecaptchaClient) obj2;
            result.success(Boxing.boxBoolean(true));
        }
        MethodChannel.Result result2 = this.$result;
        Throwable r14 = Result.m6332exceptionOrNullimpl(obj2);
        if (r14 != null) {
            result2.error("FL_INIT_FAILED", r14.toString(), (Object) null);
        }
        return Unit.INSTANCE;
    }
}
