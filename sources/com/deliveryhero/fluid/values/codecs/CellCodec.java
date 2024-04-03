package com.deliveryhero.fluid.values.codecs;

import com.deliveryhero.fluid.values.codecs.ValueCodec;
import com.deliveryhero.fluid.widgets.collections.RawCell;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/values/codecs/CellCodec;", "DecodedT", "", "Lcom/deliveryhero/fluid/values/codecs/ValueCodec$Composite;", "", "Lcom/deliveryhero/fluid/widgets/collections/RawCell;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CellCodec<DecodedT> extends ValueCodec.Composite<List<? extends DecodedT>, List<? extends RawCell>> {
}
