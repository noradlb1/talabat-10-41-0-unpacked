package com.talabat.feature.tokenization.domain.exception;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bR\u001b\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tokenization/domain/exception/TokenizationTokenGenerationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "requestId", "", "errorType", "errorCodes", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getErrorCodes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getErrorType", "()Ljava/lang/String;", "getRequestId", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizationTokenGenerationException extends Exception {
    @NotNull
    private final String[] errorCodes;
    @NotNull
    private final String errorType;
    @NotNull
    private final String requestId;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TokenizationTokenGenerationException(@org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.NotNull java.lang.String[] r13) {
        /*
            r10 = this;
            java.lang.String r0 = "requestId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "errorType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "errorCodes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 63
            r9 = 0
            r1 = r13
            java.lang.String r0 = kotlin.collections.ArraysKt___ArraysKt.joinToString$default((java.lang.Object[]) r1, (java.lang.CharSequence) r2, (java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (int) r5, (java.lang.CharSequence) r6, (kotlin.jvm.functions.Function1) r7, (int) r8, (java.lang.Object) r9)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Request id: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r2 = ", Error Type: "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = ", Error Codes: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r10.<init>(r0)
            r10.requestId = r11
            r10.errorType = r12
            r10.errorCodes = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tokenization.domain.exception.TokenizationTokenGenerationException.<init>(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @NotNull
    public final String[] getErrorCodes() {
        return this.errorCodes;
    }

    @NotNull
    public final String getErrorType() {
        return this.errorType;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }
}
