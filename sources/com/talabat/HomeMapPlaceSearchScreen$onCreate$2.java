package com.talabat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.talabat.adapters.homeMap.GooglePlaceSearchAdapter;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/talabat/HomeMapPlaceSearchScreen$onCreate$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapPlaceSearchScreen$onCreate$2 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapPlaceSearchScreen f54197b;

    public HomeMapPlaceSearchScreen$onCreate$2(HomeMapPlaceSearchScreen homeMapPlaceSearchScreen) {
        this.f54197b = homeMapPlaceSearchScreen;
    }

    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "s");
        if (editable.length() == 0) {
            this.f54197b.previousKeyword = "";
        }
        if (editable.length() > 0) {
            ((RelativeLayout) this.f54197b._$_findCachedViewById(R.id.search_clear)).setVisibility(0);
            if (this.f54197b.isSearchRequestSend) {
                ((ImageView) this.f54197b._$_findCachedViewById(R.id.search_clear_icon)).setVisibility(8);
            } else {
                ((ImageView) this.f54197b._$_findCachedViewById(R.id.search_clear_icon)).setVisibility(0);
            }
        } else {
            ((RelativeLayout) this.f54197b._$_findCachedViewById(R.id.search_clear)).setVisibility(8);
            ((ImageView) this.f54197b._$_findCachedViewById(R.id.search_clear_icon)).setVisibility(8);
            ((RelativeLayout) this.f54197b._$_findCachedViewById(R.id.no_search_result_found)).setVisibility(8);
            this.f54197b.reloadAreaFragment();
        }
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(charSequence, "s");
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i11, int i12, int i13) {
        int i14;
        boolean z11;
        Intrinsics.checkNotNullParameter(charSequence, "s");
        if (this.f54197b.requestScheduled) {
            return;
        }
        if (charSequence.length() > 0) {
            String obj = charSequence.toString();
            int length = obj.length() - 1;
            int i15 = 0;
            boolean z12 = false;
            while (i15 <= length) {
                if (!z12) {
                    i14 = i15;
                } else {
                    i14 = length;
                }
                if (Intrinsics.compare((int) obj.charAt(i14), 32) <= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z12) {
                    if (!z11) {
                        z12 = true;
                    } else {
                        i15++;
                    }
                } else if (!z11) {
                    break;
                } else {
                    length--;
                }
            }
            String obj2 = obj.subSequence(i15, length + 1).toString();
            HomeMapPlaceSearchScreen homeMapPlaceSearchScreen = this.f54197b;
            homeMapPlaceSearchScreen.sendNextRequest = homeMapPlaceSearchScreen.getTimeDifference(System.currentTimeMillis());
            if (!TalabatUtils.isNullOrEmpty(obj2)) {
                Filter filter = null;
                boolean startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.f54197b.previousKeyword, String.valueOf(obj2.charAt(0)), false, 2, (Object) null);
                if (this.f54197b.placesSuggestionArrayList == null) {
                    this.f54197b.requestPlaceSuggestions(obj2);
                } else if (!startsWith$default) {
                    ArrayList access$getPlacesSuggestionArrayList$p = this.f54197b.placesSuggestionArrayList;
                    if (access$getPlacesSuggestionArrayList$p != null) {
                        access$getPlacesSuggestionArrayList$p.clear();
                    }
                    this.f54197b.requestPlaceSuggestions(obj2);
                } else if (this.f54197b.mGooglePlaceSearchAdapter != null) {
                    ProgressBar progressBar = (ProgressBar) this.f54197b._$_findCachedViewById(R.id.places_loading_indicator);
                    if (progressBar != null) {
                        progressBar.setVisibility(8);
                    }
                    this.f54197b.searchClearVisible();
                    GooglePlaceSearchAdapter access$getMGooglePlaceSearchAdapter$p = this.f54197b.mGooglePlaceSearchAdapter;
                    if (access$getMGooglePlaceSearchAdapter$p != null) {
                        filter = access$getMGooglePlaceSearchAdapter$p.getFilter();
                    }
                    Intrinsics.checkNotNull(filter);
                    filter.filter(obj2);
                    if (this.f54197b.sendNextRequest) {
                        this.f54197b.requestPlaceSuggestions(obj2);
                        return;
                    }
                    this.f54197b.scheduleRequest(charSequence.toString());
                } else if (this.f54197b.sendNextRequest) {
                    this.f54197b.requestPlaceSuggestions(obj2);
                } else {
                    this.f54197b.scheduleRequest(charSequence.toString());
                }
            }
        } else {
            this.f54197b.isSearchRequestSend = false;
            this.f54197b.requestScheduled = false;
        }
    }
}
