package com.checkout.frames.mapper.theme;

import com.checkout.base.mapper.Mapper;
import com.checkout.frames.R;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.model.TextAlign;
import com.checkout.frames.model.font.Font;
import com.checkout.frames.model.font.FontStyle;
import com.checkout.frames.model.font.FontWeight;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import com.checkout.frames.style.component.CvvComponentStyle;
import com.checkout.frames.style.component.ExpiryDateComponentStyle;
import com.checkout.frames.style.component.PayButtonComponentStyle;
import com.checkout.frames.style.component.ScreenHeaderStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.DividerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import com.checkout.frames.style.component.p003default.DefaultCardNumberComponentStyle;
import com.checkout.frames.style.component.p003default.DefaultCvvComponentStyle;
import com.checkout.frames.style.component.p003default.DefaultExpiryDateComponentStyle;
import com.checkout.frames.style.component.p003default.DefaultLightStyle;
import com.checkout.frames.style.component.p003default.DefaultPayButtonComponentStyle;
import com.checkout.frames.style.screen.PaymentDetailsStyle;
import com.checkout.frames.style.theme.PaymentFormComponent;
import com.checkout.frames.style.theme.PaymentFormComponentField;
import com.checkout.frames.style.theme.PaymentFormTheme;
import com.checkout.frames.utils.extensions.PaymentFormStyleMapperExtensionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J4\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u001f"}, d2 = {"Lcom/checkout/frames/mapper/theme/PaymentDetailsStyleMapper;", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/theme/PaymentFormTheme;", "Lcom/checkout/frames/style/screen/PaymentDetailsStyle;", "()V", "map", "from", "provideAddressSummaryStyle", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "provideAddressSummarySubTitle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "subTitleStyle", "component", "Lcom/checkout/frames/style/theme/PaymentFormComponent;", "provideCVVStyle", "Lcom/checkout/frames/style/component/CvvComponentStyle;", "provideCardNumberStyle", "Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "provideCardSchemeStyle", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "provideExpiryDateStyle", "Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;", "providePayButtonStyle", "Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "providePaymentDetailsHeaderStyle", "Lcom/checkout/frames/style/component/ScreenHeaderStyle;", "provideSummaryComponentStyle", "addressSummaryComponentStyle", "textComponent", "addButtonComponent", "editButtonComponent", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentDetailsStyleMapper implements Mapper<PaymentFormTheme, PaymentDetailsStyle> {
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle provideAddressSummaryStyle(com.checkout.frames.style.theme.PaymentFormTheme r10) {
        /*
            r9 = this;
            java.util.List r0 = r10.getPaymentFormComponents()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.checkout.frames.style.theme.PaymentFormComponent r3 = (com.checkout.frames.style.theme.PaymentFormComponent) r3
            com.checkout.frames.style.theme.PaymentFormComponentField r4 = com.checkout.frames.style.theme.PaymentFormComponentField.BillingSummaryHeader
            java.lang.String r4 = r4.name()
            com.checkout.frames.style.theme.PaymentFormComponentField r3 = r3.getPaymentFormComponentField()
            java.lang.String r3 = r3.name()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x000a
            goto L_0x002e
        L_0x002d:
            r1 = r2
        L_0x002e:
            r6 = r1
            com.checkout.frames.style.theme.PaymentFormComponent r6 = (com.checkout.frames.style.theme.PaymentFormComponent) r6
            java.util.List r0 = r10.getPaymentFormComponents()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x003b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.checkout.frames.style.theme.PaymentFormComponent r3 = (com.checkout.frames.style.theme.PaymentFormComponent) r3
            com.checkout.frames.style.theme.PaymentFormComponentField r4 = com.checkout.frames.style.theme.PaymentFormComponentField.AddBillingSummaryButton
            java.lang.String r4 = r4.name()
            com.checkout.frames.style.theme.PaymentFormComponentField r3 = r3.getPaymentFormComponentField()
            java.lang.String r3 = r3.name()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x003b
            goto L_0x005e
        L_0x005d:
            r1 = r2
        L_0x005e:
            r7 = r1
            com.checkout.frames.style.theme.PaymentFormComponent r7 = (com.checkout.frames.style.theme.PaymentFormComponent) r7
            java.util.List r0 = r10.getPaymentFormComponents()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x006b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x008d
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.checkout.frames.style.theme.PaymentFormComponent r3 = (com.checkout.frames.style.theme.PaymentFormComponent) r3
            com.checkout.frames.style.theme.PaymentFormComponentField r4 = com.checkout.frames.style.theme.PaymentFormComponentField.EditBillingSummaryButton
            java.lang.String r4 = r4.name()
            com.checkout.frames.style.theme.PaymentFormComponentField r3 = r3.getPaymentFormComponentField()
            java.lang.String r3 = r3.name()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x006b
            goto L_0x008e
        L_0x008d:
            r1 = r2
        L_0x008e:
            r8 = r1
            com.checkout.frames.style.theme.PaymentFormComponent r8 = (com.checkout.frames.style.theme.PaymentFormComponent) r8
            java.util.List r0 = r10.getPaymentFormComponents()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x009b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00bd
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.checkout.frames.style.theme.PaymentFormComponent r3 = (com.checkout.frames.style.theme.PaymentFormComponent) r3
            com.checkout.frames.style.theme.PaymentFormComponentField r4 = com.checkout.frames.style.theme.PaymentFormComponentField.BillingSummaryPreview
            java.lang.String r4 = r4.name()
            com.checkout.frames.style.theme.PaymentFormComponentField r3 = r3.getPaymentFormComponentField()
            java.lang.String r3 = r3.name()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x009b
            goto L_0x00be
        L_0x00bd:
            r1 = r2
        L_0x00be:
            com.checkout.frames.style.theme.PaymentFormComponent r1 = (com.checkout.frames.style.theme.PaymentFormComponent) r1
            r0 = 1
            r3 = 0
            if (r1 == 0) goto L_0x00cc
            boolean r4 = r1.isFieldOptional()
            if (r4 != r0) goto L_0x00cc
            r4 = r0
            goto L_0x00cd
        L_0x00cc:
            r4 = r3
        L_0x00cd:
            if (r4 != 0) goto L_0x00f9
            if (r7 == 0) goto L_0x00d9
            boolean r4 = r7.isFieldOptional()
            if (r4 != r0) goto L_0x00d9
            r4 = r0
            goto L_0x00da
        L_0x00d9:
            r4 = r3
        L_0x00da:
            if (r4 != 0) goto L_0x00f9
            if (r8 == 0) goto L_0x00e6
            boolean r4 = r8.isFieldOptional()
            if (r4 != r0) goto L_0x00e6
            r4 = r0
            goto L_0x00e7
        L_0x00e6:
            r4 = r3
        L_0x00e7:
            if (r4 != 0) goto L_0x00f9
            if (r6 == 0) goto L_0x00f3
            boolean r4 = r6.isFieldOptional()
            if (r4 != r0) goto L_0x00f3
            r4 = r0
            goto L_0x00f4
        L_0x00f3:
            r4 = r3
        L_0x00f4:
            if (r4 == 0) goto L_0x00f7
            goto L_0x00f9
        L_0x00f7:
            r4 = r3
            goto L_0x00fa
        L_0x00f9:
            r4 = r0
        L_0x00fa:
            com.checkout.frames.style.component.default.DefaultAddressSummaryComponentStyle r5 = com.checkout.frames.style.component.p003default.DefaultAddressSummaryComponentStyle.INSTANCE
            com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle r4 = r5.light(r4)
            if (r6 == 0) goto L_0x0137
            boolean r5 = r6.isFieldHidden()
            if (r5 != 0) goto L_0x0136
            if (r1 == 0) goto L_0x0112
            boolean r1 = r1.isFieldHidden()
            if (r1 != r0) goto L_0x0112
            r1 = r0
            goto L_0x0113
        L_0x0112:
            r1 = r3
        L_0x0113:
            if (r1 != 0) goto L_0x0136
            if (r7 == 0) goto L_0x011f
            boolean r1 = r7.isFieldHidden()
            if (r1 != r0) goto L_0x011f
            r1 = r0
            goto L_0x0120
        L_0x011f:
            r1 = r3
        L_0x0120:
            if (r1 != 0) goto L_0x0136
            if (r8 == 0) goto L_0x012b
            boolean r1 = r8.isFieldHidden()
            if (r1 != r0) goto L_0x012b
            goto L_0x012c
        L_0x012b:
            r0 = r3
        L_0x012c:
            if (r0 == 0) goto L_0x012f
            goto L_0x0136
        L_0x012f:
            r3 = r9
            r5 = r10
            com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle r4 = r3.provideSummaryComponentStyle(r4, r5, r6, r7, r8)
            goto L_0x0137
        L_0x0136:
            return r2
        L_0x0137:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.mapper.theme.PaymentDetailsStyleMapper.provideAddressSummaryStyle(com.checkout.frames.style.theme.PaymentFormTheme):com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle");
    }

    private final TextLabelStyle provideAddressSummarySubTitle(TextLabelStyle textLabelStyle, PaymentFormComponent paymentFormComponent, PaymentFormTheme paymentFormTheme) {
        if (paymentFormComponent.isFieldOptional()) {
            return null;
        }
        return PaymentFormStyleMapperExtensionsKt.provideSubTitleStyle(textLabelStyle, paymentFormComponent, paymentFormTheme);
    }

    private final CvvComponentStyle provideCVVStyle(PaymentFormTheme paymentFormTheme) {
        Object obj;
        CvvComponentStyle light = DefaultCvvComponentStyle.INSTANCE.light();
        Iterator it = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.CVV.name(), (Object) ((PaymentFormComponent) obj).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent = (PaymentFormComponent) obj;
        if (paymentFormComponent == null) {
            return light;
        }
        if (paymentFormComponent.isFieldHidden()) {
            return null;
        }
        InputComponentStyle inputStyle = light.getInputStyle();
        return light.copy(InputComponentStyle.copy$default(inputStyle, PaymentFormStyleMapperExtensionsKt.provideTitleStyle(inputStyle.getTitleStyle(), paymentFormComponent, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideSubTitleStyle(inputStyle.getSubtitleStyle(), paymentFormComponent, paymentFormTheme), (TextLabelStyle) null, PaymentFormStyleMapperExtensionsKt.provideInputFieldStyle(inputStyle, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideErrorMessageStyle(inputStyle.getErrorMessageStyle(), paymentFormTheme), (ContainerStyle) null, paymentFormComponent.isFieldOptional(), 36, (Object) null));
    }

    private final CardNumberComponentStyle provideCardNumberStyle(PaymentFormTheme paymentFormTheme) {
        Object obj;
        CardNumberComponentStyle light = DefaultCardNumberComponentStyle.INSTANCE.light();
        Iterator it = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.CardNumber.name(), (Object) ((PaymentFormComponent) obj).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent = (PaymentFormComponent) obj;
        if (paymentFormComponent == null) {
            return light;
        }
        InputComponentStyle inputStyle = light.getInputStyle();
        return CardNumberComponentStyle.copy$default(light, InputComponentStyle.copy$default(inputStyle, PaymentFormStyleMapperExtensionsKt.provideTitleStyle(inputStyle.getTitleStyle(), paymentFormComponent, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideSubTitleStyle(inputStyle.getSubtitleStyle(), paymentFormComponent, paymentFormTheme), (TextLabelStyle) null, PaymentFormStyleMapperExtensionsKt.provideInputFieldStyle(inputStyle, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideErrorMessageStyle(inputStyle.getErrorMessageStyle(), paymentFormTheme), (ContainerStyle) null, paymentFormComponent.isFieldOptional(), 36, (Object) null), 0, 2, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.checkout.frames.style.theme.PaymentFormComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.checkout.frames.style.theme.PaymentFormComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.checkout.frames.style.theme.PaymentFormComponent} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.checkout.frames.style.theme.PaymentFormComponent} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.checkout.frames.style.component.CardSchemeComponentStyle provideCardSchemeStyle(com.checkout.frames.style.theme.PaymentFormTheme r14) {
        /*
            r13 = this;
            com.checkout.frames.style.component.default.DefaultLightStyle r0 = com.checkout.frames.style.component.p003default.DefaultLightStyle.INSTANCE
            r1 = 3
            r2 = 0
            com.checkout.frames.style.component.CardSchemeComponentStyle r3 = com.checkout.frames.style.component.p003default.DefaultLightStyle.cardSchemeComponentStyle$default(r0, r2, r2, r1, r2)
            java.util.List r0 = r14.getPaymentFormComponents()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r0.next()
            r4 = r1
            com.checkout.frames.style.theme.PaymentFormComponent r4 = (com.checkout.frames.style.theme.PaymentFormComponent) r4
            com.checkout.frames.style.theme.PaymentFormComponentField r5 = com.checkout.frames.style.theme.PaymentFormComponentField.CardScheme
            java.lang.String r5 = r5.name()
            com.checkout.frames.style.theme.PaymentFormComponentField r4 = r4.getPaymentFormComponentField()
            java.lang.String r4 = r4.name()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0012
            r2 = r1
        L_0x0034:
            com.checkout.frames.style.theme.PaymentFormComponent r2 = (com.checkout.frames.style.theme.PaymentFormComponent) r2
            if (r2 == 0) goto L_0x005d
            com.checkout.frames.style.component.base.TextLabelStyle r0 = r3.getTitleStyle()
            com.checkout.frames.style.component.base.TextLabelStyle r14 = com.checkout.frames.utils.extensions.PaymentFormStyleMapperExtensionsKt.provideTitleStyle(r0, r2, r14)
            if (r14 != 0) goto L_0x0052
            com.checkout.frames.style.component.base.TextLabelStyle r14 = new com.checkout.frames.style.component.base.TextLabelStyle
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 63
            r12 = 0
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            goto L_0x0053
        L_0x0052:
            r4 = r14
        L_0x0053:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            com.checkout.frames.style.component.CardSchemeComponentStyle r3 = com.checkout.frames.style.component.CardSchemeComponentStyle.copy$default(r3, r4, r5, r6, r7, r8, r9)
        L_0x005d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.mapper.theme.PaymentDetailsStyleMapper.provideCardSchemeStyle(com.checkout.frames.style.theme.PaymentFormTheme):com.checkout.frames.style.component.CardSchemeComponentStyle");
    }

    private final ExpiryDateComponentStyle provideExpiryDateStyle(PaymentFormTheme paymentFormTheme) {
        Object obj;
        ExpiryDateComponentStyle light = DefaultExpiryDateComponentStyle.INSTANCE.light();
        Iterator it = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.ExpiryDate.name(), (Object) ((PaymentFormComponent) obj).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent = (PaymentFormComponent) obj;
        if (paymentFormComponent == null) {
            return light;
        }
        InputComponentStyle inputStyle = light.getInputStyle();
        return light.copy(InputComponentStyle.copy$default(inputStyle, PaymentFormStyleMapperExtensionsKt.provideTitleStyle(inputStyle.getTitleStyle(), paymentFormComponent, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideSubTitleStyle(inputStyle.getSubtitleStyle(), paymentFormComponent, paymentFormTheme), (TextLabelStyle) null, PaymentFormStyleMapperExtensionsKt.provideInputFieldStyle(inputStyle, paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideErrorMessageStyle(inputStyle.getErrorMessageStyle(), paymentFormTheme), (ContainerStyle) null, paymentFormComponent.isFieldOptional(), 36, (Object) null));
    }

    private final PayButtonComponentStyle providePayButtonStyle(PaymentFormTheme paymentFormTheme) {
        Object obj;
        PayButtonComponentStyle light = DefaultPayButtonComponentStyle.INSTANCE.light();
        Iterator it = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.PaymentDetailsButton.name(), (Object) ((PaymentFormComponent) obj).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent = (PaymentFormComponent) obj;
        if (paymentFormComponent != null) {
            return light.copy(PaymentFormStyleMapperExtensionsKt.provideSolidButtonStyle(light.getButtonStyle(), paymentFormTheme, paymentFormComponent));
        }
        return light;
    }

    private final ScreenHeaderStyle providePaymentDetailsHeaderStyle(PaymentFormTheme paymentFormTheme) {
        Object obj;
        ScreenHeaderStyle screenHeader$default = DefaultLightStyle.screenHeader$default(DefaultLightStyle.INSTANCE, (String) null, Integer.valueOf(R.string.cko_payment_details_title), Integer.valueOf(R.drawable.cko_ic_arrow_back), 0, (FontWeight) null, (Font) null, 0, (Padding) null, 0, 0, 0, (Padding) null, 4089, (Object) null);
        Iterator it = paymentFormTheme.getPaymentFormComponents().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) PaymentFormComponentField.PaymentHeaderTitle.name(), (Object) ((PaymentFormComponent) obj).getPaymentFormComponentField().name())) {
                break;
            }
        }
        PaymentFormComponent paymentFormComponent = (PaymentFormComponent) obj;
        if (paymentFormComponent == null) {
            return screenHeader$default;
        }
        return screenHeader$default.copy(PaymentFormStyleMapperExtensionsKt.provideText(screenHeader$default.getText(), paymentFormComponent.getTitleText()), PaymentFormStyleMapperExtensionsKt.provideTextId(screenHeader$default.getTextId(), paymentFormComponent.getTitleText(), paymentFormComponent.getTitleTextId()), TextStyle.copy$default(screenHeader$default.getTextStyle(), 0, paymentFormTheme.getPaymentFormThemeColors().getTextColors().getTitleColor(), (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 509, (Object) null), ImageStyle.copy$default(screenHeader$default.getBackIconStyle(), paymentFormComponent.getBackIconImageResourceID(), paymentFormTheme.getPaymentFormThemeColors().getImageColors().getTinColor(), (Integer) null, (Integer) null, (Padding) null, 28, (Object) null), ContainerStyle.copy$default(screenHeader$default.getContainerStyle(), paymentFormTheme.getPaymentFormThemeColors().getPaymentFormColors().getBackground(), (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, (Margin) null, 254, (Object) null));
    }

    private final AddressSummaryComponentStyle provideSummaryComponentStyle(AddressSummaryComponentStyle addressSummaryComponentStyle, PaymentFormTheme paymentFormTheme, PaymentFormComponent paymentFormComponent, PaymentFormComponent paymentFormComponent2, PaymentFormComponent paymentFormComponent3) {
        DividerStyle dividerStyle;
        PaymentFormTheme paymentFormTheme2 = paymentFormTheme;
        PaymentFormComponent paymentFormComponent4 = paymentFormComponent;
        TextLabelStyle provideTitleStyle = PaymentFormStyleMapperExtensionsKt.provideTitleStyle(addressSummaryComponentStyle.getTitleStyle(), paymentFormComponent4, paymentFormTheme2);
        TextLabelStyle provideAddressSummarySubTitle = provideAddressSummarySubTitle(addressSummaryComponentStyle.getSubTitleStyle(), paymentFormComponent4, paymentFormTheme2);
        ButtonStyle provideOutLinedButtonStyle = PaymentFormStyleMapperExtensionsKt.provideOutLinedButtonStyle(addressSummaryComponentStyle.getAddAddressButtonStyle(), paymentFormTheme2, paymentFormComponent2);
        AddressSummarySectionStyle summarySectionStyle = addressSummaryComponentStyle.getSummarySectionStyle();
        ButtonStyle provideOutLinedButtonStyle2 = PaymentFormStyleMapperExtensionsKt.provideOutLinedButtonStyle(addressSummaryComponentStyle.getSummarySectionStyle().getEditAddressButtonStyle(), paymentFormTheme2, paymentFormComponent3);
        TextLabelStyle copy$default = TextLabelStyle.copy$default(addressSummaryComponentStyle.getSummarySectionStyle().getAddressTextStyle(), (String) null, (Integer) null, PaymentFormStyleMapperExtensionsKt.provideTitleTextStyle(addressSummaryComponentStyle.getSummarySectionStyle().getAddressTextStyle(), paymentFormTheme2), (ImageStyle) null, (ImageStyle) null, (ContainerStyle) null, 59, (Object) null);
        DividerStyle dividerStyle2 = addressSummaryComponentStyle.getSummarySectionStyle().getDividerStyle();
        if (dividerStyle2 != null) {
            dividerStyle = DividerStyle.copy$default(dividerStyle2, 0, paymentFormTheme.getPaymentFormThemeColors().getDividerColor().getColor(), (Margin) null, 5, (Object) null);
        } else {
            dividerStyle = null;
        }
        BorderStroke borderStroke = new BorderStroke(1, paymentFormTheme.getPaymentFormThemeColors().getButtonColors().getContainerColor());
        Margin margin = new Margin(8, 8, 0, 0, 12, (DefaultConstructorMarker) null);
        return AddressSummaryComponentStyle.copy$default(addressSummaryComponentStyle, provideTitleStyle, provideAddressSummarySubTitle, provideOutLinedButtonStyle, summarySectionStyle.copy(copy$default, dividerStyle, provideOutLinedButtonStyle2, new ContainerStyle(paymentFormTheme.getPaymentFormThemeColors().getInputFieldColors().getInputFieldBackgroundColor(), (Shape) null, paymentFormTheme.getPaymentFormCornerRadius().getAddressSummaryCornerRadius(), borderStroke, (Integer) null, (Integer) null, (Padding) null, margin, 114, (DefaultConstructorMarker) null)), ContainerStyle.copy$default(addressSummaryComponentStyle.getContainerStyle(), 0, paymentFormTheme.getPaymentFormShape().getAddressSummaryShape(), (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, new Padding(0, 0, 6, 6, 3, (DefaultConstructorMarker) null), (Margin) null, 189, (Object) null), false, 32, (Object) null);
    }

    @NotNull
    public PaymentDetailsStyle map(@NotNull PaymentFormTheme paymentFormTheme) {
        PaymentFormTheme paymentFormTheme2 = paymentFormTheme;
        Intrinsics.checkNotNullParameter(paymentFormTheme2, "from");
        return new PaymentDetailsStyle(providePaymentDetailsHeaderStyle(paymentFormTheme), provideCardSchemeStyle(paymentFormTheme), provideCardNumberStyle(paymentFormTheme), provideExpiryDateStyle(paymentFormTheme), provideCVVStyle(paymentFormTheme), provideAddressSummaryStyle(paymentFormTheme), providePayButtonStyle(paymentFormTheme), PaymentFormStyleMapperExtensionsKt.provideContainerStyle(paymentFormTheme2, new Padding(0, 0, 16, 16, 3, (DefaultConstructorMarker) null)));
    }
}
