package com.talabat.core.flutter.channels.domain.address;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003H&J \u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\bH&J\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\bH&J\u0014\u0010\u0010\u001a\u00020\f2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0003H&J0\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H&J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0019\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\f2\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H&\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/address/AddressInfoChannelCallback;", "", "getAddressList", "", "", "", "getGuestAddressInfo", "areaId", "", "getSkipAddressMap", "", "onAttach", "", "activityName", "channelIdentity", "onDetach", "setAddressList", "addresses", "setGuestAddressInfo", "firstName", "lastName", "addressMap", "setSelectedAddress", "addressId", "setSelectedCountry", "countryId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSelectedUnsavedAddress", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AddressInfoChannelCallback {
    @NotNull
    List<Map<String, Object>> getAddressList();

    @Nullable
    Map<String, Object> getGuestAddressInfo(int i11);

    boolean getSkipAddressMap();

    void onAttach(@Nullable String str, int i11);

    void onDetach(@Nullable String str, int i11);

    void setAddressList(@NotNull List<?> list);

    void setGuestAddressInfo(int i11, @NotNull String str, @NotNull String str2, @NotNull Map<?, ?> map);

    void setSelectedAddress(@NotNull String str, int i11);

    @Nullable
    Object setSelectedCountry(int i11, @NotNull Continuation<? super Unit> continuation);

    void setSelectedUnsavedAddress(@NotNull Map<?, ?> map);
}
