package library.talabat.mvp.choices;

import com.talabat.helpers.GlobalDataModel;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;
import java.util.Iterator;

public class ChoicePresenter implements IChoicePresenter {
    private boolean choicePresentOnLoad;
    private ChoiceSection choiceSection;
    private ChoiceView choiceView;
    private boolean itemOverSelectedPopipShown = false;
    private ChoiceSection selectedChoiceSection;

    public ChoicePresenter(ChoiceView choiceView2, ChoiceSection choiceSection2) {
        this.choiceView = choiceView2;
        this.choiceSection = choiceSection2;
        ChoiceSection selectedChoiceForSectionId = GlobalDataModel.SELECTED.cartMenuItem.getSelectedChoiceForSectionId(choiceSection2.f13841id);
        ChoiceSection createSelectedChoiceSection = ChoiceSection.createSelectedChoiceSection(choiceSection2);
        this.selectedChoiceSection = createSelectedChoiceSection;
        if (selectedChoiceForSectionId != null) {
            createSelectedChoiceSection.itemChoices = new ArrayList<>();
            this.selectedChoiceSection.itemChoices.addAll(selectedChoiceForSectionId.itemChoices);
            this.choicePresentOnLoad = true;
        }
    }

    private boolean canDismissChoicePopup() {
        if (this.itemOverSelectedPopipShown) {
            this.itemOverSelectedPopipShown = false;
            return false;
        }
        ChoiceSection choiceSection2 = this.selectedChoiceSection;
        if (choiceSection2 == null) {
            return false;
        }
        ChoiceSection choiceSection3 = this.choiceSection;
        int i11 = choiceSection3.maxQuantity;
        int i12 = choiceSection3.minQuantity;
        if (i11 == i12 && i12 != 0 && i11 <= choiceSection2.itemChoices.size()) {
            return true;
        }
        ChoiceSection choiceSection4 = this.choiceSection;
        if (choiceSection4.minQuantity >= choiceSection4.maxQuantity || this.selectedChoiceSection.itemChoices.size() < this.choiceSection.maxQuantity) {
            return false;
        }
        return true;
    }

    private boolean canShowDoneButton() {
        this.itemOverSelectedPopipShown = false;
        ChoiceSection choiceSection2 = this.selectedChoiceSection;
        if (choiceSection2 == null || choiceSection2.itemChoices.size() == 0 || this.choiceSection.minQuantity > this.selectedChoiceSection.itemChoices.size()) {
            return false;
        }
        return true;
    }

    private void deSelectItem(int i11) {
        ChoiceItem choiceItem;
        Iterator<ChoiceItem> it = this.selectedChoiceSection.itemChoices.iterator();
        while (true) {
            if (!it.hasNext()) {
                choiceItem = null;
                break;
            }
            choiceItem = it.next();
            if (choiceItem.f13839id == i11) {
                break;
            }
        }
        if (choiceItem != null) {
            this.selectedChoiceSection.itemChoices.remove(choiceItem);
            this.choiceView.onChoiceItemDeSelected(choiceItem);
        }
    }

    public void deleteChoiceItem(ChoiceItem choiceItem) {
        deSelectItem(choiceItem.f13839id);
    }

    public void doneButtonPressed() {
        ChoiceSection choiceSection2 = this.selectedChoiceSection;
        if (choiceSection2 == null) {
            this.choiceView.onNoChoiceSelected();
        } else if (this.choiceSection.minQuantity > choiceSection2.itemChoices.size()) {
            this.choiceView.showMinChoiceNotSelectedAlert(new int[]{1, 2, 3});
        } else if (this.choiceSection.minQuantity == 0 && this.selectedChoiceSection.itemChoices.size() == 0) {
            this.choiceView.onCompleteChoiceSelection(this.selectedChoiceSection);
        } else {
            this.choiceView.onCompleteChoiceSelection(this.selectedChoiceSection);
        }
    }

    public ArrayList<ChoiceItem> getSelectedChoiceItems() {
        return this.selectedChoiceSection.itemChoices;
    }

    public boolean isChoicePresentOnLoad() {
        return this.choicePresentOnLoad;
    }

    public boolean isDoneButtonShown() {
        return canShowDoneButton();
    }

    public void onDestroy() {
        this.choiceView = null;
    }

    public void selectChoiceItem(ChoiceItem choiceItem) {
        boolean z11;
        Iterator<ChoiceItem> it = this.selectedChoiceSection.itemChoices.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().f13839id == choiceItem.f13839id) {
                    z11 = true;
                    break;
                }
            } else {
                z11 = false;
                break;
            }
        }
        if (z11) {
            deSelectItem(choiceItem.f13839id);
        } else {
            ChoiceSection choiceSection2 = this.selectedChoiceSection;
            int i11 = choiceSection2.maxQuantity;
            if (i11 == 0 || i11 > choiceSection2.itemChoices.size()) {
                this.selectedChoiceSection.itemChoices.add(choiceItem);
                this.choiceView.onChoiceItemSelected(choiceItem);
            } else {
                ChoiceSection choiceSection3 = this.selectedChoiceSection;
                if (choiceSection3.maxQuantity == 1) {
                    this.choiceView.onChoiceItemSwiched(choiceSection3.itemChoices.get(0), choiceItem);
                    this.selectedChoiceSection.itemChoices.remove(0);
                    this.selectedChoiceSection.itemChoices.add(choiceItem);
                } else {
                    this.choiceView.refreshList();
                    this.choiceView.showChoiceOverSelectedAlert(this.choiceSection.maxQuantity);
                    this.itemOverSelectedPopipShown = true;
                }
            }
        }
        if (canDismissChoicePopup()) {
            doneButtonPressed();
        } else {
            this.choiceView.setDoneButtonEnabled(canShowDoneButton());
        }
    }

    public void showChoiceItems() {
        ChoiceSection choiceSection2 = this.selectedChoiceSection;
        if (choiceSection2 != null) {
            this.choiceView.setSeletedChoiceItems(choiceSection2.itemChoices);
        }
        this.choiceView.setChoiceItems(this.choiceSection.itemChoices);
        this.choiceView.setChoiceSectionName(this.choiceSection.f13842name);
        this.choiceView.setChoiceHint(this.choiceSection.selectionText);
    }
}
