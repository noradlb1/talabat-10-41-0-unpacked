package com.talabat.feature.darkstores.presentation.viewstate;

import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState;", "", "()V", "Hidden", "Loading", "Navigating", "Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState$Loading;", "Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState$Navigating;", "Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState$Hidden;", "com_talabat_feature_darkstores_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DarkStoreViewState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState$Hidden;", "Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState;", "()V", "com_talabat_feature_darkstores_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends DarkStoreViewState {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState$Loading;", "Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState;", "()V", "com_talabat_feature_darkstores_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading extends DarkStoreViewState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState$Navigating;", "Lcom/talabat/feature/darkstores/presentation/viewstate/DarkStoreViewState;", "restaurant", "Ldatamodels/Restaurant;", "selectedCountryId", "", "(Ldatamodels/Restaurant;I)V", "getRestaurant", "()Ldatamodels/Restaurant;", "getSelectedCountryId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_feature_darkstores_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Navigating extends DarkStoreViewState {
        @NotNull
        private final Restaurant restaurant;
        private final int selectedCountryId;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Navigating(@NotNull Restaurant restaurant2, int i11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            this.restaurant = restaurant2;
            this.selectedCountryId = i11;
        }

        public static /* synthetic */ Navigating copy$default(Navigating navigating, Restaurant restaurant2, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                restaurant2 = navigating.restaurant;
            }
            if ((i12 & 2) != 0) {
                i11 = navigating.selectedCountryId;
            }
            return navigating.copy(restaurant2, i11);
        }

        @NotNull
        public final Restaurant component1() {
            return this.restaurant;
        }

        public final int component2() {
            return this.selectedCountryId;
        }

        @NotNull
        public final Navigating copy(@NotNull Restaurant restaurant2, int i11) {
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            return new Navigating(restaurant2, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Navigating)) {
                return false;
            }
            Navigating navigating = (Navigating) obj;
            return Intrinsics.areEqual((Object) this.restaurant, (Object) navigating.restaurant) && this.selectedCountryId == navigating.selectedCountryId;
        }

        @NotNull
        public final Restaurant getRestaurant() {
            return this.restaurant;
        }

        public final int getSelectedCountryId() {
            return this.selectedCountryId;
        }

        public int hashCode() {
            return (this.restaurant.hashCode() * 31) + this.selectedCountryId;
        }

        @NotNull
        public String toString() {
            Restaurant restaurant2 = this.restaurant;
            int i11 = this.selectedCountryId;
            return "Navigating(restaurant=" + restaurant2 + ", selectedCountryId=" + i11 + ")";
        }
    }

    private DarkStoreViewState() {
    }

    public /* synthetic */ DarkStoreViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
