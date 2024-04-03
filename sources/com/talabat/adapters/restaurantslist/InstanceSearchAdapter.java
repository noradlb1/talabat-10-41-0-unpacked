package com.talabat.adapters.restaurantslist;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bf.a;
import com.talabat.R;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.talabatcommon.helpers.GlideApp;
import datamodels.Restaurant;
import java.util.Collections;
import java.util.List;

public class InstanceSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private onSuggestSearchResultClicked mListener;
    private List<Restaurant> mRestaurants = Collections.emptyList();
    private String mSearchTerm;

    public interface onSuggestSearchResultClicked {
        void onSuggestRestaurantClick(Restaurant restaurant, int i11);
    }

    public InstanceSearchAdapter(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(Restaurant restaurant, int i11, View view) {
        this.mListener.onSuggestRestaurantClick(restaurant, i11);
    }

    public int getItemCount() {
        return this.mRestaurants.size();
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i11) {
        InstantSearchViewHolder instantSearchViewHolder = (InstantSearchViewHolder) viewHolder;
        Restaurant restaurant = this.mRestaurants.get(i11);
        if (restaurant.getName().toLowerCase().contains(this.mSearchTerm.toLowerCase())) {
            int indexOf = restaurant.getName().toLowerCase().indexOf(this.mSearchTerm.toLowerCase());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(restaurant.getName());
            spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, this.mSearchTerm.length() + indexOf, 33);
            instantSearchViewHolder.f55296i.setText(spannableStringBuilder);
        } else {
            instantSearchViewHolder.f55296i.setText(restaurant.getName());
        }
        int i12 = restaurant.statusType;
        if (i12 == 0) {
            instantSearchViewHolder.f55297j.setVisibility(8);
        } else if (i12 == 5) {
            instantSearchViewHolder.f55297j.setText(this.mContext.getResources().getString(R.string.preorder));
            instantSearchViewHolder.f55297j.setTextColor(Color.parseColor("#dd1608"));
            instantSearchViewHolder.f55297j.setVisibility(0);
        } else if (i12 == 1) {
            instantSearchViewHolder.f55297j.setText(this.mContext.getResources().getString(R.string.closed_tgo));
            instantSearchViewHolder.f55297j.setTextColor(Color.parseColor("#f10026"));
            instantSearchViewHolder.f55297j.setVisibility(0);
        } else {
            instantSearchViewHolder.f55297j.setText(this.mContext.getResources().getString(R.string.busy_tgo));
            instantSearchViewHolder.f55297j.setTextColor(Color.parseColor("#ff9f00"));
            instantSearchViewHolder.f55297j.setVisibility(0);
        }
        if (restaurant.getLogo() == null || !GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(this.mContext)) {
            instantSearchViewHolder.f55295h.setImageResource(0);
        } else {
            GlideApp.with(this.mContext).clear((View) instantSearchViewHolder.f55295h);
            GlideApp.with(this.mContext).load(restaurant.getLogo()).into(instantSearchViewHolder.f55295h);
        }
        instantSearchViewHolder.itemView.setOnClickListener(new a(this, restaurant, i11));
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return new InstantSearchViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_instant_search_restaurant, viewGroup, false));
    }

    public void setListener(onSuggestSearchResultClicked onsuggestsearchresultclicked) {
        this.mListener = onsuggestsearchresultclicked;
    }

    public void setRestaurants(List<Restaurant> list, String str) {
        this.mRestaurants = list;
        this.mSearchTerm = str;
        notifyDataSetChanged();
    }
}
