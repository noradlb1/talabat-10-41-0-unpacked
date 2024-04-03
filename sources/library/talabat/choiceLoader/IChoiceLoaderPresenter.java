package library.talabat.choiceLoader;

import java.util.ArrayList;
import library.talabat.mvp.IGlobalPresenter;

public interface IChoiceLoaderPresenter extends IGlobalPresenter {
    void setRequestItemIds(int i11, ArrayList<String> arrayList);

    void stopChoiceLoading();
}
