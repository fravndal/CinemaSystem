package no.kino.gui.staffContent;

import com.mysql.jdbc.Statement;
import no.kino.control.Control;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import no.kino.domain.Ticket;

public class DeleteUnpaidOrder {


    public void writer(ArrayList<Ticket> slettinger) throws IOException {
        PrintWriter pw = null;
        FileOutputStream fo = null;
        File file = null;
        try {
            file = new File("slettinger.dat");
            pw = new PrintWriter(new FileOutputStream(file));
            fo = new FileOutputStream(file);
            int delList = slettinger.size();
            for (int i = 0; i < delList; i++) {
                pw.write(slettinger.get(i).toString() + "\n");
            }
        } finally {
            pw.flush();
            pw.close();
            fo.close();
        }

    }
}
