/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import modele.Serie;

/**
 *
 * @author cerbere
 */
public class SerieJCombo extends javax.swing.JDialog implements FocusListener {
    private List<Serie> serie;
    private final String[]  entetes = { "serie_name" };
    private List<Serie> lstSerie;
            
    public SerieJCombo(List<Serie> lstSerie)
    {
        this.lstSerie = lstSerie;
    }
    
    public void addSerie(Serie serie)
    {
        this.serie.add(serie);
    }

    public Object getValueAt(int rowIndex, int columnIndex)
    { 
        switch(columnIndex)
        {
            case 0:
                return serie.get(rowIndex).getSerie_id();
            case 1:
                return serie.get(rowIndex).getSerie_name();

            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
