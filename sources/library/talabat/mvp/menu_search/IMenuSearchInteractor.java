package library.talabat.mvp.menu_search;

import JsonModels.Response.GroceryResponse.GrocerySearchResponse;
import io.reactivex.Single;
import library.talabat.mvp.IGlobalInteractor;

public interface IMenuSearchInteractor extends IGlobalInteractor {
    void getChoiceSection(int i11);

    Single<GrocerySearchResponse> getDataFromApi(String str, String str2, int i11, String str3, String str4, String str5, String str6);
}
