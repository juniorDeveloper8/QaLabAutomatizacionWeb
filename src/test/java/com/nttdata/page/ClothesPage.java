package com.nttdata.page;

import org.openqa.selenium.By;

public class ClothesPage {

    public static By clothesLink = By.cssSelector("a[href*='/store/pe/3-clothes']");
    public static By categoryMenuContainer = By.cssSelector(".block-categories .category-top-menu");
    public static By menLink = By.cssSelector(".block-categories .category-sub-menu a[href*='/store/pe/4-men']");
}
