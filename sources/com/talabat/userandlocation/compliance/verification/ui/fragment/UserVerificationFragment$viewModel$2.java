package com.talabat.userandlocation.compliance.verification.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.userandlocation.compliance.verification.di.factory.UserVerificationViewModelFactory;
import com.talabat.userandlocation.compliance.verification.presentation.viewmodel.UserVerificationViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/userandlocation/compliance/verification/presentation/viewmodel/UserVerificationViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UserVerificationFragment$viewModel$2 extends Lambda implements Function0<UserVerificationViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ UserVerificationFragment f12326g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserVerificationFragment$viewModel$2(UserVerificationFragment userVerificationFragment) {
        super(0);
        this.f12326g = userVerificationFragment;
    }

    @NotNull
    public final UserVerificationViewModel invoke() {
        UserVerificationFragment userVerificationFragment = this.f12326g;
        UserVerificationViewModelFactory.Companion companion = UserVerificationViewModelFactory.Companion;
        FragmentActivity requireActivity = userVerificationFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return (UserVerificationViewModel) ViewModelProviders.of((Fragment) userVerificationFragment, (ViewModelProvider.Factory) companion.newInstance(requireActivity)).get(UserVerificationViewModel.class);
    }
}
