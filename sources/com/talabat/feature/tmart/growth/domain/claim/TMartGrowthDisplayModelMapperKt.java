package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"toDisplayModel", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$Success;", "imageFilePath", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "backgroundImagePath", "screenType", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;", "toDisplayModel-6MBmTN8", "(Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo$Success;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;)Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthDisplayModelMapperKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TMartGrowthClaimInfo.State.values().length];
            iArr[TMartGrowthClaimInfo.State.OTHER.ordinal()] = 1;
            iArr[TMartGrowthClaimInfo.State.CLAIMED.ordinal()] = 2;
            iArr[TMartGrowthClaimInfo.State.UNCLAIMED.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TMartGrowthScreenType.values().length];
            iArr2[TMartGrowthScreenType.HOME.ordinal()] = 1;
            iArr2[TMartGrowthScreenType.ORDER_CONFIRMATION.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @NotNull
    /* renamed from: toDisplayModel-6MBmTN8  reason: not valid java name */
    public static final TMartGrowthClaimDisplayModel m10322toDisplayModel6MBmTN8(@NotNull TMartGrowthClaimInfo.Success success, @NotNull String str, @NotNull String str2, @NotNull TMartGrowthScreenType tMartGrowthScreenType) {
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(success, "$this$toDisplayModel");
        Intrinsics.checkNotNullParameter(str, "imageFilePath");
        Intrinsics.checkNotNullParameter(str2, "backgroundImagePath");
        Intrinsics.checkNotNullParameter(tMartGrowthScreenType, "screenType");
        int i11 = WhenMappings.$EnumSwitchMapping$1[tMartGrowthScreenType.ordinal()];
        String str5 = "";
        if (i11 == 1) {
            int i12 = WhenMappings.$EnumSwitchMapping$0[success.getState().ordinal()];
            if (i12 == 1) {
                return TMartGrowthClaimDisplayModel.None.INSTANCE;
            }
            if (i12 == 2) {
                String title = success.getTitle();
                String description = success.getDescription();
                String iconUrl = success.getIconUrl();
                if (iconUrl != null) {
                    str5 = iconUrl;
                }
                return new TMartGrowthClaimDisplayModel.Claimed(title, description, TMartGrowthFilePath.m10324constructorimpl(str5), success.getDeeplink(), (DefaultConstructorMarker) null);
            } else if (i12 == 3) {
                String title2 = success.getTitle();
                String description2 = success.getDescription();
                String buttonText = success.getButtonText();
                if (buttonText == null) {
                    str3 = str5;
                } else {
                    str3 = buttonText;
                }
                return new TMartGrowthClaimDisplayModel.Unclaimed(title2, description2, str, str3, str2, (DefaultConstructorMarker) null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (i11 == 2) {
            int i13 = WhenMappings.$EnumSwitchMapping$0[success.getState().ordinal()];
            if (i13 != 1) {
                if (i13 == 2) {
                    String title3 = success.getTitle();
                    String description3 = success.getDescription();
                    String buttonText2 = success.getButtonText();
                    if (buttonText2 == null) {
                        str4 = str5;
                    } else {
                        str4 = buttonText2;
                    }
                    return new TMartGrowthClaimDisplayModel.Reminder(title3, description3, str, str4, success.getDeeplink(), success.getLogoUrl(), str2, (DefaultConstructorMarker) null);
                } else if (i13 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return TMartGrowthClaimDisplayModel.None.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
