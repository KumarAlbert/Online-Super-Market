package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
  * <p>
  * The Logger program used to Log the details of program status. 
  * </p>
  *
  * @author kumar albert
  * @version 1.0
  *
  **/
public class Logger { 
    
    static PrintWriter printWriter;
    /**
      * <p>
      * This method which makes use of performs operation to write log file.
      * </p>
      *      
      * @param e.
      *          This is used to store exception.
      * @exception exception. 
      *         It catches general exceptions.
      */
    public static void writeLog(Exception e) {
        try { 
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date(); 
            FileWriter fileWriter = new FileWriter("logger/logs/"+formatter.format(date)+".txt",true);
    	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    	    printWriter = new PrintWriter(bufferedWriter);
            String stringDate = String.valueOf(date);
            printWriter.append(stringDate+"  ");
            e.printStackTrace(printWriter);
            printWriter.append("===============================================");
            printWriter.append("===============================================");
            printWriter.append("\n");
        } catch(Exception exception) { 
              System.out.println(exception);
          }
        finally {
            printWriter.close();
        }
    } 

    /**
      * <p>
      * This method which makes use of performs operation to write log file.
      * </p>
      * 
      * @param cause. 
      *         This is a cause.
      * @exception e. 
      *         It catches general exceptions.
      */ 
    public static void writeLog(Throwable cause) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date(); 
            FileWriter fileWriter = new FileWriter("logger/logs/"+formatter.format(date)+".txt",true);
    	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    	    printWriter = new PrintWriter(bufferedWriter);
            String stringDate = String.valueOf(date);
            printWriter.append(stringDate+"  ");
            cause.printStackTrace(printWriter);
            printWriter.append("===============================================");
            printWriter.append("===============================================");
            printWriter.append("\n");
        } catch(Exception e) { 
              System.out.println(e);
          }
        finally {
            printWriter.close();
        }
    }  
}
