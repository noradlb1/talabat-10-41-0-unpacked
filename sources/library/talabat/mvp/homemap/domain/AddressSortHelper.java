package library.talabat.mvp.homemap.domain;

import com.talabat.domain.address.Address;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Llibrary/talabat/mvp/homemap/domain/AddressSortHelper;", "", "getFirstAddressSortedWithLocationOrNull", "Lcom/talabat/domain/address/Address;", "latLng", "Lkotlin/Pair;", "", "customerAddresses", "Ljava/util/ArrayList;", "sortDistance", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AddressSortHelper {
    @Nullable
    Address getFirstAddressSortedWithLocationOrNull(@NotNull Pair<Double, Double> pair, @NotNull ArrayList<Address> arrayList, int i11);
}
