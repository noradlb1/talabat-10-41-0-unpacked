package com.talabat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import datamodels.RestaurantReviewPaging;
import java.util.List;

public class UserReviewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public Context f55222i;

    /* renamed from: j  reason: collision with root package name */
    public List<RestaurantReviewPaging> f55223j;

    /* renamed from: k  reason: collision with root package name */
    public String f55224k;

    public class UserReviewViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f55225h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f55226i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55227j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f55228k;

        /* renamed from: l  reason: collision with root package name */
        public ImageView f55229l;

        /* renamed from: m  reason: collision with root package name */
        public TextView f55230m;

        /* renamed from: n  reason: collision with root package name */
        public TextView f55231n;

        /* renamed from: o  reason: collision with root package name */
        public TextView f55232o;

        /* renamed from: p  reason: collision with root package name */
        public ImageView f55233p;

        /* renamed from: q  reason: collision with root package name */
        public View f55234q;

        /* renamed from: r  reason: collision with root package name */
        public View f55235r;

        public UserReviewViewHolder(View view) {
            super(view);
            this.f55225h = (TextView) view.findViewById(R.id.tv_rate_user_name);
            this.f55226i = (TextView) view.findViewById(R.id.tv_power_user);
            this.f55227j = (TextView) view.findViewById(R.id.tv_user_comment);
            this.f55228k = (TextView) view.findViewById(R.id.tv_comment_date);
            this.f55229l = (ImageView) view.findViewById(R.id.rating_star);
            this.f55230m = (TextView) view.findViewById(R.id.tv_review_restaurant_name);
            this.f55231n = (TextView) view.findViewById(R.id.tv_restaurant_reply);
            this.f55234q = view.findViewById(R.id.view_reply);
            this.f55235r = view.findViewById(R.id.view_separator);
            this.f55233p = (ImageView) view.findViewById(R.id.vendor_rate_avatar);
            this.f55232o = (TextView) view.findViewById(R.id.vendor_rate_status);
        }
    }

    public UserReviewsAdapter(Context context, List<RestaurantReviewPaging> list, String str) {
        this.f55222i = context;
        this.f55223j = list;
        this.f55224k = str;
    }

    public int getItemCount() {
        return this.f55223j.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        UserReviewViewHolder userReviewViewHolder = (UserReviewViewHolder) viewHolder;
        RestaurantReviewPaging restaurantReviewPaging = this.f55223j.get(i11);
        TextView textView = userReviewViewHolder.f55225h;
        textView.setText(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + restaurantReviewPaging.getName());
        TextView textView2 = userReviewViewHolder.f55228k;
        textView2.setText("(" + restaurantReviewPaging.getDate() + ")");
        userReviewViewHolder.f55227j.setText(restaurantReviewPaging.getReview());
        if (restaurantReviewPaging.getRating() >= 4.0f) {
            userReviewViewHolder.f55233p.setImageResource(R.drawable.ic_happy_filled);
            userReviewViewHolder.f55232o.setText(this.f55222i.getResources().getString(R.string.vendor_rating_amazing));
        } else if (restaurantReviewPaging.getRating() <= 2.0f) {
            userReviewViewHolder.f55233p.setImageResource(R.drawable.ic_sad);
            userReviewViewHolder.f55232o.setText(this.f55222i.getResources().getString(R.string.vendor_rating_good));
        } else {
            userReviewViewHolder.f55233p.setImageResource(R.drawable.ic_happy);
            userReviewViewHolder.f55232o.setText(this.f55222i.getResources().getString(R.string.vendor_rating_v_good));
        }
        if (restaurantReviewPaging.res != null) {
            userReviewViewHolder.f55234q.setVisibility(0);
            userReviewViewHolder.f55231n.setText(restaurantReviewPaging.res.restaurantResponse);
            userReviewViewHolder.f55230m.setText(this.f55224k);
        } else {
            userReviewViewHolder.f55234q.setVisibility(8);
        }
        if (i11 == this.f55223j.size() - 1) {
            userReviewViewHolder.f55235r.setVisibility(8);
        }
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_STAR_RATING, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            userReviewViewHolder.f55229l.setVisibility(0);
            userReviewViewHolder.f55233p.setVisibility(8);
            userReviewViewHolder.f55232o.setText(restaurantReviewPaging.getRating() + "");
            return;
        }
        userReviewViewHolder.f55229l.setVisibility(8);
        userReviewViewHolder.f55233p.setVisibility(0);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new UserReviewViewHolder(LayoutInflater.from(this.f55222i).inflate(R.layout.user_review_item, viewGroup, false));
    }
}
