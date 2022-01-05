


import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author oriana.cruz
 */
public class SoupTestHTML {

    public static void main(String[] args) throws IOException {
    
        Document doc = Jsoup.connect("https://www.thinkingoutsidethecage.org/meet-animals/adopt/cats/").get();
        //System.out.println(doc); Gets the entire website 
        
        String [] names = new String[100];
        String []age= new String[100]; 
        String [] breed= new String[100];
        
        String allInfo;
        int i = 0;
        
        //Get divs containing the cat names
        Elements divs = doc.select("div [class=animal-item-content]");
        
        for (Element div : divs) {
           names [i]= div.getElementsByClass("plain").text();
  
           allInfo = div.getElementsByTag("p").text();//get the tags instead of classes or divs
             //System.out.println(allInfo);       
             
             //Extract just the age 
           age [i] = allInfo.substring(0, allInfo.indexOf("|"));//Assignment 4 HINT

             //Extract just the breed 
           breed [i] = allInfo.substring(allInfo.indexOf("|")+2);//has two innecessary characters in the line
           
           i++;
        }
        
        //Print the cats 
        for (int c = 0; c < names.length; c++) {
            if(names[c]== null){
                break;
            }
            
            System.out.print("Cat " + (c+1+ ": "));
            System.out.print("Name: "+ names[c]);
            System.out.print(", Age: "+ age[c]);
            System.out.println(", Breed: "+ breed[c]);
        }
        
    }
    
}
