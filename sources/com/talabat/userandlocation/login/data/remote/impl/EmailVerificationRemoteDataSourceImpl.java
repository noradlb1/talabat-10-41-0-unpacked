package com.talabat.userandlocation.login.data.remote.impl;

import com.google.gson.Gson;
import com.talabat.authentication.aaa.GenericErrorBody;
import com.talabat.authentication.aaa.HttpExceptionExtensionsKt;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.userandlocation.login.data.model.EmailVerification;
import com.talabat.userandlocation.login.data.remote.EmailVerificationRemoteDataSource;
import com.talabat.userandlocation.login.data.remote.VerifyEmailRemoteDataException;
import com.talabat.userandlocation.login.data.remote.api.VerifyEmailApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0019\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/talabat/userandlocation/login/data/remote/impl/EmailVerificationRemoteDataSourceImpl;", "Lcom/talabat/userandlocation/login/data/remote/EmailVerificationRemoteDataSource;", "verifyEmailApi", "Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailApi;", "gson", "Lcom/google/gson/Gson;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/userandlocation/login/data/remote/api/VerifyEmailApi;Lcom/google/gson/Gson;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "handleError", "Lcom/talabat/userandlocation/login/data/model/EmailVerification;", "throwable", "", "observe", "", "verifyEmail", "email", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toEmailVerificationError", "Lcom/talabat/userandlocation/login/data/model/EmailVerification$Error;", "Lcom/talabat/authentication/aaa/GenericErrorBody;", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EmailVerificationRemoteDataSourceImpl implements EmailVerificationRemoteDataSource {
    @NotNull
    private final Gson gson;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final VerifyEmailApi verifyEmailApi;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GenericErrorBody.Data.ExceptionType.values().length];
            iArr[GenericErrorBody.Data.ExceptionType.OAUTH_FAILED_EXCEPTION.ordinal()] = 1;
            iArr[GenericErrorBody.Data.ExceptionType.INVALID_EMAIL.ordinal()] = 2;
            iArr[GenericErrorBody.Data.ExceptionType.SOCIAL_LOGIN_USER_NOT_FOUND.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EmailVerificationRemoteDataSourceImpl(@NotNull VerifyEmailApi verifyEmailApi2, @NotNull Gson gson2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(verifyEmailApi2, "verifyEmailApi");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.verifyEmailApi = verifyEmailApi2;
        this.gson = gson2;
        this.observabilityManager = iObservabilityManager;
    }

    private final EmailVerification handleError(Throwable th2) {
        Object obj;
        if (th2 instanceof HttpException) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m6329constructorimpl(HttpExceptionExtensionsKt.tryParseGenericErrorBodyOrThrow((HttpException) th2, this.gson));
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th3));
            }
            Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
            if (r02 == null) {
                return toEmailVerificationError((GenericErrorBody) obj);
            }
            throw new VerifyEmailRemoteDataException((String) null, r02, 1, (DefaultConstructorMarker) null);
        }
        throw new VerifyEmailRemoteDataException((String) null, th2, 1, (DefaultConstructorMarker) null);
    }

    private final void observe(Throwable th2) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        iObservabilityManager.trackUnExpectedScenario("EmailVerificationRemoteDataSourceImplErrors", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    private final EmailVerification.Error toEmailVerificationError(GenericErrorBody genericErrorBody) {
        String str;
        GenericErrorBody.Data.ExceptionType exceptionType;
        int i11;
        GenericErrorBody.Data data = genericErrorBody.getData();
        EmailVerification.Error.ErrorType errorType = null;
        if (data != null) {
            str = data.getExceptionMessage();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        GenericErrorBody.Data data2 = genericErrorBody.getData();
        if (data2 != null) {
            exceptionType = data2.getExceptionType();
        } else {
            exceptionType = null;
        }
        if (exceptionType == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[exceptionType.ordinal()];
        }
        if (i11 != -1) {
            if (i11 == 1) {
                errorType = EmailVerification.Error.ErrorType.OAUTH_OAUTH_FAILED_EXCEPTION;
            } else if (i11 == 2) {
                errorType = EmailVerification.Error.ErrorType.INVALID_EMAIL;
            } else if (i11 == 3) {
                errorType = EmailVerification.Error.ErrorType.INVALID_EMAIL;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return new EmailVerification.Error(str, errorType);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object verifyEmail(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.userandlocation.login.data.model.EmailVerification> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl$verifyEmail$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl$verifyEmail$1 r0 = (com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl$verifyEmail$1) r0
            int r1 = r0.f12342k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12342k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl$verifyEmail$1 r0 = new com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl$verifyEmail$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12340i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12342k
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f12339h
            com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl r5 = (com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002d }
            goto L_0x004f
        L_0x002d:
            r6 = move-exception
            goto L_0x0058
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x0056 }
            com.talabat.userandlocation.login.data.remote.api.VerifyEmailApi r6 = r4.verifyEmailApi     // Catch:{ all -> 0x0056 }
            com.talabat.userandlocation.login.data.remote.api.VerifyEmailRequest r2 = new com.talabat.userandlocation.login.data.remote.api.VerifyEmailRequest     // Catch:{ all -> 0x0056 }
            r2.<init>(r5)     // Catch:{ all -> 0x0056 }
            r0.f12339h = r4     // Catch:{ all -> 0x0056 }
            r0.f12342k = r3     // Catch:{ all -> 0x0056 }
            java.lang.Object r6 = r6.verifyEmail(r2, r0)     // Catch:{ all -> 0x0056 }
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r5 = r4
        L_0x004f:
            com.talabat.userandlocation.login.data.remote.api.VerifyEmailResponse r6 = (com.talabat.userandlocation.login.data.remote.api.VerifyEmailResponse) r6     // Catch:{ all -> 0x002d }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x002d }
            goto L_0x0062
        L_0x0056:
            r6 = move-exception
            r5 = r4
        L_0x0058:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0062:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r0 != 0) goto L_0x00af
            com.talabat.userandlocation.login.data.remote.api.VerifyEmailResponse r6 = (com.talabat.userandlocation.login.data.remote.api.VerifyEmailResponse) r6
            com.talabat.userandlocation.login.data.model.EmailVerification$Data r5 = new com.talabat.userandlocation.login.data.model.EmailVerification$Data
            com.talabat.userandlocation.login.data.remote.api.VerifyEmailResponse$Data r0 = r6.getData()
            r1 = 0
            if (r0 == 0) goto L_0x0078
            java.lang.Boolean r0 = r0.isKnown()
            goto L_0x0079
        L_0x0078:
            r0 = r1
        L_0x0079:
            boolean r0 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r0)
            com.talabat.userandlocation.login.data.remote.api.VerifyEmailResponse$Data r2 = r6.getData()
            if (r2 == 0) goto L_0x0088
            java.lang.Boolean r2 = r2.isB2BCustomer()
            goto L_0x0089
        L_0x0088:
            r2 = r1
        L_0x0089:
            boolean r2 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r2)
            com.talabat.userandlocation.login.data.remote.api.VerifyEmailResponse$Data r3 = r6.getData()
            if (r3 == 0) goto L_0x0098
            java.lang.Boolean r3 = r3.getHasSocialLogin()
            goto L_0x0099
        L_0x0098:
            r3 = r1
        L_0x0099:
            boolean r3 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r3)
            com.talabat.userandlocation.login.data.remote.api.VerifyEmailResponse$Data r6 = r6.getData()
            if (r6 == 0) goto L_0x00a7
            java.lang.Boolean r1 = r6.getHasPassword()
        L_0x00a7:
            boolean r6 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r1)
            r5.<init>(r0, r2, r3, r6)
            goto L_0x00b6
        L_0x00af:
            r5.observe(r0)
            com.talabat.userandlocation.login.data.model.EmailVerification r5 = r5.handleError(r0)
        L_0x00b6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl.verifyEmail(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
