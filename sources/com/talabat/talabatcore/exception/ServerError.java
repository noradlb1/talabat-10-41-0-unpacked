package com.talabat.talabatcore.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcore/exception/ServerError;", "Lcom/talabat/talabatcore/exception/Failure;", "code", "", "message", "", "body", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBody", "()Ljava/lang/String;", "setBody", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMessage", "setMessage", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ServerError extends Failure {
    @Nullable
    private String body;
    @Nullable
    private Integer code;
    @NotNull
    private String message;

    public ServerError() {
        this((Integer) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServerError(Integer num, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? null : str2);
    }

    @Nullable
    public final String getBody() {
        return this.body;
    }

    @Nullable
    public final Integer getCode() {
        return this.code;
    }

    @NotNull
    public String getMessage() {
        return this.message;
    }

    public final void setBody(@Nullable String str) {
        this.body = str;
    }

    public final void setCode(@Nullable Integer num) {
        this.code = num;
    }

    public void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public ServerError(@Nullable Integer num, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.code = num;
        this.message = str;
        this.body = str2;
    }
}
