package UI;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import modele.Boat;
import modele.User;

/**
 *
 * @author cerbere
 */
public class ProprietaireForm extends javax.swing.JDialog implements FocusListener {

    private User   currentUser;
    private Boat   currentBoat;
    private ProprietaireFormEventListener  listener;
    
    
    public void stagiaireForm(java.awt.Frame parent, boolean modal, User user, ProprietaireFormEventListener listener) {
        initComponent();
    }
    
    private void initComponent() {
        
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
