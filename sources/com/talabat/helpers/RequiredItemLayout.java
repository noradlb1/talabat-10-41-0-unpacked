package com.talabat.helpers;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.adapters.RequiredItemAdapters;
import com.talabat.helpers.GlobalDataModel;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class RequiredItemLayout extends CardView implements RequiredItemAdapters.OnItemSelectedListener {
    private static final String TAG = "RequiredItemLayout";

    /* renamed from: b  reason: collision with root package name */
    public ChoiceSection f60837b;

    /* renamed from: c  reason: collision with root package name */
    public ChoiceSection f60838c;
    private StringBuilder choiceIdStringBuilder;

    /* renamed from: d  reason: collision with root package name */
    public OnItemSelectedListener f60839d;
    /* access modifiers changed from: private */
    public ImageView mImageViewArrow;
    private LinearLayout mLinearLayoutHeaderContainer;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerViewRequiredChoices;
    private RequiredItemAdapters mRequiredItemAdapters;
    private int mSectionPostion;
    private TalabatTextView mTextViewCategoryHint;
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

    public RequiredItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(LayoutInflater.from(getContext()).inflate(R.layout.item_mandatory_choice, this));
    }

    private void buildUI() {
        this.mTextViewSelectionCriteria.setVisibility(0);
        this.mTextViewSelectionCriteria.setText(this.f60837b.selectionText);
        if (!this.f60837b.f13842name.isEmpty()) {
            this.mTextViewCategoryName.setText(this.f60837b.f13842name);
        }
        if (this.f60838c.itemChoices.size() > 0) {
            this.mTextViewCategoryHint.setText(getSelectedChoiceNames(this.f60838c));
            this.mTextViewSelectionCriteria.setVisibility(8);
            this.mTextViewCategoryHint.setVisibility(0);
            this.mRecyclerViewRequiredChoices.setVisibility(8);
            this.mImageViewArrow.setImageResource(R.drawable.ic_m_choice_chevron_down);
        } else {
            this.mTextViewCategoryHint.setVisibility(8);
            this.mTextViewSelectionCriteria.setVisibility(0);
            this.mRecyclerViewRequiredChoices.setVisibility(0);
            this.mImageViewArrow.setImageResource(R.drawable.ic_m_choice_chevron_up);
        }
        this.mRequiredItemAdapters.setChoiceItems(this.f60837b);
        if (hasThirdLevelChoices() && this.choiceIdStringBuilder.length() > 0) {
            this.f60839d.onThirdLevelChoiceAvailable(this.choiceIdStringBuilder.toString(), this.thirdLevelChoiceIds);
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
        Iterator<ChoiceItem> it = this.f60837b.itemChoices.iterator();
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
        this.mTextViewCategoryHint = (TalabatTextView) view.findViewById(R.id.text_categoryHint);
        this.mTextViewSelectionCriteria = (TalabatTextView) view.findViewById(R.id.tv_selection_criteria);
        this.mImageViewArrow = (ImageView) view.findViewById(R.id.image_arrow);
        this.mRecyclerViewRequiredChoices = (RecyclerView) view.findViewById(R.id.recyclerView_requiredChoices);
        this.mRecyclerViewRequiredChoices.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RequiredItemAdapters requiredItemAdapters = new RequiredItemAdapters(getContext());
        this.mRequiredItemAdapters = requiredItemAdapters;
        this.mRecyclerViewRequiredChoices.setAdapter(requiredItemAdapters);
        this.mRequiredItemAdapters.setOnItemSelectedListener(this);
        this.mRecyclerViewRequiredChoices.setNestedScrollingEnabled(false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout_headerContainer);
        this.mLinearLayoutHeaderContainer = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (RequiredItemLayout.this.mRecyclerViewRequiredChoices.getVisibility() == 0) {
                    RequiredItemLayout.this.mRecyclerViewRequiredChoices.setVisibility(8);
                    RequiredItemLayout.this.mImageViewArrow.setImageResource(R.drawable.ic_m_choice_chevron_down);
                    return;
                }
                RequiredItemLayout.this.mRecyclerViewRequiredChoices.setVisibility(0);
                RequiredItemLayout.this.mImageViewArrow.setImageResource(R.drawable.ic_m_choice_chevron_up);
            }
        });
    }

    public String getSelectedChoiceNames(ChoiceSection choiceSection) {
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
        return this.f60839d.getSelectedChoicesByIDs(i11);
    }

    public boolean isChoiceItemSelected(int i11, int i12) {
        return false;
    }

    public void itemSelectionChanged(ChoiceItem choiceItem, boolean z11) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z11) {
            this.mRecyclerViewRequiredChoices.setVisibility(8);
            this.mImageViewArrow.setImageResource(R.drawable.ic_m_choice_chevron_down);
            if (this.f60838c.itemChoices.size() > 0) {
                Iterator<ChoiceItem> it = this.f60838c.itemChoices.iterator();
                while (it.hasNext()) {
                    ChoiceItem next = it.next();
                    if (next != choiceItem) {
                        this.f60838c.itemChoices.remove(next);
                    }
                }
            }
            if (!this.f60838c.itemChoices.contains(choiceItem)) {
                this.f60838c.itemChoices.add(choiceItem);
            }
            linkedHashSet.addAll(this.f60838c.itemChoices);
        } else {
            this.mRecyclerViewRequiredChoices.setVisibility(0);
            linkedHashSet.addAll(this.f60838c.itemChoices);
            linkedHashSet.remove(choiceItem);
        }
        this.f60838c.itemChoices.clear();
        this.f60838c.itemChoices.addAll(linkedHashSet);
        if (this.f60838c.itemChoices.size() > 0) {
            this.mTextViewCategoryHint.setVisibility(0);
            this.mTextViewCategoryHint.setText(getSelectedChoiceNames(this.f60838c));
            this.mTextViewCategoryHint.setTextColor(Color.parseColor("#757575"));
            int size = this.f60838c.itemChoices.size();
            ChoiceSection choiceSection = this.f60838c;
            if (size == choiceSection.maxQuantity) {
                this.mTextViewSelectionCriteria.setVisibility(8);
            } else if (choiceSection.itemChoices.size() < this.f60838c.maxQuantity) {
                this.mTextViewSelectionCriteria.setVisibility(0);
            }
        } else {
            this.mTextViewCategoryHint.setVisibility(8);
            if (this.f60838c.itemChoices.size() < this.f60838c.maxQuantity) {
                this.mTextViewSelectionCriteria.setVisibility(0);
            }
        }
        this.f60839d.itemSelectionChanged(this.f60838c);
        this.f60839d.itemSelectionChangedPriceChange(choiceItem, z11);
    }

    public void setChoiceSection(ChoiceSection choiceSection, int i11) {
        this.f60837b = choiceSection;
        this.mSectionPostion = i11;
        if (this.f60839d.getSelectedChoicesByIDs(choiceSection.f13841id) == null) {
            this.f60838c = ChoiceSection.createSelectedChoiceSection(this.f60837b);
        } else {
            this.f60838c = this.f60839d.getSelectedChoicesByIDs(choiceSection.f13841id);
        }
        buildUI();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f60839d = onItemSelectedListener;
    }

    public void setRequiredError(boolean z11) {
        this.mTextViewCategoryHint.setVisibility(0);
        if (z11) {
            this.mTextViewCategoryHint.setText(getContext().getString(R.string.required));
            this.mTextViewCategoryHint.setTextColor(-65536);
        } else {
            if (this.f60838c.itemChoices.size() > 0) {
                this.mTextViewCategoryHint.setText(getSelectedChoiceNames(this.f60838c));
            } else {
                this.mTextViewCategoryHint.setVisibility(8);
            }
            this.mTextViewCategoryHint.setTextColor(Color.parseColor("#757575"));
        }
        this.mRequiredItemAdapters.notifyDataSetChanged();
    }

    public void setSelectedChoiceItem(ChoiceItem choiceItem, ChoiceSection choiceSection, int i11) {
        this.f60839d.setSelectedChoiceItem(choiceItem, choiceSection, this.mSectionPostion);
    }
}
