package com.adyen.checkout.ui.internal.common.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.ui.R;
import java.util.List;

public final class Adapter<T> extends BaseAdapter implements Filterable {
    /* access modifiers changed from: private */
    public List<T> mItems;
    /* access modifiers changed from: private */
    public final TextDelegate<T> mTextDelegate;
    private final boolean mUsePaddingInGetView;
    private ViewCustomizationDelegate mViewCustomizationDelegate;

    public interface TextDelegate<T> {
        @NonNull
        String getText(@NonNull T t11);
    }

    public interface ViewCustomizationDelegate {
        void customizeView(@NonNull CheckedTextView checkedTextView);
    }

    private Adapter(boolean z11, @NonNull TextDelegate<T> textDelegate) {
        this.mUsePaddingInGetView = z11;
        this.mTextDelegate = textDelegate;
    }

    private void bindView(@NonNull T t11, @NonNull View view) {
        ((TextView) view).setText(this.mTextDelegate.getText(t11));
    }

    @NonNull
    private View createViewWithPadding(@NonNull ViewGroup viewGroup, boolean z11) {
        int i11;
        Context context = viewGroup.getContext();
        if (z11) {
            i11 = context.getResources().getDimensionPixelSize(R.dimen.standard_margin);
        } else {
            i11 = 0;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_dropdown, viewGroup, false);
        inflate.setPadding(i11, i11, i11, i11);
        ViewCustomizationDelegate viewCustomizationDelegate = this.mViewCustomizationDelegate;
        if (viewCustomizationDelegate != null) {
            viewCustomizationDelegate.customizeView((CheckedTextView) inflate);
        }
        return inflate;
    }

    @NonNull
    public static <T> Adapter<T> forAutoCompleteTextView(@NonNull TextDelegate<T> textDelegate) {
        return new Adapter<>(true, textDelegate);
    }

    @NonNull
    public static <T> Adapter<T> forSpinner(@NonNull TextDelegate<T> textDelegate) {
        return new Adapter<>(false, textDelegate);
    }

    @NonNull
    private View getViewInternal(int i11, @Nullable View view, @NonNull ViewGroup viewGroup, boolean z11) {
        if (view == null) {
            view = createViewWithPadding(viewGroup, z11);
        }
        bindView(getItem(i11), view);
        return view;
    }

    public int getCount() {
        List<T> list = this.mItems;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @NonNull
    public View getDropDownView(int i11, @Nullable View view, @NonNull ViewGroup viewGroup) {
        return getViewInternal(i11, view, viewGroup, true);
    }

    @NonNull
    public Filter getFilter() {
        return new Filter() {
            public CharSequence convertResultToString(@NonNull Object obj) {
                return Adapter.this.mTextDelegate.getText(obj);
            }

            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                int i11;
                List b11 = Adapter.this.mItems;
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (b11 != null) {
                    i11 = b11.size();
                } else {
                    i11 = 0;
                }
                filterResults.count = i11;
                filterResults.values = b11;
                return filterResults;
            }

            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                Adapter.this.notifyDataSetChanged();
            }
        };
    }

    @NonNull
    public T getItem(int i11) {
        return this.mItems.get(i11);
    }

    public long getItemId(int i11) {
        return 0;
    }

    @NonNull
    public View getView(int i11, @Nullable View view, @NonNull ViewGroup viewGroup) {
        return getViewInternal(i11, view, viewGroup, this.mUsePaddingInGetView);
    }

    public void setItems(@Nullable List<T> list) {
        List<T> list2 = this.mItems;
        if ((list2 != null && !list2.isEmpty()) || (list != null && !list.isEmpty())) {
            List<T> list3 = this.mItems;
            if (list3 == null || !list3.equals(list)) {
                this.mItems = list;
                notifyDataSetChanged();
            }
        }
    }

    public void setViewCustomizationDelegate(@Nullable ViewCustomizationDelegate viewCustomizationDelegate) {
        this.mViewCustomizationDelegate = viewCustomizationDelegate;
    }
}
