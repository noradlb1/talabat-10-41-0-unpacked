package com.talabat.feature.helpcenter.presentation;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyView$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CancellationPolicyView f58553g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f58554h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellationPolicyView$1$1(CancellationPolicyView cancellationPolicyView, Context context) {
        super(0);
        this.f58553g = cancellationPolicyView;
        this.f58554h = context;
    }

    public final void invoke() {
        try {
            this.f58553g.cancellationPolicyViewModel.cancellationPolicyClicked();
            if (!((FragmentActivity) this.f58554h).isFinishing() && (!this.f58553g.cancellationPolicyList.isEmpty())) {
                CancellationPolicyBottomSheetKt.showCancellationBottomSheet((FragmentActivity) this.f58554h, this.f58553g.cancellationPolicyList, this.f58553g.bottomSheetTile);
            }
        } catch (NullPointerException e11) {
            LogManager.logException(e11);
        }
    }
}
