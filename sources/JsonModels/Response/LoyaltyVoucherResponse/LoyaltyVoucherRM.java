package JsonModels.Response.LoyaltyVoucherResponse;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ8\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherRM;", "", "result", "LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherResult;", "errors", "", "", "isNotFound", "", "(LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherResult;Ljava/util/List;Ljava/lang/Boolean;)V", "getErrors", "()Ljava/util/List;", "setErrors", "(Ljava/util/List;)V", "()Ljava/lang/Boolean;", "setNotFound", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "title", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherResult;Ljava/util/List;Ljava/lang/Boolean;)LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherRM;", "equals", "other", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyVoucherRM {
    @SerializedName("errors")
    @Nullable
    private List<String> errors;
    @SerializedName("isNotFound")
    @Nullable
    private Boolean isNotFound;
    @SerializedName("result")
    @Nullable
    @JvmField
    public LoyaltyVoucherResult result;

    public LoyaltyVoucherRM() {
        this((LoyaltyVoucherResult) null, (List) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    public LoyaltyVoucherRM(@Nullable LoyaltyVoucherResult loyaltyVoucherResult, @Nullable List<String> list, @Nullable Boolean bool) {
        this.result = loyaltyVoucherResult;
        this.errors = list;
        this.isNotFound = bool;
    }

    public static /* synthetic */ LoyaltyVoucherRM copy$default(LoyaltyVoucherRM loyaltyVoucherRM, LoyaltyVoucherResult loyaltyVoucherResult, List<String> list, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            loyaltyVoucherResult = loyaltyVoucherRM.result;
        }
        if ((i11 & 2) != 0) {
            list = loyaltyVoucherRM.errors;
        }
        if ((i11 & 4) != 0) {
            bool = loyaltyVoucherRM.isNotFound;
        }
        return loyaltyVoucherRM.copy(loyaltyVoucherResult, list, bool);
    }

    @Nullable
    public final LoyaltyVoucherResult component1() {
        return this.result;
    }

    @Nullable
    public final List<String> component2() {
        return this.errors;
    }

    @Nullable
    public final Boolean component3() {
        return this.isNotFound;
    }

    @NotNull
    public final LoyaltyVoucherRM copy(@Nullable LoyaltyVoucherResult loyaltyVoucherResult, @Nullable List<String> list, @Nullable Boolean bool) {
        return new LoyaltyVoucherRM(loyaltyVoucherResult, list, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoyaltyVoucherRM)) {
            return false;
        }
        LoyaltyVoucherRM loyaltyVoucherRM = (LoyaltyVoucherRM) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) loyaltyVoucherRM.result) && Intrinsics.areEqual((Object) this.errors, (Object) loyaltyVoucherRM.errors) && Intrinsics.areEqual((Object) this.isNotFound, (Object) loyaltyVoucherRM.isNotFound);
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }

    @NotNull
    public final String getTitle() {
        boolean z11;
        LoyaltyVoucherResult loyaltyVoucherResult = this.result;
        if (loyaltyVoucherResult != null) {
            Intrinsics.checkNotNull(loyaltyVoucherResult);
            String title = loyaltyVoucherResult.getTitle();
            if (title == null || title.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                LoyaltyVoucherResult loyaltyVoucherResult2 = this.result;
                Intrinsics.checkNotNull(loyaltyVoucherResult2);
                return String.valueOf(loyaltyVoucherResult2.getTitle());
            }
        }
        return "";
    }

    public int hashCode() {
        LoyaltyVoucherResult loyaltyVoucherResult = this.result;
        int i11 = 0;
        int hashCode = (loyaltyVoucherResult == null ? 0 : loyaltyVoucherResult.hashCode()) * 31;
        List<String> list = this.errors;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.isNotFound;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isNotFound() {
        return this.isNotFound;
    }

    public final void setErrors(@Nullable List<String> list) {
        this.errors = list;
    }

    public final void setNotFound(@Nullable Boolean bool) {
        this.isNotFound = bool;
    }

    @NotNull
    public String toString() {
        LoyaltyVoucherResult loyaltyVoucherResult = this.result;
        List<String> list = this.errors;
        Boolean bool = this.isNotFound;
        return "LoyaltyVoucherRM(result=" + loyaltyVoucherResult + ", errors=" + list + ", isNotFound=" + bool + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoyaltyVoucherRM(JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult r15, java.util.List r16, java.lang.Boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r14 = this;
            r0 = r18 & 1
            if (r0 == 0) goto L_0x0018
            JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult r0 = new JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1023(0x3ff, float:1.434E-42)
            r13 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0019
        L_0x0018:
            r0 = r15
        L_0x0019:
            r1 = r18 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0020
            r1 = r2
            goto L_0x0022
        L_0x0020:
            r1 = r16
        L_0x0022:
            r3 = r18 & 4
            if (r3 == 0) goto L_0x0028
            r3 = r14
            goto L_0x002b
        L_0x0028:
            r3 = r14
            r2 = r17
        L_0x002b:
            r14.<init>(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM.<init>(JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult, java.util.List, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
