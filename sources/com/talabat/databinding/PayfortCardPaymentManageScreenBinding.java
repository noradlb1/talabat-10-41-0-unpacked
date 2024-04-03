package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class PayfortCardPaymentManageScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final RelativeLayout cardAvailableView;
    @NonNull
    public final RecyclerView cardList;
    @NonNull
    public final TalabatToolBarButton deleteAllCard;
    @NonNull
    public final TalabatFillButton noCardAddCard;
    @NonNull
    public final ImageButton noCardImg;
    @NonNull
    public final LinearLayout noCardView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private PayfortCardPaymentManageScreenBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull TalabatFillButton talabatFillButton, @NonNull ImageButton imageButton, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = linearLayout;
        this.back = talabatToolBarImageButton;
        this.cardAvailableView = relativeLayout;
        this.cardList = recyclerView;
        this.deleteAllCard = talabatToolBarButton;
        this.noCardAddCard = talabatFillButton;
        this.noCardImg = imageButton;
        this.noCardView = linearLayout2;
        this.talabatToolbar = relativeLayout2;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static PayfortCardPaymentManageScreenBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.card_available_view;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.card_available_view);
            if (relativeLayout != null) {
                i11 = R.id.card_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.card_list);
                if (recyclerView != null) {
                    i11 = R.id.delete_all_card;
                    TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view, R.id.delete_all_card);
                    if (talabatToolBarButton != null) {
                        i11 = R.id.no_card_add_card;
                        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.no_card_add_card);
                        if (talabatFillButton != null) {
                            i11 = R.id.no_card_img;
                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.no_card_img);
                            if (imageButton != null) {
                                i11 = R.id.no_card_view;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.no_card_view);
                                if (linearLayout != null) {
                                    i11 = R.id.talabat_toolbar;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.talabat_toolbar);
                                    if (relativeLayout2 != null) {
                                        i11 = R.id.title;
                                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
                                        if (talabatToolBarTextView != null) {
                                            i11 = R.id.toolbar;
                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                            if (talabatToolBar != null) {
                                                return new PayfortCardPaymentManageScreenBinding((LinearLayout) view, talabatToolBarImageButton, relativeLayout, recyclerView, talabatToolBarButton, talabatFillButton, imageButton, linearLayout, relativeLayout2, talabatToolBarTextView, talabatToolBar);
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
    public static PayfortCardPaymentManageScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static PayfortCardPaymentManageScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.payfort_card_payment_manage_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
