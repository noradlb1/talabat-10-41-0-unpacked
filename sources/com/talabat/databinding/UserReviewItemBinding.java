package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class UserReviewItemBinding implements ViewBinding {
    @NonNull
    public final ImageView ratingStar;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatTextView tvCommentDate;
    @NonNull
    public final TalabatTextView tvPowerUser;
    @NonNull
    public final TalabatTextView tvRateUserName;
    @NonNull
    public final TalabatTextView tvRestaurantReply;
    @NonNull
    public final TalabatTextView tvReviewRestaurantName;
    @NonNull
    public final TalabatTextView tvUserComment;
    @NonNull
    public final ImageView vendorRateAvatar;
    @NonNull
    public final TextView vendorRateStatus;
    @NonNull
    public final LinearLayout viewReply;
    @NonNull
    public final View viewSeparator;

    private UserReviewItemBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull View view) {
        this.rootView = linearLayout;
        this.ratingStar = imageView;
        this.tvCommentDate = talabatTextView;
        this.tvPowerUser = talabatTextView2;
        this.tvRateUserName = talabatTextView3;
        this.tvRestaurantReply = talabatTextView4;
        this.tvReviewRestaurantName = talabatTextView5;
        this.tvUserComment = talabatTextView6;
        this.vendorRateAvatar = imageView2;
        this.vendorRateStatus = textView;
        this.viewReply = linearLayout2;
        this.viewSeparator = view;
    }

    @NonNull
    public static UserReviewItemBinding bind(@NonNull View view) {
        int i11 = R.id.rating_star;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.rating_star);
        if (imageView != null) {
            i11 = R.id.tv_comment_date;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_comment_date);
            if (talabatTextView != null) {
                i11 = R.id.tv_power_user;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_power_user);
                if (talabatTextView2 != null) {
                    i11 = R.id.tv_rate_user_name;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_rate_user_name);
                    if (talabatTextView3 != null) {
                        i11 = R.id.tv_restaurant_reply;
                        TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_restaurant_reply);
                        if (talabatTextView4 != null) {
                            i11 = R.id.tv_review_restaurant_name;
                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_review_restaurant_name);
                            if (talabatTextView5 != null) {
                                i11 = R.id.tv_user_comment;
                                TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tv_user_comment);
                                if (talabatTextView6 != null) {
                                    i11 = R.id.vendor_rate_avatar;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.vendor_rate_avatar);
                                    if (imageView2 != null) {
                                        i11 = R.id.vendor_rate_status;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vendor_rate_status);
                                        if (textView != null) {
                                            i11 = R.id.view_reply;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.view_reply);
                                            if (linearLayout != null) {
                                                i11 = R.id.view_separator;
                                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.view_separator);
                                                if (findChildViewById != null) {
                                                    return new UserReviewItemBinding((LinearLayout) view, imageView, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4, talabatTextView5, talabatTextView6, imageView2, textView, linearLayout, findChildViewById);
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
    public static UserReviewItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static UserReviewItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.user_review_item, viewGroup, false);
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
