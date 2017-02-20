package Controller;

import Service.ItemService;
public class EditItemController {

    private ItemService _model;
    //private editItemView view;

    public EditItemController(ItemService model /*, editItemView view*/){
        this._model = model;
        //this.view = view;
    }

    public void setItemDetails(int id, String name, String des){
    	_model.editItem(id, name, des);
    }

/*TODO
 *     public void setItemPhoto(){
        model.setPhoto();
    }

    public void updateView(){
        view.Update(model.getPhoto(), model.getOwner() , model.getTitle());
    }
*/
}
