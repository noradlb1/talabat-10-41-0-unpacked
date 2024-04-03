package j$.util;

import j$.time.Instant;
import java.util.Date;

public final /* synthetic */ class DateRetargetClass {
    public static /* synthetic */ Instant toInstant(Date date) {
        return date instanceof DateRetargetInterface ? ((DateRetargetInterface) date).toInstant() : DesugarDate.toInstant(date);
    }
}
