package com.talabat.restaurants;

import android.app.Activity;
import android.content.Intent;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity;
import com.talabat.collectiondetails.ui.quickfilter.SubscribeCollectionActivity;
import com.talabat.collectiondetails.ui.quickfilter.UnsubscribeCollectionActivity;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.darkstores.helper.DarkstoresDelegate;
import com.talabat.offering.ui.OfferCollectionActivity;
import com.talabat.restaurants.v2.domain.exceptions.CollectionCategoryException;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import io.reactivex.functions.BiConsumer;
import library.talabat.SharedPreferencesManager;

class OnQuickFilterClick implements BiConsumer<RestaurantsListScreenRefactor, QuickFilter> {
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public OnQuickFilterClick(ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private Intent getIntentForCollectionsActivity(RestaurantsListScreenRefactor restaurantsListScreenRefactor, QuickFilter quickFilter) {
        Intent intent;
        if (isNormalCollection(quickFilter)) {
            intent = makeNormalCollectionIntent(restaurantsListScreenRefactor);
        } else {
            intent = makeSubscribeCollectionIntent(restaurantsListScreenRefactor);
        }
        intent.putExtra("verticalType", SharedPreferencesManager.getInstance(restaurantsListScreenRefactor).getLastFavVertical());
        return intent;
    }

    private boolean isNormalCollection(QuickFilter quickFilter) {
        if (quickFilter.getCollectionType() == null || quickFilter.getCollectionType().equalsIgnoreCase("normal")) {
            return true;
        }
        return false;
    }

    private Intent makeNormalCollectionIntent(Activity activity) {
        return new Intent(activity, UnsubscribeCollectionActivity.class);
    }

    private Intent makeSubscribeCollectionIntent(Activity activity) {
        return new Intent(activity, SubscribeCollectionActivity.class);
    }

    private void openCollectionDetails(RestaurantsListScreenRefactor restaurantsListScreenRefactor, QuickFilter quickFilter) {
        boolean booleanExtra = restaurantsListScreenRefactor.getIntent().getBooleanExtra(RestaurantsListScreenRefactor.EXTRA_IS_FROM_HOME_COLLECTION, false);
        Intent intentForCollectionsActivity = getIntentForCollectionsActivity(restaurantsListScreenRefactor, quickFilter);
        intentForCollectionsActivity.putExtra(QuickFilterRestaurantsActivity.ARG_VERTICAL_ID, restaurantsListScreenRefactor.I);
        intentForCollectionsActivity.putExtra("ARG_QUICK_FILTER", quickFilter);
        intentForCollectionsActivity.putExtra("ARG_POLYGON_EVENT", restaurantsListScreenRefactor.G);
        intentForCollectionsActivity.putExtra(QuickFilterRestaurantsActivity.ARG_IS_DIRECTLY_FROM_HOME, booleanExtra);
        restaurantsListScreenRefactor.GaOnChannelClicked(quickFilter.getSlug());
        restaurantsListScreenRefactor.startActivity(intentForCollectionsActivity);
        if (booleanExtra) {
            restaurantsListScreenRefactor.finish();
        }
    }

    private void openTmartCategoryScreen(RestaurantsListScreenRefactor restaurantsListScreenRefactor, QuickFilter quickFilter) {
        try {
            Restaurant darkStore = restaurantsListScreenRefactor.getDarkStore();
            if (darkStore != null) {
                RestaurantsListScreenRefactor restaurantsListScreenRefactor2 = restaurantsListScreenRefactor;
                DarkstoresDelegate.Companion.onDarkstoresClicked(restaurantsListScreenRefactor2, darkStore, restaurantsListScreenRefactor.mPresenter.getTMartScreenType(quickFilter.getDeepLink()), restaurantsListScreenRefactor.mPresenter.getTMartCategoryId(quickFilter.getDeepLink()), false, false, false, DarkstoresDelegate.DSClickOrigin.ORIGIN_LISTING, "", restaurantsListScreenRefactor.mPresenter.getTMartScreenTitle(quickFilter.getDeepLink()));
                return;
            }
            LogManager.logException(new CollectionCategoryException("No DarkStore in the Area"));
            openCollectionDetails(restaurantsListScreenRefactor, quickFilter);
        } catch (CollectionCategoryException e11) {
            LogManager.logException(e11);
            openCollectionDetails(restaurantsListScreenRefactor, quickFilter);
        }
    }

    public void a(RestaurantsListScreenRefactor restaurantsListScreenRefactor, QuickFilter quickFilter) {
        Intent intent = new Intent(restaurantsListScreenRefactor, OfferCollectionActivity.class);
        intent.putExtra(OfferCollectionActivity.COLLECTION_ID_PARAM, quickFilter.getId());
        restaurantsListScreenRefactor.startActivity(intent);
    }

    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor, QuickFilter quickFilter) {
        if (quickFilter != null) {
            if (restaurantsListScreenRefactor.mPresenter.isCategoryCollection(quickFilter)) {
                restaurantsListScreenRefactor.mPresenter.sendCollectionClickEvent(quickFilter);
                openTmartCategoryScreen(restaurantsListScreenRefactor, quickFilter);
            } else if (quickFilter.getCollectionType() == null || !quickFilter.getCollectionType().equalsIgnoreCase("Subscribed") || !this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_OFFERING_NAVIGATION, false)) {
                openCollectionDetails(restaurantsListScreenRefactor, quickFilter);
            } else {
                a(restaurantsListScreenRefactor, quickFilter);
            }
        }
    }
}
