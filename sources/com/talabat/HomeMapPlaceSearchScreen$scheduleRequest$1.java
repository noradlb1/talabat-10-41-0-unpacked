package com.talabat;

import android.os.Handler;
import android.widget.ProgressBar;
import com.materialedittext.MaterialEditText;
import com.talabat.helpers.TalabatUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/HomeMapPlaceSearchScreen$scheduleRequest$1", "Ljava/lang/Runnable;", "run", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapPlaceSearchScreen$scheduleRequest$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapPlaceSearchScreen f54199b;

    public HomeMapPlaceSearchScreen$scheduleRequest$1(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen) {
        this.f54199b = homeMapPlaceSearchScreen;
    }

    public void run() {
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        if (this.f54199b.timeleft >= 0) {
            HomeMapPlaceSearchScreen homeMapPlaceSearchScreen = this.f54199b;
            homeMapPlaceSearchScreen.timeleft = homeMapPlaceSearchScreen.timeleft - 1;
            String valueOf = String.valueOf(((MaterialEditText) this.f54199b._$_findCachedViewById(R.id.ed_search_location)).getText());
            int length = valueOf.length() - 1;
            int i14 = 0;
            boolean z14 = false;
            while (i14 <= length) {
                if (!z14) {
                    i13 = i14;
                } else {
                    i13 = length;
                }
                if (Intrinsics.compare((int) valueOf.charAt(i13), 32) <= 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z14) {
                    if (!z13) {
                        z14 = true;
                    } else {
                        i14++;
                    }
                } else if (!z13) {
                    break;
                } else {
                    length--;
                }
            }
            if (TalabatUtils.isNullOrEmpty(valueOf.subSequence(i14, length + 1).toString())) {
                ProgressBar progressBar = (ProgressBar) this.f54199b._$_findCachedViewById(R.id.places_loading_indicator);
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                this.f54199b.searchClearVisible();
            }
            this.f54199b.requestScheduled = true;
            Handler mHandler = this.f54199b.getMHandler();
            if (mHandler != null) {
                mHandler.postDelayed(this, 200);
                return;
            }
            return;
        }
        Handler mHandler2 = this.f54199b.getMHandler();
        if (mHandler2 != null) {
            mHandler2.removeCallbacks(this);
        }
        this.f54199b.requestScheduled = false;
        String valueOf2 = String.valueOf(((MaterialEditText) this.f54199b._$_findCachedViewById(R.id.ed_search_location)).getText());
        int length2 = valueOf2.length() - 1;
        int i15 = 0;
        boolean z15 = false;
        while (i15 <= length2) {
            if (!z15) {
                i12 = i15;
            } else {
                i12 = length2;
            }
            if (Intrinsics.compare((int) valueOf2.charAt(i12), 32) <= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z15) {
                if (!z12) {
                    z15 = true;
                } else {
                    i15++;
                }
            } else if (!z12) {
                break;
            } else {
                length2--;
            }
        }
        if (!TalabatUtils.isNullOrEmpty(valueOf2.subSequence(i15, length2 + 1).toString())) {
            HomeMapPlaceSearchScreen homeMapPlaceSearchScreen2 = this.f54199b;
            String valueOf3 = String.valueOf(((MaterialEditText) homeMapPlaceSearchScreen2._$_findCachedViewById(R.id.ed_search_location)).getText());
            int length3 = valueOf3.length() - 1;
            int i16 = 0;
            boolean z16 = false;
            while (i16 <= length3) {
                if (!z16) {
                    i11 = i16;
                } else {
                    i11 = length3;
                }
                if (Intrinsics.compare((int) valueOf3.charAt(i11), 32) <= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z16) {
                    if (!z11) {
                        z16 = true;
                    } else {
                        i16++;
                    }
                } else if (!z11) {
                    break;
                } else {
                    length3--;
                }
            }
            homeMapPlaceSearchScreen2.requestPlaceSuggestions(valueOf3.subSequence(i16, length3 + 1).toString());
        }
    }
}
