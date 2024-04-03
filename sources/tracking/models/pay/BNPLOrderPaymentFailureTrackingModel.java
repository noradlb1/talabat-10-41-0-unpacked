package tracking.models.pay;

import JsonModels.PolygonEvents;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Ltracking/models/pay/BNPLOrderPaymentFailureTrackingModel;", "", "paymentMethod", "", "errorMessage", "restaurant", "Ldatamodels/Restaurant;", "contactlessEnabled", "", "defaultPaymentMethod", "errorDetail", "errorCode", "polygonEvents", "LJsonModels/PolygonEvents;", "(Ljava/lang/String;Ljava/lang/String;Ldatamodels/Restaurant;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;LJsonModels/PolygonEvents;)V", "getContactlessEnabled", "()Z", "getDefaultPaymentMethod", "()Ljava/lang/String;", "getErrorCode", "getErrorDetail", "getErrorMessage", "getPaymentMethod", "getPolygonEvents", "()LJsonModels/PolygonEvents;", "getRestaurant", "()Ldatamodels/Restaurant;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLOrderPaymentFailureTrackingModel {
    private final boolean contactlessEnabled;
    @Nullable
    private final String defaultPaymentMethod;
    @Nullable
    private final String errorCode;
    @NotNull
    private final String errorDetail;
    @Nullable
    private final String errorMessage;
    @NotNull
    private final String paymentMethod;
    @Nullable
    private final PolygonEvents polygonEvents;
    @Nullable
    private final Restaurant restaurant;

    public BNPLOrderPaymentFailureTrackingModel(@NotNull String str, @Nullable String str2, @Nullable Restaurant restaurant2, boolean z11, @Nullable String str3, @NotNull String str4, @Nullable String str5, @Nullable PolygonEvents polygonEvents2) {
        Intrinsics.checkNotNullParameter(str, "paymentMethod");
        Intrinsics.checkNotNullParameter(str4, "errorDetail");
        this.paymentMethod = str;
        this.errorMessage = str2;
        this.restaurant = restaurant2;
        this.contactlessEnabled = z11;
        this.defaultPaymentMethod = str3;
        this.errorDetail = str4;
        this.errorCode = str5;
        this.polygonEvents = polygonEvents2;
    }

    public static /* synthetic */ BNPLOrderPaymentFailureTrackingModel copy$default(BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel, String str, String str2, Restaurant restaurant2, boolean z11, String str3, String str4, String str5, PolygonEvents polygonEvents2, int i11, Object obj) {
        BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel2 = bNPLOrderPaymentFailureTrackingModel;
        int i12 = i11;
        return bNPLOrderPaymentFailureTrackingModel.copy((i12 & 1) != 0 ? bNPLOrderPaymentFailureTrackingModel2.paymentMethod : str, (i12 & 2) != 0 ? bNPLOrderPaymentFailureTrackingModel2.errorMessage : str2, (i12 & 4) != 0 ? bNPLOrderPaymentFailureTrackingModel2.restaurant : restaurant2, (i12 & 8) != 0 ? bNPLOrderPaymentFailureTrackingModel2.contactlessEnabled : z11, (i12 & 16) != 0 ? bNPLOrderPaymentFailureTrackingModel2.defaultPaymentMethod : str3, (i12 & 32) != 0 ? bNPLOrderPaymentFailureTrackingModel2.errorDetail : str4, (i12 & 64) != 0 ? bNPLOrderPaymentFailureTrackingModel2.errorCode : str5, (i12 & 128) != 0 ? bNPLOrderPaymentFailureTrackingModel2.polygonEvents : polygonEvents2);
    }

    @NotNull
    public final String component1() {
        return this.paymentMethod;
    }

    @Nullable
    public final String component2() {
        return this.errorMessage;
    }

    @Nullable
    public final Restaurant component3() {
        return this.restaurant;
    }

    public final boolean component4() {
        return this.contactlessEnabled;
    }

    @Nullable
    public final String component5() {
        return this.defaultPaymentMethod;
    }

    @NotNull
    public final String component6() {
        return this.errorDetail;
    }

    @Nullable
    public final String component7() {
        return this.errorCode;
    }

    @Nullable
    public final PolygonEvents component8() {
        return this.polygonEvents;
    }

    @NotNull
    public final BNPLOrderPaymentFailureTrackingModel copy(@NotNull String str, @Nullable String str2, @Nullable Restaurant restaurant2, boolean z11, @Nullable String str3, @NotNull String str4, @Nullable String str5, @Nullable PolygonEvents polygonEvents2) {
        Intrinsics.checkNotNullParameter(str, "paymentMethod");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "errorDetail");
        return new BNPLOrderPaymentFailureTrackingModel(str, str2, restaurant2, z11, str3, str6, str5, polygonEvents2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLOrderPaymentFailureTrackingModel)) {
            return false;
        }
        BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel = (BNPLOrderPaymentFailureTrackingModel) obj;
        return Intrinsics.areEqual((Object) this.paymentMethod, (Object) bNPLOrderPaymentFailureTrackingModel.paymentMethod) && Intrinsics.areEqual((Object) this.errorMessage, (Object) bNPLOrderPaymentFailureTrackingModel.errorMessage) && Intrinsics.areEqual((Object) this.restaurant, (Object) bNPLOrderPaymentFailureTrackingModel.restaurant) && this.contactlessEnabled == bNPLOrderPaymentFailureTrackingModel.contactlessEnabled && Intrinsics.areEqual((Object) this.defaultPaymentMethod, (Object) bNPLOrderPaymentFailureTrackingModel.defaultPaymentMethod) && Intrinsics.areEqual((Object) this.errorDetail, (Object) bNPLOrderPaymentFailureTrackingModel.errorDetail) && Intrinsics.areEqual((Object) this.errorCode, (Object) bNPLOrderPaymentFailureTrackingModel.errorCode) && Intrinsics.areEqual((Object) this.polygonEvents, (Object) bNPLOrderPaymentFailureTrackingModel.polygonEvents);
    }

    public final boolean getContactlessEnabled() {
        return this.contactlessEnabled;
    }

    @Nullable
    public final String getDefaultPaymentMethod() {
        return this.defaultPaymentMethod;
    }

    @Nullable
    public final String getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getErrorDetail() {
        return this.errorDetail;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @Nullable
    public final PolygonEvents getPolygonEvents() {
        return this.polygonEvents;
    }

    @Nullable
    public final Restaurant getRestaurant() {
        return this.restaurant;
    }

    public int hashCode() {
        int hashCode = this.paymentMethod.hashCode() * 31;
        String str = this.errorMessage;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Restaurant restaurant2 = this.restaurant;
        int hashCode3 = (hashCode2 + (restaurant2 == null ? 0 : restaurant2.hashCode())) * 31;
        boolean z11 = this.contactlessEnabled;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode3 + (z11 ? 1 : 0)) * 31;
        String str2 = this.defaultPaymentMethod;
        int hashCode4 = (((i12 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.errorDetail.hashCode()) * 31;
        String str3 = this.errorCode;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        PolygonEvents polygonEvents2 = this.polygonEvents;
        if (polygonEvents2 != null) {
            i11 = polygonEvents2.hashCode();
        }
        return hashCode5 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.paymentMethod;
        String str2 = this.errorMessage;
        Restaurant restaurant2 = this.restaurant;
        boolean z11 = this.contactlessEnabled;
        String str3 = this.defaultPaymentMethod;
        String str4 = this.errorDetail;
        String str5 = this.errorCode;
        PolygonEvents polygonEvents2 = this.polygonEvents;
        return "BNPLOrderPaymentFailureTrackingModel(paymentMethod=" + str + ", errorMessage=" + str2 + ", restaurant=" + restaurant2 + ", contactlessEnabled=" + z11 + ", defaultPaymentMethod=" + str3 + ", errorDetail=" + str4 + ", errorCode=" + str5 + ", polygonEvents=" + polygonEvents2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLOrderPaymentFailureTrackingModel(String str, String str2, Restaurant restaurant2, boolean z11, String str3, String str4, String str5, PolygonEvents polygonEvents2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, restaurant2, z11, str3, str4, (i11 & 64) != 0 ? null : str5, polygonEvents2);
    }
}
