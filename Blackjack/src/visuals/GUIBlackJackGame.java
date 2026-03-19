package visuals;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUIBlackJackGame extends JFrame implements ActionListener{

	JButton but1, but5, but10, butYes, butNo;
	JLabel playerInfoLabel, croupierInfoLabel, roundInfoLabel, userChipsLabel, currentBetLabel, winnerLabel;
	
	
	public GUIBlackJackGame(String title) {
		super(title);
		
		initComponents();
	}
	
	
	
	private void initComponents() {
		SubJPanel upContainer, downContainer, butContainer, chipsButContainer, yesNoButContainer, playerInfoContainer, croupierInfoContainer, labelContainer;
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// Creating the panels
		upContainer = new SubJPanel();
		downContainer = new SubJPanel();
		butContainer = new SubJPanel();
		chipsButContainer = new SubJPanel();
		yesNoButContainer = new SubJPanel();
		playerInfoContainer = new SubJPanel();
		croupierInfoContainer = new SubJPanel();
		labelContainer = new SubJPanel();		
		
		
		// SETTING THE LAYOUT
		
		
		// Container of JFrame
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setSize(600, 400);
		
		// upContainer
		this.getContentPane().add(upContainer); // Add the container

		upContainer.setLayout(new FlowLayout());
		upContainer.setPreferredSize( upContainer.getPreferredSize(1, 0.75) );
		
		
		// downContainer
		this.getContentPane().add(downContainer); // Add the container

		downContainer.setLayout(new FlowLayout());
		downContainer.setPreferredSize( downContainer.getPreferredSize(1, 0.25) );
		
		// butContainer
		
		downContainer.add(butContainer); // Add the container

		butContainer.setLayout( new FlowLayout() );
		butContainer.setPreferredSize( butContainer.getPreferredSize(0.75, 1) );
		
		// playerInfoContainer
		downContainer.add(playerInfoContainer);

		playerInfoContainer.setLayout( new FlowLayout() );
		playerInfoContainer.setPreferredSize( playerInfoContainer.getPreferredSize(0.25, 1) );
		
		//chipsButConatienr
		butContainer.add(chipsButContainer);
		
		chipsButContainer.setLayout( new FlowLayout() );
		chipsButContainer.setPreferredSize( chipsButContainer.getPreferredSize(0.75, 1) );

		// yesNoButContainer
		butContainer.add(yesNoButContainer);

		yesNoButContainer.setLayout( new FlowLayout() );
		yesNoButContainer.setPreferredSize( yesNoButContainer.getPreferredSize(0.25, 1) );
		
		// labelContainer
		upContainer.add(labelContainer);

		labelContainer.setLayout( new FlowLayout() );
		labelContainer.setPreferredSize( labelContainer.getPreferredSize(0.75, 1) );
		
		// croupierInfoContainer
		upContainer.add(croupierInfoContainer);

		croupierInfoContainer.setLayout( new FlowLayout() );
		croupierInfoContainer.setPreferredSize( croupierInfoContainer.getPreferredSize(0.25, 1) );
		
		
		// CREATING AND ADDING THE BUTTONS
		
		// TODO: CREATE AN ARRAY OF BUTTONS
		but1 = new JButton("1");
		but5 = new JButton("5");
		but10 = new JButton("10");
		
		chipsButContainer.add(but1);
		chipsButContainer.add(but5);
		chipsButContainer.add(but10);

		
	}
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public static void main (String args[]) {

        EventQueue.invokeLater(
                new Runnable() {

                	@Override
                    public void run() {
                        JFrame frame = new GUIBlackJackGame("BlackJack!");
                        frame.setVisible(true);

                    }
                }
        );

    }
	
	
}
