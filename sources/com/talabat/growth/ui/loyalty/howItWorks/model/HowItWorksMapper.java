package com.talabat.growth.ui.loyalty.howItWorks.model;

import com.example.talabatresources.R;
import com.talabat.growth.features.loyaltyFAQ.models.howItWorks.HowItWorksItemResponse;
import com.talabat.growth.features.loyaltyFAQ.models.howItWorks.HowItWorksResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksMapper;", "", "()V", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HowItWorksMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ+\u0010\u000b\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksMapper$Companion;", "", "()V", "getIconType", "", "type", "", "map", "Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksDisplayModel;", "result", "Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksResponse;", "mapInstructions", "", "", "Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksItemDisplayModel;", "instructions", "", "Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksItemResponse;", "(Ljava/util/List;[Lcom/talabat/growth/features/loyaltyFAQ/models/howItWorks/HowItWorksItemResponse;)V", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int getIconType(String str) {
            if (str == null) {
                return R.drawable.ic_loyaty_star;
            }
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            String lowerCase2 = "Talabat".toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual((Object) lowerCase, (Object) lowerCase2)) {
                return R.drawable.ic_talabat_t;
            }
            String lowerCase3 = "Arrows".toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual((Object) lowerCase, (Object) lowerCase3)) {
                return R.drawable.ic_exchange_arrows;
            }
            String lowerCase4 = "Gift".toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase()");
            if (Intrinsics.areEqual((Object) lowerCase, (Object) lowerCase4)) {
                return R.drawable.ic_gift;
            }
            return R.drawable.ic_loyaty_star;
        }

        private final void mapInstructions(List<HowItWorksItemDisplayModel> list, HowItWorksItemResponse[] howItWorksItemResponseArr) {
            if (howItWorksItemResponseArr != null) {
                for (HowItWorksItemResponse howItWorksItemResponse : howItWorksItemResponseArr) {
                    HowItWorksItemDisplayModel howItWorksItemDisplayModel = new HowItWorksItemDisplayModel();
                    String text = howItWorksItemResponse.getText();
                    if (text == null) {
                        text = "";
                    }
                    howItWorksItemDisplayModel.setTip(text);
                    howItWorksItemDisplayModel.setIcon(HowItWorksMapper.Companion.getIconType(howItWorksItemResponse.getIcon()));
                    list.add(howItWorksItemDisplayModel);
                }
            }
        }

        @NotNull
        public final HowItWorksDisplayModel map(@Nullable HowItWorksResponse howItWorksResponse) {
            HowItWorksDisplayModel howItWorksDisplayModel = new HowItWorksDisplayModel((List) null, 1, (DefaultConstructorMarker) null);
            if (howItWorksResponse != null) {
                HowItWorksMapper.Companion.mapInstructions(howItWorksDisplayModel.getInstructions(), howItWorksResponse.getInstructions());
            }
            return howItWorksDisplayModel;
        }
    }
}
