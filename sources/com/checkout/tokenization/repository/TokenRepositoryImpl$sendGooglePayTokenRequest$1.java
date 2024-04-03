package com.checkout.tokenization.repository;

import com.checkout.network.response.NetworkApiResponse;
import com.checkout.tokenization.model.GooglePayTokenRequest;
import com.checkout.tokenization.response.TokenDetailsResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.checkout.tokenization.repository.TokenRepositoryImpl$sendGooglePayTokenRequest$1", f = "TokenRepositoryImpl.kt", i = {0}, l = {92}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class TokenRepositoryImpl$sendGooglePayTokenRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GooglePayTokenRequest $googlePayTokenRequest;
    final /* synthetic */ Ref.ObjectRef<NetworkApiResponse<TokenDetailsResponse>> $response;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TokenRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenRepositoryImpl$sendGooglePayTokenRequest$1(TokenRepositoryImpl tokenRepositoryImpl, GooglePayTokenRequest googlePayTokenRequest, Ref.ObjectRef<NetworkApiResponse<TokenDetailsResponse>> objectRef, Continuation<? super TokenRepositoryImpl$sendGooglePayTokenRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = tokenRepositoryImpl;
        this.$googlePayTokenRequest = googlePayTokenRequest;
        this.$response = objectRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TokenRepositoryImpl$sendGooglePayTokenRequest$1 tokenRepositoryImpl$sendGooglePayTokenRequest$1 = new TokenRepositoryImpl$sendGooglePayTokenRequest$1(this.this$0, this.$googlePayTokenRequest, this.$response, continuation);
        tokenRepositoryImpl$sendGooglePayTokenRequest$1.L$0 = obj;
        return tokenRepositoryImpl$sendGooglePayTokenRequest$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TokenRepositoryImpl$sendGooglePayTokenRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull T r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 1
            java.lang.String r3 = "googlepay"
            if (r1 == 0) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            java.lang.Object r0 = r10.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x0076 }
            goto L_0x005f
        L_0x0019:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.checkout.tokenization.request.GooglePayTokenNetworkRequest r11 = new com.checkout.tokenization.request.GooglePayTokenNetworkRequest     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.repository.TokenRepositoryImpl r4 = r10.this$0     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.model.GooglePayTokenRequest r5 = r10.$googlePayTokenRequest     // Catch:{ Exception -> 0x0076 }
            java.lang.String r5 = r5.getTokenJsonPayload()     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.entity.GooglePayEntity r4 = r4.creatingTokenData(r5)     // Catch:{ Exception -> 0x0076 }
            r11.<init>(r3, r4)     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.repository.TokenRepositoryImpl r4 = r10.this$0     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.logging.TokenizationLogger r4 = r4.logger     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.repository.TokenRepositoryImpl r5 = r10.this$0     // Catch:{ Exception -> 0x0076 }
            java.lang.String r5 = r5.publicKey     // Catch:{ Exception -> 0x0076 }
            r4.logTokenRequestEvent(r3, r5)     // Catch:{ Exception -> 0x0076 }
            kotlin.jvm.internal.Ref$ObjectRef<com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r4 = r10.$response     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.repository.TokenRepositoryImpl r5 = r10.this$0     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.NetworkApiClient r5 = r5.networkApiClient     // Catch:{ Exception -> 0x0076 }
            r10.L$0 = r1     // Catch:{ Exception -> 0x0076 }
            r10.L$1 = r4     // Catch:{ Exception -> 0x0076 }
            r10.label = r2     // Catch:{ Exception -> 0x0076 }
            java.lang.Object r11 = r5.sendGooglePayTokenRequest(r11, r10)     // Catch:{ Exception -> 0x0076 }
            if (r11 != r0) goto L_0x005e
            return r0
        L_0x005e:
            r0 = r4
        L_0x005f:
            r0.element = r11     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.repository.TokenRepositoryImpl r11 = r10.this$0     // Catch:{ Exception -> 0x0076 }
            kotlin.jvm.internal.Ref$ObjectRef<com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r0 = r10.$response     // Catch:{ Exception -> 0x0076 }
            T r0 = r0.element     // Catch:{ Exception -> 0x0076 }
            com.checkout.network.response.NetworkApiResponse r0 = (com.checkout.network.response.NetworkApiResponse) r0     // Catch:{ Exception -> 0x0076 }
            r11.logResponse(r0, r3)     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.repository.TokenRepositoryImpl r11 = r10.this$0     // Catch:{ Exception -> 0x0076 }
            com.checkout.tokenization.logging.TokenizationLogger r11 = r11.logger     // Catch:{ Exception -> 0x0076 }
            r11.resetSession()     // Catch:{ Exception -> 0x0076 }
            goto L_0x009e
        L_0x0076:
            r11 = move-exception
            com.checkout.tokenization.error.TokenizationError r0 = new com.checkout.tokenization.error.TokenizationError
            java.lang.String r2 = r11.getMessage()
            java.lang.Throwable r11 = r11.getCause()
            java.lang.String r4 = "TokenizationError.Server:3005"
            r0.<init>(r4, r2, r11)
            kotlin.jvm.internal.Ref$ObjectRef<com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r11 = r10.$response
            com.checkout.network.response.NetworkApiResponse$InternalError r2 = new com.checkout.network.response.NetworkApiResponse$InternalError
            r2.<init>(r0)
            r11.element = r2
            com.checkout.tokenization.repository.TokenRepositoryImpl r11 = r10.this$0
            com.checkout.tokenization.logging.TokenizationLogger r11 = r11.logger
            com.checkout.tokenization.repository.TokenRepositoryImpl r2 = r10.this$0
            java.lang.String r2 = r2.publicKey
            r11.logErrorOnTokenRequestedEvent(r3, r2, r0)
        L_0x009e:
            r4 = r1
            com.checkout.tokenization.repository.TokenRepositoryImpl r11 = r10.this$0
            com.checkout.tokenization.mapper.TokenizationNetworkDataMapper r11 = r11.cardTokenizationNetworkDataMapper
            kotlin.jvm.internal.Ref$ObjectRef<com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r0 = r10.$response
            T r0 = r0.element
            com.checkout.network.response.NetworkApiResponse r0 = (com.checkout.network.response.NetworkApiResponse) r0
            com.checkout.tokenization.model.TokenResult r11 = r11.toTokenResult(r0)
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            r6 = 0
            com.checkout.tokenization.repository.TokenRepositoryImpl$sendGooglePayTokenRequest$1$1 r7 = new com.checkout.tokenization.repository.TokenRepositoryImpl$sendGooglePayTokenRequest$1$1
            com.checkout.tokenization.repository.TokenRepositoryImpl r0 = r10.this$0
            com.checkout.tokenization.model.GooglePayTokenRequest r1 = r10.$googlePayTokenRequest
            r2 = 0
            r7.<init>(r0, r11, r1, r2)
            r8 = 2
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.tokenization.repository.TokenRepositoryImpl$sendGooglePayTokenRequest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
