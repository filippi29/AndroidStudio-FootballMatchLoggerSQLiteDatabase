package com.example.lab5;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlSerializer;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class GameList {
    private List<Game> gList = new ArrayList<>();
    int index;


    public GameList(AssetManager assets) {
        // Constructor Game List
//        gList.add(new Game("Hearts - PAOK", 1, 2));
//        gList.add(new Game("Olympiakos - Cukaricki", 3, 1));
//        gList.add(new Game("Antwerp - AEK", 1, 0));
//        gList.add(new Game("Braga - Panathinaikos", 2, 1));

        this.index = -1;


        try {
            InputStream is = assets.open("records.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            Element element=doc.getDocumentElement();
            element.normalize();

            NodeList nList = doc.getElementsByTagName("game"); //esoteriki pou anoigei kai kleinei

            for (int i=0; i<nList.getLength(); i++) {

                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList teamsNode = ((Element) node).getElementsByTagName("teams").item(0).getChildNodes();
                    String teams =  teamsNode.item(0).getNodeValue();
                    NodeList scoreNode = ((Element) node).getElementsByTagName("score").item(0).getChildNodes();
                    String score =  scoreNode.item(0).getNodeValue();
                    int num1 = Integer.parseInt(score.split("-")[0]);
                    int num2 = Integer.parseInt(score.split("-")[1]);

                    gList.add(new Game(teams, num1, num2));  //prosoxi!! new Game, oxi new GameList
                }
            }

        } catch (Exception e) {e.printStackTrace();}
    }

    public GameList(String teams, int num1, int num2) {
    }


//    public String saveLog(String brand, String model, Date curTime, Context c){
//        String filename ="output.log";
//        try{
//            FileOutputStream fos = c.openFileOutput(filename, Context.MODE_APPEND);
//            String logEntry = new String (curTime.toString()+"|"+brand+"|"+model+"\n");
//            fos.write(logEntry.getBytes(StandardCharsets.UTF_8));
//            fos.close();
//            return c.getFilesDir().getPath().toString()+"/"+filename;
//
//        }catch (Exception e){
//            return e.toString();
//        }
//  }

//    public String saveXMLLog(String brand, String model, Date curTime, Context c){
//        String filename = "output.xml";
//        try {
//            FileOutputStream fos = c.openFileOutput(filename, Context.MODE_APPEND);
//            XmlSerializer s = Xml.newSerializer();
//            s.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
//            s.setOutput(fos, "UTF-8");
//
//
//            s.startTag("", "games");
//            s.startTag("", "game");
//            s.startTag("", "team");
//
//            s.endTag("", "team");
//
//            s.startTag("", "score");
//            s.text(brand);
//            s.endTag("", "score");
//
//            s.endTag("", "game");
//            s.endTag("", "games");
//
//            s.endDocument();
//            s.flush();
//            fos.close();
//
//            return c.getFilesDir().getPath().toString()+"/"+filename;
//        }catch (Exception e){
//            return e.toString();
//        }
//    }



    public String message(){
        index ++;
        if (index ==  gList.size()){
            index = 0;
        }
        return gList.get(index).getText();
    }

    public String winner(){

    return gList.get(index).winner();
    }

    public String getTeam1() {
        return gList.get(index).getTeam1();
    }


    public String getTeam2() {
        return gList.get(index).getTeam2();
    }

}
