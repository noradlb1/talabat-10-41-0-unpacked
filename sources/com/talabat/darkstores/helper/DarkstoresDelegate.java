package com.talabat.darkstores.helper;

import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.media.MediaBrowserServiceCompat;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.R;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.darkstores.domain.DarkstoresFeatureApi;
import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatApplication;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj.a;
import qj.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/helper/DarkstoresDelegate;", "", "()V", "Companion", "DSClickOrigin", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresDelegate {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Instrumented
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002Jl\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J`\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002JN\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\"¨\u0006#"}, d2 = {"Lcom/talabat/darkstores/helper/DarkstoresDelegate$Companion;", "", "()V", "getRestaurantFromString", "Ldatamodels/Restaurant;", "value", "", "onDarkstoresClicked", "", "activity", "Landroid/app/Activity;", "restaurant", "deeplinkType", "", "deeplinkInfo", "isFromDeepLink", "", "shouldSuppressVendorStatusAlert", "shouldFinish", "clickOrigin", "Lcom/talabat/darkstores/helper/DarkstoresDelegate$DSClickOrigin;", "deeplinkUri", "screenTitle", "searchTerm", "eventOrigin", "darkstoresTrackingData", "Llibrary/talabat/mvp/listingmenubridge/DarkstoresTrackingData;", "pauseAdForNextScreen", "setSelectedRestaurantAndNavigate", "showStatusAlertForDarkstores", "tryNavigateUsingDeeplink", "branchId", "shopClickOrigin", "navigationCallback", "Lcom/talabat/darkstores/helper/NavigationCallback;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void c(Companion companion, Activity activity, Restaurant restaurant, boolean z11, boolean z12, int i11, String str, String str2, String str3, String str4, String str5, String str6, DarkstoresTrackingData darkstoresTrackingData, int i12, Object obj) {
            companion.setSelectedRestaurantAndNavigate(activity, restaurant, z11, z12, i11, str, str2, str3, str4, str5, str6, (i12 & 2048) != 0 ? null : darkstoresTrackingData);
        }

        public static /* synthetic */ void onDarkstoresClicked$default(Companion companion, Activity activity, Restaurant restaurant, int i11, String str, boolean z11, boolean z12, boolean z13, DSClickOrigin dSClickOrigin, String str2, String str3, String str4, String str5, DarkstoresTrackingData darkstoresTrackingData, int i12, Object obj) {
            int i13;
            String str6;
            boolean z14;
            boolean z15;
            boolean z16;
            DSClickOrigin dSClickOrigin2;
            String str7;
            String str8;
            String str9;
            String str10;
            DarkstoresTrackingData darkstoresTrackingData2;
            int i14 = i12;
            if ((i14 & 4) != 0) {
                i13 = -1;
            } else {
                i13 = i11;
            }
            if ((i14 & 8) != 0) {
                str6 = "";
            } else {
                str6 = str;
            }
            if ((i14 & 16) != 0) {
                z14 = false;
            } else {
                z14 = z11;
            }
            if ((i14 & 32) != 0) {
                z15 = false;
            } else {
                z15 = z12;
            }
            if ((i14 & 64) != 0) {
                z16 = false;
            } else {
                z16 = z13;
            }
            if ((i14 & 128) != 0) {
                dSClickOrigin2 = DSClickOrigin.ORIGIN_LISTING;
            } else {
                dSClickOrigin2 = dSClickOrigin;
            }
            if ((i14 & 256) != 0) {
                str7 = "";
            } else {
                str7 = str2;
            }
            if ((i14 & 512) != 0) {
                str8 = "";
            } else {
                str8 = str3;
            }
            if ((i14 & 1024) != 0) {
                str9 = "N/A";
            } else {
                str9 = str4;
            }
            if ((i14 & 2048) != 0) {
                str10 = "N/A";
            } else {
                str10 = str5;
            }
            if ((i14 & 4096) != 0) {
                darkstoresTrackingData2 = null;
            } else {
                darkstoresTrackingData2 = darkstoresTrackingData;
            }
            companion.onDarkstoresClicked(activity, restaurant, i13, str6, z14, z15, z16, dSClickOrigin2, str7, str8, str9, str10, darkstoresTrackingData2);
        }

        private final void pauseAdForNextScreen(Activity activity) {
            TalabatApplication talabatApplication;
            Application application = activity.getApplication();
            if (application instanceof TalabatApplication) {
                talabatApplication = (TalabatApplication) application;
            } else {
                talabatApplication = null;
            }
            if (talabatApplication != null) {
                talabatApplication.pauseBannerForNextScreen();
            }
        }

        private final void setSelectedRestaurantAndNavigate(Activity activity, Restaurant restaurant, boolean z11, boolean z12, int i11, String str, String str2, String str3, String str4, String str5, String str6, DarkstoresTrackingData darkstoresTrackingData) {
            pauseAdForNextScreen(activity);
            DarkstoresNavigator.DefaultImpls.navigateToDarkStore$default(((DarkstoresFeatureApi) AndroidComponentsKt.apiContainer(activity).getFeature(DarkstoresFeatureApi.class)).darkstoresNavigator(), activity, restaurant, Integer.valueOf(i11), str, str2, str3, z11, str4, str5, str6, (String) null, darkstoresTrackingData, 1024, (Object) null);
            if (z12) {
                activity.finish();
            }
        }

        private final void showStatusAlertForDarkstores(Activity activity, Restaurant restaurant, boolean z11, boolean z12, int i11, String str, String str2, String str3, String str4, String str5, String str6) {
            String str7;
            Activity activity2 = activity;
            if (restaurant.statusType == 1) {
                str7 = activity2.getString(R.string.restaurant_closed);
            } else {
                str7 = activity2.getString(R.string.restaurant_busy);
            }
            Intrinsics.checkNotNullExpressionValue(str7, "if (restaurant.statusTyp…urant_busy)\n            }");
            String string = activity2.getString(R.string.we_are_sorry_message);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.we_are_sorry_message)");
            String name2 = restaurant.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "restaurant.getName()");
            String string2 = activity2.getString(R.string.continue_to_restaurant);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…g.continue_to_restaurant)");
            new AlertDialog.Builder(activity2).setTitle((CharSequence) activity2.getString(R.string.restaurant) + " " + str7).setMessage((CharSequence) StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(string, RichContentLoadTimeRecorder.DELIMETER, name2, false, 4, (Object) null), "**", str7, false, 4, (Object) null)).setPositiveButton((CharSequence) string2, (DialogInterface.OnClickListener) new a(activity, restaurant, z11, z12, i11, str, str2, str3, str4, str5, str6)).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new b(z12, activity2)).show();
        }

        /* access modifiers changed from: private */
        /* renamed from: showStatusAlertForDarkstores$lambda-0  reason: not valid java name */
        public static final void m10097showStatusAlertForDarkstores$lambda0(Activity activity, Restaurant restaurant, boolean z11, boolean z12, int i11, String str, String str2, String str3, String str4, String str5, String str6, DialogInterface dialogInterface, int i12) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "$activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "$restaurant");
            String str7 = str;
            Intrinsics.checkNotNullParameter(str7, "$deeplinkInfo");
            String str8 = str2;
            Intrinsics.checkNotNullParameter(str8, "$deeplinkUri");
            String str9 = str3;
            Intrinsics.checkNotNullParameter(str9, "$screenTitle");
            String str10 = str4;
            Intrinsics.checkNotNullParameter(str10, "$searchTerm");
            String str11 = str5;
            Intrinsics.checkNotNullParameter(str11, "$eventOrigin");
            String str12 = str6;
            Intrinsics.checkNotNullParameter(str12, "$clickOrigin");
            c(DarkstoresDelegate.Companion, activity2, restaurant2, z11, z12, i11, str7, str8, str9, str10, str11, str12, (DarkstoresTrackingData) null, 2048, (Object) null);
        }

        /* access modifiers changed from: private */
        /* renamed from: showStatusAlertForDarkstores$lambda-1  reason: not valid java name */
        public static final void m10098showStatusAlertForDarkstores$lambda1(boolean z11, Activity activity, DialogInterface dialogInterface, int i11) {
            Intrinsics.checkNotNullParameter(activity, "$activity");
            if (z11) {
                activity.finish();
            }
        }

        @Nullable
        public final Restaurant getRestaurantFromString(@NotNull String str) {
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                Result.Companion companion = Result.Companion;
                Gson gson = UniversalGson.INSTANCE.gson;
                Class cls = Restaurant.class;
                if (!(gson instanceof Gson)) {
                    obj2 = gson.fromJson(str, cls);
                } else {
                    obj2 = GsonInstrumentation.fromJson(gson, str, cls);
                }
                obj = Result.m6329constructorimpl((Restaurant) obj2);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m6335isFailureimpl(obj)) {
                obj = null;
            }
            return (Restaurant) obj;
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            onDarkstoresClicked$default(this, activity2, restaurant2, 0, (String) null, false, false, false, (DSClickOrigin) null, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 8188, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, (String) null, false, false, false, (DSClickOrigin) null, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 8184, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "deeplinkInfo");
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, str2, false, false, false, (DSClickOrigin) null, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 8176, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "deeplinkInfo");
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, str2, z11, false, false, (DSClickOrigin) null, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 8160, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "deeplinkInfo");
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, str2, z11, z12, false, (DSClickOrigin) null, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 8128, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12, boolean z13) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "deeplinkInfo");
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, str2, z11, z12, z13, (DSClickOrigin) null, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 8064, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12, boolean z13, @NotNull DSClickOrigin dSClickOrigin) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "deeplinkInfo");
            DSClickOrigin dSClickOrigin2 = dSClickOrigin;
            Intrinsics.checkNotNullParameter(dSClickOrigin2, ConstantsKt.CLICK_CLICK_ORIGIN);
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, str2, z11, z12, z13, dSClickOrigin2, (String) null, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 7936, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12, boolean z13, @NotNull DSClickOrigin dSClickOrigin, @NotNull String str2) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            String str3 = str;
            Intrinsics.checkNotNullParameter(str3, "deeplinkInfo");
            DSClickOrigin dSClickOrigin2 = dSClickOrigin;
            Intrinsics.checkNotNullParameter(dSClickOrigin2, ConstantsKt.CLICK_CLICK_ORIGIN);
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str4, "deeplinkUri");
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, str3, z11, z12, z13, dSClickOrigin2, str4, (String) null, (String) null, (String) null, (DarkstoresTrackingData) null, 7680, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12, boolean z13, @NotNull DSClickOrigin dSClickOrigin, @NotNull String str2, @NotNull String str3) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            String str4 = str;
            Intrinsics.checkNotNullParameter(str4, "deeplinkInfo");
            DSClickOrigin dSClickOrigin2 = dSClickOrigin;
            Intrinsics.checkNotNullParameter(dSClickOrigin2, ConstantsKt.CLICK_CLICK_ORIGIN);
            String str5 = str2;
            Intrinsics.checkNotNullParameter(str5, "deeplinkUri");
            String str6 = str3;
            Intrinsics.checkNotNullParameter(str6, "screenTitle");
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, str4, z11, z12, z13, dSClickOrigin2, str5, str6, (String) null, (String) null, (DarkstoresTrackingData) null, 7168, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12, boolean z13, @NotNull DSClickOrigin dSClickOrigin, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            String str5 = str;
            Intrinsics.checkNotNullParameter(str5, "deeplinkInfo");
            DSClickOrigin dSClickOrigin2 = dSClickOrigin;
            Intrinsics.checkNotNullParameter(dSClickOrigin2, ConstantsKt.CLICK_CLICK_ORIGIN);
            String str6 = str2;
            Intrinsics.checkNotNullParameter(str6, "deeplinkUri");
            String str7 = str3;
            Intrinsics.checkNotNullParameter(str7, "screenTitle");
            String str8 = str4;
            Intrinsics.checkNotNullParameter(str8, "searchTerm");
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, str5, z11, z12, z13, dSClickOrigin2, str6, str7, str8, (String) null, (DarkstoresTrackingData) null, 6144, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12, boolean z13, @NotNull DSClickOrigin dSClickOrigin, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Restaurant restaurant2 = restaurant;
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            String str6 = str;
            Intrinsics.checkNotNullParameter(str6, "deeplinkInfo");
            DSClickOrigin dSClickOrigin2 = dSClickOrigin;
            Intrinsics.checkNotNullParameter(dSClickOrigin2, ConstantsKt.CLICK_CLICK_ORIGIN);
            String str7 = str2;
            Intrinsics.checkNotNullParameter(str7, "deeplinkUri");
            String str8 = str3;
            Intrinsics.checkNotNullParameter(str8, "screenTitle");
            String str9 = str4;
            Intrinsics.checkNotNullParameter(str9, "searchTerm");
            String str10 = str5;
            Intrinsics.checkNotNullParameter(str10, "eventOrigin");
            onDarkstoresClicked$default(this, activity2, restaurant2, i11, str6, z11, z12, z13, dSClickOrigin2, str7, str8, str9, str10, (DarkstoresTrackingData) null, 4096, (Object) null);
        }

        @JvmOverloads
        public final void onDarkstoresClicked(@NotNull Activity activity, @NotNull Restaurant restaurant, int i11, @NotNull String str, boolean z11, boolean z12, boolean z13, @NotNull DSClickOrigin dSClickOrigin, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable DarkstoresTrackingData darkstoresTrackingData) {
            String str6;
            int i12;
            Restaurant restaurant2 = restaurant;
            Activity activity2 = activity;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            Intrinsics.checkNotNullParameter(str, "deeplinkInfo");
            Intrinsics.checkNotNullParameter(dSClickOrigin, ConstantsKt.CLICK_CLICK_ORIGIN);
            Intrinsics.checkNotNullParameter(str2, "deeplinkUri");
            Intrinsics.checkNotNullParameter(str3, "screenTitle");
            Intrinsics.checkNotNullParameter(str4, "searchTerm");
            Intrinsics.checkNotNullParameter(str5, "eventOrigin");
            String str7 = GlobalDataModel.ShopClickOrigin;
            Intrinsics.checkNotNullExpressionValue(str7, "ShopClickOrigin");
            if (!StringsKt__StringsKt.contains$default((CharSequence) str7, (CharSequence) MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, false, 2, (Object) null)) {
                str6 = dSClickOrigin.getOrigin();
            } else {
                str6 = GlobalDataModel.ShopClickOrigin;
            }
            String str8 = str6;
            if (z12 || !((i12 = restaurant2.statusType) == 2 || i12 == 1)) {
                Intrinsics.checkNotNullExpressionValue(str8, "updatedClickOrigin");
                setSelectedRestaurantAndNavigate(activity, restaurant, z11, z13, i11, str, str2, str3, str4, str5, str8, darkstoresTrackingData);
            } else {
                Intrinsics.checkNotNullExpressionValue(str8, "updatedClickOrigin");
                showStatusAlertForDarkstores(activity, restaurant, z11, z13, i11, str, str2, str3, str4, str5, str8);
            }
            GlobalDataModel.ShopClickOrigin = str8;
        }

        public final void tryNavigateUsingDeeplink(@NotNull Activity activity, int i11, int i12, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull NavigationCallback navigationCallback) {
            NavigationCallback navigationCallback2 = navigationCallback;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(navigationCallback2, "navigationCallback");
            ((DarkstoresFeatureApi) AndroidComponentsKt.apiContainer(activity).getFeature(DarkstoresFeatureApi.class)).darkstoresNavigator().tryNavigateUsingDeeplink(activity, i11, Integer.valueOf(i12), str, str2, str3, str4, new DarkstoresDelegate$Companion$tryNavigateUsingDeeplink$1(navigationCallback2));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/helper/DarkstoresDelegate$DSClickOrigin;", "", "origin", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getOrigin", "()Ljava/lang/String;", "ORIGIN_HOME", "ORIGIN_BANNER", "ORIGIN_LISTING", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum DSClickOrigin {
        ORIGIN_HOME("home"),
        ORIGIN_BANNER("banner"),
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
