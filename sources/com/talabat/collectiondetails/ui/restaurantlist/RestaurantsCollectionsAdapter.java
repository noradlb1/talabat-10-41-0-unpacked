package com.talabat.collectiondetails.ui.restaurantlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.collectiondetails.R;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import kotlin.Unit;
import yf.d;

public class RestaurantsCollectionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnRestaurantCLickListener mListiner;
    private RestaurantListModel mRestaurantListModel = new RestaurantListModel();

    public interface OnRestaurantCLickListener {
        void onRestaurantClick(Restaurant restaurant, int i11);
    }

    public RestaurantsCollectionsAdapter(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(int i11, Restaurant restaurant, Integer num) {
        this.mListiner.onRestaurantClick(restaurant, i11);
        return Unit.INSTANCE;
    }

    public int getItemCount() {
        return this.mRestaurantListModel.getRestaurantListCount();
    }

    public RestaurantListModel getRestaurantListModel() {
        return this.mRestaurantListModel;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        ((FreshRestaurantUiViewHolderExperiment) viewHolder).bind(this.mRestaurantListModel.getAllRestaurants().get(i11), i11, new d(this, i11), "");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new FreshRestaurantUiViewHolderExperiment(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vendor_card_view_experiment, viewGroup, false), true);
    }

    public void setOnRestaurantClickListener(OnRestaurantCLickListener onRestaurantCLickListener) {
        this.mListiner = onRestaurantCLickListener;
    }

    public void setRestaurantListModel(RestaurantListModel restaurantListModel) {
        this.mRestaurantListModel = restaurantListModel;
        notifyDataSetChanged();
    }
}
