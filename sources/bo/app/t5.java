package bo.app;

import com.braze.models.IPutIntoJson;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lbo/app/t5;", "", "Lcom/braze/models/IPutIntoJson;", "", "v", "<init>", "(Ljava/lang/String;I)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public enum t5 implements IPutIntoJson<String> {
    SUBSCRIBED,
    UNSUBSCRIBED;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39418a = null;

        static {
            int[] iArr = new int[t5.values().length];
            iArr[t5.SUBSCRIBED.ordinal()] = 1;
            iArr[t5.UNSUBSCRIBED.ordinal()] = 2;
            f39418a = iArr;
        }
    }

    /* renamed from: v */
    public String forJsonPut() {
        int i11 = a.f39418a[ordinal()];
        if (i11 == 1) {
            return "subscribed";
        }
        if (i11 == 2) {
            return "unsubscribed";
        }
        throw new NoWhenBranchMatchedException();
    }
}
