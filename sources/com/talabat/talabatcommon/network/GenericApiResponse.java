package com.talabat.talabatcommon.network;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000f\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/network/GenericApiResponse;", "T", "", "result", "errors", "", "warnings", "(Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "getErrors", "()[Ljava/lang/Object;", "setErrors", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getWarnings", "setWarnings", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class GenericApiResponse<T> {
    @Nullable
    private Object[] errors;
    @Nullable
    private T result;
    @Nullable
    private Object[] warnings;

    public GenericApiResponse() {
        this((Object) null, (Object[]) null, (Object[]) null, 7, (DefaultConstructorMarker) null);
    }

    public GenericApiResponse(@Nullable T t11, @Nullable Object[] objArr, @Nullable Object[] objArr2) {
        this.result = t11;
        this.errors = objArr;
        this.warnings = objArr2;
    }

    @Nullable
    public final Object[] getErrors() {
        return this.errors;
    }

    @Nullable
    public final T getResult() {
        return this.result;
    }

    @Nullable
    public final Object[] getWarnings() {
        return this.warnings;
    }

    public final void setErrors(@Nullable Object[] objArr) {
        this.errors = objArr;
    }

    public final void setResult(@Nullable T t11) {
        this.result = t11;
    }

    public final void setWarnings(@Nullable Object[] objArr) {
        this.warnings = objArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GenericApiResponse(Object obj, Object[] objArr, Object[] objArr2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : obj, (i11 & 2) != 0 ? null : objArr, (i11 & 4) != 0 ? null : objArr2);
    }
}
