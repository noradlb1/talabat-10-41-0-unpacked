package com.talabat.userandlocation.login.data.remote.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailApi;", "", "verifyEmail", "Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailResponse;", "verifyEmailRequest", "Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailRequest;", "(Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerifyEmailApi {
    @POST("/api/v1/customers/email-check")
    @Nullable
    Object verifyEmail(@NotNull @Body VerifyEmailRequest verifyEmailRequest, @NotNull Continuation<? super VerifyEmailResponse> continuation);
}
