package Main;

public class Main {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        StoreRepository storeRepository = new StoreRepository();
        Handler handler = new Handler();
        storeRepository.init();
        handler.MainMenu(userRepository.init(),storeRepository);
        userRepository.close();


    }
}
