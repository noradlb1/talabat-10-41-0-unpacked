package com.deliveryhero.impression;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\nJ#\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/impression/ImpressionProvider;", "", "getImpression", "Lcom/deliveryhero/impression/Impression;", "position", "", "parentPosition", "(ILjava/lang/Integer;)Lcom/deliveryhero/impression/Impression;", "getImpressionValidationRule", "Lcom/deliveryhero/impression/ImpressionValidationRule;", "(ILjava/lang/Integer;)Lcom/deliveryhero/impression/ImpressionValidationRule;", "getItemType", "Lcom/deliveryhero/impression/ImpressionItemType;", "(ILjava/lang/Integer;)Lcom/deliveryhero/impression/ImpressionItemType;", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ImpressionProvider {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Impression getImpression$default(ImpressionProvider impressionProvider, int i11, Integer num, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    num = null;
                }
                return impressionProvider.getImpression(i11, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getImpression");
        }

        public static /* synthetic */ ImpressionValidationRule getImpressionValidationRule$default(ImpressionProvider impressionProvider, int i11, Integer num, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    num = null;
                }
                return impressionProvider.getImpressionValidationRule(i11, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getImpressionValidationRule");
        }

        public static /* synthetic */ ImpressionItemType getItemType$default(ImpressionProvider impressionProvider, int i11, Integer num, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    num = null;
                }
                return impressionProvider.getItemType(i11, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItemType");
        }
    }

    @Nullable
    Impression getImpression(int i11, @Nullable Integer num);

    @Nullable
    ImpressionValidationRule getImpressionValidationRule(int i11, @Nullable Integer num);

    @Nullable
    ImpressionItemType getItemType(int i11, @Nullable Integer num);
}
