package UI;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modele.Boat;

/**
 *
 * @author cerbere
 */
public class ProprietaireTableModel extends AbstractTableModel 
{
    private final String[] entetes = { "Nom du bateau", "Type de bateau", "Nom du proprietaire", "Prenom du proprietaire" };
    private List<Boat> boats;
 
    public ProprietaireTableModel(List<Boat> boats)
    {
        this.boats = boats;
    }

    public ProprietaireTableModel() {}
    
    @Override
    public String getColumnName(int Column)
    {
        return entetes[Column];
    }
    
    @Override
    public int getRowCount() 
    {
        return boats.size();
    }

    @Override
    public int getColumnCount() 
    {
        return entetes.length;
    }
    
    public Boat getFormation(int rowIndex)
    {
        return boats.get(rowIndex);
    }
    
    public void setModel(List<Boat> boats)
    {
        this.boats = boats;
        fireTableDataChanged();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        switch(columnIndex)
        {
            case 0:
                return boats.get(rowIndex).getUser_boat_name();
            case 1:
                return boats.get(rowIndex).getBoat_type_name();
            case 2:
                return boats.get(rowIndex).getUser_name();
             case 3:
                return boats.get(rowIndex).getUser_surname();
            default:
                throw new IllegalArgumentException();
        }
    }
} 
    

