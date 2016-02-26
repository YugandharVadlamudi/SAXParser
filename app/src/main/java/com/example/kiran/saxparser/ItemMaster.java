package com.example.kiran.saxparser;

/**
 * Created by Kiran on 07-12-2015.
 */
public class ItemMaster {
   private String ItemNumber,ItemName,Description;
    private int Price;
    float weight;
    public void setItemNumber(String ItemNumber)
    {
        this.ItemNumber=ItemNumber;
    }
    public String getItemNumber()
    {
        return (ItemNumber);
    }
    public void setItemName(String ItemName)
    {
        this.ItemName=ItemName;
    }
    public String getItemName()
    {
        return(ItemName);
    }
    public void setDescription(String Description)
    {
        this.Description=Description;
    }
    public String getDescription()
    {
        return (Description);
    }
    public void setPrice(int Price)
    {
        this.Price=Price;
    }
    public int getPrice()
    {
        return(Price);
    }
    public void setWeight(float weight)
    {
        this.weight=weight;
    }
    public float getWeight()
    {
        return(weight);
    }

}
