import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Navigation {
    private Stack<JFrame> pageStack = new Stack<>();

    /*public Navigation() {
        createHomePage();
    }

   private void createHomePage() {
        HomePage homePage = new HomePage();
        homePage.setSize(400, 300);

        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!pageStack.isEmpty()) {
                    JFrame previousPage = pageStack.pop();
                    previousPage.setVisible(true);
                    homePage.dispose(); // Close the current page
                }
            }
        });

        // Add components to the home page
        homePage.add(backButton, GridBagConstraints.SOUTHEAST);

        // Push the home page to the stack
        pageStack.push(homePage);

        homePage.setVisible(true);
    }

    // Create and display a new page
    private void createNewPage(String pageTitle) {
        JFrame newPage = new JFrame(pageTitle);
        newPage.setSize(400, 300);
        newPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!pageStack.isEmpty()) {
                    JFrame previousPage = pageStack.pop();
                    previousPage.setVisible(true);
                    newPage.dispose(); // Close the current page
                }
            }
        });

        // Add components to the new page
        newPage.add(backButton, BorderLayout.NORTH);

        // Push the new page to the stack
        pageStack.push(newPage);

        newPage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Navigation().createNewPage("Page 1");
        });
    }*/
}
