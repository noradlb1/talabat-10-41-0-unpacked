package com.talabat.darkstores.feature.cart.views;

import com.talabat.darkstores.feature.campaigns.CampaignProgressState;
import com.talabat.darkstores.feature.campaigns.CampaignProgressVisualisation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartProgressContract;", "", "Presenter", "View", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CartProgressContract {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$Presenter;", "", "canShow", "", "getCanShow", "()Z", "handleVisualisation", "", "campaignVisualisation", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressVisualisation;", "onAttach", "view", "Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$View;", "onDetach", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Presenter {
        boolean getCanShow();

        void handleVisualisation(@NotNull CampaignProgressVisualisation campaignProgressVisualisation);

        void onAttach(@NotNull View view);

        void onDetach();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartProgressContract$View;", "", "animateStateChange", "", "newState", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressState;", "animateWithTransientState", "transientState", "permanentState", "updateState", "state", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface View {
        void animateStateChange(@NotNull CampaignProgressState campaignProgressState);

        void animateWithTransientState(@NotNull CampaignProgressState campaignProgressState, @NotNull CampaignProgressState campaignProgressState2);

        void updateState(@NotNull CampaignProgressState campaignProgressState);
    }
}
