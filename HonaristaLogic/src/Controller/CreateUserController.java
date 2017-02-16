
public class CreateUserController {

    private createUserModel model;
    private createUserView view;

    public CreateUserController(createUserModel model, createUserView view){
        this.model = model;
        this.view = view;
    }

    public void setFullName(String fName){
        model.setFullName();
    }

    public void setUserName(String uname){
        model.setuserName(uname);
    }

    public void setPassword(String pass){
        model.setPassword(pass);
    }

    public void setEmail(String email){
        model.setEmail(email);
    }

    public void setUserPhoto(){
        model.setPhoto();
    }

    public void setUserAddress(String address){
        model.setAddress(address);
    }

    public void setRole(String role){
        model.setRole();
    }

    public void setPhoneNum(String phoneNum){
        model.setPhone();
    }

    public void updateView(){
        view.Update(model.getPhoto(), model.getUsername() , model.getPass());
    }
}
