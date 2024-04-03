package buisnessmodels;

import com.talabat.configuration.country.Country;
import com.talabat.domain.address.Address;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH&¨\u0006\u000f"}, d2 = {"Lbuisnessmodels/ICustomer;", "", "getSelectedCustomerAddress", "Lcom/talabat/domain/address/Address;", "getTalabatCreditBalance", "", "hasAddresses", "", "selectedCountry", "Lcom/talabat/configuration/country/Country;", "isLoggedIn", "setCustomerAddress", "", "address", "Ljava/util/ArrayList;", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICustomer {
    @Nullable
    Address getSelectedCustomerAddress();

    float getTalabatCreditBalance();

    @Deprecated(message = "Will be removed due to migrating from static SelectedCountryId", replaceWith = @ReplaceWith(expression = "ICustomer.hasAddresses(input)", imports = {}))
    boolean hasAddresses();

    boolean hasAddresses(@NotNull Country country);

    boolean isLoggedIn();

    void setCustomerAddress(@NotNull ArrayList<Address> arrayList);
}
