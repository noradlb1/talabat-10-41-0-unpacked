package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"LJsonModels/Response/OrderRatingDetailsError;", "", "errorCode", "", "title", "message", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getMessage", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderRatingDetailsError {
    @SerializedName("err_code")
    @Nullable
    private final String errorCode;
    @SerializedName("msg")
    @Nullable
    private final String message;
    @SerializedName("title")
    @Nullable
    private final String title;

    public OrderRatingDetailsError() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public OrderRatingDetailsError(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.errorCode = str;
        this.title = str2;
        this.message = str3;
    }

    public static /* synthetic */ OrderRatingDetailsError copy$default(OrderRatingDetailsError orderRatingDetailsError, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = orderRatingDetailsError.errorCode;
        }
        if ((i11 & 2) != 0) {
            str2 = orderRatingDetailsError.title;
        }
        if ((i11 & 4) != 0) {
            str3 = orderRatingDetailsError.message;
        }
        return orderRatingDetailsError.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.errorCode;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.message;
    }

    @NotNull
    public final OrderRatingDetailsError copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new OrderRatingDetailsError(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderRatingDetailsError)) {
            return false;
        }
        OrderRatingDetailsError orderRatingDetailsError = (OrderRatingDetailsError) obj;
        return Intrinsics.areEqual((Object) this.errorCode, (Object) orderRatingDetailsError.errorCode) && Intrinsics.areEqual((Object) this.title, (Object) orderRatingDetailsError.title) && Intrinsics.areEqual((Object) this.message, (Object) orderRatingDetailsError.message);
    }

    @Nullable
    public final String getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.errorCode;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.message;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.errorCode;
        String str2 = this.title;
        String str3 = this.message;
        return "OrderRatingDetailsError(errorCode=" + str + ", title=" + str2 + ", message=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderRatingDetailsError(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }
}
