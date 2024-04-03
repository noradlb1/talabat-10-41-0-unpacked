package com.talabat.adapters.restaurantslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bf.b;
import com.talabat.R;
import java.util.ArrayList;
import java.util.Iterator;

public class RecentSearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    /* renamed from: i  reason: collision with root package name */
    public OnRecentSearchClick f55298i;
    private Context mContext;
    /* access modifiers changed from: private */
    public ArrayList<String> mRecentList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<String> mTempRecentList = new ArrayList<>();

    public interface OnRecentSearchClick {
        void recentSearchClick(String str);
    }

    public class RecentViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f55300h;

        public RecentViewHolder(View view) {
            super(view);
            this.f55300h = (TextView) view.findViewById(R.id.textView_recent);
        }
    }

    public RecentSearchAdapter(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(String str, View view) {
        OnRecentSearchClick onRecentSearchClick = this.f55298i;
        if (onRecentSearchClick != null) {
            onRecentSearchClick.recentSearchClick(str);
        }
    }

    public Filter getFilter() {
        return new Filter() {
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                String charSequence2 = charSequence.toString();
                Filter.FilterResults filterResults = new Filter.FilterResults();
                ArrayList arrayList = new ArrayList();
                if (RecentSearchAdapter.this.mTempRecentList != null) {
                    Iterator it = RecentSearchAdapter.this.mTempRecentList.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (str.contains(charSequence2)) {
                            arrayList.add(str);
                        }
                    }
                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                }
                return filterResults;
            }

            public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                if (filterResults.count > 0) {
                    RecentSearchAdapter recentSearchAdapter = RecentSearchAdapter.this;
                    recentSearchAdapter.mRecentList = recentSearchAdapter.mTempRecentList;
                }
            }
        };
    }

    public int getItemCount() {
        return this.mRecentList.size();
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i11) {
        RecentViewHolder recentViewHolder = (RecentViewHolder) viewHolder;
        String str = this.mRecentList.get(i11);
        recentViewHolder.f55300h.setText(str);
        recentViewHolder.itemView.setOnClickListener(new b(this, str));
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return new RecentViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.item_recent_search, viewGroup, false));
    }

    public void setListener(OnRecentSearchClick onRecentSearchClick) {
        this.f55298i = onRecentSearchClick;
    }

    public void setRecentList(ArrayList<String> arrayList) {
        this.mRecentList = arrayList;
        this.mTempRecentList.clear();
        this.mTempRecentList.addAll(arrayList);
        notifyDataSetChanged();
    }
}
