package com.uladdressform.presentation.channel;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000f"}, d2 = {"Lcom/uladdressform/presentation/channel/IAddressFormMethodChannel;", "", "delete", "", "addressId", "", "getAddressFormUIRequestInfo", "Lcom/uladdressform/presentation/channel/AddressFormRequestParamBundle;", "moveForward", "it", "Lcom/uladdressform/presentation/channel/AddressFormBundle;", "navigateToMapScreen", "Lcom/uladdressform/presentation/channel/AddressFormMapBundle;", "onAddAddressSuccessfully", "onEditAddressSuccessfully", "com_talabat_feature_ul-address-form_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAddressFormMethodChannel {
    void delete(@Nullable String str);

    @NotNull
    AddressFormRequestParamBundle getAddressFormUIRequestInfo();

    void moveForward(@NotNull AddressFormBundle addressFormBundle);

    void navigateToMapScreen(@NotNull AddressFormMapBundle addressFormMapBundle);

    void onAddAddressSuccessfully(@NotNull AddressFormBundle addressFormBundle);

    void onEditAddressSuccessfully(@NotNull AddressFormBundle addressFormBundle);
}
