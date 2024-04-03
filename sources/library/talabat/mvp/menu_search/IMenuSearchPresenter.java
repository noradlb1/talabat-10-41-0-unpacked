package library.talabat.mvp.menu_search;

import android.content.Context;
import android.widget.EditText;
import datamodels.CartMenuItem;
import datamodels.MenuItem;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;

public interface IMenuSearchPresenter {
    void addItem(Restaurant restaurant, CartMenuItem cartMenuItem);

    void changeRestaurantAndAddItem(Context context, Restaurant restaurant, CartMenuItem cartMenuItem);

    void clearEditText();

    void clearQuery();

    void clearSearchHistoryList();

    void disableAutoSearch(boolean z11);

    void getChoiceSection(int i11);

    List<MenuItem> getMenuItems();

    ArrayList<String> getRecentSearchHistoryList();

    void handleMenuWithChoiceClick();

    void handleMenuWithoutChoiceClick();

    void setNewPageNumber(int i11);

    void setTagsString(String str);

    void setUpSearchThreads(EditText editText, int i11);
}
