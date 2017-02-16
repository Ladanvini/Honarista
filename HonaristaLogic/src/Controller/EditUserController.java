
public class EditUserController {

    private editUserModel model;
    private editUserView view;

    public EditUserController(editUserModel model, editUserView view){
        this.model = model;
        this.view = view;
    }

    public void setFullName(String fName){
        model.setFullName();
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

    public void setUserPhoto(){
        model.setPhoto();
    }

    public void setPhoneNum(String phoneNum){
        model.setPhone();
    }

    public void updateView(){
        view.Update(model.getPhoto(), model.getOwner() , model.getTitle());
    }

}
