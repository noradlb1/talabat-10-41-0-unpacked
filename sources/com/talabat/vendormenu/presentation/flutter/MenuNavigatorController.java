package com.talabat.vendormenu.presentation.flutter;

import android.content.Context;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.menu.MenuFeatureFlagsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.menu.MenuScreen;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0013"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/MenuNavigatorController;", "", "()V", "navigateToMenu", "", "context", "Landroid/content/Context;", "navigationParams", "Lcom/talabat/vendormenu/presentation/flutter/MenuNavigatorModel;", "featureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "openFlutterMenuHandler", "deepLink", "", "openLegacyMenuHandler", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuNavigatorController {
    @NotNull
    public static final MenuNavigatorController INSTANCE = new MenuNavigatorController();

    private MenuNavigatorController() {
    }

    private final void openFlutterMenuHandler(String str, Context context, DeepLinkNavigator deepLinkNavigator) {
        DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator, context, str, (Function0) null, 4, (Object) null);
    }

    private final void openLegacyMenuHandler(MenuNavigatorModel menuNavigatorModel, Context context, Navigator navigator) {
        boolean z11;
        int i11;
        int branchId = menuNavigatorModel.getBranchId();
        String deliveryMode = menuNavigatorModel.getDeliveryMode();
        Boolean isProRestaurant = menuNavigatorModel.isProRestaurant();
        if (isProRestaurant != null) {
            z11 = isProRestaurant.booleanValue();
        } else {
            z11 = false;
        }
        boolean z12 = z11;
        String clickOrigin = menuNavigatorModel.getClickOrigin();
        Integer itemId = menuNavigatorModel.getItemId();
        if (itemId != null) {
            i11 = itemId.intValue();
        } else {
            i11 = -1;
        }
        Navigator.DefaultImpls.navigateTo$default(navigator, context, new MenuScreen(new MenuScreen.MenuData(branchId, deliveryMode, z12, clickOrigin, i11)), (Function1) null, 4, (Object) null);
    }

    public final void navigateToMenu(@NotNull Context context, @NotNull MenuNavigatorModel menuNavigatorModel, @Nullable ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull DeepLinkNavigator deepLinkNavigator, @NotNull Navigator navigator) {
        Integer itemId;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(menuNavigatorModel, "navigationParams");
        Intrinsics.checkNotNullParameter(deepLinkNavigator, "deepLinkNavigator");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        boolean z11 = false;
        if (iTalabatFeatureFlag != null && iTalabatFeatureFlag.getFeatureFlag(MenuFeatureFlagsKeys.IS_MENU_NATIVE_TO_FLUTTER_VIA_DEEPLINK_ENABLED, false)) {
            z11 = true;
        }
        if (z11) {
            String str = "talabat://?s=vendor-menu&branchId=" + menuNavigatorModel.getBranchId() + "&deliveryMode=" + menuNavigatorModel.getDeliveryMode() + "&intraFlutterNavigation=true";
            if (!StringsKt__StringsJVMKt.isBlank(menuNavigatorModel.getClickOrigin())) {
                str = str + "&shopClickOrigin=" + menuNavigatorModel.getClickOrigin();
            }
            if (menuNavigatorModel.getItemId() != null && ((itemId = menuNavigatorModel.getItemId()) == null || itemId.intValue() != -1)) {
                str = str + "&itemId=" + menuNavigatorModel.getItemId();
            }
            openFlutterMenuHandler(str, context, deepLinkNavigator);
            return;
        }
        openLegacyMenuHandler(menuNavigatorModel, context, navigator);
    }
}
