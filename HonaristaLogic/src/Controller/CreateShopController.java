
public class CreateShopController {

    private createShopModel model;
    private createShopView view;

    public CreateShopController(createShopModel model, createShopView view){
        this.model = model;
        this.view = view;
    }

    public void setShopTitle(String name){
        model.setTitle(name);
    }

    public void setShopDescription(String des){
        model.setDescription(des);
    }

    public void setShopOwner(String owner){
        model.setOwner(owner);
    }

    public void setShopPhoto(){
        model.setPhoto();
    }

    public void setShopType(String type){
        model.setType(type);
    }

    public void updateView(){
        view.Update(model.getPhoto(), model.getOwner() , model.getType());
    }

}
