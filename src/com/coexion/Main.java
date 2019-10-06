package com.coexion;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	Main pro = new Main();
	pro.createconnetcion();
    }
    void createconnetcion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javat", "root","");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from temp;");

            ArrayList<Integer> list= new ArrayList<Integer>();
            while (rs.next()) {
                //list.add(rs.getDate("humidity"));
                list.add(rs.getInt("temperatura"));
                //list.add(rs.getInt("humidity"));
            }

            Integer[] result = new Integer[list.size()];
            result = list.toArray(result);
            int aux;

            for(int i=0; i<(result.length-1); i++) {
                for(int j=0; j<(result.length-1); j++) {
                    if(result[j] > result[j+1]) { //Si número actual > número siguiente
                        aux = result[j];
                        result[j] = result[j+1];
                        result[j+1] = aux;
                    }
                }
            }

            //Mostrando el arreglo de forma creciente
            System.out.print("\nArreglo ordenado en forma creciente ");
            for(int i=0; i<result.length; i++) {
                System.out.print(result[i]+ " - ");
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
