package library.talabat.mvp.checkout.checkoutrefactor;

import com.talabat.configuration.country.Country;
import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Llibrary/talabat/mvp/checkout/checkoutrefactor/CheckoutRefactorPresenter;", "Llibrary/talabat/mvp/checkout/checkoutrefactor/ICheckoutRefactorPresenter;", "checkoutRefactorView", "Llibrary/talabat/mvp/checkout/checkoutrefactor/CheckoutRefactorView;", "(Llibrary/talabat/mvp/checkout/checkoutrefactor/CheckoutRefactorView;)V", "paymentMethodUrl", "", "getPaymentMethodUrl", "()Ljava/lang/String;", "setPaymentMethodUrl", "(Ljava/lang/String;)V", "onDebitPaymentMethodUrlUpdated", "onDebitPaymentShown", "", "paymentUrl", "onSelectingDebitCardPaymentMethod", "onSettingDebitCardPaymentMethodLabel", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutRefactorPresenter implements ICheckoutRefactorPresenter {
    @NotNull
    private final CheckoutRefactorView checkoutRefactorView;
    @NotNull
    private String paymentMethodUrl = "";

    public CheckoutRefactorPresenter(@NotNull CheckoutRefactorView checkoutRefactorView2) {
        Intrinsics.checkNotNullParameter(checkoutRefactorView2, "checkoutRefactorView");
        this.checkoutRefactorView = checkoutRefactorView2;
    }

    @NotNull
    public final String getPaymentMethodUrl() {
        return this.paymentMethodUrl;
    }

    @NotNull
    public String onDebitPaymentMethodUrlUpdated() {
        return this.paymentMethodUrl;
    }

    public void onDebitPaymentShown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "paymentUrl");
        this.paymentMethodUrl = str;
    }

    public void onSelectingDebitCardPaymentMethod() {
        int i11 = GlobalDataModel.SelectedCountryId;
        if (i11 == Country.KUWAIT.getCountryId()) {
            this.checkoutRefactorView.showKNetMessage();
        } else if (i11 == Country.BAHRAIN.getCountryId()) {
            this.checkoutRefactorView.showBenefitMessage();
        } else if (i11 == Country.QATAR.getCountryId()) {
            this.checkoutRefactorView.showQPayMessage();
        } else {
            this.checkoutRefactorView.showDebitCardMessage();
        }
    }

    public void onSettingDebitCardPaymentMethodLabel() {
        int i11 = GlobalDataModel.SelectedCountryId;
        if (i11 == Country.KUWAIT.getCountryId()) {
            this.checkoutRefactorView.setKNetLabel();
        } else if (i11 == Country.BAHRAIN.getCountryId()) {
            this.checkoutRefactorView.setBenefitLabel();
        } else if (i11 == Country.QATAR.getCountryId()) {
            this.checkoutRefactorView.setQPayLabel();
        } else {
            this.checkoutRefactorView.setDebitCardLabel();
        }
    }

    public final void setPaymentMethodUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.paymentMethodUrl = str;
    }
}
