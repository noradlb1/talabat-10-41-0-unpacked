package com.talabat.sidemenu;

public class SidemenuExpandableListItem {
    public boolean isExpanded;
    public Object object;
    public int type;

    public SidemenuExpandableListItem(Object obj, int i11) {
        this.object = obj;
        this.type = i11;
    }
}
