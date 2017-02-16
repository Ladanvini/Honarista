
public class EditShopController {
    private editShopModel model;
    private editShopView view;

    public EditShopController(editShopModel model, editShopView view){
        this.model = model;
        this.view = view;
    }

    public void setShopTitle(String name){
        model.setTitle(name);
    }

    public void setShopDescription(String des){
        model.setDescription(des);
    }

    public void setShopPhoto(){
        model.setPhoto();
    }

    public void updateView(){
        view.Update(model.getPhoto(), model.getOwner() , model.getTitle());
    }

}
