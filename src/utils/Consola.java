package utils;

import java.util.Scanner;

public class Consola {
    private Scanner scanner=new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
