package org.selenium.practice.pages;

public interface LoginPage {
    void login(String username, String password);
    String readErrorMessage();
}
