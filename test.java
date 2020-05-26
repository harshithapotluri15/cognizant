package mock;

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
//import java.util.regex.PatternSyntaxException;
public class Test {

	public static void main(String[] args) throws IOException 
	{
		double[] a = new double[10000];
		File file = new File("C:\\Users\\harsh\\Desktop\\Memory.txt");
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) 
        {
            String readLine;
            double temp,max = 0.0,sum=0.0;
            int line = 0,i=0,count=0;
            while ((readLine = bf.readLine()) != null) 
            {
                if (line % 2 != 0) {
                	String str=readLine;
                	str=str.replaceAll("[^0-9]","");
                    str=str.trim();
                    temp=Integer.parseInt(str);
                    System.out.println(temp/10000);
                    a[i++]=temp/10000;
                   
                }
                line++;
            }
            for(int j=0;j<938;j++)
            {
            	if(max<a[j])
            		max=a[j];
            	sum=sum+a[j];
            }
            double average=sum/938;
            System.out.println("Average: " + average);
            System.out.println("Maximum: " + max);
         }
 }
}
