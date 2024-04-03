package library.talabat.mvp.placeorder;

import com.android.volley.VolleyError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Llibrary/talabat/mvp/placeorder/PlaceOrderFailure;", "", "url", "", "request", "error", "Lcom/android/volley/VolleyError;", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/volley/VolleyError;)V", "getError", "()Lcom/android/volley/VolleyError;", "getRequest", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlaceOrderFailure {
    @Nullable
    private final VolleyError error;
    @Nullable
    private final String request;
    @Nullable
    private final String url;

    public PlaceOrderFailure(@Nullable String str, @Nullable String str2, @Nullable VolleyError volleyError) {
        this.url = str;
        this.request = str2;
        this.error = volleyError;
    }

    public static /* synthetic */ PlaceOrderFailure copy$default(PlaceOrderFailure placeOrderFailure, String str, String str2, VolleyError volleyError, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = placeOrderFailure.url;
        }
        if ((i11 & 2) != 0) {
            str2 = placeOrderFailure.request;
        }
        if ((i11 & 4) != 0) {
            volleyError = placeOrderFailure.error;
        }
        return placeOrderFailure.copy(str, str2, volleyError);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @Nullable
    public final String component2() {
        return this.request;
    }

    @Nullable
    public final VolleyError component3() {
        return this.error;
    }

    @NotNull
    public final PlaceOrderFailure copy(@Nullable String str, @Nullable String str2, @Nullable VolleyError volleyError) {
        return new PlaceOrderFailure(str, str2, volleyError);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceOrderFailure)) {
            return false;
        }
        PlaceOrderFailure placeOrderFailure = (PlaceOrderFailure) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) placeOrderFailure.url) && Intrinsics.areEqual((Object) this.request, (Object) placeOrderFailure.request) && Intrinsics.areEqual((Object) this.error, (Object) placeOrderFailure.error);
    }

    @Nullable
    public final VolleyError getError() {
        return this.error;
    }

    @Nullable
    public final String getRequest() {
        return this.request;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.request;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        VolleyError volleyError = this.error;
        if (volleyError != null) {
            i11 = volleyError.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.url;
        String str2 = this.request;
        VolleyError volleyError = this.error;
        return "PlaceOrderFailure(url=" + str + ", request=" + str2 + ", error=" + volleyError + ")";
    }
}
