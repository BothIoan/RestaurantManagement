package DataLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import BusinessLayer.Restaurant;

import java.io.*;
import java.util.ArrayList;

//used this just for the bill , the binary files are generated in the Restaurant Serializer class
public class FileWriters {
            public void createBill(ArrayList<MenuItem> ordered){
                    int finalPrice = 0;
                    StringBuilder Print = new StringBuilder();
                            for(MenuItem item : ordered){
                                ArrayList returned =item.getEverything();
                                Print.append(returned.get(0));
                                finalPrice += item.getPrice();
                            }
                            Print.append("\n\n\n\n\nTOTALLY : .... ").append(finalPrice);
                    try {
                        File file = new File("bill.txt");
                        if (!file.exists())
                            file.createNewFile();

                        PrintWriter pw = new PrintWriter(file);
                        pw.println("        Bill          \n\n\n");
                        pw.print(Print.toString());
                        pw.close();
                        System.out.println("Printed");
                    }
                    catch (Exception e)
                    {e.printStackTrace();}

            }

}
