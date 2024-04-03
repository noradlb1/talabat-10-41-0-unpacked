package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class BottomSheetVouchersBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout bottomSheet;
    @NonNull
    public final LinearLayout containerAll;
    @NonNull
    public final LinearLayout errorNotifyLinearLayout;
    @NonNull
    public final ProgressBar genericProgressBar;
    @NonNull
    public final RelativeLayout genericProgressBarRootRelativeLayout;
    @NonNull
    public final TextView riderBottomSheetUseButtonTextView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final LinearLayout vendorBottomSheetUseButton;
    @NonNull
    public final LinearLayout vendorBottomSheetUseButtonLinearLayout;
    @NonNull
    public final TextView voucherBottomSheetAvailableVouchersTextView;
    @NonNull
    public final RecyclerView voucherBottomSheetRecyclerView;
    @NonNull
    public final EditText voucherBottomSheetVoucherEditText;
    @NonNull
    public final ImageView voucherItemCheckBoxImageView;

    private BottomSheetVouchersBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout3, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull TextView textView2, @NonNull RecyclerView recyclerView, @NonNull EditText editText, @NonNull ImageView imageView) {
        this.rootView = relativeLayout;
        this.bottomSheet = relativeLayout2;
        this.containerAll = linearLayout;
        this.errorNotifyLinearLayout = linearLayout2;
        this.genericProgressBar = progressBar;
        this.genericProgressBarRootRelativeLayout = relativeLayout3;
        this.riderBottomSheetUseButtonTextView = textView;
        this.vendorBottomSheetUseButton = linearLayout3;
        this.vendorBottomSheetUseButtonLinearLayout = linearLayout4;
        this.voucherBottomSheetAvailableVouchersTextView = textView2;
        this.voucherBottomSheetRecyclerView = recyclerView;
        this.voucherBottomSheetVoucherEditText = editText;
        this.voucherItemCheckBoxImageView = imageView;
    }

    @NonNull
    public static BottomSheetVouchersBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i11 = R.id.container_all;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout != null) {
            i11 = R.id.errorNotifyLinearLayout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout2 != null) {
                i11 = R.id.genericProgressBar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                if (progressBar != null) {
                    i11 = R.id.genericProgressBarRootRelativeLayout;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
                    if (relativeLayout2 != null) {
                        i11 = R.id.riderBottomSheetUseButtonTextView;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            i11 = R.id.vendorBottomSheetUseButton;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                            if (linearLayout3 != null) {
                                i11 = R.id.vendorBottomSheetUseButtonLinearLayout;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                if (linearLayout4 != null) {
                                    i11 = R.id.voucherBottomSheetAvailableVouchersTextView;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView2 != null) {
                                        i11 = R.id.voucherBottomSheetRecyclerView;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                                        if (recyclerView != null) {
                                            i11 = R.id.voucherBottomSheetVoucherEditText;
                                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i11);
                                            if (editText != null) {
                                                i11 = R.id.voucherItemCheckBoxImageView;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                                                if (imageView != null) {
                                                    return new BottomSheetVouchersBinding(relativeLayout, relativeLayout, linearLayout, linearLayout2, progressBar, relativeLayout2, textView, linearLayout3, linearLayout4, textView2, recyclerView, editText, imageView);
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
    public static BottomSheetVouchersBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BottomSheetVouchersBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_vouchers, viewGroup, false);
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
