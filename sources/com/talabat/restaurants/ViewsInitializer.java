package com.talabat.restaurants;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.talabat.R;
import com.talabat.components.gem.GemComponentRestaurantsListStrategy;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.restaurants.tmart.DarkstoreEntryView;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.LookingGlassView;
import com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/restaurants/ViewsInitializer;", "Lio/reactivex/functions/Consumer;", "Lcom/talabat/restaurants/RestaurantsListScreenRefactor;", "()V", "accept", "", "activity", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewsInitializer implements Consumer<RestaurantsListScreenRefactor> {
    public void accept(@NotNull RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        Intrinsics.checkNotNullParameter(restaurantsListScreenRefactor, "activity");
        restaurantsListScreenRefactor.f61215u = (TextView) restaurantsListScreenRefactor.findViewById(R.id.textView_screenTitle);
        LinearLayout linearLayout = (LinearLayout) restaurantsListScreenRefactor.findViewById(R.id.linearLayout_deliveringAtContainer);
        restaurantsListScreenRefactor.f61216v = linearLayout;
        linearLayout.setOnClickListener(restaurantsListScreenRefactor);
        restaurantsListScreenRefactor.f61203i = (ImageButton) restaurantsListScreenRefactor.findViewById(R.id.imageButton_cart);
        restaurantsListScreenRefactor.f61204j = (TextView) restaurantsListScreenRefactor.findViewById(R.id.textView_cartCount);
        FrameLayout frameLayout = (FrameLayout) restaurantsListScreenRefactor.findViewById(R.id.frameLayout_cartContainer);
        restaurantsListScreenRefactor.f61205k = frameLayout;
        frameLayout.setOnClickListener(restaurantsListScreenRefactor);
        ImageButton imageButton = (ImageButton) restaurantsListScreenRefactor.findViewById(R.id.favouriteImageButton);
        restaurantsListScreenRefactor.f61206l = imageButton;
        imageButton.setOnClickListener(restaurantsListScreenRefactor);
        restaurantsListScreenRefactor.f61207m = (Toolbar) restaurantsListScreenRefactor.findViewById(R.id.toolBar_main);
        restaurantsListScreenRefactor.f61217w = (AppBarLayout) restaurantsListScreenRefactor.findViewById(R.id.appbarLayout);
        restaurantsListScreenRefactor.f61208n = (LinearLayout) restaurantsListScreenRefactor.findViewById(R.id.linearLayout_searchButton);
        restaurantsListScreenRefactor.f61209o = restaurantsListScreenRefactor.findViewById(R.id.pickupTooltip);
        restaurantsListScreenRefactor.f61208n.setOnClickListener(restaurantsListScreenRefactor);
        restaurantsListScreenRefactor.f61210p = (LinearLayout) restaurantsListScreenRefactor.findViewById(R.id.linearLayout_filtersContainer);
        restaurantsListScreenRefactor.f61211q = (LinearLayout) restaurantsListScreenRefactor.findViewById(R.id.linearLayout_collections);
        restaurantsListScreenRefactor.f61212r = (TextView) restaurantsListScreenRefactor.findViewById(R.id.textView_collection_title);
        restaurantsListScreenRefactor.f61213s = (LinearLayout) restaurantsListScreenRefactor.findViewById(R.id.linearLayout_headerContainer);
        restaurantsListScreenRefactor.f61214t = (RecyclerView) restaurantsListScreenRefactor.findViewById(R.id.recyclerView_collections);
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = restaurantsListScreenRefactor.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.initializeViews();
        }
        restaurantsListScreenRefactor.f61220z = (TabBarWithTagView) restaurantsListScreenRefactor.findViewById(R.id.orderModeTabBar);
        restaurantsListScreenRefactor.f61218x = (DarkstoreEntryView) restaurantsListScreenRefactor.findViewById(R.id.darkStore);
        restaurantsListScreenRefactor.f61219y = (LookingGlassView) restaurantsListScreenRefactor.findViewById(R.id.looking_glass);
        if (restaurantsListScreenRefactor.I == 0) {
            restaurantsListScreenRefactor.f61210p.setWeightSum(3.0f);
        } else {
            restaurantsListScreenRefactor.f61210p.setWeightSum(2.0f);
        }
        if (restaurantsListScreenRefactor.I == 0 && !ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.CAN_ENABLE_LISTING_DHSEARCH, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            restaurantsListScreenRefactor.f61208n.setVisibility(8);
        }
    }
}
