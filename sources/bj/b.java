package bj;

import android.view.View;
import com.talabat.darkstores.feature.categories.subcategories.sort.SortOptionBottomSheet;
import java.util.List;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f50866b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SortOptionBottomSheet f50867c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f50868d;

    public /* synthetic */ b(List list, SortOptionBottomSheet sortOptionBottomSheet, Ref.IntRef intRef) {
        this.f50866b = list;
        this.f50867c = sortOptionBottomSheet;
        this.f50868d = intRef;
    }

    public final void onClick(View view) {
        SortOptionBottomSheet.m9933onViewCreated$lambda2(this.f50866b, this.f50867c, this.f50868d, view);
    }
}
