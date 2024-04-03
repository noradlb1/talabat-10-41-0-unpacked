package com.talabat.feature.darkstoresvendor.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/domain/model/Tags;", "", "bottomSheetTitle", "", "bottomSheetButtonTitle", "bottomSheetMovMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBottomSheetButtonTitle", "()Ljava/lang/String;", "getBottomSheetMovMessage", "getBottomSheetTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Tags {
    @NotNull
    private final String bottomSheetButtonTitle;
    @Nullable
    private final String bottomSheetMovMessage;
    @NotNull
    private final String bottomSheetTitle;

    public Tags(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, BasketDeliveryFeeTiersInfoKeys.KEY_BOTTOM_SHEET_TITLE);
        Intrinsics.checkNotNullParameter(str2, BasketDeliveryFeeTiersInfoKeys.KEY_BOTTOM_SHEET_BUTTON_TITLE);
        this.bottomSheetTitle = str;
        this.bottomSheetButtonTitle = str2;
        this.bottomSheetMovMessage = str3;
    }

    public static /* synthetic */ Tags copy$default(Tags tags, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tags.bottomSheetTitle;
        }
        if ((i11 & 2) != 0) {
            str2 = tags.bottomSheetButtonTitle;
        }
        if ((i11 & 4) != 0) {
            str3 = tags.bottomSheetMovMessage;
        }
        return tags.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.bottomSheetTitle;
    }

    @NotNull
    public final String component2() {
        return this.bottomSheetButtonTitle;
    }

    @Nullable
    public final String component3() {
        return this.bottomSheetMovMessage;
    }

    @NotNull
    public final Tags copy(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, BasketDeliveryFeeTiersInfoKeys.KEY_BOTTOM_SHEET_TITLE);
        Intrinsics.checkNotNullParameter(str2, BasketDeliveryFeeTiersInfoKeys.KEY_BOTTOM_SHEET_BUTTON_TITLE);
        return new Tags(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tags)) {
            return false;
        }
        Tags tags = (Tags) obj;
        return Intrinsics.areEqual((Object) this.bottomSheetTitle, (Object) tags.bottomSheetTitle) && Intrinsics.areEqual((Object) this.bottomSheetButtonTitle, (Object) tags.bottomSheetButtonTitle) && Intrinsics.areEqual((Object) this.bottomSheetMovMessage, (Object) tags.bottomSheetMovMessage);
    }

    @NotNull
    public final String getBottomSheetButtonTitle() {
        return this.bottomSheetButtonTitle;
    }

    @Nullable
    public final String getBottomSheetMovMessage() {
        return this.bottomSheetMovMessage;
    }

    @NotNull
    public final String getBottomSheetTitle() {
        return this.bottomSheetTitle;
    }

    public int hashCode() {
        int hashCode = ((this.bottomSheetTitle.hashCode() * 31) + this.bottomSheetButtonTitle.hashCode()) * 31;
        String str = this.bottomSheetMovMessage;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.bottomSheetTitle;
        String str2 = this.bottomSheetButtonTitle;
        String str3 = this.bottomSheetMovMessage;
        return "Tags(bottomSheetTitle=" + str + ", bottomSheetButtonTitle=" + str2 + ", bottomSheetMovMessage=" + str3 + ")";
    }
}
