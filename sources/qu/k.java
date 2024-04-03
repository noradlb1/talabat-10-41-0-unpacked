package qu;

import com.talabat.sidemenu.SideMenuRecyclerViewAdapter;
import com.talabat.sidemenu.SidemenuExpandableListItem;
import j$.util.function.Predicate;

public final /* synthetic */ class k implements Predicate {
    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return SideMenuRecyclerViewAdapter.lambda$isBnplOptionShowing$2((SidemenuExpandableListItem) obj);
    }
}
