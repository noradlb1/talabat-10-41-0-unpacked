package library.talabat.mvp.newrate;

import java.util.ArrayList;
import library.talabat.mvp.IGlobalInteractor;

public interface INewRateInteractor extends IGlobalInteractor {
    void setListener(INewRateListener iNewRateListener);

    void submitRate(String str, String str2, String str3, String str4, ArrayList<String> arrayList, ArrayList<String> arrayList2);
}
