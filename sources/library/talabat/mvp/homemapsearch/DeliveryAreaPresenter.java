package library.talabat.mvp.homemapsearch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Llibrary/talabat/mvp/homemapsearch/DeliveryAreaPresenter;", "Llibrary/talabat/mvp/homemapsearch/IDeliveryAreaPresenter;", "homeMapDeliveryAreaView", "Llibrary/talabat/mvp/homemapsearch/DeliveryAreaView;", "(Llibrary/talabat/mvp/homemapsearch/DeliveryAreaView;)V", "getHomeMapDeliveryAreaView", "()Llibrary/talabat/mvp/homemapsearch/DeliveryAreaView;", "setHomeMapDeliveryAreaView", "onDestroy", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryAreaPresenter implements IDeliveryAreaPresenter {
    @Nullable
    private DeliveryAreaView homeMapDeliveryAreaView;

    public DeliveryAreaPresenter(@NotNull DeliveryAreaView deliveryAreaView) {
        Intrinsics.checkNotNullParameter(deliveryAreaView, "homeMapDeliveryAreaView");
        this.homeMapDeliveryAreaView = deliveryAreaView;
    }

    @Nullable
    public final DeliveryAreaView getHomeMapDeliveryAreaView() {
        return this.homeMapDeliveryAreaView;
    }

    public void onDestroy() {
        this.homeMapDeliveryAreaView = null;
    }

    public final void setHomeMapDeliveryAreaView(@Nullable DeliveryAreaView deliveryAreaView) {
        this.homeMapDeliveryAreaView = deliveryAreaView;
    }
}
