package com.talabat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.lib.Integration;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;

public class OptionalItemAdapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public Context f55145i;

    /* renamed from: j  reason: collision with root package name */
    public int f55146j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<ChoiceItem> f55147k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<ChoiceItem> f55148l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    public OnMultipleItemsSelectorListener f55149m;

    /* renamed from: n  reason: collision with root package name */
    public ChoiceSection f55150n;

    public interface OnMultipleItemsSelectorListener {
        ChoiceSection getSelectedChoicesByIDs(int i11);

        void itemSelectionChanged(ChoiceItem choiceItem, boolean z11);

        void showMaxChoicesNumberReachedDialog();
    }

    public class OptionalItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public AppCompatCheckBox f55153h;

        /* renamed from: i  reason: collision with root package name */
        public TalabatTextView f55154i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55155j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f55156k;

        public OptionalItemViewHolder(View view) {
            super(view);
            this.f55153h = (AppCompatCheckBox) view.findViewById(R.id.checkbox_optionalItem);
            this.f55154i = (TalabatTextView) view.findViewById(R.id.textView_price);
            this.f55155j = (TextView) view.findViewById(R.id.discounted_price);
            this.f55156k = (TextView) view.findViewById(R.id.m_choice_name);
        }
    }

    public OptionalItemAdapters(Context context) {
        this.f55145i = context;
    }

    public int getItemCount() {
        return this.f55147k.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i11) {
        OptionalItemViewHolder optionalItemViewHolder = (OptionalItemViewHolder) viewHolder;
        ChoiceItem choiceItem = this.f55147k.get(i11);
        optionalItemViewHolder.f55153h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (this.f55149m.getSelectedChoicesByIDs(this.f55150n.f13841id) != null) {
            this.f55148l = new ArrayList<>();
            this.f55148l = this.f55149m.getSelectedChoicesByIDs(this.f55150n.f13841id).itemChoices;
        } else {
            this.f55148l = new ArrayList<>();
        }
        if (this.f55148l.contains(choiceItem)) {
            optionalItemViewHolder.f55153h.setChecked(true);
        } else {
            optionalItemViewHolder.f55153h.setChecked(false);
        }
        if (choiceItem.isPriced()) {
            optionalItemViewHolder.f55154i.setText(choiceItem.getDisplayItemChoicePice(false));
            optionalItemViewHolder.f55154i.setVisibility(0);
        } else {
            optionalItemViewHolder.f55154i.setVisibility(8);
        }
        if (!choiceItem.isDiscounted()) {
            optionalItemViewHolder.f55155j.setVisibility(8);
        } else if (Integration.isGemActive()) {
            optionalItemViewHolder.f55155j.setVisibility(8);
            optionalItemViewHolder.f55154i.setText(choiceItem.getDisplayItemChoiceOldPrice(false));
            optionalItemViewHolder.f55154i.setVisibility(0);
        } else {
            optionalItemViewHolder.f55155j.setVisibility(0);
            optionalItemViewHolder.f55155j.setText(choiceItem.getDisplayItemChoiceOldPrice(false));
            TextView textView = optionalItemViewHolder.f55155j;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
        }
        optionalItemViewHolder.f55156k.setText(choiceItem.f13840name);
        optionalItemViewHolder.f55153h.setTag(Integer.valueOf(i11));
        optionalItemViewHolder.itemView.setOnClickListener(new a(optionalItemViewHolder));
        optionalItemViewHolder.f55153h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                ChoiceItem choiceItem = OptionalItemAdapters.this.f55147k.get(i11);
                OptionalItemAdapters optionalItemAdapters = OptionalItemAdapters.this;
                if (optionalItemAdapters.f55149m.getSelectedChoicesByIDs(optionalItemAdapters.f55150n.f13841id) != null) {
                    OptionalItemAdapters.this.f55148l = new ArrayList<>();
                    OptionalItemAdapters optionalItemAdapters2 = OptionalItemAdapters.this;
                    optionalItemAdapters2.f55148l = optionalItemAdapters2.f55149m.getSelectedChoicesByIDs(optionalItemAdapters2.f55150n.f13841id).itemChoices;
                }
                if (z11) {
                    OptionalItemAdapters optionalItemAdapters3 = OptionalItemAdapters.this;
                    if (optionalItemAdapters3.f55146j != 0) {
                        int size = optionalItemAdapters3.f55148l.size();
                        OptionalItemAdapters optionalItemAdapters4 = OptionalItemAdapters.this;
                        if (size >= optionalItemAdapters4.f55146j) {
                            OnMultipleItemsSelectorListener onMultipleItemsSelectorListener = optionalItemAdapters4.f55149m;
                            if (onMultipleItemsSelectorListener != null) {
                                onMultipleItemsSelectorListener.showMaxChoicesNumberReachedDialog();
                            }
                            compoundButton.setChecked(false);
                            return;
                        }
                    }
                    OptionalItemAdapters.this.f55149m.itemSelectionChanged(choiceItem, true);
                    return;
                }
                OptionalItemAdapters.this.f55149m.itemSelectionChanged(choiceItem, false);
            }
        });
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new OptionalItemViewHolder(LayoutInflater.from(this.f55145i).inflate(R.layout.item_addon_choice, viewGroup, false));
    }

    public void setChoiceItems(ChoiceSection choiceSection, int i11) {
        this.f55150n = choiceSection;
        this.f55147k = choiceSection.itemChoices;
        this.f55146j = i11;
        notifyDataSetChanged();
    }

    public void setListener(OnMultipleItemsSelectorListener onMultipleItemsSelectorListener) {
        this.f55149m = onMultipleItemsSelectorListener;
    }
}
