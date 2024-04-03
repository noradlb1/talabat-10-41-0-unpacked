package library.talabat.mvp.choices;

import datamodels.ChoiceItem;
import java.util.ArrayList;
import library.talabat.mvp.IGlobalPresenter;

public interface IChoicePresenter extends IGlobalPresenter {
    void deleteChoiceItem(ChoiceItem choiceItem);

    void doneButtonPressed();

    ArrayList<ChoiceItem> getSelectedChoiceItems();

    boolean isChoicePresentOnLoad();

    boolean isDoneButtonShown();

    void selectChoiceItem(ChoiceItem choiceItem);

    void showChoiceItems();
}
