import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class TeacherGuiSecond {

    ArrayList<Teacher> teachers;
    JFrame mainFrame = new JFrame("Coursework Of JAVA");
    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel leftCenterPanel = new JPanel();
    JPanel rightCenterPanel = new JPanel();
    JButton tutorButton = new JButton("AddTutor");
    JButton lecturerButton = new JButton("Add Lecturer");
    JButton removeTutorButton = new JButton("Remove Tutor");
    JButton gradeAssignmentButton = new JButton("Grade Assignment");
    JButton setSalaryOfTutorButton = new JButton("Set Salary");

    JButton setDisplayButtonHome = new JButton("Display");

    JLabel idLabel = new JLabel("Teacher ID:");
    JTextField idField = new JTextField(12);

    JLabel nameLabel = new JLabel("Name:");
    JTextField nameField = new JTextField(12);

    JLabel addressLabel = new JLabel("Address:");
    JTextField addressField = new JTextField(12);

    JLabel workingTypeLabel = new JLabel("Working Type:");
    JTextField workingTypeField = new JTextField(12);

    JLabel employmentStatusLabel = new JLabel("Employment Status:");
    JTextField employmentStatusField = new JTextField(15);

    JLabel workingHoursLabel = new JLabel("Working Hours:");
    JTextField workingHoursField = new JTextField(15);

    JLabel salaryLabel = new JLabel("Salary:");
    JTextField salaryField = new JTextField(12);

    JLabel specializationLabel = new JLabel("Specialization:");
    JTextField specializationField = new JTextField(12);

    JLabel academicQualificationLabel = new JLabel("Academic:");
    JTextField academicQualificationField = new JTextField(12);


    JLabel performanceIndexLabel = new JLabel("Performance Index:");
    JTextField performanceIndexField = new JTextField(12);

    JLabel gradedScoreLabel = new JLabel("Is Score Graded");
    JTextField gradedScoreTextField = new JTextField();

    JLabel departmentLabel = new JLabel("Department");
    JTextField departmentTextField = new JTextField();

    JLabel yearsOfExperienceLabel = new JLabel("Years Of Experience");
    JTextField yearsOfExperienceTextField = new JTextField();


    JButton addLecturer = new JButton("Add Lecturer");


    //    JComboBox<Object> comboBox = new JComboBox<> ();
//
    JButton addButton = new JButton("Add");
    JButton clear = new JButton("Clear");
    JButton display = new JButton("Display");
    JButton navHome = new JButton("Back");

//    JButton[] commonButtons = {addButton,clear,display,navHome};

    public TeacherGuiSecond() {
        mainGui();
    }
    private void mainGui() {
        // Top Panel
        topPanel.setBackground(new Color(128, 128, 128));
        JLabel topLabel = new JLabel("Informatics College Of Pokhara");
        topLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topLabel.setForeground(Color.white);
        topPanel.add(topLabel);

        // Center Panel
        centerPanel.setLayout(new BorderLayout());

        // Left Center Panel (Assuming this should be used)
        leftCenterPanel.setBackground(Color.white);
        centerPanel.add(leftCenterPanel, BorderLayout.WEST);

        // Right Center Panel with GridLayout (3 rows, 2 columns) for buttons
        rightCenterPanel.setLayout(new GridLayout(3, 2, 10, 10)); // Adjust spacing as needed

        JButton[] buttons = {tutorButton, gradeAssignmentButton, setSalaryOfTutorButton, removeTutorButton, lecturerButton, setDisplayButtonHome};

        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 13));
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(95, 158, 160)); // Cadet color
            button.setBorder(BorderFactory.createLineBorder(Color.white, 5));
            button.setMargin(new Insets(5, 5, 5, 5)); // Adjust margin
            rightCenterPanel.add(button);
        }

        tutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tutorGui();
            }
        });

        lecturerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lecturerGui();
            }
        });

        removeTutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTutorGui();
            }
        });

        gradeAssignmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gradeAssignmentGui();
            }
        });
        setSalaryOfTutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSalaryGui();
            }
        });
        setDisplayButtonHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a JFrame
                JFrame frame = new JFrame("Teacher Information");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set close operation
                frame.setSize(600, 400); // Set frame size

// Create a JTextArea to display the information
                JTextArea textArea = new JTextArea();
                textArea.setEditable(false); // Make it non-editable
                textArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font and size

// Check if the teachers list is empty
                if (teachers != null && !teachers.isEmpty()) {
                   JOptionPane.showMessageDialog(null,"Please fill all the fields before displaying");
                } else {
                    for (Teacher teacher : teachers) {
                        if (teacher instanceof Lecturer) {
                            Lecturer lecturer = (Lecturer) teacher;
                            // Append lecturer information to the text area
                            textArea.append("Lecturer Information:\n" +
                                    "Lecturer ID: " + lecturer.getTeacherId() + "\n" +
                                    "Name: " + lecturer.getTeacherName() + "\n" +
                                    "Address: " + lecturer.getAddress() + "\n" +
                                    "Working Type: " + lecturer.getWorkingType() + "\n" +
                                    "Employment Status: " + lecturer.getEmploymentStatus() + "\n" +
                                    "Department: " + lecturer.getDepartment() + "\n" +
                                    "Years of Experience: " + lecturer.getYearsOfExperience() + "\n" +
                                    "Graded Score: " + lecturer.getGradedScore() + "\n\n");
                        } else if (teacher instanceof Tutor) {
                            Tutor tutor = (Tutor) teacher;
                            // Append tutor information to the text area
                            textArea.append("Tutor Information:\n" +
                                    "Lecturer ID: " + tutor.getTeacherId() + "\n" +
                                    "Name: " + tutor.getTeacherName() + "\n" +
                                    "Address: " + tutor.getAddress() + "\n" +
                                    "Working Type: " + tutor.getWorkingType() + "\n" +
                                    "Employment Status: " + tutor.getEmploymentStatus() + "\n" +
                                    "Working Hours: " + tutor.getWorkingHours() + "\n" +
                                    "Salary: " + tutor.getSalary() + "\n" +
                                    "Academic Qualification: " + tutor.getAcademicQualifications() + "\n" +
                                    "Performance Index: " + tutor.getPerformanceIndex() + "\n\n");
                        }
                    }
                }

// Add the text area to a JScrollPane
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

// Add the scroll pane to the frame
                frame.add(scrollPane);

// Center the frame on the screen
                frame.setLocationRelativeTo(null);

// Make the frame visible
                frame.setVisible(true);
            }

        });

        centerPanel.add(rightCenterPanel, BorderLayout.CENTER);

        // Set up main frame
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 600);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        // Add components to main frame
        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(centerPanel, BorderLayout.CENTER);

        // Make frame visible
        mainFrame.setVisible(true);
    }

    private void tutorGui() {
        teachers = new ArrayList<>();
        JFrame tutorFrame = new JFrame("Add Tutor");
        JPanel tutorPanel = new JPanel();
        tutorPanel.setLayout(new GridLayout(15, 2));
        tutorPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JButton home = new JButton("Back");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tutorFrame.setVisible(false);
            }
        });

        JTextField[] textFields = {idField, nameField, addressField, workingTypeField, employmentStatusField, workingHoursField, salaryField, specializationField, academicQualificationField, performanceIndexField};
        JLabel[] labels = {idLabel, nameLabel, addressLabel, workingTypeLabel, employmentStatusLabel, workingHoursLabel, salaryLabel, specializationLabel, academicQualificationLabel, performanceIndexLabel};

        for (int i = 0; i < textFields.length; i++) {
            tutorPanel.add(labels[i]);
            tutorPanel.add(textFields[i]);
            textFields[i].setMargin(new Insets(2, 2, 2, 2));

        }
        JButton addButton = new JButton("Add");
        JButton clear = new JButton("Clear");
        JButton display = new JButton("Display");
        JButton navHome = new JButton("Back");

        JButton[] commonButtons = {addButton, clear, display, navHome};
        for (JButton btn : commonButtons) {
            tutorPanel.add(btn);
        }
        navHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tutorFrame.setVisible(false);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tutorId = Integer.parseInt(idField.getText());
                    int workingHours = Integer.parseInt(workingHoursField.getText());
                    double salary = Double.parseDouble(salaryField.getText());
                    int performanceIndex = Integer.parseInt(performanceIndexField.getText());
                    String specialization = specializationField.getText();
                    String academicsQualification = academicQualificationField.getText();
                    String tutorName = nameField.getText();
                    String address = addressField.getText();
                    String workingType = workingTypeField.getText();
                    String employmentStatus = employmentStatusField.getText();
                    boolean isCertified = false;

                    addButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Tutor newTutor = new Tutor(tutorId, tutorName, address, workingType, employmentStatus, workingHours, salary, specialization, academicsQualification, performanceIndex, isCertified);
                            teachers.add(newTutor);
                            JOptionPane.showMessageDialog(mainFrame, "Tutor Added");

                        }
                    });

                } catch (NumberFormatException E) {
                    JOptionPane.showMessageDialog(mainFrame, "Input the values according to correct data type:");
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText ("");
                nameField.setText ("");
                addressField.setText ("");
                workingTypeField.setText ("");
                employmentStatusField.setText ("");
                workingHoursField.setText ("");
                salaryField.setText ("");
                specializationField.setText ("");
                academicQualificationField.setText ("");
                performanceIndexField.setText ("");
            }
        });
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Displaying");
            }
        });

//
        tutorFrame.add(tutorPanel);
        tutorFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        tutorFrame.setSize(450, 550);
        tutorFrame.setLocationRelativeTo(null);
        tutorFrame.setResizable(false);
        tutorFrame.setVisible(true);


    }

    private void tutorObject() {
        try {
            int tutorId = Integer.parseInt(idField.getText());
            int workingHours = Integer.parseInt(workingHoursField.getText());
            double salary = Double.parseDouble(salaryField.getText());
            int performanceIndex = Integer.parseInt(performanceIndexField.getText());
            String specialization = specializationField.getText();
            String academicsQualification = academicQualificationField.getText();
            String tutorName = nameField.getText();
            String address = addressField.getText();
            String workingType = workingTypeField.getText();
            String employmentStatus = employmentStatusField.getText();
            boolean isCertified = false;

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Tutor newTutor = new Tutor(tutorId, tutorName, address, workingType, employmentStatus, workingHours, salary, specialization, academicsQualification, performanceIndex, isCertified);
                    teachers.add(newTutor);
                    JOptionPane.showMessageDialog(mainFrame, "Tutor Added");

                }
            });

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Input the values according to correct data type:");
        }

    }

    //    Lecturer newLecturer;
    private void lecturerGui() {
        JFrame lecturerFrame = new JFrame("Add Lecturer");
        JPanel lecturerPanel = new JPanel();
        lecturerPanel.setLayout(new GridLayout(15, 2));
        lecturerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        navHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lecturerFrame.setVisible(false);
            }
        });
        JTextField[] textFields = {idField, nameField, addressField, workingTypeField, employmentStatusField, gradedScoreTextField, yearsOfExperienceTextField, departmentTextField};
        JLabel[] labels = {idLabel, nameLabel, addressLabel, workingTypeLabel, employmentStatusLabel, gradedScoreLabel, yearsOfExperienceLabel, departmentLabel};

        for (int i = 0; i < textFields.length; i++) {
            lecturerPanel.add(labels[i]);
            lecturerPanel.add(textFields[i]);
            textFields[i].setMargin(new Insets(2, 2, 2, 2));

        }
        JButton addButton = new JButton("Add Lecturer");
        JButton clear = new JButton("Clear");
        JButton display = new JButton("Display");
        JButton navHome = new JButton("Back");

        JButton[] commonButtons = {addButton, clear, display, navHome};
        for (JButton btn : commonButtons) {
            lecturerPanel.add(btn);
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Extract input from text fields
                String lecturerId = idField.getText().trim();
                String lecturerName = nameField.getText().trim();
                String lecturerAddress = addressField.getText().trim();
                String lecturerWorkingType = workingTypeField.getText().trim();
                String lecturerEmploymentStatus = employmentStatusField.getText().trim();
                String lecturerDepartment = departmentTextField.getText().trim();
                String lecturerGradedScore = gradedScoreTextField.getText().trim();
                String lecturerYearsOfExperience = yearsOfExperienceTextField.getText().trim();

                // If any field is empty, show an alert message
                if (lecturerId.isEmpty() || lecturerName.isEmpty() || lecturerAddress.isEmpty() ||
                        lecturerWorkingType.isEmpty() || lecturerEmploymentStatus.isEmpty() ||
                        lecturerDepartment.isEmpty() || lecturerGradedScore.isEmpty() ||
                        lecturerYearsOfExperience.isEmpty()) {

                    JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
                    return; // Exit method if fields are not filled
                }

                // Validate and convert values to required types
                try {
                    int id = Integer.parseInt(lecturerId);
                    double gradedScore = Double.parseDouble(lecturerGradedScore);
                    int yearsOfExperience = Integer.parseInt(lecturerYearsOfExperience);

                    // Check if a lecturer with the same ID already exists
                    boolean lecturerExists = teachers.stream()
                            .anyMatch(lecturer -> lecturer.getTeacherId() == id);

                    if (!lecturerExists) {
                        // Create a new lecturer object and add it to the list of lecturers
                        Lecturer newLecturer = new Lecturer(id, lecturerName, lecturerAddress,
                                lecturerWorkingType, lecturerEmploymentStatus,
                                yearsOfExperience, lecturerDepartment);
                        teachers.add(newLecturer);
                        JOptionPane.showMessageDialog(null, "Lecturer added successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "!!! Lecturer with this ID already exists !!!");
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "!!! Please enter valid input only: Integer value for ID and years of experience, Decimal value for graded score !!!");
                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText("");
                nameField.setText("");
                addressField.setText("");
                workingTypeField.setText("");
                employmentStatusField.setText("");
                gradedScoreTextField.setText("");
                yearsOfExperienceTextField.setText("");
                departmentTextField.setText("");
            }
        });

        navHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lecturerFrame.setVisible(false);
            }
        });


        lecturerFrame.add(lecturerPanel);
        lecturerFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        lecturerFrame.setSize(400, 500);
        lecturerFrame.setLocationRelativeTo(null);
        lecturerFrame.setResizable(false);
        lecturerFrame.setVisible(true);

    }


    int lecturerId;
    String lecturerName;
    String address;
    String workingType;
    String employmentStatus;
    int yearsOfExperience;
    String department;
    int gradedScore;
//    Lecturer and newLecturer;



    private void gradeAssignmentGui() {
        JFrame gradeAssignmentFrame = new JFrame("Grade Assignment");
        JPanel gradeAssignmentPanel = new JPanel();
        gradeAssignmentPanel.setLayout(new GridLayout(10, 1));
        gradeAssignmentPanel.setSize(300, 300);
        gradeAssignmentPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel idGradeAssignment = new JLabel("Teacher ID");
        JLabel gradedGradeAssignment = new JLabel("Graded Score");
        JLabel departmentGradeAssignment = new JLabel("Department");
        JLabel yearsOfExperienceGradeAssignment = new JLabel("Years Of Experience");


        JTextField idGradeAssignmentTextField = new JTextField();
        JTextField gradedGradeAssignmentTextField = new JTextField();
        JTextField departmentGradeAssignmentTextField = new JTextField();
        JTextField yearsOfExperienceGradeAssignmentTextField = new JTextField();


        gradeAssignmentPanel.add(idGradeAssignment);
        gradeAssignmentPanel.add(idGradeAssignmentTextField);

        gradeAssignmentPanel.add(gradedGradeAssignment);
        gradeAssignmentPanel.add(gradedGradeAssignmentTextField);

        gradeAssignmentPanel.add(departmentGradeAssignment);
        gradeAssignmentPanel.add(departmentGradeAssignmentTextField);

        gradeAssignmentPanel.add(yearsOfExperienceGradeAssignment);
        gradeAssignmentPanel.add(yearsOfExperienceGradeAssignmentTextField);

        JButton gradee = new JButton("GradeAssignment1");
        JButton clearr = new JButton("Clear");
        JButton displayy = new JButton("Display");
        JButton navHomee = new JButton("Back");
        gradeAssignmentPanel.add(gradee);
        gradeAssignmentPanel.add(clearr);
        gradeAssignmentPanel.add(displayy);
        gradeAssignmentPanel.add(navHomee);

        gradee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String teacherId =idGradeAssignmentTextField.getText().trim();
                String gradedScore = gradedScoreTextField.getText().trim();
                String department = departmentGradeAssignmentTextField.getText().trim();
                String yearsOfExperience = yearsOfExperienceGradeAssignmentTextField.getText().trim();

                int gradedScoreId = Integer.parseInt(teacherId);
                int gScore = Integer.parseInt(gradedScore);
                int experience = Integer.parseInt(yearsOfExperience);

                try {
                    if (teacherId.isEmpty() || gradedScore.isEmpty() || department.isEmpty() || yearsOfExperience.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "!!! Please fill all the fields !!!");
                    } else {
                        for (Teacher teacher : teachers) {

                            if (teacher  instanceof Lecturer && teacher.getTeacherId() == gradedScoreId) {
                                Lecturer gradedteacher=(Lecturer) teacher;

                                gradedteacher.gradeAssignment(gScore, department, experience);

                                JOptionPane.showMessageDialog(null, "Successfully graded Assignment of \n\tTeacher: "+ gradedScoreId);
                                return;
                            }else {
                                JOptionPane.showMessageDialog(null, "Filed to graded Assignment of \n\tTeacher: "+ gradedScoreId);
                            }
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "!!! Please enter valid input only: Integer value for ID and years of experience, Decimal value for graded score !!!");
                }
            }
        });



        //functionality for clear button which converts the text field to null
        clearr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                idGradeAssignmentTextField.setText("");
                gradedGradeAssignmentTextField.setText("");
                departmentGradeAssignmentTextField.setText("");
                yearsOfExperienceGradeAssignmentTextField.setText("");

                // Show a message or perform any other action after clearing the fields if required
                JOptionPane.showMessageDialog(null, "Text fields cleared");
            }
        });
        //proving functionality to thw grade assignment button
        displayy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (teachers.isEmpty()) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Teacher ID: " + idGradeAssignmentTextField.getText() + "\n" +
                                    "Graded Score: " + gradedGradeAssignmentTextField.getText() + "\n" +
                                    "Department: " + departmentGradeAssignmentTextField.getText() + "\n" +
                                    "Years of Experience: " + yearsOfExperienceGradeAssignmentTextField.getText()
                    );
                }
            }
        });
        navHomee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gradeAssignmentFrame.setVisible(false);
            }
        });

        gradeAssignmentFrame.add(gradeAssignmentPanel);
        gradeAssignmentFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        gradeAssignmentFrame.setSize(400, 500);
        gradeAssignmentFrame.setLocationRelativeTo(null);
        gradeAssignmentFrame.setResizable(false);
        gradeAssignmentFrame.setVisible(true);

    }


    public void removeTutorGui() {
        JFrame removeFrame = new JFrame("Remove Tutor");
        JPanel removePanel = new JPanel();
        removePanel.setLayout(new GridLayout(7, 1)); // Increased rows to accommodate all components
        removePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel idLabel = new JLabel("Enter Tutor ID:");
        JTextField idField = new JTextField(10);

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            try {
                int tutorId = Integer.parseInt(idField.getText());
                boolean removed = false;

                Iterator<Teacher> iterator = teachers.iterator();
                while (iterator.hasNext()) {
                    Teacher tutor = iterator.next();
                    if (tutor != null && tutorId == tutor.getTeacherId() && tutor instanceof Tutor) {
                        ((Tutor) tutor).removeTutor();
                        iterator.remove(); // Remove the tutor from the collection
                        removed = true;
                        break; // Exit loop after removing the first matching tutor
                    }
                }

                if (removed) {
                    JOptionPane.showMessageDialog(removeFrame, "Tutor removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(removeFrame, "Tutor not found or invalid ID.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(removeFrame, "Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> idField.setText(""));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> removeFrame.setVisible(false));


        removePanel.add(idLabel);
        removePanel.add(idField);
        removePanel.add(removeButton);
        removePanel.add(clearButton);
        removePanel.add(backButton);

        removeFrame.add(removePanel);
        removeFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        removeFrame.setSize(400, 300); // Adjusted size for better display
        removeFrame.setLocationRelativeTo(null);
        removeFrame.setResizable(false);
        removeFrame.setVisible(true);
    }



    private void setSalaryGui() {
        JFrame setSalaryFrame = new JFrame("Set Salary");
        JPanel setSalaryPanel = new JPanel();
        setSalaryPanel.setLayout(new GridLayout(10, 2));

        setSalaryPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        setSalaryPanel.add(idLabel);
        setSalaryPanel.add(idField);

        JLabel newSalaryLabel = new JLabel("New Salary");
        JTextField newSalaryTextField = new JTextField();

        setSalaryPanel.add(newSalaryLabel);
        setSalaryPanel.add(newSalaryTextField);

        JLabel newPerformanceIndexLabel = new JLabel("New Performance Index");
        JTextField newPerformanceTextField = new JTextField();

        setSalaryPanel.add(newPerformanceIndexLabel);
        setSalaryPanel.add(newPerformanceTextField);
        JButton addButtons = new JButton("Add");
        JButton clearw = new JButton("Clear");
        JButton displayw = new JButton("Display");
        JButton navHomew = new JButton("Back");
        setSalaryPanel.add(addButtons);
        setSalaryPanel.add(clearw);
        setSalaryPanel.add(displayw);
        setSalaryPanel.add(navHomew);

        navHomew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setSalaryFrame.setVisible(false);
            }
        });
        addButtons.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                String tutorId = idField.getText().trim();
                String newSalary = newSalaryTextField.getText().trim();
                String newPerformanceIndex = newPerformanceTextField.getText().trim();
                // If any field is empty, show an alert message
                try {

                    if (tutorId.isEmpty() || newSalary.isEmpty() || newPerformanceIndex.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "!!! Please Provide all fields Details !!!");
                    } else {
                        // Convert values to required types
                        int id = Integer.parseInt(tutorId);
                        double salary = Double.parseDouble(newSalary);
                        int performanceIndex = Integer.parseInt(newPerformanceIndex);

                        // Check if a tutor with the given ID exists
                        boolean tutorExists = false;
                        for (Teacher teacher : teachers) {
                            if (teacher instanceof Tutor && teacher.getTeacherId()==id ) {
                                Tutor newTeacher=(Tutor)teacher;
                                newTeacher.setSalary(salary,performanceIndex);
                                if (teacher.getWorkingHours()>20) {
                                    JOptionPane.showMessageDialog(null, "Salary and Performance Index has been change" + id);
                                }else{
                                    JOptionPane.showMessageDialog(null," Your Working Hour is less than 20. So, there is no changes");
                                }
                                tutorExists = true;
                                break;
                            }
                        }

                        if (!tutorExists) {
                            JOptionPane.showMessageDialog(null, "!!! In tutor this ID is not applied !!!");
                        }
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "!!! Provide the right data pelase, Int value for Id and Decimal value for salary and performance index !!!");
                }

            }

        });
        clearw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                idField.setText ("");
                newSalaryLabel.setText ("");
                newPerformanceTextField.setText ("");
            }
        });



        setSalaryFrame.add(setSalaryPanel);
        setSalaryFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSalaryFrame.setSize(400, 500);
        setSalaryFrame.setLocationRelativeTo(null);
        setSalaryFrame.setResizable(false);
        setSalaryFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherGuiSecond();


    }
}