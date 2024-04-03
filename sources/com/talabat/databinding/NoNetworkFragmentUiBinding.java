package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.NoNetworkWaveAnimation;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class NoNetworkFragmentUiBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarButton back;
    @NonNull
    public final NoNetworkWaveAnimation content;
    @NonNull
    public final TalabatTextView noNetworkDescriptionTxt;
    @NonNull
    public final TalabatTextView noNetworkHeaderTxt;
    @NonNull
    public final ImageView noNetwrkImg;
    @NonNull
    public final TalabatFillButton retry;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private NoNetworkFragmentUiBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull NoNetworkWaveAnimation noNetworkWaveAnimation, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = relativeLayout;
        this.back = talabatToolBarButton;
        this.content = noNetworkWaveAnimation;
        this.noNetworkDescriptionTxt = talabatTextView;
        this.noNetworkHeaderTxt = talabatTextView2;
        this.noNetwrkImg = imageView;
        this.retry = talabatFillButton;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static NoNetworkFragmentUiBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view, R.id.back);
        if (talabatToolBarButton != null) {
            i11 = R.id.content;
            NoNetworkWaveAnimation noNetworkWaveAnimation = (NoNetworkWaveAnimation) ViewBindings.findChildViewById(view, R.id.content);
            if (noNetworkWaveAnimation != null) {
                i11 = R.id.no_network_description_txt;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.no_network_description_txt);
                if (talabatTextView != null) {
                    i11 = R.id.no_network_header_txt;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.no_network_header_txt);
                    if (talabatTextView2 != null) {
                        i11 = R.id.no_netwrk_img;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.no_netwrk_img);
                        if (imageView != null) {
                            i11 = R.id.retry;
                            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.retry);
                            if (talabatFillButton != null) {
                                i11 = R.id.title;
                                TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
                                if (talabatToolBarTextView != null) {
                                    i11 = R.id.toolbar;
                                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (talabatToolBar != null) {
                                        return new NoNetworkFragmentUiBinding((RelativeLayout) view, talabatToolBarButton, noNetworkWaveAnimation, talabatTextView, talabatTextView2, imageView, talabatFillButton, talabatToolBarTextView, talabatToolBar);
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
    public static NoNetworkFragmentUiBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static NoNetworkFragmentUiBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.no_network_fragment_ui, viewGroup, false);
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
