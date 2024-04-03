package com.talabat.adapters.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.material.card.MaterialCardView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.adapters.OptionalItemRevampedAdapter;
import com.talabat.adapters.viewholder.RequiredItemRevampedViewHolder;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.VerticalDividerWithPaddingItemDecoration;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.LinkedHashSet;

public class OptionalItemRevampedViewHolder extends RecyclerView.ViewHolder implements OptionalItemRevampedAdapter.OnMultipleItemsSelectorListener {
    private Context context;

    /* renamed from: h  reason: collision with root package name */
    public int f55357h;

    /* renamed from: i  reason: collision with root package name */
    public ChoiceSection f55358i;
    private MaterialCardView mCardSection;
    private ChoiceSection mChoiceSection;
    private RequiredItemRevampedViewHolder.OnItemSelectedListener mMultipleItemsSelectorListener;
    private OptionalItemRevampedAdapter mOptionalItemAdapter;
    private RecyclerView mRecyclerViewChoices;
    private TalabatTextView mTextViewCategoryName;
    private TalabatTextView mTextViewSelectionCriteria;

    public OptionalItemRevampedViewHolder(View view) {
        super(view);
        this.context = view.getContext();
        initView(view);
    }

    private void buildUI() {
        if (this.mChoiceSection.minQuantity > 0) {
            TalabatTextView talabatTextView = this.mTextViewSelectionCriteria;
            talabatTextView.setText("(" + this.mChoiceSection.selectionText + ")");
            this.mTextViewSelectionCriteria.setTextColor(this.context.getResources().getColor(R.color.primary_100));
        } else {
            this.mTextViewSelectionCriteria.setText(this.context.getString(R.string.optional));
            this.mTextViewSelectionCriteria.setTextColor(this.context.getResources().getColor(R.color.neutral_grey));
        }
        if (!this.mChoiceSection.f13842name.isEmpty()) {
            this.mTextViewCategoryName.setText(this.mChoiceSection.f13842name.replace(CertificateUtil.DELIMITER, ""));
        }
        OptionalItemRevampedAdapter optionalItemRevampedAdapter = this.mOptionalItemAdapter;
        ChoiceSection choiceSection = this.mChoiceSection;
        optionalItemRevampedAdapter.setChoiceItems(choiceSection, choiceSection.maxQuantity);
    }

    private void initView(View view) {
        this.mTextViewCategoryName = (TalabatTextView) view.findViewById(R.id.sectionName);
        this.mTextViewSelectionCriteria = (TalabatTextView) view.findViewById(R.id.tv_selection_criteria);
        this.mCardSection = (MaterialCardView) view.findViewById(R.id.card_section);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_choices);
        this.mRecyclerViewChoices = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context, 1, false));
        Context context2 = this.context;
        this.mRecyclerViewChoices.addItemDecoration(new VerticalDividerWithPaddingItemDecoration(context2, context2.getResources().getDimensionPixelSize(R.dimen._16margin)));
        OptionalItemRevampedAdapter optionalItemRevampedAdapter = new OptionalItemRevampedAdapter(this.context);
        this.mOptionalItemAdapter = optionalItemRevampedAdapter;
        optionalItemRevampedAdapter.setListener(this);
        this.mRecyclerViewChoices.setAdapter(this.mOptionalItemAdapter);
        this.mRecyclerViewChoices.setNestedScrollingEnabled(false);
    }

    private boolean isRequiredItemsNotSelected(ChoiceSection choiceSection) {
        if (choiceSection.minQuantity > GlobalDataModel.SELECTED.cartMenuItem.getNumberofItemsSectionForChoiceSection(choiceSection.f13841id)) {
            return true;
        }
        return false;
    }

    public ChoiceSection getSelectedChoicesByIDs(int i11) {
        return this.mMultipleItemsSelectorListener.getSelectedChoicesByIDs(i11);
    }

    public void getSelectedSections(ChoiceSection choiceSection) {
        if (this.mMultipleItemsSelectorListener.getSelectedChoicesByIDs(choiceSection.f13841id) == null) {
            this.f55358i = ChoiceSection.createSelectedChoiceSection(this.mChoiceSection);
            return;
        }
        this.f55358i = new ChoiceSection();
        this.f55358i = this.mMultipleItemsSelectorListener.getSelectedChoicesByIDs(choiceSection.f13841id);
    }

    public void itemSelectionChanged(ChoiceItem choiceItem, boolean z11) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z11) {
            if (!this.f55358i.itemChoices.contains(choiceItem)) {
                this.f55358i.itemChoices.add(choiceItem);
            }
            linkedHashSet.addAll(this.f55358i.itemChoices);
        } else {
            linkedHashSet.addAll(this.f55358i.itemChoices);
            linkedHashSet.remove(choiceItem);
        }
        this.f55358i.itemChoices.clear();
        this.f55358i.itemChoices.addAll(linkedHashSet);
        this.mMultipleItemsSelectorListener.itemSelectionChanged(this.f55358i);
        this.mMultipleItemsSelectorListener.itemSelectionChangedPriceChange(choiceItem, z11);
        showRequiredItemsSelectedView(isRequiredItemsNotSelected(this.f55358i));
    }

    public void setChoiceSection(ChoiceSection choiceSection, int i11) {
        this.mChoiceSection = choiceSection;
        this.f55357h = i11;
        getSelectedSections(choiceSection);
        buildUI();
    }

    public void setMultipleItemsSelectorListener(RequiredItemRevampedViewHolder.OnItemSelectedListener onItemSelectedListener) {
        this.mMultipleItemsSelectorListener = onItemSelectedListener;
    }

    public void setRequiredError(boolean z11) {
        getSelectedSections(this.mChoiceSection);
        if (z11) {
            this.mCardSection.setStrokeColor(this.context.getResources().getColor(R.color.primary_100));
        }
        this.mOptionalItemAdapter.notifyDataSetChanged();
    }

    public void showMaxChoicesNumberReachedDialog() {
        new AlertDialog.Builder(this.context).setTitle((CharSequence) this.context.getString(R.string.error)).setMessage((CharSequence) this.context.getString(R.string.max_choices_reached)).setPositiveButton((CharSequence) this.context.getString(R.string.f54881ok), (DialogInterface.OnClickListener) null).show();
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
