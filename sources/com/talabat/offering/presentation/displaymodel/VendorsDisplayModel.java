package com.talabat.offering.presentation.displaymodel;

import datamodels.RestaurantListModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/VendorsDisplayModel;", "", "()V", "ShowEmptyVendors", "ShowVendors", "Lcom/talabat/offering/presentation/displaymodel/VendorsDisplayModel$ShowVendors;", "Lcom/talabat/offering/presentation/displaymodel/VendorsDisplayModel$ShowEmptyVendors;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class VendorsDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/VendorsDisplayModel$ShowEmptyVendors;", "Lcom/talabat/offering/presentation/displaymodel/VendorsDisplayModel;", "()V", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowEmptyVendors extends VendorsDisplayModel {
        public ShowEmptyVendors() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/VendorsDisplayModel$ShowVendors;", "Lcom/talabat/offering/presentation/displaymodel/VendorsDisplayModel;", "restaurantListModel", "Ldatamodels/RestaurantListModel;", "(Ldatamodels/RestaurantListModel;)V", "getRestaurantListModel", "()Ldatamodels/RestaurantListModel;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowVendors extends VendorsDisplayModel {
        @NotNull
        private final RestaurantListModel restaurantListModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowVendors(@NotNull RestaurantListModel restaurantListModel2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(restaurantListModel2, "restaurantListModel");
            this.restaurantListModel = restaurantListModel2;
        }

        @NotNull
        public final RestaurantListModel getRestaurantListModel() {
            return this.restaurantListModel;
        }
    }

    private VendorsDisplayModel() {
    }

    public /* synthetic */ VendorsDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
