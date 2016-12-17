package my.nhorushko.requestcmd.view;

import java.util.Scanner;

/**
 * Created by Nikol on 12/17/2016.
 */
public class Console implements View {

    public String read() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void write(String message) {
        System.out.println(message);
    }
}
