package com.talabat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.adapters.RequiredItemAdapters;
import com.talabat.helpers.OptionalItemLayout;
import com.talabat.helpers.RequiredItemLayout;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;

public class ItemChoicesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RequiredItemAdapters.OnItemSelectedListener, RequiredItemLayout.OnItemSelectedListener {
    private static final int TYPE_OPTIONAL = 2;
    private static final int TYPE_REQUIRED = 1;

    /* renamed from: i  reason: collision with root package name */
    public Context f55086i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<ChoiceSection> f55087j;

    /* renamed from: k  reason: collision with root package name */
    public RequiredItemAdapters.OnItemSelectedListener f55088k;

    /* renamed from: l  reason: collision with root package name */
    public RequiredItemLayout.OnItemSelectedListener f55089l;

    /* renamed from: m  reason: collision with root package name */
    public ArrayList<Integer> f55090m = new ArrayList<>();

    public class OptionalItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public OptionalItemLayout f55091h;

        public OptionalItemViewHolder(View view) {
            super(view);
            this.f55091h = (OptionalItemLayout) view.findViewById(R.id.optionalItemLayout);
        }
    }

    public class RequiredItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public RequiredItemLayout f55093h;

        public RequiredItemViewHolder(View view) {
            super(view);
            this.f55093h = (RequiredItemLayout) view.findViewById(R.id.requiredItemLayout);
        }
    }

    public ItemChoicesAdapter(Context context) {
        this.f55086i = context;
    }

    public int getItemCount() {
        return this.f55087j.size();
    }

    public int getItemViewType(int i11) {
        if (this.f55087j.get(i11).maxQuantity > 1 || !this.f55087j.get(i11).isMandatoryChoiceSection()) {
            return 2;
        }
        return 1;
    }

    public ChoiceSection getSelectedChoicesByIDs(int i11) {
        return this.f55089l.getSelectedChoicesByIDs(i11);
    }

    public boolean isChoiceItemSelected(int i11, int i12) {
        return this.f55088k.isChoiceItemSelected(i11, i12);
    }

    public void itemSelectionChanged(ChoiceItem choiceItem, boolean z11) {
        this.f55088k.itemSelectionChanged(choiceItem, z11);
    }

    public void itemSelectionChangedPriceChange(ChoiceItem choiceItem, boolean z11) {
        this.f55089l.itemSelectionChangedPriceChange(choiceItem, z11);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        ChoiceSection choiceSection = this.f55087j.get(i11);
        if (viewHolder.getItemViewType() == 1) {
            RequiredItemViewHolder requiredItemViewHolder = (RequiredItemViewHolder) viewHolder;
            requiredItemViewHolder.f55093h.setOnItemSelectedListener(this);
            requiredItemViewHolder.f55093h.setChoiceSection(choiceSection, i11);
            requiredItemViewHolder.f55093h.setRequiredError(this.f55090m.contains(Integer.valueOf(i11)));
        } else if (viewHolder.getItemViewType() == 2) {
            OptionalItemViewHolder optionalItemViewHolder = (OptionalItemViewHolder) viewHolder;
            optionalItemViewHolder.f55091h.setMultipleItemsSelectorListener(this);
            optionalItemViewHolder.f55091h.setChoiceSection(choiceSection, i11);
            optionalItemViewHolder.f55091h.setRequiredError(this.f55090m.contains(Integer.valueOf(i11)));
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == 1) {
            return new RequiredItemViewHolder(LayoutInflater.from(this.f55086i).inflate(R.layout.item_holder_required, viewGroup, false));
        }
        if (i11 == 2) {
            return new OptionalItemViewHolder(LayoutInflater.from(this.f55086i).inflate(R.layout.item_holder_optional, viewGroup, false));
        }
        return null;
    }

    public void onThirdLevelChoiceAvailable(String str, ArrayList<Integer> arrayList) {
        this.f55089l.onThirdLevelChoiceAvailable(str, arrayList);
    }

    public void setChoiceItems(ArrayList<ChoiceSection> arrayList) {
        new ArrayList();
        this.f55087j = arrayList;
        notifyDataSetChanged();
    }

    public void setNotSelectedChoices(ArrayList<Integer> arrayList) {
        this.f55090m = arrayList;
        notifyDataSetChanged();
    }

    public void setOnItemSelectedListener(RequiredItemAdapters.OnItemSelectedListener onItemSelectedListener) {
        this.f55088k = onItemSelectedListener;
    }

    public void setSelectedChoiceItem(ChoiceItem choiceItem, ChoiceSection choiceSection, int i11) {
        this.f55089l.setSelectedChoiceItem(choiceItem, choiceSection, i11);
    }

    public void setmSelectedChoiceListener(RequiredItemLayout.OnItemSelectedListener onItemSelectedListener) {
        this.f55089l = onItemSelectedListener;
    }

    public void itemSelectionChanged(ChoiceSection choiceSection) {
        this.f55089l.itemSelectionChanged(choiceSection);
    }
}
