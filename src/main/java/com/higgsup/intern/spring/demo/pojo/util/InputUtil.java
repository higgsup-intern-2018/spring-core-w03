package com.higgsup.intern.spring.demo.pojo.util;

import com.higgsup.intern.spring.demo.pojo.dao.DictionaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputUtil {

    @Autowired
    private static DictionaryDAO dao;
    private static String line;
    private static String[] lines;

    public InputUtil() {
    }

    public DictionaryDAO getDao() {
        return dao;
    }

    public void setDao(DictionaryDAO dao) {
        this.dao = dao;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) {
        this.lines = lines;
    }

static {
    Scanner sc = new Scanner(System.in);

        dao.getDictionaryFromFile();
        dao.instruct();
        do
    {
        System.out.print("> ");
        line = sc.nextLine();
        lines = line.split(" ", 3);

        switch (lines[0]) {
            case "save": {
                dao.save();
                break;
            }
            case "add": {
                String lines1 = lines[1].substring(0, lines[1].length() - 1);
                dao.add(lines1, lines[2]);
                break;
            }
            case "lookup": {
                dao.lookup(lines[1]);
                break;
            }
            case "delete": {
                dao.delete(lines[1]);
                break;
            }
            case "quit": {
                break;
            }
            default:
                System.out.println("Wrong input!");
        }

    } while(lines[0].equals("quit") ==false);
        sc.close();
 }
}
