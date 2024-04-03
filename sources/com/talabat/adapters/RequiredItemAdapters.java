package com.talabat.adapters;

import android.content.Context;
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

public class RequiredItemAdapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public Context f55184i;

    /* renamed from: j  reason: collision with root package name */
    public ChoiceSection f55185j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<ChoiceItem> f55186k;

    /* renamed from: l  reason: collision with root package name */
    public OnItemSelectedListener f55187l;

    /* renamed from: m  reason: collision with root package name */
    public ChoiceItem f55188m;

    /* renamed from: n  reason: collision with root package name */
    public DSRadioButton f55189n;

    public interface OnItemSelectedListener {
        ChoiceSection getSelectedChoicesByIDs(int i11);

        boolean isChoiceItemSelected(int i11, int i12);

        void itemSelectionChanged(ChoiceItem choiceItem, boolean z11);

        void setSelectedChoiceItem(ChoiceItem choiceItem, ChoiceSection choiceSection, int i11);
    }

    public class RequiredItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public DSRadioButton f55194h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f55195i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55196j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f55197k;

        public RequiredItemViewHolder(View view) {
            super(view);
            this.f55194h = (DSRadioButton) view.findViewById(R.id.radioButton_choice);
            this.f55196j = (TextView) view.findViewById(R.id.textView_price);
            this.f55197k = (TextView) view.findViewById(R.id.discounted_price);
            this.f55195i = (TextView) view.findViewById(R.id.m_choice_name);
        }
    }

    public RequiredItemAdapters(Context context) {
        this.f55184i = context;
    }

    public int getItemCount() {
        return this.f55186k.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i11) {
        final RequiredItemViewHolder requiredItemViewHolder = (RequiredItemViewHolder) viewHolder;
        final ChoiceItem choiceItem = this.f55186k.get(i11);
        requiredItemViewHolder.f55194h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (this.f55187l.getSelectedChoicesByIDs(this.f55185j.f13841id) != null) {
            this.f55188m = this.f55187l.getSelectedChoicesByIDs(this.f55185j.f13841id).itemChoices.get(0);
        } else {
            this.f55188m = null;
        }
        ChoiceItem choiceItem2 = this.f55188m;
        if (choiceItem2 == null || choiceItem2 != choiceItem) {
            requiredItemViewHolder.f55194h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            requiredItemViewHolder.f55194h.setChecked(false);
        } else {
            requiredItemViewHolder.f55194h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            requiredItemViewHolder.f55194h.setChecked(true);
        }
        if (choiceItem.isPriced()) {
            requiredItemViewHolder.f55196j.setText(choiceItem.getDisplayItemChoicePice(false));
            requiredItemViewHolder.f55196j.setVisibility(0);
        } else {
            requiredItemViewHolder.f55196j.setVisibility(8);
        }
        if (!choiceItem.isDiscounted()) {
            requiredItemViewHolder.f55197k.setVisibility(8);
        } else if (Integration.isGemActive()) {
            requiredItemViewHolder.f55197k.setVisibility(8);
            requiredItemViewHolder.f55196j.setText(choiceItem.getDisplayItemChoiceOldPrice(false));
            requiredItemViewHolder.f55196j.setVisibility(0);
        } else {
            requiredItemViewHolder.f55197k.setVisibility(0);
            requiredItemViewHolder.f55197k.setText(choiceItem.getDisplayItemChoiceOldPrice(false));
            TextView textView = requiredItemViewHolder.f55197k;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
        }
        requiredItemViewHolder.f55195i.setText(choiceItem.f13840name);
        requiredItemViewHolder.itemView.setOnClickListener(new d(requiredItemViewHolder));
        requiredItemViewHolder.f55194h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                if (z11) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(RequiredItemAdapters.this.f55189n);
                    sb2.append("");
                    DSRadioButton dSRadioButton = RequiredItemAdapters.this.f55189n;
                    if (dSRadioButton != null) {
                        dSRadioButton.setChecked(false);
                    }
                    RequiredItemAdapters requiredItemAdapters = RequiredItemAdapters.this;
                    ChoiceItem choiceItem = choiceItem;
                    requiredItemAdapters.f55188m = choiceItem;
                    requiredItemAdapters.f55189n = requiredItemViewHolder.f55194h;
                    requiredItemAdapters.f55187l.setSelectedChoiceItem(choiceItem, requiredItemAdapters.f55185j, i11);
                    RequiredItemAdapters.this.f55187l.itemSelectionChanged(choiceItem, true);
                    return;
                }
                RequiredItemAdapters.this.f55187l.itemSelectionChanged(choiceItem, false);
                RequiredItemAdapters.this.f55188m = null;
            }
        });
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new RequiredItemViewHolder(LayoutInflater.from(this.f55184i).inflate(R.layout.item_choice, viewGroup, false));
    }

    public void setChoiceItems(ChoiceSection choiceSection) {
        this.f55186k = choiceSection.itemChoices;
        this.f55185j = choiceSection;
        notifyDataSetChanged();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f55187l = onItemSelectedListener;
    }
}
