package library.talabat.mvp.login.domain.repository;

import com.talabat.domain.address.Address;
import datamodels.CustomerInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H&J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H&¨\u0006\u0016"}, d2 = {"Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "", "getCustomerAddress", "Ljava/util/ArrayList;", "Lcom/talabat/domain/address/Address;", "getMobileNumber", "", "withCountryCode", "", "hasAddresses", "isLoggedIn", "saveCustomerInfo", "", "customerInfo", "Ldatamodels/CustomerInfo;", "setCustomerAddresses", "addresses", "", "setSelectedCustomerAddress", "addressId", "areaId", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CustomerRepository {
    @NotNull
    ArrayList<Address> getCustomerAddress();

    @NotNull
    String getMobileNumber(boolean z11);

    boolean hasAddresses();

    boolean isLoggedIn();

    void saveCustomerInfo(@Nullable CustomerInfo customerInfo);

    void setCustomerAddresses(@NotNull List<Address> list);

    void setSelectedCustomerAddress(@NotNull String str, int i11);
}
