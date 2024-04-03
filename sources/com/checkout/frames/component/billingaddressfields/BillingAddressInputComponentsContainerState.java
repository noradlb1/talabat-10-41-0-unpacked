package com.checkout.frames.component.billingaddressfields;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentsContainerState;", "", "inputComponentStateList", "", "Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentState;", "(Ljava/util/List;)V", "getInputComponentStateList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressInputComponentsContainerState {
    @NotNull
    private final List<BillingAddressInputComponentState> inputComponentStateList;

    public BillingAddressInputComponentsContainerState() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public BillingAddressInputComponentsContainerState(@NotNull List<BillingAddressInputComponentState> list) {
        Intrinsics.checkNotNullParameter(list, "inputComponentStateList");
        this.inputComponentStateList = list;
    }

    public static /* synthetic */ BillingAddressInputComponentsContainerState copy$default(BillingAddressInputComponentsContainerState billingAddressInputComponentsContainerState, List<BillingAddressInputComponentState> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = billingAddressInputComponentsContainerState.inputComponentStateList;
        }
        return billingAddressInputComponentsContainerState.copy(list);
    }

    @NotNull
    public final List<BillingAddressInputComponentState> component1() {
        return this.inputComponentStateList;
    }

    @NotNull
    public final BillingAddressInputComponentsContainerState copy(@NotNull List<BillingAddressInputComponentState> list) {
        Intrinsics.checkNotNullParameter(list, "inputComponentStateList");
        return new BillingAddressInputComponentsContainerState(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BillingAddressInputComponentsContainerState) && Intrinsics.areEqual((Object) this.inputComponentStateList, (Object) ((BillingAddressInputComponentsContainerState) obj).inputComponentStateList);
    }

    @NotNull
    public final List<BillingAddressInputComponentState> getInputComponentStateList() {
        return this.inputComponentStateList;
    }

    public int hashCode() {
        return this.inputComponentStateList.hashCode();
    }

    @NotNull
    public String toString() {
        List<BillingAddressInputComponentState> list = this.inputComponentStateList;
        return "BillingAddressInputComponentsContainerState(inputComponentStateList=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillingAddressInputComponentsContainerState(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
