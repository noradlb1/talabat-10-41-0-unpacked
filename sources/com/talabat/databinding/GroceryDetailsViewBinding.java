package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.MiniCartLayout;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class GroceryDetailsViewBinding implements ViewBinding {
    @NonNull
    public final AppBarLayout appbar;
    @NonNull
    public final TalabatFillButton apply;
    @NonNull
    public final RelativeLayout back;
    @NonNull
    public final RelativeLayout brandSection;
    @NonNull
    public final TalabatTextView brandTitle;
    @NonNull
    public final ImageView brandsExpand;
    @NonNull
    public final RecyclerView brandsRecyclerView;
    @NonNull
    public final LinearLayout buttonSection;
    @NonNull
    public final TalabatTextView categoryCount;
    @NonNull
    public final TalabatTextView categoryName;
    @NonNull
    public final ImageView clearText;
    @NonNull
    public final ImageView closeCategories;
    @NonNull
    public final LinearLayout closeCategoriesView;
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final RelativeLayout filterHeaderSection;
    @NonNull
    public final TalabatTextView filterTitle;
    @NonNull
    public final TalabatTextView firstSentence;
    @NonNull
    public final RelativeLayout footer;
    @NonNull
    public final RelativeLayout gemHolderView;
    @NonNull
    public final RelativeLayout headerSection;
    @NonNull
    public final ImageView ivNoItems;
    @NonNull
    public final ImageView ivSearch;
    @NonNull
    public final ProgressBar linearProgressBar;
    @NonNull
    public final CoordinatorLayout mainContent;
    @NonNull
    public final RecyclerView menuItemsRecycler;
    @NonNull
    public final MiniCartLayout miniCart;
    @NonNull
    public final GrocerySortListItemBinding nameAZ;
    @NonNull
    public final RelativeLayout nameSection;
    @NonNull
    public final GrocerySortListItemBinding nameZA;
    @NonNull
    public final LinearLayout noItemsView;
    @NonNull
    public final GrocerySortListItemBinding priceHighToLow;
    @NonNull
    public final GrocerySortListItemBinding priceLowToHigh;
    @NonNull
    public final GrocerySortListItemBinding relevance;
    @NonNull
    public final TalabatStrokeButton reset;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final MaterialEditText searchField;
    @NonNull
    public final RelativeLayout searchSection;
    @NonNull
    public final TalabatTextView secondSentence;
    @NonNull
    public final View seperator;
    @NonNull
    public final RelativeLayout sortBottomSheet;
    @NonNull
    public final RelativeLayout sortHeaderSection;
    @NonNull
    public final ImageView sortIcon;
    @NonNull
    public final Button sortIconPadding;
    @NonNull
    public final FrameLayout sortIconWithBubble;
    @NonNull
    public final ImageView sortSectionExpand;
    @NonNull
    public final LinearLayout sortSections;
    @NonNull
    public final ImageView sortSelected;
    @NonNull
    public final TalabatTextView sortTitle;
    @NonNull
    public final RecyclerView tagsRecyclerview;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final RelativeLayout viewSearchContainer;

    private GroceryDetailsViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull AppBarLayout appBarLayout, @NonNull TalabatFillButton talabatFillButton, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull RelativeLayout relativeLayout6, @NonNull RelativeLayout relativeLayout7, @NonNull RelativeLayout relativeLayout8, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ProgressBar progressBar, @NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView2, @NonNull MiniCartLayout miniCartLayout, @NonNull GrocerySortListItemBinding grocerySortListItemBinding, @NonNull RelativeLayout relativeLayout9, @NonNull GrocerySortListItemBinding grocerySortListItemBinding2, @NonNull LinearLayout linearLayout3, @NonNull GrocerySortListItemBinding grocerySortListItemBinding3, @NonNull GrocerySortListItemBinding grocerySortListItemBinding4, @NonNull GrocerySortListItemBinding grocerySortListItemBinding5, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull MaterialEditText materialEditText, @NonNull RelativeLayout relativeLayout10, @NonNull TalabatTextView talabatTextView6, @NonNull View view, @NonNull RelativeLayout relativeLayout11, @NonNull RelativeLayout relativeLayout12, @NonNull ImageView imageView6, @NonNull Button button, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView7, @NonNull LinearLayout linearLayout4, @NonNull ImageView imageView8, @NonNull TalabatTextView talabatTextView7, @NonNull RecyclerView recyclerView3, @NonNull Toolbar toolbar2, @NonNull RelativeLayout relativeLayout13) {
        this.rootView = relativeLayout;
        this.appbar = appBarLayout;
        this.apply = talabatFillButton;
        this.back = relativeLayout2;
        this.brandSection = relativeLayout3;
        this.brandTitle = talabatTextView;
        this.brandsExpand = imageView;
        this.brandsRecyclerView = recyclerView;
        this.buttonSection = linearLayout;
        this.categoryCount = talabatTextView2;
        this.categoryName = talabatTextView3;
        this.clearText = imageView2;
        this.closeCategories = imageView3;
        this.closeCategoriesView = linearLayout2;
        this.contentView = relativeLayout4;
        this.filterHeaderSection = relativeLayout5;
        this.filterTitle = talabatTextView4;
        this.firstSentence = talabatTextView5;
        this.footer = relativeLayout6;
        this.gemHolderView = relativeLayout7;
        this.headerSection = relativeLayout8;
        this.ivNoItems = imageView4;
        this.ivSearch = imageView5;
        this.linearProgressBar = progressBar;
        this.mainContent = coordinatorLayout;
        this.menuItemsRecycler = recyclerView2;
        this.miniCart = miniCartLayout;
        this.nameAZ = grocerySortListItemBinding;
        this.nameSection = relativeLayout9;
        this.nameZA = grocerySortListItemBinding2;
        this.noItemsView = linearLayout3;
        this.priceHighToLow = grocerySortListItemBinding3;
        this.priceLowToHigh = grocerySortListItemBinding4;
        this.relevance = grocerySortListItemBinding5;
        this.reset = talabatStrokeButton;
        this.searchField = materialEditText;
        this.searchSection = relativeLayout10;
        this.secondSentence = talabatTextView6;
        this.seperator = view;
        this.sortBottomSheet = relativeLayout11;
        this.sortHeaderSection = relativeLayout12;
        this.sortIcon = imageView6;
        this.sortIconPadding = button;
        this.sortIconWithBubble = frameLayout;
        this.sortSectionExpand = imageView7;
        this.sortSections = linearLayout4;
        this.sortSelected = imageView8;
        this.sortTitle = talabatTextView7;
        this.tagsRecyclerview = recyclerView3;
        this.toolbar = toolbar2;
        this.viewSearchContainer = relativeLayout13;
    }

    @NonNull
    public static GroceryDetailsViewBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.appbar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view2, R.id.appbar);
        if (appBarLayout != null) {
            i11 = R.id.apply;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.apply);
            if (talabatFillButton != null) {
                i11 = R.id.back;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.back);
                if (relativeLayout != null) {
                    i11 = R.id.brand_section;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.brand_section);
                    if (relativeLayout2 != null) {
                        i11 = R.id.brand_title;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.brand_title);
                        if (talabatTextView != null) {
                            i11 = R.id.brands_expand;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.brands_expand);
                            if (imageView != null) {
                                i11 = R.id.brands_recyclerView;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.brands_recyclerView);
                                if (recyclerView != null) {
                                    i11 = R.id.button_section;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.button_section);
                                    if (linearLayout != null) {
                                        i11 = R.id.category_count;
                                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.category_count);
                                        if (talabatTextView2 != null) {
                                            i11 = R.id.category_name;
                                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.category_name);
                                            if (talabatTextView3 != null) {
                                                i11 = R.id.clear_text;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.clear_text);
                                                if (imageView2 != null) {
                                                    i11 = R.id.close_categories;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.close_categories);
                                                    if (imageView3 != null) {
                                                        i11 = R.id.close_categories_view;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.close_categories_view);
                                                        if (linearLayout2 != null) {
                                                            i11 = R.id.content_view;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.content_view);
                                                            if (relativeLayout3 != null) {
                                                                i11 = R.id.filter_header_section;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.filter_header_section);
                                                                if (relativeLayout4 != null) {
                                                                    i11 = R.id.filter_title;
                                                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.filter_title);
                                                                    if (talabatTextView4 != null) {
                                                                        i11 = R.id.first_sentence;
                                                                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.first_sentence);
                                                                        if (talabatTextView5 != null) {
                                                                            i11 = R.id.footer;
                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.footer);
                                                                            if (relativeLayout5 != null) {
                                                                                i11 = R.id.gem_holder_view;
                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_holder_view);
                                                                                if (relativeLayout6 != null) {
                                                                                    i11 = R.id.header_section;
                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.header_section);
                                                                                    if (relativeLayout7 != null) {
                                                                                        i11 = R.id.iv_no_items;
                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_no_items);
                                                                                        if (imageView4 != null) {
                                                                                            i11 = R.id.iv_search;
                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_search);
                                                                                            if (imageView5 != null) {
                                                                                                i11 = R.id.linear_progressBar;
                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.linear_progressBar);
                                                                                                if (progressBar != null) {
                                                                                                    i11 = R.id.main_content;
                                                                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view2, R.id.main_content);
                                                                                                    if (coordinatorLayout != null) {
                                                                                                        i11 = R.id.menu_items_recycler;
                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.menu_items_recycler);
                                                                                                        if (recyclerView2 != null) {
                                                                                                            i11 = R.id.miniCart;
                                                                                                            MiniCartLayout miniCartLayout = (MiniCartLayout) ViewBindings.findChildViewById(view2, R.id.miniCart);
                                                                                                            if (miniCartLayout != null) {
                                                                                                                i11 = R.id.name_a_z;
                                                                                                                View findChildViewById = ViewBindings.findChildViewById(view2, R.id.name_a_z);
                                                                                                                if (findChildViewById != null) {
                                                                                                                    GrocerySortListItemBinding bind = GrocerySortListItemBinding.bind(findChildViewById);
                                                                                                                    i11 = R.id.name_section;
                                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.name_section);
                                                                                                                    if (relativeLayout8 != null) {
                                                                                                                        i11 = R.id.name_z_a;
                                                                                                                        View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.name_z_a);
                                                                                                                        if (findChildViewById2 != null) {
                                                                                                                            GrocerySortListItemBinding bind2 = GrocerySortListItemBinding.bind(findChildViewById2);
                                                                                                                            i11 = R.id.no_items_view;
                                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.no_items_view);
                                                                                                                            if (linearLayout3 != null) {
                                                                                                                                i11 = R.id.price_high_to_low;
                                                                                                                                View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.price_high_to_low);
                                                                                                                                if (findChildViewById3 != null) {
                                                                                                                                    GrocerySortListItemBinding bind3 = GrocerySortListItemBinding.bind(findChildViewById3);
                                                                                                                                    i11 = R.id.price_low_to_high;
                                                                                                                                    View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.price_low_to_high);
                                                                                                                                    if (findChildViewById4 != null) {
                                                                                                                                        GrocerySortListItemBinding bind4 = GrocerySortListItemBinding.bind(findChildViewById4);
                                                                                                                                        i11 = R.id.relevance;
                                                                                                                                        View findChildViewById5 = ViewBindings.findChildViewById(view2, R.id.relevance);
                                                                                                                                        if (findChildViewById5 != null) {
                                                                                                                                            GrocerySortListItemBinding bind5 = GrocerySortListItemBinding.bind(findChildViewById5);
                                                                                                                                            i11 = R.id.reset;
                                                                                                                                            TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, R.id.reset);
                                                                                                                                            if (talabatStrokeButton != null) {
                                                                                                                                                i11 = R.id.search_field;
                                                                                                                                                MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.search_field);
                                                                                                                                                if (materialEditText != null) {
                                                                                                                                                    i11 = R.id.search_section;
                                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.search_section);
                                                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                                                        i11 = R.id.second_sentence;
                                                                                                                                                        TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.second_sentence);
                                                                                                                                                        if (talabatTextView6 != null) {
                                                                                                                                                            i11 = R.id.seperator;
                                                                                                                                                            View findChildViewById6 = ViewBindings.findChildViewById(view2, R.id.seperator);
                                                                                                                                                            if (findChildViewById6 != null) {
                                                                                                                                                                i11 = R.id.sort_bottom_sheet;
                                                                                                                                                                RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.sort_bottom_sheet);
                                                                                                                                                                if (relativeLayout10 != null) {
                                                                                                                                                                    i11 = R.id.sort_header_section;
                                                                                                                                                                    RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.sort_header_section);
                                                                                                                                                                    if (relativeLayout11 != null) {
                                                                                                                                                                        i11 = R.id.sort_icon;
                                                                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.sort_icon);
                                                                                                                                                                        if (imageView6 != null) {
                                                                                                                                                                            i11 = R.id.sort_icon_padding;
                                                                                                                                                                            Button button = (Button) ViewBindings.findChildViewById(view2, R.id.sort_icon_padding);
                                                                                                                                                                            if (button != null) {
                                                                                                                                                                                i11 = R.id.sort_icon_with_bubble;
                                                                                                                                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.sort_icon_with_bubble);
                                                                                                                                                                                if (frameLayout != null) {
                                                                                                                                                                                    i11 = R.id.sort_section_expand;
                                                                                                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.sort_section_expand);
                                                                                                                                                                                    if (imageView7 != null) {
                                                                                                                                                                                        i11 = R.id.sort_sections;
                                                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.sort_sections);
                                                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                                                            i11 = R.id.sort_selected;
                                                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, R.id.sort_selected);
                                                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                                                i11 = R.id.sort_title;
                                                                                                                                                                                                TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.sort_title);
                                                                                                                                                                                                if (talabatTextView7 != null) {
                                                                                                                                                                                                    i11 = R.id.tags_recyclerview;
                                                                                                                                                                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.tags_recyclerview);
                                                                                                                                                                                                    if (recyclerView3 != null) {
                                                                                                                                                                                                        i11 = R.id.toolbar;
                                                                                                                                                                                                        Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                                                                                        if (toolbar2 != null) {
                                                                                                                                                                                                            i11 = R.id.view_search_container;
                                                                                                                                                                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.view_search_container);
                                                                                                                                                                                                            if (relativeLayout12 != null) {
                                                                                                                                                                                                                return new GroceryDetailsViewBinding((RelativeLayout) view2, appBarLayout, talabatFillButton, relativeLayout, relativeLayout2, talabatTextView, imageView, recyclerView, linearLayout, talabatTextView2, talabatTextView3, imageView2, imageView3, linearLayout2, relativeLayout3, relativeLayout4, talabatTextView4, talabatTextView5, relativeLayout5, relativeLayout6, relativeLayout7, imageView4, imageView5, progressBar, coordinatorLayout, recyclerView2, miniCartLayout, bind, relativeLayout8, bind2, linearLayout3, bind3, bind4, bind5, talabatStrokeButton, materialEditText, relativeLayout9, talabatTextView6, findChildViewById6, relativeLayout10, relativeLayout11, imageView6, button, frameLayout, imageView7, linearLayout4, imageView8, talabatTextView7, recyclerView3, toolbar2, relativeLayout12);
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
    public static GroceryDetailsViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GroceryDetailsViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.grocery_details_view, viewGroup, false);
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
