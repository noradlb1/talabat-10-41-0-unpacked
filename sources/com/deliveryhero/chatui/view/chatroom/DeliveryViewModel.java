package com.deliveryhero.chatui.view.chatroom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/DeliveryViewModel;", "", "code", "", "amount", "address", "comments", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAmount", "getCode", "getComments", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryViewModel {
    @Nullable
    private final String address;
    @Nullable
    private final String amount;
    @Nullable
    private final String code;
    @Nullable
    private final String comments;

    public DeliveryViewModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.code = str;
        this.amount = str2;
        this.address = str3;
        this.comments = str4;
    }

    public static /* synthetic */ DeliveryViewModel copy$default(DeliveryViewModel deliveryViewModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = deliveryViewModel.code;
        }
        if ((i11 & 2) != 0) {
            str2 = deliveryViewModel.amount;
        }
        if ((i11 & 4) != 0) {
            str3 = deliveryViewModel.address;
        }
        if ((i11 & 8) != 0) {
            str4 = deliveryViewModel.comments;
        }
        return deliveryViewModel.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.amount;
    }

    @Nullable
    public final String component3() {
        return this.address;
    }

    @Nullable
    public final String component4() {
        return this.comments;
    }

    @NotNull
    public final DeliveryViewModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new DeliveryViewModel(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryViewModel)) {
            return false;
        }
        DeliveryViewModel deliveryViewModel = (DeliveryViewModel) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) deliveryViewModel.code) && Intrinsics.areEqual((Object) this.amount, (Object) deliveryViewModel.amount) && Intrinsics.areEqual((Object) this.address, (Object) deliveryViewModel.address) && Intrinsics.areEqual((Object) this.comments, (Object) deliveryViewModel.comments);
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getAmount() {
        return this.amount;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getComments() {
        return this.comments;
    }

    public int hashCode() {
        String str = this.code;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.amount;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.address;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.comments;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        return "DeliveryViewModel(code=" + this.code + ", amount=" + this.amount + ", address=" + this.address + ", comments=" + this.comments + ')';
    }
}
