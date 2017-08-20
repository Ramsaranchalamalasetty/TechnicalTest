package uk.co.assignment;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class ReadCSV {

    private static final int REGISTRATION_NUMBER_INDEX = 0;
    private static final int MAKE_INDEX = 1;
    private static final int COLOUR_INDEX = 2;

    public static void main(String args[]) throws IOException {
        List<Vehicle> vehicles = mapFileToVehicles(new File("src/main/resources/vehicles_files/vehicles.csv"));
        System.out.print(vehicles);
    }

    public static List<Vehicle> mapFileToVehicles(File file) throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
        return br.lines().map(mapToPerson).collect(toList());
    }

    private static Function<String, Vehicle> mapToPerson = (line) -> {
        String[] p = line.split(", ");
        return new Vehicle(p[REGISTRATION_NUMBER_INDEX], p[MAKE_INDEX], p[COLOUR_INDEX]);
    };
}
