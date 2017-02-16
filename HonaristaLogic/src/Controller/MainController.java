
public class MainController {

  //  Model model;
   // View view;

    CreateItemController createItemController;
    CreateShopController createShopController;
    CreateUserController createUserController;

    DeleteItemController deleteItemController;
    DeleteShopController deleteShopController;
    DeleteUserContorller deleteUserContorller;

    EditItemController editItemController;
    EditShopController editShopController;
    EditUserController editUserController;


    public MainController(){

        createItemController = new CreateItemController(this);
        createShopController = new CreateShopController(this);
        createUserController = new CreateUserController(this);

        deleteItemController = new DeleteItemController(this);
        deleteShopController = new DeleteShopController(this);
        deleteUserContorller = new DeleteUserController(this);

        editItemController = new EditItemController(this);
        editShopController = new EditShopController(this);
        editUserController = new EditUserController(this);
    }

    /*public void addView(View v){
        this.view = v;
    }
    public addModel(Model m){
        this.model = m;
    }*/
}
