package library.talabat.mvp.talabatgo;

import JsonModels.LiveTrackJson;
import library.talabat.mvp.IGlobalListener;

public interface TalabatGOListener extends IGlobalListener {
    void onDriverLocationReceived(LiveTrackJson liveTrackJson);
}
