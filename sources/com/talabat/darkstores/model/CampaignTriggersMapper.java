package com.talabat.darkstores.model;

import com.talabat.feature.darkstorescart.data.model.Benefit;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.ProductTrigger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\r\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0002J(\u0010\u0018\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J(\u0010\u0019\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001bJ(\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u001e"}, d2 = {"Lcom/talabat/darkstores/model/CampaignTriggersMapper;", "", "()V", "createAndAddSpecialTrigger", "", "triggers", "Ljava/util/ArrayList;", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "Lkotlin/collections/ArrayList;", "benefit", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "campaign", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "createAndAddTrigger", "cTrigger", "Lcom/talabat/feature/darkstorescart/data/model/ProductTrigger;", "getBenefitQtyFromBenefits", "", "getCampaignTypeEnumValue", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;", "name", "", "getDiscountValueFromBenefits", "", "getSpecialTriggersForSTCampaign", "getTriggersForCampaign", "map", "", "data", "scanAndMapCampaign", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignTriggersMapper {
    @NotNull
    public static final CampaignTriggersMapper INSTANCE = new CampaignTriggersMapper();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Campaign.CampaignType.values().length];
            iArr[Campaign.CampaignType.SameItemBundle.ordinal()] = 1;
            iArr[Campaign.CampaignType.Strikethrough.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CampaignTriggersMapper() {
    }

    private final void createAndAddSpecialTrigger(ArrayList<CampaignTrigger> arrayList, Benefit benefit, Campaign campaign) {
        float f11;
        CampaignTrigger campaignTrigger = new CampaignTrigger((String) null, (Campaign.CampaignType) null, 0, 0, (Campaign.Type) null, 0.0f, (Integer) null, (String) null, false, 511, (DefaultConstructorMarker) null);
        campaignTrigger.setId(benefit.getId());
        campaignTrigger.setCampaignId(campaign.getGlobalId());
        campaignTrigger.setTriggerQty(benefit.getQty());
        campaignTrigger.setCampaignType(campaign.getCampaignType());
        Campaign.Type discountType = benefit.getDiscountType();
        if (discountType == null) {
            discountType = campaign.getDiscountType();
        }
        campaignTrigger.setDiscountType(discountType);
        Float discountValue = benefit.getDiscountValue();
        if (discountValue != null) {
            f11 = discountValue.floatValue();
        } else {
            f11 = campaign.getDiscountValue();
        }
        campaignTrigger.setDiscountValue(f11);
        campaignTrigger.setUsageLimit(campaign.getUsageLimit());
        ArrayList<CampaignTrigger> arrayList2 = arrayList;
        arrayList.add(campaignTrigger);
    }

    private final void createAndAddTrigger(ArrayList<CampaignTrigger> arrayList, ProductTrigger productTrigger, Campaign campaign) {
        boolean z11;
        Campaign campaign2 = campaign;
        CampaignTrigger campaignTrigger = new CampaignTrigger((String) null, (Campaign.CampaignType) null, 0, 0, (Campaign.Type) null, 0.0f, (Integer) null, (String) null, false, 511, (DefaultConstructorMarker) null);
        campaignTrigger.setId(productTrigger.getProductId());
        campaignTrigger.setCampaignId(campaign.getGlobalId());
        campaignTrigger.setTriggerQty(productTrigger.getQty());
        campaignTrigger.setCampaignType(campaign.getCampaignType());
        campaignTrigger.setDiscountType(campaign.getDiscountType());
        CampaignTriggersMapper campaignTriggersMapper = INSTANCE;
        campaignTrigger.setBenefitQty(campaignTriggersMapper.getBenefitQtyFromBenefits(campaign2));
        campaignTrigger.setDiscountValue(campaignTriggersMapper.getDiscountValueFromBenefits(campaign2));
        campaignTrigger.setUsageLimit(campaign.getUsageLimit());
        Boolean isAutoAddable = campaign.isAutoAddable();
        if (isAutoAddable != null) {
            z11 = isAutoAddable.booleanValue();
        } else {
            z11 = false;
        }
        campaignTrigger.setAutoAddable(z11);
        ArrayList<CampaignTrigger> arrayList2 = arrayList;
        arrayList.add(campaignTrigger);
    }

    private final int getBenefitQtyFromBenefits(Campaign campaign) {
        List<Benefit> benefits = campaign.getBenefits();
        if (benefits == null || !(!benefits.isEmpty())) {
            return 1;
        }
        return benefits.get(0).getQty();
    }

    private final float getDiscountValueFromBenefits(Campaign campaign) {
        List<Benefit> benefits = campaign.getBenefits();
        if (benefits == null || !(!benefits.isEmpty())) {
            return campaign.getDiscountValue();
        }
        Float discountValue = benefits.get(0).getDiscountValue();
        if (discountValue != null) {
            return discountValue.floatValue();
        }
        return campaign.getDiscountValue();
    }

    private final void getSpecialTriggersForSTCampaign(ArrayList<CampaignTrigger> arrayList, Campaign campaign) {
        List<Benefit> benefits = campaign.getBenefits();
        if (benefits != null && (!benefits.isEmpty())) {
            for (Benefit createAndAddSpecialTrigger : benefits) {
                INSTANCE.createAndAddSpecialTrigger(arrayList, createAndAddSpecialTrigger, campaign);
            }
        }
    }

    private final void getTriggersForCampaign(ArrayList<CampaignTrigger> arrayList, Campaign campaign) {
        List<ProductTrigger> productTriggers = campaign.getProductTriggers();
        if (productTriggers != null && (!productTriggers.isEmpty())) {
            for (ProductTrigger createAndAddTrigger : productTriggers) {
                INSTANCE.createAndAddTrigger(arrayList, createAndAddTrigger, campaign);
            }
        }
    }

    private final void scanAndMapCampaign(ArrayList<CampaignTrigger> arrayList, Campaign campaign) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[campaign.getCampaignType().ordinal()];
        if (i11 == 1) {
            getTriggersForCampaign(arrayList, campaign);
        } else if (i11 == 2) {
            getSpecialTriggersForSTCampaign(arrayList, campaign);
        }
    }

    @NotNull
    public final Campaign.CampaignType getCampaignTypeEnumValue(@NotNull String str) {
        Campaign.CampaignType campaignType;
        Intrinsics.checkNotNullParameter(str, "name");
        Campaign.CampaignType[] values = Campaign.CampaignType.values();
        int length = values.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                campaignType = null;
                break;
            }
            campaignType = values[i11];
            if (Intrinsics.areEqual((Object) campaignType.name(), (Object) str)) {
                break;
            }
            i11++;
        }
        if (campaignType == null) {
            return Campaign.CampaignType.Else;
        }
        return campaignType;
    }

    @NotNull
    public final List<CampaignTrigger> map(@Nullable List<Campaign> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Campaign scanAndMapCampaign : list) {
                INSTANCE.scanAndMapCampaign(arrayList, scanAndMapCampaign);
            }
        }
        return arrayList;
    }
}
