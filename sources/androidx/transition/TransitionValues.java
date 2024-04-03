package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class TransitionValues {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Transition> f37812a = new ArrayList<>();
    public final Map<String, Object> values = new HashMap();
    public View view;

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        if (this.view != transitionValues.view || !this.values.equals(transitionValues.values)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + StringUtils.LF) + "    values:";
        for (String next : this.values.keySet()) {
            str = str + "    " + next + ": " + this.values.get(next) + StringUtils.LF;
        }
        return str;
    }

    public TransitionValues(@NonNull View view2) {
        this.view = view2;
    }
}
