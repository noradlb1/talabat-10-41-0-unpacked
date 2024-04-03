package com.checkout.frames.screen.billingaddress.usecase;

import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.billingformdetails.BillingAddressInputComponentStyle;
import com.checkout.frames.style.screen.BillingAddressDetailsStyle;
import com.checkout.frames.style.screen.p004default.DefaultBillingAddressDetailsStyle;
import com.checkout.frames.style.view.BillingAddressInputComponentViewStyle;
import com.checkout.frames.style.view.billingformdetails.BillingAddressInputComponentsViewContainerStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/checkout/frames/screen/billingaddress/usecase/BillingAddressInputComponentStyleUseCase;", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;", "Lcom/checkout/frames/style/view/billingformdetails/BillingAddressInputComponentsViewContainerStyle;", "billingAddressInputComponentStyleMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/frames/style/component/billingformdetails/BillingAddressInputComponentStyle;", "Lcom/checkout/frames/style/view/BillingAddressInputComponentViewStyle;", "(Lcom/checkout/base/mapper/Mapper;)V", "addMandatoryInputComponentViewStyleList", "", "defaultInputComponentViewStyleList", "inputComponentViewStyleList", "execute", "data", "provideDefaultInputComponentViewStyleList", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressInputComponentStyleUseCase implements UseCase<BillingAddressDetailsStyle, BillingAddressInputComponentsViewContainerStyle> {
    @NotNull
    private final Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentViewStyle> billingAddressInputComponentStyleMapper;

    public BillingAddressInputComponentStyleUseCase(@NotNull Mapper<BillingAddressInputComponentStyle, BillingAddressInputComponentViewStyle> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "billingAddressInputComponentStyleMapper");
        this.billingAddressInputComponentStyleMapper = mapper;
    }

    private final List<BillingAddressInputComponentViewStyle> addMandatoryInputComponentViewStyleList(List<BillingAddressInputComponentViewStyle> list, List<BillingAddressInputComponentViewStyle> list2) {
        Object obj;
        for (BillingFormFields billingFormFields : BillingFormFields.Companion.fetchAllMandatoryBillingFormFields()) {
            Iterable iterable = list2;
            boolean z11 = true;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.areEqual((Object) ((BillingAddressInputComponentViewStyle) it.next()).getAddressFieldName(), (Object) billingFormFields.name())) {
                            z11 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z11) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (Intrinsics.areEqual((Object) ((BillingAddressInputComponentViewStyle) obj).getAddressFieldName(), (Object) billingFormFields.name())) {
                        break;
                    }
                }
                BillingAddressInputComponentViewStyle billingAddressInputComponentViewStyle = (BillingAddressInputComponentViewStyle) obj;
                if (billingAddressInputComponentViewStyle != null) {
                    list2.add(billingAddressInputComponentViewStyle);
                }
            }
        }
        return list2;
    }

    private final List<BillingAddressInputComponentViewStyle> provideDefaultInputComponentViewStyleList() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : DefaultBillingAddressDetailsStyle.INSTANCE.fetchInputComponentStyleValues().entrySet()) {
            arrayList.add(this.billingAddressInputComponentStyleMapper.map(new BillingAddressInputComponentStyle(((BillingFormFields) next.getKey()).name(), (InputComponentStyle) next.getValue())));
        }
        return arrayList;
    }

    @NotNull
    public BillingAddressInputComponentsViewContainerStyle execute(@NotNull BillingAddressDetailsStyle billingAddressDetailsStyle) {
        Intrinsics.checkNotNullParameter(billingAddressDetailsStyle, "data");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : billingAddressDetailsStyle.getInputComponentsContainerStyle().getInputComponentStyleValues().entrySet()) {
            arrayList.add(this.billingAddressInputComponentStyleMapper.map(new BillingAddressInputComponentStyle(((BillingFormFields) next.getKey()).name(), (InputComponentStyle) next.getValue())));
        }
        return new BillingAddressInputComponentsViewContainerStyle(addMandatoryInputComponentViewStyleList(provideDefaultInputComponentViewStyleList(), arrayList));
    }
}
