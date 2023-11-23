import java.io.*;
import java.util.ArrayList;

public class CsvFile {


    public CsvFile() {
    }

    public void readResults(String filepath) {
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(filepath));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                for (String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public void writeModules(ArrayList<Module> module, String filepath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for (Module module1 : module) {
                writer.write(module1.getModuleName() + "," + module1.getModuleId() + "," + module1.getCredits() + "\n");
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

