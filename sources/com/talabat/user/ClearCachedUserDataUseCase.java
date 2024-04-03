package com.talabat.user;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.talabat.user.address.data.local.AddressesLocalDataSourceImp;
import com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSource;
import com.talabat.userandlocation.appinfo.data.local.AppInfoLocalDataSourceImp;
import com.talabat.userandlocation.customerinfo.data.local.CustomerInfoLocalDataSource;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/user/ClearCachedUserDataUseCase;", "", "customerInfoLocalDataSourceImpl", "Lcom/talabat/userandlocation/customerinfo/data/local/CustomerInfoLocalDataSource;", "addressesLocalDataSourceImp", "Lcom/talabat/user/address/data/local/AddressesLocalDataSourceImp;", "appInfoLocalDataSourceImp", "Lcom/talabat/userandlocation/appinfo/data/local/AppInfoLocalDataSource;", "(Lcom/talabat/userandlocation/customerinfo/data/local/CustomerInfoLocalDataSource;Lcom/talabat/user/address/data/local/AddressesLocalDataSourceImp;Lcom/talabat/userandlocation/appinfo/data/local/AppInfoLocalDataSource;)V", "inValidateCachedUserData", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClearCachedUserDataUseCase {
    @NotNull
    private final AddressesLocalDataSourceImp addressesLocalDataSourceImp;
    @NotNull
    private final AppInfoLocalDataSource appInfoLocalDataSourceImp;
    @NotNull
    private final CustomerInfoLocalDataSource customerInfoLocalDataSourceImpl;

    @JvmOverloads
    public ClearCachedUserDataUseCase() {
        this((CustomerInfoLocalDataSource) null, (AddressesLocalDataSourceImp) null, (AppInfoLocalDataSource) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ClearCachedUserDataUseCase(@NotNull CustomerInfoLocalDataSource customerInfoLocalDataSource) {
        this(customerInfoLocalDataSource, (AddressesLocalDataSourceImp) null, (AppInfoLocalDataSource) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(customerInfoLocalDataSource, "customerInfoLocalDataSourceImpl");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ClearCachedUserDataUseCase(@NotNull CustomerInfoLocalDataSource customerInfoLocalDataSource, @NotNull AddressesLocalDataSourceImp addressesLocalDataSourceImp2) {
        this(customerInfoLocalDataSource, addressesLocalDataSourceImp2, (AppInfoLocalDataSource) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(customerInfoLocalDataSource, "customerInfoLocalDataSourceImpl");
        Intrinsics.checkNotNullParameter(addressesLocalDataSourceImp2, "addressesLocalDataSourceImp");
    }

    @JvmOverloads
    public ClearCachedUserDataUseCase(@NotNull CustomerInfoLocalDataSource customerInfoLocalDataSource, @NotNull AddressesLocalDataSourceImp addressesLocalDataSourceImp2, @NotNull AppInfoLocalDataSource appInfoLocalDataSource) {
        Intrinsics.checkNotNullParameter(customerInfoLocalDataSource, "customerInfoLocalDataSourceImpl");
        Intrinsics.checkNotNullParameter(addressesLocalDataSourceImp2, "addressesLocalDataSourceImp");
        Intrinsics.checkNotNullParameter(appInfoLocalDataSource, "appInfoLocalDataSourceImp");
        this.customerInfoLocalDataSourceImpl = customerInfoLocalDataSource;
        this.addressesLocalDataSourceImp = addressesLocalDataSourceImp2;
        this.appInfoLocalDataSourceImp = appInfoLocalDataSource;
    }

    public final void inValidateCachedUserData() {
        this.customerInfoLocalDataSourceImpl.setCustomerInfo((CustomerInfo) null);
        this.addressesLocalDataSourceImp.invalidateCustomerAddresses();
        this.appInfoLocalDataSourceImp.invalidateAppInfoCash();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClearCachedUserDataUseCase(CustomerInfoLocalDataSource customerInfoLocalDataSource, AddressesLocalDataSourceImp addressesLocalDataSourceImp2, AppInfoLocalDataSource appInfoLocalDataSource, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new CustomerInfoLocalDataSourceImpl((Context) null, (Gson) null, 3, (DefaultConstructorMarker) null) : customerInfoLocalDataSource, (i11 & 2) != 0 ? new AddressesLocalDataSourceImp((SharedPreferences) null, (Gson) null, 3, (DefaultConstructorMarker) null) : addressesLocalDataSourceImp2, (i11 & 4) != 0 ? new AppInfoLocalDataSourceImp((SharedPreferences) null, 1, (DefaultConstructorMarker) null) : appInfoLocalDataSource);
    }
}
