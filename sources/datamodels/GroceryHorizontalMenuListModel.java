package datamodels;

import android.util.Pair;
import com.talabat.helpers.GlobalDataModel;
import java.util.ArrayList;
import java.util.Iterator;

public class GroceryHorizontalMenuListModel {
    private ArrayList<GroceryHorizontalRowDataModel> menuListItems;
    ArrayList<Pair<MenuSection, Integer>> menuSectionsAndPositon = new ArrayList<>();

    public void createMenuDisplayModel(ArrayList<MenuSection> arrayList, ArrayList<MenuItem> arrayList2, int i11) {
        this.menuListItems = new ArrayList<>();
        Iterator<MenuSection> it = arrayList.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            MenuSection next = it.next();
            GroceryHorizontalRowDataModel groceryHorizontalRowDataModel = new GroceryHorizontalRowDataModel();
            ArrayList arrayList3 = new ArrayList();
            groceryHorizontalRowDataModel.setMenuSection(next);
            this.menuSectionsAndPositon.add(new Pair(next, Integer.valueOf(i12)));
            int i13 = i12 + 1;
            Iterator<MenuItem> it2 = arrayList2.iterator();
            int i14 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                MenuItem next2 = it2.next();
                if (next2.price == 0.0f && !GlobalDataModel.MENU.priceOnSelectionItemAvailable) {
                    GlobalDataModel.MENU.priceOnSelectionItemAvailable = true;
                }
                if (next2.menuSectionId == next.f13863id && i14 <= i11) {
                    if (i14 >= i11) {
                        groceryHorizontalRowDataModel.setShowMore(true);
                        break;
                    } else {
                        arrayList3.add(next2);
                        i14++;
                    }
                }
            }
            i12 = i13 + 1;
            groceryHorizontalRowDataModel.setAllMenuItems(arrayList3);
            this.menuListItems.add(groceryHorizontalRowDataModel);
        }
    }

    public GroceryHorizontalRowDataModel getItemAtIndex(int i11) {
        return this.menuListItems.get(i11);
    }

    public int getLastItemPosition() {
        return this.menuListItems.size() - 1;
    }

    public int getMenuListItemCount() {
        return this.menuListItems.size();
    }
}
