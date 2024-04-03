package com.talabat.feature.walletcobrandedcc.data;

import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcRemoteDataSource;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcRepository;
import com.talabat.helpers.GlobalDataModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0011\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/WalletCobrandedCcRepositoryImpl;", "Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcRepository;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "walletCobrandedCcRemoteDataSource", "Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcRemoteDataSource;", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcRemoteDataSource;)V", "selectedCountryId", "", "getSelectedCountryId", "()I", "getWalletStatus", "Lcom/talabat/feature/walletcobrandedcc/domain/model/WalletStatus;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDisplayCobrandedCcInProgressNotification", "Lcom/talabat/feature/walletcobrandedcc/domain/model/CobrandedCcInProgressAppNotification;", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCobrandedCcRepositoryImpl implements WalletCobrandedCcRepository {
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final WalletCobrandedCcRemoteDataSource walletCobrandedCcRemoteDataSource;

    @Inject
    public WalletCobrandedCcRepositoryImpl(@NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull WalletCobrandedCcRemoteDataSource walletCobrandedCcRemoteDataSource2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(walletCobrandedCcRemoteDataSource2, "walletCobrandedCcRemoteDataSource");
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.walletCobrandedCcRemoteDataSource = walletCobrandedCcRemoteDataSource2;
    }

    private final int getSelectedCountryId() {
        Country country;
        try {
            com.talabat.configuration.location.Country selectedCountry = this.locationConfigurationRepository.selectedCountry();
            if (selectedCountry == null || (country = selectedCountry.getCountry()) == null) {
                return GlobalDataModel.SelectedCountryId;
            }
            return country.getCountryId();
        } catch (UninitializedPropertyAccessException unused) {
            return GlobalDataModel.SelectedCountryId;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getWalletStatus(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.walletcobrandedcc.domain.model.WalletStatus> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$getWalletStatus$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$getWalletStatus$1 r0 = (com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$getWalletStatus$1) r0
            int r1 = r0.f59443j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59443j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$getWalletStatus$1 r0 = new com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$getWalletStatus$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f59441h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59443j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcRemoteDataSource r5 = r4.walletCobrandedCcRemoteDataSource
            int r2 = r4.getSelectedCountryId()
            r0.f59443j = r3
            java.lang.Object r5 = r5.getWalletStatus(r2, r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            com.talabat.feature.walletcobrandedcc.data.remote.WalletStatusResponse r5 = (com.talabat.feature.walletcobrandedcc.data.remote.WalletStatusResponse) r5
            com.talabat.feature.walletcobrandedcc.domain.model.WalletStatus r5 = com.talabat.feature.walletcobrandedcc.data.remote.WalletStatusResponseKt.toEntity(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl.getWalletStatus(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object shouldDisplayCobrandedCcInProgressNotification(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.feature.walletcobrandedcc.domain.model.CobrandedCcInProgressAppNotification> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$shouldDisplayCobrandedCcInProgressNotification$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$shouldDisplayCobrandedCcInProgressNotification$1 r0 = (com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$shouldDisplayCobrandedCcInProgressNotification$1) r0
            int r1 = r0.f59446j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59446j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$shouldDisplayCobrandedCcInProgressNotification$1 r0 = new com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl$shouldDisplayCobrandedCcInProgressNotification$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f59444h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59446j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcRemoteDataSource r5 = r4.walletCobrandedCcRemoteDataSource
            int r2 = r4.getSelectedCountryId()
            r0.f59446j = r3
            java.lang.Object r5 = r5.shouldNotifyUser(r2, r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcNotificationResponse r5 = (com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcNotificationResponse) r5
            com.talabat.feature.walletcobrandedcc.domain.model.CobrandedCcInProgressAppNotification r5 = com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcNotificationResponseKt.toEntity(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl.shouldDisplayCobrandedCcInProgressNotification(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
