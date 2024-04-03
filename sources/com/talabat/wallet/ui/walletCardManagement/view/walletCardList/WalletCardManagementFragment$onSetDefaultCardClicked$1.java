package com.talabat.wallet.ui.walletCardManagement.view.walletCardList;

import android.view.View;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletSetDefaultCardRequestModel;
import com.talabat.talabatcommon.utils.ProgressBarLoading;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel;
import com.talabat.wallet.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletCardManagementFragment$onSetDefaultCardClicked$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletCardManagementFragment f12734g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f12735h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardManagementFragment$onSetDefaultCardClicked$1(WalletCardManagementFragment walletCardManagementFragment, String str) {
        super(0);
        this.f12734g = walletCardManagementFragment;
        this.f12735h = str;
    }

    public final void invoke() {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = this.f12734g._$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.showProgress(_$_findCachedViewById);
        WalletCardManagementViewModel access$getViewModel$p = this.f12734g.viewModel;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        access$getViewModel$p.onLoadSetDefaultCard(new WalletSetDefaultCardRequestModel(this.f12735h));
    }
}
