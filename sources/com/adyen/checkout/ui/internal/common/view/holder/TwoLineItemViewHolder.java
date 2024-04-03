package com.adyen.checkout.ui.internal.common.view.holder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.ui.R;

public final class TwoLineItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView mActionImageView;
    private ImageView mLogoImageView;
    private TextView mPrimaryTextView;
    private TextView mSecondaryTextView;

    private TwoLineItemViewHolder(@NonNull View view) {
        super(view);
        this.mLogoImageView = (ImageView) view.findViewById(R.id.imageView_logo);
        this.mPrimaryTextView = (TextView) view.findViewById(R.id.textView_primary);
        this.mSecondaryTextView = (TextView) view.findViewById(R.id.textView_secondary);
        this.mActionImageView = (ImageView) view.findViewById(R.id.imageView_action);
    }

    @NonNull
    public static TwoLineItemViewHolder create(@NonNull ViewGroup viewGroup) {
        return new TwoLineItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_two_line, viewGroup, false));
    }

    @NonNull
    public ImageView getActionImageView() {
        return this.mActionImageView;
    }

    @NonNull
    public ImageView getLogoImageView() {
        return this.mLogoImageView;
    }

    @NonNull
    public TextView getPrimaryTextView() {
        return this.mPrimaryTextView;
    }

    @NonNull
    public TextView getSecondaryTextView() {
        return this.mSecondaryTextView;
    }

    public void setPrimaryText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mPrimaryTextView.setVisibility(8);
        } else {
            this.mPrimaryTextView.setVisibility(0);
        }
        this.mPrimaryTextView.setText(charSequence);
    }

    public void setSecondaryText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mSecondaryTextView.setVisibility(8);
        } else {
            this.mSecondaryTextView.setVisibility(0);
        }
        this.mSecondaryTextView.setText(charSequence);
    }

    @NonNull
    public static TwoLineItemViewHolder create(@NonNull View view, @IdRes int i11) {
        return new TwoLineItemViewHolder(view.findViewById(i11));
    }
}
