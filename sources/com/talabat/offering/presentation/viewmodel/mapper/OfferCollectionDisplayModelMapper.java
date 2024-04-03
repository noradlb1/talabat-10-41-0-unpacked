package com.talabat.offering.presentation.viewmodel.mapper;

import com.talabat.offering.domain.entities.Background;
import com.talabat.offering.domain.entities.CallToAction;
import com.talabat.offering.domain.entities.HeaderText;
import com.talabat.offering.presentation.displaymodel.HeaderDisplayModel;
import com.talabat.offering.presentation.displaymodel.PopupDisplayModel;
import com.talabat.offering.presentation.displaymodel.VendorsDisplayModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ3\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¨\u0006\u001a"}, d2 = {"Lcom/talabat/offering/presentation/viewmodel/mapper/OfferCollectionDisplayModelMapper;", "", "()V", "mapBackgroundView", "Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel;", "background", "Lcom/talabat/offering/domain/entities/Background;", "foregroundImg", "", "mapHeaderView", "headerText", "Lcom/talabat/offering/domain/entities/HeaderText;", "callToAction", "Lcom/talabat/offering/domain/entities/CallToAction;", "hasTermsCondition", "", "headerViewState", "", "(Lcom/talabat/offering/domain/entities/HeaderText;Lcom/talabat/offering/domain/entities/CallToAction;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/talabat/offering/presentation/displaymodel/HeaderDisplayModel;", "mapPopupData", "Lcom/talabat/offering/presentation/displaymodel/PopupDisplayModel;", "mapVendorsView", "Lcom/talabat/offering/presentation/displaymodel/VendorsDisplayModel;", "restaurants", "", "Ldatamodels/Restaurant;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionDisplayModelMapper {
    @NotNull
    public static final OfferCollectionDisplayModelMapper INSTANCE = new OfferCollectionDisplayModelMapper();

    private OfferCollectionDisplayModelMapper() {
    }

    @NotNull
    public final HeaderDisplayModel mapBackgroundView(@Nullable Background background, @Nullable String str) {
        Integer num;
        String str2 = null;
        if (background != null) {
            num = background.getType();
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            return new HeaderDisplayModel.BackgroundColor("#" + background.getColor(), StringUtils.vendorImage(str));
        }
        if (background != null) {
            str2 = background.getImage();
        }
        return new HeaderDisplayModel.BackgroundImage(StringUtils.vendorImage(str2), StringUtils.vendorImage(str));
    }

    @NotNull
    public final HeaderDisplayModel mapHeaderView(@Nullable HeaderText headerText, @Nullable CallToAction callToAction, @Nullable Boolean bool, @Nullable Integer num) {
        HeaderDisplayModel.HeaderData headerData;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z11 = true;
        if ((num == null || num.intValue() != 2) && (num == null || num.intValue() != 1)) {
            z11 = false;
        }
        String str6 = null;
        if (z11) {
            if (headerText != null) {
                str3 = headerText.getMain();
            } else {
                str3 = null;
            }
            String valueOf = String.valueOf(str3);
            if (headerText != null) {
                str4 = headerText.getSecondary();
            } else {
                str4 = null;
            }
            String valueOf2 = String.valueOf(str4);
            if (callToAction != null) {
                str5 = callToAction.getTitle();
            } else {
                str5 = null;
            }
            String valueOf3 = String.valueOf(str5);
            if (headerText != null) {
                str6 = headerText.getColor();
            }
            headerData = new HeaderDisplayModel.HeaderData(valueOf, valueOf2, valueOf3, "#" + str6, Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE));
        } else if (num == null || num.intValue() != 3) {
            throw MissingHeaderStateException.INSTANCE;
        } else {
            if (headerText != null) {
                str = headerText.getMain();
            } else {
                str = null;
            }
            String valueOf4 = String.valueOf(str);
            if (headerText != null) {
                str2 = headerText.getSecondary();
            } else {
                str2 = null;
            }
            String valueOf5 = String.valueOf(str2);
            if (headerText != null) {
                str6 = headerText.getColor();
            }
            headerData = new HeaderDisplayModel.HeaderData(valueOf4, valueOf5, (String) null, "#" + str6, Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE), 4, (DefaultConstructorMarker) null);
        }
        return headerData;
    }

    @NotNull
    public final PopupDisplayModel mapPopupData(@Nullable CallToAction callToAction) {
        String str;
        String str2 = null;
        if (callToAction != null) {
            str = callToAction.getPopupTitle();
        } else {
            str = null;
        }
        if (callToAction != null) {
            str2 = callToAction.getPopupDescription();
        }
        return new PopupDisplayModel(str, str2);
    }

    @NotNull
    public final VendorsDisplayModel mapVendorsView(@Nullable List<? extends Restaurant> list) {
        if (list == null) {
            return new VendorsDisplayModel.ShowEmptyVendors();
        }
        RestaurantListModel restaurantListModel = new RestaurantListModel();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z11 = true;
            if (it.hasNext()) {
                Object next = it.next();
                Restaurant restaurant = (Restaurant) next;
                if (restaurant.isDarkStore && restaurant.shopType == 1) {
                    z11 = false;
                }
                if (z11) {
                    arrayList.add(next);
                }
            } else {
                restaurantListModel.setIsCollection(true);
                restaurantListModel.createNewRestautantList(arrayList);
                return new VendorsDisplayModel.ShowVendors(restaurantListModel);
            }
        }
    }
}
