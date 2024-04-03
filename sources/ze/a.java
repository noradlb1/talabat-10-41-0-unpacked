package ze;

import android.view.View;
import com.talabat.adapters.homeMap.ChooseSavedAddressListAdapter;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ChooseSavedAddressListAdapter f58051b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f58052c;

    public /* synthetic */ a(ChooseSavedAddressListAdapter chooseSavedAddressListAdapter, Ref.ObjectRef objectRef) {
        this.f58051b = chooseSavedAddressListAdapter;
        this.f58052c = objectRef;
    }

    public final void onClick(View view) {
        ChooseSavedAddressListAdapter.m9499onBindViewHolder$lambda0(this.f58051b, this.f58052c, view);
    }
}
