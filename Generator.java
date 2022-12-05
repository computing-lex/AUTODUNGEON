// *******************************
// Author: Alexis Tjarks
// Created Oct. 17, 2022
//
// I got very annoyed with making these
// commenet blocks and so I made a thing
// that reads the .java file and spits 
// out a header file to copy paste in. 
//
// TERMS OF USE:
//   DO NOT remove existing comments.
//   DO NOT edit, remove, replace, or add
//     to the existing software
//
// *******************************

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Generator {
    private ArrayList<String> methods;
    private ArrayList<String> attributes;
    private ArrayList<String> text; 
    
    private Scanner in;
    private String[] template;
    
    private File sourceFile;
    
    public Generator() {
        methods = new ArrayList<String>();
        text = new ArrayList<String>();
        attributes = new ArrayList<String>();
        in = new Scanner(System.in);

        template = new String[] {"// Class: ", "// Name: ", "// Date: ", "// Purpose: ", "// Attributes: ", "// Methods: "};
    }
    
    public static void main(String args[]) {
        Generator generator = new Generator();
        
        generator.inputFile();
        generator.printText();
        generator.outputFile();
        
    }

    public void readMethods(String fileName) {
        try{
            sourceFile = new File(fileName); 
            Scanner fileIn = new Scanner(sourceFile);

            while (fileIn.hasNextLine()) {
                String data = fileIn.nextLine();
                catchMethod(data);
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        
    }

    public void catchMethod(String data) {
        if (data.contains("public") && !data.contains("class") && !data.contains("//")) {
            methods.add(data.trim().replace(" {", ""));
        } else if (data.contains("void") && !data.contains("//")) {
            methods.add(data.trim().replace(" {", ""));
        }

        if (data.contains("private") && !data.contains("//")) {
            attributes.add(data.trim().replace(";", ""));
        }
    }

    public void inputFile() {
        DateTimeFormatter dateSetter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime currentDate = LocalDateTime.now();
        
        System.out.println("Please enter the title of the file, without the .java. ");
        String fileName = in.nextLine();

        readMethods(fileName + ".java");

        text.add("// *******************************");
        
        System.out.println("Class: ");
        text.add(template[0] + in.nextLine());
        
        text.add(template[1] + "Alexis Tjarks");
        
        text.add(template[2] + currentDate.format(dateSetter));

        text.add(emptyLine());
        System.out.println("Software purpose (Press enter to leave blank): ");
        text.add(template[3] + in.nextLine());

        text.add(emptyLine());
        text.add(template[4]); // attributes

        for (int i = 0; i < attributes.size(); i++) {
            text.add("//   " + attributes.get(i));
        }
        
        text.add(emptyLine());
        text.add(template[5]); // methods

        for (int i = 0; i < methods.size(); i++) {
            text.add("//   " + methods.get(i));
        }
        
        text.add(emptyLine());
        text.add(text.get(0)); // closer
    }

    public String emptyLine() {
        return "//";
    }

    public void printText() {
        for (int i = 0; i < text.size(); i++) {
            System.out.println(text.get(i));
        }
    }

    public void outputFile() {
        try {
            FileWriter fileOut = new FileWriter("header.txt");

            for (String i : text) {
                fileOut.write(i + "\n");
            }

            fileOut.close();
            System.out.println("Written successfully.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}