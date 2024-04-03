package z2;

import coil.EventListener;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a {
    static {
        EventListener.Factory.Companion companion = EventListener.Factory.Companion;
    }

    @JvmStatic
    @NotNull
    @JvmName(name = "create")
    public static EventListener.Factory a(@NotNull EventListener eventListener) {
        return EventListener.Factory.Companion.create(eventListener);
    }
}
