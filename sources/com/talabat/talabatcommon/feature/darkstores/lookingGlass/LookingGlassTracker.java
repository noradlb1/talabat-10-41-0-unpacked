package com.talabat.talabatcommon.feature.darkstores.lookingGlass;

import com.talabat.talabatcommon.tracking.UserSettingsTracker;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GDisplayItem;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\b0\u0006J&\u0010\t\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\b0\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/LookingGlassTracker;", "", "userSettingsTracker", "Lcom/talabat/talabatcommon/tracking/UserSettingsTracker;", "(Lcom/talabat/talabatcommon/tracking/UserSettingsTracker;)V", "categoryClickedEvent", "Lkotlin/Pair;", "", "", "itemClickedEvent", "item", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassTracker {
    @NotNull
    private final UserSettingsTracker userSettingsTracker;

    public LookingGlassTracker() {
        this((UserSettingsTracker) null, 1, (DefaultConstructorMarker) null);
    }

    public LookingGlassTracker(@NotNull UserSettingsTracker userSettingsTracker2) {
        Intrinsics.checkNotNullParameter(userSettingsTracker2, "userSettingsTracker");
        this.userSettingsTracker = userSettingsTracker2;
    }

    @NotNull
    public final Pair<String, Map<String, String>> categoryClickedEvent() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.userSettingsTracker.addUserSettings());
        hashMap.put("listingPageType", "grocery");
        return new Pair<>("category_tab_clicked_temp", hashMap);
    }

    @NotNull
    public final Pair<String, Map<String, String>> itemClickedEvent(@NotNull GDisplayItem gDisplayItem) {
        boolean z11;
        Intrinsics.checkNotNullParameter(gDisplayItem, "item");
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.userSettingsTracker.addUserSettings());
        hashMap.put("listingPageType", "grocery");
        hashMap.put("productSku", String.valueOf(gDisplayItem.getId()));
        String discountText = gDisplayItem.getDiscountText();
        if (discountText == null || discountText.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            String discountText2 = gDisplayItem.getDiscountText();
            hashMap.put("item_promotion", "true, " + discountText2);
        } else {
            hashMap.put("item_promotion", "false");
        }
        return new Pair<>("item_clicked_temp", hashMap);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LookingGlassTracker(UserSettingsTracker userSettingsTracker2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new UserSettingsTracker((Function0) null, 1, (DefaultConstructorMarker) null) : userSettingsTracker2);
    }
}
