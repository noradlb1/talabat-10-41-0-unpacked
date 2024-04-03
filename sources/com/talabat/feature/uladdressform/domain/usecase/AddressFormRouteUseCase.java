package com.talabat.feature.uladdressform.domain.usecase;

import com.talabat.feature.uladdressform.domain.repository.AddressFormFWFRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/uladdressform/domain/usecase/AddressFormRouteUseCase;", "", "repository", "Lcom/talabat/feature/uladdressform/domain/repository/AddressFormFWFRepository;", "(Lcom/talabat/feature/uladdressform/domain/repository/AddressFormFWFRepository;)V", "flutterAddressFormEnable", "", "screenType", "", "flutterAddressFormMultiLayoutEnable", "com_talabat_feature_ul-address-form_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressFormRouteUseCase {
    @NotNull
    private final AddressFormFWFRepository repository;

    @Inject
    public AddressFormRouteUseCase(@NotNull AddressFormFWFRepository addressFormFWFRepository) {
        Intrinsics.checkNotNullParameter(addressFormFWFRepository, "repository");
        this.repository = addressFormFWFRepository;
    }

    public final boolean flutterAddressFormEnable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        return this.repository.flutterAddressFormEnable(str);
    }

    public final boolean flutterAddressFormMultiLayoutEnable() {
        return this.repository.flutterAddressFormMultiLayoutEnable();
    }
}
