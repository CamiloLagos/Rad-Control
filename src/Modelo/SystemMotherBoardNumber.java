/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author juanc
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * Program to get System Motherboard Serial Number for Windows and Linux Machine
 * @author includehelp
 */
public class SystemMotherBoardNumber {
    
    /** 
     * Method for get System Motherboard Serial Number
     * @return  MAC Address
     */
    public static String getSystemMotherBoard_SerialNumber(){
        try{
            String OSName=  System.getProperty("os.name");
            if(OSName.contains("Windows")){
                return (getWindowsMotherboard_SerialNumber());
            }
            else{
                return (paraMac());
            }
        }
        catch(Exception E){
            System.err.println("System MotherBoard Exp : "+E.getMessage());
            return null;
        }
    }
    
    /**
     * Method for get Windows Machine MotherBoard Serial Number
     * @return 
     */
    private static String getWindowsMotherboard_SerialNumber() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto",".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs =
            "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
              + "Set colItems = objWMIService.ExecQuery _ \n"
              + "   (\"Select * from Win32_BaseBoard\") \n"
              + "For Each objItem in colItems \n"
              + "    Wscript.Echo objItem.SerialNumber \n"
              + "    exit for  ' do the first cpu only! \n"
              + "Next \n";

            fw.write(vbs);
            fw.close();

            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
               result += line;
            }
            input.close();
        }
        catch(Exception E){
             System.err.println("Windows MotherBoard Exp : "+E.getMessage());
        }
        return result.trim();
    } 
    public static String paraMac() {
    	
    	String valor= "";
    	String s = "";
    	String a = "";
    	   ProcessBuilder pb = new ProcessBuilder("bash", "-c",
    	            "ioreg -l | awk '/IOPlatformSerialNumber/ { print $4;}'");
    	        pb.redirectErrorStream(true);
    	        try {
    	            Process p = pb.start();
    	             
    	            // read from the process's combined stdout & stderr
    	            BufferedReader stdout = new BufferedReader(
    	                new InputStreamReader(p.getInputStream()));
    	            while ((s = stdout.readLine()) != null) {
    	            	a=s;
    	            }
    	            p.getInputStream().close();
    	            p.getOutputStream().close();
    	            p.getErrorStream().close();
    	        } catch (Exception ex) {
    	            ex.printStackTrace();
    	        }
    	        
    	        System.out.println(s + "<-");
    	        
    	        String b =  a.split("\"")[1];

    	        return b;
    	        
    }
    
    
    /**
     * Method for get Linux Machine MotherBoard Serial Number
     * @return 
     */
    private static String GetLinuxMotherBoard_serialNumber() {
        String command ="" ;
        
        String sNum = null; 
        try {   
            Process SerNumProcess = Runtime.getRuntime().exec(command);
            BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
            sNum = sNumReader.readLine().trim();
            SerNumProcess.waitFor();
            sNumReader.close();
        }
        catch (Exception ex) {
            System.err.println("Linux Motherboard Exp : "+ex.getMessage());
            sNum =null;
        }
        return sNum; 
    }
   
}
