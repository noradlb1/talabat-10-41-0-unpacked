package library.talabat.mvp.choices;

import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;

public interface ChoiceView {
    void onChoiceItemDeSelected(ChoiceItem choiceItem);

    void onChoiceItemSelected(ChoiceItem choiceItem);

    void onChoiceItemSwiched(ChoiceItem choiceItem, ChoiceItem choiceItem2);

    void onCompleteChoiceSelection(ChoiceSection choiceSection);

    void onNoChoiceSelected();

    void refreshList();

    void setChoiceHint(String str);

    void setChoiceItems(ArrayList<ChoiceItem> arrayList);

    void setChoiceSectionName(String str);

    void setDoneButtonEnabled(boolean z11);

    void setSeletedChoiceItems(ArrayList<ChoiceItem> arrayList);

    void showChoiceOverSelectedAlert(int i11);

    void showMinChoiceNotSelectedAlert(int[] iArr);
}
