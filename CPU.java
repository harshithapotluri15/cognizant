import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.io.FileNotFoundException;
import org.json.JSONObject;
class Codechef {

	public static void main(String[] args) throws IOException 
	{
		double[] a = new double[10000];
		JSONObject obj  = new JSONObject();
		JSONObject obj1 = new JSONObject();
		File fileIn1 = new File("C:\\Users\\harsh\\Desktop\\CPU.txt");
		BufferedReader br = new BufferedReader(new FileReader(fileIn1));
		try 
        {
            String delim=" +";
            String line;
            
            double sum=0.0,max=0.0;
            int count=0;
            while((line=br.readLine())!=null)
            {
                StringTokenizer st=new StringTokenizer (line,delim);
                String [] tokens=line.split(delim);
                sum+=Double.valueOf(tokens[8]);
                a[count]=Double.valueOf(tokens[8]);
                count++;
                
            
                if(Double.valueOf(tokens[8])>max)
                {
                    max=Double.valueOf(tokens[8]);
                }
            }
            //System.out.println("sum:"+sum);
            double avg=sum/count;
            //System.out.println("avg:"+ avg);
            //System.out.println("max:"+ max);
            for(int j=0;j<count;j++)
            {
            	String k=String.valueOf(j);
            	k=k+"s";
            	obj1.put(k, a[j]);
            }
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            obj.put("AverageMemory(MB)", df.format(avg));
            obj.put("values: ",obj1);
            obj.put("MaximumMemory(MB)", df.format(max));
            System.out.println(obj);
        	try
    		{
    		
    		FileWriter fw=new FileWriter("CPUOutput1.json");
    		fw.write(obj.toString());
    		fw.close();
    		
    		}
    		catch(Exception e)
    		{
    			System.out.println(e);
    		}
         }
        }
	}
