/*
 * Copyright (c) 2017 a01334390.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    a01334390 - initial API and implementation and/or initial documentation
 */
package BasicElements;

/**
 *
 * @author a01334390
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DBUser {
    private String username,email,privilege,first_name,second_name,image,password;
    private SecretKey key;
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = encrypt(password,key);
    }

    public DBUser(String username, String privilege,String email, String first_name, String second_name, String image) {
        this.username = username;
        this.email = email;
        this.privilege = privilege;
        this.first_name = first_name;
        this.second_name = second_name;
        this.image = image;
        key = getKey();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    @Override
    public String toString(){
        return username;
    }
    private SecretKey getKey(){
        try{
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey key = keygenerator.generateKey();
            return key;
        }catch(Exception e){
        }
        return null;
    }

    public String encrypt(String toDecipher, SecretKey key) {
        try{
            Cipher desCipher;
            desCipher = Cipher.getInstance("DES");

            byte[] text = toDecipher.getBytes();

            desCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] textEncrypted = desCipher.doFinal(text);
            return new String(textEncrypted);
        }catch(Exception e){
            System.out.println("Exception");
        }
        return null;
    }

    public String decrypt(String toDecrypt, SecretKey key){
        try{
                Cipher desCipher;
                desCipher = Cipher.getInstance("DES");

                byte[] text = toDecrypt.getBytes();

                desCipher.init(Cipher.DECRYPT_MODE, key);
                byte[] textDecrypted = desCipher.doFinal(text);
                return new String(textDecrypted);
        }catch(Exception e){
                System.out.println("Exception");
        }
        return null;
    }
}