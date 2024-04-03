package ze;

import android.view.View;
import com.talabat.adapters.homeMap.GooglePlaceSearchAdapter;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GooglePlaceSearchAdapter f58054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f58055c;

    public /* synthetic */ c(GooglePlaceSearchAdapter googlePlaceSearchAdapter, Ref.ObjectRef objectRef) {
        this.f58054b = googlePlaceSearchAdapter;
        this.f58055c = objectRef;
    }

    public final void onClick(View view) {
        GooglePlaceSearchAdapter.m9501onBindViewHolder$lambda0(this.f58054b, this.f58055c, view);
    }
}
