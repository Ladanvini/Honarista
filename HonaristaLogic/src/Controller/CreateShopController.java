package Controller;

import Service.ShopService;
import Service.UserService;
public class CreateShopController {

    private ShopService _model;
    private UserService _us;
    //    private createShopView view;

    public CreateShopController(ShopService model /*, createShopView view*/){
        this._model = model;
        //this.view = view;
    }

    public void setShopDetails(String name, String adr, String phonenum, String des, String owner, String type){
    	_model.createNewShop(name, adr, phonenum, des, new java.util.Date() );

    	_model.addOwnerTo(
    			_model.getShopWithId(_model.getShopId(name)),
    			_us.getUserFromId(_us.getUserId(owner))
    			);
//TODO shop type    	
    }
/* TODO
    public void setShopPhoto(){
        _model.setPhoto();
    }


    public void updateView(){
        view.Update(model.getPhoto(), model.getOwner() , model.getType());
    }
*/
}
