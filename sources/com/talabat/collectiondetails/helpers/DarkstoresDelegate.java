package com.talabat.collectiondetails.helpers;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.talabat.collectiondetails.integration.CollectionsDetailsIntegrator;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.localization.R;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;
import vf.a;
import vf.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/talabat/collectiondetails/helpers/DarkstoresDelegate;", "", "()V", "Companion", "DSClickOrigin", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresDelegate {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0002JB\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J@\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002¨\u0006\u0015"}, d2 = {"Lcom/talabat/collectiondetails/helpers/DarkstoresDelegate$Companion;", "", "()V", "onDarkstoresClicked", "", "activity", "Landroid/app/Activity;", "restaurant", "Ldatamodels/Restaurant;", "deeplinkType", "", "deeplinkInfo", "", "isFromDeepLink", "", "shouldFinish", "clickOrigin", "Lcom/talabat/collectiondetails/helpers/DarkstoresDelegate$DSClickOrigin;", "pauseAdForNextScreen", "setSelectedRestaurantAndNavigate", "showStatusAlertForDarkstores", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void onDarkstoresClicked$default(Companion companion, Activity activity, Restaurant restaurant, int i11, String str, boolean z11, boolean z12, DSClickOrigin dSClickOrigin, int i12, Object obj) {
            int i13;
            String str2;
            boolean z13;
            boolean z14;
            DSClickOrigin dSClickOrigin2;
            if ((i12 & 4) != 0) {
                i13 = -1;
            } else {
                i13 = i11;
            }
            if ((i12 & 8) != 0) {
                str2 = "";
            } else {
                str2 = str;
            }
            if ((i12 & 16) != 0) {
                z13 = false;
            } else {
                z13 = z11;
            }
            if ((i12 & 32) != 0) {
                z14 = false;
            } else {
                z14 = z12;
            }
            if ((i12 & 64) != 0) {
                dSClickOrigin2 = DSClickOrigin.ORIGIN_LISTING;
            } else {
                dSClickOrigin2 = dSClickOrigin;
            }
            companion.onDarkstoresClicked(activity, restaurant, i13, str2, z13, z14, dSClickOrigin2);
        }

        private final void pauseAdForNextScreen() {
            CollectionsDetailsIntegrator.INSTANCE.pauseBannerForNextScreen().invoke();
        }

        private final void setSelectedRestaurantAndNavigate(Activity activity, Restaurant restaurant, boolean z11, boolean z12, int i11, String str, String str2) {
            pauseAdForNextScreen();
            DarkstoresNavigator.DefaultImpls.navigateToDarkStore$default(((DarkstoresFeatureApi) AndroidComponentsKt.apiContainer(activity).getFeature(DarkstoresFeatureApi.class)).darkstoresNavigator(), activity, restaurant, Integer.valueOf(i11), str, (String) null, (String) null, z11, (String) null, (String) null, str2, (String) null, (DarkstoresTrackingData) null, 3456, (Object) null);
            if (z12) {
                activity.finish();
            }
        }

        private final void showStatusAlertForDarkstores(Activity activity, Restaurant restaurant, boolean z11, boolean z12, int i11, String str, String str2) {
            String str3;
            Activity activity2 = activity;
            if (restaurant.statusType == 1) {
                str3 = activity2.getString(R.string.restaurant_closed);
            } else {
                str3 = activity2.getString(R.string.restaurant_busy);
            }
            Intrinsics.checkNotNullExpressionValue(str3, "if (restaurant.statusTyp…t_busy)\n                }");
            String string = activity2.getString(R.string.we_are_sorry_message);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t…ing.we_are_sorry_message)");
            String name2 = restaurant.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "restaurant.getName()");
            String string2 = activity2.getString(R.string.continue_to_restaurant);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(com.t…g.continue_to_restaurant)");
            new AlertDialog.Builder(activity2).setTitle((CharSequence) activity2.getString(R.string.restaurant) + " " + str3).setMessage((CharSequence) StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, name2, false, 4, (Object) null), "**", str3, false, 4, (Object) null)).setPositiveButton((CharSequence) string2, (DialogInterface.OnClickListener) new a(activity, restaurant, z11, z12, i11, str, str2)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new b(z12, activity2)).show();
        }

        /* access modifiers changed from: private */
        /* renamed from: showStatusAlertForDarkstores$lambda-0  reason: not valid java name */
        public static final void m9541showStatusAlertForDarkstores$lambda0(Activity activity, Restaurant restaurant, boolean z11, boolean z12, int i11, String str, String str2, DialogInterface dialogInterface, int i12) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(restaurant, "$restaurant");
            Intrinsics.checkNotNullParameter(str, "$deeplinkInfo");
            Intrinsics.checkNotNullParameter(str2, "$clickOrigin");
            DarkstoresDelegate.Companion.setSelectedRestaurantAndNavigate(activity, restaurant, z11, z12, i11, str, str2);
        }

        /* access modifiers changed from: private */
        /* renamed from: showStatusAlertForDarkstores$lambda-1  reason: not valid java name */
        public static final void m9542showStatusAlertForDarkstores$lambda1(boolean z11, Activity activity, DialogInterface dialogInterface, int i11) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            if (z11) {
                activity.finish();
            }
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(restaurant, "restaurant");
            onDarkstoresClicked$default(this, activity, restaurant, 0, (String) null, false, false, (DSClickOrigin) null, 124, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(restaurant, "restaurant");
            onDarkstoresClicked$default(this, activity, restaurant, i11, (String) null, false, false, (DSClickOrigin) null, 120, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(restaurant, "restaurant");
            Intrinsics.checkNotNullParameter(str, "deeplinkInfo");
            onDarkstoresClicked$default(this, activity, restaurant, i11, str, false, false, (DSClickOrigin) null, 112, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(restaurant, "restaurant");
            Intrinsics.checkNotNullParameter(str, "deeplinkInfo");
            onDarkstoresClicked$default(this, activity, restaurant, i11, str, z11, false, (DSClickOrigin) null, 96, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(restaurant, "restaurant");
            Intrinsics.checkNotNullParameter(str, "deeplinkInfo");
            onDarkstoresClicked$default(this, activity, restaurant, i11, str, z11, z12, (DSClickOrigin) null, 64, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12, @NotNull DSClickOrigin dSClickOrigin) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(restaurant, "restaurant");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str, "deeplinkInfo");
            Intrinsics.checkNotNullParameter(dSClickOrigin, ConstantsKt.CLICK_CLICK_ORIGIN);
            int i12 = restaurant.statusType;
            if (i12 == 2 || i12 == 1) {
                showStatusAlertForDarkstores(activity, restaurant, z11, z12, i11, str, dSClickOrigin.getOrigin());
            } else {
                setSelectedRestaurantAndNavigate(activity, restaurant, z11, z12, i11, str, dSClickOrigin.getOrigin());
            }
            GlobalDataModel.ShopClickOrigin = dSClickOrigin.getOrigin();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/collectiondetails/helpers/DarkstoresDelegate$DSClickOrigin;", "", "origin", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getOrigin", "()Ljava/lang/String;", "ORIGIN_LISTING", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum DSClickOrigin {
        ORIGIN_LISTING(DefaultCardView.CARD_LIST);
        
        @NotNull
        private final String origin;

        private DSClickOrigin(String str) {
            this.origin = str;
        }

        @NotNull
        public final String getOrigin() {
            return this.origin;
        }
    }
}
