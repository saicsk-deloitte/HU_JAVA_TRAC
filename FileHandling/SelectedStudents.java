 package FileHandling;
           import java.io.BufferedReader;
           import java.io.FileReader;
           import java.io.File;
           import java.io.PrintWriter;
           import java.util.ArrayList;
           import java.util.Arrays;
           import java.util.List;
public class SelectedStudents {
    public static void main(String[] args) {
        String file = "C:\\Users\\Chamkumar\\Desktop\\StudentData.csv";
        String delimiter = ",";
        String line;
        List<List<String>> lines = new ArrayList();
        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))) {
            PrintWriter pw = new PrintWriter(new File("C:\\Users\\Chamkumar\\Desktop\\Selected.csv"));

            StringBuffer csvHeader = new StringBuffer("");
            StringBuffer csvData = new StringBuffer("");
            csvHeader.append("Name,SSC Reg.No,12th Reg.No, B.Tech Reg.No,rank\n");
            pw.write(csvHeader.toString());
            while((line = br.readLine()) != null){
                List<String> values = Arrays.asList(line.split(delimiter));
                lines.add(values);
            }
            int[] ranks=new int[lines.size()-1];
            for(int i=1;i<lines.size();i++)
            {
                ranks[i-1]=Integer.parseInt((lines.get(i)).get(4));
            }
            int n=ranks.length;
            for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                    if(ranks[j-1] > ranks[j]){

                        int temp = ranks[j-1];
                        ranks[j-1] = ranks[j];
                        ranks[j] = temp;
                    }

                }
            }
            for(int i=0;i<5;i++)
            {
                String value =Integer.toString(ranks[i]);

                int j=0;
                for( j=1;j<lines.size()-1;j++) {
                    if (((lines.get(j)).get(4)).equals(value)) {
                        System.out.print((lines.get(j)).get(4));
                        break;
                    }
                }
                csvData.append((lines.get(j)).get(0));
                csvData.append(',');
                csvData.append((lines.get(j)).get(1));
                csvData.append(',');
                csvData.append((lines.get(j)).get(2));
                csvData.append(',');
                csvData.append((lines.get(j)).get(3));
                csvData.append(',');
                csvData.append((lines.get(j)).get(4));
                csvData.append('\n');
            }
            pw.write(csvData.toString());
            pw.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}

