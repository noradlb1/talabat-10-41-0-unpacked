package com.talabat.darkstores.common;

import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\tJ7\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/common/OnProductQuantityChangeListener;", "", "decreaseProductCount", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "count", "", "listPosition", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;)V", "increaseProductCount", "onFailure", "Lkotlin/Function0;", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OnProductQuantityChangeListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void increaseProductCount$default(OnProductQuantityChangeListener onProductQuantityChangeListener, Product product, int i11, Integer num, Function0 function0, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 8) != 0) {
                    function0 = OnProductQuantityChangeListener$increaseProductCount$1.INSTANCE;
                }
                onProductQuantityChangeListener.increaseProductCount(product, i11, num, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: increaseProductCount");
        }
    }

    void decreaseProductCount(@NotNull Product product, int i11, @Nullable Integer num);

    void increaseProductCount(@NotNull Product product, int i11, @Nullable Integer num, @NotNull Function0<Unit> function0);
}
