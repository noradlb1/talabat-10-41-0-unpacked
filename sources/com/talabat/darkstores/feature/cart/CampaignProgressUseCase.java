package com.talabat.darkstores.feature.cart;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetails;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetailsRepo;
import com.talabat.darkstores.data.grocery.GroceryShoppingRepository;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.feature.campaigns.CampaignProgressStateMapper;
import com.talabat.darkstores.feature.campaigns.CampaignProgressVisualisation;
import com.talabat.feature.darkstorescampaignmessage.data.mapper.CampaignProgressResponseMapper;
import com.talabat.feature.darkstorescampaignmessage.data.model.NetworkCampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignMessageParams;
import com.talabat.feature.darkstorescampaignmessage.domain.model.CampaignProgressResponse;
import com.talabat.feature.darkstorescampaignmessage.domain.usecase.GetCampaignMessageUseCase;
import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFeeTiersInfo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.tekartik.sqflite.Constant;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ri.c;
import ri.d;
import ri.e;
import ri.f;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00017BY\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002JM\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0'2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00100JM\u00101\u001a\b\u0012\u0004\u0012\u0002020'2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00100J\b\u00103\u001a\u000204H\u0002J?\u00105\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010)2\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00106R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u001d0\u001d0\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CampaignProgressUseCase;", "", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "groceryShoppingRepo", "Lcom/talabat/darkstores/data/grocery/GroceryShoppingRepository;", "deliveryDetailsRepo", "Lcom/talabat/darkstores/data/dynamicPricing/remote/DeliveryDetailsRepo;", "ioScheduler", "Lio/reactivex/Scheduler;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getCampaignMessageUseCase", "Lcom/talabat/feature/darkstorescampaignmessage/domain/usecase/GetCampaignMessageUseCase;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "campaignProgressResponseMapper", "Lcom/talabat/feature/darkstorescampaignmessage/data/mapper/CampaignProgressResponseMapper;", "campaignProgressStateMapper", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateMapper;", "deliveryFeeTierFeatureFlagUseCase", "Lcom/talabat/darkstores/feature/cart/GroceryDeliveryFeeTierFeatureFlagUseCase;", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/data/grocery/GroceryShoppingRepository;Lcom/talabat/darkstores/data/dynamicPricing/remote/DeliveryDetailsRepo;Lio/reactivex/Scheduler;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/feature/darkstorescampaignmessage/domain/usecase/GetCampaignMessageUseCase;Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/talabat/feature/darkstorescampaignmessage/data/mapper/CampaignProgressResponseMapper;Lcom/talabat/darkstores/feature/campaigns/CampaignProgressStateMapper;Lcom/talabat/darkstores/feature/cart/GroceryDeliveryFeeTierFeatureFlagUseCase;)V", "campaignDataSubject", "Lio/reactivex/subjects/PublishSubject;", "Lcom/talabat/darkstores/feature/cart/CampaignMessageData;", "kotlin.jvm.PlatformType", "campaignProgressLegacyObservable", "Lio/reactivex/Observable;", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressVisualisation;", "campaignProgressObservable", "getCampaignProgressObservable", "()Lio/reactivex/Observable;", "campaignProgressSubject", "dispatchCampaignProgress", "", "campaignProgressResponse", "Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;", "getCampaignProgress", "Lio/reactivex/Single;", "total", "", "vendor", "Lcom/talabat/darkstores/feature/cart/CampaignProgressUseCase$VendorInfo;", "cartDiscount", "deliveryDiscount", "subTotal", "subTotalAfterDiscount", "(Lcom/talabat/darkstores/data/grocery/GroceryShoppingRepository;FLcom/talabat/darkstores/feature/cart/CampaignProgressUseCase$VendorInfo;FFFLjava/lang/Float;)Lio/reactivex/Single;", "getCampaignProgressLegacy", "Lcom/talabat/darkstores/data/grocery/model/CampaignProgressResponse;", "isCampaignMessageFromCartEnabled", "", "updateCampaignProgress", "(FFFFLjava/lang/Float;Lcom/talabat/feature/darkstorescampaignmessage/data/model/NetworkCampaignProgressResponse;)V", "VendorInfo", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressUseCase {
    @NotNull
    private final PublishSubject<CampaignMessageData> campaignDataSubject;
    @NotNull
    private final Observable<CampaignProgressVisualisation> campaignProgressLegacyObservable;
    @NotNull
    private final CampaignProgressResponseMapper campaignProgressResponseMapper;
    @NotNull
    private final CampaignProgressStateMapper campaignProgressStateMapper;
    @NotNull
    private final PublishSubject<CampaignProgressVisualisation> campaignProgressSubject;
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final GroceryDeliveryFeeTierFeatureFlagUseCase deliveryFeeTierFeatureFlagUseCase;
    @NotNull
    private final GetCampaignMessageUseCase getCampaignMessageUseCase;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JP\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CampaignProgressUseCase$VendorInfo;", "", "id", "", "code", "deliveryFee", "", "minOrderValue", "tPro", "", "basketDeliveryFeeTiersInfo", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;ZLcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;)V", "getBasketDeliveryFeeTiersInfo", "()Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "getCode", "()Ljava/lang/String;", "getDeliveryFee", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getId", "getMinOrderValue", "getTPro", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;ZLcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;)Lcom/talabat/darkstores/feature/cart/CampaignProgressUseCase$VendorInfo;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VendorInfo {
        @Nullable
        private final BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo;
        @NotNull
        private final String code;
        @Nullable
        private final Float deliveryFee;
        @NotNull

        /* renamed from: id  reason: collision with root package name */
        private final String f56245id;
        @Nullable
        private final Float minOrderValue;
        private final boolean tPro;

        public VendorInfo(@NotNull String str, @NotNull String str2, @Nullable Float f11, @Nullable Float f12, boolean z11, @Nullable BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
            this.f56245id = str;
            this.code = str2;
            this.deliveryFee = f11;
            this.minOrderValue = f12;
            this.tPro = z11;
            this.basketDeliveryFeeTiersInfo = basketDeliveryFeeTiersInfo2;
        }

        public static /* synthetic */ VendorInfo copy$default(VendorInfo vendorInfo, String str, String str2, Float f11, Float f12, boolean z11, BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = vendorInfo.f56245id;
            }
            if ((i11 & 2) != 0) {
                str2 = vendorInfo.code;
            }
            String str3 = str2;
            if ((i11 & 4) != 0) {
                f11 = vendorInfo.deliveryFee;
            }
            Float f13 = f11;
            if ((i11 & 8) != 0) {
                f12 = vendorInfo.minOrderValue;
            }
            Float f14 = f12;
            if ((i11 & 16) != 0) {
                z11 = vendorInfo.tPro;
            }
            boolean z12 = z11;
            if ((i11 & 32) != 0) {
                basketDeliveryFeeTiersInfo2 = vendorInfo.basketDeliveryFeeTiersInfo;
            }
            return vendorInfo.copy(str, str3, f13, f14, z12, basketDeliveryFeeTiersInfo2);
        }

        @NotNull
        public final String component1() {
            return this.f56245id;
        }

        @NotNull
        public final String component2() {
            return this.code;
        }

        @Nullable
        public final Float component3() {
            return this.deliveryFee;
        }

        @Nullable
        public final Float component4() {
            return this.minOrderValue;
        }

        public final boolean component5() {
            return this.tPro;
        }

        @Nullable
        public final BasketDeliveryFeeTiersInfo component6() {
            return this.basketDeliveryFeeTiersInfo;
        }

        @NotNull
        public final VendorInfo copy(@NotNull String str, @NotNull String str2, @Nullable Float f11, @Nullable Float f12, boolean z11, @Nullable BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
            return new VendorInfo(str, str2, f11, f12, z11, basketDeliveryFeeTiersInfo2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VendorInfo)) {
                return false;
            }
            VendorInfo vendorInfo = (VendorInfo) obj;
            return Intrinsics.areEqual((Object) this.f56245id, (Object) vendorInfo.f56245id) && Intrinsics.areEqual((Object) this.code, (Object) vendorInfo.code) && Intrinsics.areEqual((Object) this.deliveryFee, (Object) vendorInfo.deliveryFee) && Intrinsics.areEqual((Object) this.minOrderValue, (Object) vendorInfo.minOrderValue) && this.tPro == vendorInfo.tPro && Intrinsics.areEqual((Object) this.basketDeliveryFeeTiersInfo, (Object) vendorInfo.basketDeliveryFeeTiersInfo);
        }

        @Nullable
        public final BasketDeliveryFeeTiersInfo getBasketDeliveryFeeTiersInfo() {
            return this.basketDeliveryFeeTiersInfo;
        }

        @NotNull
        public final String getCode() {
            return this.code;
        }

        @Nullable
        public final Float getDeliveryFee() {
            return this.deliveryFee;
        }

        @NotNull
        public final String getId() {
            return this.f56245id;
        }

        @Nullable
        public final Float getMinOrderValue() {
            return this.minOrderValue;
        }

        public final boolean getTPro() {
            return this.tPro;
        }

        public int hashCode() {
            int hashCode = ((this.f56245id.hashCode() * 31) + this.code.hashCode()) * 31;
            Float f11 = this.deliveryFee;
            int i11 = 0;
            int hashCode2 = (hashCode + (f11 == null ? 0 : f11.hashCode())) * 31;
            Float f12 = this.minOrderValue;
            int hashCode3 = (hashCode2 + (f12 == null ? 0 : f12.hashCode())) * 31;
            boolean z11 = this.tPro;
            if (z11) {
                z11 = true;
            }
            int i12 = (hashCode3 + (z11 ? 1 : 0)) * 31;
            BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2 = this.basketDeliveryFeeTiersInfo;
            if (basketDeliveryFeeTiersInfo2 != null) {
                i11 = basketDeliveryFeeTiersInfo2.hashCode();
            }
            return i12 + i11;
        }

        @NotNull
        public String toString() {
            String str = this.f56245id;
            String str2 = this.code;
            Float f11 = this.deliveryFee;
            Float f12 = this.minOrderValue;
            boolean z11 = this.tPro;
            BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo2 = this.basketDeliveryFeeTiersInfo;
            return "VendorInfo(id=" + str + ", code=" + str2 + ", deliveryFee=" + f11 + ", minOrderValue=" + f12 + ", tPro=" + z11 + ", basketDeliveryFeeTiersInfo=" + basketDeliveryFeeTiersInfo2 + ")";
        }
    }

    @Inject
    public CampaignProgressUseCase(@NotNull DarkstoresRepo darkstoresRepo, @NotNull GroceryShoppingRepository groceryShoppingRepository, @NotNull DeliveryDetailsRepo deliveryDetailsRepo, @IoScheduler @NotNull Scheduler scheduler, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull GetCampaignMessageUseCase getCampaignMessageUseCase2, @NotNull ConfigurationParameters configurationParameters2, @NotNull CampaignProgressResponseMapper campaignProgressResponseMapper2, @NotNull CampaignProgressStateMapper campaignProgressStateMapper2, @NotNull GroceryDeliveryFeeTierFeatureFlagUseCase groceryDeliveryFeeTierFeatureFlagUseCase) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(groceryShoppingRepository, "groceryShoppingRepo");
        Intrinsics.checkNotNullParameter(deliveryDetailsRepo, "deliveryDetailsRepo");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(getCampaignMessageUseCase2, "getCampaignMessageUseCase");
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        Intrinsics.checkNotNullParameter(campaignProgressResponseMapper2, "campaignProgressResponseMapper");
        Intrinsics.checkNotNullParameter(campaignProgressStateMapper2, "campaignProgressStateMapper");
        Intrinsics.checkNotNullParameter(groceryDeliveryFeeTierFeatureFlagUseCase, "deliveryFeeTierFeatureFlagUseCase");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.getCampaignMessageUseCase = getCampaignMessageUseCase2;
        this.configurationParameters = configurationParameters2;
        this.campaignProgressResponseMapper = campaignProgressResponseMapper2;
        this.campaignProgressStateMapper = campaignProgressStateMapper2;
        this.deliveryFeeTierFeatureFlagUseCase = groceryDeliveryFeeTierFeatureFlagUseCase;
        PublishSubject<CampaignMessageData> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<CampaignMessageData>()");
        this.campaignDataSubject = create;
        PublishSubject<CampaignProgressVisualisation> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<CampaignProgressVisualisation>()");
        this.campaignProgressSubject = create2;
        Single<R> zip = Single.zip(darkstoresRepo.getVendor(), deliveryDetailsRepo.getDeliveryDetailsModel(), new c());
        Intrinsics.checkNotNullExpressionValue(zip, "zip(\n            darksto…o\n            )\n        }");
        Observables observables = Observables.INSTANCE;
        Observable<R> observable = zip.toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "vendorInfo.toObservable()");
        Observable<R> onErrorReturnItem = observables.combineLatest(create, observable).subscribeOn(scheduler).flatMapSingle(new d(this, groceryShoppingRepository)).onErrorReturnItem(CampaignProgressVisualisation.Companion.hidden());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "Observables\n            …ssVisualisation.hidden())");
        this.campaignProgressLegacyObservable = onErrorReturnItem;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final VendorInfo m9771_init_$lambda0(Vendor vendor, DeliveryDetails deliveryDetails) {
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        Intrinsics.checkNotNullParameter(deliveryDetails, "deliveryDetails");
        return new VendorInfo(vendor.getVendorId(), vendor.getVendorCode(), Float.valueOf(deliveryDetails.getDeliveryFee()), Float.valueOf(deliveryDetails.getMinOrderValue()), vendor.isTPro(), vendor.getBasketDeliveryFeeTiersInfo());
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final SingleSource m9772_init_$lambda1(CampaignProgressUseCase campaignProgressUseCase, GroceryShoppingRepository groceryShoppingRepository, Pair pair) {
        Intrinsics.checkNotNullParameter(campaignProgressUseCase, "this$0");
        Intrinsics.checkNotNullParameter(groceryShoppingRepository, "$groceryShoppingRepo");
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        CampaignMessageData campaignMessageData = (CampaignMessageData) pair.component1();
        VendorInfo vendorInfo = (VendorInfo) pair.component2();
        float component1 = campaignMessageData.component1();
        float component2 = campaignMessageData.component2();
        float component3 = campaignMessageData.component3();
        float component4 = campaignMessageData.component4();
        Float component5 = campaignMessageData.component5();
        Intrinsics.checkNotNullExpressionValue(vendorInfo, "vendor");
        return campaignProgressUseCase.getCampaignProgress(groceryShoppingRepository, component1, vendorInfo, component2, component3, component4, component5);
    }

    private final void dispatchCampaignProgress(NetworkCampaignProgressResponse networkCampaignProgressResponse) {
        CampaignProgressVisualisation campaignProgressVisualisation;
        CampaignProgressResponse apply;
        if (networkCampaignProgressResponse == null || (apply = this.campaignProgressResponseMapper.apply(networkCampaignProgressResponse)) == null || (campaignProgressVisualisation = this.campaignProgressStateMapper.apply(apply)) == null) {
            campaignProgressVisualisation = CampaignProgressVisualisation.Companion.hidden();
        }
        this.campaignProgressSubject.onNext(campaignProgressVisualisation);
    }

    private final Single<CampaignProgressVisualisation> getCampaignProgress(GroceryShoppingRepository groceryShoppingRepository, float f11, VendorInfo vendorInfo, float f12, float f13, float f14, Float f15) {
        if (this.deliveryFeeTierFeatureFlagUseCase.isBasketBasedDeliveryFeeEnabled(vendorInfo.getTPro(), vendorInfo.getBasketDeliveryFeeTiersInfo())) {
            Single<R> onErrorReturnItem = this.getCampaignMessageUseCase.invoke(new CampaignMessageParams(f14, f15, vendorInfo.getCode(), this.configurationParameters.getLocation().getLatitude(), this.configurationParameters.getLocation().getLongitude(), this.configurationParameters.getDjiniGlobalEntityId(), this.configurationParameters.getChainId())).map(new e(this)).onErrorReturnItem(CampaignProgressVisualisation.Companion.hidden());
            Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "{\n            getCampaig…ation.hidden())\n        }");
            return onErrorReturnItem;
        }
        Single<com.talabat.darkstores.data.grocery.model.CampaignProgressResponse> campaignProgressLegacy = getCampaignProgressLegacy(groceryShoppingRepository, f11, vendorInfo, f12, f13, f14, f15);
        CampaignProgressVisualisation.Companion companion = CampaignProgressVisualisation.Companion;
        Single<R> onErrorReturnItem2 = campaignProgressLegacy.map(new f(companion)).onErrorReturnItem(companion.hidden());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem2, "{\n            getCampaig…ation.hidden())\n        }");
        return onErrorReturnItem2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCampaignProgress$lambda-2  reason: not valid java name */
    public static final CampaignProgressVisualisation m9773getCampaignProgress$lambda2(CampaignProgressUseCase campaignProgressUseCase, CampaignProgressResponse campaignProgressResponse) {
        Intrinsics.checkNotNullParameter(campaignProgressUseCase, "this$0");
        Intrinsics.checkNotNullParameter(campaignProgressResponse, "it");
        return campaignProgressUseCase.campaignProgressStateMapper.apply(campaignProgressResponse);
    }

    private final Single<com.talabat.darkstores.data.grocery.model.CampaignProgressResponse> getCampaignProgressLegacy(GroceryShoppingRepository groceryShoppingRepository, float f11, VendorInfo vendorInfo, float f12, float f13, float f14, Float f15) {
        if (f15 != null) {
            f15.floatValue();
            Single<com.talabat.darkstores.data.grocery.model.CampaignProgressResponse> campaignProgressV3 = groceryShoppingRepository.getCampaignProgressV3(f11, vendorInfo.getId(), vendorInfo.getMinOrderValue(), vendorInfo.getDeliveryFee(), f12, f13, f14, f15.floatValue(), vendorInfo.getCode());
            if (campaignProgressV3 != null) {
                return campaignProgressV3;
            }
        }
        return groceryShoppingRepository.getCampaignProgress(f11, vendorInfo.getId(), vendorInfo.getMinOrderValue(), vendorInfo.getDeliveryFee(), f12, f13, f14);
    }

    private final boolean isCampaignMessageFromCartEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(QCommerceFeatureFlagsKeys.QCOMMERCE_CAMPAIGN_PROGRESS_IN_CART, false);
    }

    @NotNull
    public final Observable<CampaignProgressVisualisation> getCampaignProgressObservable() {
        if (!isCampaignMessageFromCartEnabled()) {
            return this.campaignProgressLegacyObservable;
        }
        Observable<CampaignProgressVisualisation> hide = this.campaignProgressSubject.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "{\n                campai…ject.hide()\n            }");
        return hide;
    }

    public final void updateCampaignProgress(float f11, float f12, float f13, float f14, @Nullable Float f15, @Nullable NetworkCampaignProgressResponse networkCampaignProgressResponse) {
        if (isCampaignMessageFromCartEnabled()) {
            dispatchCampaignProgress(networkCampaignProgressResponse);
        } else {
            this.campaignDataSubject.onNext(new CampaignMessageData(f11, f12, f13, f14, f15));
        }
    }
}
