package com.talabat.adapters.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.material.card.MaterialCardView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.adapters.RequiredItemRevampedAdapter;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.VerticalDividerWithPaddingItemDecoration;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RequiredItemRevampedViewHolder extends RecyclerView.ViewHolder implements RequiredItemRevampedAdapter.OnItemSelectedListener {
    private StringBuilder choiceIdStringBuilder;
    private Context context;

    /* renamed from: h  reason: collision with root package name */
    public ChoiceSection f55359h;

    /* renamed from: i  reason: collision with root package name */
    public ChoiceSection f55360i;

    /* renamed from: j  reason: collision with root package name */
    public OnItemSelectedListener f55361j;
    private MaterialCardView mCardSection;
    private RecyclerView mRecyclerViewChoices;
    private RequiredItemRevampedAdapter mRequiredItemAdapter;
    private int mSectionPostion;
    private TalabatTextView mTextViewCategoryName;
    private TalabatTextView mTextViewSelectionCriteria;
    private ArrayList<Integer> thirdLevelChoiceIds;

    public interface OnItemSelectedListener {
        ChoiceSection getSelectedChoicesByIDs(int i11);

        void itemSelectionChanged(ChoiceSection choiceSection);

        void itemSelectionChangedPriceChange(ChoiceItem choiceItem, boolean z11);

        void onThirdLevelChoiceAvailable(String str, ArrayList<Integer> arrayList);

        void setSelectedChoiceItem(ChoiceItem choiceItem, ChoiceSection choiceSection, int i11);
    }

    public RequiredItemRevampedViewHolder(View view) {
        super(view);
        this.context = view.getContext();
        initView(view);
    }

    private void buildUI() {
        TalabatTextView talabatTextView = this.mTextViewSelectionCriteria;
        talabatTextView.setText("(" + this.f55359h.selectionText + ")");
        if (!this.f55359h.f13842name.isEmpty()) {
            this.mTextViewCategoryName.setText(this.f55359h.f13842name.replace(CertificateUtil.DELIMITER, ""));
        }
        this.mRequiredItemAdapter.setChoiceItems(this.f55359h);
        if (hasThirdLevelChoices() && this.choiceIdStringBuilder.length() > 0) {
            this.f55361j.onThirdLevelChoiceAvailable(this.choiceIdStringBuilder.toString(), this.thirdLevelChoiceIds);
        }
    }

    private boolean checkIfItemIsAvailable(int i11) {
        for (ChoiceSection choiceSection : GlobalDataModel.SELECTED.cartMenuItem.choiceSections) {
            if (choiceSection.parentItemId == i11) {
                return true;
            }
        }
        return false;
    }

    private boolean hasThirdLevelChoices() {
        int i11;
        this.choiceIdStringBuilder = new StringBuilder();
        this.thirdLevelChoiceIds = new ArrayList<>();
        Iterator<ChoiceItem> it = this.f55359h.itemChoices.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            ChoiceItem next = it.next();
            if (next.hasSubChoice && !this.thirdLevelChoiceIds.contains(Integer.valueOf(next.f13839id)) && (i11 = next.f13839id) > 0 && !checkIfItemIsAvailable(i11)) {
                this.thirdLevelChoiceIds.add(Integer.valueOf(next.f13839id));
                if (!z11) {
                    z11 = true;
                }
            }
        }
        if (this.thirdLevelChoiceIds.size() > 0) {
            Iterator<Integer> it2 = this.thirdLevelChoiceIds.iterator();
            while (it2.hasNext()) {
                Integer next2 = it2.next();
                if (this.choiceIdStringBuilder.length() > 0) {
                    this.choiceIdStringBuilder.append(",");
                }
                this.choiceIdStringBuilder.append(next2);
            }
        }
        return z11;
    }

    private void initView(View view) {
        this.mTextViewCategoryName = (TalabatTextView) view.findViewById(R.id.sectionName);
        this.mTextViewSelectionCriteria = (TalabatTextView) view.findViewById(R.id.tv_selection_criteria);
        this.mCardSection = (MaterialCardView) view.findViewById(R.id.card_section);
        this.mRecyclerViewChoices = (RecyclerView) view.findViewById(R.id.recyclerView_choices);
        this.mRecyclerViewChoices.setLayoutManager(new LinearLayoutManager(this.context, 1, false));
        Context context2 = this.context;
        this.mRecyclerViewChoices.addItemDecoration(new VerticalDividerWithPaddingItemDecoration(context2, context2.getResources().getDimensionPixelSize(R.dimen._16margin)));
        RequiredItemRevampedAdapter requiredItemRevampedAdapter = new RequiredItemRevampedAdapter(this.context);
        this.mRequiredItemAdapter = requiredItemRevampedAdapter;
        this.mRecyclerViewChoices.setAdapter(requiredItemRevampedAdapter);
        this.mRequiredItemAdapter.setOnItemSelectedListener(this);
        this.mRecyclerViewChoices.setNestedScrollingEnabled(false);
    }

    public ChoiceSection getSelectedChoicesByIDs(int i11) {
        return this.f55361j.getSelectedChoicesByIDs(i11);
    }

    public boolean isChoiceItemSelected(int i11, int i12) {
        return false;
    }

    public void itemSelectionChanged(ChoiceItem choiceItem, boolean z11) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z11) {
            if (this.f55360i.itemChoices.size() > 0) {
                Iterator<ChoiceItem> it = this.f55360i.itemChoices.iterator();
                while (it.hasNext()) {
                    ChoiceItem next = it.next();
                    if (next != choiceItem) {
                        this.f55360i.itemChoices.remove(next);
                    }
                }
            }
            if (!this.f55360i.itemChoices.contains(choiceItem)) {
                this.f55360i.itemChoices.add(choiceItem);
            }
            linkedHashSet.addAll(this.f55360i.itemChoices);
        } else {
            linkedHashSet.addAll(this.f55360i.itemChoices);
            linkedHashSet.remove(choiceItem);
        }
        this.f55360i.itemChoices.clear();
        this.f55360i.itemChoices.addAll(linkedHashSet);
        this.f55361j.itemSelectionChanged(this.f55360i);
        this.f55361j.itemSelectionChangedPriceChange(choiceItem, z11);
    }

    public void setChoiceSection(ChoiceSection choiceSection, int i11) {
        this.f55359h = choiceSection;
        this.mSectionPostion = i11;
        if (this.f55361j.getSelectedChoicesByIDs(choiceSection.f13841id) == null) {
            this.f55360i = ChoiceSection.createSelectedChoiceSection(this.f55359h);
        } else {
            this.f55360i = this.f55361j.getSelectedChoicesByIDs(choiceSection.f13841id);
        }
        buildUI();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f55361j = onItemSelectedListener;
    }

    public void setRequiredError(boolean z11) {
        if (z11) {
            this.mCardSection.setStrokeColor(this.context.getResources().getColor(R.color.primary_100));
        }
        this.mRequiredItemAdapter.notifyDataSetChanged();
    }

    public void setSelectedChoiceItem(ChoiceItem choiceItem, ChoiceSection choiceSection, int i11) {
        this.f55361j.setSelectedChoiceItem(choiceItem, choiceSection, this.mSectionPostion);
    }

    public void showRequiredItemsSelectedView(boolean z11) {
        if (z11) {
            this.mCardSection.setCardElevation((float) this.context.getResources().getDimensionPixelSize(R.dimen._16margin));
            this.mCardSection.setStrokeColor(this.context.getResources().getColor(R.color.transparent));
            return;
        }
        this.mCardSection.setCardElevation(0.0f);
        this.mCardSection.setStrokeColor(this.context.getResources().getColor(R.color.ds_neutral_10));
    }
}
