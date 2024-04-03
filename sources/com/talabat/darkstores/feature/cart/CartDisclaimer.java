package com.talabat.darkstores.feature.cart;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartDisclaimer;", "", "title", "", "description", "url", "actionText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionText", "()Ljava/lang/String;", "getDescription", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartDisclaimer {
    @Nullable
    private final String actionText;
    @Nullable
    private final String description;
    @Nullable
    private final String title;
    @Nullable
    private final String url;

    public CartDisclaimer(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.title = str;
        this.description = str2;
        this.url = str3;
        this.actionText = str4;
    }

    public static /* synthetic */ CartDisclaimer copy$default(CartDisclaimer cartDisclaimer, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cartDisclaimer.title;
        }
        if ((i11 & 2) != 0) {
            str2 = cartDisclaimer.description;
        }
        if ((i11 & 4) != 0) {
            str3 = cartDisclaimer.url;
        }
        if ((i11 & 8) != 0) {
            str4 = cartDisclaimer.actionText;
        }
        return cartDisclaimer.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    @Nullable
    public final String component4() {
        return this.actionText;
    }

    @NotNull
    public final CartDisclaimer copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new CartDisclaimer(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartDisclaimer)) {
            return false;
        }
        CartDisclaimer cartDisclaimer = (CartDisclaimer) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) cartDisclaimer.title) && Intrinsics.areEqual((Object) this.description, (Object) cartDisclaimer.description) && Intrinsics.areEqual((Object) this.url, (Object) cartDisclaimer.url) && Intrinsics.areEqual((Object) this.actionText, (Object) cartDisclaimer.actionText);
    }

    @Nullable
    public final String getActionText() {
        return this.actionText;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.actionText;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.description;
        String str3 = this.url;
        String str4 = this.actionText;
        return "CartDisclaimer(title=" + str + ", description=" + str2 + ", url=" + str3 + ", actionText=" + str4 + ")";
    }
}
