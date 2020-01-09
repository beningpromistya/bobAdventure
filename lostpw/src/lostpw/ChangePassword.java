/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostpw;

import java.util.*;
import java.io.*;
import java.security.*;

public class ChangePassword{
  private final static JKS j = new JKS();

  public static void main(String[] args) throws Exception
  {
    if (args.length < 2)
    {
      System.out.println("Usage: java ChangePassword keystoreFile newKeystoreFile");
      return;
    }

    String keystoreFilename = args[0];
    String newFilename = args[1];
    InputStream in = new FileInputStream(keystoreFilename);
    String passwd = promptForPassword("keystore");
    
    System.out.printf("Changing password on '%s', writing to '%s'...\n", keystoreFilename, newFilename);

    j.engineLoad(in, passwd.toCharArray());
    in.close();

    passwd = promptForPassword("new keystore");

    OutputStream out = new FileOutputStream(newFilename);
    j.engineStore(out, passwd.toCharArray());
    out.close();
  }

  private static String promptForPassword(String which)
  {
    System.out.printf("Enter %s password: ", which);
    Scanner kbd = new Scanner(System.in);
    return kbd.nextLine();
  }
}
