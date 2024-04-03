package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class AddVoucherCodeViewBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final EditText voucherCodeEditText;
    @NonNull
    public final ImageView voucherCodeIconImageView;
    @NonNull
    public final TextView voucherCodeSubmitButton;

    private AddVoucherCodeViewBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.voucherCodeEditText = editText;
        this.voucherCodeIconImageView = imageView;
        this.voucherCodeSubmitButton = textView;
    }

    @NonNull
    public static AddVoucherCodeViewBinding bind(@NonNull View view) {
        int i11 = R.id.voucherCodeEditText;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i11);
        if (editText != null) {
            i11 = R.id.voucherCodeIconImageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.voucherCodeSubmitButton;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    return new AddVoucherCodeViewBinding((LinearLayout) view, editText, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static AddVoucherCodeViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AddVoucherCodeViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.add_voucher_code_view, viewGroup, false);
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
