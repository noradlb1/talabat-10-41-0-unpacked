package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_radiobutton.DSRadioButton;
import com.talabat.feature.tpro.presentation.R;

public final class ItemCancellationReasonBinding implements ViewBinding {
    @NonNull
    public final DSRadioButton rbCancellationReason;
    @NonNull
    private final View rootView;
    @NonNull
    public final TextView tvReasonText;

    private ItemCancellationReasonBinding(@NonNull View view, @NonNull DSRadioButton dSRadioButton, @NonNull TextView textView) {
        this.rootView = view;
        this.rbCancellationReason = dSRadioButton;
        this.tvReasonText = textView;
    }

    @NonNull
    public static ItemCancellationReasonBinding bind(@NonNull View view) {
        int i11 = R.id.rb_cancellation_reason;
        DSRadioButton dSRadioButton = (DSRadioButton) ViewBindings.findChildViewById(view, i11);
        if (dSRadioButton != null) {
            i11 = R.id.tv_reason_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new ItemCancellationReasonBinding(view, dSRadioButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemCancellationReasonBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.item_cancellation_reason, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
