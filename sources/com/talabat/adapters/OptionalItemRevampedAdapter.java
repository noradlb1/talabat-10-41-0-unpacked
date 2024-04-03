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

public class OptionalItemRevampedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: i  reason: collision with root package name */
    public Context f55158i;

    /* renamed from: j  reason: collision with root package name */
    public int f55159j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList<ChoiceItem> f55160k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    public ArrayList<ChoiceItem> f55161l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    public OnMultipleItemsSelectorListener f55162m;

    /* renamed from: n  reason: collision with root package name */
    public ChoiceSection f55163n;

    public interface OnMultipleItemsSelectorListener {
        ChoiceSection getSelectedChoicesByIDs(int i11);

        void itemSelectionChanged(ChoiceItem choiceItem, boolean z11);

        void showMaxChoicesNumberReachedDialog();
    }

    public class OptionalItemViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public AppCompatCheckBox f55167h;

        /* renamed from: i  reason: collision with root package name */
        public TalabatTextView f55168i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f55169j;

        /* renamed from: k  reason: collision with root package name */
        public TextView f55170k;

        /* renamed from: l  reason: collision with root package name */
        public View f55171l;

        public OptionalItemViewHolder(View view) {
            super(view);
            this.f55167h = (AppCompatCheckBox) view.findViewById(R.id.checkbox_optionalItem);
            this.f55168i = (TalabatTextView) view.findViewById(R.id.textView_price);
            this.f55169j = (TextView) view.findViewById(R.id.discounted_price);
            this.f55170k = (TextView) view.findViewById(R.id.m_choice_name);
            this.f55171l = view.findViewById(R.id.item_added_indicator);
        }
    }

    public OptionalItemRevampedAdapter(Context context) {
        this.f55158i = context;
    }

    public int getItemCount() {
        return this.f55160k.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i11) {
        final OptionalItemViewHolder optionalItemViewHolder = (OptionalItemViewHolder) viewHolder;
        ChoiceItem choiceItem = this.f55160k.get(i11);
        optionalItemViewHolder.f55167h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        if (this.f55162m.getSelectedChoicesByIDs(this.f55163n.f13841id) != null) {
            this.f55161l = new ArrayList<>();
            this.f55161l = this.f55162m.getSelectedChoicesByIDs(this.f55163n.f13841id).itemChoices;
        } else {
            this.f55161l = new ArrayList<>();
        }
        if (this.f55161l.contains(choiceItem)) {
            optionalItemViewHolder.f55167h.setChecked(true);
            optionalItemViewHolder.f55171l.setVisibility(0);
            optionalItemViewHolder.f55170k.setTextAppearance(this.f55158i, R.style.Content14Bold);
        } else {
            optionalItemViewHolder.f55167h.setChecked(false);
            optionalItemViewHolder.f55171l.setVisibility(4);
            optionalItemViewHolder.f55170k.setTextAppearance(this.f55158i, R.style.Content14Regular);
        }
        if (choiceItem.isPriced()) {
            TalabatTextView talabatTextView = optionalItemViewHolder.f55168i;
            talabatTextView.setText("(+" + choiceItem.getDisplayItemChoicePice(true) + ")");
            optionalItemViewHolder.f55168i.setVisibility(0);
        } else {
            optionalItemViewHolder.f55168i.setVisibility(8);
        }
        if (!choiceItem.isDiscounted()) {
            optionalItemViewHolder.f55169j.setVisibility(8);
        } else if (Integration.isGemActive()) {
            optionalItemViewHolder.f55169j.setVisibility(8);
            TalabatTextView talabatTextView2 = optionalItemViewHolder.f55168i;
            talabatTextView2.setText("(+" + choiceItem.getDisplayItemChoiceOldPrice(true) + ")");
            optionalItemViewHolder.f55168i.setVisibility(0);
        } else {
            optionalItemViewHolder.f55169j.setVisibility(0);
            TextView textView = optionalItemViewHolder.f55169j;
            textView.setText("(+" + choiceItem.getDisplayItemChoiceOldPrice(true) + ")");
            TextView textView2 = optionalItemViewHolder.f55169j;
            textView2.setPaintFlags(textView2.getPaintFlags() | 16);
        }
        optionalItemViewHolder.f55170k.setText(choiceItem.f13840name);
        optionalItemViewHolder.f55167h.setTag(Integer.valueOf(i11));
        optionalItemViewHolder.itemView.setOnClickListener(new b(optionalItemViewHolder));
        optionalItemViewHolder.f55167h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                ChoiceItem choiceItem = OptionalItemRevampedAdapter.this.f55160k.get(i11);
                OptionalItemRevampedAdapter optionalItemRevampedAdapter = OptionalItemRevampedAdapter.this;
                if (optionalItemRevampedAdapter.f55162m.getSelectedChoicesByIDs(optionalItemRevampedAdapter.f55163n.f13841id) != null) {
                    OptionalItemRevampedAdapter.this.f55161l = new ArrayList<>();
                    OptionalItemRevampedAdapter optionalItemRevampedAdapter2 = OptionalItemRevampedAdapter.this;
                    optionalItemRevampedAdapter2.f55161l = optionalItemRevampedAdapter2.f55162m.getSelectedChoicesByIDs(optionalItemRevampedAdapter2.f55163n.f13841id).itemChoices;
                }
                if (z11) {
                    OptionalItemRevampedAdapter optionalItemRevampedAdapter3 = OptionalItemRevampedAdapter.this;
                    if (optionalItemRevampedAdapter3.f55159j != 0) {
                        int size = optionalItemRevampedAdapter3.f55161l.size();
                        OptionalItemRevampedAdapter optionalItemRevampedAdapter4 = OptionalItemRevampedAdapter.this;
                        if (size >= optionalItemRevampedAdapter4.f55159j) {
                            OnMultipleItemsSelectorListener onMultipleItemsSelectorListener = optionalItemRevampedAdapter4.f55162m;
                            if (onMultipleItemsSelectorListener != null) {
                                onMultipleItemsSelectorListener.showMaxChoicesNumberReachedDialog();
                            }
                            compoundButton.setChecked(false);
                            optionalItemViewHolder.f55171l.setVisibility(4);
                            optionalItemViewHolder.f55170k.setTextAppearance(OptionalItemRevampedAdapter.this.f55158i, R.style.Content14Regular);
                            return;
                        }
                    }
                    OptionalItemRevampedAdapter.this.f55162m.itemSelectionChanged(choiceItem, true);
                    optionalItemViewHolder.f55171l.setVisibility(0);
                    optionalItemViewHolder.f55170k.setTextAppearance(OptionalItemRevampedAdapter.this.f55158i, R.style.Content14Bold);
                    return;
                }
                OptionalItemRevampedAdapter.this.f55162m.itemSelectionChanged(choiceItem, false);
                optionalItemViewHolder.f55171l.setVisibility(4);
                optionalItemViewHolder.f55170k.setTextAppearance(OptionalItemRevampedAdapter.this.f55158i, R.style.Content14Regular);
            }
        });
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new OptionalItemViewHolder(LayoutInflater.from(this.f55158i).inflate(R.layout.item_addon_choice_revamp, viewGroup, false));
    }

    public void setChoiceItems(ChoiceSection choiceSection, int i11) {
        this.f55163n = choiceSection;
        this.f55160k = choiceSection.itemChoices;
        this.f55159j = i11;
        notifyDataSetChanged();
    }

    public void setListener(OnMultipleItemsSelectorListener onMultipleItemsSelectorListener) {
        this.f55162m = onMultipleItemsSelectorListener;
    }
}
