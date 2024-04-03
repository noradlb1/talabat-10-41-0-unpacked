package library.talabat.mvp.newrate;

import java.util.ArrayList;
import library.talabat.mvp.IGlobalPresenter;

public interface INewRatePresenter extends IGlobalPresenter {
    void submitRate(String str, String str2, String str3, String str4, ArrayList<String> arrayList, ArrayList<String> arrayList2);
}
