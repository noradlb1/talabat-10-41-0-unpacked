package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class BusyPopupBottomsheetBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout busyPopupBottomSheet;
    @NonNull
    public final LinearLayout buttonView;
    @NonNull
    public final LinearLayout errorNotification;
    @NonNull
    public final LinearLayout listContainer;
    @NonNull
    public final TextView mainContent;
    @NonNull
    public final LinearLayout noRestaurantsView;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final RelativeLayout progressBarView;
    @NonNull
    public final RecyclerView restaurantList;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView secondaryContent;
    @NonNull
    public final TalabatFillButton viewAllRestaurants;

    private BusyPopupBottomsheetBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull LinearLayout linearLayout4, @NonNull ProgressBar progressBar2, @NonNull RelativeLayout relativeLayout3, @NonNull RecyclerView recyclerView, @NonNull TextView textView2, @NonNull TalabatFillButton talabatFillButton) {
        this.rootView = relativeLayout;
        this.busyPopupBottomSheet = relativeLayout2;
        this.buttonView = linearLayout;
        this.errorNotification = linearLayout2;
        this.listContainer = linearLayout3;
        this.mainContent = textView;
        this.noRestaurantsView = linearLayout4;
        this.progressBar = progressBar2;
        this.progressBarView = relativeLayout3;
        this.restaurantList = recyclerView;
        this.secondaryContent = textView2;
        this.viewAllRestaurants = talabatFillButton;
    }

    @NonNull
    public static BusyPopupBottomsheetBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i11 = R.id.button_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_view);
        if (linearLayout != null) {
            i11 = R.id.error_notification;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.error_notification);
            if (linearLayout2 != null) {
                i11 = R.id.list_container;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.list_container);
                if (linearLayout3 != null) {
                    i11 = R.id.main_content;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.main_content);
                    if (textView != null) {
                        i11 = R.id.no_restaurants_view;
                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.no_restaurants_view);
                        if (linearLayout4 != null) {
                            i11 = R.id.progress_bar;
                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_bar);
                            if (progressBar2 != null) {
                                i11 = R.id.progress_bar_view;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.progress_bar_view);
                                if (relativeLayout2 != null) {
                                    i11 = R.id.restaurant_list;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.restaurant_list);
                                    if (recyclerView != null) {
                                        i11 = R.id.secondary_content;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.secondary_content);
                                        if (textView2 != null) {
                                            i11 = R.id.view_all_restaurants;
                                            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.view_all_restaurants);
                                            if (talabatFillButton != null) {
                                                return new BusyPopupBottomsheetBinding(relativeLayout, relativeLayout, linearLayout, linearLayout2, linearLayout3, textView, linearLayout4, progressBar2, relativeLayout2, recyclerView, textView2, talabatFillButton);
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
    public static BusyPopupBottomsheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BusyPopupBottomsheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.busy_popup_bottomsheet, viewGroup, false);
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
