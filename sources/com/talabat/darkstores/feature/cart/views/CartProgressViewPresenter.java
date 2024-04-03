package com.talabat.darkstores.feature.cart.views;

import com.talabat.darkstores.feature.campaigns.CampaignProgressState;
import com.talabat.darkstores.feature.campaigns.CampaignProgressVisualisation;
import com.talabat.darkstores.feature.cart.views.CartProgressContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartProgressViewPresenter;", "Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$Presenter;", "()V", "canShow", "", "getCanShow", "()Z", "previousState", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "view", "Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$View;", "handleVisualisation", "", "campaignVisualisation", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressVisualisation;", "onAttach", "onDetach", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartProgressViewPresenter implements CartProgressContract.Presenter {
    @Nullable
    private CampaignProgressState previousState;
    @Nullable
    private CartProgressContract.View view;

    public boolean getCanShow() {
        CampaignProgressState campaignProgressState = this.previousState;
        return campaignProgressState != null && !Intrinsics.areEqual((Object) campaignProgressState, (Object) CampaignProgressState.Hidden.INSTANCE);
    }

    public void handleVisualisation(@NotNull CampaignProgressVisualisation campaignProgressVisualisation) {
        Intrinsics.checkNotNullParameter(campaignProgressVisualisation, "campaignVisualisation");
        CampaignProgressState component1 = campaignProgressVisualisation.component1();
        CampaignProgressState component2 = campaignProgressVisualisation.component2();
        CampaignProgressState campaignProgressState = this.previousState;
        if (component1 != null) {
            CartProgressContract.View view2 = this.view;
            if (view2 != null) {
                view2.animateWithTransientState(component1, component2);
            }
        } else if (campaignProgressState == null || Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(campaignProgressState.getClass()), (Object) Reflection.getOrCreateKotlinClass(component2.getClass()))) {
            CartProgressContract.View view3 = this.view;
            if (view3 != null) {
                view3.updateState(component2);
            }
        } else {
            CartProgressContract.View view4 = this.view;
            if (view4 != null) {
                view4.animateStateChange(component2);
            }
        }
        this.previousState = component2;
    }

    public void onAttach(@NotNull CartProgressContract.View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
    }

    public void onDetach() {
        this.view = null;
    }
}
