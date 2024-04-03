package com.talabat.darkstores.data.discovery.model;

import com.talabat.darkstores.model.CompactSwimlaneLayoutType;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.darkstores.model.SwimlaneTracking;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/talabat/darkstores/model/Swimlane;", "swimlanesIn", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FeedMultiListData$withProducts$updateProductsInSwimlane$1 extends Lambda implements Function1<List<? extends Swimlane>, List<? extends Swimlane>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Map<String, Product> f56191g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedMultiListData$withProducts$updateProductsInSwimlane$1(Map<String, Product> map) {
        super(1);
        this.f56191g = map;
    }

    @NotNull
    public final List<Swimlane> invoke(@NotNull List<Swimlane> list) {
        List<Swimlane> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "swimlanesIn");
        Iterable<Swimlane> iterable = list2;
        Map<String, Product> map = this.f56191g;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Swimlane swimlane : iterable) {
            Iterable<Product> products = swimlane.getProducts();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(products, 10));
            for (Product product : products) {
                Product product2 = map.get(product.getId());
                if (product2 != null) {
                    product = product2;
                }
                arrayList2.add(product);
            }
            arrayList.add(Swimlane.copy$default(swimlane, (String) null, (String) null, (CompactSwimlaneLayoutType) null, (String) null, arrayList2, (String) null, (String) null, (SwimlaneTracking) null, 239, (Object) null));
        }
        return arrayList;
    }
}
