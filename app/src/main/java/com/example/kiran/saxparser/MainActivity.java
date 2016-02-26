package com.example.kiran.saxparser;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends Activity {
ItemMaster itemMaster;
    String parseData="";
    TextView tv_display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_display=(TextView)findViewById(R.id.TV_output);
        try {
            parseXML();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void parseXML() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        SAXParser saxParser=saxParserFactory.newSAXParser();
//        XMLReader xmlReader=saxParser.getXMLReader();
        ItemMasterHandler itemMasterHandler=new ItemMasterHandler();
        /*IOException raised by InputStream*/
        InputStream inputStream=getAssets().open("xml.xml");
        saxParser.parse(inputStream, itemMasterHandler);
        ArrayList<ItemMaster> im=itemMasterHandler.getItemList();
        Log.d("im_value", Integer.toString(im.size()));
//        Log.d("im_value_size",""+im.get(4));
        for(int i=0;i<im.size();i++)
        {
            ItemMaster itemMaster=im.get(i);
            parseData=parseData+itemMaster.getItemNumber()+"\n";
            parseData=parseData+itemMaster.getDescription()+"\n";
            parseData=parseData+itemMaster.getWeight()+"\n";
            parseData=parseData+itemMaster.getPrice()+"\n";
            parseData=parseData+"-----------------------------\n";
        }
        Log.d("thevalueofPraseData",parseData);
        tv_display.setText(parseData);
    }
}
