package com.main;

import com.firstlab.Tribe;
import com.firstlab.WriteInfo;
import com.secondLab.*;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        secondLab();
    }


    public static void firstLab() {
        Tribe tribe = new Tribe(15, "Unga-Bunga", true);
        WriteInfo.showInfo(tribe);
    }


    public static void secondLab() {
        HashSet<IProduct> set = new HashSet();
        set.add(new Pony(10, "Boba"));
        set.add(new Cowboy(15, "Woody"));
        set.add(new Spaceman(20, "Bazz"));

        Shop shop = new Shop(set, 10);
        Customer customer = new Customer(100);

        Scanner scanner = new Scanner(System.in);
        int code = 1;

        while (code != 0) {

            System.out
                    .printf("1. Show products.\n")
                    .printf("2. Show basket.\n")
                    .printf("3. Add product to basket.\n")
                    .printf("4. Remove product from basket.\n")
                    .printf("5. Place an order\n")
                    .printf("6. Show my products\n")
                    .printf("0. Exit\n");

            System.out.print("Enter: ");
            code = scanner.nextInt();

            switch (code) {
                case 1:
                    shop.showProducts();
                    break;
                case 2:
                    shop.showBasket();
                    break;
                case 3:
                    shop.showProducts();
                    System.out.print("Choose item: ");
                    int option = scanner.nextShort() - 1;
                    shop.addProductToBasket(option);
                    break;
                case 4:
                    shop.showProducts();
                    System.out.print("Enter item to remove: ");
                    option = scanner.nextShort() - 1;
                    shop.removeProductFromBasket(option);
                    break;
                case 5:
                    shop.placeAnOrder(customer);
                    break;
                case 6:
                    customer.showProducts();
                    break;
                case 0:
                    System.out.print("Shutting down");
                    break;
                default:
                    System.out.print("There is no option with this index, try again.");
                    break;
            }

            pressAnyKey();
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }


    private static void pressAnyKey() {
        try
        {
            System.out.print("Press any key to continue: ");
            System.in.read();
        }
        catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
}

