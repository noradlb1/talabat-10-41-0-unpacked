package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b¸\u0006\u0000"}, d2 = {"com/talabat/talabatcore/viewmodel/CreateCustomViewViewModel$createViewModel$factory$1", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddCardCustomView$setupCardManagementViewModel$$inlined$createViewModel$1 extends ViewModelProvider.NewInstanceFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f11946a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GenerateCardTokenUseCase f11947b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PaymentConfigurationRepository f11948c;

    public AddCardCustomView$setupCardManagementViewModel$$inlined$createViewModel$1(AddCardCustomView addCardCustomView, GenerateCardTokenUseCase generateCardTokenUseCase, PaymentConfigurationRepository paymentConfigurationRepository) {
        this.f11946a = addCardCustomView;
        this.f11947b = generateCardTokenUseCase;
        this.f11948c = paymentConfigurationRepository;
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return this.f11946a.viewModelBuilder(this.f11947b, this.f11948c);
    }
}
