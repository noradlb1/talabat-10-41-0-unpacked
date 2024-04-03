package com.talabat.fluid.homescreen.ui.integration;

import androidx.fragment.app.Fragment;
import com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase;
import com.talabat.fluid.homescreen.presentation.mapper.EntryPointItem;
import com.talabat.homescreen.adapter.model.banner.BannerAdItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u001eJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\bH&J\b\u0010\u001b\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0015H&¨\u0006\u001f"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/integration/FluidHomeScreenIntegrable;", "", "configure", "", "configuration", "Lcom/talabat/fluid/homescreen/ui/integration/FluidHomeScreenIntegrable$Configuration;", "handleDeepLink", "deepLink", "", "hideToolBar", "onBannerClick", "bannerAdItem", "Lcom/talabat/homescreen/adapter/model/banner/BannerAdItem;", "onEntryPointClicked", "entryPointItem", "Lcom/talabat/fluid/homescreen/presentation/mapper/EntryPointItem;", "onFragmentAttached", "fragment", "Landroidx/fragment/app/Fragment;", "setSelectedVertical", "verticalId", "", "showItemReplacementBottomSheet", "info", "Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase$ItemReplacementInfo;", "showRatingBottomSheet", "encryptedOrderId", "showToolBar", "transitionHeaderColour", "colour", "Configuration", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FluidHomeScreenIntegrable {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/integration/FluidHomeScreenIntegrable$Configuration;", "", "navigationBarColor", "", "locationHintColor", "locationTitleColor", "locationArrowTintColor", "(IIII)V", "getLocationArrowTintColor", "()I", "getLocationHintColor", "getLocationTitleColor", "getNavigationBarColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Configuration {
        private final int locationArrowTintColor;
        private final int locationHintColor;
        private final int locationTitleColor;
        private final int navigationBarColor;

        public Configuration(int i11, int i12, int i13, int i14) {
            this.navigationBarColor = i11;
            this.locationHintColor = i12;
            this.locationTitleColor = i13;
            this.locationArrowTintColor = i14;
        }

        public static /* synthetic */ Configuration copy$default(Configuration configuration, int i11, int i12, int i13, int i14, int i15, Object obj) {
            if ((i15 & 1) != 0) {
                i11 = configuration.navigationBarColor;
            }
            if ((i15 & 2) != 0) {
                i12 = configuration.locationHintColor;
            }
            if ((i15 & 4) != 0) {
                i13 = configuration.locationTitleColor;
            }
            if ((i15 & 8) != 0) {
                i14 = configuration.locationArrowTintColor;
            }
            return configuration.copy(i11, i12, i13, i14);
        }

        public final int component1() {
            return this.navigationBarColor;
        }

        public final int component2() {
            return this.locationHintColor;
        }

        public final int component3() {
            return this.locationTitleColor;
        }

        public final int component4() {
            return this.locationArrowTintColor;
        }

        @NotNull
        public final Configuration copy(int i11, int i12, int i13, int i14) {
            return new Configuration(i11, i12, i13, i14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return this.navigationBarColor == configuration.navigationBarColor && this.locationHintColor == configuration.locationHintColor && this.locationTitleColor == configuration.locationTitleColor && this.locationArrowTintColor == configuration.locationArrowTintColor;
        }

        public final int getLocationArrowTintColor() {
            return this.locationArrowTintColor;
        }

        public final int getLocationHintColor() {
            return this.locationHintColor;
        }

        public final int getLocationTitleColor() {
            return this.locationTitleColor;
        }

        public final int getNavigationBarColor() {
            return this.navigationBarColor;
        }

        public int hashCode() {
            return (((((this.navigationBarColor * 31) + this.locationHintColor) * 31) + this.locationTitleColor) * 31) + this.locationArrowTintColor;
        }

        @NotNull
        public String toString() {
            int i11 = this.navigationBarColor;
            int i12 = this.locationHintColor;
            int i13 = this.locationTitleColor;
            int i14 = this.locationArrowTintColor;
            return "Configuration(navigationBarColor=" + i11 + ", locationHintColor=" + i12 + ", locationTitleColor=" + i13 + ", locationArrowTintColor=" + i14 + ")";
        }
    }

    void configure(@NotNull Configuration configuration);

    void handleDeepLink(@NotNull String str);

    void hideToolBar();

    void onBannerClick(@NotNull BannerAdItem bannerAdItem);

    void onEntryPointClicked(@NotNull EntryPointItem entryPointItem);

    void onFragmentAttached(@NotNull Fragment fragment);

    void setSelectedVertical(int i11);

    void showItemReplacementBottomSheet(@NotNull ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo itemReplacementInfo);

    void showRatingBottomSheet(@NotNull String str);

    void showToolBar();

    void transitionHeaderColour(int i11);
}
