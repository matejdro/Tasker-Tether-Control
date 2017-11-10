package com.matejdro.taskertethercontrol.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class RootUtil {

    public static boolean isRootAccessible() {
        try {
            Process proces = Runtime.getRuntime().exec("su");

            DataOutputStream out = new DataOutputStream(proces.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(proces.getInputStream()));
            out.writeBytes("id\n");
            out.flush();

            String line = in.readLine();
            return line != null;
        } catch (IOException e) {
            return false;
        }
    }
}