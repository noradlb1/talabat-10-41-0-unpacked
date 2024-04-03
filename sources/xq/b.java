package xq;

import android.content.Context;
import androidx.annotation.NonNull;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.gem.integration.GemComponentState;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.gem.GemNavigatorAction;
import datamodels.Restaurant;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;

public final /* synthetic */ class b {
    public static Map a(GemAccessor gemAccessor) {
        return new GemComponentState().call();
    }

    @NonNull
    public static String b(GemAccessor gemAccessor) {
        Long calculateGemRemainingSeconds = BusinessRulesKt.calculateGemRemainingSeconds();
        if (calculateGemRemainingSeconds != null) {
            return calculateGemRemainingSeconds.toString();
        }
        return "";
    }

    @NonNull
    public static String c(GemAccessor gemAccessor) {
        int i11;
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant == null) {
            return GEMEngine.getNoRestaurantPosition() + "";
        }
        Integer selectedRestaurantIndex = BusinessRulesKt.selectedRestaurantIndex(Integer.valueOf(restaurant.f13872id));
        StringBuilder sb2 = new StringBuilder();
        if (selectedRestaurantIndex != null) {
            i11 = selectedRestaurantIndex.intValue() + 1;
        } else {
            i11 = GEMEngine.getNoRestaurantPosition();
        }
        sb2.append(i11);
        sb2.append("");
        return sb2.toString();
    }

    @NonNull
    public static String d(GemAccessor gemAccessor) {
        int i11;
        Integer selectedTierIndex = BusinessRulesKt.selectedTierIndex(Double.valueOf((double) Cart.getInstance().getCartSubTotal()));
        StringBuilder sb2 = new StringBuilder();
        if (selectedTierIndex != null) {
            i11 = selectedTierIndex.intValue();
        } else {
            i11 = GEMEngine.getNoGemIndexSelected();
        }
        sb2.append(i11);
        sb2.append("");
        return sb2.toString();
    }

    public static boolean e(GemAccessor gemAccessor) {
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant == null) {
            return false;
        }
        return BusinessRulesKt.isGemActive(Integer.valueOf(restaurant.f13872id));
    }

    public static boolean f(GemAccessor gemAccessor) {
        return BusinessRulesKt.isGemOffersActive();
    }

    public static void g(GemAccessor gemAccessor) {
        BusinessRulesKt.onSessionChanged();
    }

    public static void h(GemAccessor gemAccessor) {
        BusinessRulesKt.resetGemOffer().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).ignoreElement().doOnError(new a()).onErrorComplete().subscribe();
    }

    public static GemAnalyticsAccessor i(GemAccessor gemAccessor) {
        return GemAnalyticsAccessor.INSTANCE;
    }

    public static void j(Context context, String str) {
        if (str.equals(GemAccessor.COMPONENT_COLLECTION)) {
            Navigator.Companion.navigate(context, GemNavigatorAction.INSTANCE.createNavigatorModelForGemCollectionScreen(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true));
        }
    }

    public static Boolean k(int i11) {
        return Boolean.valueOf(BusinessRulesKt.selectedRestaurantBranchIndex(Integer.valueOf(i11)) != null && !BusinessRulesKt.gemExpired());
    }

    public static Boolean l(int i11) {
        return Boolean.valueOf(BusinessRulesKt.selectedRestaurantIndex(Integer.valueOf(i11)) != null && !BusinessRulesKt.gemExpired());
    }

    public static void m(int i11) {
        BusinessRulesKt.selectIfGemRestaurant(i11);
    }
}
