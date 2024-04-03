package com.checkout.frames.mapper.theme;

import androidx.compose.foundation.text.KeyboardOptions;
import com.checkout.base.mapper.Mapper;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.TextAlign;
import com.checkout.frames.model.font.Font;
import com.checkout.frames.model.font.FontStyle;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields;
import com.checkout.frames.style.component.CountryComponentStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.CursorStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldIndicatorStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.style.component.billingformdetails.InputComponentsContainerStyle;
import com.checkout.frames.style.component.p003default.DefaultCountryComponentStyle;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import com.checkout.frames.style.screen.BillingFormStyle;
import com.checkout.frames.style.screen.CountryPickerStyle;
import com.checkout.frames.style.screen.p004default.DefaultBillingAddressDetailsStyle;
import com.checkout.frames.style.screen.p004default.DefaultCountryPickerStyle;
import com.checkout.frames.style.theme.PaymentFormComponent;
import com.checkout.frames.style.theme.PaymentFormComponentField;
import com.checkout.frames.style.theme.PaymentFormTheme;
import com.checkout.frames.utils.extensions.PaymentFormStyleMapperExtensionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J$\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J$\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/mapper/theme/BillingFormStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/theme/PaymentFormTheme;", "Lcom/checkout/frames/style/screen/BillingFormStyle;", "()V", "map", "from", "provideComponentStyle", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "component", "Lcom/checkout/frames/style/theme/PaymentFormComponent;", "inputComponentStyle", "provideCountryComponentStyle", "Lcom/checkout/frames/style/component/CountryComponentStyle;", "provideCountryPickerStyle", "Lcom/checkout/frames/style/screen/CountryPickerStyle;", "provideHeaderComponentStyle", "Lcom/checkout/frames/style/component/billingformdetails/HeaderComponentStyle;", "provideInputComponentStyle", "provideInputComponentsContainerStyle", "Lcom/checkout/frames/style/component/billingformdetails/InputComponentsContainerStyle;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingFormStyleMapper implements Mapper<PaymentFormTheme, BillingFormStyle> {
    private final InputComponentStyle provideComponentStyle(PaymentFormComponent paymentFormComponent, InputComponentStyle inputComponentStyle, PaymentFormTheme paymentFormTheme) {
        if (!paymentFormComponent.isFieldHidden()) {
            return provideInputComponentStyle(inputComponentStyle, paymentFormComponent, paymentFormTheme);
        }
        return null;
    }

    private final CountryComponentStyle provideCountryComponentStyle(PaymentFormTheme paymentFormTheme) {
        Object obj;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = DefaultCountryComponentStyle.INSTANCE.light();
        Iterator it = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.Country.name(), (Object) ((PaymentFormComponent) obj).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent = (PaymentFormComponent) obj;
        if (paymentFormComponent != null) {
            InputComponentStyle inputStyle = ((CountryComponentStyle) objectRef.element).getInputStyle();
            objectRef.element = ((CountryComponentStyle) objectRef.element).copy(InputComponentStyle.copy$default(inputStyle, PaymentFormStyleMapperExtensionsKt.provideTitleStyle(inputStyle.getTitleStyle(), paymentFormComponent, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideSubTitleStyle(inputStyle.getSubtitleStyle(), paymentFormComponent, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideInfoStyle(inputStyle.getInfoStyle(), paymentFormComponent, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideInputFieldStyle(inputStyle, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideErrorMessageStyle(inputStyle.getErrorMessageStyle(), paymentFormTheme), (ContainerStyle) null, false, 96, (Object) null));
        }
        return (CountryComponentStyle) objectRef.element;
    }

    private final CountryPickerStyle provideCountryPickerStyle(PaymentFormTheme paymentFormTheme) {
        Object obj;
        TextLabelStyle textLabelStyle;
        ImageStyle imageStyle;
        ImageStyle imageStyle2;
        TextLabelStyle textLabelStyle2;
        PaymentFormTheme paymentFormTheme2 = paymentFormTheme;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = DefaultCountryPickerStyle.INSTANCE.light();
        Iterator it = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.CountryPicker.name(), (Object) ((PaymentFormComponent) obj).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent = (PaymentFormComponent) obj;
        if (paymentFormComponent != null) {
            CountryPickerStyle countryPickerStyle = (CountryPickerStyle) objectRef.element;
            TextLabelStyle provideTitleStyle = PaymentFormStyleMapperExtensionsKt.provideTitleStyle(countryPickerStyle.getScreenTitleStyle(), paymentFormComponent, paymentFormTheme2);
            if (provideTitleStyle == null) {
                textLabelStyle = new TextLabelStyle((String) null, (Integer) null, (TextStyle) null, (ImageStyle) null, (ImageStyle) null, (ContainerStyle) null, 63, (DefaultConstructorMarker) null);
            } else {
                textLabelStyle = provideTitleStyle;
            }
            InputFieldStyle searchFieldStyle = countryPickerStyle.getSearchFieldStyle();
            TextStyle copy$default = TextStyle.copy$default(countryPickerStyle.getSearchFieldStyle().getTextStyle(), 0, paymentFormTheme.getPaymentFormThemeColors().getTextColors().getTitleColor(), (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 509, (Object) null);
            TextStyle copy$default2 = TextStyle.copy$default(countryPickerStyle.getSearchFieldStyle().getPlaceholderStyle(), 0, paymentFormTheme.getPaymentFormThemeColors().getTextColors().getSubTitleColor(), (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 509, (Object) null);
            InputFieldIndicatorStyle provideIndicatorStyle = PaymentFormStyleMapperExtensionsKt.provideIndicatorStyle(paymentFormTheme);
            ImageStyle leadingIconStyle = countryPickerStyle.getSearchFieldStyle().getLeadingIconStyle();
            if (leadingIconStyle != null) {
                imageStyle = ImageStyle.copy$default(leadingIconStyle, (Integer) null, paymentFormTheme.getPaymentFormThemeColors().getImageColors().getTinColor(), (Integer) null, (Integer) null, (Padding) null, 29, (Object) null);
            } else {
                imageStyle = null;
            }
            ImageStyle trailingIconStyle = countryPickerStyle.getSearchFieldStyle().getTrailingIconStyle();
            if (trailingIconStyle != null) {
                imageStyle2 = ImageStyle.copy$default(trailingIconStyle, (Integer) null, paymentFormTheme.getPaymentFormThemeColors().getImageColors().getTinColor(), (Integer) null, (Integer) null, (Padding) null, 29, (Object) null);
            } else {
                imageStyle2 = null;
            }
            InputFieldStyle copy$default3 = InputFieldStyle.copy$default(searchFieldStyle, copy$default, (String) null, (Integer) null, copy$default2, PaymentFormStyleMapperExtensionsKt.provideInputFieldContainerStyle(countryPickerStyle.getSearchFieldStyle().getContainerStyle(), paymentFormTheme2), provideIndicatorStyle, imageStyle, imageStyle2, (CursorStyle) null, (KeyboardOptions) null, 774, (Object) null);
            TextLabelStyle provideTitleStyle2 = PaymentFormStyleMapperExtensionsKt.provideTitleStyle(countryPickerStyle.getSearchItemStyle(), paymentFormComponent, paymentFormTheme2);
            if (provideTitleStyle2 == null) {
                textLabelStyle2 = new TextLabelStyle((String) null, (Integer) null, (TextStyle) null, (ImageStyle) null, (ImageStyle) null, (ContainerStyle) null, 63, (DefaultConstructorMarker) null);
            } else {
                textLabelStyle2 = provideTitleStyle2;
            }
            objectRef.element = CountryPickerStyle.copy$default(countryPickerStyle, textLabelStyle, copy$default3, textLabelStyle2, PaymentFormStyleMapperExtensionsKt.provideContainerStyle$default(paymentFormTheme2, (Padding) null, 1, (Object) null), false, 16, (Object) null);
        }
        return (CountryPickerStyle) objectRef.element;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.checkout.frames.style.theme.PaymentFormComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.checkout.frames.style.theme.PaymentFormComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.checkout.frames.style.theme.PaymentFormComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.checkout.frames.style.theme.PaymentFormComponent} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle provideHeaderComponentStyle(com.checkout.frames.style.theme.PaymentFormTheme r13) {
        /*
            r12 = this;
            com.checkout.frames.style.screen.default.DefaultBillingAddressDetailsStyle r0 = com.checkout.frames.style.screen.p004default.DefaultBillingAddressDetailsStyle.INSTANCE
            com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle r1 = r0.headerComponentStyle()
            java.util.List r0 = r13.getPaymentFormComponents()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r0.next()
            r4 = r2
            com.checkout.frames.style.theme.PaymentFormComponent r4 = (com.checkout.frames.style.theme.PaymentFormComponent) r4
            com.checkout.frames.style.theme.PaymentFormComponentField r5 = com.checkout.frames.style.theme.PaymentFormComponentField.BillingDetailsHeader
            java.lang.String r5 = r5.name()
            com.checkout.frames.style.theme.PaymentFormComponentField r4 = r4.getPaymentFormComponentField()
            java.lang.String r4 = r4.name()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0010
            goto L_0x0034
        L_0x0033:
            r2 = r3
        L_0x0034:
            com.checkout.frames.style.theme.PaymentFormComponent r2 = (com.checkout.frames.style.theme.PaymentFormComponent) r2
            java.util.List r0 = r13.getPaymentFormComponents()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0040:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0062
            java.lang.Object r4 = r0.next()
            r5 = r4
            com.checkout.frames.style.theme.PaymentFormComponent r5 = (com.checkout.frames.style.theme.PaymentFormComponent) r5
            com.checkout.frames.style.theme.PaymentFormComponentField r6 = com.checkout.frames.style.theme.PaymentFormComponentField.BillingDetailsHeaderButton
            java.lang.String r6 = r6.name()
            com.checkout.frames.style.theme.PaymentFormComponentField r5 = r5.getPaymentFormComponentField()
            java.lang.String r5 = r5.name()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0040
            r3 = r4
        L_0x0062:
            r0 = r3
            com.checkout.frames.style.theme.PaymentFormComponent r0 = (com.checkout.frames.style.theme.PaymentFormComponent) r0
            if (r2 == 0) goto L_0x0088
            com.checkout.frames.style.component.base.TextLabelStyle r3 = r1.getHeaderTitleStyle()
            com.checkout.frames.style.component.base.TextLabelStyle r2 = com.checkout.frames.utils.extensions.PaymentFormStyleMapperExtensionsKt.provideTitleStyle(r3, r2, r13)
            if (r2 != 0) goto L_0x0080
            com.checkout.frames.style.component.base.TextLabelStyle r2 = new com.checkout.frames.style.component.base.TextLabelStyle
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 63
            r11 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x0080:
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle r1 = com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle.copy$default(r1, r2, r3, r4, r5, r6)
        L_0x0088:
            r2 = r1
            if (r0 == 0) goto L_0x009b
            r3 = 0
            com.checkout.frames.style.component.base.ButtonStyle r1 = r2.getHeaderButtonStyle()
            com.checkout.frames.style.component.base.ButtonStyle r4 = com.checkout.frames.utils.extensions.PaymentFormStyleMapperExtensionsKt.provideSolidButtonStyle(r1, r13, r0)
            r5 = 0
            r6 = 5
            r7 = 0
            com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle r2 = com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle.copy$default(r2, r3, r4, r5, r6, r7)
        L_0x009b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.mapper.theme.BillingFormStyleMapper.provideHeaderComponentStyle(com.checkout.frames.style.theme.PaymentFormTheme):com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle");
    }

    private final InputComponentStyle provideInputComponentStyle(InputComponentStyle inputComponentStyle, PaymentFormComponent paymentFormComponent, PaymentFormTheme paymentFormTheme) {
        if (inputComponentStyle == null) {
            return null;
        }
        return InputComponentStyle.copy$default(inputComponentStyle, PaymentFormStyleMapperExtensionsKt.provideTitleStyle(inputComponentStyle.getTitleStyle(), paymentFormComponent, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideSubTitleStyle(inputComponentStyle.getSubtitleStyle(), paymentFormComponent, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideInfoStyle(inputComponentStyle.getInfoStyle(), paymentFormComponent, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideInputFieldStyle(inputComponentStyle, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideErrorMessageStyle(inputComponentStyle.getErrorMessageStyle(), paymentFormTheme), (ContainerStyle) null, paymentFormComponent.isFieldOptional(), 32, (Object) null);
    }

    private final InputComponentsContainerStyle provideInputComponentsContainerStyle(PaymentFormTheme paymentFormTheme) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        InputComponentStyle provideComponentStyle;
        InputComponentStyle provideComponentStyle2;
        InputComponentStyle provideComponentStyle3;
        InputComponentStyle provideComponentStyle4;
        InputComponentStyle provideComponentStyle5;
        InputComponentStyle provideComponentStyle6;
        InputComponentsContainerStyle inputComponentsContainerStyle = DefaultBillingAddressDetailsStyle.INSTANCE.inputComponentsContainerStyle();
        LinkedHashMap<BillingFormFields, InputComponentStyle> inputComponentStyleValues = inputComponentsContainerStyle.getInputComponentStyleValues();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.AddressLineOne.name(), (Object) ((PaymentFormComponent) obj).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent = (PaymentFormComponent) obj;
        BillingFormFields billingFormFields = BillingFormFields.AddressLineOne;
        InputComponentStyle inputComponentStyle = inputComponentStyleValues.get(billingFormFields);
        if (!(paymentFormComponent == null || (provideComponentStyle6 = provideComponentStyle(paymentFormComponent, inputComponentStyle, paymentFormTheme)) == null)) {
            linkedHashMap.put(billingFormFields, provideComponentStyle6);
        }
        Iterator it2 = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.AddressLineTwo.name(), (Object) ((PaymentFormComponent) obj2).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent2 = (PaymentFormComponent) obj2;
        BillingFormFields billingFormFields2 = BillingFormFields.AddressLineTwo;
        InputComponentStyle inputComponentStyle2 = inputComponentStyleValues.get(billingFormFields2);
        if (!(paymentFormComponent2 == null || (provideComponentStyle5 = provideComponentStyle(paymentFormComponent2, inputComponentStyle2, paymentFormTheme)) == null)) {
            linkedHashMap.put(billingFormFields2, provideComponentStyle5);
        }
        Iterator it3 = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it3.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.City.name(), (Object) ((PaymentFormComponent) obj3).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent3 = (PaymentFormComponent) obj3;
        BillingFormFields billingFormFields3 = BillingFormFields.City;
        InputComponentStyle inputComponentStyle3 = inputComponentStyleValues.get(billingFormFields3);
        if (!(paymentFormComponent3 == null || (provideComponentStyle4 = provideComponentStyle(paymentFormComponent3, inputComponentStyle3, paymentFormTheme)) == null)) {
            linkedHashMap.put(billingFormFields3, provideComponentStyle4);
        }
        Iterator it4 = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it4.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.State.name(), (Object) ((PaymentFormComponent) obj4).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent4 = (PaymentFormComponent) obj4;
        BillingFormFields billingFormFields4 = BillingFormFields.State;
        InputComponentStyle inputComponentStyle4 = inputComponentStyleValues.get(billingFormFields4);
        if (!(paymentFormComponent4 == null || (provideComponentStyle3 = provideComponentStyle(paymentFormComponent4, inputComponentStyle4, paymentFormTheme)) == null)) {
            linkedHashMap.put(billingFormFields4, provideComponentStyle3);
        }
        Iterator it5 = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj5 = null;
                break;
            }
            obj5 = it5.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.PostCode.name(), (Object) ((PaymentFormComponent) obj5).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent5 = (PaymentFormComponent) obj5;
        BillingFormFields billingFormFields5 = BillingFormFields.PostCode;
        InputComponentStyle inputComponentStyle5 = inputComponentStyleValues.get(billingFormFields5);
        if (!(paymentFormComponent5 == null || (provideComponentStyle2 = provideComponentStyle(paymentFormComponent5, inputComponentStyle5, paymentFormTheme)) == null)) {
            linkedHashMap.put(billingFormFields5, provideComponentStyle2);
        }
        Iterator it6 = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it6.hasNext()) {
                obj6 = null;
                break;
            }
            obj6 = it6.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.Phone.name(), (Object) ((PaymentFormComponent) obj6).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent6 = (PaymentFormComponent) obj6;
        BillingFormFields billingFormFields6 = BillingFormFields.Phone;
        InputComponentStyle inputComponentStyle6 = inputComponentStyleValues.get(billingFormFields6);
        if (!(paymentFormComponent6 == null || (provideComponentStyle = provideComponentStyle(paymentFormComponent6, inputComponentStyle6, paymentFormTheme)) == null)) {
            linkedHashMap.put(billingFormFields6, provideComponentStyle);
        }
        if (!linkedHashMap.isEmpty()) {
            return InputComponentsContainerStyle.copy$default(inputComponentsContainerStyle, linkedHashMap, (ContainerStyle) null, 2, (Object) null);
        }
        return inputComponentsContainerStyle;
    }

    @NotNull
    public BillingFormStyle map(@NotNull PaymentFormTheme paymentFormTheme) {
        Intrinsics.checkNotNullParameter(paymentFormTheme, "from");
        return new BillingFormStyle(new BillingAddressDetailsStyle(provideHeaderComponentStyle(paymentFormTheme), provideInputComponentsContainerStyle(paymentFormTheme), provideCountryComponentStyle(paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideContainerStyle$default(paymentFormTheme, (Padding) null, 1, (Object) null)), provideCountryPickerStyle(paymentFormTheme));
    }
}
