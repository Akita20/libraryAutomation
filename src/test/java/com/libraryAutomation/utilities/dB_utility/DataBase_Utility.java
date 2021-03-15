package com.libraryAutomation.utilities.dB_utility;

import com.libraryAutomation.utilities.ConfigurationReader;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataBase_Utility {
    private static Connection con;
    private static Statement stm;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;


    public static void createConnection() {

        String url = ConfigurationReader.getProperty("hr.database.url");
        String username = ConfigurationReader.getProperty("hr.database.username");
        String password = ConfigurationReader.getProperty("hr.database.password");

        createConnection(url, username, password);

    }


    public static void createConnection(String url, String username, String password) {


        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED " + e.getMessage());
        }

    }


    public static ResultSet runQuery(String sql) {

        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            rsmd = rs.getMetaData();
        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE RUNNING QUERY " + e.getMessage());
        }

        return rs;

    }


    public static void destroy() {

        try {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE CLOSING RESOURCES " + e.getMessage());
        }

    }

    private static void resetCursor() {

        try {
            rs.beforeFirst();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static int getRowCount() {

        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE GETTING ROW COUNT " + e.getMessage());
        } finally {
            resetCursor();
        }

        return rowCount;

    }

    public static int getColumnCount() {

        int columnCount = 0;

        try {
            columnCount = rsmd.getColumnCount();

        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE GETTING COLUMN COUNT " + e.getMessage());
        }

        return columnCount;

    }

    public static List<String> getAllColumnNamesAsList() {

        List<String> columnNameLst = new ArrayList<>();

        try {
            for (int colIndex = 1; colIndex <= getColumnCount(); colIndex++) {
                String columnName = rsmd.getColumnName(colIndex);
                columnNameLst.add(columnName);
            }
        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE getAllColumnNamesAsList " + e.getMessage());
        }

        return columnNameLst;

    }

    public static List<String> getRowDataAsList(int rowNum) {

        List<String> rowDataAsLst = new ArrayList<>();
        int colCount = getColumnCount();

        try {
            rs.absolute(rowNum);

            for (int colIndex = 1; colIndex <= colCount; colIndex++) {

                String cellValue = rs.getString(colIndex);
                rowDataAsLst.add(cellValue);

            }


        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE getRowDataAsList " + e.getMessage());
        } finally {
            resetCursor();
        }


        return rowDataAsLst;
    }

    public static String getCellValue(int rowNum, int columnIndex) {

        String cellValue = "";

        try {
            rs.absolute(rowNum);
            cellValue = rs.getString(columnIndex);

        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE getCellValue " + e.getMessage());
        } finally {
            resetCursor();
        }
        return cellValue;

    }

    public static String getCellValue(int rowNum, String columnName) {

        String cellValue = "";

        try {
            rs.absolute(rowNum);
            cellValue = rs.getString(columnName);

        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE getCellValue " + e.getMessage());
        } finally {
            resetCursor();
        }
        return cellValue;

    }

    public static String getFirstRowFirstColumn() {

        return getCellValue(1, 1);

    }

    public static List<String> getColumnDataAsList(int columnNum) {

        List<String> columnDataLst = new ArrayList<>();

        try {
            rs.beforeFirst(); // make sure the cursor is at before first location
            while (rs.next()) {

                String cellValue = rs.getString(columnNum);
                columnDataLst.add(cellValue);
            }

        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE getColumnDataAsList " + e.getMessage());
        } finally {
            resetCursor();
        }


        return columnDataLst;

    }

    public static List<String> getColumnDataAsList(String columnName) {

        List<String> columnDataLst = new ArrayList<>();

        try {
            rs.beforeFirst();
            while (rs.next()) {

                String cellValue = rs.getString(columnName);
                columnDataLst.add(cellValue);
            }

        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE getColumnDataAsList " + e.getMessage());
        } finally {
            resetCursor();
        }


        return columnDataLst;

    }

    public static void displayAllData() {

        int columnCount = getColumnCount();
        resetCursor();
        try {

            while (rs.next()) {

                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {

                    System.out.printf("%-25s", rs.getString(colIndex));
                }
                System.out.println();

            }

        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE displayAllData " + e.getMessage());
        } finally {
            resetCursor();
        }

    }

    public static Map<String, String> getRowMap(int rowNum) {

        Map<String, String> rowMap = new LinkedHashMap<>();
        int columnCount = getColumnCount();

        try {

            rs.absolute(rowNum);

            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                String columnName = rsmd.getColumnName(colIndex);
                String cellValue = rs.getString(colIndex);
                rowMap.put(columnName, cellValue);
            }

        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE getRowMap " + e.getMessage());
        } finally {
            resetCursor();
        }


        return rowMap;
    }

    public static List<Map<String, String>> getAllRowAsListOfMap() {

        List<Map<String, String>> allRowLstOfMap = new ArrayList<>();
        int rowCount = getRowCount();

        for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {

            Map<String, String> rowMap = getRowMap(rowIndex);
            allRowLstOfMap.add(rowMap);

        }
        resetCursor();

        return allRowLstOfMap;

    }


}

