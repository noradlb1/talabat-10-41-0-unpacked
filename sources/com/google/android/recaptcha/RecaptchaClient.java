package com.google.android.recaptcha;

import androidx.annotation.NonNull;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0003\u0002\u0015\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/google/android/recaptcha/RecaptchaClient;", "", "execute", "Lkotlin/Result;", "", "recaptchaAction", "Lcom/google/android/recaptcha/RecaptchaAction;", "execute-gIAlu-s", "(Lcom/google/android/recaptcha/RecaptchaAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "", "execute-0E7RQCE", "(Lcom/google/android/recaptcha/RecaptchaAction;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.abuse.recaptcha.enterprise.public_public"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RecaptchaClient {
    @Nullable
    @NonNull
    /* renamed from: execute-0E7RQCE  reason: not valid java name */
    Object m9340execute0E7RQCE(@NonNull RecaptchaAction recaptchaAction, long j11, @NonNull Continuation<? super Result<String>> continuation);

    @Nullable
    @NonNull
    /* renamed from: execute-gIAlu-s  reason: not valid java name */
    Object m9341executegIAlus(@NonNull RecaptchaAction recaptchaAction, @NonNull Continuation<? super Result<String>> continuation);
}
