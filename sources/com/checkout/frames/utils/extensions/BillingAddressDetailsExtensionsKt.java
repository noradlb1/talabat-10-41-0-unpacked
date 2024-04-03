package com.checkout.frames.utils.extensions;

import androidx.annotation.StringRes;
import com.checkout.frames.R;
import com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields;
import com.checkout.tokenization.model.Address;
import com.checkout.tokenization.model.Phone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u001a\u0010\u0007\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"getErrorMessage", "", "Lcom/checkout/frames/component/billingaddressfields/BillingAddressInputComponentState;", "provideAddressFieldText", "", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingAddress;", "addressFieldName", "provideBillingAddressDetails", "", "country", "Lcom/checkout/base/model/Country;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsExtensionsKt {
    @StringRes
    public static final int getErrorMessage(@NotNull BillingAddressInputComponentState billingAddressInputComponentState) {
        Intrinsics.checkNotNullParameter(billingAddressInputComponentState, "<this>");
        String addressFieldName = billingAddressInputComponentState.getAddressFieldName();
        if (Intrinsics.areEqual((Object) addressFieldName, (Object) BillingFormFields.AddressLineOne.name())) {
            return R.string.cko_billing_form_input_field_address_line_one_error;
        }
        if (Intrinsics.areEqual((Object) addressFieldName, (Object) BillingFormFields.AddressLineTwo.name())) {
            return R.string.cko_billing_form_input_field_address_line_two_error;
        }
        if (Intrinsics.areEqual((Object) addressFieldName, (Object) BillingFormFields.City.name())) {
            return R.string.cko_billing_form_input_field_city_error;
        }
        if (Intrinsics.areEqual((Object) addressFieldName, (Object) BillingFormFields.State.name())) {
            return R.string.cko_billing_form_input_field_state_error;
        }
        if (Intrinsics.areEqual((Object) addressFieldName, (Object) BillingFormFields.PostCode.name())) {
            return R.string.cko_billing_form_input_field_post_code_error;
        }
        if (Intrinsics.areEqual((Object) addressFieldName, (Object) BillingFormFields.Phone.name())) {
            return R.string.cko_billing_form_input_field_phone_number_error;
        }
        return 0;
    }

    @NotNull
    public static final String provideAddressFieldText(@NotNull BillingAddress billingAddress, @NotNull String str) {
        Phone phone;
        String number;
        Intrinsics.checkNotNullParameter(billingAddress, "<this>");
        Intrinsics.checkNotNullParameter(str, "addressFieldName");
        if (Intrinsics.areEqual((Object) str, (Object) BillingFormFields.AddressLineOne.name())) {
            Address address = billingAddress.getAddress();
            if (address == null || (number = address.getAddressLine1()) == null) {
                return "";
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) BillingFormFields.AddressLineTwo.name())) {
            Address address2 = billingAddress.getAddress();
            if (address2 == null || (number = address2.getAddressLine2()) == null) {
                return "";
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) BillingFormFields.City.name())) {
            Address address3 = billingAddress.getAddress();
            if (address3 == null || (number = address3.getCity()) == null) {
                return "";
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) BillingFormFields.State.name())) {
            Address address4 = billingAddress.getAddress();
            if (address4 == null || (number = address4.getState()) == null) {
                return "";
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) BillingFormFields.PostCode.name())) {
            Address address5 = billingAddress.getAddress();
            if (address5 == null || (number = address5.getZip()) == null) {
                return "";
            }
        } else if (!Intrinsics.areEqual((Object) str, (Object) BillingFormFields.Phone.name()) || (phone = billingAddress.getPhone()) == null || (number = phone.getNumber()) == null) {
            return "";
        }
        return number;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress provideBillingAddressDetails(@org.jetbrains.annotations.NotNull java.util.List<com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState> r10, @org.jetbrains.annotations.NotNull com.checkout.base.model.Country r11) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "country"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress r0 = new com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress
            r0.<init>()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r1 = r10.iterator()
        L_0x0015:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r1.next()
            r4 = r2
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r4 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r4
            java.lang.String r4 = r4.getAddressFieldName()
            com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields r5 = com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields.Phone
            java.lang.String r5 = r5.name()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0015
            goto L_0x0035
        L_0x0034:
            r2 = r3
        L_0x0035:
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r2 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r2
            java.util.Iterator r1 = r10.iterator()
        L_0x003b:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0059
            java.lang.Object r4 = r1.next()
            r5 = r4
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r5 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r5
            java.lang.String r5 = r5.getAddressFieldName()
            com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields r6 = com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields.AddressLineOne
            java.lang.String r6 = r6.name()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x003b
            goto L_0x005a
        L_0x0059:
            r4 = r3
        L_0x005a:
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r4 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r4
            java.util.Iterator r1 = r10.iterator()
        L_0x0060:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x007e
            java.lang.Object r5 = r1.next()
            r6 = r5
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r6 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r6
            java.lang.String r6 = r6.getAddressFieldName()
            com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields r7 = com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields.AddressLineTwo
            java.lang.String r7 = r7.name()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0060
            goto L_0x007f
        L_0x007e:
            r5 = r3
        L_0x007f:
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r5 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r5
            java.util.Iterator r1 = r10.iterator()
        L_0x0085:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x00a3
            java.lang.Object r6 = r1.next()
            r7 = r6
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r7 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r7
            java.lang.String r7 = r7.getAddressFieldName()
            com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields r8 = com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields.State
            java.lang.String r8 = r8.name()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0085
            goto L_0x00a4
        L_0x00a3:
            r6 = r3
        L_0x00a4:
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r6 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r6
            java.util.Iterator r1 = r10.iterator()
        L_0x00aa:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00c8
            java.lang.Object r7 = r1.next()
            r8 = r7
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r8 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r8
            java.lang.String r8 = r8.getAddressFieldName()
            com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields r9 = com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields.City
            java.lang.String r9 = r9.name()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x00aa
            goto L_0x00c9
        L_0x00c8:
            r7 = r3
        L_0x00c9:
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r7 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r7
            java.util.Iterator r10 = r10.iterator()
        L_0x00cf:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00ed
            java.lang.Object r1 = r10.next()
            r8 = r1
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r8 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r8
            java.lang.String r8 = r8.getAddressFieldName()
            com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields r9 = com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields.PostCode
            java.lang.String r9 = r9.name()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x00cf
            r3 = r1
        L_0x00ed:
            com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState r3 = (com.checkout.frames.component.billingaddressfields.BillingAddressInputComponentState) r3
            com.checkout.tokenization.model.Phone r10 = new com.checkout.tokenization.model.Phone
            java.lang.String r1 = ""
            if (r2 == 0) goto L_0x0103
            androidx.compose.runtime.MutableState r2 = r2.getAddressFieldText()
            if (r2 == 0) goto L_0x0103
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0104
        L_0x0103:
            r2 = r1
        L_0x0104:
            r10.<init>(r2, r11)
            r0.setPhone(r10)
            com.checkout.tokenization.model.Address r10 = r0.getAddress()
            if (r10 == 0) goto L_0x01aa
            r10.setCountry(r11)
            if (r4 == 0) goto L_0x012d
            androidx.compose.runtime.MutableState r11 = r4.getAddressFieldText()
            if (r11 == 0) goto L_0x012d
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x012d
            java.lang.CharSequence r11 = kotlin.text.StringsKt__StringsKt.trimEnd((java.lang.CharSequence) r11)
            java.lang.String r11 = r11.toString()
            if (r11 != 0) goto L_0x012e
        L_0x012d:
            r11 = r1
        L_0x012e:
            r10.setAddressLine1(r11)
            if (r5 == 0) goto L_0x014b
            androidx.compose.runtime.MutableState r11 = r5.getAddressFieldText()
            if (r11 == 0) goto L_0x014b
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x014b
            java.lang.CharSequence r11 = kotlin.text.StringsKt__StringsKt.trimEnd((java.lang.CharSequence) r11)
            java.lang.String r11 = r11.toString()
            if (r11 != 0) goto L_0x014c
        L_0x014b:
            r11 = r1
        L_0x014c:
            r10.setAddressLine2(r11)
            if (r6 == 0) goto L_0x0169
            androidx.compose.runtime.MutableState r11 = r6.getAddressFieldText()
            if (r11 == 0) goto L_0x0169
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0169
            java.lang.CharSequence r11 = kotlin.text.StringsKt__StringsKt.trimEnd((java.lang.CharSequence) r11)
            java.lang.String r11 = r11.toString()
            if (r11 != 0) goto L_0x016a
        L_0x0169:
            r11 = r1
        L_0x016a:
            r10.setState(r11)
            if (r7 == 0) goto L_0x0187
            androidx.compose.runtime.MutableState r11 = r7.getAddressFieldText()
            if (r11 == 0) goto L_0x0187
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0187
            java.lang.CharSequence r11 = kotlin.text.StringsKt__StringsKt.trimEnd((java.lang.CharSequence) r11)
            java.lang.String r11 = r11.toString()
            if (r11 != 0) goto L_0x0188
        L_0x0187:
            r11 = r1
        L_0x0188:
            r10.setCity(r11)
            if (r3 == 0) goto L_0x01a7
            androidx.compose.runtime.MutableState r11 = r3.getAddressFieldText()
            if (r11 == 0) goto L_0x01a7
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x01a7
            java.lang.CharSequence r11 = kotlin.text.StringsKt__StringsKt.trimEnd((java.lang.CharSequence) r11)
            java.lang.String r11 = r11.toString()
            if (r11 != 0) goto L_0x01a6
            goto L_0x01a7
        L_0x01a6:
            r1 = r11
        L_0x01a7:
            r10.setZip(r1)
        L_0x01aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.utils.extensions.BillingAddressDetailsExtensionsKt.provideBillingAddressDetails(java.util.List, com.checkout.base.model.Country):com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress");
    }
}
