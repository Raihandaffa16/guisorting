package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sorting {
    private JTextField jumlahField;
    private JTextField inputField;
    private JTable OutputTable;
    private JButton urutkanButton;
    private JPanel MainPanel;
    private DefaultTableModel tableModel;
    private boolean added = false;

    public sorting(){
        initComponents();
        urutkanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                int jumlah = Integer.parseInt(jumlahField.getText());
                String[] stmp = input.split(",");
                if (jumlahField.getText().length()>3){
                    JOptionPane.showMessageDialog(MainPanel,
                            "Data Terlalu Banyak\nMax Input : 999",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (stmp.length > jumlah || stmp.length < jumlah){
                    JOptionPane.showMessageDialog(MainPanel,
                            "Jumlah Angka Tidak Sesuai Limit yang DiInput",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!added) {
                    for (int i = 0; i < jumlah; i++) {
                        tableModel.addRow(new Object[]{});
                    }
                    added = true;
                }
                int a = 0;
                for (int i : masukansorting.getas(input, jumlah)){
                    tableModel.setValueAt(i, a, 0);
                    a++;
                }
                int b = 0;
                for (int i : masukansorting.getdes(input, jumlah)){
                    tableModel.setValueAt(i, b, 1);
                    b++;
                }
            }

        });
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
    private void initComponents(){
        Object[] tableColumn = {
                "Ascending",
                "Descending"
        };
        Object[][] initData = {
        };
        tableModel = new DefaultTableModel(initData, tableColumn);
        OutputTable.setModel(tableModel);
        //menampilkan sorting di setiap colom
        OutputTable.setAutoCreateRowSorter(false);
        // enable single selection
        OutputTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    }


