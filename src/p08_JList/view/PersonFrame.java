package p08_JList.view;

import p08_JList.model.Person;
import p08_JList.repository.PersonRepository;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonFrame extends JFrame {

    DefaultListModel<Person> listModel;
    JList<Person> personJList;
    JLabel companyLabel;
    JButton addBtn, delBtn;
    int nextId;

    public PersonFrame() {
        nextId = 5;
        setSize(300, 500);
        setTitle("Persons");

        listModel = new DefaultListModel<>();
        loadData();
        personJList = new JList<>(listModel);
        personJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    Person selectedPerson = personJList.getSelectedValue();
                    if(selectedPerson != null) {
                        companyLabel.setText(selectedPerson.getCompany());
                    }
                    else {
                        companyLabel.setText(" ");
                    }
                }
            }
        });

        companyLabel = new JLabel(" ");
        add(companyLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(personJList);
        personJList.setLayoutOrientation(JList.VERTICAL);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addBtn = new JButton("Add");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner in = new Scanner(System.in);
                System.out.print("Name: ");
                String name = in.nextLine();
                System.out.print("Company: ");
                String company = in.nextLine();
                PersonRepository repo = new PersonRepository();
                Person person = repo.addNew(name, company);
                if(person != null) {
                    listModel.addElement(person);
                }
                //listModel.addElement(new Person(nextId, name, company));
                //nextId++;
            }
        });
        delBtn = new JButton("Delete");
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person selectedPerson = personJList.getSelectedValue();
                if(selectedPerson != null) {
                    PersonRepository repo = new PersonRepository();
                    repo.delete(selectedPerson.getId());
                    System.out.println(selectedPerson);
                    listModel.removeElement(selectedPerson);
                }
            }
        });
        buttonPanel.add(addBtn);
        buttonPanel.add(delBtn);

        add(buttonPanel, BorderLayout.SOUTH);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void loadData() {
        /*
        listModel.addElement(new Person(1, "Bill Gates", "Microsoft"));
        listModel.addElement(new Person(2, "Elon Musk", "Tesla"));
        listModel.addElement(new Person(3, "Jeff Bezos", "Amazon"));
        listModel.addElement(new Person(4, "Steve Jobs", "Apple"));
         */
        PersonRepository repo = new PersonRepository();
        ArrayList<Person> persons = repo.all();
        for(Person person : persons) {
            listModel.addElement(person);
        }
    }

}
