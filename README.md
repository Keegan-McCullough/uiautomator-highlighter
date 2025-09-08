# uiautomator-highlighter
This project takes in xml files and screenshots (png files) of android GUI Apps from uiautomator and outputs a png file with specific GUI leafs highlighted making it easier to indicate GUI aspects of an application.

Current version of the project reads in files from the input directory and all files that both an xml and png file are parsed into nodes add to a linked list of all nodes for the file. Then the list is ran through the image annotator to highlight the leaf nodes of the screenshot in the same manner of an example output (yellow with thick dashes). These edited pngs are then put in an output directory with matching names. After each file is pocessed and ouputted the code goes on to the next pair of files.

In terminal
Have Jdk installed,
To compile: javac -d out $(find src/main/java -name "*.java")
To run: java -cp out Main
