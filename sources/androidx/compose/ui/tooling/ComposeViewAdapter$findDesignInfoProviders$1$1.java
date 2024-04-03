package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.Group;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/compose/ui/tooling/data/Group;", "group", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComposeViewAdapter$findDesignInfoProviders$1$1 extends Lambda implements Function1<Group, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposeViewAdapter f10234g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter$findDesignInfoProviders$1$1(ComposeViewAdapter composeViewAdapter) {
        super(1);
        this.f10234g = composeViewAdapter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.tooling.data.Group r6) {
        /*
            r5 = this;
            java.lang.String r0 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.Collection r6 = r6.getChildren()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            androidx.compose.ui.tooling.ComposeViewAdapter r0 = r5.f10234g
            boolean r1 = r6 instanceof java.util.Collection
            r2 = 0
            if (r1 == 0) goto L_0x001c
            r1 = r6
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x001c
            goto L_0x0074
        L_0x001c:
            java.util.Iterator r6 = r6.iterator()
        L_0x0020:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0074
            java.lang.Object r1 = r6.next()
            androidx.compose.ui.tooling.data.Group r1 = (androidx.compose.ui.tooling.data.Group) r1
            java.lang.String r3 = r1.getName()
            java.lang.String r4 = "remember"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            r4 = 1
            if (r3 == 0) goto L_0x0070
            java.util.Collection r1 = r1.getData()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r3 = r1 instanceof java.util.Collection
            if (r3 == 0) goto L_0x004e
            r3 = r1
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x004e
        L_0x004c:
            r1 = r2
            goto L_0x006c
        L_0x004e:
            java.util.Iterator r1 = r1.iterator()
        L_0x0052:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x004c
            java.lang.Object r3 = r1.next()
            if (r3 != 0) goto L_0x0060
            r3 = 0
            goto L_0x0064
        L_0x0060:
            java.lang.reflect.Method r3 = r0.getDesignInfoMethodOrNull(r3)
        L_0x0064:
            if (r3 == 0) goto L_0x0068
            r3 = r4
            goto L_0x0069
        L_0x0068:
            r3 = r2
        L_0x0069:
            if (r3 == 0) goto L_0x0052
            r1 = r4
        L_0x006c:
            if (r1 == 0) goto L_0x0070
            r1 = r4
            goto L_0x0071
        L_0x0070:
            r1 = r2
        L_0x0071:
            if (r1 == 0) goto L_0x0020
            r2 = r4
        L_0x0074:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposeViewAdapter$findDesignInfoProviders$1$1.invoke(androidx.compose.ui.tooling.data.Group):java.lang.Boolean");
    }
}
