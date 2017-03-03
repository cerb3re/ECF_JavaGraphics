package UI;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modele.Boat;
import modele.User;

/**
 *
 * @author cerbere
 */
public class UserTableModel extends AbstractTableModel 
{

    private final String[]  entetes = { "Nom", "Prenom", "Telephone", "Email", "Age" };
    private List<User>      users;
 
    public UserTableModel(List<User> users)
    {
        this.users = users;
    }

    public UserTableModel() {
    }
    
    @Override
    public String getColumnName(int Column)
    {
        return entetes[Column];
    }
    
    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }
    
    public User getFormation(int rowIndex)
    {
        return users.get(rowIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
                return users.get(rowIndex).getUser_name();
            case 1:
                return users.get(rowIndex).getUser_surname();
            case 2:
                return users.get(rowIndex).getUser_phone();
            case 3:
                return users.get(rowIndex).getUser_email();
            case 4:
                return users.get(rowIndex).getAge();
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public void setModel(List<User> users)
    {
        this.users = users;
        fireTableDataChanged();
    }
} 