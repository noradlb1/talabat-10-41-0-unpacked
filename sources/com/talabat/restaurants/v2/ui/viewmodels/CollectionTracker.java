package com.talabat.restaurants.v2.ui.viewmodels;

import com.facebook.internal.security.CertificateUtil;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.talabatcommon.tracking.UserSettingsTracker;
import datamodels.QuickFilter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J&\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\n0\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/restaurants/v2/ui/viewmodels/CollectionTracker;", "", "userSettingsTracker", "Lcom/talabat/talabatcommon/tracking/UserSettingsTracker;", "(Lcom/talabat/talabatcommon/tracking/UserSettingsTracker;)V", "addScreenName", "Ljava/util/HashMap;", "", "getCollectionCategoryClickEvent", "Lkotlin/Pair;", "", "collection", "Ldatamodels/QuickFilter;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionTracker {
    @NotNull
    private final UserSettingsTracker userSettingsTracker;

    public CollectionTracker() {
        this((UserSettingsTracker) null, 1, (DefaultConstructorMarker) null);
    }

    public CollectionTracker(@NotNull UserSettingsTracker userSettingsTracker2) {
        Intrinsics.checkNotNullParameter(userSettingsTracker2, "userSettingsTracker");
        this.userSettingsTracker = userSettingsTracker2;
    }

    private final HashMap<String, String> addScreenName() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("screenName", ScreenNames.GROCERYMENUSCREEN);
        return hashMap;
    }

    @NotNull
    public final Pair<String, Map<String, String>> getCollectionCategoryClickEvent(@NotNull QuickFilter quickFilter) {
        Intrinsics.checkNotNullParameter(quickFilter, GemAccessor.COMPONENT_COLLECTION);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.userSettingsTracker.addUserSettings());
        hashMap.putAll(addScreenName());
        hashMap.put(ConstantsKt.LOADED_LIST_VIEW_TYPE, "list_view");
        hashMap.put("screenType", "Category tile");
        String slug = quickFilter.getSlug();
        Integer id2 = quickFilter.getId();
        hashMap.put("channelIndex", slug + CertificateUtil.DELIMITER + id2);
        hashMap.put("eventOrigin", "shop list");
        hashMap.put("shopListType", "groceries");
        hashMap.put("listingPageType", "groceries");
        hashMap.put(ConstantsKt.LOADED_SHOP_LIST_TRIGGER, "channel");
        return new Pair<>("category_details_clicked", hashMap);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CollectionTracker(UserSettingsTracker userSettingsTracker2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new UserSettingsTracker((Function0) null, 1, (DefaultConstructorMarker) null) : userSettingsTracker2);
    }
}
