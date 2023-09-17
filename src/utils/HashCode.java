/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.lang.Object;
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author Asus
 */
public class HashCode {
    
    public static String toHashCode(String s)
    {
        try 
        {
            MessageDigest digest = MessageDigest.getInstance("MD5"); // MD5, SHA-512
            byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
            return byteArrayToHex(hash);
        } 
        catch (NoSuchAlgorithmException e) 
        {
            return "";
        }
    }
    
    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
}
