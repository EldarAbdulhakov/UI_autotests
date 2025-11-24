package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Set;

public class CookieUtils {

    private static final String COOKIE_FILE = "cookies.dat";

    public static void saveCookies(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COOKIE_FILE))) {
            oos.writeObject(cookies);
            System.out.println("Cookies successfully saved to file: " + COOKIE_FILE);
        } catch (IOException e) {
            System.err.println("Error saving cookies: ");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean loadCookies(WebDriver driver) {
        File file = new File(COOKIE_FILE);

        if (!file.exists()) {
            System.out.println("Cookie file not found. Login will be performed.");
            return false;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Set<Cookie> cookies = (Set<Cookie>) ois.readObject();
            driver.manage().deleteAllCookies();
            for (Cookie cookie : cookies) {
                driver.manage().addCookie(cookie);
            }
            System.out.println("Cookies are loaded from the file.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
