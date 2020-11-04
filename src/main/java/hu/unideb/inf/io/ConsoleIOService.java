package hu.unideb.inf.io;

import java.util.Scanner;

public class ConsoleIOService implements IOService {

    @Override
    public String input(String string) {
        System.out.print(string + " ");
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void inputAndPrint(String string) {
        print(input(string));
    }

}
