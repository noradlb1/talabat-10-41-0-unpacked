package com.talabat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.adapters.RequiredItemAdapters;
import com.talabat.adapters.RequiredItemRevampedAdapter;
import com.talabat.adapters.viewholder.OptionalItemRevampedViewHolder;
import com.talabat.adapters.viewholder.RequiredItemRevampedViewHolder;
import com.talabat.helpers.GlobalDataModel;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;

public class ItemChoicesRevampedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements RequiredItemAdapters.OnItemSelectedListener, RequiredItemRevampedViewHolder.OnItemSelectedListener {
    private static final int TYPE_OPTIONAL = 2;
    private static final int TYPE_REQUIRED = 1;

    /* renamed from: i  reason: collision with root package name */
    public Context f55095i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<ChoiceSection> f55096j;

    /* renamed from: k  reason: collision with root package name */
    public RequiredItemRevampedAdapter.OnItemSelectedListener f55097k;

    /* renamed from: l  reason: collision with root package name */
    public RequiredItemRevampedViewHolder.OnItemSelectedListener f55098l;

    /* renamed from: m  reason: collision with root package name */
    public ArrayList<Integer> f55099m = new ArrayList<>();

    public ItemChoicesRevampedAdapter(Context context) {
        this.f55095i = context;
    }

    private boolean isRequiredItemsNotSelected(ChoiceSection choiceSection) {
        if (choiceSection.minQuantity > GlobalDataModel.SELECTED.cartMenuItem.getNumberofItemsSectionForChoiceSection(choiceSection.f13841id)) {
            return true;
        }
        return false;
    }

    public int getItemCount() {
        return this.f55096j.size();
    }

    public int getItemViewType(int i11) {
        if (this.f55096j.get(i11).maxQuantity > 1 || !this.f55096j.get(i11).isMandatoryChoiceSection()) {
            return 2;
        }
        return 1;
    }

    public ChoiceSection getSelectedChoicesByIDs(int i11) {
        return this.f55098l.getSelectedChoicesByIDs(i11);
    }

    public boolean isChoiceItemSelected(int i11, int i12) {
        return this.f55097k.isChoiceItemSelected(i11, i12);
    }

    public void itemSelectionChanged(ChoiceItem choiceItem, boolean z11) {
        this.f55097k.itemSelectionChanged(choiceItem, z11);
    }

    public void itemSelectionChangedPriceChange(ChoiceItem choiceItem, boolean z11) {
        this.f55098l.itemSelectionChangedPriceChange(choiceItem, z11);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        ChoiceSection choiceSection = this.f55096j.get(i11);
        boolean z11 = false;
        if (viewHolder.getItemViewType() == 1) {
            RequiredItemRevampedViewHolder requiredItemRevampedViewHolder = (RequiredItemRevampedViewHolder) viewHolder;
            requiredItemRevampedViewHolder.setOnItemSelectedListener(this);
            requiredItemRevampedViewHolder.setChoiceSection(choiceSection, i11);
            boolean isRequiredItemsNotSelected = isRequiredItemsNotSelected(choiceSection);
            requiredItemRevampedViewHolder.showRequiredItemsSelectedView(isRequiredItemsNotSelected);
            if (this.f55099m.contains(Integer.valueOf(i11)) && isRequiredItemsNotSelected) {
                z11 = true;
            }
            requiredItemRevampedViewHolder.setRequiredError(z11);
        } else if (viewHolder.getItemViewType() == 2) {
            OptionalItemRevampedViewHolder optionalItemRevampedViewHolder = (OptionalItemRevampedViewHolder) viewHolder;
            optionalItemRevampedViewHolder.setMultipleItemsSelectorListener(this);
            optionalItemRevampedViewHolder.setChoiceSection(choiceSection, i11);
            boolean isRequiredItemsNotSelected2 = isRequiredItemsNotSelected(choiceSection);
            optionalItemRevampedViewHolder.showRequiredItemsSelectedView(isRequiredItemsNotSelected2);
            if (this.f55099m.contains(Integer.valueOf(i11)) && isRequiredItemsNotSelected2) {
                z11 = true;
            }
            optionalItemRevampedViewHolder.setRequiredError(z11);
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == 1) {
            return new RequiredItemRevampedViewHolder(LayoutInflater.from(this.f55095i).inflate(R.layout.item_holder_revamped, viewGroup, false));
        }
        if (i11 == 2) {
            return new OptionalItemRevampedViewHolder(LayoutInflater.from(this.f55095i).inflate(R.layout.item_holder_revamped, viewGroup, false));
        }
        return null;
    }

    public void onThirdLevelChoiceAvailable(String str, ArrayList<Integer> arrayList) {
        this.f55098l.onThirdLevelChoiceAvailable(str, arrayList);
    }

    public void setChoiceItems(ArrayList<ChoiceSection> arrayList) {
        new ArrayList();
        this.f55096j = arrayList;
        notifyDataSetChanged();
    }

    public void setNotSelectedChoices(ArrayList<Integer> arrayList) {
        this.f55099m = arrayList;
        notifyDataSetChanged();
    }

    public void setOnItemSelectedListener(RequiredItemRevampedAdapter.OnItemSelectedListener onItemSelectedListener) {
        this.f55097k = onItemSelectedListener;
    }

    public void setSelectedChoiceItem(ChoiceItem choiceItem, ChoiceSection choiceSection, int i11) {
        this.f55098l.setSelectedChoiceItem(choiceItem, choiceSection, i11);
    }

    public void setmSelectedChoiceListener(RequiredItemRevampedViewHolder.OnItemSelectedListener onItemSelectedListener) {
        this.f55098l = onItemSelectedListener;
    }

    public void itemSelectionChanged(ChoiceSection choiceSection) {
        this.f55098l.itemSelectionChanged(choiceSection);
    }
}
