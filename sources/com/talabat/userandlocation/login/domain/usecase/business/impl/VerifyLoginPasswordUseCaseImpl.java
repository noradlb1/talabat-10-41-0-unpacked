package com.talabat.userandlocation.login.domain.usecase.business.impl;

import com.talabat.authentication.authenticate.domain.model.PasswordAuthentication;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase;
import com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/impl/VerifyLoginPasswordUseCaseImpl;", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "authenticationRepository", "Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;", "refreshCustomerInformationUseCase", "Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;Lcom/talabat/userandlocation/login/domain/usecase/business/RefreshCustomerInformationUseCase;)V", "refreshCustomerInfo", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAuthenticateWithPassword", "Lcom/talabat/userandlocation/login/domain/usecase/business/VerifyLoginPasswordUseCase$Result;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyLoginPassword", "Companion", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyLoginPasswordUseCaseImpl implements VerifyLoginPasswordUseCase {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int MIN_PASSWORD_LENGTH = 6;
    @NotNull
    private final AuthenticationRepository authenticationRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @Nullable
    private final RefreshCustomerInformationUseCase refreshCustomerInformationUseCase;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/userandlocation/login/domain/usecase/business/impl/VerifyLoginPasswordUseCaseImpl$Companion;", "", "()V", "MIN_PASSWORD_LENGTH", "", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PasswordAuthentication.Error.Type.values().length];
            iArr[PasswordAuthentication.Error.Type.INVALID_CREDENTIALS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VerifyLoginPasswordUseCaseImpl(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull AuthenticationRepository authenticationRepository2, @Nullable RefreshCustomerInformationUseCase refreshCustomerInformationUseCase2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(authenticationRepository2, "authenticationRepository");
        this.dispatcher = coroutineDispatcher;
        this.authenticationRepository = authenticationRepository2;
        this.refreshCustomerInformationUseCase = refreshCustomerInformationUseCase2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refreshCustomerInfo(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$refreshCustomerInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$refreshCustomerInfo$1 r0 = (com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$refreshCustomerInfo$1) r0
            int r1 = r0.f12374j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12374j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$refreshCustomerInfo$1 r0 = new com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$refreshCustomerInfo$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12372h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12374j
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r4) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0042
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase r6 = r5.refreshCustomerInformationUseCase
            if (r6 == 0) goto L_0x0045
            r0.f12374j = r4
            java.lang.Object r6 = r6.refreshCustomerInformation(r0)
            if (r6 != r1) goto L_0x0042
            return r1
        L_0x0042:
            com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase$Result r6 = (com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase.Result) r6
            goto L_0x0046
        L_0x0045:
            r6 = r3
        L_0x0046:
            com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase$Result$Failed r0 = com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase.Result.Failed.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0054
            java.lang.String r6 = "Couldn't refresh customer info"
            com.talabat.talabatcore.logger.LogManager.error$default(r3, r6, r4, r3)
            goto L_0x0061
        L_0x0054:
            com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase$Result$Success r0 = com.talabat.userandlocation.login.domain.usecase.business.RefreshCustomerInformationUseCase.Result.Success.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            if (r6 == 0) goto L_0x0061
            java.lang.String r6 = "Customer info refreshed successfully"
            com.talabat.talabatcore.logger.LogManager.debug(r6)
        L_0x0061:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl.refreshCustomerInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object tryAuthenticateWithPassword(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase.Result> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$tryAuthenticateWithPassword$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$tryAuthenticateWithPassword$1 r0 = (com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$tryAuthenticateWithPassword$1) r0
            int r1 = r0.f12377j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12377j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$tryAuthenticateWithPassword$1 r0 = new com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl$tryAuthenticateWithPassword$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f12375h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12377j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x007a }
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository r7 = r4.authenticationRepository     // Catch:{ all -> 0x007a }
            r0.f12377j = r3     // Catch:{ all -> 0x007a }
            java.lang.Object r7 = r7.authenticateWithPassword(r5, r6, r0)     // Catch:{ all -> 0x007a }
            if (r7 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.talabat.authentication.authenticate.domain.model.PasswordAuthentication r7 = (com.talabat.authentication.authenticate.domain.model.PasswordAuthentication) r7     // Catch:{ all -> 0x007a }
            boolean r5 = r7 instanceof com.talabat.authentication.authenticate.domain.model.PasswordAuthentication.Error     // Catch:{ all -> 0x007a }
            if (r5 == 0) goto L_0x0069
            r5 = r7
            com.talabat.authentication.authenticate.domain.model.PasswordAuthentication$Error r5 = (com.talabat.authentication.authenticate.domain.model.PasswordAuthentication.Error) r5     // Catch:{ all -> 0x007a }
            com.talabat.authentication.authenticate.domain.model.PasswordAuthentication$Error$Type r5 = r5.getType()     // Catch:{ all -> 0x007a }
            if (r5 != 0) goto L_0x0050
            r5 = -1
            goto L_0x0058
        L_0x0050:
            int[] r6 = com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x007a }
            int r5 = r5.ordinal()     // Catch:{ all -> 0x007a }
            r5 = r6[r5]     // Catch:{ all -> 0x007a }
        L_0x0058:
            if (r5 != r3) goto L_0x005d
            com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase$Result$InvalidCredentials r5 = com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase.Result.InvalidCredentials.INSTANCE     // Catch:{ all -> 0x007a }
            goto L_0x0081
        L_0x005d:
            com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase$Result$Error r5 = new com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase$Result$Error     // Catch:{ all -> 0x007a }
            com.talabat.authentication.authenticate.domain.model.PasswordAuthentication$Error r7 = (com.talabat.authentication.authenticate.domain.model.PasswordAuthentication.Error) r7     // Catch:{ all -> 0x007a }
            java.lang.String r6 = r7.getMessage()     // Catch:{ all -> 0x007a }
            r5.<init>(r6)     // Catch:{ all -> 0x007a }
            goto L_0x0081
        L_0x0069:
            com.talabat.authentication.authenticate.domain.model.PasswordAuthentication$Success r5 = com.talabat.authentication.authenticate.domain.model.PasswordAuthentication.Success.INSTANCE     // Catch:{ all -> 0x007a }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r5)     // Catch:{ all -> 0x007a }
            if (r5 == 0) goto L_0x0074
            com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase$Result$Success r5 = com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase.Result.Success.INSTANCE     // Catch:{ all -> 0x007a }
            goto L_0x0081
        L_0x0074:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x007a }
            r5.<init>()     // Catch:{ all -> 0x007a }
            throw r5     // Catch:{ all -> 0x007a }
        L_0x007a:
            com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase$Result$Error r5 = new com.talabat.userandlocation.login.domain.usecase.business.VerifyLoginPasswordUseCase$Result$Error
            java.lang.String r6 = ""
            r5.<init>(r6)
        L_0x0081:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.login.domain.usecase.business.impl.VerifyLoginPasswordUseCaseImpl.tryAuthenticateWithPassword(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object verifyLoginPassword(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super VerifyLoginPasswordUseCase.Result> continuation) {
        return BuildersKt.withContext(this.dispatcher, new VerifyLoginPasswordUseCaseImpl$verifyLoginPassword$2(str2, this, str, (Continuation<? super VerifyLoginPasswordUseCaseImpl$verifyLoginPassword$2>) null), continuation);
    }
}
