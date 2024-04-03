package com.talabat.helpers.tracking.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/talabat/helpers/tracking/event/ScreenOpenedEventModel;", "", "screenName", "", "talabatCredits", "", "cartSubTotal", "cartHasItems", "", "isLoggedIn", "(Ljava/lang/String;FLjava/lang/String;ZZ)V", "getCartHasItems", "()Z", "getCartSubTotal", "()Ljava/lang/String;", "getScreenName", "getTalabatCredits", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenOpenedEventModel {
    private final boolean cartHasItems;
    @NotNull
    private final String cartSubTotal;
    private final boolean isLoggedIn;
    @NotNull
    private final String screenName;
    private final float talabatCredits;

    public ScreenOpenedEventModel(@NotNull String str, float f11, @NotNull String str2, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "cartSubTotal");
        this.screenName = str;
        this.talabatCredits = f11;
        this.cartSubTotal = str2;
        this.cartHasItems = z11;
        this.isLoggedIn = z12;
    }

    public static /* synthetic */ ScreenOpenedEventModel copy$default(ScreenOpenedEventModel screenOpenedEventModel, String str, float f11, String str2, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = screenOpenedEventModel.screenName;
        }
        if ((i11 & 2) != 0) {
            f11 = screenOpenedEventModel.talabatCredits;
        }
        float f12 = f11;
        if ((i11 & 4) != 0) {
            str2 = screenOpenedEventModel.cartSubTotal;
        }
        String str3 = str2;
        if ((i11 & 8) != 0) {
            z11 = screenOpenedEventModel.cartHasItems;
        }
        boolean z13 = z11;
        if ((i11 & 16) != 0) {
            z12 = screenOpenedEventModel.isLoggedIn;
        }
        return screenOpenedEventModel.copy(str, f12, str3, z13, z12);
    }

    @NotNull
    public final String component1() {
        return this.screenName;
    }

    public final float component2() {
        return this.talabatCredits;
    }

    @NotNull
    public final String component3() {
        return this.cartSubTotal;
    }

    public final boolean component4() {
        return this.cartHasItems;
    }

    public final boolean component5() {
        return this.isLoggedIn;
    }

    @NotNull
    public final ScreenOpenedEventModel copy(@NotNull String str, float f11, @NotNull String str2, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "cartSubTotal");
        return new ScreenOpenedEventModel(str, f11, str2, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenOpenedEventModel)) {
            return false;
        }
        ScreenOpenedEventModel screenOpenedEventModel = (ScreenOpenedEventModel) obj;
        return Intrinsics.areEqual((Object) this.screenName, (Object) screenOpenedEventModel.screenName) && Intrinsics.areEqual((Object) Float.valueOf(this.talabatCredits), (Object) Float.valueOf(screenOpenedEventModel.talabatCredits)) && Intrinsics.areEqual((Object) this.cartSubTotal, (Object) screenOpenedEventModel.cartSubTotal) && this.cartHasItems == screenOpenedEventModel.cartHasItems && this.isLoggedIn == screenOpenedEventModel.isLoggedIn;
    }

    public final boolean getCartHasItems() {
        return this.cartHasItems;
    }

    @NotNull
    public final String getCartSubTotal() {
        return this.cartSubTotal;
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    public final float getTalabatCredits() {
        return this.talabatCredits;
    }

    public int hashCode() {
        int hashCode = ((((this.screenName.hashCode() * 31) + Float.floatToIntBits(this.talabatCredits)) * 31) + this.cartSubTotal.hashCode()) * 31;
        boolean z11 = this.cartHasItems;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isLoggedIn;
        if (!z13) {
            z12 = z13;
        }
        return i11 + (z12 ? 1 : 0);
    }

    public final boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    @NotNull
    public String toString() {
        String str = this.screenName;
        float f11 = this.talabatCredits;
        String str2 = this.cartSubTotal;
        boolean z11 = this.cartHasItems;
        boolean z12 = this.isLoggedIn;
        return "ScreenOpenedEventModel(screenName=" + str + ", talabatCredits=" + f11 + ", cartSubTotal=" + str2 + ", cartHasItems=" + z11 + ", isLoggedIn=" + z12 + ")";
    }
}
