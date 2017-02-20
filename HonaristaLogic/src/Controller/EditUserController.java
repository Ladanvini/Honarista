package Controller;
import Service.UserService;
public class EditUserController {

    private UserService _model;
    //private editUserView view;

    public EditUserController(UserService model /*, editUserView view*/){
        this._model = model;
        //this.view = view;
    }

    public void setFullName(int id, String fName, String pass, String email, String adr, String phone){
    	//TODO
    }

/*TODO
    public void setUserPhoto(){
        model.setPhoto();
    }

    public void updateView(){
        view.Update(model.getPhoto(), model.getOwner() , model.getTitle());
    }
*/
}
