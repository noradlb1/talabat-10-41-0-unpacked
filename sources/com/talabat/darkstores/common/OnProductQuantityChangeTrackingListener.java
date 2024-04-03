package com.talabat.darkstores.common;

import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001Ja\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&¢\u0006\u0002\u0010\u0012Jq\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H&¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "", "decreaseProductCount", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "count", "", "listPosition", "trackingCategoryId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "swimlaneTrackingData", "Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "swimlaneRequestId", "", "swimlaneStrategy", "useOldTracking", "", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Ljava/lang/String;Ljava/lang/String;Z)V", "increaseProductCount", "onFailure", "Lkotlin/Function0;", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OnProductQuantityChangeTrackingListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void decreaseProductCount$default(OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, Product product, int i11, Integer num, TrackingCategoryId trackingCategoryId, SwimlaneTrackingData swimlaneTrackingData, String str, String str2, boolean z11, int i12, Object obj) {
            int i13 = i12;
            if (obj == null) {
                onProductQuantityChangeTrackingListener.decreaseProductCount(product, i11, num, (i13 & 8) != 0 ? null : trackingCategoryId, (i13 & 16) != 0 ? null : swimlaneTrackingData, (i13 & 32) != 0 ? null : str, (i13 & 64) != 0 ? null : str2, (i13 & 128) != 0 ? true : z11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decreaseProductCount");
        }

        public static /* synthetic */ void increaseProductCount$default(OnProductQuantityChangeTrackingListener onProductQuantityChangeTrackingListener, Product product, int i11, Integer num, TrackingCategoryId trackingCategoryId, SwimlaneTrackingData swimlaneTrackingData, String str, String str2, boolean z11, Function0 function0, int i12, Object obj) {
            TrackingCategoryId trackingCategoryId2;
            SwimlaneTrackingData swimlaneTrackingData2;
            String str3;
            String str4;
            boolean z12;
            OnProductQuantityChangeTrackingListener$increaseProductCount$1 onProductQuantityChangeTrackingListener$increaseProductCount$1;
            int i13 = i12;
            if (obj == null) {
                if ((i13 & 8) != 0) {
                    trackingCategoryId2 = null;
                } else {
                    trackingCategoryId2 = trackingCategoryId;
                }
                if ((i13 & 16) != 0) {
                    swimlaneTrackingData2 = null;
                } else {
                    swimlaneTrackingData2 = swimlaneTrackingData;
                }
                if ((i13 & 32) != 0) {
                    str3 = null;
                } else {
                    str3 = str;
                }
                if ((i13 & 64) != 0) {
                    str4 = null;
                } else {
                    str4 = str2;
                }
                if ((i13 & 128) != 0) {
                    z12 = true;
                } else {
                    z12 = z11;
                }
                if ((i13 & 256) != 0) {
                    onProductQuantityChangeTrackingListener$increaseProductCount$1 = OnProductQuantityChangeTrackingListener$increaseProductCount$1.INSTANCE;
                } else {
                    onProductQuantityChangeTrackingListener$increaseProductCount$1 = function0;
                }
                onProductQuantityChangeTrackingListener.increaseProductCount(product, i11, num, trackingCategoryId2, swimlaneTrackingData2, str3, str4, z12, onProductQuantityChangeTrackingListener$increaseProductCount$1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: increaseProductCount");
        }
    }

    void decreaseProductCount(@NotNull Product product, int i11, @Nullable Integer num, @Nullable TrackingCategoryId trackingCategoryId, @Nullable SwimlaneTrackingData swimlaneTrackingData, @Nullable String str, @Nullable String str2, boolean z11);

    void increaseProductCount(@NotNull Product product, int i11, @Nullable Integer num, @Nullable TrackingCategoryId trackingCategoryId, @Nullable SwimlaneTrackingData swimlaneTrackingData, @Nullable String str, @Nullable String str2, boolean z11, @NotNull Function0<Unit> function0);
}
