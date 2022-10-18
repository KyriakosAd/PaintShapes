import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.awt.Font.*;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.CompoundBorder;

class GUI extends javax.swing.JFrame {
    //List shapes to save every shape on canvas
    private final transient List<FullShape> shapes = new ArrayList<>();
    //List deletedShapes to save every shape that has been deleted
    private final transient List<FullShape> deletedShapes = new ArrayList<>();
    //boolean saved to keep track of whether the canvas has been saved to config file
    private boolean saved = false;
    private static final String CONFIG_FILE = "config.txt";
    private static final String ERROR_CANVAS = "Out of canvas.";

    GUI() {
        initComponents();
    }
    void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        JToolBar jToolBar1 = new JToolBar();
        buttonCreateLine = new javax.swing.JRadioButton();
        buttonCreateRectangle = new javax.swing.JRadioButton();
        buttonCreateSquare = new javax.swing.JRadioButton();
        buttonCreateCircle = new javax.swing.JRadioButton();
        buttonCreateEllipse = new javax.swing.JRadioButton();
        buttonCreateTriangle = new javax.swing.JRadioButton();
        buttonCreateStar = new javax.swing.JRadioButton();
        JToolBar jToolBar2 = new JToolBar();
        buttonCopy = new javax.swing.JRadioButton();
        buttonMove = new javax.swing.JRadioButton();
        buttonDelete = new javax.swing.JRadioButton();
        buttonReverseDelete = new javax.swing.JButton();
        buttonChangeSize = new javax.swing.JRadioButton();
        buttonFillColour = new javax.swing.JRadioButton();
        buttonOutlineColour = new javax.swing.JRadioButton();
        buttonCombine = new javax.swing.JRadioButton();
        JMenuBar jMenuBar2 = new JMenuBar();
        JMenu menuFile = new JMenu();
        JMenuItem menuItemSave = new JMenuItem();
        JMenuItem menuItemEdit = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened();
            }
        });

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.setPreferredSize(new java.awt.Dimension(726, 412));

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setBorderPainted(false);

        buttonGroup1.add(buttonCreateLine);
        String font = "Segoe UI";
        CompoundBorder border = javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        buttonCreateLine.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonCreateLine.setText("Line");
        buttonCreateLine.setBorder(border);
        buttonCreateLine.setBorderPainted(true);
        buttonCreateLine.setFocusPainted(false);
        buttonCreateLine.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonCreateLine.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonCreateLine.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonCreateLine.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCreateLine.addActionListener(this::buttonCreateLineActionPerformed);
        jToolBar1.add(buttonCreateLine);

        buttonGroup1.add(buttonCreateRectangle);
        buttonCreateRectangle.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonCreateRectangle.setText("Rectangle");
        buttonCreateRectangle.setBorder(border);
        buttonCreateRectangle.setBorderPainted(true);
        buttonCreateRectangle.setFocusPainted(false);
        buttonCreateRectangle.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonCreateRectangle.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonCreateRectangle.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonCreateRectangle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCreateRectangle.addActionListener(this::buttonCreateRectangleActionPerformed);
        jToolBar1.add(buttonCreateRectangle);

        buttonGroup1.add(buttonCreateSquare);
        buttonCreateSquare.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonCreateSquare.setText("Square");
        buttonCreateSquare.setBorder(border);
        buttonCreateSquare.setBorderPainted(true);
        buttonCreateSquare.setFocusPainted(false);
        buttonCreateSquare.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonCreateSquare.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonCreateSquare.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonCreateSquare.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCreateSquare.addActionListener(this::buttonCreateSquareActionPerformed);
        jToolBar1.add(buttonCreateSquare);

        buttonGroup1.add(buttonCreateCircle);
        buttonCreateCircle.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonCreateCircle.setText("Circle");
        buttonCreateCircle.setBorder(border);
        buttonCreateCircle.setBorderPainted(true);
        buttonCreateCircle.setFocusPainted(false);
        buttonCreateCircle.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonCreateCircle.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonCreateCircle.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonCreateCircle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCreateCircle.addActionListener(this::buttonCreateCircleActionPerformed);
        jToolBar1.add(buttonCreateCircle);

        buttonGroup1.add(buttonCreateEllipse);
        buttonCreateEllipse.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonCreateEllipse.setText("Ellipse");
        buttonCreateEllipse.setBorder(border);
        buttonCreateEllipse.setBorderPainted(true);
        buttonCreateEllipse.setFocusPainted(false);
        buttonCreateEllipse.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonCreateEllipse.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonCreateEllipse.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonCreateEllipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCreateEllipse.addActionListener(this::buttonCreateEllipseActionPerformed);
        jToolBar1.add(buttonCreateEllipse);

        buttonGroup1.add(buttonCreateTriangle);
        buttonCreateTriangle.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonCreateTriangle.setText("Triangle");
        buttonCreateTriangle.setBorder(border);
        buttonCreateTriangle.setBorderPainted(true);
        buttonCreateTriangle.setFocusPainted(false);
        buttonCreateTriangle.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonCreateTriangle.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonCreateTriangle.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonCreateTriangle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCreateTriangle.addActionListener(this::buttonCreateTriangleActionPerformed);
        jToolBar1.add(buttonCreateTriangle);

        buttonGroup1.add(buttonCreateStar);
        buttonCreateStar.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonCreateStar.setText("Star");
        buttonCreateStar.setBorder(border);
        buttonCreateStar.setBorderPainted(true);
        buttonCreateStar.setFocusPainted(false);
        buttonCreateStar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonCreateStar.setMaximumSize(new java.awt.Dimension(118, 32));
        buttonCreateStar.setMinimumSize(new java.awt.Dimension(118, 32));
        buttonCreateStar.setPreferredSize(new java.awt.Dimension(118, 32));
        buttonCreateStar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCreateStar.addActionListener(this::buttonCreateStarActionPerformed);
        jToolBar1.add(buttonCreateStar);

        jToolBar2.setFloatable(false);
        jToolBar2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar2.setBorderPainted(false);

        buttonGroup2.add(buttonCopy);
        buttonCopy.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonCopy.setText("Copy");
        buttonCopy.setBorder(border);
        buttonCopy.setBorderPainted(true);
        buttonCopy.setFocusPainted(false);
        buttonCopy.setFocusable(false);
        buttonCopy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonCopy.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonCopy.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonCopy.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonCopy.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonCopy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCopy.addActionListener(this::buttonCopyActionPerformed);
        jToolBar2.add(buttonCopy);

        buttonGroup2.add(buttonMove);
        buttonMove.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonMove.setText("Move");
        buttonMove.setBorder(border);
        buttonMove.setBorderPainted(true);
        buttonMove.setFocusPainted(false);
        buttonMove.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonMove.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonMove.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonMove.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonMove.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonMove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonMove.addActionListener(this::buttonMoveActionPerformed);
        jToolBar2.add(buttonMove);

        buttonGroup2.add(buttonDelete);
        buttonDelete.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonDelete.setText("Delete");
        buttonDelete.setBorder(border);
        buttonDelete.setBorderPainted(true);
        buttonDelete.setFocusPainted(false);
        buttonDelete.setFocusable(false);
        buttonDelete.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonDelete.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonDelete.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonDelete.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonDelete.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonDelete.addActionListener(this::buttonDeleteActionPerformed);
        jToolBar2.add(buttonDelete);

        buttonGroup2.add(buttonReverseDelete);
        buttonReverseDelete.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonReverseDelete.setText("Reverse Delete");
        buttonReverseDelete.setBorder(border);
        buttonReverseDelete.setFocusPainted(false);
        buttonReverseDelete.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonReverseDelete.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonReverseDelete.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonReverseDelete.addActionListener(this::buttonReverseDeleteActionPerformed);
        jToolBar2.add(buttonReverseDelete);

        buttonGroup2.add(buttonChangeSize);
        buttonChangeSize.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonChangeSize.setText("Change size");
        buttonChangeSize.setBorder(border);
        buttonChangeSize.setBorderPainted(true);
        buttonChangeSize.setFocusPainted(false);
        buttonChangeSize.setFocusable(false);
        buttonChangeSize.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonChangeSize.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonChangeSize.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonChangeSize.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonChangeSize.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonChangeSize.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonChangeSize.addActionListener(this::buttonChangeSizeActionPerformed);
        jToolBar2.add(buttonChangeSize);

        buttonGroup2.add(buttonFillColour);
        buttonFillColour.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonFillColour.setText("Set fill colour");
        buttonFillColour.setBorder(border);
        buttonFillColour.setBorderPainted(true);
        buttonFillColour.setFocusPainted(false);
        buttonFillColour.setFocusable(false);
        buttonFillColour.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonFillColour.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonFillColour.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonFillColour.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonFillColour.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonFillColour.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonFillColour.addActionListener(this::buttonFillColourActionPerformed);
        jToolBar2.add(buttonFillColour);

        buttonGroup2.add(buttonOutlineColour);
        buttonOutlineColour.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonOutlineColour.setText("Set outline colour");
        buttonOutlineColour.setBorder(border);
        buttonOutlineColour.setBorderPainted(true);
        buttonOutlineColour.setFocusPainted(false);
        buttonOutlineColour.setFocusable(false);
        buttonOutlineColour.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonOutlineColour.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonOutlineColour.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonOutlineColour.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonOutlineColour.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonOutlineColour.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonOutlineColour.addActionListener(this::buttonOutlineColourActionPerformed);
        jToolBar2.add(buttonOutlineColour);

        buttonGroup2.add(buttonCombine);
        buttonCombine.setFont(new java.awt.Font(font, PLAIN, 14));
        buttonCombine.setText("Combine");
        buttonCombine.setBorder(border);
        buttonCombine.setBorderPainted(true);
        buttonCombine.setFocusPainted(false);
        buttonCombine.setFocusable(false);
        buttonCombine.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonCombine.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        buttonCombine.setMaximumSize(new java.awt.Dimension(146, 32));
        buttonCombine.setMinimumSize(new java.awt.Dimension(146, 32));
        buttonCombine.setPreferredSize(new java.awt.Dimension(146, 32));
        buttonCombine.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCombine.addActionListener(this::buttonCombineActionPerformed);
        jToolBar2.add(buttonCombine);

        menuFile.setText("File");

        menuItemSave.setText("Save");
        menuItemSave.addActionListener(this::menuItemSaveActionPerformed);
        menuFile.add(menuItemSave);

        menuItemEdit.setText("Edit");
        menuItemEdit.addActionListener(this::menuItemEditActionPerformed);
        menuFile.add(menuItemEdit);

        jMenuBar2.add(menuFile);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    //Method for creation of star on button action
    private void buttonCreateStarActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonCreateStar.isSelected()){
                    //Using constructor to add a new shape to List shapes
                    shapes.add(new FullShape(evt.getX(), evt.getY(), 0, 0, 7));
                    shapes.get(shapes.size()-1).shapeWidth = 30;
                    shapes.get(shapes.size()-1).shapeHeight = shapes.get(shapes.size()-1).shapeWidth;
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    //Using checkShape method to make sure that the shape is inside the canvas
                    if(checkShape(shapes.size()-1)){
                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                        try {
                            throw new MyException(ERROR_CANVAS);
                        } catch (MyException ex) {
                            ex.printStackTrace();
                        }
                        shapes.remove(shapes.size()-1);
                    }
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    buttonGroup1.clearSelection();
                }
                buttonCreateStar.setSelected(false);
                canvas.removeMouseListener(this);
            }
        });
    }

    //Method for creation of triangle on button action
    private void buttonCreateTriangleActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonCreateTriangle.isSelected()){
                    //Using constructor to add a new shape to List shapes
                    shapes.add(new FullShape(evt.getX(), evt.getY(), 0, 0, 6));
                    shapes.get(shapes.size()-1).shapeHeight = 100;
                    shapes.get(shapes.size()-1).shapeWidth = 100;
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    //Using checkShape method to make sure that the shape is inside the canvas
                    if(checkShape(shapes.size()-1)){
                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                        try {
                            throw new MyException(ERROR_CANVAS);
                        } catch (MyException ex) {
                            ex.printStackTrace();
                        }
                        shapes.remove(shapes.size()-1);
                    }
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    buttonGroup1.clearSelection();
                }
                buttonCreateTriangle.setSelected(false);
                canvas.removeMouseListener(this);
            }
        });
    }

    //Method for creation of ellipse on button action
    private void buttonCreateEllipseActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonCreateEllipse.isSelected()){
                    //Using constructor to add a new shape to List shapes
                    shapes.add(new FullShape(evt.getX(), evt.getY(), 0, 0, 5));
                    shapes.get(shapes.size()-1).shapeHeight = 100;
                    shapes.get(shapes.size()-1).shapeWidth = 150;
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    //Using checkShape method to make sure that the shape is inside the canvas
                    if(checkShape(shapes.size()-1)){
                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                        try {
                            throw new MyException(ERROR_CANVAS);
                        } catch (MyException ex) {
                            ex.printStackTrace();
                        }
                        shapes.remove(shapes.size()-1);
                    }
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    buttonGroup1.clearSelection();
                }
                buttonCreateEllipse.setSelected(false);
                canvas.removeMouseListener(this);
            }
        });
    }

    //Method for creation of circle on button action
    private void buttonCreateCircleActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonCreateCircle.isSelected()){
                    //Using constructor to add a new shape to List shapes
                    shapes.add(new FullShape(evt.getX(), evt.getY(), 0, 0, 4));
                    shapes.get(shapes.size()-1).shapeHeight = 100;
                    shapes.get(shapes.size()-1).shapeWidth = 100;
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    //Using checkShape method to make sure that the shape is inside the canvas
                    if(checkShape(shapes.size()-1)){
                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                        try {
                            throw new MyException(ERROR_CANVAS);
                        } catch (MyException ex) {
                            ex.printStackTrace();
                        }
                        shapes.remove(shapes.size()-1);
                    }
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    buttonGroup1.clearSelection();
                }
                buttonCreateCircle.setSelected(false);
                canvas.removeMouseListener(this);
            }
        });
    }

    //Method for creation of square on button action
    private void buttonCreateSquareActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonCreateSquare.isSelected()){
                    //Using constructor to add a new shape to List shapes
                    shapes.add(new FullShape(evt.getX(), evt.getY(), 0, 0, 3));
                    shapes.get(shapes.size()-1).shapeHeight = 100;
                    shapes.get(shapes.size()-1).shapeWidth = 100;
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    //Using checkShape method to make sure that the shape is inside the canvas
                    if(checkShape(shapes.size()-1)){
                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                        try {
                            throw new MyException(ERROR_CANVAS);
                        } catch (MyException ex) {
                            ex.printStackTrace();
                        }
                        shapes.remove(shapes.size()-1);
                    }
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    buttonGroup1.clearSelection();
                }
                buttonCreateSquare.setSelected(false);
                canvas.removeMouseListener(this);
            }
        });
    }

    //Method for creation of rectangle on button action
    private void buttonCreateRectangleActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonCreateRectangle.isSelected()){
                    //Using constructor to add a new shape to List shapes
                    shapes.add(new FullShape(evt.getX(), evt.getY(), 0, 0, 2));
                    shapes.get(shapes.size()-1).shapeHeight = 100;
                    shapes.get(shapes.size()-1).shapeWidth = 150;
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    //Using checkShape method to make sure that the shape is inside the canvas
                    if(checkShape(shapes.size()-1)){
                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                        try {
                            throw new MyException(ERROR_CANVAS);
                        } catch (MyException ex) {
                            ex.printStackTrace();
                        }
                        shapes.remove(shapes.size()-1);
                    }
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                    buttonGroup1.clearSelection();
                }
                buttonCreateRectangle.setSelected(false);
                canvas.removeMouseListener(this);
            }
        });
    }
    
    //Method for creation of line on button action
    private void buttonCreateLineActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            int initX = 0;
            int initY = 0;
            boolean secondClick = false;

            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonCreateLine.isSelected()){
                    if(secondClick){
                        //Using constructor to add a new shape to List shapes
                        shapes.add(new FullShape(initX, initY, evt.getX(), evt.getY(), 1));
                        //Using paintAllShapes method to print canvas
                        paintAllShapes();
                        //Using checkShape method to make sure that the shape is inside the canvas
                        if(checkShape(shapes.size()-1)){
                            JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                            try {
                                throw new MyException(ERROR_CANVAS);
                            } catch (MyException ex) {
                                ex.printStackTrace();
                            }
                            shapes.remove(shapes.size()-1);
                        }
                        //Using paintAllShapes method to print canvas
                        paintAllShapes();
                        buttonGroup1.clearSelection();
                        initX = 0;
                        initY = 0;
                        secondClick = false;
                        buttonCreateLine.setSelected(false);
                        canvas.removeMouseListener(this);
                    }
                    else{
                        secondClick = true;
                        initX = evt.getX();
                        initY = evt.getY();
                    }
                }
                else{
                    initX = 0;
                    initY = 0;
                    secondClick = false;
                    buttonCreateLine.setSelected(false);
                    canvas.removeMouseListener(this);
                }
            }
        });
    }
    
    //Method for creating a copy of selected shape on specified location on button action
    private void buttonCopyActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            int location = -1;
            boolean secondClick = false;

            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonCopy.isSelected()){
                    if(secondClick){
                        if(location != -1){
                            if(shapes.get(location).option == 1){
                                //Using constructor to add a new shape to List shapes
                                shapes.add(new FullShape(evt.getX()-((shapes.get(location).finalX-shapes.get(location).initX)/2), evt.getY()-((shapes.get(location).finalY-shapes.get(location).initY)/2), evt.getX()+((shapes.get(location).finalX-shapes.get(location).initX)/2), evt.getY()+((shapes.get(location).finalY-shapes.get(location).initY)/2), 1));
                            }
                            else if(shapes.get(location).option == 8){
                                //Using constructor to add a new shape to List shapes
                                shapes.add(new FullShape(0, 0, 0, 0, 8));
                                shapes.get(shapes.size()-1).combinedShape = (Area)shapes.get(location).combinedShape.clone();
                                AffineTransform t = new AffineTransform();
                                t.translate((float)evt.getX()-shapes.get(location).initX, (float)evt.getY()-shapes.get(location).initY);
                                shapes.get(shapes.size()-1).combinedShape.transform(t);
                                shapes.get(shapes.size()-1).initX = evt.getX();
                                shapes.get(shapes.size()-1).initY = evt.getY();
                            }
                            else{
                                //Using constructor to add a new shape to List shapes
                                shapes.add(new FullShape(evt.getX(), evt.getY(), 0, 0, shapes.get(location).option));
                                shapes.get(shapes.size()-1).shapeWidth = shapes.get(location).shapeWidth;
                                shapes.get(shapes.size()-1).shapeHeight = shapes.get(location).shapeHeight;
                            }
                            shapes.get(shapes.size()-1).outline = shapes.get(location).outline;
                            shapes.get(shapes.size()-1).fill = shapes.get(location).fill;
                            //Using paintAllShapes method to print canvas
                            paintAllShapes();
                            //Using checkShape method to make sure that the shape is inside the canvas
                            if(checkShape(shapes.size()-1)){
                                JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                                try {
                                    throw new MyException(ERROR_CANVAS);
                                } catch (MyException ex) {
                                    ex.printStackTrace();
                                }
                                shapes.remove(shapes.size()-1);
                            }
                            //Using paintAllShapes method to print canvas
                            paintAllShapes();
                            location = -1;
                        }
                        secondClick = false;
                        buttonGroup2.clearSelection();
                        buttonCopy.setSelected(false);
                        canvas.removeMouseListener(this);
                    }
                    else{
                        secondClick = true;
                        for(int i = shapes.size()-1; i >= 0; i--){
                            if(shapes.get(i).option == 1){
                                if(shapes.get(i).actualShape.intersects((float)evt.getX()-10, (float)evt.getY()-10, 20, 20)){
                                    location = i;
                                    break;
                                }
                            }
                            else if(shapes.get(i).option == 8){
                                if(shapes.get(i).combinedShape.contains(evt.getX(), evt.getY())){
                                    location = i;
                                    break;
                                }
                            }
                            else if(shapes.get(i).actualShape.contains(evt.getX(), evt.getY())){
                                location = i;
                                break;
                            }
                        }
                    }
                }
                else{
                    location = -1;
                    secondClick = false;
                    buttonGroup2.clearSelection();
                    buttonCopy.setSelected(false);
                    canvas.removeMouseListener(this);
                }
            }
        });
    }

    //Method for moving selected shape to specified location on button action
    private void buttonMoveActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            int location = -1;
            boolean secondClick = false;

            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonMove.isSelected()){
                    if(secondClick){
                        if(location != -1){
                            if(shapes.get(location).option == 1){
                                int initX = shapes.get(location).initX;
                                int initY = shapes.get(location).initY;
                                int finalX = shapes.get(location).finalX;
                                int finalY = shapes.get(location).finalY;
                                shapes.get(location).initX = evt.getX()-((finalX-initX)/2);
                                shapes.get(location).initY = evt.getY()-((finalY-initY)/2);
                                shapes.get(location).finalX = evt.getX()+((finalX-initX)/2);
                                shapes.get(location).finalY = evt.getY()+((finalY-initY)/2);
                                //Using paintAllShapes method to print canvas
                                paintAllShapes();
                                //Using checkShape method to make sure that the shape is inside the canvas
                                if(checkShape(location)){
                                    JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                                    try {
                                        throw new MyException(ERROR_CANVAS);
                                    } catch (MyException ex) {
                                        ex.printStackTrace();
                                    }
                                    shapes.get(location).initX = initX;
                                    shapes.get(location).initY = initY;
                                    shapes.get(location).finalX = finalX;
                                    shapes.get(location).finalY = finalY;
                                }
                            }
                            else if(shapes.get(location).option == 8){
                                int initX = shapes.get(location).initX;
                                int initY = shapes.get(location).initY;
                                AffineTransform t = new AffineTransform();
                                t.translate((float)evt.getX()-initX, (float)evt.getY()-initY);
                                shapes.get(location).combinedShape.transform(t);
                                shapes.get(location).initX = evt.getX();
                                shapes.get(location).initY = evt.getY();
                                //Using paintAllShapes method to print canvas
                                paintAllShapes();
                                //Using checkShape method to make sure that the shape is inside the canvas
                                if(checkShape(location)){
                                    JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                                    try {
                                        throw new MyException(ERROR_CANVAS);
                                    } catch (MyException ex) {
                                        ex.printStackTrace();
                                    }
                                    AffineTransform t2 = new AffineTransform();
                                    t2.translate((float)initX-shapes.get(location).initX, (float)initY-shapes.get(location).initY);
                                    shapes.get(location).combinedShape.transform(t2);
                                    shapes.get(location).initX = initX;
                                    shapes.get(location).initY = initY;
                                }
                            }
                            else{
                                int initX = shapes.get(location).initX;
                                int initY = shapes.get(location).initY;
                                shapes.get(location).initX = evt.getX();
                                shapes.get(location).initY = evt.getY();
                                //Using paintAllShapes method to print canvas
                                paintAllShapes();
                                //Using checkShape method to make sure that the shape is inside the canvas
                                if(checkShape(location)){
                                    JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                                    try {
                                        throw new MyException(ERROR_CANVAS);
                                    } catch (MyException ex) {
                                        ex.printStackTrace();
                                    }
                                    shapes.get(location).initX = initX;
                                    shapes.get(location).initY = initY;
                                }
                            }
                            //Using paintAllShapes method to print canvas
                            paintAllShapes();
                            location = -1;
                        }
                        secondClick = false;
                        buttonGroup2.clearSelection();
                        buttonMove.setSelected(false);
                        canvas.removeMouseListener(this);
                    }
                    else{
                        secondClick = true;
                        for(int i = shapes.size()-1; i >= 0; i--){
                            if(shapes.get(i).option == 1){
                                if(shapes.get(i).actualShape.intersects((float)evt.getX()-10, (float)evt.getY()-10, 20, 20)){
                                    location = i;
                                    break;
                                }
                            }
                            else if(shapes.get(i).option == 8){
                                if(shapes.get(i).combinedShape.contains(evt.getX(), evt.getY())){
                                    location = i;
                                    break;
                                }
                            }
                            else if(shapes.get(i).actualShape.contains(evt.getX(), evt.getY())){
                                location = i;
                                break;
                            }
                        }
                    }
                }
                else{
                    location = -1;
                    secondClick = false;
                    buttonGroup2.clearSelection();
                    buttonMove.setSelected(false);
                    canvas.removeMouseListener(this);
                }
            }
        });
    }
    
    //Method for deleting selected shape on button action
    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonDelete.isSelected()){
                    int location = -1;
                    for(int i = shapes.size()-1; i >= 0; i--){
                        if(shapes.get(i).option == 1){
                            if(shapes.get(i).actualShape.intersects((float)evt.getX()-10, (float)evt.getY()-10, 20, 20)){
                                location = i;
                                break;
                            }
                        }
                        else if(shapes.get(i).option == 8){
                            if(shapes.get(i).combinedShape.contains(evt.getX(), evt.getY())){
                                location = i;
                                break;
                            }
                        }
                        else if(shapes.get(i).actualShape.contains(evt.getX(), evt.getY())){
                            location = i;
                            break;
                        }
                    }
                    if(location != -1){
                        deletedShapes.add(shapes.get(location));
                        shapes.remove(location);
                        //Using paintAllShapes method to print canvas
                        paintAllShapes();
                    }
                }
                buttonGroup2.clearSelection();
                buttonDelete.setSelected(false);
                canvas.removeMouseListener(this);
            }
        });
    }
    
    //Method for changing the size of selected shape on button action
    private void buttonChangeSizeActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            int location = -1;
            boolean secondClick = false;

            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonChangeSize.isSelected()){
                    if(secondClick){
                        if(location != -1){
                            if(shapes.get(location).option == 1){
                                shapes.get(location).finalX = evt.getX();
                                shapes.get(location).finalY = evt.getY();
                            }
                            //Using paintAllShapes method to print canvas
                            paintAllShapes();
                            location = -1;
                        }
                        secondClick = false;
                        buttonGroup2.clearSelection();
                        buttonChangeSize.setSelected(false);
                        canvas.removeMouseListener(this);
                    }
                    else{
                        secondClick = true;
                        for(int i = shapes.size()-1; i >= 0; i--){
                            if(shapes.get(i).option == 1){
                                if(shapes.get(i).actualShape.intersects((float)evt.getX()-10, (float)evt.getY()-10, 20, 20)){
                                    location = i;
                                    break;
                                }
                            }
                            else if(shapes.get(i).option == 8){
                                if(shapes.get(i).combinedShape.contains(evt.getX(), evt.getY())){
                                    location = i;
                                    break;
                                }
                            }
                            else if(shapes.get(i).actualShape.contains(evt.getX(), evt.getY())){
                                location = i;
                                break;
                            }
                        }
                        if(location != -1){
                            if(shapes.get(location).option == 2 || shapes.get(location).option == 5){
                                String tempInput = JOptionPane.showInputDialog(null, "Current height: " + shapes.get(location).shapeHeight + "\n(width = height + height/2)" + "\nSet height:", null);
                                if(tempInput != null && tempInput.matches(".*\\d.*")){
                                    int tempHeight = shapes.get(location).shapeHeight;
                                    int tempWidth = shapes.get(location).shapeWidth;
                                    shapes.get(location).shapeHeight = Integer.parseInt(tempInput.replaceAll("\\D", ""));
                                    if(shapes.get(location).shapeHeight < 10){
                                        shapes.get(location).shapeHeight = 10;
                                    }
                                    shapes.get(location).shapeWidth = shapes.get(location).shapeHeight + shapes.get(location).shapeHeight /2;
                                    //Using paintAllShapes method to print canvas
                                    paintAllShapes();
                                    //Using checkShape method to make sure that the shape is inside the canvas
                                    if(checkShape(location)){
                                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                                        try {
                                            throw new MyException(ERROR_CANVAS);
                                        } catch (MyException ex) {
                                            ex.printStackTrace();
                                        }
                                        shapes.get(location).shapeHeight = tempHeight;
                                        shapes.get(location).shapeWidth = tempWidth;
                                    }
                                }
                                //Using paintAllShapes method to print canvas
                                paintAllShapes();
                                location = -1;
                                secondClick = false;
                                buttonGroup2.clearSelection();
                                buttonChangeSize.setSelected(false);
                                canvas.removeMouseListener(this);
                            }
                            else if(shapes.get(location).option == 3 || shapes.get(location).option == 4 || shapes.get(location).option == 6){
                                String tempInput = JOptionPane.showInputDialog(null, "Current height: " + shapes.get(location).shapeHeight + "\n(width = height)" + "\nSet height:", null);
                                if(tempInput != null && tempInput.matches(".*\\d.*")){
                                    int tempHeight = shapes.get(location).shapeHeight;
                                    int tempWidth = shapes.get(location).shapeWidth;
                                    shapes.get(location).shapeHeight = Integer.parseInt(tempInput.replaceAll("\\D", ""));
                                    if(shapes.get(location).shapeHeight < 10){
                                        shapes.get(location).shapeHeight = 10;
                                    }
                                    shapes.get(location).shapeWidth = shapes.get(location).shapeHeight;
                                    //Using paintAllShapes method to print canvas
                                    paintAllShapes();
                                    //Using checkShape method to make sure that the shape is inside the canvas
                                    if(checkShape(location)){
                                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                                        try {
                                            throw new MyException(ERROR_CANVAS);
                                        } catch (MyException ex) {
                                            ex.printStackTrace();
                                        }
                                        shapes.get(location).shapeHeight = tempHeight;
                                        shapes.get(location).shapeWidth = tempWidth;
                                    }
                                }
                                //Using paintAllShapes method to print canvas
                                paintAllShapes();
                                location = -1;
                                secondClick = false;
                                buttonGroup2.clearSelection();
                                buttonChangeSize.setSelected(false);
                                canvas.removeMouseListener(this);
                            }
                            else if(shapes.get(location).option == 7){
                                String tempInput = JOptionPane.showInputDialog(null, "Current radius r: " + shapes.get(location).shapeWidth + "\n(R = r*2)" + "\nSet radius r:", null);
                                if(tempInput != null && tempInput.matches(".*\\d.*")){
                                    int tempHeight = shapes.get(location).shapeHeight;
                                    int tempWidth = shapes.get(location).shapeWidth;
                                    shapes.get(location).shapeHeight = Integer.parseInt(tempInput.replaceAll("\\D", ""));
                                    if(shapes.get(location).shapeHeight < 5){
                                        shapes.get(location).shapeHeight = 5;
                                    }
                                    shapes.get(location).shapeWidth = shapes.get(location).shapeHeight;
                                    //Using paintAllShapes method to print canvas
                                    paintAllShapes();
                                    //Using checkShape method to make sure that the shape is inside the canvas
                                    if(checkShape(location)){
                                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                                        try {
                                            throw new MyException(ERROR_CANVAS);
                                        } catch (MyException ex) {
                                            ex.printStackTrace();
                                        }
                                        shapes.get(location).shapeHeight = tempHeight;
                                        shapes.get(location).shapeWidth = tempWidth;
                                    }
                                }
                                //Using paintAllShapes method to print canvas
                                paintAllShapes();
                                location = -1;
                                secondClick = false;
                                buttonGroup2.clearSelection();
                                buttonChangeSize.setSelected(false);
                                canvas.removeMouseListener(this);
                            }
                            else if(shapes.get(location).option == 8){
                                String tempInput = JOptionPane.showInputDialog(
                                        null,
                                        """
                                                Default scale: 100
                                                (Scale < 100 = Smaller)
                                                (Scale > 100 = Larger)
                                                Set new scale:""",
                                        null
                                );
                                if(tempInput != null && tempInput.matches(".*\\d.*")){
                                    double scale = Integer.parseInt(tempInput.replaceAll("\\D", ""));
                                    scale = scale/100;
                                    AffineTransform t = new AffineTransform();
                                    double centerX = shapes.get(location).combinedShape.getBounds2D().getCenterX();
                                    double centerY = shapes.get(location).combinedShape.getBounds2D().getCenterY();
                                    t.translate(centerX, centerY);
                                    t.scale(scale, scale);
                                    t.translate(-centerX, -centerY);
                                    shapes.get(location).combinedShape.transform(t);
                                    //Using paintAllShapes method to print canvas
                                    paintAllShapes();
                                    //Using checkShape method to make sure that the shape is inside the canvas
                                    if(checkShape(location)){
                                        JOptionPane.showMessageDialog(null, ERROR_CANVAS);
                                        try {
                                            throw new MyException(ERROR_CANVAS);
                                        } catch (MyException ex) {
                                            ex.printStackTrace();
                                        }
                                        try {
                                            t.invert();
                                        } catch (NoninvertibleTransformException ex) {
                                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        shapes.get(location).combinedShape.transform(t);
                                    }
                                }
                                //Using paintAllShapes method to print canvas
                                paintAllShapes();
                                location = -1;
                                secondClick = false;
                                buttonGroup2.clearSelection();
                                buttonChangeSize.setSelected(false);
                                canvas.removeMouseListener(this);
                            }
                        }
                        else{
                            secondClick = false;
                            buttonGroup2.clearSelection();
                            buttonChangeSize.setSelected(false);
                            canvas.removeMouseListener(this);
                        }
                    }
                }
                else{
                    location = -1;
                    secondClick = false;
                    buttonGroup2.clearSelection();
                    buttonChangeSize.setSelected(false);
                    canvas.removeMouseListener(this);
                }
            }
        });
    }
    
    //Method for changing fill colour of selected shape on button action
    private void buttonFillColourActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            int location = -1;

            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonFillColour.isSelected()){
                    for(int i = shapes.size()-1; i >= 0; i--){
                        if(shapes.get(i).option == 1){
                            if(shapes.get(i).actualShape.intersects((float)evt.getX()-10, (float)evt.getY()-10, 20, 20)){
                                location = i;
                                break;
                            }
                        }
                        else if(shapes.get(i).option == 8){
                            if(shapes.get(i).combinedShape.contains(evt.getX(), evt.getY())){
                                location = i;
                                break;
                            }
                        }
                        else if(shapes.get(i).actualShape.contains(evt.getX(), evt.getY())){
                            location = i;
                            break;
                        }
                    }
                    if(location != -1){
                        if(shapes.get(location).option != 1){
                            shapes.get(location).fill = JColorChooser.showDialog(null, "Change fill colour", null);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Unable to change the fill colour of this shape.");
                        }
                    }
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                }
                buttonGroup2.clearSelection();
                buttonFillColour.setSelected(false);
                canvas.removeMouseListener(this);
            }
        });
    }
    
    //Method for changing outline colour of selected shape on button action
    private void buttonOutlineColourActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            int location = -1;

            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonOutlineColour.isSelected()){
                    for(int i = shapes.size()-1; i >= 0; i--){
                        if(shapes.get(i).option == 1){
                            if(shapes.get(i).actualShape.intersects((float)evt.getX()-10, (float)evt.getY()-10, 20, 20)){
                                location = i;
                                break;
                            }
                        }
                        else if(shapes.get(i).option == 8){
                            if(shapes.get(i).combinedShape.contains(evt.getX(), evt.getY())){
                                location = i;
                                break;
                            }
                        }
                        else if(shapes.get(i).actualShape.contains(evt.getX(), evt.getY())){
                            location = i;
                            break;
                        }
                    }
                    if(location != -1){
                        if((shapes.get(location).option >= 1) && (shapes.get(location).option <= 8)){
                            shapes.get(location).outline = JColorChooser.showDialog(null, "Change outline colour", null);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Unable to change the outline colour of this shape.");
                        }
                    }
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
                }
                buttonGroup2.clearSelection();
                buttonOutlineColour.setSelected(false);
                canvas.removeMouseListener(this);
            }
        });
    }
    
    //Method for combining selected shapes on button action
    private void buttonCombineActionPerformed(java.awt.event.ActionEvent evt) {
        canvas.addMouseListener(new MouseAdapter() {
            int location = -1;
            boolean secondClick = false;

            @Override
            public void mousePressed(MouseEvent evt) {
                if(buttonCombine.isSelected()){
                    if(secondClick){
                        if(location != -1){
                            boolean flag = false;
                            for(int i = shapes.size()-1; i >= 0; i--){
                                if(shapes.get(i).option != 1){
                                    if(shapes.get(i).option == 8){
                                        if(shapes.get(i).combinedShape.contains(evt.getX(), evt.getY())){
                                            flag = true;
                                            break;
                                        }
                                    }
                                    else{
                                        if(shapes.get(i).actualShape.contains(evt.getX(), evt.getY())){
                                            flag = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if(flag){
                                if(shapes.get(location).option == 8){
                                    //Using constructor to add a new shape to List shapes
                                    shapes.add(new FullShape(shapes.get(location).initX, shapes.get(location).initY, 0, 0, 8));
                                    shapes.get(shapes.size()-1).combinedShape = shapes.get(location).combinedShape;
                                    shapes.remove(shapes.get(location));
                                }
                                else{
                                    //Using constructor to add a new shape to List shapes
                                    shapes.add(new FullShape(shapes.get(location).initX, shapes.get(location).initY, 0, 0, 8));
                                    Shape tempShape = shapes.get(location).actualShape;
                                    shapes.get(shapes.size()-1).combinedShape = new Area(tempShape);
                                    shapes.remove(shapes.get(location));
                                }
                                for(int i = shapes.size()-1; i >= 0; i--){
                                    if(shapes.get(i).option != 1){
                                        if(shapes.get(i).option == 8){
                                            if(shapes.get(i).combinedShape.contains(evt.getX(), evt.getY())){
                                                shapes.get(shapes.size()-1).combinedShape.add(shapes.get(i).combinedShape);
                                                shapes.remove(shapes.get(i));
                                                break;
                                            }
                                        }
                                        else{
                                            if(shapes.get(i).actualShape.contains(evt.getX(), evt.getY())){
                                                Shape tempShape2 = shapes.get(i).actualShape;
                                                shapes.get(shapes.size()-1).combinedShape.add(new Area(tempShape2));
                                                shapes.remove(shapes.get(i));
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                            location = -1;
                        }
                        //Using paintAllShapes method to print canvas
                        paintAllShapes();
                        secondClick = false;
                        buttonGroup2.clearSelection();
                        buttonCombine.setSelected(false);
                        canvas.removeMouseListener(this);
                    }
                    else{
                        secondClick = true;
                        for(int i = shapes.size()-1; i >= 0; i--){
                            if(shapes.get(i).option != 8 && shapes.get(i).option != 1){
                                if(shapes.get(i).actualShape.contains(evt.getX(), evt.getY())){
                                    location = i;
                                    break;
                                }
                            }
                            else if(shapes.get(i).option == 8 && shapes.get(i).combinedShape.contains(evt.getX(), evt.getY())){
                                location = i;
                                break;
                            }
                        }
                    }
                }
                else{
                    location = -1;
                    secondClick = false;
                    buttonGroup2.clearSelection();
                    buttonCombine.setSelected(false);
                    canvas.removeMouseListener(this);
                }
            }
        });
    }

    //Method for reversing the last deletion on button action
    private void buttonReverseDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if(!deletedShapes.isEmpty()){
            shapes.add(deletedShapes.get(deletedShapes.size()-1));
            deletedShapes.remove(deletedShapes.size()-1);
            //Using paintAllShapes method to print canvas
            paintAllShapes();
        }
        buttonGroup2.clearSelection();
        buttonReverseDelete.setSelected(false);
    }

    //Method for saving all shapes of canvas to config file on button action
    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {
        try (FileWriter shapesWriter = new FileWriter(CONFIG_FILE)){
            for(int i = 0; i < shapes.size(); i++){
                if(shapes.get(i).option == 1){
                    shapesWriter.write(i + ")\n" +
                            "Line" + "\n" +
                            "Initial X: " + shapes.get(i).initX + "\n" +
                            "Initial Y: " + shapes.get(i).initY + "\n" +
                            "Final X: " + shapes.get(i).finalX + "\n" +
                            "Final Y: " + shapes.get(i).finalY + "\n" +
                            "Outline colour: " + "[r=" + shapes.get(i).outline.getRed() + ",g=" + shapes.get(i).outline.getGreen() + ",b=" + shapes.get(i).outline.getBlue() + ",a=" + shapes.get(i).outline.getAlpha() + "]" + "\n"
                    );
                }
                else if(shapes.get(i).option == 2){
                    shapesWriter.write(i + ")\n" +
                            "Rectangle" + "\n" +
                            "X: " + shapes.get(i).initX + "\n" +
                            "Y: " + shapes.get(i).initY + "\n" +
                            "Height: " + shapes.get(i).shapeHeight + "\n" +
                            "(Width = Height + Height/2)" + "\n" +
                            "Outline colour: " + "[r=" + shapes.get(i).outline.getRed() + ",g=" + shapes.get(i).outline.getGreen() + ",b=" + shapes.get(i).outline.getBlue() + ",a=" + shapes.get(i).outline.getAlpha() + "]" + "\n" +
                            "Fill colour: " + "[r=" + shapes.get(i).fill.getRed() + ",g=" + shapes.get(i).fill.getGreen() + ",b=" + shapes.get(i).fill.getBlue() + ",a=" + shapes.get(i).fill.getAlpha() + "]" + "\n"
                    );
                }
                else if(shapes.get(i).option == 3){
                    shapesWriter.write(i + ")\n" +
                            "Square" + "\n" +
                            "X: " + shapes.get(i).initX + "\n" +
                            "Y: " + shapes.get(i).initY + "\n" +
                            "Height: " + shapes.get(i).shapeHeight + "\n" +
                            "(Width = Height)" + "\n" +
                            "Outline colour: " + "[r=" + shapes.get(i).outline.getRed() + ",g=" + shapes.get(i).outline.getGreen() + ",b=" + shapes.get(i).outline.getBlue() + ",a=" + shapes.get(i).outline.getAlpha() + "]" + "\n" +
                            "Fill colour: " + "[r=" + shapes.get(i).fill.getRed() + ",g=" + shapes.get(i).fill.getGreen() + ",b=" + shapes.get(i).fill.getBlue() + ",a=" + shapes.get(i).fill.getAlpha() + "]" + "\n"
                    );
                }
                else if(shapes.get(i).option == 4){
                    shapesWriter.write(i + ")\n" +
                            "Circle" + "\n" +
                            "X: " + shapes.get(i).initX + "\n" +
                            "Y: " + shapes.get(i).initY + "\n" +
                            "Height: " + shapes.get(i).shapeHeight + "\n" +
                            "(Width = Height)" + "\n" +
                            "Outline colour: " + "[r=" + shapes.get(i).outline.getRed() + ",g=" + shapes.get(i).outline.getGreen() + ",b=" + shapes.get(i).outline.getBlue() + ",a=" + shapes.get(i).outline.getAlpha() + "]" + "\n" +
                            "Fill colour: " + "[r=" + shapes.get(i).fill.getRed() + ",g=" + shapes.get(i).fill.getGreen() + ",b=" + shapes.get(i).fill.getBlue() + ",a=" + shapes.get(i).fill.getAlpha() + "]" + "\n"
                    );
                }
                else if(shapes.get(i).option == 5){
                    shapesWriter.write(i + ")\n" +
                            "Ellipse" + "\n" +
                            "X: " + shapes.get(i).initX + "\n" +
                            "Y: " + shapes.get(i).initY + "\n" +
                            "Height: " + shapes.get(i).shapeHeight + "\n" +
                            "(Width = Height + Height/2)" + "\n" +
                            "Outline colour: " + "[r=" + shapes.get(i).outline.getRed() + ",g=" + shapes.get(i).outline.getGreen() + ",b=" + shapes.get(i).outline.getBlue() + ",a=" + shapes.get(i).outline.getAlpha() + "]" + "\n" +
                            "Fill colour: " + "[r=" + shapes.get(i).fill.getRed() + ",g=" + shapes.get(i).fill.getGreen() + ",b=" + shapes.get(i).fill.getBlue() + ",a=" + shapes.get(i).fill.getAlpha() + "]" + "\n"
                    );
                }
                else if(shapes.get(i).option == 6){
                    shapesWriter.write(i + ")\n" +
                            "Triangle" + "\n" +
                            "X: " + shapes.get(i).initX + "\n" +
                            "Y: " + shapes.get(i).initY + "\n" +
                            "Height: " + shapes.get(i).shapeHeight + "\n" +
                            "(Width = Height)" + "\n" +
                            "Outline colour: " + "[r=" + shapes.get(i).outline.getRed() + ",g=" + shapes.get(i).outline.getGreen() + ",b=" + shapes.get(i).outline.getBlue() + ",a=" + shapes.get(i).outline.getAlpha() + "]" + "\n" +
                            "Fill colour: " + "[r=" + shapes.get(i).fill.getRed() + ",g=" + shapes.get(i).fill.getGreen() + ",b=" + shapes.get(i).fill.getBlue() + ",a=" + shapes.get(i).fill.getAlpha() + "]" + "\n"
                    );
                }
                else if(shapes.get(i).option == 7){
                    shapesWriter.write(i + ")\n" +
                            "Star" + "\n" +
                            "X: " + shapes.get(i).initX + "\n" +
                            "Y: " + shapes.get(i).initY + "\n" +
                            "r: " + shapes.get(i).shapeWidth + "\n" +
                            "(R = r * 2)" + "\n" +
                            "Outline colour: " + "[r=" + shapes.get(i).outline.getRed() + ",g=" + shapes.get(i).outline.getGreen() + ",b=" + shapes.get(i).outline.getBlue() + ",a=" + shapes.get(i).outline.getAlpha() + "]" + "\n" +
                            "Fill colour: " + "[r=" + shapes.get(i).fill.getRed() + ",g=" + shapes.get(i).fill.getGreen() + ",b=" + shapes.get(i).fill.getBlue() + ",a=" + shapes.get(i).fill.getAlpha() + "]" + "\n"
                    );
                }
                else if(shapes.get(i).option == 8){
                    shapesWriter.write(i + ")\n" +
                            "Combined Shape" + "\n" +
                            "X: " + shapes.get(i).initX + "\n" +
                            "Y: " + shapes.get(i).initY + "\n" +
                            "Outline colour: " + "[r=" + shapes.get(i).outline.getRed() + ",g=" + shapes.get(i).outline.getGreen() + ",b=" + shapes.get(i).outline.getBlue() + ",a=" + shapes.get(i).outline.getAlpha() + "]" + "\n" +
                            "Fill colour: " + "[r=" + shapes.get(i).fill.getRed() + ",g=" + shapes.get(i).fill.getGreen() + ",b=" + shapes.get(i).fill.getBlue() + ",a=" + shapes.get(i).fill.getAlpha() + "]" + "\n"
                    );
                }
                shapesWriter.write("\n");
            }
            saved = true;
        }
        catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }

    //Method for editing all shapes of config file through notepad on button action
    private void menuItemEditActionPerformed(java.awt.event.ActionEvent evt)  {
        File tempFile = new File(CONFIG_FILE);
        boolean exists = tempFile.exists();
        if(exists && saved){
            Runtime runTime = Runtime.getRuntime();
            try {
                Process process = runTime.exec("notepad.exe " + CONFIG_FILE);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            try (BufferedReader in = new BufferedReader(new FileReader(CONFIG_FILE))) {
                    String str;
                    int location = 0;
                    int line = 0;
                    while((str = in.readLine()) != null){
                        if(str.trim().length() > 0){
                            if(Character.isDigit(str.charAt(0))){
                                location = Character.getNumericValue(str.charAt(0));
                                line = 1;
                            }
                            if(line != 0){
                                if(shapes.get(location).option == 1){
                                    if(line == 1 || line == 2){
                                        line++;
                                    }
                                    else if(line == 3){
                                        shapes.get(location).initX = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 4){
                                        shapes.get(location).initY = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 5){
                                        shapes.get(location).finalX = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 6){
                                        shapes.get(location).finalY = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 7){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).outline = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line = 0;
                                    }
                                }
                                if(shapes.get(location).option == 2){
                                    if(line == 1 || line == 2){
                                        line++;
                                    }
                                    else if(line == 3){
                                        shapes.get(location).initX = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 4){
                                        shapes.get(location).initY = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 5){
                                        shapes.get(location).shapeHeight = Integer.parseInt(str.replaceAll("\\D", ""));
                                        shapes.get(location).shapeWidth = shapes.get(location).shapeHeight + shapes.get(location).shapeHeight /2;
                                        line++;
                                    }
                                    else if(line == 6){
                                        line++;
                                    }
                                    else if(line == 7){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).outline = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line++;
                                    }
                                    else if(line == 8){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).fill = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line = 0;
                                    }
                                }
                                if(shapes.get(location).option == 3){
                                    if(line == 1 || line == 2){
                                        line++;
                                    }
                                    else if(line == 3){
                                        shapes.get(location).initX = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 4){
                                        shapes.get(location).initY = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 5){
                                        shapes.get(location).shapeHeight = Integer.parseInt(str.replaceAll("\\D", ""));
                                        shapes.get(location).shapeWidth = shapes.get(location).shapeHeight;
                                        line++;
                                    }
                                    else if(line == 6){
                                        line++;
                                    }
                                    else if(line == 7){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).outline = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line++;
                                    }
                                    else if(line == 8){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).fill = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line = 0;
                                    }
                                }
                                if(shapes.get(location).option == 4){
                                    if(line == 1 || line == 2){
                                        line++;
                                    }
                                    else if(line == 3){
                                        shapes.get(location).initX = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 4){
                                        shapes.get(location).initY = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 5){
                                        shapes.get(location).shapeHeight = Integer.parseInt(str.replaceAll("\\D", ""));
                                        shapes.get(location).shapeWidth = shapes.get(location).shapeHeight;
                                        line++;
                                    }
                                    else if(line == 6){
                                        line++;
                                    }
                                    else if(line == 7){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).outline = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line++;
                                    }
                                    else if(line == 8){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).fill = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line = 0;
                                    }
                                }
                                if(shapes.get(location).option == 5){
                                    if(line == 1 || line == 2){
                                        line++;
                                    }
                                    else if(line == 3){
                                        shapes.get(location).initX = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 4){
                                        shapes.get(location).initY = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 5){
                                        shapes.get(location).shapeHeight = Integer.parseInt(str.replaceAll("\\D", ""));
                                        shapes.get(location).shapeWidth = shapes.get(location).shapeHeight + shapes.get(location).shapeHeight /2;
                                        line++;
                                    }
                                    else if(line == 6){
                                        line++;
                                    }
                                    else if(line == 7){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).outline = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line++;
                                    }
                                    else if(line == 8){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).fill = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line = 0;
                                    }
                                }
                                if(shapes.get(location).option == 6){
                                    if(line == 1 || line == 2){
                                        line++;
                                    }
                                    else if(line == 3){
                                        shapes.get(location).initX = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 4){
                                        shapes.get(location).initY = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 5){
                                        shapes.get(location).shapeHeight = Integer.parseInt(str.replaceAll("\\D", ""));
                                        shapes.get(location).shapeWidth = shapes.get(location).shapeHeight;
                                        line++;
                                    }
                                    else if(line == 6){
                                        line++;
                                    }
                                    else if(line == 7){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).outline = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line++;
                                    }
                                    else if(line == 8){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).fill = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line = 0;
                                    }
                                }
                                if(shapes.get(location).option == 7){
                                    if(line == 1 || line == 2){
                                        line++;
                                    }
                                    else if(line == 3){
                                        shapes.get(location).initX = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 4){
                                        shapes.get(location).initY = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 5){
                                        shapes.get(location).shapeWidth = Integer.parseInt(str.replaceAll("\\D", ""));
                                        line++;
                                    }
                                    else if(line == 6){
                                        line++;
                                    }
                                    else if(line == 7){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).outline = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line++;
                                    }
                                    else if(line == 8){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).fill = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line = 0;
                                    }
                                }
                                if(shapes.get(location).option == 8){
                                    if(line == 1 || line == 2){
                                        line++;
                                    }
                                    else if(line == 3){
                                        AffineTransform t = new AffineTransform();
                                        int initX = Integer.parseInt(str.replaceAll("\\D", ""));
                                        t.translate((float)initX-shapes.get(location).initX, 0);
                                        shapes.get(location).combinedShape.transform(t);
                                        shapes.get(location).initX = initX;
                                        line++;
                                    }
                                    else if(line == 4){
                                        AffineTransform t = new AffineTransform();
                                        int initY = Integer.parseInt(str.replaceAll("\\D", ""));
                                        t.translate(0, (float)initY-shapes.get(location).initY);
                                        shapes.get(location).combinedShape.transform(t);
                                        shapes.get(location).initY = initY;
                                        line++;
                                    }
                                    else if(line == 5){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).outline = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line++;
                                    }
                                    else if(line == 6){
                                        Scanner sc = new Scanner(str);
                                        sc.useDelimiter("\\D+");
                                        shapes.get(location).fill = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                                        line = 0;
                                    }
                                }
                            }
                        }
                    }
                    //Using paintAllShapes method to print canvas
                    paintAllShapes();
            }
            catch (IOException e) {
                System.out.println("Error!");
            }
        }
        else{
            if(!exists){
                JOptionPane.showMessageDialog(null, "No file has been created.\nTry saving first.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Try saving first.");
            }
        }
    }
    
    //Method to delete config file if it exists at the start of the program
    private void formWindowOpened() {
        File tempFile = new File(CONFIG_FILE);
        boolean exists = tempFile.exists();
        if(exists){
            tempFile.delete();
        }
    }
    
    //Method checkShape to check whether the specified shape is inside the canvas
    private boolean checkShape(int location){
        boolean checkLine = (shapes.get(location).option == 1 && (shapes.get(location).initX > canvas.getWidth() || shapes.get(location).initX < 0 || shapes.get(location).initY > canvas.getHeight() || shapes.get(location).initY < 0 || shapes.get(location).finalX > canvas.getWidth() || shapes.get(location).finalX < 0 || shapes.get(location).finalY > canvas.getHeight() || shapes.get(location).finalY < 0));
        boolean checkGeneric = (shapes.get(location).option >= 2 && shapes.get(location).option <= 7 && (shapes.get(location).actualShape.getBounds2D().getX() > canvas.getWidth() || shapes.get(location).actualShape.getBounds2D().getX() < 0 || shapes.get(location).actualShape.getBounds2D().getY() > canvas.getHeight() || shapes.get(location).actualShape.getBounds2D().getY() < 0 || shapes.get(location).actualShape.getBounds2D().getX()+shapes.get(location).actualShape.getBounds2D().getWidth() > canvas.getWidth() || shapes.get(location).actualShape.getBounds2D().getX()+shapes.get(location).actualShape.getBounds2D().getWidth() < 0 || shapes.get(location).actualShape.getBounds2D().getY()+shapes.get(location).actualShape.getBounds2D().getHeight() > canvas.getHeight() || shapes.get(location).actualShape.getBounds2D().getY()+shapes.get(location).actualShape.getBounds2D().getHeight() < 0));
        boolean checkCombined = (shapes.get(location).option == 8 && (shapes.get(location).combinedShape.getBounds2D().getX() > canvas.getWidth() || shapes.get(location).combinedShape.getBounds2D().getX() < 0 || shapes.get(location).combinedShape.getBounds2D().getY() > canvas.getHeight() || shapes.get(location).combinedShape.getBounds2D().getY() < 0 || shapes.get(location).combinedShape.getBounds2D().getX()+shapes.get(location).combinedShape.getBounds2D().getWidth() > canvas.getWidth() || shapes.get(location).combinedShape.getBounds2D().getX()+shapes.get(location).combinedShape.getBounds2D().getWidth() < 0 || shapes.get(location).combinedShape.getBounds2D().getY()+shapes.get(location).combinedShape.getBounds2D().getHeight() > canvas.getHeight() || shapes.get(location).combinedShape.getBounds2D().getY()+shapes.get(location).combinedShape.getBounds2D().getHeight() < 0));
        return checkLine || checkGeneric || checkCombined;
    }
    
    //Method paintAllShapes to clear canvas and then paint all shapes
    private void paintAllShapes(){
        saved = false;
        Graphics g = canvas.getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (FullShape shape : shapes) {
            shape.g2d.setRenderingHints(shape.rh);
            shape.g2d.setStroke(new BasicStroke(2));
            switch (shape.option) {
                case 1 -> shape.actualShape = new Line2D.Float(shape.initX, shape.initY, shape.finalX, shape.finalY);
                case 2, 3 ->
                        shape.actualShape = new Rectangle2D.Float(shape.initX - ((float) shape.shapeWidth / 2), shape.initY - ((float) shape.shapeHeight / 2), shape.shapeWidth, shape.shapeHeight);
                case 4, 5 ->
                        shape.actualShape = new Ellipse2D.Float(shape.initX - ((float) shape.shapeWidth / 2), shape.initY - ((float) shape.shapeHeight / 2), shape.shapeWidth, shape.shapeHeight);
                case 6 -> {
                    int[] xPointsTriangle = {shape.initX - (shape.shapeWidth / 2), shape.initX, shape.initX + (shape.shapeWidth / 2)};
                    int[] yPointsTriangle = {shape.initY + (shape.shapeHeight / 2), shape.initY - (shape.shapeHeight / 2), shape.initY + (shape.shapeHeight / 2)};
                    shape.actualShape = new Polygon(xPointsTriangle, yPointsTriangle, xPointsTriangle.length);
                }
                case 7 -> {
                    int r = shape.shapeWidth;
                    int radius = r * 2;
                    int[] xPointsStar = new int[10];
                    int[] yPointsStar = new int[10];
                    int j = 0;
                    for (int k = 0; k < 10; k += 2) {
                        xPointsStar[k] = shape.initX + (int) (r * cos((2 * PI * j) / 5 + (PI / 2)));
                        yPointsStar[k] = shape.initY + (int) (r * sin((2 * PI * j) / 5 + (PI / 2)));
                        xPointsStar[k + 1] = shape.initX + (int) (radius * cos((2 * PI * j) / 5 + (PI / 2) + (PI / 5)));
                        yPointsStar[k + 1] = shape.initY + (int) (radius * sin((2 * PI * j) / 5 + (PI / 2) + (PI / 5)));
                        j++;
                    }
                    shape.actualShape = new Polygon(xPointsStar, yPointsStar, xPointsStar.length);
                }
                case 8 -> {
                    shape.g2d.setPaint(shape.fill);
                    shape.g2d.fill(shape.combinedShape);
                    shape.g2d.setPaint(shape.outline);
                    shape.g2d.draw(shape.combinedShape);
                }
            }
            if (shape.option != 8) {
                shape.g2d.setPaint(shape.fill);
                shape.g2d.fill(shape.actualShape);
                shape.g2d.setPaint(shape.outline);
                shape.g2d.draw(shape.actualShape);
            }
        }
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException |
                 InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new GUI().setVisible(true));
    }

    private javax.swing.JButton buttonReverseDelete;
    private javax.swing.JRadioButton buttonChangeSize;
    private javax.swing.JRadioButton buttonCombine;
    private javax.swing.JRadioButton buttonCopy;
    private javax.swing.JRadioButton buttonCreateCircle;
    private javax.swing.JRadioButton buttonCreateEllipse;
    private javax.swing.JRadioButton buttonCreateLine;
    private javax.swing.JRadioButton buttonCreateRectangle;
    private javax.swing.JRadioButton buttonCreateSquare;
    private javax.swing.JRadioButton buttonCreateStar;
    private javax.swing.JRadioButton buttonCreateTriangle;
    private javax.swing.JRadioButton buttonDelete;
    private javax.swing.JRadioButton buttonFillColour;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton buttonMove;
    private javax.swing.JRadioButton buttonOutlineColour;
    static java.awt.Canvas canvas = new java.awt.Canvas();
}
