package Controller;

import Service.UserService;
public class CreateUserController {

    private UserService _model;
    //private createUserView view;

    public CreateUserController(UserService model /*, createUserView view*/){
        this._model = model;
        //this.view = view;
    }

    public void setUserDetails(String fName, String uname, String pass, 
    		String email, String adr, String role, String phoneNum){
    	int r = role.charAt(0) + 48;
    	
    	_model.createNewUser(uname, fName, adr, phoneNum, r);
    }

/*TODO
    public void setUserPhoto(){
        model.setPhoto();
    }
    public void updateView(){
        view.Update(model.getPhoto(), model.getUsername() , model.getPass());
    }
*/
}
