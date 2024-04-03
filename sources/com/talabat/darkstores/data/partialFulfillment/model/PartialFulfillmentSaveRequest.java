package com.talabat.darkstores.data.partialFulfillment.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/data/partialFulfillment/model/PartialFulfillmentSaveRequest;", "", "code", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PartialFulfillmentSaveRequest {
    @NotNull
    private final String code;
    @NotNull
    private final String value;

    public PartialFulfillmentSaveRequest() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public PartialFulfillmentSaveRequest(@NotNull @Json(name = "code") String str, @NotNull @Json(name = "value") String str2) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "value");
        this.code = str;
        this.value = str2;
    }

    public static /* synthetic */ PartialFulfillmentSaveRequest copy$default(PartialFulfillmentSaveRequest partialFulfillmentSaveRequest, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = partialFulfillmentSaveRequest.code;
        }
        if ((i11 & 2) != 0) {
            str2 = partialFulfillmentSaveRequest.value;
        }
        return partialFulfillmentSaveRequest.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.value;
    }

    @NotNull
    public final PartialFulfillmentSaveRequest copy(@NotNull @Json(name = "code") String str, @NotNull @Json(name = "value") String str2) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "value");
        return new PartialFulfillmentSaveRequest(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialFulfillmentSaveRequest)) {
            return false;
        }
        PartialFulfillmentSaveRequest partialFulfillmentSaveRequest = (PartialFulfillmentSaveRequest) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) partialFulfillmentSaveRequest.code) && Intrinsics.areEqual((Object) this.value, (Object) partialFulfillmentSaveRequest.value);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.code.hashCode() * 31) + this.value.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.code;
        String str2 = this.value;
        return "PartialFulfillmentSaveRequest(code=" + str + ", value=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PartialFulfillmentSaveRequest(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2);
    }
}
