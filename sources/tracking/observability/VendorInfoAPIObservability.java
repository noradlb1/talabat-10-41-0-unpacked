package tracking.observability;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Ltracking/observability/VendorInfoAPIObservability;", "", "onVendorListTalabatBranchCodeAPIFailed", "", "isDarkStore", "", "errorCode", "", "errorMessage", "", "selectedCountryId", "(ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorInfoAPIObservability {
    void onVendorListTalabatBranchCodeAPIFailed(boolean z11, @Nullable Integer num, @Nullable String str, @Nullable Integer num2);
}
