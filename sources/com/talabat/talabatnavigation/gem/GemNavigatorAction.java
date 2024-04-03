package com.talabat.talabatnavigation.gem;

import android.os.Bundle;
import com.talabat.talabatnavigation.base.NavigatorModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/talabatnavigation/gem/GemNavigatorAction;", "", "()V", "OPEN_GEM_COLLECTION_ACTIVITY", "", "OPEN_GEM_OFFERING_ACTIVITY", "createNavigatorModelForGemCollectionScreen", "Lcom/talabat/talabatnavigation/base/NavigatorModel;", "bundleName", "isFromDeepLink", "", "createNavigatorModelForGemOfferScreen", "com_talabat_NewArchi_TalabatNavigation_TalabatNavigation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemNavigatorAction {
    @NotNull
    public static final GemNavigatorAction INSTANCE = new GemNavigatorAction();
    @NotNull
    public static final String OPEN_GEM_COLLECTION_ACTIVITY = "talabat.action.gem.gemCollectionScreen";
    @NotNull
    public static final String OPEN_GEM_OFFERING_ACTIVITY = "talabat.action.gem.gemOfferScreen";

    private GemNavigatorAction() {
    }

    public static /* synthetic */ NavigatorModel createNavigatorModelForGemCollectionScreen$default(GemNavigatorAction gemNavigatorAction, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return gemNavigatorAction.createNavigatorModelForGemCollectionScreen(str, z11);
    }

    @NotNull
    public final NavigatorModel createNavigatorModelForGemCollectionScreen(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "bundleName");
        Bundle bundle = new Bundle();
        bundle.putBoolean(str, z11);
        return new NavigatorModel(OPEN_GEM_COLLECTION_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final NavigatorModel createNavigatorModelForGemOfferScreen() {
        return new NavigatorModel(OPEN_GEM_OFFERING_ACTIVITY, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null);
    }
}
