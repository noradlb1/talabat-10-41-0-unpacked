package com.talabat.adapters.restaurantslist;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;

class SearchRestaurantViewHolder extends RecyclerView.ViewHolder {
    public TextView averageDeliveryTimeTextView;
    public TextView cuisineTextView;
    public TextView deliveryCostTextView;
    public TextView minimumCostTextView;
    public TextView newTagImageView;
    public ImageView overlayImageView;
    public final View preOrderLayout;
    public ProgressBar progressBar;
    public ImageView restaurantLogoImageView;
    public TextView restaurantNameTextView;
    public FrameLayout statusContainerFrameLayout;
    public TextView statusTextView;
    public ImageView vendorRateAvatar;
    public TextView vendorRateStatus;

    public SearchRestaurantViewHolder(View view) {
        super(view);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        this.restaurantLogoImageView = (ImageView) view.findViewById(R.id.imageView_restaurantLogo);
        this.overlayImageView = (ImageView) view.findViewById(R.id.imageView_overlay);
        this.vendorRateStatus = (TextView) view.findViewById(R.id.vendorRateStatus);
        this.vendorRateAvatar = (ImageView) view.findViewById(R.id.vendorRateAvatar);
        this.restaurantNameTextView = (TextView) view.findViewById(R.id.textView_restaurantName);
        this.cuisineTextView = (TextView) view.findViewById(R.id.textView_cuisines);
        this.newTagImageView = (TextView) view.findViewById(R.id.imageView_newTag);
        this.averageDeliveryTimeTextView = (TextView) view.findViewById(R.id.textView_averageDeliveryTime);
        this.minimumCostTextView = (TextView) view.findViewById(R.id.textView_minimumCost);
        this.deliveryCostTextView = (TextView) view.findViewById(R.id.textView_deliveryCost);
        this.statusContainerFrameLayout = (FrameLayout) view.findViewById(R.id.frameLayout_statusContainer);
        this.statusTextView = (TextView) view.findViewById(R.id.textView_status);
        this.preOrderLayout = view.findViewById(R.id.layout_preOrder);
    }
}
