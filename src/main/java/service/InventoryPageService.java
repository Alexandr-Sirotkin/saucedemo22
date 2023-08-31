package service;

import page.InventoryPage;

public class InventoryPageService {

  private InventoryPage inventoryPage = new InventoryPage();

  public String getActualNameOfMainPageSection() {
    return inventoryPage.getTextOfNameOfMainPageSection();
  }
}
