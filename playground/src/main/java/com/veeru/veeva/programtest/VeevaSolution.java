package com.veeru.veeva.programtest;


import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class VeevaSolution {
       static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       static final int DESC_LENGTH = 25; 
       static final int DESC_LENGTH_NEXT = 26;
       static final String COMMA = ", ";
       static final String SPACE = " ";
       static final String QUOTE = "\"";
       static final char SPACE_CHAR=' ';
       static final int START_INDEX=0;
       static final String SO_ON="...";
       static final String EMPTY=""; 
       static final long MEGABYTE=1024*1024;
       static final long KILOBYTE=1024;
       static final String TAB = "\t";  
  
  
    private static class Document {
      String name;
      String description;
      String createdBy;
      String lastModifiedBy;
      Long sizeInBytes;
      Long createdTime;
      Long modifiedTime;
      
      public Document(String n, String d, String c, String m, Long size, Long cTime, Long mTime) {
        this.name = n;
        this.description = d;
        this.createdBy = c;
        this.lastModifiedBy = m;
        this.sizeInBytes = size;
        this.createdTime = cTime;
        this.modifiedTime = mTime;
      }
      
       /**
       * Prints a report of the list of documents in the following format:
       *
       * Group by document.createdBy
       * Sort the groups using document.createdBy ascending, case insensitive
       *      Sort each sub list of documents by document.createdTime ascending
       * Format the output of document.size to be a more friendly format. Ex.  50 mb, 900 k, 342 bytes, etc...
       * Format the dates using the format: yyyy-MM-dd
       * Format the output of document.description such that
       *  - no more than the first 25 characters of the description are displayed
       *  - don't truncate any words unless the first word is longer than 25 characters
       *  - display "..." at the end of the description to indicate that it has been truncated
       *
       * Example:
       * Andy Andrews
       *      "Bobby Timmons Biography","An exhaustive look at the ...",2333 mb,2013-05-09,2013-05-14
       *      "Apple Sauce","Study of apple sauces",87348 mb,2013-05-10,2013-05-10
       *      "Zed","All matters, A to Zed",1024k,2013-05-12,2013-05-12
       * Janet Smith
       *      "Xray","How the Xray shows your ...",48 mb,2010-10-22,2010-12-02
       *      "Computers","Inventory list of ...",23423 bytes,2013-03-01,2013-04-17
       *
       *
       * @param documents not null
       */
      public void printDocumentsReport(List<Document> documents) {
        // Group documents by created by
       Map<String, List<Document>> docMap = new HashMap<String, List<Document>>();    
        
        for(Document document: documents){
          String docBy = document.createdBy;
          if(! docMap.containsKey(docBy)){
            List<Document> docList = new ArrayList<Document>();
            docList.add(document);
            docMap.put(docBy, docList);  
          }else{
            docMap.get(docBy).add(document);
          }
       }
        sortByCreatedByKey(docMap);
    }
  
      
   public  void sortByCreatedByKey(Map<String, List<Document>> input){
     
     TreeMap<String, List<Document>> sortedMap = new TreeMap<String, List<Document>>(input);
     
     for(Map.Entry<String,List<Document>> entry:sortedMap.entrySet()){ 
       System.out.println(entry.getKey());
       List<Document> docList = entry.getValue();
       //Sort the list by date asc
       Collections.sort(docList, new SortByDate());  
       // print each doc
       for(Document doc : docList){     
          printDocument(doc);
          System.out.println();    
        }
      }
 
    }
      
  }
  
  
  public static void printDocument(Document doc){
    
    // print Name
    System.out.print(TAB+QUOTE+doc.name+QUOTE);
    System.out.print(COMMA+SPACE);
    // print description
    System.out.print(QUOTE+getDesc(doc.description)+QUOTE);
    System.out.print(COMMA+SPACE);
    // print size
    System.out.print(getSize(doc.sizeInBytes));
    System.out.print(COMMA+SPACE);
    // print creation  date
    System.out.print(getDate(doc.createdTime));
    System.out.print(COMMA+SPACE);
    // print Modified date
    System.out.print(getDate(doc.modifiedTime));
    
    
    
  }
  
  public static String getDesc(String desc){
    
    if(desc.length() <= DESC_LENGTH){     
      return desc; 
    }else{
       StringBuffer sb = new StringBuffer(desc);
       if(sb.length() > DESC_LENGTH){  
         if(sb.charAt(DESC_LENGTH_NEXT) == SPACE_CHAR || sb.charAt(DESC_LENGTH) ==SPACE_CHAR){
            String result = sb.substring(START_INDEX,DESC_LENGTH);
            return sb.substring(START_INDEX,DESC_LENGTH) + SO_ON;        
         } else{
           String str =  sb.substring(START_INDEX,DESC_LENGTH);
           int index = str.lastIndexOf(SPACE);
           return sb.substring(START_INDEX,index) + SO_ON;
         }
         
       }
    }
    return EMPTY;
  }
    
    
    public static String getDate(long value){
      Date date = new Date(value); 
      return dateFormat.format(date);
    }
    
    public static String getSize(long value){
      String size=EMPTY;
      if(value > MEGABYTE){
        long mb = value/MEGABYTE;
        size = String.valueOf(mb)+" mb";
      }else if(value >=KILOBYTE){
        long kb = value/KILOBYTE;
        size = String.valueOf(kb)+"k";
      }else{
        size = String.valueOf(value)+" bytes";
      }
      return size;
    }

   private static class SortByDate implements Comparator<Document>{  
     public int compare(Document one, Document two){     
       return one.createdTime.compareTo(two.createdTime);
     }    
   }
  
    public static void main(String[] args) {
      
        List<Document> list = new ArrayList<Document>();
      
        Document doc1 = new Document("Bobby Timmons Biography","An exhaustive look at the life and adventures of Bobby Timmons","Andy Andrews", "Derek Smith", 19570622464L, 1368127395000L, 1368533430000L);
        list.add(doc1);
      
        Document doc2 = new Document("Apple Sauce","Study of apple sauces","Andy Andrews","Joe Frank",91591016448L,1368169200000L,1368169200000L);        
        list.add(doc2);
      
        Document doc3 = new Document("Zed","All matters, A to Zed","Andy Andrews","Andy Andrews",1048576L,1368342000000L,1368342000000L);   
        list.add(doc3);
      
        Document doc4 = new Document("Xray","How the Xray shows your bones and all that other internal stuff","Janet Smith","Jeff Gordon",50331648L,1291276800000L,1291312800000L);   
        list.add(doc4);
      
        Document doc5 = new Document("Computers","Inventory list of all the computers in the office","Janet Smith","Janet Smith",1024L,1362160800000L,1366218000000L);   
        list.add(doc5);
     
        doc1.printDocumentsReport(list);
    }

  
  
}