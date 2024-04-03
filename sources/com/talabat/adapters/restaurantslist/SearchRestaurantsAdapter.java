package com.talabat.adapters.restaurantslist;

import JsonModels.Response.ItemSearchResponse;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import bf.g;
import buisnessmodels.Customer;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.talabat.R;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.helpers.GlideApp;
import datamodels.Restaurant;
import datamodels.RestaurantsSearchWrapperClass;
import java.util.ArrayList;

public class SearchRestaurantsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public Context f55328i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<RestaurantsSearchWrapperClass> f55329j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    public String f55330k;

    /* renamed from: l  reason: collision with root package name */
    public onSearchResultClicked f55331l;

    public interface onSearchResultClicked {
        void onItemClick(Restaurant restaurant, ArrayList<ItemSearchResponse> arrayList, String str, int i11, String str2, int i12);

        void onRestaurantClick(Restaurant restaurant, int i11);
    }

    public SearchRestaurantsAdapter(Context context) {
        this.f55328i = context;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(Restaurant restaurant, int i11, View view) {
        onSearchResultClicked onsearchresultclicked = this.f55331l;
        if (onsearchresultclicked != null) {
            onsearchresultclicked.onRestaurantClick(restaurant, i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(Restaurant restaurant, ArrayList arrayList, int i11, SearchDishViewHolder searchDishViewHolder, int i12, View view) {
        onSearchResultClicked onsearchresultclicked = this.f55331l;
        if (onsearchresultclicked != null) {
            onsearchresultclicked.onItemClick(restaurant, arrayList, this.f55330k, i11, searchDishViewHolder.f55321j.getText().toString(), i12);
        }
    }

    public int getItemCount() {
        return this.f55329j.size();
    }

    public int getItemViewType(int i11) {
        return this.f55329j.get(i11).getType();
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i11) {
        int i12 = i11;
        if (viewHolder.getItemViewType() == 2) {
            ((SearchHeaderViewHolder) viewHolder).f55327h.setText(String.format("%s %s", new Object[]{this.f55329j.get(i12).getHeaderText(), this.f55328i.getResources().getString(R.string.search_restaurants_found)}));
        } else if (viewHolder.getItemViewType() == 3) {
            ((SearchHeaderViewHolder) viewHolder).f55327h.setText(String.format("%s %s", new Object[]{this.f55329j.get(i12).getHeaderText(), this.f55328i.getResources().getString(R.string.search_items_found)}));
        } else if (viewHolder.getItemViewType() == 0) {
            final SearchRestaurantViewHolder searchRestaurantViewHolder = (SearchRestaurantViewHolder) viewHolder;
            final Restaurant restaurant = this.f55329j.get(i12).getRestaurant();
            if (restaurant.statusType == 5) {
                searchRestaurantViewHolder.preOrderLayout.setVisibility(0);
            } else {
                searchRestaurantViewHolder.preOrderLayout.setVisibility(8);
            }
            searchRestaurantViewHolder.restaurantNameTextView.setText(restaurant.f13873name);
            searchRestaurantViewHolder.restaurantNameTextView.setMaxLines(1);
            searchRestaurantViewHolder.restaurantNameTextView.setLines(1);
            searchRestaurantViewHolder.restaurantNameTextView.setSingleLine(true);
            searchRestaurantViewHolder.restaurantNameTextView.setEllipsize(TextUtils.TruncateAt.END);
            searchRestaurantViewHolder.minimumCostTextView.setText(String.format("%s %s", new Object[]{this.f55328i.getResources().getString(R.string.min_order_place_order), restaurant.getDisplayMinimumAmountWithoutCurrency(Customer.getInstance())}));
            searchRestaurantViewHolder.averageDeliveryTimeTextView.setText(restaurant.deliveryTime);
            searchRestaurantViewHolder.cuisineTextView.setText(restaurant.getCuisineString());
            searchRestaurantViewHolder.restaurantLogoImageView.setImageDrawable((Drawable) null);
            searchRestaurantViewHolder.progressBar.setVisibility(0);
            if (restaurant.getLogo() == null) {
                searchRestaurantViewHolder.restaurantLogoImageView.setImageResource(0);
                searchRestaurantViewHolder.restaurantLogoImageView.setVisibility(0);
            } else if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(this.f55328i)) {
                float applyDimension = TypedValue.applyDimension(1, 8.0f, this.f55328i.getResources().getDisplayMetrics());
                GlideApp.with(this.f55328i).clear((View) searchRestaurantViewHolder.restaurantLogoImageView);
                GlideApp.with(this.f55328i).load(restaurant.getLogo()).transform((Transformation) new MultiTransformation((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCorners((int) applyDimension)})).listener((RequestListener) new RequestListener<Drawable>() {
                    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                        String trim = restaurant.getLogo().toString().trim();
                        if (!TalabatUtils.isNullOrEmpty(trim.substring(trim.lastIndexOf("/") + 1, trim.length()))) {
                            searchRestaurantViewHolder.progressBar.setVisibility(0);
                        } else {
                            searchRestaurantViewHolder.progressBar.setVisibility(8);
                            searchRestaurantViewHolder.restaurantLogoImageView.setImageResource(0);
                            searchRestaurantViewHolder.restaurantLogoImageView.setVisibility(0);
                        }
                        return false;
                    }

                    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                        searchRestaurantViewHolder.progressBar.setVisibility(8);
                        return false;
                    }
                }).placeholder((int) R.drawable.glide_placeholder).into(searchRestaurantViewHolder.restaurantLogoImageView);
            }
            int i13 = restaurant.statusType;
            if (i13 == 0) {
                searchRestaurantViewHolder.statusContainerFrameLayout.setVisibility(8);
            } else if (i13 == 5) {
                searchRestaurantViewHolder.preOrderLayout.setVisibility(0);
                searchRestaurantViewHolder.statusContainerFrameLayout.setVisibility(8);
            } else if (i13 == 1) {
                searchRestaurantViewHolder.statusTextView.setText(this.f55328i.getResources().getText(R.string.closed));
                searchRestaurantViewHolder.statusContainerFrameLayout.setVisibility(0);
            } else {
                searchRestaurantViewHolder.statusTextView.setText(this.f55328i.getResources().getText(R.string.busy));
                searchRestaurantViewHolder.statusContainerFrameLayout.setVisibility(0);
            }
            if (restaurant.getDeliveryCharges() == 0.0f) {
                String str = this.f55328i.getResources().getString(R.string.delivery_amount_place_order) + " " + this.f55328i.getResources().getString(R.string.free_caps);
                if (restaurant.isTalabatGo) {
                    str = this.f55328i.getResources().getString(R.string.f54892service) + " " + this.f55328i.getResources().getString(R.string.free_caps);
                }
                searchRestaurantViewHolder.deliveryCostTextView.setText(str);
            } else if (restaurant.isTalabatGo) {
                searchRestaurantViewHolder.deliveryCostTextView.setText(String.format("%s %s", new Object[]{this.f55328i.getResources().getString(R.string.f54892service), restaurant.getDisplayDeliveryChargesForList()}), TextView.BufferType.SPANNABLE);
            } else {
                searchRestaurantViewHolder.deliveryCostTextView.setText(String.format("%s %s", new Object[]{this.f55328i.getResources().getString(R.string.delivery_amount_place_order), restaurant.getDisplayDeliveryChargesForList()}));
            }
            if (restaurant.getRating() <= 2.7f) {
                searchRestaurantViewHolder.vendorRateAvatar.setImageResource(R.drawable.ds_rating_okay);
                searchRestaurantViewHolder.vendorRateStatus.setText(R.string.rate_fair);
            } else if (restaurant.getRating() <= 3.7f) {
                searchRestaurantViewHolder.vendorRateAvatar.setImageResource(R.drawable.ds_rating_good);
                searchRestaurantViewHolder.vendorRateStatus.setText(R.string.rate_okay);
            } else if (restaurant.getRating() <= 4.5f) {
                searchRestaurantViewHolder.vendorRateAvatar.setImageResource(R.drawable.ds_rating_very_good);
                searchRestaurantViewHolder.vendorRateStatus.setText(R.string.rate_very_good);
            } else {
                searchRestaurantViewHolder.vendorRateAvatar.setImageResource(R.drawable.ds_rating_very_good_filled);
                ImageViewCompat.setImageTintList(searchRestaurantViewHolder.vendorRateAvatar, ColorStateList.valueOf(ContextCompat.getColor(this.f55328i, R.color.alert_100)));
                searchRestaurantViewHolder.vendorRateStatus.setText(R.string.rate_amazing);
            }
            if (restaurant.getRating() > 0.0f) {
                searchRestaurantViewHolder.vendorRateAvatar.setVisibility(0);
                searchRestaurantViewHolder.vendorRateStatus.setVisibility(0);
                if (restaurant.isNewRestaurant) {
                    searchRestaurantViewHolder.newTagImageView.setVisibility(0);
                } else {
                    searchRestaurantViewHolder.newTagImageView.setVisibility(8);
                }
            } else if (restaurant.isNewRestaurant) {
                searchRestaurantViewHolder.newTagImageView.setVisibility(0);
                searchRestaurantViewHolder.vendorRateStatus.setVisibility(8);
                searchRestaurantViewHolder.vendorRateAvatar.setVisibility(8);
            } else {
                searchRestaurantViewHolder.vendorRateAvatar.setVisibility(0);
                searchRestaurantViewHolder.vendorRateStatus.setVisibility(0);
                searchRestaurantViewHolder.newTagImageView.setVisibility(8);
            }
            searchRestaurantViewHolder.itemView.setOnClickListener(new g(this, restaurant, i12));
        } else if (viewHolder.getItemViewType() == 1) {
            final SearchDishViewHolder searchDishViewHolder = (SearchDishViewHolder) viewHolder;
            ArrayList<ItemSearchResponse> menuItem = this.f55329j.get(i12).getMenuItem();
            final Restaurant restaurant2 = this.f55329j.get(i12).getRestaurant();
            final ItemSearchResponse itemSearchResponse = menuItem.get(0);
            int itemCount = this.f55329j.get(i12).getItemCount();
            int i14 = restaurant2.statusType;
            if (i14 == 0) {
                searchDishViewHolder.f55326o.setVisibility(8);
            } else if (i14 == 5) {
                searchDishViewHolder.f55326o.setText(this.f55328i.getResources().getString(R.string.preorder));
                searchDishViewHolder.f55326o.setTextColor(Color.parseColor("#dd1608"));
                searchDishViewHolder.f55326o.setVisibility(0);
            } else if (i14 == 1) {
                searchDishViewHolder.f55326o.setText(this.f55328i.getResources().getString(R.string.closed_tgo));
                searchDishViewHolder.f55326o.setTextColor(Color.parseColor("#f10026"));
                searchDishViewHolder.f55326o.setVisibility(0);
            } else {
                searchDishViewHolder.f55326o.setText(this.f55328i.getResources().getString(R.string.busy_tgo));
                searchDishViewHolder.f55326o.setTextColor(Color.parseColor("#ff9f00"));
                searchDishViewHolder.f55326o.setVisibility(0);
            }
            if (TalabatUtils.isArabic()) {
                String str2 = itemSearchResponse.itemNameAr;
                if (str2 != null) {
                    if (str2.toLowerCase().contains(this.f55330k.toLowerCase())) {
                        int indexOf = itemSearchResponse.itemNameAr.toLowerCase().indexOf(this.f55330k.toLowerCase());
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(itemSearchResponse.itemNameAr);
                        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, this.f55330k.length() + indexOf, 33);
                        searchDishViewHolder.f55321j.setText(spannableStringBuilder);
                    } else {
                        searchDishViewHolder.f55321j.setText(itemSearchResponse.itemNameAr);
                    }
                } else if (itemSearchResponse.itemNameEn.toLowerCase().contains(this.f55330k.toLowerCase())) {
                    int indexOf2 = itemSearchResponse.itemNameEn.toLowerCase().indexOf(this.f55330k.toLowerCase());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(itemSearchResponse.itemNameEn);
                    spannableStringBuilder2.setSpan(new StyleSpan(1), indexOf2, this.f55330k.length() + indexOf2, 33);
                    searchDishViewHolder.f55321j.setText(spannableStringBuilder2);
                } else {
                    searchDishViewHolder.f55321j.setText(itemSearchResponse.itemNameEn);
                }
            } else {
                searchDishViewHolder.f55321j.setText(itemSearchResponse.itemNameEn);
                if (itemSearchResponse.itemNameEn.toLowerCase().contains(this.f55330k.toLowerCase())) {
                    int indexOf3 = itemSearchResponse.itemNameEn.toLowerCase().indexOf(this.f55330k.toLowerCase());
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(itemSearchResponse.itemNameEn);
                    spannableStringBuilder3.setSpan(new StyleSpan(1), indexOf3, this.f55330k.length() + indexOf3, 33);
                    searchDishViewHolder.f55321j.setText(spannableStringBuilder3);
                } else {
                    searchDishViewHolder.f55321j.setText(itemSearchResponse.itemNameEn);
                }
            }
            if (restaurant2.getName().length() > 29) {
                searchDishViewHolder.f55322k.setText(restaurant2.getName().substring(0, 29) + "...");
            } else {
                searchDishViewHolder.f55322k.setText(restaurant2.getName());
            }
            if (itemSearchResponse.itemPrice == 0.0f) {
                searchDishViewHolder.f55323l.setText(this.f55328i.getResources().getString(R.string.price_based_on_selection));
            } else {
                searchDishViewHolder.f55323l.setText(TalabatFormatter.getInstance().getFormattedCurrency(itemSearchResponse.itemPrice, true));
            }
            if (itemCount > 1) {
                searchDishViewHolder.f55324m.setText(String.format("+%d %s", new Object[]{Integer.valueOf(itemCount - 1), this.f55328i.getResources().getString(R.string.similar)}));
                searchDishViewHolder.f55325n.setVisibility(0);
            } else {
                searchDishViewHolder.f55325n.setVisibility(8);
            }
            if (itemSearchResponse.getItemImage() == null || TextUtils.isEmpty(itemSearchResponse.getItemImage().trim())) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) searchDishViewHolder.f55320i.getLayoutParams();
                layoutParams.setMargins(this.f55328i.getResources().getDimensionPixelOffset(R.dimen.margin_4dp), this.f55328i.getResources().getDimensionPixelOffset(R.dimen.margin_4dp), this.f55328i.getResources().getDimensionPixelOffset(R.dimen.margin_4dp), this.f55328i.getResources().getDimensionPixelOffset(R.dimen.margin_4dp));
                searchDishViewHolder.f55320i.setLayoutParams(layoutParams);
                if (restaurant2.getLogo() == null || !GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(this.f55328i)) {
                    searchDishViewHolder.f55320i.setImageResource(0);
                    searchDishViewHolder.f55320i.setVisibility(0);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(restaurant2.getLogo());
                    sb2.append(" restaurant ");
                    sb2.append(restaurant2.getName());
                    RequestOptions requestOptions = new RequestOptions();
                    Transformation[] transformationArr = {new RoundedCorners(this.f55328i.getResources().getDimensionPixelOffset(R.dimen.margin_8dp))};
                    GlideApp.with(this.f55328i).clear((View) searchDishViewHolder.f55320i);
                    GlideApp.with(this.f55328i).load(restaurant2.getLogo()).apply((BaseRequestOptions) (RequestOptions) requestOptions.transforms(transformationArr)).listener((RequestListener) new RequestListener<Drawable>() {
                        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                            String trim = restaurant2.getLogo().toString().trim();
                            if (!TalabatUtils.isNullOrEmpty(trim.substring(trim.lastIndexOf("/") + 1, trim.length()))) {
                                searchDishViewHolder.f55319h.setVisibility(0);
                            } else {
                                searchDishViewHolder.f55319h.setVisibility(8);
                                searchDishViewHolder.f55320i.setImageResource(0);
                                searchDishViewHolder.f55320i.setVisibility(0);
                            }
                            return false;
                        }

                        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                            searchDishViewHolder.f55319h.setVisibility(8);
                            return false;
                        }
                    }).placeholder((int) R.drawable.glide_placeholder).into(searchDishViewHolder.f55320i);
                }
            } else {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) searchDishViewHolder.f55320i.getLayoutParams();
                layoutParams2.setMargins(0, 0, 0, 0);
                searchDishViewHolder.f55320i.setLayoutParams(layoutParams2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(itemSearchResponse.getItemImage());
                sb3.append(" restaurant ");
                sb3.append(restaurant2.getName());
                RequestOptions requestOptions2 = (RequestOptions) new RequestOptions().transforms(new RoundedCorners(this.f55328i.getResources().getDimensionPixelOffset(R.dimen.margin_8dp)));
                if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(this.f55328i)) {
                    GlideApp.with(this.f55328i).clear((View) searchDishViewHolder.f55320i);
                    GlideApp.with(this.f55328i).load(itemSearchResponse.getItemImage()).apply((BaseRequestOptions) requestOptions2).listener((RequestListener) new RequestListener<Drawable>() {
                        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                            String trim = itemSearchResponse.getItemImage().trim();
                            if (!TalabatUtils.isNullOrEmpty(trim.substring(trim.lastIndexOf("/") + 1, trim.length()))) {
                                searchDishViewHolder.f55319h.setVisibility(0);
                            } else {
                                searchDishViewHolder.f55319h.setVisibility(8);
                                searchDishViewHolder.f55320i.setImageResource(0);
                                searchDishViewHolder.f55320i.setVisibility(0);
                            }
                            return false;
                        }

                        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                            searchDishViewHolder.f55319h.setVisibility(8);
                            return false;
                        }
                    }).placeholder((int) R.drawable.glide_placeholder).into(searchDishViewHolder.f55320i);
                }
            }
            searchDishViewHolder.itemView.setOnClickListener(new a(this, restaurant2, menuItem, i11, searchDishViewHolder, itemCount));
        }
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        if (i11 == 0) {
            return new SearchRestaurantViewHolder(LayoutInflater.from(this.f55328i).inflate(R.layout.item_search_restuarant, viewGroup, false));
        }
        if (i11 == 1) {
            return new SearchDishViewHolder(LayoutInflater.from(this.f55328i).inflate(R.layout.item_seach_dish, viewGroup, false));
        }
        if (i11 == 2) {
            return new SearchHeaderViewHolder(LayoutInflater.from(this.f55328i).inflate(R.layout.item_vendor_search_header, viewGroup, false));
        }
        if (i11 == 3) {
            return new SearchHeaderViewHolder(LayoutInflater.from(this.f55328i).inflate(R.layout.item_vendor_search_header, viewGroup, false));
        }
        return null;
    }

    public void setListener(onSearchResultClicked onsearchresultclicked) {
        this.f55331l = onsearchresultclicked;
    }

    public void setWrapperClasses(ArrayList<RestaurantsSearchWrapperClass> arrayList, String str) {
        this.f55329j = arrayList;
        this.f55330k = str;
        notifyDataSetChanged();
    }
}
