package Controller;

import Service.ItemService;
public class CreateItemController {

//Model is service Model
	
    private ItemService _model;
//    private createItemView view;

    public CreateItemController(ItemService model /*, createItemView view*/){
        this._model = model;
//        this.view = view;
    }

    public void setItemDetails(String name, String des){
    	_model.createNewItem(name, des);
    	
    }

/*    public void setItemPhoto(){
        model.setPhoto();
    }

    public void updateView(){
        view.Update(model.getPhoto(), model.getOwner() , model.getTitle());
    }
*/
}
