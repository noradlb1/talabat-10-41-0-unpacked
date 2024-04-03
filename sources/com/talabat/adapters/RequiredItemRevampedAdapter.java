package com.talabat.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_radiobutton.DSRadioButton;
import com.talabat.R;
import com.talabat.lib.Integration;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;

public class RequiredItemRevampedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public Context f55199i;

    /* renamed from: j  reason: collision with root package name */
    public ChoiceSection f55200j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<ChoiceItem> f55201k;

    /* renamed from: l  reason: collision with root package name */
    public OnItemSelectedListener f55202l;

    /* renamed from: m  reason: collision with root package name */
    public ChoiceItem f55203m;

    /* renamed from: n  reason: collision with root package name */
    public DSRadioButton f55204n;

    public interface OnItemSelectedListener {
        ChoiceSection getSelectedChoicesByIDs(int i11);

        boolean isChoiceItemSelected(int i11, int i12);

        void itemSelectionChanged(ChoiceItem choiceItem, boolean z11);

        void setSelectedChoiceItem(ChoiceItem choiceItem, ChoiceSection choiceSection, int i11);
    }

    public class RequiredItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public DSRadioButton f55209h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f55210i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55211j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f55212k;

        /* renamed from: l  reason: collision with root package name */
        public View f55213l;

        public RequiredItemViewHolder(View view) {
            super(view);
            this.f55209h = (DSRadioButton) view.findViewById(R.id.radioButton_choice);
            this.f55211j = (TextView) view.findViewById(R.id.textView_price);
            this.f55212k = (TextView) view.findViewById(R.id.discounted_price);
            this.f55210i = (TextView) view.findViewById(R.id.m_choice_name);
            this.f55213l = view.findViewById(R.id.item_added_indicator);
        }
    }

    public RequiredItemRevampedAdapter(Context context) {
        this.f55199i = context;
    }

    private boolean isRequiredSectionWithOneChoice() {
        ArrayList<ChoiceItem> arrayList;
        ChoiceSection choiceSection = this.f55200j;
        if (choiceSection.minQuantity == 1 && (arrayList = choiceSection.itemChoices) != null && arrayList.size() == 1) {
            return true;
        }
        return false;
    }

    public int getItemCount() {
        return this.f55201k.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i11) {
        final RequiredItemViewHolder requiredItemViewHolder = (RequiredItemViewHolder) viewHolder;
        final ChoiceItem choiceItem = this.f55201k.get(i11);
        requiredItemViewHolder.f55209h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (this.f55202l.getSelectedChoicesByIDs(this.f55200j.f13841id) != null) {
            this.f55203m = this.f55202l.getSelectedChoicesByIDs(this.f55200j.f13841id).itemChoices.get(0);
        } else {
            this.f55203m = null;
        }
        ChoiceItem choiceItem2 = this.f55203m;
        if (choiceItem2 == null || choiceItem2 != choiceItem) {
            requiredItemViewHolder.f55209h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            requiredItemViewHolder.f55209h.setChecked(false);
            requiredItemViewHolder.f55213l.setVisibility(4);
            requiredItemViewHolder.f55210i.setTextAppearance(this.f55199i, R.style.Content14Regular);
        } else {
            requiredItemViewHolder.f55209h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            requiredItemViewHolder.f55209h.setChecked(true);
            requiredItemViewHolder.f55213l.setVisibility(0);
            requiredItemViewHolder.f55210i.setTextAppearance(this.f55199i, R.style.Content14Bold);
        }
        if (choiceItem.isPriced()) {
            TextView textView = requiredItemViewHolder.f55211j;
            textView.setText("(+" + choiceItem.getDisplayItemChoicePice(true) + ")");
            requiredItemViewHolder.f55211j.setVisibility(0);
        } else {
            requiredItemViewHolder.f55211j.setVisibility(8);
        }
        if (!choiceItem.isDiscounted()) {
            requiredItemViewHolder.f55212k.setVisibility(8);
        } else if (Integration.isGemActive()) {
            requiredItemViewHolder.f55212k.setVisibility(8);
            TextView textView2 = requiredItemViewHolder.f55211j;
            textView2.setText("(+" + choiceItem.getDisplayItemChoiceOldPrice(true) + ")");
            requiredItemViewHolder.f55211j.setVisibility(0);
        } else {
            requiredItemViewHolder.f55212k.setVisibility(0);
            TextView textView3 = requiredItemViewHolder.f55212k;
            textView3.setText("(+" + choiceItem.getDisplayItemChoiceOldPrice(true) + ")");
            TextView textView4 = requiredItemViewHolder.f55212k;
            textView4.setPaintFlags(textView4.getPaintFlags() | 16);
        }
        requiredItemViewHolder.f55210i.setText(choiceItem.f13840name);
        requiredItemViewHolder.itemView.setOnClickListener(new e(requiredItemViewHolder));
        requiredItemViewHolder.f55209h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                if (z11) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(RequiredItemRevampedAdapter.this.f55204n);
                    sb2.append("");
                    DSRadioButton dSRadioButton = RequiredItemRevampedAdapter.this.f55204n;
                    if (dSRadioButton != null) {
                        dSRadioButton.setChecked(false);
                    }
                    RequiredItemRevampedAdapter requiredItemRevampedAdapter = RequiredItemRevampedAdapter.this;
                    ChoiceItem choiceItem = choiceItem;
                    requiredItemRevampedAdapter.f55203m = choiceItem;
                    requiredItemRevampedAdapter.f55204n = requiredItemViewHolder.f55209h;
                    requiredItemRevampedAdapter.f55202l.setSelectedChoiceItem(choiceItem, requiredItemRevampedAdapter.f55200j, i11);
                    RequiredItemRevampedAdapter.this.f55202l.itemSelectionChanged(choiceItem, true);
                    return;
                }
                RequiredItemRevampedAdapter.this.f55202l.itemSelectionChanged(choiceItem, false);
                RequiredItemRevampedAdapter.this.f55203m = null;
            }
        });
        if (isRequiredSectionWithOneChoice() && !requiredItemViewHolder.f55209h.isChecked()) {
            new Handler().post(new f(requiredItemViewHolder));
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new RequiredItemViewHolder(LayoutInflater.from(this.f55199i).inflate(R.layout.item_choice_revamp, viewGroup, false));
    }

    public void setChoiceItems(ChoiceSection choiceSection) {
        this.f55201k = choiceSection.itemChoices;
        this.f55200j = choiceSection;
        notifyDataSetChanged();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f55202l = onItemSelectedListener;
    }
}
