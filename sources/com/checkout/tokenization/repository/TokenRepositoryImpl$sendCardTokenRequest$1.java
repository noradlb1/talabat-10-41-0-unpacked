package com.checkout.tokenization.repository;

import com.checkout.network.response.NetworkApiResponse;
import com.checkout.tokenization.model.CardTokenRequest;
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
@DebugMetadata(c = "com.checkout.tokenization.repository.TokenRepositoryImpl$sendCardTokenRequest$1", f = "TokenRepositoryImpl.kt", i = {0}, l = {62}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class TokenRepositoryImpl$sendCardTokenRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardTokenRequest $cardTokenRequest;
    final /* synthetic */ Ref.ObjectRef<NetworkApiResponse<TokenDetailsResponse>> $response;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TokenRepositoryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenRepositoryImpl$sendCardTokenRequest$1(TokenRepositoryImpl tokenRepositoryImpl, CardTokenRequest cardTokenRequest, Ref.ObjectRef<NetworkApiResponse<TokenDetailsResponse>> objectRef, Continuation<? super TokenRepositoryImpl$sendCardTokenRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = tokenRepositoryImpl;
        this.$cardTokenRequest = cardTokenRequest;
        this.$response = objectRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TokenRepositoryImpl$sendCardTokenRequest$1 tokenRepositoryImpl$sendCardTokenRequest$1 = new TokenRepositoryImpl$sendCardTokenRequest$1(this.this$0, this.$cardTokenRequest, this.$response, continuation);
        tokenRepositoryImpl$sendCardTokenRequest$1.L$0 = obj;
        return tokenRepositoryImpl$sendCardTokenRequest$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TokenRepositoryImpl$sendCardTokenRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull T r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            java.lang.String r2 = "card"
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 != r3) goto L_0x001a
            java.lang.Object r0 = r8.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x008d
        L_0x001a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r1 = r9
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.checkout.tokenization.repository.TokenRepositoryImpl r9 = r8.this$0
            com.checkout.base.usecase.UseCase r9 = r9.validateTokenizationDataUseCase
            com.checkout.tokenization.model.CardTokenRequest r4 = r8.$cardTokenRequest
            com.checkout.tokenization.model.Card r4 = r4.getCard()
            java.lang.Object r9 = r9.execute(r4)
            com.checkout.validation.model.ValidationResult r9 = (com.checkout.validation.model.ValidationResult) r9
            boolean r4 = r9 instanceof com.checkout.validation.model.ValidationResult.Failure
            if (r4 == 0) goto L_0x0051
            kotlin.jvm.internal.Ref$ObjectRef<com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r0 = r8.$response
            com.checkout.network.response.NetworkApiResponse$InternalError r2 = new com.checkout.network.response.NetworkApiResponse$InternalError
            com.checkout.validation.model.ValidationResult$Failure r9 = (com.checkout.validation.model.ValidationResult.Failure) r9
            com.checkout.base.error.CheckoutError r9 = r9.getError()
            r2.<init>(r9)
            r0.element = r2
        L_0x004f:
            r2 = r1
            goto L_0x00a4
        L_0x0051:
            boolean r9 = r9 instanceof com.checkout.validation.model.ValidationResult.Success
            if (r9 == 0) goto L_0x00cb
            com.checkout.tokenization.repository.TokenRepositoryImpl r9 = r8.this$0
            com.checkout.tokenization.logging.TokenizationLogger r9 = r9.logger
            com.checkout.tokenization.repository.TokenRepositoryImpl r4 = r8.this$0
            java.lang.String r4 = r4.publicKey
            r9.logTokenRequestEvent(r2, r4)
            kotlin.jvm.internal.Ref$ObjectRef<com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r9 = r8.$response
            com.checkout.tokenization.repository.TokenRepositoryImpl r4 = r8.this$0
            com.checkout.tokenization.NetworkApiClient r4 = r4.networkApiClient
            com.checkout.tokenization.repository.TokenRepositoryImpl r5 = r8.this$0
            com.checkout.base.mapper.Mapper r5 = r5.cardToTokenRequestMapper
            com.checkout.tokenization.model.CardTokenRequest r6 = r8.$cardTokenRequest
            com.checkout.tokenization.model.Card r6 = r6.getCard()
            java.lang.Object r5 = r5.map(r6)
            com.checkout.tokenization.request.TokenRequest r5 = (com.checkout.tokenization.request.TokenRequest) r5
            r8.L$0 = r1
            r8.L$1 = r9
            r8.label = r3
            java.lang.Object r3 = r4.sendCardTokenRequest(r5, r8)
            if (r3 != r0) goto L_0x008b
            return r0
        L_0x008b:
            r0 = r9
            r9 = r3
        L_0x008d:
            r0.element = r9
            com.checkout.tokenization.repository.TokenRepositoryImpl r9 = r8.this$0
            kotlin.jvm.internal.Ref$ObjectRef<com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r0 = r8.$response
            T r0 = r0.element
            com.checkout.network.response.NetworkApiResponse r0 = (com.checkout.network.response.NetworkApiResponse) r0
            r9.logResponse(r0, r2)
            com.checkout.tokenization.repository.TokenRepositoryImpl r9 = r8.this$0
            com.checkout.tokenization.logging.TokenizationLogger r9 = r9.logger
            r9.resetSession()
            goto L_0x004f
        L_0x00a4:
            com.checkout.tokenization.repository.TokenRepositoryImpl r9 = r8.this$0
            com.checkout.tokenization.mapper.TokenizationNetworkDataMapper r9 = r9.cardTokenizationNetworkDataMapper
            kotlin.jvm.internal.Ref$ObjectRef<com.checkout.network.response.NetworkApiResponse<com.checkout.tokenization.response.TokenDetailsResponse>> r0 = r8.$response
            T r0 = r0.element
            com.checkout.network.response.NetworkApiResponse r0 = (com.checkout.network.response.NetworkApiResponse) r0
            com.checkout.tokenization.model.TokenResult r9 = r9.toTokenResult(r0)
            kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
            r4 = 0
            com.checkout.tokenization.repository.TokenRepositoryImpl$sendCardTokenRequest$1$1 r5 = new com.checkout.tokenization.repository.TokenRepositoryImpl$sendCardTokenRequest$1$1
            com.checkout.tokenization.repository.TokenRepositoryImpl r0 = r8.this$0
            com.checkout.tokenization.model.CardTokenRequest r1 = r8.$cardTokenRequest
            r6 = 0
            r5.<init>(r0, r9, r1, r6)
            r6 = 2
            r7 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00cb:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.tokenization.repository.TokenRepositoryImpl$sendCardTokenRequest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
