package com.talabat.talabatcommon.network;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004HÆ\u0003J!\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u000eHÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/network/GenericApiErrorResponse;", "EB", "", "errors", "", "(Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "getErrorMessage", "", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GenericApiErrorResponse<EB> {
    @Nullable
    private final List<EB> errors;

    public GenericApiErrorResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public GenericApiErrorResponse(@Nullable List<? extends EB> list) {
        this.errors = list;
    }

    public static /* synthetic */ GenericApiErrorResponse copy$default(GenericApiErrorResponse genericApiErrorResponse, List<EB> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = genericApiErrorResponse.errors;
        }
        return genericApiErrorResponse.copy(list);
    }

    @Nullable
    public final List<EB> component1() {
        return this.errors;
    }

    @NotNull
    public final GenericApiErrorResponse<EB> copy(@Nullable List<? extends EB> list) {
        return new GenericApiErrorResponse<>(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GenericApiErrorResponse) && Intrinsics.areEqual((Object) this.errors, (Object) ((GenericApiErrorResponse) obj).errors);
    }

    @NotNull
    public final String getErrorMessage() throws UnknownError {
        boolean z11;
        Collection collection = this.errors;
        if (collection == null || collection.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            throw new UnknownError("Unexpected error body");
        } else if (this.errors.get(0) instanceof String) {
            EB eb2 = this.errors.get(0);
            if (eb2 != null) {
                return (String) eb2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (this.errors.get(0) instanceof LinkedTreeMap) {
            EB eb3 = this.errors.get(0);
            if (eb3 != null) {
                String str = (String) ((LinkedTreeMap) eb3).get(ProductAction.ACTION_DETAIL);
                if (str == null) {
                    return "";
                }
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<kotlin.String, kotlin.String>");
        } else {
            throw new UnknownError("Unexpected error body");
        }
    }

    @Nullable
    public final List<EB> getErrors() {
        return this.errors;
    }

    public int hashCode() {
        List<EB> list = this.errors;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<EB> list = this.errors;
        return "GenericApiErrorResponse(errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GenericApiErrorResponse(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }
}
