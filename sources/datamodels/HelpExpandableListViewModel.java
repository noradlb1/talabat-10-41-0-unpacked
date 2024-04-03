package datamodels;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldatamodels/HelpExpandableListViewModel;", "", "()V", "desc", "Ljava/util/ArrayList;", "Ldatamodels/HelpQuickDesc;", "Lkotlin/collections/ArrayList;", "getDesc", "()Ljava/util/ArrayList;", "setDesc", "(Ljava/util/ArrayList;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpExpandableListViewModel {
    @Nullable
    private ArrayList<HelpQuickDesc> desc;
    @Nullable
    private String title;

    @Nullable
    public final ArrayList<HelpQuickDesc> getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final void setDesc(@Nullable ArrayList<HelpQuickDesc> arrayList) {
        this.desc = arrayList;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }
}
