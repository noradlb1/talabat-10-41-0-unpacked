package com.talabat.darkstores.feature.product.models;

import android.content.res.Resources;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.feature.product.models.ProductCampaignLabel;
import com.talabat.feature.darkstorescart.data.model.Benefit;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.darkstorescart.data.model.CampaignLabel;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductTrigger;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.IntKt;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001a\u001b\u001cB\t\b\u0004¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\u00028$X¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0001\u0002\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaign;", "", "", "productId", "Landroid/content/res/Resources;", "resources", "", "isRtl", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "getLabel", "createTag", "", "benefitCount", "b", "()Ljava/lang/String;", "globalId", "", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "a", "()Ljava/util/List;", "benefits", "getUsageLimit", "()Ljava/lang/Integer;", "usageLimit", "<init>", "()V", "Companion", "Discount", "Free", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Discount;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public abstract class ProductCampaign {
    @NotNull
    private static final String CAMPAIGN_TAG_PREFIX = "campaign-";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float MAX_DISCOUNT_VALUE = 100.0f;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Companion;", "", "()V", "CAMPAIGN_TAG_PREFIX", "", "MAX_DISCOUNT_VALUE", "", "fromResponse", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign;", "campaignResponse", "", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: type inference failed for: r1v4 */
        /* JADX WARNING: type inference failed for: r5v2, types: [com.talabat.darkstores.feature.product.models.ProductCampaign$Discount] */
        /* JADX WARNING: type inference failed for: r9v2, types: [com.talabat.darkstores.feature.product.models.ProductCampaign$Free$SameItemDiscount] */
        /* JADX WARNING: type inference failed for: r3v6, types: [com.talabat.darkstores.feature.product.models.ProductCampaign$Free$SameItemBundle] */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.talabat.darkstores.feature.product.models.ProductCampaign fromResponse(@org.jetbrains.annotations.NotNull java.util.List<com.talabat.feature.darkstorescart.data.model.Campaign> r17) {
            /*
                r16 = this;
                r0 = r17
                java.lang.String r1 = "campaignResponse"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.Iterator r0 = r0.iterator()
            L_0x000d:
                boolean r1 = r0.hasNext()
                r2 = 0
                if (r1 == 0) goto L_0x00a4
                java.lang.Object r1 = r0.next()
                com.talabat.feature.darkstorescart.data.model.Campaign r1 = (com.talabat.feature.darkstorescart.data.model.Campaign) r1
                com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r3 = r1.getCampaignType()
                com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r4 = com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType.SameItemBundle
                if (r3 != r4) goto L_0x007f
                com.talabat.feature.darkstorescart.data.model.Campaign$Type r3 = r1.getDiscountType()
                com.talabat.feature.darkstorescart.data.model.Campaign$Type r4 = com.talabat.feature.darkstorescart.data.model.Campaign.Type.PERCENTAGE
                if (r3 != r4) goto L_0x007f
                float r2 = r1.getDiscountValue()
                r3 = 1120403456(0x42c80000, float:100.0)
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 != 0) goto L_0x0036
                r2 = 1
                goto L_0x0037
            L_0x0036:
                r2 = 0
            L_0x0037:
                if (r2 == 0) goto L_0x0060
                java.lang.Boolean r2 = r1.isAutoAddable()
                java.lang.Boolean r3 = java.lang.Boolean.TRUE
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
                if (r2 == 0) goto L_0x0060
                java.lang.String r4 = r1.getGlobalId()
                java.lang.String r5 = r1.getName()
                java.util.List r6 = r1.getBenefits()
                java.lang.Integer r8 = r1.getUsageLimit()
                java.util.List r7 = r1.getProductTriggers()
                com.talabat.darkstores.feature.product.models.ProductCampaign$Free$SameItemBundle r1 = new com.talabat.darkstores.feature.product.models.ProductCampaign$Free$SameItemBundle
                r3 = r1
                r3.<init>(r4, r5, r6, r7, r8)
                goto L_0x00a1
            L_0x0060:
                java.lang.String r10 = r1.getGlobalId()
                java.lang.String r11 = r1.getName()
                java.util.List r12 = r1.getBenefits()
                java.lang.Integer r14 = r1.getUsageLimit()
                java.util.List r13 = r1.getProductTriggers()
                float r15 = r1.getDiscountValue()
                com.talabat.darkstores.feature.product.models.ProductCampaign$Free$SameItemDiscount r1 = new com.talabat.darkstores.feature.product.models.ProductCampaign$Free$SameItemDiscount
                r9 = r1
                r9.<init>(r10, r11, r12, r13, r14, r15)
                goto L_0x00a1
            L_0x007f:
                com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r3 = r1.getCampaignType()
                com.talabat.feature.darkstorescart.data.model.Campaign$CampaignType r4 = com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType.Strikethrough
                if (r3 != r4) goto L_0x00a2
                java.lang.String r6 = r1.getGlobalId()
                java.util.List r7 = r1.getBenefits()
                com.talabat.feature.darkstorescart.data.model.Campaign$Type r9 = r1.getDiscountType()
                float r10 = r1.getDiscountValue()
                java.lang.Integer r8 = r1.getUsageLimit()
                com.talabat.darkstores.feature.product.models.ProductCampaign$Discount r1 = new com.talabat.darkstores.feature.product.models.ProductCampaign$Discount
                r5 = r1
                r5.<init>(r6, r7, r8, r9, r10)
            L_0x00a1:
                r2 = r1
            L_0x00a2:
                if (r2 == 0) goto L_0x000d
            L_0x00a4:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.product.models.ProductCampaign.Companion.fromResponse(java.util.List):com.talabat.darkstores.feature.product.models.ProductCampaign");
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\t\u0010\b\u001a\u00020\u0002HÂ\u0003J\t\u0010\t\u001a\u00020\u0004HÂ\u0003J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JL\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\n2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003R\u001a\u0010\u0014\u001a\u00020\n8\u0014X\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0014X\u0004¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010(R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010)¨\u0006,"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Discount;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign;", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "discountType", "", "discountValue", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "createDiscountLabel", "component4", "component5", "", "productId", "Landroid/content/res/Resources;", "resources", "", "isRtl", "getLabel", "", "component3", "()Ljava/lang/Integer;", "globalId", "", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "benefits", "usageLimit", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;F)Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Discount;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Ljava/util/List;", "a", "()Ljava/util/List;", "Ljava/lang/Integer;", "getUsageLimit", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "F", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;F)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
    public static final class Discount extends ProductCampaign {
        @Nullable
        private final List<Benefit> benefits;
        @NotNull
        private final Campaign.Type discountType;
        private final float discountValue;
        @NotNull
        private final String globalId;
        @Nullable
        private final Integer usageLimit;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Campaign.Type.values().length];
                iArr[Campaign.Type.PERCENTAGE.ordinal()] = 1;
                iArr[Campaign.Type.ABSOLUTE.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Discount(@NotNull String str, @Nullable List<Benefit> list, @Nullable Integer num, @NotNull Campaign.Type type, float f11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "globalId");
            Intrinsics.checkNotNullParameter(type, "discountType");
            this.globalId = str;
            this.benefits = list;
            this.usageLimit = num;
            this.discountType = type;
            this.discountValue = f11;
        }

        private final Campaign.Type component4() {
            return this.discountType;
        }

        private final float component5() {
            return this.discountValue;
        }

        public static /* synthetic */ Discount copy$default(Discount discount, String str, List<Benefit> list, Integer num, Campaign.Type type, float f11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = discount.b();
            }
            if ((i11 & 2) != 0) {
                list = discount.a();
            }
            List<Benefit> list2 = list;
            if ((i11 & 4) != 0) {
                num = discount.getUsageLimit();
            }
            Integer num2 = num;
            if ((i11 & 8) != 0) {
                type = discount.discountType;
            }
            Campaign.Type type2 = type;
            if ((i11 & 16) != 0) {
                f11 = discount.discountValue;
            }
            return discount.copy(str, list2, num2, type2, f11);
        }

        private final ProductCampaignLabel createDiscountLabel(Campaign.Type type, float f11) {
            ProductCampaignLabel productCampaignLabel;
            boolean z11;
            ProductCampaignLabel productCampaignLabel2;
            try {
                Result.Companion companion = Result.Companion;
                if (f11 > 0.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    int i11 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                    if (i11 == 1) {
                        ProductCampaignLabel.Companion companion2 = ProductCampaignLabel.Companion;
                        String format = NumberFormat.getPercentInstance().format(Float.valueOf(f11 / ((float) 100)));
                        Intrinsics.checkNotNullExpressionValue(format, "getPercentInstance().for…tValue / PERCENTAGE_BASE)");
                        productCampaignLabel2 = companion2.discount(format);
                    } else if (i11 == 2) {
                        productCampaignLabel2 = ProductCampaignLabel.Companion.discount(FloatExtensionsKt.formatCurrency(f11));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    productCampaignLabel = Result.m6329constructorimpl(productCampaignLabel2);
                    ProductCampaignLabel none = ProductCampaignLabel.Companion.none();
                    if (Result.m6335isFailureimpl(productCampaignLabel)) {
                        productCampaignLabel = none;
                    }
                    return (ProductCampaignLabel) productCampaignLabel;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                productCampaignLabel = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        }

        @Nullable
        public List<Benefit> a() {
            return this.benefits;
        }

        @NotNull
        public String b() {
            return this.globalId;
        }

        @Nullable
        public final Integer component3() {
            return getUsageLimit();
        }

        @NotNull
        public final Discount copy(@NotNull String str, @Nullable List<Benefit> list, @Nullable Integer num, @NotNull Campaign.Type type, float f11) {
            Intrinsics.checkNotNullParameter(str, "globalId");
            Intrinsics.checkNotNullParameter(type, "discountType");
            return new Discount(str, list, num, type, f11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Discount)) {
                return false;
            }
            Discount discount = (Discount) obj;
            return Intrinsics.areEqual((Object) b(), (Object) discount.b()) && Intrinsics.areEqual((Object) a(), (Object) discount.a()) && Intrinsics.areEqual((Object) getUsageLimit(), (Object) discount.getUsageLimit()) && this.discountType == discount.discountType && Intrinsics.areEqual((Object) Float.valueOf(this.discountValue), (Object) Float.valueOf(discount.discountValue));
        }

        @NotNull
        public ProductCampaignLabel getLabel(@NotNull String str, @NotNull Resources resources, boolean z11) {
            Benefit benefit;
            Campaign.Type type;
            Object obj;
            Intrinsics.checkNotNullParameter(str, "productId");
            Intrinsics.checkNotNullParameter(resources, "resources");
            List<Benefit> a11 = a();
            Float f11 = null;
            if (a11 != null) {
                Iterator it = a11.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((Benefit) obj).getId(), (Object) str)) {
                        break;
                    }
                }
                benefit = (Benefit) obj;
            } else {
                benefit = null;
            }
            if (benefit != null) {
                type = benefit.getDiscountType();
            } else {
                type = null;
            }
            if (benefit != null) {
                f11 = benefit.getDiscountValue();
            }
            Pair pair = TuplesKt.to(type, f11);
            Campaign.Type type2 = (Campaign.Type) pair.component1();
            Float f12 = (Float) pair.component2();
            if (type2 == null || f12 == null) {
                return createDiscountLabel(this.discountType, this.discountValue);
            }
            return createDiscountLabel(type2, f12.floatValue());
        }

        @Nullable
        public Integer getUsageLimit() {
            return this.usageLimit;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = ((b().hashCode() * 31) + (a() == null ? 0 : a().hashCode())) * 31;
            if (getUsageLimit() != null) {
                i11 = getUsageLimit().hashCode();
            }
            return ((((hashCode + i11) * 31) + this.discountType.hashCode()) * 31) + Float.floatToIntBits(this.discountValue);
        }

        @NotNull
        public String toString() {
            String b11 = b();
            List<Benefit> a11 = a();
            Integer usageLimit2 = getUsageLimit();
            Campaign.Type type = this.discountType;
            float f11 = this.discountValue;
            return "Discount(globalId=" + b11 + ", benefits=" + a11 + ", usageLimit=" + usageLimit2 + ", discountType=" + type + ", discountValue=" + f11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\t\b\u0004¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&ø\u0001\u0000J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0006\u0010\u0011\u001a\u00020\u000eR\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00048$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0001\u0004\u001c\u001d\u001e\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign;", "", "currentProductId", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "cartProducts", "Lkotlin/Pair;", "Lcom/talabat/darkstores/feature/product/models/CampaignAddedQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignProgressData;", "getProgressData", "Landroid/content/res/Resources;", "resources", "", "added", "inProgressLabel", "requiredItems", "Lcom/talabat/feature/darkstorescart/data/model/ProductTrigger;", "c", "()Ljava/util/List;", "triggers", "<init>", "()V", "MixAndMatch", "MixAndMatchDiscount", "SameItemBundle", "SameItemDiscount", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$SameItemBundle;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$SameItemDiscount;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$MixAndMatch;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$MixAndMatchDiscount;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
    public static abstract class Free extends ProductCampaign {

        @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\b\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b2\u00103J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J1\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016ø\u0001\u0000J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JT\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\b2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b!\u0010\"J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\u0011HÖ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003R\u001a\u0010\u001a\u001a\u00020\u00068\u0014X\u0004¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010\u001b\u001a\u00020\u00068\u0014X\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b+\u0010*R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\b8\u0014X\u0004¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010.R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\b8\u0014X\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b/\u0010.R\u001c\u0010 \u001a\u0004\u0018\u00010\u00118\u0016X\u0004¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b1\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$MixAndMatch;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "", "isOnBenefitsList", "isThisCampaignApplied", "", "currentProductId", "", "cartProducts", "Lkotlin/Pair;", "Lcom/talabat/darkstores/feature/product/models/CampaignAddedQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignProgressData;", "getProgressData", "Landroid/content/res/Resources;", "resources", "", "added", "inProgressLabel", "productId", "isRtl", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "getLabel", "component5", "()Ljava/lang/Integer;", "globalId", "name", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "benefits", "Lcom/talabat/feature/darkstorescart/data/model/ProductTrigger;", "triggers", "usageLimit", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$MixAndMatch;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "c", "Ljava/lang/Integer;", "getUsageLimit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
        public static final class MixAndMatch extends Free {
            @Nullable
            private final List<Benefit> benefits;
            @NotNull
            private final String globalId;
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private final String f56507name;
            @Nullable
            private final List<ProductTrigger> triggers;
            @Nullable
            private final Integer usageLimit;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MixAndMatch(@NotNull String str, @NotNull String str2, @Nullable List<Benefit> list, @Nullable List<ProductTrigger> list2, @Nullable Integer num) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "globalId");
                Intrinsics.checkNotNullParameter(str2, "name");
                this.globalId = str;
                this.f56507name = str2;
                this.benefits = list;
                this.triggers = list2;
                this.usageLimit = num;
            }

            public static /* synthetic */ MixAndMatch copy$default(MixAndMatch mixAndMatch, String str, String str2, List<Benefit> list, List<ProductTrigger> list2, Integer num, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = mixAndMatch.b();
                }
                if ((i11 & 2) != 0) {
                    str2 = mixAndMatch.d();
                }
                String str3 = str2;
                if ((i11 & 4) != 0) {
                    list = mixAndMatch.a();
                }
                List<Benefit> list3 = list;
                if ((i11 & 8) != 0) {
                    list2 = mixAndMatch.c();
                }
                List<ProductTrigger> list4 = list2;
                if ((i11 & 16) != 0) {
                    num = mixAndMatch.getUsageLimit();
                }
                return mixAndMatch.copy(str, str3, list3, list4, num);
            }

            private final boolean isOnBenefitsList(Product product) {
                Boolean bool;
                List<Benefit> a11 = a();
                if (a11 != null) {
                    Iterable iterable = a11;
                    boolean z11 = false;
                    if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                        Iterator it = iterable.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (Intrinsics.areEqual((Object) ((Benefit) it.next()).getId(), (Object) product.getId())) {
                                    z11 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    bool = Boolean.valueOf(z11);
                } else {
                    bool = null;
                }
                return BooleanKt.orFalse(bool);
            }

            private final boolean isThisCampaignApplied(Product product) {
                Iterable<CampaignLabel> appliedCampaigns = product.getAppliedCampaigns();
                if ((appliedCampaigns instanceof Collection) && ((Collection) appliedCampaigns).isEmpty()) {
                    return false;
                }
                for (CampaignLabel campaignId : appliedCampaigns) {
                    if (Intrinsics.areEqual((Object) campaignId.getCampaignId(), (Object) b())) {
                        return true;
                    }
                }
                return false;
            }

            @Nullable
            public List<Benefit> a() {
                return this.benefits;
            }

            @NotNull
            public String b() {
                return this.globalId;
            }

            @Nullable
            public List<ProductTrigger> c() {
                return this.triggers;
            }

            @Nullable
            public final Integer component5() {
                return getUsageLimit();
            }

            @NotNull
            public final MixAndMatch copy(@NotNull String str, @NotNull String str2, @Nullable List<Benefit> list, @Nullable List<ProductTrigger> list2, @Nullable Integer num) {
                Intrinsics.checkNotNullParameter(str, "globalId");
                Intrinsics.checkNotNullParameter(str2, "name");
                return new MixAndMatch(str, str2, list, list2, num);
            }

            @NotNull
            public String d() {
                return this.f56507name;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MixAndMatch)) {
                    return false;
                }
                MixAndMatch mixAndMatch = (MixAndMatch) obj;
                return Intrinsics.areEqual((Object) b(), (Object) mixAndMatch.b()) && Intrinsics.areEqual((Object) d(), (Object) mixAndMatch.d()) && Intrinsics.areEqual((Object) a(), (Object) mixAndMatch.a()) && Intrinsics.areEqual((Object) c(), (Object) mixAndMatch.c()) && Intrinsics.areEqual((Object) getUsageLimit(), (Object) mixAndMatch.getUsageLimit());
            }

            @NotNull
            public ProductCampaignLabel getLabel(@NotNull String str, @NotNull Resources resources, boolean z11) {
                Intrinsics.checkNotNullParameter(str, "productId");
                Intrinsics.checkNotNullParameter(resources, "resources");
                return ProductCampaignLabel.Companion.mixAndMatch(d());
            }

            @NotNull
            public Pair<CampaignAddedQuantity, CampaignFreeQuantity> getProgressData(@NotNull String str, @NotNull List<Product> list) {
                Integer num;
                Object obj;
                int i11;
                Intrinsics.checkNotNullParameter(str, "currentProductId");
                Intrinsics.checkNotNullParameter(list, "cartProducts");
                Iterable iterable = list;
                Iterator it = iterable.iterator();
                while (true) {
                    num = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((Product) obj).getId(), (Object) str)) {
                        break;
                    }
                }
                Product product = (Product) obj;
                if (product != null) {
                    num = Integer.valueOf(product.getCartCount());
                }
                int orZero = IntKt.orZero(num);
                ArrayList<Product> arrayList = new ArrayList<>();
                Iterator it2 = iterable.iterator();
                while (true) {
                    i11 = 0;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    Product product2 = (Product) next;
                    if (!Intrinsics.areEqual((Object) product2.getId(), (Object) str) && isOnBenefitsList(product2) && isThisCampaignApplied(product2)) {
                        i11 = 1;
                    }
                    if (i11 != 0) {
                        arrayList.add(next);
                    }
                }
                for (Product cartCount : arrayList) {
                    i11 += cartCount.getCartCount();
                }
                return TuplesKt.to(CampaignAddedQuantity.m10030boximpl(CampaignAddedQuantity.m10031constructorimpl(orZero)), CampaignFreeQuantity.m10037boximpl(CampaignFreeQuantity.m10038constructorimpl(i11)));
            }

            @Nullable
            public Integer getUsageLimit() {
                return this.usageLimit;
            }

            public int hashCode() {
                int i11 = 0;
                int hashCode = ((((((b().hashCode() * 31) + d().hashCode()) * 31) + (a() == null ? 0 : a().hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (getUsageLimit() != null) {
                    i11 = getUsageLimit().hashCode();
                }
                return hashCode + i11;
            }

            @NotNull
            public String inProgressLabel(@NotNull Resources resources, int i11) {
                Intrinsics.checkNotNullParameter(resources, "resources");
                String string = resources.getString(R.string.free_item_campaign_remaining, new Object[]{Integer.valueOf(requiredItems() - i11), Integer.valueOf(benefitCount())});
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …Count()\n                )");
                return string;
            }

            @NotNull
            public String toString() {
                String b11 = b();
                String d11 = d();
                List<Benefit> a11 = a();
                List<ProductTrigger> c11 = c();
                Integer usageLimit2 = getUsageLimit();
                return "MixAndMatch(globalId=" + b11 + ", name=" + d11 + ", benefits=" + a11 + ", triggers=" + c11 + ", usageLimit=" + usageLimit2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\n\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0004\b6\u00107J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J\t\u0010\u0007\u001a\u00020\u0006HÂ\u0003J1\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016ø\u0001\u0000J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ^\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\b2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010#\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b$\u0010%J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0013HÖ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003R\u001a\u0010\u001c\u001a\u00020\b8\u0014X\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010\u001d\u001a\u00020\b8\u0014X\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b.\u0010-R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n8\u0014X\u0004¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b0\u00101R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\n8\u0014X\u0004¢\u0006\f\n\u0004\b!\u0010/\u001a\u0004\b2\u00101R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00138\u0016X\u0004¢\u0006\f\n\u0004\b\"\u00103\u001a\u0004\b4\u0010\u001bR\u0014\u0010#\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u00105\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$MixAndMatchDiscount;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "", "isOnBenefitsList", "isThisCampaignApplied", "", "component6", "", "currentProductId", "", "cartProducts", "Lkotlin/Pair;", "Lcom/talabat/darkstores/feature/product/models/CampaignAddedQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignProgressData;", "getProgressData", "Landroid/content/res/Resources;", "resources", "", "added", "inProgressLabel", "productId", "isRtl", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "getLabel", "component5", "()Ljava/lang/Integer;", "globalId", "name", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "benefits", "Lcom/talabat/feature/darkstorescart/data/model/ProductTrigger;", "triggers", "usageLimit", "discountValue", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;F)Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$MixAndMatchDiscount;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "c", "Ljava/lang/Integer;", "getUsageLimit", "F", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;F)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
        public static final class MixAndMatchDiscount extends Free {
            @Nullable
            private final List<Benefit> benefits;
            private final float discountValue;
            @NotNull
            private final String globalId;
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private final String f56508name;
            @Nullable
            private final List<ProductTrigger> triggers;
            @Nullable
            private final Integer usageLimit;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MixAndMatchDiscount(@NotNull String str, @NotNull String str2, @Nullable List<Benefit> list, @Nullable List<ProductTrigger> list2, @Nullable Integer num, float f11) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "globalId");
                Intrinsics.checkNotNullParameter(str2, "name");
                this.globalId = str;
                this.f56508name = str2;
                this.benefits = list;
                this.triggers = list2;
                this.usageLimit = num;
                this.discountValue = f11;
            }

            private final float component6() {
                return this.discountValue;
            }

            public static /* synthetic */ MixAndMatchDiscount copy$default(MixAndMatchDiscount mixAndMatchDiscount, String str, String str2, List<Benefit> list, List<ProductTrigger> list2, Integer num, float f11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = mixAndMatchDiscount.b();
                }
                if ((i11 & 2) != 0) {
                    str2 = mixAndMatchDiscount.d();
                }
                String str3 = str2;
                if ((i11 & 4) != 0) {
                    list = mixAndMatchDiscount.a();
                }
                List<Benefit> list3 = list;
                if ((i11 & 8) != 0) {
                    list2 = mixAndMatchDiscount.c();
                }
                List<ProductTrigger> list4 = list2;
                if ((i11 & 16) != 0) {
                    num = mixAndMatchDiscount.getUsageLimit();
                }
                Integer num2 = num;
                if ((i11 & 32) != 0) {
                    f11 = mixAndMatchDiscount.discountValue;
                }
                return mixAndMatchDiscount.copy(str, str3, list3, list4, num2, f11);
            }

            private final boolean isOnBenefitsList(Product product) {
                Boolean bool;
                List<Benefit> a11 = a();
                if (a11 != null) {
                    Iterable iterable = a11;
                    boolean z11 = false;
                    if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                        Iterator it = iterable.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (Intrinsics.areEqual((Object) ((Benefit) it.next()).getId(), (Object) product.getId())) {
                                    z11 = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    bool = Boolean.valueOf(z11);
                } else {
                    bool = null;
                }
                return BooleanKt.orFalse(bool);
            }

            private final boolean isThisCampaignApplied(Product product) {
                Iterable<CampaignLabel> appliedCampaigns = product.getAppliedCampaigns();
                if ((appliedCampaigns instanceof Collection) && ((Collection) appliedCampaigns).isEmpty()) {
                    return false;
                }
                for (CampaignLabel campaignId : appliedCampaigns) {
                    if (Intrinsics.areEqual((Object) campaignId.getCampaignId(), (Object) b())) {
                        return true;
                    }
                }
                return false;
            }

            @Nullable
            public List<Benefit> a() {
                return this.benefits;
            }

            @NotNull
            public String b() {
                return this.globalId;
            }

            @Nullable
            public List<ProductTrigger> c() {
                return this.triggers;
            }

            @Nullable
            public final Integer component5() {
                return getUsageLimit();
            }

            @NotNull
            public final MixAndMatchDiscount copy(@NotNull String str, @NotNull String str2, @Nullable List<Benefit> list, @Nullable List<ProductTrigger> list2, @Nullable Integer num, float f11) {
                Intrinsics.checkNotNullParameter(str, "globalId");
                Intrinsics.checkNotNullParameter(str2, "name");
                return new MixAndMatchDiscount(str, str2, list, list2, num, f11);
            }

            @NotNull
            public String d() {
                return this.f56508name;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MixAndMatchDiscount)) {
                    return false;
                }
                MixAndMatchDiscount mixAndMatchDiscount = (MixAndMatchDiscount) obj;
                return Intrinsics.areEqual((Object) b(), (Object) mixAndMatchDiscount.b()) && Intrinsics.areEqual((Object) d(), (Object) mixAndMatchDiscount.d()) && Intrinsics.areEqual((Object) a(), (Object) mixAndMatchDiscount.a()) && Intrinsics.areEqual((Object) c(), (Object) mixAndMatchDiscount.c()) && Intrinsics.areEqual((Object) getUsageLimit(), (Object) mixAndMatchDiscount.getUsageLimit()) && Intrinsics.areEqual((Object) Float.valueOf(this.discountValue), (Object) Float.valueOf(mixAndMatchDiscount.discountValue));
            }

            @NotNull
            public ProductCampaignLabel getLabel(@NotNull String str, @NotNull Resources resources, boolean z11) {
                Intrinsics.checkNotNullParameter(str, "productId");
                Intrinsics.checkNotNullParameter(resources, "resources");
                return ProductCampaignLabel.Companion.mixAndMatch(d());
            }

            @NotNull
            public Pair<CampaignAddedQuantity, CampaignFreeQuantity> getProgressData(@NotNull String str, @NotNull List<Product> list) {
                Integer num;
                Object obj;
                int i11;
                Intrinsics.checkNotNullParameter(str, "currentProductId");
                Intrinsics.checkNotNullParameter(list, "cartProducts");
                Iterable iterable = list;
                Iterator it = iterable.iterator();
                while (true) {
                    num = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((Product) obj).getId(), (Object) str)) {
                        break;
                    }
                }
                Product product = (Product) obj;
                if (product != null) {
                    num = Integer.valueOf(product.getCartCount());
                }
                int orZero = IntKt.orZero(num);
                ArrayList<Product> arrayList = new ArrayList<>();
                Iterator it2 = iterable.iterator();
                while (true) {
                    i11 = 0;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    Product product2 = (Product) next;
                    if (isOnBenefitsList(product2) && isThisCampaignApplied(product2)) {
                        i11 = 1;
                    }
                    if (i11 != 0) {
                        arrayList.add(next);
                    }
                }
                for (Product cartCount : arrayList) {
                    i11 += cartCount.getCartCount();
                }
                return TuplesKt.to(CampaignAddedQuantity.m10030boximpl(CampaignAddedQuantity.m10031constructorimpl(orZero)), CampaignFreeQuantity.m10037boximpl(CampaignFreeQuantity.m10038constructorimpl(RangesKt___RangesKt.coerceAtMost(i11, IntKt.orZero(getUsageLimit())))));
            }

            @Nullable
            public Integer getUsageLimit() {
                return this.usageLimit;
            }

            public int hashCode() {
                int i11 = 0;
                int hashCode = ((((((b().hashCode() * 31) + d().hashCode()) * 31) + (a() == null ? 0 : a().hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (getUsageLimit() != null) {
                    i11 = getUsageLimit().hashCode();
                }
                return ((hashCode + i11) * 31) + Float.floatToIntBits(this.discountValue);
            }

            @NotNull
            public String inProgressLabel(@NotNull Resources resources, int i11) {
                Object obj;
                Object obj2;
                Intrinsics.checkNotNullParameter(resources, "resources");
                NumberFormat percentInstance = NumberFormat.getPercentInstance();
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.m6329constructorimpl(percentInstance.format(Float.valueOf(this.discountValue / ((float) 100))));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m6336isSuccessimpl(obj)) {
                    obj2 = Result.m6329constructorimpl(resources.getString(R.string.free_item_campaign_remaining_percentage, new Object[]{Integer.valueOf(requiredItems() - i11), (String) obj}));
                } else {
                    obj2 = Result.m6329constructorimpl(obj);
                }
                if (Result.m6335isFailureimpl(obj2)) {
                    obj2 = "";
                }
                return (String) obj2;
            }

            @NotNull
            public String toString() {
                String b11 = b();
                String d11 = d();
                List<Benefit> a11 = a();
                List<ProductTrigger> c11 = c();
                Integer usageLimit2 = getUsageLimit();
                float f11 = this.discountValue;
                return "MixAndMatchDiscount(globalId=" + b11 + ", name=" + d11 + ", benefits=" + a11 + ", triggers=" + c11 + ", usageLimit=" + usageLimit2 + ", discountValue=" + f11 + ")";
            }
        }

        @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0004\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0004\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b0\u00101J1\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016ø\u0001\u0000J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017JT\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00042\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\t\u0010!\u001a\u00020\u0002HÖ\u0001J\t\u0010\"\u001a\u00020\u000eHÖ\u0001J\u0013\u0010%\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003R\u001a\u0010\u0018\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010\u0019\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b)\u0010(R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00048\u0014X\u0004¢\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00048\u0014X\u0004¢\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b-\u0010,R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$SameItemBundle;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "", "currentProductId", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "cartProducts", "Lkotlin/Pair;", "Lcom/talabat/darkstores/feature/product/models/CampaignAddedQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignProgressData;", "getProgressData", "Landroid/content/res/Resources;", "resources", "", "added", "inProgressLabel", "productId", "", "isRtl", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "getLabel", "component5", "()Ljava/lang/Integer;", "globalId", "name", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "benefits", "Lcom/talabat/feature/darkstorescart/data/model/ProductTrigger;", "triggers", "usageLimit", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$SameItemBundle;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "c", "Ljava/lang/Integer;", "getUsageLimit", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
        public static final class SameItemBundle extends Free {
            @Nullable
            private final List<Benefit> benefits;
            @NotNull
            private final String globalId;
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private final String f56509name;
            @Nullable
            private final List<ProductTrigger> triggers;
            @Nullable
            private final Integer usageLimit;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SameItemBundle(@NotNull String str, @NotNull String str2, @Nullable List<Benefit> list, @Nullable List<ProductTrigger> list2, @Nullable Integer num) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "globalId");
                Intrinsics.checkNotNullParameter(str2, "name");
                this.globalId = str;
                this.f56509name = str2;
                this.benefits = list;
                this.triggers = list2;
                this.usageLimit = num;
            }

            public static /* synthetic */ SameItemBundle copy$default(SameItemBundle sameItemBundle, String str, String str2, List<Benefit> list, List<ProductTrigger> list2, Integer num, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = sameItemBundle.b();
                }
                if ((i11 & 2) != 0) {
                    str2 = sameItemBundle.d();
                }
                String str3 = str2;
                if ((i11 & 4) != 0) {
                    list = sameItemBundle.a();
                }
                List<Benefit> list3 = list;
                if ((i11 & 8) != 0) {
                    list2 = sameItemBundle.c();
                }
                List<ProductTrigger> list4 = list2;
                if ((i11 & 16) != 0) {
                    num = sameItemBundle.getUsageLimit();
                }
                return sameItemBundle.copy(str, str3, list3, list4, num);
            }

            @Nullable
            public List<Benefit> a() {
                return this.benefits;
            }

            @NotNull
            public String b() {
                return this.globalId;
            }

            @Nullable
            public List<ProductTrigger> c() {
                return this.triggers;
            }

            @Nullable
            public final Integer component5() {
                return getUsageLimit();
            }

            @NotNull
            public final SameItemBundle copy(@NotNull String str, @NotNull String str2, @Nullable List<Benefit> list, @Nullable List<ProductTrigger> list2, @Nullable Integer num) {
                Intrinsics.checkNotNullParameter(str, "globalId");
                Intrinsics.checkNotNullParameter(str2, "name");
                return new SameItemBundle(str, str2, list, list2, num);
            }

            @NotNull
            public String d() {
                return this.f56509name;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SameItemBundle)) {
                    return false;
                }
                SameItemBundle sameItemBundle = (SameItemBundle) obj;
                return Intrinsics.areEqual((Object) b(), (Object) sameItemBundle.b()) && Intrinsics.areEqual((Object) d(), (Object) sameItemBundle.d()) && Intrinsics.areEqual((Object) a(), (Object) sameItemBundle.a()) && Intrinsics.areEqual((Object) c(), (Object) sameItemBundle.c()) && Intrinsics.areEqual((Object) getUsageLimit(), (Object) sameItemBundle.getUsageLimit());
            }

            @NotNull
            public ProductCampaignLabel getLabel(@NotNull String str, @NotNull Resources resources, boolean z11) {
                Benefit benefit;
                Integer num;
                int i11;
                ProductTrigger productTrigger;
                int i12;
                Object obj;
                Object obj2;
                Intrinsics.checkNotNullParameter(str, "productId");
                Intrinsics.checkNotNullParameter(resources, "resources");
                List<Benefit> a11 = a();
                Integer num2 = null;
                if (a11 != null) {
                    Iterator it = a11.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        if (Intrinsics.areEqual((Object) ((Benefit) obj2).getId(), (Object) str)) {
                            break;
                        }
                    }
                    benefit = (Benefit) obj2;
                } else {
                    benefit = null;
                }
                if (benefit != null) {
                    num = Integer.valueOf(benefit.getQty());
                } else {
                    num = null;
                }
                if (num != null) {
                    i11 = num.intValue();
                } else {
                    i11 = 1;
                }
                List<ProductTrigger> c11 = c();
                if (c11 != null) {
                    Iterator it2 = c11.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        if (Intrinsics.areEqual((Object) ((ProductTrigger) obj).getProductId(), (Object) str)) {
                            break;
                        }
                    }
                    productTrigger = (ProductTrigger) obj;
                } else {
                    productTrigger = null;
                }
                if (productTrigger != null) {
                    num2 = Integer.valueOf(productTrigger.getQty());
                }
                if (num2 != null) {
                    i12 = num2.intValue();
                } else {
                    i12 = 1;
                }
                String string = resources.getString(R.string.ds_promo_tag_qty, new Object[]{Integer.valueOf(i12), Integer.valueOf(i11)});
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …uantity\n                )");
                return ProductCampaignLabel.Companion.sameItemBundle(string);
            }

            @NotNull
            public Pair<CampaignAddedQuantity, CampaignFreeQuantity> getProgressData(@NotNull String str, @NotNull List<Product> list) {
                Object obj;
                Pair<CampaignAddedQuantity, CampaignFreeQuantity> pair;
                Intrinsics.checkNotNullParameter(str, "currentProductId");
                Intrinsics.checkNotNullParameter(list, "cartProducts");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((Product) obj).getId(), (Object) str)) {
                        break;
                    }
                }
                Product product = (Product) obj;
                if (product == null || (pair = TuplesKt.to(CampaignAddedQuantity.m10030boximpl(CampaignAddedQuantity.m10031constructorimpl(product.getCartCount())), CampaignFreeQuantity.m10037boximpl(CampaignFreeQuantity.m10038constructorimpl(IntKt.orZero(product.getFreeCount()))))) == null) {
                    return TuplesKt.to(CampaignAddedQuantity.m10030boximpl(CampaignAddedQuantity.m10031constructorimpl(0)), CampaignFreeQuantity.m10037boximpl(CampaignFreeQuantity.m10038constructorimpl(0)));
                }
                return pair;
            }

            @Nullable
            public Integer getUsageLimit() {
                return this.usageLimit;
            }

            public int hashCode() {
                int i11 = 0;
                int hashCode = ((((((b().hashCode() * 31) + d().hashCode()) * 31) + (a() == null ? 0 : a().hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (getUsageLimit() != null) {
                    i11 = getUsageLimit().hashCode();
                }
                return hashCode + i11;
            }

            @NotNull
            public String inProgressLabel(@NotNull Resources resources, int i11) {
                Intrinsics.checkNotNullParameter(resources, "resources");
                String string = resources.getString(R.string.free_item_campaign_remaining, new Object[]{Integer.valueOf(requiredItems() - i11), Integer.valueOf(benefitCount())});
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …Count()\n                )");
                return string;
            }

            @NotNull
            public String toString() {
                String b11 = b();
                String d11 = d();
                List<Benefit> a11 = a();
                List<ProductTrigger> c11 = c();
                Integer usageLimit2 = getUsageLimit();
                return "SameItemBundle(globalId=" + b11 + ", name=" + d11 + ", benefits=" + a11 + ", triggers=" + c11 + ", usageLimit=" + usageLimit2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0006\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0006\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010!\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J\t\u0010\u0003\u001a\u00020\u0002HÂ\u0003J1\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016ø\u0001\u0000J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J^\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00042\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00062\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010!\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\t\u0010$\u001a\u00020\u0004HÖ\u0001J\t\u0010%\u001a\u00020\u0010HÖ\u0001J\u0013\u0010(\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003R\u001a\u0010\u001a\u001a\u00020\u00048\u0014X\u0004¢\u0006\f\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010\u001b\u001a\u00020\u00048\u0014X\u0004¢\u0006\f\n\u0004\b\u001b\u0010)\u001a\u0004\b,\u0010+R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00068\u0014X\u0004¢\u0006\f\n\u0004\b\u001d\u0010-\u001a\u0004\b.\u0010/R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00068\u0014X\u0004¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b0\u0010/R\u001c\u0010 \u001a\u0004\u0018\u00010\u00108\u0016X\u0004¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b2\u0010\u0019R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u00103\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$SameItemDiscount;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "", "component6", "", "currentProductId", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "cartProducts", "Lkotlin/Pair;", "Lcom/talabat/darkstores/feature/product/models/CampaignAddedQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignProgressData;", "getProgressData", "Landroid/content/res/Resources;", "resources", "", "added", "inProgressLabel", "productId", "", "isRtl", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "getLabel", "component5", "()Ljava/lang/Integer;", "globalId", "name", "Lcom/talabat/feature/darkstorescart/data/model/Benefit;", "benefits", "Lcom/talabat/feature/darkstorescart/data/model/ProductTrigger;", "triggers", "usageLimit", "discountValue", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;F)Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free$SameItemDiscount;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "c", "Ljava/lang/Integer;", "getUsageLimit", "F", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;F)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
        public static final class SameItemDiscount extends Free {
            @Nullable
            private final List<Benefit> benefits;
            private final float discountValue;
            @NotNull
            private final String globalId;
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private final String f56510name;
            @Nullable
            private final List<ProductTrigger> triggers;
            @Nullable
            private final Integer usageLimit;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SameItemDiscount(@NotNull String str, @NotNull String str2, @Nullable List<Benefit> list, @Nullable List<ProductTrigger> list2, @Nullable Integer num, float f11) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "globalId");
                Intrinsics.checkNotNullParameter(str2, "name");
                this.globalId = str;
                this.f56510name = str2;
                this.benefits = list;
                this.triggers = list2;
                this.usageLimit = num;
                this.discountValue = f11;
            }

            private final float component6() {
                return this.discountValue;
            }

            public static /* synthetic */ SameItemDiscount copy$default(SameItemDiscount sameItemDiscount, String str, String str2, List<Benefit> list, List<ProductTrigger> list2, Integer num, float f11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = sameItemDiscount.b();
                }
                if ((i11 & 2) != 0) {
                    str2 = sameItemDiscount.d();
                }
                String str3 = str2;
                if ((i11 & 4) != 0) {
                    list = sameItemDiscount.a();
                }
                List<Benefit> list3 = list;
                if ((i11 & 8) != 0) {
                    list2 = sameItemDiscount.c();
                }
                List<ProductTrigger> list4 = list2;
                if ((i11 & 16) != 0) {
                    num = sameItemDiscount.getUsageLimit();
                }
                Integer num2 = num;
                if ((i11 & 32) != 0) {
                    f11 = sameItemDiscount.discountValue;
                }
                return sameItemDiscount.copy(str, str3, list3, list4, num2, f11);
            }

            @Nullable
            public List<Benefit> a() {
                return this.benefits;
            }

            @NotNull
            public String b() {
                return this.globalId;
            }

            @Nullable
            public List<ProductTrigger> c() {
                return this.triggers;
            }

            @Nullable
            public final Integer component5() {
                return getUsageLimit();
            }

            @NotNull
            public final SameItemDiscount copy(@NotNull String str, @NotNull String str2, @Nullable List<Benefit> list, @Nullable List<ProductTrigger> list2, @Nullable Integer num, float f11) {
                Intrinsics.checkNotNullParameter(str, "globalId");
                Intrinsics.checkNotNullParameter(str2, "name");
                return new SameItemDiscount(str, str2, list, list2, num, f11);
            }

            @NotNull
            public String d() {
                return this.f56510name;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SameItemDiscount)) {
                    return false;
                }
                SameItemDiscount sameItemDiscount = (SameItemDiscount) obj;
                return Intrinsics.areEqual((Object) b(), (Object) sameItemDiscount.b()) && Intrinsics.areEqual((Object) d(), (Object) sameItemDiscount.d()) && Intrinsics.areEqual((Object) a(), (Object) sameItemDiscount.a()) && Intrinsics.areEqual((Object) c(), (Object) sameItemDiscount.c()) && Intrinsics.areEqual((Object) getUsageLimit(), (Object) sameItemDiscount.getUsageLimit()) && Intrinsics.areEqual((Object) Float.valueOf(this.discountValue), (Object) Float.valueOf(sameItemDiscount.discountValue));
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.talabat.feature.darkstorescart.data.model.ProductTrigger} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.talabat.feature.darkstorescart.data.model.ProductTrigger} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.talabat.feature.darkstorescart.data.model.ProductTrigger} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.talabat.feature.darkstorescart.data.model.ProductTrigger} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
            @org.jetbrains.annotations.NotNull
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.talabat.darkstores.feature.product.models.ProductCampaignLabel getLabel(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull android.content.res.Resources r7, boolean r8) {
                /*
                    r5 = this;
                    java.lang.String r8 = "productId"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
                    java.lang.String r8 = "resources"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
                    java.util.List r8 = r5.a()
                    r0 = 0
                    if (r8 == 0) goto L_0x0033
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.Iterator r8 = r8.iterator()
                L_0x0017:
                    boolean r1 = r8.hasNext()
                    if (r1 == 0) goto L_0x002f
                    java.lang.Object r1 = r8.next()
                    r2 = r1
                    com.talabat.feature.darkstorescart.data.model.Benefit r2 = (com.talabat.feature.darkstorescart.data.model.Benefit) r2
                    java.lang.String r2 = r2.getId()
                    boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
                    if (r2 == 0) goto L_0x0017
                    goto L_0x0030
                L_0x002f:
                    r1 = r0
                L_0x0030:
                    com.talabat.feature.darkstorescart.data.model.Benefit r1 = (com.talabat.feature.darkstorescart.data.model.Benefit) r1
                    goto L_0x0034
                L_0x0033:
                    r1 = r0
                L_0x0034:
                    java.util.List r8 = r5.c()
                    r2 = 0
                    if (r8 == 0) goto L_0x0062
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.Iterator r8 = r8.iterator()
                L_0x0041:
                    boolean r3 = r8.hasNext()
                    if (r3 == 0) goto L_0x0059
                    java.lang.Object r3 = r8.next()
                    r4 = r3
                    com.talabat.feature.darkstorescart.data.model.ProductTrigger r4 = (com.talabat.feature.darkstorescart.data.model.ProductTrigger) r4
                    java.lang.String r4 = r4.getProductId()
                    boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
                    if (r4 == 0) goto L_0x0041
                    r0 = r3
                L_0x0059:
                    com.talabat.feature.darkstorescart.data.model.ProductTrigger r0 = (com.talabat.feature.darkstorescart.data.model.ProductTrigger) r0
                    if (r0 == 0) goto L_0x0062
                    int r6 = r0.getQty()
                    goto L_0x0063
                L_0x0062:
                    r6 = r2
                L_0x0063:
                    if (r1 == 0) goto L_0x006a
                    int r8 = r1.getQty()
                    goto L_0x006b
                L_0x006a:
                    r8 = r2
                L_0x006b:
                    float r0 = r5.discountValue
                    r1 = 0
                    int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r1 <= 0) goto L_0x00ab
                    if (r8 <= 0) goto L_0x00ab
                    if (r6 > 0) goto L_0x0077
                    goto L_0x00ab
                L_0x0077:
                    float r8 = (float) r8
                    float r0 = r0 * r8
                    float r8 = (float) r6
                    float r0 = r0 / r8
                    int r8 = com.talabat.localization.R.string.grocery_same_item_bundle_percentage_discount
                    r1 = 2
                    java.lang.Object[] r1 = new java.lang.Object[r1]
                    java.lang.String r6 = java.lang.String.valueOf(r6)
                    r1[r2] = r6
                    java.util.Locale r6 = java.util.Locale.ENGLISH
                    java.text.NumberFormat r6 = java.text.NumberFormat.getPercentInstance(r6)
                    r2 = 100
                    float r2 = (float) r2
                    float r0 = r0 / r2
                    java.lang.Float r0 = java.lang.Float.valueOf(r0)
                    java.lang.String r6 = r6.format(r0)
                    r0 = 1
                    r1[r0] = r6
                    java.lang.String r6 = r7.getString(r8, r1)
                    java.lang.String r7 = "resources.getString(\n   …E_BASE)\n                )"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                    com.talabat.darkstores.feature.product.models.ProductCampaignLabel$Companion r7 = com.talabat.darkstores.feature.product.models.ProductCampaignLabel.Companion
                    com.talabat.darkstores.feature.product.models.ProductCampaignLabel r6 = r7.sameItemBundle(r6)
                    return r6
                L_0x00ab:
                    com.talabat.darkstores.feature.product.models.ProductCampaignLabel$Companion r6 = com.talabat.darkstores.feature.product.models.ProductCampaignLabel.Companion
                    com.talabat.darkstores.feature.product.models.ProductCampaignLabel r6 = r6.none()
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.product.models.ProductCampaign.Free.SameItemDiscount.getLabel(java.lang.String, android.content.res.Resources, boolean):com.talabat.darkstores.feature.product.models.ProductCampaignLabel");
            }

            @NotNull
            public Pair<CampaignAddedQuantity, CampaignFreeQuantity> getProgressData(@NotNull String str, @NotNull List<Product> list) {
                Integer num;
                Object obj;
                Integer num2;
                Intrinsics.checkNotNullParameter(str, "currentProductId");
                Intrinsics.checkNotNullParameter(list, "cartProducts");
                Iterator it = list.iterator();
                while (true) {
                    num = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((Product) obj).getId(), (Object) str)) {
                        break;
                    }
                }
                Product product = (Product) obj;
                if (product != null) {
                    num2 = Integer.valueOf(product.getCartCount());
                } else {
                    num2 = null;
                }
                int orZero = IntKt.orZero(num2);
                if (product != null) {
                    num = Integer.valueOf(product.getCartCount() / requiredItems());
                }
                return TuplesKt.to(CampaignAddedQuantity.m10030boximpl(CampaignAddedQuantity.m10031constructorimpl(orZero)), CampaignFreeQuantity.m10037boximpl(CampaignFreeQuantity.m10038constructorimpl(IntKt.orZero(num))));
            }

            @Nullable
            public Integer getUsageLimit() {
                return this.usageLimit;
            }

            public int hashCode() {
                int i11 = 0;
                int hashCode = ((((((b().hashCode() * 31) + d().hashCode()) * 31) + (a() == null ? 0 : a().hashCode())) * 31) + (c() == null ? 0 : c().hashCode())) * 31;
                if (getUsageLimit() != null) {
                    i11 = getUsageLimit().hashCode();
                }
                return ((hashCode + i11) * 31) + Float.floatToIntBits(this.discountValue);
            }

            @NotNull
            public String inProgressLabel(@NotNull Resources resources, int i11) {
                Object obj;
                Object obj2;
                Intrinsics.checkNotNullParameter(resources, "resources");
                NumberFormat percentInstance = NumberFormat.getPercentInstance();
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.m6329constructorimpl(percentInstance.format(Float.valueOf(this.discountValue / ((float) 100))));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m6336isSuccessimpl(obj)) {
                    obj2 = Result.m6329constructorimpl(resources.getString(R.string.free_item_campaign_remaining_percentage, new Object[]{Integer.valueOf(requiredItems() - i11), (String) obj}));
                } else {
                    obj2 = Result.m6329constructorimpl(obj);
                }
                if (Result.m6335isFailureimpl(obj2)) {
                    obj2 = "";
                }
                return (String) obj2;
            }

            @NotNull
            public String toString() {
                String b11 = b();
                String d11 = d();
                List<Benefit> a11 = a();
                List<ProductTrigger> c11 = c();
                Integer usageLimit2 = getUsageLimit();
                float f11 = this.discountValue;
                return "SameItemDiscount(globalId=" + b11 + ", name=" + d11 + ", benefits=" + a11 + ", triggers=" + c11 + ", usageLimit=" + usageLimit2 + ", discountValue=" + f11 + ")";
            }
        }

        private Free() {
            super((DefaultConstructorMarker) null);
        }

        public /* synthetic */ Free(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public abstract List<ProductTrigger> c();

        @NotNull
        public abstract Pair<CampaignAddedQuantity, CampaignFreeQuantity> getProgressData(@NotNull String str, @NotNull List<Product> list);

        @NotNull
        public abstract String inProgressLabel(@NotNull Resources resources, int i11);

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = (com.talabat.feature.darkstorescart.data.model.ProductTrigger) kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int requiredItems() {
            /*
                r1 = this;
                java.util.List r0 = r1.c()
                if (r0 == 0) goto L_0x0017
                java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r0)
                com.talabat.feature.darkstorescart.data.model.ProductTrigger r0 = (com.talabat.feature.darkstorescart.data.model.ProductTrigger) r0
                if (r0 == 0) goto L_0x0017
                int r0 = r0.getQty()
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                goto L_0x0018
            L_0x0017:
                r0 = 0
            L_0x0018:
                int r0 = com.talabat.talabatcommon.extentions.IntKt.orZero((java.lang.Integer) r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.product.models.ProductCampaign.Free.requiredItems():int");
        }
    }

    private ProductCampaign() {
    }

    public /* synthetic */ ProductCampaign(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public abstract List<Benefit> a();

    @NotNull
    public abstract String b();

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = (com.talabat.feature.darkstorescart.data.model.Benefit) kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int benefitCount() {
        /*
            r1 = this;
            java.util.List r0 = r1.a()
            if (r0 == 0) goto L_0x0017
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r0)
            com.talabat.feature.darkstorescart.data.model.Benefit r0 = (com.talabat.feature.darkstorescart.data.model.Benefit) r0
            if (r0 == 0) goto L_0x0017
            int r0 = r0.getQty()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            int r0 = com.talabat.talabatcommon.extentions.IntKt.orZero((java.lang.Integer) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.product.models.ProductCampaign.benefitCount():int");
    }

    @NotNull
    public final String createTag() {
        String b11 = b();
        return CAMPAIGN_TAG_PREFIX + b11;
    }

    @NotNull
    public abstract ProductCampaignLabel getLabel(@NotNull String str, @NotNull Resources resources, boolean z11);

    @Nullable
    public abstract Integer getUsageLimit();
}
