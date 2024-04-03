package com.talabat.fluid.homescreen.domain.usecase.business;

import com.deliveryhero.fluid.widgets.collections.list.ListCell;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase;", "", "shouldShowItemReplacementBottomSheet", "Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase$ItemReplacementInfo;", "collectionData", "", "Lcom/deliveryhero/fluid/widgets/collections/list/ListCell;", "ItemReplacementInfo", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ShowItemReplacementBottomSheetUseCase {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase$ItemReplacementInfo;", "", "shouldShowBottomSheet", "", "chainName", "", "chainId", "orderId", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChainId", "()Ljava/lang/String;", "getChainName", "getOrderId", "getShouldShowBottomSheet", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ItemReplacementInfo {
        @NotNull
        private final String chainId;
        @NotNull
        private final String chainName;
        @NotNull
        private final String orderId;
        private final boolean shouldShowBottomSheet;

        public ItemReplacementInfo(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "chainName");
            Intrinsics.checkNotNullParameter(str2, "chainId");
            Intrinsics.checkNotNullParameter(str3, "orderId");
            this.shouldShowBottomSheet = z11;
            this.chainName = str;
            this.chainId = str2;
            this.orderId = str3;
        }

        public static /* synthetic */ ItemReplacementInfo copy$default(ItemReplacementInfo itemReplacementInfo, boolean z11, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = itemReplacementInfo.shouldShowBottomSheet;
            }
            if ((i11 & 2) != 0) {
                str = itemReplacementInfo.chainName;
            }
            if ((i11 & 4) != 0) {
                str2 = itemReplacementInfo.chainId;
            }
            if ((i11 & 8) != 0) {
                str3 = itemReplacementInfo.orderId;
            }
            return itemReplacementInfo.copy(z11, str, str2, str3);
        }

        public final boolean component1() {
            return this.shouldShowBottomSheet;
        }

        @NotNull
        public final String component2() {
            return this.chainName;
        }

        @NotNull
        public final String component3() {
            return this.chainId;
        }

        @NotNull
        public final String component4() {
            return this.orderId;
        }

        @NotNull
        public final ItemReplacementInfo copy(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "chainName");
            Intrinsics.checkNotNullParameter(str2, "chainId");
            Intrinsics.checkNotNullParameter(str3, "orderId");
            return new ItemReplacementInfo(z11, str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemReplacementInfo)) {
                return false;
            }
            ItemReplacementInfo itemReplacementInfo = (ItemReplacementInfo) obj;
            return this.shouldShowBottomSheet == itemReplacementInfo.shouldShowBottomSheet && Intrinsics.areEqual((Object) this.chainName, (Object) itemReplacementInfo.chainName) && Intrinsics.areEqual((Object) this.chainId, (Object) itemReplacementInfo.chainId) && Intrinsics.areEqual((Object) this.orderId, (Object) itemReplacementInfo.orderId);
        }

        @NotNull
        public final String getChainId() {
            return this.chainId;
        }

        @NotNull
        public final String getChainName() {
            return this.chainName;
        }

        @NotNull
        public final String getOrderId() {
            return this.orderId;
        }

        public final boolean getShouldShowBottomSheet() {
            return this.shouldShowBottomSheet;
        }

        public int hashCode() {
            boolean z11 = this.shouldShowBottomSheet;
            if (z11) {
                z11 = true;
            }
            return ((((((z11 ? 1 : 0) * true) + this.chainName.hashCode()) * 31) + this.chainId.hashCode()) * 31) + this.orderId.hashCode();
        }

        @NotNull
        public String toString() {
            boolean z11 = this.shouldShowBottomSheet;
            String str = this.chainName;
            String str2 = this.chainId;
            String str3 = this.orderId;
            return "ItemReplacementInfo(shouldShowBottomSheet=" + z11 + ", chainName=" + str + ", chainId=" + str2 + ", orderId=" + str3 + ")";
        }
    }

    @NotNull
    ItemReplacementInfo shouldShowItemReplacementBottomSheet(@NotNull List<ListCell> list);
}
