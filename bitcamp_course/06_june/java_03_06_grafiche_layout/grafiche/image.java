package grafiche;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.util.Base64;
import java.awt.*;

public class image {
    public static void main(String[] args) throws Exception {
    // Load the image
    BufferedImage image = ImageIO.read(new File("C:\\Users\\Dell\\Desktop\\tutorial programming\\languages_library_framework\\Java\\java_formatter\\website\\img\\logo.png"));

    // Convert the image to byte array
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, "png", baos);
    baos.flush();
    byte[] imageInByte = baos.toByteArray();
    baos.close();

    // Convert byte array to Base64
    String encodedImage = Base64.getEncoder().encodeToString(imageInByte);

    // Print the Base64 representation of the image
    // System.out.println(encodedImage);

    // Create a JFrame
    JFrame frame = new JFrame();
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a JLabel and add the image to it
    JLabel label = new JLabel(new ImageIcon(image));

    // Add the JLabel to the JFrame
    frame.getContentPane().add(label, BorderLayout.CENTER);

    // Display the JFrame
    frame.pack();
    frame.setVisible(true);
    }
}
