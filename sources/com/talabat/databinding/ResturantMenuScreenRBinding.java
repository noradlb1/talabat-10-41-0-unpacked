package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.feature.tpro.presentation.databinding.TproSubscriptionHeaderBinding;
import com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView;
import com.talabat.gem.adapters.presentation.menu.GemMenuFooterView;
import com.talabat.helpers.BaseRatingBar;
import com.talabat.helpers.MiniCartLayout;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.homescreen.widget.BaseHomeHorizontalRecyclerViewLayout;

public final class ResturantMenuScreenRBinding implements ViewBinding {
    @NonNull
    public final AppBarLayout appbar;
    @NonNull
    public final ImageView back;
    @NonNull
    public final ImageView binDiscountIcon;
    @NonNull
    public final RelativeLayout binView;
    @NonNull
    public final TalabatTextView bottomSheetTitle;
    @NonNull
    public final ImageView closeBinView;
    @NonNull
    public final ImageView closeCategories;
    @NonNull
    public final LinearLayout closeCategoriesView;
    @NonNull
    public final CollapsingToolbarLayout collapseToolBar;
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final TalabatTextView deliveryTimeText;
    @NonNull
    public final LinearLayout detailBottomView;
    @NonNull
    public final ImageView extraTextWarning;
    @NonNull
    public final RelativeLayout footer;
    @NonNull
    public final GemMenuFooterView gemMenuFooterView;
    @NonNull
    public final CoordinatorLayout htabMaincontent;
    @NonNull
    public final RecyclerView itemsRecyclerView;
    @NonNull
    public final LinearLayout linearLayoutRestaurantInfo;
    @NonNull
    public final RelativeLayout linearLayoutRestaurantWarning;
    @NonNull
    public final RelativeLayout llHeader;
    @NonNull
    public final LinearLayout menuCategories;
    @NonNull
    public final RelativeLayout menuCategoriesBottomSheet;
    @NonNull
    public final ImageView menuCategoriesIcon;
    @NonNull
    public final RecyclerView menuList;
    @NonNull
    public final MiniCartLayout miniCart;
    @NonNull
    public final FrameLayout miniCartLayout;
    @NonNull
    public final ImageView newDeliveryTimeImage;
    @NonNull
    public final RelativeLayout newDeliveryTimeView;
    @NonNull
    public final TalabatTextView newInfoText;
    @NonNull
    public final TalabatTextView newOffersContent;
    @NonNull
    public final ImageView newOffersImage;
    @NonNull
    public final TalabatTextView newOffersMore;
    @NonNull
    public final RelativeLayout newOffersView;
    @NonNull
    public final TalabatTextView newRestaurantDescription;
    @NonNull
    public final LinearLayout newRestaurantInfoSection;
    @NonNull
    public final TalabatTextView newRestaurantName;
    @NonNull
    public final TalabatTextView newRestaurantWarning;
    @NonNull
    public final TalabatTextView newReviewsContent;
    @NonNull
    public final ImageView newReviewsImage;
    @NonNull
    public final TalabatTextView newReviewsMore;
    @NonNull
    public final RelativeLayout newReviewsView;
    @NonNull
    public final TextView newStatusText;
    @NonNull
    public final RelativeLayout pagerView;
    @NonNull
    public final TalabatTextView parallelBinContent;
    @NonNull
    public final ImageView parallelBinImage;
    @NonNull
    public final ProgressBar parallelBinImageProgressBar;
    @NonNull
    public final RelativeLayout parallelBinImageView;
    @NonNull
    public final TalabatTextView parallelBinMore;
    @NonNull
    public final View parallelBinSeparator;
    @NonNull
    public final RelativeLayout parallelBinView;
    @NonNull
    public final BaseHomeHorizontalRecyclerViewLayout previousOrderView;
    @NonNull
    public final BaseRatingBar rateStars;
    @NonNull
    public final ImageView restaurantLogo;
    @NonNull
    public final RelativeLayout rlContainer;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView searchIcon;
    @NonNull
    public final RelativeLayout statusView;
    @NonNull
    public final TproSubscriptionHeaderBinding subscriptionHeader;
    @NonNull
    public final TabLayout tabLayout;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TProVendorMovView tproMov;

    private ResturantMenuScreenRBinding(@NonNull RelativeLayout relativeLayout, @NonNull AppBarLayout appBarLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView5, @NonNull RelativeLayout relativeLayout4, @NonNull GemMenuFooterView gemMenuFooterView2, @NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout5, @NonNull RelativeLayout relativeLayout6, @NonNull LinearLayout linearLayout4, @NonNull RelativeLayout relativeLayout7, @NonNull ImageView imageView6, @NonNull RecyclerView recyclerView2, @NonNull MiniCartLayout miniCartLayout2, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView7, @NonNull RelativeLayout relativeLayout8, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull ImageView imageView8, @NonNull TalabatTextView talabatTextView5, @NonNull RelativeLayout relativeLayout9, @NonNull TalabatTextView talabatTextView6, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull TalabatTextView talabatTextView9, @NonNull ImageView imageView9, @NonNull TalabatTextView talabatTextView10, @NonNull RelativeLayout relativeLayout10, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout11, @NonNull TalabatTextView talabatTextView11, @NonNull ImageView imageView10, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout12, @NonNull TalabatTextView talabatTextView12, @NonNull View view, @NonNull RelativeLayout relativeLayout13, @NonNull BaseHomeHorizontalRecyclerViewLayout baseHomeHorizontalRecyclerViewLayout, @NonNull BaseRatingBar baseRatingBar, @NonNull ImageView imageView11, @NonNull RelativeLayout relativeLayout14, @NonNull ImageView imageView12, @NonNull RelativeLayout relativeLayout15, @NonNull TproSubscriptionHeaderBinding tproSubscriptionHeaderBinding, @NonNull TabLayout tabLayout2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull Toolbar toolbar2, @NonNull TProVendorMovView tProVendorMovView) {
        this.rootView = relativeLayout;
        this.appbar = appBarLayout;
        this.back = imageView;
        this.binDiscountIcon = imageView2;
        this.binView = relativeLayout2;
        this.bottomSheetTitle = talabatTextView;
        this.closeBinView = imageView3;
        this.closeCategories = imageView4;
        this.closeCategoriesView = linearLayout;
        this.collapseToolBar = collapsingToolbarLayout;
        this.contentView = relativeLayout3;
        this.deliveryTimeText = talabatTextView2;
        this.detailBottomView = linearLayout2;
        this.extraTextWarning = imageView5;
        this.footer = relativeLayout4;
        this.gemMenuFooterView = gemMenuFooterView2;
        this.htabMaincontent = coordinatorLayout;
        this.itemsRecyclerView = recyclerView;
        this.linearLayoutRestaurantInfo = linearLayout3;
        this.linearLayoutRestaurantWarning = relativeLayout5;
        this.llHeader = relativeLayout6;
        this.menuCategories = linearLayout4;
        this.menuCategoriesBottomSheet = relativeLayout7;
        this.menuCategoriesIcon = imageView6;
        this.menuList = recyclerView2;
        this.miniCart = miniCartLayout2;
        this.miniCartLayout = frameLayout;
        this.newDeliveryTimeImage = imageView7;
        this.newDeliveryTimeView = relativeLayout8;
        this.newInfoText = talabatTextView3;
        this.newOffersContent = talabatTextView4;
        this.newOffersImage = imageView8;
        this.newOffersMore = talabatTextView5;
        this.newOffersView = relativeLayout9;
        this.newRestaurantDescription = talabatTextView6;
        this.newRestaurantInfoSection = linearLayout5;
        this.newRestaurantName = talabatTextView7;
        this.newRestaurantWarning = talabatTextView8;
        this.newReviewsContent = talabatTextView9;
        this.newReviewsImage = imageView9;
        this.newReviewsMore = talabatTextView10;
        this.newReviewsView = relativeLayout10;
        this.newStatusText = textView;
        this.pagerView = relativeLayout11;
        this.parallelBinContent = talabatTextView11;
        this.parallelBinImage = imageView10;
        this.parallelBinImageProgressBar = progressBar;
        this.parallelBinImageView = relativeLayout12;
        this.parallelBinMore = talabatTextView12;
        this.parallelBinSeparator = view;
        this.parallelBinView = relativeLayout13;
        this.previousOrderView = baseHomeHorizontalRecyclerViewLayout;
        this.rateStars = baseRatingBar;
        this.restaurantLogo = imageView11;
        this.rlContainer = relativeLayout14;
        this.searchIcon = imageView12;
        this.statusView = relativeLayout15;
        this.subscriptionHeader = tproSubscriptionHeaderBinding;
        this.tabLayout = tabLayout2;
        this.title = talabatToolBarTextView;
        this.toolbar = toolbar2;
        this.tproMov = tProVendorMovView;
    }

    @NonNull
    public static ResturantMenuScreenRBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view2, R.id.appbar);
        if (appBarLayout != null) {
            i11 = R.id.back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.back);
            if (imageView != null) {
                i11 = R.id.bin_discount_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.bin_discount_icon);
                if (imageView2 != null) {
                    i11 = R.id.bin_view;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bin_view);
                    if (relativeLayout != null) {
                        i11 = R.id.bottom_sheet_title;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.bottom_sheet_title);
                        if (talabatTextView != null) {
                            i11 = R.id.close_bin_view;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.close_bin_view);
                            if (imageView3 != null) {
                                i11 = R.id.close_categories;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.close_categories);
                                if (imageView4 != null) {
                                    i11 = R.id.close_categories_view;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.close_categories_view);
                                    if (linearLayout != null) {
                                        i11 = R.id.collapseToolBar;
                                        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(view2, R.id.collapseToolBar);
                                        if (collapsingToolbarLayout != null) {
                                            i11 = R.id.content_view;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.content_view);
                                            if (relativeLayout2 != null) {
                                                i11 = R.id.delivery_time_text;
                                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_time_text);
                                                if (talabatTextView2 != null) {
                                                    i11 = R.id.detail_bottom_view;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.detail_bottom_view);
                                                    if (linearLayout2 != null) {
                                                        i11 = R.id.extra_text_warning;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.extra_text_warning);
                                                        if (imageView5 != null) {
                                                            i11 = R.id.footer;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.footer);
                                                            if (relativeLayout3 != null) {
                                                                i11 = R.id.gemMenuFooterView;
                                                                GemMenuFooterView gemMenuFooterView2 = (GemMenuFooterView) ViewBindings.findChildViewById(view2, R.id.gemMenuFooterView);
                                                                if (gemMenuFooterView2 != null) {
                                                                    i11 = R.id.htab_maincontent;
                                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view2, R.id.htab_maincontent);
                                                                    if (coordinatorLayout != null) {
                                                                        i11 = R.id.items_recyclerView;
                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.items_recyclerView);
                                                                        if (recyclerView != null) {
                                                                            i11 = R.id.linearLayout_restaurantInfo;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_restaurantInfo);
                                                                            if (linearLayout3 != null) {
                                                                                i11 = R.id.linearLayout_restaurant_warning;
                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_restaurant_warning);
                                                                                if (relativeLayout4 != null) {
                                                                                    i11 = R.id.ll_header;
                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.ll_header);
                                                                                    if (relativeLayout5 != null) {
                                                                                        i11 = R.id.menu_categories;
                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.menu_categories);
                                                                                        if (linearLayout4 != null) {
                                                                                            i11 = R.id.menu_categories_bottom_sheet;
                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.menu_categories_bottom_sheet);
                                                                                            if (relativeLayout6 != null) {
                                                                                                i11 = R.id.menu_categories_icon;
                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.menu_categories_icon);
                                                                                                if (imageView6 != null) {
                                                                                                    i11 = R.id.menu_list;
                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.menu_list);
                                                                                                    if (recyclerView2 != null) {
                                                                                                        i11 = R.id.miniCart;
                                                                                                        MiniCartLayout miniCartLayout2 = (MiniCartLayout) ViewBindings.findChildViewById(view2, R.id.miniCart);
                                                                                                        if (miniCartLayout2 != null) {
                                                                                                            i11 = R.id.miniCartLayout;
                                                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.miniCartLayout);
                                                                                                            if (frameLayout != null) {
                                                                                                                i11 = R.id.new_delivery_time_image;
                                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.new_delivery_time_image);
                                                                                                                if (imageView7 != null) {
                                                                                                                    i11 = R.id.new_delivery_time_view;
                                                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.new_delivery_time_view);
                                                                                                                    if (relativeLayout7 != null) {
                                                                                                                        i11 = R.id.new_info_text;
                                                                                                                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.new_info_text);
                                                                                                                        if (talabatTextView3 != null) {
                                                                                                                            i11 = R.id.new_offers_content;
                                                                                                                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.new_offers_content);
                                                                                                                            if (talabatTextView4 != null) {
                                                                                                                                i11 = R.id.new_offers_image;
                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, R.id.new_offers_image);
                                                                                                                                if (imageView8 != null) {
                                                                                                                                    i11 = R.id.new_offers_more;
                                                                                                                                    TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.new_offers_more);
                                                                                                                                    if (talabatTextView5 != null) {
                                                                                                                                        i11 = R.id.new_offers_view;
                                                                                                                                        RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.new_offers_view);
                                                                                                                                        if (relativeLayout8 != null) {
                                                                                                                                            i11 = R.id.new_restaurant_description;
                                                                                                                                            TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.new_restaurant_description);
                                                                                                                                            if (talabatTextView6 != null) {
                                                                                                                                                i11 = R.id.new_restaurant_info_section;
                                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.new_restaurant_info_section);
                                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                                    i11 = R.id.new_restaurant_name;
                                                                                                                                                    TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.new_restaurant_name);
                                                                                                                                                    if (talabatTextView7 != null) {
                                                                                                                                                        i11 = R.id.new_restaurant_warning;
                                                                                                                                                        TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.new_restaurant_warning);
                                                                                                                                                        if (talabatTextView8 != null) {
                                                                                                                                                            i11 = R.id.new_reviews_content;
                                                                                                                                                            TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.new_reviews_content);
                                                                                                                                                            if (talabatTextView9 != null) {
                                                                                                                                                                i11 = R.id.new_reviews_image;
                                                                                                                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view2, R.id.new_reviews_image);
                                                                                                                                                                if (imageView9 != null) {
                                                                                                                                                                    i11 = R.id.new_reviews_more;
                                                                                                                                                                    TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.new_reviews_more);
                                                                                                                                                                    if (talabatTextView10 != null) {
                                                                                                                                                                        i11 = R.id.new_reviews_view;
                                                                                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.new_reviews_view);
                                                                                                                                                                        if (relativeLayout9 != null) {
                                                                                                                                                                            i11 = R.id.new_status_text;
                                                                                                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.new_status_text);
                                                                                                                                                                            if (textView != null) {
                                                                                                                                                                                i11 = R.id.pager_view;
                                                                                                                                                                                RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.pager_view);
                                                                                                                                                                                if (relativeLayout10 != null) {
                                                                                                                                                                                    i11 = R.id.parallel_bin_content;
                                                                                                                                                                                    TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_content);
                                                                                                                                                                                    if (talabatTextView11 != null) {
                                                                                                                                                                                        i11 = R.id.parallel_bin_image;
                                                                                                                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image);
                                                                                                                                                                                        if (imageView10 != null) {
                                                                                                                                                                                            i11 = R.id.parallel_bin_image_progressBar;
                                                                                                                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image_progressBar);
                                                                                                                                                                                            if (progressBar != null) {
                                                                                                                                                                                                i11 = R.id.parallel_bin_image_view;
                                                                                                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image_view);
                                                                                                                                                                                                if (relativeLayout11 != null) {
                                                                                                                                                                                                    i11 = R.id.parallel_bin_more;
                                                                                                                                                                                                    TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_more);
                                                                                                                                                                                                    if (talabatTextView12 != null) {
                                                                                                                                                                                                        i11 = R.id.parallel_bin_separator;
                                                                                                                                                                                                        View findChildViewById = ViewBindings.findChildViewById(view2, R.id.parallel_bin_separator);
                                                                                                                                                                                                        if (findChildViewById != null) {
                                                                                                                                                                                                            i11 = R.id.parallel_bin_view;
                                                                                                                                                                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parallel_bin_view);
                                                                                                                                                                                                            if (relativeLayout12 != null) {
                                                                                                                                                                                                                i11 = R.id.previous_order_view;
                                                                                                                                                                                                                BaseHomeHorizontalRecyclerViewLayout baseHomeHorizontalRecyclerViewLayout = (BaseHomeHorizontalRecyclerViewLayout) ViewBindings.findChildViewById(view2, R.id.previous_order_view);
                                                                                                                                                                                                                if (baseHomeHorizontalRecyclerViewLayout != null) {
                                                                                                                                                                                                                    i11 = R.id.rate_stars;
                                                                                                                                                                                                                    BaseRatingBar baseRatingBar = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.rate_stars);
                                                                                                                                                                                                                    if (baseRatingBar != null) {
                                                                                                                                                                                                                        i11 = R.id.restaurant_logo;
                                                                                                                                                                                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view2, R.id.restaurant_logo);
                                                                                                                                                                                                                        if (imageView11 != null) {
                                                                                                                                                                                                                            RelativeLayout relativeLayout13 = (RelativeLayout) view2;
                                                                                                                                                                                                                            i11 = R.id.search_icon;
                                                                                                                                                                                                                            ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view2, R.id.search_icon);
                                                                                                                                                                                                                            if (imageView12 != null) {
                                                                                                                                                                                                                                i11 = R.id.status_view;
                                                                                                                                                                                                                                RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.status_view);
                                                                                                                                                                                                                                if (relativeLayout14 != null) {
                                                                                                                                                                                                                                    i11 = R.id.subscription_header;
                                                                                                                                                                                                                                    View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.subscription_header);
                                                                                                                                                                                                                                    if (findChildViewById2 != null) {
                                                                                                                                                                                                                                        TproSubscriptionHeaderBinding bind = TproSubscriptionHeaderBinding.bind(findChildViewById2);
                                                                                                                                                                                                                                        i11 = R.id.tabLayout;
                                                                                                                                                                                                                                        TabLayout tabLayout2 = (TabLayout) ViewBindings.findChildViewById(view2, R.id.tabLayout);
                                                                                                                                                                                                                                        if (tabLayout2 != null) {
                                                                                                                                                                                                                                            i11 = R.id.title;
                                                                                                                                                                                                                                            TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                                                                                                                                            if (talabatToolBarTextView != null) {
                                                                                                                                                                                                                                                i11 = R.id.toolbar;
                                                                                                                                                                                                                                                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                                                                                                                                if (toolbar2 != null) {
                                                                                                                                                                                                                                                    i11 = R.id.tpro_mov;
                                                                                                                                                                                                                                                    TProVendorMovView tProVendorMovView = (TProVendorMovView) ViewBindings.findChildViewById(view2, R.id.tpro_mov);
                                                                                                                                                                                                                                                    if (tProVendorMovView != null) {
                                                                                                                                                                                                                                                        return new ResturantMenuScreenRBinding(relativeLayout13, appBarLayout, imageView, imageView2, relativeLayout, talabatTextView, imageView3, imageView4, linearLayout, collapsingToolbarLayout, relativeLayout2, talabatTextView2, linearLayout2, imageView5, relativeLayout3, gemMenuFooterView2, coordinatorLayout, recyclerView, linearLayout3, relativeLayout4, relativeLayout5, linearLayout4, relativeLayout6, imageView6, recyclerView2, miniCartLayout2, frameLayout, imageView7, relativeLayout7, talabatTextView3, talabatTextView4, imageView8, talabatTextView5, relativeLayout8, talabatTextView6, linearLayout5, talabatTextView7, talabatTextView8, talabatTextView9, imageView9, talabatTextView10, relativeLayout9, textView, relativeLayout10, talabatTextView11, imageView10, progressBar, relativeLayout11, talabatTextView12, findChildViewById, relativeLayout12, baseHomeHorizontalRecyclerViewLayout, baseRatingBar, imageView11, relativeLayout13, imageView12, relativeLayout14, bind, tabLayout2, talabatToolBarTextView, toolbar2, tProVendorMovView);
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ResturantMenuScreenRBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ResturantMenuScreenRBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.resturant_menu_screen_r, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
