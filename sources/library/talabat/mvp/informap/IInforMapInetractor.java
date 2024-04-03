package library.talabat.mvp.informap;

import JsonModels.Request.InforMapRequest;
import library.talabat.mvp.IGlobalInteractor;

public interface IInforMapInetractor extends IGlobalInteractor {
    void mapInforMapAddressObjectConvertor(boolean z11, int i11, InforMapRequest inforMapRequest);
}
