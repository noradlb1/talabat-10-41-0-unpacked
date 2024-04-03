package com.talabat.helpers;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.adapters.OptionalItemAdapters;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.RequiredItemLayout;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class OptionalItemLayout extends CardView implements OptionalItemAdapters.OnMultipleItemsSelectorListener {

    /* renamed from: b  reason: collision with root package name */
    public int f60834b;

    /* renamed from: c  reason: collision with root package name */
    public ChoiceSection f60835c;
    private StringBuilder choiceIdStringBuilder;
    private ChoiceSection mChoiceSection;
    /* access modifiers changed from: private */
    public ImageView mImageViewArrow;
    private LinearLayout mLinearLayoutHeaderContainer;
    private RequiredItemLayout.OnItemSelectedListener mMultipleItemsSelectorListener;
    private OptionalItemAdapters mOptionalItemAdapters;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerViewOptionalChoices;
    private TalabatTextView mTextViewCategoryHint;
    private TalabatTextView mTextViewCategoryName;
    private TalabatTextView mTextViewSelectionCriteria;
    private ArrayList<Integer> thirdLevelChoiceIds;

    public OptionalItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.item_optional_choice, this));
    }

    private void buildUI() {
        this.mTextViewSelectionCriteria.setVisibility(0);
        this.mTextViewSelectionCriteria.setText(this.mChoiceSection.selectionText);
        ChoiceSection choiceSection = this.mChoiceSection;
        if (choiceSection.minQuantity == 0 && !choiceSection.f13842name.contains(getContext().getString(R.string.optional_with_bracket))) {
            ChoiceSection choiceSection2 = this.mChoiceSection;
            choiceSection2.f13842name = this.mChoiceSection.f13842name + " " + getContext().getString(R.string.optional_with_bracket);
        }
        this.mTextViewCategoryName.setText(this.mChoiceSection.f13842name);
        if (this.f60835c.itemChoices.size() > 0) {
            this.mTextViewCategoryHint.setText(getSelectedChoiceNames(this.f60835c));
        } else {
            this.mTextViewCategoryHint.setVisibility(8);
            this.mTextViewCategoryHint.setText(this.mChoiceSection.selectionText);
        }
        OptionalItemAdapters optionalItemAdapters = this.mOptionalItemAdapters;
        ChoiceSection choiceSection3 = this.mChoiceSection;
        optionalItemAdapters.setChoiceItems(choiceSection3, choiceSection3.maxQuantity);
    }

    private boolean checkIfItemIsAvailable(int i11) {
        for (ChoiceSection choiceSection : GlobalDataModel.SELECTED.cartMenuItem.choiceSections) {
            if (choiceSection.parentItemId == i11) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean hasThirdLevelChoices() {
        int i11;
        this.choiceIdStringBuilder = new StringBuilder();
        this.thirdLevelChoiceIds = new ArrayList<>();
        Iterator<ChoiceItem> it = this.mChoiceSection.itemChoices.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            ChoiceItem next = it.next();
            if (next.hasSubChoice) {
                if (!this.thirdLevelChoiceIds.contains(Integer.valueOf(next.f13839id)) && (i11 = next.f13839id) > 0 && !checkIfItemIsAvailable(i11)) {
                    this.thirdLevelChoiceIds.add(Integer.valueOf(next.f13839id));
                }
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
        this.mTextViewCategoryHint = (TalabatTextView) view.findViewById(R.id.text_categoryHint);
        this.mTextViewSelectionCriteria = (TalabatTextView) view.findViewById(R.id.tv_selection_criteria);
        this.mImageViewArrow = (ImageView) view.findViewById(R.id.image_arrow);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_requiredChoices);
        this.mRecyclerViewOptionalChoices = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        OptionalItemAdapters optionalItemAdapters = new OptionalItemAdapters(getContext());
        this.mOptionalItemAdapters = optionalItemAdapters;
        optionalItemAdapters.setListener(this);
        this.mRecyclerViewOptionalChoices.setAdapter(this.mOptionalItemAdapters);
        this.mRecyclerViewOptionalChoices.setNestedScrollingEnabled(false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout_headerContainer);
        this.mLinearLayoutHeaderContainer = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (OptionalItemLayout.this.mRecyclerViewOptionalChoices.getVisibility() == 0) {
                    OptionalItemLayout.this.mRecyclerViewOptionalChoices.setVisibility(8);
                    OptionalItemLayout.this.mImageViewArrow.setImageResource(R.drawable.ic_m_choice_chevron_down);
                    return;
                }
                OptionalItemLayout.this.mRecyclerViewOptionalChoices.setVisibility(0);
                OptionalItemLayout.this.mImageViewArrow.setImageResource(R.drawable.ic_m_choice_chevron_up);
                boolean unused = OptionalItemLayout.this.hasThirdLevelChoices();
            }
        });
    }

    public String getSelectedChoiceNames(ChoiceSection choiceSection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(choiceSection.itemChoices);
        choiceSection.itemChoices.clear();
        choiceSection.itemChoices.addAll(linkedHashSet);
        StringBuilder sb2 = new StringBuilder();
        Iterator<ChoiceItem> it = choiceSection.itemChoices.iterator();
        while (it.hasNext()) {
            ChoiceItem next = it.next();
            if (sb2.length() > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(next.f13840name);
        }
        return sb2.toString();
    }

    public ChoiceSection getSelectedChoicesByIDs(int i11) {
        return this.mMultipleItemsSelectorListener.getSelectedChoicesByIDs(i11);
    }

    public void getSelectedSections(ChoiceSection choiceSection) {
        if (this.mMultipleItemsSelectorListener.getSelectedChoicesByIDs(choiceSection.f13841id) == null) {
            this.f60835c = ChoiceSection.createSelectedChoiceSection(this.mChoiceSection);
            return;
        }
        this.f60835c = new ChoiceSection();
        this.f60835c = this.mMultipleItemsSelectorListener.getSelectedChoicesByIDs(choiceSection.f13841id);
    }

    public void itemSelectionChanged(ChoiceItem choiceItem, boolean z11) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z11) {
            if (!this.f60835c.itemChoices.contains(choiceItem)) {
                this.f60835c.itemChoices.add(choiceItem);
            }
            linkedHashSet.addAll(this.f60835c.itemChoices);
        } else {
            linkedHashSet.addAll(this.f60835c.itemChoices);
            linkedHashSet.remove(choiceItem);
        }
        this.f60835c.itemChoices.clear();
        this.f60835c.itemChoices.addAll(linkedHashSet);
        if (this.f60835c.itemChoices.size() > 0) {
            this.mTextViewCategoryHint.setVisibility(0);
            this.mTextViewCategoryHint.setText(getSelectedChoiceNames(this.f60835c));
            this.mTextViewCategoryHint.setTextColor(Color.parseColor("#757575"));
            int size = this.f60835c.itemChoices.size();
            ChoiceSection choiceSection = this.f60835c;
            if (size == choiceSection.maxQuantity) {
                this.mTextViewSelectionCriteria.setVisibility(8);
            } else if (choiceSection.itemChoices.size() < this.f60835c.maxQuantity) {
                this.mTextViewSelectionCriteria.setVisibility(0);
            }
        } else {
            this.mTextViewCategoryHint.setVisibility(8);
            if (this.f60835c.itemChoices.size() < this.f60835c.maxQuantity) {
                this.mTextViewSelectionCriteria.setVisibility(0);
            }
        }
        this.mMultipleItemsSelectorListener.itemSelectionChanged(this.f60835c);
        this.mMultipleItemsSelectorListener.itemSelectionChangedPriceChange(choiceItem, z11);
    }

    public void setChoiceSection(ChoiceSection choiceSection, int i11) {
        this.mChoiceSection = choiceSection;
        this.f60834b = i11;
        getSelectedSections(choiceSection);
        buildUI();
    }

    public void setMultipleItemsSelectorListener(RequiredItemLayout.OnItemSelectedListener onItemSelectedListener) {
        this.mMultipleItemsSelectorListener = onItemSelectedListener;
    }

    public void setRequiredError(boolean z11) {
        getSelectedSections(this.mChoiceSection);
        this.mTextViewCategoryHint.setVisibility(0);
        if (z11) {
            this.mTextViewCategoryHint.setText(getContext().getString(R.string.required));
            this.mTextViewCategoryHint.setTextColor(-65536);
        } else {
            if (this.f60835c.itemChoices.size() > 0) {
                this.mTextViewCategoryHint.setText(getSelectedChoiceNames(this.f60835c));
            } else {
                this.mTextViewCategoryHint.setVisibility(8);
            }
            this.mTextViewCategoryHint.setTextColor(Color.parseColor("#757575"));
        }
        this.mOptionalItemAdapters.notifyDataSetChanged();
    }

    public void showMaxChoicesNumberReachedDialog() {
        new AlertDialog.Builder(getContext()).setTitle((CharSequence) getContext().getString(R.string.error)).setMessage((CharSequence) getContext().getString(R.string.max_choices_reached)).setPositiveButton((CharSequence) getContext().getString(R.string.f54881ok), (DialogInterface.OnClickListener) null).show();
    }
}
