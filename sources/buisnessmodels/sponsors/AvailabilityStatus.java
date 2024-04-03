package buisnessmodels.sponsors;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface AvailabilityStatus {
    public static final int BUSY = 2;
    public static final int CLOSED = 3;
    public static final int OPEN = 0;
    public static final int PRAYER = 4;
    public static final int PRE_ORDER_ONLY = 1;
}
