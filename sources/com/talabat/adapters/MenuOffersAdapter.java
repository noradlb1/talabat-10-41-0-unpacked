package com.talabat.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.talabat.R;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.talabatcommon.helpers.GlideApp;
import datamodels.OffersItem;
import java.util.List;

public class MenuOffersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public Context f55131i;

    /* renamed from: j  reason: collision with root package name */
    public List<OffersItem> f55132j;
    /* access modifiers changed from: private */
    public OnClickedListener mClickListener;

    public class OfferViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f55137h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f55138i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55139j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f55140k;

        /* renamed from: l  reason: collision with root package name */
        public TextView f55141l;

        /* renamed from: m  reason: collision with root package name */
        public View f55142m;

        /* renamed from: n  reason: collision with root package name */
        public View f55143n;

        public OfferViewHolder(View view) {
            super(view);
            this.f55137h = (ProgressBar) view.findViewById(R.id.progress);
            this.f55138i = (ImageView) view.findViewById(R.id.civ_item_image);
            this.f55139j = (TextView) view.findViewById(R.id.tv_item_name);
            this.f55140k = (TextView) view.findViewById(R.id.tv_desc);
            this.f55141l = (TextView) view.findViewById(R.id.tv_select);
            this.f55142m = view.findViewById(R.id.fl_image);
            this.f55143n = view.findViewById(R.id.ll_container);
        }
    }

    public interface OnClickedListener {
        void onCartIconClicked(int i11, ImageView imageView);

        void onMenuImageClicked(int i11, ImageView imageView);

        void onOffersItemClicked(int i11, ImageView imageView);
    }

    public MenuOffersAdapter(Context context) {
        this.f55131i = context;
    }

    public int getItemCount() {
        return this.f55132j.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        final OfferViewHolder offerViewHolder = (OfferViewHolder) viewHolder;
        OffersItem offersItem = this.f55132j.get(i11);
        String str = offersItem.title;
        if (str == null || str.isEmpty()) {
            offerViewHolder.f55139j.setVisibility(8);
        } else {
            offerViewHolder.f55139j.setText(offersItem.title);
        }
        String str2 = offersItem.description;
        if (str2 == null || str2.isEmpty()) {
            offerViewHolder.f55140k.setVisibility(4);
        } else {
            offerViewHolder.f55140k.setText(offersItem.description);
            offerViewHolder.f55140k.setVisibility(0);
        }
        offerViewHolder.f55138i.setTag(Integer.valueOf(i11));
        String str3 = offersItem.thumbnail;
        if (str3 == null || !str3.isEmpty()) {
            offerViewHolder.f55142m.setVisibility(8);
            offerViewHolder.f55137h.setVisibility(8);
            offerViewHolder.f55138i.setVisibility(0);
            return;
        }
        offerViewHolder.f55142m.setVisibility(0);
        offerViewHolder.f55143n.setPadding(0, 0, 0, 13);
        offerViewHolder.f55138i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (MenuOffersAdapter.this.mClickListener != null) {
                    MenuOffersAdapter.this.mClickListener.onMenuImageClicked(intValue, offerViewHolder.f55138i);
                }
            }
        });
        if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(this.f55131i)) {
            GlideApp.with(this.f55131i).clear((View) offerViewHolder.f55138i);
            GlideApp.with(this.f55131i).load(offersItem.thumbnail).circleCrop().listener((RequestListener) new RequestListener<Drawable>() {
                public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                    offerViewHolder.f55138i.setImageResource(R.drawable.placeholder);
                    offerViewHolder.f55137h.setVisibility(8);
                    offerViewHolder.f55138i.setVisibility(0);
                    return false;
                }

                public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                    offerViewHolder.f55137h.setVisibility(8);
                    offerViewHolder.f55138i.setVisibility(0);
                    return false;
                }
            }).into(offerViewHolder.f55138i);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new OfferViewHolder(LayoutInflater.from(this.f55131i).inflate(R.layout.item_menu_offer, viewGroup, false));
    }

    public void setOffers(List<OffersItem> list) {
        this.f55132j = list;
        notifyDataSetChanged();
    }
}
