package com.talabat.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.talabat.R;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.designhelpers.LoadingHelper.BallPulseIndicator;
import com.talabat.designhelpers.LoadingHelper.Indicator;
import com.talabat.designhelpers.LoadingHelper.LoadingIndicatorView;
import com.talabat.designhelpers.Utils;
import com.talabat.lib.Integration;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.helpers.TalabatGlideModule;
import datamodels.CartMenuItem;
import datamodels.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    /* renamed from: i  reason: collision with root package name */
    public Context f55100i;

    /* renamed from: j  reason: collision with root package name */
    public List<MenuItem> f55101j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f55102k;

    /* renamed from: l  reason: collision with root package name */
    public MenuItemsFilter f55103l = new MenuItemsFilter(this);

    /* renamed from: m  reason: collision with root package name */
    public List<MenuItem> f55104m;
    /* access modifiers changed from: private */
    public OnClickedListener mClickListener;

    /* renamed from: n  reason: collision with root package name */
    public BallPulseIndicator f55105n;

    public class MenuItemsFilter extends Filter {
        private MenuAdapter mAdapter;

        private MenuItemsFilter(MenuAdapter menuAdapter) {
            this.mAdapter = menuAdapter;
        }

        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            MenuAdapter.this.f55104m.clear();
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence.length() == 0) {
                MenuAdapter menuAdapter = MenuAdapter.this;
                menuAdapter.f55104m.addAll(menuAdapter.f55101j);
            } else {
                String[] split = charSequence.toString().split(" ");
                for (MenuItem next : MenuAdapter.this.f55101j) {
                    int length = split.length;
                    boolean z11 = false;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            z11 = true;
                            break;
                        }
                        if (!next.f13862name.toLowerCase().contains(split[i11].toLowerCase())) {
                            break;
                        }
                        i11++;
                    }
                    if (z11) {
                        MenuAdapter.this.f55104m.add(next);
                    }
                }
            }
            List<MenuItem> list = MenuAdapter.this.f55104m;
            filterResults.values = list;
            filterResults.count = list.size();
            return filterResults;
        }

        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (filterResults.count == 0) {
                MenuAdapter.this.mClickListener.showEmptyScreen(true);
                return;
            }
            MenuAdapter.this.mClickListener.showEmptyScreen(false);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f55115h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f55116i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55117j;

        /* renamed from: k  reason: collision with root package name */
        public ImageView f55118k;

        /* renamed from: l  reason: collision with root package name */
        public ProgressBar f55119l;

        /* renamed from: m  reason: collision with root package name */
        public ImageView f55120m;

        /* renamed from: n  reason: collision with root package name */
        public TextView f55121n;

        /* renamed from: o  reason: collision with root package name */
        public TextView f55122o;

        /* renamed from: p  reason: collision with root package name */
        public TextView f55123p;

        /* renamed from: q  reason: collision with root package name */
        public RelativeLayout f55124q;

        /* renamed from: r  reason: collision with root package name */
        public LoadingIndicatorView f55125r;

        /* renamed from: s  reason: collision with root package name */
        public View f55126s;

        /* renamed from: t  reason: collision with root package name */
        public View f55127t;

        /* renamed from: u  reason: collision with root package name */
        public View f55128u;

        /* renamed from: v  reason: collision with root package name */
        public View f55129v;

        public MenuViewHolder(View view) {
            super(view);
            this.f55115h = (TextView) view.findViewById(R.id.itemName);
            this.f55116i = (TextView) view.findViewById(R.id.itemDescription);
            this.f55117j = (TextView) view.findViewById(R.id.itemPrice);
            this.f55118k = (ImageView) view.findViewById(R.id.itemImg);
            this.f55119l = (ProgressBar) view.findViewById(R.id.progress);
            this.f55120m = (ImageView) view.findViewById(R.id.discountIc);
            this.f55121n = (TextView) view.findViewById(R.id.priceExtraInfo);
            this.f55122o = (TextView) view.findViewById(R.id.priceBefore);
            this.f55124q = (RelativeLayout) view.findViewById(R.id.rootView);
            this.f55125r = (LoadingIndicatorView) view.findViewById(R.id.loading_price);
            this.f55126s = view.findViewById(R.id.image_holder);
            this.f55127t = view.findViewById(R.id.price_view);
            this.f55128u = view.findViewById(R.id.view_separator);
            this.f55129v = view.findViewById(R.id.item_added_indicator);
            this.f55123p = (TextView) view.findViewById(R.id.item_quantity);
        }
    }

    public interface OnClickedListener {
        void onCartIconClicked(int i11, ImageView imageView);

        void onMenuImageClicked(int i11, ImageView imageView);

        void onMenuItemClicked(int i11, ImageView imageView);

        void showEmptyScreen(boolean z11);
    }

    public MenuAdapter(Context context, boolean z11) {
        this.f55100i = context;
        this.f55102k = z11;
    }

    private int getItemQuantityFromCart(MenuItem menuItem) {
        int i11 = 0;
        if (!Cart.getInstance().hasItems()) {
            return 0;
        }
        Iterator<CartMenuItem> it = Cart.getInstance().getCartItems().iterator();
        while (it.hasNext()) {
            CartMenuItem next = it.next();
            if (menuItem.f13862name.equals(next.f13862name) && menuItem.f13861id == next.f13861id) {
                i11 += next.getQuantity();
            }
        }
        return i11;
    }

    public Filter getFilter() {
        return this.f55103l;
    }

    public int getItemCount() {
        return this.f55104m.size();
    }

    public List<MenuItem> getMenuList() {
        return this.f55104m;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        final MenuViewHolder menuViewHolder = (MenuViewHolder) viewHolder;
        MenuItem menuItem = this.f55104m.get(i11);
        menuViewHolder.f55125r.setIndicator((Indicator) this.f55105n);
        menuViewHolder.f55125r.show();
        menuViewHolder.f55115h.setText(menuItem.f13862name);
        if (i11 == 0) {
            menuViewHolder.f55128u.setVisibility(8);
        } else {
            menuViewHolder.f55128u.setVisibility(0);
        }
        if (menuItem.desc.equals("")) {
            menuViewHolder.f55116i.setVisibility(8);
        } else {
            menuViewHolder.f55116i.setText(menuItem.desc);
            menuViewHolder.f55116i.setVisibility(0);
        }
        if (this.f55102k) {
            menuViewHolder.f55120m.setVisibility(0);
        } else {
            menuViewHolder.f55120m.setVisibility(8);
        }
        int itemQuantityFromCart = getItemQuantityFromCart(menuItem);
        if (itemQuantityFromCart > 0) {
            menuViewHolder.f55129v.setVisibility(0);
            menuViewHolder.f55123p.setVisibility(0);
            menuViewHolder.f55123p.setText(String.format(Locale.US, this.f55100i.getString(R.string.quantity_text), new Object[]{Integer.valueOf(itemQuantityFromCart)}));
        } else {
            menuViewHolder.f55129v.setVisibility(8);
            menuViewHolder.f55123p.setVisibility(8);
        }
        if (menuItem.getDisplayPrice().equals("0")) {
            menuViewHolder.f55121n.setVisibility(0);
            menuViewHolder.f55121n.setText(this.f55100i.getString(R.string.price_based_on_selection));
            menuViewHolder.f55127t.setVisibility(8);
            menuViewHolder.f55122o.setVisibility(8);
            menuViewHolder.f55125r.setVisibility(8);
            menuViewHolder.f55125r.hide();
        } else {
            menuViewHolder.f55127t.setVisibility(0);
            menuViewHolder.f55122o.setVisibility(8);
            menuViewHolder.f55121n.setVisibility(8);
            menuViewHolder.f55117j.setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.price, true));
            if (menuItem.isDiscounted()) {
                if (Integration.isGemActive()) {
                    menuViewHolder.f55122o.setVisibility(8);
                    menuViewHolder.f55117j.setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.oldPrice, true));
                } else {
                    menuViewHolder.f55122o.setVisibility(0);
                    menuViewHolder.f55122o.setText(menuItem.getDisplayOldPriceNonFormatted());
                    menuViewHolder.f55122o.setPaintFlags(menuViewHolder.f55121n.getPaintFlags() | 16);
                }
            }
        }
        menuViewHolder.f55118k.setTag(R.id.itemImg, Integer.valueOf(i11));
        if (menuItem.hasThumbnail) {
            menuViewHolder.f55126s.setVisibility(0);
            menuViewHolder.f55118k.getLayoutParams().height = Utils.dpToPixel(100, this.f55100i);
            menuViewHolder.f55118k.getLayoutParams().width = Utils.dpToPixel(110, this.f55100i);
            menuViewHolder.f55118k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int i11;
                    try {
                        i11 = ((Integer) view.getTag(R.id.itemImg)).intValue();
                    } catch (Exception unused) {
                        i11 = 0;
                    }
                    if (MenuAdapter.this.mClickListener != null) {
                        MenuAdapter.this.mClickListener.onMenuImageClicked(i11, menuViewHolder.f55118k);
                    }
                }
            });
            if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(this.f55100i)) {
                GlideApp.with(this.f55100i).clear((View) menuViewHolder.f55118k);
                GlideApp.with(this.f55100i).load(menuItem.getThumbnail()).listener((RequestListener) new RequestListener<Drawable>() {
                    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                        menuViewHolder.f55118k.setImageResource(R.drawable.placeholder);
                        menuViewHolder.f55119l.setVisibility(8);
                        menuViewHolder.f55118k.setVisibility(0);
                        return false;
                    }

                    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                        menuViewHolder.f55119l.setVisibility(8);
                        menuViewHolder.f55118k.setVisibility(0);
                        return false;
                    }
                }).apply(TalabatGlideModule.requestOptions().transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCorners(this.f55100i.getResources().getDimensionPixelSize(R.dimen.card_corner_radius))})).into(menuViewHolder.f55118k);
            }
        } else {
            menuViewHolder.f55126s.setVisibility(8);
            menuViewHolder.f55119l.setVisibility(8);
            menuViewHolder.f55118k.setVisibility(8);
        }
        menuViewHolder.f55117j.setTag(Integer.valueOf(i11));
        menuViewHolder.f55117j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (MenuAdapter.this.mClickListener != null) {
                    MenuAdapter.this.mClickListener.onCartIconClicked(intValue, menuViewHolder.f55118k);
                }
            }
        });
        menuViewHolder.f55124q.setTag(Integer.valueOf(i11));
        menuViewHolder.f55124q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (MenuAdapter.this.mClickListener != null) {
                    MenuAdapter.this.mClickListener.onMenuItemClicked(intValue, menuViewHolder.f55118k);
                }
            }
        });
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        this.f55105n = new BallPulseIndicator();
        return new MenuViewHolder(LayoutInflater.from(this.f55100i).inflate(R.layout.countinuous_section_item_right_image_relative, viewGroup, false));
    }

    public void setClickListener(OnClickedListener onClickedListener) {
        this.mClickListener = onClickedListener;
    }

    public void setMenu(List<MenuItem> list) {
        this.f55101j = list;
        ArrayList arrayList = new ArrayList();
        this.f55104m = arrayList;
        arrayList.addAll(this.f55101j);
        notifyDataSetChanged();
    }
}
