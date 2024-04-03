package library.talabat.mvp.choosesavedaddress;

import android.content.Context;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0017\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0010H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0017H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0017H&J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0017H&J\u001a\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u00122\u0006\u0010#\u001a\u00020\u0010H&J\u0016\u0010$\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170&H&J\b\u0010'\u001a\u00020\u0010H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0010H&J\u0012\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0010H&J\b\u0010.\u001a\u00020\u0003H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0005H&¨\u00061"}, d2 = {"Llibrary/talabat/mvp/choosesavedaddress/ChooseSavedAddressView;", "Lcom/talabat/helpers/Talabat;", "currentLocOutSideCountry", "", "countyId", "", "fetchCurrentLocaion", "forceToenableCurrentLocation", "getContext", "Landroid/content/Context;", "listenForCurrentLocation", "onCountryDataLoaded", "id", "(Ljava/lang/Integer;)V", "redirectMapScreen", "ignoreCurrentLocation", "", "UserSelectedAddress", "", "areaId", "isPrioritizeSearch", "redirectToListingFromDCL", "result", "Lcom/talabat/domain/address/Address;", "reverseBrachIdReceived", "branchInfo", "address", "reverseBrachIdReceivedFromDL", "branchId", "reverseAddress", "reverserAddressReceived", "selectAddress", "cstAddress", "showBrandNotDeliverHere", "geoAddressTitle", "fromDcl", "showCustomerSavedAddress", "customerAddress", "Ljava/util/ArrayList;", "showRedirectLoading", "unableToFindLocation", "trackError", "updateApiErrorMsg", "localizedMessage", "updateIsFrachiseRestaurant", "isFranchiseRes", "updateIsIGnoreSavedLoc", "updateRestGrpId", "restGrpId", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChooseSavedAddressView extends Talabat {
    void currentLocOutSideCountry(int i11);

    void fetchCurrentLocaion();

    void forceToenableCurrentLocation();

    @NotNull
    Context getContext();

    void listenForCurrentLocation();

    void onCountryDataLoaded(@Nullable Integer num);

    void redirectMapScreen(boolean z11, @NotNull String str, int i11, boolean z12);

    void redirectToListingFromDCL(@NotNull Address address);

    void reverseBrachIdReceived(int i11, @NotNull Address address);

    void reverseBrachIdReceivedFromDL(int i11, @NotNull Address address);

    void reverserAddressReceived(@Nullable Address address);

    void selectAddress(@NotNull Address address);

    void showBrandNotDeliverHere(@Nullable String str, boolean z11);

    void showCustomerSavedAddress(@NotNull ArrayList<Address> arrayList);

    boolean showRedirectLoading();

    void unableToFindLocation(boolean z11);

    void updateApiErrorMsg(@Nullable String str);

    void updateIsFrachiseRestaurant(boolean z11);

    void updateIsIGnoreSavedLoc();

    void updateRestGrpId(int i11);
}
