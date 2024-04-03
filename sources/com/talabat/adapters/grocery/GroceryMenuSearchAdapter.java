package com.talabat.adapters.grocery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.designhelpers.LoadingHelper.BallPulseIndicator;
import com.talabat.designhelpers.LoadingHelper.Indicator;
import com.talabat.designhelpers.LoadingHelper.LoadingIndicatorView;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.lib.Integration;
import com.talabat.talabatcommon.helpers.GlideApp;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.MenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;
import tracking.ScreenNames;

public class GroceryMenuSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    /* renamed from: i  reason: collision with root package name */
    public Context f55243i;

    /* renamed from: j  reason: collision with root package name */
    public List<MenuItem> f55244j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f55245k;

    /* renamed from: l  reason: collision with root package name */
    public List<MenuItem> f55246l;

    /* renamed from: m  reason: collision with root package name */
    public BallPulseIndicator f55247m;
    /* access modifiers changed from: private */
    public OnClickedListener mClickListener;

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f55251h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f55252i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55253j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f55254k;

        /* renamed from: l  reason: collision with root package name */
        public TextView f55255l;

        /* renamed from: m  reason: collision with root package name */
        public TextView f55256m;

        /* renamed from: n  reason: collision with root package name */
        public ImageView f55257n;

        /* renamed from: o  reason: collision with root package name */
        public ProgressBar f55258o;

        /* renamed from: p  reason: collision with root package name */
        public RelativeLayout f55259p;

        /* renamed from: q  reason: collision with root package name */
        public View f55260q;

        /* renamed from: r  reason: collision with root package name */
        public View f55261r;

        /* renamed from: s  reason: collision with root package name */
        public View f55262s;

        /* renamed from: t  reason: collision with root package name */
        public View f55263t;

        /* renamed from: u  reason: collision with root package name */
        public View f55264u;

        /* renamed from: v  reason: collision with root package name */
        public LoadingIndicatorView f55265v;

        /* renamed from: w  reason: collision with root package name */
        public TalabatButton f55266w;

        public MenuViewHolder(View view) {
            super(view);
            this.f55253j = (TextView) view.findViewById(R.id.itemName);
            this.f55254k = (TextView) view.findViewById(R.id.itemDescription);
            this.f55255l = (TextView) view.findViewById(R.id.itemPrice);
            this.f55257n = (ImageView) view.findViewById(R.id.itemImg);
            this.f55258o = (ProgressBar) view.findViewById(R.id.progress);
            this.f55259p = (RelativeLayout) view.findViewById(R.id.discountIc);
            this.f55251h = (TextView) view.findViewById(R.id.priceExtraInfo);
            this.f55252i = (TextView) view.findViewById(R.id.priceBefore);
            this.f55265v = (LoadingIndicatorView) view.findViewById(R.id.loading_price);
            this.f55266w = (TalabatButton) view.findViewById(R.id.add_item);
            this.f55260q = view.findViewById(R.id.price_section);
            this.f55261r = view.findViewById(R.id.rootView);
            this.f55262s = view.findViewById(R.id.quantity_section);
            this.f55263t = view.findViewById(R.id.decrease_qty);
            this.f55264u = view.findViewById(R.id.increase_qty);
            this.f55256m = (TextView) view.findViewById(R.id.quantity_text);
        }
    }

    public interface OnClickedListener {
        void goToCart();

        void onCartIconClicked(int i11, ImageView imageView, String str);

        void onMaxCartItemsReached();

        void onMenuImageClicked(MenuItem menuItem, ImageView imageView);

        void onMenuItemClicked(MenuItem menuItem, ImageView imageView);

        void onQuantityDecreased();

        void onQuantityIncreased();

        void showEmptyScreen(boolean z11);
    }

    public GroceryMenuSearchAdapter(Context context, boolean z11) {
        this.f55243i = context;
        this.f55245k = z11;
    }

    private void decreaseQuantity(MenuItem menuItem, View view, Button button, TextView textView) {
        CartMenuItem cartMenuItem;
        Cart instance = Cart.getInstance();
        CartMenuItem cartMenuItem2 = new CartMenuItem();
        Iterator<CartMenuItem> it = instance.getCartItems().iterator();
        loop0:
        while (true) {
            cartMenuItem = cartMenuItem2;
            while (it.hasNext()) {
                cartMenuItem2 = it.next();
                if (menuItem.f13861id == cartMenuItem2.f13861id) {
                    cartMenuItem2.setQuantity(cartMenuItem2.getQuantity() - 1);
                    int quantity = cartMenuItem2.getQuantity();
                    if (quantity < 1) {
                        view.setVisibility(8);
                        button.setVisibility(0);
                    } else {
                        textView.setText(quantity + "");
                    }
                }
            }
            break loop0;
        }
        if (cartMenuItem.f13861id > 0) {
            instance.decreaseItemQuantity(cartMenuItem, this.f55243i);
            AppTracker.onItemRemovedFromCart(this.f55243i, Cart.getInstance().getRestaurant(), cartMenuItem, "menu_decrease", ScreenNames.getScreenType(ScreenNames.GROCERYMENU_SEARCH), ScreenNames.GROCERYMENU_SEARCH);
            OnClickedListener onClickedListener = this.mClickListener;
            if (onClickedListener != null) {
                onClickedListener.onQuantityDecreased();
            }
        }
    }

    private String getChoicesString(ArrayList<ChoiceSection> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() == 0) {
            return "";
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<ChoiceItem> it2 = it.next().itemChoices.iterator();
            while (it2.hasNext()) {
                ChoiceItem next = it2.next();
                if (sb2.length() > 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(next.f13840name);
            }
        }
        return sb2.toString();
    }

    private void increaseQuantity(MenuItem menuItem, View view, Button button, TextView textView) {
        String str;
        Cart instance = Cart.getInstance();
        CartMenuItem cartMenuItem = new CartMenuItem();
        Iterator<CartMenuItem> it = instance.getCartItems().iterator();
        CartMenuItem cartMenuItem2 = cartMenuItem;
        boolean z11 = false;
        while (it.hasNext()) {
            CartMenuItem next = it.next();
            if (menuItem.f13861id == next.f13861id) {
                int quantity = next.getQuantity();
                if (instance.getCartItemQuantity(next) < 100) {
                    next.setQuantity(quantity + 1);
                    textView.setText(next.getQuantity() + "");
                    z11 = false;
                    cartMenuItem2 = next;
                } else {
                    TextView textView2 = textView;
                    cartMenuItem2 = next;
                    z11 = true;
                }
            } else {
                TextView textView3 = textView;
            }
        }
        if (z11) {
            OnClickedListener onClickedListener = this.mClickListener;
            if (onClickedListener != null) {
                onClickedListener.onMaxCartItemsReached();
            }
        } else if (cartMenuItem2.f13861id > 0) {
            instance.increaseItemQuantity(cartMenuItem2, this.f55243i);
            ArrayList<ChoiceSection> arrayList = cartMenuItem2.selectedChoices;
            if (arrayList != null) {
                str = getChoicesString(arrayList);
            } else {
                str = "";
            }
            AppTracker.onItemAddedToCart(this.f55243i, Cart.getInstance().getRestaurant(), cartMenuItem2, AppTracker.getRestaurantId(GlobalDataModel.SELECTED.restaurant), AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant), "menu_increase", str, cartMenuItem2.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], cartMenuItem2.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], "shop_details", ScreenNames.GROCERYMENU_SEARCH);
            OnClickedListener onClickedListener2 = this.mClickListener;
            if (onClickedListener2 != null) {
                onClickedListener2.onQuantityIncreased();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(MenuViewHolder menuViewHolder, MenuItem menuItem, View view) {
        OnClickedListener onClickedListener;
        try {
            if (menuViewHolder.f55257n.getDrawable().getConstantState() != ContextCompat.getDrawable(this.f55243i, R.drawable.placeholder_grocery).getConstantState() && (onClickedListener = this.mClickListener) != null) {
                onClickedListener.onMenuImageClicked(menuItem, menuViewHolder.f55257n);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$1(MenuItem menuItem, MenuViewHolder menuViewHolder, View view) {
        OnClickedListener onClickedListener = this.mClickListener;
        if (onClickedListener != null) {
            onClickedListener.onMenuItemClicked(menuItem, menuViewHolder.f55257n);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$2(int i11, MenuViewHolder menuViewHolder, MenuItem menuItem, View view) {
        OnClickedListener onClickedListener = this.mClickListener;
        if (onClickedListener != null) {
            onClickedListener.onCartIconClicked(i11, menuViewHolder.f55257n, "menu_normal");
            if (GlobalDataModel.MENU.isQuickAddEnabled) {
                setCount(menuItem, menuViewHolder.f55262s, menuViewHolder.f55266w, menuViewHolder.f55256m);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$3(MenuItem menuItem, MenuViewHolder menuViewHolder, View view) {
        if (menuItem.choiceSections.length > 0 || menuItem.willHaveChoices()) {
            OnClickedListener onClickedListener = this.mClickListener;
            if (onClickedListener != null) {
                onClickedListener.goToCart();
                return;
            }
            return;
        }
        decreaseQuantity(menuItem, menuViewHolder.f55262s, menuViewHolder.f55266w, menuViewHolder.f55256m);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$4(MenuItem menuItem, int i11, MenuViewHolder menuViewHolder, View view) {
        if (menuItem.choiceSections.length > 0 || menuItem.willHaveChoices()) {
            OnClickedListener onClickedListener = this.mClickListener;
            if (onClickedListener != null) {
                onClickedListener.onCartIconClicked(i11, menuViewHolder.f55257n, "menu_increase");
                return;
            }
            return;
        }
        increaseQuantity(menuItem, menuViewHolder.f55262s, menuViewHolder.f55266w, menuViewHolder.f55256m);
    }

    private void setCount(MenuItem menuItem, View view, Button button, TextView textView) {
        if (!Cart.getInstance().hasItems()) {
            view.setVisibility(8);
            button.setVisibility(0);
            return;
        }
        Iterator<CartMenuItem> it = Cart.getInstance().getCartItems().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            CartMenuItem next = it.next();
            if (menuItem.f13862name.equals(next.f13862name) && menuItem.f13861id == next.f13861id) {
                i11 += next.getQuantity();
            }
        }
        if (i11 > 0) {
            view.setVisibility(0);
            button.setVisibility(8);
            textView.setText(i11 + "");
            return;
        }
        view.setVisibility(8);
        button.setVisibility(0);
    }

    public List<MenuItem> getExistingList() {
        return this.f55244j;
    }

    public Filter getFilter() {
        return new Filter() {
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                ArrayList arrayList = new ArrayList();
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (charSequence.length() == 0) {
                    arrayList.addAll(GroceryMenuSearchAdapter.this.f55244j);
                } else {
                    for (MenuItem next : GroceryMenuSearchAdapter.this.f55244j) {
                        if (next.f13862name.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                            arrayList.add(next);
                        }
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
                return filterResults;
            }

            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                if (filterResults.count == 0) {
                    GroceryMenuSearchAdapter.this.mClickListener.showEmptyScreen(true);
                    return;
                }
                GroceryMenuSearchAdapter.this.mClickListener.showEmptyScreen(false);
                GroceryMenuSearchAdapter.this.f55246l.clear();
                GroceryMenuSearchAdapter.this.f55246l.addAll((List) filterResults.values);
                GroceryMenuSearchAdapter.this.notifyDataSetChanged();
            }
        };
    }

    public int getItemCount() {
        return this.f55246l.size();
    }

    public List<MenuItem> getMenuList() {
        return this.f55246l;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        final MenuViewHolder menuViewHolder = (MenuViewHolder) viewHolder;
        menuViewHolder.setIsRecyclable(false);
        MenuItem menuItem = this.f55246l.get(i11);
        menuViewHolder.f55265v.setIndicator((Indicator) this.f55247m);
        menuViewHolder.f55265v.show();
        menuViewHolder.f55253j.setText(menuItem.f13862name);
        if (menuItem.desc.equals("")) {
            menuViewHolder.f55254k.setVisibility(8);
        } else {
            menuViewHolder.f55254k.setText(menuItem.desc);
            menuViewHolder.f55254k.setVisibility(8);
        }
        if (this.f55245k) {
            menuViewHolder.f55259p.setVisibility(0);
        } else {
            menuViewHolder.f55259p.setVisibility(8);
        }
        if (menuItem.getDisplayPrice().equals("0")) {
            menuViewHolder.f55251h.setVisibility(0);
            menuViewHolder.f55251h.setText(this.f55243i.getString(R.string.price_based_on_selection));
            menuViewHolder.f55255l.setVisibility(8);
            menuViewHolder.f55252i.setVisibility(8);
        } else {
            menuViewHolder.f55251h.setVisibility(8);
            menuViewHolder.f55255l.setVisibility(0);
            menuViewHolder.f55255l.setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.price, true));
            menuViewHolder.f55252i.setVisibility(8);
            if (menuItem.isDiscounted()) {
                if (Integration.isGemActive()) {
                    menuViewHolder.f55255l.setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.oldPrice, true));
                    menuViewHolder.f55252i.setVisibility(8);
                } else {
                    menuViewHolder.f55252i.setVisibility(0);
                    menuViewHolder.f55252i.setText(menuItem.getDisplayOldPriceNonFormatted());
                    menuViewHolder.f55252i.setPaintFlags(menuViewHolder.f55251h.getPaintFlags() | 16);
                }
            }
        }
        if (menuItem.hasThumbnail) {
            menuViewHolder.f55257n.setOnClickListener(new a(this, menuViewHolder, menuItem));
            if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(this.f55243i)) {
                GlideApp.with(this.f55243i).clear((View) menuViewHolder.f55257n);
                GlideApp.with(this.f55243i).load(menuItem.getThumbnail()).centerInside().listener((RequestListener) new RequestListener<Drawable>() {
                    public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                        menuViewHolder.f55257n.setImageResource(R.drawable.placeholder_grocery);
                        menuViewHolder.f55258o.setVisibility(8);
                        return false;
                    }

                    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                        menuViewHolder.f55258o.setVisibility(8);
                        return false;
                    }
                }).into(menuViewHolder.f55257n);
            }
        } else {
            menuViewHolder.f55257n.setImageResource(R.drawable.placeholder_grocery);
            menuViewHolder.f55258o.setVisibility(8);
            menuViewHolder.f55257n.setVisibility(0);
        }
        menuViewHolder.f55261r.setOnClickListener(new b(this, menuItem, menuViewHolder));
        menuViewHolder.f55260q.setTag(Integer.valueOf(i11));
        if (GlobalDataModel.MENU.isQuickAddEnabled) {
            setCount(menuItem, menuViewHolder.f55262s, menuViewHolder.f55266w, menuViewHolder.f55256m);
        }
        menuViewHolder.f55266w.setOnClickListener(new c(this, i11, menuViewHolder, menuItem));
        menuViewHolder.f55263t.setOnClickListener(new d(this, menuItem, menuViewHolder));
        menuViewHolder.f55264u.setOnClickListener(new e(this, menuItem, i11, menuViewHolder));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        this.f55247m = new BallPulseIndicator();
        return new MenuViewHolder(LayoutInflater.from(this.f55243i).inflate(R.layout.grocery_grid_view_item, viewGroup, false));
    }

    public void setClickListener(OnClickedListener onClickedListener) {
        this.mClickListener = onClickedListener;
    }

    public void setMenu(List<MenuItem> list) {
        ArrayList arrayList = new ArrayList();
        this.f55244j = arrayList;
        arrayList.addAll(list);
        ArrayList arrayList2 = new ArrayList();
        this.f55246l = arrayList2;
        arrayList2.addAll(this.f55244j);
        notifyDataSetChanged();
    }
}
