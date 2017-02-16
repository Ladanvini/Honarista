
public class EditItemController {

    private editItemModel model;
    private editItemView view;

    public EditItemController(editItemModel model, editItemView view){
        this.model = model;
        this.view = view;
    }

    public void setItemTitle(String name){
        model.setTitle(name);
    }

    public void setItemDescription(String des){
        model.setDescription(des);
    }

    public void setItemPhoto(){
        model.setPhoto();
    }

    public void updateView(){
        view.Update(model.getPhoto(), model.getOwner() , model.getTitle());
    }

}
