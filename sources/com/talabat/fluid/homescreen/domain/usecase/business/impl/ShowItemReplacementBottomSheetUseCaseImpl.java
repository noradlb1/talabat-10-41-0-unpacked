package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase;
import com.talabat.fluid.homescreen.presentation.displaymodel.Component;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusDataMapper;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001e\u0010\f\u001a\u0004\u0018\u00010\r*\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\b*\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/ShowItemReplacementBottomSheetUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase;", "orderStatusDataMapper", "Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusDataMapper;", "(Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusDataMapper;)V", "metaDataComponentKey", "", "shouldShowItemReplacementBottomSheet", "Lcom/talabat/fluid/homescreen/domain/usecase/business/ShowItemReplacementBottomSheetUseCase$ItemReplacementInfo;", "collectionData", "", "Lcom/deliveryhero/fluid/widgets/collections/list/ListCell;", "getComponentOrNull", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/Component;", "", "", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "toItemReplacementInfo", "Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView$OrderStatusData;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShowItemReplacementBottomSheetUseCaseImpl implements ShowItemReplacementBottomSheetUseCase {
    @NotNull
    private final String metaDataComponentKey = FluidHomeScreenViewModel.METADATA_COMPONENT_KEY;
    @NotNull
    private final OrderStatusDataMapper orderStatusDataMapper;

    public ShowItemReplacementBottomSheetUseCaseImpl(@NotNull OrderStatusDataMapper orderStatusDataMapper2) {
        Intrinsics.checkNotNullParameter(orderStatusDataMapper2, "orderStatusDataMapper");
        this.orderStatusDataMapper = orderStatusDataMapper2;
    }

    private final Component getComponentOrNull(Map<String, ? extends Object> map) {
        Component.Companion companion = Component.Companion;
        Object obj = map.get(this.metaDataComponentKey);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return null;
        }
        return companion.from(str);
    }

    private final ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo toItemReplacementInfo(OrderStatusView.OrderStatusData orderStatusData) {
        if (orderStatusData == null) {
            return new ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo(false, "", "", "");
        }
        return new ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo(true, orderStatusData.getChainName(), orderStatusData.getChainId(), String.valueOf(orderStatusData.getOriginalOrderID()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.talabat.homescreen.orderstatus.ui.OrderStatusView$OrderStatusData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.talabat.homescreen.orderstatus.ui.OrderStatusView$OrderStatusData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.talabat.homescreen.orderstatus.ui.OrderStatusView$OrderStatusData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.talabat.homescreen.orderstatus.ui.OrderStatusView$OrderStatusData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.talabat.homescreen.orderstatus.ui.OrderStatusView$OrderStatusData} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo shouldShowItemReplacementBottomSheet(@org.jetbrains.annotations.NotNull java.util.List<com.deliveryhero.fluid.widgets.collections.list.ListCell> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "collectionData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x000b:
            boolean r0 = r8.hasNext()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0031
            java.lang.Object r0 = r8.next()
            r4 = r0
            com.deliveryhero.fluid.widgets.collections.list.ListCell r4 = (com.deliveryhero.fluid.widgets.collections.list.ListCell) r4
            com.deliveryhero.fluid.template.data.TemplateUiData r4 = r4.getData()
            java.util.Map r4 = r4.getMetadata()
            com.talabat.fluid.homescreen.presentation.displaymodel.Component r4 = r7.getComponentOrNull(r4)
            com.talabat.fluid.homescreen.presentation.displaymodel.Component r5 = com.talabat.fluid.homescreen.presentation.displaymodel.Component.ACTIVE_ORDERS
            if (r4 != r5) goto L_0x002d
            r4 = r1
            goto L_0x002e
        L_0x002d:
            r4 = r2
        L_0x002e:
            if (r4 == 0) goto L_0x000b
            goto L_0x0032
        L_0x0031:
            r0 = r3
        L_0x0032:
            com.deliveryhero.fluid.widgets.collections.list.ListCell r0 = (com.deliveryhero.fluid.widgets.collections.list.ListCell) r0
            if (r0 == 0) goto L_0x0097
            com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusDataMapper r8 = r7.orderStatusDataMapper
            com.deliveryhero.fluid.template.data.TemplateUiData r0 = r0.getData()
            java.util.Map r0 = r0.getMetadata()
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            int r5 = r0.size()
            int r5 = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(r5)
            r4.<init>(r5)
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0055:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0071
            java.lang.Object r5 = r0.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = r5.toString()
            r4.put(r6, r5)
            goto L_0x0055
        L_0x0071:
            java.util.List r8 = r8.invoke((java.util.Map<java.lang.String, java.lang.String>) r4)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x007b:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0095
            java.lang.Object r0 = r8.next()
            r4 = r0
            com.talabat.homescreen.orderstatus.ui.OrderStatusView$OrderStatusData r4 = (com.talabat.homescreen.orderstatus.ui.OrderStatusView.OrderStatusData) r4
            int r4 = r4.getOrderStatus()
            r5 = 6
            if (r4 != r5) goto L_0x0091
            r4 = r1
            goto L_0x0092
        L_0x0091:
            r4 = r2
        L_0x0092:
            if (r4 == 0) goto L_0x007b
            r3 = r0
        L_0x0095:
            com.talabat.homescreen.orderstatus.ui.OrderStatusView$OrderStatusData r3 = (com.talabat.homescreen.orderstatus.ui.OrderStatusView.OrderStatusData) r3
        L_0x0097:
            com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase$ItemReplacementInfo r8 = r7.toItemReplacementInfo(r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.domain.usecase.business.impl.ShowItemReplacementBottomSheetUseCaseImpl.shouldShowItemReplacementBottomSheet(java.util.List):com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase$ItemReplacementInfo");
    }
}
