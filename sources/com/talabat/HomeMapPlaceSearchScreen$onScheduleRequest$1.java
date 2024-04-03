package com.talabat;

import android.os.Handler;
import android.widget.ProgressBar;
import com.materialedittext.MaterialEditText;
import com.talabat.helpers.TalabatUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/HomeMapPlaceSearchScreen$onScheduleRequest$1", "Ljava/lang/Runnable;", "run", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapPlaceSearchScreen$onScheduleRequest$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapPlaceSearchScreen f54198b;

    public HomeMapPlaceSearchScreen$onScheduleRequest$1(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen) {
        this.f54198b = homeMapPlaceSearchScreen;
    }

    public void run() {
        if (this.f54198b.timeleft >= 0) {
            HomeMapPlaceSearchScreen homeMapPlaceSearchScreen = this.f54198b;
            homeMapPlaceSearchScreen.timeleft = homeMapPlaceSearchScreen.timeleft - 1;
            if (TalabatUtils.isNullOrEmpty(StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) this.f54198b._$_findCachedViewById(R.id.ed_search_location)).getText())).toString())) {
                ProgressBar progressBar = (ProgressBar) this.f54198b._$_findCachedViewById(R.id.places_loading_indicator);
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                this.f54198b.searchClearVisible();
            }
            this.f54198b.requestScheduled = true;
            Handler mHandler = this.f54198b.getMHandler();
            if (mHandler != null) {
                mHandler.postDelayed(this, 200);
                return;
            }
            return;
        }
        Handler mHandler2 = this.f54198b.getMHandler();
        if (mHandler2 != null) {
            mHandler2.removeCallbacks(this);
        }
        this.f54198b.requestScheduled = false;
        HomeMapPlaceSearchScreen homeMapPlaceSearchScreen2 = this.f54198b;
        int i11 = R.id.ed_search_location;
        if (!TalabatUtils.isNullOrEmpty(StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) homeMapPlaceSearchScreen2._$_findCachedViewById(i11)).getText())).toString())) {
            HomeMapPlaceSearchScreen homeMapPlaceSearchScreen3 = this.f54198b;
            homeMapPlaceSearchScreen3.requestPlaceSuggestions(StringsKt__StringsKt.trim((CharSequence) String.valueOf(((MaterialEditText) homeMapPlaceSearchScreen3._$_findCachedViewById(i11)).getText())).toString());
        }
    }
}
