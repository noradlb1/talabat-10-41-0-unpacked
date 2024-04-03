package com.checkout.frames.style.theme;

import androidx.compose.runtime.internal.StabilityInferred;
import com.adyen.checkout.core.model.Address;
import com.checkout.frames.R;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019JÖ\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/checkout/frames/style/theme/DefaultPaymentFormTheme;", "", "()V", "addBillingSummaryButton", "Lcom/checkout/frames/style/theme/PaymentFormComponent;", "addressLineOne", "addressLineTwo", "billingDetailsHeader", "billingDetailsHeaderButton", "billingSummaryHeader", "billingSummaryPreview", "cardNumber", "cardScheme", "city", "country", "countryPicker", "cvv", "editBillingSummaryButton", "expiryDate", "payButton", "paymentHeaderTitle", "phone", "postCode", "state", "provideComponents", "", "providePaymentFormComponents", "billingSummaryTextStyle", "billingSummaryContainer", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultPaymentFormTheme {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultPaymentFormTheme INSTANCE = new DefaultPaymentFormTheme();
    @NotNull
    private static final PaymentFormComponent addBillingSummaryButton = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.AddBillingSummaryButton).build();
    @NotNull
    private static final PaymentFormComponent addressLineOne = new PaymentFormComponentBuilder().setPaymentFormField(PaymentFormComponentField.AddressLineOne).setIsFieldOptional(false).setIsFieldHidden(false).build();
    @NotNull
    private static final PaymentFormComponent addressLineTwo = new PaymentFormComponentBuilder().setIsFieldOptional(true).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.AddressLineTwo).build();
    @NotNull
    private static final PaymentFormComponent billingDetailsHeader = new PaymentFormComponentBuilder().setPaymentFormField(PaymentFormComponentField.BillingDetailsHeader).build();
    @NotNull
    private static final PaymentFormComponent billingDetailsHeaderButton = new PaymentFormComponentBuilder().setPaymentFormField(PaymentFormComponentField.BillingDetailsHeaderButton).build();
    @NotNull
    private static final PaymentFormComponent billingSummaryHeader = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.BillingSummaryHeader).build();
    @NotNull
    private static final PaymentFormComponent billingSummaryPreview = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.BillingSummaryPreview).build();
    @NotNull
    private static final PaymentFormComponent cardNumber = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.CardNumber).build();
    @NotNull
    private static final PaymentFormComponent cardScheme = new PaymentFormComponentBuilder().setPaymentFormField(PaymentFormComponentField.CardScheme).build();
    @NotNull
    private static final PaymentFormComponent city = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.City).build();
    @NotNull
    private static final PaymentFormComponent country = new PaymentFormComponentBuilder().setPaymentFormField(PaymentFormComponentField.Country).build();
    @NotNull
    private static final PaymentFormComponent countryPicker = new PaymentFormComponentBuilder().setPaymentFormField(PaymentFormComponentField.CountryPicker).build();
    @NotNull
    private static final PaymentFormComponent cvv = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.CVV).build();
    @NotNull
    private static final PaymentFormComponent editBillingSummaryButton = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.EditBillingSummaryButton).build();
    @NotNull
    private static final PaymentFormComponent expiryDate = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.ExpiryDate).build();
    @NotNull
    private static final PaymentFormComponent payButton = new PaymentFormComponentBuilder().setPaymentFormField(PaymentFormComponentField.PaymentDetailsButton).build();
    @NotNull
    private static final PaymentFormComponent paymentHeaderTitle = new PaymentFormComponentBuilder().setPaymentFormField(PaymentFormComponentField.PaymentHeaderTitle).setBackIconImage(R.drawable.cko_ic_arrow_back).build();
    @NotNull
    private static final PaymentFormComponent phone = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.Phone).build();
    @NotNull
    private static final PaymentFormComponent postCode = new PaymentFormComponentBuilder().setIsFieldOptional(false).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.PostCode).build();
    @NotNull
    private static final PaymentFormComponent state = new PaymentFormComponentBuilder().setIsFieldOptional(true).setIsFieldHidden(false).setPaymentFormField(PaymentFormComponentField.State).build();

    private DefaultPaymentFormTheme() {
    }

    public static /* synthetic */ List providePaymentFormComponents$default(DefaultPaymentFormTheme defaultPaymentFormTheme, PaymentFormComponent paymentFormComponent, PaymentFormComponent paymentFormComponent2, PaymentFormComponent paymentFormComponent3, PaymentFormComponent paymentFormComponent4, PaymentFormComponent paymentFormComponent5, PaymentFormComponent paymentFormComponent6, PaymentFormComponent paymentFormComponent7, PaymentFormComponent paymentFormComponent8, PaymentFormComponent paymentFormComponent9, PaymentFormComponent paymentFormComponent10, PaymentFormComponent paymentFormComponent11, PaymentFormComponent paymentFormComponent12, PaymentFormComponent paymentFormComponent13, PaymentFormComponent paymentFormComponent14, PaymentFormComponent paymentFormComponent15, PaymentFormComponent paymentFormComponent16, PaymentFormComponent paymentFormComponent17, PaymentFormComponent paymentFormComponent18, PaymentFormComponent paymentFormComponent19, PaymentFormComponent paymentFormComponent20, int i11, Object obj) {
        int i12 = i11;
        return defaultPaymentFormTheme.providePaymentFormComponents((i12 & 1) != 0 ? paymentHeaderTitle : paymentFormComponent, (i12 & 2) != 0 ? cardScheme : paymentFormComponent2, (i12 & 4) != 0 ? cardNumber : paymentFormComponent3, (i12 & 8) != 0 ? expiryDate : paymentFormComponent4, (i12 & 16) != 0 ? cvv : paymentFormComponent5, (i12 & 32) != 0 ? billingSummaryHeader : paymentFormComponent6, (i12 & 64) != 0 ? addBillingSummaryButton : paymentFormComponent7, (i12 & 128) != 0 ? editBillingSummaryButton : paymentFormComponent8, (i12 & 256) != 0 ? billingSummaryPreview : paymentFormComponent9, (i12 & 512) != 0 ? payButton : paymentFormComponent10, (i12 & 1024) != 0 ? billingDetailsHeader : paymentFormComponent11, (i12 & 2048) != 0 ? billingDetailsHeaderButton : paymentFormComponent12, (i12 & 4096) != 0 ? addressLineOne : paymentFormComponent13, (i12 & 8192) != 0 ? addressLineTwo : paymentFormComponent14, (i12 & 16384) != 0 ? city : paymentFormComponent15, (i12 & 32768) != 0 ? state : paymentFormComponent16, (i12 & 65536) != 0 ? postCode : paymentFormComponent17, (i12 & 131072) != 0 ? phone : paymentFormComponent18, (i12 & 262144) != 0 ? country : paymentFormComponent19, (i12 & 524288) != 0 ? countryPicker : paymentFormComponent20);
    }

    @NotNull
    public final List<PaymentFormComponent> provideComponents() {
        return providePaymentFormComponents$default(this, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048575, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents() {
        return providePaymentFormComponents$default(this, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048575, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        return providePaymentFormComponents$default(this, paymentFormComponent, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048574, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048572, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048568, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048560, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048544, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048512, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048448, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048320, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1048064, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1047552, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent11, "billingDetailsHeader");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, paymentFormComponent11, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1046528, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11, @NotNull PaymentFormComponent paymentFormComponent12) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent11, "billingDetailsHeader");
        Intrinsics.checkNotNullParameter(paymentFormComponent12, "billingDetailsHeaderButton");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, paymentFormComponent11, paymentFormComponent12, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1044480, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11, @NotNull PaymentFormComponent paymentFormComponent12, @NotNull PaymentFormComponent paymentFormComponent13) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent11, "billingDetailsHeader");
        Intrinsics.checkNotNullParameter(paymentFormComponent12, "billingDetailsHeaderButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent13, "addressLineOne");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, paymentFormComponent11, paymentFormComponent12, paymentFormComponent13, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1040384, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11, @NotNull PaymentFormComponent paymentFormComponent12, @NotNull PaymentFormComponent paymentFormComponent13, @NotNull PaymentFormComponent paymentFormComponent14) {
        Intrinsics.checkNotNullParameter(paymentFormComponent, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent11, "billingDetailsHeader");
        Intrinsics.checkNotNullParameter(paymentFormComponent12, "billingDetailsHeaderButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent13, "addressLineOne");
        Intrinsics.checkNotNullParameter(paymentFormComponent14, "addressLineTwo");
        return providePaymentFormComponents$default(this, paymentFormComponent, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, paymentFormComponent11, paymentFormComponent12, paymentFormComponent13, paymentFormComponent14, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1032192, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11, @NotNull PaymentFormComponent paymentFormComponent12, @NotNull PaymentFormComponent paymentFormComponent13, @NotNull PaymentFormComponent paymentFormComponent14, @NotNull PaymentFormComponent paymentFormComponent15) {
        PaymentFormComponent paymentFormComponent16 = paymentFormComponent;
        Intrinsics.checkNotNullParameter(paymentFormComponent16, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent11, "billingDetailsHeader");
        Intrinsics.checkNotNullParameter(paymentFormComponent12, "billingDetailsHeaderButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent13, "addressLineOne");
        Intrinsics.checkNotNullParameter(paymentFormComponent14, "addressLineTwo");
        Intrinsics.checkNotNullParameter(paymentFormComponent15, Address.KEY_CITY);
        return providePaymentFormComponents$default(this, paymentFormComponent16, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, paymentFormComponent11, paymentFormComponent12, paymentFormComponent13, paymentFormComponent14, paymentFormComponent15, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 1015808, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11, @NotNull PaymentFormComponent paymentFormComponent12, @NotNull PaymentFormComponent paymentFormComponent13, @NotNull PaymentFormComponent paymentFormComponent14, @NotNull PaymentFormComponent paymentFormComponent15, @NotNull PaymentFormComponent paymentFormComponent16) {
        PaymentFormComponent paymentFormComponent17 = paymentFormComponent;
        Intrinsics.checkNotNullParameter(paymentFormComponent17, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent11, "billingDetailsHeader");
        Intrinsics.checkNotNullParameter(paymentFormComponent12, "billingDetailsHeaderButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent13, "addressLineOne");
        Intrinsics.checkNotNullParameter(paymentFormComponent14, "addressLineTwo");
        Intrinsics.checkNotNullParameter(paymentFormComponent15, Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(paymentFormComponent16, "state");
        return providePaymentFormComponents$default(this, paymentFormComponent17, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, paymentFormComponent11, paymentFormComponent12, paymentFormComponent13, paymentFormComponent14, paymentFormComponent15, paymentFormComponent16, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 983040, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11, @NotNull PaymentFormComponent paymentFormComponent12, @NotNull PaymentFormComponent paymentFormComponent13, @NotNull PaymentFormComponent paymentFormComponent14, @NotNull PaymentFormComponent paymentFormComponent15, @NotNull PaymentFormComponent paymentFormComponent16, @NotNull PaymentFormComponent paymentFormComponent17) {
        PaymentFormComponent paymentFormComponent18 = paymentFormComponent;
        Intrinsics.checkNotNullParameter(paymentFormComponent18, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent11, "billingDetailsHeader");
        Intrinsics.checkNotNullParameter(paymentFormComponent12, "billingDetailsHeaderButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent13, "addressLineOne");
        Intrinsics.checkNotNullParameter(paymentFormComponent14, "addressLineTwo");
        Intrinsics.checkNotNullParameter(paymentFormComponent15, Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(paymentFormComponent16, "state");
        Intrinsics.checkNotNullParameter(paymentFormComponent17, "postCode");
        return providePaymentFormComponents$default(this, paymentFormComponent18, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, paymentFormComponent11, paymentFormComponent12, paymentFormComponent13, paymentFormComponent14, paymentFormComponent15, paymentFormComponent16, paymentFormComponent17, (PaymentFormComponent) null, (PaymentFormComponent) null, (PaymentFormComponent) null, 917504, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11, @NotNull PaymentFormComponent paymentFormComponent12, @NotNull PaymentFormComponent paymentFormComponent13, @NotNull PaymentFormComponent paymentFormComponent14, @NotNull PaymentFormComponent paymentFormComponent15, @NotNull PaymentFormComponent paymentFormComponent16, @NotNull PaymentFormComponent paymentFormComponent17, @NotNull PaymentFormComponent paymentFormComponent18) {
        PaymentFormComponent paymentFormComponent19 = paymentFormComponent;
        Intrinsics.checkNotNullParameter(paymentFormComponent19, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent11, "billingDetailsHeader");
        Intrinsics.checkNotNullParameter(paymentFormComponent12, "billingDetailsHeaderButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent13, "addressLineOne");
        Intrinsics.checkNotNullParameter(paymentFormComponent14, "addressLineTwo");
        Intrinsics.checkNotNullParameter(paymentFormComponent15, Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(paymentFormComponent16, "state");
        Intrinsics.checkNotNullParameter(paymentFormComponent17, "postCode");
        Intrinsics.checkNotNullParameter(paymentFormComponent18, "phone");
        return providePaymentFormComponents$default(this, paymentFormComponent19, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, paymentFormComponent11, paymentFormComponent12, paymentFormComponent13, paymentFormComponent14, paymentFormComponent15, paymentFormComponent16, paymentFormComponent17, paymentFormComponent18, (PaymentFormComponent) null, (PaymentFormComponent) null, 786432, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11, @NotNull PaymentFormComponent paymentFormComponent12, @NotNull PaymentFormComponent paymentFormComponent13, @NotNull PaymentFormComponent paymentFormComponent14, @NotNull PaymentFormComponent paymentFormComponent15, @NotNull PaymentFormComponent paymentFormComponent16, @NotNull PaymentFormComponent paymentFormComponent17, @NotNull PaymentFormComponent paymentFormComponent18, @NotNull PaymentFormComponent paymentFormComponent19) {
        PaymentFormComponent paymentFormComponent20 = paymentFormComponent;
        Intrinsics.checkNotNullParameter(paymentFormComponent20, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent2, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent3, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent4, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent5, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent6, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent7, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent8, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent9, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent10, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent11, "billingDetailsHeader");
        Intrinsics.checkNotNullParameter(paymentFormComponent12, "billingDetailsHeaderButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent13, "addressLineOne");
        Intrinsics.checkNotNullParameter(paymentFormComponent14, "addressLineTwo");
        Intrinsics.checkNotNullParameter(paymentFormComponent15, Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(paymentFormComponent16, "state");
        Intrinsics.checkNotNullParameter(paymentFormComponent17, "postCode");
        Intrinsics.checkNotNullParameter(paymentFormComponent18, "phone");
        Intrinsics.checkNotNullParameter(paymentFormComponent19, "country");
        return providePaymentFormComponents$default(this, paymentFormComponent20, paymentFormComponent2, paymentFormComponent3, paymentFormComponent4, paymentFormComponent5, paymentFormComponent6, paymentFormComponent7, paymentFormComponent8, paymentFormComponent9, paymentFormComponent10, paymentFormComponent11, paymentFormComponent12, paymentFormComponent13, paymentFormComponent14, paymentFormComponent15, paymentFormComponent16, paymentFormComponent17, paymentFormComponent18, paymentFormComponent19, (PaymentFormComponent) null, 524288, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final List<PaymentFormComponent> providePaymentFormComponents(@NotNull PaymentFormComponent paymentFormComponent, @NotNull PaymentFormComponent paymentFormComponent2, @NotNull PaymentFormComponent paymentFormComponent3, @NotNull PaymentFormComponent paymentFormComponent4, @NotNull PaymentFormComponent paymentFormComponent5, @NotNull PaymentFormComponent paymentFormComponent6, @NotNull PaymentFormComponent paymentFormComponent7, @NotNull PaymentFormComponent paymentFormComponent8, @NotNull PaymentFormComponent paymentFormComponent9, @NotNull PaymentFormComponent paymentFormComponent10, @NotNull PaymentFormComponent paymentFormComponent11, @NotNull PaymentFormComponent paymentFormComponent12, @NotNull PaymentFormComponent paymentFormComponent13, @NotNull PaymentFormComponent paymentFormComponent14, @NotNull PaymentFormComponent paymentFormComponent15, @NotNull PaymentFormComponent paymentFormComponent16, @NotNull PaymentFormComponent paymentFormComponent17, @NotNull PaymentFormComponent paymentFormComponent18, @NotNull PaymentFormComponent paymentFormComponent19, @NotNull PaymentFormComponent paymentFormComponent20) {
        PaymentFormComponent paymentFormComponent21 = paymentFormComponent;
        PaymentFormComponent paymentFormComponent22 = paymentFormComponent2;
        PaymentFormComponent paymentFormComponent23 = paymentFormComponent3;
        PaymentFormComponent paymentFormComponent24 = paymentFormComponent4;
        PaymentFormComponent paymentFormComponent25 = paymentFormComponent5;
        PaymentFormComponent paymentFormComponent26 = paymentFormComponent6;
        PaymentFormComponent paymentFormComponent27 = paymentFormComponent7;
        PaymentFormComponent paymentFormComponent28 = paymentFormComponent8;
        PaymentFormComponent paymentFormComponent29 = paymentFormComponent9;
        PaymentFormComponent paymentFormComponent30 = paymentFormComponent10;
        PaymentFormComponent paymentFormComponent31 = paymentFormComponent11;
        PaymentFormComponent paymentFormComponent32 = paymentFormComponent12;
        PaymentFormComponent paymentFormComponent33 = paymentFormComponent13;
        PaymentFormComponent paymentFormComponent34 = paymentFormComponent14;
        PaymentFormComponent paymentFormComponent35 = paymentFormComponent16;
        Intrinsics.checkNotNullParameter(paymentFormComponent21, "paymentHeaderTitle");
        Intrinsics.checkNotNullParameter(paymentFormComponent22, "cardScheme");
        Intrinsics.checkNotNullParameter(paymentFormComponent23, "cardNumber");
        Intrinsics.checkNotNullParameter(paymentFormComponent24, "expiryDate");
        Intrinsics.checkNotNullParameter(paymentFormComponent25, CardTokenizationPlugin.ARG_CVV_KEY);
        Intrinsics.checkNotNullParameter(paymentFormComponent26, "billingSummaryTextStyle");
        Intrinsics.checkNotNullParameter(paymentFormComponent27, "addBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent28, "editBillingSummaryButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent29, "billingSummaryContainer");
        Intrinsics.checkNotNullParameter(paymentFormComponent30, "payButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent31, "billingDetailsHeader");
        Intrinsics.checkNotNullParameter(paymentFormComponent32, "billingDetailsHeaderButton");
        Intrinsics.checkNotNullParameter(paymentFormComponent33, "addressLineOne");
        Intrinsics.checkNotNullParameter(paymentFormComponent34, "addressLineTwo");
        Intrinsics.checkNotNullParameter(paymentFormComponent15, Address.KEY_CITY);
        Intrinsics.checkNotNullParameter(paymentFormComponent16, "state");
        Intrinsics.checkNotNullParameter(paymentFormComponent17, "postCode");
        Intrinsics.checkNotNullParameter(paymentFormComponent18, "phone");
        Intrinsics.checkNotNullParameter(paymentFormComponent19, "country");
        Intrinsics.checkNotNullParameter(paymentFormComponent20, "countryPicker");
        return CollectionsKt__CollectionsKt.listOf(paymentFormComponent21, paymentFormComponent22, paymentFormComponent23, paymentFormComponent24, paymentFormComponent25, paymentFormComponent26, paymentFormComponent27, paymentFormComponent28, paymentFormComponent29, paymentFormComponent30, paymentFormComponent31, paymentFormComponent32, paymentFormComponent33, paymentFormComponent34, paymentFormComponent15, paymentFormComponent16, paymentFormComponent17, paymentFormComponent18, paymentFormComponent19, paymentFormComponent20);
    }
}
