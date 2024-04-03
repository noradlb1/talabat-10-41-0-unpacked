package com.talabat.adapters.restaurantslist;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.helpers.HorizontalSpacesItemDecoration;
import datamodels.Swimlane;

public class SwimlaneRestaurantViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f55341h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55342i;

    public SwimlaneRestaurantViewHolder(View view, Context context) {
        super(view);
        this.f55341h = (RecyclerView) view.findViewById(R.id.recyclerView_recommendationRestaurants);
        this.f55342i = (TextView) view.findViewById(R.id.swimlaneTitle);
        new LinearSnapHelper().attachToRecyclerView(this.f55341h);
        this.f55341h.setNestedScrollingEnabled(false);
        this.f55341h.startNestedScroll(1);
        this.f55341h.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.f55341h.addItemDecoration(new HorizontalSpacesItemDecoration(context.getResources().getDimensionPixelOffset(R.dimen.ds_xs)));
    }

    public void setSwimlane(Context context, Swimlane swimlane, OnRestaurantClick onRestaurantClick) {
        if (swimlane.getTitle() != null) {
            this.f55342i.setText(swimlane.getTitle());
        }
        SwimlaneRestaurantsAdapter swimlaneRestaurantsAdapter = new SwimlaneRestaurantsAdapter(context, swimlane);
        swimlaneRestaurantsAdapter.setOnRestaurantClickListener(onRestaurantClick);
        this.f55341h.setAdapter(swimlaneRestaurantsAdapter);
    }
}
