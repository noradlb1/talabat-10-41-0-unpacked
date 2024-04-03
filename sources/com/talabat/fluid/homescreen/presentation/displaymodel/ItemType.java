package com.talabat.fluid.homescreen.presentation.displaymodel;

import com.talabat.gem.integration.GemAccessor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/ItemType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COLLECTION", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ItemType {
    COLLECTION(GemAccessor.COMPONENT_COLLECTION);
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluid/homescreen/presentation/displaymodel/ItemType$Companion;", "", "()V", "from", "Lcom/talabat/fluid/homescreen/presentation/displaymodel/ItemType;", "value", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ItemType from(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            for (ItemType itemType : ItemType.values()) {
                if (Intrinsics.areEqual((Object) itemType.getValue(), (Object) str)) {
                    return itemType;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private ItemType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
