package com.talabat.feature.darkstores.domain.navigator;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0001\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0002\u0010\u001bJg\u0010\u001c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u001fH&¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresNavigator;", "", "navigateInternal", "", "fragment", "Landroidx/fragment/app/Fragment;", "target", "Lcom/talabat/feature/darkstores/domain/navigator/DarkstoresInternalNavigationTarget;", "navigateToDarkStore", "activity", "Landroid/app/Activity;", "restaurant", "Ldatamodels/Restaurant;", "deeplinkType", "", "deeplinkInfo", "", "deeplinkUri", "screenTitle", "isFromDeeplink", "", "searchTerm", "eventOrigin", "shopClickOrigin", "experimentKey", "darkstoresTrackingData", "Llibrary/talabat/mvp/listingmenubridge/DarkstoresTrackingData;", "(Landroid/app/Activity;Ldatamodels/Restaurant;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Llibrary/talabat/mvp/listingmenubridge/DarkstoresTrackingData;)V", "tryNavigateUsingDeeplink", "branchId", "navigationCallback", "Lkotlin/Function1;", "(Landroid/app/Activity;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "com_talabat_feature_darkstores_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresNavigator {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void navigateToDarkStore$default(DarkstoresNavigator darkstoresNavigator, Activity activity, Restaurant restaurant, Integer num, String str, String str2, String str3, boolean z11, String str4, String str5, String str6, String str7, DarkstoresTrackingData darkstoresTrackingData, int i11, Object obj) {
            int i12 = i11;
            if (obj == null) {
                darkstoresNavigator.navigateToDarkStore(activity, restaurant, num, str, (i12 & 16) != 0 ? null : str2, (i12 & 32) != 0 ? null : str3, (i12 & 64) != 0 ? false : z11, (i12 & 128) != 0 ? null : str4, (i12 & 256) != 0 ? null : str5, (i12 & 512) != 0 ? null : str6, (i12 & 1024) != 0 ? null : str7, (i12 & 2048) != 0 ? null : darkstoresTrackingData);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateToDarkStore");
        }

        public static /* synthetic */ void tryNavigateUsingDeeplink$default(DarkstoresNavigator darkstoresNavigator, Activity activity, int i11, Integer num, String str, String str2, String str3, String str4, Function1 function1, int i12, Object obj) {
            if (obj == null) {
                darkstoresNavigator.tryNavigateUsingDeeplink(activity, i11, num, str, str2, (i12 & 32) != 0 ? null : str3, (i12 & 64) != 0 ? null : str4, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryNavigateUsingDeeplink");
        }
    }

    void navigateInternal(@NotNull Fragment fragment, @NotNull DarkstoresInternalNavigationTarget darkstoresInternalNavigationTarget);

    void navigateToDarkStore(@NotNull Activity activity, @NotNull Restaurant restaurant, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable DarkstoresTrackingData darkstoresTrackingData);

    void tryNavigateUsingDeeplink(@NotNull Activity activity, int i11, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Function1<? super Boolean, Unit> function1);
}
