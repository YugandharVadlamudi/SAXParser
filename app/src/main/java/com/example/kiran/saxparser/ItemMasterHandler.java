package com.example.kiran.saxparser;

import android.util.Log;
import android.widget.Toast;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by Kiran on 07-12-2015.
 */
public class ItemMasterHandler extends DefaultHandler {
    Boolean CurrentElemnt=false;
    String CurrentValue="";
    ItemMaster itemMaster;
    String ItemNumber,Description;
    int price;
    float weigth;
    ArrayList<ItemMaster> itemMasters=new ArrayList<ItemMaster>();
    /*we can keep here ArrayList or ArrayList<ItemMaster>*/

    public ArrayList<ItemMaster> getItemList()
    {
        return(itemMasters);
    }



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        Log.d("theURI", "" + uri);
        Log.d("theLocalName", "" + localName);
        Log.d("theQName",""+qName);
        Log.d("theAttributes",""+attributes);
        CurrentElemnt=true;
        CurrentValue="";
        if(localName.equals("ItemsData"))
        {
            itemMaster=new ItemMaster();
        }


    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        Log.d("characters_ch", "" + ch);
        Log.d("Character_start", "" + start);
        Log.d("Character_length", "" + length);
        if(CurrentElemnt)
        {
            CurrentValue=CurrentValue+new String(ch,start,length);
        }

    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        Log.d("endElement_theURI", "" + uri);
        Log.d("endElement_theLocalName", "" + localName);
        Log.d("endElement_theQName", "" + qName);
        if(localName.equals("ItemNumber"))
        {
            itemMaster.setItemNumber(CurrentValue);
        }
        else if(localName.equals("Weight"))
        {
            itemMaster.setWeight(Float.valueOf(CurrentValue));
        }
        else if(localName.equalsIgnoreCase("Description"))
        {
            itemMaster.setDescription(CurrentValue);
        }
        else if(localName.equalsIgnoreCase("Price"))
        {
            itemMaster.setPrice(Integer.valueOf(CurrentValue));
        }
        else  if(localName.equalsIgnoreCase("ItemsData"))
        {
            itemMasters.add(itemMaster);
        }

    }


}
