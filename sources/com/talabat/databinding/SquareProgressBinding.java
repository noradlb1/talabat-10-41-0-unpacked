package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.designhelpers.CustomSquareProgree.SquareProgressView;

public final class SquareProgressBinding implements ViewBinding {
    @NonNull
    public final TalabatButton enterButton;
    @NonNull
    public final RelativeLayout enterLayout;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final SquareProgressView squareProgressView;

    private SquareProgressBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatButton talabatButton, @NonNull RelativeLayout relativeLayout2, @NonNull SquareProgressView squareProgressView2) {
        this.rootView = relativeLayout;
        this.enterButton = talabatButton;
        this.enterLayout = relativeLayout2;
        this.squareProgressView = squareProgressView2;
    }

    @NonNull
    public static SquareProgressBinding bind(@NonNull View view) {
        int i11 = R.id.enter_button;
        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view, R.id.enter_button);
        if (talabatButton != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            SquareProgressView squareProgressView2 = (SquareProgressView) ViewBindings.findChildViewById(view, R.id.square_progress_view);
            if (squareProgressView2 != null) {
                return new SquareProgressBinding(relativeLayout, talabatButton, relativeLayout, squareProgressView2);
            }
            i11 = R.id.square_progress_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SquareProgressBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SquareProgressBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.square_progress, viewGroup, false);
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
