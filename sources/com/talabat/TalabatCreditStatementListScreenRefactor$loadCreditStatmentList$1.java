package com.talabat;

import android.annotation.TargetApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"com/talabat/TalabatCreditStatementListScreenRefactor$loadCreditStatmentList$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "currentScrollPosition", "", "getCurrentScrollPosition", "()I", "setCurrentScrollPosition", "(I)V", "onScrolled", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditStatementListScreenRefactor$loadCreditStatmentList$1 extends RecyclerView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TalabatCreditStatementListScreenRefactor f55074a;
    private int currentScrollPosition;

    public TalabatCreditStatementListScreenRefactor$loadCreditStatmentList$1(TalabatCreditStatementListScreenRefactor talabatCreditStatementListScreenRefactor) {
        this.f55074a = talabatCreditStatementListScreenRefactor;
    }

    public final int getCurrentScrollPosition() {
        return this.currentScrollPosition;
    }

    @TargetApi(21)
    public void onScrolled(@NotNull RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.checkNotNullParameter(recyclerView, "view");
        int i13 = this.currentScrollPosition + i12;
        this.currentScrollPosition = i13;
        if (i13 == 0) {
            TalabatCreditStatementListScreenRefactor talabatCreditStatementListScreenRefactor = this.f55074a;
            int i14 = R.id.tal_credit_statment_container;
            ((CardView) talabatCreditStatementListScreenRefactor._$_findCachedViewById(i14)).setElevation(0.0f);
            ((CardView) this.f55074a._$_findCachedViewById(i14)).setMaxCardElevation(0.0f);
            return;
        }
        TalabatCreditStatementListScreenRefactor talabatCreditStatementListScreenRefactor2 = this.f55074a;
        int i15 = R.id.tal_credit_statment_container;
        ((CardView) talabatCreditStatementListScreenRefactor2._$_findCachedViewById(i15)).setElevation(50.0f);
        ((CardView) this.f55074a._$_findCachedViewById(i15)).setMaxCardElevation(24.0f);
    }

    public final void setCurrentScrollPosition(int i11) {
        this.currentScrollPosition = i11;
    }
}
