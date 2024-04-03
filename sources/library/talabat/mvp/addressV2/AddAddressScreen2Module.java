package library.talabat.mvp.addressV2;

import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Llibrary/talabat/mvp/addressV2/AddAddressScreen2Module;", "", "addressJsonprovider", "Lkotlin/Function0;", "", "addressFormFormatJsonProvider", "Llibrary/talabat/mvp/addressV2/AddressFormFormatJsonProvider;", "userAddAddressScreenEventsListener", "Llibrary/talabat/mvp/addressV2/UserAddAddressScreenEventsListener;", "tracker", "Llibrary/talabat/mvp/addressV2/AddAddressScreenEventsTalabatTracker;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface AddAddressScreen2Module {
    @NotNull
    @Binds
    Function0<String> addressJsonprovider(@NotNull AddressFormFormatJsonProvider addressFormFormatJsonProvider);

    @NotNull
    @Binds
    UserAddAddressScreenEventsListener userAddAddressScreenEventsListener(@NotNull AddAddressScreenEventsTalabatTracker addAddressScreenEventsTalabatTracker);
}
