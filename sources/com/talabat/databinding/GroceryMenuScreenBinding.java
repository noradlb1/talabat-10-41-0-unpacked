package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
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
import com.talabat.helpers.MiniCartLayout;

public final class GroceryMenuScreenBinding implements ViewBinding {
    @NonNull
    public final ImageView amexImg;
    @NonNull
    public final AppBarLayout appbar;
    @NonNull
    public final TalabatTextView bottomSheetTitle;
    @NonNull
    public final ImageView btnMInfo;
    @NonNull
    public final ImageView cashImg;
    @NonNull
    public final ImageView closeCategories;
    @NonNull
    public final LinearLayout closeCategoriesView;
    @NonNull
    public final CollapsingToolbarLayout collapseToolBar;
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final TalabatTextView deliveryTime;
    @NonNull
    public final ImageView disclaimerArrow;
    @NonNull
    public final TalabatTextView edSearch;
    @NonNull
    public final RelativeLayout footer;
    @NonNull
    public final RelativeLayout gemHolderView;
    @NonNull
    public final FrameLayout groceryHeader;
    @NonNull
    public final TalabatTextView groceryName;
    @NonNull
    public final RelativeLayout grocerySearchContainer;
    @NonNull
    public final TalabatTextView groceryStatus;
    @NonNull
    public final ImageView hiddenSearchImage;
    @NonNull
    public final CoordinatorLayout htabMaincontent;
    @NonNull
    public final ImageView image;
    @NonNull
    public final RecyclerView itemsRecyclerView;
    @NonNull
    public final ImageView ivSearch;
    @NonNull
    public final ImageView knetImg;
    @NonNull
    public final LinearLayout linearLayoutHeaderCenterData;
    @NonNull
    public final LinearLayout linearLayoutRestaurantInfo;
    @NonNull
    public final LinearLayout llHeader;
    @NonNull
    public final LinearLayout llMoreInfo;
    @NonNull
    public final ImageView masterCardImg;
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
    public final TalabatTextView newGroceryOffersMore;
    @NonNull
    public final ImageView offersIcon;
    @NonNull
    public final RelativeLayout offersView;
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
    public final RelativeLayout parallelBinView;
    @NonNull
    public final LinearLayout paymentSection;
    @NonNull
    public final ImageView percentageImage;
    @NonNull
    public final ImageView restaurantLogo;
    @NonNull
    public final TalabatTextView restaurantName;
    @NonNull
    public final TalabatTextView restaurantOffersCount;
    @NonNull
    public final RelativeLayout rlContainer;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout searchBar;
    @NonNull
    public final TproSubscriptionHeaderBinding subscriptionHeader;
    @NonNull
    public final TabLayout tabLayout;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final LinearLayout titleStatus;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final RelativeLayout toolbarView;
    @NonNull
    public final TProVendorMovView tproMov;
    @NonNull
    public final TalabatTextView tvRestaurantWarning;
    @NonNull
    public final TalabatTextView tvToGo;
    @NonNull
    public final ImageView visaImg;

    private GroceryMenuScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull AppBarLayout appBarLayout, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView5, @NonNull TalabatTextView talabatTextView3, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull FrameLayout frameLayout, @NonNull TalabatTextView talabatTextView4, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatTextView talabatTextView5, @NonNull ImageView imageView6, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView7, @NonNull RecyclerView recyclerView, @NonNull ImageView imageView8, @NonNull ImageView imageView9, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull ImageView imageView10, @NonNull LinearLayout linearLayout6, @NonNull RelativeLayout relativeLayout6, @NonNull ImageView imageView11, @NonNull RecyclerView recyclerView2, @NonNull MiniCartLayout miniCartLayout, @NonNull TalabatTextView talabatTextView6, @NonNull ImageView imageView12, @NonNull RelativeLayout relativeLayout7, @NonNull RelativeLayout relativeLayout8, @NonNull TalabatTextView talabatTextView7, @NonNull ImageView imageView13, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout9, @NonNull TalabatTextView talabatTextView8, @NonNull RelativeLayout relativeLayout10, @NonNull LinearLayout linearLayout7, @NonNull ImageView imageView14, @NonNull ImageView imageView15, @NonNull TalabatTextView talabatTextView9, @NonNull TalabatTextView talabatTextView10, @NonNull RelativeLayout relativeLayout11, @NonNull RelativeLayout relativeLayout12, @NonNull TproSubscriptionHeaderBinding tproSubscriptionHeaderBinding, @NonNull TabLayout tabLayout2, @NonNull TalabatTextView talabatTextView11, @NonNull LinearLayout linearLayout8, @NonNull Toolbar toolbar2, @NonNull RelativeLayout relativeLayout13, @NonNull TProVendorMovView tProVendorMovView, @NonNull TalabatTextView talabatTextView12, @NonNull TalabatTextView talabatTextView13, @NonNull ImageView imageView16) {
        this.rootView = relativeLayout;
        this.amexImg = imageView;
        this.appbar = appBarLayout;
        this.bottomSheetTitle = talabatTextView;
        this.btnMInfo = imageView2;
        this.cashImg = imageView3;
        this.closeCategories = imageView4;
        this.closeCategoriesView = linearLayout;
        this.collapseToolBar = collapsingToolbarLayout;
        this.contentView = relativeLayout2;
        this.deliveryTime = talabatTextView2;
        this.disclaimerArrow = imageView5;
        this.edSearch = talabatTextView3;
        this.footer = relativeLayout3;
        this.gemHolderView = relativeLayout4;
        this.groceryHeader = frameLayout;
        this.groceryName = talabatTextView4;
        this.grocerySearchContainer = relativeLayout5;
        this.groceryStatus = talabatTextView5;
        this.hiddenSearchImage = imageView6;
        this.htabMaincontent = coordinatorLayout;
        this.image = imageView7;
        this.itemsRecyclerView = recyclerView;
        this.ivSearch = imageView8;
        this.knetImg = imageView9;
        this.linearLayoutHeaderCenterData = linearLayout2;
        this.linearLayoutRestaurantInfo = linearLayout3;
        this.llHeader = linearLayout4;
        this.llMoreInfo = linearLayout5;
        this.masterCardImg = imageView10;
        this.menuCategories = linearLayout6;
        this.menuCategoriesBottomSheet = relativeLayout6;
        this.menuCategoriesIcon = imageView11;
        this.menuList = recyclerView2;
        this.miniCart = miniCartLayout;
        this.newGroceryOffersMore = talabatTextView6;
        this.offersIcon = imageView12;
        this.offersView = relativeLayout7;
        this.pagerView = relativeLayout8;
        this.parallelBinContent = talabatTextView7;
        this.parallelBinImage = imageView13;
        this.parallelBinImageProgressBar = progressBar;
        this.parallelBinImageView = relativeLayout9;
        this.parallelBinMore = talabatTextView8;
        this.parallelBinView = relativeLayout10;
        this.paymentSection = linearLayout7;
        this.percentageImage = imageView14;
        this.restaurantLogo = imageView15;
        this.restaurantName = talabatTextView9;
        this.restaurantOffersCount = talabatTextView10;
        this.rlContainer = relativeLayout11;
        this.searchBar = relativeLayout12;
        this.subscriptionHeader = tproSubscriptionHeaderBinding;
        this.tabLayout = tabLayout2;
        this.title = talabatTextView11;
        this.titleStatus = linearLayout8;
        this.toolbar = toolbar2;
        this.toolbarView = relativeLayout13;
        this.tproMov = tProVendorMovView;
        this.tvRestaurantWarning = talabatTextView12;
        this.tvToGo = talabatTextView13;
        this.visaImg = imageView16;
    }

    @NonNull
    public static GroceryMenuScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.amexImg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.amexImg);
        if (imageView != null) {
            i11 = R.id.appbar;
            AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view2, R.id.appbar);
            if (appBarLayout != null) {
                i11 = R.id.bottom_sheet_title;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.bottom_sheet_title);
                if (talabatTextView != null) {
                    i11 = R.id.btn_m_info;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.btn_m_info);
                    if (imageView2 != null) {
                        i11 = R.id.cashImg;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.cashImg);
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
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.content_view);
                                        if (relativeLayout != null) {
                                            i11 = R.id.delivery_time;
                                            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.delivery_time);
                                            if (talabatTextView2 != null) {
                                                i11 = R.id.disclaimer_arrow;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.disclaimer_arrow);
                                                if (imageView5 != null) {
                                                    i11 = R.id.ed_search;
                                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.ed_search);
                                                    if (talabatTextView3 != null) {
                                                        i11 = R.id.footer;
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.footer);
                                                        if (relativeLayout2 != null) {
                                                            i11 = R.id.gem_holder_view;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_holder_view);
                                                            if (relativeLayout3 != null) {
                                                                i11 = R.id.grocery_header;
                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.grocery_header);
                                                                if (frameLayout != null) {
                                                                    i11 = R.id.grocery_name;
                                                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.grocery_name);
                                                                    if (talabatTextView4 != null) {
                                                                        i11 = R.id.grocery_search_container;
                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.grocery_search_container);
                                                                        if (relativeLayout4 != null) {
                                                                            i11 = R.id.grocery_status;
                                                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.grocery_status);
                                                                            if (talabatTextView5 != null) {
                                                                                i11 = R.id.hidden_search_image;
                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.hidden_search_image);
                                                                                if (imageView6 != null) {
                                                                                    i11 = R.id.htab_maincontent;
                                                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view2, R.id.htab_maincontent);
                                                                                    if (coordinatorLayout != null) {
                                                                                        i11 = R.id.image;
                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.image);
                                                                                        if (imageView7 != null) {
                                                                                            i11 = R.id.items_recyclerView;
                                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.items_recyclerView);
                                                                                            if (recyclerView != null) {
                                                                                                i11 = R.id.iv_search;
                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_search);
                                                                                                if (imageView8 != null) {
                                                                                                    i11 = R.id.knetImg;
                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view2, R.id.knetImg);
                                                                                                    if (imageView9 != null) {
                                                                                                        i11 = R.id.linearLayout_headerCenterData;
                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_headerCenterData);
                                                                                                        if (linearLayout2 != null) {
                                                                                                            i11 = R.id.linearLayout_restaurantInfo;
                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_restaurantInfo);
                                                                                                            if (linearLayout3 != null) {
                                                                                                                i11 = R.id.ll_header;
                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_header);
                                                                                                                if (linearLayout4 != null) {
                                                                                                                    i11 = R.id.ll_more_info;
                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_more_info);
                                                                                                                    if (linearLayout5 != null) {
                                                                                                                        i11 = R.id.masterCardImg;
                                                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view2, R.id.masterCardImg);
                                                                                                                        if (imageView10 != null) {
                                                                                                                            i11 = R.id.menu_categories;
                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.menu_categories);
                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                i11 = R.id.menu_categories_bottom_sheet;
                                                                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.menu_categories_bottom_sheet);
                                                                                                                                if (relativeLayout5 != null) {
                                                                                                                                    i11 = R.id.menu_categories_icon;
                                                                                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view2, R.id.menu_categories_icon);
                                                                                                                                    if (imageView11 != null) {
                                                                                                                                        i11 = R.id.menu_list;
                                                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.menu_list);
                                                                                                                                        if (recyclerView2 != null) {
                                                                                                                                            i11 = R.id.miniCart;
                                                                                                                                            MiniCartLayout miniCartLayout = (MiniCartLayout) ViewBindings.findChildViewById(view2, R.id.miniCart);
                                                                                                                                            if (miniCartLayout != null) {
                                                                                                                                                i11 = R.id.new_grocery_offers_more;
                                                                                                                                                TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.new_grocery_offers_more);
                                                                                                                                                if (talabatTextView6 != null) {
                                                                                                                                                    i11 = R.id.offers_icon;
                                                                                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view2, R.id.offers_icon);
                                                                                                                                                    if (imageView12 != null) {
                                                                                                                                                        i11 = R.id.offers_view;
                                                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.offers_view);
                                                                                                                                                        if (relativeLayout6 != null) {
                                                                                                                                                            i11 = R.id.pager_view;
                                                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.pager_view);
                                                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                                                i11 = R.id.parallel_bin_content;
                                                                                                                                                                TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_content);
                                                                                                                                                                if (talabatTextView7 != null) {
                                                                                                                                                                    i11 = R.id.parallel_bin_image;
                                                                                                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image);
                                                                                                                                                                    if (imageView13 != null) {
                                                                                                                                                                        i11 = R.id.parallel_bin_image_progressBar;
                                                                                                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image_progressBar);
                                                                                                                                                                        if (progressBar != null) {
                                                                                                                                                                            i11 = R.id.parallel_bin_image_view;
                                                                                                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parallel_bin_image_view);
                                                                                                                                                                            if (relativeLayout8 != null) {
                                                                                                                                                                                i11 = R.id.parallel_bin_more;
                                                                                                                                                                                TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.parallel_bin_more);
                                                                                                                                                                                if (talabatTextView8 != null) {
                                                                                                                                                                                    i11 = R.id.parallel_bin_view;
                                                                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.parallel_bin_view);
                                                                                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                                                                                        i11 = R.id.payment_section;
                                                                                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.payment_section);
                                                                                                                                                                                        if (linearLayout7 != null) {
                                                                                                                                                                                            i11 = R.id.percentage_image;
                                                                                                                                                                                            ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view2, R.id.percentage_image);
                                                                                                                                                                                            if (imageView14 != null) {
                                                                                                                                                                                                i11 = R.id.restaurant_logo;
                                                                                                                                                                                                ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(view2, R.id.restaurant_logo);
                                                                                                                                                                                                if (imageView15 != null) {
                                                                                                                                                                                                    i11 = R.id.restaurant_name;
                                                                                                                                                                                                    TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.restaurant_name);
                                                                                                                                                                                                    if (talabatTextView9 != null) {
                                                                                                                                                                                                        i11 = R.id.restaurant_offers_count;
                                                                                                                                                                                                        TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.restaurant_offers_count);
                                                                                                                                                                                                        if (talabatTextView10 != null) {
                                                                                                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) view2;
                                                                                                                                                                                                            i11 = R.id.search_bar;
                                                                                                                                                                                                            RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.search_bar);
                                                                                                                                                                                                            if (relativeLayout11 != null) {
                                                                                                                                                                                                                i11 = R.id.subscription_header;
                                                                                                                                                                                                                View findChildViewById = ViewBindings.findChildViewById(view2, R.id.subscription_header);
                                                                                                                                                                                                                if (findChildViewById != null) {
                                                                                                                                                                                                                    TproSubscriptionHeaderBinding bind = TproSubscriptionHeaderBinding.bind(findChildViewById);
                                                                                                                                                                                                                    i11 = R.id.tabLayout;
                                                                                                                                                                                                                    TabLayout tabLayout2 = (TabLayout) ViewBindings.findChildViewById(view2, R.id.tabLayout);
                                                                                                                                                                                                                    if (tabLayout2 != null) {
                                                                                                                                                                                                                        i11 = R.id.title;
                                                                                                                                                                                                                        TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                                                                                                                        if (talabatTextView11 != null) {
                                                                                                                                                                                                                            i11 = R.id.title_status;
                                                                                                                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.title_status);
                                                                                                                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                                                                                                                i11 = R.id.toolbar;
                                                                                                                                                                                                                                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                                                                                                                if (toolbar2 != null) {
                                                                                                                                                                                                                                    i11 = R.id.toolbar_view;
                                                                                                                                                                                                                                    RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.toolbar_view);
                                                                                                                                                                                                                                    if (relativeLayout12 != null) {
                                                                                                                                                                                                                                        i11 = R.id.tpro_mov;
                                                                                                                                                                                                                                        TProVendorMovView tProVendorMovView = (TProVendorMovView) ViewBindings.findChildViewById(view2, R.id.tpro_mov);
                                                                                                                                                                                                                                        if (tProVendorMovView != null) {
                                                                                                                                                                                                                                            i11 = R.id.tv_restaurant_warning;
                                                                                                                                                                                                                                            TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_restaurant_warning);
                                                                                                                                                                                                                                            if (talabatTextView12 != null) {
                                                                                                                                                                                                                                                i11 = R.id.tv_to_go;
                                                                                                                                                                                                                                                TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_to_go);
                                                                                                                                                                                                                                                if (talabatTextView13 != null) {
                                                                                                                                                                                                                                                    i11 = R.id.visaImg;
                                                                                                                                                                                                                                                    ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(view2, R.id.visaImg);
                                                                                                                                                                                                                                                    if (imageView16 != null) {
                                                                                                                                                                                                                                                        return new GroceryMenuScreenBinding(relativeLayout10, imageView, appBarLayout, talabatTextView, imageView2, imageView3, imageView4, linearLayout, collapsingToolbarLayout, relativeLayout, talabatTextView2, imageView5, talabatTextView3, relativeLayout2, relativeLayout3, frameLayout, talabatTextView4, relativeLayout4, talabatTextView5, imageView6, coordinatorLayout, imageView7, recyclerView, imageView8, imageView9, linearLayout2, linearLayout3, linearLayout4, linearLayout5, imageView10, linearLayout6, relativeLayout5, imageView11, recyclerView2, miniCartLayout, talabatTextView6, imageView12, relativeLayout6, relativeLayout7, talabatTextView7, imageView13, progressBar, relativeLayout8, talabatTextView8, relativeLayout9, linearLayout7, imageView14, imageView15, talabatTextView9, talabatTextView10, relativeLayout10, relativeLayout11, bind, tabLayout2, talabatTextView11, linearLayout8, toolbar2, relativeLayout12, tProVendorMovView, talabatTextView12, talabatTextView13, imageView16);
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
    public static GroceryMenuScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GroceryMenuScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.grocery_menu_screen, viewGroup, false);
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
