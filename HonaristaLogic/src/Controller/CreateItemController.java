
public class CreateItemController {


    private createItemModel model;
    private createItemView view;

    public CreateItemController(createItemModel model, createItemView view){
        this.model = model;
        this.view = view;
    }

    public void setItemTitle(String name){
        model.setTitle(name);
    }

    public void setItemDescription(String des){
        model.setDescription(des);
    }

    public void setItemOwner(String owner){
        model.setOwner(owner);
    }

    public void setItemPhoto(){
        model.setPhoto();
    }

    public void updateView(){
        view.Update(model.getPhoto(), model.getOwner() , model.getTitle());
    }

}
