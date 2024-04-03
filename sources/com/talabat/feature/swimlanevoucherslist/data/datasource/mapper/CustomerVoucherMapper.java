package com.talabat.feature.swimlanevoucherslist.data.datasource.mapper;

import com.talabat.feature.swimlanevoucherslist.data.model.QCSwimLaneVouchers;
import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import com.talabat.features.swimlanevoucherslist.domain.model.DiscountType;
import com.talabat.features.swimlanevoucherslist.domain.model.VoucherType;
import com.talabat.mapper.ModelMapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u0007B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/datasource/mapper/CustomerVoucherMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/swimlanevoucherslist/data/model/QCSwimLaneVouchers;", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "()V", "apply", "source", "Companion", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerVoucherMapper implements ModelMapper<QCSwimLaneVouchers, CustomerVoucher> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String NOT_AVAILABLE = "N/A";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/swimlanevoucherslist/data/datasource/mapper/CustomerVoucherMapper$Companion;", "", "()V", "NOT_AVAILABLE", "", "com_talabat_feature_customer-vouchers-swimlane_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    public CustomerVoucher apply(@NotNull QCSwimLaneVouchers qCSwimLaneVouchers) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(qCSwimLaneVouchers, "source");
        String id2 = qCSwimLaneVouchers.getId();
        if (id2 == null) {
            return null;
        }
        String voucherName = qCSwimLaneVouchers.getVoucherName();
        String str3 = voucherName == null ? "N/A" : voucherName;
        String title = qCSwimLaneVouchers.getTitle();
        if (title == null) {
            str = "N/A";
        } else {
            str = title;
        }
        String subtitle = qCSwimLaneVouchers.getSubtitle();
        if (subtitle == null) {
            str2 = "N/A";
        } else {
            str2 = subtitle;
        }
        VoucherType access$getVoucher = CustomerVoucherMapperKt.getVoucher(qCSwimLaneVouchers);
        DiscountType access$getDiscount = CustomerVoucherMapperKt.getDiscount(qCSwimLaneVouchers);
        String image = qCSwimLaneVouchers.getImage();
        if (image == null) {
            image = "";
        }
        String str4 = image;
        List<String> skuIds = qCSwimLaneVouchers.getSkuIds();
        if (skuIds == null) {
            skuIds = CollectionsKt__CollectionsKt.emptyList();
        }
        return new CustomerVoucher(id2, str3, str, str2, access$getVoucher, access$getDiscount, str4, skuIds);
    }
}
