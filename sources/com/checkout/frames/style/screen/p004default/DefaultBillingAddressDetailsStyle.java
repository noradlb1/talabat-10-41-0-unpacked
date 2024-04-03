package com.checkout.frames.style.screen.p004default;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import com.checkout.frames.R;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle;
import com.checkout.frames.style.component.billingformdetails.InputComponentsContainerStyle;
import com.checkout.frames.style.component.p003default.DefaultButtonStyle;
import com.checkout.frames.style.component.p003default.DefaultLightStyle;
import com.checkout.frames.utils.constants.BillingAddressDetailsConstants;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/checkout/frames/style/screen/default/DefaultBillingAddressDetailsStyle;", "", "()V", "fetchInputComponentStyleValues", "Ljava/util/LinkedHashMap;", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingFormFields;", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lkotlin/collections/LinkedHashMap;", "headerComponentStyle", "Lcom/checkout/frames/style/component/billingformdetails/HeaderComponentStyle;", "inputComponentsContainerStyle", "Lcom/checkout/frames/style/component/billingformdetails/InputComponentsContainerStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.checkout.frames.style.screen.default.DefaultBillingAddressDetailsStyle  reason: invalid package */
public final class DefaultBillingAddressDetailsStyle {
    public static final int $stable = 0;
    @NotNull
    public static final DefaultBillingAddressDetailsStyle INSTANCE = new DefaultBillingAddressDetailsStyle();

    private DefaultBillingAddressDetailsStyle() {
    }

    @NotNull
    public final LinkedHashMap<BillingFormFields, InputComponentStyle> fetchInputComponentStyleValues() {
        ImeAction.Companion companion = ImeAction.Companion;
        KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, 0, companion.m5190getNexteUduSuo(), 7, (DefaultConstructorMarker) null);
        LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap = new LinkedHashMap<>();
        BillingFormFields billingFormFields = BillingFormFields.AddressLineOne;
        DefaultLightStyle defaultLightStyle = DefaultLightStyle.INSTANCE;
        KeyboardOptions keyboardOptions2 = keyboardOptions;
        BillingFormFields billingFormFields2 = billingFormFields;
        LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap2 = linkedHashMap;
        linkedHashMap2.put(billingFormFields2, DefaultLightStyle.inputComponentStyle$default(defaultLightStyle, (String) null, Integer.valueOf(R.string.cko_billing_form_input_field_address_line_one), (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, false, new Padding(0, 20, 16, 16, 1, (DefaultConstructorMarker) null), (Margin) null, false, keyboardOptions2, 1533, (Object) null));
        BillingFormFields billingFormFields3 = BillingFormFields.AddressLineTwo;
        Integer valueOf = Integer.valueOf(R.string.cko_billing_form_input_field_address_line_two);
        int i11 = R.string.cko_input_field_optional_info;
        BillingFormFields billingFormFields4 = billingFormFields3;
        LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap3 = linkedHashMap2;
        linkedHashMap3.put(billingFormFields4, DefaultLightStyle.inputComponentStyle$default(defaultLightStyle, (String) null, valueOf, (String) null, (Integer) null, (String) null, Integer.valueOf(i11), (String) null, (Integer) null, false, new Padding(0, 20, 16, 16, 1, (DefaultConstructorMarker) null), (Margin) null, true, keyboardOptions2, 1501, (Object) null));
        BillingFormFields billingFormFields5 = BillingFormFields.City;
        LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap4 = linkedHashMap3;
        linkedHashMap4.put(billingFormFields5, DefaultLightStyle.inputComponentStyle$default(defaultLightStyle, (String) null, Integer.valueOf(R.string.cko_billing_form_input_field_city), (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, false, new Padding(0, 20, 16, 16, 1, (DefaultConstructorMarker) null), (Margin) null, false, keyboardOptions2, 1533, (Object) null));
        BillingFormFields billingFormFields6 = BillingFormFields.State;
        LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap5 = linkedHashMap4;
        linkedHashMap5.put(billingFormFields6, DefaultLightStyle.inputComponentStyle$default(defaultLightStyle, (String) null, Integer.valueOf(R.string.cko_billing_form_input_field_state), (String) null, (Integer) null, (String) null, Integer.valueOf(i11), (String) null, (Integer) null, false, new Padding(0, 20, 16, 16, 1, (DefaultConstructorMarker) null), (Margin) null, true, keyboardOptions2, 1501, (Object) null));
        LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap6 = linkedHashMap5;
        linkedHashMap6.put(BillingFormFields.PostCode, DefaultLightStyle.inputComponentStyle$default(defaultLightStyle, (String) null, Integer.valueOf(R.string.cko_billing_form_input_field_postcode), (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, false, new Padding(0, 20, 16, 16, 1, (DefaultConstructorMarker) null), (Margin) null, false, keyboardOptions2, 1533, (Object) null));
        DefaultLightStyle defaultLightStyle2 = defaultLightStyle;
        linkedHashMap6.put(BillingFormFields.Phone, DefaultLightStyle.inputComponentStyle$default(defaultLightStyle2, (String) null, Integer.valueOf(R.string.cko_billing_form_input_field_phone_title), (String) null, Integer.valueOf(R.string.cko_billing_form_input_field_phone_subtitle), (String) null, (Integer) null, (String) null, (Integer) null, false, new Padding(0, 20, 16, 16, 1, (DefaultConstructorMarker) null), (Margin) null, false, new KeyboardOptions(0, false, KeyboardType.Companion.m5223getNumberPjHm6EE(), companion.m5188getDoneeUduSuo(), 3, (DefaultConstructorMarker) null), 1525, (Object) null));
        linkedHashMap6.put(BillingFormFields.Country, DefaultLightStyle.inputComponentStyle$default(defaultLightStyle2, (String) null, Integer.valueOf(R.string.cko_country_picker_screen_title), (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, false, new Padding(0, 20, 16, 16, 1, (DefaultConstructorMarker) null), (Margin) null, false, (KeyboardOptions) null, 5629, (Object) null));
        return linkedHashMap6;
    }

    @NotNull
    public final HeaderComponentStyle headerComponentStyle() {
        TextLabelStyle screenTitleTextLabelStyle = DefaultLightStyle.INSTANCE.screenTitleTextLabelStyle(new Padding(14, 16, 0, 0));
        DefaultButtonStyle defaultButtonStyle = DefaultButtonStyle.INSTANCE;
        int i11 = R.string.cko_billing_form_button_save;
        Shape shape = Shape.RoundCorner;
        CornerRadius cornerRadius = r2;
        CornerRadius cornerRadius2 = new CornerRadius(8);
        Padding padding = r2;
        Padding padding2 = new Padding(6, 6, 18, 18);
        Margin margin = r8;
        Margin margin2 = new Margin(14, 0, 0, 16, 6, (DefaultConstructorMarker) null);
        return new HeaderComponentStyle(screenTitleTextLabelStyle, DefaultButtonStyle.lightSolid$default(defaultButtonStyle, (String) null, Integer.valueOf(i11), 4294967295L, 4278935536L, 4285690482L, BillingAddressDetailsConstants.buttonDisabledContainerColor, shape, cornerRadius, padding, (ImageStyle) null, (ImageStyle) null, margin, (FontWeight) null, 5633, (Object) null), (ContainerStyle) null, 4, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final InputComponentsContainerStyle inputComponentsContainerStyle() {
        return new InputComponentsContainerStyle(fetchInputComponentStyleValues(), (ContainerStyle) null, 2, (DefaultConstructorMarker) null);
    }
}
