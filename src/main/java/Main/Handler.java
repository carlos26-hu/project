package Main;

import Tool.Tools;
import User.User;

import java.util.*;

public class Handler {

    Scanner scanner = new Scanner(System.in);
    StoreRepository storeRepository = new StoreRepository();
    List<Tools> list = new ArrayList<>();
    Map<Tools, Integer> selectedtools = new HashMap<>();

    public void MainMenu(List<User> users, StoreRepository sR) {
        storeRepository = sR;

        User user = checkUser(users);
        boolean userauthor = user.isAuthorization();
        int choice = 0;

        System.out.println("Hello " + user.getName());
        while (choice <= 0) {

            System.out.println("Mit szeretnél csinálni?");
            System.out.println("1. Kitárolás");
            System.out.println("2. Visszatárolás");
            System.out.println("3. Készülék felszerszámozás");
            if (userauthor) {
                System.out.println("4. Raktár kritikus szerszámok mennyisége");
                System.out.println("5. Raktárkészlet kezelése");
                System.out.println("6. Gépek kezelése");
                System.out.println("7. Adatlekérdezés");
                System.out.println("8. Felhasználók kezelése");
                System.out.println("9. Kilépés");
            }
            choice = scanner.nextInt();
            if (choice > 9) {
                System.out.println("Nem választható menü!");
                choice = 0;
            }
            if (choice > 3 && !userauthor) {
                System.out.println("Nincs jogosultságod!");
                choice = 0;
            }
        }
        submenu(choice);
    }

    private void submenu(int choice) {

        int newchoice = 0;
        String dbtable = null;
        StringBuilder stringBuilder = new StringBuilder();
        List<String> coloumnList;
        if (choice == 1 || choice == 2) {
            while (newchoice <= 0) {
                System.out.println("Szerszámot vagy terméket szeretnél?");
                System.out.println("1. Szerszám");
                System.out.println("2. Termék");
                newchoice = scanner.nextInt();
                if (newchoice == 1) {
                    dbtable = "tool";
                } else if (newchoice == 2) {
                    dbtable = "product";
                } else {
                    cls();
                    System.out.println("Téves megadás!");
                }
            }
        }
        coloumnList = storeRepository.getMenu("SELECT * FROM " + dbtable);
        stringBuilder.append("SELECT * FROM ");
        stringBuilder.append(dbtable);
        stringBuilder.append(" WHERE ");
        stringBuilder.append(searchmenu(coloumnList));
        stringBuilder.append(selectMenu());
        stringBuilder.append(orderList(coloumnList));
        System.out.println(stringBuilder);
        list = storeRepository.getList(stringBuilder.toString());
        list.stream().forEach(System.out::println);
        System.out.println();
        System.out.println();
        System.out.println();
        selectProducts();

    }

    private void selectProducts() {
scanner.nextLine();

        List<Integer> selectedId = new ArrayList<>();
        Tools actualTool = null;
        System.out.println("Kérem a kiválasztott szerszám id-ját!");
        System.out.println("kiválasztás befejezése: 0");
        int value=-50;

            while (value!=0) {
                value = scanner.nextInt();
                System.out.println(value);
                for (Tools tools : list) {
                    if (tools.getId() == value) {
                        actualTool = tools;
                        System.out.println("Kérem a mennyiséget");
                        int quantity = scanner.nextInt();
                        if(quantity>tools.getQuantity()){
                            System.out.println("Nem vehetsz ki többet, mint amennyi a raktárban van!");
                            System.out.println("A raktárban lévő mennyiség "+tools.getQuantity()+ "lesz kivéve!");
                            quantity = tools.getQuantity();
                        }
                        selectedtools.put(actualTool,quantity);
                        System.out.println(actualTool);
                        System.out.println(quantity);
                        System.out.println("Kérem a követkető id-t");
                        break;
                    }
                }
            }

        for (Map.Entry<Tools, Integer> toolsIntegerEntry : selectedtools.entrySet())
            System.out.println(toolsIntegerEntry.getKey()+" "+ toolsIntegerEntry.getValue());

    }

    private String orderList(List<String> coloumnList) {

        int choice = 0;

        cls();
        System.out.println("Mi alapján rendezzem?");
        while (choice <= 0) {
            for (int i = 0; i < coloumnList.size(); i++) {
                System.out.println(i + 1 + ". " + coloumnList.get(i));
            }
            choice = scanner.nextInt();
            if (choice > coloumnList.size()) {
                choice = 0;
            }
        }
        return " ORDER BY " + coloumnList.get(choice - 1) + ";";
    }


    private String selectMenu() {

        int choice = 0;
        String select = null;
        while (choice <= 0) {
            System.out.println("1. Egyenlő");
            System.out.println("2. Nem egyenlő");
            System.out.println("3. Kisebb");
            System.out.println("4. Nagyobb");
            System.out.println("5. Tartalmaz");
            System.out.println("6. Nem tartalmaz");
            System.out.println("7. Között");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                select = " = ";
                break;
            case 2:
                select = " != ";
                break;
            case 3:
                select = " < ";
                break;
            case 4:
                select = " > ";
                break;
            case 5:
                select = " LIKE  ";
                break;
            case 6:
                select = " NOT LIKE ";
                break;
            case 7:
                select = " BETWEEN ";
                break;
        }
        scanner.nextLine();
        if (choice < 7) {
            System.out.println("Kérem az értéket!");
            String value = scanner.nextLine();
            select = select + " " + value;
        } else {
            System.out.println("Kérem az első értéket!");
            String value1 = scanner.nextLine();
            select = select + " " + value1 + " AND";
            System.out.println("Kérem a második értéket!");
            String value2 = scanner.nextLine();
            select = select + " " + value2;

        }
        System.out.println(select);
        return select;
    }

    private String searchmenu(List<String> coloumnList) {

        int choice = 0;

        cls();
        while (choice <= 0) {
            for (int i = 0; i < coloumnList.size(); i++) {
                System.out.println(i + 1 + ". " + coloumnList.get(i));
            }
            choice = scanner.nextInt();
            if (choice > coloumnList.size()) {
                choice = 0;
            }
        }
        return coloumnList.get(choice - 1);
    }


    private User checkUser(List<User> users) {

        User actualUser = null;

        System.out.println("Hello!");

        while (actualUser == null) {

            System.out.println("Add meg a felhasználónevet: ");
            String s = scanner.nextLine();
            System.out.println(s);
            try {
                actualUser = users.stream().
                        filter(user -> user.getName().equals(s))
                        .findFirst()
                        .get();
                System.out.println("Kérem a jelszót:");
                if (!actualUser.getPassword().equals(scanner.nextLine())) {
                    System.out.println("Hibás megadás!");
                    actualUser = null;
                }
            } catch (Exception e) {
                System.out.println("Hibás megadás!");
            }
        }
        cls();
        return actualUser;
    }

    private void cls() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }
}