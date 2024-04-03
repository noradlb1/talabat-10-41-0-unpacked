package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0002\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPPointResponseModel;", "", "isSuccessful", "", "imageUrl", "", "title", "description", "buttonTitle", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getDescription", "getImageUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPPointResponseModel;", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentOTPPointResponseModel {
    @Nullable
    private final String buttonTitle;
    @Nullable
    private final String description;
    @Nullable
    private final String imageUrl;
    @Nullable
    private final Boolean isSuccessful;
    @Nullable
    private final String title;

    public SubscriptionPaymentOTPPointResponseModel() {
        this((Boolean) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public SubscriptionPaymentOTPPointResponseModel(@Nullable @Json(name = "isSuccessful") Boolean bool, @Nullable @Json(name = "imageUrl") String str, @Nullable @Json(name = "title") String str2, @Nullable @Json(name = "description") String str3, @Nullable @Json(name = "buttonTitle") String str4) {
        this.isSuccessful = bool;
        this.imageUrl = str;
        this.title = str2;
        this.description = str3;
        this.buttonTitle = str4;
    }

    public static /* synthetic */ SubscriptionPaymentOTPPointResponseModel copy$default(SubscriptionPaymentOTPPointResponseModel subscriptionPaymentOTPPointResponseModel, Boolean bool, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = subscriptionPaymentOTPPointResponseModel.isSuccessful;
        }
        if ((i11 & 2) != 0) {
            str = subscriptionPaymentOTPPointResponseModel.imageUrl;
        }
        String str5 = str;
        if ((i11 & 4) != 0) {
            str2 = subscriptionPaymentOTPPointResponseModel.title;
        }
        String str6 = str2;
        if ((i11 & 8) != 0) {
            str3 = subscriptionPaymentOTPPointResponseModel.description;
        }
        String str7 = str3;
        if ((i11 & 16) != 0) {
            str4 = subscriptionPaymentOTPPointResponseModel.buttonTitle;
        }
        return subscriptionPaymentOTPPointResponseModel.copy(bool, str5, str6, str7, str4);
    }

    @Nullable
    public final Boolean component1() {
        return this.isSuccessful;
    }

    @Nullable
    public final String component2() {
        return this.imageUrl;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @Nullable
    public final String component4() {
        return this.description;
    }

    @Nullable
    public final String component5() {
        return this.buttonTitle;
    }

    @NotNull
    public final SubscriptionPaymentOTPPointResponseModel copy(@Nullable @Json(name = "isSuccessful") Boolean bool, @Nullable @Json(name = "imageUrl") String str, @Nullable @Json(name = "title") String str2, @Nullable @Json(name = "description") String str3, @Nullable @Json(name = "buttonTitle") String str4) {
        return new SubscriptionPaymentOTPPointResponseModel(bool, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPaymentOTPPointResponseModel)) {
            return false;
        }
        SubscriptionPaymentOTPPointResponseModel subscriptionPaymentOTPPointResponseModel = (SubscriptionPaymentOTPPointResponseModel) obj;
        return Intrinsics.areEqual((Object) this.isSuccessful, (Object) subscriptionPaymentOTPPointResponseModel.isSuccessful) && Intrinsics.areEqual((Object) this.imageUrl, (Object) subscriptionPaymentOTPPointResponseModel.imageUrl) && Intrinsics.areEqual((Object) this.title, (Object) subscriptionPaymentOTPPointResponseModel.title) && Intrinsics.areEqual((Object) this.description, (Object) subscriptionPaymentOTPPointResponseModel.description) && Intrinsics.areEqual((Object) this.buttonTitle, (Object) subscriptionPaymentOTPPointResponseModel.buttonTitle);
    }

    @Nullable
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Boolean bool = this.isSuccessful;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.imageUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.buttonTitle;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode4 + i11;
    }

    @Nullable
    public final Boolean isSuccessful() {
        return this.isSuccessful;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isSuccessful;
        String str = this.imageUrl;
        String str2 = this.title;
        String str3 = this.description;
        String str4 = this.buttonTitle;
        return "SubscriptionPaymentOTPPointResponseModel(isSuccessful=" + bool + ", imageUrl=" + str + ", title=" + str2 + ", description=" + str3 + ", buttonTitle=" + str4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionPaymentOTPPointResponseModel(java.lang.Boolean r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
        L_0x0006:
            r10 = r9 & 2
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x000e
            r10 = r0
            goto L_0x000f
        L_0x000e:
            r10 = r5
        L_0x000f:
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0015
            r1 = r0
            goto L_0x0016
        L_0x0015:
            r1 = r6
        L_0x0016:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001c
            r2 = r0
            goto L_0x001d
        L_0x001c:
            r2 = r7
        L_0x001d:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r0 = r8
        L_0x0023:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r2
            r10 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPPointResponseModel.<init>(java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
