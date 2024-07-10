/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangosneaker.utils;

import java.util.regex.Pattern;

/**
 *
 * @author catlinh
 */
public class Util {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^0(3|5|7|8|9)\\d{8}$");

    public static boolean isValidPhoneNumber(String phoneNumber){
        if (phoneNumber == null) {
            return false;
        }
        return PHONE_PATTERN.matcher(phoneNumber).matches();
    }

}
