package makecsv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static config.DataBaseConfig.DatabaseConfig.*;

public class MakecsvFillDataBase {

    public static void main(String[] args) {

     /*   List<Cutter> cutters = new ArrayList<>();
        for (int i = 2; i <= 20; i=i+2) {
         //   for (int j = 0; j < 10; j=j+5) {

                double diameter = i ;
                double length = 3 * i ;
                String productCode = "ZZMECARB" + (int) diameter * 1 + (int) length;
                if (i % 3 == 0 && i % 2 == 0) {
                    cutters.add(new Cutter(productCode, diameter, length, ToolMaterial.Carbide, true, "D" +
                            diameter + " átmérőjű," + length + "hosszú keményfém bevonatos maró", true, 4,
                            Geometry.End,3,2));
                }else if (i % 5 == 0) {
                    cutters.add(new Cutter(productCode, diameter, length, ToolMaterial.Carbide, true, "D" +
                            diameter + " átmérőjű," + length + " hosszú keményfém bevonatos maró", true, 4,
                            Geometry.End,3,5));
                }else{
                    cutters.add(new Cutter(productCode, diameter, length, ToolMaterial.Carbide, true, "D" +
                            diameter + " átmérőjű," + length + " hosszú keményfém bevonatos maró", false, 4,
                            Geometry.End,3,2));
                    }

           //     }
            }

            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("src/main/resources/Milling_cutters.csv"),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                for (Cutter cutter : cutters) {
                    bufferedWriter.append(cutter.getProductCode() + ";" + cutter.getDiameter() + ";" + cutter.getEdgeLength() + ";"
                            + cutter.getMaterial() + ";" + cutter.getCoated() + ";" + cutter.getDescription() + ";" +
                            cutter.getCritic() + ";"+cutter.getNumberOfEdge()+";"+cutter.getGeometry()+";" +
                            cutter.getNumOfMin()+";"+cutter.getQuantity());
                    bufferedWriter.newLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        try (Connection connection = DriverManager.getConnection(DB_Storage, USER, PASSWORD); BufferedReader bufferedReader
                = Files.newBufferedReader(Path.of("src/main/resources/Milling_cutters.csv"))) {

            String line;
            bufferedReader.readLine();
            while((line=bufferedReader.readLine())!=null){
                String[] str = line.split(";");
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tool (toolcode, " +
                                "diameter, length, material, coated, description, critic, " +
                                "numberof_edge, geometry, minquantity, quantity) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
                preparedStatement.setString(1,str[0]);//code
                preparedStatement.setDouble(2, Double.parseDouble(str[1]));//dia
                preparedStatement.setDouble(3, Double.parseDouble(str[2]));///length
                preparedStatement.setString(4,str[3]);//material
                preparedStatement.setBoolean(5, Boolean.parseBoolean(str[4]));//coated
                preparedStatement.setString(6,str[5]);//desc
                preparedStatement.setBoolean(7, Boolean.parseBoolean(str[6]));//critic
                preparedStatement.setInt(8, Integer.parseInt(str[7]));//edge
                preparedStatement.setString(9, str[8]);//geometry
                preparedStatement.setInt(10, Integer.parseInt(str[9]));//min
                preparedStatement.setInt(11, Integer.parseInt(str[10]));//quantity
                System.out.println(preparedStatement.executeUpdate());

            }

        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }



    }
}