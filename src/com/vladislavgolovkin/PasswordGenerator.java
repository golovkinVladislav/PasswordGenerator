package com.vladislavgolovkin;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Random;


public class PasswordGenerator {
    public static void writeToClipboard(StringBuilder theStringThatIsCopiedToTheBuffer) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(theStringThatIsCopiedToTheBuffer.toString());
        clipboard.setContents(transferable, null);
    }

    public static String stringCharacterForPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String stringNumberForPassword = "1234567890";
    public static String stringSpecialСharactersForPassword = "-!@#$%^&*()~";
    public static StringBuilder stringBuilderRezult =
            new StringBuilder()
                    .append(stringCharacterForPassword)
                    .append(stringNumberForPassword)
                    .append(stringSpecialСharactersForPassword);
    public static StringBuilder readуEneratedPassword = new StringBuilder();

    public static void main(String[] args) {
          switch (args[1].toLowerCase()) {
            case "yes":
                if (Integer.parseInt(args[0]) <= 50 && Integer.parseInt(args[0]) >= 10) {
                    for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                        Random random = new Random();
                        int randomValue = random.nextInt((stringBuilderRezult.toString().toCharArray().length - 1) + 1) + 1;
                        char[] ch = stringBuilderRezult.toString().toCharArray();
                        writeToClipboard(readуEneratedPassword.append(ch[randomValue-1]));
                    }
                } else {
                    throw new InvalidValueForTheFirstArgument("Password length from 10 to 50");
                }
                System.out.println("Your ready password is in the clipboard!");
                break;
            case "no":
                stringBuilderRezult.setLength(stringBuilderRezult.length() - stringSpecialСharactersForPassword.length());
                if (Integer.parseInt(args[0]) <= 50 && Integer.parseInt(args[0]) >= 10) {
                    for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                        Random random = new Random();
                        int randomValue = random.nextInt((stringBuilderRezult.toString().toCharArray().length - 1) + 1) + 1;
                        char[] ch = stringBuilderRezult.toString().toCharArray();
                        writeToClipboard(readуEneratedPassword.append(ch[randomValue-1]));
                    }
                } else {
                    throw new InvalidValueForTheFirstArgument("Password length from 10 to 50");
                }
                System.out.println("Your ready password is in the clipboard!");
                break;
            default:
                System.out.printf("Template to generate: %d %s", (int)(Math.random()*50)+1, "yes");
        }
    }
}
