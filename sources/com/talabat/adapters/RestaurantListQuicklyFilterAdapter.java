package com.talabat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.talabat.R;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import datamodels.QuickFilter;
import java.util.ArrayList;
import xe.e;

public class RestaurantListQuicklyFilterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<QuickFilter> f55215i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    public Context f55216j;

    /* renamed from: k  reason: collision with root package name */
    public OnQuickFilterClick f55217k;

    public interface OnQuickFilterClick {
        void quickFilterClick(String str);
    }

    public class QuicklyFilterViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public CardView f55218h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f55219i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55220j;

        public QuicklyFilterViewHolder(View view) {
            super(view);
            this.f55218h = (CardView) view.findViewById(R.id.linearLayout_container);
            this.f55219i = (ImageView) view.findViewById(R.id.imageView_icon);
            this.f55220j = (TextView) view.findViewById(R.id.textView_name);
        }
    }

    public RestaurantListQuicklyFilterAdapter(Context context) {
        this.f55216j = context;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(QuickFilter quickFilter, View view) {
        this.f55217k.quickFilterClick(quickFilter.getDeepLink());
    }

    public int getItemCount() {
        return this.f55215i.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        QuicklyFilterViewHolder quicklyFilterViewHolder = (QuicklyFilterViewHolder) viewHolder;
        QuickFilter quickFilter = this.f55215i.get(i11);
        Glide.with(this.f55216j).load(StringUtils.vendorImage(quickFilter.getSmallIcon())).into(quicklyFilterViewHolder.f55219i);
        quicklyFilterViewHolder.f55220j.setText(quickFilter.getWidgetName());
        quicklyFilterViewHolder.f55218h.setOnClickListener(new e(this, quickFilter));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new QuicklyFilterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_restuarant_list_quick_filter, viewGroup, false));
    }

    public void setOnClickListener(OnQuickFilterClick onQuickFilterClick) {
        this.f55217k = onQuickFilterClick;
    }

    public void setQuickFilterList() {
        this.f55215i = GlobalDataModel.collections;
        notifyDataSetChanged();
    }
}
